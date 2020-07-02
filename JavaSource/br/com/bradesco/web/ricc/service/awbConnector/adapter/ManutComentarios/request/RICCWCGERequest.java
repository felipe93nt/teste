/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWCGERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de areaEntrada
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
     * Prop�sito:  Retornar o valor de fILLER0
     *
     * @return fILLER0
     */
    public String getFILLER0() {
        return filler0;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER0
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
