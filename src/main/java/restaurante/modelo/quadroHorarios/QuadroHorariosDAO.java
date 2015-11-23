package restaurante.modelo.quadroHorarios;

import java.util.List;

import restaurante.modelo.funcionario.Funcionario;

public interface QuadroHorariosDAO {
	public void salvar(QuadroHorarios quadroHorarios);
	public void alterar(QuadroHorarios quadroHorarios,Integer id);
	public void excluir(QuadroHorarios quadroHorarios);
	public List<QuadroHorarios> listarQuadroDeHorarios();
	public QuadroHorarios buscarQuadoHorario(Funcionario funcionario);
}
