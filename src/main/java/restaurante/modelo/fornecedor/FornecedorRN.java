package restaurante.modelo.fornecedor;

import java.util.List;

import restaurante.util.DAOFactory;

public class FornecedorRN {

	private FornecedorDAO fornecedorDAO;

	public FornecedorRN(){
		this.fornecedorDAO =  DAOFactory.criarFornecedorDAO();
	}	

	/**
	 * @autor alkxyly
	 * @param fornecedor - Objeto fornecedor que ser√° persistido.
	 * 
	 * Salva o fornecedor.
	 */
	public void salvar(Fornecedor fornecedor){
		this.fornecedorDAO.salvar(fornecedor);
	}
	/**
	 * @author alkxyly
	 * @since 13 de novembro de 2015
	 * 
	 */
	public void excluir(Fornecedor fornecedor){
		this.fornecedorDAO.excluir(fornecedor);
	}
	/**
	 * @autor alkxyly
	 * @param fornecedor -Objeto  fornecedor que ser· alterado.
	 * 
	 */
	public void alterar(Fornecedor fornecedor){
		this.fornecedorDAO.alterar(fornecedor);
	}
	public List<Fornecedor> listar (){
		return this.fornecedorDAO.listar();
	}
}
