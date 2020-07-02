/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA8SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA8SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo anoSafra
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ANO-SAFRA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 5, pic = "X(005)")
    protected String anoSafra = null;

    /**
     * Atributo acrCristal
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-CRISTAL", "RICCWA8S-AC"
        + "R-CRISTAL"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 1, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrCristal = null;

    /**
     * Atributo acrCristalN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-CRISTAL", "RICCWA8S-AC"
        + "R-CRISTAL-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String acrCristalN = null;

    /**
     * Atributo acrVhp
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-VHP", "RICCWA8S-ACR-VH"
        + "P"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 3, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrVhp = null;

    /**
     * Atributo acrVhpN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-VHP", "RICCWA8S-ACR-VH"
        + "P-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String acrVhpN = null;

    /**
     * Atributo acrOrga
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-ORGANICO", "RICCWA8S-A"
        + "CR-ORGA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 5, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrOrga = null;

    /**
     * Atributo acrOrgaN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ACUCAR-ORGANICO", "RICCWA8S-A"
        + "CR-ORGA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "X(001)")
    protected String acrOrgaN = null;

    /**
     * Atributo etaAni
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-ANIDRO", "RICCWA8S-ETA"
        + "-ANI"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 7, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaAni = null;

    /**
     * Atributo etaAniN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-ANIDRO", "RICCWA8S-ETA"
        + "-ANI-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 8, maxBytes = 1, pic = "X(001)")
    protected String etaAniN = null;

    /**
     * Atributo etaHidra
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-HIDRATADO", "RICCWA8S-"
        + "ETA-HIDRA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 9, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaHidra = null;

    /**
     * Atributo etaHidraN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-HIDRATADO", "RICCWA8S-"
        + "ETA-HIDRA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String etaHidraN = null;

    /**
     * Atributo etaOrga
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-ORGANICO", "RICCWA8S-E"
        + "TA-ORGA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 11, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaOrga = null;

    /**
     * Atributo etaOrgaN
     */
    @CommareaField(name = {"RICCWA8S-REGISTRO", "RICCWA8S-AREA-SAIDA", "RICCWA8S-ETANOL-ORGANICO", "RICCWA8S-E"
        + "TA-ORGA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 12, maxBytes = 1, pic = "X(001)")
    protected String etaOrgaN = null;

    /**
     * Propósito:  Retornar o valor de anoSafra
     *
     * @return anoSafra
     */
    public String getAnoSafra() {
        return anoSafra;
    }

    /**
     * Propósito:  Atribuir valor ao anoSafra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoSafra(String value) {
        this.anoSafra = value;
    }

    /**
     * Propósito:  Retornar o valor de acrCristal
     *
     * @return acrCristal
     */
    public BigDecimal getAcrCristal() {
        return acrCristal;
    }

    /**
     * Propósito:  Atribuir valor ao acrCristal
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrCristal(BigDecimal value) {
        this.acrCristal = value;
    }

    /**
     * Propósito:  Retornar o valor de acrCristalN
     *
     * @return acrCristalN
     */
    public String getAcrCristalN() {
        return acrCristalN;
    }

    /**
     * Propósito:  Atribuir valor ao acrCristalN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrCristalN(String value) {
        this.acrCristalN = value;
    }

    /**
     * Propósito:  Retornar o valor de acrVhp
     *
     * @return acrVhp
     */
    public BigDecimal getAcrVhp() {
        return acrVhp;
    }

    /**
     * Propósito:  Atribuir valor ao acrVhp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrVhp(BigDecimal value) {
        this.acrVhp = value;
    }

    /**
     * Propósito:  Retornar o valor de acrVhpN
     *
     * @return acrVhpN
     */
    public String getAcrVhpN() {
        return acrVhpN;
    }

    /**
     * Propósito:  Atribuir valor ao acrVhpN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrVhpN(String value) {
        this.acrVhpN = value;
    }

    /**
     * Propósito:  Retornar o valor de acrOrga
     *
     * @return acrOrga
     */
    public BigDecimal getAcrOrga() {
        return acrOrga;
    }

    /**
     * Propósito:  Atribuir valor ao acrOrga
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrOrga(BigDecimal value) {
        this.acrOrga = value;
    }

    /**
     * Propósito:  Retornar o valor de acrOrgaN
     *
     * @return acrOrgaN
     */
    public String getAcrOrgaN() {
        return acrOrgaN;
    }

    /**
     * Propósito:  Atribuir valor ao acrOrgaN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrOrgaN(String value) {
        this.acrOrgaN = value;
    }

    /**
     * Propósito:  Retornar o valor de etaAni
     *
     * @return etaAni
     */
    public BigDecimal getEtaAni() {
        return etaAni;
    }

    /**
     * Propósito:  Atribuir valor ao etaAni
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaAni(BigDecimal value) {
        this.etaAni = value;
    }

    /**
     * Propósito:  Retornar o valor de etaAniN
     *
     * @return etaAniN
     */
    public String getEtaAniN() {
        return etaAniN;
    }

    /**
     * Propósito:  Atribuir valor ao etaAniN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaAniN(String value) {
        this.etaAniN = value;
    }

    /**
     * Propósito:  Retornar o valor de etaHidra
     *
     * @return etaHidra
     */
    public BigDecimal getEtaHidra() {
        return etaHidra;
    }

    /**
     * Propósito:  Atribuir valor ao etaHidra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaHidra(BigDecimal value) {
        this.etaHidra = value;
    }

    /**
     * Propósito:  Retornar o valor de etaHidraN
     *
     * @return etaHidraN
     */
    public String getEtaHidraN() {
        return etaHidraN;
    }

    /**
     * Propósito:  Atribuir valor ao etaHidraN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaHidraN(String value) {
        this.etaHidraN = value;
    }

    /**
     * Propósito:  Retornar o valor de etaOrga
     *
     * @return etaOrga
     */
    public BigDecimal getEtaOrga() {
        return etaOrga;
    }

    /**
     * Propósito:  Atribuir valor ao etaOrga
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaOrga(BigDecimal value) {
        this.etaOrga = value;
    }

    /**
     * Propósito:  Retornar o valor de etaOrgaN
     *
     * @return etaOrgaN
     */
    public String getEtaOrgaN() {
        return etaOrgaN;
    }

    /**
     * Propósito:  Atribuir valor ao etaOrgaN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaOrgaN(String value) {
        this.etaOrgaN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA8SResponseRegistroAreaSaida() {
        super();
    }
}
