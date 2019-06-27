package com.ufc.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPrato;
	private String nome;
	private double preco;
	private String nomeImagem;
	
	
	public Long getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(Long idPrato) {
		this.idPrato = idPrato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNomeImagem() {
		return nomeImagem;
	}
	public void setNomeImagem(String idImagem) {
		this.nomeImagem = idImagem;
	}
	
	
	
}
