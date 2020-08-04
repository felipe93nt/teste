package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 12:51
 */
public class Npccwxterequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXTE-HEADER.NPCCWXTE-COD-LAYOUT")
	private String codlayout = "NPCCWXTE";

	@Adapter(transactionField = "NPCCWXTE-HEADER.NPCCWXTE-TAM-LAYOUT")
	private Integer tamlayout = 100;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-CINDCD-ECONM-PNALT")
	private Integer cindcdeconmpnalt = 0;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-VPNALT-ANTEC-CMBIO")
	private String vpnaltanteccmbio = null;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWXTE-REGISTRO.NPCCWXTE-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;
	
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

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}
	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public Integer getCindcdeconmpnalt() {
		return cindcdeconmpnalt;
	}
	public void setCindcdeconmpnalt(Integer cindcdeconmpnalt) {
		this.cindcdeconmpnalt = cindcdeconmpnalt;
	}

	public String getVpnaltanteccmbio() {
		return vpnaltanteccmbio;
	}
	public void setVpnaltanteccmbio(String vpnaltanteccmbio) {
		this.vpnaltanteccmbio = vpnaltanteccmbio;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}
	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
    
}