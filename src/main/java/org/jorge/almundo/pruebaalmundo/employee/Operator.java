package org.jorge.almundo.pruebaalmundo.employee;

public class Operator extends Employee {

	public Operator() {
		super("Operador");
	}

	@Override
	public void removeEmployee() {
		getListener().operators.remove(this);
		getListener().processQueue();
	}

}
