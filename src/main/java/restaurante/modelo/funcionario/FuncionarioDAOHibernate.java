package restaurante.modelo.funcionario;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class FuncionarioDAOHibernate implements FuncionarioDAO {
	private Session session ;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Date cargaHorariaTotal(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float bonificacao(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float salarioTotal(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void inserir(Funcionario funcionario) {
		session.save(funcionario);
	}

	@Override
	public void alterar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		session.update(funcionario);
	}

	@Override
	public void excluir(Funcionario funcionario) {
		// TODO Auto-generated method stub
		session.delete(funcionario);
	}
	
	@Override
	public void excluirPorCPF(String cpf){
		final String consultaSQL = "DELETE FROM funcionario as f WHERE f.cpf LIKE "+cpf;
		Query deletar = session.createSQLQuery(consultaSQL).addEntity(Funcionario.class);
		deletar.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> buscarPorNome(String nome){
		String hql = "select u from Funcionario u where u.nome like :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome+"%");
		return (List<Funcionario>) consulta.list();
	}
	
	@Override
	public List<Funcionario> listarFuncionarios() {
		// TODO Auto-generated method stub
		final String consultaSQL = "SELECT * FROM funcionario;";
		Query consulta = session.createSQLQuery(consultaSQL).addEntity(Funcionario.class);
		@SuppressWarnings("unchecked")
		List<Funcionario> listaFuncionarios = consulta.list();
		return listaFuncionarios;
	}
	
	
}
