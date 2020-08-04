package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operacaoAditarModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Consopersiclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Consopersiclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Npccww2erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Npccww2sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Npccww2sresponse_gride;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operacaoAditarModal.IOperacaoAditarModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoAditarVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

@Named("operacaoAditarModalServiceImpl")
@RequestScoped
public class OperacaoAditarModalServiceImpl extends BaseService implements IOperacaoAditarModalService{

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 3433106710570072035L;
	
	 /**
     * Nome: getOperacoesVinculadas
     * 
     * Propósito: Retorna lista de operaçoes vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<OperacaoAditarVO> getOperacoes(OperacaoAditarVO OpVcVO) {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OperacaoAditarModalServiceImpl.getOperacoes <<<<<<<<<<<");
            
            List<OperacaoAditarVO> lista = new ArrayList<OperacaoAditarVO>();
            
            OperacaoAditarVO objTo = null;
            
            Consopersiclrequest request = new Consopersiclrequest();
            Consopersiclresponse response = new Consopersiclresponse();
            Npccww2erequest entrada = new Npccww2erequest();
            Npccww2sresponse saida = new Npccww2sresponse();
            request.setNpccww2erequest(entrada);
            response.setNpccww2sresponse(saida);
            
            entrada.setDanobase(OpVcVO.getDanobase());
            entrada.setNbletocmbioano(OpVcVO.getNumoperacao());
            
            // Executa chamada CWS - Fluxo: NPCCIAP4 - Books: NPCCWW2E / NPCCWW2S
            listaComPaginacao(request, response, "CONSOPERSICL", "NPCCIAP4");
            
            for (int i = 0; i < response.getNpccww2sresponse().getQtdeocorr(); i++) {
            	
            	Npccww2sresponse_gride objFrom = response.getNpccww2sresponse().getGride().get(i);
            	objTo = new OperacaoAditarVO();
            	
            	// Copia os valores das propriedades
            	objTo.setCcontrfinanexpor(objFrom.getGride_ccontrfinanexpor());
            	objTo.setCmoedacmbiofinan(objFrom.getGride_cmoedacmbiofinan());
            	objTo.setDfimfinanexpor(SiteUtil.trocarPontoPorBarra(objFrom.getGride_dfimfinanexpor()));
            	objTo.setVfinandevedcmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_vfinandevedcmbio()));
            	objTo.setVfinanexporcmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_vfinanexporcmbio()));
            	objTo.setNdsembcmbiotrade(objFrom.getGride_ndsembcmbiotrade());
            	
            	lista.add(objTo);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OperacaoAditarModalServiceImpl.getOperacoes <<<<<<<<<<<");
        }

    }
	
}
