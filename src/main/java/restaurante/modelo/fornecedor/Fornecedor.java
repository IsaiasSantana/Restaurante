package restaurante.modelo.fornecedor;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import restaurante.modelo.contato.Contato;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{
	
	

	private static final long serialVersionUID = 3312734899491331741L;

	@Id
	@GeneratedValue
	private Integer idFornecedor;
	
	private String nome;
	
	private String tipoDeFornecedor;
	
	@OneToOne( fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}) 
	private Contato contato;
	
	public Integer getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDeFornecedor() {
		return tipoDeFornecedor;
	}
	public void setTipoDeFornecedor(String tipoDeFornecedor) {
		this.tipoDeFornecedor = tipoDeFornecedor;
	}
	
	
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFornecedor == null) ? 0 : idFornecedor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((tipoDeFornecedor == null) ? 0 : tipoDeFornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (idFornecedor == null) {
			if (other.idFornecedor != null)
				return false;
		} else if (!idFornecedor.equals(other.idFornecedor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoDeFornecedor == null) {
			if (other.tipoDeFornecedor != null)
				return false;
		} else if (!tipoDeFornecedor.equals(other.tipoDeFornecedor))
			return false;
		return true;
	}
	

	
	
}
