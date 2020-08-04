package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/12/15 12:13
 */
public class Npccwwnsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CMCADO-OPER-CMBIO")
	private Integer lista_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-RMCADO-OPER-CMBIO")
	private String lista_rmcadoopercmbio = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CMCADO-CMBIO-MCSUL")
	private Long lista_cmcadocmbiomcsul = 0L;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-RINGLS-MCADO-CMBIO")
	private String lista_ringlsmcadocmbio = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CINDCD-LICEN-MCADO")
	private String lista_cindcdlicenmcado = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CMCADO-REST-CMBIO")
	private String lista_cmcadorestcmbio = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-NTPO-SIT-CMBIO")
	private Integer lista_ntpositcmbio = 0;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-RJUSTF-SIT-CMBIO")
	private String lista_rjustfsitcmbio = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CUSUAR-INCL")
	private String lista_cusuarincl = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-HINCL-REG")
	private String lista_hinclreg = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-CUSUAR-MANUT")
	private String lista_cusuarmanut = null;

	@Adapter(transactionField = "NPCCWWNS-REGISTRO.NPCCWWNS-LISTA.NPCCWWNS-HMANUT-REG")
	private String lista_hmanutreg = null;
	
	public Integer getLista_cmcadoopercmbio() {
		return lista_cmcadoopercmbio;
	}
	public void setLista_cmcadoopercmbio(Integer lista_cmcadoopercmbio) {
		this.lista_cmcadoopercmbio = lista_cmcadoopercmbio;
	}

	public String getLista_rmcadoopercmbio() {
		return lista_rmcadoopercmbio;
	}
	public void setLista_rmcadoopercmbio(String lista_rmcadoopercmbio) {
		this.lista_rmcadoopercmbio = lista_rmcadoopercmbio;
	}

	public Long getLista_cmcadocmbiomcsul() {
		return lista_cmcadocmbiomcsul;
	}
	public void setLista_cmcadocmbiomcsul(Long lista_cmcadocmbiomcsul) {
		this.lista_cmcadocmbiomcsul = lista_cmcadocmbiomcsul;
	}

	public String getLista_ringlsmcadocmbio() {
		return lista_ringlsmcadocmbio;
	}
	public void setLista_ringlsmcadocmbio(String lista_ringlsmcadocmbio) {
		this.lista_ringlsmcadocmbio = lista_ringlsmcadocmbio;
	}

	public String getLista_cindcdlicenmcado() {
		return lista_cindcdlicenmcado;
	}
	public void setLista_cindcdlicenmcado(String lista_cindcdlicenmcado) {
		this.lista_cindcdlicenmcado = lista_cindcdlicenmcado;
	}

	public String getLista_cmcadorestcmbio() {
		return lista_cmcadorestcmbio;
	}
	public void setLista_cmcadorestcmbio(String lista_cmcadorestcmbio) {
		this.lista_cmcadorestcmbio = lista_cmcadorestcmbio;
	}

	public Integer getLista_ntpositcmbio() {
		return lista_ntpositcmbio;
	}
	public void setLista_ntpositcmbio(Integer lista_ntpositcmbio) {
		this.lista_ntpositcmbio = lista_ntpositcmbio;
	}

	public String getLista_rjustfsitcmbio() {
		return lista_rjustfsitcmbio;
	}
	public void setLista_rjustfsitcmbio(String lista_rjustfsitcmbio) {
		this.lista_rjustfsitcmbio = lista_rjustfsitcmbio;
	}

	public String getLista_cusuarincl() {
		return lista_cusuarincl;
	}
	public void setLista_cusuarincl(String lista_cusuarincl) {
		this.lista_cusuarincl = lista_cusuarincl;
	}

	public String getLista_hinclreg() {
		return lista_hinclreg;
	}
	public void setLista_hinclreg(String lista_hinclreg) {
		this.lista_hinclreg = lista_hinclreg;
	}

	public String getLista_cusuarmanut() {
		return lista_cusuarmanut;
	}
	public void setLista_cusuarmanut(String lista_cusuarmanut) {
		this.lista_cusuarmanut = lista_cusuarmanut;
	}

	public String getLista_hmanutreg() {
		return lista_hmanutreg;
	}
	public void setLista_hmanutreg(String lista_hmanutreg) {
		this.lista_hmanutreg = lista_hmanutreg;
	}
    
}