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

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
/**
*
* Nome: BaseCNPJConverter
* Propósito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@FacesConverter(value="baseCNPJConverter")
public class BaseCNPJConverter implements Converter{

	/**
     * Irá converter CNPJ formatado para um sem pontos, traço e barra.
     */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        
        String cnpj = value;
        if (value != null && !value.equals(""))
            cnpj = value.replaceAll("\\.",
                    "");

        return cnpj;
    }

	/**
     * Irá converter Base de CNPJ com 8 dígitos. Ex.: 00.000.000
     */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        
        String cnpj = "";
        if (value != null) {
            cnpj = value.toString();
            cnpj = SiteUtil.removeNaoNumericos(cnpj);
            cnpj = SiteUtil.formatNumber(cnpj,8);
            cnpj = cnpj.substring(0,
                    2) + "."
                    + cnpj.substring(2,
                            5)
                    + "."
                    + cnpj.substring(5,
                            8);
        }

        return cnpj;
    }

}