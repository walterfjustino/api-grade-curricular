package com.truckdelivery.domain;

import java.util.ArrayList;
import java.util.List;

public class Motorista {
	
	private Integer id;
	private Integer idade;
	private String  nome;
 	private String  cpf;
 	private String  cnh;
 	private Boolean caminhaoProprio;
 	private Integer caminhaoModelo; 
 	private Boolean caminhaCarregado;
 	private String  localizacao;
 	
 	private List<Motorista>motoristas = new ArrayList<>();
 	
 	public Motorista() {
 		
  	}
 	
 	//CONSTRUTOR COM PARAMETROS
	public Motorista(Integer id, Integer idade, String nome, String cpf, String cnh, Boolean caminhaoProprio,
			Integer caminhaoModelo, Boolean caminhaCarregado, String localizacao) {
		super();
		this.id = id;
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.caminhaoProprio = caminhaoProprio;
		this.caminhaoModelo = caminhaoModelo;
		this.caminhaCarregado = caminhaCarregado;
		this.localizacao = localizacao;
	}
	
	
	//GETTER E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Boolean getCaminhaoProprio() {
		return caminhaoProprio;
	}

	public void setCaminhaoProprio(Boolean caminhaoProprio) {
		this.caminhaoProprio = caminhaoProprio;
	}

	public Integer getCaminhaoModelo() {
		return caminhaoModelo;
	}

	public void setCaminhaoModelo(Integer caminhaoModelo) {
		this.caminhaoModelo = caminhaoModelo;
	}

	public Boolean getCaminhaCarregado() {
		return caminhaCarregado;
	}

	public void setCaminhaCarregado(Boolean caminhaCarregado) {
		this.caminhaCarregado = caminhaCarregado;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
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
		Motorista other = (Motorista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 	
	
 	
} 
