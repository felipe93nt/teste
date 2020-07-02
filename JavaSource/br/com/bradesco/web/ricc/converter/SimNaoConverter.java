package br.com.bradesco.web.ricc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "simNaoConverter")
public class SimNaoConverter implements Converter {
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {

		if(value == null){
			return null;
		}
		
		if(value.equals("")){
			return "";
		}
		
		return value.toString();
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		
		if(value == null){
			return null;
		}
		
		if(value.equals("")){
			return "";
		}
		
		if(value.equals("1")) {
			return "Sim";
		} else if (value.equals("2")) {
			return "Não";
		}
		
		return null;
		
	}
}
