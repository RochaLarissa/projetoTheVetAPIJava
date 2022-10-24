package com.gft.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.atendimento.AtendimentoMapper;
import com.gft.dto.atendimento.ConsultaAtendimentoDTO;
import com.gft.dto.atendimento.RegistroAtendimentoDTO;
import com.gft.entities.Atendimento;
import com.gft.services.AtendimentoService;

@RestController
@RequestMapping("v1/atendimentos")
public class AtendimentoController {
	
	private final AtendimentoService atendimentoService;
	
	public AtendimentoController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}
	
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
	public ResponseEntity<List<ConsultaAtendimentoDTO>> buscarTodosOsAtendimentos(@PageableDefault Pageable pageable) {
				
		return ResponseEntity.ok(atendimentoService.listarTodosOsAtendimentos().stream().
				map(AtendimentoMapper::fromEntity).collect(Collectors.toList()));
	}
	
	
	@PostMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaAtendimentoDTO> salvarAtendimento(@RequestBody RegistroAtendimentoDTO dto) {		
			try {
				Atendimento atendimento = atendimentoService.salvarAtendimento(AtendimentoMapper.fromDTO(dto));			
				return ResponseEntity.ok(AtendimentoMapper.fromEntity(atendimento));
			} catch (RuntimeException ex) {
				return ResponseEntity.notFound().build();
			}		
    }

    @GetMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaAtendimentoDTO> buscarAtendimentoPorId(@PathVariable Long id) {

    	Atendimento atendimento = atendimentoService.buscarAtendimentoPorId(id);
        return ResponseEntity.ok(AtendimentoMapper.fromEntity(atendimento));        
    }
    
    @DeleteMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaAtendimentoDTO> excluirAtendimento(@PathVariable Long id){
    	try {    		   		
    		atendimentoService.excluirAtendimento(id);    		    		
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    

}
