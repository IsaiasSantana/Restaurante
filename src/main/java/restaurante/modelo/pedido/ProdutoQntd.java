package restaurante.modelo.pedido;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import restaurante.modelo.produto.Produto;


/**
 * 
 * @author dgaramos
 * @version 1.0
 */

@Entity
@Table (name = "produtoQntd")
public class ProdutoQntd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idProdutoQntd;
	
	@OneToOne
	private Produto produto;
	
	@ManyToOne
	private Pedido pedido;
	
	private Integer qntd;
	public Integer getIdProdutoQntd() {
		return idProdutoQntd;
	}
	public void setIdProdutoQntd(Integer idProdutoQntd) {
		this.idProdutoQntd = idProdutoQntd;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProdutoQntd == null) ? 0 : idProdutoQntd.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qntd == null) ? 0 : qntd.hashCode());
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
		ProdutoQntd other = (ProdutoQntd) obj;
		if (idProdutoQntd == null) {
			if (other.idProdutoQntd != null)
				return false;
		} else if (!idProdutoQntd.equals(other.idProdutoQntd))
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
		return true;
	}
	@Override
	public String toString() {
		return "ProdutoQntd [idProdutoQntd=" + idProdutoQntd + ", produto=" + produto + ", qntd=" + qntd + "]";
	}

	
}
