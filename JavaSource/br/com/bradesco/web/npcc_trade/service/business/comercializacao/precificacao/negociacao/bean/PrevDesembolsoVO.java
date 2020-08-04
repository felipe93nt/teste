package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

/**
 * Nome: PrevDesembolsoVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 10/06/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class PrevDesembolsoVO {

    /** NPCCWYKE-NBLETO-NEGOC-CMBI  = CODIGO IDENTIFICADOR BOLETO */
    private Long nbletonegoccmbio = 0L;

    /** NPCCWV2S-HINCL-REG          = DATA/HORA INCLUSAO */
    private String hinclreg = null;

    /** NPCCWYKE-VPREVT-DSEMB-CMBIO = VALOR DESEMBOLSO */
    private String vprevtdsembcmbio = null;

    /** NPCCWYKE-DPREVT-DSEMB-CMBIO = DATA DESEMBOLSO */
    private String dprevtdsembcmbio = null;

    /** NPCCWYKE-TDIA-CAREN-PRINC   = QTD. DIAS CARENCIA PRINCIPAL */
    private Integer tdiacarenprinc = 0;

    /** NPCCWYKE-CFLUXO-LIQDC-PRINC = COD. PERIODICIDADE PRINCIPAL */
    private Integer cfluxoliqdcprinc = 0;

    /** NPCCWYKE-QPCELA-TRADE-PRINC = QTD. PARCELAS PRINCIPAL */
    private Integer qpcelatradeprinc = 0;

    /** NPCCWYKE-TDIA-CAREN-JURO    = QTD. DIAS CARENCIA JUROS */
    private Integer tdiacarenjuro = 0;

    /** NPCCWYKE-TDIA-FINAN-DSEMB   = PRAZO DO FINANCINAMENTO DIAS */
    private Integer tdiafinandsemb = 0;

    /** NPCCWYKE-CFLUXO-LIQDC-JURO  = COD. PERIODICIDADE JUROS */
    private Integer cfluxoliqdcjuro = 0;

    /** NPCCWYKE-QPCELA-TRADE-JURO  = QTD. PARCELAS JUROS */
    private Integer qpcelatradejuro = 0;

    /** NPCCWYKE-CMOMEN-COBR-CMBIO  = MOMENTO QUE REALIZOU COBRANCA */
    private Integer cmomencobrcmbio = 0;
    
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
     * @return o valor do vprevtdsembcmbio
     */
    public String getVprevtdsembcmbio() {
        return vprevtdsembcmbio;
    }

    /**
     * @param vprevtdsembcmbio seta o novo valor para o campo vprevtdsembcmbio
     */
    public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
        this.vprevtdsembcmbio = vprevtdsembcmbio;
    }

    /**
     * @return o valor do dprevtdsembcmbio
     */
    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do tdiacarenprinc
     */
    public Integer getTdiacarenprinc() {
        return tdiacarenprinc;
    }

    /**
     * @param tdiacarenprinc seta o novo valor para o campo tdiacarenprinc
     */
    public void setTdiacarenprinc(Integer tdiacarenprinc) {
        this.tdiacarenprinc = tdiacarenprinc;
    }

    /**
     * @return o valor do cfluxoliqdcprinc
     */
    public Integer getCfluxoliqdcprinc() {
        return cfluxoliqdcprinc;
    }

    /**
     * @param cfluxoliqdcprinc seta o novo valor para o campo cfluxoliqdcprinc
     */
    public void setCfluxoliqdcprinc(Integer cfluxoliqdcprinc) {
        this.cfluxoliqdcprinc = cfluxoliqdcprinc;
    }

    /**
     * @return o valor do qpcelatradeprinc
     */
    public Integer getQpcelatradeprinc() {
        return qpcelatradeprinc;
    }

    /**
     * @param qpcelatradeprinc seta o novo valor para o campo qpcelatradeprinc
     */
    public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
        this.qpcelatradeprinc = qpcelatradeprinc;
    }

    /**
     * @return o valor do tdiacarenjuro
     */
    public Integer getTdiacarenjuro() {
        return tdiacarenjuro;
    }

    /**
     * @param tdiacarenjuro seta o novo valor para o campo tdiacarenjuro
     */
    public void setTdiacarenjuro(Integer tdiacarenjuro) {
        this.tdiacarenjuro = tdiacarenjuro;
    }

    /**
     * @return o valor do tdiafinandsemb
     */
    public Integer getTdiafinandsemb() {
        return tdiafinandsemb;
    }

    /**
     * @param tdiafinandsemb seta o novo valor para o campo tdiafinandsemb
     */
    public void setTdiafinandsemb(Integer tdiafinandsemb) {
        this.tdiafinandsemb = tdiafinandsemb;
    }

    /**
     * @return o valor do cfluxoliqdcjuro
     */
    public Integer getCfluxoliqdcjuro() {
        return cfluxoliqdcjuro;
    }

    /**
     * @param cfluxoliqdcjuro seta o novo valor para o campo cfluxoliqdcjuro
     */
    public void setCfluxoliqdcjuro(Integer cfluxoliqdcjuro) {
        this.cfluxoliqdcjuro = cfluxoliqdcjuro;
    }

    /**
     * @return o valor do qpcelatradejuro
     */
    public Integer getQpcelatradejuro() {
        return qpcelatradejuro;
    }

    /**
     * @param qpcelatradejuro seta o novo valor para o campo qpcelatradejuro
     */
    public void setQpcelatradejuro(Integer qpcelatradejuro) {
        this.qpcelatradejuro = qpcelatradejuro;
    }

    /**
     * @return o valor do cmomencobrcmbio
     */
    public Integer getCmomencobrcmbio() {
        return cmomencobrcmbio;
    }

    /**
     * @param cmomencobrcmbio seta o novo valor para o campo cmomencobrcmbio
     */
    public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
        this.cmomencobrcmbio = cmomencobrcmbio;
    }
    
}