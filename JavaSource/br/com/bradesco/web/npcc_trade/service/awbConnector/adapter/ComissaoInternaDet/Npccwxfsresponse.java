package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:04
 */
public class Npccwxfsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXFS-HEADER.NPCCWXFS-COD-LAYOUT")
	private String codlayout = "NPCCWXFS";

	@Adapter(transactionField = "NPCCWXFS-HEADER.NPCCWXFS-TAM-LAYOUT")
	private Integer tamlayout = 3298;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-NCOMIS-INTRN-TRADE")
	private Integer ncomisintrntrade = 0;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Npccwxfsresponse_lista")
	private List<Npccwxfsresponse_lista> lista = null;
	
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

	public Integer getNcomisintrntrade() {
		return ncomisintrntrade;
	}
	public void setNcomisintrntrade(Integer ncomisintrntrade) {
		this.ncomisintrntrade = ncomisintrntrade;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwxfsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxfsresponse_lista> lista) {
		this.lista = lista;
	}
    
}