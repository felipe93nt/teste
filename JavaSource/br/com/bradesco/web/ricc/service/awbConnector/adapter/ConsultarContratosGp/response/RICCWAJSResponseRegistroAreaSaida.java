/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAJSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAJSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ndetlhContr
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-NDETLH-CONTR"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int ndetlhContr = 0;

    /**
     * Atributo rproj
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-RPROJ"}, maxLength = 100,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 100, pic = "X(100)")
    protected String rproj = null;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-IRZ-SCIAL"}, maxLength = 70,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo vcontr
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-VCONTR"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcontr = null;

    /**
     * Atributo vsaldo
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-VSALDO"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsaldo = null;

    /**
     * Atributo dtFim
     */
    @CommareaField(name = {"RICCWAJS-REGISTRO", "RICCWAJS-AREA-SAIDA", "RICCWAJS-DT-FIM"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 10, pic = "X(010)")
    protected String dtFim = null;

    /**
     * Propósito:  Retornar o valor de ndetlhContr
     *
     * @return ndetlhContr
     */
    public int getNdetlhContr() {
        return ndetlhContr;
    }

    /**
     * Propósito:  Atribuir valor ao ndetlhContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNdetlhContr(int value) {
        this.ndetlhContr = value;
    }

    /**
     * Propósito:  Retornar o valor de rproj
     *
     * @return rproj
     */
    public String getRproj() {
        return rproj;
    }

    /**
     * Propósito:  Atribuir valor ao rproj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRproj(String value) {
        this.rproj = value;
    }

    /**
     * Propósito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Propósito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Propósito:  Retornar o valor de vcontr
     *
     * @return vcontr
     */
    public BigDecimal getVcontr() {
        return vcontr;
    }

    /**
     * Propósito:  Atribuir valor ao vcontr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcontr(BigDecimal value) {
        this.vcontr = value;
    }

    /**
     * Propósito:  Retornar o valor de vsaldo
     *
     * @return vsaldo
     */
    public BigDecimal getVsaldo() {
        return vsaldo;
    }

    /**
     * Propósito:  Atribuir valor ao vsaldo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsaldo(BigDecimal value) {
        this.vsaldo = value;
    }

    /**
     * Propósito:  Retornar o valor de dtFim
     *
     * @return dtFim
     */
    public String getDtFim() {
        return dtFim;
    }

    /**
     * Propósito:  Atribuir valor ao dtFim
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtFim(String value) {
        this.dtFim = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAJSResponseRegistroAreaSaida() {
        super();
    }
}
