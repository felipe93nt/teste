package br.com.bradesco.web.npcc_trade.utils.components;

/**
  * <b>Nome:</b> <p> LineBreaks.java </p>
  * 
  * <b>Propósito:</b> <p> Tratar quebra de linha para envio ao mainframe. </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR/>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  *
  * Registro  de Manutenção: 06/01/2017
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class LineBreaks {
    
    public static String NEW_LINE_REGEX = "\\r\\n|\\r|\\n";
    
    public static String NEW_LINE = "\r\n";
    
    public static String NEW_LINE_NPC = "¬";
    
    public static String NEW_LINE_BR = "<br />";
    
    
    /**
     * Nome: formatToMainframe
     * 
     * Propósito: Substituir o caracter de quebra "\r\n" de linha por "¬"
     *
     * @param : Texto com formatação original.
     * @return : Texto com quebra de linha "¬".
     * @throws :
     * @exception : 
     *
     */
    public static String formatToMainframe(String value) {
        
        return value.replaceAll(NEW_LINE_REGEX, NEW_LINE_NPC);
    }
    
    /**
     * Nome: addCaracterToMainframe
     * 
     * Propósito: Adicionar o caracter de quebra "\r\n" de linha por "¬"
     *
     * @param : Texto com formatação original.
     * @return : Texto com quebra de linha "¬".
     * @throws :
     * @exception : 
     *
     */
    public static String addCaracterToMainframe(String value) {
        
        return value + NEW_LINE_NPC;
    }

    /**
     * Nome: formatToWeb
     * 
     * Propósito: Substituir o caracter "¬" pela quebra de linha "\r\n"
     *
     * @param : Texto com quebra de linha "¬".
     * @return : Texto com formatação original.
     * @throws :
     * @exception : 
     *
     */
    public static String formatToWeb(String value) {
        
        return value.replaceAll(NEW_LINE_NPC, NEW_LINE);
    }
    
    
    /**
     * Nome: formatMainFrameToWeb
     * 
     * Propósito: Substituir o caracter "¬" pela quebra de linha <br />
     *
     * @param : Texto com quebra de linha "¬".
     * @return : Texto com formatação original.
     * @throws :
     * @exception : 
     *
     */
    public static String formatMainFrameToWeb(String value) {
        
        return value.replaceAll(NEW_LINE_NPC, NEW_LINE_BR);
    }
    
    
}
