/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 18/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA0SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA0SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nprevtLcto
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-NPREVT-LCTO"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nprevtLcto = 0;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-IEMPTO-IMOB"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rlocEmpto
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-RLOC-EMPTO"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 40, pic = "X(040)")
    protected String rlocEmpto = null;

    /**
     * Atributo vtotTerrn
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-VTOT-TERRN"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotTerrn = null;

    /**
     * Atributo vprevt
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-VPREVT"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vprevt = null;

    /**
     * Atributo dprevtLcto
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-DPREVT-LCTO"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 10, pic = "X(010)")
    protected String dprevtLcto = null;

    /**
     * Atributo csitLcto
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA", "RICCWA0S-CSIT-LCTO"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int csitLcto = 0;

    /**
     * Propósito:  Retornar o valor de nprevtLcto
     *
     * @return nprevtLcto
     */
    public int getNprevtLcto() {
        return nprevtLcto;
    }

    /**
     * Propósito:  Atribuir valor ao nprevtLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNprevtLcto(int value) {
        this.nprevtLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de iemptoImob
     *
     * @return iemptoImob
     */
    public String getIemptoImob() {
        return iemptoImob;
    }

    /**
     * Propósito:  Atribuir valor ao iemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIemptoImob(String value) {
        this.iemptoImob = value;
    }

    /**
     * Propósito:  Retornar o valor de rlocEmpto
     *
     * @return rlocEmpto
     */
    public String getRlocEmpto() {
        return rlocEmpto;
    }

    /**
     * Propósito:  Atribuir valor ao rlocEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRlocEmpto(String value) {
        this.rlocEmpto = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotTerrn
     *
     * @return vtotTerrn
     */
    public BigDecimal getVtotTerrn() {
        return vtotTerrn;
    }

    /**
     * Propósito:  Atribuir valor ao vtotTerrn
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotTerrn(BigDecimal value) {
        this.vtotTerrn = value;
    }

    /**
     * Propósito:  Retornar o valor de vprevt
     *
     * @return vprevt
     */
    public BigDecimal getVprevt() {
        return vprevt;
    }

    /**
     * Propósito:  Atribuir valor ao vprevt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVprevt(BigDecimal value) {
        this.vprevt = value;
    }

    /**
     * Propósito:  Retornar o valor de dprevtLcto
     *
     * @return dprevtLcto
     */
    public String getDprevtLcto() {
        return dprevtLcto;
    }

    /**
     * Propósito:  Atribuir valor ao dprevtLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDprevtLcto(String value) {
        this.dprevtLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de csitLcto
     *
     * @return csitLcto
     */
    public int getCsitLcto() {
        return csitLcto;
    }

    /**
     * Propósito:  Atribuir valor ao csitLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsitLcto(int value) {
        this.csitLcto = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA0SResponseRegistroAreaSaida() {
        super();
    }
}
