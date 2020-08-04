package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.List;



/**
  * Nome: ListaCotacoesExternas.java
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
  * Registro  de Manutenção: 10/06/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class CotacoesExternasVO {
    
    /** CODIGO USUARIO DA SESSAO **/
    private String cusuariosess = null;
    
    /** DESCRIÇÃO USUARIO DA SESSAO **/
    private String nusuariosess = null;
    
    /** Lista Cotações **/
    private List<ListaCotacoesExternasVO> listaCotacoes = new ArrayList<ListaCotacoesExternasVO>();
    
   
    /**
     * @return o valor do listaCotacoes
     */
    public List<ListaCotacoesExternasVO> getListaCotacoes() {
        return listaCotacoes;
    }

    /**
     * @param listaCotacoes seta o novo valor para o campo listaCotacoes
     */
    public void setListaCotacoes(List<ListaCotacoesExternasVO> listaCotacoes) {
        this.listaCotacoes = listaCotacoes;
    }

    /**
     * @return o valor do cusuariosess
     */
    public String getCusuariosess() {
        return cusuariosess;
    }

    /**
     * @param cusuariosess seta o novo valor para o campo cusuariosess
     */
    public void setCusuariosess(String cusuariosess) {
        this.cusuariosess = cusuariosess;
    }

    /**
     * @return o valor do nusuariosess
     */
    public String getNusuariosess() {
        return nusuariosess;
    }

    /**
     * @param nusuariosess seta o novo valor para o campo nusuariosess
     */
    public void setNusuariosess(String nusuariosess) {
        this.nusuariosess = nusuariosess;
    }
}
