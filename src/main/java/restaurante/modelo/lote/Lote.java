package restaurante.modelo.lote;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import restaurante.modelo.encomenda.Encomenda;
import restaurante.modelo.item.Item;

/**
 * 
 * @author Thiago
 * @author isaiasSantana
 * @version 1.0
 */

@Entity
@Table(name = "lote")
public class Lote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idLote;
	
	private Integer qntdItens;
	
	private Date validade; 
	
	private Boolean chegada;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "idEncomenda")
	private Encomenda encomenda; 

	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public Integer getQntdItens() {
		return qntdItens;
	}

	public void setQntdItens(Integer qntdItens) {
		this.qntdItens = qntdItens;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Boolean getChegada() {
		return chegada;
	}

	public void setChegada(Boolean chegada) {
		this.chegada = chegada;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chegada == null) ? 0 : chegada.hashCode());
		result = prime * result + ((encomenda == null) ? 0 : encomenda.hashCode());
		result = prime * result + ((idLote == null) ? 0 : idLote.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((qntdItens == null) ? 0 : qntdItens.hashCode());
		result = prime * result + ((validade == null) ? 0 : validade.hashCode());
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
		Lote other = (Lote) obj;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (encomenda == null) {
			if (other.encomenda != null)
				return false;
		} else if (!encomenda.equals(other.encomenda))
			return false;
		if (idLote == null) {
			if (other.idLote != null)
				return false;
		} else if (!idLote.equals(other.idLote))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (qntdItens == null) {
			if (other.qntdItens != null)
				return false;
		} else if (!qntdItens.equals(other.qntdItens))
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", qntdItens=" + qntdItens + ", validade=" + validade + ", chegada=" + chegada
				+ ", item=" + item + ", encomenda=" + encomenda + "]";
	}
}
