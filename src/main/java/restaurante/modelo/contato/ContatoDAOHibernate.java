package restaurante.modelo.contato;

import org.hibernate.Session;

public class ContatoDAOHibernate implements ContatoDAO{
	private Session session;	
	

	public void setSession(Session session) {
		this.session = session;
	}



	@Override
	public void salvar(Contato contato) {
		this.session.save(contato);
	}



	@Override
	public Contato carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
