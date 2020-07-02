/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWBBSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBBSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBBS-HEADER", "RICCWBBS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBBS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBBS-HEADER", "RICCWBBS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo pzvalddRelat
     */
    @CommareaField(name = {"RICCWBBS-REGISTRO", "RICCWBBS-PZVALDD-RELAT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int pzvalddRelat = 0;

    /**
     * Atributo vriscoTot
     */
    @CommareaField(name = {"RICCWBBS-REGISTRO", "RICCWBBS-VRISCO-TOT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vriscoTot = null;

    /**
     * Atributo cusuarAtulz
     */
    @CommareaField(name = {"RICCWBBS-REGISTRO", "RICCWBBS-CUSUAR-ATULZ"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "X(009)")
    protected String cusuarAtulz = null;

    /**
     * Atributo hatulzParmz
     */
    @CommareaField(name = {"RICCWBBS-REGISTRO", "RICCWBBS-HATULZ-PARMZ"}, maxLength = 26, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 26, pic = "X(026)")
    protected String hatulzParmz = null;

    /**
     * Atributo segmentos
     */
    @CommareaContainer(name = {"RICCWBBS-REGISTRO", "RICCWBBS-SEGMENTOS"}, minOccurs = 10, maxOccurs = 10,
        fieldNumber = 6, type = RICCWBBSResponseRegistroSegmentos.class)
    protected List<RICCWBBSResponseRegistroSegmentos> segmentos = new ArrayList<RICCWBBSResponseRegistroSegmentos>();

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
     * Propósito:  Retornar o valor de hatulzParmz
     *
     * @return hatulzParmz
     */
    public String getHatulzParmz() {
        return hatulzParmz;
    }

    /**
     * Propósito:  Atribuir valor ao hatulzParmz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setHatulzParmz(String value) {
        this.hatulzParmz = value;
    }

    /**
     * Propósito:  Retornar o valor de segmentos
     *
     * @return segmentos
     */
    public List<RICCWBBSResponseRegistroSegmentos> getSegmentos() {
        if (segmentos == null) {
            segmentos = new  ArrayList<RICCWBBSResponseRegistroSegmentos>();
        }
        return this.segmentos;
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
    public RICCWBBSResponse() {
        super();
    }

    public void setSegmentos(List<RICCWBBSResponseRegistroSegmentos> value) {
        this.segmentos = value;
    }
}
