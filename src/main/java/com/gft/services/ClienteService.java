package com.gft.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.gft.dto.cliente.ClienteMapper;
import com.gft.dto.cliente.ConsultaClienteDTO;
import com.gft.entities.Cliente;
import com.gft.exceptions.ClienteException;
import com.gft.exceptions.EntityNotFoundException;
import com.gft.exceptions.NomeClienteException;
import com.gft.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvarCliente(Cliente cliente) throws ClienteException{
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<String> listaCpfClientes = new ArrayList<>();
        for(int i = 0; i < listaClientes.size(); i++) {
        	listaCpfClientes.add(listaClientes.get(i).getCpf());
        }
        		
		if(listaCpfClientes.contains(cliente.getCpf())) {
			throw new ClienteException("CPF já cadastrado");
		}
        
		return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodosOsClientes() {
        return clienteRepository.findAll();
    }
	
    public Cliente buscarClientePorId(Long id) throws EntityNotFoundException{
    	Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
    }

    public List<ConsultaClienteDTO> buscarClientePorNome(String nome) throws NomeClienteException{
    	List<ConsultaClienteDTO> listaDto = new ArrayList<>();
    	List<Cliente> listaCliente = clienteRepository.findByNomeContains(nome);
    	
    	for(int i = 0; i < listaCliente.size(); i++) {
    		listaDto.add(ClienteMapper.fromEntity(listaCliente.get(i)));    		
    	}
    	
        if(listaDto.isEmpty()) {
        	throw new NomeClienteException("Cliente não encontrado!");
        } 
        
        return listaDto;       	
        	
        
    }

    public Cliente atualizarCliente(Cliente cliente, Long id) throws ClienteException{
    	Cliente clienteOriginal = this.buscarClientePorId(id);
    	cliente.setId(clienteOriginal.getId());

        return clienteRepository.save(cliente);
    }

	public void excluirCliente(Long id) {

		clienteRepository.deleteById(id);
    }
	
	

}
