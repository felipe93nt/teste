package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 17/05/16 09:25
 */
public class Npccwwxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWXE-HEADER.NPCCWWXE-COD-LAYOUT")
	private String codlayout = "NPCCWWXE";

	@Adapter(transactionField = "NPCCWWXE-HEADER.NPCCWWXE-TAM-LAYOUT")
	private Integer tamlayout = 7449;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-DVCTO-DSEMB-CMBIO")
	private String dvctodsembcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VJURO-DSEMB-CMBIO")
	private String vjurodsembcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VDSEMB-NEGOC-CMBIO")
	private String vdsembnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VTX-VAR-OPER")
	private String vtxvaroper = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VTX-CMBIO-VARVL")
	private String vtxcmbiovarvl = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-PTX-JURO-FNDNG")
	private String ptxjurofndng = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-PSPREAD-TX-CMBIO")
	private String pspreadtxcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-CPERM-VAR-PATRM")
	private String cpermvarpatrm = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-CINDCD-CMBIO-VARVL")
	private String cindcdcmbiovarvl = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-IORG-EXTER-FINAN")
	private String iorgexterfinan = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-CFLUXO-LIQDC-PRINC")
	private Integer cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-QPCELA-TRADE-PRINC")
	private Integer qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-TDIA-CAREN-JURO")
	private Integer tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-CFLUXO-LIQDC-JURO")
	private Integer cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-QPCELA-TRADE-JURO")
	private Integer qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Npccwwxerequest_lstlis")
	private List<Npccwwxerequest_lstlis> lstlis = null;
	
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

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
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

	public List<Npccwwxerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwwxerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}
    
}