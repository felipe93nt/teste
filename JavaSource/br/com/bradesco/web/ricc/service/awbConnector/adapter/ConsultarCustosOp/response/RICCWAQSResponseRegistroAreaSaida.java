/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 13/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAQSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAQSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncustoOper
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-NCUSTO-OPER"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int ncustoOper = 0;

    /**
     * Atributo nanoCusto
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-NANO-CUSTO"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoCusto = 0;

    /**
     * Atributo pcustCombs
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-COMBS"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcustCombs = null;

    /**
     * Atributo pcustCombsN
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-COMBS-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String pcustCombsN = null;

    /**
     * Atributo pcustMdobra
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-MDOBRA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcustMdobra = null;

    /**
     * Atributo pcustMdobraN
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-MDOBRA-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String pcustMdobraN = null;

    /**
     * Atributo pcustOutros
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-OUTROS"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcustOutros = null;

    /**
     * Atributo pcustOutrosN
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-OUTROS-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String pcustOutrosN = null;

    /**
     * Atributo pcustTotal
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-TOTAL"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcustTotal = null;

    /**
     * Atributo pcustTotalN
     */
    @CommareaField(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA", "RICCWAQS-PCUST-TOTAL-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String pcustTotalN = null;

    /**
     * Prop�sito:  Retornar o valor de ncustoOper
     *
     * @return ncustoOper
     */
    public int getNcustoOper() {
        return ncustoOper;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncustoOper
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcustoOper(int value) {
        this.ncustoOper = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nanoCusto
     *
     * @return nanoCusto
     */
    public int getNanoCusto() {
        return nanoCusto;
    }

    /**
     * Prop�sito:  Atribuir valor ao nanoCusto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoCusto(int value) {
        this.nanoCusto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustCombs
     *
     * @return pcustCombs
     */
    public BigDecimal getPcustCombs() {
        return pcustCombs;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustCombs
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustCombs(BigDecimal value) {
        this.pcustCombs = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustCombsN
     *
     * @return pcustCombsN
     */
    public String getPcustCombsN() {
        return pcustCombsN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustCombsN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustCombsN(String value) {
        this.pcustCombsN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustMdobra
     *
     * @return pcustMdobra
     */
    public BigDecimal getPcustMdobra() {
        return pcustMdobra;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustMdobra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustMdobra(BigDecimal value) {
        this.pcustMdobra = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustMdobraN
     *
     * @return pcustMdobraN
     */
    public String getPcustMdobraN() {
        return pcustMdobraN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustMdobraN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustMdobraN(String value) {
        this.pcustMdobraN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustOutros
     *
     * @return pcustOutros
     */
    public BigDecimal getPcustOutros() {
        return pcustOutros;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustOutros
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustOutros(BigDecimal value) {
        this.pcustOutros = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustOutrosN
     *
     * @return pcustOutrosN
     */
    public String getPcustOutrosN() {
        return pcustOutrosN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustOutrosN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustOutrosN(String value) {
        this.pcustOutrosN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustTotal
     *
     * @return pcustTotal
     */
    public BigDecimal getPcustTotal() {
        return pcustTotal;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustTotal
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustTotal(BigDecimal value) {
        this.pcustTotal = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcustTotalN
     *
     * @return pcustTotalN
     */
    public String getPcustTotalN() {
        return pcustTotalN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcustTotalN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcustTotalN(String value) {
        this.pcustTotalN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAQSResponseRegistroAreaSaida() {
        super();
    }
}
