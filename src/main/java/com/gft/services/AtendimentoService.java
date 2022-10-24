package com.gft.services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.gft.dto.atendimento.AtendimentoMapper;
import com.gft.entities.ArquivoMorto;
import com.gft.entities.Atendimento;
import com.gft.exceptions.EntityNotFoundException;
import com.gft.repositories.AtendimentoRepository;


@Service
public class AtendimentoService {
	
	private final AtendimentoRepository atendimentoRepository;
	private final ArquivoMortoService arquivoMortoService;


	public AtendimentoService(AtendimentoRepository atendimentoRepository, ArquivoMortoService arquivoMortoService) {
		this.atendimentoRepository = atendimentoRepository;
		this.arquivoMortoService = arquivoMortoService;
	}
	
	public Atendimento salvarAtendimento(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listarTodosOsAtendimentos() {
        return atendimentoRepository.findAll();
    }
	
    public Atendimento buscarAtendimentoPorId(Long id) throws EntityNotFoundException{
    	Optional<Atendimento> atendimento = atendimentoRepository.findById(id);

        return atendimento.orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado!"));
    }
    
    public void excluirAtendimento(Long id) {
    	Atendimento atendimento = this.buscarAtendimentoPorId(id);
		ArquivoMorto arquivo = new ArquivoMorto(null, AtendimentoMapper.fromEntity(atendimento).toString(), LocalDateTime.now());
		arquivoMortoService.salvarArquivoMorto(arquivo);
		    	
    	atendimentoRepository.deleteById(id);
    }

	

}
