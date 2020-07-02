/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAASResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAASResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-NRELAT-CREDT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nomeRelat
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-NOME-RELAT"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 50, pic = "X(050)")
    protected String nomeRelat = null;

    /**
     * Atributo csgmtoRelat
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CSGMTO-RELAT"}, maxLength = 3,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int csgmtoRelat = 0;

    /**
     * Atributo cidtfdTrnsp
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CIDTFD-TRNSP"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int cidtfdTrnsp = 0;

    /**
     * Atributo cidtfdImobl
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CIDTFD-IMOBL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int cidtfdImobl = 0;

    /**
     * Atributo cidtfdAgric
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CIDTFD-AGRIC"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int cidtfdAgric = 0;

    /**
     * Atributo cidtfdProj
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CIDTFD-PROJ"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int cidtfdProj = 0;

    /**
     * Atributo csitRelat
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CSIT-RELAT"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int csitRelat = 0;

    /**
     * Atributo dataRel
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-DATA-REL"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 10, pic = "X(010)")
    protected String dataRel = null;

    /**
     * Atributo horaRel
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-HORA-REL"}, maxLength = 8,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 8, pic = "X(008)")
    protected String horaRel = null;

    /**
     * Atributo cusuarIncl
     */
    @CommareaField(name = {"RICCWAAS-REGISTRO", "RICCWAAS-AREA-SAIDA", "RICCWAAS-CUSUAR-INCL"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 9, pic = "X(009)")
    protected String cusuarIncl = null;

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
     * Propósito:  Retornar o valor de nomeRelat
     *
     * @return nomeRelat
     */
    public String getNomeRelat() {
        return nomeRelat;
    }

    /**
     * Propósito:  Atribuir valor ao nomeRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNomeRelat(String value) {
        this.nomeRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de csgmtoRelat
     *
     * @return csgmtoRelat
     */
    public int getCsgmtoRelat() {
        return csgmtoRelat;
    }

    /**
     * Propósito:  Atribuir valor ao csgmtoRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsgmtoRelat(int value) {
        this.csgmtoRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdTrnsp
     *
     * @return cidtfdTrnsp
     */
    public int getCidtfdTrnsp() {
        return cidtfdTrnsp;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdTrnsp(int value) {
        this.cidtfdTrnsp = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdImobl
     *
     * @return cidtfdImobl
     */
    public int getCidtfdImobl() {
        return cidtfdImobl;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdImobl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdImobl(int value) {
        this.cidtfdImobl = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdAgric
     *
     * @return cidtfdAgric
     */
    public int getCidtfdAgric() {
        return cidtfdAgric;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdAgric
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdAgric(int value) {
        this.cidtfdAgric = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdProj
     *
     * @return cidtfdProj
     */
    public int getCidtfdProj() {
        return cidtfdProj;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdProj(int value) {
        this.cidtfdProj = value;
    }

    /**
     * Propósito:  Retornar o valor de csitRelat
     *
     * @return csitRelat
     */
    public int getCsitRelat() {
        return csitRelat;
    }

    /**
     * Propósito:  Atribuir valor ao csitRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsitRelat(int value) {
        this.csitRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de dataRel
     *
     * @return dataRel
     */
    public String getDataRel() {
        return dataRel;
    }

    /**
     * Propósito:  Atribuir valor ao dataRel
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDataRel(String value) {
        this.dataRel = value;
    }

    /**
     * Propósito:  Retornar o valor de horaRel
     *
     * @return horaRel
     */
    public String getHoraRel() {
        return horaRel;
    }

    /**
     * Propósito:  Atribuir valor ao horaRel
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setHoraRel(String value) {
        this.horaRel = value;
    }

    /**
     * Propósito:  Retornar o valor de cusuarIncl
     *
     * @return cusuarIncl
     */
    public String getCusuarIncl() {
        return cusuarIncl;
    }

    /**
     * Propósito:  Atribuir valor ao cusuarIncl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCusuarIncl(String value) {
        this.cusuarIncl = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAASResponseRegistroAreaSaida() {
        super();
    }
}
