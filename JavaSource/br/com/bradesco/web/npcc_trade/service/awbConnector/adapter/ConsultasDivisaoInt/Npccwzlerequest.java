package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Npccwzlerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZLE-HEADER.NPCCWZLE-COD-LAYOUT")
	private String codlayout = "NPCCWZLE";

	@Adapter(transactionField = "NPCCWZLE-HEADER.NPCCWZLE-TAM-LAYOUT")
	private Integer tamlayout = 79;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-DTPER-INI")
	private String dtperini = null;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-DTPER-FIM")
	private String dtperfim = null;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-VNEGOC-MOEDA-ESTRGI")
	private String vnegocmoedaestrgi = null;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-VNEGOC-MOEDA-ESTRGF")
	private String vnegocmoedaestrgf = null;

	@Adapter(transactionField = "NPCCWZLE-REGISTRO.NPCCWZLE-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;
	
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

	public String getDtperini() {
		return dtperini;
	}
	public void setDtperini(String dtperini) {
		this.dtperini = dtperini;
	}

	public String getDtperfim() {
		return dtperfim;
	}
	public void setDtperfim(String dtperfim) {
		this.dtperfim = dtperfim;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getVnegocmoedaestrgi() {
		return vnegocmoedaestrgi;
	}
	public void setVnegocmoedaestrgi(String vnegocmoedaestrgi) {
		this.vnegocmoedaestrgi = vnegocmoedaestrgi;
	}

	public String getVnegocmoedaestrgf() {
		return vnegocmoedaestrgf;
	}
	public void setVnegocmoedaestrgf(String vnegocmoedaestrgf) {
		this.vnegocmoedaestrgf = vnegocmoedaestrgf;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}
    
}