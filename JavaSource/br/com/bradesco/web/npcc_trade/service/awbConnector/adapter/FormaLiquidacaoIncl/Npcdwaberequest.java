package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:48
 */
public class Npcdwaberequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWABE-HEADER.NPCDWABE-COD-LAYOUT")
	private String codlayout = "NPCDWABE";

	@Adapter(transactionField = "NPCDWABE-HEADER.NPCDWABE-TAM-LAYOUT")
	private Integer tamlayout = 51;

	@Adapter(transactionField = "NPCDWABE-REGISTRO.NPCDWABE-CLIQDC-CMBIO-BACEN")
	private Integer cliqdccmbiobacen = 0;

	@Adapter(transactionField = "NPCDWABE-REGISTRO.NPCDWABE-IFORMA-LIQDC-BLETO")
	private String iformaliqdcbleto = null;

	@Adapter(transactionField = "NPCDWABE-REGISTRO.NPCDWABE-CMOEDA-ESTRG-NACIO")
	private Integer cmoedaestrgnacio = 0;

	@Adapter(transactionField = "NPCDWABE-REGISTRO.NPCDWABE-CSGL-FORMA-LIQDC")
	private String csglformaliqdc = null;

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
    
}