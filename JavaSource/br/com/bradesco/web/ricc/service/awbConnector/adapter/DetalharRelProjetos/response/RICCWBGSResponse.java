/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBGSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBGSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBGS-HEADER", "RICCWBGS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBGS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBGS-HEADER", "RICCWBGS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo iprojEmpr
     */
    @CommareaField(name = {"RICCWBGS-REGISTRO", "RICCWBGS-IPROJ-EMPR"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 30, pic = "X(030)")
    protected String iprojEmpr = null;

    /**
     * Atributo filler97
     */
    protected String filler97 = null;

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
     * Prop�sito:  Retornar o valor de iprojEmpr
     *
     * @return iprojEmpr
     */
    public String getIprojEmpr() {
        return iprojEmpr;
    }

    /**
     * Prop�sito:  Atribuir valor ao iprojEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIprojEmpr(String value) {
        this.iprojEmpr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER97
     *
     * @return fILLER97
     */
    public String getFILLER97() {
        return filler97;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER97
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER97(String value) {
        this.filler97 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBGSResponse() {
        super();
    }
}
