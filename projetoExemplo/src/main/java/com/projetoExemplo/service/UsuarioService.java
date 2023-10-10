package com.projetoExemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoExemplo.entities.Usuario;
import com.projetoExemplo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> buscaTodosUsuarios(){
		return usuarioRepository.findAll();
	}
	public Usuario buscaUsuarioId(Long id) {
		Optional <Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public Usuario alterarUsuario(Long id,Usuario alterarU) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			alterarU.setId(id);
			return usuarioRepository.save(alterarU);
		}
		return null;
	}
		public boolean apagarUsuario(Long id) {
			Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
			if (existeUsuario.isPresent()) {
				usuarioRepository.deleteById(id);
				return true;
			}
			return false ;
		}
	}

