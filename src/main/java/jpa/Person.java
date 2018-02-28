package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Person {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private Collection<Home> homes;
	
	public Person() {
		super();
		this.homes = new ArrayList<Home>();
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	public Collection<Home> getHomes() {
		return homes;
	}
	
	public void setHomes(Collection<Home> homes) {
		this.homes = homes;
	}

	public void addHome(Home home) {
		this.homes.add(home);
	}
}