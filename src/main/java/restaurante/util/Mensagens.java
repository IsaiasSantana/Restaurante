package restaurante.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * @author alkxly
 * @since 11 de novembro de 2015
 */
public class Mensagens {
	/**
	 * @author alkxly
	 * @since 11 de novembro de 2015
	 * @param mensagem - mensagem que será exibida.
	 * Adiciona uma mensagem de confirmação
	 */
	public static void adicionarMensagemConfirmacao(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();         
		context.addMessage(null, new FacesMessage(mensagem) );
	}
	/**
	 * @autor alkxyly
	 * @param mensagem -  mensagem que ser� exibida.
	 * 
	 * Adiciona uma mensagem de erro.
	 */
	public static void adicionarMensagemErro(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();         
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,mensagem) );
	}
}
