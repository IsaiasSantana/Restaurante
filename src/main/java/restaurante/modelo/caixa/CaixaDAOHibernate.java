package restaurante.modelo.caixa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import restaurante.modelo.funcionario.Funcionario;

/**
 * 
 * @author IsaíasSantana
 *
 */
public class CaixaDAOHibernate implements CaixaDAO {
	private Session session; //Objeto que permite fazer o CRUD no banco de dados.
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void abrirCaixa() {
		
	}

	@Override
	public double fecharCaixa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void inserir(Caixa caixa) {
		session.save(caixa);
		
	}

	@Override
	public void alterar(Caixa caixa) {
		// TODO Auto-generated method stub
		session.update(caixa);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> buscarGerentes(){
		String hql = "select u from Funcionario u where u.categoria like :categoria";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("categoria", "gerente"+"%");
		return (List<Funcionario>) consulta.list();
	}

}
