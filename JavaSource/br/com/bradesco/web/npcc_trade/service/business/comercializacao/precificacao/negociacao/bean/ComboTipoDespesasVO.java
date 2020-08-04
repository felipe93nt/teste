package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

public class ComboTipoDespesasVO {

    /* NPCCWIGS-DTPO-DESP-CMBIO = DESCRICAO DESPESA CAMBIO            */
    private String dtpodespcmbio = null;

    /* NPCCWIGS-CTPO-DESP-CMBIO = CODIGO DESPESA CAMBIO               */
    private Integer ctpodespcmbio = 0;

    /* NPCCWIGS-NTPO-SIT-CMBIO  = TIPO DESPESA                        */
    /*                            = 1 - DESPESA NACIONAL              */
    /*                            = 2 - DESPESA EXTERNA               */
    private Integer ntpositcmbio = 0;

    /**
     * @return o valor do dtpodespcmbio
     */
    public String getDtpodespcmbio() {
        return dtpodespcmbio;
    }

    /**
     * @param dtpodespcmbio seta o novo valor para o campo dtpodespcmbio
     */
    public void setDtpodespcmbio(String dtpodespcmbio) {
        this.dtpodespcmbio = dtpodespcmbio;
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
     * @return o valor do ntpositcmbio
     */
    public Integer getNtpositcmbio() {
        return ntpositcmbio;
    }

    /**
     * @param ntpositcmbio seta o novo valor para o campo ntpositcmbio
     */
    public void setNtpositcmbio(Integer ntpositcmbio) {
        this.ntpositcmbio = ntpositcmbio;
    }
  
}
