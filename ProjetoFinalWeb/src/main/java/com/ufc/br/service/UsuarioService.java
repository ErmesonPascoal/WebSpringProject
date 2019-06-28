package com.ufc.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Role;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarUsuario(Usuario usuario) {
		Role role = new Role();
		role.setPapel("ROLE_CLIENTE");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		usuario.setRoles(roles);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
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

	public Usuario buscarPorNome(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByNome(username);
	}
}
