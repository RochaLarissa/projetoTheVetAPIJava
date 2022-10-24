package com.gft.entities;
import java.util.Objects;
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
@Table(name = "clientes")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	private String email;
	
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Cachorro> listaCachorros;

	@OneToMany(mappedBy = "tutorCachorro", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Atendimento> listaAtendimentos;
		
		
	public Cliente() {
	}
		
	public Cliente(Long id, String cpf, String nome, String telefone, String email, Set<Cachorro> listaCachorros, Set<Atendimento> listaAtendimentos) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.listaCachorros = listaCachorros;
		this.listaAtendimentos = listaAtendimentos;
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
	
	public Set<Cachorro> getListaCachorros() {
		return listaCachorros;
	}
	public void setListaCachorros(Set<Cachorro> listaCachorros) {
		this.listaCachorros = listaCachorros;
	}

	public Set<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}

	public void setListaAtendimentos(Set<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", listaCachorros=" + listaCachorros + ", listaAtendimentos=" + listaAtendimentos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, listaAtendimentos, listaCachorros, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(listaAtendimentos, other.listaAtendimentos)
				&& Objects.equals(listaCachorros, other.listaCachorros) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	
	
	
}
