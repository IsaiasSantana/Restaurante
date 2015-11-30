package restaurante.controle;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import restaurante.modelo.encomenda.Encomenda;
import restaurante.modelo.encomenda.EncomendaRN;
import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.funcionario.FuncionarioRN;
import restaurante.modelo.item.Item;
import restaurante.modelo.item.ItemRN;
import restaurante.modelo.fornecedor.Fornecedor;
import restaurante.modelo.fornecedor.FornecedorRN;
import restaurante.modelo.lote.Lote;
import restaurante.modelo.lote.LoteRN;

import restaurante.util.Mensagens;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean (name = "encomendaBean")
@RequestScoped
public class EncomendaBean {
	
	private Encomenda encomenda;
	private Encomenda encomendaSelecionada;
	private Lote loteSelecionado;
	private List<Encomenda> listaEncomenda;
	private Integer idFuncionario;
	private Integer idFornecedor;
	private Integer idEncomenda;
	private Integer idLote;
	private Funcionario funcionario;
	private Lote lote;
	private Fornecedor fornecedor;
	private List<Lote> listaLote;
	private Item item;
	private List<Item> listaItem;
	private Integer idItem;
	private List<Funcionario> listaFuncionario;
	private List<Fornecedor> listaFornecedor;
	private Integer quantidade;
	private Date validade;	

	public EncomendaBean(){
		this.encomenda = new Encomenda();
		this.encomendaSelecionada = new Encomenda();
		this.loteSelecionado = new Lote();
		this.listaEncomenda = new ArrayList<Encomenda>();
		this.lote = new Lote();
		this.listaLote = new ArrayList<Lote>();
		this.funcionario = new Funcionario();
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.fornecedor = new Fornecedor();
		this.listaFornecedor = new ArrayList<Fornecedor>();
		this.item = new Item();
		this.listaItem = new ArrayList<Item>();
		this.validade = new Date();
	}
	

	/**
	 * Salva uma encomenda
	 * @return retorna uma string para a listagem de encomendas
	 */
	public String salvarEncomenda(){
		
		if(this.encomenda !=null){
			
			//puxa o respectivo fornecedor que entrega a encomenda 
           	for(Fornecedor fornecedor : listaFornecedor){
            	if(fornecedor.getIdFornecedor().equals(this.idFornecedor)){
            		this.fornecedor = fornecedor;
            	}
            }
           	
           	this.encomenda.setFornecedor(fornecedor);
           	
           	//puxa o respectivo funcionario que fez a encomenda
           	for(Funcionario responsavel : listaFuncionario){
            	if(responsavel.getIdFuncionario().equals(idFuncionario)){
            		this.funcionario = responsavel;
            	}
            }
           	
           	this.encomenda.setFuncionario(funcionario);
           	
           	this.listaLote.add(lote);
           	this.encomenda.setListaLotes(listaLote);
           	this.lote.setEncomenda(encomenda);	
           	this.encomenda.setChegada(false);
         
        	this.lote.setChegada(this.encomenda.getChegada());
        	        	
        	for(Item item : listaItem){
            	if(item.getIdItem().equals(idItem)){
            		this.item = item;
            	}
            }
        	
        	this.lote.setItem(item); 
        
           	LoteRN loteRN = new LoteRN();
           	loteRN.salvar(lote);
           	EncomendaRN encomendaRN = new EncomendaRN();
           	encomendaRN.salvar(encomenda);
           	
			Mensagens.adicionarMensagemConfirmacao("Encomenda cadastrada com sucesso");
			this.encomenda = new Encomenda();
			this.lote = new Lote();
			this.listaLote = new ArrayList<Lote>();
			this.listaItem = new ArrayList<Item>();
		}
		return "listarEncomenda";
	}
	
	/**
	 * Altera o status de chegada de uma encomenda quando esta chega ao restaurante
	 * @return
	 */
	public String marcarChegada(){
		
		this.lote.setChegada(true);
		this.loteSelecionado.getEncomenda().setChegada(this.lote.getChegada());
		this.listaEncomenda.removeAll(listaEncomenda);
		this.listaLote.removeAll(listaLote);
		Mensagens.adicionarMensagemConfirmacao("Encomenda foi marcada como entregue");
		return null;
	}
	
	/**
	 * Lista todas a encomendas
	 * @return uma string representando a url da página de listagem de encomendas.
	 */
	public String listarEncomendaJSF(){	
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("listarEncomenda");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/listarEncomenda";
	}
	
	/**
	 * Exclui uma determinada encomenda
	 */
	public void excluirEncomenda(){
		
		EncomendaRN encomendaRN = new EncomendaRN();
		try {
			//pega o lote recupera o id da encomenda que ele está associado e apaga essa encomenda	
			encomendaRN.excluir(encomendaRN.carregar(loteSelecionado.getEncomenda().getIdEncomenda()));
			Mensagens.adicionarMensagemConfirmacao("Encomenda excluida");	
		} 
		catch (Exception e) {
			Mensagens.adicionarMensagemErro("Não foi possivel excluir a encomenda");	
		}	
	}
	
	/*
	 * Getters e Setters
	 */

	public Lote getLoteSelecionado() {
		return loteSelecionado;
	}

	public void setLoteSelecionado(Lote loteSelecionado) {
		this.loteSelecionado = loteSelecionado;
	}
	
	
	public Integer getIdItem() {
		return idItem;
	}
	
	
	public Integer getIdEncomenda() {
		return idEncomenda;
	}

	
	public void setIdEncomenda(Integer idEncomenda) {
		this.idEncomenda = idEncomenda;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	public Date getValidade() {
		return validade;
	}

	
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	
	public Item getItem() {
		return item;
	}

	
	public void setItem(Item item) {
		this.item = item;
	}

	
	public List<Item> getListaItem() {
		ItemRN itemRN = new ItemRN();
		this.listaItem = itemRN.listar();
		return this.listaItem;
	}

	
	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}

	
	public String editar(){
		return "cadastroEncomenda";
	}
	
	
	public Encomenda getEncomenda() {
		return encomenda;
	}

	
	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	
	public Lote getLote() {
		return lote;
	}

	
	public void setLote(Lote lote) {
		this.lote = lote;
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
	

	public List<Encomenda> getListaEncomenda() {
		EncomendaRN encomendaRN = new EncomendaRN();
		this.listaEncomenda = encomendaRN.listarEncomenda();
		return this.listaEncomenda;
	}


	public void setListaEncomenda(List<Encomenda> listaEncomenda) {
		this.listaEncomenda = listaEncomenda;
	}

	
	public List<Lote> getListaLote() {
		LoteRN loteRN = new LoteRN();
		this.listaLote = loteRN.listar();
		return this.listaLote;
	}


	public void setListaLote(List<Lote> listaLote) {
		this.listaLote = listaLote;
	}
	
	
	public List<Funcionario> getListaFuncionario() {
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		this.listaFuncionario = funcionarioRN.listarFuncionarios();
		return this.listaFuncionario;
	}


	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	
	
	public List<Fornecedor> getListaFornecedor() {
		FornecedorRN fornecedorRN = new FornecedorRN();
		this.listaFornecedor = fornecedorRN.listar();
		return this.listaFornecedor;
	}


	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}
	
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	public Integer getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	
	public Integer getIdLote() {
		return idLote;
	}

	
	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}
	
	
	public Encomenda getEncomendaSelecionada() {
		return encomendaSelecionada;
	}

	
	public void setEncomendaSelecionada(Encomenda encomendaSelecionada) {
		this.encomendaSelecionada = encomendaSelecionada;
	}	
}