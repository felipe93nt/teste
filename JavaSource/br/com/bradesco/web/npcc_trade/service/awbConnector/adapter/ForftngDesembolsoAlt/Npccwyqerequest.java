package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/09/16 17:33
 */
public class Npccwyqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYQE-HEADER.NPCCWYQE-COD-LAYOUT")
	private String codlayout = "NPCCWYQE";

	@Adapter(transactionField = "NPCCWYQE-HEADER.NPCCWYQE-TAM-LAYOUT")
	private Integer tamlayout = 8137;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-DVCTO-DSEMB-CMBIO")
	private String dvctodsembcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VJURO-DSEMB-CMBIO")
	private String vjurodsembcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VDSEMB-NEGOC-CMBIO")
	private String vdsembnegoccmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VTX-VAR-OPER")
	private String vtxvaroper = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VTX-CMBIO-VARVL")
	private String vtxcmbiovarvl = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-PTX-JURO-FNDNG")
	private String ptxjurofndng = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-PSPREAD-TX-CMBIO")
	private String pspreadtxcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-CPERM-VAR-PATRM")
	private String cpermvarpatrm = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-CINDCD-CMBIO-VARVL")
	private String cindcdcmbiovarvl = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-IORG-EXTER-FINAN")
	private String iorgexterfinan = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-CFLUXO-LIQDC-PRINC")
	private Integer cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-QPCELA-TRADE-PRINC")
	private Integer qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-TDIA-CAREN-JURO")
	private Integer tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-CFLUXO-LIQDC-JURO")
	private Integer cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-QPCELA-TRADE-JURO")
	private Integer qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-QTD-OC-MERC")
	private Integer qtdocmerc = 0;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqerequest_lstlis")
	private List<Npccwyqerequest_lstlis> lstlis = null;

	@Adapter(transactionField = "NPCCWYQE-REGISTRO.NPCCWYQE-LST-MER", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqerequest_lstmer")
	private List<Npccwyqerequest_lstmer> lstmer = null;
	
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public String getDprevtembrq() {
		return dprevtembrq;
	}
	public void setDprevtembrq(String dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	public String getDvctodsembcmbio() {
		return dvctodsembcmbio;
	}
	public void setDvctodsembcmbio(String dvctodsembcmbio) {
		this.dvctodsembcmbio = dvctodsembcmbio;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getVjurodsembcmbio() {
		return vjurodsembcmbio;
	}
	public void setVjurodsembcmbio(String vjurodsembcmbio) {
		this.vjurodsembcmbio = vjurodsembcmbio;
	}

	public String getVdsembnegoccmbio() {
		return vdsembnegoccmbio;
	}
	public void setVdsembnegoccmbio(String vdsembnegoccmbio) {
		this.vdsembnegoccmbio = vdsembnegoccmbio;
	}

	public String getVtxvaroper() {
		return vtxvaroper;
	}
	public void setVtxvaroper(String vtxvaroper) {
		this.vtxvaroper = vtxvaroper;
	}

	public String getVtxcmbiovarvl() {
		return vtxcmbiovarvl;
	}
	public void setVtxcmbiovarvl(String vtxcmbiovarvl) {
		this.vtxcmbiovarvl = vtxcmbiovarvl;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public String getPtxjurofndng() {
		return ptxjurofndng;
	}
	public void setPtxjurofndng(String ptxjurofndng) {
		this.ptxjurofndng = ptxjurofndng;
	}

	public String getPspreadtxcmbio() {
		return pspreadtxcmbio;
	}
	public void setPspreadtxcmbio(String pspreadtxcmbio) {
		this.pspreadtxcmbio = pspreadtxcmbio;
	}

	public String getCpermvarpatrm() {
		return cpermvarpatrm;
	}
	public void setCpermvarpatrm(String cpermvarpatrm) {
		this.cpermvarpatrm = cpermvarpatrm;
	}

	public String getCindcdcmbiovarvl() {
		return cindcdcmbiovarvl;
	}
	public void setCindcdcmbiovarvl(String cindcdcmbiovarvl) {
		this.cindcdcmbiovarvl = cindcdcmbiovarvl;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public String getIorgexterfinan() {
		return iorgexterfinan;
	}
	public void setIorgexterfinan(String iorgexterfinan) {
		this.iorgexterfinan = iorgexterfinan;
	}

	public Integer getTdiacarenprinc() {
		return tdiacarenprinc;
	}
	public void setTdiacarenprinc(Integer tdiacarenprinc) {
		this.tdiacarenprinc = tdiacarenprinc;
	}

	public Integer getCfluxoliqdcprinc() {
		return cfluxoliqdcprinc;
	}
	public void setCfluxoliqdcprinc(Integer cfluxoliqdcprinc) {
		this.cfluxoliqdcprinc = cfluxoliqdcprinc;
	}

	public Integer getQpcelatradeprinc() {
		return qpcelatradeprinc;
	}
	public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
		this.qpcelatradeprinc = qpcelatradeprinc;
	}

	public Integer getTdiacarenjuro() {
		return tdiacarenjuro;
	}
	public void setTdiacarenjuro(Integer tdiacarenjuro) {
		this.tdiacarenjuro = tdiacarenjuro;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public Integer getCfluxoliqdcjuro() {
		return cfluxoliqdcjuro;
	}
	public void setCfluxoliqdcjuro(Integer cfluxoliqdcjuro) {
		this.cfluxoliqdcjuro = cfluxoliqdcjuro;
	}

	public Integer getQpcelatradejuro() {
		return qpcelatradejuro;
	}
	public void setQpcelatradejuro(Integer qpcelatradejuro) {
		this.qpcelatradejuro = qpcelatradejuro;
	}

	public Integer getCmomencobrcmbio() {
		return cmomencobrcmbio;
	}
	public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}

	public Integer getQtdoclist() {
		return qtdoclist;
	}
	public void setQtdoclist(Integer qtdoclist) {
		this.qtdoclist = qtdoclist;
	}

	public Integer getQtdocmerc() {
		return qtdocmerc;
	}
	public void setQtdocmerc(Integer qtdocmerc) {
		this.qtdocmerc = qtdocmerc;
	}

	public List<Npccwyqerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwyqerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}

	public List<Npccwyqerequest_lstmer> getLstmer() {
		return lstmer;
	}
	public void setLstmer( List<Npccwyqerequest_lstmer> lstmer) {
		this.lstmer = lstmer;
	}
    
}