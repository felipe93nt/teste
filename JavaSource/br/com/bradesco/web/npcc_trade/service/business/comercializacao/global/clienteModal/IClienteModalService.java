package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.clienteModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;

public interface IClienteModalService {
    
    /**
     * 
     * Nome: getMsgRetorno
     *  
     * Propósito: Fornece mensagem de retorno enviado pelo mainframe na execução dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    String getMsgRetorno();
	
	public List<TradeFinNegocListasVO> listar(ClienteSelecaoVO vo, boolean pesqCpf);

}
