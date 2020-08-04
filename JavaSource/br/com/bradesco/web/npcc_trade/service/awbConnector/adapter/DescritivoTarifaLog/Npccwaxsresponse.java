package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 03/09/18 16:07
 */
public class Npccwaxsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAXS-HEADER.NPCCWAXS-COD-LAYOUT")
	private String codlayout = "NPCCWAXS";

	@Adapter(transactionField = "NPCCWAXS-HEADER.NPCCWAXS-TAM-LAYOUT")
	private Integer tamlayout = 8365;

	@Adapter(transactionField = "NPCCWAXS-REGISTRO.NPCCWAXS-S-QT-TARIFA")
	private Integer sqttarifa = 0;

	@Adapter(transactionField = "NPCCWAXS-REGISTRO.NPCCWAXS-S-OCORRENCIA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog.Npccwaxsresponse_socorrencia")
	private List<Npccwaxsresponse_socorrencia> socorrencia = null;
	
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

	public Integer getSqttarifa() {
		return sqttarifa;
	}
	public void setSqttarifa(Integer sqttarifa) {
		this.sqttarifa = sqttarifa;
	}

	public List<Npccwaxsresponse_socorrencia> getSocorrencia() {
		return socorrencia;
	}
	public void setSocorrencia( List<Npccwaxsresponse_socorrencia> socorrencia) {
		this.socorrencia = socorrencia;
	}
    
}