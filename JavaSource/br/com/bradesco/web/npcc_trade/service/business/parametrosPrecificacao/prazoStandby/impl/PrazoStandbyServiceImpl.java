/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 01/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.impl;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt.Npccwvzerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt.Npccwvzsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt.Prazostandbyaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt.Prazostandbyaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon.Npccwvyerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon.Npccwvysresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon.Prazostandbyconrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon.Prazostandbyconresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl.Npccwvwerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl.Npccwvwsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl.Prazostandbyinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl.Prazostandbyinclresponse;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.IPrazoStandbyService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.bean.PrazoStandbyVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
 * Nome: PrazoStandbyServiceImpl.java
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
 * Registro  de Manutenção: 01/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
@Named("prazoStandbyService")
@SessionScoped
public class PrazoStandbyServiceImpl extends BaseService implements IPrazoStandbyService {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     */
    public PrazoStandbyServiceImpl() {
        super();
    }

    	/**
    	* Nome: getPrazoStandby
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/12/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public PrazoStandbyVO getPrazoStandby() {
    	String codMens = null;
    	
    	PrazoStandbyVO prazoStandbyVO = new PrazoStandbyVO();

    	Prazostandbyconrequest request = new Prazostandbyconrequest();
        Prazostandbyconresponse response = new Prazostandbyconresponse();
        Npccwvyerequest bookEntrada = new Npccwvyerequest();
        Npccwvysresponse bookSaida = new Npccwvysresponse();

        request.setNpccwvyerequest(bookEntrada);
        response.setNpccwvysresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setNparmgralcmbio(Numeros.DOIS);

        // Executa chamada CWS - Fluxo: NPCCIASG - Books: NPCCWVYE / NPCCWVYS
        listaSemPaginacao(request, response, "PRAZOSTANDBYCON");
        
    	prazoStandbyVO.setTdiamaxcredt(response.getNpccwvysresponse().getTdiamaxcredt());
    	
    	codMens = response.getCodmens();
    	
    	if (response.getNpccwvysresponse().getTdiamaxcredt() <= 0 &&
    			response.getCodmens().equals("NPCC0400")) {
    		
    		prazoStandbyVO.setCodmens(response.getCodmens());
    		prazoStandbyVO.setTexmens(response.getTexmens());
    		prazoStandbyVO.setTdiamaxcredt(null);
			
		}
    	
    	return prazoStandbyVO;
    	
    }

    	/**
    	* Nome: incluiPrazoStandby
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 10/12/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String incluiPrazoStandby(Integer pPrazo) {

    	Prazostandbyinclrequest request = new Prazostandbyinclrequest();
        Prazostandbyinclresponse response = new Prazostandbyinclresponse();
        Npccwvwerequest bookEntrada = new Npccwvwerequest();
        Npccwvwsresponse bookSaida = new Npccwvwsresponse();

        request.setNpccwvwerequest(bookEntrada);
        response.setNpccwvwsresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setTdiamaxcredt(pPrazo);
        
        // Executa chamada CWS - Fluxo NPCCIASE - Books: NPCCWVWE / NPCCWVWS
        listaSemPaginacao(request, response, "PRAZOSTANDBYINCL");
        
        return response.getTexmens();
    }

    	/**
    	* Nome: alteraPrazoStandby
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 10/12/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String alteraPrazoStandby(Integer pPrazo) {

    	Prazostandbyaltrequest request = new Prazostandbyaltrequest();
        Prazostandbyaltresponse response = new Prazostandbyaltresponse();
        Npccwvzerequest bookEntrada = new Npccwvzerequest();
        Npccwvzsresponse bookSaida = new Npccwvzsresponse();

        request.setNpccwvzerequest(bookEntrada);
        response.setNpccwvzsresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setTdiamaxcredt(pPrazo);
        
        // Executa chamada CWS - Fluxo NPCCIASF - Books: NPCCWVZE / NPCCWVZS
        listaSemPaginacao(request, response, "PRAZOSTANDBYALT");
        
        return response.getTexmens();
    	
    }
}
