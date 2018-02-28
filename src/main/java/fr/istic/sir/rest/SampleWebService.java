package fr.istic.sir.rest;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jpa.*;

@Path("/api")
public class SampleWebService {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    //////////
    // HOME //
    //////////
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Home> getHomes() {    	
    	String s = "SELECT h FROM Home as h";
		Query q = manager.createQuery(s, Home.class);
		return q.getResultList();
    }
    
    @GET
    @Path("/home/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHomeById(@PathParam("id") int id) {    	
    	try {
    		return manager.find(Home.class, id);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    @POST
    @Path("/home")
    @Produces(MediaType.TEXT_HTML)
    public String addHome(@QueryParam("taille") int taille, @QueryParam("nbChambres") int nbChambres, @QueryParam("idPerson") int idPerson) {
    	Home h = new Home();
    	h.setTaille(taille);
    	h.setNbChambres(nbChambres);
    	h.setPerson(manager.find(Person.class, idPerson));
    	return "Add OK";
    }
    
    @DELETE
    @Path("/home/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String removeHomeById(@PathParam("id") int id) {
    	try {
	    	manager.getTransaction().begin();
	    	manager.remove(getHomeById(id));
	    	manager.getTransaction().commit();
	    	
	    	return "Delete OK";
    	} catch (Exception e) {
    		return "Une erreur est survenue et la suppression n'a pas pu être effectuée.";
    	}
    }
    
    ////////////
    // PERSON //
    ////////////
    
    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getPersons() {    	
    	String s = "SELECT p FROM Person as p";
		Query q = manager.createQuery(s, Person.class);
		return q.getResultList();
    }
    
    @GET
    @Path("/person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") int id) {    	
    	try {
    		return manager.find(Person.class, id);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    @POST
    @Path("/person")
    @Produces(MediaType.TEXT_HTML)
    public String addPerson(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("mail") String mail) {
    	Person p = new Person();
    	p.setNom(nom);
    	p.setPrenom(prenom);
    	p.setMail(mail);
    	return "Add OK";
    }
    
    @DELETE
    @Path("/person/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String removePersonById(@PathParam("id") int id) {
    	try {
	    	manager.getTransaction().begin();
	    	manager.remove(getPersonById(id));
	    	manager.getTransaction().commit();
	    	
	    	return "Delete OK";
    	} catch (Exception e) {
    		return "Une erreur est survenue et la suppression n'a pas pu être effectuée.";
    	}
    }
    
    //////////////////
    // SMART DEVICE //
    //////////////////
    
    @GET
    @Path("/device")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SmartDevice> getSmartDevices() {    	
    	String s = "SELECT d FROM SmartDevice as d";
		Query q = manager.createQuery(s, SmartDevice.class);
		return q.getResultList();
    }
    
    @GET
    @Path("/device/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SmartDevice getSmartDeviceById(@PathParam("id") int id) {
    	try {
    		return manager.find(SmartDevice.class, id);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    @POST
    @Path("/device/electronic")
    @Produces(MediaType.TEXT_HTML)
    public String addElectronicDevice(@QueryParam("conso") float conso, @QueryParam("idHome") int idHome) {
    	ElectronicDevice d = new ElectronicDevice();
    	d.setConso(conso);
    	d.setHome(manager.find(Home.class, idHome));
    	return "Add OK";
    }
    
    @POST
    @Path("/device/heater")
    @Produces(MediaType.TEXT_HTML)
    public String addHeater(@QueryParam("power") int power, @QueryParam("idHome") int idHome) {
    	Heater d = new Heater();
    	d.setPower(power);
    	d.setHome(manager.find(Home.class, idHome));
    	return "Add OK";
    }
    
    @DELETE
    @Path("/device/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String removeSmartDeviceById(@PathParam("id") int id) {
    	try {
	    	manager.getTransaction().begin();
	    	manager.remove(getSmartDeviceById(id));
	    	manager.getTransaction().commit();
	    	
	    	return "Delete OK";
    	} catch (Exception e) {
    		return "Une erreur est survenue et la suppression n'a pas pu être effectuée.";
    	}
    }
}
