package br.com.bradesco.web.ricc.converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.bradesco.web.ricc.utils.SiteUtil;

@FacesConverter(value = "valorConverter")
public class ValorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		
		if(value == null){
			return null;
		}
		
		if(value.equals("")){
			return "";
		}
		
		return value.toString();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		
		DecimalFormat format = new DecimalFormat();
		BigDecimal valorBD = new BigDecimal(0);
		if (SiteUtil.getInstance().isNotEmptyOrNull(value)) {

			format = (DecimalFormat) NumberFormat.getNumberInstance(SiteUtil.PT_BR);
			format.applyPattern(SiteUtil.DECIMAL_PATTERN);
			valorBD = new BigDecimal(value.toString());

			return format.format(valorBD);
		}
		return "0,00";
	}

}
