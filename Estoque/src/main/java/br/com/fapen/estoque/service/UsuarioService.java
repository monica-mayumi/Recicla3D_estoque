package br.com.fapen.estoque.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fapen.estoque.form.UsuarioForm;
import br.com.fapen.estoque.models.Perfil;
import br.com.fapen.estoque.models.Usuario;
import br.com.fapen.estoque.repositories.PerfilRepository;
import br.com.fapen.estoque.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRep;

	@Autowired
	private PerfilRepository perfilRep;

	private UsuarioService() {

		super();
		try {
			addAdminUser();
			System.out.println("oloco/; " + userExists("Admin"));
			if (userExists("Admin") == false) {

				System.out.println("HAHAHAHAHAHAHAHAHAHA");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRO: " + e.toString());
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuarioBuscado = usuarioRep.findByLogin(username);
		return usuarioBuscado;
	}

	public Usuario loadUserByEmail(String email) {
		return usuarioRep.findByEmail(email);
	}

	public Usuario loadUserByHash(String hash) {
		return usuarioRep.findByHash(hash);
	}

	public void salvar(UsuarioForm formulario) {
		if (formulario.isInclusao()) {
			// Criptografa a senha
			String senhaLimpa = formulario.getUsuario().getPassword();
			formulario.getUsuario().setPassword(this.criptoSenha(senhaLimpa));

			// Monta o hash unico com (login + email + senha)
			formulario.getUsuario().setHash(this.geraHashUsuario(formulario.getUsuario()));
		}

		formulario.getUsuario().getAuthorities().clear();
		for (Perfil p : formulario.getListaPerfil()) {
			if (p.getAuthority() != null) {
				formulario.getUsuario().getAuthorities().add(p);
			}
		}
		usuarioRep.save(formulario.getUsuario());
	}

	public Usuario alterarSenha(Integer integer, String novaSenha) {
		Usuario u = usuarioRep.findByid(integer);// .get();
		String novaSenhaCripto = this.criptoSenha(novaSenha);
		u.setPassword(novaSenhaCripto);
		String novoHash = this.geraHashUsuario(u);
		u.setHash(novoHash);

		usuarioRep.alterarSenha(novaSenhaCripto, novoHash, integer);
		return u;
	}

	private String geraHashUsuario(Usuario usuario) {
		String dadosUsuario = usuario.getUsername() + usuario.getEmail() + usuario.getPassword();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		BigInteger hash = new BigInteger(1, md.digest(dadosUsuario.getBytes()));
		return hash.toString(16);
	}

	private String criptoSenha(String senhaLimpa) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senhaLimpa);
	}

	public boolean userExists(String login) {
		Usuario usu = usuarioRep.findByLogin(login);
		return (usu != null);
	}

	public void addAdminUser() {
		Perfil perfilAdmin = new Perfil();
		//Perfil perfilAdmin = new Perfil("ROLE_ADMIN", "Administrador");
		perfilAdmin.setAuthority("ROLE_ADMIN");
		perfilAdmin.setDescricao("Administrador");
		perfilRep.save(perfilAdmin);

		Usuario usuarioAdmin = new Usuario();
		usuarioAdmin.setUsername("Admin");
		usuarioAdmin.setCpf("15515515588");
		usuarioAdmin.setDataNascimento(LocalDate.parse("0001-01-01"));
		usuarioAdmin.setNomeCompleto("Administrador");
		usuarioAdmin.setEmail("rodrigo.guerato@hotmail.com");
		usuarioAdmin.setPassword(this.criptoSenha("1234"));
		usuarioAdmin.setHash(this.geraHashUsuario(usuarioAdmin));
		usuarioAdmin.getAuthorities().add(perfilAdmin);
		usuarioRep.save(usuarioAdmin);
	}

}
