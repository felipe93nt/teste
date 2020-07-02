/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWCDERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCDERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCDE-HEADER", "RICCWCDE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCDE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCDE-HEADER", "RICCWCDE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 1800;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCDE-REGISTRO", "RICCWCDE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCDE-REGISTRO", "RICCWCDE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCDE-REGISTRO", "RICCWCDE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCDE-REGISTRO", "RICCWCDE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo ctpoRamo
     */
    @CommareaField(name = {"RICCWCDE-REGISTRO", "RICCWCDE-CTPO-RAMO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamo = 0;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWCDE-REGISTRO", "RICCWCDE-AREA-ENTRADA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 7, type = RICCWCDERequestRegistroAreaEntrada.class)
    protected List<RICCWCDERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWCDERequestRegistroAreaEntrada>();

    /**
     * Atributo filler2
     */
    protected String filler2 = null;

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
     * Propósito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Propósito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Propósito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Propósito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Propósito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoRamo
     *
     * @return ctpoRamo
     */
    public int getCtpoRamo() {
        return ctpoRamo;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoRamo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamo(int value) {
        this.ctpoRamo = value;
    }

    /**
     * Propósito:  Retornar o valor de areaEntrada
     *
     * @return areaEntrada
     */
    public List<RICCWCDERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWCDERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER2
     *
     * @return fILLER2
     */
    public String getFILLER2() {
        return filler2;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER2
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER2(String value) {
        this.filler2 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCDERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWCDERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
