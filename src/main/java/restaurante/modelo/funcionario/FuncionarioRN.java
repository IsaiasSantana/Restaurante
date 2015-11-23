package restaurante.modelo.funcionario;

import java.util.List;

import restaurante.util.DAOFactory;

public class FuncionarioRN {
	private FuncionarioDAO funcDAO;
	
	public FuncionarioRN(){
		funcDAO = DAOFactory.criarFuncionarioDAO();
	}
	
	public void inserir(Funcionario funcionario){
		funcDAO.inserir(funcionario);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return funcDAO.listarFuncionarios();
	}
	
	public void excluir(Funcionario funcionario){
		funcDAO.excluir(funcionario);
	}
	
	public void alterar(Funcionario funcionario){
		funcDAO.alterar(funcionario);
	}
	
	 public List<Funcionario> buscarPorNome(String nome){
		return funcDAO.buscarPorNome(nome);
	}
	
}
