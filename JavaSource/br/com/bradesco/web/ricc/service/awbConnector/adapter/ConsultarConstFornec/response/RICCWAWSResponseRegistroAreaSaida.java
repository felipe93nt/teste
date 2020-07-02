/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAWSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAWSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nconstForn
     */
    @CommareaField(name = {"RICCWAWS-REGISTRO", "RICCWAWS-AREA-SAIDA", "RICCWAWS-NCONST-FORN"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nconstForn = 0;

    /**
     * Atributo rconFornc
     */
    @CommareaField(name = {"RICCWAWS-REGISTRO", "RICCWAWS-AREA-SAIDA", "RICCWAWS-RCON-FORNC"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 30, pic = "X(030)")
    protected String rconFornc = null;

    /**
     * Propósito:  Retornar o valor de nconstForn
     *
     * @return nconstForn
     */
    public int getNconstForn() {
        return nconstForn;
    }

    /**
     * Propósito:  Atribuir valor ao nconstForn
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNconstForn(int value) {
        this.nconstForn = value;
    }

    /**
     * Propósito:  Retornar o valor de rconFornc
     *
     * @return rconFornc
     */
    public String getRconFornc() {
        return rconFornc;
    }

    /**
     * Propósito:  Atribuir valor ao rconFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRconFornc(String value) {
        this.rconFornc = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAWSResponseRegistroAreaSaida() {
        super();
    }
}
