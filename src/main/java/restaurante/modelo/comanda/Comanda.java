package restaurante.modelo.comanda;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import restaurante.modelo.pedido.Pedido;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

@Entity
@Table (name="comanda")
public class Comanda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idComanda;
	
	private Integer nMesa;
	private String responsavel;
	
	@OneToMany (mappedBy = "comanda", cascade= CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> listaPedidos;
	
	private Boolean comandaInativa;
	
	/**
	 * 
	 */
	
	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getnMesa() {
		return nMesa;
	}

	public void setnMesa(Integer nMesa) {
		this.nMesa = nMesa;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Boolean getComandaInativa() {
		return comandaInativa;
	}

	public void setComandaInativa(Boolean comandaInativa) {
		this.comandaInativa = comandaInativa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", nMesa=" + nMesa + ", cpfResponsavel=" + responsavel
				+ ", listaPedidos=" + listaPedidos + ", comandaInativa=" + comandaInativa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comandaInativa == null) ? 0 : comandaInativa.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((idComanda == null) ? 0 : idComanda.hashCode());
		result = prime * result + ((listaPedidos == null) ? 0 : listaPedidos.hashCode());
		result = prime * result + ((nMesa == null) ? 0 : nMesa.hashCode());
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
		Comanda other = (Comanda) obj;
		if (comandaInativa == null) {
			if (other.comandaInativa != null)
				return false;
		} else if (!comandaInativa.equals(other.comandaInativa))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (idComanda == null) {
			if (other.idComanda != null)
				return false;
		} else if (!idComanda.equals(other.idComanda))
			return false;
		if (listaPedidos == null) {
			if (other.listaPedidos != null)
				return false;
		} else if (!listaPedidos.equals(other.listaPedidos))
			return false;
		if (nMesa == null) {
			if (other.nMesa != null)
				return false;
		} else if (!nMesa.equals(other.nMesa))
			return false;
		return true;
	}

	
}
