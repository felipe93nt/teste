package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean;


public class ConsultaDivInternacFiltroVO {

   /* NPCCWZLE-DTPER-INI           = DATA FINAL PERIODO */
    private String dtperini = null;

   /* NPCCWZLE-DTPER-FIM           = DATA INICIO PERIODO */
    private String dtperfim = null;

   /* NPCCWZLE-CPRODT-SERVC        = CODIGO DO PRODUTO */
    private Integer cprodtservc = 0;

   /* NPCCWZLE-CSIT-BLETO-CMBIO    = SITUACAO DA COTACAO */
    private Integer csitbletocmbio = 0;

   /* NPCCWZLE-VNEGOC-MOEDA-ESTRGI = VALOR INICIAL DA MOEDA */
    private String vnegocmoedaestrgi = null;

   /* NPCCWZLE-VNEGOC-MOEDA-ESTRGF = VALOR FINAL DA MOEDA */
    private String vnegocmoedaestrgf = null;

   /* NPCCWZLE-CTPO-NEGOC-CMBIO    = TIPO DE COTACAO */
    private Integer ctponegoccmbio = 0;
    
    /**
     * @return o valor do dtperini
     */
    public String getDtperini() {
        return dtperini;
    }

    /**
     * @param dtperini seta o novo valor para o campo dtperini
     */
    public void setDtperini(String dtperini) {
        this.dtperini = dtperini;
    }

    /**
     * @return o valor do dtperfim
     */
    public String getDtperfim() {
        return dtperfim;
    }

    /**
     * @param dtperfim seta o novo valor para o campo dtperfim
     */
    public void setDtperfim(String dtperfim) {
        this.dtperfim = dtperfim;
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
     * @return o valor do vnegocmoedaestrgi
     */
    public String getVnegocmoedaestrgi() {
        return vnegocmoedaestrgi;
    }

    /**
     * @param vnegocmoedaestrgi seta o novo valor para o campo vnegocmoedaestrgi
     */
    public void setVnegocmoedaestrgi(String vnegocmoedaestrgi) {
        this.vnegocmoedaestrgi = vnegocmoedaestrgi;
    }

    /**
     * @return o valor do vnegocmoedaestrgf
     */
    public String getVnegocmoedaestrgf() {
        return vnegocmoedaestrgf;
    }

    /**
     * @param vnegocmoedaestrgf seta o novo valor para o campo vnegocmoedaestrgf
     */
    public void setVnegocmoedaestrgf(String vnegocmoedaestrgf) {
        this.vnegocmoedaestrgf = vnegocmoedaestrgf;
    }

    /**
     * @return o valor do ctponegoccmbio
     */
    public Integer getCtponegoccmbio() {
        return ctponegoccmbio;
    }

    /**
     * @param ctponegoccmbio seta o novo valor para o campo ctponegoccmbio
     */
    public void setCtponegoccmbio(Integer ctponegoccmbio) {
        this.ctponegoccmbio = ctponegoccmbio;
    }

}
