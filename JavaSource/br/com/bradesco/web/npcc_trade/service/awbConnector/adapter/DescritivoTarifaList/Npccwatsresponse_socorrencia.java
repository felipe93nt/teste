package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/08/18 16:26
 */
public class Npccwatsresponse_socorrencia extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA.NPCCWATS-S-CCOND-ECONC")
	private Integer socorrencia_sccondeconc = 0;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA.NPCCWATS-S-DCCOND-ECONC")
	private String socorrencia_sdccondeconc = null;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA.NPCCWATS-S-DALTER")
	private String socorrencia_sdalter = null;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA.NPCCWATS-S-CUSUAR")
	private String socorrencia_scusuar = null;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA.NPCCWATS-S-HMANUT")
	private String socorrencia_shmanut = null;
	
	public Integer getSocorrencia_sccondeconc() {
		return socorrencia_sccondeconc;
	}
	public void setSocorrencia_sccondeconc(Integer socorrencia_sccondeconc) {
		this.socorrencia_sccondeconc = socorrencia_sccondeconc;
	}

	public String getSocorrencia_sdccondeconc() {
		return socorrencia_sdccondeconc;
	}
	public void setSocorrencia_sdccondeconc(String socorrencia_sdccondeconc) {
		this.socorrencia_sdccondeconc = socorrencia_sdccondeconc;
	}

	public String getSocorrencia_sdalter() {
		return socorrencia_sdalter;
	}
	public void setSocorrencia_sdalter(String socorrencia_sdalter) {
		this.socorrencia_sdalter = socorrencia_sdalter;
	}

	public String getSocorrencia_scusuar() {
		return socorrencia_scusuar;
	}
	public void setSocorrencia_scusuar(String socorrencia_scusuar) {
		this.socorrencia_scusuar = socorrencia_scusuar;
	}

	public String getSocorrencia_shmanut() {
		return socorrencia_shmanut;
	}
	public void setSocorrencia_shmanut(String socorrencia_shmanut) {
		this.socorrencia_shmanut = socorrencia_shmanut;
	}
    
}