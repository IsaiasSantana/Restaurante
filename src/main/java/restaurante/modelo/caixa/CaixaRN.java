package restaurante.modelo.caixa;

import java.util.List;

import restaurante.modelo.funcionario.Funcionario;
import restaurante.util.DAOFactory;

/**
 * 
 * @author IsaíasSantana
 *
 */
public class CaixaRN {
	private CaixaDAO caixaDAO;
	
	public CaixaRN(){
		caixaDAO = DAOFactory.criarCaixaDAO();
	}
	
	public void inserir(Caixa caixa) {
		caixaDAO.inserir(caixa);
	}
	
	public List<Funcionario> buscarGerentes(){
		return caixaDAO.buscarGerentes();
	}
	

}