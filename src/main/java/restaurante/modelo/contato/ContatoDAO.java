package restaurante.modelo.contato;

public interface ContatoDAO {
	public void salvar(Contato contato);
	public Contato carregar(Integer codigo);
}
