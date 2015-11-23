package restaurante.modelo.contato;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import restaurante.modelo.fornecedor.Fornecedor;

@Entity
@Table(name = "contato")
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idContato;

	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String telefone;
	
	@Column(unique = true)
	private String celular;
	
	@OneToOne(mappedBy = "contato",fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})  
	private Fornecedor fornecedor;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Integer getIdContato() {
		return idContato;
	}
	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result
				+ ((idContato == null) ? 0 : idContato.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (idContato == null) {
			if (other.idContato != null)
				return false;
		} else if (!idContato.equals(other.idContato))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", email=" + email
				+ ", telefone=" + telefone + ", celular=" + celular + "]";
	}

	
}
