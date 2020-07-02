/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 25/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCFERequestRegistroAreaEntrada 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCFERequestRegistroAreaEntrada extends AnnotatedAdapter {

    /**
     * Atributo danoSafraAnt
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-DANO-SAFRA-ANT"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 0, maxBytes = 5, pic = "X(005)")
    protected String danoSafraAnt = null;

    /**
     * Atributo danoSafraNovo
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-DANO-SAFRA-NOVO"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 1, maxBytes = 5, pic = "X(005)")
    protected String danoSafraNovo = null;

    /**
     * Atributo acrCristal
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-CRISTAL", "RICCWCFE-"
        + "ACR-CRISTAL"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrCristal = null;

    /**
     * Atributo acrCristalN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-CRISTAL", "RICCWCFE-"
        + "ACR-CRISTAL-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String acrCristalN = null;

    /**
     * Atributo acrVhp
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-VHP", "RICCWCFE-ACR-"
        + "VHP"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrVhp = null;

    /**
     * Atributo acrVhpN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-VHP", "RICCWCFE-ACR-"
        + "VHP-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String acrVhpN = null;

    /**
     * Atributo acrOrga
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-ORGANICO", "RICCWCFE"
        + "-ACR-ORGA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal acrOrga = null;

    /**
     * Atributo acrOrgaN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ACUCAR-ORGANICO", "RICCWCFE"
        + "-ACR-ORGA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String acrOrgaN = null;

    /**
     * Atributo etaAni
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-ANIDRO", "RICCWCFE-E"
        + "TA-ANI"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaAni = null;

    /**
     * Atributo etaAniN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-ANIDRO", "RICCWCFE-E"
        + "TA-ANI-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String etaAniN = null;

    /**
     * Atributo etaHidra
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-HIDRATADO", "RICCWCF"
        + "E-ETA-HIDRA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaHidra = null;

    /**
     * Atributo etaHidraN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-HIDRATADO", "RICCWCF"
        + "E-ETA-HIDRA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String etaHidraN = null;

    /**
     * Atributo etaOrga
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-ORGANICO", "RICCWCFE"
        + "-ETA-ORGA"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 12, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal etaOrga = null;

    /**
     * Atributo etaOrgaN
     */
    @CommareaField(name = {"RICCWCFE-REGISTRO", "RICCWCFE-AREA-ENTRADA", "RICCWCFE-ETANOL-ORGANICO", "RICCWCFE"
        + "-ETA-ORGA-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String etaOrgaN = null;

    /**
     * Prop�sito:  Retornar o valor de danoSafraAnt
     *
     * @return danoSafraAnt
     */
    public String getDanoSafraAnt() {
        return danoSafraAnt;
    }

    /**
     * Prop�sito:  Atribuir valor ao danoSafraAnt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDanoSafraAnt(String value) {
        this.danoSafraAnt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de danoSafraNovo
     *
     * @return danoSafraNovo
     */
    public String getDanoSafraNovo() {
        return danoSafraNovo;
    }

    /**
     * Prop�sito:  Atribuir valor ao danoSafraNovo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDanoSafraNovo(String value) {
        this.danoSafraNovo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrCristal
     *
     * @return acrCristal
     */
    public BigDecimal getAcrCristal() {
        return acrCristal;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrCristal
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrCristal(BigDecimal value) {
        this.acrCristal = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrCristalN
     *
     * @return acrCristalN
     */
    public String getAcrCristalN() {
        return acrCristalN;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrCristalN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrCristalN(String value) {
        this.acrCristalN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrVhp
     *
     * @return acrVhp
     */
    public BigDecimal getAcrVhp() {
        return acrVhp;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrVhp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrVhp(BigDecimal value) {
        this.acrVhp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrVhpN
     *
     * @return acrVhpN
     */
    public String getAcrVhpN() {
        return acrVhpN;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrVhpN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrVhpN(String value) {
        this.acrVhpN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrOrga
     *
     * @return acrOrga
     */
    public BigDecimal getAcrOrga() {
        return acrOrga;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrOrga
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrOrga(BigDecimal value) {
        this.acrOrga = value;
    }

    /**
     * Prop�sito:  Retornar o valor de acrOrgaN
     *
     * @return acrOrgaN
     */
    public String getAcrOrgaN() {
        return acrOrgaN;
    }

    /**
     * Prop�sito:  Atribuir valor ao acrOrgaN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAcrOrgaN(String value) {
        this.acrOrgaN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaAni
     *
     * @return etaAni
     */
    public BigDecimal getEtaAni() {
        return etaAni;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaAni
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaAni(BigDecimal value) {
        this.etaAni = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaAniN
     *
     * @return etaAniN
     */
    public String getEtaAniN() {
        return etaAniN;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaAniN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaAniN(String value) {
        this.etaAniN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaHidra
     *
     * @return etaHidra
     */
    public BigDecimal getEtaHidra() {
        return etaHidra;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaHidra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaHidra(BigDecimal value) {
        this.etaHidra = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaHidraN
     *
     * @return etaHidraN
     */
    public String getEtaHidraN() {
        return etaHidraN;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaHidraN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaHidraN(String value) {
        this.etaHidraN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaOrga
     *
     * @return etaOrga
     */
    public BigDecimal getEtaOrga() {
        return etaOrga;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaOrga
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setEtaOrga(BigDecimal value) {
        this.etaOrga = value;
    }

    /**
     * Prop�sito:  Retornar o valor de etaOrgaN
     *
     * @return etaOrgaN
     */
    public String getEtaOrgaN() {
        return etaOrgaN;
    }

    /**
     * Prop�sito:  Atribuir valor ao etaOrgaN
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
    public RICCWCFERequestRegistroAreaEntrada() {
        super();
    }
}
