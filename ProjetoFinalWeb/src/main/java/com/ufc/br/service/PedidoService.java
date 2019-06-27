package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.ufc.br.model.Pedido;
import com.ufc.br.model.Prato;
import com.ufc.br.repository.PedidoRepository;
import com.ufc.br.repository.PratoRepository;
import com.ufc.br.repository.UsuarioRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	Pedido pedido = new Pedido();
	
	public void addPratoNaListaDePedido(Prato prato) {
		
		//Pedido.pratos.add(prato);
		pedido.getPratos().add(prato);
		pedido.setValorTotalPedido(pedido.getValorTotalPedido()+prato.getPreco());
		
	}
	
	public void addListaDePedido() {
		pedido.setUsuario(usuarioRepository.getOne((long)16));
		pedidoRepository.save(pedido);
		pedido = null;
	}
	
	public void deletarPratoDaListaDePedido(Long idPrato) {
		
		for(Prato prato : pedido.getPratos()) {
			if(prato.getIdPrato() == idPrato) {
				pedido.getPratos().remove(prato);
				return;
			}
		}
		
		
	}
	
	public void deletarListaDePedido() {
		
		
		
	}
	
	public List<Prato> getPratos(){
		return pedido.getPratos();
	}
	
}
