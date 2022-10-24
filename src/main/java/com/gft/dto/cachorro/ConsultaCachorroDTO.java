package com.gft.dto.cachorro;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gft.dto.cliente.ConsultaClienteDTO;

public class ConsultaCachorroDTO {
	
	private Long id;
	
	private String nome;	
	
	private ConsultaClienteDTO tutor;
	
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate nascimento;
	
	private String raca;		
	
	private String informacoes;
	
	public ConsultaCachorroDTO() {		
	}	
	
	public ConsultaCachorroDTO(Long id, String nome, ConsultaClienteDTO tutor, LocalDate nascimento, String raca,
			String informacoes) {
		this.id = id;
		this.tutor = tutor;
		this.nome = nome;
		this.nascimento = nascimento;
		this.raca = raca;
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

	public ConsultaClienteDTO getTutor() {
		return tutor;
	}

	public void setTutor(ConsultaClienteDTO tutor) {
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

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	@Override
	public String toString() {
		return "ConsultaCachorroDTO [id=" + id + ", nome=" + nome + ", tutor=" + tutor + ", nascimento=" + nascimento
				+ ", raca=" + raca + ", informacoes=" + informacoes + "]";
	}

	

	
	

}
