package org.jorge.almundo.prueba.pruebaalmundo;

import org.jorge.almundo.pruebaalmundo.business.Dispatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Dispatcher.class)
public class PruebaAlmundoApplicationTests {

	@Test
	public void contextLoads() {
		probar();
	}
	
	private void probar() {
		Dispatcher dispatcher = Dispatcher.getInstance();
		for (int i = 0; i <20; i++) {
			System.out.println("id: "+dispatcher.dispatchCall());
		}
	}

}
