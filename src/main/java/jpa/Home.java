package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Home {
	private int id;
	private int taille;
	private int nbChambres;
	private Person person;
	private Collection<SmartDevice> devices;
	
	public Home() {
		super();
		this.devices = new ArrayList<SmartDevice>();
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getNbChambres() {
		return nbChambres;
	}
	
	public void setNbChambres(int nbChambres) {
		this.nbChambres = nbChambres;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
	public Collection<SmartDevice> getDevices() {
		return devices;
	}

	public void setDevices(Collection<SmartDevice> devices) {
		this.devices = devices;
	}
	
	public void addDevice(SmartDevice device) {
		this.devices.add(device);
	}
}