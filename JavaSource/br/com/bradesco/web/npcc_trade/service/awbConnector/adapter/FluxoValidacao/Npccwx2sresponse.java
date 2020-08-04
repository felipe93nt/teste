package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Npccwx2sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX2S-HEADER.NPCCWX2S-COD-LAYOUT")
	private String codlayout = "NPCCWX2S";

	@Adapter(transactionField = "NPCCWX2S-HEADER.NPCCWX2S-TAM-LAYOUT")
	private Integer tamlayout = 116;

	@Adapter(transactionField = "NPCCWX2S-REGISTRO.NPCCWX2S-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX2S-REGISTRO.NPCCWX2S-INFORMATIVO")
	private String informativo = null;
	
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

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getInformativo() {
		return informativo;
	}
	public void setInformativo(String informativo) {
		this.informativo = informativo;
	}
    
}