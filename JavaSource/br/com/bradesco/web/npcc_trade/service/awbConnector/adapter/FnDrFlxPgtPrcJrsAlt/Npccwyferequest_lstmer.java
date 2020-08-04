package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 15:23
 */
public class Npccwyferequest_lstmer extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-CMCADO-OPER-CMBIO")
	private Integer lstmer_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-NMCADO-CMBIO-TRADE")
	private Integer lstmer_nmcadocmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-CPAIS")
	private Integer lstmer_cpais = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-CUNIC-PSSOA-MCADO")
	private Long lstmer_cunicpssoamcado = 0L;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-CPAIS-BNEFC")
	private Integer lstmer_cpaisbnefc = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER.NPCCWYFE-DPREVT-EMBRQ")
	private String lstmer_dprevtembrq = null;
	
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

	public String getLstmer_dprevtembrq() {
		return lstmer_dprevtembrq;
	}
	public void setLstmer_dprevtembrq(String lstmer_dprevtembrq) {
		this.lstmer_dprevtembrq = lstmer_dprevtembrq;
	}
    
}