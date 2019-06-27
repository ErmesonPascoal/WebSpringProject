package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/cadastrarse")
	public ModelAndView cadastrarse() {
		ModelAndView mv = new ModelAndView("cadastrarse");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@RequestMapping("/cadastrarse/salvarUsuario")
	public ModelAndView salvarUsuario(Usuario usuario) {
		
		usuarioService.cadastrarUsuario(usuario);
		ModelAndView mv = new ModelAndView("redirect:/listarUsuarios");
		return mv;
	}
	
	@RequestMapping("/listarUsuarios")
	public ModelAndView listarUsuarios() { 
		List<Usuario> usuarios = usuarioService.getUsuarios();
		ModelAndView mv = new ModelAndView("listagemUsuarios");
		mv.addObject("listaDeUsuarios", usuarios);
		return mv;
	}
	
	@RequestMapping("/deletarUsuario/{id}")
	public ModelAndView deletarUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		ModelAndView mv = new ModelAndView("redirect:/listarUsuarios");
		
		return mv;
	}
	
	@RequestMapping("/alterarUsuario/{id}")
	public ModelAndView alterarUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuario(id);
		ModelAndView mv = new ModelAndView("cadastrarse");
		mv.addObject("usuario",usuario);
		return mv;
	}
	

}
