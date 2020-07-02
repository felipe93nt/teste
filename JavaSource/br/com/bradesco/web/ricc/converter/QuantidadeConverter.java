package br.com.bradesco.web.ricc.converter;

import java.text.DecimalFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bradesco.web.ricc.utils.SiteUtil;

@FacesConverter(value = "quantidadeConverter")
public class QuantidadeConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {

		if(value == null){
			return null;
		}
		
		if(value.equals("")){
			return "";
		}
		
		return value.toString().replaceAll("\\.", "");
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		
		if(value == null){
			return null;
		}
		
		if(value.equals("")){
			return "";
		}
		
		Long _valueNro = SiteUtil.getInstance().nullToLong(value);
		DecimalFormat format = new DecimalFormat("###,###");

		return format.format(_valueNro).toString();
		
	}

}
