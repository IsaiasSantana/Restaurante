package restaurante.controle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import restaurante.modelo.comanda.Comanda;
import restaurante.modelo.comanda.ComandaRN;
import restaurante.modelo.pedido.Pedido;
import restaurante.modelo.pedido.PedidoRN;
import restaurante.modelo.produto.Produto;
import restaurante.modelo.produto.ProdutoRN;
import restaurante.util.Mensagens;

/**
 * 
 * @author dgaramos
 * @version 1.0
 */
@ManagedBean (name = "comandaBean")
@RequestScoped
public class ComandaBean {
	
	private Comanda comanda;
	private List<Comanda> listaComanda;
	private List<Comanda> listaComandaAtiva;
	private List<Comanda> listaComandaInativa;
	private Pedido pedido;
	private Pedido pedidoSelecionado;
	private List<Pedido> listaPedido;
	private Produto produto;
	private List<Produto> listaProduto;
	private Integer idProduto;
	private Integer idComanda;
	
	public ComandaBean(){
		
		this.comanda = new Comanda();
		this.listaComanda = new ArrayList<Comanda>();
		this.listaComandaAtiva = new ArrayList<Comanda>();
		this.listaComandaInativa = new ArrayList<Comanda>();
		this.pedido = new Pedido();
		this.pedidoSelecionado = new Pedido();
		this.listaPedido  = new ArrayList<Pedido>();
		this.produto  = new Produto();
		this.listaProduto = new ArrayList<Produto>();
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public List<Comanda> getListaComanda() {
		ComandaRN comandaRN = new ComandaRN();
		this.listaComanda = comandaRN.listar();
		return listaComanda;
	}

	public void setListaComanda(List<Comanda> listaComanda) {
		this.listaComanda = listaComanda;
	}

	public List<Comanda> getListaComandaAtiva() {
		ComandaRN comandaRN = new ComandaRN();
		this.listaComandaAtiva = comandaRN.listarAtivas();
		return listaComandaAtiva;
	}

	public void setListaComandaAtiva(List<Comanda> listaComandaAtiva) {
		this.listaComandaAtiva = listaComandaAtiva;
	}

	public List<Comanda> getListaComandaInativa() {
		ComandaRN comandaRN = new ComandaRN();
		this.listaComandaInativa = comandaRN.listarInativas();
		return listaComandaInativa;
	}

	public void setListaComandaInativa(List<Comanda> listaComandaInativa) {
		this.listaComandaInativa = listaComandaInativa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProduto() {
		ProdutoRN produtoRN = new ProdutoRN();
		this.listaProduto = produtoRN.listar();
		return this.listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public String salvarComanda(){
	       if(this.pedido != null){
	    	 //Trecho de c�digo para definir qual � o produto a ser adicionado
	           for(Produto produto : listaProduto){
	            	if(produto.getIdProduto().equals(this.idProduto)){
	            		this.produto = produto;
	            	}
	            }
	       		this.pedido.setProduto(produto); 
	       		
	       		this.pedido.setStatusPedido(false);
	       		
	       		if(pedido.getHoraRealizado() == null){
	       			Timestamp horaRealizado = new Timestamp(System.currentTimeMillis());
	       			pedido.setHoraRealizado(horaRealizado);
	       		}
	       		
	       		
	       		
	       		this.comanda.setComandaInativa(false);
	       		this.listaPedido.add(pedido);
	       		this.comanda.setListaPedidos(listaPedido);
	       		this.pedido.setComanda(comanda);
	       		
	       		
	    		PedidoRN pedidoRN = new PedidoRN();	
	    		ComandaRN comandaRN = new ComandaRN();
	    		
	    		comandaRN.salvar(comanda);
	    		pedidoRN.salvar(pedido);	
	    		Mensagens.adicionarMensagemConfirmacao("Comanda cadastrada com sucesso");
	    		
	    		this.pedido = new Pedido();
	    		this.listaPedido = new ArrayList<Pedido>();
	    		this.comanda = new Comanda();
	       	}
			return "listaComandasAtivas";

		}
	
	public double calcularComanda(){
		double total = 0;
		
		for(Pedido pedidoTMP : this.comanda.getListaPedidos()){
			total = pedidoTMP.getQntd()* pedidoTMP.getProduto().getPreco();
		}
		
		return total;
	}
	
	public String fecharComanda(){
		
		//Trecho de c�digo que verifica se existem pedidos n�o atendidos na comanda
		for (Pedido pedido : this.comanda.getListaPedidos()){
			 if (pedido.getStatusPedido() == false){
				 Mensagens.adicionarMensagemErro("Comanda n�o pode ser paga pois ainda existem pedidos n�o atendidos nela");
				 return null;
			 }
		 }
		
		this.comanda.setComandaInativa(true);
		ComandaRN comandaRN = new ComandaRN();
		comandaRN.salvar(comanda);
		return "fecharComanda";
	}
	 public String pagarComanda(){
		 
		 //trecho de c�digo para verificar a comanda a ser paga
		 for(Comanda comanda : listaComanda){
         	if(comanda.getIdComanda().equals(this.idComanda)){
         		this.comanda = comanda;
         	}
         }
		 
		 ComandaRN comandaRN = new ComandaRN();
		 
		 for (Pedido pedido : comandaRN.listarPedidos(comanda)){
			  //pedido.setComanda(null);
			 System.out.println(pedido.getIdPedido());
			 //PedidoRN pedidoRN = new PedidoRN();
			 //pedidoRN.salvar(pedido);
			 //pedidoRN.excluir(pedido);
		 }
		 
		
		//comandaRN.excluir(comanda);
		 return "listaComandasInativas";
	 }
	 
	
}
