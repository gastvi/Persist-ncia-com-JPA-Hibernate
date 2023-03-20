package br.com.alura.loja.Vo;

import java.time.LocalDate;

public class RelatorioVendasVo {

	private String nomeProduto;
	private Long quantidadeVendia;
	private LocalDate ultimaDataDeVenda;

	
	public RelatorioVendasVo(String nomeProduto, Long quantidadeVendia, LocalDate ultimaDataDeVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendia = quantidadeVendia;
		this.ultimaDataDeVenda = ultimaDataDeVenda;
	}

	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getQuantidadeVendia() {
		return quantidadeVendia;
	}

	public void setQuantidadeVendia(Long quantidadeVendia) {
		this.quantidadeVendia = quantidadeVendia;
	}

	public LocalDate getUltimaDataDeVenda() {
		return ultimaDataDeVenda;
	}

	public void setUltimaDataDeVenda(LocalDate ultimaDataDeVenda) {
		this.ultimaDataDeVenda = ultimaDataDeVenda;
	}

	@Override
	public String toString() {
		return "RelatorioVendasVo[nome do produto: " + nomeProduto + ", qunatidade vendida: " + quantidadeVendia
				+ ", ultima venda: " + ultimaDataDeVenda + "]";
	}

}
