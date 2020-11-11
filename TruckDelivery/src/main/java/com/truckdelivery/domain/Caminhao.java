package com.truckdelivery.domain;

import java.util.ArrayList;
import java.util.List;

public class Caminhao {
	
	private Integer id;
	private String  nome;
	private Integer caminhaoModelo;
	
	private List<Caminhao>caminhoes = new ArrayList<>();
	
	public Caminhao() {
		
	}
	//CONSTRUTOR COM PARAMETROS
	public Caminhao(Integer id, String nome, Integer caminhaoModelo) {
		super();
		this.id = id;
		this.nome = nome;
		this.caminhaoModelo = caminhaoModelo;
	}
	
	//GETTER E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCaminhaoModelo() {
		return caminhaoModelo;
	}

	public void setCaminhaoModelo(Integer caminhaoModelo) {
		this.caminhaoModelo = caminhaoModelo;
	}

	public List<Caminhao> getCaminhoes() {
		return caminhoes;
	}

	public void setCaminhoes(List<Caminhao> caminhoes) {
		this.caminhoes = caminhoes;
	}
	
	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caminhao other = (Caminhao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
