package br.com.fapen.estoque.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
@Entity(name = "t_perfil")
public class Perfil  implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "perfil_id", length = 50)
	private String authority;
	@Column(name = "descricao", length = 50)
	private String descricao;


	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	

}
