package com.ufc.br.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private List<Prato> pratos;
	private double preco = 0.0;
	
	private static Carrinho carrinho = null;
	
	private Carrinho() {
		pratos = new ArrayList<>();
	}
	
	public static Carrinho getInstance() {
		if(carrinho == null) {
			return new Carrinho();
		}
		return carrinho;
	}
	
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	
}
