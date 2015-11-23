package restaurante.modelo.pedido;

import java.util.List;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public interface PedidoDAO {
	
	public void salvar (Pedido pedido);
	public void excluir (Pedido pedido);
	public void atualizar (Pedido pedido);
	public List<Pedido> listar();
	public List<Pedido> listarNaoAtendidos();
	public List<Pedido> listarPedidosRefeicaoNaoAtendidos();
	public List<Pedido> listarPedidosBebidaNaoAtendidos();
}
