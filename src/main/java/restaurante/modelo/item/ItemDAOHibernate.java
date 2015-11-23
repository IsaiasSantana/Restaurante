package restaurante.modelo.item;


/**
 * 
 * @author Thiago
 * @version 1.0
 */


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ItemDAOHibernate implements ItemDAO {
	
	private Session session;
	 
	public void setSession(Session session){
			this.session = session;
	}
	 
	@Override
	public void salvar(Item item) {
		this.session.save(item);
		
	}
	
	@Override
	public void excluir(Item item) {
		this.session.delete(item);
		
	}
	
	@Override
	public void alterar(Item item) {
		this.session.update(item);
		
	}
	

	@Override
	public List<Item> listarItens() {
		// TODO Auto-generated method stub
		Query querySql = this.session.createSQLQuery("select * from item order by idItem asc").addEntity(Item.class);
		List<Item> lista = querySql.list();
		return lista;
	}

	@Override
	public Item carregar(Integer idItem) {
		return (Item) this.session.get(Item.class, idItem);
	}
	
	

	
	

}
