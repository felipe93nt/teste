package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;


public interface IDesenquadradaModalService {
    
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
	
    /**
     * Nome: consultarBloqueioCliente
     * 
     * Propósito: Consulta se cliente tem bloqueio
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
	public String consultarBloqueioCliente(Long codUnicoPessoa);
	
	/**
     * Nome: pesquisar
     * 
     * Propósito: Carrega a Lista de Desenquadramentos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public DesenquadramentoVO pesquisar(DesenquadramentoVO filtro);

}
