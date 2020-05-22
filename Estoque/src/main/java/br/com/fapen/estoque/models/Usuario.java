package br.com.fapen.estoque.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.userdetails.UserDetails;

@DynamicUpdate
@Entity(name = "t_usuario")
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 609928275369457081L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer id;

	@Column(name = "usuario_login", length = 45)
	private String login;

	@Column(name = "usuario_senha", updatable = false)
	private String password;

	@Column(name = "usuario_nome_completo")
	private String nomeCompleto;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "usuario_data_nascimento")
	private LocalDate dataNascimento;

	
	@Column(name = "usuario_cpf",length = 11 )
	private String cpf;

	@Column(name = "usuario_email",length = 100)
	private String email;

	@Column(name = "usuario_foto_perfil")
	private String caminhoFoto;

	@Column(name = "usuario_hash",updatable = false)
	private String hash;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "usuario_perfil_id"))
	private List<Perfil> authorities = new ArrayList<Perfil>();

	public void setAuthorities(List<Perfil> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<Perfil> getAuthorities() {
		return this.authorities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return login;
	}

	public void setUsername(String username) {
		this.login = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[^0-9]", "");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean hasRole(String roleName) {
		boolean result = false;
		for (Perfil p : this.authorities) {
			if (p.getAuthority().equals(roleName)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
