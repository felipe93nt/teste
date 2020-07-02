/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWATSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWATSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWATS-HEADER", "RICCWATS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWATS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWATS-HEADER", "RICCWATS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWATS-REGISTRO", "RICCWATS-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWATSResponseRegistroAreaSaida.class)
    protected List<RICCWATSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWATSResponseRegistroAreaSaida>();

    /**
     * Atributo filler49
     */
    protected String filler49 = null;

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
    public List<RICCWATSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWATSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER49
     *
     * @return fILLER49
     */
    public String getFILLER49() {
        return filler49;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER49
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER49(String value) {
        this.filler49 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWATSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWATSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
