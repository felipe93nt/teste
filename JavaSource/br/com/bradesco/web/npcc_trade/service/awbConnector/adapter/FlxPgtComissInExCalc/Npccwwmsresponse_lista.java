package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:06
 */
public class Npccwwmsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-NPCELA-COMIS")
	private Integer lista_npcelacomis = 0;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-VCUSTO-FINCR-CMBIO")
	private String lista_vcustofincrcmbio = null;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-VPCELA-COMIS-CMBIO")
	private String lista_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-TDIA-NEGOC-PCELA")
	private Integer lista_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-PJURO-NEGOC-CMBIO")
	private String lista_pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWWMS-REGISTRO.NPCCWWMS-LISTA.NPCCWWMS-CPERDC-JURO-CMBIO")
	private Integer lista_cperdcjurocmbio = 0;
	
	public Integer getLista_npcelacomis() {
		return lista_npcelacomis;
	}
	public void setLista_npcelacomis(Integer lista_npcelacomis) {
		this.lista_npcelacomis = lista_npcelacomis;
	}

	public String getLista_dvctopcelatrade() {
		return lista_dvctopcelatrade;
	}
	public void setLista_dvctopcelatrade(String lista_dvctopcelatrade) {
		this.lista_dvctopcelatrade = lista_dvctopcelatrade;
	}

	public String getLista_vcustofincrcmbio() {
		return lista_vcustofincrcmbio;
	}
	public void setLista_vcustofincrcmbio(String lista_vcustofincrcmbio) {
		this.lista_vcustofincrcmbio = lista_vcustofincrcmbio;
	}

	public String getLista_vpcelacomiscmbio() {
		return lista_vpcelacomiscmbio;
	}
	public void setLista_vpcelacomiscmbio(String lista_vpcelacomiscmbio) {
		this.lista_vpcelacomiscmbio = lista_vpcelacomiscmbio;
	}

	public Integer getLista_tdianegocpcela() {
		return lista_tdianegocpcela;
	}
	public void setLista_tdianegocpcela(Integer lista_tdianegocpcela) {
		this.lista_tdianegocpcela = lista_tdianegocpcela;
	}

	public String getLista_pjuronegoccmbio() {
		return lista_pjuronegoccmbio;
	}
	public void setLista_pjuronegoccmbio(String lista_pjuronegoccmbio) {
		this.lista_pjuronegoccmbio = lista_pjuronegoccmbio;
	}

	public Integer getLista_cperdcjurocmbio() {
		return lista_cperdcjurocmbio;
	}
	public void setLista_cperdcjurocmbio(Integer lista_cperdcjurocmbio) {
		this.lista_cperdcjurocmbio = lista_cperdcjurocmbio;
	}
    
}