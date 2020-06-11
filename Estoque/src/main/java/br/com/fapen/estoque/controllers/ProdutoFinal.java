package br.com.fapen.estoque.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller

public class ProdutoFinal {
	
	@RequestMapping(value = "/produto", method = RequestMethod.GET, name = "produtoUrl")
	public String produto(Principal usuarioPrincipal) {
		return "produto";
	}

}
