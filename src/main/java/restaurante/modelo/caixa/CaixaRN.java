package restaurante.modelo.caixa;

import java.util.List;

import restaurante.modelo.caixaEntrada.CaixaEntradaRN;
import restaurante.modelo.caixaRetirada.CaixaRetiradaRN;
import restaurante.modelo.funcionario.Funcionario;
import restaurante.util.DAOFactory;

/**
 * 
 * @author Isa�asSantana
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
	
	/**
	 * 
	 * @return retorna um vetor de double de duas posi��es, onde a primeira posi��o
	 * 		   cont�m o total de todas as entradas e a segunda posi��o o total de saidas.
	 */
	public double[] fecharCaixa(){
		final CaixaEntradaRN caixaEntRN = new CaixaEntradaRN();
		final CaixaRetiradaRN caixaRetRN = new CaixaRetiradaRN();
		final double valoreSomados[] = new double[2];
		valoreSomados[0] = caixaEntRN.somarEntradas();
		valoreSomados[1] = caixaRetRN.somarRetiradas();
		return valoreSomados;
	}
	
}