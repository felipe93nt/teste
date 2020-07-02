/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWB0ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB0ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB0E-HEADER", "RICCWB0E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB0E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB0E-HEADER", "RICCWB0E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB0E-REGISTRO", "RICCWB0E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWB0E-REGISTRO", "RICCWB0E-AREA-ENTRADA"}, minOccurs = 4, maxOccurs = 4,
        fieldNumber = 5, type = RICCWB0ERequestRegistroAreaEntrada.class)
    protected List<RICCWB0ERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWB0ERequestRegistroAreaEntrada>();

    /**
     * Atributo filler118
     */
    protected String filler118 = null;

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
    public List<RICCWB0ERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWB0ERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER118
     *
     * @return fILLER118
     */
    public String getFILLER118() {
        return filler118;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER118
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER118(String value) {
        this.filler118 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB0ERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWB0ERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
