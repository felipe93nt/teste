/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBYERequestRegistroAreaEntrada 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBYERequestRegistroAreaEntrada extends AnnotatedAdapter {

    /**
     * Atributo ctpoFatmt
     */
    @CommareaField(name = {"RICCWBYE-REGISTRO", "RICCWBYE-AREA-ENTRADA", "RICCWBYE-CTPO-FATMT"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 1, pic = "9(001)")
    protected int ctpoFatmt = 0;

    /**
     * Atributo pfatmt
     */
    @CommareaField(name = {"RICCWBYE-REGISTRO", "RICCWBYE-AREA-ENTRADA", "RICCWBYE-PFATMT"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfatmt = null;

    /**
     * Atributo pfatmtN
     */
    @CommareaField(name = {"RICCWBYE-REGISTRO", "RICCWBYE-AREA-ENTRADA", "RICCWBYE-PFATMT-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String pfatmtN = null;

    /**
     * Atributo pebitda
     */
    @CommareaField(name = {"RICCWBYE-REGISTRO", "RICCWBYE-AREA-ENTRADA", "RICCWBYE-PEBITDA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pebitda = null;

    /**
     * Atributo pebitdaN
     */
    @CommareaField(name = {"RICCWBYE-REGISTRO", "RICCWBYE-AREA-ENTRADA", "RICCWBYE-PEBITDA-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String pebitdaN = null;

    /**
     * Prop�sito:  Retornar o valor de ctpoFatmt
     *
     * @return ctpoFatmt
     */
    public int getCtpoFatmt() {
        return ctpoFatmt;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoFatmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoFatmt(int value) {
        this.ctpoFatmt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pfatmt
     *
     * @return pfatmt
     */
    public BigDecimal getPfatmt() {
        return pfatmt;
    }

    /**
     * Prop�sito:  Atribuir valor ao pfatmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfatmt(BigDecimal value) {
        this.pfatmt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pfatmtN
     *
     * @return pfatmtN
     */
    public String getPfatmtN() {
        return pfatmtN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pfatmtN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfatmtN(String value) {
        this.pfatmtN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pebitda
     *
     * @return pebitda
     */
    public BigDecimal getPebitda() {
        return pebitda;
    }

    /**
     * Prop�sito:  Atribuir valor ao pebitda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPebitda(BigDecimal value) {
        this.pebitda = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pebitdaN
     *
     * @return pebitdaN
     */
    public String getPebitdaN() {
        return pebitdaN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pebitdaN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPebitdaN(String value) {
        this.pebitdaN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBYERequestRegistroAreaEntrada() {
        super();
    }
}
