package com.ufc.br.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Pedido;
import com.ufc.br.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	
	
	public void addListaDePedido(Pedido pedido) {
		
		pedidoRepository.save(pedido);
	}
	
	public void deletarListaDePedido() {
		
		
		
	}
	
}
