/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAOSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAOSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncliFornc
     */
    @CommareaField(name = {"RICCWAOS-REGISTRO", "RICCWAOS-AREA-SAIDA", "RICCWAOS-NCLI-FORNC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int ncliFornc = 0;

    /**
     * Atributo ctpoCli
     */
    @CommareaField(name = {"RICCWAOS-REGISTRO", "RICCWAOS-AREA-SAIDA", "RICCWAOS-CTPO-CLI"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "9(001)")
    protected int ctpoCli = 0;

    /**
     * Atributo rcliFornc
     */
    @CommareaField(name = {"RICCWAOS-REGISTRO", "RICCWAOS-AREA-SAIDA", "RICCWAOS-RCLI-FORNC"}, maxLength = 80,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 80, pic = "X(080)")
    protected String rcliFornc = null;

    /**
     * Atributo pcliFornc
     */
    @CommareaField(name = {"RICCWAOS-REGISTRO", "RICCWAOS-AREA-SAIDA", "RICCWAOS-PCLI-FORNC"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcliFornc = null;

    /**
     * Prop�sito:  Retornar o valor de ncliFornc
     *
     * @return ncliFornc
     */
    public int getNcliFornc() {
        return ncliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcliFornc(int value) {
        this.ncliFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoCli
     *
     * @return ctpoCli
     */
    public int getCtpoCli() {
        return ctpoCli;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoCli
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoCli(int value) {
        this.ctpoCli = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rcliFornc
     *
     * @return rcliFornc
     */
    public String getRcliFornc() {
        return rcliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao rcliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRcliFornc(String value) {
        this.rcliFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcliFornc
     *
     * @return pcliFornc
     */
    public BigDecimal getPcliFornc() {
        return pcliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcliFornc(BigDecimal value) {
        this.pcliFornc = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAOSResponseRegistroAreaSaida() {
        super();
    }
}
