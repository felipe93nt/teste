package br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariolargecorporate.QuestionarioLargeCorporateVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class QuestionarioLargeCorporateViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627035249993777631L;

	private QuestionarioLargeCorporateVO model = null;
	private List<TipoQuestionarioVO> comboSetor;

	@Override
	public void inicializar() {
		model = new QuestionarioLargeCorporateVO();
		if (model.getListaSetor().isEmpty()) {
			comboSetor = siteUtil.carregarListaSetor();
		}
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
