package br.com.bradesco.web.npcc_trade.utils;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;

/**
 * 
 * Nome: TrataErroUtil.java
 * 
 * Propósito:
 * <p>
 * Tratar os erros provenientes da chamada mainframe
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
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
     * Propósito: Obter uma instancia do TrataErroUtil (nao eh um sigleton)
     *
     * @return : TrataErroUtil
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static TrataErroUtil getInstance() {
        return new TrataErroUtil();
    }

    /**
     * 
     * Nome: tratarRetornoPesquisaVaziaMainframe
     * 
     * Propósito: Tratar o retorno do mainframe quando ele executa uma busca e nao retorna nada
     *
     * @param : npccWebException
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public boolean tratarRetornoPesquisaVaziaMainframe(NpccTradeWebException npccWebException) {

        boolean isTratado = Boolean.FALSE;

        if (npccWebException.getMessage() != null) {

            if (!npccWebException.getMessage().equals("NÃO HÁ REGISTROS PARA O FILTRO INFORMADO")
                            && !npccWebException.getMessage().equals("NÃO EXISTEM DADOS PARA ESSA PESQUISA")) {
                throw new NpccTradeWebException(npccWebException.getMessage(), npccWebException, SiteUtil.STRING_EMPTY);
            } else {
                logger.info(getClass(), npccWebException.getMessage());
                isTratado = Boolean.TRUE;
            }
        }
        return isTratado;
    }
}
