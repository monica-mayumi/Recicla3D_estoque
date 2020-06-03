package br.com.fapen.estoque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.estoque.form.MateriaPrimaForm;
import br.com.fapen.estoque.models.Fornecedor;
import br.com.fapen.estoque.models.MateriaPrima;
import br.com.fapen.estoque.repositories.FornecedorRepository;
import br.com.fapen.estoque.repositories.MateriaPrimaRepository;
import br.com.fapen.estoque.repositories.Paginacao;

@Controller

public class MateriaPrimaController {

	@Autowired
	MateriaPrimaRepository repMateriaPrima;
	@Autowired
	FornecedorRepository repFornecedor;

	@RequestMapping(value = "/novoM", method = RequestMethod.GET, name = "novoProdutoUrl")
	public ModelAndView folder() {
		List<Fornecedor> listaDeFornecedores = repFornecedor.findAll();

		ModelAndView mavFornec = new ModelAndView("produtos/cadMateriaPrima");
		mavFornec.addObject("fornecedorList", listaDeFornecedores);
		return mavFornec;
	}

	@RequestMapping(method = RequestMethod.POST, name = "salvarProdutoUrl")
	public String salvaNoBancoMateriaPrima(@Valid MateriaPrimaForm produtoQueSeraSalvo,
			BindingResult resultadoValidacao, RedirectAttributes atributos) {
		Fornecedor fornec = new Fornecedor();
		fornec.setId(produtoQueSeraSalvo.getFornecedor());

		MateriaPrima mtp = new MateriaPrima();
		mtp.setId(produtoQueSeraSalvo.getId());
		mtp.setCategoria(produtoQueSeraSalvo.getCategoria());
		mtp.setCustoUnitario(produtoQueSeraSalvo.getCustoUnitario());
		mtp.setDescricao(produtoQueSeraSalvo.getDescricao());
		mtp.setFornecedor(fornec);

		repMateriaPrima.save(mtp);
		atributos.addFlashAttribute("mensagemStatus", "Produto salvo com sucesso aeee");
		// atributos.addFlashAttribute("numpages","" + repMateriaPrima.count()); //Pega
		// numero de linhas na tabela
		return "redirect:/listar";
	}

	// Listar
	@RequestMapping(value = "/listar", method = RequestMethod.GET, name = "listarProdutoUrl")
	@ResponseBody
	public ModelAndView listar(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {
		Page<MateriaPrima> listaDeProdutosCadastrados;
		if (busca.equals("")) {
			listaDeProdutosCadastrados = repMateriaPrima.findAll(Paginacao.getPaginacao(pagina));
		}else {
			listaDeProdutosCadastrados = repMateriaPrima.findByDescricaoContainingIgnoreCase(busca,
					Paginacao.getPaginacao(pagina));
		}

		/*Page<MateriaPrima> listaDeProdutosCadastrados = repMateriaPrima.findByDescricaoContainingIgnoreCase(busca,
				Paginacao.getPaginacao(pagina));*/
		

		Paginacao listaPaginada = new Paginacao();

		listaPaginada.setTotalLinhas(repMateriaPrima.count());
		listaPaginada.setPaginacorrente(pagina);

		ModelAndView mav = new ModelAndView("produtos/ListaProduto");
		mav.addObject("produtoList", listaDeProdutosCadastrados);
		mav.addObject("listaPaginada", listaPaginada);
		// mav.addObject("busca" , busca);

		return mav;
	}

	// edição
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET, name = "alterarProdutoUrl")
	public ModelAndView alterar(@PathVariable Integer id) {
		MateriaPrima produtoSendoAlterado = repMateriaPrima.getOne(id);

		List<Fornecedor> listaDeFornecedores = repFornecedor.findAll();

		System.out.println("SAIU" + produtoSendoAlterado.getDescricao());
		ModelAndView mav = new ModelAndView("produtos/cadMateriaPrima");
		mav.addObject("cadMateriaPrima", produtoSendoAlterado);
		mav.addObject("fornecedorList", listaDeFornecedores);

		return mav;

	}

	// Detalhe
	@RequestMapping(value = "/{id}", name = "detalharProdutoUrl")
	public ModelAndView detalhar(@PathVariable Integer id) {

		MateriaPrima produtoVindoDoBanco = repMateriaPrima.getOne(id);
		ModelAndView mav = new ModelAndView("produtos/DetalheProduto");
		mav.addObject("produto", produtoVindoDoBanco);
		return mav;
	}

	// Excluir
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, name = "excluirProdutoUrl")
	public String excluir(@PathVariable Integer id, RedirectAttributes atributos) {

		MateriaPrima produtoEncontrado = repMateriaPrima.getOne(id);
		repMateriaPrima.delete(produtoEncontrado);
		atributos.addFlashAttribute("mensagemStatus", "Produto excluido com sucesso!");

		return "redirect:/listar";
	}

}
