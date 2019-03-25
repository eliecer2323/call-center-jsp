package org.jorge.almundo.pruebaalmundo.employee;

import org.jorge.almundo.pruebaalmundo.business.Call;
import org.jorge.almundo.pruebaalmundo.business.Dispatcher;

public abstract class Employee extends Thread {
	
	private Dispatcher listener;
	private String type;
	private Call call;
	
	public Employee (String type) {
		this.type = type;
	}

	public boolean answerCall(Call call) {
		this.call = call;
		this.start();
		return true;
	}
	
	public void run() {
		for (int i=0; i<call.getDuration(); i++) {
			try {
				sleep(1000);
				listener.mensajes.put(call.getId()+"", listener.mensajes.get(call.getId()+"")+"<br />Se han completado "+i+" de "+call.getDuration()+" segundos");
				System.out.println(type+" esta procesando la llamada "+call.getId()+": "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		listener.mensajes.put(call.getId()+"", listener.mensajes.get(call.getId()+"")+"<br />"+type+" atendió su llamada con exito en "+call.getDuration()+" segundos");
		System.out.println(type+" termino la llamada "+call.getId());
		removeEmployee();
	}
	
	public void setListener(Dispatcher listener) {
		this.listener = listener;
	}
	
	public Dispatcher getListener() {
		return listener;
	}
	
	public abstract void removeEmployee();
	
}
