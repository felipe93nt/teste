package br.com.bradesco.web.ricc.service.business.treinamento.equipe4;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;

public interface IEquipe4Service extends Serializable {

	RetornoPesquisaCadastramentoVO carregarListaLargeCorporate(PesquisaCadastramentoVO entrada);
	
}
