/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA2SResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA2SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA2S-HEADER", "RICCWA2S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA2S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA2S-HEADER", "RICCWA2S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 22300;

    /**
     * Atributo dbaseRelat
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-DBASE-RELAT"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dbaseRelat = null;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWA2S-QTOT-OCOR", fieldNumber = 4, type = RICCWA2SResponseRegistroAreaSaida.class)
    protected List<RICCWA2SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA2SResponseRegistroAreaSaida>();

    /**
     * Atributo vtotalCustoTot
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-CUSTO-TOT"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalCustoTot = null;

    /**
     * Atributo vtotalCustoInc
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-CUSTO-INC"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalCustoInc = null;

    /**
     * Atributo vtotalTotGral
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-TOT-GRAL"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalTotGral = null;

    /**
     * Atributo vtotalVdaPermu
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-VDA-PERMU"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalVdaPermu = null;

    /**
     * Atributo qtotalUndMnor
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-QTOTAL-UND-MNOR"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 11, pic = "9(011)")
    protected long qtotalUndMnor = 0L;

    /**
     * Atributo qtotalUndPermu
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-QTOTAL-UND-PERMU"}, maxLength = 11,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 11, pic = "9(011)")
    protected long qtotalUndPermu = 0L;

    /**
     * Atributo qtotalTotEstoq
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-QTOTAL-TOT-ESTOQ"}, maxLength = 11,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 11, pic = "9(011)")
    protected long qtotalTotEstoq = 0L;

    /**
     * Atributo vtotalTotRecbd
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-TOT-RECBD"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalTotRecbd = null;

    /**
     * Atributo vtotalPreChave
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-PRE-CHAVE"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 13, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalPreChave = null;

    /**
     * Atributo vtotalPosChave
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-POS-CHAVE"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 14, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalPosChave = null;

    /**
     * Atributo vtotalTotContr
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-TOT-CONTR"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 15, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalTotContr = null;

    /**
     * Atributo vtotalSdoLibrd
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-SDO-LIBRD"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 16, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalSdoLibrd = null;

    /**
     * Atributo vtotalSdoDvdor
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-VTOTAL-SDO-DVDOR"}, maxLength = 19,
        usage = "DISPLAY", fieldNumber = 17, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotalSdoDvdor = null;

    /**
     * Atributo filler7
     */
    protected String filler7 = null;

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
     * Propósito:  Retornar o valor de dbaseRelat
     *
     * @return dbaseRelat
     */
    public String getDbaseRelat() {
        return dbaseRelat;
    }

    /**
     * Propósito:  Atribuir valor ao dbaseRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseRelat(String value) {
        this.dbaseRelat = value;
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
    public List<RICCWA2SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA2SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de vtotalCustoTot
     *
     * @return vtotalCustoTot
     */
    public BigDecimal getVtotalCustoTot() {
        return vtotalCustoTot;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalCustoTot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalCustoTot(BigDecimal value) {
        this.vtotalCustoTot = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalCustoInc
     *
     * @return vtotalCustoInc
     */
    public BigDecimal getVtotalCustoInc() {
        return vtotalCustoInc;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalCustoInc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalCustoInc(BigDecimal value) {
        this.vtotalCustoInc = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalTotGral
     *
     * @return vtotalTotGral
     */
    public BigDecimal getVtotalTotGral() {
        return vtotalTotGral;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalTotGral
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalTotGral(BigDecimal value) {
        this.vtotalTotGral = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalVdaPermu
     *
     * @return vtotalVdaPermu
     */
    public BigDecimal getVtotalVdaPermu() {
        return vtotalVdaPermu;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalVdaPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalVdaPermu(BigDecimal value) {
        this.vtotalVdaPermu = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotalUndMnor
     *
     * @return qtotalUndMnor
     */
    public long getQtotalUndMnor() {
        return qtotalUndMnor;
    }

    /**
     * Propósito:  Atribuir valor ao qtotalUndMnor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotalUndMnor(long value) {
        this.qtotalUndMnor = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotalUndPermu
     *
     * @return qtotalUndPermu
     */
    public long getQtotalUndPermu() {
        return qtotalUndPermu;
    }

    /**
     * Propósito:  Atribuir valor ao qtotalUndPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotalUndPermu(long value) {
        this.qtotalUndPermu = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotalTotEstoq
     *
     * @return qtotalTotEstoq
     */
    public long getQtotalTotEstoq() {
        return qtotalTotEstoq;
    }

    /**
     * Propósito:  Atribuir valor ao qtotalTotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotalTotEstoq(long value) {
        this.qtotalTotEstoq = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalTotRecbd
     *
     * @return vtotalTotRecbd
     */
    public BigDecimal getVtotalTotRecbd() {
        return vtotalTotRecbd;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalTotRecbd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalTotRecbd(BigDecimal value) {
        this.vtotalTotRecbd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalPreChave
     *
     * @return vtotalPreChave
     */
    public BigDecimal getVtotalPreChave() {
        return vtotalPreChave;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalPreChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalPreChave(BigDecimal value) {
        this.vtotalPreChave = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalPosChave
     *
     * @return vtotalPosChave
     */
    public BigDecimal getVtotalPosChave() {
        return vtotalPosChave;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalPosChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalPosChave(BigDecimal value) {
        this.vtotalPosChave = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalTotContr
     *
     * @return vtotalTotContr
     */
    public BigDecimal getVtotalTotContr() {
        return vtotalTotContr;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalTotContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalTotContr(BigDecimal value) {
        this.vtotalTotContr = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotalSdoLibrd
     *
     * @return vtotalSdoLibrd
     */
    public BigDecimal getVtotalSdoLibrd() {
        return vtotalSdoLibrd;
    }

    /**
     * Propósito:  Atribuir valor ao vtotalSdoLibrd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotalSdoLibrd(BigDecimal value) {
        this.vtotalSdoLibrd = value;
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
     * Propósito:  Retornar o valor de fILLER7
     *
     * @return fILLER7
     */
    public String getFILLER7() {
        return filler7;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER7
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER7(String value) {
        this.filler7 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA2SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA2SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
