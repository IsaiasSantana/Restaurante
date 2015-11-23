package restaurante.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import restaurante.modelo.quadroHorarios.QuadroHorarios;
import restaurante.modelo.quadroHorarios.QuadroHorariosRN;
import restaurante.util.Mensagens;

@ManagedBean
@RequestScoped
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
	
	
	
	public List<QuadroHorarios> getQuadroHorariosList() {
		if(quadroHorariosList == null) quadroHorariosList = quadroHorarioRN.listarQuadroDeHorarios();
		return quadroHorariosList;
	}

	public void setQuadroHorariosList(List<QuadroHorarios> quadroHorariosList) {
		this.quadroHorariosList = quadroHorariosList;
	}

	public String salvar()
	{
		if(this.quadroHorarios != null)
		{
			System.out.println("Hora de chegada: "+   this.quadroHorarios.getHoraDeChegada().getHours()+":"+quadroHorarios.getHoraDeChegada().getMinutes()+":"+quadroHorarios.getHoraDeChegada().getSeconds());
			System.out.println("Hora de saída: "+     this.quadroHorarios.getHoraDeSaida().getHours()+":"+quadroHorarios.getHoraDeChegada().getMinutes()+":"+quadroHorarios.getHoraDeChegada().getSeconds());
			quadroHorarioRN.salvar(quadroHorarios);
			Mensagens.adicionarMensagemConfirmacao("Quadro de horário cadastrado");
			this.quadroHorarios = new QuadroHorarios();
			
		}
		return null;
	}
	
}
