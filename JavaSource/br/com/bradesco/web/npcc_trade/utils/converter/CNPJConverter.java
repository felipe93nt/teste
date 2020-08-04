/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.converter
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
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
* Nome: CNPJConverter
* Prop�sito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@FacesConverter(value="cnpjConverter")
public class CNPJConverter implements Converter{

	/**
     * Ir� converter CNPJ formatado para um sem pontos, tra�o e barra. Ex.
     * de retorno: 00.000.000/0001-00
     */
	public Object getAsObject(FacesContext context,
            UIComponent component,
            String value) throws ConverterException {
        
        String cnpj = value;
        if (value != null && !value.equals(""))
            cnpj = value.replaceAll("\\.",
                    "")
                    .replaceAll("\\-",
                            "")
                    .replaceAll("/",
                            "");

        return cnpj;
    }

	/**
     * Ir� converter Base de CNPJ com 8 d�gitos + filial + d�gito. Ex.:
     * 00.000.000/0001-00
     */
	public String getAsString(FacesContext context,
            UIComponent component,
            Object value) throws ConverterException {
        
        String cnpj = "";
        if (value != null) {
            cnpj = value.toString();
            cnpj = SiteUtil.formatNumber(cnpj,14);

            cnpj = cnpj.substring(0,
                    2) + "."
                    + cnpj.substring(2,
                            5)
                    + "."
                    + cnpj.substring(5,
                            8)
                    + "/"
                    + cnpj.substring(8,
                            12)
                    + "-"
                    + cnpj.substring(12,
                            14);
        }
        return cnpj;
    }

}