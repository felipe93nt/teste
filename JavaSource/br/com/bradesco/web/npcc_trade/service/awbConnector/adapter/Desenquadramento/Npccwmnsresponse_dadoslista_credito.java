package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnsresponse_dadoslista_credito extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CREDITO.NPCCWMNS-DESC-CRED")
	private String dadoslista_credito_desccred = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CREDITO.NPCCWMNS-VMOTVO-SOLIC")
	private String dadoslista_credito_vmotvosolic = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-CREDITO.NPCCWMNS-VMOTVO-DISP")
	private String dadoslista_credito_vmotvodisp = null;
	
	public String getDadoslista_credito_desccred() {
		return dadoslista_credito_desccred;
	}
	public void setDadoslista_credito_desccred(String dadoslista_credito_desccred) {
		this.dadoslista_credito_desccred = dadoslista_credito_desccred;
	}

	public String getDadoslista_credito_vmotvosolic() {
		return dadoslista_credito_vmotvosolic;
	}
	public void setDadoslista_credito_vmotvosolic(String dadoslista_credito_vmotvosolic) {
		this.dadoslista_credito_vmotvosolic = dadoslista_credito_vmotvosolic;
	}

	public String getDadoslista_credito_vmotvodisp() {
		return dadoslista_credito_vmotvodisp;
	}
	public void setDadoslista_credito_vmotvodisp(String dadoslista_credito_vmotvodisp) {
		this.dadoslista_credito_vmotvodisp = dadoslista_credito_vmotvodisp;
	}
    
}