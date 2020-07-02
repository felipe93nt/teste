/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWB2ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB2ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB2E-HEADER", "RICCWB2E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB2E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB2E-HEADER", "RICCWB2E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB2E-REGISTRO", "RICCWB2E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB2E-REGISTRO", "RICCWB2E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB2E-REGISTRO", "RICCWB2E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo rotraLocac
     */
    @CommareaField(name = {"RICCWB2E-REGISTRO", "RICCWB2E-ROTRA-LOCAC"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 50, pic = "X(050)")
    protected String rotraLocac = null;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWB2E-REGISTRO", "RICCWB2E-AREA-ENTRADA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 6, type = RICCWB2ERequestRegistroAreaEntrada.class)
    protected List<RICCWB2ERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWB2ERequestRegistroAreaEntrada>();

    /**
     * Atributo filler1
     */
    protected String filler1 = null;

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
     * Propósito:  Retornar o valor de rotraLocac
     *
     * @return rotraLocac
     */
    public String getRotraLocac() {
        return rotraLocac;
    }

    /**
     * Propósito:  Atribuir valor ao rotraLocac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRotraLocac(String value) {
        this.rotraLocac = value;
    }

    /**
     * Propósito:  Retornar o valor de areaEntrada
     *
     * @return areaEntrada
     */
    public List<RICCWB2ERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWB2ERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER1
     *
     * @return fILLER1
     */
    public String getFILLER1() {
        return filler1;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER1
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
    public RICCWB2ERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWB2ERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
