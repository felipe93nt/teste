package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.impl;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Consultasdivisaointrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Consultasdivisaointresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt.Npccwzlsresponse_lista2;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.IConsultasDivisaoInternacionalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ListaCotacDivInternacTotaisVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ListaCotacDivInternacVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
*
* Nome: ConsultasDivisaoInternacionalServiceImpl Propósito: Serviços para a funcionalidade <br/>
*
* Data: 13/07/2015 <br/>
* 
* @author BRQ <br/>
*         copyright Copyright (c) 2016 <br/>
*
* @version 1.0
* @see
*/
@Named("consultasDivisaoInternacionalService")
@SessionScoped
public class ConsultasDivisaoInternacionalServiceImpl  extends BaseService implements IConsultasDivisaoInternacionalService {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -850411758352128059L;

    /**
     * 
     * Nome: getListaCotacoesDivisaoInternacional
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 30/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    @Override
    public ConsultaDivInternacVO getListaCotacoesDivisaoInternacional(ConsultaDivInternacFiltroVO filtro) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] ConsultasDivisaoInternacionalServiceImpl.getListaCotacoesDivisaoInternacional | CONSULTASDIVISAOINT ------- ");

            Consultasdivisaointrequest request = new Consultasdivisaointrequest();
            Consultasdivisaointresponse response =  new Consultasdivisaointresponse();
            Npccwzlerequest entrada = new Npccwzlerequest();
            Npccwzlsresponse saida = new Npccwzlsresponse();
            request.setNpccwzlerequest(entrada);
            response.setNpccwzlsresponse(saida);
            
            entrada.setDtperini(filtro.getDtperini());
            entrada.setDtperfim(filtro.getDtperfim());
            entrada.setCprodtservc(filtro.getCprodtservc());
            entrada.setCsitbletocmbio(filtro.getCsitbletocmbio());
            entrada.setVnegocmoedaestrgi(SiteUtil.webMoedaToMainframe(filtro.getVnegocmoedaestrgi()));
            entrada.setVnegocmoedaestrgf(SiteUtil.webMoedaToMainframe(filtro.getVnegocmoedaestrgf()));
            entrada.setCtponegoccmbio(filtro.getCtponegoccmbio());
            
            ConsultaDivInternacVO retorno = new ConsultaDivInternacVO();
            
            // FLUXO: NPCCIARD BOOK: NPCCWZLE / NPCCWZLS 
            listaComPaginacao(request, response, "CONSULTASDIVISAOINT", "NPCCIARD");
            
            setMsgRetorno(response.getTexmens());
            
            ListaCotacDivInternacVO objCotacao = null;
            ListaCotacDivInternacTotaisVO objTotal = null;
            
            for (int i = 0; i < response.getNpccwzlsresponse().getQtdeocorr(); i++) {
    
                Npccwzlsresponse_lista objFrom = response.getNpccwzlsresponse().getLista().get(i);
                objCotacao = new ListaCotacDivInternacVO();
                
                objCotacao.setIrzscial(objFrom.getLista_irzscial());
                objCotacao.setDtposgmtocli(objFrom.getLista_dtposgmtocli());
                objCotacao.setDtcotacao(objFrom.getLista_dtcotacao());
                objCotacao.setDfchtobletocmbio(objFrom.getLista_dfchtobletocmbio());
                objCotacao.setNomeundorgnz(objFrom.getLista_nomeundorgnz());
                objCotacao.setEconmmoeda(objFrom.getLista_econmmoeda());
                objCotacao.setVnegocmoedaestrg(objFrom.getLista_vnegocmoedaestrg());
                objCotacao.setCprodtdesc(objFrom.getLista_cprodtdesc());
                objCotacao.setPrzmedtot(objFrom.getLista_przmedtot());
                objCotacao.setVtxspreadnegoc(objFrom.getLista_vtxspreadnegoc());
                objCotacao.setDprevtdsembcmbio(objFrom.getLista_dprevtdsembcmbio());
                objCotacao.setUnibnccst(objFrom.getLista_unibnccst());
                
                
                retorno.getListaCotacoes().add(objCotacao);
            }
            
            for (int i = 0; i < response.getNpccwzlsresponse().getQtdeocor2(); i++) {
    
                Npccwzlsresponse_lista2 objFrom = response.getNpccwzlsresponse().getLista2().get(i);
                objTotal = new ListaCotacDivInternacTotaisVO();
                
                objTotal.setIsglindcdeconm(objFrom.getLista2_isglindcdeconm());
                objTotal.setVnegocmoedatot(objFrom.getLista2_vnegocmoedatot());
                
                
                retorno.getListaTotais().add(objTotal);
            }
                    
            return retorno;

        } finally {
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] ConsultasDivisaoInternacionalServiceImpl.getListaCotacoesDivisaoInternacional | CONSULTASDIVISAOINT ------- ");
        }
        
    }

}
