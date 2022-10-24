package com.gft.controllers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.gft.dto.veterinario.ConsultaVeterinarioDTO;
import com.gft.dto.veterinario.RegistroVeterinarioDTO;
import com.gft.dto.veterinario.VeterinarioMapper;
import com.gft.entities.Atendimento;
import com.gft.entities.Veterinario;
import com.gft.services.VeterinarioService;

@RestController
@RequestMapping("v1/veterinarios")
public class VeterinarioController {

	
	private final VeterinarioService veterinarioService;
	
	public VeterinarioController(VeterinarioService veterinarioService) {
		this.veterinarioService = veterinarioService;
	}
	
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
	public ResponseEntity<List<ConsultaVeterinarioDTO>> buscarTodosOsVeterinarios(@PageableDefault Pageable pageable) {
				
		return ResponseEntity.ok(veterinarioService.listarTodosOsVeterinarios().stream().
				map(VeterinarioMapper::fromEntity).collect(Collectors.toList()));
	}
	
	
	@PostMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaVeterinarioDTO> salvarVeterinario(@RequestBody RegistroVeterinarioDTO dto) {
		
		Veterinario veterinario = veterinarioService.salvarVeterinario(VeterinarioMapper.fromDTO(dto));
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinario));
    }

    @GetMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaVeterinarioDTO> buscarVeterinarioPorId(@PathVariable Long id) {
    	Veterinario veterinario = veterinarioService.buscarVeterinarioPorId(id);
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinario));        
    }

    @GetMapping("/nome/{nome}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<List<ConsultaVeterinarioDTO>> buscarVeterinarioPorNome(@PathVariable String nome) {

    	List<ConsultaVeterinarioDTO> listaVeterinario = veterinarioService.buscarVeterinarioPorNome(nome);
        return ResponseEntity.ok(listaVeterinario);        
    }

    @PutMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaVeterinarioDTO> alterarVeterinario(@PathVariable Long id, @RequestBody RegistroVeterinarioDTO dto) {
        
    	Veterinario veterinario = veterinarioService.atualizarVeterinario(VeterinarioMapper.fromDTO(dto), id);
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinario));    
    }

    @DeleteMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ConsultaVeterinarioDTO> excluirVeterinario(@PathVariable Long id) {
        try {
        	veterinarioService.excluirVeterinario(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listarAtendimentos/{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<Set<ConsultaAtendimentoDTO>> listarTodosOsAtendimentosDeVeterinariooPorID(@PathVariable Long id) {
        Set<Atendimento> setAtendimento = veterinarioService.buscarVeterinarioPorId(id).getListaAtendimentos();
        Set<ConsultaAtendimentoDTO> setAtendimentoDto = new HashSet<>();
        
        Iterator<Atendimento> atendimentoIterator = setAtendimento.iterator();
        while(atendimentoIterator.hasNext()) {
        	Atendimento atendimento = atendimentoIterator.next();
        	setAtendimentoDto.add(AtendimentoMapper.fromEntity(atendimento));
        }
                
        return ResponseEntity.ok().body(setAtendimentoDto);
    }
    
    
}
