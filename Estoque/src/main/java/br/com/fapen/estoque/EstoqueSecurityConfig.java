package br.com.fapen.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.fapen.estoque.service.UsuarioService;

@EnableWebSecurity
public class EstoqueSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;
	
	@Autowired
	private UsuarioService servicoDeUsuarios;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
		
		auth.userDetailsService(servicoDeUsuarios).passwordEncoder(new BCryptPasswordEncoder());
		
		System.out.println("Passou aqui !!!!!");
		//Cria o usuario Admin, se não existir
		if (! servicoDeUsuarios.userExists("Admin")) {
			servicoDeUsuarios.addAdminUser();
		}

	}


	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		     .antMatchers("/usuarios/**").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/sobre").permitAll()
			.antMatchers("/contato").permitAll()
			.antMatchers("/produto").permitAll()
			.antMatchers("/api/**").permitAll()
			.antMatchers("/recuperarSenha/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/img/**").permitAll()					
			.antMatchers(HttpMethod.POST, "/**/delete").hasAnyRole("ADMIN", "GERENTE")
			//.antMatchers("/usuarios/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()
			.and()
			.csrf().disable()
			.logout(). logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");
	}	
}

