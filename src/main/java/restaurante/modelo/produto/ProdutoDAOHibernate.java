package restaurante.modelo.produto;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class ProdutoDAOHibernate implements ProdutoDAO{
	
	
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Produto produto) {
		this.session.save(produto);
		
	}

	@Override
	public void atualizar(Produto produto) {
		this.session.update(produto);
		
	}

	@Override
	public void excluir(Produto produto) {
		this.session.delete(produto);
		
	}

	@Override
	public Produto carregar(Integer idProduto) {
		return (Produto) this.session.get(Produto.class, idProduto);
	}

	@Override
	public Produto buscaPorNome(String nome) {
		String hql = "select u from Produto u where u.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Produto) consulta.uniqueResult();
	}

	@Override
	public List<Produto> listar() {
		Query querySql = this.session.createSQLQuery("select * from produto order by isRefeicao desc").addEntity(Produto.class);
		List<Produto> lista = querySql.list();
		return lista;
	}
	
	@Override
	public List<Produto> listarRefeicao() {
		Query querySql = this.session.createSQLQuery("select * from produto where isRefeicao = true").addEntity(Produto.class);
		List<Produto> lista = querySql.list();
		return lista;
	}
	
	@Override
	public List<Produto> listarBebida() {
		Query querySql = this.session.createSQLQuery("select * from produto  where isRefeicao = false").addEntity(Produto.class);
		List<Produto> lista = querySql.list();
		return lista;
	}

}
