package com.truckdelivery.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Frete {
	
	private Integer id;
	private String  origem;
	private String  destino;
	private Integer caminhaoModelo;
	private Date 	dataEntregaCarga;
	private Date 	dataRetiraCarga;
	
	private List<Frete>fretes= new ArrayList<>();
	
	public Frete() {
		
	}
	
	
	//CONSTRUTOR COM PARAMETROS
	public Frete(Integer id, String origem, String destino, Integer caminhaoModelo, Date dataEntregaCarga,
			Date dataRetiraCarga) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.caminhaoModelo = caminhaoModelo;
		this.dataEntregaCarga = dataEntregaCarga;
		this.dataRetiraCarga = dataRetiraCarga;
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

	public Integer getCaminhaoModelo() {
		return caminhaoModelo;
	}

	public void setCaminhaoModelo(Integer caminhaoModelo) {
		this.caminhaoModelo = caminhaoModelo;
	}

	public Date getDataEntregaCarga() {
		return dataEntregaCarga;
	}

	public void setDataEntregaCarga(Date dataEntregaCarga) {
		this.dataEntregaCarga = dataEntregaCarga;
	}

	public Date getDataRetiraCarga() {
		return dataRetiraCarga;
	}

	public void setDataRetiraCarga(Date dataRetiraCarga) {
		this.dataRetiraCarga = dataRetiraCarga;
	}

	public List<Frete> getFretes() {
		return fretes;
	}

	public void setFretes(List<Frete> fretes) {
		this.fretes = fretes;
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
		Frete other = (Frete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
