package br.com.fapen.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.estoque.models.Produto;
import br.com.fapen.estoque.repositories.MateriaPrimaRepository;
import br.com.fapen.estoque.repositories.Paginacao;
import br.com.fapen.estoque.validation.ProdutoValidator;

@Controller
@RequestMapping(value = "/produtos")
public class MateriaPrimaController {

	@Autowired
	private MateriaPrimaRepository produtoRep;

	@Autowired
	private ProdutoValidator validadorDeProduto;

	@InitBinder("produto")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validadorDeProduto);
	}

	@RequestMapping(value = "/novoM", method = RequestMethod.GET, name = "novoProdutoUrl")
	public String formulario(Produto produto) {

		return "produtos/form";
	}

	@RequestMapping(method = RequestMethod.POST, name = "salvarProdutoUrl")
	public String salvarNoBanco(@Valid Produto produtoQueSeraSalvo, BindingResult resultadoValidacao,
			RedirectAttributes atributos) {

		if (resultadoValidacao.hasErrors()) {
			return formulario(produtoQueSeraSalvo);
		}
		
		produtoRep.save(produtoQueSeraSalvo);
		atributos.addFlashAttribute("mensagemStatus", "Produto salvo com sucesso!");

		return "redirect:/produtos";
	}

	@RequestMapping(method = RequestMethod.GET, name = "listarProdutoUrl")
	public ModelAndView listar(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {

		Page<Produto> listaDeProdutosCadastrados = produtoRep.findByDescricaoContainingIgnoreCase(busca,
				Paginacao.getPaginacao(pagina));

		ModelAndView mav = new ModelAndView("produtos/ListaProduto");
		mav.addObject("listaPaginada", listaDeProdutosCadastrados);
		mav.addObject("busca", busca);

		return mav;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET, name = "alterarProdutoUrl")
	public ModelAndView alterar(@PathVariable Long id) {
		Produto produtoQueSeraAlterado = produtoRep.getOne(id);

		ModelAndView mav = new ModelAndView("produtos/form");
		mav.addObject("produto", produtoQueSeraAlterado);
		return mav;
	}

	@RequestMapping(value = "/{id}", name = "detalharProdutoUrl")
	public ModelAndView detalhar(@PathVariable Long id) {

		Produto produtoVindoDoBanco = produtoRep.getOne(id);
		ModelAndView mav = new ModelAndView("produtos/DetalheProduto");
		mav.addObject("produto", produtoVindoDoBanco);
		return mav;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, name = "excluirProdutoUrl")
	public String excluir(@PathVariable Long id, RedirectAttributes atributos) {

		Produto produtoEncontrado = produtoRep.getOne(id);
		produtoRep.delete(produtoEncontrado);
		atributos.addFlashAttribute("mensagemStatus", "Produto excluido com sucesso !");
		return "redirect:/produtos";
	}

}
