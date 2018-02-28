package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.Person;

@WebServlet(name="person",urlPatterns={"/person"})
public class PersonServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			Person p = new Person();
			p.setNom(request.getParameter("name"));
			p.setPrenom(request.getParameter("firstname"));
			p.setMail(request.getParameter("mail"));
			manager.persist(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		/*String s = "SELECT e FROM Person as e where e.nom=:name";
		
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "REBOURS"); 
		List<Person> res = q.getResultList();
		
		System.out.println("taille : " + res.size());
		System.out.println(res.get(0).getNom());*/
		
		manager.close();
		factory.close();
		
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
		
			PrintWriter out = response.getWriter();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
	
		String s = "SELECT e FROM Person as e";
		
		Query q = manager.createQuery(s,Person.class);
		List<Person> res = q.getResultList();
		int i = 0;
		for (Person p : res) {
			out.println(p.getNom() + " " + p.getPrenom() + "<br/>");
		}
	

		manager.close();
		factory.close();
	}
}
