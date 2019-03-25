package org.jorge.almundo.pruebaalmundo.controller;

import org.jorge.almundo.pruebaalmundo.business.Dispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestsHandler {
	
	@RequestMapping("/index")
	public String welcome() {
		System.out.println("Entra a Welcome");
	    return "index";
	}
	
	@PostMapping("/dispatch")
    public String dispatchCall(Model model) {
		int idCall = Dispatcher.getInstance().dispatchCall();
		model.addAttribute("idCall", idCall);
        return "index";
    }
	
	@RequestMapping("/mensaje")
	public String Mensaje() {
		System.out.println("Entra a Mensaje");
	    return "mensaje";
	}
	
}
