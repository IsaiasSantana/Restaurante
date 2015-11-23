package restaurante.modelo.contato;

import restaurante.util.DAOFactory;

public class ContatoRN {
	private ContatoDAO contatoDAO ;
	public ContatoRN(){
		this.contatoDAO = DAOFactory.criarContatoDAO();
	}
	/**
	 * @autor alkxyly	
	 * @param contato - objeto contato que será persistido.
	 * 
	 * Salva o contato.
	 */
	public void salvar(Contato contato){
		this.contatoDAO.salvar(contato);
	}
}	
