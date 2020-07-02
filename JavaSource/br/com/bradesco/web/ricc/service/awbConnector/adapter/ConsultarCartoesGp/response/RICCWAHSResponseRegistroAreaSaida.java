/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAHSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAHSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncataoCredt
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-SAIDA", "RICCWAHS-NCATAO-CREDT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int ncataoCredt = 0;

    /**
     * Atributo qtotCart
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-SAIDA", "RICCWAHS-QTOT-CART"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 9, pic = "9(009)")
    protected int qtotCart = 0;

    /**
     * Atributo vresul
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-SAIDA", "RICCWAHS-VRESUL"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresul = null;

    /**
     * Atributo rbande
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-SAIDA", "RICCWAHS-RBANDE"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 30, pic = "X(030)")
    protected String rbande = null;

    /**
     * Prop�sito:  Retornar o valor de ncataoCredt
     *
     * @return ncataoCredt
     */
    public int getNcataoCredt() {
        return ncataoCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncataoCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcataoCredt(int value) {
        this.ncataoCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtotCart
     *
     * @return qtotCart
     */
    public int getQtotCart() {
        return qtotCart;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotCart
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotCart(int value) {
        this.qtotCart = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresul
     *
     * @return vresul
     */
    public BigDecimal getVresul() {
        return vresul;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresul
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresul(BigDecimal value) {
        this.vresul = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rbande
     *
     * @return rbande
     */
    public String getRbande() {
        return rbande;
    }

    /**
     * Prop�sito:  Atribuir valor ao rbande
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRbande(String value) {
        this.rbande = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAHSResponseRegistroAreaSaida() {
        super();
    }
}
