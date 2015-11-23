package restaurante.modelo.fornecedor;

import java.util.List;

public interface FornecedorDAO {
	public void salvar(Fornecedor fornecedor);
	public void excluir(Fornecedor fornecedor);
	public void alterar(Fornecedor fornecedor);
	public Fornecedor carregar(Integer codigo);
	public List<Fornecedor> listar();
}
