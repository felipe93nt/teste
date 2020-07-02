/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/12/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAKSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAKSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo sNumAno
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-S-NUM-ANO"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 4, pic = "9(004)")
    protected int sNumAno = 0;

    /**
     * Atributo vtotM01S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JANEIRO", "RICCWAKS-VTOT-M01-"
        + "S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "X(001)")
    protected String vtotM01S = null;

    /**
     * Atributo vtotM01
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JANEIRO",
        "RICCWAKS-VTOT-M01"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 2, maxBytes = 17, pic = "9(015"
        + ")V99")
    protected BigDecimal vtotM01 = null;

    /**
     * Atributo vtotM01Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JANEIRO", "RICCWAKS-VTOT-M01-"
        + "NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String vtotM01Null = null;

    /**
     * Atributo vtotM02S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-FEVEREIRO", "RICCWAKS-VTOT-M0"
        + "2-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String vtotM02S = null;

    /**
     * Atributo vtotM02
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-FEVEREIRO", "RICCWAKS-VTOT-M0"
        + "2"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 5, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM02 = null;

    /**
     * Atributo vtotM02Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-FEVEREIRO", "RICCWAKS-VTOT-M0"
        + "2-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "X(001)")
    protected String vtotM02Null = null;

    /**
     * Atributo vtotM03S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-MARCO",
        "RICCWAKS-VTOT-M03-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001"
        + ")")
    protected String vtotM03S = null;

    /**
     * Atributo vtotM03
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-MARCO", "RICCWAKS-VTOT-M03"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM03 = null;

    /**
     * Atributo vtotM03Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-MARCO", "RICCWAKS-VTOT-M03-NU"
        + "LL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String vtotM03Null = null;

    /**
     * Atributo vtotM04S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-ABRIL",
        "RICCWAKS-VTOT-M04-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String vtotM04S = null;

    /**
     * Atributo vtotM04
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-ABRIL", "RICCWAKS-VTOT-M04"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM04 = null;

    /**
     * Atributo vtotM04Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-ABRIL", "RICCWAKS-VTOT-M04-NU"
        + "LL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 12, maxBytes = 1, pic = "X(001)")
    protected String vtotM04Null = null;

    /**
     * Atributo vtotM05S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JMAIO",
        "RICCWAKS-VTOT-M05-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String vtotM05S = null;

    /**
     * Atributo vtotM05
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JMAIO", "RICCWAKS-VTOT-M05"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM05 = null;

    /**
     * Atributo vtotM05Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JMAIO", "RICCWAKS-VTOT-M05-NU"
        + "LL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001)")
    protected String vtotM05Null = null;

    /**
     * Atributo vtotM06S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JUNHO",
        "RICCWAKS-VTOT-M06-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 16, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String vtotM06S = null;

    /**
     * Atributo vtotM06
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JUNHO", "RICCWAKS-VTOT-M06"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 17, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM06 = null;

    /**
     * Atributo vtotM06Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JUNHO", "RICCWAKS-VTOT-M06-NU"
        + "LL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 18, maxBytes = 1, pic = "X(001)")
    protected String vtotM06Null = null;

    /**
     * Atributo vtotM07S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JULHO",
        "RICCWAKS-VTOT-M07-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String vtotM07S = null;

    /**
     * Atributo vtotM07
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JULHO", "RICCWAKS-VTOT-M07"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 20, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM07 = null;

    /**
     * Atributo vtotM07Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-JULHO", "RICCWAKS-VTOT-M07-NU"
        + "LL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 21, maxBytes = 1, pic = "X(001)")
    protected String vtotM07Null = null;

    /**
     * Atributo vtotM08S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-AGOSTO",
        "RICCWAKS-VTOT-M08-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 22, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String vtotM08S = null;

    /**
     * Atributo vtotM08
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-AGOSTO", "RICCWAKS-VTOT-M08"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 23, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotM08 = null;

    /**
     * Atributo vtotM08Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-AGOSTO", "RICCWAKS-VTOT-M08-N"
        + "ULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 24, maxBytes = 1, pic = "X(001)")
    protected String vtotM08Null = null;

    /**
     * Atributo vtotM09S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-SETEMBRO", "RICCWAKS-VTOT-M09"
        + "-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 25, maxBytes = 1, pic = "X(001)")
    protected String vtotM09S = null;

    /**
     * Atributo vtotM09
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-SETEMBRO",
        "RICCWAKS-VTOT-M09"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 26, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal vtotM09 = null;

    /**
     * Atributo vtotM09Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-SETEMBRO", "RICCWAKS-VTOT-M09"
        + "-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 27, maxBytes = 1, pic = "X(001)")
    protected String vtotM09Null = null;

    /**
     * Atributo vtotM10S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-OUTUBRO", "RICCWAKS-VTOT-M10-"
        + "S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 28, maxBytes = 1, pic = "X(001)")
    protected String vtotM10S = null;

    /**
     * Atributo vtotM10
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-OUTUBRO",
        "RICCWAKS-VTOT-M10"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 29, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal vtotM10 = null;

    /**
     * Atributo vtotM10Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-OUTUBRO", "RICCWAKS-VTOT-M10-"
        + "NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 30, maxBytes = 1, pic = "X(001)")
    protected String vtotM10Null = null;

    /**
     * Atributo vtotM11S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-NOVEMBRO", "RICCWAKS-VTOT-M11"
        + "-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 31, maxBytes = 1, pic = "X(001)")
    protected String vtotM11S = null;

    /**
     * Atributo vtotM11
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-NOVEMBRO",
        "RICCWAKS-VTOT-M11"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 32, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal vtotM11 = null;

    /**
     * Atributo vtotM11Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-NOVEMBRO", "RICCWAKS-VTOT-M11"
        + "-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 33, maxBytes = 1, pic = "X(001)")
    protected String vtotM11Null = null;

    /**
     * Atributo vtotM12S
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-DEZEMBRO", "RICCWAKS-VTOT-M12"
        + "-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 34, maxBytes = 1, pic = "X(001)")
    protected String vtotM12S = null;

    /**
     * Atributo vtotM12
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-DEZEMBRO",
        "RICCWAKS-VTOT-M12"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 35, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal vtotM12 = null;

    /**
     * Atributo vtotM12Null
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-DEZEMBRO", "RICCWAKS-VTOT-M12"
        + "-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 36, maxBytes = 1, pic = "X(001)")
    protected String vtotM12Null = null;

    /**
     * Atributo vtotFatmtS
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-VTOT-FATMT-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 37, maxBytes = 1, pic = "X(001)")
    protected String vtotFatmtS = null;

    /**
     * Atributo vtotFatmt
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-VTOT-FATMT"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 38, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotFatmt = null;

    /**
     * Atributo vmedFatmtS
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-VMED-FATMT-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 39, maxBytes = 1, pic = "X(001)")
    protected String vmedFatmtS = null;

    /**
     * Atributo vmedFatmt
     */
    @CommareaField(name = {"RICCWAKS-REGISTRO", "RICCWAKS-AREA-SAIDA", "RICCWAKS-VMED-FATMT"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 40, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmedFatmt = null;

    /**
     * Prop�sito:  Retornar o valor de sNumAno
     *
     * @return sNumAno
     */
    public int getsNumAno() {
        return sNumAno;
    }

    /**
     * Prop�sito:  Atribuir valor ao sNumAno
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setsNumAno(int value) {
        this.sNumAno = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM01S
     *
     * @return vtotM01S
     */
    public String getVtotM01S() {
        return vtotM01S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM01S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM01S(String value) {
        this.vtotM01S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM01
     *
     * @return vtotM01
     */
    public BigDecimal getVtotM01() {
        return vtotM01;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM01
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM01(BigDecimal value) {
        this.vtotM01 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM01Null
     *
     * @return vtotM01Null
     */
    public String getVtotM01Null() {
        return vtotM01Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM01Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM01Null(String value) {
        this.vtotM01Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM02S
     *
     * @return vtotM02S
     */
    public String getVtotM02S() {
        return vtotM02S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM02S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM02S(String value) {
        this.vtotM02S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM02
     *
     * @return vtotM02
     */
    public BigDecimal getVtotM02() {
        return vtotM02;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM02
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM02(BigDecimal value) {
        this.vtotM02 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM02Null
     *
     * @return vtotM02Null
     */
    public String getVtotM02Null() {
        return vtotM02Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM02Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM02Null(String value) {
        this.vtotM02Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM03S
     *
     * @return vtotM03S
     */
    public String getVtotM03S() {
        return vtotM03S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM03S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM03S(String value) {
        this.vtotM03S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM03
     *
     * @return vtotM03
     */
    public BigDecimal getVtotM03() {
        return vtotM03;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM03
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM03(BigDecimal value) {
        this.vtotM03 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM03Null
     *
     * @return vtotM03Null
     */
    public String getVtotM03Null() {
        return vtotM03Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM03Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM03Null(String value) {
        this.vtotM03Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM04S
     *
     * @return vtotM04S
     */
    public String getVtotM04S() {
        return vtotM04S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM04S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM04S(String value) {
        this.vtotM04S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM04
     *
     * @return vtotM04
     */
    public BigDecimal getVtotM04() {
        return vtotM04;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM04
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM04(BigDecimal value) {
        this.vtotM04 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM04Null
     *
     * @return vtotM04Null
     */
    public String getVtotM04Null() {
        return vtotM04Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM04Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM04Null(String value) {
        this.vtotM04Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM05S
     *
     * @return vtotM05S
     */
    public String getVtotM05S() {
        return vtotM05S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM05S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM05S(String value) {
        this.vtotM05S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM05
     *
     * @return vtotM05
     */
    public BigDecimal getVtotM05() {
        return vtotM05;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM05
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM05(BigDecimal value) {
        this.vtotM05 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM05Null
     *
     * @return vtotM05Null
     */
    public String getVtotM05Null() {
        return vtotM05Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM05Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM05Null(String value) {
        this.vtotM05Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM06S
     *
     * @return vtotM06S
     */
    public String getVtotM06S() {
        return vtotM06S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM06S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM06S(String value) {
        this.vtotM06S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM06
     *
     * @return vtotM06
     */
    public BigDecimal getVtotM06() {
        return vtotM06;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM06
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM06(BigDecimal value) {
        this.vtotM06 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM06Null
     *
     * @return vtotM06Null
     */
    public String getVtotM06Null() {
        return vtotM06Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM06Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM06Null(String value) {
        this.vtotM06Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM07S
     *
     * @return vtotM07S
     */
    public String getVtotM07S() {
        return vtotM07S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM07S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM07S(String value) {
        this.vtotM07S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM07
     *
     * @return vtotM07
     */
    public BigDecimal getVtotM07() {
        return vtotM07;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM07
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM07(BigDecimal value) {
        this.vtotM07 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM07Null
     *
     * @return vtotM07Null
     */
    public String getVtotM07Null() {
        return vtotM07Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM07Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM07Null(String value) {
        this.vtotM07Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM08S
     *
     * @return vtotM08S
     */
    public String getVtotM08S() {
        return vtotM08S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM08S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM08S(String value) {
        this.vtotM08S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM08
     *
     * @return vtotM08
     */
    public BigDecimal getVtotM08() {
        return vtotM08;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM08
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM08(BigDecimal value) {
        this.vtotM08 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM08Null
     *
     * @return vtotM08Null
     */
    public String getVtotM08Null() {
        return vtotM08Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM08Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM08Null(String value) {
        this.vtotM08Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM09S
     *
     * @return vtotM09S
     */
    public String getVtotM09S() {
        return vtotM09S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM09S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM09S(String value) {
        this.vtotM09S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM09
     *
     * @return vtotM09
     */
    public BigDecimal getVtotM09() {
        return vtotM09;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM09
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM09(BigDecimal value) {
        this.vtotM09 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM09Null
     *
     * @return vtotM09Null
     */
    public String getVtotM09Null() {
        return vtotM09Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM09Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM09Null(String value) {
        this.vtotM09Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM10S
     *
     * @return vtotM10S
     */
    public String getVtotM10S() {
        return vtotM10S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM10S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM10S(String value) {
        this.vtotM10S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM10
     *
     * @return vtotM10
     */
    public BigDecimal getVtotM10() {
        return vtotM10;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM10
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM10(BigDecimal value) {
        this.vtotM10 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM10Null
     *
     * @return vtotM10Null
     */
    public String getVtotM10Null() {
        return vtotM10Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM10Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM10Null(String value) {
        this.vtotM10Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM11S
     *
     * @return vtotM11S
     */
    public String getVtotM11S() {
        return vtotM11S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM11S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM11S(String value) {
        this.vtotM11S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM11
     *
     * @return vtotM11
     */
    public BigDecimal getVtotM11() {
        return vtotM11;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM11
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM11(BigDecimal value) {
        this.vtotM11 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM11Null
     *
     * @return vtotM11Null
     */
    public String getVtotM11Null() {
        return vtotM11Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM11Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM11Null(String value) {
        this.vtotM11Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM12S
     *
     * @return vtotM12S
     */
    public String getVtotM12S() {
        return vtotM12S;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM12S
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM12S(String value) {
        this.vtotM12S = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM12
     *
     * @return vtotM12
     */
    public BigDecimal getVtotM12() {
        return vtotM12;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM12
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM12(BigDecimal value) {
        this.vtotM12 = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotM12Null
     *
     * @return vtotM12Null
     */
    public String getVtotM12Null() {
        return vtotM12Null;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotM12Null
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotM12Null(String value) {
        this.vtotM12Null = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotFatmtS
     *
     * @return vtotFatmtS
     */
    public String getVtotFatmtS() {
        return vtotFatmtS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotFatmtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotFatmtS(String value) {
        this.vtotFatmtS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotFatmt
     *
     * @return vtotFatmt
     */
    public BigDecimal getVtotFatmt() {
        return vtotFatmt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotFatmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotFatmt(BigDecimal value) {
        this.vtotFatmt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedFatmtS
     *
     * @return vmedFatmtS
     */
    public String getVmedFatmtS() {
        return vmedFatmtS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedFatmtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedFatmtS(String value) {
        this.vmedFatmtS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedFatmt
     *
     * @return vmedFatmt
     */
    public BigDecimal getVmedFatmt() {
        return vmedFatmt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedFatmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedFatmt(BigDecimal value) {
        this.vmedFatmt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAKSResponseRegistroAreaSaida() {
        super();
    }
}