package restaurante.modelo.retiradaitem;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.item.Item;

@Entity
@Table (name="retiradaitem")
public class RetiradaItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idSaida;
	
	@OneToOne
	private Funcionario responsavelRetirada;
	
	@ManyToOne
	private Item itemRetirado;
	
	private Integer qtdRetirada;
	
	private Timestamp horaRetirada;

	public Integer getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(Integer idSaida) {
		this.idSaida = idSaida;
	}

	public Funcionario getResponsavelRetirada() {
		return responsavelRetirada;
	}

	public void setResponsavelRetirada(Funcionario responsavelRetirada) {
		this.responsavelRetirada = responsavelRetirada;
	}

	public Item getItemRetirado() {
		return itemRetirado;
	}

	public void setItemRetirado(Item itemRetirado) {
		this.itemRetirado = itemRetirado;
	}

	public Integer getQtdRetirada() {
		return qtdRetirada;
	}

	public void setQtdRetirada(Integer qtdRetirada) {
		this.qtdRetirada = qtdRetirada;
	}

	public Timestamp getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraRetirada(Timestamp horaRetirada) {
		this.horaRetirada = horaRetirada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaRetirada == null) ? 0 : horaRetirada.hashCode());
		result = prime * result + ((idSaida == null) ? 0 : idSaida.hashCode());
		result = prime * result + ((itemRetirado == null) ? 0 : itemRetirado.hashCode());
		result = prime * result + ((qtdRetirada == null) ? 0 : qtdRetirada.hashCode());
		result = prime * result + ((responsavelRetirada == null) ? 0 : responsavelRetirada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetiradaItem other = (RetiradaItem) obj;
		if (horaRetirada == null) {
			if (other.horaRetirada != null)
				return false;
		} else if (!horaRetirada.equals(other.horaRetirada))
			return false;
		if (idSaida == null) {
			if (other.idSaida != null)
				return false;
		} else if (!idSaida.equals(other.idSaida))
			return false;
		if (itemRetirado == null) {
			if (other.itemRetirado != null)
				return false;
		} else if (!itemRetirado.equals(other.itemRetirado))
			return false;
		if (qtdRetirada == null) {
			if (other.qtdRetirada != null)
				return false;
		} else if (!qtdRetirada.equals(other.qtdRetirada))
			return false;
		if (responsavelRetirada == null) {
			if (other.responsavelRetirada != null)
				return false;
		} else if (!responsavelRetirada.equals(other.responsavelRetirada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RetiradaItem [idSaida=" + idSaida + ", responsavelRetirada=" + responsavelRetirada + ", itemRetirado="
				+ itemRetirado + ", qtdRetirada=" + qtdRetirada + ", horaRetirada=" + horaRetirada + "]";
	}
	
	
	
	
	
	

}
