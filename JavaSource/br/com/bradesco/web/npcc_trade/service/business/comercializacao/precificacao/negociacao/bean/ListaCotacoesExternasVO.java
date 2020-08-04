package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.List;



/**
  * Nome: ListaCotacoesExternas.java
  * 
  * PropÛsito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilaÁ„o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de ManutenÁ„o: 10/06/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr„o hexavision.
*/
public class ListaCotacoesExternasVO {
    
    /** CODIGO DO FUNDING **/
    private Long cfndng = 0L;

    /** CODIGO BANQ. FINANCIADOR **/
    private Long cbanqrcmbiofndng = 0L;
    
    /** DESCR. BANQ. FINANCIADOR **/
    private String nbanqrcmbiofndng = null;
    
    /** CODIGO BANQ. REEMBOLSADOR **/
    private Long cbanqrcmbiorcdor = 0L;

    /** DESCR. BANQ. REEMBOLSADOR **/
    private String nbanqrcmbiorcdor = null;

    /** CODIGO CONFIRMADOR**/
    private Long cbanqrcmbioaviso = 0L;

    /** DESC CONFIRMADOR **/
    private String nbanqrcmbioaviso = null;
   
    /** DATA DA COTAÁAO **/
    private String dcotacfndngcmbio = null;

    /** VALIDADE DA COTAÁAO **/
    private String dlimfndngcmbio = null;

    /** STATUS DA COTAÁAO **/
    private String cindcdfndngutlzd = null;
    
    private String formataStatusCtc = null;

    /** DESCR. STATUS COTAÁAO **/
    private String nindcdfndngutlzd = null;

    /** CONTATO DIV. INTERN. **/
    private String cusuarmanut = null;

    /** CONTATO DIV. INTERN. **/
    private String nusuarmanut = null;
    
    /** CODIGO USUARIO DA SESSAO **/
    private String cusuariosess = null;
    
    /** DESCRI«√O USUARIO DA SESSAO **/
    private String nusuariosess = null;

    /** PERCENTUAL TAXA FIXA **/
    private String ptxfixacmbio = null;

    /** CODIGO DA MOEDA LIBOR **/
    private Integer cindcdeconmmoelib = 0;

    /** QUANT. DIAS OPERA«√O CMBIO **/
    private Integer tdiaopercmbio = 0;

    /** QUANT. MESES LIBOR **/
    private Integer tmesliborcmbio = 0;

    /** VALOR TAXA LIBOR **/
    private String vtxliborcmbio = null;
    
    /** NUMERO DO BOLETO NEGOCIO **/
    private Long nbletonegoccmbio = 0L;

    /**
     * INDICADOR DO PROCESSAMENTO         
     * FLAG QUANDO INSER«√O (I)          
     * FLAG QUANDO ALTERA«√O (A)  
     */
    private String flagproc = null;

    /** STATUS DA COTAÁ„O **/
    private String cindcdfndngutl = null;

    /** QUANTIDADE DE DESPESAS **/
    private Integer qtdedsp = 0;

    /** Lista de despesas de Funding **/
    private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    
    /** CODIGO BANQ. **/
    private Long cbanqrcmbio = 0L;

    /** DESCR. BANQ. **/
    private String nbanqrcmbio = null;
    
    /** CODIGO DA PRA«A **/
    private Long cmunintlcmbio = 0L;
    
    /** DESCRICAO DO PRA«A **/
    private String imunintlcmbio;
    
    /** DESCRICAO DO PAIS **/
    private String ipais;
    
    
    /** CODIGO DO PAIS **/
    private Integer cpais = 0;
    
    /** CODIGO BANQ SWIFT **/
    private String cidbanqrswift;
    
    /** CODIGO DO STATUS DA COTACAO **/
    private String cindcdfndgttlzd;
    
    /**
     * VALOR DO PERIODO DA TAXA
     */
    private String nbasebletonegoc = null;
    
    private String pracacmbiofndmg = null;
     
    private String pracacmbiorcdor =  null;
    
    private String pracacmbioaviso = null;
    
    
    public String getPracacmbiofndmg() {
        return pracacmbiofndmg;
    }

    public void setPracacmbiofndmg(String pracacmbiofndmg) {
        this.pracacmbiofndmg = pracacmbiofndmg;
    }

    public String getPracacmbiorcdor() {
        return pracacmbiorcdor;
    }

    public void setPracacmbiorcdor(String pracacmbiorcdor) {
        this.pracacmbiorcdor = pracacmbiorcdor;
    }

    public String getPracacmbioaviso() {
        return pracacmbioaviso;
    }

    public void setPracacmbioaviso(String pracacmbioaviso) {
        this.pracacmbioaviso = pracacmbioaviso;
    }

