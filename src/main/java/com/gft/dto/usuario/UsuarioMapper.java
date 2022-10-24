package com.gft.dto.usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.dto.cliente.ClienteMapper;
import com.gft.entities.Cliente;
import com.gft.entities.Perfil;
import com.gft.entities.Usuario;


public class UsuarioMapper {
	
	public static Usuario fromDTO(RegistroUsuarioDTO dto) {
		
		Perfil perfil = new Perfil();
		perfil.setId(dto.getPerfilId());
		
		Cliente cliente = new Cliente();
		cliente.setId(dto.getClienteId());
		
		return new Usuario(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()), perfil, cliente);
		
	}
	
	public static ConsultaUsuarioDTO fromEntity(Usuario usuario) {
		
		return new ConsultaUsuarioDTO(usuario.getEmail(), usuario.getPerfil().getNome(), ClienteMapper.fromEntity(usuario.getCliente()));
		
	}

}
