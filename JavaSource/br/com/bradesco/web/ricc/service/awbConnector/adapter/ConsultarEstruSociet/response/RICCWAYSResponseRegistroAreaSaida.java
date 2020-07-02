/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAYSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAYSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nestrtSoct
     */
    @CommareaField(name = {"RICCWAYS-REGISTRO", "RICCWAYS-AREA-SAIDA", "RICCWAYS-NESTRT-SOCT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nestrtSoct = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWAYS-REGISTRO", "RICCWAYS-AREA-SAIDA", "RICCWAYS-IRZ-SCIAL"}, maxLength = 70,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo pprtcAcnst
     */
    @CommareaField(name = {"RICCWAYS-REGISTRO", "RICCWAYS-AREA-SAIDA", "RICCWAYS-PPRTC-ACNST"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pprtcAcnst = null;

    /**
     * Prop�sito:  Retornar o valor de nestrtSoct
     *
     * @return nestrtSoct
     */
    public int getNestrtSoct() {
        return nestrtSoct;
    }

    /**
     * Prop�sito:  Atribuir valor ao nestrtSoct
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNestrtSoct(int value) {
        this.nestrtSoct = value;
    }

    /**
     * Prop�sito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Prop�sito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pprtcAcnst
     *
     * @return pprtcAcnst
     */
    public BigDecimal getPprtcAcnst() {
        return pprtcAcnst;
    }

    /**
     * Prop�sito:  Atribuir valor ao pprtcAcnst
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPprtcAcnst(BigDecimal value) {
        this.pprtcAcnst = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAYSResponseRegistroAreaSaida() {
        super();
    }
}
