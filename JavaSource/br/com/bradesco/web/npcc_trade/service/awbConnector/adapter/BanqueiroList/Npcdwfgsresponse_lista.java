package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/09/18 14:36
 */
public class Npcdwfgsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-IBANQR-CMBIO")
	private String lista_ibanqrcmbio = null;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CBANQR-CMBIO")
	private Long lista_cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CID-BANQR-SWIFT")
	private String lista_cidbanqrswift = null;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CFLIAL-BANQR-SWIFT")
	private String lista_cflialbanqrswift = null;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CPAIS")
	private Integer lista_cpais = 0;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-IPAIS")
	private String lista_ipais = null;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CMUN-INTL-CMBIO")
	private Long lista_cmunintlcmbio = 0L;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-IMUN-INTL-CMBIO")
	private String lista_imunintlcmbio = null;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CTROCA-MSGEM-SWIFT")
	private Integer lista_ctrocamsgemswift = 0;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA.NPCDWFGS-CINDCD-BLOQUEADO")
	private Integer lista_cindcdbloqueado = 0;
	
	public String getLista_ibanqrcmbio() {
		return lista_ibanqrcmbio;
	}
	public void setLista_ibanqrcmbio(String lista_ibanqrcmbio) {
		this.lista_ibanqrcmbio = lista_ibanqrcmbio;
	}

	public Long getLista_cbanqrcmbio() {
		return lista_cbanqrcmbio;
	}
	public void setLista_cbanqrcmbio(Long lista_cbanqrcmbio) {
		this.lista_cbanqrcmbio = lista_cbanqrcmbio;
	}

	public String getLista_cidbanqrswift() {
		return lista_cidbanqrswift;
	}
	public void setLista_cidbanqrswift(String lista_cidbanqrswift) {
		this.lista_cidbanqrswift = lista_cidbanqrswift;
	}

	public String getLista_cflialbanqrswift() {
		return lista_cflialbanqrswift;
	}
	public void setLista_cflialbanqrswift(String lista_cflialbanqrswift) {
		this.lista_cflialbanqrswift = lista_cflialbanqrswift;
	}

	public Integer getLista_cpais() {
		return lista_cpais;
	}
	public void setLista_cpais(Integer lista_cpais) {
		this.lista_cpais = lista_cpais;
	}

	public String getLista_ipais() {
		return lista_ipais;
	}
	public void setLista_ipais(String lista_ipais) {
		this.lista_ipais = lista_ipais;
	}

	public Long getLista_cmunintlcmbio() {
		return lista_cmunintlcmbio;
	}
	public void setLista_cmunintlcmbio(Long lista_cmunintlcmbio) {
		this.lista_cmunintlcmbio = lista_cmunintlcmbio;
	}

	public String getLista_imunintlcmbio() {
		return lista_imunintlcmbio;
	}
	public void setLista_imunintlcmbio(String lista_imunintlcmbio) {
		this.lista_imunintlcmbio = lista_imunintlcmbio;
	}

	public Integer getLista_ctrocamsgemswift() {
		return lista_ctrocamsgemswift;
	}
	public void setLista_ctrocamsgemswift(Integer lista_ctrocamsgemswift) {
		this.lista_ctrocamsgemswift = lista_ctrocamsgemswift;
	}

	public Integer getLista_cindcdbloqueado() {
		return lista_cindcdbloqueado;
	}
	public void setLista_cindcdbloqueado(Integer lista_cindcdbloqueado) {
		this.lista_cindcdbloqueado = lista_cindcdbloqueado;
	}
    
}