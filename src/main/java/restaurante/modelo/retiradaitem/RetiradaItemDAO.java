package restaurante.modelo.retiradaitem;

import java.util.List;

public interface RetiradaItemDAO {

	public void salvar(RetiradaItem retiradaItem);
	public void excluir(RetiradaItem retiradaItem);
	public void alterar(RetiradaItem retiradaItem);
	public RetiradaItem carregar(Integer codigo);
	public List<RetiradaItem> listarRetiradas();
}
