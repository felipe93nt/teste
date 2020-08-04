package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/09/16 10:19
 */
public class Npccwzmsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZMS-HEADER.NPCCWZMS-COD-LAYOUT")
	private String codlayout = "NPCCWZMS";

	@Adapter(transactionField = "NPCCWZMS-HEADER.NPCCWZMS-TAM-LAYOUT")
	private Integer tamlayout = 262;

	@Adapter(transactionField = "NPCCWZMS-SAIDA.NPCCWZMS-CUNIC-PSSOA-DCMBIO")
	private String cunicpssoadcmbio = null;

	@Adapter(transactionField = "NPCCWZMS-SAIDA.NPCCWZMS-IPAIS-CMBIO")
	private String ipaiscmbio = null;

	@Adapter(transactionField = "NPCCWZMS-SAIDA.NPCCWZMS-ICIDD-CMBIO")
	private String iciddcmbio = null;

	@Adapter(transactionField = "NPCCWZMS-SAIDA.NPCCWZMS-LOGRD-CMBIO")
	private String logrdcmbio = null;
	
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

	public String getCunicpssoadcmbio() {
		return cunicpssoadcmbio;
	}
	public void setCunicpssoadcmbio(String cunicpssoadcmbio) {
		this.cunicpssoadcmbio = cunicpssoadcmbio;
	}

	public String getIpaiscmbio() {
		return ipaiscmbio;
	}
	public void setIpaiscmbio(String ipaiscmbio) {
		this.ipaiscmbio = ipaiscmbio;
	}

	public String getIciddcmbio() {
		return iciddcmbio;
	}
	public void setIciddcmbio(String iciddcmbio) {
		this.iciddcmbio = iciddcmbio;
	}

	public String getLogrdcmbio() {
		return logrdcmbio;
	}
	public void setLogrdcmbio(String logrdcmbio) {
		this.logrdcmbio = logrdcmbio;
	}
    
}