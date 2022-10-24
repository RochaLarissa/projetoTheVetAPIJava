package com.gft.dto.atendimento;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gft.entities.Cachorro;
import com.gft.entities.Cliente;
import com.gft.entities.Veterinario;

public class RegistroAtendimentoDTO {
	
	private Cachorro cachorro;
	
	private Cliente tutor;
	
	private Veterinario veterinario;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataHora = LocalDateTime.now();
		
	private String dadosAnimal;	
	
	private String diagnostico;
	
	private String comentarios;
		
		
	public RegistroAtendimentoDTO(Cachorro cachorro, Cliente tutor, Veterinario veterinario, 
			String dadosAnimal, String diagnostico, String comentarios) {
		this.cachorro = cachorro;
		this.tutor = tutor;
		this.veterinario = veterinario;
		this.dadosAnimal = dadosAnimal;
		this.diagnostico = diagnostico;
		this.comentarios = comentarios;
	}
	
		
	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	public Cliente getTutor() {
		return tutor;
	}

	public void setTutor(Cliente tutor) {
		this.tutor = tutor;
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
