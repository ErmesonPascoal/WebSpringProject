package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Prato;
import com.ufc.br.repository.PratoRepository;
import com.ufc.br.util.FileUtilsProject;

@Service
public class PratoService {
	@Autowired
	private PratoRepository pratoRepository;
	
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		String caminho = "img/" + imagem.getOriginalFilename();
		prato.setNomeImagem(imagem.getOriginalFilename());
		FileUtilsProject.salvarImagem(caminho, imagem);
		pratoRepository.save(prato);
	}
	
	public List<Prato> getPratos(){
		return pratoRepository.findAll();
	}
	
	public void deletarPrato(Long id) {
		pratoRepository.deleteById(id);
	}
	
	public Prato buscarPrato(Long id) {
		return pratoRepository.getOne(id);
	}
	
}
