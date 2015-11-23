package restaurante.modelo.quadroHorarios;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import restaurante.modelo.fornecedor.Fornecedor;
import restaurante.modelo.funcionario.Funcionario;

/**
 * 
 * @author IsaíasSantana
 *
 */
public class QuadroHorariosDAOHibernate implements QuadroHorariosDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(QuadroHorarios quadroHorarios) {
		session.save(quadroHorarios);
		
	}

	@Override
	public void alterar(QuadroHorarios quadroHorarios, Integer id) {
		QuadroHorarios quadroHorarioAlt = null; 
		
		if(quadroHorarios != null){
			quadroHorarioAlt = (QuadroHorarios) this.session.get(QuadroHorarios.class,id);
			quadroHorarioAlt.setHoraDeChegada(quadroHorarios.getHoraDeChegada());
			quadroHorarioAlt.setHoraDeSaida(quadroHorarios.getHoraDeSaida());			
			session.update(quadroHorarioAlt);
		}
	}

	@Override
	public void excluir(QuadroHorarios quadroHorarios) {
		
		session.delete(quadroHorarios);
	}

	@Override
	public QuadroHorarios buscarQuadoHorario(Funcionario funcionario) {
		final String parametro = ":idQuadroHorarioFuncionario";
		final String consulta = "SELECT q FROM QuadroHorarios q WHERE q.idQuadroHorarios = "+parametro;
		Query query = session.createQuery(consulta);
		query.setParameter(parametro,funcionario.getQuadroHorario().getIdQuadroHorarios());
		return (QuadroHorarios)query.uniqueResult();
	}

	@Override
	public List<QuadroHorarios> listarQuadroDeHorarios() {
		Query querySql = this.session.createSQLQuery("select * from quadro_horarios order by idQuadroHorarios asc").addEntity(QuadroHorarios.class);
		@SuppressWarnings("unchecked")
		List<QuadroHorarios> lista = querySql.list();
		return lista;
	}
}