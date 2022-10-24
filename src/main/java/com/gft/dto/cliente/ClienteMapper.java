package com.gft.dto.cliente;
import com.gft.entities.Cliente;

public class ClienteMapper {
	
	public static Cliente fromDTO(RegistroClienteDTO dto) {
		return new Cliente(null, dto.getCpf(), dto.getNome(), dto.getTelefone(), dto.getEmail(), 
				dto.getListaCachorros(), dto.getListaAtendimentos());
	}
	
	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome(), 
				cliente.getTelefone(), cliente.getEmail());
	}

}
