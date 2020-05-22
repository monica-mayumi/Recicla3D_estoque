package br.com.fapen.estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SobreController {
	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String helloword() {
		return "sobre";
	}

}
