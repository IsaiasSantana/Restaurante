package restaurante.modelo.funcionario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import restaurante.modelo.quadroHorarios.QuadroHorarios;

/**
 * 
 * @author alkxly
 * @author Isaï¿½asSantana
 * @see 5 de novembro de 2015
 * @version 1.0
 */
@Entity
@Table(name = "funcionario")
public  class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idFuncionario;
	private String nome;
	private String cpf;
	private float salarioBase;
	private int cargaHorariaBase;
	private transient int tipoFuncionario;
	private String categoria;
	@Temporal(TemporalType.TIME)
	private Date cargaHorariaTrabalhada;
	@Temporal(TemporalType.TIME)
	private Date horasExtras;
	private int statusContratual;
	
	/**
	 * Muitos funcionários cumprem um único quadro de horário.
	 */
	@ManyToOne
	private QuadroHorarios quadroHorario;
		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargaHorariaBase;
		result = prime * result + ((cargaHorariaTrabalhada == null) ? 0 : cargaHorariaTrabalhada.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((horasExtras == null) ? 0 : horasExtras.hashCode());
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((quadroHorario == null) ? 0 : quadroHorario.hashCode());
		result = prime * result + Float.floatToIntBits(salarioBase);
		result = prime * result + statusContratual;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Funcionario))
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargaHorariaBase != other.cargaHorariaBase)
			return false;
		if (cargaHorariaTrabalhada == null) {
			if (other.cargaHorariaTrabalhada != null)
				return false;
		} else if (!cargaHorariaTrabalhada.equals(other.cargaHorariaTrabalhada))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (horasExtras == null) {
			if (other.horasExtras != null)
				return false;
		} else if (!horasExtras.equals(other.horasExtras))
			return false;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (quadroHorario == null) {
			if (other.quadroHorario != null)
				return false;
		} else if (!quadroHorario.equals(other.quadroHorario))
			return false;
		if (Float.floatToIntBits(salarioBase) != Float.floatToIntBits(other.salarioBase))
			return false;
		if (statusContratual != other.statusContratual)
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", salarioBase="
				+ salarioBase + ", cargaHorariaBase=" + cargaHorariaBase + ", categoria=" + categoria
				+ ", cargaHorariaTrabalhada=" + cargaHorariaTrabalhada + ", horasExtras=" + horasExtras
				+ ", statusContratual=" + statusContratual + ", quadroHorario=" + quadroHorario + "]";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getCargaHorariaBase() {
		return cargaHorariaBase;
	}

	public void setCargaHorariaBase(int cargaHorariaBase) {
		this.cargaHorariaBase = cargaHorariaBase;
	}

	public Date getCargaHorariaTrabalhada() {
		return cargaHorariaTrabalhada;
	}

	public void setCargaHorariaTrabalhada(Date cargaHorariaTrabalhada) {
		this.cargaHorariaTrabalhada = cargaHorariaTrabalhada;
	}

	public Date getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(Date horasExtras) {
		this.horasExtras = horasExtras;
	}

	public int getStatusContratual() {
		return statusContratual;
	}

	public void setStatusContratual(int statusContratual) {
		this.statusContratual = statusContratual;
	}

	public QuadroHorarios getQuadroHorario() {
		return quadroHorario;
	}

	public void setQuadroHorario(QuadroHorarios quadroHorario) {
		this.quadroHorario = quadroHorario;
	}
}
