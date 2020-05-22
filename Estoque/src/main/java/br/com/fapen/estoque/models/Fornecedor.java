package br.com.fapen.estoque.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_fornecedor")
public class Fornecedor {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fornec_id")
	private Integer id;

	@Column(name = "fornec_nome_empresa")
	private String nomeEmpresa;
	
	@Column(name = "fornec_email")
	private String  fornecedorEmail;

	@Column(name = "fornec_cnpj",length=10)
	private String cnpj;
    
    @Column(name = "fornec_telefone_comercial",length=10)
	private String telefoneComercial;
    
    @Embedded
    private Endereco endereco;
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getFornecedorEmail() {
		return fornecedorEmail;
	}

	public void setFornecedorEmail(String fornecedorEmail) {
		this.fornecedorEmail = fornecedorEmail;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

}
