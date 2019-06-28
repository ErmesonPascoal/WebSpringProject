package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	@Id
	private String papel;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> pessoas;
	
	
	

	public List<Usuario> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Usuario> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	
	
	
	

}
