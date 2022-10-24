package com.gft.dto.cliente;

import java.util.Objects;

public class ConsultaClienteDTO {
	
	private Long id;
	private String cpf;	
	private String nome;
	private String telefone;	
	private String email;		
		
	
	public ConsultaClienteDTO() {		
	}	
		
	public ConsultaClienteDTO(Long id, String cpf, String nome, String telefone, String email) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@Override
	public String toString() {
		return "ConsultaClienteDTO [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaClienteDTO other = (ConsultaClienteDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}

	
	
	
}
