/**
 * Nome:  br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.impl
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 27/11/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt.Clausulaaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt.Clausulaaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt.Npccwvjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt.Npccwvjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet.Clausuladetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet.Clausuladetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet.Npccwvierequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet.Npccwvisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl.Clausulaexclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl.Clausulaexclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl.Npccwvkerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl.Npccwvksresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl.Clausulainclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl.Clausulainclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl.Npccwvherequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl.Npccwvhsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Clausulalistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Clausulalistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Npccwvgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Npccwvgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList.Npccwvgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.IClausulaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.bean.ClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.LineBreaks;

/**
*
* Nome: ClausulaServiceImpl Propósito: Serviços para a funcionalidade <br/>
*
* Data: 27/11/2015 <br/>
* 
* @author BRQ <br/>
*         copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/

@Named("clausulaService")
@SessionScoped
public class ClausulaServiceImpl extends BaseService implements IClausulaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 */
	
	public ClausulaServiceImpl() {
		super();
	}

	/**
     * 
     * Nome: getLista 
     * Propósito: Carrega a lista de Cláusulas
     *
     * @param : tipoClausula
     * @return : List<ClausulaVO>
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	
	@Override
	public List<ClausulaVO> listar(Integer tipoClausula) {
		List<ClausulaVO> listaVO = new ArrayList<ClausulaVO>();
		
		Clausulalistrequest request = new Clausulalistrequest();
        Clausulalistresponse response = new Clausulalistresponse();
        Npccwvgerequest bookEntrada = new Npccwvgerequest();
        Npccwvgsresponse bookSaida = new Npccwvgsresponse();

        request.setNpccwvgerequest(bookEntrada);
        response.setNpccwvgsresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setCtpoclauscmbio(tipoClausula);

        // executa chamada CWS
        listaComPaginacao(request, response, "CLAUSULALIST", "NPCCIAOI");
        

        // trata retorno
        this.setMsgRetorno(response.getTexmens());

        // carrega lista de retorno
        for (int i = Numeros.ZERO; i < response.getNpccwvgsresponse().getQtdeocorr(); i++) {

        	Npccwvgsresponse_lista objFrom = response.getNpccwvgsresponse().getLista().get(i);
        	ClausulaVO objTo = new ClausulaVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
            
            objTo.setRclauscontrcmbio(LineBreaks.formatToWeb(objFrom.getLista_rclauscontrcmbio()));

            listaVO.add(objTo);
        }
        

        return listaVO;
	}
	
	/**
     * 
     * Nome: incluir
     * 
     * Propósito: Inclui a lista de Cláusulas
     *
     * @param : ClausulaVO
     * @return : String de resultado
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	@Override
	public String incluir(ClausulaVO obj) {
		
		Clausulainclrequest request = new Clausulainclrequest();
		Clausulainclresponse response = new Clausulainclresponse();
		Npccwvherequest entrada = new Npccwvherequest();
		Npccwvhsresponse saida = new Npccwvhsresponse();
        request.setNpccwvherequest(entrada);
        response.setNpccwvhsresponse(saida);
        
        SiteUtil.copyPropertiesObjects(obj, entrada);
        
        entrada.setRclauscontrcmbio(LineBreaks.formatToMainframe(obj.getRclauscontrcmbio()));

        // executa chamada MF
        listaSemPaginacao(request, response, "CLAUSULAINCL");
		
		return response.getTexmens();
	}
	
	/**
     * 
     * Nome: alterar
     * 
     * Propósito: Altera um item de Cláusulas
     *
     * @param : ClausulaVO
     * @return : String de resultado
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	@Override
	public String alterar(ClausulaVO obj) {
		
		Clausulaaltrequest request = new Clausulaaltrequest();
		Clausulaaltresponse response = new Clausulaaltresponse();
		Npccwvjerequest entrada = new Npccwvjerequest();
		Npccwvjsresponse saida = new Npccwvjsresponse();
        request.setNpccwvjerequest(entrada);
        response.setNpccwvjsresponse(saida);

        SiteUtil.copyPropertiesObjects(obj, entrada);
        
        entrada.setRclauscontrcmbio(LineBreaks.formatToMainframe(obj.getRclauscontrcmbio()));

        listaSemPaginacao(request, response, "CLAUSULAALT");

        return response.getTexmens();
	}

	/**
     * 
     * Nome: excluir
     * 
     * Propósito: Exclui um item de Cláusulas
     *
     * @param : ClausulaVO
     * @return : String de resultado
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	@Override
	public String excluir(ClausulaVO obj) {
		Clausulaexclrequest request = new Clausulaexclrequest();
		Clausulaexclresponse response = new Clausulaexclresponse();
        Npccwvkerequest entrada = new Npccwvkerequest();
        Npccwvksresponse saida = new Npccwvksresponse();
        request.setNpccwvkerequest(entrada);
        response.setNpccwvksresponse(saida);

        SiteUtil.copyPropertiesObjects(obj, entrada);

        listaSemPaginacao(request, response, "CLAUSULAEXCL");

        return response.getTexmens();
	}
	
	/**
     * 
     * Nome: obterClausula
     * 
     * Propósito: Obter dados da Cláusula e enviar pra página seguinte
     *
     * @param : Id da Clausula selecionada
     * @return : String de resultado
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	@Override
	public ClausulaVO detalhar(Integer idClausula) {
		ClausulaVO clausula = new ClausulaVO();

		
		Clausuladetrequest request = new Clausuladetrequest();
		Clausuladetresponse response = new Clausuladetresponse();
		Npccwvierequest entrada = new Npccwvierequest();
		Npccwvisresponse saida = new Npccwvisresponse();
        request.setNpccwvierequest(entrada);
        response.setNpccwvisresponse(saida);

		entrada.setCclauscontrcmbio(idClausula);

		// executa chamada CWS
        listaSemPaginacao(request, response, "CLAUSULADET");
        
        // trata retorno
        this.setMsgRetorno(response.getTexmens());
        
        //Copia dados obtidos para o retorno
        SiteUtil.copyPropertiesObjects(saida, clausula);
        
        clausula.setRclauscontrcmbio(LineBreaks.formatToWeb(saida.getRclauscontrcmbio()));

        return clausula;
	}

}
