/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 21/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCLERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCLERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCLE-HEADER", "RICCWCLE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCLE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCLE-HEADER", "RICCWCLE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo qveicFrota
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-QVEIC-FROTA"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int qveicFrota = 0;

    /**
     * Atributo vveicFrota
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-VVEIC-FROTA"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vveicFrota = null;

    /**
     * Atributo vsdoDvdorFrt
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-VSDO-DVDOR-FRT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdorFrt = null;

    /**
     * Atributo pgrauAlieFrt
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-PGRAU-ALIE-FRT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pgrauAlieFrt = null;

    /**
     * Atributo nidadeMedFrt
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-NIDADE-MED-FRT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 3, pic = "9(003)")
    protected int nidadeMedFrt = 0;

    /**
     * Atributo vmesFinanFrt
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-VMES-FINAN-FRT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmesFinanFrt = null;

    /**
     * Atributo vmesCaptlGro
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-VMES-CAPTL-GRO"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmesCaptlGro = null;

    /**
     * Atributo vfatmtMedMes
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-VFATMT-MED-MES"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vfatmtMedMes = null;

    /**
     * Atributo pcompmRecta
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-PCOMPM-RECTA"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 15, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcompmRecta = null;

    /**
     * Atributo pcompmCaptl
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-PCOMPM-CAPTL"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 16, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcompmCaptl = null;

    /**
     * Atributo pfrotaPrpia
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-PFROTA-PRPIA"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 17, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfrotaPrpia = null;

    /**
     * Atributo pultExerc
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "RICCWCLE-PULT-EXERC"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 18, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pultExerc = null;

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWCLE-REGISTRO", "FILLER"}, maxLength = 133, usage = "DISPLAY",
        fieldNumber = 19, maxBytes = 133, pic = "X(133)")
    protected String filler0 = null;

    /**
     * Propósito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Propósito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Propósito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Propósito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Propósito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Propósito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Propósito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Propósito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
    }

    /**
     * Propósito:  Retornar o valor de qveicFrota
     *
     * @return qveicFrota
     */
    public int getQveicFrota() {
        return qveicFrota;
    }

    /**
     * Propósito:  Atribuir valor ao qveicFrota
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQveicFrota(int value) {
        this.qveicFrota = value;
    }

    /**
     * Propósito:  Retornar o valor de vveicFrota
     *
     * @return vveicFrota
     */
    public BigDecimal getVveicFrota() {
        return vveicFrota;
    }

    /**
     * Propósito:  Atribuir valor ao vveicFrota
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVveicFrota(BigDecimal value) {
        this.vveicFrota = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoDvdorFrt
     *
     * @return vsdoDvdorFrt
     */
    public BigDecimal getVsdoDvdorFrt() {
        return vsdoDvdorFrt;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoDvdorFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoDvdorFrt(BigDecimal value) {
        this.vsdoDvdorFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de pgrauAlieFrt
     *
     * @return pgrauAlieFrt
     */
    public BigDecimal getPgrauAlieFrt() {
        return pgrauAlieFrt;
    }

    /**
     * Propósito:  Atribuir valor ao pgrauAlieFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPgrauAlieFrt(BigDecimal value) {
        this.pgrauAlieFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de nidadeMedFrt
     *
     * @return nidadeMedFrt
     */
    public int getNidadeMedFrt() {
        return nidadeMedFrt;
    }

    /**
     * Propósito:  Atribuir valor ao nidadeMedFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNidadeMedFrt(int value) {
        this.nidadeMedFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de vmesFinanFrt
     *
     * @return vmesFinanFrt
     */
    public BigDecimal getVmesFinanFrt() {
        return vmesFinanFrt;
    }

    /**
     * Propósito:  Atribuir valor ao vmesFinanFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmesFinanFrt(BigDecimal value) {
        this.vmesFinanFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de vmesCaptlGro
     *
     * @return vmesCaptlGro
     */
    public BigDecimal getVmesCaptlGro() {
        return vmesCaptlGro;
    }

    /**
     * Propósito:  Atribuir valor ao vmesCaptlGro
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmesCaptlGro(BigDecimal value) {
        this.vmesCaptlGro = value;
    }

    /**
     * Propósito:  Retornar o valor de vfatmtMedMes
     *
     * @return vfatmtMedMes
     */
    public BigDecimal getVfatmtMedMes() {
        return vfatmtMedMes;
    }

    /**
     * Propósito:  Atribuir valor ao vfatmtMedMes
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVfatmtMedMes(BigDecimal value) {
        this.vfatmtMedMes = value;
    }

    /**
     * Propósito:  Retornar o valor de pcompmRecta
     *
     * @return pcompmRecta
     */
    public BigDecimal getPcompmRecta() {
        return pcompmRecta;
    }

    /**
     * Propósito:  Atribuir valor ao pcompmRecta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcompmRecta(BigDecimal value) {
        this.pcompmRecta = value;
    }

    /**
     * Propósito:  Retornar o valor de pcompmCaptl
     *
     * @return pcompmCaptl
     */
    public BigDecimal getPcompmCaptl() {
        return pcompmCaptl;
    }

    /**
     * Propósito:  Atribuir valor ao pcompmCaptl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcompmCaptl(BigDecimal value) {
        this.pcompmCaptl = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrotaPrpia
     *
     * @return pfrotaPrpia
     */
    public BigDecimal getPfrotaPrpia() {
        return pfrotaPrpia;
    }

    /**
     * Propósito:  Atribuir valor ao pfrotaPrpia
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrotaPrpia(BigDecimal value) {
        this.pfrotaPrpia = value;
    }

    /**
     * Propósito:  Retornar o valor de pultExerc
     *
     * @return pultExerc
     */
    public BigDecimal getPultExerc() {
        return pultExerc;
    }

    /**
     * Propósito:  Atribuir valor ao pultExerc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPultExerc(BigDecimal value) {
        this.pultExerc = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER0
     *
     * @return fILLER0
     */
    public String getFILLER0() {
        return filler0;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER0
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER0(String value) {
        this.filler0 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCLERequest() {
        super();
    }
}
