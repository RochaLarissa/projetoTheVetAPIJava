package com.gft.dto.veterinario;
import com.gft.entities.Veterinario;

public class VeterinarioMapper {
	
	public static Veterinario fromDTO(RegistroVeterinarioDTO dto) {
		return new Veterinario(null, dto.getCrmv(), dto.getNome(), dto.getTelefone(), dto.getEmail(), 
				dto.getEspecialidade(), dto.getListaAtendimentos());
	}
	
	public static ConsultaVeterinarioDTO fromEntity(Veterinario veterinario) {
		return new ConsultaVeterinarioDTO(veterinario.getId(), veterinario.getCrmv(), veterinario.getNome(), veterinario.getTelefone(),
				veterinario.getEmail(), veterinario.getEspecialidade());
	}

}
