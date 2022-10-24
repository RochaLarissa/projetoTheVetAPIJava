package com.gft.dto.cachorro;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gft.entities.Atendimento;
import com.gft.entities.Cliente;

public class RegistroCachorroDTO {
	
	private String nome;
	
	private Cliente tutor;
	
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate nascimento;
	
	private String raca;	
	
	private Set<Atendimento> listaAtendimentos;	
	
	private String informacoes;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getTutor() {
		return tutor;
	}
	public void setTutor(Cliente tutor) {
		this.tutor = tutor;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Set<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}
	public void setListaAtendimentos(Set<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	
		

}
