/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAVSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAVSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAVS-HEADER", "RICCWAVS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAVS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAVS-HEADER", "RICCWAVS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 500;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 2, type = RICCWAVSResponseRegistroAreaSaida.class)
    protected List<RICCWAVSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAVSResponseRegistroAreaSaida>();

    /**
     * Atributo filler53
     */
    protected String filler53 = null;

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
    public List<RICCWAVSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAVSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER53
     *
     * @return fILLER53
     */
    public String getFILLER53() {
        return filler53;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER53
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER53(String value) {
        this.filler53 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAVSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAVSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
