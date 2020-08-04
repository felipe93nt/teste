/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;

/**
 * Nome: LimitesModalVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class LimitesModalVO {

    private Integer cindcdeconmmoeda = null;
    private Integer cprodtservcoper = null;
    private Integer cprodtservc = null;
    private Long cpssoajurid = null;
    private String cpssoajuriddesc = null;
    private String descrprodtlimite = null;
    private String dvctolimgerc = null;
    private String venclimite = null;
    private String vdispnlimgerc = null;
    private String vutlzdlimgerc = null;
    private Integer ccatlggarntprinc = null;
    private String descrgarntprinc = null;
    private String descrmoeda = null;
    private String pspreadprodt = null;
    private Integer pvctolimgerc = null;
    private Long danosoltcanlse = null;
    private Long nsoltcanlsecredt = null;
    private Long nseqsoltcanlse = null;
    private Long numproposta = null;
    private String descrseg = null;

    // LISTA LIMITE
    private Long ncontrlim = null;

    // LISTA PROPOSTA
    private Long nseqcontrppl = null;

    /** FILTRO */
    private Integer produto = null;
    private Long cunicpssoacmbio = null;
    private Long cpessoa = null;
    private Integer pais = null;
    private CnpjDataType cnpj = null;

    /**
     * @return o valor do cindcdeconmmoeda
     */
    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    /**
     * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
     */
    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }

    /**
     * @return o valor do cprodtservcoper
     */
    public Integer getCprodtservcoper() {
        return cprodtservcoper;
    }

    /**
     * @param cprodtservcoper seta o novo valor para o campo cprodtservcoper
     */
    public void setCprodtservcoper(Integer cprodtservcoper) {
        this.cprodtservcoper = cprodtservcoper;
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
     * @return o valor do cpssoajurid
     */
    public Long getCpssoajurid() {
        return cpssoajurid;
    }

    /**
     * @param cpssoajurid seta o novo valor para o campo cpssoajurid
     */
    public void setCpssoajurid(Long cpssoajurid) {
        this.cpssoajurid = cpssoajurid;
    }

    /**
     * @return o valor do cpssoajuriddesc
     */
    public String getCpssoajuriddesc() {
        return cpssoajuriddesc;
    }

    /**
     * @param cpssoajuriddesc seta o novo valor para o campo cpssoajuriddesc
     */
    public void setCpssoajuriddesc(String cpssoajuriddesc) {
        this.cpssoajuriddesc = cpssoajuriddesc;
    }

    /**
     * @return o valor do descrprodtlimite
     */
    public String getDescrprodtlimite() {
        return descrprodtlimite;
    }

    /**
     * @param descrprodtlimite seta o novo valor para o campo descrprodtlimite
     */
    public void setDescrprodtlimite(String descrprodtlimite) {
        this.descrprodtlimite = descrprodtlimite;
    }

    /**
     * @return o valor do dvctolimgerc
     */
    public String getDvctolimgerc() {
        return dvctolimgerc;
    }

    /**
     * @param dvctolimgerc seta o novo valor para o campo dvctolimgerc
     */
    public void setDvctolimgerc(String dvctolimgerc) {
        this.dvctolimgerc = dvctolimgerc;
    }

    /**
     * @return o valor do venclimite
     */
    public String getVenclimite() {
        return venclimite;
    }

    /**
     * @param venclimite seta o novo valor para o campo venclimite
     */
    public void setVenclimite(String venclimite) {
        this.venclimite = venclimite;
    }

    /**
     * @return o valor do vdispnlimgerc
     */
    public String getVdispnlimgerc() {
        return vdispnlimgerc;
    }

    /**
     * @param vdispnlimgerc seta o novo valor para o campo vdispnlimgerc
     */
    public void setVdispnlimgerc(String vdispnlimgerc) {
        this.vdispnlimgerc = vdispnlimgerc;
    }

    /**
     * @return o valor do vutlzdlimgerc
     */
    public String getVutlzdlimgerc() {
        return vutlzdlimgerc;
    }

    /**
     * @param vutlzdlimgerc seta o novo valor para o campo vutlzdlimgerc
     */
    public void setVutlzdlimgerc(String vutlzdlimgerc) {
        this.vutlzdlimgerc = vutlzdlimgerc;
    }

    /**
     * @return o valor do ccatlggarntprinc
     */
    public Integer getCcatlggarntprinc() {
        return ccatlggarntprinc;
    }

    /**
     * @param ccatlggarntprinc seta o novo valor para o campo ccatlggarntprinc
     */
    public void setCcatlggarntprinc(Integer ccatlggarntprinc) {
        this.ccatlggarntprinc = ccatlggarntprinc;
    }

    /**
     * @return o valor do descrgarntprinc
     */
    public String getDescrgarntprinc() {
        return descrgarntprinc;
    }

    /**
     * @param descrgarntprinc seta o novo valor para o campo descrgarntprinc
     */
    public void setDescrgarntprinc(String descrgarntprinc) {
        this.descrgarntprinc = descrgarntprinc;
    }

    /**
     * @return o valor do descrmoeda
     */
    public String getDescrmoeda() {
        return descrmoeda;
    }

    /**
     * @param descrmoeda seta o novo valor para o campo descrmoeda
     */
    public void setDescrmoeda(String descrmoeda) {
        this.descrmoeda = descrmoeda;
    }

    /**
     * @return o valor do pspreadprodt
     */
    public String getPspreadprodt() {
        return pspreadprodt;
    }

    /**
     * @param pspreadprodt seta o novo valor para o campo pspreadprodt
     */
    public void setPspreadprodt(String pspreadprodt) {
        this.pspreadprodt = pspreadprodt;
    }

    /**
     * @return o valor do pvctolimgerc
     */
    public Integer getPvctolimgerc() {
        return pvctolimgerc;
    }

    /**
     * @param pvctolimgerc seta o novo valor para o campo pvctolimgerc
     */
    public void setPvctolimgerc(Integer pvctolimgerc) {
        this.pvctolimgerc = pvctolimgerc;
    }

    /**
     * @return o valor do danosoltcanlse
     */
    public Long getDanosoltcanlse() {
        return danosoltcanlse;
    }

    /**
     * @param danosoltcanlse seta o novo valor para o campo danosoltcanlse
     */
    public void setDanosoltcanlse(Long danosoltcanlse) {
        this.danosoltcanlse = danosoltcanlse;
    }

    /**
     * @return o valor do nsoltcanlsecredt
     */
    public Long getNsoltcanlsecredt() {
        return nsoltcanlsecredt;
    }

    /**
     * @param nsoltcanlsecredt seta o novo valor para o campo nsoltcanlsecredt
     */
    public void setNsoltcanlsecredt(Long nsoltcanlsecredt) {
        this.nsoltcanlsecredt = nsoltcanlsecredt;
    }

    /**
     * @return o valor do nseqsoltcanlse
     */
    public Long getNseqsoltcanlse() {
        return nseqsoltcanlse;
    }

    /**
     * @param nseqsoltcanlse seta o novo valor para o campo nseqsoltcanlse
     */
    public void setNseqsoltcanlse(Long nseqsoltcanlse) {
        this.nseqsoltcanlse = nseqsoltcanlse;
    }

    /**
     * @return o valor do numproposta
     */
    public Long getNumproposta() {
        return numproposta;
    }

    /**
     * @param numproposta seta o novo valor para o campo numproposta
     */
    public void setNumproposta(Long numproposta) {
        this.numproposta = numproposta;
    }

    /**
     * @return o valor do descrseg
     */
    public String getDescrseg() {
        return descrseg;
    }

    /**
     * @param descrseg seta o novo valor para o campo descrseg
     */
    public void setDescrseg(String descrseg) {
        this.descrseg = descrseg;
    }

    /**
     * @return o valor do nseqcontrppl
     */
    public Long getNseqcontrppl() {
        return nseqcontrppl;
    }

    /**
     * @param nseqcontrppl seta o novo valor para o campo nseqcontrppl
     */
    public void setNseqcontrppl(Long nseqcontrppl) {
        this.nseqcontrppl = nseqcontrppl;
    }

    /**
     * @return o valor do ncontrlim
     */
    public Long getNcontrlim() {
        return ncontrlim;
    }

    /**
     * @param ncontrlim seta o novo valor para o campo ncontrlim
     */
    public void setNcontrlim(Long ncontrlim) {
        this.ncontrlim = ncontrlim;
    }

    /**
     * @return o valor do produto
     */
    public Integer getProduto() {
        return produto;
    }

    /**
     * @param produto seta o novo valor para o campo produto
     */
    public void setProduto(Integer produto) {
        this.produto = produto;
    }

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
     * @return o valor do cpessoa
     */
    public Long getCpessoa() {
        return cpessoa;
    }

    /**
     * @param cpessoa seta o novo valor para o campo cpessoa
     */
    public void setCpessoa(Long cpessoa) {
        this.cpessoa = cpessoa;
    }

    /**
     * @return o valor do pais
     */
    public Integer getPais() {
        return pais;
    }

    /**
     * @param pais seta o novo valor para o campo pais
     */
    public void setPais(Integer pais) {
        this.pais = pais;
    }

    /**
     * @return o valor do cnpj
     */
    public CnpjDataType getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj seta o novo valor para o campo cnpj
     */
    public void setCnpj(CnpjDataType cnpj) {
        this.cnpj = cnpj;
    }

}
