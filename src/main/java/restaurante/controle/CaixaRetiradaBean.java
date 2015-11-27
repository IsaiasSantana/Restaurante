package restaurante.controle;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import restaurante.modelo.caixaRetirada.CaixaRetirada;
import restaurante.modelo.caixaRetirada.CaixaRetiradaRN;

@ManagedBean
@ApplicationScoped
public class CaixaRetiradaBean {
	private CaixaRetirada caixaRetirada;

	public CaixaRetiradaBean(){
		caixaRetirada = new CaixaRetirada();
	}
	
	public CaixaRetirada getCaixaRetirada() {
		return caixaRetirada;
	}

	public void setCaixaRetirada(CaixaRetirada caixaRetirada) {
		this.caixaRetirada = caixaRetirada;
	}
	
	public List<CaixaRetirada> getListaRetiradas(){
		return new CaixaRetiradaRN().retiradas();
	}
	
	public void salvar(){
		if(caixaRetirada != null){
			System.out.println(caixaRetirada.getValor());
			System.out.println(caixaRetirada.getResponsavel());
			final CaixaRetiradaRN caixaRetiradaRN = new CaixaRetiradaRN();
			caixaRetiradaRN.inserir(caixaRetirada);
		}
	}
	
}
