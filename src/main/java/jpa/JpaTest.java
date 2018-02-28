package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			ElectronicDevice e1 = new ElectronicDevice();
			e1.setConso(45);

			ElectronicDevice e2 = new ElectronicDevice();
			e2.setConso(46);
			
			Heater he1 = new Heater();
			he1.setPower(500);
			
			Heater he2 = new Heater();
			he2.setPower(600);
	
			Home ho = new Home();
			ho.setNbChambres(5);
			ho.setTaille(58);
			ho.addDevice(e1);
			ho.addDevice(e2);
			ho.addDevice(he1);
			ho.addDevice(he2);
			e1.setHome(ho);
			e2.setHome(ho);
			he1.setHome(ho);
			he2.setHome(ho);
			
			Person p = new Person();
			p.setNom("jacques");
			p.addHome(ho);
			
			ho.setPerson(p);
			
			manager.persist(p);
			
			e1.setConso(12);
			
			CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
			// assuming a is an Integer  
			// if returning multiple fields, look into using a Tuple 
//			    or specifying the return type as an Object or Object[]
			CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
			Root<Person> from = query.from(Person.class);
			query.select(from);
			TypedQuery<Person> tq = manager.createQuery(query);
			List<Person> l = tq.getResultList();
			for (Person pers : l) {
				System.err.println(pers.getNom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		String s = "SELECT e FROM Person as e where e.nom=:name";
		
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "jacques"); 
		List<Person> res = q.getResultList();
		
		System.out.println("taille : " + res.size());
		System.out.println(res.get(0).getNom());
		
		manager.close();
		factory.close();
	}

}
