/**
 *
 * Nome: BanqueirosServiceImpl.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 09/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.banqueiros.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Banqueiroaltrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Banqueiroaltresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest_motivo;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3erequest_motivob;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAlt.Npcdwc3sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Banqueiroaprovdetrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Banqueiroaprovdetresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse_motvoblqe;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovDet.Npcdwc9sresponse_motvodstv;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovList.Banqueiroaprovlistrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovList.Banqueiroaprovlistresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovList.Npcdwc8erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovList.Npcdwc8sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovList.Npcdwc8sresponse_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovacao.Banqueiroaprovacaorequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovacao.Banqueiroaprovacaoresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovacao.Npcdwdaerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroAprovacao.Npcdwdasresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqDesbloq.Banqueirobloqdesbloqrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqDesbloq.Banqueirobloqdesbloqresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqDesbloq.Npcdwc6erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqDesbloq.Npcdwc6erequest_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqDesbloq.Npcdwc6sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqueioDet.Banqueirobloqueiodetrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqueioDet.Banqueirobloqueiodetresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqueioDet.Npcdwhaerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqueioDet.Npcdwhasresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroBloqueioDet.Npcdwhasresponse_motvoblqe;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroCliCaduList.Banqueiroclicadulistrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroCliCaduList.Banqueiroclicadulistresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroCliCaduList.Npcdwhberequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroCliCaduList.Npcdwhbsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroCliCaduList.Npcdwhbsresponse_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Banqueirodetrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Banqueirodetresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse_motvoblqe;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDet.Npcdwc4sresponse_motvodstv;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAprAssoc.Banqueirodetaprassocrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAprAssoc.Banqueirodetaprassocresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAprAssoc.Npcdwhferequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAprAssoc.Npcdwhfsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Banqueirodetaproaltrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Banqueirodetaproaltresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse_motvoblqe;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproAlt.Npcdwhcsresponse_motvorest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Banqueirodetaprobloqrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Banqueirodetaprobloqresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhderequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse_motvoblqe;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroDetAproBloq.Npcdwhdsresponse_motvodstv;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroExcluirManu.Banqueiroexcluirmanurequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroExcluirManu.Banqueiroexcluirmanuresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroExcluirManu.Npcdwdferequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroExcluirManu.Npcdwdfsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroGerarLog.Banqueirogerarlogrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroGerarLog.Banqueirogerarlogresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroGerarLog.Npcdwc7erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroGerarLog.Npcdwc7sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroListManut.Banqueirolistmanutrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroListManut.Banqueirolistmanutresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroListManut.Npcdwc2erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroListManut.Npcdwc2sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroListManut.Npcdwc2sresponse_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRejeitar.Banqueirorejeitarrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRejeitar.Banqueirorejeitarresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRejeitar.Npcdwdberequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRejeitar.Npcdwdbsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisaoList.Banqueirorevisaolistrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisaoList.Banqueirorevisaolistresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisaoList.Npcdwdcerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisaoList.Npcdwdcsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisaoList.Npcdwdcsresponse_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarAsso.Banqueirorevisarassorequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarAsso.Banqueirorevisarassoresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarAsso.Npcdwhherequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarAsso.Npcdwhhsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarBloq.Banqueirorevisarbloqrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarBloq.Banqueirorevisarbloqresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarBloq.Npcdwhgerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarBloq.Npcdwhgerequest_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarBloq.Npcdwhgsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Banqueirorevisarmanurequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Banqueirorevisarmanuresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdeerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdeerequest_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdeerequest_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdeerequest_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdeerequest_motivo;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueiroRevisarManu.Npcdwdesresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Banqueirosinclrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Banqueirosinclresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Npcdwc1erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Npcdwc1erequest_clearing;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Npcdwc1erequest_conta;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Npcdwc1erequest_endereco;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosIncl.Npcdwc1sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosListaSwift.Banqueiroslistaswiftrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosListaSwift.Banqueiroslistaswiftresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosListaSwift.Npcdwcwerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosListaSwift.Npcdwcwsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.BanqueirosListaSwift.Npcdwcwsresponse_lista;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.CliCbioConsPendencia.Clicbioconspendenciarequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.CliCbioConsPendencia.Clicbioconspendenciaresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.CliCbioConsPendencia.Npcdwejerequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.CliCbioConsPendencia.Npcdwejsresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.MotivoBanqueiroList.Motivobanqueirolistrequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.MotivoBanqueiroList.Motivobanqueirolistresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.MotivoBanqueiroList.Npcdwc5erequest;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.MotivoBanqueiroList.Npcdwc5sresponse;
//import br.com.bradesco.web.npcd.service.awbConnector.adapter.MotivoBanqueiroList.Npcdwc5sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.IBanqueirosService;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueiroBaseVo;
//import br.com.bradesco.web.npcd.service.business.banqueiros.banqueiros.bean.BanqueirosDadosAntesDepoisVo;
//import br.com.bradesco.web.npcd.service.business.banqueiros.banqueiros.bean.BanqueirosDadosSpecVo;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueirosFiltroVo;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
//import br.com.bradesco.web.npcd.service.business.global.LogAlteracaoListaVO;
//import br.com.bradesco.web.npcd.utils.Numeros;
//import br.com.bradesco.web.npcd.utils.SiteUtil;
//import br.com.bradesco.web.npcd.utils.enums.EnumSimNao;
//import br.com.bradesco.web.npcd.utils.enums.EnumSimNaoStr;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoConta;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoManutencao;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoUnidade;

/**
 *
 * Nome: BanqueirosServiceImpl.java Propósito:
 * <p>
 * </p>
 *
 * @author : Bradesco S.A<BR/>
 *         Equipe : Centro desenvolvimento - Curitiba <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 */
