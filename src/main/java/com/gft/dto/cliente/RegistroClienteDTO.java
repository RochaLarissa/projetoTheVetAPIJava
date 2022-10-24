package com.gft.dto.cliente;
import java.util.Set;

import com.gft.entities.Atendimento;
import com.gft.entities.Cachorro;

public class RegistroClienteDTO {
	
	private String cpf;	
	private String nome;
	private String telefone;	
	private String email;		
	private Set<Cachorro> listaCachorros;
	private Set<Atendimento> listaAtendimentos;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Cachorro> getListaCachorros() {
		return listaCachorros;
	}
	public void setListaCachorros(Set<Cachorro> listaCachorros) {
		this.listaCachorros = listaCachorros;
	}
	public Set<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}
	public void setListaAtendimentos(Set<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}	
	
	
	
		

}
