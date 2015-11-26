package restaurante.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import restaurante.modelo.funcionario.Funcionario;

@FacesConverter(value="funcionarioConverter", forClass=Funcionario.class)
public class FuncionarioConverter implements Converter{
	
	  @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Funcionario) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Funcionario) {
	            Funcionario funcionario = (Funcionario) value;
	            if (funcionario != null && funcionario instanceof Funcionario && funcionario.getIdFuncionario() != null) {
	                uiComponent.getAttributes().put( funcionario.getIdFuncionario().toString(), funcionario);
	                return funcionario.getIdFuncionario().toString();
	            }
	        }
	        return "";
	    }
	
}
