package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Calcvalorescomissintrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Calcvalorescomissintresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlaerequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt.Npccwlasresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Dtvencouprazocalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Dtvencouprazocalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Npccwx6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc.Npccwx6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Flxpgtcomissinexcalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Flxpgtcomissinexcalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Npccwwmerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Npccwwmsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc.Npccwwmsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
@Named("comissaoInternaExternaModalService")
@RequestScoped
public class ComissaoInternaExternaModalServiceImpl extends BaseService implements IComissaoInternaExternaModalService {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 3515481001972109644L;

	/**
     * Nome: gerarParcelasComissaoExterna
     * 
     * Propósito: Gerar itens da lista de ComissãoExterna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public Boolean gerarParcelasComissaoExterna(TrdFinNegComissaoVO comissaoVO) {
    	
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] ComissaoInternaExternaModalServiceImpl.gerarParcelasComissaoInternaExterna | FLXPGTCOMISSINEXCALC ------- ");
            
            List<TrdFinNegParcelaVO> lista = new ArrayList<TrdFinNegParcelaVO>();
            
            TrdFinNegParcelaVO objTo = null;
            
            Flxpgtcomissinexcalcrequest request = new Flxpgtcomissinexcalcrequest();
            Flxpgtcomissinexcalcresponse response = new Flxpgtcomissinexcalcresponse();
            Npccwwmerequest entrada = new Npccwwmerequest();
            Npccwwmsresponse saida = new Npccwwmsresponse();
            request.setNpccwwmerequest(entrada);
            response.setNpccwwmsresponse(saida);
            
            if(comissaoVO.getDateComissao() != null){
            	entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(comissaoVO.getDateComissao()));
            }else{
            	entrada.setDprevtdsembcmbio(comissaoVO.getDataComissaoFormat());
            }
            entrada.setTdiafinandsemb(comissaoVO.getTdiafinandsemb());
            
            if(comissaoVO.getVnegocmoedaestrg().indexOf(",") >= 0) {
                entrada.setValoroperacao(SiteUtil.webMoedaToMainframe(comissaoVO.getVnegocmoedaestrg()));
            } else {
                entrada.setValoroperacao(comissaoVO.getVnegocmoedaestrg());
            }
            
            entrada.setPjuronegoccmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getPjuronegoccmbio()));
            entrada.setCperdcjurocmbio(comissaoVO.getCperdcjurocmbio());
            entrada.setVprevtdsembcmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVprevtdsembcmbio()));
            entrada.setVprevtcomiscmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxtotalcomis()));
            entrada.setVmincobrcomis(SiteUtil.webMoedaToMainframe(comissaoVO.getVmincobrcomis()));
            entrada.setCindcdpcobrcomis(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdfcobrcomis(comissaoVO.getCodMomentoComissao());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setCpais(comissaoVO.getCpais());
            
            // Fluxo: NPCCIAO9 - Books: NPCCWWME / NPCCWWMS
            listaComPaginacao(request, response, "FLXPGTCOMISSINEXCALC","NPCCIAO9");
            
            comissaoVO.setVprevtcomiscmbio(SiteUtil.formatarValorWeb(response.getNpccwwmsresponse().getVprevtcomiscmbio()));
            if (comissaoVO.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                return true;
            }
            
            comissaoVO.setQpcelacmbiotrade(response.getNpccwwmsresponse().getQtdeocorr());
            
            for (int i = 0; i < response.getNpccwwmsresponse().getQtdeocorr(); i++) {
            	
            	Npccwwmsresponse_lista objFrom = response.getNpccwwmsresponse().getLista().get(i);
            	objTo = new TrdFinNegParcelaVO();
            	
            	// Copia os valores das propriedades
            	
            	objTo.setNpcelacomis(objFrom.getLista_npcelacomis());
            	objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            	objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
            	objTo.setVencimentoComissao(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            	objTo.setVpcelacomiscmbio(objFrom.getLista_vpcelacomiscmbio());
            	objTo.setValorParcelaComissao(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelacomiscmbio()));
            	objTo.setVcustofincrcmbio(objFrom.getLista_vcustofincrcmbio());
            	objTo.setPjuronegoccmbio(objFrom.getLista_pjuronegoccmbio());
            	objTo.setCperdcjurocmbio(objFrom.getLista_cperdcjurocmbio());
            	
            	lista.add(objTo);
            }
            comissaoVO.setListaParcelasComissao(lista);
            
            return Boolean.TRUE;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] ComissaoInternaExternaModalServiceImpl.gerarParcelasComissaoInternaExterna | FLXPGTCOMISSINEXCALC ------- ");
        }  

    }
    
    /**
     * Nome: getComissaoInterna
     * 
     * Propósito: Gerar itens da lista de Comissão Interna
     *
     * @param :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2017 - Autor: BRQ - Responsavel: 
     */
    public Boolean getComissaoInterna(TrdFinNegComissaoVO comissaoVO, 
            TrdFinNegFluxoPagtoVO fluxoPagamento) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] ComissaoInternaExternaModalServiceImpl.getComissaoInterna | CALCVALORESCOMISSINT ------- ");
            
            List<TrdFinNegParcelaVO> lista = new ArrayList<TrdFinNegParcelaVO>();
            
            TrdFinNegParcelaVO objTo = null;
            List<Npccwlaerequest_lista> listaDesembolso = new ArrayList<Npccwlaerequest_lista>();
            
            Calcvalorescomissintrequest request = new Calcvalorescomissintrequest();
            Calcvalorescomissintresponse response = new Calcvalorescomissintresponse();
            Npccwlaerequest entrada = new Npccwlaerequest();
            Npccwlasresponse saida = new Npccwlasresponse();
            request.setNpccwlaerequest(entrada);
            response.setNpccwlasresponse(saida);
            
            TrdFinNegFluxoPagtoVO fluxoPagamentoAux = new TrdFinNegFluxoPagtoVO();
            fluxoPagamentoAux = fluxoPagamento.copy();
            
            List<TrdFinNegParcelaVO> listaParcelasFluxoPgtoAux = null;
            listaParcelasFluxoPgtoAux = formatarParcelasFluxoPagamento(fluxoPagamentoAux);
          	fluxoPagamentoAux.setListaParcelasFluxoPgto(null);
            fluxoPagamentoAux.setListaParcelasFluxoPgto(listaParcelasFluxoPgtoAux);
            
            entrada.setFuncao(comissaoVO.getFuncao());
            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomisintrn());
            entrada.setCindcdpcobrjuros(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdfcobrcotac(comissaoVO.getCodMomentoComissao());
            entrada.setVprevtdsembcmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVprevtdsembcmbio()));
            entrada.setVlxoperaccmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxoperaccmbio()));
            entrada.setVlxcomiscmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxcomiscmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getPjuronegoccmbio()));
			entrada.setQtdeocorrprinc(fluxoPagamentoAux.getQtdeocorrprinc());
			entrada.setQtdeocorrjuros(fluxoPagamentoAux.getQtdeocorrjuros());
            
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setCpais(comissaoVO.getCpais());
			entrada.setDprevtdsembcmbio(fluxoPagamentoAux.getDprevtdsembcmbio());
			entrada.setTdiafinandsemb(fluxoPagamentoAux.getTdiafinandsemb());
            entrada.setVmincobrcomis(SiteUtil.webMoedaToMainframe(comissaoVO.getVmincobrcomis()));
            
            for (Iterator<TrdFinNegParcelaVO> iterator = fluxoPagamentoAux.getListaParcelasFluxoPgto().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemFluxo = (TrdFinNegParcelaVO) iterator.next();
                Npccwlaerequest_lista itemDesembolso = new Npccwlaerequest_lista();
                
                itemDesembolso.setLista_npceladsembtrade(itemFluxo.getNpceladsembtrade());
                itemDesembolso.setLista_tdianegocpcela(itemFluxo.getTdianegocpcela());
                itemDesembolso.setLista_dvctopcelatrade(itemFluxo.getDvctopcelatrade());
                itemDesembolso.setLista_vpcelamesatrade(SiteUtil.webMoedaToMainframe(itemFluxo.getVpcelamesatrade()));
                itemDesembolso.setLista_tpparcela(itemFluxo.getTpparcela());
                
                listaDesembolso.add(itemDesembolso);
            }
            
            entrada.setQtdeocorr(listaDesembolso.size());
            entrada.setLista(listaDesembolso);
            
            // Fluxo: NPCCIAH6 - Books: NPCCWLAE / NPCCWLAS
            listaComPaginacao(request, response, "CALCVALORESCOMISSINT","NPCCIAH6");
            
            saida.getCindcdfcobrcotac();
            saida.getCindcdpcobrjuros();
            
            comissaoVO.setVprevtcomiscmbio(SiteUtil.formatarValorWeb(saida.getVprevtcomiscmbio()));
            
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwlasresponse_lista objFrom = saida.getLista().get(i);
                objTo = new TrdFinNegParcelaVO();
                
                objTo.setNpcelacomis(objFrom.getLista_npceladsembtrade());
                objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
                objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
                objTo.setVencimentoComissao(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
                
                objTo.setVpcelacomiscmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                objTo.setVpcelamesatrade(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                objTo.setValorParcelaComissao(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                
                lista.add(objTo);
            }
            
            comissaoVO.setQpcelacmbiotrade(saida.getQtdeocorr());
            comissaoVO.setListaParcelasComissao(lista);
            
            return Boolean.TRUE;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] ComissaoInternaExternaModalServiceImpl.getComissaoInterna | CALCVALORESCOMISSINT ------- ");
        }  

    }
    
	public List<TrdFinNegParcelaVO> formatarParcelasFluxoPagamento(TrdFinNegFluxoPagtoVO pFluxoPagamento) {
    	List<TrdFinNegParcelaVO> listaPrinc = new ArrayList<TrdFinNegParcelaVO>();
    	//List<TrdFinNegParcelaVO> listaJuros = new ArrayList<TrdFinNegParcelaVO>();
    	
    	List<TrdFinNegParcelaVO> fluxoPagamentoAux = pFluxoPagamento.getListaParcelasFluxoPgto();

    	TrdFinNegParcelaVO objTo = null;
    	for (int i = 0; i < fluxoPagamentoAux.size(); i++) {
    		TrdFinNegParcelaVO objFrom = fluxoPagamentoAux.get(i);
    		objTo = new TrdFinNegParcelaVO();
    		
    		if (objFrom.getTpparcela().equals("P")) {
    			objTo.setTpparcela("P");
        		objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
        		objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
        		objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
        		objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
        		objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
        		objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
        		objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));

        		listaPrinc.add(objTo);
        		
        		if (objFrom.getValorJurosParcelaFluxoPgto() != null && pFluxoPagamento.getCodJurosPeriodicidade() != 14) {
		    		objTo = new TrdFinNegParcelaVO();
		
		    		objTo.setTpparcela("J");
		    		objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
		    		objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
		    		objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
		    		objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
		    		objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
		    		objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
		    		objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
		    		
		    		listaPrinc.add(objTo);
        		}
			} else {
        		objTo = new TrdFinNegParcelaVO();

        		objTo.setTpparcela("J");
        		objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
        		objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
        		objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
        		objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
        		objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
        		objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
        		objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));

        		listaPrinc.add(objTo);
			}
    	}
    	int numeroParcela = 1;
    	for (int i = 0; i < listaPrinc.size(); i++) {
    		listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
    		numeroParcela++;			
    	}    	
        return listaPrinc;
	}

	/**
     * 
    	* Nome: calcularDataVencimentoOuPrazo
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 19/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void  calcularDataVencimentoOuPrazo(TrdFinNegComissaoVO flxPgtVO, TrdFinNegParcelaVO irregularVO) {

        Dtvencouprazocalcrequest request = new Dtvencouprazocalcrequest();
        Dtvencouprazocalcresponse response = new Dtvencouprazocalcresponse();
        Npccwx6erequest entrada = new Npccwx6erequest();
        Npccwx6sresponse saida = new Npccwx6sresponse();
        request.setNpccwx6erequest(entrada);
        response.setNpccwx6sresponse(saida);

        entrada.setCpais(flxPgtVO.getCpais());
        entrada.setDprevtdsembcmbio(SiteUtil.stringDataWebToMainframe(irregularVO.getVencimentoComissao()));
        entrada.setDvctopcelatrade(SiteUtil.dataWebToMainframe(irregularVO.getDateVctopcelatrade()));
        entrada.setTdiaprzooper(irregularVO.getTdianegocpcela());

        // Fluxo: NPCCIAPL - Books: NPCCWX6E / NPCCWX6S
        listaSemPaginacao(request, response, "DTVENCOUPRAZOCALC");

        irregularVO.setTdianegocpcela(response.getNpccwx6sresponse().getTdiaprzooper());
        irregularVO.setDvctopcelatrade(response.getNpccwx6sresponse().getDvctopcelatrade());
        irregularVO.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(response.
                        getNpccwx6sresponse().getDvctopcelatrade()));
        
        irregularVO.setMensagem(null);
        if(response.getCodmens().equals("NPCC0901") 
                || response.getCodmens().equals("NPCC0902") 
                || response.getCodmens().equals("NPCC0903")) {
            irregularVO.setMensagem(response.getTexmens());
        }
    }

    /**
     * Nome: getComissaoInterna
     * 
     * Propósito: Gerar itens da lista de Comissão Interna
     *
     * @param :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2017 - Autor: BRQ - Responsavel: 
     */
    public Boolean calculoJuros(TrdFinNegComissaoVO comissaoVO, TrdFinNegFluxoPagtoVO fluxoPagamento, String taxaDeJuros) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] ComissaoInternaExternaModalServiceImpl.getComissaoInterna | CALCVALORESCOMISSINT ------- ");
            
            List<TrdFinNegParcelaVO> lista = new ArrayList<TrdFinNegParcelaVO>();
            
            TrdFinNegParcelaVO objTo = null;
            List<Npccwlaerequest_lista> listaDesembolso = new ArrayList<Npccwlaerequest_lista>();
            
            Calcvalorescomissintrequest request = new Calcvalorescomissintrequest();
            Calcvalorescomissintresponse response = new Calcvalorescomissintresponse();
            Npccwlaerequest entrada = new Npccwlaerequest();
            Npccwlasresponse saida = new Npccwlasresponse();
            request.setNpccwlaerequest(entrada);
            response.setNpccwlasresponse(saida);
            
            TrdFinNegFluxoPagtoVO fluxoPagamentoAux = new TrdFinNegFluxoPagtoVO();
            fluxoPagamentoAux = fluxoPagamento.copy();
            
            List<TrdFinNegParcelaVO> listaParcelasFluxoPgtoAux = null;
            if (fluxoPagamento.getCfluxoliqdcprinc().equals(fluxoPagamento.getCodJurosPeriodicidade())) {
            	listaParcelasFluxoPgtoAux = formatarParcelasFluxoPagamento(fluxoPagamentoAux);
            	
                fluxoPagamentoAux.setListaParcelasFluxoPgto(null);
                fluxoPagamentoAux.setListaParcelasFluxoPgto(listaParcelasFluxoPgtoAux);
			}
            
            entrada.setFuncao(comissaoVO.getFuncao());
            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomisintrn());
            entrada.setCindcdpcobrjuros(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdfcobrcotac(comissaoVO.getCodMomentoComissao());
            entrada.setVprevtdsembcmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVprevtdsembcmbio()));
            entrada.setVlxoperaccmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxoperaccmbio()));
            entrada.setVlxcomiscmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxcomiscmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.webMoedaToMainframe(taxaDeJuros));
			entrada.setQtdeocorrprinc(fluxoPagamentoAux.getQtdeocorrprinc());
			entrada.setQtdeocorrjuros(fluxoPagamentoAux.getQtdeocorrjuros());
            
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setCpais(comissaoVO.getCpais());
			entrada.setDprevtdsembcmbio(fluxoPagamentoAux.getDprevtdsembcmbio());
			entrada.setTdiafinandsemb(fluxoPagamentoAux.getTdiafinandsemb());
            entrada.setVmincobrcomis(SiteUtil.webMoedaToMainframe(comissaoVO.getVmincobrcomis()));
            
            for (Iterator<TrdFinNegParcelaVO> iterator = fluxoPagamentoAux.getListaParcelasFluxoPgto().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemFluxo = (TrdFinNegParcelaVO) iterator.next();
                Npccwlaerequest_lista itemDesembolso = new Npccwlaerequest_lista();
                
                itemDesembolso.setLista_npceladsembtrade(itemFluxo.getNpceladsembtrade());
                itemDesembolso.setLista_tdianegocpcela(itemFluxo.getTdianegocpcela());
                itemDesembolso.setLista_dvctopcelatrade(itemFluxo.getDvctopcelatrade());
                itemDesembolso.setLista_vpcelamesatrade(SiteUtil.webMoedaToMainframe(itemFluxo.getVpcelamesatrade()));
                itemDesembolso.setLista_tpparcela(itemFluxo.getTpparcela());
                
                listaDesembolso.add(itemDesembolso);
            }
            
            entrada.setQtdeocorr(listaDesembolso.size());
            entrada.setLista(listaDesembolso);
            
            // Fluxo: NPCCIAH6 - Books: NPCCWLAE / NPCCWLAS
            listaComPaginacao(request, response, "CALCVALORESCOMISSINT","NPCCIAH6");
            
            saida.getCindcdfcobrcotac();
            saida.getCindcdpcobrjuros();
            
            comissaoVO.setVprevtcomiscmbio(SiteUtil.formatarValorWeb(saida.getVprevtcomiscmbio()));
            
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwlasresponse_lista objFrom = saida.getLista().get(i);
                objTo = new TrdFinNegParcelaVO();
                
                objTo.setNpcelacomis(objFrom.getLista_npceladsembtrade());
                objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
                objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
                objTo.setVencimentoComissao(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
                
                objTo.setVpcelacomiscmbio(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                objTo.setVpcelamesatrade(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                objTo.setValorParcelaComissao(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                
                lista.add(objTo);
            }
            //========================================================================================================================
            
//            for (int i = 0; i < fluxoPagamento.getListaParcelasFluxoPgto().size(); i++) {
//            	TrdFinNegParcelaVO parcela = fluxoPagamento.getListaParcelasFluxoPgto().get(i);
//            	parcela.setValorJurosParcelaFluxoPgto(lista.get(i).getValorParcelaComissao());
//            }
            int numeroPcela = 0;
            for (int i = 0; i < fluxoPagamento.getListaParcelasFluxoPgto().size(); i++) {
            	TrdFinNegParcelaVO parcela = fluxoPagamento.getListaParcelasFluxoPgto().get(i);
            	
            	if (parcela.getTpparcela().equals("J")) {
            		parcela.setValorJurosParcelaFluxoPgto(lista.get(numeroPcela).getValorParcelaComissao());
            		numeroPcela++;
				}
            }
            
            //========================================================================================================================            
            
            
            comissaoVO.setQpcelacmbiotrade(saida.getQtdeocorr());
//            comissaoVO.setListaParcelasComissao(lista);
            
            return Boolean.TRUE;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] ComissaoInternaExternaModalServiceImpl.getComissaoInterna | CALCVALORESCOMISSINT ------- ");
        }  

    }
}
