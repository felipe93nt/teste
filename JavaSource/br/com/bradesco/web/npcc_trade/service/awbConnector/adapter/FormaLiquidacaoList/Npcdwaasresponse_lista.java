package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/10/15 10:02
 */
public class Npcdwaasresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CFORMA-LIQDC-CMBIO")
	private Integer lista_cformaliqdccmbio = 0;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-IFORMA-LIQDC-BLETO")
	private String lista_iformaliqdcbleto = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CMOEDA-ESTRG-NACIO")
	private Integer lista_cmoedaestrgnacio = 0;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CSGL-FORMA-LIQDC")
	private String lista_csglformaliqdc = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CLIQDC-CMBIO-BACEN")
	private Integer lista_cliqdccmbiobacen = 0;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-NTPO-SIT-CMBIO")
	private Integer lista_ntpositcmbio = 0;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-RJUSTF-SIT-CMBIO")
	private String lista_rjustfsitcmbio = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CUSUAR-INCL")
	private String lista_cusuarincl = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-IUSUAR-INCL")
	private String lista_iusuarincl = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-HINCL-REG")
	private String lista_hinclreg = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-CUSUAR-MANUT")
	private String lista_cusuarmanut = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-IUSUAR-MANUT")
	private String lista_iusuarmanut = null;

	@Adapter(transactionField = "NPCDWAAS-REGISTRO.NPCDWAAS-LISTA.NPCDWAAS-HMANUT-REG")
	private String lista_hmanutreg = null;
	
	public Integer getLista_cformaliqdccmbio() {
		return lista_cformaliqdccmbio;
	}
	public void setLista_cformaliqdccmbio(Integer lista_cformaliqdccmbio) {
		this.lista_cformaliqdccmbio = lista_cformaliqdccmbio;
	}

	public String getLista_iformaliqdcbleto() {
		return lista_iformaliqdcbleto;
	}
	public void setLista_iformaliqdcbleto(String lista_iformaliqdcbleto) {
		this.lista_iformaliqdcbleto = lista_iformaliqdcbleto;
	}

	public Integer getLista_cmoedaestrgnacio() {
		return lista_cmoedaestrgnacio;
	}
	public void setLista_cmoedaestrgnacio(Integer lista_cmoedaestrgnacio) {
		this.lista_cmoedaestrgnacio = lista_cmoedaestrgnacio;
	}

	public String getLista_csglformaliqdc() {
		return lista_csglformaliqdc;
	}
	public void setLista_csglformaliqdc(String lista_csglformaliqdc) {
		this.lista_csglformaliqdc = lista_csglformaliqdc;
	}

	public Integer getLista_cliqdccmbiobacen() {
		return lista_cliqdccmbiobacen;
	}
	public void setLista_cliqdccmbiobacen(Integer lista_cliqdccmbiobacen) {
		this.lista_cliqdccmbiobacen = lista_cliqdccmbiobacen;
	}

	public Integer getLista_ntpositcmbio() {
		return lista_ntpositcmbio;
	}
	public void setLista_ntpositcmbio(Integer lista_ntpositcmbio) {
		this.lista_ntpositcmbio = lista_ntpositcmbio;
	}

	public String getLista_rjustfsitcmbio() {
		return lista_rjustfsitcmbio;
	}
	public void setLista_rjustfsitcmbio(String lista_rjustfsitcmbio) {
		this.lista_rjustfsitcmbio = lista_rjustfsitcmbio;
	}

	public String getLista_cusuarincl() {
		return lista_cusuarincl;
	}
	public void setLista_cusuarincl(String lista_cusuarincl) {
		this.lista_cusuarincl = lista_cusuarincl;
	}

	public String getLista_iusuarincl() {
		return lista_iusuarincl;
	}
	public void setLista_iusuarincl(String lista_iusuarincl) {
		this.lista_iusuarincl = lista_iusuarincl;
	}

	public String getLista_hinclreg() {
		return lista_hinclreg;
	}
	public void setLista_hinclreg(String lista_hinclreg) {
		this.lista_hinclreg = lista_hinclreg;
	}

	public String getLista_cusuarmanut() {
		return lista_cusuarmanut;
	}
	public void setLista_cusuarmanut(String lista_cusuarmanut) {
		this.lista_cusuarmanut = lista_cusuarmanut;
	}

	public String getLista_iusuarmanut() {
		return lista_iusuarmanut;
	}
	public void setLista_iusuarmanut(String lista_iusuarmanut) {
		this.lista_iusuarmanut = lista_iusuarmanut;
	}

	public String getLista_hmanutreg() {
		return lista_hmanutreg;
	}
	public void setLista_hmanutreg(String lista_hmanutreg) {
		this.lista_hmanutreg = lista_hmanutreg;
	}
    
}