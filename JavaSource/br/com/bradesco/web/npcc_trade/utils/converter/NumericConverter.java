package br.com.bradesco.web.npcc_trade.utils.converter;

import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
  * Nome: NumericConverter.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ - Francinaldo
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 25/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@FacesConverter(value = "numericConverter")
public class NumericConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        // Verifica a nulidade 
        if (value != null && value.toString().trim().length() > 0) {            
            return value.replace(".", "").replace(",", ".");
        } else {
            return "";
        }
    }

    @SuppressWarnings("resource")
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        Formatter formatter = new Formatter(new Locale("pt", "BR"));        
        
        // Verifica a nulidade 
        if (value != null && value.toString().trim().length() > 0) {            
            String mask = "";
            String stringValue = getNumericValue(value.toString());
            BigDecimal decimalValue = new BigDecimal(stringValue);
            int dotIndex = stringValue.indexOf(".");
            
            // Verifica se há decimais no número
            if (dotIndex > -1) {
                int precision = stringValue.length() - dotIndex - 1;
                
                mask = String.format("%%,.%df", precision);
            } else {
                mask = "%,.0f";
            }
            
            return formatter.format(mask, decimalValue).toString();
        } else {
            return formatter.format("%,.2f", 0.0f).toString();
        }
    }
    
    private String getNumericValue(String value) {
        int dotCount = characterCount(value, ".");
        int commaCount = characterCount(value, ",");
        
        // Valor no padrão americano (e.g. 1,000,000.00)
        if (commaCount > dotCount && dotCount == 1) {
            return value.toString().trim().replace(",", "");
        } else if (dotCount == 1) { // Pode ser tanto 1.000,00 como 1,000.00
            int dotIndex = value.indexOf(".");
            int commaIndex = value.indexOf(",");
            
            if (dotIndex > commaIndex) {
                return value.toString().trim().replace(",", "");
            } else {
                return value.toString().trim().replace(".", "").replace(",", ".");
            }
        } else {
            return value.toString().trim().replace(".", "").replace(",", ".");
        }
    }
    
    private int characterCount(String string, String character) {
        if (string != null && string.length() > 0) {
            int counter = 0;
            int lastIndex = string.indexOf(character, 0);
            
            while (lastIndex > -1) {
                lastIndex = string.indexOf(character, lastIndex + 1);
                counter++;
            }
            
            return counter;            
        } else {
            return 0;
        }
    }
}
