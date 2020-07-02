/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWACSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWACSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo npatrmRelat
     */
    @CommareaField(name = {"RICCWACS-REGISTRO", "RICCWACS-AREA-SAIDA", "RICCWABS-NPATRM-RELAT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int npatrmRelat = 0;

    /**
     * Atributo rpatrm
     */
    @CommareaField(name = {"RICCWACS-REGISTRO", "RICCWACS-AREA-SAIDA", "RICCWACS-RPATRM"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 30, pic = "X(030)")
    protected String rpatrm = null;

    /**
     * Atributo vpatrm
     */
    @CommareaField(name = {"RICCWACS-REGISTRO", "RICCWACS-AREA-SAIDA", "RICCWACS-VPATRM"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vpatrm = null;

    /**
     * Prop�sito:  Retornar o valor de npatrmRelat
     *
     * @return npatrmRelat
     */
    public int getNpatrmRelat() {
        return npatrmRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao npatrmRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNpatrmRelat(int value) {
        this.npatrmRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rpatrm
     *
     * @return rpatrm
     */
    public String getRpatrm() {
        return rpatrm;
    }

    /**
     * Prop�sito:  Atribuir valor ao rpatrm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRpatrm(String value) {
        this.rpatrm = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vpatrm
     *
     * @return vpatrm
     */
    public BigDecimal getVpatrm() {
        return vpatrm;
    }

    /**
     * Prop�sito:  Atribuir valor ao vpatrm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpatrm(BigDecimal value) {
        this.vpatrm = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWACSResponseRegistroAreaSaida() {
        super();
    }
}
