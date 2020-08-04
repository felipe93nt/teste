/**
 *
 * Nome: ParametroUnidadeExternaServiceImpl.java
 * Propósito: <p> </p>
 *
 * @author :  BRADESCO S.A.<BR/>
 * Equipe : CD <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet.Npccwj3erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet.Npccwj3sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet.Parametrounidextdetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet.Parametrounidextdetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Npccwj2erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Npccwj2sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Npccwj2sresponse_tbfaixas_tbfaixasoccurs;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Parametrounidextlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList.Parametrounidextlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan.Npccwj7erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan.Npccwj7erequest_faixas;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan.Parametrounidextmanrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan.Parametrounidextmanresponse;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.IParametroUnidadeExternaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.FaixaOperacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.ParametroUnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;


/**
 *
 * Nome: ParametroUnidadeExternaServiceImpl.java 
 * Propósito:
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
@Named("parametroUnidadeExternaService")
@SessionScoped
public class ParametroUnidadeExternaServiceImpl extends BaseService implements
		IParametroUnidadeExternaService, Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 2455177668936216546L;


	/**
	 * Nome: pesquisar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 */
	public ParametroUnidadeExternaVO pesquisar(ParametroUnidadeExternaVO filtro) {

		Parametrounidextlistrequest request = new Parametrounidextlistrequest();
		Parametrounidextlistresponse response = new Parametrounidextlistresponse();
		
		List<FaixaOperacaoVO> lista = new ArrayList<FaixaOperacaoVO>();

		Npccwj2erequest input = new Npccwj2erequest();
		Npccwj2sresponse output = new Npccwj2sresponse();

		ParametroUnidadeExternaVO objTo = new ParametroUnidadeExternaVO();

		input.setCindcdeconmmoeda(filtro.getCindcdeconmmoeda());
		input.setCprodtservc(filtro.getCprodtservc());
		
		request.setNpccwj2erequest(input);
		response.setNpccwj2sresponse(output);

		// Executa chamada CWS - Fluxo: NPCCIAUW - Books: NPCCWJ2E / NPCCWJ2S
		try {
			listaSemPaginacao(request, response, "PARAMETROUNIDEXTLIST");
		}
		catch(NpccTradeWebException e) {
			this.setMsgRetorno(e.getMessage());
			return objTo;
		}
		
		// trata retorno
		this.setMsgRetorno(response.getTexmens());
		
		objTo.setCindcdeconmmoeda(response.getNpccwj2sresponse().getCindcdeconmmoeda());
		objTo.setDescMoeda(response.getNpccwj2sresponse().getMoedadesc());
		objTo.setCprodtservc(response.getNpccwj2sresponse().getCprodtservc());
		objTo.setDescProduto(response.getNpccwj2sresponse().getProdtdesc());
		objTo.setValorAutorizadoPorProduto(SiteUtil.doubleToBrowserMoeda(response.getNpccwj2sresponse().getVlimaprovcusto()));
		
		// carrega lista de retorno

		for (int i = 0; i < response.getNpccwj2sresponse().getQtdfaixaoper(); i++) {
			Npccwj2sresponse_tbfaixas_tbfaixasoccurs objFrom = response.getNpccwj2sresponse().getTbfaixas_tbfaixasoccurs().get(i);

			FaixaOperacaoVO faixaOperacao = new FaixaOperacaoVO();
			faixaOperacao.getBanco().setCbanqrcmbio(objFrom.getTbfaixas_tbfaixasoccurs_cbanqrcmbio());
			faixaOperacao.setValorDe(SiteUtil.formatarValorWeb(objFrom.getTbfaixas_tbfaixasoccurs_vliminferbanqr()));
			faixaOperacao.setValorAte(SiteUtil.formatarValorWeb(objFrom.getTbfaixas_tbfaixasoccurs_vlimsupebanqr()));
			faixaOperacao.getBanco().setImunintlcmbio(objFrom.getTbfaixas_tbfaixasoccurs_banqrpracadesc());
			faixaOperacao.getBanco().setIbanqrcmbio(objFrom.getTbfaixas_tbfaixasoccurs_banqrdesc());
			faixaOperacao.getBanco().setCidbanqrswift(objFrom.getTbfaixas_tbfaixasoccurs_scidbanqrswift());

			lista.add(faixaOperacao);
		}

		objTo.setListaFaixaOperacao(lista);
		
		return objTo;

	}

	/**
	 * Nome: detalhar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 */
	public ParametroUnidadeExternaVO detalhar(ParametroUnidadeExternaVO filtro) {
		Parametrounidextdetrequest request = new Parametrounidextdetrequest();
		Parametrounidextdetresponse response = new Parametrounidextdetresponse();

		List<FaixaOperacaoVO> lista = new ArrayList<FaixaOperacaoVO>();

		Npccwj3erequest input = new Npccwj3erequest();
		Npccwj3sresponse output = new Npccwj3sresponse();

		ParametroUnidadeExternaVO objTo = new ParametroUnidadeExternaVO();

		input.setCindcdeconmmoeda(filtro.getCindcdeconmmoeda());
		input.setCprodtservc(filtro.getCprodtservc());
		input.setValorme(SiteUtil.webMoedaToBigDecimal(filtro.getVnegocmoedaestrg()));
		
		request.setNpccwj3erequest(input);
		response.setNpccwj3sresponse(output);

		try {
			// Executa chamada CWS - Fluxo: NPCCIAUX - Books: NPCCWJ3E / NPCCWJ3S
			listaSemPaginacao(request, response, "PARAMETROUNIDEXTDET");
		}
		catch(NpccTradeWebException e) {
			this.setMsgRetorno(e.getMessage());
			return objTo;
		}
		
		// trata retorno
		this.setMsgRetorno(response.getTexmens());
		
		FaixaOperacaoVO faixaOperacao = new FaixaOperacaoVO();

		objTo.setCindcdeconmmoeda(response.getNpccwj3sresponse().getCindcdeconmmoeda());
		objTo.setDescMoeda(response.getNpccwj3sresponse().getMoedadesc());
		objTo.setCprodtservc(response.getNpccwj3sresponse().getCprodtservc());
		objTo.setDescProduto(response.getNpccwj3sresponse().getProdtdesc());
		objTo.setValorAutorizadoPorProduto(SiteUtil.doubleToBrowserMoeda(response.getNpccwj3sresponse().getVlimaprovcusto()));
		
		faixaOperacao.getBanco().setCbanqrcmbio(response.getNpccwj3sresponse().getCbanqrcmbio());
		faixaOperacao.setValorDe(SiteUtil.formatarValorWeb(response.getNpccwj3sresponse().getVliminferbanqr()));
		faixaOperacao.setValorAte(SiteUtil.formatarValorWeb(response.getNpccwj3sresponse().getVlimsupebanqr()));
		faixaOperacao.getBanco().setImunintlcmbio(response.getNpccwj3sresponse().getBanqrpracadesc());
		faixaOperacao.getBanco().setIbanqrcmbio(response.getNpccwj3sresponse().getBanqrdesc());

		lista.add(faixaOperacao);

		objTo.setListaFaixaOperacao(lista);
		
		return objTo;

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
	public String manutencao(ParametroUnidadeExternaVO parametroOperacao) {
		Parametrounidextmanrequest request = new Parametrounidextmanrequest();
		Parametrounidextmanresponse response = new Parametrounidextmanresponse();

		Npccwj7erequest input = new Npccwj7erequest();
		List<Npccwj7erequest_faixas> faixas = new ArrayList<Npccwj7erequest_faixas>();

		input.setCindcdeconmmoeda(parametroOperacao.getCindcdeconmmoeda());
		input.setCprodtservc(parametroOperacao.getCprodtservc());
		input.setFuncaoiae(parametroOperacao.getFuncao());
		input.setVlimaprovcusto(SiteUtil.webMoedaToMainframe(parametroOperacao.getValorAutorizadoPorProduto()));

		List<FaixaOperacaoVO> listaFaixaOperacao = parametroOperacao.getListaFaixaOperacao();
		
		int i = 0;
		for (FaixaOperacaoVO faixaOperacao : listaFaixaOperacao) {
			Npccwj7erequest_faixas faixa = new Npccwj7erequest_faixas();
			faixa.setFaixas_cbanqrcmbio(faixaOperacao.getBanco().getCbanqrcmbio());
			faixa.setFaixas_vliminferbanqr(SiteUtil.webMoedaToMainframe(faixaOperacao.getValorDe()));
			faixa.setFaixas_vlimsupebanqr(SiteUtil.webMoedaToMainframe(faixaOperacao.getValorAte()));
			faixas.add(faixa);
			i++;
		}
		input.setQtdfaixaoper(i);
		input.setFaixas(faixas);

		request.setNpccwj7erequest(input);

		try {
			// Executa chamada CWS - Fluxo: NPCCIAUV - Book: NPCCWJ7E
			listaSemPaginacao(request, response, "PARAMETROUNIDEXTMAN");

		}
		catch(NpccTradeWebException e) {
            throw new NpccTradeWebException(e.getMessage(), e, SiteUtil.STRING_EMPTY);
		}
		return response.getTexmens();
	}
}
