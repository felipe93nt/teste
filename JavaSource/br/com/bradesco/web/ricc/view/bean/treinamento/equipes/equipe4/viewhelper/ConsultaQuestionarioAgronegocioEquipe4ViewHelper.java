package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe4.viewhelper;

import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultaQuestionarioAgronegocioEquipe4ViewHelper extends AbstractViewHelper{

	private static final long serialVersionUID = -5188856427042529843L;
	
	private QuestionarioAgronegocioVO model;
	private Boolean renderAbaGraosFibras;
	private Boolean renderAbaUsinas;

	@Override
	public void inicializar() {
		
		model = new QuestionarioAgronegocioVO();
		renderAbaGraosFibras = Boolean.TRUE;
		renderAbaUsinas = Boolean.FALSE;
		
	}

	public QuestionarioAgronegocioVO getModel() {
		return model;
	}

	public void setModel(QuestionarioAgronegocioVO model) {
		this.model = model;
	}

	public Boolean getRenderAbaGraosFibras() {
		return renderAbaGraosFibras;
	}

	public void setRenderAbaGraosFibras(Boolean renderAbaGraosFibras) {
		this.renderAbaGraosFibras = renderAbaGraosFibras;
	}

	public Boolean getRenderAbaUsinas() {
		return renderAbaUsinas;
	}

	public void setRenderAbaUsinas(Boolean renderAbaUsinas) {
		this.renderAbaUsinas = renderAbaUsinas;
	}

}
