/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAZSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAZSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nemptoImob
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-AREA-SAIDA", "RICCWAZS-NEMPTO-IMOB"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nemptoImob = 0;

    /**
     * Atributo nanoHist
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-AREA-SAIDA", "RICCWAZS-NANO-HIST"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoHist = 0;

    /**
     * Atributo vtotLcto
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-AREA-SAIDA", "RICCWAZS-VTOT-LCTO"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotLcto = null;

    /**
     * Atributo qtotLcto
     */
    @CommareaField(name = {"RICCWAZS-REGISTRO", "RICCWAZS-AREA-SAIDA", "RICCWAZS-QTOT-LCTO"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int qtotLcto = 0;

    /**
     * Propósito:  Retornar o valor de nemptoImob
     *
     * @return nemptoImob
     */
    public int getNemptoImob() {
        return nemptoImob;
    }

    /**
     * Propósito:  Atribuir valor ao nemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNemptoImob(int value) {
        this.nemptoImob = value;
    }

    /**
     * Propósito:  Retornar o valor de nanoHist
     *
     * @return nanoHist
     */
    public int getNanoHist() {
        return nanoHist;
    }

    /**
     * Propósito:  Atribuir valor ao nanoHist
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoHist(int value) {
        this.nanoHist = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotLcto
     *
     * @return vtotLcto
     */
    public BigDecimal getVtotLcto() {
        return vtotLcto;
    }

    /**
     * Propósito:  Atribuir valor ao vtotLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotLcto(BigDecimal value) {
        this.vtotLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotLcto
     *
     * @return qtotLcto
     */
    public int getQtotLcto() {
        return qtotLcto;
    }

    /**
     * Propósito:  Atribuir valor ao qtotLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotLcto(int value) {
        this.qtotLcto = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAZSResponseRegistroAreaSaida() {
        super();
    }
}
