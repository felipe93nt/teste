package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Npccwx2erequest_lstmerc extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-CMCADO-OPER-CMBIO")
	private Integer lstmerc_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-CUNIC-PSSOA-CMBIO")
	private Long lstmerc_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-CPAIS-ORIGM")
	private Integer lstmerc_cpaisorigm = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-CPAIS-BNEFC")
	private Integer lstmerc_cpaisbnefc = 0;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-DPREVT-EMBRQ")
	private String lstmerc_dprevtembrq = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWX2E-LST-MERC.NPCCWX2E-NDSEMB-MCADO-TRADE")
	private Integer lstmerc_ndsembmcadotrade = 0;
	
	public Integer getLstmerc_cmcadoopercmbio() {
		return lstmerc_cmcadoopercmbio;
	}
	public void setLstmerc_cmcadoopercmbio(Integer lstmerc_cmcadoopercmbio) {
		this.lstmerc_cmcadoopercmbio = lstmerc_cmcadoopercmbio;
	}

	public Long getLstmerc_cunicpssoacmbio() {
		return lstmerc_cunicpssoacmbio;
	}
	public void setLstmerc_cunicpssoacmbio(Long lstmerc_cunicpssoacmbio) {
		this.lstmerc_cunicpssoacmbio = lstmerc_cunicpssoacmbio;
	}

	public Integer getLstmerc_cpaisorigm() {
		return lstmerc_cpaisorigm;
	}
	public void setLstmerc_cpaisorigm(Integer lstmerc_cpaisorigm) {
		this.lstmerc_cpaisorigm = lstmerc_cpaisorigm;
	}

	public Integer getLstmerc_cpaisbnefc() {
		return lstmerc_cpaisbnefc;
	}
	public void setLstmerc_cpaisbnefc(Integer lstmerc_cpaisbnefc) {
		this.lstmerc_cpaisbnefc = lstmerc_cpaisbnefc;
	}

	public String getLstmerc_dprevtembrq() {
		return lstmerc_dprevtembrq;
	}
	public void setLstmerc_dprevtembrq(String lstmerc_dprevtembrq) {
		this.lstmerc_dprevtembrq = lstmerc_dprevtembrq;
	}

	public Integer getLstmerc_ndsembmcadotrade() {
		return lstmerc_ndsembmcadotrade;
	}
	public void setLstmerc_ndsembmcadotrade(Integer lstmerc_ndsembmcadotrade) {
		this.lstmerc_ndsembmcadotrade = lstmerc_ndsembmcadotrade;
	}
    
}