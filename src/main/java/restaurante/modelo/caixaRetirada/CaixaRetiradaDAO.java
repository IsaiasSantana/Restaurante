package restaurante.modelo.caixaRetirada;

import java.util.List;

public interface CaixaRetiradaDAO {
	
	/**
	 * 
	 * @return retorna todas as retiradas do caixa.
	 */
	List<CaixaRetirada> retiradas();
	
	/**
	 * 
	 * @param retirada retirada a ser inserida para registro.
	 */
	void inserir(CaixaRetirada retirada);
	
	/**
	 * apaga todas as retiradas do caixa.
	 */
	void zerarCaixaRetirada();
}
