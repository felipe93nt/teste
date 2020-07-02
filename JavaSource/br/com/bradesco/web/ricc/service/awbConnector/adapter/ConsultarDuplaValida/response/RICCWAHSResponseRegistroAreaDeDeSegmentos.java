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
 * Nome: RICCWAHSResponseRegistroAreaDeDeSegmentos 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de deCindcdSgmto
     *
     * @return deCindcdSgmto
     */
    public int getDeCindcdSgmto() {
        return deCindcdSgmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao deCindcdSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDeCindcdSgmto(int value) {
        this.deCindcdSgmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de deCindcdObrigt
     *
     * @return deCindcdObrigt
     */
    public int getDeCindcdObrigt() {
        return deCindcdObrigt;
    }

    /**
     * Prop�sito:  Atribuir valor ao deCindcdObrigt
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
