/**
*
* Nome: ComissaoVO.java
* Propósito: <p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 25/04/2016
*   - Autor: BRQ
*   - Responsavel: Equipe Web
*   _ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.tradeFinance.bean;

import java.util.List;

/**
*
* Nome: ComissaoVO.java
* Propósito: <p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 25/04/2016
*  - Autor: BRQ
*  - Responsavel: Equipe Web
*  _ Ajuste para deixar no padrão hexavision.
*/
public class ComissaoVO {
        
    /**
     * NUMERO DA COMISSAO INTERNA
     */
    private Integer ncomisintrncmbio;
    
    /**
     * NUMERO DA COMISSAO EXTERNA
     */
    private Integer ncomisextertrade = 0;
    
    /**
     * CODIGO DA PERIODICIDADE
     */
    private Integer cfluxoperdccmbio;
    
    /**
     * DESCRICAO DA PERIODICIDADE
     */
    private String ifluxoperdccmbio;
    
    /**
     * CODIGO DO MOMENTO
     */
    private Integer cmomencobrcmbio;
    
    /**
     * CODIGO DA MOEDA
     */
    private Integer cindcdeconmmoeda;
    
    /**
     * SIMBOLO DA MOEDA
     */
    private String isglindcdfonte = null;
    
    /**
     * SIMBOLO DA MOEDA
     */
    private String isglindcdeconmmoeda;
    
    /**
     * VALOR COMISSAO INTERNA
     */
    private String vprevtcomiscmbio;
    
    /**
     * DATA PREVISTA DESEMBOLSO CAMBIO
     */
    private String dprevtdsembcmbio;
    
    /**
     * COD. IDENTIFICADOR TIPO COBRANCA COMISSAO INTERNA CAMBIO          
     */
    private Integer ccobrcomisintrn;
    
    /**
     * DESCRICAO TIPO COBRANCA COMISSAO INTERNA CAMBIO          
     */
    private String descrComissao;
    
    /**
     * % COMISSAO NEGOCIACAO CAMBIO          
     */
    private String pcomisnegoccmbio;
    
    /**
     *  COD. IDENTIFICADOR TIPO COBRANCA COMISSAO CAMBIO          
     */
    private Integer ccobrcomiscmbio;
    
    /**
     * VALOR MINIMO COBRANCA COMISSAO NEGOCIACAO CAMBIO          
     */
    private String vmincobrcomis;         
    
    /**
     * VALOR TAXA SPREAD CAMBIO APROVADO          
     */
    private String vtxspreadaprov;
    
    /**
     * VALOR TAXA SPREAD CAMBIO NEGOCIACAO          
     */
    private String vtxspreadnegoc;
    
    /**
     * VALOR TAXA SPREAD CAMBIO NEGOCIACAO          
     */
    private String ptxflatpnalt;
    
    /**
     * VALOR DO CUSTO TOTAL         
     */
    private String custototal;
    
    /**
     * NUMERO DA BOLETO NEGOCIACAO
     */
    private Integer nbletonegoccmbio;
    
    /**
     * NUMERO DA COMISSAO INTERNA
     */
    private Integer ncomisintrntrade;
    
    /**
     * NUMERO DA PARCELA
     */
    private Integer npcelacomisintrn;
    
    /**
     * VENCIMENTO DA PARCELA
     */
    private String  dvctopcelatrade;
    
    /**
     * VALOR DA PARCELA
     */
    private String vpcelacomiscmbio;
    
    /**
     * PRAZO DA PARCELA
     */
    private Integer prazoparcela;     
    
    /**
     * DESCRICAO DO MOMENTO
     */
    private String descrmomento;
    
    /**
     * QTDE DE PARCELAS
     */
    private Integer qpcelacmbiotrade;
    
    /**
     * NPCCWYLE - Exclusivo do book
     */
    private String hinclreg = null;
    