    /**
     * @return o valor do cfndng
     */
    
    public Long getCfndng() {
        return cfndng;
    }

    /**
     * @param cfndng seta o novo valor para o campo cfndng
     */
    public void setCfndng(Long cfndng) {
        this.cfndng = cfndng;
    }

    /**
     * @return o valor do cbanqrcmbiofndng
     */
    public Long getCbanqrcmbiofndng() {
        return cbanqrcmbiofndng;
    }

    /**
     * @param cbanqrcmbiofndng seta o novo valor para o campo cbanqrcmbiofndng
     */
    public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
        this.cbanqrcmbiofndng = cbanqrcmbiofndng;
    }

    /**
     * @return o valor do nbanqrcmbiofndng
     */
    public String getNbanqrcmbiofndng() {
        return nbanqrcmbiofndng;
    }

    /**
     * @param nbanqrcmbiofndng seta o novo valor para o campo nbanqrcmbiofndng
     */
    public void setNbanqrcmbiofndng(String nbanqrcmbiofndng) {
        this.nbanqrcmbiofndng = nbanqrcmbiofndng;
    }

    /**
     * @return o valor do cbanqrcmbiorcdor
     */
    public Long getCbanqrcmbiorcdor() {
        return cbanqrcmbiorcdor;
    }

    /**
     * @param cbanqrcmbiorcdor seta o novo valor para o campo cbanqrcmbiorcdor
     */
    public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
        this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
    }

    /**
     * @return o valor do nbanqrcmbiorcdor
     */
    public String getNbanqrcmbiorcdor() {
        return nbanqrcmbiorcdor;
    }

    /**
     * @param nbanqrcmbiorcdor seta o novo valor para o campo nbanqrcmbiorcdor
     */
    public void setNbanqrcmbiorcdor(String nbanqrcmbiorcdor) {
        this.nbanqrcmbiorcdor = nbanqrcmbiorcdor;
    }

    /**
     * @return o valor do cbanqrcmbioaviso
     */
    public Long getCbanqrcmbioaviso() {
        return cbanqrcmbioaviso;
    }

    /**
     * @param cbanqrcmbioaviso seta o novo valor para o campo cbanqrcmbioaviso
     */
    public void setCbanqrcmbioaviso(Long cbanqrcmbioaviso) {
        this.cbanqrcmbioaviso = cbanqrcmbioaviso;
    }

    /**
     * @return o valor do nbanqrcmbioaviso
     */
    public String getNbanqrcmbioaviso() {
        return nbanqrcmbioaviso;
    }

    /**
     * @param nbanqrcmbioaviso seta o novo valor para o campo nbanqrcmbioaviso
     */
    public void setNbanqrcmbioaviso(String nbanqrcmbioaviso) {
        this.nbanqrcmbioaviso = nbanqrcmbioaviso;
    }

    /**
     * @return o valor do dcotacfndngcmbio
     */
    public String getDcotacfndngcmbio() {
        return dcotacfndngcmbio;
    }

    /**
     * @param dcotacfndngcmbio seta o novo valor para o campo dcotacfndngcmbio
     */
    public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
        this.dcotacfndngcmbio = dcotacfndngcmbio;
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
     * @return o valor do cindcdfndngutlzd
     */
    public String getCindcdfndngutlzd() {
        return cindcdfndngutlzd;
    }

    /**
     * @param cindcdfndngutlzd seta o novo valor para o campo cindcdfndngutlzd
     */
    public void setCindcdfndngutlzd(String cindcdfndngutlzd) {
        this.cindcdfndngutlzd = cindcdfndngutlzd;
    }

    /**
     * @return o valor do nindcdfndngutlzd
     */
    public String getNindcdfndngutlzd() {
        return nindcdfndngutlzd;
    }

    /**
     * @param nindcdfndngutlzd seta o novo valor para o campo nindcdfndngutlzd
     */
    public void setNindcdfndngutlzd(String nindcdfndngutlzd) {
        this.nindcdfndngutlzd = nindcdfndngutlzd;
    }

    /**
     * @return o valor do cusuarmanut
     */
    public String getCusuarmanut() {
        return cusuarmanut;
    }

    /**
     * @param cusuarmanut seta o novo valor para o campo cusuarmanut
     */
    public void setCusuarmanut(String cusuarmanut) {
        this.cusuarmanut = cusuarmanut;
    }

    /**
     * @return o valor do nusuarmanut
     */
    public String getNusuarmanut() {
        return nusuarmanut;
    }

    /**
     * @param nusuarmanut seta o novo valor para o campo nusuarmanut
     */
    public void setNusuarmanut(String nusuarmanut) {
        this.nusuarmanut = nusuarmanut;
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

    /**
     * @return o valor do ptxfixacmbio
     */
    public String getPtxfixacmbio() {
        return ptxfixacmbio;
    }

    /**
     * @param ptxfixacmbio seta o novo valor para o campo ptxfixacmbio
     */
    public void setPtxfixacmbio(String ptxfixacmbio) {
        this.ptxfixacmbio = ptxfixacmbio;
    }

    /**
     * @return o valor do cindcdeconmmoelib
     */
    public Integer getCindcdeconmmoelib() {
        return cindcdeconmmoelib;
    }

    /**
     * @param cindcdeconmmoelib seta o novo valor para o campo cindcdeconmmoelib
     */
    public void setCindcdeconmmoelib(Integer cindcdeconmmoelib) {
        this.cindcdeconmmoelib = cindcdeconmmoelib;
    }

    /**
     * @return o valor do tdiaopercmbio
     */
    public Integer getTdiaopercmbio() {
        return tdiaopercmbio;
    }

    /**
     * @param tdiaopercmbio seta o novo valor para o campo tdiaopercmbio
     */
    public void setTdiaopercmbio(Integer tdiaopercmbio) {
        this.tdiaopercmbio = tdiaopercmbio;
    }

    /**
     * @return o valor do tmesliborcmbio
     */
    public Integer getTmesliborcmbio() {
        return tmesliborcmbio;
    }

    /**
     * @param tmesliborcmbio seta o novo valor para o campo tmesliborcmbio
     */
    public void setTmesliborcmbio(Integer tmesliborcmbio) {
        this.tmesliborcmbio = tmesliborcmbio;
    }

    /**
     * @return o valor do vtxliborcmbio
     */
    public String getVtxliborcmbio() {
        return vtxliborcmbio;
    }

    /**
     * @param vtxliborcmbio seta o novo valor para o campo vtxliborcmbio
     */
    public void setVtxliborcmbio(String vtxliborcmbio) {
        this.vtxliborcmbio = vtxliborcmbio;
    }

    /**
     * @return o valor do listaDespesas
     */
    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }

    /**
     * @param listaDespesas seta o novo valor para o campo listaDespesas
     */
    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    public Long getCbanqrcmbio() {
        return cbanqrcmbio;
    }

    public void setCbanqrcmbio(Long cbanqrcmbio) {
        this.cbanqrcmbio = cbanqrcmbio;
    }

    public String getNbanqrcmbio() {
        return nbanqrcmbio;
    }

    public void setNbanqrcmbio(String nbanqrcmbio) {
        this.nbanqrcmbio = nbanqrcmbio;
    }

    public String getImunintlcmbio() {
        return imunintlcmbio;
    }

    public void setImunintlcmbio(String imunintlcmbio) {
        this.imunintlcmbio = imunintlcmbio;
    }

    public String getIpais() {
        return ipais;
    }

    public void setIpais(String ipais) {
        this.ipais = ipais;
    }

    public Integer getCpais() {
        return cpais;
    }

    public void setCpais(Integer cpais) {
        this.cpais = cpais;
    }

    public String getCidbanqrswift() {
        return cidbanqrswift;
    }

    public void setCidbanqrswift(String cidbanqrswift) {
        this.cidbanqrswift = cidbanqrswift;
    }

    public String getCindcdfndgttlzd() {
        return cindcdfndgttlzd;
    }

    public void setCindcdfndgttlzd(String cindcdfndgttlzd) {
        this.cindcdfndgttlzd = cindcdfndgttlzd;
    }

    public Long getCmunintlcmbio() {
        return cmunintlcmbio;
    }

    public void setCmunintlcmbio(Long cmunintlcmbio) {
        this.cmunintlcmbio = cmunintlcmbio;
    }

    public String getFormataStatusCtc() {
        return formataStatusCtc;
    }

    public void setFormataStatusCtc(String formataStatusCtc) {
        this.formataStatusCtc = formataStatusCtc;
    }

    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    public String getFlagproc() {
        return flagproc;
    }

    public void setFlagproc(String flagproc) {
        this.flagproc = flagproc;
    }

    public String getCindcdfndngutl() {
        return cindcdfndngutl;
    }

    public void setCindcdfndngutl(String cindcdfndngutl) {
        this.cindcdfndngutl = cindcdfndngutl;
    }

    public Integer getQtdedsp() {
        return qtdedsp;
    }

    public void setQtdedsp(Integer qtdedsp) {
        this.qtdedsp = qtdedsp;
    }

    /**
     * @return the nbasebletonegoc
     */
    public String getNbasebletonegoc() {
        return nbasebletonegoc;
    }

    /**
     * @param nbasebletonegoc the nbasebletonegoc to set
     */
    public void setNbasebletonegoc(String nbasebletonegoc) {
        this.nbasebletonegoc = nbasebletonegoc;
    }
    
}
