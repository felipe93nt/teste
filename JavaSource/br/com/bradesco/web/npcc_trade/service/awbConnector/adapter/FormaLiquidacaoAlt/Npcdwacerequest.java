package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:50
 */
public class Npcdwacerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWACE-HEADER.NPCDWACE-COD-LAYOUT")
	private String codlayout = "NPCDWACE";

	@Adapter(transactionField = "NPCDWACE-HEADER.NPCDWACE-TAM-LAYOUT")
	private Integer tamlayout = 255;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-CFORMA-LIQDC-CMBIO")
	private Integer cformaliqdccmbio = 0;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-CLIQDC-CMBIO-BACEN")
	private Integer cliqdccmbiobacen = 0;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-IFORMA-LIQDC-BLETO")
	private String iformaliqdcbleto = null;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-CMOEDA-ESTRG-NACIO")
	private Integer cmoedaestrgnacio = 0;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-CSGL-FORMA-LIQDC")
	private String csglformaliqdc = null;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-NTPO-SIT-CMBIO")
	private Integer ntpositcmbio = 0;

	@Adapter(transactionField = "NPCDWACE-REGISTRO.NPCDWACE-RJUSTF-SIT-CMBIO")
	private String rjustfsitcmbio = null;

    /**
     * @return o valor do codlayout
     */
    public String getCodlayout() {
        return codlayout;
    }

    /**
     * @param codlayout seta o novo valor para o campo codlayout
     */
    public void setCodlayout(String codlayout) {
        this.codlayout = codlayout;
    }

    /**
     * @return o valor do tamlayout
     */
    public Integer getTamlayout() {
        return tamlayout;
    }

    /**
     * @param tamlayout seta o novo valor para o campo tamlayout
     */
    public void setTamlayout(Integer tamlayout) {
        this.tamlayout = tamlayout;
    }

    /**
     * @return o valor do cformaliqdccmbio
     */
    public Integer getCformaliqdccmbio() {
        return cformaliqdccmbio;
    }

    /**
     * @param cformaliqdccmbio seta o novo valor para o campo cformaliqdccmbio
     */
    public void setCformaliqdccmbio(Integer cformaliqdccmbio) {
        this.cformaliqdccmbio = cformaliqdccmbio;
    }

    /**
     * @return o valor do cliqdccmbiobacen
     */
    public Integer getCliqdccmbiobacen() {
        return cliqdccmbiobacen;
    }

    /**
     * @param cliqdccmbiobacen seta o novo valor para o campo cliqdccmbiobacen
     */
    public void setCliqdccmbiobacen(Integer cliqdccmbiobacen) {
        this.cliqdccmbiobacen = cliqdccmbiobacen;
    }

    /**
     * @return o valor do iformaliqdcbleto
     */
    public String getIformaliqdcbleto() {
        return iformaliqdcbleto;
    }

    /**
     * @param iformaliqdcbleto seta o novo valor para o campo iformaliqdcbleto
     */
    public void setIformaliqdcbleto(String iformaliqdcbleto) {
        this.iformaliqdcbleto = iformaliqdcbleto;
    }

    /**
     * @return o valor do cmoedaestrgnacio
     */
    public Integer getCmoedaestrgnacio() {
        return cmoedaestrgnacio;
    }

    /**
     * @param cmoedaestrgnacio seta o novo valor para o campo cmoedaestrgnacio
     */
    public void setCmoedaestrgnacio(Integer cmoedaestrgnacio) {
        this.cmoedaestrgnacio = cmoedaestrgnacio;
    }

    /**
     * @return o valor do csglformaliqdc
     */
    public String getCsglformaliqdc() {
        return csglformaliqdc;
    }

    /**
     * @param csglformaliqdc seta o novo valor para o campo csglformaliqdc
     */
    public void setCsglformaliqdc(String csglformaliqdc) {
        this.csglformaliqdc = csglformaliqdc;
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

    /**
     * @return o valor do rjustfsitcmbio
     */
    public String getRjustfsitcmbio() {
        return rjustfsitcmbio;
    }

    /**
     * @param rjustfsitcmbio seta o novo valor para o campo rjustfsitcmbio
     */
    public void setRjustfsitcmbio(String rjustfsitcmbio) {
        this.rjustfsitcmbio = rjustfsitcmbio;
    }
    
}