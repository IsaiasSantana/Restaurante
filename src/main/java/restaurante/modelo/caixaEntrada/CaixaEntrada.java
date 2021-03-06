package restaurante.modelo.caixaEntrada;

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
@Table(name="caixa_entrada")
public class CaixaEntrada implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idEntrada;
	private String rotulo;
	private boolean cartao;
	private double valor;
	
	private Timestamp timeStamp;
	
	@ManyToOne
	private Caixa caixa;
	
	private Integer responsavel;
	
	public Integer getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public boolean isCartao() {
		return cartao;
	}
	public void setCartao(boolean cartao) {
		this.cartao = cartao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Integer responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + (cartao ? 1231 : 1237);
		result = prime * result + ((idEntrada == null) ? 0 : idEntrada.hashCode());
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
		if (!(obj instanceof CaixaEntrada))
			return false;
		CaixaEntrada other = (CaixaEntrada) obj;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (cartao != other.cartao)
			return false;
		if (idEntrada == null) {
			if (other.idEntrada != null)
				return false;
		} else if (!idEntrada.equals(other.idEntrada))
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
		return "CaixaEntrada [idEntrada=" + idEntrada + ", rotulo=" + rotulo + ", cartao=" + cartao + ", valor=" + valor
				+ ", timeStamp=" + timeStamp + ", caixa=" + caixa + ", responsavel=" + responsavel + "]";
	}
}
