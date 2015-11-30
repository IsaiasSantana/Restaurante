package restaurante.util;

import restaurante.conexao.HibernateUtil;
import restaurante.modelo.caixa.CaixaDAO;
import restaurante.modelo.caixa.CaixaDAOHibernate;
import restaurante.modelo.caixaEntrada.CaixaEntradaDAO;
import restaurante.modelo.caixaEntrada.CaixaEntradaDAOHibernate;
import restaurante.modelo.caixaRetirada.CaixaRetiradaDAO;
import restaurante.modelo.caixaRetirada.CaixaRetiradaDAOHibernate;
import restaurante.modelo.comanda.ComandaDAO;
import restaurante.modelo.comanda.ComandaDAOHibernate;
import restaurante.modelo.contato.ContatoDAO;
import restaurante.modelo.contato.ContatoDAOHibernate;
import restaurante.modelo.encomenda.EncomendaDAO;
import restaurante.modelo.encomenda.EncomendaDAOHibernate;
import restaurante.modelo.fornecedor.FornecedorDAO;
import restaurante.modelo.fornecedor.FornecedorDAOHibernate;
import restaurante.modelo.funcionario.FuncionarioDAO;
import restaurante.modelo.funcionario.FuncionarioDAOHibernate;
import restaurante.modelo.item.ItemDAO;
import restaurante.modelo.item.ItemDAOHibernate;
import restaurante.modelo.lote.LoteDAO;
import restaurante.modelo.lote.LoteDAOHibernate;
import restaurante.modelo.pedido.PedidoDAO;
import restaurante.modelo.pedido.PedidoDAOHibernate;
import restaurante.modelo.produto.ProdutoDAO;
import restaurante.modelo.produto.ProdutoDAOHibernate;
import restaurante.modelo.quadroHorarios.QuadroHorariosDAO;
import restaurante.modelo.quadroHorarios.QuadroHorariosDAOHibernate;
import restaurante.modelo.retiradaitem.RetiradaItemDAO;
import restaurante.modelo.retiradaitem.RetiradaItemDAOHibernate;


public class DAOFactory {
	
	
	public static RetiradaItemDAO criarRetiradaItemDAO(){
		RetiradaItemDAOHibernate retiradaItemDAO = new RetiradaItemDAOHibernate();
		retiradaItemDAO.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return retiradaItemDAO;
	}
	
	public static LoteDAO criarLoteDAO(){
		LoteDAOHibernate loteDAOH = new LoteDAOHibernate();
		loteDAOH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return loteDAOH;
	}
	
	public static EncomendaDAO criarEncomendaDAO(){
		EncomendaDAOHibernate encDAOH = new EncomendaDAOHibernate();
		encDAOH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return encDAOH;
	}
	
	public static CaixaRetiradaDAO criarCaixaRetiradaDAO(){
		CaixaRetiradaDAOHibernate cRDH = new CaixaRetiradaDAOHibernate();
		cRDH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return cRDH;
	}
	
	public static CaixaEntradaDAO criarCaixaEntradaDAO(){
		CaixaEntradaDAOHibernate cEDH = new CaixaEntradaDAOHibernate();
		cEDH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return cEDH;
	}
	
	public static CaixaDAO criarCaixaDAO(){
		CaixaDAOHibernate caixaDH = new CaixaDAOHibernate();
		caixaDH.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return caixaDH;
	}
	
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
