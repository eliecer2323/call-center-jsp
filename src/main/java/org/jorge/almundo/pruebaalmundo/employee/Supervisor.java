package org.jorge.almundo.pruebaalmundo.employee;

public class Supervisor extends Employee {

	public Supervisor() {
		super("Supervisor");
	}

	@Override
	public void removeEmployee() {
		getListener().supervisors.remove(this);
		getListener().processQueue();
	}

}
