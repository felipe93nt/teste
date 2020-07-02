package br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioaltovarejo.QuestionarioAltoVarejoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultaAltoVarejoViewHelper extends AbstractViewHelper{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3975902512292285738L;
	private QuestionarioAltoVarejoVO model;
	private List<TipoQuestionarioVO> comboSetor;
	
	@Override
	public void inicializar() {
		model = new QuestionarioAltoVarejoVO();
	}

	public QuestionarioAltoVarejoVO getModel() {
		return model;
	}

	public void setModel(QuestionarioAltoVarejoVO model) {
		this.model = model;
	}

	public List<TipoQuestionarioVO> getComboSetor() {
		return comboSetor;
	}

	public void setComboSetor(List<TipoQuestionarioVO> comboSetor) {
		this.comboSetor = comboSetor;
	}
	
}
