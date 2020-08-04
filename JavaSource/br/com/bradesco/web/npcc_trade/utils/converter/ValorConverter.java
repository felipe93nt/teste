/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.converter
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.utils.converter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
*
* Nome: ValorConverter
* Propósito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@FacesConverter(value="valorConverter")
public class ValorConverter implements Converter{

	/**
	 * This method used for return the converted value to the user.
	 */
	public Object getAsObject(FacesContext arg0,
            UIComponent arg1,
            String valorTela) throws ConverterException {

        if (valorTela == null || valorTela.toString()
                .trim()
                .equals("")) {
            return 0.0d;

        } else {
            valorTela = valorTela.replaceAll(Pattern.quote("."),
                    "");

            try {
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                
                if (arg1 instanceof HtmlInputTextarea) {
                	return Double.valueOf(valorTela.replace(",", ".")).doubleValue();
				} else {
					return nf.parse(valorTela.replace(",", ".")).doubleValue();
				}

            } catch (Exception e) {
                return 0.0d;
            }
        }
    }

	/**
	 * This method used for return the converted value to the user.
	 */
	public String getAsString(FacesContext arg0,
            UIComponent arg1,
            Object valorTela) throws ConverterException {
        if (valorTela == null || valorTela.toString()
                .trim()
                .equals("")) {
            return "0,00";

        } else {
        	
        	Locale meuLocal = new Locale( "pt", "BR" );
        	NumberFormat nfVal = NumberFormat.getCurrencyInstance( meuLocal );
        	
        	String simbolo = (String) nfVal.format(valorTela).subSequence(0, 1);
        	// Verifica se o valor é negativo. Se positivo inverte o '-' para depois do 'R$'
        	if (simbolo != null && simbolo.equals("-")) {
        		String valorComp = "R$ -";
        		String valor = (String) nfVal.format(valorTela).subSequence(4, nfVal.format(valorTela).length());
        		valorComp += valor;
        		return valorComp;
			}
        	
            return nfVal.format(valorTela);
        }
    }

}