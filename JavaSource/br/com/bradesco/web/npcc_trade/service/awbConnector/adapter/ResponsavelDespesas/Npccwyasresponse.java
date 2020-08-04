package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/12/16 11:33
 */
public class Npccwyasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYAS-HEADER.NPCCWYAS-COD-LAYOUT")
	private String codlayout = "NPCCWYAS";

	@Adapter(transactionField = "NPCCWYAS-HEADER.NPCCWYAS-TAM-LAYOUT")
	private Integer tamlayout = 4666;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-CUNIC-PSSOA-DESC")
	private String cunicpssoadesc = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-CUNIC-PSSOA-IMUN")
	private String cunicpssoaimun = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-CUNIC-PSSOA-BNF")
	private Long cunicpssoabnf = 0L;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-CUNIC-PSSOA-AFI")
	private Long cunicpssoaafi = 0L;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Npccwyasresponse_listaresp")
	private List<Npccwyasresponse_listaresp> listaresp = null;
	
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

	public String getCunicpssoadesc() {
		return cunicpssoadesc;
	}
	public void setCunicpssoadesc(String cunicpssoadesc) {
		this.cunicpssoadesc = cunicpssoadesc;
	}

	public String getCunicpssoaimun() {
		return cunicpssoaimun;
	}
	public void setCunicpssoaimun(String cunicpssoaimun) {
		this.cunicpssoaimun = cunicpssoaimun;
	}

	public Long getCunicpssoabnf() {
		return cunicpssoabnf;
	}
	public void setCunicpssoabnf(Long cunicpssoabnf) {
		this.cunicpssoabnf = cunicpssoabnf;
	}

	public Long getCunicpssoaafi() {
		return cunicpssoaafi;
	}
	public void setCunicpssoaafi(Long cunicpssoaafi) {
		this.cunicpssoaafi = cunicpssoaafi;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwyasresponse_listaresp> getListaresp() {
		return listaresp;
	}
	public void setListaresp( List<Npccwyasresponse_listaresp> listaresp) {
		this.listaresp = listaresp;
	}
    
}