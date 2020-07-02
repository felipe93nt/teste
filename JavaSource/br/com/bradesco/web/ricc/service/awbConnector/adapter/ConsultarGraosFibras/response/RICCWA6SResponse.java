/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA6SResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA6SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA6S-HEADER", "RICCWA6S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA6S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA6S-HEADER", "RICCWA6S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 1800;

    /**
     * Atributo ctpoRamoSoja
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-CTPO-RAMO-SOJA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamoSoja = 0;

    /**
     * Atributo ctpoRamoMilho
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-CTPO-RAMO-MILHO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamoMilho = 0;

    /**
     * Atributo ctpoRamoAlogodao
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-CTPO-RAMO-ALOGODAO"}, maxLength = 1, usage = "DISPLA"
        + "Y", fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamoAlogodao = 0;

    /**
     * Atributo ctpoRamo
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-CTPO-RAMO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamo = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 6, type = RICCWA6SResponseRegistroAreaSaida.class)
    protected List<RICCWA6SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA6SResponseRegistroAreaSaida>();

    /**
     * Atributo filler1
     */
    protected String filler1 = null;

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
     * Prop�sito:  Retornar o valor de ctpoRamoSoja
     *
     * @return ctpoRamoSoja
     */
    public int getCtpoRamoSoja() {
        return ctpoRamoSoja;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRamoSoja
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamoSoja(int value) {
        this.ctpoRamoSoja = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoRamoMilho
     *
     * @return ctpoRamoMilho
     */
    public int getCtpoRamoMilho() {
        return ctpoRamoMilho;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRamoMilho
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamoMilho(int value) {
        this.ctpoRamoMilho = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoRamoAlogodao
     *
     * @return ctpoRamoAlogodao
     */
    public int getCtpoRamoAlogodao() {
        return ctpoRamoAlogodao;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRamoAlogodao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamoAlogodao(int value) {
        this.ctpoRamoAlogodao = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoRamo
     *
     * @return ctpoRamo
     */
    public int getCtpoRamo() {
        return ctpoRamo;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRamo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamo(int value) {
        this.ctpoRamo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWA6SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA6SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER1
     *
     * @return fILLER1
     */
    public String getFILLER1() {
        return filler1;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER1(String value) {
        this.filler1 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA6SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA6SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
