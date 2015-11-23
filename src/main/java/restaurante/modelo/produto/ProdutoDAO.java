package restaurante.modelo.produto;

import java.util.List;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

public interface ProdutoDAO {
	public void salvar(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(Produto produto);
	public Produto carregar(Integer idProduto);
	public Produto buscaPorNome(String nome);
	public List<Produto> listar();
	public List<Produto> listarRefeicao();
	public List<Produto> listarBebida();
}