    /**
     * NPCCWXJS_LISTA - Exclusivo do book
     */
    private Integer ccondceconc = 0;

    /**
     * NPCCWXJS_LISTA - Exclusivo do book
     */
    private String icondeconc = null;

    /**
     * NPCCWXJS_LISTA - Exclusivo do book
     */
    private Integer cperdcjurocmbio = 0;

    /**
     * NPCCWXJS_LISTA - Exclusivo do book
     */
    private String iperdcjurocmbio = null;
    
    /**
     * NPCCWYME - Exclusivo do book
     */
    private Long cunicclicmbio = 0L;
    
    /**
     * LISTA DE PARCELAS
     */
    private List<ComissaoParcelaVO> parcelas = null;

    /**
     * @return o valor do parcelas
     */
    public List<ComissaoParcelaVO> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas seta o novo valor para o campo parcelas
     */
    public void setParcelas(List<ComissaoParcelaVO> parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return o valor do ncomisintrncmbio
     */
    public Integer getNcomisintrncmbio() {
        return ncomisintrncmbio;
    }

    /**
     * @param ncomisintrncmbio seta o novo valor para o campo ncomisintrncmbio
     */
    public void setNcomisintrncmbio(Integer ncomisintrncmbio) {
        this.ncomisintrncmbio = ncomisintrncmbio;
    }

    /**
     * @return o valor do cfluxoperdccmbio
     */
    public Integer getCfluxoperdccmbio() {
        return cfluxoperdccmbio;
    }

    /**
     * @param cfluxoperdccmbio seta o novo valor para o campo cfluxoperdccmbio
     */
    public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
        this.cfluxoperdccmbio = cfluxoperdccmbio;
    }

    /**
     * @return o valor do ifluxoperdccmbio
     */
    public String getIfluxoperdccmbio() {
        return ifluxoperdccmbio;
    }

    /**
     * @param ifluxoperdccmbio seta o novo valor para o campo ifluxoperdccmbio
     */
    public void setIfluxoperdccmbio(String ifluxoperdccmbio) {
        this.ifluxoperdccmbio = ifluxoperdccmbio;
    }

    /**
     * @return o valor do cmomencobrcmbio
     */
    public Integer getCmomencobrcmbio() {
        return cmomencobrcmbio;
    }

