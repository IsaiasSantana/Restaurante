package restaurante.controle;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import restaurante.modelo.produto.Produto;
import restaurante.modelo.produto.ProdutoRN;
import restaurante.util.Mensagens;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean{
	
	private Produto produto;
	private List<Produto> listaProduto;
	private Produto refeicao;
	private List<Produto> listaRefeicao;
	private Produto bebida;
	
	
	public ProdutoBean(){
		this.produto =  new Produto();
		this.listaProduto =  new ArrayList<Produto>();
		this.listaRefeicao =  new ArrayList<Produto>();
		this.listaBebida =  new ArrayList<Produto>();
	}
	
	public Produto getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Produto refeicao) {
		this.refeicao = refeicao;
	}

	public Produto getBebida() {
		return bebida;
	}

	public void setBebida(Produto bebida) {
		this.bebida = bebida;
	}

	private List<Produto> listaBebida;
	

	
	public List<Produto> getListaRefeicao() {
		ProdutoRN produtoRN = new ProdutoRN();
		this.listaRefeicao = produtoRN.listarRefeicao();
		return listaRefeicao;
	}

	public void setListaRefeicao(List<Produto> listaRefeicao) {
		this.listaRefeicao = listaRefeicao;
	}

	public List<Produto> getListaBebida() {
		ProdutoRN produtoRN = new ProdutoRN();
		this.listaBebida = produtoRN.listarBebida();
		return listaBebida;
	}

	public void setListaBebida(List<Produto> listaBebida) {
		this.listaBebida = listaBebida;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	//Método salvar2 criado para que após cadastro seja visualizado o cardápio
	//a página vai de cadastroProduto.jsf para cardapio.jsf
	public String salvar(){
		if(this.produto != null){
			
			//Operação matemática no preço para truncar as casas decimais em apenas duas
			produto.setPreco(Math.floor(produto.getPreco()*100)/100);
			ProdutoRN produtoRN = new ProdutoRN();
			produtoRN.salvar(produto);
			
			Mensagens.adicionarMensagemConfirmacao("Produto cadastrado com sucesso");
			this.produto= new Produto();
		}
		return "cardapio";
	}
	
	//Método salvar2 criado para que possa se criar outro produto
	//a página vai de cadastroProduto.jsf para cadastroProduto.jsf
	public String salvar2(){ 
		if(this.produto != null){
			
			//Operação matemática no preço para truncar as casas decimais em apenas duas
			produto.setPreco(Math.floor(produto.getPreco()*100)/100);
			
			ProdutoRN produtoRN = new ProdutoRN();
			produtoRN.salvar(produto);
			Mensagens.adicionarMensagemConfirmacao("Produto cadastrado com sucesso");
			this.produto= new Produto();
		}
		return null;
	}

	public String excluir(){
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.excluir(this.produto);
		this.listaProduto = null;
		Mensagens.adicionarMensagemConfirmacao("Produto excluido com sucesso");
		return null;
	}
	
	public String editar(){
		return "cadastroProduto";
	}

	public List<Produto> getListaProduto() {
		ProdutoRN produtoRN = new ProdutoRN();
		this.listaProduto = produtoRN.listar();
		return this.listaProduto;		
	}

	



}
