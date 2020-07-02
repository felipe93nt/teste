/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAPSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAPSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAPS-HEADER", "RICCWAPS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAPS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAPS-HEADER", "RICCWAPS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 250;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAPS-REGISTRO", "RICCWAPS-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWAPSResponseRegistroAreaSaida.class)
    protected List<RICCWAPSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAPSResponseRegistroAreaSaida>();

    /**
     * Atributo filler39
     */
    protected String filler39 = null;

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
    public List<RICCWAPSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAPSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER39
     *
     * @return fILLER39
     */
    public String getFILLER39() {
        return filler39;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER39
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER39(String value) {
        this.filler39 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAPSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAPSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
