package restaurante.modelo.produto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

@Entity
@Table (name= "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idProduto;
	private String nome;
	private Boolean isRefeicao;
	private double preco;
	
	/**
	 * 
	 */
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getIsRefeicao() {
		return isRefeicao;
	}
	public void setIsRefeicao(Boolean isRefeicao) {
		this.isRefeicao = isRefeicao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((isRefeicao == null) ? 0 : isRefeicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = (int) (prime * result + preco);
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (isRefeicao == null) {
			if (other.isRefeicao != null)
				return false;
		} else if (!isRefeicao.equals(other.isRefeicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco != other.preco)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", isRefeicao=" + isRefeicao + ", preco=" + preco
				+ "]";
	}
	
	
}
