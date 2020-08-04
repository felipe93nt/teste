package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.modeloBoletoModal.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Modeloboletolistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Modeloboletolistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.modeloBoletoModal.IModeloBoletoModalService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

@Named("modeloBoletoModalService")
@RequestScoped
public class ModeloBoletoModalServiceImpl extends BaseService implements IModeloBoletoModalService, Serializable  {

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
     */
    public List<ModeloBoletoVO> getListaModBoleto(ModeloBoletoVO filtro) {
    	
        List<ModeloBoletoVO> listaVO = new ArrayList<ModeloBoletoVO>();

        Modeloboletolistrequest request = new Modeloboletolistrequest();
        Modeloboletolistresponse response = new Modeloboletolistresponse();
        Npccwvmerequest bookEntrada = new Npccwvmerequest();
        Npccwvmsresponse bookSaida = new Npccwvmsresponse();

        request.setNpccwvmerequest(bookEntrada);
        response.setNpccwvmsresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setCprodtserv(filtro.getCprodtservc());
        bookEntrada.setImodcontrcmbio(filtro.getImodcontrcmbio());

        // executa chamada CWS
        listaComPaginacao(request, response, "MODELOBOLETOLIST", "NPCCIAOO");

        // trata retorno
        this.setMsgRetorno(response.getTexmens());

        // carrega lista de retorno
        for (int i = Numeros.ZERO; i < response.getNpccwvmsresponse().getQtdeocorr(); i++) {

            Npccwvmsresponse_lista objFrom = response.getNpccwvmsresponse().getLista().get(i);
            ModeloBoletoVO objTo = new ModeloBoletoVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            objTo.setImodcontrcmbio(objFrom.getLista_imodcontrcmbio());
            objTo.setCmodcontrcmbio(objFrom.getLista_cmodcontrcmbio());
            objTo.setCindcdmodpdrao(objFrom.getLista_cindcdmodpdrao().equals("S")?true:false);

            // Seta os valor dos campos que não vem do MF

            listaVO.add(objTo);
        }

        return listaVO;
    }

}
