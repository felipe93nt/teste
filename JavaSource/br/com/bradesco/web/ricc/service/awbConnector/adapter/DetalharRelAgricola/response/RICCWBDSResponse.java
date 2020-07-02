/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBDSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBDSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBDS-HEADER", "RICCWBDS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBDS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBDS-HEADER", "RICCWBDS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo iusinaAcucr
     */
    @CommareaField(name = {"RICCWBDS-REGISTRO", "RICCWBDS-IUSINA-ACUCR"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 30, pic = "X(030)")
    protected String iusinaAcucr = null;

    /**
     * Atributo filler91
     */
    protected String filler91 = null;

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
     * Propósito:  Retornar o valor de iusinaAcucr
     *
     * @return iusinaAcucr
     */
    public String getIusinaAcucr() {
        return iusinaAcucr;
    }

    /**
     * Propósito:  Atribuir valor ao iusinaAcucr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIusinaAcucr(String value) {
        this.iusinaAcucr = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER91
     *
     * @return fILLER91
     */
    public String getFILLER91() {
        return filler91;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER91
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER91(String value) {
        this.filler91 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBDSResponse() {
        super();
    }
}
