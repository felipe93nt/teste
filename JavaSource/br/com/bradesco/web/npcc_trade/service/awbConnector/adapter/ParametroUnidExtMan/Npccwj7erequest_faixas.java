package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/10/18 15:12
 */
public class Npccwj7erequest_faixas extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-FAIXAS.NPCCWJ7E-CBANQR-CMBIO")
	private Long faixas_cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-FAIXAS.NPCCWJ7E-VLIM-INFER-BANQR")
	private String faixas_vliminferbanqr = null;

	@Adapter(transactionField = "NPCCWJ7E-REGISTRO.NPCCWJ7E-FAIXAS.NPCCWJ7E-VLIM-SUPE-BANQR")
	private String faixas_vlimsupebanqr = null;
	
	public Long getFaixas_cbanqrcmbio() {
		return faixas_cbanqrcmbio;
	}
	public void setFaixas_cbanqrcmbio(Long faixas_cbanqrcmbio) {
		this.faixas_cbanqrcmbio = faixas_cbanqrcmbio;
	}

	public String getFaixas_vliminferbanqr() {
		return faixas_vliminferbanqr;
	}
	public void setFaixas_vliminferbanqr(String faixas_vliminferbanqr) {
		this.faixas_vliminferbanqr = faixas_vliminferbanqr;
	}

	public String getFaixas_vlimsupebanqr() {
		return faixas_vlimsupebanqr;
	}
	public void setFaixas_vlimsupebanqr(String faixas_vlimsupebanqr) {
		this.faixas_vlimsupebanqr = faixas_vlimsupebanqr;
	}
    
}