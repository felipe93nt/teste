package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:06
 */
public class Npccwwmsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWMS-HEADER.NPCCWWMS-COD-LAYOUT")
	private String codlayout = "NPCCWWMS";

	@Adapter(transactionField = "NPCCWWMS-HEADER.NPCCWWMS-TAM-LAYOUT")
	private Integer tamlayout = 12509;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-VPREVT-COMIS-CMBIO")
	private Double vprevtcomiscmbio = 0D;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Npccwwmsresponse_lista")
	private List<Npccwwmsresponse_lista> lista = null;
	
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

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public Double getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}
	public void setVprevtcomiscmbio(Double vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}

	public List<Npccwwmsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwmsresponse_lista> lista) {
		this.lista = lista;
	}
    
}