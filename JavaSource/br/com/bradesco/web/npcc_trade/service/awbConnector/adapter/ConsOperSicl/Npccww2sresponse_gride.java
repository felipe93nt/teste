package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/09/16 11:12
 */
public class Npccww2sresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-CCONTR-FINAN-EXPOR")
	private Integer gride_ccontrfinanexpor = 0;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-DFIM-FINAN-EXPOR")
	private String gride_dfimfinanexpor = null;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-CMOEDA-CMBIO-FINAN")
	private Integer gride_cmoedacmbiofinan = 0;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-VFINAN-EXPOR-CMBIO")
	private String gride_vfinanexporcmbio = null;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-VFINAN-DEVED-CMBIO")
	private String gride_vfinandevedcmbio = null;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE.NPCCWW2S-NDSEMB-CMBIO-TRADE")
	private Integer gride_ndsembcmbiotrade = 0;
	
	public Integer getGride_ccontrfinanexpor() {
		return gride_ccontrfinanexpor;
	}
	public void setGride_ccontrfinanexpor(Integer gride_ccontrfinanexpor) {
		this.gride_ccontrfinanexpor = gride_ccontrfinanexpor;
	}

	public String getGride_dfimfinanexpor() {
		return gride_dfimfinanexpor;
	}
	public void setGride_dfimfinanexpor(String gride_dfimfinanexpor) {
		this.gride_dfimfinanexpor = gride_dfimfinanexpor;
	}

	public Integer getGride_cmoedacmbiofinan() {
		return gride_cmoedacmbiofinan;
	}
	public void setGride_cmoedacmbiofinan(Integer gride_cmoedacmbiofinan) {
		this.gride_cmoedacmbiofinan = gride_cmoedacmbiofinan;
	}

	public String getGride_vfinanexporcmbio() {
		return gride_vfinanexporcmbio;
	}
	public void setGride_vfinanexporcmbio(String gride_vfinanexporcmbio) {
		this.gride_vfinanexporcmbio = gride_vfinanexporcmbio;
	}

	public String getGride_vfinandevedcmbio() {
		return gride_vfinandevedcmbio;
	}
	public void setGride_vfinandevedcmbio(String gride_vfinandevedcmbio) {
		this.gride_vfinandevedcmbio = gride_vfinandevedcmbio;
	}

	public Integer getGride_ndsembcmbiotrade() {
		return gride_ndsembcmbiotrade;
	}
	public void setGride_ndsembcmbiotrade(Integer gride_ndsembcmbiotrade) {
		this.gride_ndsembcmbiotrade = gride_ndsembcmbiotrade;
	}
    
}