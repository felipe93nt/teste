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
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;

/**
 * Nome: AdvicePosterior
 * Prop�sito: Classe respons�vel por interceptar os m�todos do neg�cio ap�s sua execu��o <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@Aspect
@Named("advicePosterior")
@ApplicationScoped
public class AdvicePosterior {
    /**
     * Nome: afterReturning <br/>
     * Prop�sito: Intercepta m�todos de neg�cio ap�s retorno da
     * execu��o com �xito. <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param joinPoint
     * @param integer
     * @throws Throwable
     */
    @After("execution(* br.com.bradesco.web.npcc_trade.aop.BeanNegocio.logicaNegocioAnteriorPosterior(..)) && args(integer)")
    public void afterReturning(JoinPoint joinPoint, Integer integer) throws Throwable {
        String value = "";
        value = integer.toString();
        ILogManager logger = BradescoCommonServiceFactory.getLogManager();
        logger.info(joinPoint.getClass(), "Dentro do after!");
        logger.info(joinPoint.getClass(), "A classe e o m�todo [" + joinPoint.getTarget().getClass().getSimpleName()
                + "." + joinPoint.getSignature().getName() + "] foram executados com �xito. O m�todo retornou "
                + integer.getClass().getSimpleName() + " " + value);
    }
}