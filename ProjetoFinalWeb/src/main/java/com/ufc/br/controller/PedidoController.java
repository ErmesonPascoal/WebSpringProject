package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Prato;
import com.ufc.br.service.PedidoService;
import com.ufc.br.service.PratoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PratoService pratoService;
	
	@RequestMapping("/addPratoNaLista/{id}")
	public ModelAndView addPratoNaListaDePedido(@PathVariable Long id) {
		
		pedidoService.addPratoNaListaDePedido(pratoService.buscarPrato(id));
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		mv.addObject("listaDePratosNoPedido", pedidoService.getPratos());
		return mv;
		
	}
	
	@RequestMapping("/addPedido")
	public ModelAndView addListaDePedido() {
		pedidoService.addListaDePedido();
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		return mv;
		
	}
	
	@RequestMapping("/deletarPratoDaLista/{idPrato}")
	public ModelAndView deletarPratoDaListaDePedido(@PathVariable Long idPrato) {
		pedidoService.deletarPratoDaListaDePedido(idPrato);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		mv.addObject("listaDePratosNoPedido", pedidoService.getPratos());
		return mv;
		
	}
	
	@RequestMapping("/deletarPedido")
	public ModelAndView deletarListaDePedido() {
		
		ModelAndView mv = new ModelAndView("listagemPratos");
		return mv;
		
	}
	
}
