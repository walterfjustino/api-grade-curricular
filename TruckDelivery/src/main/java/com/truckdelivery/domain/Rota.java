package com.truckdelivery.domain;

import java.util.ArrayList;
import java.util.List;

public class Rota {
	
	private Integer id;
	private String  origem;
	private String  destino;
	private String  localizacao;
	
	private List<Rota>rotas = new ArrayList<>();

	
	public Rota() {
		
	}

	
	//CONSTRUTOR COM PARAMETROS
	public Rota(Integer id, String origem, String destino, String localizacao) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.localizacao = localizacao;
	}

	
	//GETTER E SETTERS
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public List<Rota> getRotas() {
		return rotas;
	}


	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
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
		Rota other = (Rota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}


