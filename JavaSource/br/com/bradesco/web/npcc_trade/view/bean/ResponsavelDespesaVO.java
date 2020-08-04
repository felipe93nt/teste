package br.com.bradesco.web.npcc_trade.view.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;

/**
  * Nome: ResponsavelDespesaVO.java
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
  * Registro  de Manutenção: 12/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ResponsavelDespesaVO {
    
    /** Codigo IdentificadorPessoa **/
    private Long cunicpssoacmbio = 0L;

    /** Descricao IdentificadorPessoa **/
    private String cunicpssoadesc = null;
    
    /** CODIGO DO BANCO INDICADO **/
    private Long cunicpssoabnf = 0L;
    
    /** CODIGO DO AFIANÇADO **/
    private Long cunicpssoaafi = 0L;
    
    /** QUANTIDADES DE OCORRENCIAS **/
    private String dlimfndngcmbio = null;
    
    /** DESCRIÇÃO DO MUNICIPIO **/
    private String cunicpssoaimun = null;
    
   private List<ListaResponsavelDespesaVO> listaDespesa = new ArrayList<ListaResponsavelDespesaVO>();

/**
 * @return o valor do cunicpssoacmbio
 */
public Long getCunicpssoacmbio() {
    return cunicpssoacmbio;
}

/**
 * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
 */
public void setCunicpssoacmbio(Long cunicpssoacmbio) {
    this.cunicpssoacmbio = cunicpssoacmbio;
}

/**
 * @return o valor do cunicpssoadesc
 */
public String getCunicpssoadesc() {
    return cunicpssoadesc;
}

/**
 * @param cunicpssoadesc seta o novo valor para o campo cunicpssoadesc
 */
public void setCunicpssoadesc(String cunicpssoadesc) {
    this.cunicpssoadesc = cunicpssoadesc;
}

/**
 * @return o valor do cunicpssoabnf
 */
public Long getCunicpssoabnf() {
    return cunicpssoabnf;
}

/**
 * @param cunicpssoabnf seta o novo valor para o campo cunicpssoabnf
 */
public void setCunicpssoabnf(Long cunicpssoabnf) {
    this.cunicpssoabnf = cunicpssoabnf;
}

/**
 * @return o valor do cunicpssoaafi
 */
public Long getCunicpssoaafi() {
    return cunicpssoaafi;
}

/**
 * @param cunicpssoaafi seta o novo valor para o campo cunicpssoaafi
 */
public void setCunicpssoaafi(Long cunicpssoaafi) {
    this.cunicpssoaafi = cunicpssoaafi;
}

/**
 * @return o valor do dlimfndngcmbio
 */
public String getDlimfndngcmbio() {
    return dlimfndngcmbio;
}

/**
 * @param dlimfndngcmbio seta o novo valor para o campo dlimfndngcmbio
 */
public void setDlimfndngcmbio(String dlimfndngcmbio) {
    this.dlimfndngcmbio = dlimfndngcmbio;
}

/**
 * @return o valor do listaDespesa
 */
public List<ListaResponsavelDespesaVO> getListaDespesa() {
    return listaDespesa;
}

/**
 * @param listaDespesa seta o novo valor para o campo listaDespesa
 */
public void setListaDespesa(List<ListaResponsavelDespesaVO> listaDespesa) {
    this.listaDespesa = listaDespesa;
}

public String getCunicpssoaimun() {
    return cunicpssoaimun;
}

public void setCunicpssoaimun(String cunicpssoaimun) {
    this.cunicpssoaimun = cunicpssoaimun;
}
    
   

}
