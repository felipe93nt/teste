/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 23/10/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBLERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBLERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBLE-HEADER", "RICCWBLE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBLE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBLE-HEADER", "RICCWBLE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 600;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo anoCol1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-ANO-COL1"}, maxLength = 4, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 4, pic = "9(004)")
    protected int anoCol1 = 0;

    /**
     * Atributo anoCol2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-ANO-COL2"}, maxLength = 4, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 4, pic = "9(004)")
    protected int anoCol2 = 0;

    /**
     * Atributo anoCol3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-ANO-COL3"}, maxLength = 4, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 4, pic = "9(004)")
    protected int anoCol3 = 0;

    /**
     * Atributo l1Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 50, pic = "X(050)")
    protected String l1Descricao = null;

    /**
     * Atributo l1PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l1PabertC1 = null;

    /**
     * Atributo l1PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String l1PabertC1N = null;

    /**
     * Atributo l1PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l1PabertC2 = null;

    /**
     * Atributo l1PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String l1PabertC2N = null;

    /**
     * Atributo l1PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 14, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l1PabertC3 = null;

    /**
     * Atributo l1PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-01", "RICCWBLE-L1-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001)")
    protected String l1PabertC3N = null;

    /**
     * Atributo l2Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 16, maxBytes = 50, pic = "X(050)")
    protected String l2Descricao = null;

    /**
     * Atributo l2PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 17, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l2PabertC1 = null;

    /**
     * Atributo l2PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 18, maxBytes = 1, pic = "X(001)")
    protected String l2PabertC1N = null;

    /**
     * Atributo l2PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 19, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l2PabertC2 = null;

    /**
     * Atributo l2PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 20, maxBytes = 1, pic = "X(001)")
    protected String l2PabertC2N = null;

    /**
     * Atributo l2PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 21, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l2PabertC3 = null;

    /**
     * Atributo l2PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-02", "RICCWBLE-L2-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 22, maxBytes = 1, pic = "X(001)")
    protected String l2PabertC3N = null;

    /**
     * Atributo l3Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 23, maxBytes = 50, pic = "X(050)")
    protected String l3Descricao = null;

    /**
     * Atributo l3PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 24, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l3PabertC1 = null;

    /**
     * Atributo l3PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 25, maxBytes = 1, pic = "X(001)")
    protected String l3PabertC1N = null;

    /**
     * Atributo l3PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 26, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l3PabertC2 = null;

    /**
     * Atributo l3PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 27, maxBytes = 1, pic = "X(001)")
    protected String l3PabertC2N = null;

    /**
     * Atributo l3PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 28, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l3PabertC3 = null;

    /**
     * Atributo l3PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-03", "RICCWBLE-L3-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 29, maxBytes = 1, pic = "X(001)")
    protected String l3PabertC3N = null;

    /**
     * Atributo l4Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 30, maxBytes = 50, pic = "X(050)")
    protected String l4Descricao = null;

    /**
     * Atributo l4PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 31, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l4PabertC1 = null;

    /**
     * Atributo l4PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 32, maxBytes = 1, pic = "X(001)")
    protected String l4PabertC1N = null;

    /**
     * Atributo l4PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 33, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l4PabertC2 = null;

    /**
     * Atributo l4PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 34, maxBytes = 1, pic = "X(001)")
    protected String l4PabertC2N = null;

    /**
     * Atributo l4PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 35, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l4PabertC3 = null;

    /**
     * Atributo l4PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-04", "RICCWBLE-L4-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 36, maxBytes = 1, pic = "X(001)")
    protected String l4PabertC3N = null;

    /**
     * Atributo l5Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 37, maxBytes = 50, pic = "X(050)")
    protected String l5Descricao = null;

    /**
     * Atributo l5PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 38, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l5PabertC1 = null;

    /**
     * Atributo l5PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 39, maxBytes = 1, pic = "X(001)")
    protected String l5PabertC1N = null;

    /**
     * Atributo l5PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 40, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l5PabertC2 = null;

    /**
     * Atributo l5PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 41, maxBytes = 1, pic = "X(001)")
    protected String l5PabertC2N = null;

    /**
     * Atributo l5PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 42, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l5PabertC3 = null;

    /**
     * Atributo l5PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-05", "RICCWBLE-L5-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 43, maxBytes = 1, pic = "X(001)")
    protected String l5PabertC3N = null;

    /**
     * Atributo l6Descricao
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-DESCRICAO"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 44, maxBytes = 50, pic = "X(050)")
    protected String l6Descricao = null;

    /**
     * Atributo l6PabertC1
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C1"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 45, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l6PabertC1 = null;

    /**
     * Atributo l6PabertC1N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C1-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 46, maxBytes = 1, pic = "X(001)")
    protected String l6PabertC1N = null;

    /**
     * Atributo l6PabertC2
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C2"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 47, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l6PabertC2 = null;

    /**
     * Atributo l6PabertC2N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C2-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 48, maxBytes = 1, pic = "X(001)")
    protected String l6PabertC2N = null;

    /**
     * Atributo l6PabertC3
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C3"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 49, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal l6PabertC3 = null;

    /**
     * Atributo l6PabertC3N
     */
    @CommareaField(name = {"RICCWBLE-REGISTRO", "RICCWBLE-LINHA-06", "RICCWBLE-L6-PABERT-C3-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 50, maxBytes = 1, pic = "X(001)")
    protected String l6PabertC3N = null;

    /**
     * Atributo filler24
     */
    protected String filler24 = null;

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
     * Propósito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de anoCol1
     *
     * @return anoCol1
     */
    public int getAnoCol1() {
        return anoCol1;
    }

    /**
     * Propósito:  Atribuir valor ao anoCol1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoCol1(int value) {
        this.anoCol1 = value;
    }

    /**
     * Propósito:  Retornar o valor de anoCol2
     *
     * @return anoCol2
     */
    public int getAnoCol2() {
        return anoCol2;
    }

    /**
     * Propósito:  Atribuir valor ao anoCol2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoCol2(int value) {
        this.anoCol2 = value;
    }

    /**
     * Propósito:  Retornar o valor de anoCol3
     *
     * @return anoCol3
     */
    public int getAnoCol3() {
        return anoCol3;
    }

    /**
     * Propósito:  Atribuir valor ao anoCol3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoCol3(int value) {
        this.anoCol3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l1Descricao
     *
     * @return l1Descricao
     */
    public String getL1Descricao() {
        return l1Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l1Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1Descricao(String value) {
        this.l1Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC1
     *
     * @return l1PabertC1
     */
    public BigDecimal getL1PabertC1() {
        return l1PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC1(BigDecimal value) {
        this.l1PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC1N
     *
     * @return l1PabertC1N
     */
    public String getL1PabertC1N() {
        return l1PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC1N(String value) {
        this.l1PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC2
     *
     * @return l1PabertC2
     */
    public BigDecimal getL1PabertC2() {
        return l1PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC2(BigDecimal value) {
        this.l1PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC2N
     *
     * @return l1PabertC2N
     */
    public String getL1PabertC2N() {
        return l1PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC2N(String value) {
        this.l1PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC3
     *
     * @return l1PabertC3
     */
    public BigDecimal getL1PabertC3() {
        return l1PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC3(BigDecimal value) {
        this.l1PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l1PabertC3N
     *
     * @return l1PabertC3N
     */
    public String getL1PabertC3N() {
        return l1PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l1PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL1PabertC3N(String value) {
        this.l1PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de l2Descricao
     *
     * @return l2Descricao
     */
    public String getL2Descricao() {
        return l2Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l2Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2Descricao(String value) {
        this.l2Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC1
     *
     * @return l2PabertC1
     */
    public BigDecimal getL2PabertC1() {
        return l2PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC1(BigDecimal value) {
        this.l2PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC1N
     *
     * @return l2PabertC1N
     */
    public String getL2PabertC1N() {
        return l2PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC1N(String value) {
        this.l2PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC2
     *
     * @return l2PabertC2
     */
    public BigDecimal getL2PabertC2() {
        return l2PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC2(BigDecimal value) {
        this.l2PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC2N
     *
     * @return l2PabertC2N
     */
    public String getL2PabertC2N() {
        return l2PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC2N(String value) {
        this.l2PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC3
     *
     * @return l2PabertC3
     */
    public BigDecimal getL2PabertC3() {
        return l2PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC3(BigDecimal value) {
        this.l2PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l2PabertC3N
     *
     * @return l2PabertC3N
     */
    public String getL2PabertC3N() {
        return l2PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l2PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL2PabertC3N(String value) {
        this.l2PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de l3Descricao
     *
     * @return l3Descricao
     */
    public String getL3Descricao() {
        return l3Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l3Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3Descricao(String value) {
        this.l3Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC1
     *
     * @return l3PabertC1
     */
    public BigDecimal getL3PabertC1() {
        return l3PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC1(BigDecimal value) {
        this.l3PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC1N
     *
     * @return l3PabertC1N
     */
    public String getL3PabertC1N() {
        return l3PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC1N(String value) {
        this.l3PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC2
     *
     * @return l3PabertC2
     */
    public BigDecimal getL3PabertC2() {
        return l3PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC2(BigDecimal value) {
        this.l3PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC2N
     *
     * @return l3PabertC2N
     */
    public String getL3PabertC2N() {
        return l3PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC2N(String value) {
        this.l3PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC3
     *
     * @return l3PabertC3
     */
    public BigDecimal getL3PabertC3() {
        return l3PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC3(BigDecimal value) {
        this.l3PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l3PabertC3N
     *
     * @return l3PabertC3N
     */
    public String getL3PabertC3N() {
        return l3PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l3PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL3PabertC3N(String value) {
        this.l3PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de l4Descricao
     *
     * @return l4Descricao
     */
    public String getL4Descricao() {
        return l4Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l4Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4Descricao(String value) {
        this.l4Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC1
     *
     * @return l4PabertC1
     */
    public BigDecimal getL4PabertC1() {
        return l4PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC1(BigDecimal value) {
        this.l4PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC1N
     *
     * @return l4PabertC1N
     */
    public String getL4PabertC1N() {
        return l4PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC1N(String value) {
        this.l4PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC2
     *
     * @return l4PabertC2
     */
    public BigDecimal getL4PabertC2() {
        return l4PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC2(BigDecimal value) {
        this.l4PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC2N
     *
     * @return l4PabertC2N
     */
    public String getL4PabertC2N() {
        return l4PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC2N(String value) {
        this.l4PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC3
     *
     * @return l4PabertC3
     */
    public BigDecimal getL4PabertC3() {
        return l4PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC3(BigDecimal value) {
        this.l4PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l4PabertC3N
     *
     * @return l4PabertC3N
     */
    public String getL4PabertC3N() {
        return l4PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l4PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL4PabertC3N(String value) {
        this.l4PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de l5Descricao
     *
     * @return l5Descricao
     */
    public String getL5Descricao() {
        return l5Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l5Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5Descricao(String value) {
        this.l5Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC1
     *
     * @return l5PabertC1
     */
    public BigDecimal getL5PabertC1() {
        return l5PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC1(BigDecimal value) {
        this.l5PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC1N
     *
     * @return l5PabertC1N
     */
    public String getL5PabertC1N() {
        return l5PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC1N(String value) {
        this.l5PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC2
     *
     * @return l5PabertC2
     */
    public BigDecimal getL5PabertC2() {
        return l5PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC2(BigDecimal value) {
        this.l5PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC2N
     *
     * @return l5PabertC2N
     */
    public String getL5PabertC2N() {
        return l5PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC2N(String value) {
        this.l5PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC3
     *
     * @return l5PabertC3
     */
    public BigDecimal getL5PabertC3() {
        return l5PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC3(BigDecimal value) {
        this.l5PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l5PabertC3N
     *
     * @return l5PabertC3N
     */
    public String getL5PabertC3N() {
        return l5PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l5PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL5PabertC3N(String value) {
        this.l5PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de l6Descricao
     *
     * @return l6Descricao
     */
    public String getL6Descricao() {
        return l6Descricao;
    }

    /**
     * Propósito:  Atribuir valor ao l6Descricao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6Descricao(String value) {
        this.l6Descricao = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC1
     *
     * @return l6PabertC1
     */
    public BigDecimal getL6PabertC1() {
        return l6PabertC1;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC1(BigDecimal value) {
        this.l6PabertC1 = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC1N
     *
     * @return l6PabertC1N
     */
    public String getL6PabertC1N() {
        return l6PabertC1N;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC1N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC1N(String value) {
        this.l6PabertC1N = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC2
     *
     * @return l6PabertC2
     */
    public BigDecimal getL6PabertC2() {
        return l6PabertC2;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC2(BigDecimal value) {
        this.l6PabertC2 = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC2N
     *
     * @return l6PabertC2N
     */
    public String getL6PabertC2N() {
        return l6PabertC2N;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC2N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC2N(String value) {
        this.l6PabertC2N = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC3
     *
     * @return l6PabertC3
     */
    public BigDecimal getL6PabertC3() {
        return l6PabertC3;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC3(BigDecimal value) {
        this.l6PabertC3 = value;
    }

    /**
     * Propósito:  Retornar o valor de l6PabertC3N
     *
     * @return l6PabertC3N
     */
    public String getL6PabertC3N() {
        return l6PabertC3N;
    }

    /**
     * Propósito:  Atribuir valor ao l6PabertC3N
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setL6PabertC3N(String value) {
        this.l6PabertC3N = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER24
     *
     * @return fILLER24
     */
    public String getFILLER24() {
        return filler24;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER24
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER24(String value) {
        this.filler24 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBLERequest() {
        super();
    }
}
