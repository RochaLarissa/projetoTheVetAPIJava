package com.gft.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.entities.ArquivoMorto;
import com.gft.services.ArquivoMortoService;

@RestController
@RequestMapping("v1/arquivoMorto")
public class ArquivoMortoController {
	
	private final ArquivoMortoService arquivoMortoService;
	
	public ArquivoMortoController(ArquivoMortoService arquivoMortoService) {
		this.arquivoMortoService = arquivoMortoService;
	}
	
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('Admin')")
	public ResponseEntity<List<ArquivoMorto>> buscarTodosOsAtendimentosExcluidos(@PageableDefault Pageable pageable) {
				
		return ResponseEntity.ok(arquivoMortoService.listarTodosOsArquivosMortos().stream().
				collect(Collectors.toList()));
	}
		

    @GetMapping("{id}")
    @PreAuthorize(value = "hasAuthority('Admin')")
    public ResponseEntity<ArquivoMorto> buscarArquivoMortoPorId(@PathVariable Long id) {
  	
        return ResponseEntity.ok(arquivoMortoService.buscarArquivoMortoPorId(id));        
    }

    

}
