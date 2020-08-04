package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:30
 */
public class Npccwwqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWQE-HEADER.NPCCWWQE-COD-LAYOUT")
	private String codlayout = "NPCCWWQE";

	@Adapter(transactionField = "NPCCWWQE-HEADER.NPCCWWQE-TAM-LAYOUT")
	private Integer tamlayout = 69;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-DATA-INIO")
	private String datainio = null;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-DATA-FIM")
	private String datafim = null;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWQE-REGISTRO.NPCCWWQE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;
	
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

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public String getDatainio() {
		return datainio;
	}
	public void setDatainio(String datainio) {
		this.datainio = datainio;
	}

	public String getDatafim() {
		return datafim;
	}
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}
    
}