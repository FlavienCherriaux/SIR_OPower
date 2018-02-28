package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends SmartDevice {
	private float conso;
	
	public ElectronicDevice() {
		super();
	}

	public float getConso() {
		return conso;
	}

	public void setConso(float conso) {
		this.conso = conso;
	}
}
