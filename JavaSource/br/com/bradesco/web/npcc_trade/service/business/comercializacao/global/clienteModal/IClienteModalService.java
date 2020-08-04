package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.clienteModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;

public interface IClienteModalService {
    
    /**
     * 
     * Nome: getMsgRetorno
     *  
     * Prop�sito: Fornece mensagem de retorno enviado pelo mainframe na execu��o dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String getMsgRetorno();
	
	public List<TradeFinNegocListasVO> listar(ClienteSelecaoVO vo, boolean pesqCpf);

}
