package restaurante.modelo.fornecedor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



public class FornecedorDAOHibernate implements FornecedorDAO{
	private Session session ;	
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void excluir(Fornecedor fornecedor) {
		this.session.delete(fornecedor);

	}

	@Override
	public void alterar(Fornecedor fornecedor) {
		this.session.update(fornecedor);

	}

	@Override
	public Fornecedor carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvar(Fornecedor fornecedor) {
		this.session.save(fornecedor);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> listar() {
		Query queySql = this.session.createSQLQuery("select * from fornecedor order by idFornecedor asc").addEntity(Fornecedor.class);
		List<Fornecedor> lista = queySql.list();
		return lista;
	}


}

