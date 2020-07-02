/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWANSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWANSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWANS-HEADER", "RICCWANS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWANS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWANS-HEADER", "RICCWANS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 17700;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWANS-REGISTRO", "RICCWANS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWANS-REGISTRO", "RICCWANS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 30,
        dependsOn = "RICCWANS-QTOT-OCOR", fieldNumber = 3, type = RICCWANSResponseRegistroAreaSaida.class)
    protected List<RICCWANSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWANSResponseRegistroAreaSaida>();

    /**
     * Atributo filler35
     */
    protected String filler35 = null;

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
    public List<RICCWANSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWANSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER35
     *
     * @return fILLER35
     */
    public String getFILLER35() {
        return filler35;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER35
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER35(String value) {
        this.filler35 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWANSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWANSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
