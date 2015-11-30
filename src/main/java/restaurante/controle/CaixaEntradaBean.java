package restaurante.controle;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import restaurante.modelo.caixa.Caixa;
import restaurante.modelo.caixaEntrada.CaixaEntrada;
import restaurante.modelo.caixaEntrada.CaixaEntradaRN;
import restaurante.modelo.funcionario.Funcionario;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean
@ApplicationScoped
public class CaixaEntradaBean {
	
	private CaixaEntrada caixaEntrada;
	private Caixa caixa;
	private Funcionario funcionarioResponsavel;
	
	public CaixaEntradaBean(){
		caixaEntrada = new CaixaEntrada();
		caixa = new Caixa();
		funcionarioResponsavel = new Funcionario();
	}
	
	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public CaixaEntrada getCaixaEntrada() {
		return caixaEntrada;
	}

	public void setCaixaEntrada(CaixaEntrada caixaEntrada) {
		this.caixaEntrada = caixaEntrada;
	}
	
	
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<Caixa> getListaCaixas(){
		return new CaixaEntradaRN().caixas();
	}
	
	public List<CaixaEntrada> getListaCaixaEntradas(){
		return new CaixaEntradaRN().listaCaixaEntradas();
	}
	
	public void setResponsavel(Funcionario funcionario){
		this.funcionarioResponsavel = funcionario;
	}
	
	/**
	 * Salva uma entrada de dinheiro no caixa.
	 */
	public void salvar()
	{
		CaixaEntradaRN cERN = new CaixaEntradaRN();
		caixaEntrada.setCaixa(caixa);
		cERN.cadastradaEntradaCaixa(caixaEntrada);
	}
	
}
