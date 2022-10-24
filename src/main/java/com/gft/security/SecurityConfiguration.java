package com.gft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gft.filter.FiltroAutenticacao;
import com.gft.services.AutenticacaoService;
import com.gft.services.UsuarioService;



@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/v1/auth").permitAll()
		
		//criar novo
		.antMatchers(HttpMethod.POST, "/v1/clientes").hasAuthority("Admin")
		.antMatchers(HttpMethod.POST, "/v1/cachorros").hasAuthority("Admin")
		.antMatchers(HttpMethod.POST, "/v1/veterinarios").hasAuthority("Admin")
		.antMatchers(HttpMethod.POST, "/v1/atendimentos").hasAuthority("Admin")
		
		//ver todos
		.antMatchers(HttpMethod.GET, "/v1/clientes").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/cachorros").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/veterinarios").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/atendimentos").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/arquivoMorto").hasAuthority("Admin")
		
		//listar por id
		.antMatchers(HttpMethod.GET, "/v1/clientes/{id})").hasAuthority("Admin, User")
		.antMatchers(HttpMethod.GET, "/v1/cachorros/{id})").hasAuthority("Admin, User")
		.antMatchers(HttpMethod.GET, "/v1/veterinarios/{id})").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/atendimentos/{id})").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/arquivoMorto/{id})").hasAuthority("Admin")
		
		//listar por nome
		.antMatchers(HttpMethod.GET, "/v1/clientes/nome/{nome}").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/cachorros/nome/{nome}").hasAuthority("Admin")
		.antMatchers(HttpMethod.GET, "/v1/veterinarios/nome/{nome}").hasAuthority("Admin")
		
		//ver lista de cachorros e de atendimentos
		.antMatchers(HttpMethod.GET, "/v1/clientes/listarCachorros/...").hasAuthority("Admin, User") 
		.antMatchers(HttpMethod.GET, "/v1/clientes/listarAtendimentos/...").hasAuthority("Admin, User") 
		.antMatchers(HttpMethod.GET, "/v1/cachorros/listarAtendimentos/...").hasAuthority("Admin, User")
		.antMatchers(HttpMethod.GET, "/v1/veterinarios/listarAtendimentos/...").hasAuthority("Admin")
		
		//alterar dados
		.antMatchers(HttpMethod.PUT, "/v1/clientes/{id})").hasAuthority("Admin") 
		.antMatchers(HttpMethod.PUT, "/v1/cachorros/{id})").hasAuthority("Admin") 
		.antMatchers(HttpMethod.PUT, "/v1/veterinarios/{id})").hasAuthority("Admin") 
		
		//deletar e arquivar
		.antMatchers(HttpMethod.DELETE, "/v1/clientes/{id})").hasAuthority("Admin") 
		.antMatchers(HttpMethod.DELETE, "/v1/cachorros/{id})").hasAuthority("Admin") 
		.antMatchers(HttpMethod.DELETE, "/v1/veterinarios/{id})").hasAuthority("Admin") 
		.antMatchers(HttpMethod.DELETE, "/v1/atendimentos/{id})").hasAuthority("Admin") 
		
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new FiltroAutenticacao(autenticacaoService, usuarioService), 
				UsernamePasswordAuthenticationFilter.class);
	}
	
	

}
