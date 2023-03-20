package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.Dao.CategoriaDao;
import br.com.alura.loja.Dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {

		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        
        Produto p = produtoDao.buscarPorId(2l);
        System.out.println(p.getPreco());
      
        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("celulares");
        todos.forEach(p2 -> System.out.println(p2.getNome()));
        
        BigDecimal preco = produtoDao.buscarPrecoDoProdutoComNome("Celular Xaomi");
        System.out.println("o preço do produto é: "+ preco);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("celulares");

		Produto celular = new Produto("Celular Xaomi", "muito bom", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriadao = new CategoriaDao(em);
		ProdutoDao produtodao = new ProdutoDao(em);

		em.getTransaction().begin();
		categoriadao.cadastrar(celulares);
		produtodao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
