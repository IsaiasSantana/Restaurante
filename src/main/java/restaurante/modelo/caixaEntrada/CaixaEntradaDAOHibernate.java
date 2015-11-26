package restaurante.modelo.caixaEntrada;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import restaurante.modelo.caixa.Caixa;

/**
 * 
 * @author IsaíasSantana
 *
 */
public class CaixaEntradaDAOHibernate implements CaixaEntradaDAO {
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	
	@Override
	public void cadastradaEntradaCaixa(CaixaEntrada valorPago) {
		session.save(valorPago);
	}
	

	@Override
	public List<Caixa> caixas() {
		final String consulta = "SELECT * FROM caixa;";
		Query query = session.createSQLQuery(consulta).addEntity(Caixa.class);
		@SuppressWarnings("unchecked")
		List<Caixa> caixas = query.list();
		return caixas;
	}

}
