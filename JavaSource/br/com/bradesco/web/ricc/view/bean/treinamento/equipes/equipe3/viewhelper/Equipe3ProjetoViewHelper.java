package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.viewhelper;

import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe3ProjetoViewHelper extends AbstractViewHelper {

	private static final long serialVersionUID = 8855777272841729765L;

	private QuestionarioProjetoVO model;
	
	@Override
	public void inicializar() {
		model = new QuestionarioProjetoVO();
		
	}

	public QuestionarioProjetoVO getModel() {
		return model;
	}

	public void setModel(QuestionarioProjetoVO questionarioProjeto) {
		this.model = questionarioProjeto;
	}

}