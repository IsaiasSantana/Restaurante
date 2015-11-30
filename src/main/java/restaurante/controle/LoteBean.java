package restaurante.controle;

/**
 * 
 * @author Thiago
 * @version 1.0
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import restaurante.modelo.lote.Lote;
import restaurante.modelo.lote.LoteRN;
import restaurante.modelo.item.Item;
import restaurante.modelo.item.ItemRN;

import restaurante.util.Mensagens;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean(name = "loteBean")
@RequestScoped
public class LoteBean {

	private Lote lote;
	private Lote loteSelecionado;
	private List<Lote> listaLote;
	private Item item;
	private List<Item> listaItem;
	private Integer idItem;
	private Integer idLote;
	private int qtd;
	private Date validade;
	
	public LoteBean(){
		this.lote = new Lote();
		this.loteSelecionado = new Lote();
		this.listaLote =  new ArrayList<Lote>();
		this.item = new Item();
		this.listaItem = new ArrayList<Item>();
		this.validade = new Date();
		
	}	
	
	/**
	 * Salva um novo lote
	 * @return uma string para a listagem de lotes
	 */
	public String salvarLote(){
	
		if(this.lote !=null){
			
			List<Lote>  lotes = this.item.getLote();
           	this.item.setLote(lotes);
			
			for(Item item : listaItem){
            	if(item.getIdItem().equals(this.idItem)){
            		this.item = item;
            	}
            }
       		
           	this.lote.setItem(item);
           	this.lote.setChegada(false);
           
           	LoteRN loteRN = new LoteRN();
           	loteRN.salvar(lote);
          
			Mensagens.adicionarMensagemConfirmacao("Lote cadastrado com sucesso");
			this.lote = new Lote();		
		}
		return "listaItens";
		
	}
	
	/**
	 * Faz a listagem dos lotes 
	 * @return retorna uma string para a página de listagem de lotes
	 */
	public String listarLoteJSF(){	
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("listarLote");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/listarLote";
	}
	

	/**
	 * Exclui um lote
	 */
	public void excluir(){
		LoteRN loteRN = new LoteRN();
		try {
			loteRN.excluir(loteSelecionado);
		} 
		catch (Exception e) {
			Mensagens.adicionarMensagemErro("Não foi possivel excluir o lote");	
		}
		
		Mensagens.adicionarMensagemConfirmacao("Lote excluido");	

	}
	
	/**
	 * Atualiza a quantidade de itens quando um lote chega no restaurante
	 * @return retorna nulo para permancer na mesma página.
	 */
	public String atualizaQuantidadeItens(){
		if(loteSelecionado.getChegada()==true){
			qtd = this.loteSelecionado.getItem().getQuantidade();
			qtd = qtd + this.loteSelecionado.getQntdItens();
			this.loteSelecionado.getItem().setQuantidade(qtd);
			Mensagens.adicionarMensagemConfirmacao("Quantidade de item atualizado");	
		}
		else{
			Mensagens.adicionarMensagemErro("Lote ainda não chegou no restaurante");
		}
		
		return null;
	}

	
	/*
	 * Getters e Setters
	 */
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Lote getLoteSelecionado() {
		return loteSelecionado;
	}
	
	public void setLoteSelecionado(Lote loteSelecionado) {
		this.loteSelecionado = loteSelecionado;
	}

	public List<Lote> getListaLote() {
		LoteRN loteRN = new LoteRN();
		this.listaLote = loteRN.listar();
		return this.listaLote;
	}

	public void setListaLote(List<Lote> listaLote) {
		this.listaLote = listaLote;
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


	public Integer getIdItem() {
		return idItem;
	}


	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	
	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}	
}