package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.List;





/**
  * Nome: ListaResponsavelDespesaVO.java
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
public class ListaResponsavelDespesaVO {
    /** CODIGO BANQ. **/
    private Long cbanqrcmbio = 0L;

    /** DESCR. BANQ. **/
    private String nbanqrcmbio = null;

    /** FUNçãO **/
    private String nfuncresp = null;

    /** PRACA **/
    private String imunindcmbio = null;
    
    /** CODIGO PAIS  **/
    private Integer cpais = 0;
    
    /** PAIS **/
    private String ipais = null;

    /** CODIGO SWIFT   **/
    private String cidbanqrswift = null;
    
    /** codigo indentificador Funding utilizado **/
    private String cindcdfndngutlzd = null;

    /** desc indentificador Funding utilizado **/
    private String nindcdfndngutlzd = null;
    
    /** codigo funding **/
    private Long cfndng = 0L;

    /** DESCRIÇÃO DO BENEFICIARIO **/
    private String cunicpssoadbnf = null;
    
    /** PAIS **/
    private String ipaisbnf = null;

    /** CIDADE DO BENEFICIARIO **/
    private String iciddbnf = null;

    /** ENDEREÇO BENEFICIARIO **/
    private String logrdbnf = null;

    /** DESCRIÇÃO DO AFIANÇADO **/
    private String cunicpssoadafi = null;

    /** PAIS DO AFIANÇADO **/
    private String ipaisafi = null;

    /** CIDADE DO AFIANÇADO  **/
    private String iciddafi = null;
    
    /** ENDEREÇO AFIANÇADO  **/
    private String logrdafi = null;
    
    /** CODIGO DA FUNCAO FUNDING **/
    private Integer cbanqrcmbiofndg = 0;
    
    /** CODIGO DA FUNCAO CONFIRMADOR **/
    private Integer cbanqrcmbiorcdor = 0;
    
    /** CODIGO DA FUNCAO AVISADOR **/
    private Integer cbanqrcmbioaviso = 0;
    
    /** CODIGO DA PRAÇA **/
    private Long cmunintlcmbio = 0L;
    
    /** DESCRICAO DO PRAÇA **/
    private String imunintlcmbio;
    
    /** CODIGO DO STATUS DA COTACAO **/
    private String cindcdfndgttlzd;
    
    /** DESCRICAO DO STATUS DA COTACAO **/
    private String nindcdfndgttlzd;
    
    /** DATA DA COTACAO **/
    private String dcotacfndngcmbio;
    
    /** CÓDIGO DA FUNCÃO SELECIONADA **/
    private Integer Cfuncao;

	private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    
    /**
     * @return o valor do cbanqrcmbio
     */
    public Long getCbanqrcmbio() {
        return cbanqrcmbio;
    }

    /**
     * @param cbanqrcmbio seta o novo valor para o campo cbanqrcmbio
     */
    public void setCbanqrcmbio(Long cbanqrcmbio) {
        this.cbanqrcmbio = cbanqrcmbio;
    }

    /**
     * @return o valor do nbanqrcmbio
     */
    public String getNbanqrcmbio() {
        return nbanqrcmbio;
    }

    /**
     * @param nbanqrcmbio seta o novo valor para o campo nbanqrcmbio
     */
    public void setNbanqrcmbio(String nbanqrcmbio) {
        this.nbanqrcmbio = nbanqrcmbio;
    }

    /**
     * @return o valor do nfuncresp
     */
    public String getNfuncresp() {
        return nfuncresp;
    }

    /**
     * @param nfuncresp seta o novo valor para o campo nfuncresp
     */
    public void setNfuncresp(String nfuncresp) {
        this.nfuncresp = nfuncresp;
    }

    /**
     * @return o valor do imunindcmbio
     */
    public String getImunindcmbio() {
        return imunindcmbio;
    }

    /**
     * @param imunindcmbio seta o novo valor para o campo imunindcmbio
     */
    public void setImunindcmbio(String imunindcmbio) {
        this.imunindcmbio = imunindcmbio;
    }

    /**
     * @return o valor do ipais
     */
    public String getIpais() {
        return ipais;
    }

    /**
     * @param ipais seta o novo valor para o campo ipais
     */
    public void setIpais(String ipais) {
        this.ipais = ipais;
    }

    /**
     * @return o valor do cidbanqrswift
     */
    public String getCidbanqrswift() {
        return cidbanqrswift;
    }

    /**
     * @param cidbanqrswift seta o novo valor para o campo cidbanqrswift
     */
    public void setCidbanqrswift(String cidbanqrswift) {
        this.cidbanqrswift = cidbanqrswift;
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
     * @return o valor do cunicpssoadbnf
     */
    public String getCunicpssoadbnf() {
        return cunicpssoadbnf;
    }

    /**
     * @param cunicpssoadbnf seta o novo valor para o campo cunicpssoadbnf
     */
    public void setCunicpssoadbnf(String cunicpssoadbnf) {
        this.cunicpssoadbnf = cunicpssoadbnf;
    }

    /**
     * @return o valor do ipaisbnf
     */
    public String getIpaisbnf() {
        return ipaisbnf;
    }

    /**
     * @param ipaisbnf seta o novo valor para o campo ipaisbnf
     */
    public void setIpaisbnf(String ipaisbnf) {
        this.ipaisbnf = ipaisbnf;
    }

    /**
     * @return o valor do iciddbnf
     */
    public String getIciddbnf() {
        return iciddbnf;
    }

    /**
     * @param iciddbnf seta o novo valor para o campo iciddbnf
     */
    public void setIciddbnf(String iciddbnf) {
        this.iciddbnf = iciddbnf;
    }

    /**
     * @return o valor do logrdbnf
     */
    public String getLogrdbnf() {
        return logrdbnf;
    }

    /**
     * @param logrdbnf seta o novo valor para o campo logrdbnf
     */
    public void setLogrdbnf(String logrdbnf) {
        this.logrdbnf = logrdbnf;
    }

    /**
     * @return o valor do cunicpssoadafi
     */
    public String getCunicpssoadafi() {
        return cunicpssoadafi;
    }

    /**
     * @param cunicpssoadafi seta o novo valor para o campo cunicpssoadafi
     */
    public void setCunicpssoadafi(String cunicpssoadafi) {
        this.cunicpssoadafi = cunicpssoadafi;
    }

    /**
     * @return o valor do ipaisafi
     */
    public String getIpaisafi() {
        return ipaisafi;
    }

    /**
     * @param ipaisafi seta o novo valor para o campo ipaisafi
     */
    public void setIpaisafi(String ipaisafi) {
        this.ipaisafi = ipaisafi;
    }

    /**
     * @return o valor do iciddafi
     */
    public String getIciddafi() {
        return iciddafi;
    }

    /**
     * @param iciddafi seta o novo valor para o campo iciddafi
     */
    public void setIciddafi(String iciddafi) {
        this.iciddafi = iciddafi;
    }

    /**
     * @return o valor do logrdafi
     */
    public String getLogrdafi() {
        return logrdafi;
    }

    /**
     * @param logrdafi seta o novo valor para o campo logrdafi
     */
    public void setLogrdafi(String logrdafi) {
        this.logrdafi = logrdafi;
    }

    public Integer getCbanqrcmbiofndg() {
        return cbanqrcmbiofndg;
    }

    public void setCbanqrcmbiofndg(Integer cbanqrcmbiofndg) {
        this.cbanqrcmbiofndg = cbanqrcmbiofndg;
    }

    public String getImunintlcmbio() {
        return imunintlcmbio;
    }

    public void setImunintlcmbio(String imunintlcmbio) {
        this.imunintlcmbio = imunintlcmbio;
    }

    public Long getCmunintlcmbio() {
        return cmunintlcmbio;
    }

    public void setCmunintlcmbio(Long cmunintlcmbio) {
        this.cmunintlcmbio = cmunintlcmbio;
    }

    public Integer getCpais() {
        return cpais;
    }

    public void setCpais(Integer cpais) {
        this.cpais = cpais;
    }

    public String getCindcdfndgttlzd() {
        return cindcdfndgttlzd;
    }

    public void setCindcdfndgttlzd(String cindcdfndgttlzd) {
        this.cindcdfndgttlzd = cindcdfndgttlzd;
    }

    public String getNindcdfndgttlzd() {
        return nindcdfndgttlzd;
    }

    public void setNindcdfndgttlzd(String nindcdfndgttlzd) {
        this.nindcdfndgttlzd = nindcdfndgttlzd;
    }

    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }

    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    public String getDcotacfndngcmbio() {
        return dcotacfndngcmbio;
    }

    public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
        this.dcotacfndngcmbio = dcotacfndngcmbio;
    }

    public Integer getCbanqrcmbiorcdor() {
        return cbanqrcmbiorcdor;
    }

    public void setCbanqrcmbiorcdor(Integer cbanqrcmbiorcdor) {
        this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
    }

    public Integer getCbanqrcmbioaviso() {
        return cbanqrcmbioaviso;
    }

    public void setCbanqrcmbioaviso(Integer cbanqrcmbioaviso) {
        this.cbanqrcmbioaviso = cbanqrcmbioaviso;
    }
    
    public Integer getCfuncao() {
		return Cfuncao;
	}

	public void setCfuncao(Integer cfuncao) {
		Cfuncao = cfuncao;
	}

}
