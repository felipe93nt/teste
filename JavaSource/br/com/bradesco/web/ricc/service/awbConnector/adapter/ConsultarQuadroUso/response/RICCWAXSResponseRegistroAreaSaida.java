/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAXSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAXSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nquadrUso
     */
    @CommareaField(name = {"RICCWAXS-REGISTRO", "RICCWAXS-AREA-SAIDA", "RICCWAXS-NQUADR-USO"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nquadrUso = 0;

    /**
     * Atributo rquadrProj
     */
    @CommareaField(name = {"RICCWAXS-REGISTRO", "RICCWAXS-AREA-SAIDA", "RICCWAXS-RQUADR-PROJ"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 50, pic = "X(050)")
    protected String rquadrProj = null;

    /**
     * Atributo dinicQuadr
     */
    @CommareaField(name = {"RICCWAXS-REGISTRO", "RICCWAXS-AREA-SAIDA", "RICCWAXS-DINIC-QUADR"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dinicQuadr = null;

    /**
     * Atributo dfimQuadr
     */
    @CommareaField(name = {"RICCWAXS-REGISTRO", "RICCWAXS-AREA-SAIDA", "RICCWAXS-DFIM-QUADR"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 10, pic = "X(010)")
    protected String dfimQuadr = null;

    /**
     * Atributo pquadrProj
     */
    @CommareaField(name = {"RICCWAXS-REGISTRO", "RICCWAXS-AREA-SAIDA", "RICCWAXS-PQUADR-PROJ"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pquadrProj = null;

    /**
     * Prop�sito:  Retornar o valor de nquadrUso
     *
     * @return nquadrUso
     */
    public int getNquadrUso() {
        return nquadrUso;
    }

    /**
     * Prop�sito:  Atribuir valor ao nquadrUso
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNquadrUso(int value) {
        this.nquadrUso = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rquadrProj
     *
     * @return rquadrProj
     */
    public String getRquadrProj() {
        return rquadrProj;
    }

    /**
     * Prop�sito:  Atribuir valor ao rquadrProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRquadrProj(String value) {
        this.rquadrProj = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dinicQuadr
     *
     * @return dinicQuadr
     */
    public String getDinicQuadr() {
        return dinicQuadr;
    }

    /**
     * Prop�sito:  Atribuir valor ao dinicQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDinicQuadr(String value) {
        this.dinicQuadr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dfimQuadr
     *
     * @return dfimQuadr
     */
    public String getDfimQuadr() {
        return dfimQuadr;
    }

    /**
     * Prop�sito:  Atribuir valor ao dfimQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDfimQuadr(String value) {
        this.dfimQuadr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pquadrProj
     *
     * @return pquadrProj
     */
    public BigDecimal getPquadrProj() {
        return pquadrProj;
    }

    /**
     * Prop�sito:  Atribuir valor ao pquadrProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPquadrProj(BigDecimal value) {
        this.pquadrProj = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAXSResponseRegistroAreaSaida() {
        super();
    }
}
