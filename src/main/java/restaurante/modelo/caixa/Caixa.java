package restaurante.modelo.caixa;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import restaurante.modelo.caixaEntrada.CaixaEntrada;
import restaurante.modelo.caixaRetirada.CaixaRetirada;
import restaurante.modelo.funcionario.Funcionario;

/**
 * 
 * @author IsaíasSantana
 *
 */
@Entity
@Table(name="caixa")
public class Caixa {
	@Id
	@GeneratedValue
	private Integer idCaixa;
	private Date dia;
	private double totalCaixa;
	private transient List<CaixaEntrada> listaEntradas;
	private transient List<CaixaRetirada> listaSaidas;
	
	@ManyToOne
	private Funcionario responsavelAbertura;
	
	@ManyToOne
	private Funcionario responsavelFechamento;
	
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public double getTotalCaixa() {
		return totalCaixa;
	}
	public void setTotalCaixa(double totalCaixa) {
		this.totalCaixa = totalCaixa;
	}
	public List<CaixaEntrada> getListaEntradas() {
		return listaEntradas;
	}
	public void setListaEntradas(List<CaixaEntrada> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}
	public List<CaixaRetirada> getListaSaidas() {
		return listaSaidas;
	}
	public void setListaSaidas(List<CaixaRetirada> listaSaidas) {
		this.listaSaidas = listaSaidas;
	}
	public Funcionario getResponsavelAbertura() {
		return responsavelAbertura;
	}
	public void setResponsavelAbertura(Funcionario responsavelAbertura) {
		this.responsavelAbertura = responsavelAbertura;
	}
	public Funcionario getResponsavelFechamento() {
		return responsavelFechamento;
	}
	public void setResponsavelFechamento(Funcionario responsavelFechamento) {
		this.responsavelFechamento = responsavelFechamento;
	}
	
	public Integer getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(Integer idCaixa) {
		this.idCaixa = idCaixa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((idCaixa == null) ? 0 : idCaixa.hashCode());
		result = prime * result + ((responsavelAbertura == null) ? 0 : responsavelAbertura.hashCode());
		result = prime * result + ((responsavelFechamento == null) ? 0 : responsavelFechamento.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCaixa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Caixa))
			return false;
		Caixa other = (Caixa) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (idCaixa == null) {
			if (other.idCaixa != null)
				return false;
		} else if (!idCaixa.equals(other.idCaixa))
			return false;
		if (responsavelAbertura == null) {
			if (other.responsavelAbertura != null)
				return false;
		} else if (!responsavelAbertura.equals(other.responsavelAbertura))
			return false;
		if (responsavelFechamento == null) {
			if (other.responsavelFechamento != null)
				return false;
		} else if (!responsavelFechamento.equals(other.responsavelFechamento))
			return false;
		if (Double.doubleToLongBits(totalCaixa) != Double.doubleToLongBits(other.totalCaixa))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Caixa [idCaixa=" + idCaixa + ", dia=" + dia + ", totalCaixa=" + totalCaixa + ", responsavelAbertura="
				+ responsavelAbertura + ", responsavelFechamento=" + responsavelFechamento + "]";
	}
}
