package com.gft.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gft.entities.ArquivoMorto;
import com.gft.exceptions.EntityNotFoundException;
import com.gft.repositories.ArquivoMortoRepository;

@Service
public class ArquivoMortoService {
	
	private final ArquivoMortoRepository arquivoMortoRepository;

	public ArquivoMortoService(ArquivoMortoRepository arquivoMortoRepository) {
		this.arquivoMortoRepository = arquivoMortoRepository;
	}
	
	public ArquivoMorto salvarArquivoMorto(ArquivoMorto arquivoMorto) {
		return arquivoMortoRepository.save(arquivoMorto);
	}
	
	public List<ArquivoMorto> listarTodosOsArquivosMortos() {
		return arquivoMortoRepository.findAll();
	}
	
	public ArquivoMorto buscarArquivoMortoPorId(Long id) throws EntityNotFoundException{
    	Optional<ArquivoMorto> arquivoMorto = arquivoMortoRepository.findById(id);

        return arquivoMorto.orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado!"));
    }
	

}
