package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.bean.TipoClausulaVO;

/**
 * 
 * Nome: TipoClausulaService.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
public interface ITipoClausulaService extends Serializable {

    /**
     * 
     * Nome: getMsgRetorno
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */

    String getMsgRetorno();

    /**
     * 
     * Nome: getLista
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    List<TipoClausulaVO> listar();

    /**
     * Nome: incluir
     * 
     * Prop�sito: Incluir TipoClausulaVO
     *
     * @param : TipoClausulaVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String incluir(TipoClausulaVO obj);

    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String alterar(TipoClausulaVO obj);

    /**
     * 
     * Nome: excluir
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String excluir(TipoClausulaVO obj);

}
