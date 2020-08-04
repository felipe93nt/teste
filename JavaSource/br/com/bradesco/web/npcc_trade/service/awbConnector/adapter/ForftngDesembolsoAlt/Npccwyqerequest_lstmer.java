package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/09/16 17:33
 */
public class Npccwyqerequest_lstmer extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-CMCADO-OPER-CMBIO")
	private Integer lstmer_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-NMCADO-CMBIO-TRADE")
	private Integer lstmer_nmcadocmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-CPAIS")
	private Integer lstmer_cpais = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-CUNIC-PSSOA-MCADO")
	private Long lstmer_cunicpssoamcado = 0L;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-CPAIS-BNEFC")
	private Integer lstmer_cpaisbnefc = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER.NPCCWYQE-DPREVT-EMBRQ-M")
	private String lstmer_dprevtembrqm = null;
	
	public Integer getLstmer_cmcadoopercmbio() {
		return lstmer_cmcadoopercmbio;
	}
	public void setLstmer_cmcadoopercmbio(Integer lstmer_cmcadoopercmbio) {
		this.lstmer_cmcadoopercmbio = lstmer_cmcadoopercmbio;
	}

	public Integer getLstmer_nmcadocmbiotrade() {
		return lstmer_nmcadocmbiotrade;
	}
	public void setLstmer_nmcadocmbiotrade(Integer lstmer_nmcadocmbiotrade) {
		this.lstmer_nmcadocmbiotrade = lstmer_nmcadocmbiotrade;
	}

	public Integer getLstmer_cpais() {
		return lstmer_cpais;
	}
	public void setLstmer_cpais(Integer lstmer_cpais) {
		this.lstmer_cpais = lstmer_cpais;
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

	public String getLstmer_dprevtembrqm() {
		return lstmer_dprevtembrqm;
	}
	public void setLstmer_dprevtembrqm(String lstmer_dprevtembrqm) {
		this.lstmer_dprevtembrqm = lstmer_dprevtembrqm;
	}
    
}