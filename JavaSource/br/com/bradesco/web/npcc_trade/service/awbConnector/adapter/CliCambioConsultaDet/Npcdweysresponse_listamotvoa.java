package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listamotvoa extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-MOTVO-A.NPCDWEYS-RTPO-MOTVO-REST-A")
	private String listamotvoa_rtpomotvoresta = null;
	
	public String getListamotvoa_rtpomotvoresta() {
		return listamotvoa_rtpomotvoresta;
	}
	public void setListamotvoa_rtpomotvoresta(String listamotvoa_rtpomotvoresta) {
		this.listamotvoa_rtpomotvoresta = listamotvoa_rtpomotvoresta;
	}
    
}