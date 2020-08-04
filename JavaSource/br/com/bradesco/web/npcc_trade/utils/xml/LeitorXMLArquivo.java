package br.com.bradesco.web.npcc_trade.utils.xml;

/**
 *
 * Nome: LeitorXMLArquivo.java
 * 
 * Prop�sito: LeitorXMLArquivo.java Carrega um XML e fornece os m�todos necess�rios para percorre-lo como uma lista.
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 23/07/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class LeitorXMLArquivo extends LeitorXML {

        /**
         * Construtor
         * 
         * @param nomeArquivo
         * @param nomeNodo
         */
    public LeitorXMLArquivo(String nomeArquivo, String nomeNodo) {
        super();
        try {
            lerXml(getClass().getResourceAsStream(nomeArquivo), nomeNodo);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao ler o XML \"" + nomeArquivo
                            + "\". Possivelmente o caminho est� incorreto (deve iniciar com \"/\")", e);
        }
    }
}
