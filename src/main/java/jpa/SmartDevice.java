package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SmartDevice {
	private int id;
	private Home home;

	public SmartDevice() {
		super();
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
}