@Named("banqueirosService")
@SessionScoped
public class BanqueirosServiceImpl extends BaseService implements
		IBanqueirosService {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 4550166576006125813L;

	/**
	 * Método construtor da classe.
	 */
	public BanqueirosServiceImpl() {
		super();

	}

	/**
	 * 
	 * Nome: BanqueirosListaSwift Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 09/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueirosListaSwift(BanqueirosFiltroVo dadosFiltro) {
//
//		Banqueiroslistaswiftrequest request = new Banqueiroslistaswiftrequest();
//		Banqueiroslistaswiftresponse response = new Banqueiroslistaswiftresponse();
//		Npcdwcwerequest entrada = new Npcdwcwerequest();
//		Npcdwcwsresponse saida = new Npcdwcwsresponse();
//		request.setNpcdwcwerequest(entrada);
//		response.setNpcdwcwsresponse(saida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		entrada.setTipopesquisa(SiteUtil.getInt(dadosFiltro
//				.getTipoPesquisaCadastro()));
//
//		// Efetua o tratamento dos campos de descricao e código da despesa de
//		// acordo com o tipo de pesquisa.
//		if (SiteUtil.getInt(dadosFiltro.getTipoPesquisaCadastro()) == Numeros.NUM1
//				.intValue()) {
//			String codigoSwift = dadosFiltro.getDescricao();
//
//			// Verifica se a filial do swift foi informado
//			if (codigoSwift != null && codigoSwift.length() > 8) {
//				entrada.setCidbanqrswift(codigoSwift.substring(0, 8));
//				entrada.setCflialbanqrswift(codigoSwift.substring(8));
//			} else {
//				entrada.setCidbanqrswift(codigoSwift);
//				entrada.setCflialbanqrswift(SiteUtil.STRING_EMPTY);
//			}
//
//			entrada.setIbanqrcmbioswift(SiteUtil.STRING_EMPTY);
//
//		} else {
//			entrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
//			entrada.setIbanqrcmbioswift(SiteUtil.getString(dadosFiltro
//					.getDescricao()));
//		}
//
//		// executa chamada CWS - Fluxo NPCDIADQ - Books: NPCDWCWE / NPCDWCWS
//		listaComPaginacao(request, response, "BANQUEIROSLISTASWIFT", "NPCDIADQ");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		for (int i = 0; i < response.getNpcdwcwsresponse().getQtdeocorr(); i++) {
//
//			Npcdwcwsresponse_lista objFrom = response.getNpcdwcwsresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			// Seta os valor dos campos que não vem do MF
//			dadosRetorno.getListaCodSwift().add(objTo);
//		}
//
//		return dadosRetorno;
//	}

	/**
	 * 
	 * Nome: banqueiroListManut Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 */
	public BanqueiroBaseVo banqueiroListManut(BanqueirosFiltroVo dadosFiltro) {

//		Banqueirolistmanutrequest request = new Banqueirolistmanutrequest();
//		Banqueirolistmanutresponse response = new Banqueirolistmanutresponse();
//		Npcdwc2erequest entrada = new Npcdwc2erequest();
//		Npcdwc2sresponse saida = new Npcdwc2sresponse();
//		request.setNpcdwc2erequest(entrada);
//		response.setNpcdwc2sresponse(saida);
		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		entrada.setTipopesquisa(SiteUtil.getInt(dadosFiltro
//				.getTipoPesquisaManutencao()));
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosFiltro, entrada);
//
//		// Efetua o tratamento dos campos de descricao e código da despesa de
//		// acordo com o tipo de pesquisa.
//		if (SiteUtil.getInt(dadosFiltro.getTipoPesquisaManutencao()) == Numeros.NUM1
//				.intValue()) {
//
//			entrada.setCbanqrcmbio(SiteUtil.getLong(dadosFiltro.getDescricao()));
//			entrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
//			entrada.setIbanqrcmbio(SiteUtil.STRING_EMPTY);
//			entrada.setCpais(Numeros.NUM0);
//			entrada.setCmunintlcmbio(Numeros.NUM0_LONG);
//
//		} else if (SiteUtil.getInt(dadosFiltro.getTipoPesquisaManutencao()) == Numeros.NUM2
//				.intValue()) {
//			String codigoSwift = dadosFiltro.getDescricao();
//
//			// Verifica se a filial do swift foi informado
//			if (codigoSwift != null && codigoSwift.length() > 8) {
//				entrada.setCidbanqrswift(codigoSwift.substring(0, 8));
//				entrada.setCflialbanqrswift(codigoSwift.substring(8));
//			} else {
//				entrada.setCidbanqrswift(codigoSwift);
//				entrada.setCflialbanqrswift(SiteUtil.STRING_EMPTY);
//			}
//
//			entrada.setCbanqrcmbio(Numeros.NUM0_LONG);
//			entrada.setIbanqrcmbio(SiteUtil.STRING_EMPTY);
//			entrada.setCpais(Numeros.NUM0);
//			entrada.setCmunintlcmbio(Numeros.NUM0_LONG);
//
//		} else if (SiteUtil.getInt(dadosFiltro.getTipoPesquisaManutencao()) == Numeros.NUM3
//				.intValue()) {
//			entrada.setIbanqrcmbio(SiteUtil.getString(dadosFiltro
//					.getDescricao()));
//			entrada.setCbanqrcmbio(Numeros.NUM0_LONG);
//			entrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
//			entrada.setCpais(Numeros.NUM0);
//			entrada.setCmunintlcmbio(Numeros.NUM0_LONG);
//
//		} else {
//			entrada.setCbanqrcmbio(Numeros.NUM0_LONG);
//			entrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
//			entrada.setIbanqrcmbio(SiteUtil.STRING_EMPTY);
//		}
//
//		// executa chamada CWS - Fluxo NPCDIADO - Books: NPCDWC2E / NPCDWC2S
//		listaComPaginacao(request, response, "BANQUEIROLISTMANUT", "NPCDIADO");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		for (int i = 0; i < response.getNpcdwc2sresponse().getQtdeocorr(); i++) {
//
//			Npcdwc2sresponse_lista objFrom = response.getNpcdwc2sresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			objTo.setItrocamsgemswift(EnumSimNao.fromCode(objFrom
//					.getLista_ctrocamsgemswift()));
//
//			// Seta os valor dos campos que não vem do MF
//			dadosRetorno.getListaCodSwift().add(objTo);
//		}

		return dadosRetorno;
	}

	/**
	 * 
	 * Nome: banqueiroAprovList Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroAprovList() {
//
//		Banqueiroaprovlistrequest request = new Banqueiroaprovlistrequest();
//		Banqueiroaprovlistresponse response = new Banqueiroaprovlistresponse();
//		Npcdwc8erequest entrada = new Npcdwc8erequest();
//		Npcdwc8sresponse saida = new Npcdwc8sresponse();
//		request.setNpcdwc8erequest(entrada);
//		response.setNpcdwc8sresponse(saida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Campo não utilizado pelo MF para esta pesquisa.
//		entrada.setCbanqrcmbio(Numeros.NUM0_LONG);
//
//		// executa chamada CWS - Fluxo NPCDIADM - Books: NPCDWC8E / NPCDWC8S
//		listaComPaginacao(request, response, "BANQUEIROAPROVLIST", "NPCDIADM");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		for (int i = 0; i < response.getNpcdwc8sresponse().getQtdeocorr(); i++) {
//
//			Npcdwc8sresponse_lista objFrom = response.getNpcdwc8sresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			// Seta descrição do tipo de manutenção.
//			objTo.setTipoManutencao(EnumTipoManutencao.fromCode(objFrom
//					.getLista_cindcdtpomanut()));
//
//			// Seta os valor dos campos que não vem do MF
//			dadosRetorno.getListaCodSwift().add(objTo);
//		}
//
//		return dadosRetorno;
//	}
//
	/**
	 * 
	 * Nome: banqueiroRevisaoList Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroRevisaoList() {
//
//		Banqueirorevisaolistrequest request = new Banqueirorevisaolistrequest();
//		Banqueirorevisaolistresponse response = new Banqueirorevisaolistresponse();
//		Npcdwdcerequest entrada = new Npcdwdcerequest();
//		Npcdwdcsresponse saida = new Npcdwdcsresponse();
//		request.setNpcdwdcerequest(entrada);
//		response.setNpcdwdcsresponse(saida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Campo não utilizado pelo MF para esta pesquisa.
//		entrada.setCbanqrcmbio(Numeros.NUM0_LONG);
//
//		// executa chamada CWS - Fluxo NPCDIAD4 - Books: NPCDWDCE / NPCDWDCS
//		listaComPaginacao(request, response, "BANQUEIROREVISAOLIST", "NPCDIAD4");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		for (int i = 0; i < response.getNpcdwdcsresponse().getQtdeocorr(); i++) {
//
//			Npcdwdcsresponse_lista objFrom = response.getNpcdwdcsresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			// Seta descrição do tipo de manutenção.
//			objTo.setTipoManutencao(EnumTipoManutencao.fromCode(objFrom
//					.getLista_cindcdtpomanut()));
//
//			// Seta os valor dos campos que não vem do MF
//			dadosRetorno.getListaCodSwift().add(objTo);
//		}
//
//		return dadosRetorno;
//	}

	/**
	 * 
	 * Nome: banqueirosIncl Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 17/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueirosIncl(BanqueiroBaseVo dadosInclusao) {
//
//		Banqueirosinclrequest request = new Banqueirosinclrequest();
//		Banqueirosinclresponse response = new Banqueirosinclresponse();
//		Npcdwc1erequest bookEntrada = new Npcdwc1erequest();
//		Npcdwc1sresponse bookSaida = new Npcdwc1sresponse();
//		request.setNpcdwc1erequest(bookEntrada);
//		response.setNpcdwc1sresponse(bookSaida);
//
//		bookEntrada.setConta(new ArrayList<Npcdwc1erequest_conta>());
//		bookEntrada.setClearing(new ArrayList<Npcdwc1erequest_clearing>());
//		bookEntrada.setEndereco(new ArrayList<Npcdwc1erequest_endereco>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosInclusao, bookEntrada);
//
//		bookEntrada.setDinicscrtzbanqr(SiteUtil
//				.dataWebToMainframe(dadosInclusao.getDinicscrtzbanqr()));
//		bookEntrada.setDfimscrtzbanqr(SiteUtil.dataWebToMainframe(dadosInclusao
//				.getDfimscrtzbanqr()));
//
//		String cnpj = SiteUtil.removeNaoNumericos(dadosInclusao.getCnpj()
//				.toString());
//
//		// Verifica o tamanho do cnpj para recuperar o valor de cada campo via
//		// de substring.
//		if (!cnpj.isEmpty() && cnpj.length() == Numeros.CATORZE) {
//			bookEntrada.setCcpfcnpj(SiteUtil.getInt(cnpj.substring(0,
//					cnpj.length() - 6)));
//			bookEntrada.setCflialcnpj(SiteUtil.getInt(dadosInclusao.getCnpj()
//					.getCnpjCampo4()));
//			bookEntrada.setCctrlcpfcnpj(SiteUtil.getInt(dadosInclusao.getCnpj()
//					.getCnpjCampo5()));
//		} else {
//			bookEntrada.setCcpfcnpj(Numeros.NUM0);
//			bookEntrada.setCflialcnpj(Numeros.NUM0);
//			bookEntrada.setCctrlcpfcnpj(Numeros.NUM0);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Contas.
//		bookEntrada.setQtdeconta(SiteUtil.getInt(dadosInclusao.getListaConta()
//				.size()));
//
//		// Popula a lista de Contas
//		for (BanqueirosDadosSpecVo objFrom : dadosInclusao.getListaConta()) {
//
//			Npcdwc1erequest_conta objTo = new Npcdwc1erequest_conta();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", false);
//
//			bookEntrada.getConta().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista Clearing .
//		bookEntrada.setQtdeclearing(SiteUtil.getInt(dadosInclusao
//				.getListaClearing().size()));
//
//		// Popula a lista de Clearing.
//		for (BanqueirosDadosSpecVo objFrom : dadosInclusao.getListaClearing()) {
//
//			Npcdwc1erequest_clearing objTo = new Npcdwc1erequest_clearing();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", false);
//
//			bookEntrada.getClearing().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Endereços.
//		bookEntrada.setQtdeendereco(SiteUtil.getInt(dadosInclusao
//				.getListaEndereco().size()));
//
//		// Popula a lista de Endereços.
//		for (BanqueirosDadosSpecVo objFrom : dadosInclusao.getListaEndereco()) {
//
//			Npcdwc1erequest_endereco objTo = new Npcdwc1erequest_endereco();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", false);
//
//			bookEntrada.getEndereco().add(objTo);
//		}
//
//		// executa chamada CWS - Fluxo NPCDIADH - Books: NPCDWC1E / NPCDWC1S
//		listaSemPaginacao(request, response, "BANQUEIROSINCL");
//
//		return response.getTexmens();
//	}

	/**
	 * Nome: banqueiroAlt
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroAlt(BanqueiroBaseVo dadosAlteracao) {
//
//		Banqueiroaltrequest request = new Banqueiroaltrequest();
//		Banqueiroaltresponse response = new Banqueiroaltresponse();
//		Npcdwc3erequest bookEntrada = new Npcdwc3erequest();
//		Npcdwc3sresponse bookSaida = new Npcdwc3sresponse();
//		request.setNpcdwc3erequest(bookEntrada);
//		response.setNpcdwc3sresponse(bookSaida);
//
//		bookEntrada.setConta(new ArrayList<Npcdwc3erequest_conta>());
//		bookEntrada.setClearing(new ArrayList<Npcdwc3erequest_clearing>());
//		bookEntrada.setEndereco(new ArrayList<Npcdwc3erequest_endereco>());
//		bookEntrada.setMotivo(new ArrayList<Npcdwc3erequest_motivo>());
//		bookEntrada.setMotivob(new ArrayList<Npcdwc3erequest_motivob>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosAlteracao, bookEntrada);
//
//		bookEntrada.setDinicscrtzbanqr(SiteUtil
//				.dataWebToMainframe(dadosAlteracao.getDinicscrtzbanqr()));
//		bookEntrada.setDfimscrtzbanqr(SiteUtil
//				.dataWebToMainframe(dadosAlteracao.getDfimscrtzbanqr()));
//		bookEntrada.setCindcdpapeloper(dadosAlteracao.getIcindcdbloqueado()
//				.getCodigo());
//
//		String cnpj = SiteUtil.removeNaoNumericos(dadosAlteracao.getCnpj()
//				.toString());
//
//		// Verifica o tamanho do cnpj para recuperar o valor de cada campo via
//		// de substring.
//		if (!cnpj.isEmpty() && cnpj.length() == Numeros.CATORZE) {
//			bookEntrada.setCcpfcnpj(SiteUtil.getInt(cnpj.substring(0,
//					cnpj.length() - 6)));
//			bookEntrada.setCflialcnpj(SiteUtil.getInt(dadosAlteracao.getCnpj()
//					.getCnpjCampo4()));
//			bookEntrada.setCctrlcpfcnpj(SiteUtil.getInt(dadosAlteracao
//					.getCnpj().getCnpjCampo5()));
//		} else {
//			bookEntrada.setCcpfcnpj(Numeros.NUM0);
//			bookEntrada.setCflialcnpj(Numeros.NUM0);
//			bookEntrada.setCctrlcpfcnpj(Numeros.NUM0);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Contas.
//		bookEntrada.setQtdeconta(SiteUtil.getInt(dadosAlteracao.getListaConta()
//				.size()));
//
//		// Popula a lista de Contas
//		for (BanqueirosDadosSpecVo objFrom : dadosAlteracao.getListaConta()) {
//
//			Npcdwc3erequest_conta objTo = new Npcdwc3erequest_conta();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", false);
//
//			bookEntrada.getConta().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista Clearing .
//		bookEntrada.setQtdeclearing(SiteUtil.getInt(dadosAlteracao
//				.getListaClearing().size()));
//
//		// Popula a lista de Clearing.
//		for (BanqueirosDadosSpecVo objFrom : dadosAlteracao.getListaClearing()) {
//
//			Npcdwc3erequest_clearing objTo = new Npcdwc3erequest_clearing();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", false);
//
//			bookEntrada.getClearing().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Endereços.
//		bookEntrada.setQtdeendereco(SiteUtil.getInt(dadosAlteracao
//				.getListaEndereco().size()));
//
//		// Popula a lista de Endereços.
//		for (BanqueirosDadosSpecVo objFrom : dadosAlteracao.getListaEndereco()) {
//
//			Npcdwc3erequest_endereco objTo = new Npcdwc3erequest_endereco();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", false);
//
//			bookEntrada.getEndereco().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Motivos.
//		bookEntrada.setQtdemotivo(SiteUtil.getInt(dadosAlteracao
//				.getListaMotivosAtivosDireita().size()));
//
//		// Popula a lista de Motivos
//		for (BanqueirosDadosSpecVo objFrom : dadosAlteracao
//				.getListaMotivosAtivosDireita()) {
//
//			Npcdwc3erequest_motivo objTo = new Npcdwc3erequest_motivo();
//			objTo.setMotivo_ntpomotvorest(objFrom.getNtpomotvodstv());
//
//			bookEntrada.getMotivo().add(objTo);
//		}
//
//		// Verifica se há dados de bloqueio para serem enviados
//		if (dadosAlteracao.getListaBloqueios() != null) {
//			bookEntrada.setQtdemotivob(dadosAlteracao.getListaBloqueios()
//					.size());
//
//			// Popula a lista de Motivos
//			for (BanqueirosDadosSpecVo objFrom : dadosAlteracao
//					.getListaBloqueios()) {
//
//				Npcdwc3erequest_motivob objTo = new Npcdwc3erequest_motivob();
//				objTo.setMotivob_ntpomotvobloq(objFrom.getNtpomotvoblqe());
//
//				bookEntrada.getMotivob().add(objTo);
//			}
//		}
//
//		// executa chamada CWS - Fluxo NPCDIACX - Books: NPCDWC3E / NPCDWC3S
//		listaSemPaginacao(request, response, "BANQUEIROALT");
//
//		return response.getTexmens();
//	}

	/**
	 * 
	 * Nome: banqueiroDet Propósito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 24/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDet(BanqueiroBaseVo dadosEntrada) {
//
//		Banqueirodetrequest request = new Banqueirodetrequest();
//		Banqueirodetresponse response = new Banqueirodetresponse();
//		Npcdwc4erequest bookEntrada = new Npcdwc4erequest();
//		Npcdwc4sresponse bookSaida = new Npcdwc4sresponse();
//		request.setNpcdwc4erequest(bookEntrada);
//		response.setNpcdwc4sresponse(bookSaida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAC6 - Books: NPCDWC4E / NPCDWC4S
//		listaComPaginacao(request, response, "BANQUEIRODET", "NPCDIAC6");
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaida, dadosRetorno);
//
//		dadosRetorno.setTipoUnidade(EnumTipoUnidade.fromCode(bookSaida
//				.getCclasfundbanqr()));
//		dadosRetorno.setIpssoapoltcexpsi(EnumSimNao.fromCode(bookSaida
//				.getCpssoapoltcexpsi()));
//		dadosRetorno.setIindcdbanqrcorsp(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrcorsp()));
//		dadosRetorno.setItrocamsgemswift(EnumSimNao.fromCode(bookSaida
//				.getCtrocamsgemswift()));
//		dadosRetorno.setIindcdbanqrscrtz(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrscrtz()));
//		dadosRetorno.setIbanqrscrtzprinc(EnumSimNao.fromCode(bookSaida
//				.getCbanqrscrtzprinc()));
//		dadosRetorno.setIindcdconvecmbio(EnumSimNao.fromCode(bookSaida
//				.getCindcdconvecmbio()));
//		dadosRetorno.setIcindcdbloqueado(EnumSimNao.fromCode(bookSaida
//				.getCindcdbloqueado()));
//		dadosRetorno.setIcindcdpapelativo(EnumSimNao.fromCode(bookSaida
//				.getCindcdpapelativo()));
//		dadosRetorno.setIbanqrhedge(EnumSimNaoStr.fromCode(bookSaida
//				.getBanqrhedge()));
//		dadosRetorno.setDinicscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDinicscrtzbanqr()));
//		dadosRetorno.setDfimscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDfimscrtzbanqr()));
//		dadosRetorno.setFlgswiftcarga(bookSaida.getFlgswiftcarga().equals("S"));
//
//		// Formata o CNPJ para exibição na tela.
//		dadosRetorno.setCnpjFormatado(SiteUtil.formatarCPFCCNPJ(
//				bookSaida.getCcpfcnpj(), bookSaida.getCflialcnpj(),
//				bookSaida.getCctrlcpfcnpj()));
//
//		// Formata o CNPJ para exibição correta no componente na tela.
//		dadosRetorno.setCnpj(SiteUtil.formatarCnpjComponente(
//				dadosRetorno.getCnpj(), bookSaida.getCcpfcnpj(),
//				bookSaida.getCflialcnpj(), bookSaida.getCctrlcpfcnpj()));
//
//		// trata a mensagem de retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Percorre apenas o itens válidos contidos na lista de Contas
//		for (int i = 0; i < bookSaida.getQtdeconta(); i++) {
//
//			Npcdwc4sresponse_conta objFrom = bookSaida.getConta().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", true);
//			objTo.setTipoConta(EnumTipoConta.fromCode(objFrom
//					.getConta_cutilzctabanqr()));
//			// Recupera a descrição da moeda.
//			StringBuffer descricaoMoeda = new StringBuffer();
//			descricaoMoeda.append(objFrom.getConta_cindcdfontecons())
//					.append("-").append(objFrom.getConta_isglindcdfonte());
//			objTo.setIindcdeconmmoeda(descricaoMoeda.toString());
//
//			dadosRetorno.getListaConta().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeclearing(); i++) {
//
//			Npcdwc4sresponse_clearing objFrom = bookSaida.getClearing().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", true);
//			objTo.setPrioridade(EnumSimNao.fromCode(objFrom
//					.getClearing_ccmaracompeprior()));
//
//			dadosRetorno.getListaClearing().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeendereco(); i++) {
//
//			Npcdwc4sresponse_endereco objFrom = bookSaida.getEndereco().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", true);
//
//			// Recupera a descrição da cidade
//			objTo.setImunintlcmbio(objFrom.getEndereco_imun());
//
//			// Recupera a descrição do país
//			objTo.setNomepais(objFrom.getEndereco_ipais());
//
//			objTo.setCmunintlcmbio(objFrom.getEndereco_cmun());
//
//			// Verifica se o país selecionado é "Brasil" para recuperar a
//			// descrição da UF
//			if (objFrom.getEndereco_cpais().compareTo(Numeros.NUM9) == Numeros.NUM0) {
//
//				// Formata o cep para exibição na lista.
//				objTo.setIcoduf(objFrom.getEndereco_imun());
//			}
//			dadosRetorno.getListaEndereco().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvodstv(); i++) {
//
//			Npcdwc4sresponse_motvodstv objFrom = bookSaida.getMotvodstv()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvodstv_", true);
//
//			dadosRetorno.getListaMotivosAtivosDireita().add(objTo);
//			dadosRetorno.getListaMotivos().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvoblqe(); i++) {
//
//			Npcdwc4sresponse_motvoblqe objFrom = bookSaida.getMotvoblqe()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvoblqe_", true);
//
//			dadosRetorno.getListaMotivosBloqueioDireita().add(objTo);
//			dadosRetorno.getListaBloqueios().add(objTo);
//		}
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * 
//	 * Nome: banqueiroBloqueioDet Propósito:
//	 *
//	 * @param : <BR/>
//	 * @return :
//	 *
//	 * @throws :
//	 * 
//	 * @exception :
//	 *
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/12/2015 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueiroBaseVo banqueiroBloqueioDet(BanqueiroBaseVo dadosEntrada) {
//
//		Banqueirobloqueiodetrequest request = new Banqueirobloqueiodetrequest();
//		Banqueirobloqueiodetresponse response = new Banqueirobloqueiodetresponse();
//		Npcdwhaerequest bookEntrada = new Npcdwhaerequest();
//		Npcdwhasresponse bookSaida = new Npcdwhasresponse();
//		request.setNpcdwhaerequest(bookEntrada);
//		response.setNpcdwhasresponse(bookSaida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAGU - Books: NPCDWHAE / NPCDWHAS
//		listaComPaginacao(request, response, "BANQUEIROBLOQUEIODET", "NPCDIAGU");
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaida, dadosRetorno);
//
//		dadosRetorno.setItrocamsgemswift(EnumSimNao.fromCode(bookSaida
//				.getCtrocamsgemswift()));
//		dadosRetorno.setIindcdbanqrcorsp(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrcorsp()));
//		dadosRetorno.setIcindcdbloqueado(EnumSimNao.fromCode(bookSaida
//				.getCindcdbloqueado()));
//		dadosRetorno.setIbanqrhedge(EnumSimNaoStr.fromCode(bookSaida
//				.getBanqrhedge()));
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvoblqe(); i++) {
//
//			Npcdwhasresponse_motvoblqe objFrom = bookSaida.getMotvoblqe()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvoblqe_", true);
//
//			dadosRetorno.getListaMotivosBloqueioDireita().add(objTo);
//		}
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * 
//	 * Nome: banqueiroBloqDesbloq Propósito:
//	 *
//	 * @param : <BR/>
//	 * @return :
//	 *
//	 * @throws :
//	 * 
//	 * @exception :
//	 *
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroBloqDesbloq(BanqueiroBaseVo dadosEntrada,
//			String tipoOperacao) {
//
//		Banqueirobloqdesbloqrequest request = new Banqueirobloqdesbloqrequest();
//		Banqueirobloqdesbloqresponse response = new Banqueirobloqdesbloqresponse();
//		Npcdwc6erequest bookEntrada = new Npcdwc6erequest();
//		Npcdwc6sresponse bookSaida = new Npcdwc6sresponse();
//		request.setNpcdwc6erequest(bookEntrada);
//		response.setNpcdwc6sresponse(bookSaida);
//
//		bookEntrada.setLista(new ArrayList<Npcdwc6erequest_lista>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//		bookEntrada.setCunicpssoacmbio(SiteUtil.getLong(dadosEntrada
//				.getCbanqrcmbio()));
//
//		// Verifica o tipo de operação.
//		if (tipoOperacao.equals(SiteUtil.getString(Numeros.NUM1))) {
//
//			// Seta a quantidade de ocorrências da lista de Motivos.
//			bookEntrada.setQtdeocorr(SiteUtil.getInt(dadosEntrada
//					.getListaMotivosBloqueioDireita().size()));
//
//			// Popula a lista de Contas
//			for (BanqueirosDadosSpecVo objFrom : dadosEntrada
//					.getListaMotivosBloqueioDireita()) {
//
//				Npcdwc6erequest_lista objTo = new Npcdwc6erequest_lista();
//				objTo.setLista_ntpomotvorest(objFrom.getNtpomotvoblqe());
//
//				bookEntrada.getLista().add(objTo);
//			}
//		} else {
//			bookEntrada.setQtdeocorr(Numeros.NUM0);
//		}
//
//		// executa chamada CWS - Fluxo NPCDIAC4 - Books: NPCDWC6E / NPCDWC6S
//		listaSemPaginacao(request, response, "BANQUEIROBLOQDESBLOQ");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroAprovDet
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueiroBaseVo banqueiroAprovDet(BanqueiroBaseVo dadosEntrada) {
//
//		Banqueiroaprovdetrequest request = new Banqueiroaprovdetrequest();
//		Banqueiroaprovdetresponse response = new Banqueiroaprovdetresponse();
//		Npcdwc9erequest bookEntrada = new Npcdwc9erequest();
//		Npcdwc9sresponse bookSaida = new Npcdwc9sresponse();
//		request.setNpcdwc9erequest(bookEntrada);
//		response.setNpcdwc9sresponse(bookSaida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAC5 - Books: NPCDWC9E / NPCDWC9S
//		listaComPaginacao(request, response, "BANQUEIROAPROVDET", "NPCDIAC5");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaida, dadosRetorno);
//
//		dadosRetorno.setCindcdtpomanut(SiteUtil.getString(dadosEntrada
//				.getCindcdtpomanut()));
//		dadosRetorno.setTipoUnidade(EnumTipoUnidade.fromCode(bookSaida
//				.getCclasfundbanqr()));
//		dadosRetorno.setIpssoapoltcexpsi(EnumSimNao.fromCode(bookSaida
//				.getCpssoapoltcexpsi()));
//		dadosRetorno.setIindcdbanqrcorsp(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrcorsp()));
//		dadosRetorno.setItrocamsgemswift(EnumSimNao.fromCode(bookSaida
//				.getCtrocamsgemswift()));
//		dadosRetorno.setIindcdbanqrscrtz(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrscrtz()));
//		dadosRetorno.setIbanqrscrtzprinc(EnumSimNao.fromCode(bookSaida
//				.getCbanqrscrtzprinc()));
//		dadosRetorno.setIindcdconvecmbio(EnumSimNao.fromCode(bookSaida
//				.getCindcdconvecmbio()));
//		dadosRetorno.setIcindcdbloqueado(EnumSimNao.fromCode(bookSaida
//				.getCindcdbloqueado()));
//		dadosRetorno.setIcindcdpapelativo(EnumSimNao.fromCode(bookSaida
//				.getCindcdpapelativo()));
//		dadosRetorno.setIbanqrhedge(EnumSimNaoStr.fromCode(bookSaida
//				.getBanqrhedge()));
//		dadosRetorno.setDinicscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDinicscrtzbanqr()));
//		dadosRetorno.setDfimscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDfimscrtzbanqr()));
//		dadosRetorno.setFlgswiftcarga(bookSaida.getFlgswiftcarga().equals("S"));
//
//		// Formata o CNPJ para exibição na tela.
//		dadosRetorno.setCnpjFormatado(SiteUtil.formatarCPFCCNPJ(
//				bookSaida.getCcpfcnpj(), bookSaida.getCflialcnpj(),
//				bookSaida.getCctrlcpfcnpj()));
//
//		// Formata o CNPJ para exibição correta no componente na tela.
//		dadosRetorno.setCnpj(SiteUtil.formatarCnpjComponente(
//				dadosRetorno.getCnpj(), bookSaida.getCcpfcnpj(),
//				bookSaida.getCflialcnpj(), bookSaida.getCctrlcpfcnpj()));
//
//		// trata a mensagem de retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Percorre apenas o itens válidos contidos na lista de Contas
//		for (int i = 0; i < bookSaida.getQtdeconta(); i++) {
//
//			Npcdwc9sresponse_conta objFrom = bookSaida.getConta().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", true);
//			objTo.setTipoConta(EnumTipoConta.fromCode(objFrom
//					.getConta_cutilzctabanqr()));
//			// Recupera a descrição da moeda.
//			StringBuffer descricaoMoeda = new StringBuffer();
//			descricaoMoeda.append(objFrom.getConta_cindcdfontecons())
//					.append("-").append(objFrom.getConta_isglindcdfonte());
//			objTo.setIindcdeconmmoeda(descricaoMoeda.toString());
//
//			dadosRetorno.getListaConta().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeclearing(); i++) {
//
//			Npcdwc9sresponse_clearing objFrom = bookSaida.getClearing().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", true);
//			objTo.setPrioridade(EnumSimNao.fromCode(objFrom
//					.getClearing_ccmaracompeprior()));
//
//			dadosRetorno.getListaClearing().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeendereco(); i++) {
//
//			Npcdwc9sresponse_endereco objFrom = bookSaida.getEndereco().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", true);
//
//			// Recupera a descrição da cidade
//			objTo.setImunintlcmbio(objFrom.getEndereco_imun());
//
//			// Recupera a descrição do país
//			objTo.setNomepais(objFrom.getEndereco_ipais());
//
//			objTo.setCmunintlcmbio(objFrom.getEndereco_cmun());
//
//			// Verifica se o país selecionado é "Brasil" para recuperar a
//			// descrição da UF
//			if (objFrom.getEndereco_cpais().compareTo(Numeros.NUM9) == Numeros.NUM0) {
//
//				// Formata o cep para exibição na lista.
//				objTo.setIcoduf(objFrom.getEndereco_imun());
//			}
//
//			dadosRetorno.getListaEndereco().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvodstv(); i++) {
//
//			Npcdwc9sresponse_motvodstv objFrom = bookSaida.getMotvodstv()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvodstv_", true);
//
//			dadosRetorno.getListaMotivosAtivosDireita().add(objTo);
//			dadosRetorno.getListaMotivos().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvoblqe(); i++) {
//
//			Npcdwc9sresponse_motvoblqe objFrom = bookSaida.getMotvoblqe()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvoblqe_", true);
//
//			dadosRetorno.getListaMotivosBloqueioDireita().add(objTo);
//			dadosRetorno.getListaBloqueios().add(objTo);
//		}
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * Nome: motivoBanqueiroList
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public List<BanqueirosDadosSpecVo> motivoBanqueiroList(Integer funcao,
//			boolean apenasAtivos) {
//
//		List<BanqueirosDadosSpecVo> lista = new ArrayList<BanqueirosDadosSpecVo>();
//
//		Motivobanqueirolistrequest request = new Motivobanqueirolistrequest();
//		Motivobanqueirolistresponse response = new Motivobanqueirolistresponse();
//		Npcdwc5erequest entrada = new Npcdwc5erequest();
//		Npcdwc5sresponse saida = new Npcdwc5sresponse();
//		request.setNpcdwc5erequest(entrada);
//		response.setNpcdwc5sresponse(saida);
//
//		// Valores fixos por solicitação da equipe MF.
//		entrada.setTipopesquisa(Numeros.NUM2);
//		entrada.setRtpomotvorest(SiteUtil.STRING_EMPTY);
//		entrada.setCidtfdnvelrest(funcao);
//		entrada.setNtpositcmbio(apenasAtivos ? Numeros.NUM1 : Numeros.NUM0);
//		entrada.setNtpopapelcmbio(Numeros.NUM2);
//
//		// executa chamada CWS - Fluxo NPCDIADR - Books: NPCDWC5E / NPCDWC5S
//		listaComPaginacao(request, response, "MOTIVOBANQUEIROLIST", "NPCDIADR");
//
//		// trata retorno
//		setMsgRetorno(response.getTexmens());
//
//		// carrega lista de retorno
//		for (int i = Numeros.ZERO; i < response.getNpcdwc5sresponse()
//				.getQtdeocorr(); i++) {
//			Npcdwc5sresponse_lista objFrom = response.getNpcdwc5sresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			// Campos para lista de Motivo Bloqueio
//			objTo.setNtpomotvoblqe(objFrom.getLista_ntpomotvorest());
//			objTo.setRtpomotvoblqe(objFrom.getLista_rtpomotvorest());
//
//			// Campos para lista de Motivo Inativação
//			objTo.setNtpomotvodstv(objFrom.getLista_ntpomotvorest());
//			objTo.setRtpomotvodstv(objFrom.getLista_rtpomotvorest());
//
//			// adiciona o objeto a lista
//			lista.add(objTo);
//		}
//
//		return lista;
//	}
//
//	/**
//	 * Nome: banqueiroDetAproBloq
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 18/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueiroBaseVo banqueiroDetAproBloq(BanqueiroBaseVo dadosEntrada) {
//
//		Banqueirodetaprobloqrequest request = new Banqueirodetaprobloqrequest();
//		Banqueirodetaprobloqresponse response = new Banqueirodetaprobloqresponse();
//		Npcdwhderequest bookEntrada = new Npcdwhderequest();
//		Npcdwhdsresponse bookSaida = new Npcdwhdsresponse();
//
//		request.setNpcdwhderequest(bookEntrada);
//		response.setNpcdwhdsresponse(bookSaida);
//
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAGY - Books: NPCDWHDE / NPCDWHDS
//		listaComPaginacao(request, response, "BANQUEIRODETAPROBLOQ", "NPCDIAGY");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaida, dadosRetorno);
//
//		dadosRetorno.setCindcdtpomanut(SiteUtil.getString(dadosEntrada
//				.getCindcdtpomanut()));
//		dadosRetorno.setTipoUnidade(EnumTipoUnidade.fromCode(bookSaida
//				.getCclasfundbanqr()));
//		dadosRetorno.setIpssoapoltcexpsi(EnumSimNao.fromCode(bookSaida
//				.getCpssoapoltcexpsi()));
//		dadosRetorno.setIindcdbanqrcorsp(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrcorsp()));
//		dadosRetorno.setItrocamsgemswift(EnumSimNao.fromCode(bookSaida
//				.getCtrocamsgemswift()));
//		dadosRetorno.setIindcdbanqrscrtz(EnumSimNao.fromCode(bookSaida
//				.getCindcdbanqrscrtz()));
//		dadosRetorno.setIbanqrscrtzprinc(EnumSimNao.fromCode(bookSaida
//				.getCbanqrscrtzprinc()));
//		dadosRetorno.setIindcdconvecmbio(EnumSimNao.fromCode(bookSaida
//				.getCindcdconvecmbio()));
//		dadosRetorno.setIcindcdbloqueado(EnumSimNao.fromCode(bookSaida
//				.getCindcdbloqueado()));
//		dadosRetorno.setIcindcdpapelativo(EnumSimNao.fromCode(bookSaida
//				.getCindcdpapelativo()));
//		dadosRetorno.setIbanqrhedge(EnumSimNaoStr.fromCode(bookSaida
//				.getBanqrhedge()));
//		dadosRetorno.setDinicscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDinicscrtzbanqr()));
//		dadosRetorno.setDfimscrtzbanqrformated(SiteUtil
//				.stringDataMainframeToWeb(bookSaida.getDfimscrtzbanqr()));
//
//		// Formata o CNPJ para exibição na tela.
//		dadosRetorno.setCnpjFormatado(SiteUtil.formatarCPFCCNPJ(
//				bookSaida.getCcpfcnpj(), bookSaida.getCflialcnpj(),
//				bookSaida.getCctrlcpfcnpj()));
//
//		// Formata o CNPJ para exibição correta no componente na tela.
//		dadosRetorno.setCnpj(SiteUtil.formatarCnpjComponente(
//				dadosRetorno.getCnpj(), bookSaida.getCcpfcnpj(),
//				bookSaida.getCflialcnpj(), bookSaida.getCctrlcpfcnpj()));
//
//		// trata a mensagem de retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Percorre apenas o itens válidos contidos na lista de Contas
//		for (int i = 0; i < bookSaida.getQtdeconta(); i++) {
//
//			Npcdwhdsresponse_conta objFrom = bookSaida.getConta().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", true);
//			objTo.setTipoConta(EnumTipoConta.fromCode(objFrom
//					.getConta_cutilzctabanqr()));
//			// Recupera a descrição da moeda.
//			StringBuffer descricaoMoeda = new StringBuffer();
//			descricaoMoeda.append(objFrom.getConta_cindcdfontecons())
//					.append("-").append(objFrom.getConta_isglindcdfonte());
//			objTo.setIindcdeconmmoeda(descricaoMoeda.toString());
//
//			dadosRetorno.getListaConta().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeclearing(); i++) {
//
//			Npcdwhdsresponse_clearing objFrom = bookSaida.getClearing().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", true);
//			objTo.setPrioridade(EnumSimNao.fromCode(objFrom
//					.getClearing_ccmaracompeprior()));
//
//			dadosRetorno.getListaClearing().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Clearing
//		for (int i = 0; i < bookSaida.getQtdeendereco(); i++) {
//
//			Npcdwhdsresponse_endereco objFrom = bookSaida.getEndereco().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", true);
//
//			// Recupera a descrição da cidade
//			objTo.setImunintlcmbio(objFrom.getEndereco_imun());
//
//			// Recupera a descrição do país
//			objTo.setNomepais(objFrom.getEndereco_ipais());
//
//			objTo.setCmunintlcmbio(objFrom.getEndereco_cmun());
//
//			// Verifica se o país selecionado é "Brasil" para recuperar a
//			// descrição da UF
//			if (objFrom.getEndereco_cpais().compareTo(Numeros.NUM9) == Numeros.NUM0) {
//
//				// Formata o cep para exibição na lista.
//				objTo.setIcoduf(objFrom.getEndereco_imun());
//			}
//
//			dadosRetorno.getListaEndereco().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvodstv(); i++) {
//
//			Npcdwhdsresponse_motvodstv objFrom = bookSaida.getMotvodstv()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvodstv_", true);
//
//			dadosRetorno.getListaMotivosAtivosDireita().add(objTo);
//			dadosRetorno.getListaMotivos().add(objTo);
//		}
//
//		// Percorre apenas o itens válidos contidos na lista de Motivo de
//		// Desativação
//		for (int i = 0; i < bookSaida.getQtdemotvoblqe(); i++) {
//
//			Npcdwhdsresponse_motvoblqe objFrom = bookSaida.getMotvoblqe()
//					.get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "motvoblqe_", true);
//
//			dadosRetorno.getListaMotivosBloqueioDireita().add(objTo);
//			dadosRetorno.getListaBloqueios().add(objTo);
//		}
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * Nome: banqueiroAprovacao
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 23/12/2015 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroAprovacao(BanqueiroBaseVo dadosAprovacao) {
//
//		Banqueiroaprovacaorequest request = new Banqueiroaprovacaorequest();
//		Banqueiroaprovacaoresponse response = new Banqueiroaprovacaoresponse();
//		Npcdwdaerequest bookEntrada = new Npcdwdaerequest();
//		Npcdwdasresponse bookSaida = new Npcdwdasresponse();
//		request.setNpcdwdaerequest(bookEntrada);
//		response.setNpcdwdasresponse(bookSaida);
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosAprovacao, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAC1 - Books: NPCDWDAE / NPCDWDAS
//		listaSemPaginacao(request, response, "BANQUEIROAPROVACAO");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroRejeitar
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroRejeitar(BanqueiroBaseVo dadosRejeicao) {
//
//		Banqueirorejeitarrequest request = new Banqueirorejeitarrequest();
//		Banqueirorejeitarresponse response = new Banqueirorejeitarresponse();
//		Npcdwdberequest bookEntrada = new Npcdwdberequest();
//		Npcdwdbsresponse bookSaida = new Npcdwdbsresponse();
//		request.setNpcdwdberequest(bookEntrada);
//		response.setNpcdwdbsresponse(bookSaida);
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosRejeicao, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAD6 - Books: NPCDWDBE / NPCDWDBS
//		listaSemPaginacao(request, response, "BANQUEIROREJEITAR");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroDetAproAssoc
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 19/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueiroBaseVo banqueiroDetAproAssoc(BanqueiroBaseVo dadosEntrada) {
//
//		Banqueirodetaprassocrequest request = new Banqueirodetaprassocrequest();
//		Banqueirodetaprassocresponse response = new Banqueirodetaprassocresponse();
//		Npcdwhferequest bookEntrada = new Npcdwhferequest();
//		Npcdwhfsresponse bookSaida = new Npcdwhfsresponse();
//		request.setNpcdwhferequest(bookEntrada);
//		response.setNpcdwhfsresponse(bookSaida);
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntrada);
//
//		// executa chamada CWS - Fluxo: NPCDIAG0 - Books: NPCDWHFE / NPCDWHFS
//		listaComPaginacao(request, response, "BANQUEIRODETAPRASSOC", "NPCDIAG0");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaida, dadosRetorno);
//
//		// Formata o CNPJ para exibição na tela.
//		dadosRetorno.setCnpjFormatado(SiteUtil.formatarCPFCCNPJ(
//				bookSaida.getCdcpfcnpj(), bookSaida.getCdfilial(),
//				bookSaida.getCdctrlcpfcnpj()));
//
//		// Formata o CNPJ para exibição correta no componente na tela.
//		dadosRetorno.setCnpj(SiteUtil.formatarCnpjComponente(
//				dadosRetorno.getCnpj(), bookSaida.getCdcpfcnpj(),
//				bookSaida.getCdfilial(), bookSaida.getCdctrlcpfcnpj()));
//
//		// trata a mensagem de retorno
//		this.setMsgRetorno(response.getTexmens());
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * Nome: banqueiroDetAproAlt
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 20/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueiroBaseVo banqueiroDetAproAlt(BanqueiroBaseVo dadosEntrada) {
//		int indexJustificativaDesativacao = 0;
//		int indexJustificativaBloqueio = 0;
//
//		Banqueirodetaproaltrequest requestAntes = new Banqueirodetaproaltrequest();
//		Banqueirodetaproaltresponse responseAntes = new Banqueirodetaproaltresponse();
//		Banqueirodetaproaltrequest requestDepois = new Banqueirodetaproaltrequest();
//		Banqueirodetaproaltresponse responseDepois = new Banqueirodetaproaltresponse();
//
//		Npcdwhcerequest bookEntradaAntes = new Npcdwhcerequest();
//		Npcdwhcsresponse bookSaidaAntes = new Npcdwhcsresponse();
//
//		Npcdwhcerequest bookEntradaDepois = new Npcdwhcerequest();
//		Npcdwhcsresponse bookSaidaDepois = new Npcdwhcsresponse();
//
//		requestAntes.setNpcdwhcerequest(bookEntradaAntes);
//		responseAntes.setNpcdwhcsresponse(bookSaidaAntes);
//
//		requestDepois.setNpcdwhcerequest(bookEntradaDepois);
//		responseDepois.setNpcdwhcsresponse(bookSaidaDepois);
//
//		BanqueiroBaseVo dadosRetorno = new BanqueiroBaseVo();
//
//		dadosRetorno
//				.setListaAntesDepois(new ArrayList<BanqueirosDadosAntesDepoisVo>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntradaAntes);
//		SiteUtil.copyPropertiesObjects(dadosEntrada, bookEntradaDepois);
//
//		bookEntradaAntes.setTipoentrada("A");
//		bookEntradaDepois.setTipoentrada("D");
//
//		// executa chamada CWS - Fluxo NPCDIAGX - Books: NPCDWHCE / NPCDWHCS
//		listaSemPaginacao(requestAntes, responseAntes, "BANQUEIRODETAPROALT");
//
//		// executa chamada CWS - Fluxo NPCDIAGX - Books: NPCDWHCE / NPCDWHCS
//		listaSemPaginacao(requestDepois, responseDepois, "BANQUEIRODETAPROALT");
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(bookSaidaDepois, dadosRetorno);
//
//		dadosRetorno.setRjustfrejeicmbio(bookSaidaDepois.getRrejeiclibanqr());
//
//		dadosRetorno
//				.getListaAntesDepois()
//				.add(atribuirValoresAntesDepois(
//						bookSaidaAntes.getCidbanqrswift(),
//						bookSaidaDepois.getCidbanqrswift(), "label_swift_code"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						bookSaidaAntes.getCflialbanqrswift(),
//						bookSaidaDepois.getCflialbanqrswift(),
//						"label_swift_branch_code"));
//
//		dadosRetorno
//				.getListaAntesDepois()
//				.add(atribuirValoresAntesDepois(
//						bookSaidaAntes.getCbanqrcmbio(),
//						bookSaidaDepois.getCbanqrcmbio(), "label_cod_banqueiro"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(bookSaidaAntes.getIbanqrcmbio(),
//						bookSaidaDepois.getIbanqrcmbio(), "label_nome_banco"));
//
//		StringBuffer grupoFormatadoAntes = new StringBuffer();
//		grupoFormatadoAntes.append(bookSaidaAntes.getCtpogrpbanqr())
//				.append(" - ").append(bookSaidaAntes.getItpogrpbanqr());
//
//		StringBuffer grupoFormatadoDepois = new StringBuffer();
//		grupoFormatadoDepois.append(bookSaidaDepois.getCtpogrpbanqr())
//				.append(" - ").append(bookSaidaDepois.getItpogrpbanqr());
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(grupoFormatadoAntes,
//						grupoFormatadoDepois, "label_grupo"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumTipoUnidade.fromCode(
//								bookSaidaAntes.getCclasfundbanqr())
//								.getDescricao(),
//						EnumTipoUnidade.fromCode(
//								bookSaidaDepois.getCclasfundbanqr())
//								.getDescricao(), "label_tipo_unidade"));
//
//		StringBuffer cnpjFormatadoAntes = new StringBuffer();
//		cnpjFormatadoAntes.append(SiteUtil.formatarCPFCCNPJ(
//				bookSaidaAntes.getCcpfcnpj(), bookSaidaAntes.getCflialcnpj(),
//				bookSaidaAntes.getCctrlcpfcnpj()));
//
//		StringBuffer cnpjFormatadoDepois = new StringBuffer();
//		cnpjFormatadoDepois.append(SiteUtil.formatarCPFCCNPJ(
//				bookSaidaDepois.getCcpfcnpj(), bookSaidaDepois.getCflialcnpj(),
//				bookSaidaDepois.getCctrlcpfcnpj()));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(cnpjFormatadoAntes,
//						cnpjFormatadoDepois, "label_cnpj"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(bookSaidaAntes.getCbco(),
//						bookSaidaDepois.getCbco(),
//						"label_cod_compensacao_bacen"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(bookSaidaAntes.getCintlidfincr(),
//						bookSaidaDepois.getCintlidfincr(), "label_nif"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCpssoapoltcexpsi())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCpssoapoltcexpsi())
//								.getDescricao(), "label_pep"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCindcdbanqrcorsp())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCindcdbanqrcorsp())
//								.getDescricao(), "label_correspondente"));
//
//		dadosRetorno
//				.getListaAntesDepois()
//				.add(atribuirValoresAntesDepois(
//						bookSaidaAntes.getItpoorgnzfincr(),
//						bookSaidaDepois.getItpoorgnzfincr(), "label_tipo_orgao"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNaoStr.fromCode(bookSaidaAntes.getBanqrhedge())
//								.getDescricao(),
//						EnumSimNaoStr.fromCode(bookSaidaDepois.getBanqrhedge())
//								.getDescricao(), "label_banqueiro_hedge"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(bookSaidaAntes.getEwebbanqrcmbio(),
//						bookSaidaDepois.getEwebbanqrcmbio(), "label_web"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						bookSaidaAntes.getEbanqrcmbioswift(),
//						bookSaidaDepois.getEbanqrcmbioswift(),
//						"label_endereco_swift"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCtrocamsgemswift())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCtrocamsgemswift())
//								.getDescricao(), "label_rma"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						bookSaidaAntes.getRjustfbanqrmsgem(),
//						bookSaidaDepois.getRjustfbanqrmsgem(),
//						"label_justificativa_rma"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCindcdpapelativo())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCindcdpapelativo())
//								.getDescricao(), "label_ativo"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						bookSaidaAntes.getRjustfinatvcmbio(),
//						bookSaidaDepois.getRjustfinatvcmbio(),
//						"label_justificativa_desativacao"));
//		indexJustificativaDesativacao = dadosRetorno.getListaAntesDepois()
//				.size();
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						bookSaidaAntes.getQtdemotvoblqe() > 0 ? "Sim" : "Não",
//						bookSaidaDepois.getQtdemotvoblqe() > 0 ? "Sim" : "Não",
//						"label_bloqueado"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(bookSaidaAntes.getRjustfblqe(),
//						bookSaidaDepois.getRjustfblqe(),
//						"label_justificativa_bloqueio"));
//		indexJustificativaBloqueio = dadosRetorno.getListaAntesDepois().size();
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCindcdbanqrscrtz())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCindcdbanqrscrtz())
//								.getDescricao(), "label_banco_designado"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCbanqrscrtzprinc())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCbanqrscrtzprinc())
//								.getDescricao(), "label_designado_principal"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(
//						EnumSimNao.fromCode(
//								bookSaidaAntes.getCindcdconvecmbio())
//								.getDescricao(),
//						EnumSimNao.fromCode(
//								bookSaidaDepois.getCindcdconvecmbio())
//								.getDescricao(), "label_convenio"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(SiteUtil
//						.stringDataMainframeToWeb(bookSaidaAntes
//								.getDinicscrtzbanqr()), SiteUtil
//						.stringDataMainframeToWeb(bookSaidaDepois
//								.getDinicscrtzbanqr()),
//						"label_data_inicio_designado"));
//
//		dadosRetorno.getListaAntesDepois().add(
//				atribuirValoresAntesDepois(SiteUtil
//						.stringDataMainframeToWeb(bookSaidaAntes
//								.getDfimscrtzbanqr()), SiteUtil
//						.stringDataMainframeToWeb(bookSaidaDepois
//								.getDfimscrtzbanqr()),
//						"label_data_fim_designado"));
//
//		// Verifica se há itens na lista de contas.
//		if (bookSaidaAntes.getQtdeconta().compareTo(Numeros.NUM0) > Numeros.NUM0
//				|| bookSaidaDepois.getQtdeconta().compareTo(Numeros.NUM0) > Numeros.NUM0) {
//
//			int qtdeIteracoesContas = 0;
//			int quantidadeAntes = bookSaidaAntes.getQtdeconta();
//			int quantidadeDepois = bookSaidaDepois.getQtdeconta();
//			LogAlteracaoListaVO listaAlteracoes = null;
//			List<Integer> itensAlterados = null;
//
//			// Verifica qual é a quantidade de iterações a serem realizadas no
//			// laço "for"
//			if (bookSaidaAntes.getQtdeconta().compareTo(
//					bookSaidaDepois.getQtdeconta()) > Numeros.NUM0) {
//				qtdeIteracoesContas = quantidadeAntes;
//			} else {
//				qtdeIteracoesContas = quantidadeDepois;
//			}
//
//			listaAlteracoes = ajustarListasConta(bookSaidaAntes.getConta(),
//					quantidadeAntes, bookSaidaDepois.getConta(),
//					quantidadeDepois);
//			itensAlterados = listaAlteracoes.getItensAlterados();
//
//			// Percorre a quantidade máxima de iterações que a lista pode ter
//			// para recuperar as Contas "Antes" e
//			// "Depois"
//			for (int i = 0; i < qtdeIteracoesContas; i++) {
//				String label = SiteUtil.STRING_EMPTY;
//				String infoAntes = null;
//				String infoDepois = null;
//
//				// Verifica se foi a primeira passagem
//				if (i == 0) {
//					label = "label_conta_minusculo";
//				}
//
//				if (quantidadeAntes > i) {
//					infoAntes = listaAlteracoes.getAntes().get(i);
//				}
//
//				if (quantidadeDepois > i) {
//					infoDepois = listaAlteracoes.getDepois().get(i);
//				}
//
//				dadosRetorno.getListaAntesDepois().add(
//						atribuirValoresAntesDepois(infoAntes, infoDepois,
//								label, itensAlterados.contains(i)));
//			}
//		}
//
//		// Verifica se há itens na lista de clearing.
//		if (bookSaidaAntes.getQtdeclearing().compareTo(Numeros.NUM0) > Numeros.NUM0
//				|| bookSaidaDepois.getQtdeclearing().compareTo(Numeros.NUM0) > Numeros.NUM0) {
//
//			int qtdeIteracoesClearing = 0;
//			int quantidadeAntes = bookSaidaAntes.getQtdeclearing();
//			int quantidadeDepois = bookSaidaDepois.getQtdeclearing();
//			LogAlteracaoListaVO listaAlteracoes = null;
//			List<Integer> itensAlterados = null;
//
//			// Verifica qual é a quantidade de iterações a serem realizadas no
//			// laço "for"
//			if (bookSaidaAntes.getQtdeclearing().compareTo(
//					bookSaidaDepois.getQtdeclearing()) > Numeros.NUM0) {
//				qtdeIteracoesClearing = quantidadeAntes;
//			} else {
//				qtdeIteracoesClearing = quantidadeDepois;
//			}
//
//			listaAlteracoes = ajustarListasClearing(
//					bookSaidaAntes.getClearing(), quantidadeAntes,
//					bookSaidaDepois.getClearing(), quantidadeDepois);
//			itensAlterados = listaAlteracoes.getItensAlterados();
//
//			// Percorre a quantidade máxima de iterações que a lista pode ter
//			// para recuperar os Endereços "Antes" e
//			// "Depois"
//			for (int i = 0; i < qtdeIteracoesClearing; i++) {
//				String label = SiteUtil.STRING_EMPTY;
//				String infoAntes = null;
//				String infoDepois = null;
//
//				// Verifica se foi a primeira passagem
//				if (i == 0) {
//					label = "label_clearing";
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeAntes > i) {
//					String info = listaAlteracoes.getAntes().get(i);
//
//					// Verifica a tamanho e nulidade antes de formatar a
//					// clearing
//					if (info != null && info.length() > 2) {
//
//						infoAntes = info.substring(0, 2).concat(" - ")
//								.concat(info.substring(2));
//					} else {
//
//						infoAntes = info;
//					}
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeDepois > i) {
//					String info = listaAlteracoes.getDepois().get(i);
//
//					// Verifica a tamanho e nulidade antes de formatar a
//					// clearing
//					if (info != null && info.length() > 2) {
//
//						infoDepois = info.substring(0, 2).concat(" - ")
//								.concat(info.substring(2));
//					} else {
//
//						infoDepois = info;
//					}
//				}
//
//				dadosRetorno.getListaAntesDepois().add(
//						atribuirValoresAntesDepois(infoAntes, infoDepois,
//								label, itensAlterados.contains(i)));
//			}
//
//		}
//
//		// Verifica se há itens na lista de endereço.
//		if (bookSaidaAntes.getQtdeendereco().compareTo(Numeros.NUM0) > Numeros.NUM0
//				|| bookSaidaDepois.getQtdeendereco().compareTo(Numeros.NUM0) > Numeros.NUM0) {
//
//			int qtdeIteracoesEnderecos = 0;
//			int quantidadeAntes = bookSaidaAntes.getQtdeendereco();
//			int quantidadeDepois = bookSaidaDepois.getQtdeendereco();
//			LogAlteracaoListaVO listaAlteracoes = null;
//			List<Integer> itensAlterados = null;
//
//			// Verifica qual é a quantidade de iterações a serem realizadas no
//			// laço "for"
//			if (bookSaidaAntes.getQtdeendereco().compareTo(
//					bookSaidaDepois.getQtdeendereco()) > Numeros.NUM0) {
//				qtdeIteracoesEnderecos = quantidadeAntes;
//			} else {
//				qtdeIteracoesEnderecos = quantidadeDepois;
//			}
//
//			listaAlteracoes = ajustarListasEndereco(
//					bookSaidaAntes.getEndereco(), quantidadeAntes,
//					bookSaidaDepois.getEndereco(), quantidadeDepois);
//			itensAlterados = listaAlteracoes.getItensAlterados();
//
//			// Percorre a quantidade máxima de iterações que a lista pode ter
//			// para recuperar os Endereços "Antes" e
//			// "Depois"
//			for (int i = 0; i < qtdeIteracoesEnderecos; i++) {
//				String label = SiteUtil.STRING_EMPTY;
//				String infoAntes = null;
//				String infoDepois = null;
//
//				// Verifica se foi a primeira passagem
//				if (i == 0) {
//					label = "label_endereco";
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeAntes > i) {
//					infoAntes = listaAlteracoes.getAntes().get(i);
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeDepois > i) {
//					infoDepois = listaAlteracoes.getDepois().get(i);
//				}
//
//				dadosRetorno.getListaAntesDepois().add(
//						atribuirValoresAntesDepois(infoAntes, infoDepois,
//								label, itensAlterados.contains(i)));
//			}
//
//		}
//
//		// Verifica se há itens na lista de motivos.
//		if (bookSaidaAntes.getQtdemotvoblqe().compareTo(Numeros.NUM0) > Numeros.NUM0
//				|| bookSaidaDepois.getQtdemotvoblqe().compareTo(Numeros.NUM0) > Numeros.NUM0) {
//
//			int qtdeIteracoesMotivosBloqueio = 0;
//			int quantidadeAntes = bookSaidaAntes.getQtdemotvoblqe();
//			int quantidadeDepois = bookSaidaDepois.getQtdemotvoblqe();
//			LogAlteracaoListaVO listaAlteracoes = null;
//			List<Integer> itensAlterados = null;
//
//			// Verifica qual é a quantidade de iterações a serem realizadas no
//			// laço "for"
//			if (bookSaidaAntes.getQtdemotvoblqe().compareTo(
//					bookSaidaDepois.getQtdemotvoblqe()) > Numeros.NUM0) {
//				qtdeIteracoesMotivosBloqueio = quantidadeAntes;
//			} else {
//				qtdeIteracoesMotivosBloqueio = quantidadeDepois;
//			}
//
//			listaAlteracoes = ajustarListasMotivoBloqueio(
//					bookSaidaAntes.getMotvoblqe(), quantidadeAntes,
//					bookSaidaDepois.getMotvoblqe(), quantidadeDepois);
//			itensAlterados = listaAlteracoes.getItensAlterados();
//
//			// Percorre a quantidade máxima de iterações que a lista pode ter
//			// para recuperar os motivos "Antes" e
//			// "Depois"
//			for (int i = 0; i < qtdeIteracoesMotivosBloqueio; i++) {
//				String label = SiteUtil.STRING_EMPTY;
//				String infoAntes = null;
//				String infoDepois = null;
//
//				// Verifica se foi a primeira passagem
//				if (i == 0) {
//					label = "label_motivos_bloqueio";
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeAntes > i) {
//					infoAntes = listaAlteracoes.getAntes().get(i);
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeDepois > i) {
//					infoDepois = listaAlteracoes.getDepois().get(i);
//				}
//
//				dadosRetorno.getListaAntesDepois().add(
//						indexJustificativaBloqueio++,
//						atribuirValoresAntesDepois(infoAntes, infoDepois,
//								label, itensAlterados.contains(i)));
//			}
//		}
//
//		// Verifica se há itens na lista de motivos.
//		if (bookSaidaAntes.getQtdemotvo().compareTo(Numeros.NUM0) > Numeros.NUM0
//				|| bookSaidaDepois.getQtdemotvo().compareTo(Numeros.NUM0) > Numeros.NUM0) {
//
//			int qtdeIteracoesMotivos = 0;
//			int quantidadeAntes = bookSaidaAntes.getQtdemotvo();
//			int quantidadeDepois = bookSaidaDepois.getQtdemotvo();
//			LogAlteracaoListaVO listaAlteracoes = null;
//			List<Integer> itensAlterados = null;
//
//			// Verifica qual é a quantidade de iterações a serem realizadas no
//			// laço "for"
//			if (bookSaidaAntes.getQtdemotvo().compareTo(
//					bookSaidaDepois.getQtdemotvo()) > Numeros.NUM0) {
//				qtdeIteracoesMotivos = quantidadeAntes;
//			} else {
//				qtdeIteracoesMotivos = quantidadeDepois;
//			}
//
//			listaAlteracoes = ajustarListasMotivo(
//					bookSaidaAntes.getMotvorest(), quantidadeAntes,
//					bookSaidaDepois.getMotvorest(), quantidadeDepois);
//			itensAlterados = listaAlteracoes.getItensAlterados();
//
//			// Percorre a quantidade máxima de iterações que a lista pode ter
//			// para recuperar os motivos "Antes" e
//			// "Depois"
//			for (int i = 0; i < qtdeIteracoesMotivos; i++) {
//				String label = SiteUtil.STRING_EMPTY;
//				String infoAntes = null;
//				String infoDepois = null;
//
//				// Verifica se foi a primeira passagem
//				if (i == 0) {
//					label = "label_motivos_desativacao";
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeAntes > i) {
//					infoAntes = listaAlteracoes.getAntes().get(i);
//				}
//
//				// Verifica se há item para ser buscado
//				if (quantidadeDepois > i) {
//					infoDepois = listaAlteracoes.getDepois().get(i);
//				}
//
//				dadosRetorno.getListaAntesDepois().add(
//						indexJustificativaDesativacao++,
//						atribuirValoresAntesDepois(infoAntes, infoDepois,
//								label, itensAlterados.contains(i)));
//			}
//		}
//
//		return dadosRetorno;
//	}
//
//	/**
//	 * Nome: banqueiroCliCaduList
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 22/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public List<BanqueirosDadosSpecVo> banqueiroCliCaduList(
//			BanqueirosDadosSpecVo dadosCliente) {
//
//		Banqueiroclicadulistrequest request = new Banqueiroclicadulistrequest();
//		Banqueiroclicadulistresponse response = new Banqueiroclicadulistresponse();
//		Npcdwhberequest bookEntrada = new Npcdwhberequest();
//		Npcdwhbsresponse bookSaida = new Npcdwhbsresponse();
//		request.setNpcdwhberequest(bookEntrada);
//		response.setNpcdwhbsresponse(bookSaida);
//		Integer qtdeOcorrLista = null;
//
//		List<BanqueirosDadosSpecVo> lista = new ArrayList<BanqueirosDadosSpecVo>();
//
//		// Pesquisa
//		if (dadosCliente.getCdcpfcnpj() != null
//				&& dadosCliente.getCdcpfcnpj() > 0) {
//			bookEntrada
//					.setTipopesquisa(dadosCliente.getCdfilial() > 0 ? Numeros.DOIS
//							: Numeros.UM);
//			bookEntrada.setCdcpfcnpj(dadosCliente.getCdcpfcnpj());
//			bookEntrada.setCdfilial(dadosCliente.getCdfilial());
//			bookEntrada.setCdctrlcpfcnpj(dadosCliente.getCdctrlcpfcnpj());
//		} else {
//			// Monta a área de entrada
//			bookEntrada.setTipopesquisa(Numeros.TRES);
//			bookEntrada.setNmnomecliente(SiteUtil.getString(dadosCliente
//					.getNmnomecliente()));
//		}
//
//		// executa chamaa CWS - Fluxo NPCDIAGW - Books: NPCDWHBE / NPCDWHBS
//		listaSemPaginacao(request, response, "BANQUEIROCLICADULIST");
//
//		// trata retorno
//		setMsgRetorno(response.getTexmens());
//		qtdeOcorrLista = response.getNpcdwhbsresponse().getQtdeocorr();
//
//		// carrega lista de retorno
//		for (int i = 0; i < qtdeOcorrLista; i++) {
//
//			Npcdwhbsresponse_lista objFrom = response.getNpcdwhbsresponse()
//					.getLista().get(i);
//			BanqueirosDadosSpecVo objTo = new BanqueirosDadosSpecVo();
//
//			// Copia os valores das propriedades com o mesmo nome
//			// automaticamente
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
//
//			lista.add(objTo);
//		}
//
//		return lista;
//	}
//
//	/**
//	 * Nome: banqueiroRevisarManu
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroRevisarManu(BanqueiroBaseVo dadosRevisao) {
//
//		Banqueirorevisarmanurequest request = new Banqueirorevisarmanurequest();
//		Banqueirorevisarmanuresponse response = new Banqueirorevisarmanuresponse();
//		Npcdwdeerequest bookEntrada = new Npcdwdeerequest();
//		Npcdwdesresponse bookSaida = new Npcdwdesresponse();
//		request.setNpcdwdeerequest(bookEntrada);
//		response.setNpcdwdesresponse(bookSaida);
//
//		bookEntrada.setConta(new ArrayList<Npcdwdeerequest_conta>());
//		bookEntrada.setClearing(new ArrayList<Npcdwdeerequest_clearing>());
//		bookEntrada.setEndereco(new ArrayList<Npcdwdeerequest_endereco>());
//		bookEntrada.setMotivo(new ArrayList<Npcdwdeerequest_motivo>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosRevisao, bookEntrada);
//
//		bookEntrada.setDinicscrtzbanqr(SiteUtil.dataWebToMainframe(dadosRevisao
//				.getDinicscrtzbanqr()));
//		bookEntrada.setDfimscrtzbanqr(SiteUtil.dataWebToMainframe(dadosRevisao
//				.getDfimscrtzbanqr()));
//
//		String cnpj = SiteUtil.removeNaoNumericos(dadosRevisao.getCnpj()
//				.toString());
//
//		// Verifica o tamanho do cnpj para recuperar o valor de cada campo via
//		// de substring.
//		if (!cnpj.isEmpty() && cnpj.length() == Numeros.CATORZE) {
//			bookEntrada.setCcpfcnpj(SiteUtil.getInt(cnpj.substring(0,
//					cnpj.length() - 6)));
//			bookEntrada.setCflialcnpj(SiteUtil.getInt(dadosRevisao.getCnpj()
//					.getCnpjCampo4()));
//			bookEntrada.setCctrlcpfcnpj(SiteUtil.getInt(dadosRevisao.getCnpj()
//					.getCnpjCampo5()));
//		} else {
//			bookEntrada.setCcpfcnpj(Numeros.NUM0);
//			bookEntrada.setCflialcnpj(Numeros.NUM0);
//			bookEntrada.setCctrlcpfcnpj(Numeros.NUM0);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Contas.
//		bookEntrada.setQtdeconta(SiteUtil.getInt(dadosRevisao.getListaConta()
//				.size()));
//
//		// Popula a lista de Contas
//		for (BanqueirosDadosSpecVo objFrom : dadosRevisao.getListaConta()) {
//
//			Npcdwdeerequest_conta objTo = new Npcdwdeerequest_conta();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "conta_", false);
//
//			bookEntrada.getConta().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista Clearing .
//		bookEntrada.setQtdeclearing(SiteUtil.getInt(dadosRevisao
//				.getListaClearing().size()));
//
//		// Popula a lista de Clearing.
//		for (BanqueirosDadosSpecVo objFrom : dadosRevisao.getListaClearing()) {
//
//			Npcdwdeerequest_clearing objTo = new Npcdwdeerequest_clearing();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "clearing_", false);
//
//			bookEntrada.getClearing().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Endereços.
//		bookEntrada.setQtdeendereco(SiteUtil.getInt(dadosRevisao
//				.getListaEndereco().size()));
//
//		// Popula a lista de Endereços.
//		for (BanqueirosDadosSpecVo objFrom : dadosRevisao.getListaEndereco()) {
//
//			Npcdwdeerequest_endereco objTo = new Npcdwdeerequest_endereco();
//
//			SiteUtil.copyPropertiesObjects(objFrom, objTo, "endereco_", false);
//
//			bookEntrada.getEndereco().add(objTo);
//		}
//
//		// Seta a quantidade de ocorrências da lista de Motivos.
//		bookEntrada.setQtdemotivo(SiteUtil.getInt(dadosRevisao
//				.getListaMotivosAtivosDireita().size()));
//
//		// Popula a lista de Motivos
//		for (BanqueirosDadosSpecVo objFrom : dadosRevisao
//				.getListaMotivosAtivosDireita()) {
//
//			Npcdwdeerequest_motivo objTo = new Npcdwdeerequest_motivo();
//			objTo.setMotivo_ntpomotvorest(objFrom.getNtpomotvodstv());
//
//			bookEntrada.getMotivo().add(objTo);
//		}
//
//		// executa chamada CWS - Fluxo NPCDIAD7 - Books: NPCDWDEE / NPCDWDES
//		listaSemPaginacao(request, response, "BANQUEIROREVISARMANU");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroRevisarBloq
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroRevisarBloq(BanqueiroBaseVo dadosRevisao) {
//
//		Banqueirorevisarbloqrequest request = new Banqueirorevisarbloqrequest();
//		Banqueirorevisarbloqresponse response = new Banqueirorevisarbloqresponse();
//		Npcdwhgerequest bookEntrada = new Npcdwhgerequest();
//		Npcdwhgsresponse bookSaida = new Npcdwhgsresponse();
//		request.setNpcdwhgerequest(bookEntrada);
//		response.setNpcdwhgsresponse(bookSaida);
//
//		bookEntrada.setLista(new ArrayList<Npcdwhgerequest_lista>());
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosRevisao, bookEntrada);
//		bookEntrada.setCunicpssoacmbio(SiteUtil.getLong(dadosRevisao
//				.getCbanqrcmbio()));
//		bookEntrada.setRrejeiclibanqr(dadosRevisao.getRrejeiclibanqr());
//
//		// Verifica o tipo de manutenção.
//		if (dadosRevisao.getCindcdtpomanut().equals(SiteUtil.STRING_P)) {
//			// Adiciona o indicar de bloqueio (1)
//			bookEntrada.setCindcdbloqueado(Numeros.UM);
//
//			// Seta a quantidade de ocorrências da lista de Motivos de bloqueio.
//			bookEntrada.setQtdeocorr(SiteUtil.getInt(dadosRevisao
//					.getListaMotivosBloqueioDireita().size()));
//
//			// Popula a lista de Contas
//			for (BanqueirosDadosSpecVo objFrom : dadosRevisao
//					.getListaMotivosBloqueioDireita()) {
//
//				Npcdwhgerequest_lista objTo = new Npcdwhgerequest_lista();
//
//				objTo.setLista_ntpomotvorest(objFrom.getNtpomotvoblqe());
//
//				bookEntrada.getLista().add(objTo);
//			}
//		} else {
//			// Adiciona o indicar de desbloqueio (2)
//			bookEntrada.setCindcdbloqueado(Numeros.DOIS);
//			bookEntrada.setQtdeocorr(Numeros.NUM0);
//		}
//
//		// executa chamada CWS - Fluxo NPCDIAG1 - Books: NPCDWHGE / NPCDWHGS
//		listaSemPaginacao(request, response, "BANQUEIROREVISARBLOQ");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroRevisarAsso
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroRevisarAsso(BanqueiroBaseVo dadosRevisao) {
//
//		Banqueirorevisarassorequest request = new Banqueirorevisarassorequest();
//		Banqueirorevisarassoresponse response = new Banqueirorevisarassoresponse();
//		Npcdwhherequest bookEntrada = new Npcdwhherequest();
//		Npcdwhhsresponse bookSaida = new Npcdwhhsresponse();
//		request.setNpcdwhherequest(bookEntrada);
//		response.setNpcdwhhsresponse(bookSaida);
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosRevisao, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAG2 - Books: NPCDWHHE / NPCDWHHS
//		listaSemPaginacao(request, response, "BANQUEIROREVISARASSO");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: banqueiroExcluirManu
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public String banqueiroExcluirManu(BanqueiroBaseVo dadosExclusao) {
//
//		Banqueiroexcluirmanurequest request = new Banqueiroexcluirmanurequest();
//		Banqueiroexcluirmanuresponse response = new Banqueiroexcluirmanuresponse();
//		Npcdwdferequest bookEntrada = new Npcdwdferequest();
//		Npcdwdfsresponse bookSaida = new Npcdwdfsresponse();
//		request.setNpcdwdferequest(bookEntrada);
//		response.setNpcdwdfsresponse(bookSaida);
//
//		// Copia os valores das propriedades com o mesmo nome automaticamente
//		SiteUtil.copyPropertiesObjects(dadosExclusao, bookEntrada);
//
//		// executa chamada CWS - Fluxo NPCDIAD8 - Books: NPCDWDFE / NPCDWDFS
//		listaSemPaginacao(request, response, "BANQUEIROEXCLUIRMANU");
//
//		return response.getTexmens();
//	}
//
//	/**
//	 * Nome: consultarSolicitacaoPendente
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 23/02/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public void consultarSolicitacaoPendente(Long cunicpssoacmbio, Long cpssoa) {
//		Clicbioconspendenciarequest request = new Clicbioconspendenciarequest();
//		Clicbioconspendenciaresponse response = new Clicbioconspendenciaresponse();
//		Npcdwejerequest entrada = new Npcdwejerequest();
//		Npcdwejsresponse saida = new Npcdwejsresponse();
//
//		entrada.setCunicpssoacmbio(cunicpssoacmbio);
//		entrada.setCpssoa(cpssoa);
//
//		request.setNpcdwejerequest(entrada);
//		response.setNpcdwejsresponse(saida);
//
//		// Consultar se há solicitação pendente - Fluxo: NPCDIAEY - Books:
//		// NPCDWEJE / NPCDWEJS
//		listaSemPaginacao(request, response, "CLICBIOCONSPENDENCIA");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//	}
//
//	/**
//	 * Nome: atribuirValoresAntesDepois
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 20/01/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public BanqueirosDadosAntesDepoisVo atribuirValoresAntesDepois(
//			Object dadosAntes, Object dadosDepois, String descricao) {
//
//		BanqueirosDadosAntesDepoisVo dadosAntesDepois = new BanqueirosDadosAntesDepoisVo();
//		dadosAntesDepois.setAntes(SiteUtil.nullToString(dadosAntes));
//		dadosAntesDepois.setDepois(SiteUtil.nullToString(dadosDepois));
//		dadosAntesDepois.setDescricao(SiteUtil.getFacesMessage(descricao));
//		dadosAntesDepois.setExibirItemAlterado(SiteUtil
//				.compararIgualdadeValorCampos(dadosAntes, dadosDepois));
//
//		return dadosAntesDepois;
//	}
//
//	/**
//	 * Nome: atribuirValoresAntesDepois
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private BanqueirosDadosAntesDepoisVo atribuirValoresAntesDepois(
//			Object dadosAntes, Object dadosDepois, String descricao,
//			boolean exibirItemAlterado) {
//
//		BanqueirosDadosAntesDepoisVo dadosAntesDepois = atribuirValoresAntesDepois(
//				dadosAntes, dadosDepois, descricao);
//
//		dadosAntesDepois.setExibirItemAlterado(exibirItemAlterado);
//
//		return dadosAntesDepois;
//	}
//
//	/**
//	 * Nome: ajustarListasConta
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private LogAlteracaoListaVO ajustarListasConta(
//			List<Npcdwhcsresponse_conta> listaAntes, int quantidadeAntes,
//			List<Npcdwhcsresponse_conta> listaDepois, int quantidadeDepois) {
//
//		LogAlteracaoListaVO retornoAntesDepois = new LogAlteracaoListaVO();
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeAntes; i++) {
//			retornoAntesDepois.getAntes().add(
//					listaAntes.get(i).getConta_contalista());
//		}
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeDepois; i++) {
//			retornoAntesDepois.getDepois().add(
//					listaDepois.get(i).getConta_contalista());
//		}
//
//		Collections.sort(retornoAntesDepois.getAntes());
//		Collections.sort(retornoAntesDepois.getDepois());
//
//		return retornoAntesDepois;
//	}
//
//	/**
//	 * Nome: ajustarListasClearing
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private LogAlteracaoListaVO ajustarListasClearing(
//			List<Npcdwhcsresponse_clearing> listaAntes, int quantidadeAntes,
//			List<Npcdwhcsresponse_clearing> listaDepois, int quantidadeDepois) {
//
//		LogAlteracaoListaVO retornoAntesDepois = new LogAlteracaoListaVO();
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeAntes; i++) {
//			retornoAntesDepois.getAntes().add(
//					listaAntes.get(i).getClearing_clearinglista());
//		}
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeDepois; i++) {
//			retornoAntesDepois.getDepois().add(
//					listaDepois.get(i).getClearing_clearinglista());
//		}
//
//		Collections.sort(retornoAntesDepois.getAntes());
//		Collections.sort(retornoAntesDepois.getDepois());
//
//		return retornoAntesDepois;
//	}
//
//	/**
//	 * Nome: ajustarListasEndereco
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private LogAlteracaoListaVO ajustarListasEndereco(
//			List<Npcdwhcsresponse_endereco> listaAntes, int quantidadeAntes,
//			List<Npcdwhcsresponse_endereco> listaDepois, int quantidadeDepois) {
//
//		LogAlteracaoListaVO retornoAntesDepois = new LogAlteracaoListaVO();
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeAntes; i++) {
//			retornoAntesDepois.getAntes().add(
//					listaAntes.get(i).getEndereco_enderecolista());
//		}
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeDepois; i++) {
//			retornoAntesDepois.getDepois().add(
//					listaDepois.get(i).getEndereco_enderecolista());
//		}
//
//		Collections.sort(retornoAntesDepois.getAntes());
//		Collections.sort(retornoAntesDepois.getDepois());
//
//		return retornoAntesDepois;
//	}
//
//	/**
//	 * Nome: ajustarListasMotivo
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 10/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private LogAlteracaoListaVO ajustarListasMotivo(
//			List<Npcdwhcsresponse_motvorest> listaAntes, int quantidadeAntes,
//			List<Npcdwhcsresponse_motvorest> listaDepois, int quantidadeDepois) {
//
//		LogAlteracaoListaVO retornoAntesDepois = new LogAlteracaoListaVO();
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeAntes; i++) {
//			retornoAntesDepois.getAntes().add(
//					listaAntes.get(i).getMotvorest_motvorestlista());
//		}
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeDepois; i++) {
//			retornoAntesDepois.getDepois().add(
//					listaDepois.get(i).getMotvorest_motvorestlista());
//		}
//
//		Collections.sort(retornoAntesDepois.getAntes());
//		Collections.sort(retornoAntesDepois.getDepois());
//
//		return retornoAntesDepois;
//	}
//
//	/**
//	 * Nome: ajustarListasMotivoBloqueio
//	 * 
//	 * Propósito:
//	 *
//	 * @param :
//	 * @return :
//	 * @throws :
//	 * @exception :
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 15/03/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	private LogAlteracaoListaVO ajustarListasMotivoBloqueio(
//			List<Npcdwhcsresponse_motvoblqe> listaAntes, int quantidadeAntes,
//			List<Npcdwhcsresponse_motvoblqe> listaDepois, int quantidadeDepois) {
//
//		LogAlteracaoListaVO retornoAntesDepois = new LogAlteracaoListaVO();
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeAntes; i++) {
//			retornoAntesDepois.getAntes().add(
//					listaAntes.get(i).getMotvoblqe_rtpomotvoblqe());
//		}
//
//		// Percorre todos os itens
//		for (int i = 0; i < quantidadeDepois; i++) {
//			retornoAntesDepois.getDepois().add(
//					listaDepois.get(i).getMotvoblqe_rtpomotvoblqe());
//		}
//
//		Collections.sort(retornoAntesDepois.getAntes());
//		Collections.sort(retornoAntesDepois.getDepois());
//
//		return retornoAntesDepois;
//	}
//
//	/**
//	 * 
//	 * Nome: banqueiroGerarLog Propósito:
//	 *
//	 * @param : <BR/>
//	 * @return :
//	 *
//	 * @throws :
//	 * 
//	 * @exception :
//	 *
//	 * @see : Referencias externas.
//	 *
//	 *      Registro de Manutenção: 19/09/2016 - Autor: BRQ - Responsavel:
//	 *      Equipe Web - Adequação ao padrão hexavision.
//	 */
//	public void banqueiroGerarLog(Long codigo) {
//
//		Banqueirogerarlogrequest request = new Banqueirogerarlogrequest();
//		Banqueirogerarlogresponse response = new Banqueirogerarlogresponse();
//		Npcdwc7erequest entrada = new Npcdwc7erequest();
//		Npcdwc7sresponse saida = new Npcdwc7sresponse();
//		request.setNpcdwc7erequest(entrada);
//		response.setNpcdwc7sresponse(saida);
//
//		// Campo não utilizado pelo MF para esta pesquisa.
//		entrada.setCbanqrcmbio(codigo);
//
//		// executa chamada CWS - Fluxo NPCDIAH0 - Books: NPCDWC7E
//		listaSemPaginacao(request, response, "BANQUEIROGERARLOG");
//
//		// trata retorno
//		this.setMsgRetorno(response.getTexmens());
//	}
}
