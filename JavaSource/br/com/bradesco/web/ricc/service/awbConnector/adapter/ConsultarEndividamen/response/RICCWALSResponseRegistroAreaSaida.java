/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWALSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWALSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nendvtBrio
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-NENDVT-BRIO"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nendvtBrio = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-IRZ-SCIAL"}, maxLength = 70,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo rmodldBco
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-RMODLD-BCO"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 30, pic = "X(030)")
    protected String rmodldBco = null;

    /**
     * Atributo vsdoEndv
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-VSDO-ENDV"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoEndv = null;

    /**
     * Atributo vvctoEndv
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-VVCTO-ENDV"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvctoEndv = null;

    /**
     * Atributo dtVvcto
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-DT-VVCTO"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 10, pic = "X(010)")
    protected String dtVvcto = null;

    /**
     * Atributo ramotzEndv
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-RAMOTZ-ENDV"}, maxLength = 20,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 20, pic = "X(020)")
    protected String ramotzEndv = null;

    /**
     * Atributo rgarntBco
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA", "RICCWALS-RGARNT-BCO"}, maxLength = 100,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 100, pic = "X(100)")
    protected String rgarntBco = null;

    /**
     * Propósito:  Retornar o valor de nendvtBrio
     *
     * @return nendvtBrio
     */
    public int getNendvtBrio() {
        return nendvtBrio;
    }

    /**
     * Propósito:  Atribuir valor ao nendvtBrio
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNendvtBrio(int value) {
        this.nendvtBrio = value;
    }

    /**
     * Propósito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Propósito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Propósito:  Retornar o valor de rmodldBco
     *
     * @return rmodldBco
     */
    public String getRmodldBco() {
        return rmodldBco;
    }

    /**
     * Propósito:  Atribuir valor ao rmodldBco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRmodldBco(String value) {
        this.rmodldBco = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoEndv
     *
     * @return vsdoEndv
     */
    public BigDecimal getVsdoEndv() {
        return vsdoEndv;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoEndv(BigDecimal value) {
        this.vsdoEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de vvctoEndv
     *
     * @return vvctoEndv
     */
    public BigDecimal getVvctoEndv() {
        return vvctoEndv;
    }

    /**
     * Propósito:  Atribuir valor ao vvctoEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvctoEndv(BigDecimal value) {
        this.vvctoEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de dtVvcto
     *
     * @return dtVvcto
     */
    public String getDtVvcto() {
        return dtVvcto;
    }

    /**
     * Propósito:  Atribuir valor ao dtVvcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtVvcto(String value) {
        this.dtVvcto = value;
    }

    /**
     * Propósito:  Retornar o valor de ramotzEndv
     *
     * @return ramotzEndv
     */
    public String getRamotzEndv() {
        return ramotzEndv;
    }

    /**
     * Propósito:  Atribuir valor ao ramotzEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRamotzEndv(String value) {
        this.ramotzEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de rgarntBco
     *
     * @return rgarntBco
     */
    public String getRgarntBco() {
        return rgarntBco;
    }

    /**
     * Propósito:  Atribuir valor ao rgarntBco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRgarntBco(String value) {
        this.rgarntBco = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWALSResponseRegistroAreaSaida() {
        super();
    }
}
