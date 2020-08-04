package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:44
 */
public class Npccwxjsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-NCOMIS-EXTER-TRADE")
	private Integer lista_ncomisextertrade = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CCONDC-ECONC")
	private Integer lista_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-ICOND-ECONC")
	private String lista_icondeconc = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-VPCELA-COMIS-CMBIO")
	private String lista_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-PCOMIS-NEGOC-CMBIO")
	private String lista_pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CPERDC-JURO-CMBIO")
	private Integer lista_cperdcjurocmbio = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-IPERDC-JURO-CMBIO")
	private String lista_iperdcjurocmbio = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CFLUXO-PERDC-CMBIO")
	private Integer lista_cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-IFLUXO-PERDC-CMBIO")
	private String lista_ifluxoperdccmbio = null;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CMOMEN-COBR-CMBIO")
	private Integer lista_cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-QPCELA-CMBIO-TRADE")
	private Integer lista_qpcelacmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXJS-REGISTRO.NPCCWXJS-LISTA.NPCCWXJS-CRESP-COMIS-EXTER")
	private Integer lista_crespcomisexter = 0;
	
	public Integer getLista_ncomisextertrade() {
		return lista_ncomisextertrade;
	}
	public void setLista_ncomisextertrade(Integer lista_ncomisextertrade) {
		this.lista_ncomisextertrade = lista_ncomisextertrade;
	}

	public Integer getLista_ccondceconc() {
		return lista_ccondceconc;
	}
	public void setLista_ccondceconc(Integer lista_ccondceconc) {
		this.lista_ccondceconc = lista_ccondceconc;
	}

	public String getLista_icondeconc() {
		return lista_icondeconc;
	}
	public void setLista_icondeconc(String lista_icondeconc) {
		this.lista_icondeconc = lista_icondeconc;
	}

	public Integer getLista_cperdcjurocmbio() {
		return lista_cperdcjurocmbio;
	}
	public void setLista_cperdcjurocmbio(Integer lista_cperdcjurocmbio) {
		this.lista_cperdcjurocmbio = lista_cperdcjurocmbio;
	}

	public String getLista_iperdcjurocmbio() {
		return lista_iperdcjurocmbio;
	}
	public void setLista_iperdcjurocmbio(String lista_iperdcjurocmbio) {
		this.lista_iperdcjurocmbio = lista_iperdcjurocmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}

	public Integer getLista_cfluxoperdccmbio() {
		return lista_cfluxoperdccmbio;
	}
	public void setLista_cfluxoperdccmbio(Integer lista_cfluxoperdccmbio) {
		this.lista_cfluxoperdccmbio = lista_cfluxoperdccmbio;
	}

	public String getLista_ifluxoperdccmbio() {
		return lista_ifluxoperdccmbio;
	}
	public void setLista_ifluxoperdccmbio(String lista_ifluxoperdccmbio) {
		this.lista_ifluxoperdccmbio = lista_ifluxoperdccmbio;
	}

	public Integer getLista_cmomencobrcmbio() {
		return lista_cmomencobrcmbio;
	}
	public void setLista_cmomencobrcmbio(Integer lista_cmomencobrcmbio) {
		this.lista_cmomencobrcmbio = lista_cmomencobrcmbio;
	}

	public Integer getLista_qpcelacmbiotrade() {
		return lista_qpcelacmbiotrade;
	}
	public void setLista_qpcelacmbiotrade(Integer lista_qpcelacmbiotrade) {
		this.lista_qpcelacmbiotrade = lista_qpcelacmbiotrade;
	}

	public Integer getLista_crespcomisexter() {
		return lista_crespcomisexter;
	}
	public void setLista_crespcomisexter(Integer lista_crespcomisexter) {
		this.lista_crespcomisexter = lista_crespcomisexter;
	}
    /**
     * @return o valor do lista_vpcelacomiscmbio
     */
    public String getLista_vpcelacomiscmbio() {
        return lista_vpcelacomiscmbio;
    }
    /**
     * @param lista_vpcelacomiscmbio seta o novo valor para o campo lista_vpcelacomiscmbio
     */
    public void setLista_vpcelacomiscmbio(String lista_vpcelacomiscmbio) {
        this.lista_vpcelacomiscmbio = lista_vpcelacomiscmbio;
    }
    /**
     * @return o valor do lista_pcomisnegoccmbio
     */
    public String getLista_pcomisnegoccmbio() {
        return lista_pcomisnegoccmbio;
    }
    /**
     * @param lista_pcomisnegoccmbio seta o novo valor para o campo lista_pcomisnegoccmbio
     */
    public void setLista_pcomisnegoccmbio(String lista_pcomisnegoccmbio) {
        this.lista_pcomisnegoccmbio = lista_pcomisnegoccmbio;
    }
    
}