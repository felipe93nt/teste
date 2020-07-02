/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 04/01/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBOERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBOERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBOE-HEADER", "RICCWBOE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBOE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBOE-HEADER", "RICCWBOE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo csitValdcReg
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-CSIT-VALDC-REG"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 1, pic = "9(001)")
    protected int csitValdcReg = 0;

    /**
     * Atributo nparmzDe
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-NPARMZ-DE"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int nparmzDe = 0;

    /**
     * Atributo nparmzPara
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-NPARMZ-PARA"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nparmzPara = 0;

    /**
     * Atributo cusuarValdc
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-CUSUAR-VALDC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "X(009)")
    protected String cusuarValdc = null;

    /**
     * Atributo rjustif
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-RJUSTIF"}, maxLength = 256, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 256, pic = "X(256)")
    protected String rjustif = null;

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
     * Propósito:  Retornar o valor de csitValdcReg
     *
     * @return csitValdcReg
     */
    public int getCsitValdcReg() {
        return csitValdcReg;
    }

    /**
     * Propósito:  Atribuir valor ao csitValdcReg
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsitValdcReg(int value) {
        this.csitValdcReg = value;
    }

    /**
     * Propósito:  Retornar o valor de nparmzDe
     *
     * @return nparmzDe
     */
    public int getNparmzDe() {
        return nparmzDe;
    }

    /**
     * Propósito:  Atribuir valor ao nparmzDe
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNparmzDe(int value) {
        this.nparmzDe = value;
    }

    /**
     * Propósito:  Retornar o valor de nparmzPara
     *
     * @return nparmzPara
     */
    public int getNparmzPara() {
        return nparmzPara;
    }

    /**
     * Propósito:  Atribuir valor ao nparmzPara
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNparmzPara(int value) {
        this.nparmzPara = value;
    }

    /**
     * Propósito:  Retornar o valor de cusuarValdc
     *
     * @return cusuarValdc
     */
    public String getCusuarValdc() {
        return cusuarValdc;
    }

    /**
     * Propósito:  Atribuir valor ao cusuarValdc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCusuarValdc(String value) {
        this.cusuarValdc = value;
    }

    /**
     * Propósito:  Retornar o valor de rjustif
     *
     * @return rjustif
     */
    public String getRjustif() {
        return rjustif;
    }

    /**
     * Propósito:  Atribuir valor ao rjustif
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRjustif(String value) {
        this.rjustif = value;
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
    public RICCWBOERequest() {
        super();
    }
}
