/**
 * Nome: br.com.bradesco.web.npcc_trade.exception
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 13/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.exception;

import br.com.bradesco.web.aq.application.error.BradescoViewException;

/**
 *
 * Nome: NpccTradeWebException 
 * Propósito: <br/>
 *
 * Data: 13/07/2015 <br/>
 * 
 * @author thiagoito / Brq <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
public class NpccTradeWebException extends BradescoViewException {

    private static final long serialVersionUID = 1L;
    
    private String message;

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException() {
        super();
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, String code, String pAction, BradescoViewExceptionActionType actionType) {
        super(message, code, pAction, actionType);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, String code, String pAction, String pActionListener, String pPath) {
        super(message, code, pAction, pActionListener, pPath);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, String code, String pAction, String pActionListener) {
        super(message, code, pAction, pActionListener);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, String code, String pAction) {
        super(message, code, pAction);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, String code) {
        super(message, code);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, Throwable cause, String code, String pAction,
            BradescoViewExceptionActionType actionType) {
        super(message, cause, code, pAction, actionType);
        this.setMessage(code);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, Throwable cause, String code, String pAction, String pActionListener,
            String pPath) {
        super(message, cause, code, pAction, pActionListener, pPath);
        this.setMessage(code);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, Throwable cause, String code, String pAction, String pActionListener) {
        super(message, cause, code, pAction, pActionListener);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, Throwable cause, String code, String pAction) {
        super(message, cause, code, pAction);
        this.setMessage(message);
    }

    /**
    * Construtor: NpccTradeWebException.java
    */
    public NpccTradeWebException(String message, Throwable cause, String code) {
        super(message, cause, code);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

 
}
