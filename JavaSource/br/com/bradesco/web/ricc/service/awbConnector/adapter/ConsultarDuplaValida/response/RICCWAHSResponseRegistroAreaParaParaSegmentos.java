/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAHSResponseRegistroAreaParaParaSegmentos 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAHSResponseRegistroAreaParaParaSegmentos extends AnnotatedAdapter {

    /**
     * Atributo paraCindcdSgmto
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-SEGMENTOS", "RICCWAHS-PAR"
        + "A-CINDCD-SGMTO"}, maxLength = 5, usage = "DISPLAY", fieldNumber = 0, maxBytes = 5, pic = "9(005)")
    protected int paraCindcdSgmto = 0;

    /**
     * Atributo paraCindcdObrigt
     */
    @CommareaField(name = {"RICCWAHS-REGISTRO", "RICCWAHS-AREA-PARA", "RICCWAHS-PARA-SEGMENTOS", "RICCWAHS-PAR"
        + "A-CINDCD-OBRIGT"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "9(001)")
    protected int paraCindcdObrigt = 0;

    /**
     * Prop�sito:  Retornar o valor de paraCindcdSgmto
     *
     * @return paraCindcdSgmto
     */
    public int getParaCindcdSgmto() {
        return paraCindcdSgmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao paraCindcdSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaCindcdSgmto(int value) {
        this.paraCindcdSgmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de paraCindcdObrigt
     *
     * @return paraCindcdObrigt
     */
    public int getParaCindcdObrigt() {
        return paraCindcdObrigt;
    }

    /**
     * Prop�sito:  Atribuir valor ao paraCindcdObrigt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setParaCindcdObrigt(int value) {
        this.paraCindcdObrigt = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAHSResponseRegistroAreaParaParaSegmentos() {
        super();
    }
}
