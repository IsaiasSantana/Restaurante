package restaurante.modelo.encomenda;

import java.util.List;

public interface EncomendaDAO {

	public void salvar(Encomenda encomenda);
	public void excluir(Encomenda encomenda);
	public void alterar(Encomenda encomenda);
	public Encomenda carregar(Integer codigo);
	public List<Encomenda> listarEncomendas();
	
}
