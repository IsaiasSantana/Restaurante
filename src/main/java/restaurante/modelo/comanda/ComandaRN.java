package restaurante.modelo.comanda;

import java.util.List;

import restaurante.modelo.pedido.Pedido;
import restaurante.util.DAOFactory;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class ComandaRN {

	private ComandaDAO comandaDAO;
	
	public ComandaRN(){
		this.comandaDAO = DAOFactory.criarComandaDAO();
	}
	
	public void salvar(Comanda comanda){
		Integer idComanda = comanda.getIdComanda();
		if (idComanda == null || idComanda == 0){
			this.comandaDAO.salvar(comanda);
		} else{
			this.comandaDAO.atualizar(comanda);
		}
	}
	
	public void excluir(Comanda comanda){
		this.comandaDAO.excluir(comanda);
	}
	
	public List<Comanda> listar() {
		return this.comandaDAO.listar();
	}

	public List<Comanda> listarAtivas() {
		return this.comandaDAO.listarAtivas();
	}

	public List<Comanda> listarInativas() {
		return this.comandaDAO.listarInativas();
	}
	
	public List<Pedido> listarPedidos(Comanda comanda){
		return this.comandaDAO.listarPedidos(comanda);
	}
}
