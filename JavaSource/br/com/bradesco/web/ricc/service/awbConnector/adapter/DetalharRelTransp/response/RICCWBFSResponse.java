/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 17/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBFSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBFSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBFS-HEADER", "RICCWBFS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBFS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBFS-HEADER", "RICCWBFS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo qveicFrota
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-QVEIC-FROTA"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int qveicFrota = 0;

    /**
     * Atributo vveicFrota
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-VVEIC-FROTA"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vveicFrota = null;

    /**
     * Atributo vsdoDvdorFrt
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-VSDO-DVDOR-FRT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdorFrt = null;

    /**
     * Atributo pgrauAlieFrt
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-PGRAU-ALIE-FRT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pgrauAlieFrt = null;

    /**
     * Atributo nidadeMedFrt
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-NIDADE-MED-FRT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 3, pic = "9(003)")
    protected int nidadeMedFrt = 0;

    /**
     * Atributo vmesFinanFrt
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-VMES-FINAN-FRT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmesFinanFrt = null;

    /**
     * Atributo vmesCaptlGro
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-VMES-CAPTL-GRO"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmesCaptlGro = null;

    /**
     * Atributo vfatmtMedMes
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-VFATMT-MED-MES"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vfatmtMedMes = null;

    /**
     * Atributo pcompmRecta
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-PCOMPM-RECTA"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcompmRecta = null;

    /**
     * Atributo pcompmCaptl
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-PCOMPM-CAPTL"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcompmCaptl = null;

    /**
     * Atributo pfrotaPrpia
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-PFROTA-PRPIA"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pfrotaPrpia = null;

    /**
     * Atributo pultExerc
     */
    @CommareaField(name = {"RICCWBFS-REGISTRO", "RICCWBFS-PULT-EXERC"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pultExerc = null;

    /**
     * Atributo filler1
     */
    protected String filler1 = null;

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
     * Propósito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Propósito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
    }

    /**
     * Propósito:  Retornar o valor de qveicFrota
     *
     * @return qveicFrota
     */
    public int getQveicFrota() {
        return qveicFrota;
    }

    /**
     * Propósito:  Atribuir valor ao qveicFrota
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQveicFrota(int value) {
        this.qveicFrota = value;
    }

    /**
     * Propósito:  Retornar o valor de vveicFrota
     *
     * @return vveicFrota
     */
    public BigDecimal getVveicFrota() {
        return vveicFrota;
    }

    /**
     * Propósito:  Atribuir valor ao vveicFrota
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVveicFrota(BigDecimal value) {
        this.vveicFrota = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoDvdorFrt
     *
     * @return vsdoDvdorFrt
     */
    public BigDecimal getVsdoDvdorFrt() {
        return vsdoDvdorFrt;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoDvdorFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoDvdorFrt(BigDecimal value) {
        this.vsdoDvdorFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de pgrauAlieFrt
     *
     * @return pgrauAlieFrt
     */
    public BigDecimal getPgrauAlieFrt() {
        return pgrauAlieFrt;
    }

    /**
     * Propósito:  Atribuir valor ao pgrauAlieFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPgrauAlieFrt(BigDecimal value) {
        this.pgrauAlieFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de nidadeMedFrt
     *
     * @return nidadeMedFrt
     */
    public int getNidadeMedFrt() {
        return nidadeMedFrt;
    }

    /**
     * Propósito:  Atribuir valor ao nidadeMedFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNidadeMedFrt(int value) {
        this.nidadeMedFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de vmesFinanFrt
     *
     * @return vmesFinanFrt
     */
    public BigDecimal getVmesFinanFrt() {
        return vmesFinanFrt;
    }

    /**
     * Propósito:  Atribuir valor ao vmesFinanFrt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmesFinanFrt(BigDecimal value) {
        this.vmesFinanFrt = value;
    }

    /**
     * Propósito:  Retornar o valor de vmesCaptlGro
     *
     * @return vmesCaptlGro
     */
    public BigDecimal getVmesCaptlGro() {
        return vmesCaptlGro;
    }

    /**
     * Propósito:  Atribuir valor ao vmesCaptlGro
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmesCaptlGro(BigDecimal value) {
        this.vmesCaptlGro = value;
    }

    /**
     * Propósito:  Retornar o valor de vfatmtMedMes
     *
     * @return vfatmtMedMes
     */
    public BigDecimal getVfatmtMedMes() {
        return vfatmtMedMes;
    }

    /**
     * Propósito:  Atribuir valor ao vfatmtMedMes
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVfatmtMedMes(BigDecimal value) {
        this.vfatmtMedMes = value;
    }

    /**
     * Propósito:  Retornar o valor de pcompmRecta
     *
     * @return pcompmRecta
     */
    public BigDecimal getPcompmRecta() {
        return pcompmRecta;
    }

    /**
     * Propósito:  Atribuir valor ao pcompmRecta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcompmRecta(BigDecimal value) {
        this.pcompmRecta = value;
    }

    /**
     * Propósito:  Retornar o valor de pcompmCaptl
     *
     * @return pcompmCaptl
     */
    public BigDecimal getPcompmCaptl() {
        return pcompmCaptl;
    }

    /**
     * Propósito:  Atribuir valor ao pcompmCaptl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcompmCaptl(BigDecimal value) {
        this.pcompmCaptl = value;
    }

    /**
     * Propósito:  Retornar o valor de pfrotaPrpia
     *
     * @return pfrotaPrpia
     */
    public BigDecimal getPfrotaPrpia() {
        return pfrotaPrpia;
    }

    /**
     * Propósito:  Atribuir valor ao pfrotaPrpia
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPfrotaPrpia(BigDecimal value) {
        this.pfrotaPrpia = value;
    }

    /**
     * Propósito:  Retornar o valor de pultExerc
     *
     * @return pultExerc
     */
    public BigDecimal getPultExerc() {
        return pultExerc;
    }

    /**
     * Propósito:  Atribuir valor ao pultExerc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPultExerc(BigDecimal value) {
        this.pultExerc = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER1
     *
     * @return fILLER1
     */
    public String getFILLER1() {
        return filler1;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER1(String value) {
        this.filler1 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBFSResponse() {
        super();
    }
}
