package br.com.fapen.estoque.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fapen.estoque.models.MateriaPrima;
import br.com.fapen.estoque.repositories.MateriaPrimaRepository;
import br.com.fapen.estoque.validation.ProdutoValidator;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoApiController {

	@Autowired
	private MateriaPrimaRepository repProdutos;

	@Autowired
	private ProdutoValidator produtoValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}

	@GetMapping
	public List<MateriaPrima> listar() {
		return repProdutos.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MateriaPrima> buscarPorId(@PathVariable Integer id) {
		Optional<MateriaPrima> prod = repProdutos.findById(id);
		if (prod.isEmpty()) {
			return new ResponseEntity<MateriaPrima>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MateriaPrima>(prod.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody MateriaPrima produto) {
		repProdutos.save(produto);
		return new ResponseEntity<Object>(produto, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MateriaPrima> alterar(@PathVariable Integer id, @RequestBody MateriaPrima produto) {
		MateriaPrima prod = repProdutos.findById(id).get();
		if (prod == null) {
			return new ResponseEntity<MateriaPrima>(HttpStatus.NOT_FOUND);
		}
		repProdutos.save(produto);
		return new ResponseEntity<MateriaPrima>(produto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MateriaPrima> excluir(@PathVariable Integer id) {
		MateriaPrima prod = repProdutos.findById(id).get();
		if (prod == null) {
			return new ResponseEntity<MateriaPrima>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MateriaPrima>(HttpStatus.OK);
	}
}
