/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA9SResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA9SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ctpoComent
     */
    @CommareaField(name = {"RICCWA9S-REGISTRO", "RICCWA9S-AREA-SAIDA", "RICCWA9S-CTPO-COMENT"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(0002)")
    protected int ctpoComent = 0;

    /**
     * Atributo cseqComent
     */
    @CommareaField(name = {"RICCWA9S-REGISTRO", "RICCWA9S-AREA-SAIDA", "RICCWA9S-CSEQ-COMENT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 9, pic = "9(0009)")
    protected int cseqComent = 0;

    /**
     * Atributo rcomenRelt
     */
    @CommareaField(name = {"RICCWA9S-REGISTRO", "RICCWA9S-AREA-SAIDA", "RICCWA9S-RCOMEN-RELT"},
        maxLength = 5000, usage = "DISPLAY", fieldNumber = 2, maxBytes = 5000, pic = "X(5000)")
    protected String rcomenRelt = null;

    /**
     * Prop�sito:  Retornar o valor de ctpoComent
     *
     * @return ctpoComent
     */
    public int getCtpoComent() {
        return ctpoComent;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoComent
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoComent(int value) {
        this.ctpoComent = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cseqComent
     *
     * @return cseqComent
     */
    public int getCseqComent() {
        return cseqComent;
    }

    /**
     * Prop�sito:  Atribuir valor ao cseqComent
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCseqComent(int value) {
        this.cseqComent = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rcomenRelt
     *
     * @return rcomenRelt
     */
    public String getRcomenRelt() {
        return rcomenRelt;
    }

    /**
     * Prop�sito:  Atribuir valor ao rcomenRelt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRcomenRelt(String value) {
        this.rcomenRelt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA9SResponseRegistroAreaSaida() {
        super();
    }
}