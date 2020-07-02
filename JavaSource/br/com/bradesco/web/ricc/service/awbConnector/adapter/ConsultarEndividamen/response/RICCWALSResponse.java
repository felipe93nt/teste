/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWALSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWALSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWALS-HEADER", "RICCWALS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWALS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWALS-HEADER", "RICCWALS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 13800;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo vtotSaldo
     */
    @CommareaField(name = {"RICCWALS-REGISTRO", "RICCWALS-VTOT-SALDO"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotSaldo = null;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWALS-REGISTRO", "RICCWALS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWALS-QTOT-OCOR", fieldNumber = 4, type = RICCWALSResponseRegistroAreaSaida.class)
    protected List<RICCWALSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWALSResponseRegistroAreaSaida>();

    /**
     * Atributo filler3
     */
    protected String filler3 = null;

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
     * Propósito:  Retornar o valor de qtotOcor
     *
     * @return qtotOcor
     */
    public int getQtotOcor() {
        return qtotOcor;
    }

    /**
     * Propósito:  Atribuir valor ao qtotOcor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotOcor(int value) {
        this.qtotOcor = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotSaldo
     *
     * @return vtotSaldo
     */
    public BigDecimal getVtotSaldo() {
        return vtotSaldo;
    }

    /**
     * Propósito:  Atribuir valor ao vtotSaldo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotSaldo(BigDecimal value) {
        this.vtotSaldo = value;
    }

    /**
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWALSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWALSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER3
     *
     * @return fILLER3
     */
    public String getFILLER3() {
        return filler3;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER3(String value) {
        this.filler3 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWALSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWALSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
