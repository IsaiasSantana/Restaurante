package restaurante.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import restaurante.modelo.funcionario.Funcionario;
import restaurante.modelo.funcionario.FuncionarioRN;
import restaurante.modelo.quadroHorarios.QuadroHorarios;
import restaurante.util.Mensagens;

/**
 * 
 * @author IsaíasSantana
 *
 */
@ManagedBean
@SessionScoped
public class FuncionarioBean {
	private Funcionario funcionario;
	private Funcionario funcionarioSelecionado;
	private List<Funcionario> listaFuncionarios;
	private List<Funcionario> listaFuncionarioPorNome;
	private QuadroHorarios quadroHorario;
	private int tipoFuncionario;
	
	public FuncionarioBean(){
		funcionario = new Funcionario();
		quadroHorario = new QuadroHorarios();
		funcionarioSelecionado = new Funcionario();
	}
	
	/**
	 * Configura um quadro de horário para o funcionário.
	 */
	public void escolherQuadroHorario()
	{
		funcionario.setQuadroHorario(quadroHorario);
	}
	
	/**
	 * Salva um novo funcionário no banco caso não exista, se existir apenas é atualizado os seus valores.
	 * @return
	 */
	public String salvar(){
		String pagina = null;
		
		if(funcionario != null){
			FuncionarioRN funcRN = new FuncionarioRN();
			if(funcionario.getIdFuncionario() != null){
				funcRN.alterar(funcionario);
				pagina = "listarFuncionarios";
				Mensagens.adicionarMensagemConfirmacao("Funcionário alterado com sucesso!");	
			}else
			{
				try{
					funcRN.inserir(funcionario);
					Mensagens.adicionarMensagemConfirmacao("Funcionário cadastrado com sucesso!");
				}catch(Exception e){
					Mensagens.adicionarMensagemErro("Não foi possivel cadastrar  o funcionário");
				}
				pagina = "cadastrarFuncionario";
			}
			
			funcionario = new Funcionario();
		}
		return pagina;
	}
	
	/**
	 * Redireciona para a tela de cadastro.
	 * @return
	 */
	public String editar(){
		return "cadastrarFuncionario";
	}
	
	/**
	 * Exclui um funcionario do sistema.
	 */
	public void excluir(){
		FuncionarioRN funcRN = new FuncionarioRN();
		try{
			funcRN.excluir(funcionarioSelecionado);
		}catch (Exception e) {
			Mensagens.adicionarMensagemErro("Não foi possivel excluir o funcionário");	
		}
		Mensagens.adicionarMensagemConfirmacao("Funcionário excluido com sucesso!");	
	}
	
	/**
	 * Procura um funcionário pelo nome, informado na tela de busca.
	 */
	public void buscaPorNome(){
	
		FuncionarioRN funcRN = new FuncionarioRN();
		listaFuncionarioPorNome = funcRN.buscarPorNome(funcionarioSelecionado.getNome());
		if(listaFuncionarioPorNome.isEmpty()) Mensagens.adicionarMensagemErro("O funcionário "+funcionarioSelecionado.getNome()+" Não Existe");
		
		funcionario = new Funcionario();
		funcionarioSelecionado = new Funcionario();		
	}
	
	/*
	 * Getters e Setters
	 */
	
	public QuadroHorarios getQuadroHorario() {
		return quadroHorario;
	}

	public void setQuadroHorario(QuadroHorarios quadroHorario) {
		this.quadroHorario = quadroHorario;
	}

	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public List<Funcionario> getListaFuncionarios() {
			FuncionarioRN funcRN = new FuncionarioRN();
			listaFuncionarios = funcRN.listarFuncionarios();
		
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Funcionario> getListaFuncionarioPorNome() {
		return listaFuncionarioPorNome;
	}

	public void setListaFuncionarioPorNome(List<Funcionario> listaFuncionarioPorNome) {
		this.listaFuncionarioPorNome = listaFuncionarioPorNome;
	}	
}