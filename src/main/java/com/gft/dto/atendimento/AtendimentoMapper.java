package com.gft.dto.atendimento;

import com.gft.dto.cachorro.CachorroMapper;
import com.gft.dto.cliente.ClienteMapper;
import com.gft.dto.veterinario.VeterinarioMapper;
import com.gft.entities.Atendimento;

public class AtendimentoMapper {
	
	public static Atendimento fromDTO(RegistroAtendimentoDTO dto) {
		return new Atendimento(null, dto.getCachorro(), dto.getTutor(), dto.getVeterinario(), dto.getDataHora(),
				dto.getDadosAnimal(), dto.getDiagnostico(), dto.getComentarios());
	}
	
	
	public static ConsultaAtendimentoDTO fromEntity(Atendimento atendimento) {
		return new ConsultaAtendimentoDTO(atendimento.getId(), CachorroMapper.fromEntity(atendimento.getCachorro()), 
				ClienteMapper.fromEntity(atendimento.getTutorCachorro()), VeterinarioMapper.fromEntity(atendimento.getVeterinario()), 
				atendimento.getDataHora(), atendimento.getDadosAnimal(), atendimento.getDiagnostico(), 
				atendimento.getComentarios());
	}

}
