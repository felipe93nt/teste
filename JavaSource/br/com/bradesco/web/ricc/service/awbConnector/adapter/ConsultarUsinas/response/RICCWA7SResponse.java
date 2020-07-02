/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 20/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA7SResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA7SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA7S-HEADER", "RICCWA7S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA7S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA7S-HEADER", "RICCWA7S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 1200;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA7S-REGISTRO", "RICCWA7S-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWA7SResponseRegistroAreaSaida.class)
    protected List<RICCWA7SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA7SResponseRegistroAreaSaida>();

    /**
     * Atributo filler2
     */
    protected String filler2 = null;

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
    public List<RICCWA7SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA7SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER2
     *
     * @return fILLER2
     */
    public String getFILLER2() {
        return filler2;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER2(String value) {
        this.filler2 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA7SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA7SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
