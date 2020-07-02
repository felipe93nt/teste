/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWBZERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBZERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBZE-HEADER", "RICCWBZE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBZE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBZE-HEADER", "RICCWBZE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBZE-REGISTRO", "RICCWBZE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBZE-REGISTRO", "RICCWBZE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBZE-REGISTRO", "RICCWBZE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWBZE-REGISTRO", "RICCWBZE-AREA-ENTRADA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 5, type = RICCWBZERequestRegistroAreaEntrada.class)
    protected List<RICCWBZERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWBZERequestRegistroAreaEntrada>();

    /**
     * Atributo filler117
     */
    protected String filler117 = null;

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
     * Propósito:  Retornar o valor de areaEntrada
     *
     * @return areaEntrada
     */
    public List<RICCWBZERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWBZERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER117
     *
     * @return fILLER117
     */
    public String getFILLER117() {
        return filler117;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER117
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER117(String value) {
        this.filler117 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBZERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWBZERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
