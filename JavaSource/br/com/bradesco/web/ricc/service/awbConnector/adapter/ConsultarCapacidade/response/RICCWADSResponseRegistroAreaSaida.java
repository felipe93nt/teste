/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWADSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWADSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncapacPrtv
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA", "RICCWADS-NCAPAC-PRTV"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int ncapacPrtv = 0;

    /**
     * Atributo rplanta
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA", "RICCWADS-RPLANTA"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 30, pic = "X(030)")
    protected String rplanta = null;

    /**
     * Atributo qtCapac
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA", "RICCWADS-QT-CAPAC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 9, pic = "9(009)")
    protected int qtCapac = 0;

    /**
     * Atributo qtProduc
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA", "RICCWADS-QT-PRODUC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int qtProduc = 0;

    /**
     * Atributo putilzProd
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA", "RICCWADS-PUTILZ-PROD"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal putilzProd = null;

    /**
     * Propósito:  Retornar o valor de ncapacPrtv
     *
     * @return ncapacPrtv
     */
    public int getNcapacPrtv() {
        return ncapacPrtv;
    }

    /**
     * Propósito:  Atribuir valor ao ncapacPrtv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcapacPrtv(int value) {
        this.ncapacPrtv = value;
    }

    /**
     * Propósito:  Retornar o valor de rplanta
     *
     * @return rplanta
     */
    public String getRplanta() {
        return rplanta;
    }

    /**
     * Propósito:  Atribuir valor ao rplanta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRplanta(String value) {
        this.rplanta = value;
    }

    /**
     * Propósito:  Retornar o valor de qtCapac
     *
     * @return qtCapac
     */
    public int getQtCapac() {
        return qtCapac;
    }

    /**
     * Propósito:  Atribuir valor ao qtCapac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtCapac(int value) {
        this.qtCapac = value;
    }

    /**
     * Propósito:  Retornar o valor de qtProduc
     *
     * @return qtProduc
     */
    public int getQtProduc() {
        return qtProduc;
    }

    /**
     * Propósito:  Atribuir valor ao qtProduc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtProduc(int value) {
        this.qtProduc = value;
    }

    /**
     * Propósito:  Retornar o valor de putilzProd
     *
     * @return putilzProd
     */
    public BigDecimal getPutilzProd() {
        return putilzProd;
    }

    /**
     * Propósito:  Atribuir valor ao putilzProd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPutilzProd(BigDecimal value) {
        this.putilzProd = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWADSResponseRegistroAreaSaida() {
        super();
    }
}
