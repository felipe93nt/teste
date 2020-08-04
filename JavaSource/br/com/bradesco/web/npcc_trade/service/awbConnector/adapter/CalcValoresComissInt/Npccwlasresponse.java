package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Npccwlasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWLAS-HEADER.NPCCWLAS-COD-LAYOUT")
	private String codlayout = "NPCCWLAS";

	@Adapter(transactionField = "NPCCWLAS-HEADER.NPCCWLAS-TAM-LAYOUT")
	private Integer tamlayout = 7364;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-CINDCD-PCOBR-JUROS")
	private Integer cindcdpcobrjuros = 0;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-CINDCD-FCOBR-COTAC")
	private Integer cindcdfcobrcotac = 0;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-VPREVT-COMIS-CMBIO")
	private Double vprevtcomiscmbio = 0D;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlasresponse_lista")
	private List<Npccwlasresponse_lista> lista = null;
	
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

	public Integer getCindcdpcobrjuros() {
		return cindcdpcobrjuros;
	}
	public void setCindcdpcobrjuros(Integer cindcdpcobrjuros) {
		this.cindcdpcobrjuros = cindcdpcobrjuros;
	}

	public Integer getCindcdfcobrcotac() {
		return cindcdfcobrcotac;
	}
	public void setCindcdfcobrcotac(Integer cindcdfcobrcotac) {
		this.cindcdfcobrcotac = cindcdfcobrcotac;
	}

	public Double getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}
	public void setVprevtcomiscmbio(Double vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwlasresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwlasresponse_lista> lista) {
		this.lista = lista;
	}
    
}