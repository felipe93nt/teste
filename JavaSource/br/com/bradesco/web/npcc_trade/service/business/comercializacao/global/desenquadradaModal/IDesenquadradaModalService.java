package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;


public interface IDesenquadradaModalService {
    
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
	
    /**
     * Nome: consultarBloqueioCliente
     * 
     * Prop�sito: Consulta se cliente tem bloqueio
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 12/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequa��o ao
     *      padr�o hexavision.
     */
	public String consultarBloqueioCliente(Long codUnicoPessoa);
	
	/**
     * Nome: pesquisar
     * 
     * Prop�sito: Carrega a Lista de Desenquadramentos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 12/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequa��o ao
     *      padr�o hexavision.
     */
    public DesenquadramentoVO pesquisar(DesenquadramentoVO filtro);

}
