package com.gft.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gft.dto.veterinario.ConsultaVeterinarioDTO;
import com.gft.dto.veterinario.VeterinarioMapper;
import com.gft.entities.Veterinario;
import com.gft.exceptions.EntityNotFoundException;
import com.gft.exceptions.NomeVeterinarioException;
import com.gft.exceptions.VeterinarioException;
import com.gft.repositories.VeterinarioRepository;

@Service
public class VeterinarioService {
	
	private final VeterinarioRepository veterinarioRepository;

	public VeterinarioService(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}
	
	public Veterinario salvarVeterinario(Veterinario veterinario) throws VeterinarioException{
		List<Veterinario> listaVeterinario = veterinarioRepository.findAll();
        List<String> listaCrmvVeterinario = new ArrayList<>();
        for(int i = 0; i < listaVeterinario.size(); i++) {
        	listaCrmvVeterinario.add(listaVeterinario.get(i).getCrmv());
        }
        		
		if(listaCrmvVeterinario.contains(veterinario.getCrmv())) {
			throw new VeterinarioException("CRMV já cadastrado");
		}
        		
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodosOsVeterinarios() {
        return veterinarioRepository.findAll();
    }
	
    public Veterinario buscarVeterinarioPorId(Long id) throws EntityNotFoundException{
    	Optional<Veterinario> veterinario = veterinarioRepository.findById(id);

        return veterinario.orElseThrow(() -> new EntityNotFoundException("Veterinário não encontrado!"));
    }

    public List<ConsultaVeterinarioDTO> buscarVeterinarioPorNome(String nome) throws NomeVeterinarioException{
    	List<ConsultaVeterinarioDTO> listaDto = new ArrayList<>();
    	List<Veterinario> listaVeterinario = veterinarioRepository.findByNomeContains(nome);
    	
    	for(int i = 0; i < listaVeterinario.size(); i++) {
    		listaDto.add(VeterinarioMapper.fromEntity(listaVeterinario.get(i)));    		
    	}
    	
        if(listaDto.isEmpty()) {
        	throw new NomeVeterinarioException("Veterinário não encontrado!");
        } 
        
        return listaDto;      
    }

    public Veterinario atualizarVeterinario(Veterinario veterinario, Long id) throws VeterinarioException{
    	Veterinario veterinarioOriginal = this.buscarVeterinarioPorId(id);
    	veterinario.setId(veterinarioOriginal.getId());
    	
    	return veterinarioRepository.save(veterinario);
    }

	public void excluirVeterinario(Long id) {

		veterinarioRepository.deleteById(id);
    }

}
