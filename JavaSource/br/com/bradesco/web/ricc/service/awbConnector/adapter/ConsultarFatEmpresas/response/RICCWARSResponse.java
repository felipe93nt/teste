/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWARSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWARSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWARS-HEADER", "RICCWARS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWARS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWARS-HEADER", "RICCWARS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 500;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWARS-REGISTRO", "RICCWARS-AREA-SAIDA"}, minOccurs = 8, maxOccurs = 8,
        fieldNumber = 2, type = RICCWARSResponseRegistroAreaSaida.class)
    protected List<RICCWARSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWARSResponseRegistroAreaSaida>();

    /**
     * Atributo filler45
     */
    protected String filler45 = null;

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
    public List<RICCWARSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWARSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER45
     *
     * @return fILLER45
     */
    public String getFILLER45() {
        return filler45;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER45
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER45(String value) {
        this.filler45 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWARSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWARSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
