package restaurante.modelo.retiradaitem;

import java.util.List;

import restaurante.util.DAOFactory;

public class RetiradaItemRN {
	
private RetiradaItemDAO retiradaItemDAO;
	

	public RetiradaItemRN(){
		this.retiradaItemDAO = DAOFactory.criarRetiradaItemDAO();
	}
	
	
	public RetiradaItem carregar(Integer idSaida){
		return this.retiradaItemDAO.carregar(idSaida);
	}

	
	public void alterar(RetiradaItem retiradaItem){
		this.retiradaItemDAO.alterar(retiradaItem);
	}
	
	
	public void salvar(RetiradaItem retiradaItem){
		Integer idSaida = retiradaItem.getIdSaida();
		if (idSaida == null || idSaida == 0){
			this.retiradaItemDAO.salvar(retiradaItem);
		} else{
			this.retiradaItemDAO.alterar(retiradaItem);
		}
	}
	
	public void excluir(RetiradaItem retiradaItem){
		this.retiradaItemDAO.excluir(retiradaItem);
	}
	
	public List<RetiradaItem> listar() {
		return this.retiradaItemDAO.listarRetiradas();
	}


}
