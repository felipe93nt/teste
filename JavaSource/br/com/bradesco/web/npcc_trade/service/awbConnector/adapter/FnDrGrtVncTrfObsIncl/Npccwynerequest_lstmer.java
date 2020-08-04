package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest_lstmer extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-NDSEMB-CMBIO-TRADE")
	private Integer lstmer_ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-CMCADO-OPER-CMBIO")
	private Integer lstmer_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-CPAIS")
	private Integer lstmer_cpais = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-CPAIS-EMBRQ")
	private Integer lstmer_cpaisembrq = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-QPREVT-EMBRQ-CMBIO")
	private Integer lstmer_qprevtembrqcmbio = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-CUNIC-PSSOA-MCADO")
	private Long lstmer_cunicpssoamcado = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-CPAIS-BNEFC")
	private Integer lstmer_cpaisbnefc = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-MER.NPCCWYNE-DPREVT-EMBRQ")
	private String lstmer_dprevtembrq = null;
	
	public Integer getLstmer_ndsembcmbiotrade() {
		return lstmer_ndsembcmbiotrade;
	}
	public void setLstmer_ndsembcmbiotrade(Integer lstmer_ndsembcmbiotrade) {
		this.lstmer_ndsembcmbiotrade = lstmer_ndsembcmbiotrade;
	}

	public Integer getLstmer_cmcadoopercmbio() {
		return lstmer_cmcadoopercmbio;
	}
	public void setLstmer_cmcadoopercmbio(Integer lstmer_cmcadoopercmbio) {
		this.lstmer_cmcadoopercmbio = lstmer_cmcadoopercmbio;
	}

	public Integer getLstmer_cpais() {
		return lstmer_cpais;
	}
	public void setLstmer_cpais(Integer lstmer_cpais) {
		this.lstmer_cpais = lstmer_cpais;
	}

	public Integer getLstmer_cpaisembrq() {
		return lstmer_cpaisembrq;
	}
	public void setLstmer_cpaisembrq(Integer lstmer_cpaisembrq) {
		this.lstmer_cpaisembrq = lstmer_cpaisembrq;
	}

	public Integer getLstmer_qprevtembrqcmbio() {
		return lstmer_qprevtembrqcmbio;
	}
	public void setLstmer_qprevtembrqcmbio(Integer lstmer_qprevtembrqcmbio) {
		this.lstmer_qprevtembrqcmbio = lstmer_qprevtembrqcmbio;
	}

	public Long getLstmer_cunicpssoamcado() {
		return lstmer_cunicpssoamcado;
	}
	public void setLstmer_cunicpssoamcado(Long lstmer_cunicpssoamcado) {
		this.lstmer_cunicpssoamcado = lstmer_cunicpssoamcado;
	}

	public Integer getLstmer_cpaisbnefc() {
		return lstmer_cpaisbnefc;
	}
	public void setLstmer_cpaisbnefc(Integer lstmer_cpaisbnefc) {
		this.lstmer_cpaisbnefc = lstmer_cpaisbnefc;
	}

	public String getLstmer_dprevtembrq() {
		return lstmer_dprevtembrq;
	}
	public void setLstmer_dprevtembrq(String lstmer_dprevtembrq) {
		this.lstmer_dprevtembrq = lstmer_dprevtembrq;
	}
    
}