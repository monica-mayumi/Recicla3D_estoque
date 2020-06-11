package br.com.fapen.estoque.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class SobreController {
	@RequestMapping(value = "/sobre", method = RequestMethod.GET, name = "sobreUrl")
	public String home(Principal usuarioPrincipal) {
		return "sobre";
	}
}
