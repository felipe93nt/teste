package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.cotacoesaVencer;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public class CotacoesaVencerViewHelper {
   
	private Integer qtdDias = Numeros.ZERO;

	
    /**
     * @return a quantidade de dias para o filto
     */ 
	public Integer getQtdDias() {
		return qtdDias;
	}

    /**
     * @param seta a quantidade de dias para o filtro
     */
	public void setQtdDias(Integer qtdDias) {
		this.qtdDias = qtdDias;
	} 
}

