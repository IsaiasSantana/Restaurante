package restaurante.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import restaurante.modelo.caixa.Caixa;


@FacesConverter(value="caixaConverter", forClass=Caixa.class)
public class CaixaConverter implements Converter{
	
	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Caixa) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Caixa) {
            Caixa caixa = (Caixa) value;
            if (caixa != null && caixa instanceof Caixa && caixa.getIdCaixa() != null) {
                uiComponent.getAttributes().put( caixa.getIdCaixa().toString(), caixa);
                return caixa.getIdCaixa().toString();
            }
        }
        return "";
    }

}
