package com.gft.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veterinarios")
public class Veterinario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String crmv;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String email;
	
	private String especialidade;
	
	@OneToMany(mappedBy = "veterinario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Atendimento> listaAtendimentos;
	
	
	public Veterinario() {
	}


	public Veterinario(Long id, String crmv, String nome, String telefone, String email, String especialidade,
			Set<Atendimento> listaAtendimentos) {
		this.id = id;
		this.crmv = crmv;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
		this.listaAtendimentos = listaAtendimentos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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
