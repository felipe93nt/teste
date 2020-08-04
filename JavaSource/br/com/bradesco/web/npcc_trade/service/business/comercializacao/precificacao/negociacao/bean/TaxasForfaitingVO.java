/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 13/01/2016
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

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bradesco.data.connector.Adapter;


/**
 * Nome: TaxasForfaitingVO.java
 * 
 * Propósito: Área com Dados Temporários de trabalho
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TaxasForfaitingVO {

	/*** 1 - EMBUTIDO 2 - DEDUZIDO ***/
    private Integer jurosembded = 0;

    /*** VALOR OPERACAO ***/
    private String vnegocmoedaestrg = null;

    /*** PRAZO DA OPERACAO ***/
    private Integer tdiaopercmbio = 0;

    /*** LIBOR TRAVADA ***/
    private String vtravaliborcmbio = null;

    /*** CUSTO EXTERNO ***/
    private String vtxliborcmbio = null;

    /*** SPREAD NEGOCIADO ***/
    private String vtxspreadnegoc = null;

    /*** TAXA ***/
    private String taxajuros = null;

    /*** TAXA DESCONTADA ***/
    private String taxadescontada = null;

    /*** VALOR DE JUROS NO SAQUE ***/
    private String valorjuros = null;

    /*** VALOR DO SAQUE TOTAL ***/
    private String valorsaque = null;

    /***************  Quadro de Operacao Forfaiting **************/

    private String infoCol1 = null;
    
    private String infoCol2 = null;

    /**
     * @return o valor do jurosembded
     */
    public Integer getJurosembded() {
        return jurosembded;
    }

    /**
     * @param jurosembded seta o novo valor para o campo jurosembded
     */
    public void setJurosembded(Integer jurosembded) {
        this.jurosembded = jurosembded;
    }

    /**
     * @return o valor do vnegocmoedaestrg
     */
    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    /**
     * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
     */
    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    /**
     * @return o valor do tdiaopercmbio
     */
    public Integer getTdiaopercmbio() {
        return tdiaopercmbio;
    }

    /**
     * @param tdiaopercmbio seta o novo valor para o campo tdiaopercmbio
     */
    public void setTdiaopercmbio(Integer tdiaopercmbio) {
        this.tdiaopercmbio = tdiaopercmbio;
    }

    /**
     * @return o valor do vtravaliborcmbio
     */
    public String getVtravaliborcmbio() {
        return vtravaliborcmbio;
    }

    /**
     * @param vtravaliborcmbio seta o novo valor para o campo vtravaliborcmbio
     */
    public void setVtravaliborcmbio(String vtravaliborcmbio) {
        this.vtravaliborcmbio = vtravaliborcmbio;
    }

    /**
     * @return o valor do vtxliborcmbio
     */
    public String getVtxliborcmbio() {
        return vtxliborcmbio;
    }

    /**
     * @param vtxliborcmbio seta o novo valor para o campo vtxliborcmbio
     */
    public void setVtxliborcmbio(String vtxliborcmbio) {
        this.vtxliborcmbio = vtxliborcmbio;
    }

    /**
     * @return o valor do vtxspreadnegoc
     */
    public String getVtxspreadnegoc() {
        return vtxspreadnegoc;
    }

    /**
     * @param vtxspreadnegoc seta o novo valor para o campo vtxspreadnegoc
     */
    public void setVtxspreadnegoc(String vtxspreadnegoc) {
        this.vtxspreadnegoc = vtxspreadnegoc;
    }

    /**
     * @return o valor do taxajuros
     */
    public String getTaxajuros() {
        return taxajuros;
    }

    /**
     * @param taxajuros seta o novo valor para o campo taxajuros
     */
    public void setTaxajuros(String taxajuros) {
        this.taxajuros = taxajuros;
    }

    /**
     * @return o valor do taxadescontada
     */
    public String getTaxadescontada() {
        return taxadescontada;
    }

    /**
     * @param taxadescontada seta o novo valor para o campo taxadescontada
     */
    public void setTaxadescontada(String taxadescontada) {
        this.taxadescontada = taxadescontada;
    }

    /**
     * @return o valor do valorjuros
     */
    public String getValorjuros() {
        return valorjuros;
    }

    /**
     * @param valorjuros seta o novo valor para o campo valorjuros
     */
    public void setValorjuros(String valorjuros) {
        this.valorjuros = valorjuros;
    }

    /**
     * @return o valor do valorsaque
     */
    public String getValorsaque() {
        return valorsaque;
    }

    /**
     * @param valorsaque seta o novo valor para o campo valorsaque
     */
    public void setValorsaque(String valorsaque) {
        this.valorsaque = valorsaque;
    }

    /**
     * @return o valor do infoCol1
     */
    public String getInfoCol1() {
        return infoCol1;
    }

    /**
     * @param infoCol1 seta o novo valor para o campo infoCol1
     */
    public void setInfoCol1(String infoCol1) {
        this.infoCol1 = infoCol1;
    }

    /**
     * @return o valor do infoCol2
     */
    public String getInfoCol2() {
        return infoCol2;
    }

    /**
     * @param infoCol2 seta o novo valor para o campo infoCol2
     */
    public void setInfoCol2(String infoCol2) {
        this.infoCol2 = infoCol2;
    }
	
}
