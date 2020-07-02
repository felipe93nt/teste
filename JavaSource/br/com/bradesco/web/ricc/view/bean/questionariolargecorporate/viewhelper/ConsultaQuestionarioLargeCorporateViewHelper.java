package br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariolargecorporate.QuestionarioLargeCorporateVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultaQuestionarioLargeCorporateViewHelper extends
		AbstractViewHelper {

	private static final long serialVersionUID = 7141855954440886560L;

	private QuestionarioLargeCorporateVO model;
	private List<TipoQuestionarioVO> comboSetor;

	@Override
	public void inicializar() {
		setModel(new QuestionarioLargeCorporateVO());
	}

	public QuestionarioLargeCorporateVO getModel() {
		return model;
	}

	public void setModel(QuestionarioLargeCorporateVO model) {
		this.model = model;
	}

	public List<TipoQuestionarioVO> getComboSetor() {
		return comboSetor;
	}

	public void setComboSetor(List<TipoQuestionarioVO> comboSetor) {
		this.comboSetor = comboSetor;
	}

}
