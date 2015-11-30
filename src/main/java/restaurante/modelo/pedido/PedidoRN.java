package restaurante.modelo.pedido;

import java.util.List;

import restaurante.util.DAOFactory;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class PedidoRN {
	
	private PedidoDAO pedidoDAO;
	
	public PedidoRN(){
		this.pedidoDAO = DAOFactory.criarPedidoDAO();
	}
	
	
	public void salvar(Pedido pedido){
		Integer idPedido = pedido.getIdPedido();
		if (idPedido == null || idPedido == 0){
			this.pedidoDAO.salvar(pedido);
		} else{
			this.pedidoDAO.atualizar(pedido);
		}
	}	

	public void excluir(Pedido pedido){
		this.pedidoDAO.excluir(pedido);
	}
	
	public List<Pedido> listar() {
		return this.pedidoDAO.listar();
	}
	
	public List<Pedido> listarNaoAtendidos() {
		return this.pedidoDAO.listarNaoAtendidos();
	}
	public List<Pedido> listarPedidosRefeicaoNaoAtendidos() {
		return this.pedidoDAO.listarPedidosRefeicaoNaoAtendidos();
	}
	public List<Pedido> listarPedidosBebidaNaoAtendidos() {
		return this.pedidoDAO.listarPedidosBebidaNaoAtendidos();
	}
}
