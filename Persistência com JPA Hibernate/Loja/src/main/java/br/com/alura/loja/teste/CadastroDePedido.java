package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.Dao.CategoriaDao;
import br.com.alura.loja.Dao.ClienteDao;
import br.com.alura.loja.Dao.PedidoDao;
import br.com.alura.loja.Dao.ProdutoDao;
import br.com.alura.loja.Vo.RelatorioVendasVo;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		poularbancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtodao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
//		List<Produto> prod = produtodao.buscarTodos();
//		for (Produto produto : prod) {
//			System.out.println(produto.getId());
//		}

		Produto celular = produtodao.buscarPorId(4l);
		Produto videogmae = produtodao.buscarPorId(5l);
		Produto notebook = produtodao.buscarPorId(6l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		Cliente cliente2 = clienteDao.buscarPorId(2l);
		Cliente cliente3 = clienteDao.buscarPorId(3l);

		em.getTransaction().begin();
		Pedido pedido = new Pedido(cliente);
		Pedido pedido2 = new Pedido(cliente2);
		Pedido pedido3 = new Pedido(cliente3);
		pedido.adicionarItem(new ItemPedido(10, celular, pedido));
		pedido.adicionarItem(new ItemPedido(40, videogmae, pedido2));
		pedido.adicionarItem(new ItemPedido(2, notebook, pedido3));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		pedidoDao.cadastrar(pedido3);

		em.getTransaction().commit();

		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("O valor total vendido é:" + totalVendido);

		List<RelatorioVendasVo> obj = pedidoDao.relatorioDeVendaso();
		for (RelatorioVendasVo relatorioVendasVo : obj) {
			System.out.println(relatorioVendasVo.toString());
		}

	}

	private static void poularbancoDeDados() {
		Categoria celulares = new Categoria("celulares");
		Categoria videogames = new Categoria("videogames");
		Categoria computadores = new Categoria("computadores");

		Produto celular = new Produto("Celular Xaomi", "muito bom", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("ps5", "Playstation 5", new BigDecimal("3000"), videogames);
		Produto computador = new Produto("Macbook", "macbook pro", new BigDecimal("6000"), computadores);

		Cliente cliente = new Cliente("Gabriel", "1");
		Cliente cliente2 = new Cliente("Renato", "2");
		Cliente cliente3 = new Cliente("Luceny", "3");

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriadao = new CategoriaDao(em);
		ProdutoDao produtodao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		categoriadao.cadastrar(celulares);
		categoriadao.cadastrar(videogames);
		categoriadao.cadastrar(computadores);

		produtodao.cadastrar(celular);
		produtodao.cadastrar(videogame);
		produtodao.cadastrar(computador);

		clienteDao.cadastrar(cliente);
		clienteDao.cadastrar(cliente2);
		clienteDao.cadastrar(cliente3);

		em.getTransaction().commit();
		em.close();
	}

}