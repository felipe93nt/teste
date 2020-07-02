/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB0ERequestRegistroAreaEntrada 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB0ERequestRegistroAreaEntrada extends AnnotatedAdapter {

    /**
     * Atributo nreajsTrnsp
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-NREAJS-TRNSP"},
        maxLength = 2, usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int nreajsTrnsp = 0;

    /**
     * Atributo nanoTrsp
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-NANO-TRSP"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoTrsp = 0;

    /**
     * Atributo ptranMuncp
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-MUNCP"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptranMuncp = null;

    /**
     * Atributo ptranMuncpN
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-MUNCP-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String ptranMuncpN = null;

    /**
     * Atributo ptranImuncp
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-IMUNCP"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptranImuncp = null;

    /**
     * Atributo ptranImuncpN
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-IMUNCP-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String ptranImuncpN = null;

    /**
     * Atributo ptranIestad
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-IESTAD"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptranIestad = null;

    /**
     * Atributo ptranIestadN
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-IESTAD-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String ptranIestadN = null;

    /**
     * Atributo ptranInacio
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-INACIO"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptranInacio = null;

    /**
     * Atributo ptranInacioN
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-INACIO-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String ptranInacioN = null;

    /**
     * Atributo ptranFrtmto
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-FRTMTO"},
        maxLength = 5, usage = "DISPLAY", fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptranFrtmto = null;

    /**
     * Atributo ptranFrtmtoN
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA", "RICCWB0E-PTRAN-FRTMTO-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String ptranFrtmtoN = null;

    /**
     * Prop�sito:  Retornar o valor de nreajsTrnsp
     *
     * @return nreajsTrnsp
     */
    public int getNreajsTrnsp() {
        return nreajsTrnsp;
    }

    /**
     * Prop�sito:  Atribuir valor ao nreajsTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNreajsTrnsp(int value) {
        this.nreajsTrnsp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nanoTrsp
     *
     * @return nanoTrsp
     */
    public int getNanoTrsp() {
        return nanoTrsp;
    }

    /**
     * Prop�sito:  Atribuir valor ao nanoTrsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoTrsp(int value) {
        this.nanoTrsp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranMuncp
     *
     * @return ptranMuncp
     */
    public BigDecimal getPtranMuncp() {
        return ptranMuncp;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranMuncp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranMuncp(BigDecimal value) {
        this.ptranMuncp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranMuncpN
     *
     * @return ptranMuncpN
     */
    public String getPtranMuncpN() {
        return ptranMuncpN;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranMuncpN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranMuncpN(String value) {
        this.ptranMuncpN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranImuncp
     *
     * @return ptranImuncp
     */
    public BigDecimal getPtranImuncp() {
        return ptranImuncp;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranImuncp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranImuncp(BigDecimal value) {
        this.ptranImuncp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranImuncpN
     *
     * @return ptranImuncpN
     */
    public String getPtranImuncpN() {
        return ptranImuncpN;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranImuncpN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranImuncpN(String value) {
        this.ptranImuncpN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranIestad
     *
     * @return ptranIestad
     */
    public BigDecimal getPtranIestad() {
        return ptranIestad;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranIestad
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranIestad(BigDecimal value) {
        this.ptranIestad = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranIestadN
     *
     * @return ptranIestadN
     */
    public String getPtranIestadN() {
        return ptranIestadN;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranIestadN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranIestadN(String value) {
        this.ptranIestadN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranInacio
     *
     * @return ptranInacio
     */
    public BigDecimal getPtranInacio() {
        return ptranInacio;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranInacio
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranInacio(BigDecimal value) {
        this.ptranInacio = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranInacioN
     *
     * @return ptranInacioN
     */
    public String getPtranInacioN() {
        return ptranInacioN;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranInacioN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranInacioN(String value) {
        this.ptranInacioN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranFrtmto
     *
     * @return ptranFrtmto
     */
    public BigDecimal getPtranFrtmto() {
        return ptranFrtmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranFrtmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranFrtmto(BigDecimal value) {
        this.ptranFrtmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ptranFrtmtoN
     *
     * @return ptranFrtmtoN
     */
    public String getPtranFrtmtoN() {
        return ptranFrtmtoN;
    }

    /**
     * Prop�sito:  Atribuir valor ao ptranFrtmtoN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtranFrtmtoN(String value) {
        this.ptranFrtmtoN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB0ERequestRegistroAreaEntrada() {
        super();
    }
}
