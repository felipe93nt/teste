package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Npccwx4sresponse_pcelasfndng extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCELAS-FNDNG.NPCCWX4S-CEXTER-REFT-FNDNG")
	private String pcelasfndng_cexterreftfndng = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCELAS-FNDNG.NPCCWX4S-CINDCD-MOEDA-FNDG")
	private Integer pcelasfndng_cindcdmoedafndg = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCELAS-FNDNG.NPCCWX4S-DES-ECONM-MOEDA-FNDG")
	private String pcelasfndng_deseconmmoedafndg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCELAS-FNDNG.NPCCWX4S-VPCELA-FNDNG-CMBIO")
	private String pcelasfndng_vpcelafndngcmbio = null;
	
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

	public String getPcelasfndng_vpcelafndngcmbio() {
		return pcelasfndng_vpcelafndngcmbio;
	}
	public void setPcelasfndng_vpcelafndngcmbio(String pcelasfndng_vpcelafndngcmbio) {
		this.pcelasfndng_vpcelafndngcmbio = pcelasfndng_vpcelafndngcmbio;
	}
    
}