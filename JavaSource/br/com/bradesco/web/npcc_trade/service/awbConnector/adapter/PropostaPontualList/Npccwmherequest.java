package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/03/16 18:33
 */
public class Npccwmherequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMHE-HEADER.NPCCWMHE-COD-LAYOUT")
	private String codlayout = "NPCCWMHE";

	@Adapter(transactionField = "NPCCWMHE-HEADER.NPCCWMHE-TAM-LAYOUT")
	private Integer tamlayout = 32;

	@Adapter(transactionField = "NPCCWMHE-REGISTRO.NPCCWMHE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWMHE-REGISTRO.NPCCWMHE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWMHE-REGISTRO.NPCCWMHE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;
	
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

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCidtfdmesacmbio() {
		return cidtfdmesacmbio;
	}
	public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
		this.cidtfdmesacmbio = cidtfdmesacmbio;
	}
    
}