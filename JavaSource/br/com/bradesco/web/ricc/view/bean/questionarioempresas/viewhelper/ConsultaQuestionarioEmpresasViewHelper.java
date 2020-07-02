package br.com.bradesco.web.ricc.view.bean.questionarioempresas.viewhelper;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionarioempresas.QuestionarioEmpresasVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultaQuestionarioEmpresasViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6317309063206631408L;
	
	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	private QuestionarioEmpresasVO model;
	
	@Override
	public void inicializar() {
		model = new QuestionarioEmpresasVO();
		
	}

	public QuestionarioEmpresasVO getModel() {
		return model;
	}

	public void setModel(QuestionarioEmpresasVO model) {
		this.model = model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
