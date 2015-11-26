package restaurante.modelo.caixa;

import java.util.List;

import restaurante.modelo.funcionario.Funcionario;

/**
 * 
 * @author IsaíasSantana
 *
 */
public interface CaixaDAO {
	/**
	 * Abre o caixa para permitir entrada de comandas.
	 */
	 void abrirCaixa();
	 /**
	  * Fecha o caixa no fim do expediente de trabalho.
	  * @return o total arrecadado durante um dia de trabalho.
	  */
	 double fecharCaixa();
	 /**
	  * Insere um novo caixa no banco de dados do sistema.
	  * @param caixa objeto contendo os dados do caixa
	  */
	 void inserir(Caixa caixa);
	 /**
	  * Altera algum dado do caixa, logo após é persistido novamente no banco.
	  * @param caixa objeto a ser alterado
	  */
	 void alterar(Caixa caixa);
	 /**
	  * @return uma lista contendo todos os gerentes que podem abrir e fechar o caixa
	  */
	 List<Funcionario> buscarGerentes();
	
}
