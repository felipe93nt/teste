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

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
*
* Nome: StringConverter
* Propósito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@FacesConverter(value="stringConverter")
public class StringConverter implements Converter{

	/**
	 * This method used for return the converted value to the user.
	 */
	public Object getAsObject(FacesContext arg0,
            UIComponent arg1,
            String valorTela) throws ConverterException {

        if (valorTela == null || valorTela.toString()
                .trim()
                .equals("")) {
            return "0";

        } else {
            
        	return valorTela;
			
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
            return "0";

        } else {
        	
            return String.valueOf(valorTela);
        }
    }

}