package org.jorge.almundo.pruebaalmundo;

import org.jorge.almundo.pruebaalmundo.business.Dispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaAlmundoApplication {

	public static void main(String[] args) {
//		probar();
		SpringApplication.run(PruebaAlmundoApplication.class, args);
	}

	private static void probar() {
		Dispatcher dispatcher = Dispatcher.getInstance();
		for (int i = 0; i <20; i++) {
			System.out.println("id: "+dispatcher.dispatchCall());
		}
	}

}
