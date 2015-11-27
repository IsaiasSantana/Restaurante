package restaurante.modelo.caixaRetirada;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CaixaRetiradaDAOHibernate implements CaixaRetiradaDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public List<CaixaRetirada> retiradas() {
		final String consulta = "SELECT * FROM caixa_retirada;";
		Query query = session.createSQLQuery(consulta).addEntity(CaixaRetirada.class);
		@SuppressWarnings("unchecked")
		List<CaixaRetirada> caixas = query.list();
		return caixas;
	}

	@Override
	public void inserir(CaixaRetirada retirada) {
		session.save(retirada);
		
	}

	@Override
	public void zerarCaixaRetirada() {
		
	}
	
	

}
