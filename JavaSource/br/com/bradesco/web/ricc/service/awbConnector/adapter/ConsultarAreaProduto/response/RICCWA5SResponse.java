/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWA5SResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA5SResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA5S-HEADER", "RICCWA5S-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA5S";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA5S-HEADER", "RICCWA5S-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 9800;

    /**
     * Atributo iprotrAgri
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-IPROTR-AGRI"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 70, pic = "X(070)")
    protected String iprotrAgri = null;

    /**
     * Atributo qtotOcor
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-QTOT-OCOR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int qtotOcor = 0;

    /**
     * Atributo qtotAreaTot
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-QTOT-AREA-TOT"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 11, pic = "9(011)")
    protected long qtotAreaTot = 0L;

    /**
     * Atributo qtotAreaProd
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-QTOT-AREA-PROD"}, maxLength = 11, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 11, pic = "9(011)")
    protected long qtotAreaProd = 0L;

    /**
     * Atributo vtotMercd
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-VTOT-MERCD"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotMercd = null;

    /**
     * Atributo vtotMerHctar
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-VTOT-MER-HCTAR"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotMerHctar = null;

    /**
     * Atributo vtotCustArre
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-VTOT-CUST-ARRE"}, maxLength = 19, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 19, pic = "9(017)V99")
    protected BigDecimal vtotCustArre = null;

    /**
     * Atributo areaSaida
     */
    @CommareaContainer(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA"}, minOccurs = 0, maxOccurs = 50,
        dependsOn = "RICCWA5S-QTOT-OCOR", fieldNumber = 9, type = RICCWA5SResponseRegistroAreaSaida.class)
    protected List<RICCWA5SResponseRegistroAreaSaida> areaSaida = new ArrayList<RICCWA5SResponseRegistroAreaSaida>();

    /**
     * Atributo filler5
     */
    protected String filler5 = null;

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
     * Propósito:  Retornar o valor de iprotrAgri
     *
     * @return iprotrAgri
     */
    public String getIprotrAgri() {
        return iprotrAgri;
    }

    /**
     * Propósito:  Atribuir valor ao iprotrAgri
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIprotrAgri(String value) {
        this.iprotrAgri = value;
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
     * Propósito:  Retornar o valor de qtotAreaTot
     *
     * @return qtotAreaTot
     */
    public long getQtotAreaTot() {
        return qtotAreaTot;
    }

    /**
     * Propósito:  Atribuir valor ao qtotAreaTot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotAreaTot(long value) {
        this.qtotAreaTot = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotAreaProd
     *
     * @return qtotAreaProd
     */
    public long getQtotAreaProd() {
        return qtotAreaProd;
    }

    /**
     * Propósito:  Atribuir valor ao qtotAreaProd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotAreaProd(long value) {
        this.qtotAreaProd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotMercd
     *
     * @return vtotMercd
     */
    public BigDecimal getVtotMercd() {
        return vtotMercd;
    }

    /**
     * Propósito:  Atribuir valor ao vtotMercd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotMercd(BigDecimal value) {
        this.vtotMercd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotMerHctar
     *
     * @return vtotMerHctar
     */
    public BigDecimal getVtotMerHctar() {
        return vtotMerHctar;
    }

    /**
     * Propósito:  Atribuir valor ao vtotMerHctar
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotMerHctar(BigDecimal value) {
        this.vtotMerHctar = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotCustArre
     *
     * @return vtotCustArre
     */
    public BigDecimal getVtotCustArre() {
        return vtotCustArre;
    }

    /**
     * Propósito:  Atribuir valor ao vtotCustArre
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCustArre(BigDecimal value) {
        this.vtotCustArre = value;
    }

    /**
     * Propósito:  Retornar o valor de areaSaida
     *
     * @return areaSaida
     */
    public List<RICCWA5SResponseRegistroAreaSaida> getAreaSaida() {
        if (areaSaida == null) {
            areaSaida = new  ArrayList<RICCWA5SResponseRegistroAreaSaida>();
        }
        return this.areaSaida;
    }

    /**
     * Propósito:  Retornar o valor de fILLER5
     *
     * @return fILLER5
     */
    public String getFILLER5() {
        return filler5;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER5
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER5(String value) {
        this.filler5 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA5SResponse() {
        super();
    }

    public void setAreaSaida(List<RICCWA5SResponseRegistroAreaSaida> value) {
        this.areaSaida = value;
    }
}
