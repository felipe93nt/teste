package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.devolverModal;

public interface IDevolverModalService {

	public String devolverCotacao(DevolucaoVO devolucaoVO);
	
	/**
     * 
     * Nome: devolverCotacaoDivrg
     * 
     * Propósito: 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/06/2017 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String devolverCotacaoDivrg(DevolucaoVO devolucaoVO);
	
}
