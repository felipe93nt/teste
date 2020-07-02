/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAPSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAPSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ntrnspCarga
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-NTRNSP-CARGA"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int ntrnspCarga = 0;

    /**
     * Atributo nanoFrota
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-NANO-FROTA"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoFrota = 0;

    /**
     * Atributo pfrtPpria
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-PPRIA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfrtPpria = null;

    /**
     * Atributo pfrtPpriaN
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-PPRIA-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String pfrtPpriaN = null;

    /**
     * Atributo pfrtAgrdos
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-AGRDOS"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfrtAgrdos = null;

    /**
     * Atributo pfrtAgrdosN
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-AGRDOS-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String pfrtAgrdosN = null;

    /**
     * Atributo pfrtTceros
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-TCEROS"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfrtTceros = null;

    /**
     * Atributo pfrtTcerosN
     */
    @CommareaField(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA", "RICCWAPS-PFRT-TCEROS-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String pfrtTcerosN = null;

    /**
     * Propósito:  Retornar o valor de ntrnspCarga
     *
     * @return ntrnspCarga
     */
    public int getNtrnspCarga() {
        return ntrnspCarga;
    }

    /**
     * Propósito:  Atribuir valor ao ntrnspCarga
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNtrnspCarga(int value) {
        this.ntrnspCarga = value;
    }

    /**
     * Propósito:  Retornar o valor de nanoFrota
     *
     * @return nanoFrota
     */
    public int getNanoFrota() {
        return nanoFrota;
    }

    /**
     * Propósito:  Atribuir valor ao nanoFrota
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoFrota(int value) {
        this.nanoFrota = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtPpria
     *
     * @return pfrtPpria
     */
    public BigDecimal getPfrtPpria() {
        return pfrtPpria;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtPpria
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtPpria(BigDecimal value) {
        this.pfrtPpria = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtPpriaN
     *
     * @return pfrtPpriaN
     */
    public String getPfrtPpriaN() {
        return pfrtPpriaN;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtPpriaN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtPpriaN(String value) {
        this.pfrtPpriaN = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtAgrdos
     *
     * @return pfrtAgrdos
     */
    public BigDecimal getPfrtAgrdos() {
        return pfrtAgrdos;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtAgrdos
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtAgrdos(BigDecimal value) {
        this.pfrtAgrdos = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtAgrdosN
     *
     * @return pfrtAgrdosN
     */
    public String getPfrtAgrdosN() {
        return pfrtAgrdosN;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtAgrdosN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtAgrdosN(String value) {
        this.pfrtAgrdosN = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtTceros
     *
     * @return pfrtTceros
     */
    public BigDecimal getPfrtTceros() {
        return pfrtTceros;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtTceros
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtTceros(BigDecimal value) {
        this.pfrtTceros = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrtTcerosN
     *
     * @return pfrtTcerosN
     */
    public String getPfrtTcerosN() {
        return pfrtTcerosN;
    }

    /**
     * Propósito:  Atribuir valor ao pfrtTcerosN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrtTcerosN(String value) {
        this.pfrtTcerosN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAPSResponseRegistroAreaSaida() {
        super();
    }
}
