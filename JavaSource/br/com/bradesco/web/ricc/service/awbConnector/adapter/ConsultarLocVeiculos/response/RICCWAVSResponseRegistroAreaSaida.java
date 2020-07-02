/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAVSResponseRegistroAreaSaida 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAVSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nlocacTrnsp
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-NLOCAC-TRNSP"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int nlocacTrnsp = 0;

    /**
     * Atributo nanoLocac
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-NANO-LOCAC"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoLocac = 0;

    /**
     * Atributo plocacVeicN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-PLOCAC-VEIC-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String plocacVeicN = null;

    /**
     * Atributo plocacVeic
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-PLOCAC-VEIC"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal plocacVeic = null;

    /**
     * Atributo pvdaVeicN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-PVDA-VEIC-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String pvdaVeicN = null;

    /**
     * Atributo pvdaVeic
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-PVDA-VEIC"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pvdaVeic = null;

    /**
     * Atributo potraLocacN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-POTRA-LOCAC-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "X(001)")
    protected String potraLocacN = null;

    /**
     * Atributo potraLocac
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-POTRA-LOCAC"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal potraLocac = null;

    /**
     * Atributo rotraLocacN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-ROTRA-LOCAC-N"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 8, maxBytes = 1, pic = "X(001)")
    protected String rotraLocacN = null;

    /**
     * Atributo rotraLocac
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-ROTRA-LOCAC"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 50, pic = "X(050)")
    protected String rotraLocac = null;

    /**
     * Atributo qtotUndN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-QTOT-UND-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String qtotUndN = null;

    /**
     * Atributo qtotUnd
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-QTOT-UND"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 9, pic = "9(009)")
    protected int qtotUnd = 0;

    /**
     * Atributo qvdaVeicN
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-QVDA-VEIC-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 1, pic = "X(001)")
    protected String qvdaVeicN = null;

    /**
     * Atributo qvdaVeic
     */
    @CommareaField(name = {"RICCWAVS-REGISTRO", "RICCWAVS-AREA-SAIDA", "RICCWAVS-QVDA-VEIC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 13, maxBytes = 9, pic = "9(009)")
    protected int qvdaVeic = 0;

    /**
     * Prop�sito:  Retornar o valor de nlocacTrnsp
     *
     * @return nlocacTrnsp
     */
    public int getNlocacTrnsp() {
        return nlocacTrnsp;
    }

    /**
     * Prop�sito:  Atribuir valor ao nlocacTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNlocacTrnsp(int value) {
        this.nlocacTrnsp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nanoLocac
     *
     * @return nanoLocac
     */
    public int getNanoLocac() {
        return nanoLocac;
    }

    /**
     * Prop�sito:  Atribuir valor ao nanoLocac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoLocac(int value) {
        this.nanoLocac = value;
    }

    /**
     * Prop�sito:  Retornar o valor de plocacVeicN
     *
     * @return plocacVeicN
     */
    public String getPlocacVeicN() {
        return plocacVeicN;
    }

    /**
     * Prop�sito:  Atribuir valor ao plocacVeicN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlocacVeicN(String value) {
        this.plocacVeicN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de plocacVeic
     *
     * @return plocacVeic
     */
    public BigDecimal getPlocacVeic() {
        return plocacVeic;
    }

    /**
     * Prop�sito:  Atribuir valor ao plocacVeic
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlocacVeic(BigDecimal value) {
        this.plocacVeic = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvdaVeicN
     *
     * @return pvdaVeicN
     */
    public String getPvdaVeicN() {
        return pvdaVeicN;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvdaVeicN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvdaVeicN(String value) {
        this.pvdaVeicN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvdaVeic
     *
     * @return pvdaVeic
     */
    public BigDecimal getPvdaVeic() {
        return pvdaVeic;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvdaVeic
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvdaVeic(BigDecimal value) {
        this.pvdaVeic = value;
    }

    /**
     * Prop�sito:  Retornar o valor de potraLocacN
     *
     * @return potraLocacN
     */
    public String getPotraLocacN() {
        return potraLocacN;
    }

    /**
     * Prop�sito:  Atribuir valor ao potraLocacN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPotraLocacN(String value) {
        this.potraLocacN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de potraLocac
     *
     * @return potraLocac
     */
    public BigDecimal getPotraLocac() {
        return potraLocac;
    }

    /**
     * Prop�sito:  Atribuir valor ao potraLocac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPotraLocac(BigDecimal value) {
        this.potraLocac = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rotraLocacN
     *
     * @return rotraLocacN
     */
    public String getRotraLocacN() {
        return rotraLocacN;
    }

    /**
     * Prop�sito:  Atribuir valor ao rotraLocacN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRotraLocacN(String value) {
        this.rotraLocacN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rotraLocac
     *
     * @return rotraLocac
     */
    public String getRotraLocac() {
        return rotraLocac;
    }

    /**
     * Prop�sito:  Atribuir valor ao rotraLocac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRotraLocac(String value) {
        this.rotraLocac = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtotUndN
     *
     * @return qtotUndN
     */
    public String getQtotUndN() {
        return qtotUndN;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotUndN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotUndN(String value) {
        this.qtotUndN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtotUnd
     *
     * @return qtotUnd
     */
    public int getQtotUnd() {
        return qtotUnd;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotUnd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotUnd(int value) {
        this.qtotUnd = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qvdaVeicN
     *
     * @return qvdaVeicN
     */
    public String getQvdaVeicN() {
        return qvdaVeicN;
    }

    /**
     * Prop�sito:  Atribuir valor ao qvdaVeicN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQvdaVeicN(String value) {
        this.qvdaVeicN = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qvdaVeic
     *
     * @return qvdaVeic
     */
    public int getQvdaVeic() {
        return qvdaVeic;
    }

    /**
     * Prop�sito:  Atribuir valor ao qvdaVeic
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQvdaVeic(int value) {
        this.qvdaVeic = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAVSResponseRegistroAreaSaida() {
        super();
    }
}
