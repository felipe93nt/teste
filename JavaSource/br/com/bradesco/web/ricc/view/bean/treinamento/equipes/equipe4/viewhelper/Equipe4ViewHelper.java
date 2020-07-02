package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe4.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariolargecorporate.QuestionarioLargeCorporateVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe4ViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 1L;
	
	private QuestionarioLargeCorporateVO model = new QuestionarioLargeCorporateVO();
	private List<TipoQuestionarioVO> comboSetor;
	
	@Override
	public void inicializar() {
		model.setCodRelatorio("560");
		model.setCodGrupo("9");
		model.setNomeGrupo("CEFRI");
		model.setCodSituacaoRelatorio("212");
		model.setCodSegmentoRelatorio("215");
		model.setFlagSetorAgricola("1");
		model.setFlagSetorImobiliario("1");
		model.setFlagSetorTransporte("1");
		model.setFlagSetorProjeto("1");
		setModel(model);
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
