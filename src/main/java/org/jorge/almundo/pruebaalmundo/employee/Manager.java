package org.jorge.almundo.pruebaalmundo.employee;

public class Manager extends Employee {

	public Manager() {
		super("Director");
	}

	@Override
	public void removeEmployee() {
		getListener().managers.remove(this);
		getListener().processQueue();
	}
}
