package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listamotvoi extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-MOTVO-I.NPCDWEYS-RTPO-MOTVO-REST-I")
	private String listamotvoi_rtpomotvoresti = null;
	
	public String getListamotvoi_rtpomotvoresti() {
		return listamotvoi_rtpomotvoresti;
	}
	public void setListamotvoi_rtpomotvoresti(String listamotvoi_rtpomotvoresti) {
		this.listamotvoi_rtpomotvoresti = listamotvoi_rtpomotvoresti;
	}
    
}