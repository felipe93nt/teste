/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWASSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWASSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWASS-HEADER", "RICCWASS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWASS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWASS-HEADER", "RICCWASS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWASSResponseRegistroAreaSaida.class)
    protected List<RICCWASSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWASSResponseRegistroAreaSaida>();

    /**
     * Atributo filler47
     */
    protected String filler47 = null;

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
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWASSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWASSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER47
     *
     * @return fILLER47
     */
    public String getFILLER47() {
        return filler47;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER47
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER47(String value) {
        this.filler47 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWASSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWASSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
