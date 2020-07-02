/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA3SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA3SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CGRP-ECONM"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-NRELAT-CREDT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nomeRelat
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-NOME-RELAT"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 50, pic = "X(050)")
    protected String nomeRelat = null;

    /**
     * Atributo csgmtoRelat
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CSGMTO-RELAT"}, maxLength = 3,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 3, pic = "9(003)")
    protected int csgmtoRelat = 0;

    /**
     * Atributo cidtfdTrnsp
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CIDTFD-TRNSP"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int cidtfdTrnsp = 0;

    /**
     * Atributo cidtfdImobl
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CIDTFD-IMOBL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int cidtfdImobl = 0;

    /**
     * Atributo cidtfdAgric
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CIDTFD-AGRIC"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int cidtfdAgric = 0;

    /**
     * Atributo cidtfdProj
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CIDTFD-PROJ"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int cidtfdProj = 0;

    /**
     * Atributo dinclRel
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-DINCL-REL"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 10, pic = "X(010)")
    protected String dinclRel = null;

    /**
     * Atributo hinclRel
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-HINCL-REL"}, maxLength = 8,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 8, pic = "X(008)")
    protected String hinclRel = null;

    /**
     * Atributo cusuarIncl
     */
    @CommareaField(name = {"RICCWA3S-REGISTRO", "RICCWA3S-AREA-SAIDA", "RICCWA3S-CUSUAR-INCL"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 9, pic = "X(009)")
    protected String cusuarIncl = null;

    /**
     * Propósito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Propósito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

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
     * Propósito:  Retornar o valor de dinclRel
     *
     * @return dinclRel
     */
    public String getDinclRel() {
        return dinclRel;
    }

    /**
     * Propósito:  Atribuir valor ao dinclRel
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDinclRel(String value) {
        this.dinclRel = value;
    }

    /**
     * Propósito:  Retornar o valor de hinclRel
     *
     * @return hinclRel
     */
    public String getHinclRel() {
        return hinclRel;
    }

    /**
     * Propósito:  Atribuir valor ao hinclRel
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setHinclRel(String value) {
        this.hinclRel = value;
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
    public RICCWA3SResponseRegistroAreaSaida() {
        super();
    }
}
