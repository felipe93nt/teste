package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;



/**
  * Nome: ListaDespesasVO.java
  * 
  * PropÛsito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilaÁ„o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de ManutenÁ„o: 10/06/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr„o hexavision.
*/
public class ListaDespesasVO {
    
    /** NUMERO DA DESPESA **/
    private Long ndespbletocmbio = 0L;

    /** CODIGO TIPO DA DESPESA **/
    private Integer ctpodespcmbio = 0;

    /** DESCRI«√O TIPO DA DESPESA **/
    private String ntpodespcmbio = null;

    /** CODIGO RESPONSAVEL DESPESA  **/
    private Integer cidtfdrespdesp = 0;

    /** DESCRI«√O RESPONSAVEL DESP. **/
    private String nidtfdrespdesp = null;

    /** TAXA DA DESPESA **/
    private String pdespnegoccmbio = "0";

    /** CODIGO PERIODO TAXA **/
    private Integer cbasebletonegoc = 0;

    /** PERIODO DA TAXA **/
    private String nbasebletonegoc = null;

    /** CODIGO FLUXO PERIODO **/
    private Integer cfluxoperdccmbio = 0;

    /** DESCRIÁ„O FLUXO PERIODO **/
    private String nfluxoperdccmbio = null;

    /** CODIGO IDENTIFICAÁ„O MOEDA **/
    private Integer cindcdeconmmoeda = 0;

    /** DESCRIÁ„O DA MOEDA **/
    private String nindcdeconmmoeda = null;

    /** VALOR DA DESPESA **/
    private String vdespbletocmbio = "0";

    /** CODIGO FORMA DE PAGAMENTO **/
    private Integer cformacobrdesp = 0;

    /** DESCRIÁ„O DE FORMA PAGAMENT **/
    private String nformacobrdesp = null;

    /** VALOR MINIMO DESPESA **/
    private String vmindespcmbio = "0";
    
    /** Formata Despesa por conta (Recupera da consulta) **/
    private String formataDespesaPorconta = null;

    /**
     * @return o valor do ndespbletocmbio
     */
    public Long getNdespbletocmbio() {
        return ndespbletocmbio;
    }

    /**
     * @param ndespbletocmbio seta o novo valor para o campo ndespbletocmbio
     */
    public void setNdespbletocmbio(Long ndespbletocmbio) {
        this.ndespbletocmbio = ndespbletocmbio;
    }

    /**
     * @return o valor do ctpodespcmbio
     */
    public Integer getCtpodespcmbio() {
        return ctpodespcmbio;
    }

    /**
     * @param ctpodespcmbio seta o novo valor para o campo ctpodespcmbio
     */
    public void setCtpodespcmbio(Integer ctpodespcmbio) {
        this.ctpodespcmbio = ctpodespcmbio;
    }

    /**
     * @return o valor do ntpodespcmbio
     */
    public String getNtpodespcmbio() {
        return ntpodespcmbio;
    }

    /**
     * @param ntpodespcmbio seta o novo valor para o campo ntpodespcmbio
     */
    public void setNtpodespcmbio(String ntpodespcmbio) {
        this.ntpodespcmbio = ntpodespcmbio;
    }

    /**
     * @return o valor do cidtfdrespdesp
     */
    public Integer getCidtfdrespdesp() {
        return cidtfdrespdesp;
    }

    /**
     * @param cidtfdrespdesp seta o novo valor para o campo cidtfdrespdesp
     */
    public void setCidtfdrespdesp(Integer cidtfdrespdesp) {
        this.cidtfdrespdesp = cidtfdrespdesp;
    }

    /**
     * @return o valor do nidtfdrespdesp
     */
    public String getNidtfdrespdesp() {
        return nidtfdrespdesp;
    }

    /**
     * @param nidtfdrespdesp seta o novo valor para o campo nidtfdrespdesp
     */
    public void setNidtfdrespdesp(String nidtfdrespdesp) {
        this.nidtfdrespdesp = nidtfdrespdesp;
    }

    /**
     * @return o valor do pdespnegoccmbio
     */
    public String getPdespnegoccmbio() {
        return pdespnegoccmbio;
    }

