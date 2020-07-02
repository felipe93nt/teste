package br.com.bradesco.web.ricc.service.business.treinamento.equipe3;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;

public interface IEquipe3Service extends Serializable {

	RetornoPesquisaCadastramentoVO carregarListaVarejo(PesquisaCadastramentoVO entrada);
	
}
