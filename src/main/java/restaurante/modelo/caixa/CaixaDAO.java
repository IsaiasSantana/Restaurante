package restaurante.modelo.caixa;

public interface CaixaDAO {
	 void abrirCaixa();
	 double fecharCaixa();
	 void inserir(Caixa caixa);
	 void alterar(Caixa caixa);
}
