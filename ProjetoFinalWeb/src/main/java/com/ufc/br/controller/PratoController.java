package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Carrinho;
import com.ufc.br.model.Prato;
import com.ufc.br.service.PratoService;

@Controller
public class PratoController {
	@Autowired
	private PratoService pratoService; 
	
	Carrinho carrinho = Carrinho.getInstance();
	
	@RequestMapping("/pratos")
	public ModelAndView listarPratos() {
		List<Prato> pratos = pratoService.getPratos();
		ModelAndView mv = new ModelAndView("listagemPratos");
		mv.addObject("listaDePratosNoPedido", carrinho.getPratos());
		mv.addObject("preco", carrinho.getPreco());
		mv.addObject("listaDePratos", pratos);
		return mv;
	}
	
	@RequestMapping("/cadastrarPratos")
	public ModelAndView cadastroPratos() {
		ModelAndView mv = new ModelAndView("cadastrarPrato");
		mv.addObject("prato", new Prato());
		return mv;
	}
	@RequestMapping("/cadastrarPratos/salvarPrato")
	public ModelAndView salvarPrato(Prato prato, @RequestParam(value="imagem") MultipartFile imagem) {
		
		pratoService.cadastrarPrato(prato, imagem);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		
		return mv;
	}
	
	@RequestMapping("/deletarPratos/{idPrato}")
	public ModelAndView deletarPratos(@PathVariable Long idPrato) {
		pratoService.deletarPrato(idPrato);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		return mv;
		
	}
	
	@RequestMapping("/alterarPratos/{idPrato}")
	public ModelAndView alterarPratos(@PathVariable Long idPrato) {
		Prato prato= pratoService.buscarPrato(idPrato);
		ModelAndView mv = new ModelAndView("cadastrarPrato");
		mv.addObject("prato", prato);
		return mv;
		
	}
}
