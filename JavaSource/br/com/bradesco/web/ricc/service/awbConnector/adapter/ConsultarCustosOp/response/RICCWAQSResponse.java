/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 13/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAQSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAQSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAQS-HEADER", "RICCWAQS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAQS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAQS-HEADER", "RICCWAQS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 250;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAQS-REGISTRO", "RICCWAQS-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWAQSResponseRegistroAreaSaida.class)
    protected List<RICCWAQSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAQSResponseRegistroAreaSaida>();

    /**
     * Atributo filler5
     */
    protected String filler5 = null;

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
    public List<RICCWAQSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAQSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER5
     *
     * @return fILLER5
     */
    public String getFILLER5() {
        return filler5;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER5
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
    public RICCWAQSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAQSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