    /**
     * @param cmomencobrcmbio seta o novo valor para o campo cmomencobrcmbio
     */
    public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
        this.cmomencobrcmbio = cmomencobrcmbio;
    }

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
     * @return o valor do isglindcdfonte
     */
    public String getIsglindcdfonte() {
        return isglindcdfonte;
    }

    /**
     * @param isglindcdfonte seta o novo valor para o campo isglindcdfonte
     */
    public void setIsglindcdfonte(String isglindcdfonte) {
        this.isglindcdfonte = isglindcdfonte;
    }

    /**
     * @return o valor do isglindcdeconmmoeda
     */
    public String getIsglindcdeconmmoeda() {
        return isglindcdeconmmoeda;
    }

    /**
     * @param isglindcdeconmmoeda seta o novo valor para o campo isglindcdeconmmoeda
     */
    public void setIsglindcdeconmmoeda(String isglindcdeconmmoeda) {
        this.isglindcdeconmmoeda = isglindcdeconmmoeda;
    }

    /**
     * @return o valor do vprevtcomiscmbio
     */
    public String getVprevtcomiscmbio() {
        return vprevtcomiscmbio;
    }

    /**
     * @param vprevtcomiscmbio seta o novo valor para o campo vprevtcomiscmbio
     */
    public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
        this.vprevtcomiscmbio = vprevtcomiscmbio;
    }

    /**
     * @return o valor do dprevtdsembcmbio
     */
    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do ccobrcomisintrn
     */
    public Integer getCcobrcomisintrn() {
        return ccobrcomisintrn;
    }

    /**
     * @param ccobrcomisintrn seta o novo valor para o campo ccobrcomisintrn
     */
    public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
        this.ccobrcomisintrn = ccobrcomisintrn;
    }

    /**
     * @return o valor do descrComissao
     */
    public String getDescrComissao() {
        return descrComissao;
    }

    /**
     * @param descrComissao seta o novo valor para o campo descrComissao
     */
    public void setDescrComissao(String descrComissao) {
        this.descrComissao = descrComissao;
    }

    /**
     * @return o valor do pcomisnegoccmbio
     */
    public String getPcomisnegoccmbio() {
        return pcomisnegoccmbio;
    }

    /**
     * @param pcomisnegoccmbio seta o novo valor para o campo pcomisnegoccmbio
     */
    public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
        this.pcomisnegoccmbio = pcomisnegoccmbio;
    }

    /**
     * @return o valor do ccobrcomiscmbio
     */
    public Integer getCcobrcomiscmbio() {
        return ccobrcomiscmbio;
    }

    /**
     * @param ccobrcomiscmbio seta o novo valor para o campo ccobrcomiscmbio
     */
    public void setCcobrcomiscmbio(Integer ccobrcomiscmbio) {
        this.ccobrcomiscmbio = ccobrcomiscmbio;
    }

    /**
     * @return o valor do vmincobrcomis
     */
    public String getVmincobrcomis() {
        return vmincobrcomis;
    }

    /**
     * @param vmincobrcomis seta o novo valor para o campo vmincobrcomis
     */
    public void setVmincobrcomis(String vmincobrcomis) {
        this.vmincobrcomis = vmincobrcomis;
    }

    /**
     * @return o valor do vtxspreadaprov
     */
    public String getVtxspreadaprov() {
        return vtxspreadaprov;
    }

    /**
     * @param vtxspreadaprov seta o novo valor para o campo vtxspreadaprov
     */
    public void setVtxspreadaprov(String vtxspreadaprov) {
        this.vtxspreadaprov = vtxspreadaprov;
    }

    /**
     * @return o valor do vtxspreadnegoc
     */
    public String getVtxspreadnegoc() {
        return vtxspreadnegoc;
    }

    /**
     * @param vtxspreadnegoc seta o novo valor para o campo vtxspreadnegoc
     */
    public void setVtxspreadnegoc(String vtxspreadnegoc) {
        this.vtxspreadnegoc = vtxspreadnegoc;
    }

    /**
     * @return o valor do ptxflatpnalt
     */
    public String getPtxflatpnalt() {
        return ptxflatpnalt;
    }

    /**
     * @param ptxflatpnalt seta o novo valor para o campo ptxflatpnalt
     */
    public void setPtxflatpnalt(String ptxflatpnalt) {
        this.ptxflatpnalt = ptxflatpnalt;
    }

    /**
     * @return o valor do custototal
     */
    public String getCustototal() {
        return custototal;
    }

    /**
     * @param custototal seta o novo valor para o campo custototal
     */
    public void setCustototal(String custototal) {
        this.custototal = custototal;
    }

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Integer getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Integer nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do ncomisintrntrade
     */
    public Integer getNcomisintrntrade() {
        return ncomisintrntrade;
    }

    /**
     * @param ncomisintrntrade seta o novo valor para o campo ncomisintrntrade
     */
    public void setNcomisintrntrade(Integer ncomisintrntrade) {
        this.ncomisintrntrade = ncomisintrntrade;
    }

    /**
     * @return o valor do npcelacomisintrn
     */
    public Integer getNpcelacomisintrn() {
        return npcelacomisintrn;
    }

    /**
     * @param npcelacomisintrn seta o novo valor para o campo npcelacomisintrn
     */
    public void setNpcelacomisintrn(Integer npcelacomisintrn) {
        this.npcelacomisintrn = npcelacomisintrn;
    }

    /**
     * @return o valor do dvctopcelatrade
     */
    public String getDvctopcelatrade() {
        return dvctopcelatrade;
    }

    /**
     * @param dvctopcelatrade seta o novo valor para o campo dvctopcelatrade
     */
    public void setDvctopcelatrade(String dvctopcelatrade) {
        this.dvctopcelatrade = dvctopcelatrade;
    }

    /**
     * @return o valor do vpcelacomiscmbio
     */
    public String getVpcelacomiscmbio() {
        return vpcelacomiscmbio;
    }

    /**
     * @param vpcelacomiscmbio seta o novo valor para o campo vpcelacomiscmbio
     */
    public void setVpcelacomiscmbio(String vpcelacomiscmbio) {
        this.vpcelacomiscmbio = vpcelacomiscmbio;
    }

    /**
     * @return o valor do prazoparcela
     */
    public Integer getPrazoparcela() {
        return prazoparcela;
    }

    /**
     * @param prazoparcela seta o novo valor para o campo prazoparcela
     */
    public void setPrazoparcela(Integer prazoparcela) {
        this.prazoparcela = prazoparcela;
    }

    /**
     * @return o valor do descrmomento
     */
    public String getDescrmomento() {
        return descrmomento;
    }

    /**
     * @param descrmomento seta o novo valor para o campo descrmomento
     */
    public void setDescrmomento(String descrmomento) {
        this.descrmomento = descrmomento;
    }

    /**
     * @return o valor do hinclreg
     */
    public String getHinclreg() {
        return hinclreg;
    }

    /**
     * @param hinclreg seta o novo valor para o campo hinclreg
     */
    public void setHinclreg(String hinclreg) {
        this.hinclreg = hinclreg;
    }

    /**
     * @return o valor do ncomisextertrade
     */
    public Integer getNcomisextertrade() {
        return ncomisextertrade;
    }

    /**
     * @param ncomisextertrade seta o novo valor para o campo ncomisextertrade
     */
    public void setNcomisextertrade(Integer ncomisextertrade) {
        this.ncomisextertrade = ncomisextertrade;
    }

    /**
     * @return o valor do qpcelacmbiotrade
     */
    public Integer getQpcelacmbiotrade() {
        return qpcelacmbiotrade;
    }

    /**
     * @param qpcelacmbiotrade seta o novo valor para o campo qpcelacmbiotrade
     */
    public void setQpcelacmbiotrade(Integer qpcelacmbiotrade) {
        this.qpcelacmbiotrade = qpcelacmbiotrade;
    }

    /**
     * @return o valor do ccondceconc
     */
    public Integer getCcondceconc() {
        return ccondceconc;
    }

    /**
     * @param ccondceconc seta o novo valor para o campo ccondceconc
     */
    public void setCcondceconc(Integer ccondceconc) {
        this.ccondceconc = ccondceconc;
    }

    /**
     * @return o valor do icondeconc
     */
    public String getIcondeconc() {
        return icondeconc;
    }

    /**
     * @param icondeconc seta o novo valor para o campo icondeconc
     */
    public void setIcondeconc(String icondeconc) {
        this.icondeconc = icondeconc;
    }

    /**
     * @return o valor do cperdcjurocmbio
     */
    public Integer getCperdcjurocmbio() {
        return cperdcjurocmbio;
    }

    /**
     * @param cperdcjurocmbio seta o novo valor para o campo cperdcjurocmbio
     */
    public void setCperdcjurocmbio(Integer cperdcjurocmbio) {
        this.cperdcjurocmbio = cperdcjurocmbio;
    }

    /**
     * @return o valor do iperdcjurocmbio
     */
    public String getIperdcjurocmbio() {
        return iperdcjurocmbio;
    }

    /**
     * @param iperdcjurocmbio seta o novo valor para o campo iperdcjurocmbio
     */
    public void setIperdcjurocmbio(String iperdcjurocmbio) {
        this.iperdcjurocmbio = iperdcjurocmbio;
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

}
