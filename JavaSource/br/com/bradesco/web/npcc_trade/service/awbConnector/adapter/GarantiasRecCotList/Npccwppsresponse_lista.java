package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/17 18:19
 */
public class Npccwppsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-NCONTR-LIM")
	private Long lista_ncontrlim = 0L;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-CPSSOA-JURID")
	private Long lista_cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-CPSSOA-JURID-DESC")
	private String lista_cpssoajuriddesc = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-CPRODT-SERVC-OPER")
	private Integer lista_cprodtservcoper = 0;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-DESCR-PRODT-LIMITE")
	private String lista_descrprodtlimite = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-DESCR-MOEDA")
	private String lista_descrmoeda = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-VUTLZD-LIM-GERC")
	private String lista_vutlzdlimgerc = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-VDISPN-LIM-GERC")
	private String lista_vdispnlimgerc = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-DVCTO-LIM-GERC")
	private String lista_dvctolimgerc = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-PVCTO-LIM-GERC")
	private Integer lista_pvctolimgerc = 0;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-PSPREAD-PRODT")
	private String lista_pspreadprodt = null;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-CCATLG-GARNT-PRINC")
	private Integer lista_ccatlggarntprinc = 0;

	@Adapter(transactionField = "NPCCWPPS-REGISTRO.NPCCWPPS-LISTA.NPCCWPPS-DESCR-GARNT-PRINC")
	private String lista_descrgarntprinc = null;
	
	public Long getLista_ncontrlim() {
		return lista_ncontrlim;
	}
	public void setLista_ncontrlim(Long lista_ncontrlim) {
		this.lista_ncontrlim = lista_ncontrlim;
	}

	public Long getLista_cpssoajurid() {
		return lista_cpssoajurid;
	}
	public void setLista_cpssoajurid(Long lista_cpssoajurid) {
		this.lista_cpssoajurid = lista_cpssoajurid;
	}

	public String getLista_cpssoajuriddesc() {
		return lista_cpssoajuriddesc;
	}
	public void setLista_cpssoajuriddesc(String lista_cpssoajuriddesc) {
		this.lista_cpssoajuriddesc = lista_cpssoajuriddesc;
	}

	public Integer getLista_cprodtservcoper() {
		return lista_cprodtservcoper;
	}
	public void setLista_cprodtservcoper(Integer lista_cprodtservcoper) {
		this.lista_cprodtservcoper = lista_cprodtservcoper;
	}

	public String getLista_descrprodtlimite() {
		return lista_descrprodtlimite;
	}
	public void setLista_descrprodtlimite(String lista_descrprodtlimite) {
		this.lista_descrprodtlimite = lista_descrprodtlimite;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_descrmoeda() {
		return lista_descrmoeda;
	}
	public void setLista_descrmoeda(String lista_descrmoeda) {
		this.lista_descrmoeda = lista_descrmoeda;
	}

	public String getLista_vutlzdlimgerc() {
		return lista_vutlzdlimgerc;
	}
	public void setLista_vutlzdlimgerc(String lista_vutlzdlimgerc) {
		this.lista_vutlzdlimgerc = lista_vutlzdlimgerc;
	}

	public String getLista_vdispnlimgerc() {
		return lista_vdispnlimgerc;
	}
	public void setLista_vdispnlimgerc(String lista_vdispnlimgerc) {
		this.lista_vdispnlimgerc = lista_vdispnlimgerc;
	}

	public String getLista_dvctolimgerc() {
		return lista_dvctolimgerc;
	}
	public void setLista_dvctolimgerc(String lista_dvctolimgerc) {
		this.lista_dvctolimgerc = lista_dvctolimgerc;
	}

	public Integer getLista_pvctolimgerc() {
		return lista_pvctolimgerc;
	}
	public void setLista_pvctolimgerc(Integer lista_pvctolimgerc) {
		this.lista_pvctolimgerc = lista_pvctolimgerc;
	}

	public String getLista_pspreadprodt() {
		return lista_pspreadprodt;
	}
	public void setLista_pspreadprodt(String lista_pspreadprodt) {
		this.lista_pspreadprodt = lista_pspreadprodt;
	}

	public Integer getLista_ccatlggarntprinc() {
		return lista_ccatlggarntprinc;
	}
	public void setLista_ccatlggarntprinc(Integer lista_ccatlggarntprinc) {
		this.lista_ccatlggarntprinc = lista_ccatlggarntprinc;
	}

	public String getLista_descrgarntprinc() {
		return lista_descrgarntprinc;
	}
	public void setLista_descrgarntprinc(String lista_descrgarntprinc) {
		this.lista_descrgarntprinc = lista_descrgarntprinc;
	}
    
}