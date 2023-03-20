package br.com.alura.loja.Dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.Vo.RelatorioVendasVo;
import br.com.alura.loja.modelo.Pedido;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "Select SUM(p.valorTotal) From Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioVendasVo> relatorioDeVendaso() {
		String jpql = "Select new br.com.alura.loja.Vo.RelatorioVendasVo( "
				+ "p.nome, SUM(ip.quantidade), MAX(pe.data)) From Pedido pe join pe.itens ip join ip.produto p "
				+ " Group by p.nome Order by ip.quantidade DESC";
		return em.createQuery(jpql, RelatorioVendasVo.class).getResultList();
	}

}
