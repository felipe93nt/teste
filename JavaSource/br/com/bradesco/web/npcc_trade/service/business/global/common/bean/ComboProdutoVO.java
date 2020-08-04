/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 14/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;



/**
 * Nome: ComboProdutoVO.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 14/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class ComboProdutoVO implements Comparable<ComboProdutoVO>{

    /**** Campos da Entrada  *****/

    private Integer cidtfdmesacmbio = 0;

    private Integer ccmbioprodtfutur = 0;

    private Integer ccomczprodtcmbio = 0;

    /**** Campos da Saída  *****/

    private Integer cprodtservc = 0;

    private String rprodtservc = null;

    /**
     * @return o valor do cidtfdmesacmbio
     */
    public Integer getCidtfdmesacmbio() {
        return cidtfdmesacmbio;
    }

    /**
     * @param cidtfdmesacmbio seta o novo valor para o campo cidtfdmesacmbio
     */
    public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
        this.cidtfdmesacmbio = cidtfdmesacmbio;
    }

    /**
     * @return o valor do ccmbioprodtfutur
     */
    public Integer getCcmbioprodtfutur() {
        return ccmbioprodtfutur;
    }

    /**
     * @param ccmbioprodtfutur seta o novo valor para o campo ccmbioprodtfutur
     */
    public void setCcmbioprodtfutur(Integer ccmbioprodtfutur) {
        this.ccmbioprodtfutur = ccmbioprodtfutur;
    }

    /**
     * @return o valor do ccomczprodtcmbio
     */
    public Integer getCcomczprodtcmbio() {
        return ccomczprodtcmbio;
    }

    /**
     * @param ccomczprodtcmbio seta o novo valor para o campo ccomczprodtcmbio
     */
    public void setCcomczprodtcmbio(Integer ccomczprodtcmbio) {
        this.ccomczprodtcmbio = ccomczprodtcmbio;
    }

    /**
     * @return o valor do cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }

    /**
     * @param cprodtservc seta o novo valor para o campo cprodtservc
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    /**
     * @return o valor do rprodtservc
     */
    public String getRprodtservc() {
        return rprodtservc;
    }

    /**
     * @param rprodtservc seta o novo valor para o campo rprodtservc
     */
    public void setRprodtservc(String rprodtservc) {
        this.rprodtservc = rprodtservc;
    }

    /**
     * Nome: compareTo
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 31/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    @Override
    public int compareTo(ComboProdutoVO next) {
        // Verifica se possui valor antes de fazer a comparação
        if (getRprodtservc() != null) {
            return getRprodtservc().compareToIgnoreCase(next.getRprodtservc());
        } else {
            return -1;
        }
    }
}
