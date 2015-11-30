package restaurante.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import restaurante.modelo.quadroHorarios.QuadroHorarios;
import restaurante.modelo.quadroHorarios.QuadroHorariosRN;
import restaurante.util.Mensagens;

@ManagedBean
@RequestScoped

/**
 * 
 * @author IsaíasSantana
 *
 */
public class QuadroHorariosBean {
	
	private QuadroHorarios quadroHorarios;
	private List<QuadroHorarios> quadroHorariosList;
	private QuadroHorariosRN quadroHorarioRN;
	
	public QuadroHorariosBean(){
		quadroHorarios = new QuadroHorarios();
		quadroHorarioRN = new QuadroHorariosRN();
	}

	public QuadroHorarios getQuadroHorarios() {
		return quadroHorarios;
	}

	public void setQuadroHorarios(QuadroHorarios quadroHorarios) {
		this.quadroHorarios = quadroHorarios;
	}
	
	/**
	 * 
	 * @return uma lista com todos os quadros de horários disponíveis.
	 */
	public List<QuadroHorarios> getQuadroHorariosList() {
		if(quadroHorariosList == null) quadroHorariosList = quadroHorarioRN.listarQuadroDeHorarios();
		return quadroHorariosList;
	}

	public void setQuadroHorariosList(List<QuadroHorarios> quadroHorariosList) {
		this.quadroHorariosList = quadroHorariosList;
	}
	
	/**
	 * Salva um novo quadro de horário.
	 * @return retorna null para permanecer na mesma página.
	 */
	public String salvar()
	{
		if(this.quadroHorarios != null)
		{
			quadroHorarioRN.salvar(quadroHorarios);
			Mensagens.adicionarMensagemConfirmacao("Quadro de horário cadastrado");
			this.quadroHorarios = new QuadroHorarios();
			
		}
		return null;
	}
}
