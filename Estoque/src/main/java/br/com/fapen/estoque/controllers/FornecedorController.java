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

import br.com.fapen.estoque.models.Fornecedor;
import br.com.fapen.estoque.repositories.FornecedorRepository;
import br.com.fapen.estoque.repositories.Paginacao;


@Controller
public class FornecedorController {
	
	@Autowired
	FornecedorRepository repFornecedor;
	@RequestMapping(value = "/novof", method = RequestMethod.GET , name="novoFornecedorUrl")
	public String folder() {
		
		return "fornecedor/CadastroFornecedor";
	}
	
	
	@RequestMapping(value = "fornecedor/CadastroFornecedor", method = RequestMethod.POST, name = "salvaFornecedorUrl")
	public String salvaNoBancoFornecedor(@Valid Fornecedor fornecedorQueSeraSalvo, BindingResult resultadoValidacao
			, RedirectAttributes atributos)
	{
			/* validacao do cadastro if(resultadoValidacao.hasErrors()){
			 * return fornecedor(fornecedorQueSeraSalvo)} */
		
		System.out.println("Estou salvando o Fornecedor");
		System.out.println(fornecedorQueSeraSalvo.getNomeEmpresa());
		System.out.println(fornecedorQueSeraSalvo.getFornecedorEmail());
		System.out.println(fornecedorQueSeraSalvo.getCnpj());
		System.out.println(fornecedorQueSeraSalvo.getTelefoneComercial());
		//salvar no banco
		repFornecedor.save(fornecedorQueSeraSalvo);
		//atributos.addFlashAttribute("mensagemStatus", "Produto salvo com sucesso aeee");
		//return "redirect:/listar";
		return "redirect:/listarf";
	}
	// Listar
		@RequestMapping(value = "/listarf", method = RequestMethod.GET, name = "listarFornecedorUrl")
		@ResponseBody
		public ModelAndView listar(@RequestParam(defaultValue = "1") Integer pagina) {
			Page<Fornecedor> listaFornecedorCadastrados = repFornecedor.findAll(Paginacao.getPaginacao(pagina));

			Paginacao listaPaginada = new Paginacao();

			listaPaginada.setTotalLinhas(repFornecedor.count());
			listaPaginada.setPaginacorrente(pagina);

			ModelAndView mav = new ModelAndView("fornecedor/ListaFornecedor");
			mav.addObject("forncedorList", listaFornecedorCadastrados  );
			mav.addObject("listaPaginada", listaPaginada);

			return mav;
		}
		//Edicao
		@RequestMapping(value = "/{id}/editarf", method = RequestMethod.GET, name = "alterarFornecedorUrl")
		public ModelAndView alterar(@PathVariable Integer id) {
			Fornecedor fornecedorSendoAlterado = repFornecedor.getOne(id);

			List<Fornecedor> listaDeFornecedores = repFornecedor.findAll();

			System.out.println("SAIU"  + fornecedorSendoAlterado.getNomeEmpresa());
			ModelAndView mav = new ModelAndView("fornecedor/CadastroFornecedor");
			mav.addObject("CadastroFornecedor", fornecedorSendoAlterado);
			mav.addObject("fornecedorList", listaDeFornecedores);

			return mav;

		}
		// Detalhe
		@RequestMapping(value = "//{id}", name = "detalharFornecedorUrl")
		public ModelAndView detalhar(@PathVariable Integer id) {

			Fornecedor produtoVindoDoBanco = repFornecedor.getOne(id);
			ModelAndView mav = new ModelAndView("fornecedor/detalheFornecedor");
			mav.addObject("fornecedor", produtoVindoDoBanco);
			return mav;
		}
		// Excluir
		@SuppressWarnings("unused")
		@RequestMapping(value = "//{id}/delete",method = RequestMethod.POST,  name = "excluirFornecedorUrl")
		public String excluir(@PathVariable Integer id, RedirectAttributes atributos) {

			
		
			Fornecedor fornecedorEncontrado = repFornecedor.getOne(id);
			repFornecedor.delete(repFornecedor.getOne(id));
			atributos.addFlashAttribute("mensagemStatus", "Fornecedor excluido com sucesso!");

			return "redirect:/listarf";
		}

	
	
}
