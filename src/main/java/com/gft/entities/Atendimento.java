package com.gft.entities;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atendimentos")
public class Atendimento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinTable(name = "cachorro_lista_atendimentos", joinColumns = @JoinColumn(name = "atendimento_id"),
    inverseJoinColumns = @JoinColumn(name = "cachorro_id"))
	private Cachorro cachorro;
		
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinTable(name = "cliente_lista_atendimentos", joinColumns = @JoinColumn(name = "atendimento_id"),
	inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private Cliente tutorCachorro;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinTable(name = "veterinario_lista_atendimentos", joinColumns = @JoinColumn(name = "atendimento_id"),
    inverseJoinColumns = @JoinColumn(name = "veterinario_id"))
	private Veterinario veterinario;
	
	@Column(nullable = false)
	private LocalDateTime dataHora;
		
	@Column(nullable = false)
	private String dadosAnimal;
		
	private String diagnostico;
	
	private String comentarios;	
	

	public Atendimento() {
	}


	public Atendimento(Long id, Cachorro cachorro, Cliente tutorCachorro, Veterinario veterinario,
			LocalDateTime dataHora, String dadosAnimal, String diagnostico, String comentarios) {
		this.id = id;
		this.cachorro = cachorro;
		this.tutorCachorro = tutorCachorro;
		this.veterinario = veterinario;
		this.dataHora = dataHora;
		this.dadosAnimal = dadosAnimal;
		this.diagnostico = diagnostico;
		this.comentarios = comentarios;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	public Cliente getTutorCachorro() {
		return tutorCachorro;
	}

	public void setTutorCachorro(Cliente tutorCachorro) {
		this.tutorCachorro = tutorCachorro;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDadosAnimal() {
		return dadosAnimal;
	}

	public void setDadosAnimal(String dadosAnimal) {
		this.dadosAnimal = dadosAnimal;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	

}
