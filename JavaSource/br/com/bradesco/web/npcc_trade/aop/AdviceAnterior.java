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
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;

/**
 * Nome: AdviceAnterior
 * Prop�sito: Classe respons�vel por interceptar os m�todos de neg�cio antes de sua execu��o <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@Aspect
@Named("adviceAnterior")
@ApplicationScoped
public class AdviceAnterior {
    /**
     * Nome: before <br/>
     * Prop�sito: Intercepta m�todos de neg�cio antes de sua execu��o <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param joinPoint
     * @throws Throwable
     */
    @Before("execution(* br.com.bradesco.web.npcc_trade.aop.BeanNegocio.logicaNegocioAnteriorPosterior(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        ILogManager logger = BradescoCommonServiceFactory.getLogManager();
        logger.info(joinPoint.getTarget().getClass(), "Logando execu��o usando Aspectos");
        logger.info(joinPoint.getTarget().getClass(), "A classe e o m�todo em execu��o s�o ["
                + joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "]");
    }
}