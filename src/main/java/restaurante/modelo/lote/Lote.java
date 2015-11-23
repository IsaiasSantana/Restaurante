package restaurante.modelo.lote;

import restaurante.modelo.item.Item;
import restaurante.modelo.fornecedor.Fornecedor;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Thiago
 * @version 1.0
 */

@Entity
@Table(name = "lote")
public class Lote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idLote;
	
	private Integer qantdItens;
	
	private Date validade;
	
	private Boolean chegada;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Fornecedor fornecedor;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	public Item getItem() {
		return item;
	}




	public void setItem(Item item) {
		this.item = item;
	}




	public Fornecedor getFornecedor() {
		return fornecedor;
	}




	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}




	public Integer getIdLote() {
		return idLote;
	}
	
	

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}
	
	

	public Integer getQantdItens() {
		return qantdItens;
	}
	
	

	public void setQantdItens(Integer qantdItens) {
		this.qantdItens = qantdItens;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chegada == null) ? 0 : chegada.hashCode());
		result = prime * result + ((idLote == null) ? 0 : idLote.hashCode());
		result = prime * result + ((qantdItens == null) ? 0 : qantdItens.hashCode());
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
		if (idLote == null) {
			if (other.idLote != null)
				return false;
		} else if (!idLote.equals(other.idLote))
			return false;
		if (qantdItens == null) {
			if (other.qantdItens != null)
				return false;
		} else if (!qantdItens.equals(other.qantdItens))
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
		return "Lote [idLote=" + idLote + ", qantdItens=" + qantdItens + ", validade=" + validade + ", chegada="
				+ chegada + ", item=" + item + ", fornecedor=" + fornecedor + "]";
	}

	
	
	
	
	

}
