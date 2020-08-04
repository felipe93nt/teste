package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:30
 */
public class Npccwwqsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-NBLETO-NEGOC-CMBIO")
	private Long lista_nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-NBLETO-CMBIO-ANO")
	private Long lista_nbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-DFIM-NEGOC-CMBIO")
	private String lista_dfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-IINDCD-ECONM-MOEDA")
	private String lista_iindcdeconmmoeda = null;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-VNEGOC-MOEDA-ESTRG")
	private String lista_vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWQS-REGISTRO.NPCCWWQS-LISTA.NPCCWWQS-IPRODT-SERVC")
	private String lista_iprodtservc = null;
	
	public Long getLista_nbletonegoccmbio() {
		return lista_nbletonegoccmbio;
	}
	public void setLista_nbletonegoccmbio(Long lista_nbletonegoccmbio) {
		this.lista_nbletonegoccmbio = lista_nbletonegoccmbio;
	}

	public Long getLista_nbletocmbioano() {
		return lista_nbletocmbioano;
	}
	public void setLista_nbletocmbioano(Long lista_nbletocmbioano) {
		this.lista_nbletocmbioano = lista_nbletocmbioano;
	}

	public String getLista_dfimnegoccmbio() {
		return lista_dfimnegoccmbio;
	}
	public void setLista_dfimnegoccmbio(String lista_dfimnegoccmbio) {
		this.lista_dfimnegoccmbio = lista_dfimnegoccmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_iindcdeconmmoeda() {
		return lista_iindcdeconmmoeda;
	}
	public void setLista_iindcdeconmmoeda(String lista_iindcdeconmmoeda) {
		this.lista_iindcdeconmmoeda = lista_iindcdeconmmoeda;
	}

	public String getLista_vnegocmoedaestrg() {
		return lista_vnegocmoedaestrg;
	}
	public void setLista_vnegocmoedaestrg(String lista_vnegocmoedaestrg) {
		this.lista_vnegocmoedaestrg = lista_vnegocmoedaestrg;
	}

	public Integer getLista_cprodtservc() {
		return lista_cprodtservc;
	}
	public void setLista_cprodtservc(Integer lista_cprodtservc) {
		this.lista_cprodtservc = lista_cprodtservc;
	}

	public String getLista_iprodtservc() {
		return lista_iprodtservc;
	}
	public void setLista_iprodtservc(String lista_iprodtservc) {
		this.lista_iprodtservc = lista_iprodtservc;
	}
    
}