package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 05/10/16 09:46
 */
public class Npccwwgerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWGE-HEADER.NPCCWWGE-COD-LAYOUT")
	private String codlayout = "NPCCWWGE";

	@Adapter(transactionField = "NPCCWWGE-HEADER.NPCCWWGE-TAM-LAYOUT")
	private Integer tamlayout = 7242;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-CFLUXO-LIQDC-PRINC")
	private Integer cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-QPCELA-TRADE-PRINC")
	private Integer qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-TDIA-CAREN-JURO")
	private Integer tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-CFLUXO-LIQDC-JURO")
	private Integer cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-QPCELA-TRADE-JURO")
	private Integer qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Npccwwgerequest_lstlis")
	private List<Npccwwgerequest_lstlis> lstlis = null;
	
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

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
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

	public List<Npccwwgerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwwgerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}
    
}