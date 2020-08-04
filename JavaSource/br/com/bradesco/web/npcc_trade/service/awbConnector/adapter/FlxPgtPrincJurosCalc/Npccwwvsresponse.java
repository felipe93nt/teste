package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 14/10/19 13:20
 */
public class Npccwwvsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWVS-HEADER.NPCCWWVS-COD-LAYOUT")
	private String codlayout = "NPCCWWVS";

	@Adapter(transactionField = "NPCCWWVS-HEADER.NPCCWWVS-TAM-LAYOUT")
	private Integer tamlayout = 7553;

	@Adapter(transactionField = "NPCCWWVS-REGISTRO.NPCCWWVS-QTDE-OCORR-PRINC")
	private Integer qtdeocorrprinc = 0;

	@Adapter(transactionField = "NPCCWWVS-REGISTRO.NPCCWWVS-QTDE-OCORR-JUROS")
	private Integer qtdeocorrjuros = 0;

	@Adapter(transactionField = "NPCCWWVS-REGISTRO.NPCCWWVS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWVS-REGISTRO.NPCCWWVS-PRZ-OPER-AJUSTADO")
	private String przoperajustado = null;

	@Adapter(transactionField = "NPCCWWVS-REGISTRO.NPCCWWVS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Npccwwvsresponse_lista")
	private List<Npccwwvsresponse_lista> lista = null;
	
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

	public Integer getQtdeocorrprinc() {
		return qtdeocorrprinc;
	}
	public void setQtdeocorrprinc(Integer qtdeocorrprinc) {
		this.qtdeocorrprinc = qtdeocorrprinc;
	}

	public Integer getQtdeocorrjuros() {
		return qtdeocorrjuros;
	}
	public void setQtdeocorrjuros(Integer qtdeocorrjuros) {
		this.qtdeocorrjuros = qtdeocorrjuros;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public String getPrzoperajustado() {
		return przoperajustado;
	}
	public void setPrzoperajustado(String przoperajustado) {
		this.przoperajustado = przoperajustado;
	}

	public List<Npccwwvsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwvsresponse_lista> lista) {
		this.lista = lista;
	}
    
}