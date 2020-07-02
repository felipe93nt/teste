package br.com.bradesco.web.ricc.view.bean.duplavalidacao.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.duplavalidacao.DuplaValidacaoVO;
import br.com.bradesco.web.ricc.service.business.duplavalidacao.IDuplaValidacaoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.duplavalidacao.viewhelper.DuplaValidacaoViewHelper;

@SessionScoped
@Named("duplaValidacaoBean")
public class DuplaValidacaoBean extends AbstractBean<DuplaValidacaoViewHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2222201914139422394L;

	@Inject
	@Named("duplaValidacaoService")
	private IDuplaValidacaoService service;
	private DuplaValidacaoViewHelper viewHelper;
	String usuarioLogado = null;
	
	private ArrayList<String> mensagens = new ArrayList<String>();

	@Override
	public String iniciarPagina() {
		setViewHelper(new DuplaValidacaoViewHelper());
		getViewHelper().inicializar();
		validaCamposDePara();
		verificaUsuarioLogado();
		return RiccConstants.TELA_DUPLAVALIDACAO_PARAMETRIZACAO;
	}

	// verifica o preenchimento do justificativa
	public boolean validaPreenchimento() {
		if ((getViewHelper().getJustificativa() == null)
				|| (getViewHelper().getJustificativa()
						.equalsIgnoreCase(""))) {
			siteUtil.getMessages()
					.getMsgInformada("msg_campo_just_obrigatorio");
			return false;
		}
		return true;
	}
	
	public void validaPreenchimentoAuto(AjaxBehaviorEvent e) {
		if ((getViewHelper().getJustificativa() == null)
				|| (getViewHelper().getJustificativa()
						.equalsIgnoreCase(""))) {
			getViewHelper().setFlagDesabBotao(Boolean.TRUE);
		}else{
			getViewHelper().setFlagDesabBotao(Boolean.FALSE);
		}
	}

	// metodo para desabilitar botões se o usuário logado for
	// igual ao usuario da solicitação
	public void verificaUsuarioLogado() {
//		getViewHelper().getModel().setUsuarioSolicitacao("I90387x");// valor
//																	// fake
		usuarioLogado = BradescoCommonServiceFactory.getSecurityManager()
				.getUserId().trim().toUpperCase();

		if (getViewHelper().getModelPara().getUsuarioSolicitacao()
				.equalsIgnoreCase(usuarioLogado)) {
			getViewHelper().setFlagDesabJust(Boolean.TRUE);
			getViewHelper().setFlagDesabBotao(Boolean.TRUE);
		}else if ((getViewHelper().getModelDe().getNumeroParametrizacao() == 0) && 
				(getViewHelper().getModelPara().getNumeroParametrizacao() == 0)){
			getViewHelper().setFlagDesabJust(Boolean.TRUE);
			getViewHelper().setFlagDesabBotao(Boolean.TRUE);
		}else {
			getViewHelper().setFlagDesabJust(Boolean.FALSE);
			getViewHelper().setFlagDesabBotao(Boolean.TRUE);
		}
	}
	
	public void consultaDuplaValidacao(){
		try {
			List<DuplaValidacaoVO> retorno = service.consultaDuplaValidacao(1);
			viewHelper.setModelDe(retorno.get(0));
			viewHelper.setModelPara(retorno.get(1));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			mensagens.add(e.getMessage());
		}
	}
	
	public void aprovar (){
		if(validaPreenchimento()){
			manutencaoDuplaValidacao(1);
		}
	}
	
	public void reprovar(){
		if(validaPreenchimento()){
			manutencaoDuplaValidacao(2);
		}
	}
	
	public void manutencaoDuplaValidacao (int tipoManutencao){
		try {
			usuarioLogado = BradescoCommonServiceFactory.getSecurityManager()
					.getUserId().trim().toUpperCase();
			service.manutencaoDuplaValidacao(tipoManutencao, getViewHelper().getModelDe(),
					getViewHelper().getModelPara(), getViewHelper().getJustificativa(), usuarioLogado);
			String retorno = "";
			if(tipoManutencao == 1){
				retorno = "aprovada";
			}else if (tipoManutencao == 2){
				retorno = "recusada";
			}
			getViewHelper().setJustificativa("");
			validaCamposDePara();
			verificaUsuarioLogado();
			BradescoFacesUtils.addInfoModalMessage("Parametrização " + retorno + " com sucesso", Boolean.FALSE);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			mensagens.add(e.getMessage());
		}
	}
	
	//Verificar se o campo PARA está populado e renderiza os campos.
	public void validaCamposDePara() {
		consultaDuplaValidacao();
		if(getViewHelper().getModelDe().getNumeroParametrizacao() == 0){
			getViewHelper().setFlagRenderCamposDe(Boolean.FALSE);
		}else{
			getViewHelper().setFlagRenderCamposDe(Boolean.TRUE);
		}
		if(getViewHelper().getModelPara().getNumeroParametrizacao() == 0){
			getViewHelper().setFlagRenderCamposPara(Boolean.FALSE);
		}else{
			getViewHelper().setFlagRenderCamposPara(Boolean.TRUE);
		}
		if((getViewHelper().getModelDe().getNumeroParametrizacao() == 0) && 
				(getViewHelper().getModelPara().getNumeroParametrizacao() == 0)){
			getViewHelper().setFlagRenderCamposDe(Boolean.TRUE);
			getViewHelper().setFlagRenderCamposPara(Boolean.TRUE);
		}
	}

	public IDuplaValidacaoService getService() {
		return service;
	}

	public void setService(IDuplaValidacaoService service) {
		this.service = service;
	}

	public DuplaValidacaoViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(DuplaValidacaoViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}	

}
