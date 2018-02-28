package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Heater extends SmartDevice {
	private int power;
	
	public Heater() {
		super();
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
