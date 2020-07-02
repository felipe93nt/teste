package br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioaltovarejo.QuestionarioAltoVarejoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AltoVarejoViewHelper extends AbstractViewHelper {

	/**
	 *
	 */
	private static final long serialVersionUID = -1817303582028361985L;

	private QuestionarioAltoVarejoVO altoVarejoVO;
	private List<TipoQuestionarioVO> comboSetor;

	@Override
	public void inicializar() {
		altoVarejoVO = new QuestionarioAltoVarejoVO();
	}

	public QuestionarioAltoVarejoVO getAltoVarejoVO() {
		return altoVarejoVO;
	}

	public void setAltoVarejoVO(QuestionarioAltoVarejoVO altoVarejoVO) {
		this.altoVarejoVO = altoVarejoVO;
	}

	public List<TipoQuestionarioVO> getComboSetor() {
		return comboSetor;
	}

	public void setComboSetor(List<TipoQuestionarioVO> comboSetor) {
		this.comboSetor = comboSetor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
