/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAJSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAJSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAJS-HEADER", "RICCWAJS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAJS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAJS-HEADER", "RICCWAJS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 11300;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWAJS-QTOT-OCOR", fieldNumber = 3, type = RICCWAJSResponseRegistroAreaSaida.class)
    protected List<RICCWAJSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAJSResponseRegistroAreaSaida>();

    /**
     * Atributo vtotContr
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-VTOT-CONTR"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotContr = null;

    /**
     * Atributo vtotSaldo
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-VTOT-SALDO"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotSaldo = null;

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
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWAJSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAJSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de vtotContr
     *
     * @return vtotContr
     */
    public BigDecimal getVtotContr() {
        return vtotContr;
    }

    /**
     * Propósito:  Atribuir valor ao vtotContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotContr(BigDecimal value) {
        this.vtotContr = value;
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
    public RICCWAJSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAJSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
