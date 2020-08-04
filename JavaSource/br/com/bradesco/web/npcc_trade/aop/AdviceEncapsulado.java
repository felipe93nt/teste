/**
 * Nome: br.com.bradesco.web.npcc_trade.aop
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.aop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;

/**
 * Nome: AdviceEncapsulado
 * Prop�sito: Classe respons�vel por encapsular os m�todos do neg�cio <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@Aspect
@Named("adviceEncapsulado")
@ApplicationScoped
public class AdviceEncapsulado {
    /**
     * Nome: afterReturn <br/>
     * Prop�sito: Intercepta os m�todos do neg�cio ap�s a sua execu��o <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param joinPoint
     * @param result
     * @return
     * @throws Throwable
     */
    @AfterReturning(pointcut = "execution(* br.com.bradesco.web.npcc_trade.aop.BeanNegocio.logicaNegocioEncapsulada(..))", returning = "result")
    public Object afterReturn(JoinPoint joinPoint, Object result) throws Throwable {
        ILogManager logger = BradescoCommonServiceFactory.getLogManager();
        try {
            Integer valorRetorno = (Integer) result;
            logger.info(joinPoint.getTarget().getClass(), "Interceptando execu��o do m�todo ["
                    + joinPoint.getSignature().getName() + "]");
            Integer valor = (Integer) valorRetorno;
            if (valor > 10) {
                logger.warn(joinPoint.getTarget().getClass(), "Valor menor que o esperado. Esperava <= 10. Obteve "
                        + valor);
            } else {
                logger.info(joinPoint.getTarget().getClass(), "O valor retornado foi " + valor);
            }
            return valorRetorno;
        } catch (Exception throwable) {
            logger.error(joinPoint.getTarget().getClass(), "Logando exce��o interceptada com aspectos. Stacktrace: ",
                    throwable);
            throw throwable;
        }
    }
}