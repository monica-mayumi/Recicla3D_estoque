package br.com.fapen.estoque.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "t_matr_prim")
public class MateriaPrima {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matr_prim_id")
	private Integer id;

	@Column(name = "matr_prim_descricao")
	private String descricao;
	
	@Column(name = "matr_prim_custo_unitario")
	private BigDecimal custoUnitario;
	
    @Column(name="matr_prim_categoria",length=10)
	private String categoria;
    
    //@Column(name="matr_prim_fornec_id")
    //private Integer fornecedor;
/*
 *    CONSTRAINT fk_t_matr_prim FOREIGN KEY (matr_prim_fornec_id)
        REFERENCES public.t_fornecedor (fornec_id) MATCH SIMPLE
 
    @ManyToOne
    @JoinColumn(name="matr_prim_fornec_id",
    foreignKey = @ForeignKey(),
    			referencedColumnName="fornec_id")   
    */
    
    @ManyToOne
    @JoinColumn(name="matr_prim_fornec_id",referencedColumnName="fornec_id")    
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getCustoUnitario() {
		return custoUnitario;
	}

	public void setCustoUnitario(BigDecimal custoUnitario) {
		this.custoUnitario = custoUnitario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
