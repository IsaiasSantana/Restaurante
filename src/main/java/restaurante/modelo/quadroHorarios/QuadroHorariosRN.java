package restaurante.modelo.quadroHorarios;

import java.util.List;

import restaurante.util.DAOFactory;

public class QuadroHorariosRN {
	
	private QuadroHorariosDAO quadroHorariosDAO;
	
	public QuadroHorariosRN(){
		quadroHorariosDAO = DAOFactory.criarQuadroHorariosDAO();
	}
	
	public void salvar(QuadroHorarios quadroHorario){
		quadroHorariosDAO.salvar(quadroHorario);
	}
	
	public List<QuadroHorarios> listarQuadroDeHorarios() {
		return quadroHorariosDAO.listarQuadroDeHorarios();
	}
	
}
