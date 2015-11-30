package restaurante.controle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.funcionario.FuncionarioRN;
import restaurante.modelo.item.Item;
import restaurante.modelo.item.ItemRN;
import restaurante.modelo.retiradaitem.RetiradaItem;
import restaurante.modelo.retiradaitem.RetiradaItemRN;
import restaurante.util.Mensagens;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean (name = "retiradaItemBean")
@RequestScoped
public class RetiradaItemBean {
	
	private RetiradaItem retirada;
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionario;
	private Integer idFuncionario;
	private Item item;
	private List<Item> listaItem;
	private List<RetiradaItem> listaRetiradas;
	private Integer idItem;
	private Integer quantidadeItens;
	
	
	public RetiradaItemBean(){
		this.retirada = new RetiradaItem();
		this.funcionario = new Funcionario();
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.item = new Item();
		this.listaItem = new ArrayList<Item>();
		this.listaRetiradas = new ArrayList<RetiradaItem>();
	}
		
	
	/**
	 * @author IsaíasSantana
	 * Registra retirada de item do estoque de itens 
	 * @return uma string para a lista de retiradas
	 */
	public String salvarRetiradaItem(){
		
		if(this.retirada !=null){
			
           	//puxa o respectivo funcionario que fez a retirada do item
           	for(Funcionario responsavel : listaFuncionario){
            	if(responsavel.getIdFuncionario().equals(idFuncionario)){
            		this.funcionario = responsavel;
            	}
            }
           	
           	this.retirada.setResponsavelRetirada(funcionario);
           	
           	//puxa o respectivo item retirado
           	for(Item item : listaItem){
            	if(item.getIdItem().equals(idItem)){
            		this.item = item;
            	}
            }
           	
           	this.retirada.setItemRetirado(item);
           	
           	//define a hora da retirada
           	if(retirada.getHoraRetirada() == null){
       			Timestamp horaRetirada = new Timestamp(System.currentTimeMillis());
       			retirada.setHoraRetirada(horaRetirada);
       			
       		}
           	
           	if(this.item.getQuantidade() > 0 && quantidadeItens <= this.item.getQuantidade()){
           		this.retirada.setQtdRetirada(quantidadeItens);
           		this.retirada.setItemRetirado(this.item);
           		RetiradaItemRN retiradaItemRN = new RetiradaItemRN();
               	retiradaItemRN.salvar(retirada);
    			Mensagens.adicionarMensagemConfirmacao("Registro de retirada de item efetuado");
    			
    			final ItemRN itemRN = new ItemRN();
    			this.item.setQuantidade(this.item.getQuantidade()-quantidadeItens);
    			itemRN.alterar(this.item);

                this.retirada = new RetiradaItem();
    			this.item = new Item();
    			this.listaFuncionario = new ArrayList<Funcionario>();
    			this.listaItem = new ArrayList<Item>();
           	}
           	else{
           		Mensagens.adicionarMensagemErro("A quantidade a ser retirada é maior do que a quantidade de itens disponíveis");
           	}
          	
		}
		return "listarRetirada";
	}	
	
	/*
	 * Getters e Setters
	 */

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getListaFuncionario() {
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		this.listaFuncionario = funcionarioRN.listarFuncionarios();
		return listaFuncionario;
	}


	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}


	public Integer getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public RetiradaItem getRetirada() {
		return retirada;
	}


	public void setRetirada(RetiradaItem retirada) {
		this.retirada = retirada;
	}


	public Integer getQuantidadeItens() {
		return quantidadeItens;
	}


	public void setQuantidadeItens(Integer quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
	

	public List<RetiradaItem> getListaRetiradas() {
		RetiradaItemRN retiradaItemRN = new RetiradaItemRN();
		this.listaRetiradas = retiradaItemRN.listar();
		return this.listaRetiradas;
		//return retiradaItemRN.listar();
	}


	public void setListaRetiradas(List<RetiradaItem> listaRetiradas) {
		this.listaRetiradas = listaRetiradas;
	}


	
}