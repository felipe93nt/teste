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

/**
 * Nome: IBeanNegocio
 * Propósito: Classe que representa a interface do bean de negocio <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
public interface IBeanNegocio {
    /**
     * Nome: logicaNegocioExcecao <br/>
     * Propósito: Tratar as exeções da logica do negocio <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @throws Exception
     */
    public void logicaNegocioExcecao() throws Exception;
    
    /**
     * Nome: logicaNegocioAnteriorPosterior <br/>
     * Propósito: método que devolve um valor da negociação anterior <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param valor
     * @return
     */
    public Integer logicaNegocioAnteriorPosterior(Integer valor);
    
    /**
     * Nome: logicaNegocioEncapsulada <br/>
     * Propósito: Encapsular a lógica do negócio <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param lancarExcecao
     * @param valor
     * @return
     * @throws Exception
     */
    public Integer logicaNegocioEncapsulada(boolean lancarExcecao, Integer valor) throws Exception;
}
