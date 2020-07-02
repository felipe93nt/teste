package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.viewhelper;

import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe3AgronegocioViewHelper extends AbstractViewHelper {
	
	

	private static final long serialVersionUID = -1817303582028361985L;
	
	@Override
	public void inicializar() {

		modelAgronegocio = new QuestionarioAgronegocioVO();
		renderAbaGraosFibras = Boolean.TRUE;
		renderAbaUsinas = Boolean.FALSE;
		 
	}

	/// AGRONEGOCIO 
	
	private QuestionarioAgronegocioVO modelAgronegocio;
	private Boolean renderAbaGraosFibras;
	private Boolean renderAbaUsinas;

	public QuestionarioAgronegocioVO getModelAgronegocio() {
		return modelAgronegocio;
	}

	public void setModelAgronegocio(QuestionarioAgronegocioVO modelAgronegocio) {
		this.modelAgronegocio = modelAgronegocio;
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
