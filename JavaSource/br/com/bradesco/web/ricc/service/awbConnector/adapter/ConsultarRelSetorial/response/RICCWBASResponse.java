/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBASResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBASResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBAS-HEADER", "RICCWBAS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBAS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBAS-HEADER", "RICCWBAS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo cidtfdTrnsp
     */
    @CommareaField(name = {"RICCWBAS-REGISTRO", "RICCWBAS-CIDTFD-TRNSP"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 1, pic = "9(001)")
    protected int cidtfdTrnsp = 0;

    /**
     * Atributo cidtfdImobl
     */
    @CommareaField(name = {"RICCWBAS-REGISTRO", "RICCWBAS-CIDTFD-IMOBL"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int cidtfdImobl = 0;

    /**
     * Atributo cidtfdAgric
     */
    @CommareaField(name = {"RICCWBAS-REGISTRO", "RICCWBAS-CIDTFD-AGRIC"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int cidtfdAgric = 0;

    /**
     * Atributo cidtfdProj
     */
    @CommareaField(name = {"RICCWBAS-REGISTRO", "RICCWBAS-CIDTFD-PROJ"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int cidtfdProj = 0;

    /**
     * Atributo filler85
     */
    protected String filler85 = null;

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
     * Prop�sito:  Retornar o valor de cidtfdTrnsp
     *
     * @return cidtfdTrnsp
     */
    public int getCidtfdTrnsp() {
        return cidtfdTrnsp;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdTrnsp(int value) {
        this.cidtfdTrnsp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdImobl
     *
     * @return cidtfdImobl
     */
    public int getCidtfdImobl() {
        return cidtfdImobl;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdImobl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdImobl(int value) {
        this.cidtfdImobl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdAgric
     *
     * @return cidtfdAgric
     */
    public int getCidtfdAgric() {
        return cidtfdAgric;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdAgric
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdAgric(int value) {
        this.cidtfdAgric = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdProj
     *
     * @return cidtfdProj
     */
    public int getCidtfdProj() {
        return cidtfdProj;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdProj(int value) {
        this.cidtfdProj = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER85
     *
     * @return fILLER85
     */
    public String getFILLER85() {
        return filler85;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER85
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER85(String value) {
        this.filler85 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBASResponse() {
        super();
    }
}
