package com.gft.controllers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gft.dto.atendimento.AtendimentoMapper;
import com.gft.dto.atendimento.ConsultaAtendimentoDTO;
import com.gft.dto.cachorro.CachorroMapper;
import com.gft.dto.cachorro.ConsultaCachorroDTO;
import com.gft.dto.cliente.ClienteMapper;
import com.gft.dto.cliente.ConsultaClienteDTO;
import com.gft.dto.cliente.RegistroClienteDTO;
import com.gft.entities.Atendimento;
import com.gft.entities.Cachorro;
import com.gft.entities.Cliente;
import com.gft.entities.Usuario;
import com.gft.services.ClienteService;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<ConsultaClienteDTO>> buscarTodosOsClientes(@PageableDefault Pageable pageable) {
				
		return ResponseEntity.ok(clienteService.listarTodosOsClientes().stream().
				map(ClienteMapper::fromEntity).collect(Collectors.toList()));
	}
	
	
	@PostMapping
    public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody RegistroClienteDTO dto) {
		
		Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(dto));
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));		
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaClienteDTO> buscarClientePorId(@PathVariable Long id) {    
    	
    	Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Cliente cliente = clienteService.buscarClientePorId(id);
    	    	
    	if (usuario.getPerfil().getNome().equals("Admin") || usuario.getCliente().getId().equals(cliente.getId()) ) {    		
    		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));    
    	} else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();    	    		
    	}
    	
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ConsultaClienteDTO>> buscarClientePorNome(@PathVariable String nome) {
	
		List<ConsultaClienteDTO> listaCliente = clienteService.buscarClientePorNome(nome);
		return ResponseEntity.ok(listaCliente);		      
    }

    @PutMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaClienteDTO> alterarCliente(@PathVariable Long id, @RequestBody RegistroClienteDTO dto) {
        
    	Cliente cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));            
    }

    @DeleteMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaClienteDTO> excluirCliente(@PathVariable Long id) {
        try {
        	clienteService.excluirCliente(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listarCachorros/{id}")
    public ResponseEntity<Set<ConsultaCachorroDTO>> listarCachorrosDeClientePorId(@PathVariable Long id) {  
    	
    	Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Cliente cliente = clienteService.buscarClientePorId(id);
    	    	
    	if (usuario.getPerfil().getNome().equals("Admin") || usuario.getCliente().getId().equals(cliente.getId()) ) {   
    	
	    	Set<Cachorro> setCachorros = clienteService.buscarClientePorId(id).getListaCachorros();
	    	Set<ConsultaCachorroDTO> setCachorrosDto = new HashSet<>();
	    	        
	        Iterator<Cachorro> cachorroIterator = setCachorros.iterator();
	        while(cachorroIterator.hasNext()) {
	        	Cachorro cachorro = cachorroIterator.next();
	        	setCachorrosDto.add(CachorroMapper.fromEntity(cachorro));
	        }
	                        
	        return ResponseEntity.ok().body(setCachorrosDto);
    	} else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    }

    @GetMapping("/listarAtendimentos/{id}")
    public ResponseEntity<Set<ConsultaAtendimentoDTO>> listarTodosOsAtendimentosDeClientePorID(@PathVariable Long id) {
        
    	Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Cliente cliente = clienteService.buscarClientePorId(id);
    	    	
    	if (usuario.getPerfil().getNome().equals("Admin") || usuario.getCliente().getId().equals(cliente.getId()) ) {   
    	
	    	Set<Atendimento> setAtendimento = clienteService.buscarClientePorId(id).getListaAtendimentos();
	        Set<ConsultaAtendimentoDTO> setAtendimentoDto = new HashSet<>();
	        
	        Iterator<Atendimento> atendimentoIterator = setAtendimento.iterator();
	        while(atendimentoIterator.hasNext()) {
	        	Atendimento atendimento = atendimentoIterator.next();
	        	setAtendimentoDto.add(AtendimentoMapper.fromEntity(atendimento));
	        }
	                
	        return ResponseEntity.ok().body(setAtendimentoDto);
    	} else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    }
    
}
