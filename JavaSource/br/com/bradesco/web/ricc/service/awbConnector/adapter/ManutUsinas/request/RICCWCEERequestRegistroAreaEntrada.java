/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 20/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCEERequestRegistroAreaEntrada 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCEERequestRegistroAreaEntrada extends AnnotatedAdapter {

    /**
     * Atributo nusinaAcucr
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-NUSINA-ACUCR"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nusinaAcucr = 0;

    /**
     * Atributo anoSafra
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-ANO-SAFRA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 5, pic = "X(005)")
    protected String anoSafra = null;

    /**
     * Atributo capacMoagem
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CAPACIDADE-MOAGEM", "RICCWC"
        + "EE-CAPAC-MOAGEM"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 2, maxBytes = 15, pic = "9(015"
        + ")")
    protected long capacMoagem = 0L;

    /**
     * Atributo capacMoagemNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CAPACIDADE-MOAGEM", "RICCWC"
        + "EE-CAPAC-MOAGEM-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X("
        + "001)")
    protected String capacMoagemNull = null;

    /**
     * Atributo canaPropr
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-PROPRIA", "RICCWCEE-CA"
        + "NA-PROPR"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal canaPropr = null;

    /**
     * Atributo canaProprNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-PROPRIA", "RICCWCEE-CA"
        + "NA-PROPR-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String canaProprNull = null;

    /**
     * Atributo canaArrend
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-ARRENDADA", "RICCWCEE-"
        + "CANA-ARREND"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal canaArrend = null;

    /**
     * Atributo canaArrendNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-ARRENDADA", "RICCWCEE-"
        + "CANA-ARREND-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1,
        pic = "X(001)")
    protected String canaArrendNull = null;

    /**
     * Atributo canaTerceiro
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-TERCEIROS", "RICCWCEE-"
        + "CANA-TERCEIRO"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 8, maxBytes = 5,
        pic = "9(003)V99")
    protected BigDecimal canaTerceiro = null;

    /**
     * Atributo canaTerceiroNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-CANA-TERCEIROS", "RICCWCEE-"
        + "CANA-TERCEIRO-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(00"
        + "1)")
    protected String canaTerceiroNull = null;

    /**
     * Atributo totMoagem
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-TOTAL-MOAGEM", "RICCWCEE-TO"
        + "T-MOAGEM"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal totMoagem = null;

    /**
     * Atributo totMoagemNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-TOTAL-MOAGEM", "RICCWCEE-TO"
        + "T-MOAGEM-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String totMoagemNull = null;

    /**
     * Atributo areaPropr
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-PROPRIA", "RICCWCEE-AR"
        + "EA-PROPR"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 12, maxBytes = 15, pic = "9(015)")
    protected long areaPropr = 0L;

    /**
     * Atributo areaProprNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-PROPRIA", "RICCWCEE-AR"
        + "EA-PROPR-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String areaProprNull = null;

    /**
     * Atributo areaArrend
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-ARRENDADA", "RICCWCEE-"
        + "AREA-ARREND"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 14, maxBytes = 15, pic = "9(015)")
    protected long areaArrend = 0L;

    /**
     * Atributo areaArrendNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-ARRENDADA", "RICCWCEE-"
        + "AREA-ARREND-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001"
        + ")")
    protected String areaArrendNull = null;

    /**
     * Atributo areaRenov
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-RENOVACAO", "RICCWCEE-"
        + "AREA-RENOV"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 16, maxBytes = 15, pic = "9(015)")
    protected long areaRenov = 0L;

    /**
     * Atributo areaRenovNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-RENOVACAO", "RICCWCEE-"
        + "AREA-RENOV-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 17, maxBytes = 1,
        pic = "X(001)")
    protected String areaRenovNull = null;

    /**
     * Atributo areaExpans
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-EXPANSAO", "RICCWCEE-A"
        + "REA-EXPANS"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 18, maxBytes = 15, pic = "9(015)")
    protected long areaExpans = 0L;

    /**
     * Atributo areaExpansNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-AREA-EXPANSAO", "RICCWCEE-A"
        + "REA-EXPANS-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1,
        pic = "X(001)")
    protected String areaExpansNull = null;

    /**
     * Atributo idadeMed
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-IDADE-MEDIA-CANAVIAL", "RIC"
        + "CWCEE-IDADE-MED"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 20, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal idadeMed = null;

    /**
     * Atributo idadeMedNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-IDADE-MEDIA-CANAVIAL", "RIC"
        + "CWCEE-IDADE-MED-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 21, maxBytes = 1, pic = "X"
        + "(001)")
    protected String idadeMedNull = null;

    /**
     * Atributo colheitaMecan
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-COLHEITA-MECANIZADA", "RICC"
        + "WCEE-COLHEITA-MECAN"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 22, maxBytes = 17, pic = ""
        + "9(015)V99")
    protected BigDecimal colheitaMecan = null;

    /**
     * Atributo colheitaMecanNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-COLHEITA-MECANIZADA", "RICC"
        + "WCEE-COLHEITA-MECAN-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 23, maxBytes = 1,
        pic = "X(001)")
    protected String colheitaMecanNull = null;

    /**
     * Atributo raioMed
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-RAIO-MEDIO", "RICCWCEE-RAIO"
        + "-MED"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 24, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal raioMed = null;

    /**
     * Atributo raioMedNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-RAIO-MEDIO", "RICCWCEE-RAIO"
        + "-MED-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 25, maxBytes = 1, pic = "X(001)")
    protected String raioMedNull = null;

    /**
     * Atributo prodIndus
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-PRODUTIV-INDUSTRIAL", "RICC"
        + "WCEE-PROD-INDUS"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 26, maxBytes = 15, pic = "9(01"
        + "5)")
    protected long prodIndus = 0L;

    /**
     * Atributo prodIndusNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-PRODUTIV-INDUSTRIAL", "RICC"
        + "WCEE-PROD-INDUS-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 27, maxBytes = 1, pic = "X"
        + "(001)")
    protected String prodIndusNull = null;

    /**
     * Atributo potencInstal
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-POTENCIA-INSTALADA", "RICCW"
        + "CEE-POTENC-INSTAL"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 28, maxBytes = 15, pic = "9("
        + "015)")
    protected long potencInstal = 0L;

    /**
     * Atributo potencInstalNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-POTENCIA-INSTALADA", "RICCW"
        + "CEE-POTENC-INSTAL-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 29, maxBytes = 1, pic = 
        "X(001)")
    protected String potencInstalNull = null;

    /**
     * Atributo totEnergiaVend
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-TOTAL-ENERGIA-VENDIDA", "RI"
        + "CCWCEE-TOT-ENERGIA-VEND"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 30, maxBytes = 15,
        pic = "9(015)")
    protected long totEnergiaVend = 0L;

    /**
     * Atributo totEnergiaVendNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-TOTAL-ENERGIA-VENDIDA", "RI"
        + "CCWCEE-TOT-ENERGIA-VEND-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 31, maxBytes = 1,
        pic = "X(001)")
    protected String totEnergiaVendNull = null;

    /**
     * Atributo faturamento
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-FATURAMENTOS", "RICCWCEE-FA"
        + "TURAMENTO"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 32, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal faturamento = null;

    /**
     * Atributo faturamentoNull
     */
    @CommareaField(name = {"RICCWCEE-REGISTRO", "RICCWCEE-AREA-ENTRADA", "RICCWCEE-FATURAMENTOS", "RICCWCEE-FA"
        + "TURAMENTO-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 33, maxBytes = 1, pic = "X(001)")
    protected String faturamentoNull = null;

    /**
     * Propósito:  Retornar o valor de nusinaAcucr
     *
     * @return nusinaAcucr
     */
    public int getNusinaAcucr() {
        return nusinaAcucr;
    }

    /**
     * Propósito:  Atribuir valor ao nusinaAcucr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNusinaAcucr(int value) {
        this.nusinaAcucr = value;
    }

    /**
     * Propósito:  Retornar o valor de anoSafra
     *
     * @return anoSafra
     */
    public String getAnoSafra() {
        return anoSafra;
    }

    /**
     * Propósito:  Atribuir valor ao anoSafra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoSafra(String value) {
        this.anoSafra = value;
    }

    /**
     * Propósito:  Retornar o valor de capacMoagem
     *
     * @return capacMoagem
     */
    public long getCapacMoagem() {
        return capacMoagem;
    }

    /**
     * Propósito:  Atribuir valor ao capacMoagem
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCapacMoagem(long value) {
        this.capacMoagem = value;
    }

    /**
     * Propósito:  Retornar o valor de capacMoagemNull
     *
     * @return capacMoagemNull
     */
    public String getCapacMoagemNull() {
        return capacMoagemNull;
    }

    /**
     * Propósito:  Atribuir valor ao capacMoagemNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCapacMoagemNull(String value) {
        this.capacMoagemNull = value;
    }

    /**
     * Propósito:  Retornar o valor de canaPropr
     *
     * @return canaPropr
     */
    public BigDecimal getCanaPropr() {
        return canaPropr;
    }

    /**
     * Propósito:  Atribuir valor ao canaPropr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaPropr(BigDecimal value) {
        this.canaPropr = value;
    }

    /**
     * Propósito:  Retornar o valor de canaProprNull
     *
     * @return canaProprNull
     */
    public String getCanaProprNull() {
        return canaProprNull;
    }

    /**
     * Propósito:  Atribuir valor ao canaProprNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaProprNull(String value) {
        this.canaProprNull = value;
    }

    /**
     * Propósito:  Retornar o valor de canaArrend
     *
     * @return canaArrend
     */
    public BigDecimal getCanaArrend() {
        return canaArrend;
    }

    /**
     * Propósito:  Atribuir valor ao canaArrend
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaArrend(BigDecimal value) {
        this.canaArrend = value;
    }

    /**
     * Propósito:  Retornar o valor de canaArrendNull
     *
     * @return canaArrendNull
     */
    public String getCanaArrendNull() {
        return canaArrendNull;
    }

    /**
     * Propósito:  Atribuir valor ao canaArrendNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaArrendNull(String value) {
        this.canaArrendNull = value;
    }

    /**
     * Propósito:  Retornar o valor de canaTerceiro
     *
     * @return canaTerceiro
     */
    public BigDecimal getCanaTerceiro() {
        return canaTerceiro;
    }

    /**
     * Propósito:  Atribuir valor ao canaTerceiro
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaTerceiro(BigDecimal value) {
        this.canaTerceiro = value;
    }

    /**
     * Propósito:  Retornar o valor de canaTerceiroNull
     *
     * @return canaTerceiroNull
     */
    public String getCanaTerceiroNull() {
        return canaTerceiroNull;
    }

    /**
     * Propósito:  Atribuir valor ao canaTerceiroNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCanaTerceiroNull(String value) {
        this.canaTerceiroNull = value;
    }

    /**
     * Propósito:  Retornar o valor de totMoagem
     *
     * @return totMoagem
     */
    public BigDecimal getTotMoagem() {
        return totMoagem;
    }

    /**
     * Propósito:  Atribuir valor ao totMoagem
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTotMoagem(BigDecimal value) {
        this.totMoagem = value;
    }

    /**
     * Propósito:  Retornar o valor de totMoagemNull
     *
     * @return totMoagemNull
     */
    public String getTotMoagemNull() {
        return totMoagemNull;
    }

    /**
     * Propósito:  Atribuir valor ao totMoagemNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTotMoagemNull(String value) {
        this.totMoagemNull = value;
    }

    /**
     * Propósito:  Retornar o valor de areaPropr
     *
     * @return areaPropr
     */
    public long getAreaPropr() {
        return areaPropr;
    }

    /**
     * Propósito:  Atribuir valor ao areaPropr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaPropr(long value) {
        this.areaPropr = value;
    }

    /**
     * Propósito:  Retornar o valor de areaProprNull
     *
     * @return areaProprNull
     */
    public String getAreaProprNull() {
        return areaProprNull;
    }

    /**
     * Propósito:  Atribuir valor ao areaProprNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaProprNull(String value) {
        this.areaProprNull = value;
    }

    /**
     * Propósito:  Retornar o valor de areaArrend
     *
     * @return areaArrend
     */
    public long getAreaArrend() {
        return areaArrend;
    }

    /**
     * Propósito:  Atribuir valor ao areaArrend
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaArrend(long value) {
        this.areaArrend = value;
    }

    /**
     * Propósito:  Retornar o valor de areaArrendNull
     *
     * @return areaArrendNull
     */
    public String getAreaArrendNull() {
        return areaArrendNull;
    }

    /**
     * Propósito:  Atribuir valor ao areaArrendNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaArrendNull(String value) {
        this.areaArrendNull = value;
    }

    /**
     * Propósito:  Retornar o valor de areaRenov
     *
     * @return areaRenov
     */
    public long getAreaRenov() {
        return areaRenov;
    }

    /**
     * Propósito:  Atribuir valor ao areaRenov
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaRenov(long value) {
        this.areaRenov = value;
    }

    /**
     * Propósito:  Retornar o valor de areaRenovNull
     *
     * @return areaRenovNull
     */
    public String getAreaRenovNull() {
        return areaRenovNull;
    }

    /**
     * Propósito:  Atribuir valor ao areaRenovNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaRenovNull(String value) {
        this.areaRenovNull = value;
    }

    /**
     * Propósito:  Retornar o valor de areaExpans
     *
     * @return areaExpans
     */
    public long getAreaExpans() {
        return areaExpans;
    }

    /**
     * Propósito:  Atribuir valor ao areaExpans
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaExpans(long value) {
        this.areaExpans = value;
    }

    /**
     * Propósito:  Retornar o valor de areaExpansNull
     *
     * @return areaExpansNull
     */
    public String getAreaExpansNull() {
        return areaExpansNull;
    }

    /**
     * Propósito:  Atribuir valor ao areaExpansNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaExpansNull(String value) {
        this.areaExpansNull = value;
    }

    /**
     * Propósito:  Retornar o valor de idadeMed
     *
     * @return idadeMed
     */
    public BigDecimal getIdadeMed() {
        return idadeMed;
    }

    /**
     * Propósito:  Atribuir valor ao idadeMed
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIdadeMed(BigDecimal value) {
        this.idadeMed = value;
    }

    /**
     * Propósito:  Retornar o valor de idadeMedNull
     *
     * @return idadeMedNull
     */
    public String getIdadeMedNull() {
        return idadeMedNull;
    }

    /**
     * Propósito:  Atribuir valor ao idadeMedNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIdadeMedNull(String value) {
        this.idadeMedNull = value;
    }

    /**
     * Propósito:  Retornar o valor de colheitaMecan
     *
     * @return colheitaMecan
     */
    public BigDecimal getColheitaMecan() {
        return colheitaMecan;
    }

    /**
     * Propósito:  Atribuir valor ao colheitaMecan
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setColheitaMecan(BigDecimal value) {
        this.colheitaMecan = value;
    }

    /**
     * Propósito:  Retornar o valor de colheitaMecanNull
     *
     * @return colheitaMecanNull
     */
    public String getColheitaMecanNull() {
        return colheitaMecanNull;
    }

    /**
     * Propósito:  Atribuir valor ao colheitaMecanNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setColheitaMecanNull(String value) {
        this.colheitaMecanNull = value;
    }

    /**
     * Propósito:  Retornar o valor de raioMed
     *
     * @return raioMed
     */
    public BigDecimal getRaioMed() {
        return raioMed;
    }

    /**
     * Propósito:  Atribuir valor ao raioMed
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRaioMed(BigDecimal value) {
        this.raioMed = value;
    }

    /**
     * Propósito:  Retornar o valor de raioMedNull
     *
     * @return raioMedNull
     */
    public String getRaioMedNull() {
        return raioMedNull;
    }

    /**
     * Propósito:  Atribuir valor ao raioMedNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRaioMedNull(String value) {
        this.raioMedNull = value;
    }

    /**
     * Propósito:  Retornar o valor de prodIndus
     *
     * @return prodIndus
     */
    public long getProdIndus() {
        return prodIndus;
    }

    /**
     * Propósito:  Atribuir valor ao prodIndus
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdIndus(long value) {
        this.prodIndus = value;
    }

    /**
     * Propósito:  Retornar o valor de prodIndusNull
     *
     * @return prodIndusNull
     */
    public String getProdIndusNull() {
        return prodIndusNull;
    }

    /**
     * Propósito:  Atribuir valor ao prodIndusNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdIndusNull(String value) {
        this.prodIndusNull = value;
    }

    /**
     * Propósito:  Retornar o valor de potencInstal
     *
     * @return potencInstal
     */
    public long getPotencInstal() {
        return potencInstal;
    }

    /**
     * Propósito:  Atribuir valor ao potencInstal
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPotencInstal(long value) {
        this.potencInstal = value;
    }

    /**
     * Propósito:  Retornar o valor de potencInstalNull
     *
     * @return potencInstalNull
     */
    public String getPotencInstalNull() {
        return potencInstalNull;
    }

    /**
     * Propósito:  Atribuir valor ao potencInstalNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPotencInstalNull(String value) {
        this.potencInstalNull = value;
    }

    /**
     * Propósito:  Retornar o valor de totEnergiaVend
     *
     * @return totEnergiaVend
     */
    public long getTotEnergiaVend() {
        return totEnergiaVend;
    }

    /**
     * Propósito:  Atribuir valor ao totEnergiaVend
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTotEnergiaVend(long value) {
        this.totEnergiaVend = value;
    }

    /**
     * Propósito:  Retornar o valor de totEnergiaVendNull
     *
     * @return totEnergiaVendNull
     */
    public String getTotEnergiaVendNull() {
        return totEnergiaVendNull;
    }

    /**
     * Propósito:  Atribuir valor ao totEnergiaVendNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTotEnergiaVendNull(String value) {
        this.totEnergiaVendNull = value;
    }

    /**
     * Propósito:  Retornar o valor de faturamento
     *
     * @return faturamento
     */
    public BigDecimal getFaturamento() {
        return faturamento;
    }

    /**
     * Propósito:  Atribuir valor ao faturamento
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFaturamento(BigDecimal value) {
        this.faturamento = value;
    }

    /**
     * Propósito:  Retornar o valor de faturamentoNull
     *
     * @return faturamentoNull
     */
    public String getFaturamentoNull() {
        return faturamentoNull;
    }

    /**
     * Propósito:  Atribuir valor ao faturamentoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFaturamentoNull(String value) {
        this.faturamentoNull = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCEERequestRegistroAreaEntrada() {
        super();
    }
}
