/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWCGERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCGERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCGE-HEADER", "RICCWCGE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCGE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCGE-HEADER", "RICCWCGE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 20200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCGE-REGISTRO", "RICCWCGE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCGE-REGISTRO", "RICCWCGE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCGE-REGISTRO", "RICCWCGE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWCGE-REGISTRO", "RICCWCGE-AREA-ENTRADA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 5, type = RICCWCGERequestRegistroAreaEntrada.class)
    protected List<RICCWCGERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWCGERequestRegistroAreaEntrada>();

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWCGE-REGISTRO", "FILLER"}, maxLength = 122, usage = "DISPLAY", fieldNumber = 6,
        maxBytes = 122, pic = "X(122)")
    protected String filler0 = null;

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
    public List<RICCWCGERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWCGERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER0
     *
     * @return fILLER0
     */
    public String getFILLER0() {
        return filler0;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER0
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER0(String value) {
        this.filler0 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCGERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWCGERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
