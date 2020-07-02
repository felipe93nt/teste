/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA1SResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA1SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA1S-HEADER", "RICCWA1S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA1S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA1S-HEADER", "RICCWA1S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 16700;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWA1S-QTOT-OCOR", fieldNumber = 4, type = RICCWA1SResponseRegistroAreaSaida.class)
    protected List<RICCWA1SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA1SResponseRegistroAreaSaida>();

    /**
     * Atributo vtotalRecbd
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-RECBD"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalRecbd = null;

    /**
     * Atributo vtotalDoze
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-DOZE"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalDoze = null;

    /**
     * Atributo vtotalTrntaSeis
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-TRNTA-SEIS"}, maxLength = 19, usage = "DISPLA"
        + "Y", fieldNumber = 7, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalTrntaSeis = null;

    /**
     * Atributo vtotalPosTrnta
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-POS-TRNTA"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalPosTrnta = null;

    /**
     * Atributo qtotalUnd
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-QTOTAL-UND"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 11, pic = "9(011)")
    protected long qtotalUnd = 0L;

    /**
     * Atributo vtotalEstoq
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-ESTOQ"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalEstoq = null;

    /**
     * Atributo vtotalSdoDvdor
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-VTOTAL-SDO-DVDOR"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalSdoDvdor = null;

    /**
     * Atributo filler5
     */
    protected String filler5 = null;

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
     * Propósito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Propósito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotOcor
     *
     * @return qtotOcor
     */
    public int getQtotOcor() {
        return qtotOcor;
    }

    /**
     * Propósito:  Atribuir valor ao qtotOcor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotOcor(int value) {
        this.qtotOcor = value;
    }

    /**
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWA1SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA1SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de vtotalRecbd
     *
     * @return vtotalRecbd
     */
    public BigDecimal getVtotalRecbd() {
        return vtotalRecbd;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalRecbd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalRecbd(BigDecimal value) {
        this.vtotalRecbd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalDoze
     *
     * @return vtotalDoze
     */
    public BigDecimal getVtotalDoze() {
        return vtotalDoze;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalDoze
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalDoze(BigDecimal value) {
        this.vtotalDoze = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalTrntaSeis
     *
     * @return vtotalTrntaSeis
     */
    public BigDecimal getVtotalTrntaSeis() {
        return vtotalTrntaSeis;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalTrntaSeis
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalTrntaSeis(BigDecimal value) {
        this.vtotalTrntaSeis = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalPosTrnta
     *
     * @return vtotalPosTrnta
     */
    public BigDecimal getVtotalPosTrnta() {
        return vtotalPosTrnta;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalPosTrnta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalPosTrnta(BigDecimal value) {
        this.vtotalPosTrnta = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotalUnd
     *
     * @return qtotalUnd
     */
    public long getQtotalUnd() {
        return qtotalUnd;
    }

    /**
     * Propósito:  Atribuir valor ao qtotalUnd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotalUnd(long value) {
        this.qtotalUnd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalEstoq
     *
     * @return vtotalEstoq
     */
    public BigDecimal getVtotalEstoq() {
        return vtotalEstoq;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalEstoq(BigDecimal value) {
        this.vtotalEstoq = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalSdoDvdor
     *
     * @return vtotalSdoDvdor
     */
    public BigDecimal getVtotalSdoDvdor() {
        return vtotalSdoDvdor;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalSdoDvdor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalSdoDvdor(BigDecimal value) {
        this.vtotalSdoDvdor = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER5
     *
     * @return fILLER5
     */
    public String getFILLER5() {
        return filler5;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER5
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER5(String value) {
        this.filler5 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA1SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA1SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
