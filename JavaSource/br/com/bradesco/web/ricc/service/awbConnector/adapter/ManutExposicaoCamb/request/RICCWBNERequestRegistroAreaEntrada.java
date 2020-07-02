/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBNERequestRegistroAreaEntrada 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBNERequestRegistroAreaEntrada extends AnnotatedAdapter {

    /**
     * Atributo nmercdExter
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-NMERCD-EXTER"},
        maxLength = 2, usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int nmercdExter = 0;

    /**
     * Atributo dtInfo
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-DT-INFO"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 10, pic = "X(010)")
    protected String dtInfo = null;

    /**
     * Atributo vtotImporS
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-IMPORTACAO", "RICCWBNE-VTOT"
        + "-IMPOR-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String vtotImporS = null;

    /**
     * Atributo vtotImpor
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-IMPORTACAO", "RICCWBNE-VTOT"
        + "-IMPOR"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotImpor = null;

    /**
     * Atributo vtotImporNull
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-IMPORTACAO", "RICCWBNE-VTOT"
        + "-IMPOR-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String vtotImporNull = null;

    /**
     * Atributo vtotExporS
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-EXPORTACAO", "RICCWBNE-VTOT"
        + "-EXPOR-S"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String vtotExporS = null;

    /**
     * Atributo vtotExpor
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-EXPORTACAO", "RICCWBNE-VTOT"
        + "-EXPOR"}, maxLength = 17, usage = "DISPLAY", fieldNumber = 6, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotExpor = null;

    /**
     * Atributo vtotExporNull
     */
    @CommareaField(name = {"RICCWBNE-REGISTRO", "RICCWBNE-AREA-ENTRADA", "RICCWBNE-EXPORTACAO", "RICCWBNE-VTOT"
        + "-EXPOR-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String vtotExporNull = null;

    /**
     * Prop�sito:  Retornar o valor de nmercdExter
     *
     * @return nmercdExter
     */
    public int getNmercdExter() {
        return nmercdExter;
    }

    /**
     * Prop�sito:  Atribuir valor ao nmercdExter
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNmercdExter(int value) {
        this.nmercdExter = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dtInfo
     *
     * @return dtInfo
     */
    public String getDtInfo() {
        return dtInfo;
    }

    /**
     * Prop�sito:  Atribuir valor ao dtInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtInfo(String value) {
        this.dtInfo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotImporS
     *
     * @return vtotImporS
     */
    public String getVtotImporS() {
        return vtotImporS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotImporS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotImporS(String value) {
        this.vtotImporS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotImpor
     *
     * @return vtotImpor
     */
    public BigDecimal getVtotImpor() {
        return vtotImpor;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotImpor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotImpor(BigDecimal value) {
        this.vtotImpor = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotImporNull
     *
     * @return vtotImporNull
     */
    public String getVtotImporNull() {
        return vtotImporNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotImporNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotImporNull(String value) {
        this.vtotImporNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotExporS
     *
     * @return vtotExporS
     */
    public String getVtotExporS() {
        return vtotExporS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotExporS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotExporS(String value) {
        this.vtotExporS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotExpor
     *
     * @return vtotExpor
     */
    public BigDecimal getVtotExpor() {
        return vtotExpor;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotExpor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotExpor(BigDecimal value) {
        this.vtotExpor = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotExporNull
     *
     * @return vtotExporNull
     */
    public String getVtotExporNull() {
        return vtotExporNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotExporNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotExporNull(String value) {
        this.vtotExporNull = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBNERequestRegistroAreaEntrada() {
        super();
    }
}
