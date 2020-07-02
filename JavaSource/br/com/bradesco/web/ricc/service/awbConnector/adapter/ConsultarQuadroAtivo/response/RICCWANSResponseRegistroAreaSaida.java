/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWANSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWANSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nquadrAtiv
     */
    @CommareaField(name = {"RICCWANS-REGISTRO", "RICCWANS-AREA-SAIDA", "RICCWANS-NQUADR-ATIV"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nquadrAtiv = 0;

    /**
     * Atributo rativo
     */
    @CommareaField(name = {"RICCWANS-REGISTRO", "RICCWANS-AREA-SAIDA", "RICCWANS-RATIVO"}, maxLength = 70,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 70, pic = "X(070)")
    protected String rativo = null;

    /**
     * Atributo pprtcpAtiv
     */
    @CommareaField(name = {"RICCWANS-REGISTRO", "RICCWANS-AREA-SAIDA", "RICCWANS-PPRTCP-ATIV"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pprtcpAtiv = null;

    /**
     * Atributo rinfoRelvt
     */
    @CommareaField(name = {"RICCWANS-REGISTRO", "RICCWANS-AREA-SAIDA", "RICCWANS-RINFO-RELVT"},
        maxLength = 500, usage = "DISPLAY", fieldNumber = 3, maxBytes = 500, pic = "X(500)")
    protected String rinfoRelvt = null;

    /**
     * Propósito:  Retornar o valor de nquadrAtiv
     *
     * @return nquadrAtiv
     */
    public int getNquadrAtiv() {
        return nquadrAtiv;
    }

    /**
     * Propósito:  Atribuir valor ao nquadrAtiv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNquadrAtiv(int value) {
        this.nquadrAtiv = value;
    }

    /**
     * Propósito:  Retornar o valor de rativo
     *
     * @return rativo
     */
    public String getRativo() {
        return rativo;
    }

    /**
     * Propósito:  Atribuir valor ao rativo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRativo(String value) {
        this.rativo = value;
    }

    /**
     * Propósito:  Retornar o valor de pprtcpAtiv
     *
     * @return pprtcpAtiv
     */
    public BigDecimal getPprtcpAtiv() {
        return pprtcpAtiv;
    }

    /**
     * Propósito:  Atribuir valor ao pprtcpAtiv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPprtcpAtiv(BigDecimal value) {
        this.pprtcpAtiv = value;
    }

    /**
     * Propósito:  Retornar o valor de rinfoRelvt
     *
     * @return rinfoRelvt
     */
    public String getRinfoRelvt() {
        return rinfoRelvt;
    }

    /**
     * Propósito:  Atribuir valor ao rinfoRelvt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRinfoRelvt(String value) {
        this.rinfoRelvt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWANSResponseRegistroAreaSaida() {
        super();
    }
}
