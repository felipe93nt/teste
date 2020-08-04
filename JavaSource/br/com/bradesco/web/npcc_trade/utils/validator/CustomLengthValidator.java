/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.validator
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 13/08/2015
 *
 * @author Thiago / BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.utils.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * 
 * Nome: CustomLengthValidator Propósito: Valida quantidade mínima e máxima se o
 * campo for preenchido<br/>
 * 
 * Data: 17/06/2015 <br/>
 * 
 * @author Thiago / BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 * 
 * @version 1.0
 * @see
 */
@FacesValidator("customLengthValidator")
public class CustomLengthValidator extends LengthValidator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String text = value.toString();

        // executa validação se o campo for preenchido
        if (!SiteUtil.isEmptyOrNull(text)) {
            setMinimum(Integer.valueOf((String) component.getAttributes().get("minimum")));
            setMaximum(Integer.valueOf((String) component.getAttributes().get("maximum")));
            super.validate(context, component, value);
        }
    }
}
