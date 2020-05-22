package br.com.fapen.estoque.models;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.fapen.estoque.enums.CondicaoPagtoEnum;
import br.com.fapen.estoque.enums.StatusEnum;

@Entity(name = "t_pedido_compra")
public class PedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_compra_id")
	private int id;

	@ManyToOne
	//@Column(name = "pedido_compra_fornec_id")
	@JoinColumn(name="pedido_compra_fornec_id",referencedColumnName="fornec_id")
	private Fornecedor fornecedor;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "pedido_compra_data_entrega")
	private LocalDate dataEntrega;

	@Enumerated(EnumType.STRING)
	@Column(name = "pedido_compra_condicao_pagto")
	private CondicaoPagtoEnum condicaoPagamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "pedido_compra_status")
	private StatusEnum status;

	@Column(name = "pedido_compra_valor_total")
	private BigDecimal valorTotal;

	@Column(name = "pedido_compra_obs")
	private String observacao;
	
	@OneToMany(targetEntity = ItemPedidoCompra.class,
			   mappedBy = "pedido", 
			   fetch = FetchType.LAZY, 
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	private List<ItemPedidoCompra> itens = new ArrayList<ItemPedidoCompra>();

	public PedidoCompra() {
		this.status = StatusEnum.EM_DIGITACAO;
		this.valorTotal = BigDecimal.ZERO;
		this.dataEntrega = LocalDate.now().plusDays(10);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public CondicaoPagtoEnum getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagtoEnum condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<ItemPedidoCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoCompra> itens) {
		this.itens = itens;
	}
/*	
	public ItemPedidoCompra getItemPedidoCompra() {
		return itemPedidoCompra;
	}

	public void setItemPedidoCompra(ItemPedidoCompra itemPedidoCompra) {
		this.itemPedidoCompra = itemPedidoCompra;
	}
*/	

}
