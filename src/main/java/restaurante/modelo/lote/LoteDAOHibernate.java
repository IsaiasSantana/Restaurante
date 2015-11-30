package restaurante.modelo.lote;


/**
 * 
 * @author Thiago
 * @version 1.0
 */

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class LoteDAOHibernate implements LoteDAO{
	
	private Session session;
	 
	public void setSession(Session session){
			this.session = session;
	}
	
	
	@Override
	public void salvar(Lote lote) {
		this.session.save(lote);
		
	}
	
	@Override
	public void excluir(Lote lote) {
		this.session.delete(lote);
		
	}
	
	@Override
	public void alterar(Lote lote) {
		this.session.update(lote);
		
	}
	

	@Override
	public List<Lote> listarLotes() {
		// TODO Auto-generated method stub
		Query querySql = this.session.createSQLQuery("select * from lote order by idLote asc").addEntity(Lote.class);
		@SuppressWarnings("unchecked")
		List<Lote> lista = querySql.list();
		return lista;
	}

	@Override
	public Lote carregar(Integer idLote) {
		return (Lote) this.session.get(Lote.class, idLote);
	}


}
