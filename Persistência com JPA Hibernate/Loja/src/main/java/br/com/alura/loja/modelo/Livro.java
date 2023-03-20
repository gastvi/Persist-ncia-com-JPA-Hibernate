package br.com.alura.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto{
	
	private String autro;
	private Integer numeroDepanigas;
	
	public Livro() {}
	
	public Livro(String autro, Integer numeroDepanigas) {
		this.autro = autro;
		this.numeroDepanigas = numeroDepanigas;
	}
	

	public String getAutro() {
		return autro;
	}

	public void setAutro(String autro) {
		this.autro = autro;
	}

	public Integer getNumeroDepanigas() {
		return numeroDepanigas;
	}

	public void setNumeroDepanigas(Integer numeroDepanigas) {
		this.numeroDepanigas = numeroDepanigas;
	}
	
	
	
}
