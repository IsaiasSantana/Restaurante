package restaurante.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import restaurante.modelo.caixa.Caixa;
import restaurante.modelo.caixa.CaixaRN;
import restaurante.modelo.caixaEntrada.CaixaEntradaRN;
import restaurante.modelo.funcionario.Funcionario;
import restaurante.util.Mensagens;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean
@ApplicationScoped
public class CaixaBean {
	
	private Caixa caixa;
	private Funcionario funcionarioResponsavel;
	private double totalEntrada, totalSaida;
	private List<Caixa> caixas;
	
	/**
	 * Construtor, inicializa algumas variáveis do caixa.
	 */
	public CaixaBean(){
		init();
	}
	
	private void init(){
		caixa = new Caixa();
		caixas = null;
		funcionarioResponsavel = new Funcionario();
	}

	
	/**
	 * 
	 * @return retorna uma lista contendo todos os gerentes que podem gerenciar um caixa.
	 */
	public List<SelectItem> getGerentes(){
		final CaixaRN caixaRN = new CaixaRN();
		final List<Funcionario> listaGerentes  = caixaRN.buscarGerentes();
		SelectItem lista[];
		SelectItemGroup grupoGerente;
		List<SelectItem> gerentes;
		
		if(listaGerentes.size() == 0){
			lista = new SelectItem[1];
			lista[0] = new SelectItem(null,"Nenhum gerente cadastrado no sistema ainda.");
			grupoGerente = new SelectItemGroup("Gerentes");
			grupoGerente.setSelectItems(lista);
			gerentes = new ArrayList<>(1);
			gerentes.add(grupoGerente);
		}
		else{
			lista = new SelectItem[caixaRN.buscarGerentes().size()+1];
		    grupoGerente = new SelectItemGroup("Gerentes");
		    lista[0] = new SelectItem(null,"Selecione um gerente");
			for(int i = 1; i <= listaGerentes.size(); i++){
				lista[i] = new SelectItem((Funcionario)listaGerentes.get(i-1),listaGerentes.get(i-1).getNome());
			}
			grupoGerente.setSelectItems(lista);
			gerentes = new ArrayList<>();
			gerentes.add(grupoGerente);
		}
		
		return gerentes;
	}
	
	/**
	 * Salva um caixa no banco. Se já existir um caixa cadastrado, uma mensagem de erro será mostrada
	 * Indicando que já existe um caixa para o restaurante.
	 */
	public void salvar(){
		if(caixa.getIdCaixa() != null){
			if(funcionarioResponsavel != null){
				caixa.setResponsavelAbertura(funcionarioResponsavel);
				caixa.setResponsavelFechamento(funcionarioResponsavel);
			}
			try{
				final CaixaEntradaRN cer = new CaixaEntradaRN();
				List<Caixa> caixaBanco = cer.caixas();
				if(caixaBanco.isEmpty())
				{
					CaixaRN caixaRN = new CaixaRN();
					caixaRN.inserir(caixa);
					Mensagens.adicionarMensagemConfirmacao("Caixa cadastrado com sucesso!");
				}
				else Mensagens.adicionarMensagemErro("Já existe um caixa cadastrado chamado "+caixaBanco.get(0).getIdCaixa());
				
			}
			catch(Exception e){
				Mensagens.adicionarMensagemConfirmacao("Não foi possível cadastrar o caixa");
			}

		}
		funcionarioResponsavel = new Funcionario();
		caixa = new Caixa();		
	}
	
	/**
	 * Fecha o caixa do dia, faz a soma de todas entradas, todas as saídas, calcula
	 * A diferença entre entradas-saídas e insere o valor arrecadado no caixa.
	 */
	public void fecharCaixa(){
		final double[] valores = new CaixaRN().fecharCaixa();
		caixa.setTotalCaixa(valores[0]-valores[1]);
		totalEntrada = valores[0];
		totalSaida = valores[1];
	}
	
	/*
	 * Getters e Setters
	 */
	
	public double getTotalEntrada() {
		return totalEntrada;
	}

	public double getTotalSaida() {
		return totalSaida;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}	
}