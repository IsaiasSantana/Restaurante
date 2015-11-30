package restaurante.modelo.quadroHorarios;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author IsaíasSantana
 *
 */
@Entity
@Table(name="quadro_horarios")
public class QuadroHorarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idQuadroHorarios;
	@Temporal(TemporalType.TIME)
	private Date horaDeChegada;
	@Temporal(TemporalType.TIME)
	private Date horaDeSaida;
	
	public Integer getIdQuadroHorarios() {
		return idQuadroHorarios;
	}
	
	public void setIdQuadroHorarios(Integer idQuadroHorarios) {
		this.idQuadroHorarios = idQuadroHorarios;
	}
	
	public Date getHoraDeChegada() {
		return horaDeChegada;
	}
	
	public void setHoraDeChegada(Date horaDeChegada) {
		this.horaDeChegada = horaDeChegada;
	}
	
	public Date getHoraDeSaida() {
		return horaDeSaida;
	}
	
	public void setHoraDeSaida(Date horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaDeChegada == null) ? 0 : horaDeChegada.hashCode());
		result = prime * result + ((horaDeSaida == null) ? 0 : horaDeSaida.hashCode());
		result = prime * result + ((idQuadroHorarios == null) ? 0 : idQuadroHorarios.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof QuadroHorarios))
			return false;
		QuadroHorarios other = (QuadroHorarios) obj;
		if (horaDeChegada == null) {
			if (other.horaDeChegada != null)
				return false;
		} else if (!horaDeChegada.equals(other.horaDeChegada))
			return false;
		if (horaDeSaida == null) {
			if (other.horaDeSaida != null)
				return false;
		} else if (!horaDeSaida.equals(other.horaDeSaida))
			return false;
		if (idQuadroHorarios == null) {
			if (other.idQuadroHorarios != null)
				return false;
		} else if (!idQuadroHorarios.equals(other.idQuadroHorarios))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuadroHorarios [idQuadroHorarios=" + idQuadroHorarios + ", horaDeChegada=" + horaDeChegada
				+ ", horaDeSaida=" + horaDeSaida + "]";
	}	
}