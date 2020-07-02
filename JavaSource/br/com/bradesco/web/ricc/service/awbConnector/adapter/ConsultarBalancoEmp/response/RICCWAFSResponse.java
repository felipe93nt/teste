/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 01/07/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAFSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAFSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAFS-HEADER", "RICCWAFS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAFS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAFS-HEADER", "RICCWAFS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 800;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-IRZ-SCIAL"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA"}, minOccurs = 3, maxOccurs = 3,
        fieldNumber = 3, type = RICCWAFSResponseRegistroAreaSaida.class)
    protected List<RICCWAFSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWAFSResponseRegistroAreaSaida>();

    /**
     * Atributo filler3
     */
    protected String filler3 = null;

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
     * Propósito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Propósito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWAFSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWAFSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER3
     *
     * @return fILLER3
     */
    public String getFILLER3() {
        return filler3;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER3
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER3(String value) {
        this.filler3 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAFSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWAFSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
