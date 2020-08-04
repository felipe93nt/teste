package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 10:41
 */
public class Npccwxhsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-NBLETO-NEGOC-VNCLO")
	private Long lista_nbletonegocvnclo = 0L;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-NBLETO-CMBIO-ANO")
	private Long lista_nbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-IPRODT-SERVC")
	private String lista_iprodtservc = null;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-IINDCD-ECONM-MOEDA")
	private String lista_iindcdeconmmoeda = null;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-VNEGOC-MOEDA-ESTRG")
	private String lista_vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWXHS-REGISTRO.NPCCWXHS-LISTA.NPCCWXHS-CINDCD-VNCLO-IMPOR")
	private String lista_cindcdvncloimpor = null;
	
	public Long getLista_nbletonegocvnclo() {
		return lista_nbletonegocvnclo;
	}
	public void setLista_nbletonegocvnclo(Long lista_nbletonegocvnclo) {
		this.lista_nbletonegocvnclo = lista_nbletonegocvnclo;
	}

	public Long getLista_nbletocmbioano() {
		return lista_nbletocmbioano;
	}
	public void setLista_nbletocmbioano(Long lista_nbletocmbioano) {
		this.lista_nbletocmbioano = lista_nbletocmbioano;
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

	public String getLista_cindcdvncloimpor() {
		return lista_cindcdvncloimpor;
	}
	public void setLista_cindcdvncloimpor(String lista_cindcdvncloimpor) {
		this.lista_cindcdvncloimpor = lista_cindcdvncloimpor;
	}
    
}