package restaurante.modelo.comanda;

import java.util.List;

import restaurante.modelo.pedido.Pedido;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public interface ComandaDAO {

	public void salvar (Comanda comanda);
	public void excluir (Comanda comanda);
	public void atualizar (Comanda comanda);
	public List<Comanda> listar();
	public List<Comanda> listarAtivas();
	public List<Comanda> listarInativas();
	public List<Pedido> listarPedidos(Comanda comanda);
	
}
