package org.jorge.almundo.pruebaalmundo.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import org.jorge.almundo.pruebaalmundo.employee.Employee;
import org.jorge.almundo.pruebaalmundo.employee.Manager;
import org.jorge.almundo.pruebaalmundo.employee.Operator;
import org.jorge.almundo.pruebaalmundo.employee.Supervisor;

public class Dispatcher {
	
	private static Dispatcher instance;
	private Queue<Call> cola = new LinkedList<Call>();
	public Map<String, String> mensajes = new HashMap<String, String>();
	public List<Employee> operators = new ArrayList<Employee>();
	public List<Employee> supervisors = new ArrayList<Employee>();
	public List<Employee> managers = new ArrayList<Employee>();
	private int autoincremental;
	
	private Dispatcher() {
		
	}
	
	public int dispatchCall() {
		Random r = new Random();
		int seconds = r.nextInt(6) + 5;
		Call llamada = new Call();
		llamada.setDuration(seconds);
		llamada.setId(++autoincremental);
		System.out.println("Llamada creada con "+seconds);
		cola.add(llamada);
		mensajes.put(llamada.getId()+"", "Su llamada se encuentra en cola para ser atendida con una duración de "+seconds+" segundos");
		processQueue();
		return llamada.getId();
	}
	
	public void processQueue() {
		Call llamada = cola.peek(); 
		if(llamada!=null) {
			Employee empleado = null;
			if(operators.size()<7) {
				empleado = new Operator();
				mensajes.put(llamada.getId()+"", mensajes.get(llamada.getId()+"")+"<br />Su llamada será atendida por un operador");
				System.out.print("Operador atenderá");
				operators.add(empleado);
			} else if(supervisors.size()<2) {
				empleado = new Supervisor();
				mensajes.put(llamada.getId()+"", mensajes.get(llamada.getId()+"")+"<br />Su llamada será atendida por un supervisor");
				System.out.print("Supervisor atenderá");
				supervisors.add(empleado);
			} else if (managers.size()<1) {
				empleado = new Manager();
				mensajes.put(llamada.getId()+"", mensajes.get(llamada.getId()+"")+"<br />Su llamada será atendida por un director");
				System.out.print("Director atenderá");
				managers.add(empleado);
			} 
			
			if(empleado!=null) {
				empleado.setListener(this);
				System.out.println(" la llamada "+llamada.getId());
				empleado.answerCall(cola.poll());
			}
		}
	}
	
	public String fecthCall(int idCall) {
		return mensajes.get(idCall+"");		
	}

	public static Dispatcher getInstance() {
		if(instance==null) {
			instance = new Dispatcher();
		}
		return instance;
	}
	
}
