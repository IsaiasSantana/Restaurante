package restaurante.modelo.encomenda;

import restaurante.modelo.fornecedor.Fornecedor;
import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.item.Item;
import restaurante.modelo.lote.Lote;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

//import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Thiago
 * @version 1.0
 */

public class EncomendaLote implements Serializable{
	


	private static final long serialVersionUID = 1L;

	
	private Integer idEncomenda;
	
	
	private Funcionario funcionario;	
	

	private Fornecedor fornecedor;
	
	
	private transient List<Lote> listaLotes;	
	
	
	private Boolean chegada;
	
	private Integer idLote;
	
	private Integer qntdItens;
	
	private Date validade;
	
	private Item item;


	private Session session;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
		result = prime * result + ((idLote == null) ? 0 : idLote.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((listaLotes == null) ? 0 : listaLotes.hashCode());
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
		EncomendaLote other = (EncomendaLote) obj;
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
		if (listaLotes == null) {
			if (other.listaLotes != null)
				return false;
		} else if (!listaLotes.equals(other.listaLotes))
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
		return "EncomendaLote [idEncomenda=" + idEncomenda + ", funcionario=" + funcionario + ", fornecedor="
				+ fornecedor + ", listaLotes=" + listaLotes + ", chegada=" + chegada + ", idLote=" + idLote
				+ ", qntdItens=" + qntdItens + ", validade=" + validade + ", item=" + item + "]";
	}
	
	
	public List<EncomendaLote> listarEncomendas() {
		// TODO Auto-generated method stub
		Query querySql = this.session.createSQLQuery("select * from encomenda join lote on encomenda.idEncomenda = lote.idLote");
		List<EncomendaLote> lista = querySql.list();
		return lista;
	}

	
	
	
}
