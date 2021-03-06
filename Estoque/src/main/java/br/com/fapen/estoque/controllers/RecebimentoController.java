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

import antlr.collections.List;
import br.com.fapen.estoque.form.RecebimentoFiltroForm;
import br.com.fapen.estoque.form.RecebimentoForm;
import br.com.fapen.estoque.models.Produto;
import br.com.fapen.estoque.repositories.Paginacao;
import br.com.fapen.estoque.service.PedidoCompraService;
import br.com.fapen.estoque.service.RecebimentoService;
import br.com.fapen.estoque.validation.RecebimentoFormValidation;


@Controller
@RequestMapping(value = "/recebimento")
public class RecebimentoController {

	@Autowired
	private RecebimentoFormValidation validator;

	@Autowired
	private PedidoCompraService pedidoService;

	@Autowired
	private RecebimentoService recebService;

	@InitBinder("recebimentoForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET, name = "novoRecebimentoUrl")
	public ModelAndView formulario(RecebimentoForm recebimentoForm) {
		ModelAndView mav = new ModelAndView("recebimento/RecebimentoForm");
		mav.addObject("listaPedidos", pedidoService.listarEmDigitacao());
		mav.addObject(recebimentoForm);
		return mav;
	}

	@RequestMapping(value = "/carregaItens", method = RequestMethod.POST, name = "carregaItensRecebUrl")
	public ModelAndView carregaItensPedido(RecebimentoForm recebimentoForm) {
		recebService.carregarItensPedido(recebimentoForm);
		ModelAndView mav = new ModelAndView("recebimento/RecebForm-table");
		mav.addObject(recebimentoForm);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "salvarRecebimentoUrl")
	public ModelAndView salvarNoBanco(@Valid RecebimentoForm recebimentoForm, BindingResult resultado,
			RedirectAttributes atributos) {

		if (resultado.hasErrors()) {
			return formulario(recebimentoForm);
		}

		recebService.entrarEstoque(recebimentoForm);
		ModelAndView mav = new ModelAndView("redirect:/recebimento");
		atributos.addFlashAttribute("mensagemStatus", "Baixa realizada com sucesso !");

		return mav;
	}

	
	@RequestMapping(method = RequestMethod.GET, name = "listarRecebimentoUrl")
	public ModelAndView listar(RecebimentoFiltroForm filtroForm) {
		ModelAndView mav = new ModelAndView("recebimento/ListaReceb");
		mav.addObject("listaPaginada", recebService.listar(filtroForm)); //lista selecionado
		mav.addObject("recebimentoFiltroForm", filtroForm);
		return mav;
	}

	@RequestMapping(value = "/{id}/detalhes", method = RequestMethod.GET, name = "detalharRecebimentoUrl")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("recebimento/DetalheReceb");
		mav.addObject("registro", recebService.findById(id));
		return mav;
	}

	@RequestMapping(value = "{id}/estornar", method = RequestMethod.POST, name = "estornoRecebimentoUrl")
	public String estorar(@PathVariable Long id, RedirectAttributes atributos) {		
		try {
			recebService.estornar(id);
		} catch (Exception e) {
			atributos.addFlashAttribute("mensagemStatus", "Falha ao estornar " + e.getMessage());
			return "redirect:/recebimento";
		}		
		atributos.addFlashAttribute("mensagemStatus", "Recebimento estornado com sucesso.");
		return "redirect:/recebimento";
	}

}