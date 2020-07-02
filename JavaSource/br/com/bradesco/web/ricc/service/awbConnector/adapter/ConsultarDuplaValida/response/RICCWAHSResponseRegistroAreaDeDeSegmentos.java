/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAHSResponseRegistroAreaDeDeSegmentos 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAHSResponseRegistroAreaDeDeSegmentos extends AnnotatedAdapter {

    /**
     * Atributo deCindcdSgmto
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-SEGMENTOS", "RICCWAHS-DE-CIND"
        + "CD-SGMTO"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 0, maxBytes = 5, pic = "9(005)")
    protected int deCindcdSgmto = 0;

    /**
     * Atributo deCindcdObrigt
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-DE", "RICCWAHS-DE-SEGMENTOS", "RICCWAHS-DE-CIND"
        + "CD-OBRIGT"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "9(001)")
    protected int deCindcdObrigt = 0;

    /**
     * Propósito:  Retornar o valor de deCindcdSgmto
     *
     * @return deCindcdSgmto
     */
    public int getDeCindcdSgmto() {
        return deCindcdSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao deCindcdSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeCindcdSgmto(int value) {
        this.deCindcdSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de deCindcdObrigt
     *
     * @return deCindcdObrigt
     */
    public int getDeCindcdObrigt() {
        return deCindcdObrigt;
    }

    /**
     * Propósito:  Atribuir valor ao deCindcdObrigt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeCindcdObrigt(int value) {
        this.deCindcdObrigt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAHSResponseRegistroAreaDeDeSegmentos() {
        super();
    }
}
