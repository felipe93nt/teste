package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/01/16 11:22
 */
public class Npcdwemerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEME-HEADER.NPCDWEME-COD-LAYOUT")
	private String codlayout = "NPCDWEME";

	@Adapter(transactionField = "NPCDWEME-HEADER.NPCDWEME-TAM-LAYOUT")
	private Integer tamlayout = 134;

	@Adapter(transactionField = "NPCDWEME-REGISTRO.NPCDWEME-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCDWEME-REGISTRO.NPCDWEME-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCDWEME-REGISTRO.NPCDWEME-IPSSOA-CMBIO")
	private String ipssoacmbio = null;

	@Adapter(transactionField = "NPCDWEME-REGISTRO.NPCDWEME-IREDZD-PSSOA-CMBIO")
	private String iredzdpssoacmbio = null;
	
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

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public String getIpssoacmbio() {
		return ipssoacmbio;
	}
	public void setIpssoacmbio(String ipssoacmbio) {
		this.ipssoacmbio = ipssoacmbio;
	}

	public String getIredzdpssoacmbio() {
		return iredzdpssoacmbio;
	}
	public void setIredzdpssoacmbio(String iredzdpssoacmbio) {
		this.iredzdpssoacmbio = iredzdpssoacmbio;
	}
    
}