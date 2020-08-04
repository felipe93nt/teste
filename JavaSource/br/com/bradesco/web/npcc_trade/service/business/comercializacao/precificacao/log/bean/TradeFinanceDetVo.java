/**
 *
 * Nome: TradeFinanceDetVo.java
 * Propï¿½sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 30/12/2015
 *  - Autor: BRQ
 *  - Responsavel: Equipe Web
 *  _ Ajuste para deixar no padrï¿½o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean;

import java.util.ArrayList;
import java.util.List;


/**
  * Nome: TradeFinanceDetVo.java
  * 
  * PropÃ³sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilaÃ§Ã£o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de ManutenÃ§Ã£o: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrÃ£o hexavision.
*/
public class TradeFinanceDetVo {
    
    /** CODIGO SITUACAO DO BOLETO **/
    private Integer csitbletocmbio = 0;

    /** DESCRICAO SITUACAO DO BOLETO **/
    private String dsitbletocmbio = null;

    /** DATA DA COTACAO **/
    private String dtcotacao = null;

    /** HORARIO DA INCLUSAO DA COTACAO **/
    private String horario = null;

    /** CODIGO UNICO DO CLIENTE **/
    private Long cunicclicmbio = 0L;

    /** NOME DO CLIENTE **/
    private String ncunicclicmbio = null;

    /** CODIGO DO PRODUTO/ SERVICO **/
    private Integer cprodtservc = 0;

    /** DESCRICAO DO PRODUTO **/
    private String dprodtservc = null;

    /** VALOR DA MOEDA ESTRANGEIRA **/
    private String vnegocmoedaestrg = null;

    /** CODIGO OPERADOR **/
    private String cusuarinclt = null;

    /** NOME DO OPERADOR **/
    private String nusuarinclt = null;

    /** FUNCAO DA OPERACAO **/
    private String cindcdtpomanut = null;

    /** DESCRICAO DA FUNCAO **/
    private String funcao = null;

    /** NUMERO DO BOLETO MESA TRADE **/
    private Long nbletonegoccmbio = 0L;
    
    /** CODIGO DA MODALIDADE **/
    private Integer cmodldprodtcmbio = 0;
    
    /** DESCRICAO DA MODALIDADE **/
    private String cmodldprodtdesc = null;
    
    /** HORA DA INCLUSAO DO HISTORICO **/
    private String hinclreghist = null;
    
    
    /** LISTAR HISTORICO DE TARIFAS **/
    private List<ListaHistoricoTarifaVO> historicoTarifaList = new ArrayList<ListaHistoricoTarifaVO>();

    /**
     * @return o valor do csitbletocmbio
     */
    public Integer getCsitbletocmbio() {
        return csitbletocmbio;
    }

    /**
     * @param csitbletocmbio seta o novo valor para o campo csitbletocmbio
     */
    public void setCsitbletocmbio(Integer csitbletocmbio) {
        this.csitbletocmbio = csitbletocmbio;
    }

    /**
     * @return o valor do dsitbletocmbio
     */
    public String getDsitbletocmbio() {
        return dsitbletocmbio;
    }

    /**
     * @param dsitbletocmbio seta o novo valor para o campo dsitbletocmbio
     */
    public void setDsitbletocmbio(String dsitbletocmbio) {
        this.dsitbletocmbio = dsitbletocmbio;
    }

    /**
     * @return o valor do dtcotacao
     */
    public String getDtcotacao() {
        return dtcotacao;
    }

    /**
     * @param dtcotacao seta o novo valor para o campo dtcotacao
     */
    public void setDtcotacao(String dtcotacao) {
        this.dtcotacao = dtcotacao;
    }

    /**
     * @return o valor do horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario seta o novo valor para o campo horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    /**
     * @return o valor do ncunicclicmbio
     */
    public String getNcunicclicmbio() {
        return ncunicclicmbio;
    }

    /**
     * @param ncunicclicmbio seta o novo valor para o campo ncunicclicmbio
     */
    public void setNcunicclicmbio(String ncunicclicmbio) {
        this.ncunicclicmbio = ncunicclicmbio;
    }

    /**
     * @return o valor do cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }

    /**
     * @param cprodtservc seta o novo valor para o campo cprodtservc
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    /**
     * @return o valor do dprodtservc
     */
    public String getDprodtservc() {
        return dprodtservc;
    }

    /**
     * @param dprodtservc seta o novo valor para o campo dprodtservc
     */
    public void setDprodtservc(String dprodtservc) {
        this.dprodtservc = dprodtservc;
    }

    /**
     * @return o valor do vnegocmoedaestrg
     */
    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    /**
     * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
     */
    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    /**
     * @return o valor do cusuarinclt
     */
    public String getCusuarinclt() {
        return cusuarinclt;
    }

    /**
     * @param cusuarinclt seta o novo valor para o campo cusuarinclt
     */
    public void setCusuarinclt(String cusuarinclt) {
        this.cusuarinclt = cusuarinclt;
    }

    /**
     * @return o valor do nusuarinclt
     */
    public String getNusuarinclt() {
        return nusuarinclt;
    }

    /**
     * @param nusuarinclt seta o novo valor para o campo nusuarinclt
     */
    public void setNusuarinclt(String nusuarinclt) {
        this.nusuarinclt = nusuarinclt;
    }

    /**
     * @return o valor do cindcdtpomanut
     */
    public String getCindcdtpomanut() {
        return cindcdtpomanut;
    }

    /**
     * @param cindcdtpomanut seta o novo valor para o campo cindcdtpomanut
     */
    public void setCindcdtpomanut(String cindcdtpomanut) {
        this.cindcdtpomanut = cindcdtpomanut;
    }

    /**
     * @return o valor do funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao seta o novo valor para o campo funcao
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do cmodldprodtcmbio
     */
    public Integer getCmodldprodtcmbio() {
        return cmodldprodtcmbio;
    }

    /**
     * @param cmodldprodtcmbio seta o novo valor para o campo cmodldprodtcmbio
     */
    public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
        this.cmodldprodtcmbio = cmodldprodtcmbio;
    }

    /**
     * @return o valor do cmodldprodtdesc
     */
    public String getCmodldprodtdesc() {
        return cmodldprodtdesc;
    }

    /**
     * @param cmodldprodtdesc seta o novo valor para o campo cmodldprodtdesc
     */
    public void setCmodldprodtdesc(String cmodldprodtdesc) {
        this.cmodldprodtdesc = cmodldprodtdesc;
    }

    /**
     * @return o valor do historicoTarifaList
     */
    public List<ListaHistoricoTarifaVO> getHistoricoTarifaList() {
        return historicoTarifaList;
    }

    /**
     * @param historicoTarifaList seta o novo valor para o campo historicoTarifaList
     */
    public void setHistoricoTarifaList(List<ListaHistoricoTarifaVO> historicoTarifaList) {
        this.historicoTarifaList = historicoTarifaList;
    }

    /**
     * @return o valor do hinclreghist
     */
    public String getHinclreghist() {
        return hinclreghist;
    }

    /**
     * @param hinclreghist seta o novo valor para o campo hinclreghist
     */
    public void setHinclreghist(String hinclreghist) {
        this.hinclreghist = hinclreghist;
    }
}
