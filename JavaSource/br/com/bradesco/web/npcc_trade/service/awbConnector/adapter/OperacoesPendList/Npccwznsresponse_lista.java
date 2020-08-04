package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/04/17 15:21
 */
public class Npccwznsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-DPREVT-DSEMB-CMBIO")
	private String lista_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-TDIA-FINAN-DSEMB")
	private Integer lista_tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-VPREVT-DSEMB-CMBIO")
	private Double lista_vprevtdsembcmbio = 0D;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-DFCHTO-BLETO-CMBIO")
	private String lista_dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-NOME-PRODT-SERVC")
	private String lista_nomeprodtservc = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-IMP-EXP-DEVEDOR")
	private String lista_impexpdevedor = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-NOME-UND-ORGNZ")
	private String lista_nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-VTX-LIBOR-CMBIO")
	private Double lista_vtxliborcmbio = 0D;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-IORG-EXTER-CMBIO")
	private String lista_iorgextercmbio = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-CUSTO-EXTERN-AA")
	private String lista_custoexternaa = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-SPREAD-NEGOC-AA")
	private String lista_spreadnegocaa = null;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-NUMERO-OP")
	private Integer lista_numeroop = 0;

	@Adapter(transactionField = "NPCCWZNS-REGISTRO.NPCCWZNS-LISTA.NPCCWZNS-DESC-SITUACAO")
	private String lista_descsituacao = null;
	
	public String getLista_dprevtdsembcmbio() {
		return lista_dprevtdsembcmbio;
	}
	public void setLista_dprevtdsembcmbio(String lista_dprevtdsembcmbio) {
		this.lista_dprevtdsembcmbio = lista_dprevtdsembcmbio;
	}

	public Integer getLista_tdiafinandsemb() {
		return lista_tdiafinandsemb;
	}
	public void setLista_tdiafinandsemb(Integer lista_tdiafinandsemb) {
		this.lista_tdiafinandsemb = lista_tdiafinandsemb;
	}

	public String getLista_dvctopcelatrade() {
		return lista_dvctopcelatrade;
	}
	public void setLista_dvctopcelatrade(String lista_dvctopcelatrade) {
		this.lista_dvctopcelatrade = lista_dvctopcelatrade;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}

	public Double getLista_vprevtdsembcmbio() {
		return lista_vprevtdsembcmbio;
	}
	public void setLista_vprevtdsembcmbio(Double lista_vprevtdsembcmbio) {
		this.lista_vprevtdsembcmbio = lista_vprevtdsembcmbio;
	}

	public String getLista_dfchtobletocmbio() {
		return lista_dfchtobletocmbio;
	}
	public void setLista_dfchtobletocmbio(String lista_dfchtobletocmbio) {
		this.lista_dfchtobletocmbio = lista_dfchtobletocmbio;
	}

	public String getLista_nomeprodtservc() {
		return lista_nomeprodtservc;
	}
	public void setLista_nomeprodtservc(String lista_nomeprodtservc) {
		this.lista_nomeprodtservc = lista_nomeprodtservc;
	}

	public String getLista_impexpdevedor() {
		return lista_impexpdevedor;
	}
	public void setLista_impexpdevedor(String lista_impexpdevedor) {
		this.lista_impexpdevedor = lista_impexpdevedor;
	}

	public String getLista_nomeundorgnz() {
		return lista_nomeundorgnz;
	}
	public void setLista_nomeundorgnz(String lista_nomeundorgnz) {
		this.lista_nomeundorgnz = lista_nomeundorgnz;
	}

	public Double getLista_vtxliborcmbio() {
		return lista_vtxliborcmbio;
	}
	public void setLista_vtxliborcmbio(Double lista_vtxliborcmbio) {
		this.lista_vtxliborcmbio = lista_vtxliborcmbio;
	}

	public String getLista_iorgextercmbio() {
		return lista_iorgextercmbio;
	}
	public void setLista_iorgextercmbio(String lista_iorgextercmbio) {
		this.lista_iorgextercmbio = lista_iorgextercmbio;
	}

	public String getLista_custoexternaa() {
		return lista_custoexternaa;
	}
	public void setLista_custoexternaa(String lista_custoexternaa) {
		this.lista_custoexternaa = lista_custoexternaa;
	}

	public String getLista_spreadnegocaa() {
		return lista_spreadnegocaa;
	}
	public void setLista_spreadnegocaa(String lista_spreadnegocaa) {
		this.lista_spreadnegocaa = lista_spreadnegocaa;
	}

	public Integer getLista_numeroop() {
		return lista_numeroop;
	}
	public void setLista_numeroop(Integer lista_numeroop) {
		this.lista_numeroop = lista_numeroop;
	}

	public String getLista_descsituacao() {
		return lista_descsituacao;
	}
	public void setLista_descsituacao(String lista_descsituacao) {
		this.lista_descsituacao = lista_descsituacao;
	}
    
}