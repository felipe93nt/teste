package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/10/18 17:22
 */
public class Npccwj2sresponse_tbfaixas_tbfaixasoccurs extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-CIDTFD-FAIXA-OPER")
	private Integer tbfaixas_tbfaixasoccurs_cidtfdfaixaoper = 0;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-VLIM-INFER-BANQR")
	private String tbfaixas_tbfaixasoccurs_vliminferbanqr = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-VLIM-SUPE-BANQR")
	private String tbfaixas_tbfaixasoccurs_vlimsupebanqr = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-CBANQR-CMBIO")
	private Long tbfaixas_tbfaixasoccurs_cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-BANQR-DESC")
	private String tbfaixas_tbfaixasoccurs_banqrdesc = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-BANQR-PRACA-DESC")
	private String tbfaixas_tbfaixasoccurs_banqrpracadesc = null;

	@Adapter(transactionField = "NPCCWJ2S-REGISTRO.NPCCWJ2S-TB-FAIXAS.NPCCWJ2S-TB-FAIXAS-OCCURS.NPCCWJ2S-S-CID-BANQR-SWIFT")
	private String tbfaixas_tbfaixasoccurs_scidbanqrswift = null;
	
	public Integer getTbfaixas_tbfaixasoccurs_cidtfdfaixaoper() {
		return tbfaixas_tbfaixasoccurs_cidtfdfaixaoper;
	}
	public void setTbfaixas_tbfaixasoccurs_cidtfdfaixaoper(Integer tbfaixas_tbfaixasoccurs_cidtfdfaixaoper) {
		this.tbfaixas_tbfaixasoccurs_cidtfdfaixaoper = tbfaixas_tbfaixasoccurs_cidtfdfaixaoper;
	}

	public String getTbfaixas_tbfaixasoccurs_vliminferbanqr() {
		return tbfaixas_tbfaixasoccurs_vliminferbanqr;
	}
	public void setTbfaixas_tbfaixasoccurs_vliminferbanqr(String tbfaixas_tbfaixasoccurs_vliminferbanqr) {
		this.tbfaixas_tbfaixasoccurs_vliminferbanqr = tbfaixas_tbfaixasoccurs_vliminferbanqr;
	}

	public String getTbfaixas_tbfaixasoccurs_vlimsupebanqr() {
		return tbfaixas_tbfaixasoccurs_vlimsupebanqr;
	}
	public void setTbfaixas_tbfaixasoccurs_vlimsupebanqr(String tbfaixas_tbfaixasoccurs_vlimsupebanqr) {
		this.tbfaixas_tbfaixasoccurs_vlimsupebanqr = tbfaixas_tbfaixasoccurs_vlimsupebanqr;
	}

	public Long getTbfaixas_tbfaixasoccurs_cbanqrcmbio() {
		return tbfaixas_tbfaixasoccurs_cbanqrcmbio;
	}
	public void setTbfaixas_tbfaixasoccurs_cbanqrcmbio(Long tbfaixas_tbfaixasoccurs_cbanqrcmbio) {
		this.tbfaixas_tbfaixasoccurs_cbanqrcmbio = tbfaixas_tbfaixasoccurs_cbanqrcmbio;
	}

	public String getTbfaixas_tbfaixasoccurs_banqrdesc() {
		return tbfaixas_tbfaixasoccurs_banqrdesc;
	}
	public void setTbfaixas_tbfaixasoccurs_banqrdesc(String tbfaixas_tbfaixasoccurs_banqrdesc) {
		this.tbfaixas_tbfaixasoccurs_banqrdesc = tbfaixas_tbfaixasoccurs_banqrdesc;
	}

	public String getTbfaixas_tbfaixasoccurs_banqrpracadesc() {
		return tbfaixas_tbfaixasoccurs_banqrpracadesc;
	}
	public void setTbfaixas_tbfaixasoccurs_banqrpracadesc(String tbfaixas_tbfaixasoccurs_banqrpracadesc) {
		this.tbfaixas_tbfaixasoccurs_banqrpracadesc = tbfaixas_tbfaixasoccurs_banqrpracadesc;
	}

	public String getTbfaixas_tbfaixasoccurs_scidbanqrswift() {
		return tbfaixas_tbfaixasoccurs_scidbanqrswift;
	}
	public void setTbfaixas_tbfaixasoccurs_scidbanqrswift(String tbfaixas_tbfaixasoccurs_scidbanqrswift) {
		this.tbfaixas_tbfaixasoccurs_scidbanqrswift = tbfaixas_tbfaixasoccurs_scidbanqrswift;
	}
    
}