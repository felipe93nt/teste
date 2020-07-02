/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 01/07/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAFSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAFSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nbalanEmpr
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-NBALAN-EMPR"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int nbalanEmpr = 0;

    /**
     * Atributo dtBalan
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-DT-BALAN"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 10, pic = "X(010)")
    protected String dtBalan = null;

    /**
     * Atributo vrectLiqS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-RECEITA-LIQ", "RICCWAFS-VRECT"
        + "-LIQ-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String vrectLiqS = null;

    /**
     * Atributo vrectLiq
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-RECEITA-LIQ", "RICCWAFS-VRECT"
        + "-LIQ"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrectLiq = null;

    /**
     * Atributo vrectLiqNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-RECEITA-LIQ", "RICCWAFS-VRECT"
        + "-LIQ-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String vrectLiqNull = null;

    /**
     * Atributo vcontRecS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-CONTAS-RECEBER", "RICCWAFS-VC"
        + "ONT-REC-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String vcontRecS = null;

    /**
     * Atributo vcontRec
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-CONTAS-RECEBER", "RICCWAFS-VC"
        + "ONT-REC"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 6, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcontRec = null;

    /**
     * Atributo vcontRecNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-CONTAS-RECEBER", "RICCWAFS-VC"
        + "ONT-REC-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String vcontRecNull = null;

    /**
     * Atributo vtotEstqS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ESTOQUES", "RICCWAFS-VTOT-EST"
        + "Q-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 8, maxBytes = 1, pic = "X(001)")
    protected String vtotEstqS = null;

    /**
     * Atributo vtotEstoq
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ESTOQUES", "RICCWAFS-VTOT-EST"
        + "OQ"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotEstoq = null;

    /**
     * Atributo vtotEstqNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ESTOQUES", "RICCWAFS-VTOT-EST"
        + "Q-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String vtotEstqNull = null;

    /**
     * Atributo vrectBrutS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-GER-BRUTA", "RICCWAFS-VRECT-B"
        + "RUT-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String vrectBrutS = null;

    /**
     * Atributo vrectBrut
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-GER-BRUTA", "RICCWAFS-VRECT-B"
        + "RUT"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrectBrut = null;

    /**
     * Atributo vrectBrtNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-GER-BRUTA", "RICCWAFS-VRECT-B"
        + "RT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String vrectBrtNull = null;

    /**
     * Atributo pmargmOperS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-MARGEM-OPER", "RICCWAFS-PMARG"
        + "M-OPER-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 14, maxBytes = 1, pic = "X(001)")
    protected String pmargmOperS = null;

    /**
     * Atributo pmargmOper
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-MARGEM-OPER", "RICCWAFS-PMARG"
        + "M-OPER"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 15, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pmargmOper = null;

    /**
     * Atributo pmargmOpNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-MARGEM-OPER", "RICCWAFS-PMARG"
        + "M-OP-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 16, maxBytes = 1, pic = "X(001)")
    protected String pmargmOpNull = null;

    /**
     * Atributo vlucroLiqS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-LUCRO-LIQUIDO", "RICCWAFS-VLU"
        + "CRO-LIQ-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 17, maxBytes = 1, pic = "X(001)")
    protected String vlucroLiqS = null;

    /**
     * Atributo vlucroLiq
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-LUCRO-LIQUIDO", "RICCWAFS-VLU"
        + "CRO-LIQ"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 18, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vlucroLiq = null;

    /**
     * Atributo vlucroLiNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-LUCRO-LIQUIDO", "RICCWAFS-VLU"
        + "CRO-LI-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1, pic = "X(001)")
    protected String vlucroLiNull = null;

    /**
     * Atributo vpatrmLiqS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-PATRIMONIO-LIQ", "RICCWAFS-VP"
        + "ATRM-LIQ-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 20, maxBytes = 1, pic = "X(001)")
    protected String vpatrmLiqS = null;

    /**
     * Atributo vpatrmLiq
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-PATRIMONIO-LIQ", "RICCWAFS-VP"
        + "ATRM-LIQ"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 21, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vpatrmLiq = null;

    /**
     * Atributo vpatrmLiNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-PATRIMONIO-LIQ", "RICCWAFS-VP"
        + "ATRM-LI-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 22, maxBytes = 1, pic = "X(001)")
    protected String vpatrmLiNull = null;

    /**
     * Atributo vtotEndvS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-TOT", "RICCWAFS"
        + "-VTOT-ENDV-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 23, maxBytes = 1, pic = "X(001)")
    protected String vtotEndvS = null;

    /**
     * Atributo vtotEndv
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-TOT", "RICCWAFS"
        + "-VTOT-ENDV"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 24, maxBytes = 17,
        pic = "9(015)V99")
    protected BigDecimal vtotEndv = null;

    /**
     * Atributo vtotEndvNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-TOT", "RICCWAFS"
        + "-VTOT-ENDV-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 25, maxBytes = 1,
        pic = "X(001)")
    protected String vtotEndvNull = null;

    /**
     * Atributo vdispnCxS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-DISPONIBILIDADE", "RICCWAFS-V"
        + "DISPN-CX-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 26, maxBytes = 1, pic = "X(001)")
    protected String vdispnCxS = null;

    /**
     * Atributo vdispnCx
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-DISPONIBILIDADE", "RICCWAFS-V"
        + "DISPN-CX"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 27, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vdispnCx = null;

    /**
     * Atributo vdispnCxNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-DISPONIBILIDADE", "RICCWAFS-V"
        + "DISPN-CX-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 28, maxBytes = 1, pic = "X(001)")
    protected String vdispnCxNull = null;

    /**
     * Atributo vliqEndvS
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-LIQ", "RICCWAFS"
        + "-VLIQ-ENDV-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 29, maxBytes = 1, pic = "X(001)")
    protected String vliqEndvS = null;

    /**
     * Atributo vliqEndv
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-LIQ", "RICCWAFS"
        + "-VLIQ-ENDV"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 30, maxBytes = 17,
        pic = "9(015)V99")
    protected BigDecimal vliqEndv = null;

    /**
     * Atributo vliqEndvNull
     */
    @CommareaField(name = {"RICCWAFS-REGISTRO", "RICCWAFS-AREA-SAIDA", "RICCWAFS-ENDIVIDAMENTO-LIQ", "RICCWAFS"
        + "-VLIQ-ENDV-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 31, maxBytes = 1,
        pic = "X(001)")
    protected String vliqEndvNull = null;

    /**
     * Prop�sito:  Retornar o valor de nbalanEmpr
     *
     * @return nbalanEmpr
     */
    public int getNbalanEmpr() {
        return nbalanEmpr;
    }

    /**
     * Prop�sito:  Atribuir valor ao nbalanEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNbalanEmpr(int value) {
        this.nbalanEmpr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dtBalan
     *
     * @return dtBalan
     */
    public String getDtBalan() {
        return dtBalan;
    }

    /**
     * Prop�sito:  Atribuir valor ao dtBalan
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtBalan(String value) {
        this.dtBalan = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectLiqS
     *
     * @return vrectLiqS
     */
    public String getVrectLiqS() {
        return vrectLiqS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectLiqS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectLiqS(String value) {
        this.vrectLiqS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectLiq
     *
     * @return vrectLiq
     */
    public BigDecimal getVrectLiq() {
        return vrectLiq;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectLiq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectLiq(BigDecimal value) {
        this.vrectLiq = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectLiqNull
     *
     * @return vrectLiqNull
     */
    public String getVrectLiqNull() {
        return vrectLiqNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectLiqNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectLiqNull(String value) {
        this.vrectLiqNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcontRecS
     *
     * @return vcontRecS
     */
    public String getVcontRecS() {
        return vcontRecS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcontRecS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcontRecS(String value) {
        this.vcontRecS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcontRec
     *
     * @return vcontRec
     */
    public BigDecimal getVcontRec() {
        return vcontRec;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcontRec
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcontRec(BigDecimal value) {
        this.vcontRec = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcontRecNull
     *
     * @return vcontRecNull
     */
    public String getVcontRecNull() {
        return vcontRecNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcontRecNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcontRecNull(String value) {
        this.vcontRecNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEstqS
     *
     * @return vtotEstqS
     */
    public String getVtotEstqS() {
        return vtotEstqS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEstqS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEstqS(String value) {
        this.vtotEstqS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEstoq
     *
     * @return vtotEstoq
     */
    public BigDecimal getVtotEstoq() {
        return vtotEstoq;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEstoq(BigDecimal value) {
        this.vtotEstoq = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEstqNull
     *
     * @return vtotEstqNull
     */
    public String getVtotEstqNull() {
        return vtotEstqNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEstqNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEstqNull(String value) {
        this.vtotEstqNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectBrutS
     *
     * @return vrectBrutS
     */
    public String getVrectBrutS() {
        return vrectBrutS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectBrutS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectBrutS(String value) {
        this.vrectBrutS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectBrut
     *
     * @return vrectBrut
     */
    public BigDecimal getVrectBrut() {
        return vrectBrut;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectBrut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectBrut(BigDecimal value) {
        this.vrectBrut = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectBrtNull
     *
     * @return vrectBrtNull
     */
    public String getVrectBrtNull() {
        return vrectBrtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectBrtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectBrtNull(String value) {
        this.vrectBrtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pmargmOperS
     *
     * @return pmargmOperS
     */
    public String getPmargmOperS() {
        return pmargmOperS;
    }

    /**
     * Prop�sito:  Atribuir valor ao pmargmOperS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPmargmOperS(String value) {
        this.pmargmOperS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pmargmOper
     *
     * @return pmargmOper
     */
    public BigDecimal getPmargmOper() {
        return pmargmOper;
    }

    /**
     * Prop�sito:  Atribuir valor ao pmargmOper
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPmargmOper(BigDecimal value) {
        this.pmargmOper = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pmargmOpNull
     *
     * @return pmargmOpNull
     */
    public String getPmargmOpNull() {
        return pmargmOpNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao pmargmOpNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPmargmOpNull(String value) {
        this.pmargmOpNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vlucroLiqS
     *
     * @return vlucroLiqS
     */
    public String getVlucroLiqS() {
        return vlucroLiqS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vlucroLiqS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroLiqS(String value) {
        this.vlucroLiqS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vlucroLiq
     *
     * @return vlucroLiq
     */
    public BigDecimal getVlucroLiq() {
        return vlucroLiq;
    }

    /**
     * Prop�sito:  Atribuir valor ao vlucroLiq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroLiq(BigDecimal value) {
        this.vlucroLiq = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vlucroLiNull
     *
     * @return vlucroLiNull
     */
    public String getVlucroLiNull() {
        return vlucroLiNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vlucroLiNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroLiNull(String value) {
        this.vlucroLiNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vpatrmLiqS
     *
     * @return vpatrmLiqS
     */
    public String getVpatrmLiqS() {
        return vpatrmLiqS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vpatrmLiqS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpatrmLiqS(String value) {
        this.vpatrmLiqS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vpatrmLiq
     *
     * @return vpatrmLiq
     */
    public BigDecimal getVpatrmLiq() {
        return vpatrmLiq;
    }

    /**
     * Prop�sito:  Atribuir valor ao vpatrmLiq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpatrmLiq(BigDecimal value) {
        this.vpatrmLiq = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vpatrmLiNull
     *
     * @return vpatrmLiNull
     */
    public String getVpatrmLiNull() {
        return vpatrmLiNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vpatrmLiNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpatrmLiNull(String value) {
        this.vpatrmLiNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEndvS
     *
     * @return vtotEndvS
     */
    public String getVtotEndvS() {
        return vtotEndvS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEndvS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEndvS(String value) {
        this.vtotEndvS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEndv
     *
     * @return vtotEndv
     */
    public BigDecimal getVtotEndv() {
        return vtotEndv;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEndv(BigDecimal value) {
        this.vtotEndv = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEndvNull
     *
     * @return vtotEndvNull
     */
    public String getVtotEndvNull() {
        return vtotEndvNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEndvNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEndvNull(String value) {
        this.vtotEndvNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vdispnCxS
     *
     * @return vdispnCxS
     */
    public String getVdispnCxS() {
        return vdispnCxS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vdispnCxS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdispnCxS(String value) {
        this.vdispnCxS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vdispnCx
     *
     * @return vdispnCx
     */
    public BigDecimal getVdispnCx() {
        return vdispnCx;
    }

    /**
     * Prop�sito:  Atribuir valor ao vdispnCx
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdispnCx(BigDecimal value) {
        this.vdispnCx = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vdispnCxNull
     *
     * @return vdispnCxNull
     */
    public String getVdispnCxNull() {
        return vdispnCxNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vdispnCxNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdispnCxNull(String value) {
        this.vdispnCxNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vliqEndvS
     *
     * @return vliqEndvS
     */
    public String getVliqEndvS() {
        return vliqEndvS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vliqEndvS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVliqEndvS(String value) {
        this.vliqEndvS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vliqEndv
     *
     * @return vliqEndv
     */
    public BigDecimal getVliqEndv() {
        return vliqEndv;
    }

    /**
     * Prop�sito:  Atribuir valor ao vliqEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVliqEndv(BigDecimal value) {
        this.vliqEndv = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vliqEndvNull
     *
     * @return vliqEndvNull
     */
    public String getVliqEndvNull() {
        return vliqEndvNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vliqEndvNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVliqEndvNull(String value) {
        this.vliqEndvNull = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAFSResponseRegistroAreaSaida() {
        super();
    }
}
