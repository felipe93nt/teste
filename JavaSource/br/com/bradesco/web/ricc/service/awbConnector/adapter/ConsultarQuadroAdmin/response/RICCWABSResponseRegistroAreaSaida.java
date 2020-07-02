/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWABSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWABSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nseqQuadr
     */
    @CommareaField(name = {"RICCWABS-REGISTRO", "RICCWABS-AREA-SAIDA", "RICCWABS-NSEQ-QUADR"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nseqQuadr = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWABS-REGISTRO", "RICCWABS-AREA-SAIDA", "RICCWABS-IRZ-SCIAL"}, maxLength = 70,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo rcargo
     */
    @CommareaField(name = {"RICCWABS-REGISTRO", "RICCWABS-AREA-SAIDA", "RICCWABS-RCARGO"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 30, pic = "X(030)")
    protected String rcargo = null;

    /**
     * Prop�sito:  Retornar o valor de nseqQuadr
     *
     * @return nseqQuadr
     */
    public int getNseqQuadr() {
        return nseqQuadr;
    }

    /**
     * Prop�sito:  Atribuir valor ao nseqQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNseqQuadr(int value) {
        this.nseqQuadr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Prop�sito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rcargo
     *
     * @return rcargo
     */
    public String getRcargo() {
        return rcargo;
    }

    /**
     * Prop�sito:  Atribuir valor ao rcargo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRcargo(String value) {
        this.rcargo = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWABSResponseRegistroAreaSaida() {
        super();
    }
}
