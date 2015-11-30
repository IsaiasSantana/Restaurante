package restaurante.modelo.contato;

import java.util.List;

import restaurante.modelo.pedido.Pedido;
import restaurante.modelo.pedido.PedidoDAO;
import restaurante.util.DAOFactory;

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
}
