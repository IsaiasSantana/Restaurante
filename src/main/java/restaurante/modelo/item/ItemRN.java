package restaurante.modelo.item;

/**
 * 
 * @author Thiago
 * @version 1.0
 */


import java.util.List;

import restaurante.util.DAOFactory;

public class ItemRN {
	
private ItemDAO itemDAO;
	

	public ItemRN(){
		this.itemDAO = DAOFactory.criarItemDAO();
	}
	
	
	public Item carregar(Integer idItem){
		return this.itemDAO.carregar(idItem);
	}

	
	public void alterar(Item item){
		this.itemDAO.alterar(item);
	}
	
	
	public void salvar(Item item){
		Integer idItem = item.getIdItem();
		if (idItem == null || idItem == 0){
			this.itemDAO.salvar(item);
		} else{
			this.itemDAO.alterar(item);
		}
	}
	
	public void excluir(Item item){
		this.itemDAO.excluir(item);
	}
	
	public List<Item> listar() {
		return this.itemDAO.listarItens();
	}

	
	

}
