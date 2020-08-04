package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/12/15 12:13
 */
public class Npccwwnerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWNE-HEADER.NPCCWWNE-COD-LAYOUT")
	private String codlayout = "NPCCWWNE";

	@Adapter(transactionField = "NPCCWWNE-HEADER.NPCCWWNE-TAM-LAYOUT")
	private Integer tamlayout = 324;

	@Adapter(transactionField = "NPCCWWNE-REGISTRO.NPCCWWNE-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCCWWNE-REGISTRO.NPCCWWNE-RMCADO-OPER-CMBIO")
	private String rmcadoopercmbio = null;

	@Adapter(transactionField = "NPCCWWNE-REGISTRO.NPCCWWNE-CMCADO-CMBIO-MCSUL")
	private Long cmcadocmbiomcsul = 0L;
	
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

	public String getRmcadoopercmbio() {
		return rmcadoopercmbio;
	}
	public void setRmcadoopercmbio(String rmcadoopercmbio) {
		this.rmcadoopercmbio = rmcadoopercmbio;
	}

	public Long getCmcadocmbiomcsul() {
		return cmcadocmbiomcsul;
	}
	public void setCmcadocmbiomcsul(Long cmcadocmbiomcsul) {
		this.cmcadocmbiomcsul = cmcadocmbiomcsul;
	}
    
}