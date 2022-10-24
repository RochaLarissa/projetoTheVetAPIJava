package com.gft.entities;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "cachorros")
public class Cachorro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JoinTable(name = "clientes_lista_cachorros", joinColumns = @JoinColumn(name = "cachorro_id"),
    inverseJoinColumns = @JoinColumn(name = "cliente_id"))	
	private Cliente tutor;
	
	@Column(nullable = false)
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate nascimento;
	
	@Column(nullable = false)
	private String raca;
	
	@OneToMany(mappedBy = "cachorro", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Atendimento> listaAtendimentos;
	
	private String informacoes;
	
	
	public Cachorro() {
	}

	public Cachorro(Long id, String nome, Cliente tutor, LocalDate nascimento, String raca,
			Set<Atendimento> listaAtendimentos, String informacoes) {
		this.id = id;
		this.nome = nome;
		this.tutor = tutor;
		this.nascimento = nascimento;
		this.raca = raca;
		this.listaAtendimentos = listaAtendimentos;
		this.informacoes = informacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Cachorro [id=" + id + ", nome=" + nome + ", tutor=" + tutor.getNome() + ", nascimento=" + nascimento + ", raca="
				+ raca + ", listaAtendimentos=" + listaAtendimentos + ", informacoes=" + informacoes + "]";
	}

	
	
	
}
