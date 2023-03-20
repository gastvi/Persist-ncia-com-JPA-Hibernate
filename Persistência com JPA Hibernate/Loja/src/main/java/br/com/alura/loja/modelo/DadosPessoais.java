package br.com.alura.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class DadosPessoais implements Serializable{

	private String nome;
	private String Cpf;
	
	public DadosPessoais() {
		
	}
			
			
	public DadosPessoais(String nome, String Cpf) {
		this.Cpf = Cpf;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return Cpf;
	}

}
