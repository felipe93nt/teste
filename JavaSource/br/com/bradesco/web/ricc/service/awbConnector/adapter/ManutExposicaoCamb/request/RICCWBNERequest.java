/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWBNERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBNERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBNE-HEADER", "RICCWBNE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBNE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBNE-HEADER", "RICCWBNE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo tpoMoeda
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-TPO-MOEDA"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 3, pic = "X(003)")
    protected String tpoMoeda = null;

    /**
     * Atributo areaEntrada
     */
    @CommareaContainer(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA"}, minOccurs = 3, maxOccurs = 3,
        fieldNumber = 7, type = RICCWBNERequestRegistroAreaEntrada.class)
    protected List<RICCWBNERequestRegistroAreaEntrada> areaEntrada = new ArrayList<RICCWBNERequestRegistroAreaEntrada>();

    /**
     * Atributo filler105
     */
    protected String filler105 = null;

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
     * Propósito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de tpoMoeda
     *
     * @return tpoMoeda
     */
    public String getTpoMoeda() {
        return tpoMoeda;
    }

    /**
     * Propósito:  Atribuir valor ao tpoMoeda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTpoMoeda(String value) {
        this.tpoMoeda = value;
    }

    /**
     * Propósito:  Retornar o valor de areaEntrada
     *
     * @return areaEntrada
     */
    public List<RICCWBNERequestRegistroAreaEntrada> getAreaEntrada() {
        if (areaEntrada == null) {
            areaEntrada = new  ArrayList<RICCWBNERequestRegistroAreaEntrada>();
        }
        return this.areaEntrada;
    }

    /**
     * Propósito:  Retornar o valor de fILLER105
     *
     * @return fILLER105
     */
    public String getFILLER105() {
        return filler105;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER105
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER105(String value) {
        this.filler105 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBNERequest() {
        super();
    }

    public void setAreaEntrada(List<RICCWBNERequestRegistroAreaEntrada> value) {
        this.areaEntrada = value;
    }
}
