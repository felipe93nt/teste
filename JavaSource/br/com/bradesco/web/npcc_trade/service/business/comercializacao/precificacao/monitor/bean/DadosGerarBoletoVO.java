package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;


/**
 * Nome: DadosGerarBoletoVO.java
 * 
 * Prop�sito: Dados da cota��o gerada pela tela 'Duplicar' quando acionado o bot�o 'Gerar Boleto'
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 14/05/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class DadosGerarBoletoVO {

    /** Vari�vel do tipo Integer */
    private Integer danobase = null;

    /** Vari�vel do tipo Integer */
    private Integer nbletocmbioano = null;
    
    private Boolean gerarBoleto = Boolean.FALSE;

    /**
     * @return o valor do danobase
     */
    public Integer getDanobase() {
        return danobase;
    }

    /**
     * @param danobase seta o novo valor para o campo danobase
     */
    public void setDanobase(Integer danobase) {
        this.danobase = danobase;
    }

    /**
     * @return o valor do nbletocmbioano
     */
    public Integer getNbletocmbioano() {
        return nbletocmbioano;
    }

    /**
     * @param nbletocmbioano seta o novo valor para o campo nbletocmbioano
     */
    public void setNbletocmbioano(Integer nbletocmbioano) {
        this.nbletocmbioano = nbletocmbioano;
    }

    /**
     * @return o valor do gerarBoleto
     */
    public Boolean getGerarBoleto() {
        return gerarBoleto;
    }

    /**
     * @param gerarBoleto seta o novo valor para o campo gerarBoleto
     */
    public void setGerarBoleto(Boolean gerarBoleto) {
        this.gerarBoleto = gerarBoleto;
    }
    
}
