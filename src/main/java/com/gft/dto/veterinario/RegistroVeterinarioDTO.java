package com.gft.dto.veterinario;
import java.util.Set;
import com.gft.entities.Atendimento;

public class RegistroVeterinarioDTO {
	
	private String crmv;	
	private String nome;
	private String telefone;		
	private String email;	
	private String especialidade;
	private Set<Atendimento> listaAtendimentos;
	
	public String getCrmv() {
		return crmv;
	}
	public void setCrmv(String crmv) {
		this.crmv = crmv;
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
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public Set<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}
	public void setListaAtendimentos(Set<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}	
	
	
	
}
