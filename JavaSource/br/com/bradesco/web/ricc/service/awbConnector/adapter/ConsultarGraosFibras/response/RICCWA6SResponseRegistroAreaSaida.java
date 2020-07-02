/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA6SResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA6SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nprodRelat
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-NPROD-RELAT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nprodRelat = 0;

    /**
     * Atributo anoSafra
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-ANO-SAFRA"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 5, pic = "X(005)")
    protected String anoSafra = null;

    /**
     * Atributo areaPropr
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-AREA-PROPRIA", "RICCWA6S-AREA"
        + "-PROPR"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 2, maxBytes = 15, pic = "9(015)")
    protected long areaPropr = 0L;

    /**
     * Atributo areaProprNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-AREA-PROPRIA", "RICCWA6S-AREA"
        + "-PROPR-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String areaProprNull = null;

    /**
     * Atributo areaArrend
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-AREA-ARRENDADA", "RICCWA6S-AR"
        + "EA-ARREND"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 4, maxBytes = 15, pic = "9(015)")
    protected long areaArrend = 0L;

    /**
     * Atributo areaArrendNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-AREA-ARRENDADA", "RICCWA6S-AR"
        + "EA-ARREND-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String areaArrendNull = null;

    /**
     * Atributo produtivKg
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUTIVIDADE-KG", "RICCWA6S-"
        + "PRODUTIV-KG"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 6, maxBytes = 15, pic = "9(015)")
    protected long produtivKg = 0L;

    /**
     * Atributo produtivKgNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUTIVIDADE-KG", "RICCWA6S-"
        + "PRODUTIV-KG-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1,
        pic = "X(001)")
    protected String produtivKgNull = null;

    /**
     * Atributo prodGrao
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-GRAOS", "RICCWA6S-PR"
        + "OD-GRAO"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 8, maxBytes = 15, pic = "9(015)")
    protected long prodGrao = 0L;

    /**
     * Atributo prodGraoNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-GRAOS", "RICCWA6S-PR"
        + "OD-GRAO-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String prodGraoNull = null;

    /**
     * Atributo prodSemnt
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-SEMENTES", "RICCWA6S"
        + "-PROD-SEMNT"}, maxLength = 15, usage = "DISPLAY", fieldNumber = 10, maxBytes = 15, pic = "9(015)")
    protected long prodSemnt = 0L;

    /**
     * Atributo prodSemntNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-SEMENTES", "RICCWA6S"
        + "-PROD-SEMNT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001"
        + ")")
    protected String prodSemntNull = null;

    /**
     * Atributo prodSemntKg
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-SEMNT-KG", "RICCWA6S"
        + "-PROD-SEMNT-KG"}, maxLength = 2, usage = "DISPLAY", fieldNumber = 12, maxBytes = 2, pic = "9(002)")
    protected int prodSemntKg = 0;

    /**
     * Atributo prodSemntKgNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PRODUCAO-SEMNT-KG", "RICCWA6S"
        + "-PROD-SEMNT-KG-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X("
        + "001)")
    protected String prodSemntKgNull = null;

    /**
     * Atributo vmedGrao
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-GRAO", "RICCWA6S-"
        + "VMED-GRAO"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmedGrao = null;

    /**
     * Atributo vmedGraoNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-GRAO", "RICCWA6S-"
        + "VMED-GRAO-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001)")
    protected String vmedGraoNull = null;

    /**
     * Atributo vmedSemnt
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-SEMENTE", "RICCWA"
        + "6S-VMED-SEMNT"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 16, maxBytes = 17, pic = "9(015)"
        + "V99")
    protected BigDecimal vmedSemnt = null;

    /**
     * Atributo vmedSemntNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-SEMENTE", "RICCWA"
        + "6S-VMED-SEMNT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 17, maxBytes = 1, pic = "X(0"
        + "01)")
    protected String vmedSemntNull = null;

    /**
     * Atributo vmedSemntKg
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-SEMNT-KG", "RICCW"
        + "A6S-VMED-SEMNT-KG"}, maxLength = 2, usage = "DISPLAY", fieldNumber = 18, maxBytes = 2, pic = "9(00"
        + "2)")
    protected int vmedSemntKg = 0;

    /**
     * Atributo vmedSemntKgNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-SEMNT-KG", "RICCW"
        + "A6S-VMED-SEMNT-KG-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1, pic = 
        "X(001)")
    protected String vmedSemntKgNull = null;

    /**
     * Atributo pvolGraoFix
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VOLUME-GRAO-FIXADO", "RICCWA6"
        + "S-PVOL-GRAO-FIX"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 20, maxBytes = 5, pic = "9(003)"
        + "V99")
    protected BigDecimal pvolGraoFix = null;

    /**
     * Atributo pvolGraoFixNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VOLUME-GRAO-FIXADO", "RICCWA6"
        + "S-PVOL-GRAO-FIX-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 21, maxBytes = 1, pic = "X"
        + "(001)")
    protected String pvolGraoFixNull = null;

    /**
     * Atributo vmedGraoFix
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-GRAO-FIXADO", "RICCWA6S"
        + "-VMED-GRAO-FIX"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 22, maxBytes = 17, pic = "9(015"
        + ")V99")
    protected BigDecimal vmedGraoFix = null;

    /**
     * Atributo vmedGraoFixNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-GRAO-FIXADO", "RICCWA6S"
        + "-VMED-GRAO-FIX-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 23, maxBytes = 1, pic = "X("
        + "001)")
    protected String vmedGraoFixNull = null;

    /**
     * Atributo vcustoProd
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-CUSTO-PROD", "RICCWA6S-VCUSTO"
        + "-PROD"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 24, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoProd = null;

    /**
     * Atributo vcustoProdNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-CUSTO-PROD", "RICCWA6S-VCUSTO"
        + "-PROD-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 25, maxBytes = 1, pic = "X(001)")
    protected String vcustoProdNull = null;

    /**
     * Atributo plumaAHect
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PLUMA-ARROBA-HECT", "RICCWA6S"
        + "-PLUMA-A-HECT"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 26, maxBytes = 17, pic = "9(015)"
        + "V99")
    protected BigDecimal plumaAHect = null;

    /**
     * Atributo plumaAHectNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-PLUMA-ARROBA-HECT", "RICCWA6S"
        + "-PLUMA-A-HECT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 27, maxBytes = 1, pic = "X(0"
        + "01)")
    protected String plumaAHectNull = null;

    /**
     * Atributo carocoAHect
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-CAROCO-ARROBA-HECT", "RICCWA6"
        + "S-CAROCO-A-HECT"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 28, maxBytes = 17, pic = "9(01"
        + "5)V99")
    protected BigDecimal carocoAHect = null;

    /**
     * Atributo carocoAHectNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-CAROCO-ARROBA-HECT", "RICCWA6"
        + "S-CAROCO-A-HECT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 29, maxBytes = 1, pic = "X"
        + "(001)")
    protected String carocoAHectNull = null;

    /**
     * Atributo fibrilhaAHect
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-FIBRILHA-ARROBA-HECT", "RICCW"
        + "A6S-FIBRILHA-A-HECT"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 30, maxBytes = 17, pic = ""
        + "9(015)V99")
    protected BigDecimal fibrilhaAHect = null;

    /**
     * Atributo fibrilhaAHectNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-FIBRILHA-ARROBA-HECT", "RICCW"
        + "A6S-FIBRILHA-A-HECT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 31, maxBytes = 1,
        pic = "X(001)")
    protected String fibrilhaAHectNull = null;

    /**
     * Atributo vmedPluma
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-PLUMA", "RICCWA6S"
        + "-VMED-PLUMA"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 32, maxBytes = 17, pic = "9(015)V9"
        + "9")
    protected BigDecimal vmedPluma = null;

    /**
     * Atributo vmedPlumaNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-PLUMA", "RICCWA6S"
        + "-VMED-PLUMA-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 33, maxBytes = 1, pic = "X(001"
        + ")")
    protected String vmedPlumaNull = null;

    /**
     * Atributo vmedCaroco
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-CAROCO", "RICCWA6"
        + "S-VMED-CAROCO"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 34, maxBytes = 17, pic = "9(015)"
        + "V99")
    protected BigDecimal vmedCaroco = null;

    /**
     * Atributo vmedCarocoNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-CAROCO", "RICCWA6"
        + "S-VMED-CAROCO-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 35, maxBytes = 1, pic = "X(0"
        + "01)")
    protected String vmedCarocoNull = null;

    /**
     * Atributo vmedFibrilha
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-FIBRILHA", "RICCW"
        + "A6S-VMED-FIBRILHA"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 36, maxBytes = 17, pic = "9("
        + "015)V99")
    protected BigDecimal vmedFibrilha = null;

    /**
     * Atributo vmedFibrilhaNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-MEDIO-FIBRILHA", "RICCW"
        + "A6S-VMED-FIBRILHA-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 37, maxBytes = 1, pic = 
        "X(001)")
    protected String vmedFibrilhaNull = null;

    /**
     * Atributo pvolPlumaFix
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VOLUME-PLUMA-FIXADO", "RICCWA"
        + "6S-PVOL-PLUMA-FIX"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 38, maxBytes = 5, pic = "9(00"
        + "3)V99")
    protected BigDecimal pvolPlumaFix = null;

    /**
     * Atributo pvolPlumaFixNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VOLUME-PLUMA-FIXADO", "RICCWA"
        + "6S-PVOL-PLUMA-FIX-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 39, maxBytes = 1, pic = 
        "X(001)")
    protected String pvolPlumaFixNull = null;

    /**
     * Atributo vmedPlumaFix
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-PLUMA-FIXADO", "RICCWA6"
        + "S-VMED-PLUMA-FIX"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 40, maxBytes = 17, pic = "9(0"
        + "15)V99")
    protected BigDecimal vmedPlumaFix = null;

    /**
     * Atributo vmedPlumaFixNull
     */
    @CommareaField(name = {"RICCWA6S-REGISTRO", "RICCWA6S-AREA-SAIDA", "RICCWA6S-VALOR-PLUMA-FIXADO", "RICCWA6"
        + "S-VMED-PLUMA-FIX-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 41, maxBytes = 1, pic = ""
        + "X(001)")
    protected String vmedPlumaFixNull = null;

    /**
     * Prop�sito:  Retornar o valor de nprodRelat
     *
     * @return nprodRelat
     */
    public int getNprodRelat() {
        return nprodRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao nprodRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNprodRelat(int value) {
        this.nprodRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de anoSafra
     *
     * @return anoSafra
     */
    public String getAnoSafra() {
        return anoSafra;
    }

    /**
     * Prop�sito:  Atribuir valor ao anoSafra
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAnoSafra(String value) {
        this.anoSafra = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaPropr
     *
     * @return areaPropr
     */
    public long getAreaPropr() {
        return areaPropr;
    }

    /**
     * Prop�sito:  Atribuir valor ao areaPropr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaPropr(long value) {
        this.areaPropr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaProprNull
     *
     * @return areaProprNull
     */
    public String getAreaProprNull() {
        return areaProprNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao areaProprNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaProprNull(String value) {
        this.areaProprNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaArrend
     *
     * @return areaArrend
     */
    public long getAreaArrend() {
        return areaArrend;
    }

    /**
     * Prop�sito:  Atribuir valor ao areaArrend
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaArrend(long value) {
        this.areaArrend = value;
    }

    /**
     * Prop�sito:  Retornar o valor de areaArrendNull
     *
     * @return areaArrendNull
     */
    public String getAreaArrendNull() {
        return areaArrendNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao areaArrendNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setAreaArrendNull(String value) {
        this.areaArrendNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de produtivKg
     *
     * @return produtivKg
     */
    public long getProdutivKg() {
        return produtivKg;
    }

    /**
     * Prop�sito:  Atribuir valor ao produtivKg
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdutivKg(long value) {
        this.produtivKg = value;
    }

    /**
     * Prop�sito:  Retornar o valor de produtivKgNull
     *
     * @return produtivKgNull
     */
    public String getProdutivKgNull() {
        return produtivKgNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao produtivKgNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdutivKgNull(String value) {
        this.produtivKgNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodGrao
     *
     * @return prodGrao
     */
    public long getProdGrao() {
        return prodGrao;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodGrao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdGrao(long value) {
        this.prodGrao = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodGraoNull
     *
     * @return prodGraoNull
     */
    public String getProdGraoNull() {
        return prodGraoNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodGraoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdGraoNull(String value) {
        this.prodGraoNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodSemnt
     *
     * @return prodSemnt
     */
    public long getProdSemnt() {
        return prodSemnt;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodSemnt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdSemnt(long value) {
        this.prodSemnt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodSemntNull
     *
     * @return prodSemntNull
     */
    public String getProdSemntNull() {
        return prodSemntNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodSemntNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdSemntNull(String value) {
        this.prodSemntNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodSemntKg
     *
     * @return prodSemntKg
     */
    public int getProdSemntKg() {
        return prodSemntKg;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodSemntKg
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdSemntKg(int value) {
        this.prodSemntKg = value;
    }

    /**
     * Prop�sito:  Retornar o valor de prodSemntKgNull
     *
     * @return prodSemntKgNull
     */
    public String getProdSemntKgNull() {
        return prodSemntKgNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao prodSemntKgNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setProdSemntKgNull(String value) {
        this.prodSemntKgNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedGrao
     *
     * @return vmedGrao
     */
    public BigDecimal getVmedGrao() {
        return vmedGrao;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedGrao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedGrao(BigDecimal value) {
        this.vmedGrao = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedGraoNull
     *
     * @return vmedGraoNull
     */
    public String getVmedGraoNull() {
        return vmedGraoNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedGraoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedGraoNull(String value) {
        this.vmedGraoNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedSemnt
     *
     * @return vmedSemnt
     */
    public BigDecimal getVmedSemnt() {
        return vmedSemnt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedSemnt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedSemnt(BigDecimal value) {
        this.vmedSemnt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedSemntNull
     *
     * @return vmedSemntNull
     */
    public String getVmedSemntNull() {
        return vmedSemntNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedSemntNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedSemntNull(String value) {
        this.vmedSemntNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedSemntKg
     *
     * @return vmedSemntKg
     */
    public int getVmedSemntKg() {
        return vmedSemntKg;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedSemntKg
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedSemntKg(int value) {
        this.vmedSemntKg = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedSemntKgNull
     *
     * @return vmedSemntKgNull
     */
    public String getVmedSemntKgNull() {
        return vmedSemntKgNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedSemntKgNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedSemntKgNull(String value) {
        this.vmedSemntKgNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvolGraoFix
     *
     * @return pvolGraoFix
     */
    public BigDecimal getPvolGraoFix() {
        return pvolGraoFix;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvolGraoFix
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvolGraoFix(BigDecimal value) {
        this.pvolGraoFix = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvolGraoFixNull
     *
     * @return pvolGraoFixNull
     */
    public String getPvolGraoFixNull() {
        return pvolGraoFixNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvolGraoFixNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvolGraoFixNull(String value) {
        this.pvolGraoFixNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedGraoFix
     *
     * @return vmedGraoFix
     */
    public BigDecimal getVmedGraoFix() {
        return vmedGraoFix;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedGraoFix
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedGraoFix(BigDecimal value) {
        this.vmedGraoFix = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedGraoFixNull
     *
     * @return vmedGraoFixNull
     */
    public String getVmedGraoFixNull() {
        return vmedGraoFixNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedGraoFixNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedGraoFixNull(String value) {
        this.vmedGraoFixNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcustoProd
     *
     * @return vcustoProd
     */
    public BigDecimal getVcustoProd() {
        return vcustoProd;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcustoProd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoProd(BigDecimal value) {
        this.vcustoProd = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcustoProdNull
     *
     * @return vcustoProdNull
     */
    public String getVcustoProdNull() {
        return vcustoProdNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcustoProdNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoProdNull(String value) {
        this.vcustoProdNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de plumaAHect
     *
     * @return plumaAHect
     */
    public BigDecimal getPlumaAHect() {
        return plumaAHect;
    }

    /**
     * Prop�sito:  Atribuir valor ao plumaAHect
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlumaAHect(BigDecimal value) {
        this.plumaAHect = value;
    }

    /**
     * Prop�sito:  Retornar o valor de plumaAHectNull
     *
     * @return plumaAHectNull
     */
    public String getPlumaAHectNull() {
        return plumaAHectNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao plumaAHectNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlumaAHectNull(String value) {
        this.plumaAHectNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de carocoAHect
     *
     * @return carocoAHect
     */
    public BigDecimal getCarocoAHect() {
        return carocoAHect;
    }

    /**
     * Prop�sito:  Atribuir valor ao carocoAHect
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCarocoAHect(BigDecimal value) {
        this.carocoAHect = value;
    }

    /**
     * Prop�sito:  Retornar o valor de carocoAHectNull
     *
     * @return carocoAHectNull
     */
    public String getCarocoAHectNull() {
        return carocoAHectNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao carocoAHectNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCarocoAHectNull(String value) {
        this.carocoAHectNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fibrilhaAHect
     *
     * @return fibrilhaAHect
     */
    public BigDecimal getFibrilhaAHect() {
        return fibrilhaAHect;
    }

    /**
     * Prop�sito:  Atribuir valor ao fibrilhaAHect
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFibrilhaAHect(BigDecimal value) {
        this.fibrilhaAHect = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fibrilhaAHectNull
     *
     * @return fibrilhaAHectNull
     */
    public String getFibrilhaAHectNull() {
        return fibrilhaAHectNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao fibrilhaAHectNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFibrilhaAHectNull(String value) {
        this.fibrilhaAHectNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedPluma
     *
     * @return vmedPluma
     */
    public BigDecimal getVmedPluma() {
        return vmedPluma;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedPluma
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedPluma(BigDecimal value) {
        this.vmedPluma = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedPlumaNull
     *
     * @return vmedPlumaNull
     */
    public String getVmedPlumaNull() {
        return vmedPlumaNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedPlumaNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedPlumaNull(String value) {
        this.vmedPlumaNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedCaroco
     *
     * @return vmedCaroco
     */
    public BigDecimal getVmedCaroco() {
        return vmedCaroco;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedCaroco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedCaroco(BigDecimal value) {
        this.vmedCaroco = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedCarocoNull
     *
     * @return vmedCarocoNull
     */
    public String getVmedCarocoNull() {
        return vmedCarocoNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedCarocoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedCarocoNull(String value) {
        this.vmedCarocoNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedFibrilha
     *
     * @return vmedFibrilha
     */
    public BigDecimal getVmedFibrilha() {
        return vmedFibrilha;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedFibrilha
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedFibrilha(BigDecimal value) {
        this.vmedFibrilha = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedFibrilhaNull
     *
     * @return vmedFibrilhaNull
     */
    public String getVmedFibrilhaNull() {
        return vmedFibrilhaNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedFibrilhaNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedFibrilhaNull(String value) {
        this.vmedFibrilhaNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvolPlumaFix
     *
     * @return pvolPlumaFix
     */
    public BigDecimal getPvolPlumaFix() {
        return pvolPlumaFix;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvolPlumaFix
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvolPlumaFix(BigDecimal value) {
        this.pvolPlumaFix = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvolPlumaFixNull
     *
     * @return pvolPlumaFixNull
     */
    public String getPvolPlumaFixNull() {
        return pvolPlumaFixNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvolPlumaFixNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvolPlumaFixNull(String value) {
        this.pvolPlumaFixNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedPlumaFix
     *
     * @return vmedPlumaFix
     */
    public BigDecimal getVmedPlumaFix() {
        return vmedPlumaFix;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedPlumaFix
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedPlumaFix(BigDecimal value) {
        this.vmedPlumaFix = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vmedPlumaFixNull
     *
     * @return vmedPlumaFixNull
     */
    public String getVmedPlumaFixNull() {
        return vmedPlumaFixNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vmedPlumaFixNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmedPlumaFixNull(String value) {
        this.vmedPlumaFixNull = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA6SResponseRegistroAreaSaida() {
        super();
    }
}
