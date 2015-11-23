package restaurante.modelo.item;

/**
 * 
 * @author Thiago
 * @version 1.0
 */

import java.util.List;

public interface ItemDAO {
	public void salvar(Item item);
	public void excluir(Item item);
	public void alterar(Item item);
	public Item carregar(Integer codigo);
	public List<Item> listarItens();

}
