package com.gft.dto.atendimento;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gft.dto.cachorro.ConsultaCachorroDTO;
import com.gft.dto.cliente.ConsultaClienteDTO;
import com.gft.dto.veterinario.ConsultaVeterinarioDTO;

public class ConsultaAtendimentoDTO {
	
	private Long id;
	
	private ConsultaCachorroDTO cachorro;
	
	private ConsultaClienteDTO tutorCachorro;
	
	private ConsultaVeterinarioDTO veterinario;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataHora;
		
	private String dadosAnimal;	
	
	private String diagnostico;
	
	private String comentarios;	
	
	public ConsultaAtendimentoDTO() {
	}
			
	public ConsultaAtendimentoDTO(Long id, ConsultaCachorroDTO cachorro, ConsultaClienteDTO tutorCachorro,
			ConsultaVeterinarioDTO veterinario, LocalDateTime dataHora, String dadosAnimal, String diagnostico,
			String comentarios) {
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

	public ConsultaCachorroDTO getCachorro() {
		return cachorro;
	}

	public void setCachorro(ConsultaCachorroDTO cachorro) {
		this.cachorro = cachorro;
	}

	public ConsultaClienteDTO getTutorCachorro() {
		return tutorCachorro;
	}

	public void setTutorCachorro(ConsultaClienteDTO tutorCachorro) {
		this.tutorCachorro = tutorCachorro;
	}

	public ConsultaVeterinarioDTO getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(ConsultaVeterinarioDTO veterinario) {
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

	@Override
	public String toString() {
		return "ConsultaAtendimentoDTO [id=" + id + ", cachorro=" + cachorro + ", tutorCachorro=" + tutorCachorro
				+ ", veterinario=" + veterinario + ", dataHora=" + dataHora + ", dadosAnimal=" + dadosAnimal
				+ ", diagnostico=" + diagnostico + ", comentarios=" + comentarios + "]";
	}
	
	

}
