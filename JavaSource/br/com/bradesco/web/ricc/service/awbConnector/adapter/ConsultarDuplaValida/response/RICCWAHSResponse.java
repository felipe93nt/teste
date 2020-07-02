/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;

/**
 * Nome: RICCWAHSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAHSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAHS-HEADER", "RICCWAHS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAHS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAHS-HEADER", "RICCWAHS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo deNparmz
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-NPARMZ"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 9, pic = "9(009)")
    protected int deNparmz = 0;

    /**
     * Atributo deTvladdRelat
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-TVLADD-RELAT"}, maxLength = 3,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 3, pic = "9(003)")
    protected int deTvladdRelat = 0;

    /**
     * Atributo deVrisco
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-VRISCO"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal deVrisco = null;

    /**
     * Atributo deCusuarAtulz
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-CUSUAR-ATULZ"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 9, pic = "X(009)")
    protected String deCusuarAtulz = null;

    /**
     * Atributo deHatulzRelat
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-HATULZ-RELAT"},
        maxLength = 26, usage = "DISPLAY", fieldNumber = 6, maxBytes = 26, pic = "X(026)")
    protected String deHatulzRelat = null;

    /**
     * Atributo deCusuarValdc
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-CUSUAR-VALDC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 9, pic = "X(009)")
    protected String deCusuarValdc = null;

    /**
     * Atributo deHvaldcReg
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-HVALDC-REG"}, maxLength = 26,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 26, pic = "X(026)")
    protected String deHvaldcReg = null;

    /**
     * Atributo deSegmentos
     */
    @CommareaContainer(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-SEGMENTOS"}, minOccurs = 10,
        maxOccurs = 10, fieldNumber = 9, type = RICCWAHSResponseRegistroAreaDeDeSegmentos.class)
    protected List<RICCWAHSResponseRegistroAreaDeDeSegmentos> deSegmentos = new ArrayList<RICCWAHSResponseRegistroAreaDeDeSegmentos>();

    /**
     * Atributo paraNparmz
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-NPARMZ"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 9, pic = "9(009)")
    protected int paraNparmz = 0;

    /**
     * Atributo paraTvladdRelat
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-TVLADD-RELAT"},
        maxLength = 3, usage = "DISPLAY", fieldNumber = 11, maxBytes = 3, pic = "9(003)")
    protected int paraTvladdRelat = 0;

    /**
     * Atributo paraVrisco
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-VRISCO"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal paraVrisco = null;

    /**
     * Atributo paraCusuarAtulz
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-CUSUAR-ATULZ"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 13, maxBytes = 9, pic = "X(009)")
    protected String paraCusuarAtulz = null;

    /**
     * Atributo paraHatulzRelat
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-HATULZ-RELAT"},
        maxLength = 26, usage = "DISPLAY", fieldNumber = 14, maxBytes = 26, pic = "X(026)")
    protected String paraHatulzRelat = null;

    /**
     * Atributo paraSegmentos
     */
    @CommareaContainer(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-SEGMENTOS"},
        minOccurs = 10, maxOccurs = 10, fieldNumber = 15,
        type = RICCWAHSResponseRegistroAreaParaParaSegmentos.class)
    protected List<RICCWAHSResponseRegistroAreaParaParaSegmentos> paraSegmentos = new ArrayList<RICCWAHSResponseRegistroAreaParaParaSegmentos>();

    /**
     * Atributo filler4
     */
    protected String filler4 = null;

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
     * Propósito:  Retornar o valor de deNparmz
     *
     * @return deNparmz
     */
    public int getDeNparmz() {
        return deNparmz;
    }

    /**
     * Propósito:  Atribuir valor ao deNparmz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeNparmz(int value) {
        this.deNparmz = value;
    }

    /**
     * Propósito:  Retornar o valor de deTvladdRelat
     *
     * @return deTvladdRelat
     */
    public int getDeTvladdRelat() {
        return deTvladdRelat;
    }

    /**
     * Propósito:  Atribuir valor ao deTvladdRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeTvladdRelat(int value) {
        this.deTvladdRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de deVrisco
     *
     * @return deVrisco
     */
    public BigDecimal getDeVrisco() {
        return deVrisco;
    }

    /**
     * Propósito:  Atribuir valor ao deVrisco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeVrisco(BigDecimal value) {
        this.deVrisco = value;
    }

    /**
     * Propósito:  Retornar o valor de deCusuarAtulz
     *
     * @return deCusuarAtulz
     */
    public String getDeCusuarAtulz() {
        return deCusuarAtulz;
    }

    /**
     * Propósito:  Atribuir valor ao deCusuarAtulz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeCusuarAtulz(String value) {
        this.deCusuarAtulz = value;
    }

    /**
     * Propósito:  Retornar o valor de deHatulzRelat
     *
     * @return deHatulzRelat
     */
    public String getDeHatulzRelat() {
        return deHatulzRelat;
    }

    /**
     * Propósito:  Atribuir valor ao deHatulzRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeHatulzRelat(String value) {
        this.deHatulzRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de deCusuarValdc
     *
     * @return deCusuarValdc
     */
    public String getDeCusuarValdc() {
        return deCusuarValdc;
    }

    /**
     * Propósito:  Atribuir valor ao deCusuarValdc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeCusuarValdc(String value) {
        this.deCusuarValdc = value;
    }

    /**
     * Propósito:  Retornar o valor de deHvaldcReg
     *
     * @return deHvaldcReg
     */
    public String getDeHvaldcReg() {
        return deHvaldcReg;
    }

    /**
     * Propósito:  Atribuir valor ao deHvaldcReg
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeHvaldcReg(String value) {
        this.deHvaldcReg = value;
    }

    /**
     * Propósito:  Retornar o valor de deSegmentos
     *
     * @return deSegmentos
     */
    public List<RICCWAHSResponseRegistroAreaDeDeSegmentos> getDeSegmentos() {
        if (deSegmentos == null) {
            deSegmentos = new  ArrayList<RICCWAHSResponseRegistroAreaDeDeSegmentos>();
        }
        return this.deSegmentos;
    }

    /**
     * Propósito:  Retornar o valor de paraNparmz
     *
     * @return paraNparmz
     */
    public int getParaNparmz() {
        return paraNparmz;
    }

    /**
     * Propósito:  Atribuir valor ao paraNparmz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaNparmz(int value) {
        this.paraNparmz = value;
    }

    /**
     * Propósito:  Retornar o valor de paraTvladdRelat
     *
     * @return paraTvladdRelat
     */
    public int getParaTvladdRelat() {
        return paraTvladdRelat;
    }

    /**
     * Propósito:  Atribuir valor ao paraTvladdRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaTvladdRelat(int value) {
        this.paraTvladdRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de paraVrisco
     *
     * @return paraVrisco
     */
    public BigDecimal getParaVrisco() {
        return paraVrisco;
    }

    /**
     * Propósito:  Atribuir valor ao paraVrisco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaVrisco(BigDecimal value) {
        this.paraVrisco = value;
    }

    /**
     * Propósito:  Retornar o valor de paraCusuarAtulz
     *
     * @return paraCusuarAtulz
     */
    public String getParaCusuarAtulz() {
        return paraCusuarAtulz;
    }

    /**
     * Propósito:  Atribuir valor ao paraCusuarAtulz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaCusuarAtulz(String value) {
        this.paraCusuarAtulz = value;
    }

    /**
     * Propósito:  Retornar o valor de paraHatulzRelat
     *
     * @return paraHatulzRelat
     */
    public String getParaHatulzRelat() {
        return paraHatulzRelat;
    }

    /**
     * Propósito:  Atribuir valor ao paraHatulzRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaHatulzRelat(String value) {
        this.paraHatulzRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de paraSegmentos
     *
     * @return paraSegmentos
     */
    public List<RICCWAHSResponseRegistroAreaParaParaSegmentos> getParaSegmentos() {
        if (paraSegmentos == null) {
            paraSegmentos = new  ArrayList<RICCWAHSResponseRegistroAreaParaParaSegmentos>();
        }
        return this.paraSegmentos;
    }

    /**
     * Propósito:  Retornar o valor de fILLER4
     *
     * @return fILLER4
     */
    public String getFILLER4() {
        return filler4;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER4
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER4(String value) {
        this.filler4 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAHSResponse() {
        super();
    }

    public void setDeSegmentos(List<RICCWAHSResponseRegistroAreaDeDeSegmentos> value) {
        this.deSegmentos = value;
    }

    public void setParaSegmentos(List<RICCWAHSResponseRegistroAreaParaParaSegmentos> value) {
        this.paraSegmentos = value;
    }
}
