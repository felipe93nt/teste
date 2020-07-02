/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAWSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAWSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAWS-HEADER", "RICCWAWS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAWS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAWS-HEADER", "RICCWAWS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 2200;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWAWS-REGISTRO", "RICCWAWS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAWS-REGISTRO", "RICCWAWS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWAWS-QTOT-OCOR", fieldNumber = 3, type = RICCWAWSResponseRegistroAreaSaida.class)
    protected List<RICCWAWSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAWSResponseRegistroAreaSaida>();

    /**
     * Atributo filler5
     */
    protected String filler5 = null;

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
    public List<RICCWAWSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAWSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER5
     *
     * @return fILLER5
     */
    public String getFILLER5() {
        return filler5;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER5
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER5(String value) {
        this.filler5 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAWSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAWSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
