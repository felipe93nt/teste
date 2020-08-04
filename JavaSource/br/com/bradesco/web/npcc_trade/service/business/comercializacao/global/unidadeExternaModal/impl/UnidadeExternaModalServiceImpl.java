package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.IUnidadeExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

@Named("unidadeExternaModalService")
@RequestScoped
public class UnidadeExternaModalServiceImpl extends BaseService implements IUnidadeExternaModalService, Serializable  {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 2028157107174956804L;

	/**
     * Nome: getListaUniExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 24/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<UnidadeExternaVO> getListaUniExterna(UnidadeExternaVO unidadeExternaVO, Integer modalidade) {

        List<UnidadeExternaVO> lista = new ArrayList<UnidadeExternaVO>();

        Unidextmodallistrequest request = new Unidextmodallistrequest();
        Unidextmodallistresponse response = new Unidextmodallistresponse();
        Npcdwfgerequest bookEntrada = new Npcdwfgerequest();
        Npcdwfgsresponse bookSaida = new Npcdwfgsresponse();
        request.setNpcdwfgerequest(bookEntrada);
        response.setNpcdwfgsresponse(bookSaida);

        // Monta a área de entrada de acordo com o tipo de pesquisa.
        bookEntrada.setTipopesquisa(unidadeExternaVO.getTipoPesquisaUnidExt());
        
        bookEntrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
        bookEntrada.setCflialbanqrswift(SiteUtil.STRING_EMPTY);
        
        // 1 - BANCO CORRESPONDENTE | 2 - BANCO REEMBOLSADOR | 3 - BANCO AVISADOR | 4 - BANCO INDICADO | 5 - UNIDADE EXTERNA GP2
        if(modalidade.equals(Numeros.UM)){
        	bookEntrada.setIbanqrcmbio(unidadeExternaVO.getBancocorr());
        	// Para tela de inclusão de Boleto AGEX
        	if (!SiteUtil.isEmptyOrNull(unidadeExternaVO.getCbanqrcmbio())) {
        	   bookEntrada.setCbanqrcmbio(unidadeExternaVO.getCbanqrcmbio());
        	}
        }
        else if (modalidade.equals(Numeros.DOIS)) {
        	bookEntrada.setIbanqrcmbio(unidadeExternaVO.getBancodesemb());
        }
        else if (modalidade.equals(Numeros.TRES)) {
            bookEntrada.setIbanqrcmbio(unidadeExternaVO.getBancoaviso());
        }
        else if (modalidade.equals(Numeros.QUATRO)) {
            bookEntrada.setIbanqrcmbio(unidadeExternaVO.getBancoindica());
        }
        else if (modalidade.equals(Numeros.CINCO)) {
            bookEntrada.setIbanqrcmbio(unidadeExternaVO.getIbanqrcmbio());
        }
        
        // executa chamada CWS - Fluxo NPCDIADP - Books: NPCDWFGE / NPCDWFGS
        listaComPaginacao(request, response, "UNIDEXTMODALLIST", "NPCDIADP");

        for (Npcdwfgsresponse_lista objFrom : response.getNpcdwfgsresponse().getLista()) {

            UnidadeExternaVO objTo = new UnidadeExternaVO();

            // Copia os valores das propriedades
            objTo.setCbanqrcmbio(objFrom.getLista_cbanqrcmbio());
            objTo.setIbanqrcmbio(objFrom.getLista_ibanqrcmbio());
            objTo.setCpais(objFrom.getLista_cpais());
            objTo.setIpais(objFrom.getLista_ipais());
            objTo.setCidbanqrswift(objFrom.getLista_cidbanqrswift());
            objTo.setCmunintlcmbio(objFrom.getLista_cmunintlcmbio());
            objTo.setImunintlcmbio(objFrom.getLista_imunintlcmbio());
            
            lista.add(objTo);
        }

        return lista;
    }

}
