package com.gft.dto.cachorro;
import com.gft.dto.cliente.ClienteMapper;
import com.gft.entities.Cachorro;

public class CachorroMapper {
	
	public static Cachorro fromDTO(RegistroCachorroDTO dto) {
		return new Cachorro(null, dto.getNome(), dto.getTutor(), dto.getNascimento(), dto.getRaca(), 
				dto.getListaAtendimentos(), dto.getInformacoes());
	}
	
	
	public static ConsultaCachorroDTO fromEntity(Cachorro cachorro) {
		return new ConsultaCachorroDTO(cachorro.getId(), cachorro.getNome(), ClienteMapper.fromEntity(cachorro.getTutor()), 
				cachorro.getNascimento(), cachorro.getRaca(), cachorro.getInformacoes());
	}

}
