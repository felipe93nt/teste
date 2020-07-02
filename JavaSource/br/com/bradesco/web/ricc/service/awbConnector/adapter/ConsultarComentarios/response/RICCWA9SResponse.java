/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA9SResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA9SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA9S-HEADER", "RICCWA9S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA9S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA9S-HEADER", "RICCWA9S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 20200;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA9S-REGISTRO", "RICCWA9S-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWA9SResponseRegistroAreaSaida.class)
    protected List<RICCWA9SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA9SResponseRegistroAreaSaida>();

    /**
     * Atributo filler81
     */
    protected String filler81 = null;

    /**
     * Prop�sito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWA9SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA9SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER81
     *
     * @return fILLER81
     */
    public String getFILLER81() {
        return filler81;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER81
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER81(String value) {
        this.filler81 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA9SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA9SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
