package br.com.bradesco.web.ricc.view.bean.questionarioempresas.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioempresas.QuestionarioEmpresasVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class QuestionarioEmpresasViewHelper extends AbstractViewHelper {
	/**
	 *
	 */
	private static final long serialVersionUID = -1116835804304222911L;

	private QuestionarioEmpresasVO questionarioEmpresasVO;
	private List<TipoQuestionarioVO> comboSetor;
	
	@Override
	public void inicializar() {
		questionarioEmpresasVO = new QuestionarioEmpresasVO();
		if (questionarioEmpresasVO.getListaSetor().isEmpty()) {
			comboSetor = siteUtil.carregarListaSetor();
		}
	}
	
	public QuestionarioEmpresasVO getQuestionarioEmpresasVO() {
		return questionarioEmpresasVO;
	}

	public void setQuestionarioEmpresasVO(
			QuestionarioEmpresasVO questionarioEmpresasVO) {
		this.questionarioEmpresasVO = questionarioEmpresasVO;
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
