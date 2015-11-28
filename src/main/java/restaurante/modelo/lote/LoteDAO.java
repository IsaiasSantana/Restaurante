package restaurante.modelo.lote;

import java.util.List;


/**
 * 
 * @author Thiago
 * @version 1.0
 */


public interface LoteDAO {
	public void salvar(Lote lote);
	public void excluir(Lote lote);
	public void alterar(Lote lote);
	public Lote carregar(Integer codigo);
	public List<Lote> listarLotes();


}
