/**
 * 
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.io.Serializable;

/**
 * Nome: InformacaoPilotoVO.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 16/05/2017
 * - Autor: BRQ
 * - Responsavel: Equipe Web
 * _ Ajuste para deixar no padrão hexavision.
*/
public class InformacaoPilotoVO implements Serializable {
    
    /** Variavel do tipo long. */
    private static final long serialVersionUID = -1996854324209409473L;
    private boolean pilotoAtivo = false;
    private boolean clientePiloto = false;
    
    /**
     * Construtor
     * 
     * @param 
     */
    public InformacaoPilotoVO() {
        super();
    }

    /**
     * @return the pilotoAtivo
     */
    public boolean isPilotoAtivo() {
        return pilotoAtivo;
    }

    /**
     * @param pilotoAtivo the pilotoAtivo to set
     */
    public void setPilotoAtivo(boolean pilotoAtivo) {
        this.pilotoAtivo = pilotoAtivo;
    }

    /**
     * @return the clientePiloto
     */
    public boolean isClientePiloto() {
        return clientePiloto;
    }

    /**
     * @param clientePiloto the clientePiloto to set
     */
    public void setClientePiloto(boolean clientePiloto) {
        this.clientePiloto = clientePiloto;
    }
    
    public boolean isOperarComLimite() {
        return !isPilotoAtivo() || isClientePiloto();
    }
}
