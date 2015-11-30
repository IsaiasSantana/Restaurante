package restaurante.modelo.retiradaitem;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class RetiradaItemDAOHibernate implements RetiradaItemDAO {

	private Session session;
	 
	public void setSession(Session session){
			this.session = session;
	}
	
	
	@Override
	public void salvar(RetiradaItem retiradaItem) {
		this.session.save(retiradaItem);
		
	}
	
	@Override
	public void excluir(RetiradaItem retiradaItem) {
		this.session.delete(retiradaItem);
		
	}
	
	@Override
	public void alterar(RetiradaItem retiradaItem) {
		this.session.update(retiradaItem);
		
	}
	

	@Override
	public List<RetiradaItem> listarRetiradas() {
		// TODO Auto-generated method stub
		Query querySql = this.session.createSQLQuery("SELECT * FROM retiradaItem order by idSaida asc").addEntity(RetiradaItem.class);
		@SuppressWarnings("unchecked")
		List<RetiradaItem> lista = querySql.list();
		return lista;
	}

	@Override
	public RetiradaItem carregar(Integer idSaida) {
		return (RetiradaItem) this.session.get(RetiradaItem.class, idSaida);
	}

	
}
