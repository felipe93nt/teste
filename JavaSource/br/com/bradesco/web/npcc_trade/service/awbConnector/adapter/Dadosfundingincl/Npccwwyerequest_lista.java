package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 14:05
 */
public class Npccwwyerequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-LISTA.NPCCWWYE-CEXTER-REFT-FNDNG")
	private String lista_cexterreftfndng = null;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-LISTA.NPCCWWYE-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWYE-REGISTRO.NPCCWWYE-LISTA.NPCCWWYE-VPCELA-FNDNG-CMBIO")
	private String lista_vpcelafndngcmbio = null;
	
	public String getLista_cexterreftfndng() {
		return lista_cexterreftfndng;
	}
	public void setLista_cexterreftfndng(String lista_cexterreftfndng) {
		this.lista_cexterreftfndng = lista_cexterreftfndng;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_vpcelafndngcmbio() {
		return lista_vpcelafndngcmbio;
	}
	public void setLista_vpcelafndngcmbio(String lista_vpcelafndngcmbio) {
		this.lista_vpcelafndngcmbio = lista_vpcelafndngcmbio;
	}
    
}