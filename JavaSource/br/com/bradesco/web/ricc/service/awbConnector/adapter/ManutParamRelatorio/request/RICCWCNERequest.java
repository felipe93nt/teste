/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWCNERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCNERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCNE-HEADER", "RICCWCNE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCNE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCNE-HEADER", "RICCWCNE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo nparmzRelat
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-NPARMZ-RELAT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int nparmzRelat = 0;

    /**
     * Atributo pzvalddRelat
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-PZVALDD-RELAT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 3, pic = "9(003)")
    protected int pzvalddRelat = 0;

    /**
     * Atributo vriscoTot
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-VRISCO-TOT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vriscoTot = null;

    /**
     * Atributo cusuarAtulz
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-CUSUAR-ATULZ"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "X(009)")
    protected String cusuarAtulz = null;

    /**
     * Atributo segmentos
     */
    @CommareaContainer(name = {"RICCWCNE-REGISTRO", "RICCWCNE-SEGMENTOS"}, minOccurs = 10, maxOccurs = 10,
        fieldNumber = 7, type = RICCWCNERequestRegistroSegmentos.class)
    protected List<RICCWCNERequestRegistroSegmentos> segmentos = new ArrayList<RICCWCNERequestRegistroSegmentos>();

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "FILLER"}, maxLength = 86, usage = "DISPLAY", fieldNumber = 8,
        maxBytes = 86, pic = "X(086)")
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
     * Propósito:  Retornar o valor de nparmzRelat
     *
     * @return nparmzRelat
     */
    public int getNparmzRelat() {
        return nparmzRelat;
    }

    /**
     * Propósito:  Atribuir valor ao nparmzRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNparmzRelat(int value) {
        this.nparmzRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de pzvalddRelat
     *
     * @return pzvalddRelat
     */
    public int getPzvalddRelat() {
        return pzvalddRelat;
    }

    /**
     * Propósito:  Atribuir valor ao pzvalddRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPzvalddRelat(int value) {
        this.pzvalddRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de vriscoTot
     *
     * @return vriscoTot
     */
    public BigDecimal getVriscoTot() {
        return vriscoTot;
    }

    /**
     * Propósito:  Atribuir valor ao vriscoTot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVriscoTot(BigDecimal value) {
        this.vriscoTot = value;
    }

    /**
     * Propósito:  Retornar o valor de cusuarAtulz
     *
     * @return cusuarAtulz
     */
    public String getCusuarAtulz() {
        return cusuarAtulz;
    }

    /**
     * Propósito:  Atribuir valor ao cusuarAtulz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCusuarAtulz(String value) {
        this.cusuarAtulz = value;
    }

    /**
     * Propósito:  Retornar o valor de segmentos
     *
     * @return segmentos
     */
    public List<RICCWCNERequestRegistroSegmentos> getSegmentos() {
        if (segmentos == null) {
            segmentos = new  ArrayList<RICCWCNERequestRegistroSegmentos>();
        }
        return this.segmentos;
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
    public RICCWCNERequest() {
        super();
    }

    public void setSegmentos(List<RICCWCNERequestRegistroSegmentos> value) {
        this.segmentos = value;
    }
}
