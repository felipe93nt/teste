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

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
*
* Nome: BigDecimalConverter
* Propósito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@FacesConverter(value="bigDecimalConverter")
public class BigDecimalConverter implements Converter{

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
            valorTela = valorTela.trim()
                    .replace("R$ ",
                            "");

            try {
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                if (arg1 instanceof HtmlInputText) {
                    return new BigDecimal(valorTela.replace(",",
                            "."));
                } else {
                    return nf.parse(valorTela.replace(",",
                            "."));
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
            return valorTela.toString()
                    .trim();
        }
    }

}