package br.com.bradesco.web.ricc.service.business.cadastro;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;

public interface ICadastramentoRicService extends Serializable {

	RetornoPesquisaCadastramentoVO carregarListaCadastro(PesquisaCadastramentoVO entrada);
	
}
