package restaurante.modelo.pedido;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import restaurante.modelo.produto.Produto;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class PedidoDAOHibernate implements PedidoDAO{

	 private Session session;
	 
	public void setSession(Session session){
			this.session = session;
	}
	 
	@Override
	public void salvar(Pedido pedido) {
		this.session.save(pedido);
		
	}



	@Override
	public void excluir(Pedido pedido) {
		this.session.delete(pedido);
		
	}

	@Override
	public void atualizar(Pedido pedido) {
		this.session.update(pedido);
		
	}
	


	@Override
	public List<Pedido> listar() {
		Query querySql = this.session.createSQLQuery("select * from pedido order by idPedido asc").addEntity(Pedido.class);
		@SuppressWarnings("unchecked")
		List<Pedido> lista = querySql.list();
		return lista;
	}
	
	@Override
	public List<Pedido> listarNaoAtendidos() {
		Query querySql = this.session.createSQLQuery("select * from pedido where statusPedido = false").addEntity(Pedido.class);
		@SuppressWarnings("unchecked")
		List<Pedido> lista = querySql.list();
		return lista;
	}

	@Override
	public List<Pedido> listarPedidosRefeicaoNaoAtendidos() {
		Query querySql = this.session.createSQLQuery("select idPedido, horaAtendido, horaRealizado, qntd, statusPedido, produto_idProduto from pedido, produto where idProduto = produto_idproduto and isRefeicao = true and statusPedido = false order by idPedido asc").addEntity(Produto.class);
		@SuppressWarnings("unchecked")
		List<Pedido> lista = querySql.list();
		return lista;
	}
	
	@Override
	public List<Pedido> listarPedidosBebidaNaoAtendidos() {
		Query querySql = this.session.createSQLQuery("select idPedido, horaAtendido, horaRealizado, qntd, statusPedido, produto_idProduto from pedido, produto where idProduto = produto_idproduto and isRefeicao = false and statusPedido = false order by idPedido asc").addEntity(Produto.class);
		@SuppressWarnings("unchecked")
		List<Pedido> lista = querySql.list();
		return lista;
	}

	
	
	

}
