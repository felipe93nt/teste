package br.com.bradesco.web.npcc_trade.utils.xml;

/**
 *
 * Nome: LeitorXMLArquivo.java
 * 
 * Propósito: LeitorXMLArquivo.java Carrega um XML e fornece os métodos necessários para percorre-lo como uma lista.
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 23/07/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
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
                            + "\". Possivelmente o caminho está incorreto (deve iniciar com \"/\")", e);
        }
    }
}
