package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 08:46
 */
public class Npcdwfgerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWFGE-HEADER.NPCDWFGE-COD-LAYOUT")
	private String codlayout = "NPCDWFGE";

	@Adapter(transactionField = "NPCDWFGE-HEADER.NPCDWFGE-TAM-LAYOUT")
	private Integer tamlayout = 118;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-CBANQR-CMBIO")
	private Long cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-CID-BANQR-SWIFT")
	private String cidbanqrswift = null;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-CFLIAL-BANQR-SWIFT")
	private String cflialbanqrswift = null;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-IBANQR-CMBIO")
	private String ibanqrcmbio = null;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCDWFGE-REGISTRO.NPCDWFGE-CMUN-INTL-CMBIO")
	private Long cmunintlcmbio = 0L;
	
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

	public Integer getTipopesquisa() {
		return tipopesquisa;
	}
	public void setTipopesquisa(Integer tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	public String getCidbanqrswift() {
		return cidbanqrswift;
	}
	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	public String getCflialbanqrswift() {
		return cflialbanqrswift;
	}
	public void setCflialbanqrswift(String cflialbanqrswift) {
		this.cflialbanqrswift = cflialbanqrswift;
	}

	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}
	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public Long getCmunintlcmbio() {
		return cmunintlcmbio;
	}
	public void setCmunintlcmbio(Long cmunintlcmbio) {
		this.cmunintlcmbio = cmunintlcmbio;
	}
    
}