package restaurante.modelo.caixaEntrada;

import java.util.List;

import restaurante.modelo.caixa.Caixa;
import restaurante.util.DAOFactory;

/**
 * 
 * @author IsaíasSantana
 *
 */
public class CaixaEntradaRN {
	private CaixaEntradaDAO caixaEntDAO;
	
	public CaixaEntradaRN(){
		caixaEntDAO = DAOFactory.criarCaixaEntradaDAO();
	}
	
	public void cadastradaEntradaCaixa(CaixaEntrada valorPago){
		caixaEntDAO.cadastradaEntradaCaixa(valorPago);
	}
	
	public List<Caixa> caixas(){
		return caixaEntDAO.caixas();
	}	
}
