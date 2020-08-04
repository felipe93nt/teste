package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 08/11/16 15:05
 */
public class Npccwv6erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV6E-HEADER.NPCCWV6E-COD-LAYOUT")
	private String codlayout = "NPCCWV6E";

	@Adapter(transactionField = "NPCCWV6E-HEADER.NPCCWV6E-TAM-LAYOUT")
	private Integer tamlayout = 3654;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-CUSUARIO-SESS")
	private String cusuariosess = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-FLAG-PROC")
	private String flagproc = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CFNDNG")
	private Long dadosfdg_cfndng = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-DCOTAC-FNDNG-CMBIO")
	private String dadosfdg_dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CBANQR-CMBIO-FNDNG")
	private Long dadosfdg_cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CBANQR-CMBIO-RCDOR")
	private Long dadosfdg_cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CBANQR-CMBIO-AVISO")
	private Long dadosfdg_cbanqrcmbioaviso = 0L;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-DLIM-FNDNG-CMBIO")
	private String dadosfdg_dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-PTX-FIXA-CMBIO")
	private String dadosfdg_ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CINDCD-ECONM-MOE-LIB")
	private Integer dadosfdg_cindcdeconmmoelib = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-TDIA-OPER-CMBIO")
	private Integer dadosfdg_tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-TMES-LIBOR-CMBIO")
	private Integer dadosfdg_tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-VTX-LIBOR-CMBIO")
	private String dadosfdg_vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-DADOS-FDG.NPCCWV6E-CINDCD-FNDNG-UTL")
	private String dadosfdg_cindcdfndngutl = null;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-QTDE-DSP")
	private Integer qtdedsp = 0;

	@Adapter(transactionField = "NPCCWV6E-REGISTRO.NPCCWV6E-LISTA-DSP", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Npccwv6erequest_listadsp")
	private List<Npccwv6erequest_listadsp> listadsp = null;
	
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

	public String getCusuariosess() {
		return cusuariosess;
	}
	public void setCusuariosess(String cusuariosess) {
		this.cusuariosess = cusuariosess;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public String getFlagproc() {
		return flagproc;
	}
	public void setFlagproc(String flagproc) {
		this.flagproc = flagproc;
	}

	public Long getDadosfdg_cfndng() {
		return dadosfdg_cfndng;
	}
	public void setDadosfdg_cfndng(Long dadosfdg_cfndng) {
		this.dadosfdg_cfndng = dadosfdg_cfndng;
	}

	public String getDadosfdg_dcotacfndngcmbio() {
		return dadosfdg_dcotacfndngcmbio;
	}
	public void setDadosfdg_dcotacfndngcmbio(String dadosfdg_dcotacfndngcmbio) {
		this.dadosfdg_dcotacfndngcmbio = dadosfdg_dcotacfndngcmbio;
	}

	public Long getDadosfdg_cbanqrcmbiofndng() {
		return dadosfdg_cbanqrcmbiofndng;
	}
	public void setDadosfdg_cbanqrcmbiofndng(Long dadosfdg_cbanqrcmbiofndng) {
		this.dadosfdg_cbanqrcmbiofndng = dadosfdg_cbanqrcmbiofndng;
	}

	public Long getDadosfdg_cbanqrcmbiorcdor() {
		return dadosfdg_cbanqrcmbiorcdor;
	}
	public void setDadosfdg_cbanqrcmbiorcdor(Long dadosfdg_cbanqrcmbiorcdor) {
		this.dadosfdg_cbanqrcmbiorcdor = dadosfdg_cbanqrcmbiorcdor;
	}

	public Long getDadosfdg_cbanqrcmbioaviso() {
		return dadosfdg_cbanqrcmbioaviso;
	}
	public void setDadosfdg_cbanqrcmbioaviso(Long dadosfdg_cbanqrcmbioaviso) {
		this.dadosfdg_cbanqrcmbioaviso = dadosfdg_cbanqrcmbioaviso;
	}

	public String getDadosfdg_dlimfndngcmbio() {
		return dadosfdg_dlimfndngcmbio;
	}
	public void setDadosfdg_dlimfndngcmbio(String dadosfdg_dlimfndngcmbio) {
		this.dadosfdg_dlimfndngcmbio = dadosfdg_dlimfndngcmbio;
	}

	public String getDadosfdg_ptxfixacmbio() {
		return dadosfdg_ptxfixacmbio;
	}
	public void setDadosfdg_ptxfixacmbio(String dadosfdg_ptxfixacmbio) {
		this.dadosfdg_ptxfixacmbio = dadosfdg_ptxfixacmbio;
	}

	public Integer getDadosfdg_cindcdeconmmoelib() {
		return dadosfdg_cindcdeconmmoelib;
	}
	public void setDadosfdg_cindcdeconmmoelib(Integer dadosfdg_cindcdeconmmoelib) {
		this.dadosfdg_cindcdeconmmoelib = dadosfdg_cindcdeconmmoelib;
	}

	public Integer getDadosfdg_tdiaopercmbio() {
		return dadosfdg_tdiaopercmbio;
	}
	public void setDadosfdg_tdiaopercmbio(Integer dadosfdg_tdiaopercmbio) {
		this.dadosfdg_tdiaopercmbio = dadosfdg_tdiaopercmbio;
	}

	public Integer getDadosfdg_tmesliborcmbio() {
		return dadosfdg_tmesliborcmbio;
	}
	public void setDadosfdg_tmesliborcmbio(Integer dadosfdg_tmesliborcmbio) {
		this.dadosfdg_tmesliborcmbio = dadosfdg_tmesliborcmbio;
	}

	public String getDadosfdg_vtxliborcmbio() {
		return dadosfdg_vtxliborcmbio;
	}
	public void setDadosfdg_vtxliborcmbio(String dadosfdg_vtxliborcmbio) {
		this.dadosfdg_vtxliborcmbio = dadosfdg_vtxliborcmbio;
	}

	public String getDadosfdg_cindcdfndngutl() {
		return dadosfdg_cindcdfndngutl;
	}
	public void setDadosfdg_cindcdfndngutl(String dadosfdg_cindcdfndngutl) {
		this.dadosfdg_cindcdfndngutl = dadosfdg_cindcdfndngutl;
	}

	public Integer getQtdedsp() {
		return qtdedsp;
	}
	public void setQtdedsp(Integer qtdedsp) {
		this.qtdedsp = qtdedsp;
	}

	public List<Npccwv6erequest_listadsp> getListadsp() {
		return listadsp;
	}
	public void setListadsp( List<Npccwv6erequest_listadsp> listadsp) {
		this.listadsp = listadsp;
	}
    
}