    /**
     * @param pdespnegoccmbio seta o novo valor para o campo pdespnegoccmbio
     */
    public void setPdespnegoccmbio(String pdespnegoccmbio) {
        this.pdespnegoccmbio = pdespnegoccmbio;
    }

    /**
     * @return o valor do cbasebletonegoc
     */
    public Integer getCbasebletonegoc() {
        return cbasebletonegoc;
    }

    /**
     * @param cbasebletonegoc seta o novo valor para o campo cbasebletonegoc
     */
    public void setCbasebletonegoc(Integer cbasebletonegoc) {
        this.cbasebletonegoc = cbasebletonegoc;
    }

    /**
     * @return o valor do nbasebletonegoc
     */
    public String getNbasebletonegoc() {
        return nbasebletonegoc;
    }

    /**
     * @param nbasebletonegoc seta o novo valor para o campo nbasebletonegoc
     */
    public void setNbasebletonegoc(String nbasebletonegoc) {
        this.nbasebletonegoc = nbasebletonegoc;
    }

    /**
     * @return o valor do cfluxoperdccmbio
     */
    public Integer getCfluxoperdccmbio() {
        return cfluxoperdccmbio;
    }

    /**
     * @param cfluxoperdccmbio seta o novo valor para o campo cfluxoperdccmbio
     */
    public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
        this.cfluxoperdccmbio = cfluxoperdccmbio;
    }

    /**
     * @return o valor do nfluxoperdccmbio
     */
    public String getNfluxoperdccmbio() {
        return nfluxoperdccmbio;
    }

    /**
     * @param nfluxoperdccmbio seta o novo valor para o campo nfluxoperdccmbio
     */
    public void setNfluxoperdccmbio(String nfluxoperdccmbio) {
        this.nfluxoperdccmbio = nfluxoperdccmbio;
    }

    /**
     * @return o valor do cindcdeconmmoeda
     */
    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    /**
     * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
     */
    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }

    /**
     * @return o valor do nindcdeconmmoeda
     */
    public String getNindcdeconmmoeda() {
        return nindcdeconmmoeda;
    }

    /**
     * @param nindcdeconmmoeda seta o novo valor para o campo nindcdeconmmoeda
     */
    public void setNindcdeconmmoeda(String nindcdeconmmoeda) {
        this.nindcdeconmmoeda = nindcdeconmmoeda;
    }

    /**
     * @return o valor do vdespbletocmbio
     */
    public String getVdespbletocmbio() {
        return vdespbletocmbio;
    }

    /**
     * @param vdespbletocmbio seta o novo valor para o campo vdespbletocmbio
     */
    public void setVdespbletocmbio(String vdespbletocmbio) {
        this.vdespbletocmbio = vdespbletocmbio;
    }

    /**
     * @return o valor do cformacobrdesp
     */
    public Integer getCformacobrdesp() {
        return cformacobrdesp;
    }

    /**
     * @param cformacobrdesp seta o novo valor para o campo cformacobrdesp
     */
    public void setCformacobrdesp(Integer cformacobrdesp) {
        this.cformacobrdesp = cformacobrdesp;
    }

    /**
     * @return o valor do nformacobrdesp
     */
    public String getNformacobrdesp() {
        return nformacobrdesp;
    }

    /**
     * @param nformacobrdesp seta o novo valor para o campo nformacobrdesp
     */
    public void setNformacobrdesp(String nformacobrdesp) {
        this.nformacobrdesp = nformacobrdesp;
    }

    /**
     * @return o valor do vmindespcmbio
     */
    public String getVmindespcmbio() {
        return vmindespcmbio;
    }

    /**
     * @param vmindespcmbio seta o novo valor para o campo vmindespcmbio
     */
    public void setVmindespcmbio(String vmindespcmbio) {
        this.vmindespcmbio = vmindespcmbio;
    }

    public String getFormataDespesaPorconta() {
        return formataDespesaPorconta;
    }

    public void setFormataDespesaPorconta(String formataDespesaPorconta) {
        this.formataDespesaPorconta = formataDespesaPorconta;
    }

}
