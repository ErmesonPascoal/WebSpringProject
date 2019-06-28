package com.ufc.br.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Carrinho;
import com.ufc.br.model.Pedido;
import com.ufc.br.model.Prato;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.PedidoService;
import com.ufc.br.service.PratoService;
import com.ufc.br.service.UsuarioService;
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PratoService pratoService;
	@Autowired
	private UsuarioService usuarioService;
	
	Carrinho carrinho = Carrinho.getInstance();
	
	@RequestMapping("/addPratoNaLista/{idPrato}")
	public ModelAndView addPratoNaListaDePedido(@PathVariable Long idPrato) {
		Prato prato = pratoService.buscarPrato(idPrato);
		List<Prato> pratos = pratoService.getPratos();
		carrinho.getPratos().add(prato);
		carrinho.setPreco(carrinho.getPreco()+prato.getPreco());
		ModelAndView mv = new ModelAndView("listagemPratos");
		mv.addObject("listaDePratosNoPedido", carrinho.getPratos());
		mv.addObject("preco", carrinho.getPreco());
		mv.addObject("listaDePratos", pratos);
		return mv;
		
	}
	
	@RequestMapping("/addPedido")
	public ModelAndView addListaDePedido() {
		Pedido pedido = new Pedido();
		
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario usuario = usuarioService.buscarPorNome(user.getUsername());
		
		pedido.setUsuario(usuario);
		pedido.setPratos(carrinho.getPratos());
		pedido.setValorTotalPedido(carrinho.getPreco());
		pedidoService.addListaDePedido(pedido);
		carrinho.setPratos(new ArrayList<>());;
		carrinho.setPreco(0.0);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		return mv;
		
	}
	
	@RequestMapping("/deletarPratoDaLista/{idPrato}")
	public ModelAndView deletarPratoDaListaDePedido(@PathVariable Long idPrato) {
		List<Prato> pratos = pratoService.getPratos();
		ModelAndView mv = new ModelAndView("listagemPratos");
		for(Prato prato : carrinho.getPratos()) {
			if(prato.getIdPrato() == idPrato) {
				carrinho.setPreco(carrinho.getPreco()-prato.getPreco());
				carrinho.getPratos().remove(prato);
				mv.addObject("listaDePratosNoPedido", carrinho.getPratos());
				mv.addObject("preco", carrinho.getPreco());
				mv.addObject("listaDePratos", pratos);
				return mv;
			}
		}
		
		return mv;
		
	}
	
	@RequestMapping("/deletarPedido")
	public ModelAndView deletarListaDePedido() {
		
		ModelAndView mv = new ModelAndView("listagemPratos");
		return mv;
		
	}
	
}
