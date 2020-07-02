package br.com.bradesco.web.ricc.view.bean.questionarioprojetos.viewhelper;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.AjaxBehaviorEvent;

import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.ConstrutoresFornecedoresVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.EstruturaSocietariaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.UsosFontesVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class QuestionarioProjetoViewHelper extends AbstractViewHelper {

	private static final long serialVersionUID = 8855777272841729765L;

	private QuestionarioProjetoVO model;
	private Map<Integer, EstruturaSocietariaVO> estruturaSocietariaMap;
	
	//Flags de controle de botões
	private boolean desabilitaIncluirAcionista = true;
	private boolean desabilitaIncluirUsosFontes = true;
	private boolean desabilitaIncluirConstrutoresFornecedores = true;
	
	@Override
	public void inicializar() {
		model = new QuestionarioProjetoVO();
		estruturaSocietariaMap = new HashMap<Integer, EstruturaSocietariaVO>();
		
		desabilitaIncluirAcionista = true;
		desabilitaIncluirUsosFontes = true;
		desabilitaIncluirConstrutoresFornecedores = true;
	}
	
	

	public void desabilitaIncluirAcionista(AjaxBehaviorEvent e) {
		EstruturaSocietariaVO acionista = model.getAcionista();
		if (siteUtil.isEmptyOrNull(acionista.getDescAcionista())) {
			setDesabilitaIncluirAcionista(Boolean.TRUE);
		} else if (siteUtil.isEmptyOrNull(acionista.getPrcParticipacao())) {
			setDesabilitaIncluirAcionista(Boolean.TRUE);
		} else {
			setDesabilitaIncluirAcionista(Boolean.FALSE);
		}
	}
	
	public void desabilitaIncluirUsosFontes(AjaxBehaviorEvent e){
		UsosFontesVO usosFontes = model.getUsosFontes();
		if(siteUtil.isEmptyOrNull(usosFontes.getCdTipoDocumento().toString())){
			setDesabilitaIncluirUsosFontes(Boolean.TRUE);
		} else if(siteUtil.isEmptyOrNull(usosFontes.getDescUsosFontes())){
			setDesabilitaIncluirUsosFontes(Boolean.TRUE);
		} else if(siteUtil.isEmptyOrNull(usosFontes.getPrcParticipacao().toString())){
			setDesabilitaIncluirUsosFontes(Boolean.TRUE);
		} else {
			setDesabilitaIncluirUsosFontes(Boolean.FALSE);
		}
		
	}
	
	public void desabilitaIncluirConstrutoresFornecedores(AjaxBehaviorEvent e){
		ConstrutoresFornecedoresVO construtoresFornecedores = model.getConstrutoresFornecedores();
		if(siteUtil.isEmptyOrNull(construtoresFornecedores.getCdTipoDocumento().toString())){
			setDesabilitaIncluirConstrutoresFornecedores(Boolean.TRUE);
		} else if(siteUtil.isEmptyOrNull(construtoresFornecedores.getDescConstrutoresFornecedores())){
			setDesabilitaIncluirConstrutoresFornecedores(Boolean.TRUE);
		} else {
			setDesabilitaIncluirConstrutoresFornecedores(Boolean.FALSE);
		}
		
	}
	
	public QuestionarioProjetoVO getModel() {
		return model;
	}

	public void setModel(QuestionarioProjetoVO questionarioProjeto) {
		this.model = questionarioProjeto;
	}

	public boolean isDesabilitaIncluirAcionista() {
		return desabilitaIncluirAcionista;
	}

	public void setDesabilitaIncluirAcionista(boolean desabilitaIncluirAcionista) {
		this.desabilitaIncluirAcionista = desabilitaIncluirAcionista;
	}

	public boolean isDesabilitaIncluirUsosFontes() {
		return desabilitaIncluirUsosFontes;
	}

	public void setDesabilitaIncluirUsosFontes(boolean desabilitaIncluirUsosFontes) {
		this.desabilitaIncluirUsosFontes = desabilitaIncluirUsosFontes;
	}

	public boolean isDesabilitaIncluirConstrutoresFornecedores() {
		return desabilitaIncluirConstrutoresFornecedores;
	}

	public void setDesabilitaIncluirConstrutoresFornecedores(
			boolean desabilitaIncluirConstrutoresFornecedores) {
		this.desabilitaIncluirConstrutoresFornecedores = desabilitaIncluirConstrutoresFornecedores;
	}



	public Map<Integer, EstruturaSocietariaVO> getEstruturaSocietariaMap() {
		return estruturaSocietariaMap;
	}


}
