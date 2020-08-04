/**
 *
 * Nome: ParticipantesServiceImpl.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 29/02/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas.Atualizartarifasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas.Atualizartarifasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas.Listartarifasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas.Listartarifasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas.Npcdwn0erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas.Npcdwn0sresponse;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.ITarifaAutomaticaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaVO;


/**
 *
 * Nome: ParticipantesServiceImpl.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 29/02/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */

@Named("tarifaAutomaticaService")
@SessionScoped
public class TarifaAutomaticaServiceImpl extends BaseService implements
		ITarifaAutomaticaService, Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 7231360475979640170L;


	/**
	 * Nome: pesquisar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public List<TarifaAutomaticaVO> pesquisar(TarifaAutomaticaFiltroVO filtro) {
		List<TarifaAutomaticaVO> tarifasAuto = new ArrayList<TarifaAutomaticaVO>();

		Listartarifasrequest request = new Listartarifasrequest();
		Listartarifasresponse response = new Listartarifasresponse();

		Npcdwn0erequest input = new Npcdwn0erequest();
		Npcdwn0sresponse output = new Npcdwn0sresponse();

		// Obtem o index do tra�o e adiciona mais dois para compensar o pr�prio
		// tra�o e o espa�o
		int dashIndex = filtro.getRprodtservc().indexOf("-") + 2;

		input.setCprodtservc(filtro.getCprodtservc());
		input.setRprodtservc(filtro.getRprodtservc().substring(dashIndex));
		input.setCoper(filtro.getCoper());
		input.setRoper(filtro.getRoper());

		request.setNpcdwn0erequest(input);
		response.setNpcdwn0sresponse(output);

		// Executa chamada CWS - Fluxo: NPCDIAHV - Books: NPCDWN0E / NPCDWN0S
		List<Listartarifasresponse> pages = autoPaginate(request, response,
				"LISTARTARIFAS", "NPCDIAHV");

		// trata retorno
		this.setMsgRetorno(response.getTexmens());

		// Percorre todas as paginas obtidas do MF
		for (Listartarifasresponse page : pages) {
			Npcdwn0sresponse currentOutput = page.getNpcdwn0sresponse();

			// Percorre todos os itens da lista
			for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
				// Verifica se o item da lista � uma tarifa autom�tica
				TarifaAutomaticaVO tarifa = new TarifaAutomaticaVO();
				tarifa.setCprodtservc(currentOutput.getLista().get(i).getLista_cprodtservc());
				tarifa.setRprodtservc(currentOutput.getLista().get(i).getLista_rprodtservc());
				tarifa.setCoper(currentOutput.getLista().get(i).getLista_coper());
				tarifa.setRoper(currentOutput.getLista().get(i).getLista_roper());
				tarifa.setCcondceconc(currentOutput.getLista().get(i).getLista_ccondceconc());
				tarifa.setIcondceconc(currentOutput.getLista().get(i).getLista_icondceconc());
				tarifa.setIndaut(currentOutput.getLista().get(i).getLista_indaut());
				tarifa.setAutomatica(tarifa.getIndaut().equalsIgnoreCase("S"));

				tarifasAuto.add(tarifa);
			}
		}

		return tarifasAuto;
	}

	@Override
	public List<TarifaAutomaticaVO> obterOperacoes(int produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TarifaAutomaticaVO> pesquisarLog(TarifaAutomaticaFiltroVO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar(List<TarifaAutomaticaVO> tarifas) {
		// TODO Auto-generated method stub
		return null;
	}
}
