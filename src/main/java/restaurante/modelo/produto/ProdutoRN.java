package restaurante.modelo.produto;

import java.util.List;
import restaurante.util.DAOFactory;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public class ProdutoRN {

	private ProdutoDAO produtoDAO;
	
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}
	
	public Produto carregar(Integer idProduto){
		return this.produtoDAO.carregar(idProduto);
	}
	
	public Produto buscaPorNome(String nome){
		return this.produtoDAO.buscaPorNome(nome);
	}
	
	public void salvar(Produto produto){
		Integer idProduto = produto.getIdProduto();
		if (idProduto == null || idProduto == 0){
			this.produtoDAO.salvar(produto);
		} else{
			this.produtoDAO.atualizar(produto);
		}
	}
	
	public void excluir(Produto produto){
		this.produtoDAO.excluir(produto);
	}
	
	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}
	
	public List<Produto> listarRefeicao() {
		return this.produtoDAO.listarRefeicao();
	}
	public List<Produto> listarBebida() {
		return this.produtoDAO.listarBebida();
	}
}
