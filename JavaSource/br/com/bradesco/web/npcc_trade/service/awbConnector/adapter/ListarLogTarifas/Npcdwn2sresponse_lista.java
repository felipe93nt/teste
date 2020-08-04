package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarLogTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 10:48
 */
public class Npcdwn2sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-RPRODT-SERVC")
	private String lista_rprodtservc = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-COPER")
	private Integer lista_coper = 0;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-ROPER")
	private String lista_roper = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-CCONDC-ECONC")
	private Integer lista_ccondceconc = 0;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-ICONDC-ECONC")
	private String lista_icondceconc = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-IND-AUT")
	private String lista_indaut = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-CUSUAR-MANUT")
	private String lista_cusuarmanut = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-IUSUAR-MANUT")
	private String lista_iusuarmanut = null;

	@Adapter(transactionField = "NPCDWN2S-REGISTRO.NPCDWN2S-LISTA.NPCDWN2S-HMANUT-REG")
	private String lista_hmanutreg = null;

	public Integer getLista_cprodtservc() {
		return lista_cprodtservc;
	}

	public void setLista_cprodtservc(Integer lista_cprodtservc) {
		this.lista_cprodtservc = lista_cprodtservc;
	}

	public String getLista_rprodtservc() {
		return lista_rprodtservc;
	}

	public void setLista_rprodtservc(String lista_rprodtservc) {
		this.lista_rprodtservc = lista_rprodtservc;
	}

	public Integer getLista_coper() {
		return lista_coper;
	}

	public void setLista_coper(Integer lista_coper) {
		this.lista_coper = lista_coper;
	}

	public String getLista_roper() {
		return lista_roper;
	}

	public void setLista_roper(String lista_roper) {
		this.lista_roper = lista_roper;
	}

	public Integer getLista_ccondceconc() {
		return lista_ccondceconc;
	}

	public void setLista_ccondceconc(Integer lista_ccondceconc) {
		this.lista_ccondceconc = lista_ccondceconc;
	}

	public String getLista_icondceconc() {
		return lista_icondceconc;
	}

	public void setLista_icondceconc(String lista_icondceconc) {
		this.lista_icondceconc = lista_icondceconc;
	}

	public String getLista_indaut() {
		return lista_indaut;
	}

	public void setLista_indaut(String lista_indaut) {
		this.lista_indaut = lista_indaut;
	}

	public String getLista_cusuarmanut() {
		return lista_cusuarmanut;
	}

	public void setLista_cusuarmanut(String lista_cusuarmanut) {
		this.lista_cusuarmanut = lista_cusuarmanut;
	}

	public String getLista_iusuarmanut() {
		return lista_iusuarmanut;
	}

	public void setLista_iusuarmanut(String lista_iusuarmanut) {
		this.lista_iusuarmanut = lista_iusuarmanut;
	}

	public String getLista_hmanutreg() {
		return lista_hmanutreg;
	}

	public void setLista_hmanutreg(String lista_hmanutreg) {
		this.lista_hmanutreg = lista_hmanutreg;
	}

}