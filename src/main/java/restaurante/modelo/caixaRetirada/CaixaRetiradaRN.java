package restaurante.modelo.caixaRetirada;

import java.util.List;

import restaurante.util.DAOFactory;

public class CaixaRetiradaRN {
	
	private CaixaRetiradaDAO caixaRetiradaDAO;
	
	public CaixaRetiradaRN(){
		caixaRetiradaDAO = DAOFactory.criarCaixaRetiradaDAO();
	}
	
	public void inserir(CaixaRetirada retirada){
		caixaRetiradaDAO.inserir(retirada);
	}
	
	public List<CaixaRetirada> retiradas(){
		return caixaRetiradaDAO.retiradas();
	}
	
	public double somarRetiradas(){
		return caixaRetiradaDAO.somarRetiradas();
	}
}
