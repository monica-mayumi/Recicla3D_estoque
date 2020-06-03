package br.com.fapen.estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fapen.estoque.form.UsuarioForm;

@Controller
@RequestMapping
public class TesteContraller {
	@RequestMapping(value = "/novoUsuario1", method = RequestMethod.GET, name = "novoUsuarioUrl")
	public String formulario(UsuarioForm usuarioForm) {
		return "produtos/cadMateriaPrima";
	}


}
