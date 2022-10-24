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
import com.gft.dto.cachorro.RegistroCachorroDTO;
import com.gft.entities.Atendimento;
import com.gft.entities.Cachorro;
import com.gft.entities.Usuario;
import com.gft.services.CachorroService;


@RestController
@RequestMapping("v1/cachorros")
public class CachorroController {
	
	private final CachorroService cachorroService;
	
	public CachorroController(CachorroService cachorroService) {
		this.cachorroService = cachorroService;
	}
	
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
	public ResponseEntity<List<ConsultaCachorroDTO>> buscarTodosOsCachorros(@PageableDefault Pageable pageable) {
				
		return ResponseEntity.ok(cachorroService.listarTodosOsCachorros().stream().
				map(CachorroMapper::fromEntity).collect(Collectors.toList()));
	}
		
	@PostMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaCachorroDTO> salvarCachorro(@RequestBody RegistroCachorroDTO dto) {
		
		Cachorro cachorro = cachorroService.salvarCachorro(CachorroMapper.fromDTO(dto));
        return ResponseEntity.ok(CachorroMapper.fromEntity(cachorro));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaCachorroDTO> buscarCachorroPorId(@PathVariable Long id) {
    	
    	Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Cachorro cachorro = cachorroService.buscarCachorroPorId(id);
    	
    	if (usuario.getPerfil().getNome().equals("Admin") || usuario.getCliente().getId().equals(cachorro.getTutor().getId())) {
    		return ResponseEntity.ok(CachorroMapper.fromEntity(cachorro));       		
    	} else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    }

    @GetMapping("/nome/{nome}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<List<ConsultaCachorroDTO>> buscarCachorroPorNome(@PathVariable String nome) {

    	List<ConsultaCachorroDTO> listaCachorro = cachorroService.buscarCachorroPorNome(nome);
        return ResponseEntity.ok(listaCachorro);        
    }

    @PutMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaCachorroDTO> alterarCachorro(@PathVariable Long id, @RequestBody RegistroCachorroDTO dto) {
        
    	Cachorro cachorro = cachorroService.atualizarCachorro(CachorroMapper.fromDTO(dto), id);
        return ResponseEntity.ok(CachorroMapper.fromEntity(cachorro));        
    }

    @DeleteMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaCachorroDTO> excluirCachorro(@PathVariable Long id) {
        try {
        	cachorroService.excluirCachorro(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listarAtendimentos/{id}")
    public ResponseEntity<Set<ConsultaAtendimentoDTO>> listarTodosOsAtendimentosDeCachorroPorID(@PathVariable Long id) {
    	
    	Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Cachorro cachorro = cachorroService.buscarCachorroPorId(id);
    	
    	if (usuario.getPerfil().getNome().equals("Admin") || usuario.getCliente().getId().equals(cachorro.getTutor().getId())) {
    		Set<Atendimento> setAtendimento = cachorroService.buscarCachorroPorId(id).getListaAtendimentos();
    		Set<ConsultaAtendimentoDTO> setAtendimentoDto = new HashSet<>();
    		
    		Iterator<Atendimento> atendimentoIterator = setAtendimento.iterator();
    		while(atendimentoIterator.hasNext()) {
    			Atendimento atendimento = atendimentoIterator.next();
    			setAtendimentoDto.add(AtendimentoMapper.fromEntity(atendimento));
    		}
    		
    		return ResponseEntity.ok().body(setAtendimentoDto);
    		
    	}else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    	
    }

    
    
}