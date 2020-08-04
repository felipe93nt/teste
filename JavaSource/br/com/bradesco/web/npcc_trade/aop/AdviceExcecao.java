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
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;

/**
 * Nome: AdviceExcecao
 * Propósito: Classe responsável por interceptar os métodos do negócio quando houver uma exceção <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@Aspect
@Named("adviceExcecao")
@ApplicationScoped
public class AdviceExcecao {
    /**
     * Nome: afterThrowing <br/>
     * Propósito: Intercepta métodos de negócio quando ocorrer o lançamento
     * de exceções. <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param joinPoint
     * @param error
     */
    @AfterThrowing(pointcut = "execution(* br.com.bradesco.web.npcc_trade.aop.BeanNegocio.logicaNegocioExcecao(..))", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        ILogManager logger = BradescoCommonServiceFactory.getLogManager();
        logger.error(joinPoint.getTarget().getClass(), "Logando Exceção usando Aspectos. StackTrace: ",
                error.getCause());
    }
}