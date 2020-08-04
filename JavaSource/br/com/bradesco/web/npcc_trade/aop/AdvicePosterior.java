/**
 * Nome: br.com.bradesco.web.npcc_trade.aop
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
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
 * Propósito: Classe responsável por interceptar os métodos do negócio após sua execução <br/>
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
     * Propósito: Intercepta métodos de negócio após retorno da
     * execução com êxito. <br/>
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
        logger.info(joinPoint.getClass(), "A classe e o método [" + joinPoint.getTarget().getClass().getSimpleName()
                + "." + joinPoint.getSignature().getName() + "] foram executados com êxito. O método retornou "
                + integer.getClass().getSimpleName() + " " + value);
    }
}