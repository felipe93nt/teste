package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.beneficiarioModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Beneficiariomodllistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Beneficiariomodllistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Npcdwemerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Npcdwemsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList.Npcdwemsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.beneficiarioModal.IBenefModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;


@Named("benefModalService")
@RequestScoped
public class BenefModalServiceImpl extends BaseService implements IBenefModalService{

	 /** Variavel do tipo long. */
	private static final long serialVersionUID = -3708424705149347239L;

	/**
     * Nome: getListaBeneficiario
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinNegocListasVO> getListaBeneficiario(TrdFinNegMercadoriaVO filtro) {

        List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();

        Beneficiariomodllistrequest request = new Beneficiariomodllistrequest();
        Npcdwemerequest entrada = new Npcdwemerequest();
        request.setNpcdwemerequest(entrada);

        Beneficiariomodllistresponse response = new Beneficiariomodllistresponse();
        Npcdwemsresponse saida = new Npcdwemsresponse();
        response.setNpcdwemsresponse(saida);

        entrada.setTipopesquisa(filtro.getTipoPesquisaBeneficiario());
        entrada.setIpssoacmbio(filtro.getIpssoacmbio());

        // executa chamada CWS - Fluxo NPCDIAFG - Books: NPCDWEME / NPCDWEMS
        listaComPaginacao(request, response, "BENEFICIARIOMODLLIST", "NPCDIAFG");

        for (int i = Numeros.ZERO; i < response.getNpcdwemsresponse().getQtdeocorr(); i++) {
            Npcdwemsresponse_lista objFrom = response.getNpcdwemsresponse().getLista().get(i);
            TradeFinNegocListasVO objTo = new TradeFinNegocListasVO();

            // Copia os valores das propriedades
            objTo.setIredzdpssoacmbio(objFrom.getLista_iredzdpssoacmbio());
            objTo.setIpssoacmbio(objFrom.getLista_ipssoacmbio());
            objTo.setCunicpssoacmbio(objFrom.getLista_cunicpssoacmbio());
            objTo.setIciddeender(objFrom.getLista_iciddeender());
            objTo.setIpaiscoplt(objFrom.getLista_ipaiscoplt());

            lista.add(objTo);
        }

        return lista;

    }
	
}
