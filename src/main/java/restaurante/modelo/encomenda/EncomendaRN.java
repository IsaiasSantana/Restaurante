package restaurante.modelo.encomenda;

import java.util.List;


import restaurante.util.DAOFactory;

/**
 * 
 * @author thiago
 * @version 1.0
 */

public class EncomendaRN {
	
	private EncomendaDAO encomendaDAO;
	
	public EncomendaRN(){
		this.encomendaDAO = DAOFactory.criarEncomendaDAO();
	}
	
	
	public void salvar(Encomenda encomenda){
		Integer idEncomenda = encomenda.getIdEncomenda();
		if (idEncomenda == null || idEncomenda == 0){
			this.encomendaDAO.salvar(encomenda);
		} else{
			this.encomendaDAO.alterar(encomenda);
		}
	}	

	public void excluir(Encomenda encomenda){
		this.encomendaDAO.excluir(encomenda);
	}
	
	public List<Encomenda> listarEncomenda() {
		return this.encomendaDAO.listarEncomendas();
	}
	
	
	public Encomenda carregar(Integer idEncomenda){
		return this.encomendaDAO.carregar(idEncomenda);
	}
	
	public void alterar(Encomenda encomenda){
		this.encomendaDAO.alterar(encomenda);
	}
}
