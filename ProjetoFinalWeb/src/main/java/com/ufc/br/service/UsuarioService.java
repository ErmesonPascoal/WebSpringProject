package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}

	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	public Usuario buscarUsuario(Long id) {
		return usuarioRepository.getOne(id);
		
	}
}
