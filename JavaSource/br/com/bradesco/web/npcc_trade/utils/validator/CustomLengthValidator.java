/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.validator
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 13/08/2015
 *
 * @author Thiago / BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
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
 * Nome: CustomLengthValidator Prop�sito: Valida quantidade m�nima e m�xima se o
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

        // executa valida��o se o campo for preenchido
        if (!SiteUtil.isEmptyOrNull(text)) {
            setMinimum(Integer.valueOf((String) component.getAttributes().get("minimum")));
            setMaximum(Integer.valueOf((String) component.getAttributes().get("maximum")));
            super.validate(context, component, value);
        }
    }
}
