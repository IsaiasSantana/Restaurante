package restaurante.modelo.caixaEntrada;

import java.util.List;

import restaurante.modelo.caixa.Caixa;

/**
 * 
 * @author Isa�asSantana
 *
 */
public interface CaixaEntradaDAO {
	void cadastradaEntradaCaixa(CaixaEntrada caixaEntrada);
	 
	 /**
	  * 
	  * @return retorna todos os caixas dispon�veis.
	  */
	 List<Caixa> caixas();
	 
	 /**
	  * 
	  * @return retorna uma lista com todas as entradas de comandas que ir�o entrar no caixa.
	  */
	 List<CaixaEntrada> listaCaixaEntradas();
	 
	 /**
	  * 
	  * @return retorna o total de todas as entradas feitas no caixa de entrada.
	  */
	 double somarEntradas();
	 
}
