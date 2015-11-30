package restaurante.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 * Faces converter for support of LocalDate
 * @author Juneau
 */
@FacesConverter(value="localDateTimeConverter")
public class ConversorHora implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return LocalTime.parse(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	
    	 Date date = (Date) value;
    	 Instant instant = Instant.ofEpochMilli(date.getTime());
    	 LocalTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
        
        return res.getHour()+":"+res.getMinute()+":"+res.getSecond();
    }
    //
}