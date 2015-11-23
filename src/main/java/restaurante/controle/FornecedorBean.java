package restaurante.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import restaurante.modelo.contato.Contato;
import restaurante.modelo.contato.ContatoRN;
import restaurante.modelo.fornecedor.Fornecedor;
import restaurante.modelo.fornecedor.FornecedorRN;
import restaurante.util.Mensagens;

@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorBean {
	private Fornecedor fornecedor;
	private List<Fornecedor> listaFornecedor;
	private Contato contato;
	private Fornecedor fornecedorSelecionado;

	public FornecedorBean(){
		this.fornecedor =  new Fornecedor();
		this.listaFornecedor =  new ArrayList<Fornecedor>();
		this.contato = new Contato();
		this.fornecedorSelecionado =  new Fornecedor();
	}

	/**
	 * @author alkxly
	 * @since 10 de novembro de 2015
	 * 
	 * Salvar os dados do fornecedor e seu contato.
	 */
	public String salvar(){
		String pagina = null;
		
		if(this.fornecedor != null && this.contato != null){
			ContatoRN contatoRN = new ContatoRN();
			FornecedorRN fornecedorRN = new FornecedorRN();
		
			if(this.fornecedor.getIdFornecedor() != null){
				fornecedorRN.alterar(fornecedor);
				pagina = "listarFornecedor";
				Mensagens.adicionarMensagemConfirmacao("Fornecedor alterado");	
			
			}else{
				this.fornecedor.setContato(this.contato);
				this.contato.setFornecedor(fornecedor);
				try {
					contatoRN.salvar(contato);
					fornecedorRN.salvar(fornecedor);
					Mensagens.adicionarMensagemConfirmacao("Fornecedor cadastrado");
				} catch (Exception e) {
					Mensagens.adicionarMensagemErro("Não foi possivel cadastrar  o fornecedor");		
				}
				pagina = "cadastroFornecedor";
			}


			this.fornecedor = new Fornecedor();
			this.contato = new Contato();
		}
		return pagina;


	}
	/**
	 * @author alkxly
	 * @return - pÃ¡gina de listagem de fornecedor
	 *
	 * Redireciona o link de listagem de fornecedor.
	 * 
	 * PÃ¡gina Origem : cadastroFornecedor.xhtml
	 * PÃ¡gina Destino : listarFornecedor.xhtml
	 */
	public String listarFornecedorJSF(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listarFornecedor");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/listarFornecedor";
	}

	/**
	 * @author alkxyly
	 * 
	 * Exclui o fornecedor do banco de dados
	 */
	public void excluir(){
		FornecedorRN fornecedorRN = new FornecedorRN();
		try {
			fornecedorRN.excluir(fornecedorSelecionado);
		} catch (Exception e) {
			Mensagens.adicionarMensagemErro("Não foi possivel excluir o fornecedor");	
		}
		Mensagens.adicionarMensagemConfirmacao("Fornecedor excluido");	

	}
	/**
	 * @author alkxyly
	 * @return página de cadastro de fornecedor
	 * 
	 * Redireciona para página de cadastro com o objeto selecionado para alteração.
	 */
	public String editar(){
		return "cadastroFornecedor";
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<Fornecedor> getListaFornecedor() {
		FornecedorRN fornecedorRN = new FornecedorRN();
		listaFornecedor = fornecedorRN.listar();
		return listaFornecedor;
	}
	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}


}
