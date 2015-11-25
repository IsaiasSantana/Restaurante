package restaurante.modelo.caixaEntrada;

import java.util.List;

import restaurante.modelo.caixa.Caixa;

/**
 * 
 * @author IsaíasSantana
 *
 */
public interface CaixaEntradaDAO {
	void cadastradaEntradaCaixa(CaixaEntrada caixaEntrada);
	 
	 /**
	  * 
	  * @return retorna todos os caixas disponíveis.
	  */
	 List<Caixa> caixas();
}
