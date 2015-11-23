package restaurante.util;

import restaurante.conexao.HibernateUtil;
import restaurante.modelo.comanda.ComandaDAO;
import restaurante.modelo.comanda.ComandaDAOHibernate;
import restaurante.modelo.contato.ContatoDAO;
import restaurante.modelo.contato.ContatoDAOHibernate;
import restaurante.modelo.fornecedor.FornecedorDAO;
import restaurante.modelo.fornecedor.FornecedorDAOHibernate;
import restaurante.modelo.funcionario.FuncionarioDAO;
import restaurante.modelo.funcionario.FuncionarioDAOHibernate;
import restaurante.modelo.item.ItemDAO;
import restaurante.modelo.item.ItemDAOHibernate;
import restaurante.modelo.pedido.PedidoDAO;
import restaurante.modelo.pedido.PedidoDAOHibernate;
import restaurante.modelo.produto.ProdutoDAO;
import restaurante.modelo.produto.ProdutoDAOHibernate;
import restaurante.modelo.quadroHorarios.QuadroHorariosDAO;
import restaurante.modelo.quadroHorarios.QuadroHorariosDAOHibernate;


public class DAOFactory {
	
	
	public static FuncionarioDAO criarFuncionarioDAO(){
		FuncionarioDAOHibernate funcionarioDH = new FuncionarioDAOHibernate();
		funcionarioDH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return funcionarioDH;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ProdutoDAO criarProdutoDAO(){
		ProdutoDAOHibernate produtoDAO = new ProdutoDAOHibernate();
		produtoDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return produtoDAO;
	}
	
	/**
	 * 
	 * @return
	 */
	public static QuadroHorariosDAO criarQuadroHorariosDAO(){
		QuadroHorariosDAOHibernate  quadroHDH = new QuadroHorariosDAOHibernate();
		quadroHDH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return quadroHDH;
	}
	
	/**
	 * 
	 * @return
	 */
	public static FornecedorDAO criarFornecedorDAO(){
		FornecedorDAOHibernate fornecedorDAO = new FornecedorDAOHibernate();
		fornecedorDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return fornecedorDAO;
	}
	/**
	 * 
	 * @return
	 */
	public static ContatoDAO criarContatoDAO(){
		ContatoDAOHibernate contatoDAO = new ContatoDAOHibernate();
		contatoDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return contatoDAO;
	}
	/**
	 * 
	 * @return
	 */
	public static PedidoDAO criarPedidoDAO(){
		PedidoDAOHibernate pedidoDAO = new PedidoDAOHibernate();
		pedidoDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return pedidoDAO;
	}
	/**
	 * 
	 * @return
	 */
	public static ComandaDAO criarComandaDAO(){
		ComandaDAOHibernate comandaDAO = new ComandaDAOHibernate();
		comandaDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return comandaDAO;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ItemDAO criarItemDAO(){
		ItemDAOHibernate itemDAO = new ItemDAOHibernate();
		itemDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return itemDAO;
	}
	
}
