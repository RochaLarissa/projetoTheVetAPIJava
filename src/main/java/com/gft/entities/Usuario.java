package com.gft.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_usuario")
public class Usuario implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@JsonIgnore
	private String senha;
	
	@ManyToOne
	private Perfil perfil;
	
	@ManyToOne
	private Cliente cliente;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(this.perfil);
	}
	@Override
	@JsonIgnore
	public String getPassword() {
		return getSenha();
	}
	@Override
	public String getUsername() {
		return getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", perfil=" + perfil + "]";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCachorro(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Usuario(Long id, String email, String senha, Perfil perfil, Cliente cliente) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.cliente = cliente;
	}
	public Usuario() {
	}
	
	
	

}
