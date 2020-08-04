package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnsresponse_dadoslista_st extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-ST.NPCCWMNS-DESC-STAND")
	private String dadoslista_st_descstand = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-ST.NPCCWMNS-TDIA-MAX")
	private Integer dadoslista_st_tdiamax = 0;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-ST.NPCCWMNS-TDIA-VALDD")
	private Integer dadoslista_st_tdiavaldd = 0;
	
	public String getDadoslista_st_descstand() {
		return dadoslista_st_descstand;
	}
	public void setDadoslista_st_descstand(String dadoslista_st_descstand) {
		this.dadoslista_st_descstand = dadoslista_st_descstand;
	}

	public Integer getDadoslista_st_tdiamax() {
		return dadoslista_st_tdiamax;
	}
	public void setDadoslista_st_tdiamax(Integer dadoslista_st_tdiamax) {
		this.dadoslista_st_tdiamax = dadoslista_st_tdiamax;
	}

	public Integer getDadoslista_st_tdiavaldd() {
		return dadoslista_st_tdiavaldd;
	}
	public void setDadoslista_st_tdiavaldd(Integer dadoslista_st_tdiavaldd) {
		this.dadoslista_st_tdiavaldd = dadoslista_st_tdiavaldd;
	}
    
}