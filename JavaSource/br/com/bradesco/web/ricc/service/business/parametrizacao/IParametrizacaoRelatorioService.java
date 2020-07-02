package br.com.bradesco.web.ricc.service.business.parametrizacao;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.parametrizacao.RelatorioParametrizacaoVO;

public interface IParametrizacaoRelatorioService extends Serializable {

	/**
	 * @param relatorio
	 * @return
	 */
	public String salvarRelatorio(RelatorioParametrizacaoVO relatorio);

	/**
	 * @return
	 */
	public RelatorioParametrizacaoVO detalharRelatorio();

}
