/**
 * Nome: br.com.bradesco.web.npcc_trade.exception
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.exception;

import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.config.IExceptionConfig;
import br.com.bradesco.web.aq.application.error.handler.AbstractBaseExceptionHandlerImpl;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.utils.MessagesUtil;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
*
* Nome: NpccTradeExceptionHandler
* Propósito: TODO <br/>
*
* Data: 17/06/2015 <br/>
* @author mauricio.sako / Capgemini <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@Named("npcc_tradeExceptionHandler")
public class NpccTradeExceptionHandler extends AbstractBaseExceptionHandlerImpl{

    /**
     * Comentarios para el Constructor.
     *
     */
    public NpccTradeExceptionHandler() {
        super();
    }
    
    /**
     * Ignora as configurações do error-catalog
     */
    @Override
    protected boolean beforePerformForward(Exception exception, IExceptionConfig config){
        
        if(!SiteUtil.isEmptyOrNull(exception.getMessage())){
            BradescoFacesUtils.addInfoModalMessage(exception.getMessage(), false);
        } else {
            BradescoFacesUtils.addInfoModalMessage(MessagesUtil.MENSAGEM_INTERNA_EXCECAO, false);
        }
        
        return false;
    }

    @Override
    protected boolean beforePerformAlert(Exception arg0, IExceptionConfig arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean beforePerformLogout(Exception arg0, IExceptionConfig arg1) {
        // TODO Auto-generated method stub
        return false;
    }

}
