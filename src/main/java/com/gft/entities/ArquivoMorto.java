package com.gft.entities;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "arquivo_morto")
public class ArquivoMorto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 2000)
	private String atendimento;
	
	private LocalDateTime dataExclusao;	
	
	public ArquivoMorto() {
	}

	public ArquivoMorto(Long id, String atendimento, LocalDateTime dataExclusao) {
		this.id = id;
		this.atendimento = atendimento;
		this.dataExclusao = dataExclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public LocalDateTime getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(LocalDateTime dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	

}
