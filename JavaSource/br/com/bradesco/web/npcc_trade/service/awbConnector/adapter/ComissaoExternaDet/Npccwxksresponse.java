package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:25
 */
public class Npccwxksresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXKS-HEADER.NPCCWXKS-COD-LAYOUT")
	private String codlayout = "NPCCWXKS";

	@Adapter(transactionField = "NPCCWXKS-HEADER.NPCCWXKS-TAM-LAYOUT")
	private Integer tamlayout = 3511;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-NCOMIS-EXTER-TRADE")
	private Integer ncomisextertrade = 0;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-ISGL-INDCD-FONTE")
	private String isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Npccwxksresponse_lista")
	private List<Npccwxksresponse_lista> lista = null;
	
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getNcomisextertrade() {
		return ncomisextertrade;
	}
	public void setNcomisextertrade(Integer ncomisextertrade) {
		this.ncomisextertrade = ncomisextertrade;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwxksresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxksresponse_lista> lista) {
		this.lista = lista;
	}
    
}