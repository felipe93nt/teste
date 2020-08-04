/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametros.formaLiquidacao
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;

/**
 *
 * Nome: IFormaLiquidacaoService
 * 
 * Prop�sito: Interface para o servi�o <br/>
 *
 * Data: 13/07/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
public interface IModeloBoletoService extends Serializable {

    /**
     * 
     * Nome: getMsgRetorno
     * 
     * Prop�sito: Fornece mensagem de retorno enviado pelo mainframe na execu��o
     * dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String getMsgRetorno();

    /**
     * 
     * Nome: listar 
     * 
     * Prop�sito: Listar modelos de boleto
     *
     * @param : filtroProduto
     * @return : List<ModeloBoletoVO>
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     */
    public List<ModeloBoletoVO> listar(Integer filtroProduto);

    /**
     * 
     * Nome: detalhar 
     * 
     * Prop�sito: Detalhar modelos de boleto
     *
     * @param : filtroProduto
     * @return : ModeloBoletoVO
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public ModeloBoletoVO detalhar(Integer codModeloBoleto);

    /**
     * 
     * Nome: incluir
     * 
     * Prop�sito: Incluir FormaLiquidacaoVO
     *
     * @param : FormaLiquidacaoVO
     * @return : Boolean
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String incluir(ModeloBoletoVO obj);

    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito: alterar Modelo de Boleto
     *
     * @param : ModeloBoletoVO
     * @return : String
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String alterar(ModeloBoletoVO obj);

    /**
     * 
     * Nome: excluir Prop�sito: Excluir ModeloBoletoVO
     *
     * @param : ModeloBoletoVO
     * @return : Boolean
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String excluir(ModeloBoletoVO obj);

}
