/**
 * Nome: br.com.bradesco.web.piloto.service.business
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.ricc.service.business;

import br.com.bradesco.web.ricc.exception.RiccException;

/**
 * Nome: PilotoServiceBusinessException
 * Propósito: Classe que define o PilotoServiceBusinessException <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
public class RiccServiceBusinessException extends RiccException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4051441792735816129L;

	/**
     * Nome: Construtor <br/>
     * Propósito: Cria uma instancia do tipo PilotoServiceBusinessException <br/>
     * Data: <21/07/2015><br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     */
    public RiccServiceBusinessException() {
        super();
    }

    /**
     * Nome: Construtor <br/>
     * Propósito: Cria uma instancia do tipo PilotoServiceBusinessException <br/>
     * Data: <21/07/2015><br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param arg0
     */
    public RiccServiceBusinessException(String arg0) {
        super(arg0);
    }

    /**
     * Nome: Construtor <br/>
     * Propósito: Cria uma instancia do tipo PilotoServiceBusinessException <br/>
     * Data: <21/07/2015><br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param arg0
     * @param arg1
     */
    public RiccServiceBusinessException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Nome: Construtor <br/>
     * Propósito: Cria uma instancia do tipo PilotoServiceBusinessException <br/>
     * Data: <21/07/2015><br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param arg0
     */
    public RiccServiceBusinessException(Throwable arg0) {
        super(arg0);
    }
}
