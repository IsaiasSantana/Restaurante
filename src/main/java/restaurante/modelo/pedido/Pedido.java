package restaurante.modelo.pedido;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import restaurante.modelo.comanda.Comanda;

import restaurante.modelo.produto.Produto;


/**
 * 
 * @author dgaramos
 * @version 1.0
 */

@Entity
@Table (name = "pedido")
public class Pedido implements Serializable{
	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idPedido;
	
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private Comanda comanda;
	
	
	@OneToOne
	private Produto produto;

	
	private Integer qntd;
	private Boolean statusPedido;
	private Timestamp horaRealizado;
	private Timestamp horaAtendido;
	
	//@ManyToOne
	//private Garcom garcomResponsavel;
	
	
	/**
	 * 
	 */
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQntd() {
		return qntd;
	}
	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}
	public Boolean getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(Boolean statusPedido) {
		this.statusPedido = statusPedido;
	}
	public Timestamp getHoraRealizado() {
		return horaRealizado;
	}
	public void setHoraRealizado(Timestamp horaRealizado) {
		this.horaRealizado = horaRealizado;
	}
	public Timestamp getHoraAtendido() {
		return horaAtendido;
	}
	public void setHoraAtendido(Timestamp horaAtendido) {
		this.horaAtendido = horaAtendido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
		result = prime * result + ((horaAtendido == null) ? 0 : horaAtendido.hashCode());
		result = prime * result + ((horaRealizado == null) ? 0 : horaRealizado.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qntd == null) ? 0 : qntd.hashCode());
		result = prime * result + ((statusPedido == null) ? 0 : statusPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (comanda == null) {
			if (other.comanda != null)
				return false;
		} else if (!comanda.equals(other.comanda))
			return false;
		if (horaAtendido == null) {
			if (other.horaAtendido != null)
				return false;
		} else if (!horaAtendido.equals(other.horaAtendido))
			return false;
		if (horaRealizado == null) {
			if (other.horaRealizado != null)
				return false;
		} else if (!horaRealizado.equals(other.horaRealizado))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qntd == null) {
			if (other.qntd != null)
				return false;
		} else if (!qntd.equals(other.qntd))
			return false;
		if (statusPedido == null) {
			if (other.statusPedido != null)
				return false;
		} else if (!statusPedido.equals(other.statusPedido))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", comanda=" + comanda + ", produto=" + produto + ", qntd=" + qntd
				+ ", statusPedido=" + statusPedido + ", horaRealizado=" + horaRealizado + ", horaAtendido="
				+ horaAtendido + "]";
	}

	
	
	
}
