/**
 *
 * Nome: ComissaoDesembolsoServiceImpl.java
 * Propósito: <p> </p>
 *
 * @author :  BRADESCO S.A.<BR/>
 * Equipe : CD <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrizacao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet.Comissaodesembolsdetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet.Comissaodesembolsdetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet.Npccwj6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet.Npccwj6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsMan.Comissaodesembolsmanrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsMan.Comissaodesembolsmanresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsMan.Npccwj4erequest;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.IComissaoDesembolsoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.bean.ComissaoDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 *
 * Nome: ComissaoDesembolsoServiceImpl.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRadesco<BR/>
 *         Equipe : CD <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 */
@Named("comissaodesembolsoService")
@SessionScoped
public class ComissaoDesembolsoServiceImpl extends BaseService implements
		IComissaoDesembolsoService, Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 2455177668936216546L;

	/**
	 * Nome: pesquisar
	 * 
	 * Propósito:
	 *
	 * @param : tipoAcesso onde:
	 * 		 	1 - ACESSO INCLUINDO DEMAIS PRODUTOS
	 *		 	2 - ACESSO ESPECIFICO COM DADOS DE ENTRADA
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 */
	public List<ComissaoDesembolsoVO> pesquisar(ComissaoDesembolsoVO filtro, Integer tipoAcesso) {
		List<ComissaoDesembolsoVO> listComissaoDesembolcons = new ArrayList<ComissaoDesembolsoVO>();

		Comissaodesembolsdetrequest request = new Comissaodesembolsdetrequest();
		Comissaodesembolsdetresponse response = new Comissaodesembolsdetresponse();

		Npccwj6erequest input = new Npccwj6erequest();
		Npccwj6sresponse output = new Npccwj6sresponse();

		input.setCprodtservc(filtro.getCprodtservc());
		input.setCindcdeconmmoeda(filtro.getCindcdeconmmoeda());
		input.setTipoacesso(tipoAcesso);
		
		request.setNpccwj6erequest(input);
		response.setNpccwj6sresponse(output);

		try {
			// Executa chamada CWS - Fluxo: NPCCIAU0 - Books: NPCCWJ6E / NPCCWJ6S
			listaSemPaginacao(request, response, "COMISSAODESEMBOLSDET");

			Npccwj6sresponse currentOutput = response.getNpccwj6sresponse();

			// Percorre todos os itens da lista
			ComissaoDesembolsoVO comissaodesembolcons = new ComissaoDesembolsoVO();
			comissaodesembolcons.setCindcdeconmmoeda(currentOutput.getCindcdeconmmoeda());
			comissaodesembolcons.setDescreconmmoeda(currentOutput.getMoedadesc());
			comissaodesembolcons.setCprodtservc(currentOutput.getCprodtservc());
			comissaodesembolcons.setCprodtdesc(currentOutput.getProdtdesc());
			comissaodesembolcons.setVlimcomisfixa(SiteUtil.bigDecimalToWebMoeda(currentOutput.getVlimcomisfixa()));
			comissaodesembolcons.setVcomisfixa(SiteUtil.bigDecimalToWebMoeda(currentOutput.getVcomisfixa()));
	
			listComissaoDesembolcons.add(comissaodesembolcons);
		}
		catch(NpccTradeWebException e) {
			this.setMsgRetorno(e.getMessage());
			return listComissaoDesembolcons;
		}
		
		// trata retorno
		this.setMsgRetorno(response.getTexmens());

		return listComissaoDesembolcons;
	}
	/**
	 * Nome: manutencao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public String manutencao(ComissaoDesembolsoVO ComissaoDesembolsoVO) {
		
		Comissaodesembolsmanrequest request = new Comissaodesembolsmanrequest();
		Comissaodesembolsmanresponse response = new Comissaodesembolsmanresponse();
		Npccwj4erequest input = new Npccwj4erequest();
		
		input.setFuncao(ComissaoDesembolsoVO.getFuncao());
		input.setCindcdeconmmoeda(ComissaoDesembolsoVO.getCindcdeconmmoeda());
		input.setCprodtservc(ComissaoDesembolsoVO.getCprodtservc());
		input.setVlimcomisfixa(SiteUtil.webMoedaToBigDecimal(ComissaoDesembolsoVO.getVlimcomisfixa()));
		input.setVcomisfixa(SiteUtil.webMoedaToBigDecimal(ComissaoDesembolsoVO.getVcomisfixa()));
			
		request.setNpccwj4erequest(input);

		// Executa chamada CWS - Fluxo: NPCCIAUY - Book: NPCCWJ4E       
		listaSemPaginacao(request, response, "COMISSAODESEMBOLSMAN");

		return response.getTexmens();
	}
	@Override
	public List<ComissaoDesembolsoVO> pesquisarLog(ComissaoDesembolsoVO filtro) {
		// TODO Auto-generated method stub
		

		return null;
	}
	
	
}
