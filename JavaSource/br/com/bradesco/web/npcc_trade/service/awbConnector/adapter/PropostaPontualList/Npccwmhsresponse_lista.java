package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/03/16 18:33
 */
public class Npccwmhsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-NSEQ-CONTR-PPL")
	private Long lista_nseqcontrppl = 0L;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-DESCR-PRODT-LIMITE")
	private String lista_descrprodtlimite = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-DESCR-MOEDA")
	private String lista_descrmoeda = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-VPRINC-PPSTA-NEGOC")
	private String lista_vprincppstanegoc = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-PVCTO-LIM-GERC")
	private Integer lista_pvctolimgerc = 0;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-PSPREAD-NEGOC")
	private String lista_pspreadnegoc = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-CCATLG-GARNT")
	private Integer lista_ccatlggarnt = 0;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-DESCR-GARNT-PRINC")
	private String lista_descrgarntprinc = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-DT-SOLIC-PPL")
	private String lista_dtsolicppl = null;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-NSEQ-CONTR-NEGOC")
	private Long lista_nseqcontrnegoc = 0L;

	@Adapter(transactionField = "NPCCWMHS-REGISTRO.NPCCWMHS-LISTA.NPCCWMHS-DESCR-SEG")
	private String lista_descrseg = null;
	
	public Long getLista_nseqcontrppl() {
		return lista_nseqcontrppl;
	}
	public void setLista_nseqcontrppl(Long lista_nseqcontrppl) {
		this.lista_nseqcontrppl = lista_nseqcontrppl;
	}

	public Integer getLista_cprodtservc() {
		return lista_cprodtservc;
	}
	public void setLista_cprodtservc(Integer lista_cprodtservc) {
		this.lista_cprodtservc = lista_cprodtservc;
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

	public String getLista_vprincppstanegoc() {
		return lista_vprincppstanegoc;
	}
	public void setLista_vprincppstanegoc(String lista_vprincppstanegoc) {
		this.lista_vprincppstanegoc = lista_vprincppstanegoc;
	}

	public Integer getLista_pvctolimgerc() {
		return lista_pvctolimgerc;
	}
	public void setLista_pvctolimgerc(Integer lista_pvctolimgerc) {
		this.lista_pvctolimgerc = lista_pvctolimgerc;
	}

	public String getLista_pspreadnegoc() {
		return lista_pspreadnegoc;
	}
	public void setLista_pspreadnegoc(String lista_pspreadnegoc) {
		this.lista_pspreadnegoc = lista_pspreadnegoc;
	}

	public Integer getLista_ccatlggarnt() {
		return lista_ccatlggarnt;
	}
	public void setLista_ccatlggarnt(Integer lista_ccatlggarnt) {
		this.lista_ccatlggarnt = lista_ccatlggarnt;
	}

	public String getLista_descrgarntprinc() {
		return lista_descrgarntprinc;
	}
	public void setLista_descrgarntprinc(String lista_descrgarntprinc) {
		this.lista_descrgarntprinc = lista_descrgarntprinc;
	}

	public String getLista_dtsolicppl() {
		return lista_dtsolicppl;
	}
	public void setLista_dtsolicppl(String lista_dtsolicppl) {
		this.lista_dtsolicppl = lista_dtsolicppl;
	}

	public Long getLista_nseqcontrnegoc() {
		return lista_nseqcontrnegoc;
	}
	public void setLista_nseqcontrnegoc(Long lista_nseqcontrnegoc) {
		this.lista_nseqcontrnegoc = lista_nseqcontrnegoc;
	}

	public String getLista_descrseg() {
		return lista_descrseg;
	}
	public void setLista_descrseg(String lista_descrseg) {
		this.lista_descrseg = lista_descrseg;
	}
    
}