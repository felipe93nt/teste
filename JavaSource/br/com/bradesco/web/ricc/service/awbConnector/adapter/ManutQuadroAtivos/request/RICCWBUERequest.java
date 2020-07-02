/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBUERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBUERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBUE-HEADER", "RICCWBUE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBUE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBUE-HEADER", "RICCWBUE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 800;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo nquadrAtivo
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-NQUADR-ATIVO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int nquadrAtivo = 0;

    /**
     * Atributo rativo
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-RATIVO"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 70, pic = "X(070)")
    protected String rativo = null;

    /**
     * Atributo pprtcpAtiv
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-PPRTCP-ATIV"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pprtcpAtiv = null;

    /**
     * Atributo rinfoRelvt
     */
    @CommareaField(name = {"RICCWBUE-REGISTRO", "RICCWBUE-RINFO-RELVT"}, maxLength = 500, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 500, pic = "X(500)")
    protected String rinfoRelvt = null;

    /**
     * Atributo filler112
     */
    protected String filler112 = null;

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
     * Prop�sito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Prop�sito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Prop�sito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nquadrAtivo
     *
     * @return nquadrAtivo
     */
    public int getNquadrAtivo() {
        return nquadrAtivo;
    }

    /**
     * Prop�sito:  Atribuir valor ao nquadrAtivo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNquadrAtivo(int value) {
        this.nquadrAtivo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rativo
     *
     * @return rativo
     */
    public String getRativo() {
        return rativo;
    }

    /**
     * Prop�sito:  Atribuir valor ao rativo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRativo(String value) {
        this.rativo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pprtcpAtiv
     *
     * @return pprtcpAtiv
     */
    public BigDecimal getPprtcpAtiv() {
        return pprtcpAtiv;
    }

    /**
     * Prop�sito:  Atribuir valor ao pprtcpAtiv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPprtcpAtiv(BigDecimal value) {
        this.pprtcpAtiv = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rinfoRelvt
     *
     * @return rinfoRelvt
     */
    public String getRinfoRelvt() {
        return rinfoRelvt;
    }

    /**
     * Prop�sito:  Atribuir valor ao rinfoRelvt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRinfoRelvt(String value) {
        this.rinfoRelvt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER112
     *
     * @return fILLER112
     */
    public String getFILLER112() {
        return filler112;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER112
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER112(String value) {
        this.filler112 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBUERequest() {
        super();
    }
}