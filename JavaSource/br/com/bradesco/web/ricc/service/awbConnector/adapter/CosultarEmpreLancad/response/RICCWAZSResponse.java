/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAZSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAZSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAZS-HEADER", "RICCWAZS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAZS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAZS-HEADER", "RICCWAZS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 2100;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAZS-REGISTRO", "RICCWAZS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWAZS-QTOT-OCOR", fieldNumber = 3, type = RICCWAZSResponseRegistroAreaSaida.class)
    protected List<RICCWAZSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAZSResponseRegistroAreaSaida>();

    /**
     * Atributo vtotVgv
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-VTOT-VGV"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotVgv = null;

    /**
     * Atributo qtotEmpmt
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-QTOT-EMPMT"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 11, pic = "9(011)")
    protected long qtotEmpmt = 0L;

    /**
     * Atributo filler1
     */
    protected String filler1 = null;

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
    public List<RICCWAZSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAZSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de vtotVgv
     *
     * @return vtotVgv
     */
    public BigDecimal getVtotVgv() {
        return vtotVgv;
    }

    /**
     * Propósito:  Atribuir valor ao vtotVgv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotVgv(BigDecimal value) {
        this.vtotVgv = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotEmpmt
     *
     * @return qtotEmpmt
     */
    public long getQtotEmpmt() {
        return qtotEmpmt;
    }

    /**
     * Propósito:  Atribuir valor ao qtotEmpmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotEmpmt(long value) {
        this.qtotEmpmt = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER1
     *
     * @return fILLER1
     */
    public String getFILLER1() {
        return filler1;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER1(String value) {
        this.filler1 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAZSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAZSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
