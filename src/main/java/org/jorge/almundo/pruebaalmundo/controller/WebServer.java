package org.jorge.almundo.pruebaalmundo.controller;

import java.util.HashMap;
import java.util.Map;

import org.jorge.almundo.pruebaalmundo.business.Dispatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServer {
	
	@GetMapping("/getCalls")
    public Map getCalls(@RequestParam("idCall") int idCall) {
		String respuesta = Dispatcher.getInstance().fecthCall(idCall);
		Map json = new HashMap();
		json.put("mensaje", respuesta);
        return json;
    }

}
