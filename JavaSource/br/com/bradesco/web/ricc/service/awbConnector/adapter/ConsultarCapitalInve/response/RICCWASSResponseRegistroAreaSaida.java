/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWASSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWASSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncaptlInves
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-NCAPTL-INVES"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int ncaptlInves = 0;

    /**
     * Atributo nanoCaptl
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-NANO-CAPTL"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoCaptl = 0;

    /**
     * Atributo vrecrsPprioS
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-PROPRIOS", "RICCWASS"
        + "-VRECRS-PPRIO-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String vrecrsPprioS = null;

    /**
     * Atributo vrecrsPprio
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-PROPRIOS", "RICCWASS"
        + "-VRECRS-PPRIO"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V"
        + "99")
    protected BigDecimal vrecrsPprio = null;

    /**
     * Atributo vrecrsPprioN
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-PROPRIOS", "RICCWASS"
        + "-VRECRS-PPRIO-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String vrecrsPprioN = null;

    /**
     * Atributo vrecrsTceroS
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-TERCEIROS", "RICCWAS"
        + "S-VRECRS-TCERO-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1,
        pic = "X(001)")
    protected String vrecrsTceroS = null;

    /**
     * Atributo vrecrsTcero
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-TERCEIROS", "RICCWAS"
        + "S-VRECRS-TCERO"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 6, maxBytes = 17, pic = "9(015)"
        + "V99")
    protected BigDecimal vrecrsTcero = null;

    /**
     * Atributo vrecrsTceroN
     */
    @CommareaField(name = {"RICCWASS-REGISTRO", "RICCWASS-AREA-SAIDA", "RICCWASS-RECURSOS-TERCEIROS", "RICCWAS"
        + "S-VRECRS-TCERO-N"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1,
        pic = "X(001)")
    protected String vrecrsTceroN = null;

    /**
     * Prop�sito:  Retornar o valor de ncaptlInves
     *
     * @return ncaptlInves
     */
    public int getNcaptlInves() {
        return ncaptlInves;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncaptlInves
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcaptlInves(int value) {
        this.ncaptlInves = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nanoCaptl
     *
     * @return nanoCaptl
     */
    public int getNanoCaptl() {
        return nanoCaptl;
    }

    /**
     * Prop�sito:  Atribuir valor ao nanoCaptl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoCaptl(int value) {
        this.nanoCaptl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsPprioS
     *
     * @return vrecrsPprioS
     */
    public String getVrecrsPprioS() {
        return vrecrsPprioS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsPprioS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsPprioS(String value) {
        this.vrecrsPprioS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsPprio
     *
     * @return vrecrsPprio
     */
    public BigDecimal getVrecrsPprio() {
        return vrecrsPprio;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsPprio
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsPprio(BigDecimal value) {
        this.vrecrsPprio = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsPprioN
     *
     * @return vrecrsPprioN
     */
    public String getVrecrsPprioN() {
        return vrecrsPprioN;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsPprioN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsPprioN(String value) {
        this.vrecrsPprioN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsTceroS
     *
     * @return vrecrsTceroS
     */
    public String getVrecrsTceroS() {
        return vrecrsTceroS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsTceroS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsTceroS(String value) {
        this.vrecrsTceroS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsTcero
     *
     * @return vrecrsTcero
     */
    public BigDecimal getVrecrsTcero() {
        return vrecrsTcero;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsTcero
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsTcero(BigDecimal value) {
        this.vrecrsTcero = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecrsTceroN
     *
     * @return vrecrsTceroN
     */
    public String getVrecrsTceroN() {
        return vrecrsTceroN;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecrsTceroN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecrsTceroN(String value) {
        this.vrecrsTceroN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWASSResponseRegistroAreaSaida() {
        super();
    }
}
