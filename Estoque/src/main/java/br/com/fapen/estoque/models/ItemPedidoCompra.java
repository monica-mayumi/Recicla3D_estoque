package br.com.fapen.estoque.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "t_item_pedido_compra")
public class ItemPedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_pedido_compra_id")
	private int id;

	@ManyToOne
	//@Column(name = "item_pedido_compra")
	@JoinColumn(name="item_pedido_compra") //,referencedColumnName="pedido_compra_itens_pedido_compra_id")
	private PedidoCompra pedido;

	@ManyToOne
	//@Column(name = "item_pedido_compra_matr_prim_id")
	@JoinColumn(name="item_pedido_compra_matr_prim_id",referencedColumnName="matr_prim_id")
	private MateriaPrima produto;

	@Column(name = "item_pedido_compra_quantidade")
	private Long quantidade;

	@Column(name = "item_pedido_compra_valor_unitario")
	private BigDecimal precoUnitario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PedidoCompra getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra pedido) {
		this.pedido = pedido;
	}

	public MateriaPrima getProduto() {
		return produto;
	}

	public void setProduto(MateriaPrima produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		BigDecimal qtde = new BigDecimal(this.quantidade);
		return this.precoUnitario.multiply(qtde);
	}
}
