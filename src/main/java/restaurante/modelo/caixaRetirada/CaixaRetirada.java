package restaurante.modelo.caixaRetirada;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import restaurante.modelo.caixa.Caixa;

/**
 * 
 * @author IsaíasSantana
 *
 */
@Entity
@Table(name="caixa_retirada")
public class CaixaRetirada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idRetirada;
	private String rotulo;
	private double valor;
	@ManyToOne
	private Caixa caixa;
	private Integer responsavel;
	private Timestamp timeStamp;
	
	
	
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public Integer getIdRetirada() {
		return idRetirada;
	}
	public void setIdRetirada(Integer idRetirada) {
		this.idRetirada = idRetirada;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Integer responsavel) {
		this.responsavel = responsavel;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((idRetirada == null) ? 0 : idRetirada.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((rotulo == null) ? 0 : rotulo.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CaixaRetirada))
			return false;
		CaixaRetirada other = (CaixaRetirada) obj;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (idRetirada == null) {
			if (other.idRetirada != null)
				return false;
		} else if (!idRetirada.equals(other.idRetirada))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (rotulo == null) {
			if (other.rotulo != null)
				return false;
		} else if (!rotulo.equals(other.rotulo))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CaixaRetirada [idRetirada=" + idRetirada + ", rotulo=" + rotulo + ", valor=" + valor + ", caixa="
				+ caixa + ", responsavel=" + responsavel + ", timeStamp=" + timeStamp + "]";
	}
}
