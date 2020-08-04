package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/04/16 11:04
 */
public class Npccwhfsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWHFS-HEADER.NPCCWHFS-COD-LAYOUT")
	private String codlayout = "NPCCWHFS";

	@Adapter(transactionField = "NPCCWHFS-HEADER.NPCCWHFS-TAM-LAYOUT")
	private Integer tamlayout = 28;

	@Adapter(transactionField = "NPCCWHFS-REGISTRO.NPCCWHFS-TDIA-LIQDC")
	private Integer tdialiqdc = 0;

	@Adapter(transactionField = "NPCCWHFS-REGISTRO.NPCCWHFS-DLIQDC-CMBIO")
	private String dliqdccmbio = null;
	
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

	public Integer getTdialiqdc() {
		return tdialiqdc;
	}
	public void setTdialiqdc(Integer tdialiqdc) {
		this.tdialiqdc = tdialiqdc;
	}

	public String getDliqdccmbio() {
		return dliqdccmbio;
	}
	public void setDliqdccmbio(String dliqdccmbio) {
		this.dliqdccmbio = dliqdccmbio;
	}
    
}