/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWABSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWABSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWABS-HEADER", "RICCWABS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWABS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWABS-HEADER", "RICCWABS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 5600;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWABS-REGISTRO", "RICCWABS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWABS-REGISTRO", "RICCWABS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWABS-QTOT-OCOR", fieldNumber = 3, type = RICCWABSResponseRegistroAreaSaida.class)
    protected List<RICCWABSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWABSResponseRegistroAreaSaida>();

    /**
     * Atributo filler11
     */
    protected String filler11 = null;

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
     * Prop�sito:  Retornar o valor de qtotOcor
     *
     * @return qtotOcor
     */
    public int getQtotOcor() {
        return qtotOcor;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotOcor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotOcor(int value) {
        this.qtotOcor = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWABSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWABSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER11
     *
     * @return fILLER11
     */
    public String getFILLER11() {
        return filler11;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER11
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER11(String value) {
        this.filler11 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWABSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWABSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
