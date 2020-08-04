/**
 * Nome: br.com.bradesco.web.npcc_trade.exception
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 13/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */

package br.com.bradesco.web.npcc_trade.exception;

import br.com.bradesco.web.aq.application.error.BradescoApplicationException;

/**
 *
 * Nome: NpccTradeException 
 * Prop�sito: <br/>
 *
 * Data: 13/07/2015 <br/>
 * 
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
public class NpccTradeException extends BradescoApplicationException {

    private static final long serialVersionUID = 1L;

    /** Variavel do tipo long. */
    protected int cdErro = 0;
    protected int level = 0;
    protected String dsErro = "";

    /**
     * Informa��o
     */
    public final static int LEVEL_INFO = 1;
    /**
     * Erro grave
     */
    public final static int LEVEL_SEVERE = 2;

    /**
     * Informa o valor do C�digo
     * 
     * @return
     */
    public int getCodErro() {
        return cdErro;
    }

    /**
     * informa o conte�do da Descri��o
     * 
     * @return
     */
    public String getDscErro() {
        return dsErro;
    }

    /**
     * Informa o tipo de Exce��o
     * 
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Comentarios para el Constructor.
     *
     */
    public NpccTradeException() {
        super();
        // @TODO Auto-generated constructor stub
    }

    /**
     * Comentarios para el Constructor.
     *
     * @param arg0
     */
    public NpccTradeException(String arg0) {
        super(arg0);
        // @TODO Auto-generated constructor stub
    }

    /**
     * Comentarios para el Constructor.
     *
     * @param arg0
     * @param arg1
     */
    public NpccTradeException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        // @TODO Auto-generated constructor stub
    }

    /**
     * Comentarios para el Constructor.
     *
     * @param arg0
     */
    public NpccTradeException(Throwable arg0) {
        super(arg0);
        // @TODO Auto-generated constructor stub
    }
    
    /**
     * Construtor
     * 
     * @param message
     * @param cause
     * @param code
     */
    public NpccTradeException(final String message, final Throwable cause, final String code) {
        super(message, cause, code);
    }

}
