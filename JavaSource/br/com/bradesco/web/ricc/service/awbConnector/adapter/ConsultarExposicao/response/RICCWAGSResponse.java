/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAGSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAGSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAGS-HEADER", "RICCWAGS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAGS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAGS-HEADER", "RICCWAGS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo tpoMoeda
     */
    @CommareaField(name = {"RICCWAGS-REGISTRO", "RICCWAGS-TPO-MOEDA"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "X(003)")
    protected String tpoMoeda = null;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAGS-REGISTRO", "RICCWAGS-AREA-SAIDA"}, minOccurs = 3, maxOccurs = 3,
        fieldNumber = 3, type = RICCWAGSResponseRegistroAreaSaida.class)
    protected List<RICCWAGSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAGSResponseRegistroAreaSaida>();

    /**
     * Atributo filler21
     */
    protected String filler21 = null;

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
     * Prop�sito:  Retornar o valor de tpoMoeda
     *
     * @return tpoMoeda
     */
    public String getTpoMoeda() {
        return tpoMoeda;
    }

    /**
     * Prop�sito:  Atribuir valor ao tpoMoeda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTpoMoeda(String value) {
        this.tpoMoeda = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWAGSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAGSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER21
     *
     * @return fILLER21
     */
    public String getFILLER21() {
        return filler21;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER21
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER21(String value) {
        this.filler21 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAGSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAGSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
