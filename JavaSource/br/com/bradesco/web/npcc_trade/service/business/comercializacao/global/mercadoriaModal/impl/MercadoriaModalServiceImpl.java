package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.mercadoriaModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Mercadoriasmodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Mercadoriasmodallistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.mercadoriaModal.IMercadoriaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;

@Named("mercadoriaModalService")
@RequestScoped
public class MercadoriaModalServiceImpl extends BaseService implements IMercadoriaModalService{

	/** Variavel do tipo long. */
	private static final long serialVersionUID = -3877612342179056296L;

	public List<TradeFinNegocListasVO> getMercadoriasModalList(TrdFinNegMercadoriaVO filtro) {

        List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();

        TradeFinNegocListasVO objTo = null;

        Mercadoriasmodallistrequest request = new Mercadoriasmodallistrequest();
        Mercadoriasmodallistresponse response = new Mercadoriasmodallistresponse();
        Npccwwnerequest entrada = new Npccwwnerequest();
        Npccwwnsresponse saida = new Npccwwnsresponse();
        request.setNpccwwnerequest(entrada);
        response.setNpccwwnsresponse(saida);

        entrada.setTipopesquisa(filtro.getTipoPesquisaMercadoria());
        entrada.setCmcadocmbiomcsul(0L);
        entrada.setRmcadoopercmbio(filtro.getRmcadoopercmbio());

        // Executa chamada CWS - Fluxo: NPCCIAOY - Books: NPCCWWNE / NPCCWWNS
        listaComPaginacao(request, response, "MERCADORIASMODALLIST", "NPCCIAOY");

        for (int i = 0; i < response.getNpccwwnsresponse().getQtdeocorr(); i++) {

            Npccwwnsresponse_lista objFrom = response.getNpccwwnsresponse().getLista().get(i);
            objTo = new TradeFinNegocListasVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCmcadoopercmbio(objFrom.getLista_cmcadoopercmbio());
            objTo.setRmcadoopercmbio(objFrom.getLista_rmcadoopercmbio());
            objTo.setAtivoSimNao(EnumSimNao.fromCode(objFrom.getLista_ntpositcmbio()).getDescricao());
            objTo.setNtpositcmbio(objFrom.getLista_ntpositcmbio());
            objTo.setCindcdlicenmcado(objFrom.getLista_cindcdlicenmcado());
            objTo.setCmcadorestcmbio(objFrom.getLista_cmcadorestcmbio());

            lista.add(objTo);
        }

        return lista;
    }
}
