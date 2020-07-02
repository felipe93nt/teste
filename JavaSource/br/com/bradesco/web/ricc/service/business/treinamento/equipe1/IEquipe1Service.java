package br.com.bradesco.web.ricc.service.business.treinamento.equipe1;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;

public interface IEquipe1Service extends Serializable {

	RetornoPesquisaCadastramentoVO carregarListaCorporate(PesquisaCadastramentoVO entrada);
	
}
