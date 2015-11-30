package restaurante.modelo.encomenda;


/**
 * 
 * @author Thiago
 * @version 1.0
 */

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class EncomendaDAOHibernate implements EncomendaDAO{
	
	
	private Session session;
	 
	public void setSession(Session session){
			this.session = session;
	}
	
	
	@Override
	public void salvar(Encomenda encomenda) {
		this.session.save(encomenda);
		
	}
	
	@Override
	public void excluir(Encomenda encomenda) {
		this.session.delete(encomenda);
		
	}
	
	@Override
	public void alterar(Encomenda encomenda) {
		this.session.update(encomenda);
		
	}
	

	@Override
	public List<Encomenda> listarEncomendas() {
		// TODO Auto-generated method stub
		Query querySql = this.session.createSQLQuery("select * from encomenda order by idEncomenda asc").addEntity(Encomenda.class);
		@SuppressWarnings("unchecked")
		List<Encomenda> lista = querySql.list();
		return lista;
	}
	

	@Override
	public Encomenda carregar(Integer idEncomenda) {
		return (Encomenda) this.session.get(Encomenda.class, idEncomenda);
	}
}