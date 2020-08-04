package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal.impl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg.Alterarcotacaodivergrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg.Alterarcotacaodivergresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg.Npccwzwerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg.Npccwzwsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg.Devolvercotacaodivrgrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg.Devolvercotacaodivrgresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg.Npccwkyerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg.Npccwkysresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal.DevolucaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal.IDevolverModalService;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;

/**
  * Nome: DevolverModalServiceImpl.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 17/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named("devolverModalService")
@RequestScoped
public class DevolverModalServiceImpl extends BaseService implements IDevolverModalService, Serializable{

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1986150392244889177L;

	/**
	 * 
	 * Nome: alterarCotacaoDiverg
	 * 
	 * Propósito: 
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String devolverCotacao(DevolucaoVO devolucaoVO) {
		
		Alterarcotacaodivergrequest request = new Alterarcotacaodivergrequest();
		Alterarcotacaodivergresponse response = new Alterarcotacaodivergresponse();

		Npccwzwerequest entrada = new Npccwzwerequest();
		Npccwzwsresponse saida = new Npccwzwsresponse();

		request.setNpccwzwerequest(entrada);
		response.setNpccwzwsresponse(saida);
		
		
		String textoDevolucao = devolucaoVO.getRobsbletocmbio();
		
		// Caso o cliente cole um texto que contenha quebra de linha nesta três 
		// linhas ele transforma em uma String e retira a quebra de linha. 
		textoDevolucao  = textoDevolucao.replaceAll("\r", "");
		textoDevolucao  = textoDevolucao.replaceAll("\n", "");
		textoDevolucao  = textoDevolucao.replaceAll("\t", "");
		
		entrada.setNbletonegoccmbio(devolucaoVO.getNbletonegoccmbio());
		entrada.setCsitbletocmbio(devolucaoVO.getCsitbletocmbio());  
        entrada.setCmotvobletocmbio(devolucaoVO.getCmotvobletocmbio());
        entrada.setRobsbletocmbio(textoDevolucao);
        entrada.setCtpoobsbleto(devolucaoVO.getCtpoobsbleto());
        entrada.setNseqcontrlim(devolucaoVO.getNseqcontrlim());
        entrada.setNppstapontucmbio(devolucaoVO.getNppstapontucmbio());
        entrada.setCsitbletoaprov(devolucaoVO.getCsitbletoaprov());
        
		listaSemPaginacao(request, response, "ALTERARCOTACAODIVERG");

		return response.getTexmens();


	}
	
	/**
     * 
     * Nome: devolverCotacaoDivrg
     * 
     * Propósito: 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/06/2017 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String devolverCotacaoDivrg(DevolucaoVO devolucaoVO) {
        
        Devolvercotacaodivrgrequest request = new Devolvercotacaodivrgrequest();
        Devolvercotacaodivrgresponse response = new Devolvercotacaodivrgresponse();

        Npccwkyerequest entrada = new Npccwkyerequest();
        Npccwkysresponse saida = new Npccwkysresponse();

        request.setNpccwkyerequest(entrada);
        response.setNpccwkysresponse(saida);
        
        
        String textoDevolucao = devolucaoVO.getRobsbletocmbio();
        
        // Caso o cliente cole um texto que contenha quebra de linha nesta três 
        // linhas ele transforma em uma String e retira a quebra de linha. 
        textoDevolucao  = textoDevolucao.replaceAll("\r", "");
        textoDevolucao  = textoDevolucao.replaceAll("\n", "");
        textoDevolucao  = textoDevolucao.replaceAll("\t", "");
        
        entrada.setNbletonegoccmbio(devolucaoVO.getNbletonegoccmbio());
        entrada.setCsitbletocmbio(devolucaoVO.getCsitbletocmbio());  
        entrada.setCmotvobletocmbio(devolucaoVO.getCmotvobletocmbio());
        entrada.setRobsbletocmbio(textoDevolucao);
        entrada.setCtpoobsbleto(devolucaoVO.getCtpoobsbleto());
        entrada.setNseqcontrlim(devolucaoVO.getNseqcontrlim());
        entrada.setNppstapontucmbio(devolucaoVO.getNppstapontucmbio());
        entrada.setCsitbletoaprov(devolucaoVO.getCsitbletoaprov());
        
        // Fluxo: NPCCIAHU  Books: NPCCWKYE/NPCCWKYS
        listaSemPaginacao(request, response, "DEVOLVERCOTACAODIVRG");

        return response.getTexmens();


    }

}
