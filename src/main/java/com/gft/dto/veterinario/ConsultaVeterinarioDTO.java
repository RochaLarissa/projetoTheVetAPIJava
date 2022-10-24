package com.gft.dto.veterinario;

public class ConsultaVeterinarioDTO {
	
	private Long id;
	private String crmv;	
	private String nome;
	private String telefone;		
	private String email;	
	private String especialidade;
	
	public ConsultaVeterinarioDTO() {		
	}	

	public ConsultaVeterinarioDTO(Long id, String crmv, String nome, String telefone, String email,
			String especialidade) {
		this.id = id;
		this.crmv = crmv;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
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

	@Override
	public String toString() {
		return "ConsultaVeterinarioDTO [id=" + id + ", crmv=" + crmv + ", nome=" + nome + ", telefone=" + telefone
				+ ", email=" + email + ", especialidade=" + especialidade + "]";
	}

	
	
}
