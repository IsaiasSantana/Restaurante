package restaurante.controle;

/**
 * 
 * @author Thiago
 * @version 1.0
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import restaurante.modelo.item.Item;
import restaurante.modelo.item.ItemRN;
import restaurante.util.Mensagens;


@ManagedBean(name = "itemBean")
@RequestScoped
public class ItemBean {
	
	private Item item;
	private Item itemSelecionado;
	private List<Item> listaItem;
	
	
	public ItemBean(){
		this.item = new Item();
		this.itemSelecionado = new Item();
		this.listaItem =  new ArrayList<Item>();
	}
	
	//Salva um novo item
	public String salvar(){
		String msg = null;
		
		if(this.item != null){
			ItemRN itemRN = new ItemRN();
		
			if(this.item.getIdItem() != null){
				itemRN.alterar(item);
				msg = "listarItem";
				Mensagens.adicionarMensagemConfirmacao("Item alterado");	
			}
			else{
				try {
					item.setQuantidade(0);
					itemRN.salvar(item);
					Mensagens.adicionarMensagemConfirmacao("Item cadastrado com sucesso");
				} catch (Exception e) {
					Mensagens.adicionarMensagemErro("Não foi possivel cadastrar  o item");		
				}
				msg = "cadastroItem";
			}

			this.item = new Item();
		}
		return msg;
	
	}
	
	
	//Lista os itens salvos
	public String listarItemJSF(){
		
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("listarItem");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/listarItem";
	}
	
	
	//Exclui um item
	public void excluir(){
		ItemRN itemRN = new ItemRN();
		try {
			itemRN.excluir(itemSelecionado);
		} catch (Exception e) {
			Mensagens.adicionarMensagemErro("Não foi possivel excluir o item");	
		}
		Mensagens.adicionarMensagemConfirmacao("Item excluido");	

	}
	
	public String editar(){
		return "cadastroItem";
	}
	
	public Item getItemSelecionado() {
		return itemSelecionado;

	}

	public void setItemSelecionado(Item itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<Item> getListaItem() {
		ItemRN itemRN = new ItemRN();
		listaItem = itemRN.listar();
		return listaItem;
	}
	
	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}
}