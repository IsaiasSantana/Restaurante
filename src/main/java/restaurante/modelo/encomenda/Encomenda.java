package restaurante.modelo.encomenda;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import restaurante.modelo.fornecedor.Fornecedor;
import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.lote.Lote;



/**
 * 
 * @author Thiago
 * @version 1.0
 */

@Entity
@Table (name = "encomenda")
public class Encomenda implements Serializable{
	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idEncomenda;
	
	@ManyToOne 
	private Funcionario funcionario;	
	
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "encomenda", targetEntity = Lote.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lote> listaLotes; // o mapeamento deve ser assim.	
	
	
	private Boolean chegada;


	public Integer getIdEncomenda() {
		return idEncomenda;
	}


	public void setIdEncomenda(Integer idEncomenda) {
		this.idEncomenda = idEncomenda;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public List<Lote> getListaLotes() {
		return listaLotes;
	}


	public void setListaLotes(List<Lote> listaLotes) {
		this.listaLotes = listaLotes;
	}


	public Boolean getChegada() {
		return chegada;
	}


	public void setChegada(Boolean chegada) {
		this.chegada = chegada;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chegada == null) ? 0 : chegada.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((idEncomenda == null) ? 0 : idEncomenda.hashCode());
		result = prime * result + ((listaLotes == null) ? 0 : listaLotes.hashCode());
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
		Encomenda other = (Encomenda) obj;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idEncomenda == null) {
			if (other.idEncomenda != null)
				return false;
		} else if (!idEncomenda.equals(other.idEncomenda))
			return false;
		if (listaLotes == null) {
			if (other.listaLotes != null)
				return false;
		} else if (!listaLotes.equals(other.listaLotes))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Encomenda [idEncomenda=" + idEncomenda + ", funcionario=" + funcionario + ", fornecedor=" + fornecedor
				+ ", listaLotes=" + listaLotes + ", chegada=" + chegada + "]";
	}

	


	
	
	

	
	
	
}
