package com.ufc.br.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtilsProject {
	public static void salvarImagem(String caminho, MultipartFile imagem) {
		File file = new File(caminho);
		
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
