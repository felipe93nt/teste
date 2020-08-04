package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 31/07/18 09:11
 */
public class Npccwx1sresponse_pcelasfndng extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCELAS-FNDNG.NPCCWX1S-CEXTER-REFT-FNDNG")
	private String pcelasfndng_cexterreftfndng = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCELAS-FNDNG.NPCCWX1S-CINDCD-MOEDA-FNDG")
	private Integer pcelasfndng_cindcdmoedafndg = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCELAS-FNDNG.NPCCWX1S-DES-ECONM-MOEDA-FNDG")
	private String pcelasfndng_deseconmmoedafndg = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCELAS-FNDNG.NPCCWX1S-VPCELA-FNDNG-CMBIO")
	private Double pcelasfndng_vpcelafndngcmbio = 0D;
	
	public String getPcelasfndng_cexterreftfndng() {
		return pcelasfndng_cexterreftfndng;
	}
	public void setPcelasfndng_cexterreftfndng(String pcelasfndng_cexterreftfndng) {
		this.pcelasfndng_cexterreftfndng = pcelasfndng_cexterreftfndng;
	}

	public Integer getPcelasfndng_cindcdmoedafndg() {
		return pcelasfndng_cindcdmoedafndg;
	}
	public void setPcelasfndng_cindcdmoedafndg(Integer pcelasfndng_cindcdmoedafndg) {
		this.pcelasfndng_cindcdmoedafndg = pcelasfndng_cindcdmoedafndg;
	}

	public String getPcelasfndng_deseconmmoedafndg() {
		return pcelasfndng_deseconmmoedafndg;
	}
	public void setPcelasfndng_deseconmmoedafndg(String pcelasfndng_deseconmmoedafndg) {
		this.pcelasfndng_deseconmmoedafndg = pcelasfndng_deseconmmoedafndg;
	}

	public Double getPcelasfndng_vpcelafndngcmbio() {
		return pcelasfndng_vpcelafndngcmbio;
	}
	public void setPcelasfndng_vpcelafndngcmbio(Double pcelasfndng_vpcelafndngcmbio) {
		this.pcelasfndng_vpcelafndngcmbio = pcelasfndng_vpcelafndngcmbio;
	}
    
}