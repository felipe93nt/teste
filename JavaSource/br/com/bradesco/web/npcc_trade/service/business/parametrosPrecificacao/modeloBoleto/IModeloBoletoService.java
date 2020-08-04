/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametros.formaLiquidacao
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;

/**
 *
 * Nome: IFormaLiquidacaoService
 * 
 * Propósito: Interface para o serviço <br/>
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
     * Propósito: Fornece mensagem de retorno enviado pelo mainframe na execução
     * dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    String getMsgRetorno();

    /**
     * 
     * Nome: listar 
     * 
     * Propósito: Listar modelos de boleto
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
     * Propósito: Detalhar modelos de boleto
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
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public ModeloBoletoVO detalhar(Integer codModeloBoleto);

    /**
     * 
     * Nome: incluir
     * 
     * Propósito: Incluir FormaLiquidacaoVO
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
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    String incluir(ModeloBoletoVO obj);

    /**
     * 
     * Nome: alterar
     * 
     * Propósito: alterar Modelo de Boleto
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
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String alterar(ModeloBoletoVO obj);

    /**
     * 
     * Nome: excluir Propósito: Excluir ModeloBoletoVO
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
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String excluir(ModeloBoletoVO obj);

}
