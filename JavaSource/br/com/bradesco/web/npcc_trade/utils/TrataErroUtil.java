package br.com.bradesco.web.npcc_trade.utils;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;

/**
 * 
 * Nome: TrataErroUtil.java
 * 
 * Prop�sito:
 * <p>
 * Tratar os erros provenientes da chamada mainframe
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class TrataErroUtil {

    /**
     * Logger para as mensagens
     */
    private static ILogManager logger = BradescoCommonServiceFactory.getLogManager();

    /**
     * 
     * Nome: getInstance
     * 
     * Prop�sito: Obter uma instancia do TrataErroUtil (nao eh um sigleton)
     *
     * @return : TrataErroUtil
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public static TrataErroUtil getInstance() {
        return new TrataErroUtil();
    }

    /**
     * 
     * Nome: tratarRetornoPesquisaVaziaMainframe
     * 
     * Prop�sito: Tratar o retorno do mainframe quando ele executa uma busca e nao retorna nada
     *
     * @param : npccWebException
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public boolean tratarRetornoPesquisaVaziaMainframe(NpccTradeWebException npccWebException) {

        boolean isTratado = Boolean.FALSE;

        if (npccWebException.getMessage() != null) {

            if (!npccWebException.getMessage().equals("N�O H� REGISTROS PARA O FILTRO INFORMADO")
                            && !npccWebException.getMessage().equals("N�O EXISTEM DADOS PARA ESSA PESQUISA")) {
                throw new NpccTradeWebException(npccWebException.getMessage(), npccWebException, SiteUtil.STRING_EMPTY);
            } else {
                logger.info(getClass(), npccWebException.getMessage());
                isTratado = Boolean.TRUE;
            }
        }
        return isTratado;
    }
}
