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

/**
 * Nome:BeanNegocio
 * Prop�sito: Classe que representa o bean de neg�cio <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@Named("beanAlvo")
@ApplicationScoped
public class BeanNegocio implements IBeanNegocio {
    /**
     * Nome: logicaNegocioExcecao <br/>
     * Prop�sito:Simula o lan�amento de uma exce��o por um
     * Bean para tratamento usando log + aspectos<br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @throws Exception
     * @see br.com.bradesco.web.npcc_trade.aop.IBeanNegocio#logicaNegocioExcecao()
     */
    public void logicaNegocioExcecao() throws Exception {
        throw new Exception();
    }

    /**
     * Nome: logicaNegocioAnteriorPosterior <br/>
     * Prop�sito:Simula a execu��o completa de um m�todo
     * para monitora��o usando log + aspectos <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param valor
     * @return
     * @see br.com.bradesco.web.npcc_trade.aop.IBeanNegocio#logicaNegocioAnteriorPosterior(java.lang.Integer)
     */
    public Integer logicaNegocioAnteriorPosterior(Integer valor) {
        Integer simulacao = valor;
        return simulacao;
    }

    /**
     * Nome: logicaNegocioEncapsulada <br/>
     * Prop�sito:Simula a execu��o de um m�todo com possibilidade
     * do lan�amento de exce��es para encapsulamento
     * usando log + aspectos <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param lancarExcecao
     * @param valor
     * @return
     * @throws Exception
     * @see br.com.bradesco.web.npcc_trade.aop.IBeanNegocio#logicaNegocioEncapsulada(boolean, java.lang.Integer)
     */
    public Integer logicaNegocioEncapsulada(boolean lancarExcecao, Integer valor) throws Exception {
        Integer simulacao = valor;
        if (lancarExcecao) {
            simulacao = simulacao / 0;
        }
        return simulacao;
    }
}