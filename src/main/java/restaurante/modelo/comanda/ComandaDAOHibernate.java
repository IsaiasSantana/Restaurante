package restaurante.modelo.comanda;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import restaurante.modelo.pedido.Pedido;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class ComandaDAOHibernate implements ComandaDAO{

	 private Session session;
	 
		public void setSession(Session session){
				this.session = session;
		}
	
	@Override
	public void salvar(Comanda comanda) {
		this.session.save(comanda);
		
	}

	@Override
	public void excluir(Comanda comanda) {
		this.session.delete(comanda);
		
	}

	@Override
	public void atualizar(Comanda comanda) {
		this.session.update(comanda);
		
	}

	@Override
	public List<Comanda> listar() {
		Query querySql = this.session.createSQLQuery("select * from comanda order by idComanda asc").addEntity(Comanda.class);
		List<Comanda> lista = querySql.list();
		return lista;
	}

	@Override
	public List<Comanda> listarAtivas() {
		Query querySql = this.session.createSQLQuery("select * from comanda where comandaInativa = false").addEntity(Comanda.class);
		List<Comanda> lista = querySql.list();
		return lista;
	}

	@Override
	public List<Comanda> listarInativas() {
		Query querySql = this.session.createSQLQuery("select * from comanda where comandaInativa = true").addEntity(Comanda.class);
		List<Comanda> lista = querySql.list();
		return lista;
	}

	@Override
	public List<Pedido> listarPedidos(Comanda comanda) {
		Query queryHql =  this.session.createQuery("FROM comanda.listaPedidos");
		queryHql.setParameter("comanda", comanda);
		List<Pedido> lista = queryHql.list();
		return lista;
	}
}
