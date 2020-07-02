package br.com.bradesco.web.ricc.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;

public final class RiccMessages {

	/** Atributo rb. */
	private ResourceBundle rb = getResourceBundle();

	/** Atributo instance. */
	private static RiccMessages instance = null;

	/**
     * Construtor privado da classe CursoJavaMessages.
     */
	private RiccMessages(){
	}

	public static RiccMessages getInstance(){
		if (instance == null) {
			instance = new RiccMessages();
		}
		return instance;
	}


	private ResourceBundle getResourceBundle() {
		String bundleLocation = FacesContext.getCurrentInstance()
				.getApplication().getMessageBundle();
		Locale locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		ClassLoader loader = RiccMessages.class.getClassLoader();
		ResourceBundle rb = ResourceBundle.getBundle(bundleLocation, locale,
				loader);
		return rb;
	}

	public void getMsgCampoObrigatorio(final String key){
		StringBuilder msg = new StringBuilder();
		msg.append(rb.getString(RiccConstants.O_CAMPO) + RiccConstants.ESPACO);
		msg.append(rb.getString(key));
		msg.append(RiccConstants.ESPACO +  rb.getString(RiccConstants.OBRIGATORIO));

		BradescoFacesUtils.addInfoModalMessage(msg.toString() + ".", false);
	}
	
	public void getMsgCamposObrigatoriosTodos(final String key) {
		StringBuilder msg = new StringBuilder();
		msg.append(rb.getString(RiccConstants.TODOS_OS_CAMPOS) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.DE_DOIS_PONTOS) + RiccConstants.ESPACO);
		msg.append(rb.getString(key) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.OBRIGATORIOS));
		
		BradescoFacesUtils.addInfoModalMessage(msg.toString(), false);
	}
	
	public void getMsgColunaObrigatoria(final String key) {
		StringBuilder msg = new StringBuilder();
		msg.append(rb.getString(RiccConstants.TODOS_OS_CAMPOS_COLUNA) + RiccConstants.ESPACO);
		msg.append(rb.getString(key) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.OBRIGATORIOS));
		
		BradescoFacesUtils.addInfoModalMessage(msg.toString(), false);
	}
	
	public void getMsgCampoObrigatorioBloco(final String keyCampo,
			final String keyTipoCampo, final String keyBloco) {
		StringBuilder msg = new StringBuilder();
		msg.append(rb.getString(RiccConstants.O_CAMPO) + RiccConstants.ESPACO);
		msg.append(rb.getString(keyCampo) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.DE_DOIS_PONTOS) + RiccConstants.ESPACO);
		msg.append(rb.getString(keyTipoCampo) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.DO_BLOCO) + RiccConstants.ESPACO);
		msg.append(rb.getString(keyBloco) + RiccConstants.ESPACO);
		msg.append(rb.getString(RiccConstants.OBRIGATORIO));
		
		BradescoFacesUtils.addInfoModalMessage(msg.toString(), false);
	}

	public void getMsgInformada(String key) {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(key), false);

	}
	
	public void getMsgListaDeveConterItem(String key) {
		String msg = "A lista de " + rb.getString(key) + " deve conter ao menos um item";
		BradescoFacesUtils.addInfoModalMessage(msg, false);
	}

	public void getMsgSelecioneUmItemLista(String key){
		String msg = rb.getString(RiccConstants.SELECIONE_UM_ITEM_NA_LISTA) + " de " + rb.getString(key);
		BradescoFacesUtils.addInfoModalMessage(msg, false);
	}

	public void getMsgCombinacaoFiltrosInvalida() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.COMBINACAO_FILTROS_INVALIDA), false);
	}

	public void getMsgCadastroEfetuadoSucesso() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.CADASTRO_EFETUADO_SUCESSO), false);
	}
	
	public void getMsgInclusaoSucesso() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.INCLUSAO_EFETUADA_SUCESSO), false);
	}
	
	public void getMsgExclusaoSucesso() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.EXCLUSAO_EFETUADA_SUCESSO), false);
	}
	
	public void getMsgSalvarSucesso() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.RELATORIO_SALVO_SUCESSO), false);
	}
	
	public void getMsgConcluirSucesso() {
		BradescoFacesUtils.addInfoModalMessage(rb.getString(RiccConstants.RELATORIO_CONCLUIDO_SUCESSO), false);
	}
	
	public void getMsgConcluirSucessoFowardCadastramento() {
		BradescoFacesUtils.addInfoModalMessage (rb.getString(RiccConstants.RELATORIO_CONCLUIDO_SUCESSO), ((CadastramentoRicBean) FacesUtils
				.getManagedBean("cadastramentoRicBean")).carregarListaCadastramento(), BradescoViewExceptionActionType.ACTION, false);
	}
	
	public void getMsgPencentualTotal(String key){
		String msg = rb.getString(RiccConstants.PERCENTUAL_TOTAL_CEM) + " no campo " + rb.getString(key);
		BradescoFacesUtils.addInfoModalMessage(msg,  false);
	}
	
	public void getMsgDataInvalida(String key){
		String msg ="Campo " + rb.getString(key) + " inválida!";
		BradescoFacesUtils.addInfoModalMessage(msg,  false);
	}
	
	public void getMsgDataInicioMaiorDataFim(String keyDtInicio, String keyDtFim){
		String msg ="Campo " + rb.getString(keyDtInicio) + " não pode ser maior que " + rb.getString(keyDtFim);
		BradescoFacesUtils.addInfoModalMessage(msg,  false);
	}
	
	public void getMsgSomaPercentualTotalMaiorQueCem(String keyQuadro, String ano){
		StringBuilder _msg = new StringBuilder();
		_msg.append(rb.getString(RiccConstants.SOMA_PERCENTUAL_MAIOR_QUE_CEM));
		_msg.append("<br>");
		_msg.append("Quadro: " + rb.getString(keyQuadro));
		_msg.append("<br>");
		_msg.append("Ano: " + ano);
		BradescoFacesUtils.addInfoModalMessage(_msg.toString(), false);
	}

	public void getMsgPrcMaiorQuePermitido(String key) {
		String msg ="Valor " + rb.getString(key) + " maior que 100,00%";
		BradescoFacesUtils.addInfoModalMessage(msg,  false);
	}
	
}
