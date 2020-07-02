package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuestionarioCorporateVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe1ViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 1L;

	private QuestionarioCorporateVO model;
	private List<TipoQuestionarioVO> comboSetor;
	
	@Override
	public void inicializar() {
	
		setModel(new QuestionarioCorporateVO());
		
	}

	public QuestionarioCorporateVO getModel() {
		return model;
	}

	public void setModel(QuestionarioCorporateVO model) {
		this.model = model;
	}

	public List<TipoQuestionarioVO> getComboSetor() {
		return comboSetor;
	}

	public void setComboSetor(List<TipoQuestionarioVO> comboSetor) {
		this.comboSetor = comboSetor;
	}

}
