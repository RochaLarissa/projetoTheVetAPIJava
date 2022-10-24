package com.gft.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gft.dto.cachorro.CachorroMapper;
import com.gft.dto.cachorro.ConsultaCachorroDTO;
import com.gft.entities.Cachorro;
import com.gft.exceptions.EntityNotFoundException;
import com.gft.exceptions.NomeCachorroException;
import com.gft.repositories.CachorroRepository;

@Service
public class CachorroService {
	
	private final CachorroRepository cachorroRepository;

	public CachorroService(CachorroRepository cachorroRepository) {
		this.cachorroRepository = cachorroRepository;
	}
	
	public Cachorro salvarCachorro(Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }

    public List<Cachorro> listarTodosOsCachorros() {
        return cachorroRepository.findAll();
    }
	
    public Cachorro buscarCachorroPorId(Long id) throws EntityNotFoundException{
    	Optional<Cachorro> cachorro = cachorroRepository.findById(id);

        return cachorro.orElseThrow(() -> new EntityNotFoundException("Cachorro não encontrado!"));
    }

    public List<ConsultaCachorroDTO> buscarCachorroPorNome(String nome) throws NomeCachorroException{         
        List<ConsultaCachorroDTO> listaDto = new ArrayList<>();
    	List<Cachorro> listaCachorro = cachorroRepository.findByNomeContains(nome);
    	
    	for(int i = 0; i < listaCachorro.size(); i++) {
    		listaDto.add(CachorroMapper.fromEntity(listaCachorro.get(i)));    		
    	}
    	
        if(listaDto.isEmpty()) {
        	throw new NomeCachorroException("Cachorro não encontrado!");
        } 
        
        return listaDto;       	
        	
    }

    public Cachorro atualizarCachorro(Cachorro cachorro, Long id) {
    	Cachorro cachorroOriginal = this.buscarCachorroPorId(id);
    	cachorro.setId(cachorroOriginal.getId());

        return cachorroRepository.save(cachorro);
    }

	public void excluirCachorro(Long id) {

		cachorroRepository.deleteById(id);
    }

}
