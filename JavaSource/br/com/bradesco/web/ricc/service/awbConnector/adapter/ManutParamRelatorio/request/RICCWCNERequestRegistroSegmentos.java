/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCNERequestRegistroSegmentos 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de cindcdSgmto
     *
     * @return cindcdSgmto
     */
    public int getCindcdSgmto() {
        return cindcdSgmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao cindcdSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCindcdSgmto(int value) {
        this.cindcdSgmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cindcdObrigt
     *
     * @return cindcdObrigt
     */
    public int getCindcdObrigt() {
        return cindcdObrigt;
    }

    /**
     * Prop�sito:  Atribuir valor ao cindcdObrigt
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
