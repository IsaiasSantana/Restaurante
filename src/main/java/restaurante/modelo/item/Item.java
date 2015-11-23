package restaurante.modelo.item;


import restaurante.modelo.lote.Lote;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * 
 * @author Thiago
 * @version 1.0
 */


@Entity
@Table(name = "item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idItem;
	
	private String nomeItem;
	
	private Integer quantidade;
	
	private String tipoItem;
	
	
	
	@OneToMany(mappedBy="item", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Lote> lote;
	
	
	
	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public List<Lote> getLote() {
		return lote;
	}

	public void setLote(List<Lote> lote) {
		this.lote = lote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		Item other = (Item) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", nomeItem=" + nomeItem + ", quantidade=" + quantidade + ", lote=" + lote
				+ "]";
	}

	

	
	
	
	
	
	
}
