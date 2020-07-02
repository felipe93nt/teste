package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe2.viewhelper;

import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe2ConsultaQuestionarioImobiliarioViewHelper extends
		AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2071442707863025154L;
	private QuestionarioImobiliarioVO model;
	private List<TipoQuestionarioVO> comboSetor;

	@Override
	public void inicializar() {
		model = new QuestionarioImobiliarioVO();
		renderAbaQuestionario = Boolean.TRUE;
		renderAbaObrasAndamento = Boolean.FALSE;
		renderAbaObrasConcluidas = Boolean.FALSE;
		
	}
	
	//Atributos que renderizam as "abas"
		private Boolean renderAbaQuestionario;
		private Boolean renderAbaObrasAndamento;
		private Boolean renderAbaObrasConcluidas;

	public QuestionarioImobiliarioVO getModel() {
		return model;
	}

	public void setModel(QuestionarioImobiliarioVO model) {
		this.model = model;
	}

	public List<TipoQuestionarioVO> getComboSetor() {
		return comboSetor;
	}

	public void setComboSetor(List<TipoQuestionarioVO> comboSetor) {
		this.comboSetor = comboSetor;
	}
	
	public Boolean getRenderAbaQuestionario() {
		return renderAbaQuestionario;
	}

	public void setRenderAbaQuestionario(Boolean renderAbaQuestionario) {
		this.renderAbaQuestionario = renderAbaQuestionario;
	}

	public Boolean getRenderAbaObrasAndamento() {
		return renderAbaObrasAndamento;
	}

	public void setRenderAbaObrasAndamento(Boolean renderAbaObrasAndamento) {
		this.renderAbaObrasAndamento = renderAbaObrasAndamento;
	}

	public Boolean getRenderAbaObrasConcluidas() {
		return renderAbaObrasConcluidas;
	}

	public void setRenderAbaObrasConcluidas(Boolean renderAbaObrasConcluidas) {
		this.renderAbaObrasConcluidas = renderAbaObrasConcluidas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
