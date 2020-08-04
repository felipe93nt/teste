package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/01/16 11:22
 */
public class Npcdwemsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA.NPCDWEMS-IREDZD-PSSOA-CMBIO")
	private String lista_iredzdpssoacmbio = null;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA.NPCDWEMS-IPSSOA-CMBIO")
	private String lista_ipssoacmbio = null;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA.NPCDWEMS-CUNIC-PSSOA-CMBIO")
	private Long lista_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA.NPCDWEMS-ICIDDE-ENDER")
	private String lista_iciddeender = null;

	@Adapter(transactionField = "NPCDWEMS-REGISTRO.NPCDWEMS-LISTA.NPCDWEMS-IPAIS-COPLT")
	private String lista_ipaiscoplt = null;
	
	public String getLista_iredzdpssoacmbio() {
		return lista_iredzdpssoacmbio;
	}
	public void setLista_iredzdpssoacmbio(String lista_iredzdpssoacmbio) {
		this.lista_iredzdpssoacmbio = lista_iredzdpssoacmbio;
	}

	public String getLista_ipssoacmbio() {
		return lista_ipssoacmbio;
	}
	public void setLista_ipssoacmbio(String lista_ipssoacmbio) {
		this.lista_ipssoacmbio = lista_ipssoacmbio;
	}

	public Long getLista_cunicpssoacmbio() {
		return lista_cunicpssoacmbio;
	}
	public void setLista_cunicpssoacmbio(Long lista_cunicpssoacmbio) {
		this.lista_cunicpssoacmbio = lista_cunicpssoacmbio;
	}

	public String getLista_iciddeender() {
		return lista_iciddeender;
	}
	public void setLista_iciddeender(String lista_iciddeender) {
		this.lista_iciddeender = lista_iciddeender;
	}

	public String getLista_ipaiscoplt() {
		return lista_ipaiscoplt;
	}
	public void setLista_ipaiscoplt(String lista_ipaiscoplt) {
		this.lista_ipaiscoplt = lista_ipaiscoplt;
	}
    
}