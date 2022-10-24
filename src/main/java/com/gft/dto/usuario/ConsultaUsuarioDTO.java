package com.gft.dto.usuario;
import com.gft.dto.cliente.ConsultaClienteDTO;

public class ConsultaUsuarioDTO {
	
	private String email;
	private String nomePerfil;
	private ConsultaClienteDTO cliente;
	
	public ConsultaUsuarioDTO() {
	}
	
	public ConsultaUsuarioDTO(String email, String nomePerfil, ConsultaClienteDTO cliente) {
		this.email = email;
		this.nomePerfil = nomePerfil;
		this.cliente = cliente;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
		
	public ConsultaClienteDTO getCliente() {
		return cliente;
	}
	public void setFilial(ConsultaClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	

}
