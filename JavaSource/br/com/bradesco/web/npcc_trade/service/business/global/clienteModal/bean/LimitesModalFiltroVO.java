/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;

/**
 * Nome: LimitesModalFiltroVO.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class LimitesModalFiltroVO {

    private Integer produto = null;
    private Long cunicpssoacmbio = null;
    private Long cpessoa = null;
    private Integer pais = null;
    private CnpjDataType cnpj = null;

    /**
     * @return o valor do produto
     */
    public Integer getProduto() {
        return produto;
    }

    /**
     * @param produto seta o novo valor para o campo produto
     */
    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    /**
     * @return o valor do cunicpssoacmbio
     */
    public Long getCunicpssoacmbio() {
        return cunicpssoacmbio;
    }

    /**
     * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
     */
    public void setCunicpssoacmbio(Long cunicpssoacmbio) {
        this.cunicpssoacmbio = cunicpssoacmbio;
    }

    /**
     * @return o valor do pais
     */
    public Integer getPais() {
        return pais;
    }

    /**
     * @param pais seta o novo valor para o campo pais
     */
    public void setPais(Integer pais) {
        this.pais = pais;
    }

    /**
     * @return o valor do cnpj
     */
    public CnpjDataType getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj seta o novo valor para o campo cnpj
     */
    public void setCnpj(CnpjDataType cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return o valor do cpessoa
     */
    public Long getCpessoa() {
        return cpessoa;
    }

    /**
     * @param cpessoa seta o novo valor para o campo cpessoa
     */
    public void setCpessoa(Long cpessoa) {
        this.cpessoa = cpessoa;
    }

}
