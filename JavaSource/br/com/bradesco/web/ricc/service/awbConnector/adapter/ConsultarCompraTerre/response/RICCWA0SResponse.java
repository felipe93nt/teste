/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 18/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA0SResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA0SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA0S-HEADER", "RICCWA0S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA0S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA0S-HEADER", "RICCWA0S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 7400;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWA0S-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo vtotTerreno
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWALS-VTOT-TERRENO"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotTerreno = null;

    /**
     * Atributo vtotProjetada
     */
    @CommareaField(name = {"RICCWA0S-REGISTRO", "RICCWALS-VTOT-PROJETADA"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotProjetada = null;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA0S-REGISTRO", "RICCWA0S-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWA0S-QTOT-OCOR", fieldNumber = 6, type = RICCWA0SResponseRegistroAreaSaida.class)
    protected List<RICCWA0SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA0SResponseRegistroAreaSaida>();

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
     * Prop�sito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Prop�sito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
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
     * Prop�sito:  Retornar o valor de vtotTerreno
     *
     * @return vtotTerreno
     */
    public BigDecimal getVtotTerreno() {
        return vtotTerreno;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotTerreno
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotTerreno(BigDecimal value) {
        this.vtotTerreno = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotProjetada
     *
     * @return vtotProjetada
     */
    public BigDecimal getVtotProjetada() {
        return vtotProjetada;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotProjetada
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotProjetada(BigDecimal value) {
        this.vtotProjetada = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWA0SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA0SResponseRegistroAreaSaida>();
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
    public RICCWA0SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA0SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
