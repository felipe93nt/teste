/**
 *
 * Nome: DescritivoTarifaServiceImpl.java
 * Propósito: <p> </p>
 *
 * @author :  BRADESCO S.A.<BR/>
 * Equipe : CD <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaAlt.Descritivotarifaaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaAlt.Descritivotarifaaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaAlt.Npccwanerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaExcl.Descritivotarifaexclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaExcl.Descritivotarifaexclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaExcl.Npccwaqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaIncl.Descritivotarifainclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaIncl.Descritivotarifainclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaIncl.Npccwaaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList.Descritivotarifalistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList.Descritivotarifalistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList.Npccwaterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList.Npccwatsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog.Descritivotarifalogrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog.Descritivotarifalogresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog.Npccwaxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog.Npccwaxsresponse;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.IDescritivoTarifaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean.DescritivoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 *
 * Nome: DescritivoTarifaServiceImpl.java Propósito:
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
@Named("descritivoTarifaService")
@SessionScoped
public class DescritivoTarifaServiceImpl extends BaseService implements
		IDescritivoTarifaService, Serializable {

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
	public List<DescritivoTarifaVO> pesquisar(DescritivoTarifaVO filtro) {
		List<DescritivoTarifaVO> descritivoTarifaList = new ArrayList<DescritivoTarifaVO>();

		Descritivotarifalistrequest request = new Descritivotarifalistrequest();
		Descritivotarifalistresponse response = new Descritivotarifalistresponse();

		Npccwaterequest input = new Npccwaterequest();
		Npccwatsresponse output = new Npccwatsresponse();

		input.setEcprodtservc(filtro.getCprodtservc());

		request.setNpccwaterequest(input);
		response.setNpccwatsresponse(output);

		// Executa chamada CWS - Fluxo: NPCCIAUT - Books: NPCCWATE / NPCCWATS
		List<Descritivotarifalistresponse> pages = autoPaginate(request, response,
				"DESCRITIVOTARIFALIST", "NPCCIAUT");

		// trata retorno
		this.setMsgRetorno(response.getTexmens());

		// Percorre todas as paginas obtidas do MF
		for (Descritivotarifalistresponse page : pages) {
			Npccwatsresponse currentOutput = page.getNpccwatsresponse();

			// Percorre todos os itens da lista
			for (int i = 0; i < currentOutput.getSqttarifa(); i++) {
				DescritivoTarifaVO descritivoTarifa = new DescritivoTarifaVO();
				descritivoTarifa.setCcondceconc(currentOutput.getSocorrencia().get(i)
						.getSocorrencia_sccondeconc());
				descritivoTarifa.setDccondeconc(currentOutput.getSocorrencia().get(i)
						.getSocorrencia_sdccondeconc());
				descritivoTarifa.setDalter(currentOutput.getSocorrencia().get(i)
						.getSocorrencia_sdalter());

				descritivoTarifaList.add(descritivoTarifa);
			}
		}

		return descritivoTarifaList;
	}

	/**
	 * Nome: pesquisarLog
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
	public List<DescritivoTarifaVO> pesquisarLog(DescritivoTarifaVO filtro) {
		List<DescritivoTarifaVO> tarifas = new ArrayList<DescritivoTarifaVO>();

		Descritivotarifalogrequest request = new Descritivotarifalogrequest();
		Descritivotarifalogresponse response = new Descritivotarifalogresponse();

		Npccwaxerequest input = new Npccwaxerequest();
		Npccwaxsresponse output = new Npccwaxsresponse();

		input.setEdtinici(SiteUtil.dataWebToMainframe(filtro.getDtinici()));
		input.setEdtfinal(SiteUtil.dataWebToMainframe(filtro.getDtfinal()));

		request.setNpccwaxerequest(input);
		response.setNpccwaxsresponse(output);

		// Executa chamada CWS - Fluxo: NPCCIAUU - Books: NPCCWAXE / NPCCWAXS
		listaComPaginacao(request, response, "DESCRITIVOTARIFALOG", "NPCCIAUU");

		// Percorre todos os itens da lista
		for (int i = 0; i < output.getSqttarifa(); i++) {
			DescritivoTarifaVO descritivoTarifa = new DescritivoTarifaVO();
			descritivoTarifa.setCprodtservc(output.getSocorrencia().get(i).getSocorrencia_sccondeconc());
			descritivoTarifa.setCfuncao(output.getSocorrencia().get(i).getSocorrencia_scfuncao());
			descritivoTarifa.setCprodtservc(output.getSocorrencia().get(i).getSocorrencia_sccondeconc());
			descritivoTarifa.setHinclreg(SiteUtil.stringDataMainframeToWeb(output.getSocorrencia().get(i).getSocorrencia_shinclreg()));
			//descritivoTarifa.setHinclreg(output.getSocorrencia().get(i).getSocorrencia_shinclreg());
			descritivoTarifa.setDccondeconc(output.getSocorrencia().get(i).getSocorrencia_sdccondeconc());
			descritivoTarifa.setDalter(output.getSocorrencia().get(i).getSocorrencia_sdalter());
			descritivoTarifa.setCusuarincl(output.getSocorrencia().get(i).getSocorrencia_scusuar());
			descritivoTarifa.setHmanutreg(SiteUtil.stringDataMainframeToWeb(output.getSocorrencia().get(i).getSocorrencia_shmanut()));
			//descritivoTarifa.setHmanutreg(output.getSocorrencia().get(i).getSocorrencia_shmanut());
			tarifas.add(descritivoTarifa);
		}

		return tarifas;
	}

	/**
	 * Nome: incluir
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public String incluir(DescritivoTarifaVO descritivoTarifaVO) {
		Descritivotarifainclrequest request = new Descritivotarifainclrequest();
		Descritivotarifainclresponse response = new Descritivotarifainclresponse();

		Npccwaaerequest input = new Npccwaaerequest();

		input.setCcondeconc(descritivoTarifaVO.getCcondceconc());
		input.setRcondceconccmbio(descritivoTarifaVO.getDalter());

		request.setNpccwaaerequest(input);

		// Executa chamada CWS - Fluxo: NPCCIAUP - Book: NPCCWAAE
		listaSemPaginacao(request, response, "DESCRITIVOTARIFAINCL");

		return response.getTexmens();
	}
	/**
	 * Nome: alterar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public String alterar(DescritivoTarifaVO descritivoTarifaVO) {
		Descritivotarifaaltrequest request = new Descritivotarifaaltrequest();
		Descritivotarifaaltresponse response = new Descritivotarifaaltresponse();

		Npccwanerequest input = new Npccwanerequest();

		input.setEccondeconc(descritivoTarifaVO.getCcondceconc());
		input.setEdalter(descritivoTarifaVO.getDalter());
			
		request.setNpccwanerequest(input);

		// Executa chamada CWS - Fluxo: NPCCIAUQ - Book: NPCCWANE
		listaSemPaginacao(request, response, "DESCRITIVOTARIFAALT");

		return response.getTexmens();
	}
	/**
	 * Nome: excluir
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public String excluir(DescritivoTarifaVO descritivoTarifaVO) {
		Descritivotarifaexclrequest request = new Descritivotarifaexclrequest();
		Descritivotarifaexclresponse response = new Descritivotarifaexclresponse();

		Npccwaqerequest input = new Npccwaqerequest();

		input.setEccondeconc(descritivoTarifaVO.getCcondceconc());

		request.setNpccwaqerequest(input);

		// Executa chamada CWS - Fluxo: NPCCIAUS - Book: NPCCWAQE
		listaSemPaginacao(request, response, "DESCRITIVOTARIFAEXCL");

		return response.getTexmens();
	}
}
