/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Prop×£sito: Uso exclusivo do Bradesco, cont×™m
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;

/**
 * Nome: TrdFinNegocInclVO.java
 * 
 * Prop×£sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 02/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class VincularOperacaoLcVO {

	private String msgRetorno = null;
	
	private Long nbletonegoccmbio = 0L;

    private Long nbletovncloimpor = 0L;

    private String hinclreg = null;
	
    private Integer cprodtservc = 0;
    
    private Integer csitbletocmbio = 0;
    
    private Integer csitequal = 0;
    
    private String hinclreghist = null;
    
    private boolean origemAlteracao = false;
    
    private Integer csitbletoaprov = 0;

    private Integer cmodcontrcmbio = 0;
    
    private Integer funcaoTela = 0;
    
    private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
    
    public EnumProduto getProduto() {
        return EnumProduto.fromCode(this.cprodtservc);
    }

    /**
     * @return o valor do msgRetorno
     */
    public String getMsgRetorno() {
        return msgRetorno;
    }

    /**
     * @param msgRetorno seta o novo valor para o campo msgRetorno
     */
    public void setMsgRetorno(String msgRetorno) {
        this.msgRetorno = msgRetorno;
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
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }

    /**
     * @param clienteSelecaoVO seta o novo valor para o campo clienteSelecaoVO
     */
    public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
        this.clienteSelecaoVO = clienteSelecaoVO;
    }

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do nbletovncloimpor
     */
    public Long getNbletovncloimpor() {
        return nbletovncloimpor;
    }

    /**
     * @param nbletovncloimpor seta o novo valor para o campo nbletovncloimpor
     */
    public void setNbletovncloimpor(Long nbletovncloimpor) {
        this.nbletovncloimpor = nbletovncloimpor;
    }

    /**
     * @return o valor do hinclreg
     */
    public String getHinclreg() {
        return hinclreg;
    }

    /**
     * @param hinclreg seta o novo valor para o campo hinclreg
     */
    public void setHinclreg(String hinclreg) {
        this.hinclreg = hinclreg;
    }

    /**
     * @return o valor do csitbletocmbio
     */
    public Integer getCsitbletocmbio() {
        return csitbletocmbio;
    }

    /**
     * @param csitbletocmbio seta o novo valor para o campo csitbletocmbio
     */
    public void setCsitbletocmbio(Integer csitbletocmbio) {
        this.csitbletocmbio = csitbletocmbio;
    }

    /**
     * @return o valor do csitequal
     */
    public Integer getCsitequal() {
        return csitequal;
    }

    /**
     * @param csitequal seta o novo valor para o campo csitequal
     */
    public void setCsitequal(Integer csitequal) {
        this.csitequal = csitequal;
    }

    /**
     * @return o valor do hinclreghist
     */
    public String getHinclreghist() {
        return hinclreghist;
    }

    /**
     * @param hinclreghist seta o novo valor para o campo hinclreghist
     */
    public void setHinclreghist(String hinclreghist) {
        this.hinclreghist = hinclreghist;
    }

    /**
     * @return o valor do origemAlteracao
     */
    public boolean isOrigemAlteracao() {
        return origemAlteracao;
    }

    /**
     * @param origemAlteracao seta o novo valor para o campo origemAlteracao
     */
    public void setOrigemAlteracao(boolean origemAlteracao) {
        this.origemAlteracao = origemAlteracao;
    }

    /**
     * @return o valor do csitbletoaprov
     */
    public Integer getCsitbletoaprov() {
        return csitbletoaprov;
    }

    /**
     * @param csitbletoaprov seta o novo valor para o campo csitbletoaprov
     */
    public void setCsitbletoaprov(Integer csitbletoaprov) {
        this.csitbletoaprov = csitbletoaprov;
    }

    /**
     * @return o valor do cmodcontrcmbio
     */
    public Integer getCmodcontrcmbio() {
        return cmodcontrcmbio;
    }

    /**
     * @param cmodcontrcmbio seta o novo valor para o campo cmodcontrcmbio
     */
    public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
        this.cmodcontrcmbio = cmodcontrcmbio;
    }

    /**
     * @return o valor do funcaoTela
     */
    public Integer getFuncaoTela() {
        return funcaoTela;
    }

    /**
     * @param funcaoTela seta o novo valor para o campo funcaoTela
     */
    public void setFuncaoTela(Integer funcaoTela) {
        this.funcaoTela = funcaoTela;
    }  
}
