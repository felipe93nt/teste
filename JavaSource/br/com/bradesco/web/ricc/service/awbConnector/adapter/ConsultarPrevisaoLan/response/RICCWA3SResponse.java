/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA3SResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA3SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA3S-HEADER", "RICCWA3S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA3S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA3S-HEADER", "RICCWA3S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 5300;

    /**
     * Atributo cindcdObrig
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-CINDCD-OBRIG"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 1, pic = "9(001)")
    protected int cindcdObrig = 0;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWA3S-QTOT-OCOR", fieldNumber = 4, type = RICCWA3SResponseRegistroAreaSaida.class)
    protected List<RICCWA3SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA3SResponseRegistroAreaSaida>();

    /**
     * Atributo filler69
     */
    protected String filler69 = null;

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
     * Propósito:  Retornar o valor de cindcdObrig
     *
     * @return cindcdObrig
     */
    public int getCindcdObrig() {
        return cindcdObrig;
    }

    /**
     * Propósito:  Atribuir valor ao cindcdObrig
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCindcdObrig(int value) {
        this.cindcdObrig = value;
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
    public List<RICCWA3SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA3SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER69
     *
     * @return fILLER69
     */
    public String getFILLER69() {
        return filler69;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER69
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER69(String value) {
        this.filler69 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA3SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA3SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
