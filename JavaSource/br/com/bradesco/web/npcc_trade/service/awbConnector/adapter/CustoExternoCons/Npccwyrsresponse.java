package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/04/16 12:32
 */
public class Npccwyrsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYRS-HEADER.NPCCWYRS-COD-LAYOUT")
	private String codlayout = "NPCCWYRS";

	@Adapter(transactionField = "NPCCWYRS-HEADER.NPCCWYRS-TAM-LAYOUT")
	private Integer tamlayout = 69;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-VALIDADE-COTAC")
	private Integer validadecotac = 0;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-DT-COTAC")
	private String dtcotac = null;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-CUSTO-EXT")
	private String custoext = null;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-ISGL-INDCD-FONTE")
	private String isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-PRZO-MEDIO-DSEMB-M")
	private Integer przomediodsembm = 0;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-SPREAD-CLEAN")
	private String spreadclean = null;

	@Adapter(transactionField = "NPCCWYRS-REGISTRO.NPCCWYRS-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Integer getValidadecotac() {
		return validadecotac;
	}
	public void setValidadecotac(Integer validadecotac) {
		this.validadecotac = validadecotac;
	}

	public String getDtcotac() {
		return dtcotac;
	}
	public void setDtcotac(String dtcotac) {
		this.dtcotac = dtcotac;
	}

	public String getCustoext() {
		return custoext;
	}
	public void setCustoext(String custoext) {
		this.custoext = custoext;
	}

	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	public Integer getPrzomediodsembm() {
		return przomediodsembm;
	}
	public void setPrzomediodsembm(Integer przomediodsembm) {
		this.przomediodsembm = przomediodsembm;
	}

	public String getSpreadclean() {
		return spreadclean;
	}
	public void setSpreadclean(String spreadclean) {
		this.spreadclean = spreadclean;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}
    
}