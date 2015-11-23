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
@ManagedBean (name = "pedidoBean")
@RequestScoped
public class PedidoBean {
	
	private Pedido pedido;
	private List<Pedido> listaPedido;
	private List<Pedido> listaPedidoRefeicao;
	private List<Pedido> listaPedidoRefeicaoEspera;
	private List<Pedido> listaPedidoRefeicaoPreparo;
	private List<Pedido> listaPedidoRefeicaoPronta;
	private List<Pedido> listaPedidoBebida;
	private Produto produto;
	private List<Produto> listaProduto;
	private Integer idProduto;
	private Comanda comanda;
	private List<Comanda> listaComanda;
	private Integer idComanda;
	private Pedido pedidoSelecionado;
	
	public PedidoBean(){
		this.pedido = new Pedido();
		this.listaPedido = new ArrayList<Pedido>();
		this.produto = new Produto();
		this.listaProduto = new ArrayList<Produto>();
		this.listaPedidoRefeicao = new ArrayList<Pedido>();
		this.listaPedidoRefeicaoEspera = new ArrayList<Pedido>();
		this.listaPedidoRefeicaoPreparo = new ArrayList<Pedido>();
		this.listaPedidoRefeicaoPronta = new ArrayList<Pedido>();
		this.listaPedidoBebida = new ArrayList<Pedido>();
		this.comanda = new Comanda();
		this.listaComanda = new ArrayList<Comanda>();
		this.pedidoSelecionado = new Pedido();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public List<Produto> getListaProduto() {
		ProdutoRN produtoRN = new ProdutoRN();
		this.listaProduto = produtoRN.listar();
		return this.listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedido() {
		PedidoRN pedidoRN = new PedidoRN();
		this.listaPedido = pedidoRN.listarNaoAtendidos();
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public List<Pedido> getListaPedidoRefeicao() {
		PedidoRN pedidoRN = new PedidoRN();
		for(Pedido pedidoTMP : pedidoRN.listarNaoAtendidos()){
        	if(pedidoTMP.getProduto().getIsRefeicao().equals(true)){
        		this.listaPedidoRefeicao.add(pedidoTMP);
        	}
        }
		return listaPedidoRefeicao;
	}

	public void setListaPedidoRefeicao(List<Pedido> listaPedidoRefeicao) {
		this.listaPedidoRefeicao = listaPedidoRefeicao;
	}

	public List<Pedido> getListaPedidoRefeicaoEspera() {
		PedidoRN pedidoRN = new PedidoRN();
		for(Pedido pedidoTMP : pedidoRN.listarNaoAtendidos()){
        	if(pedidoTMP.getProduto().getIsRefeicao().equals(true)){
        		this.listaPedidoRefeicaoEspera.add(pedidoTMP);
        	}
        }
		return listaPedidoRefeicaoEspera;
	}

	public void setListaPedidoRefeicaoEspera(List<Pedido> listaPedidoRefeicaoEspera) {
		this.listaPedidoRefeicaoEspera = listaPedidoRefeicaoEspera;
	}

	public List<Pedido> getListaPedidoRefeicaoPreparo() {
		return listaPedidoRefeicaoPreparo;
	}

	public void setListaPedidoRefeicaoPreparo(List<Pedido> listaPedidoRefeicaoPreparo) {
		this.listaPedidoRefeicaoPreparo = listaPedidoRefeicaoPreparo;
	}

	public List<Pedido> getListaPedidoRefeicaoPronta() {
		return listaPedidoRefeicaoPronta;
	}

	public void setListaPedidoRefeicaoPronta(List<Pedido> listaPedidoRefeicaoPronta) {
		this.listaPedidoRefeicaoPronta = listaPedidoRefeicaoPronta;
	}

	public List<Pedido> getListaPedidoBebida() {
		PedidoRN pedidoRN = new PedidoRN();
		for(Pedido pedidoTMP : pedidoRN.listarNaoAtendidos()){
        	if(pedidoTMP.getProduto().getIsRefeicao().equals(false)){
        		this.listaPedidoBebida.add(pedidoTMP);
        	}
        }
		return listaPedidoBebida;
	}

	public void setListaPedidoBebida(List<Pedido> listaPedidoBebida) {
		this.listaPedidoBebida = listaPedidoBebida;
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

	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public String salvarPedido(){
       if(this.pedido != null){
    	 //Trecho de código para definir qual é o produto a ser adicionado
           for(Produto produto : listaProduto){
            	if(produto.getIdProduto().equals(this.idProduto)){
            		this.produto = produto;
            	}
            }
       		
           	this.pedido.setProduto(produto); 
       		
           	 //Trecho de código para definir em qual comanda será adcionada o pedido
                  for(Comanda comanda : listaComanda){
                   	if(comanda.getIdComanda().equals(this.idComanda)){
                   		this.comanda = comanda;
                   	}
            }
                  
            List<Pedido> listaPedidoComanda = this.comanda.getListaPedidos();
            
            this.comanda.setListaPedidos(listaPedidoComanda);
            this.pedido.setComanda(comanda);
       		
       		
       		pedido.setStatusPedido(false);
       		
       		if(pedido.getHoraRealizado() == null){
       			Timestamp horaRealizado = new Timestamp(System.currentTimeMillis());
       			pedido.setHoraRealizado(horaRealizado);
       		}
       		ComandaRN comandaRN = new ComandaRN();
    		PedidoRN pedidoRN = new PedidoRN();	
    		comandaRN.salvar(comanda);
    		pedidoRN.salvar(pedido);	
    		Mensagens.adicionarMensagemConfirmacao("Pedido cadastrado com sucesso");
    		this.pedido = new Pedido();
       	}
		return "listaPedidos";

	}
	
	public String marcarAtendido(){
		
		this.pedido.setStatusPedido(true);
		Timestamp horaAtendido = new Timestamp(System.currentTimeMillis());
		pedido.setHoraAtendido(horaAtendido);
		
		PedidoRN pedidoRN = new PedidoRN();
		pedidoRN.salvar(this.pedido);
		this.listaPedidoBebida.removeAll(listaPedidoBebida);
		this.listaPedidoRefeicaoPronta.removeAll(listaPedidoRefeicaoEspera);
		Mensagens.adicionarMensagemConfirmacao("Pedido marcado como atendido");
		return null;
	}
	
	public String excluir(){
		PedidoRN pedidoRN = new PedidoRN();
		
		this.comanda = pedidoSelecionado.getComanda();
		pedidoRN.excluir(this.pedidoSelecionado);
		
		//Trecho de código para verificar se a comanda a qual o pedido pertencia ficou vazia, 
		//para que a mesma seja excluida
		this.listaPedido = this.comanda.getListaPedidos();
		this.listaPedido.remove(pedidoSelecionado);
		this.comanda.setListaPedidos(this.listaPedido);
		if (this.comanda.getListaPedidos().isEmpty() == true){
			ComandaRN comandaRN = new ComandaRN();
			comandaRN.excluir(this.comanda);
		}
		
		//zerando as listas para corrigir o erro de exibição da persistencia 
		//da consulta de antes de excluir o determinado item
		this.listaPedidoBebida.removeAll(listaPedidoBebida);
		this.listaPedidoRefeicaoEspera.removeAll(listaPedidoRefeicaoEspera);
		
		Mensagens.adicionarMensagemConfirmacao("Pedido excluido com sucesso");
		return "/listaPedidos";
	}
	
	public String emPreparo(){
		this.listaPedidoRefeicaoEspera.remove(this.pedido);
		this.listaPedidoRefeicaoPreparo.add(this.pedido);
		return null;
		
		
	}
}
