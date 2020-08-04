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

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.error.config.IExceptionConfig;
import br.com.bradesco.web.aq.application.error.handler.AbstractBaseExceptionHandlerImpl;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.context.BradescoFacesContext;
import br.com.bradesco.web.npcc_trade.utils.MessagesUtil;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.SessionBean;

/**
 *
 * Nome: NpccTradeWebExceptionHandler 
 * Propósito: Tratamento de erro de negocio <br/>
 *
 * Data: 17/06/2015 <br/>
 * 
 * @author thiagoito / BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named("npccTradeWebExceptionHandler")
public class NpccTradeWebExceptionHandler extends AbstractBaseExceptionHandlerImpl {

    @Inject
    @Named("sessionBean")
    SessionBean sessionBean;
    
    /**
     * Comentarios para el Constructor.
     *
     */
    public NpccTradeWebExceptionHandler() {
        super();
    }

    /**
     * Trata as exceções lançadas pelo sistema
     */
    @Override
    public boolean beforePerformForward(java.lang.Exception e, IExceptionConfig config) {
        String message = e.getMessage();

        //Trata mensagem em branco
        if (SiteUtil.isEmptyOrNull(message)) {
            message = MessagesUtil.MENSAGEM_INTERNA_EXCECAO;
            
            if (e.getCause() instanceof CTGServiceException) {
                
                BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>> [MENSAGEM_INTERNA_EXCECAO] - " + e.getCause().getMessage() + " <<<<<<<<<<<");
            }
        }

        if (e instanceof NpccTradeWebException) {
            NpccTradeWebException ex = (NpccTradeWebException)e;
            ExternalContext ec = BradescoFacesContext.getCurrentInstance().getExternalContext(); 

            try {
                String httpVerb = ((HttpServletRequest)ec.getRequest()).getMethod();

                if ((ex.getCode() != null 
                        && (ex.getCode().equals("GSEG0044") 
                            || ex.getCode().equals("GSEG0046"))) 
                        || httpVerb.toUpperCase().equals("GET")) {                  
                    
                    ec.redirect(ec.getRequestContextPath() + "/template/errorPages/genericError.xhtml");
                    
                    if (sessionBean != null) {
                        sessionBean.setErrorMessage(message);
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        BradescoFacesUtils.addInfoModalMessage(message, false);

        return false;
    }

    @Override
    protected boolean beforePerformAlert(Exception arg0, IExceptionConfig arg1) {
        return false;
    }

    @Override
    protected boolean beforePerformLogout(Exception arg0, IExceptionConfig arg1) {
        return false;
    }

}
