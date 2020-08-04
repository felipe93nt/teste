package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/17 18:19
 */
public class Npccwpperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWPPE-HEADER.NPCCWPPE-COD-LAYOUT")
	private String codlayout = "NPCCWPPE";

	@Adapter(transactionField = "NPCCWPPE-HEADER.NPCCWPPE-TAM-LAYOUT")
	private Integer tamlayout = 32;

	@Adapter(transactionField = "NPCCWPPE-REGISTRO.NPCCWPPE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWPPE-REGISTRO.NPCCWPPE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWPPE-REGISTRO.NPCCWPPE-CIDTFD-MESA-CMBIO")
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