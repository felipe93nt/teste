package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 20/08/18 16:26
 */
public class Npccwatsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWATS-HEADER.NPCCWATS-COD-LAYOUT")
	private String codlayout = "NPCCWATS";

	@Adapter(transactionField = "NPCCWATS-HEADER.NPCCWATS-TAM-LAYOUT")
	private Integer tamlayout = 4215;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-QT-TARIFA")
	private Integer sqttarifa = 0;

	@Adapter(transactionField = "NPCCWATS-REGISTRO.NPCCWATS-S-OCORRENCIA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList.Npccwatsresponse_socorrencia")
	private List<Npccwatsresponse_socorrencia> socorrencia = null;
	
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

	public List<Npccwatsresponse_socorrencia> getSocorrencia() {
		return socorrencia;
	}
	public void setSocorrencia( List<Npccwatsresponse_socorrencia> socorrencia) {
		this.socorrencia = socorrencia;
	}
    
}