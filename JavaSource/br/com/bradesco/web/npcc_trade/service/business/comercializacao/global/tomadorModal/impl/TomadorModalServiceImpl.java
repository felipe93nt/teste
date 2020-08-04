/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 23/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Npccwo9erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Npccwo9sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Npccwo9sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Tomadorlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList.Tomadorlistresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal.ITomadorModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TomadorModalServiceImpl.java
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
 * Registro  de Manutenção: 23/05/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */

@Named("tomadorModalService")
@RequestScoped
public class TomadorModalServiceImpl extends BaseService implements ITomadorModalService {

    	/**
    	* Nome: getTomadorModalList
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public List<TradeFinNegocListasVO> getTomadorModalList(String nomeTomador) {

        List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();

        TradeFinNegocListasVO objTo = null;

        Tomadorlistrequest request = new Tomadorlistrequest();
        Tomadorlistresponse response = new Tomadorlistresponse();
        Npccwo9erequest entrada = new Npccwo9erequest();
        Npccwo9sresponse saida = new Npccwo9sresponse();
        request.setNpccwo9erequest(entrada);
        response.setNpccwo9sresponse(saida);

        entrada.setTipopesquisa(EnumTradeFinance.PESQUISA_NOME_TOMADOR.getCodigo());
        entrada.setNtpopapelcmbio(EnumTradeFinance.TIPO_PAPEL_TOMADOR.getCodigo());
        entrada.setNmnomecliente(nomeTomador);

        // Executa chamada CWS - Fluxo: NPCCIAI0 - Books: NPCCWO9E / NPCCWO9S
        listaComPaginacao(request, response, "TOMADORLIST", "NPCCIAI0");

        for (int i = 0; i < response.getNpccwo9sresponse().getQtdeocorr(); i++) {

            Npccwo9sresponse_lista objFrom = response.getNpccwo9sresponse().getLista().get(i);
            objTo = new TradeFinNegocListasVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(objFrom.getLista_cdcpfcnpj(),
                            objFrom.getLista_cdfilial(), objFrom.getLista_cdctrlcpfcnpj()));
            objTo.setCunicpssoacmbiot(objFrom.getLista_cunicpssoacmbio());
            objTo.setNcunicpssoacmbiot(objFrom.getLista_nmnomecliente());
            objTo.setIciddeender(objFrom.getLista_iciddeender());
            objTo.setIpais(objFrom.getLista_ipaisgeogr());
            objTo.setCdclub(objFrom.getLista_cdclub());
            
            // Aline 05/09/2016 - AFIANCADO MODAL ( Separado para usar no serviço NPCCWZME/S
            objTo.setCdcpfcnpj(objFrom.getLista_cdcpfcnpj());
            objTo.setCdfilial(objFrom.getLista_cdfilial());
            objTo.setCdctrlcpfcnpj(objFrom.getLista_cdctrlcpfcnpj());
            
            lista.add(objTo);
        }

        return lista;
    }

}
