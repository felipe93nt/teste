/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA4SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA4SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nareaAtuac
     */
    @CommareaField(name = {"RICCWA4S-REGISTRO", "RICCWA4S-AREA-SAIDA", "RICCWA4S-NAREA-ATUAC"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nareaAtuac = 0;

    /**
     * Atributo restAtuac
     */
    @CommareaField(name = {"RICCWA4S-REGISTRO", "RICCWA4S-AREA-SAIDA", "RICCWA4S-REST-ATUAC"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 40, pic = "X(040)")
    protected String restAtuac = null;

    /**
     * Atributo rrgiaoAtua
     */
    @CommareaField(name = {"RICCWA4S-REGISTRO", "RICCWA4S-AREA-SAIDA", "RICCWA4S-RRGIAO-ATUA"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 40, pic = "X(040)")
    protected String rrgiaoAtua = null;

    /**
     * Propósito:  Retornar o valor de nareaAtuac
     *
     * @return nareaAtuac
     */
    public int getNareaAtuac() {
        return nareaAtuac;
    }

    /**
     * Propósito:  Atribuir valor ao nareaAtuac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNareaAtuac(int value) {
        this.nareaAtuac = value;
    }

    /**
     * Propósito:  Retornar o valor de restAtuac
     *
     * @return restAtuac
     */
    public String getRestAtuac() {
        return restAtuac;
    }

    /**
     * Propósito:  Atribuir valor ao restAtuac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRestAtuac(String value) {
        this.restAtuac = value;
    }

    /**
     * Propósito:  Retornar o valor de rrgiaoAtua
     *
     * @return rrgiaoAtua
     */
    public String getRrgiaoAtua() {
        return rrgiaoAtua;
    }

    /**
     * Propósito:  Atribuir valor ao rrgiaoAtua
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRrgiaoAtua(String value) {
        this.rrgiaoAtua = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA4SResponseRegistroAreaSaida() {
        super();
    }
}
