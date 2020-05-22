package br.com.fapen.estoque.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(name = "fornec_cep",length=10)
	private String cep;
	@Column(name = "fornec_endereco",length=10)
	private String endereco;
	

	@Column(name = "fornec_numero",length=10)
	private String numero;
	
	@Column(name = "fornec_complemento",length=10)
	private String complemento;
	
	@Column(name = "fornec_bairro",length=10)
	private String bairro;
	@Column(name = "fornec_municipio",length=10)
	private String municipio;
	
	@Column(name = "fornec_uf",length = 2)
	private String uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

}
