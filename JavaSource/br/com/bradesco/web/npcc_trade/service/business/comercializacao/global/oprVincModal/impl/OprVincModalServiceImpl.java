package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.oprVincModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Operacoesclientelistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Operacoesclientelistresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.oprVincModal.IOprVincModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

@Named("oprVincModalService")
@RequestScoped
public class OprVincModalServiceImpl extends BaseService implements IOprVincModalService {

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
    public List<TrdFinNegOperVincVO> getOperacoesVinculadas(TrdFinNegOperVincVO OpVcVO) {
    	
    	try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] OprVincModalServiceImpl.getOperacoesVinculadas <<<<<<<<<<<");
            
            List<TrdFinNegOperVincVO> lista = new ArrayList<TrdFinNegOperVincVO>();
            
            TrdFinNegOperVincVO objTo = null;
            
            Operacoesclientelistrequest request = new Operacoesclientelistrequest();
            Operacoesclientelistresponse response = new Operacoesclientelistresponse();
            Npccwwqerequest entrada = new Npccwwqerequest();
            Npccwwqsresponse saida = new Npccwwqsresponse();
            request.setNpccwwqerequest(entrada);
            response.setNpccwwqsresponse(saida);
            
            entrada.setCunicclicmbio(OpVcVO.getCunicclicmbio());
            
            if (OpVcVO.getDataPesquisa() == null || OpVcVO.getDataPesquisa().getBeginDate() == null) {
            	entrada.setDatainio("");
            } else {
            	String dtEmissaoIni = SiteUtil.dataWebToMainframe(OpVcVO.getDataPesquisa().getBeginDate());
            	entrada.setDatainio(dtEmissaoIni.equals("0") ? "" : dtEmissaoIni);
            }
            if (OpVcVO.getDataPesquisa() == null || OpVcVO.getDataPesquisa().getEndDate() == null) {
            	entrada.setDatafim("");
            } else {
            	String dtEmissaoFim = SiteUtil.dataWebToMainframe(OpVcVO.getDataPesquisa().getEndDate());
            	entrada.setDatafim(dtEmissaoFim.equals("0") ? "" : dtEmissaoFim);
            }
            
            entrada.setDanobase(OpVcVO.getDanobase());
            entrada.setNbletocmbioano(OpVcVO.getNumoperacao());
            entrada.setCprodtservc(OpVcVO.getCprodtservc());
            entrada.setCindcdeconmmoeda(OpVcVO.getCindcdeconmmoeda());
            
            // Executa chamada CWS - Fluxo: NPCCIAPC - Books: NPCCWWQE / NPCCWWQS
            listaComPaginacao(request, response, "OPERACOESCLIENTELIST", "NPCCIAPC");
            
            for (int i = 0; i < response.getNpccwwqsresponse().getQtdeocorr(); i++) {
            	
            	Npccwwqsresponse_lista objFrom = response.getNpccwwqsresponse().getLista().get(i);
            	objTo = new TrdFinNegOperVincVO();
            	
            	// Copia os valores das propriedades
            	objTo.setNbletonegoccmbio(objFrom.getLista_nbletonegoccmbio());
            	objTo.setNbletocmbioano(objFrom.getLista_nbletocmbioano());
            	objTo.setDfimnegoccmbio(objFrom.getLista_dfimnegoccmbio());
            	String dataWeb = null;
            	if (SiteUtil.isEmptyOrNull(objFrom.getLista_dfimnegoccmbio()) ||
            			objFrom.getLista_dfimnegoccmbio().contains("00000")) {
            		objTo.setDataVencimento("");
            	} else {
            		dataWeb = SiteUtil.dateTimeMainframeToWeb(objFrom.getLista_dfimnegoccmbio());
            		objTo.setDataVencimento(dataWeb.substring(0, 10));
            	}
            	objTo.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
            	objTo.setIindcdeconmmoeda(objFrom.getLista_iindcdeconmmoeda());
            	objTo.setVnegocmoedaestrg(objFrom.getLista_vnegocmoedaestrg());
            	objTo.setValorMoeda(SiteUtil.formatarValorWeb(objFrom.getLista_vnegocmoedaestrg()));
            	objTo.setCprodtservc(objFrom.getLista_cprodtservc());
            	objTo.setIprodtservc(objFrom.getLista_iprodtservc());
            	
            	lista.add(objTo);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] OprVincModalServiceImpl.getOperacoesVinculadas <<<<<<<<<<<");
        }

    }
	
}
