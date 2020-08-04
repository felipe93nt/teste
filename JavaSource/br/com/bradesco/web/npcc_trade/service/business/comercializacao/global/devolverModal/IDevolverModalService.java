package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal;

public interface IDevolverModalService {

	public String devolverCotacao(DevolucaoVO devolucaoVO);
	
	/**
     * 
     * Nome: devolverCotacaoDivrg
     * 
     * Prop�sito: 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 20/06/2017 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String devolverCotacaoDivrg(DevolucaoVO devolucaoVO);
	
}
