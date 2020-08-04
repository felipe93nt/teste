package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/11/17 16:31
 */
public class Npccwzjsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-NBLETO-NEGOC-CMBIO")
	private Long lista_nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-DANO-BASE")
	private Integer lista_danobase = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-NBLETO-CMBIO-ANO")
	private Integer lista_nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-DFCHTO-BLETO-CMBIO")
	private String lista_dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-CUNIC-CLI-CMBIO")
	private Long lista_cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-CECONM-MOEDA-LIM")
	private Integer lista_ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-DFIM-NEGOC-CMBIO")
	private String lista_dfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-VNEGOC-MOEDA-ESTRG")
	private String lista_vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-VNEGOC-MOEDA-DOLAR")
	private String lista_vnegocmoedadolar = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-DESC-PROD")
	private String lista_descprod = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWZJS-REGISTRO.NPCCWZJS-LISTA.NPCCWZJS-NOME-COMPLETO-CLI")
	private String lista_nomecompletocli = null;
	
	public Long getLista_nbletonegoccmbio() {
		return lista_nbletonegoccmbio;
	}
	public void setLista_nbletonegoccmbio(Long lista_nbletonegoccmbio) {
		this.lista_nbletonegoccmbio = lista_nbletonegoccmbio;
	}

	public Integer getLista_danobase() {
		return lista_danobase;
	}
	public void setLista_danobase(Integer lista_danobase) {
		this.lista_danobase = lista_danobase;
	}

	public Integer getLista_nbletocmbioano() {
		return lista_nbletocmbioano;
	}
	public void setLista_nbletocmbioano(Integer lista_nbletocmbioano) {
		this.lista_nbletocmbioano = lista_nbletocmbioano;
	}

	public String getLista_dfchtobletocmbio() {
		return lista_dfchtobletocmbio;
	}
	public void setLista_dfchtobletocmbio(String lista_dfchtobletocmbio) {
		this.lista_dfchtobletocmbio = lista_dfchtobletocmbio;
	}

	public Long getLista_cunicclicmbio() {
		return lista_cunicclicmbio;
	}
	public void setLista_cunicclicmbio(Long lista_cunicclicmbio) {
		this.lista_cunicclicmbio = lista_cunicclicmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public Integer getLista_cprodtservc() {
		return lista_cprodtservc;
	}
	public void setLista_cprodtservc(Integer lista_cprodtservc) {
		this.lista_cprodtservc = lista_cprodtservc;
	}

	public Integer getLista_ceconmmoedalim() {
		return lista_ceconmmoedalim;
	}
	public void setLista_ceconmmoedalim(Integer lista_ceconmmoedalim) {
		this.lista_ceconmmoedalim = lista_ceconmmoedalim;
	}

	public String getLista_dfimnegoccmbio() {
		return lista_dfimnegoccmbio;
	}
	public void setLista_dfimnegoccmbio(String lista_dfimnegoccmbio) {
		this.lista_dfimnegoccmbio = lista_dfimnegoccmbio;
	}

	public String getLista_vnegocmoedaestrg() {
		return lista_vnegocmoedaestrg;
	}
	public void setLista_vnegocmoedaestrg(String lista_vnegocmoedaestrg) {
		this.lista_vnegocmoedaestrg = lista_vnegocmoedaestrg;
	}

	public String getLista_vnegocmoedadolar() {
		return lista_vnegocmoedadolar;
	}
	public void setLista_vnegocmoedadolar(String lista_vnegocmoedadolar) {
		this.lista_vnegocmoedadolar = lista_vnegocmoedadolar;
	}

	public String getLista_descprod() {
		return lista_descprod;
	}
	public void setLista_descprod(String lista_descprod) {
		this.lista_descprod = lista_descprod;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}

	public String getLista_nomecompletocli() {
		return lista_nomecompletocli;
	}
	public void setLista_nomecompletocli(String lista_nomecompletocli) {
		this.lista_nomecompletocli = lista_nomecompletocli;
	}
    
}