/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response;

import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWADSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWADSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWADS-HEADER", "RICCWADS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWADS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWADS-HEADER", "RICCWADS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 3300;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWADS-REGISTRO", "RICCWADS-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWADS-QTOT-OCOR", fieldNumber = 3, type = RICCWADSResponseRegistroAreaSaida.class)
    protected List<RICCWADSResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWADSResponseRegistroAreaSaida>();

    /**
     * Atributo qtotCapac
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-QTOT-CAPAC"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 11, pic = "9(011)")
    protected long qtotCapac = 0L;

    /**
     * Atributo qtotProduc
     */
    @CommareaField(name = {"RICCWADS-REGISTRO", "RICCWADS-QTOT-PRODUC"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 11, pic = "9(011)")
    protected long qtotProduc = 0L;

    /**
     * Atributo filler9
     */
    protected String filler9 = null;

    /**
     * Propósito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Propósito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Propósito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotOcor
     *
     * @return qtotOcor
     */
    public int getQtotOcor() {
        return qtotOcor;
    }

    /**
     * Propósito:  Atribuir valor ao qtotOcor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotOcor(int value) {
        this.qtotOcor = value;
    }

    /**
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWADSResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWADSResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de qtotCapac
     *
     * @return qtotCapac
     */
    public long getQtotCapac() {
        return qtotCapac;
    }

    /**
     * Propósito:  Atribuir valor ao qtotCapac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotCapac(long value) {
        this.qtotCapac = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotProduc
     *
     * @return qtotProduc
     */
    public long getQtotProduc() {
        return qtotProduc;
    }

    /**
     * Propósito:  Atribuir valor ao qtotProduc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotProduc(long value) {
        this.qtotProduc = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER9
     *
     * @return fILLER9
     */
    public String getFILLER9() {
        return filler9;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER9
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER9(String value) {
        this.filler9 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWADSResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWADSResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
