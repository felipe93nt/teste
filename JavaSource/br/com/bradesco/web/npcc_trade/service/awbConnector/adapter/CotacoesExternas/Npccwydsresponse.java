package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 31/10/17 12:30
 */
public class Npccwydsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYDS-HEADER.NPCCWYDS-COD-LAYOUT")
	private String codlayout = "NPCCWYDS";

	@Adapter(transactionField = "NPCCWYDS-HEADER.NPCCWYDS-TAM-LAYOUT")
	private Integer tamlayout = 10105;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-CUSUARIO-SESS")
	private String cusuariosess = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-NUSUARIO-SESS")
	private String nusuariosess = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Npccwydsresponse_listacontac")
	private List<Npccwydsresponse_listacontac> listacontac = null;
	
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

	public String getCusuariosess() {
		return cusuariosess;
	}
	public void setCusuariosess(String cusuariosess) {
		this.cusuariosess = cusuariosess;
	}

	public String getNusuariosess() {
		return nusuariosess;
	}
	public void setNusuariosess(String nusuariosess) {
		this.nusuariosess = nusuariosess;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwydsresponse_listacontac> getListacontac() {
		return listacontac;
	}
	public void setListacontac( List<Npccwydsresponse_listacontac> listacontac) {
		this.listacontac = listacontac;
	}
    
}