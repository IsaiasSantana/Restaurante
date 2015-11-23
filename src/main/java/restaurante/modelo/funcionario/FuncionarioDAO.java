package restaurante.modelo.funcionario;

import java.util.Date;
import java.util.List;

public interface FuncionarioDAO{
	public Date cargaHorariaTotal(Funcionario funcionario);
	public float bonificacao(Funcionario funcionario);
	public float salarioTotal(Funcionario funcionario);
	public void inserir(Funcionario funcionario);
	public void alterar(Funcionario funcionario);
	public void excluir(Funcionario funcionario);
	public void excluirPorCPF(String cpf);
	public List<Funcionario> listarFuncionarios();
	public List<Funcionario> buscarPorNome(String nome);
}
