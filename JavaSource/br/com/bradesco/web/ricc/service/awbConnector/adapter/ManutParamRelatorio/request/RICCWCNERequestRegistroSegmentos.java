/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCNERequestRegistroSegmentos 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCNERequestRegistroSegmentos extends AnnotatedAdapter {

    /**
     * Atributo cindcdSgmto
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-SEGMENTOS", "RICCWCNE-CINDCD-SGMTO"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 5, pic = "9(005)")
    protected int cindcdSgmto = 0;

    /**
     * Atributo cindcdObrigt
     */
    @CommareaField(name = {"RICCWCNE-REGISTRO", "RICCWCNE-SEGMENTOS", "RICCWCNE-CINDCD-OBRIGT"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "9(001)")
    protected int cindcdObrigt = 0;

    /**
     * Propósito:  Retornar o valor de cindcdSgmto
     *
     * @return cindcdSgmto
     */
    public int getCindcdSgmto() {
        return cindcdSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao cindcdSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCindcdSgmto(int value) {
        this.cindcdSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de cindcdObrigt
     *
     * @return cindcdObrigt
     */
    public int getCindcdObrigt() {
        return cindcdObrigt;
    }

    /**
     * Propósito:  Atribuir valor ao cindcdObrigt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCindcdObrigt(int value) {
        this.cindcdObrigt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCNERequestRegistroSegmentos() {
        super();
    }
}
