/**
 * Nome: br.com.bradesco.web.cursojava.utils
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.ricc.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.bradesco.data.connector.exception.ConnectorExecutionException;
import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UISubmitCheck.Constants;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.config.BradescoRuntimeConfig;
import br.com.bradesco.web.aq.view.config.element.BradescoNavigationCase;
import br.com.bradesco.web.aq.view.config.element.BradescoNavigationRule;
import br.com.bradesco.web.aq.view.core.th.ext.util.BradescoTHMessageUtils;
import br.com.bradesco.web.aq.view.facescontext.BradescoFacesContextFactory;
import br.com.bradesco.web.aq.view.lifecycle.BradescoLifecycle;
import br.com.bradesco.web.aq.view.lifecycle.BradescoLifecycleFactory;
import br.com.bradesco.web.aq.view.util.BradescoHashMapUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.exception.RiccMensagemException;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;

import com.google.gson.Gson;

/**
 * Nome: SiteUtil Propósito: Classe que define o SiteUtil <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
public final class SiteUtil {
	/**
	 * Representa uma String vazia.
	 */
	public final String STRING_EMPTY = "";

	public final String VAZIO = "";

	public static final Locale PT_BR = new Locale("pt", "BR");

	public static final String DECIMAL_PATTERN = "#,##0.00";

	public static final String DECIMAL_UMA_CASA_PATTERN = "#,##0.0";

	public static final String INTEGER_PATTERN = "#,###";

	private static SiteUtil instance = null;

	/**
	 * Construtor privado da classe SiteUtil.
	 */
	private SiteUtil() {

	}

	public static SiteUtil getInstance() {
		if (instance == null) {
			instance = new SiteUtil();
		}
		return instance;
	}

	/**
	 * Obter o contexto Faces mediante o ServletRequest. (por exemplo, para
	 * obter o faces context do Servlet Filter)
	 *
	 * @param request
	 *            ServletRequest.
	 * @param respose
	 *            ServletResponse.
	 * @param servletContext
	 *            ServletContext.
	 * @return FacesContext instancia do contexto Faces atual.
	 */
	public FacesContext getFacesContext(ServletRequest request,
			ServletResponse respose, ServletContext servletContext) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext != null) {
			return facesContext;
		}
		BradescoFacesContextFactory contextFactory = (BradescoFacesContextFactory) FactoryFinder
				.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
		BradescoLifecycleFactory lifecycleFactory = (BradescoLifecycleFactory) FactoryFinder
				.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		BradescoLifecycle lifecycle = lifecycleFactory
				.getLifecycle(BradescoLifecycleFactory.DEFAULT_LIFECYCLE);
		return contextFactory.getFacesContext(servletContext, request, respose,
				lifecycle);
	}

	/**
	 * Obter o atributo 'toViewId', configurado no caso da navegação, para os
	 * "outcome" e "fromAction" passados.
	 *
	 * @param facesContext
	 *            Contexto Faces.
	 * @param outcome
	 *            O atributo 'outcome' do caso da navegação.
	 * @param fromAction
	 *            O atributo 'from-action' do caso da navegação.
	 * @return String O atributo 'toViewId' do caso da navegação.
	 */
	public String getNavigationCaseToViewId(FacesContext facesContext,
			String outcome, String fromAction) {
		if (facesContext == null) {
			return null;
		}
		String viewId = "*";
		if (facesContext.getViewRoot() != null) {
			viewId = facesContext.getViewRoot().getViewId();
		}
		Map casesMap = getNavigationCases(facesContext);
		BradescoNavigationCase navigationCase = null;

		List casesList = (List) casesMap.get(viewId);
		if (casesList != null) {
			// Exact match?
			navigationCase = calculaMapeamentoNavigationCase(casesList,
					fromAction, outcome);
		}
		if (navigationCase != null) {
			return navigationCase.getToViewId();
		}
		return null;
	}

	/**
	 * Retorna o mapeamento do caso da navegação para os parametros passados.
	 *
	 * @param casesList
	 *            Listagem dos casos da navegação.
	 * @param actionRef
	 *            Referencia da ação realizada.
	 * @param outcome
	 *            O String 'outcome' para mapeamento.
	 * @return NavigationCase O caso da navegação mapeado
	 */
	public BradescoNavigationCase calculaMapeamentoNavigationCase(
			List casesList, String actionRef, String outcome) {
		BradescoNavigationCase bradescoNavigationCase = BradescoNavigationCase
				.getInstance();
		for (int i = 0, size = casesList.size(); i < size; i++) {
			bradescoNavigationCase.setNavigationCase(casesList.get(i));
			String cazeOutcome = bradescoNavigationCase.getFromOutcome();
			String cazeActionRef = bradescoNavigationCase.getFromAction();
			if ((cazeOutcome == null || cazeOutcome.equals(outcome))
					&& (cazeActionRef == null || cazeActionRef
							.equals(actionRef))) {
				return bradescoNavigationCase;
			}
		}
		return null;
	}

	/**
	 * Retorna um Map com todos os casos da navegação configurados.
	 *
	 * @param facesContext
	 *            O contexto Faces.
	 * @return Map com os casos da navegação.
	 */
	public Map getNavigationCases(FacesContext facesContext) {
		BradescoRuntimeConfig runtimeConfig = BradescoRuntimeConfig
				.getInstance();
		Collection rules = runtimeConfig.getNavigationRules();
		int rulesSize = rules.size();
		Map cases = new HashMap(BradescoHashMapUtils.calcCapacity(rulesSize));
		BradescoNavigationRule navigationRule = BradescoNavigationRule
				.getInstance();
		for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
			navigationRule.setNavigationRule(iterator.next());
			String fromViewId = navigationRule.getFromViewId();
			if (fromViewId == null) {
				fromViewId = "*";
			} else {
				fromViewId = fromViewId.trim();
			}
			List list = (List) cases.get(fromViewId);
			if (list == null) {
				list = new ArrayList(navigationRule.getNavigationCases());
				cases.put(fromViewId, list);
			} else {
				;
			}
		}
		return cases;
	}

	/**
	 * Obtem o valor do atributo messageKey.
	 *
	 * @param messageKey
	 *            - Chave da mensagem
	 * @return Mensagem definida pelo atributo messageKey.
	 */
	public String getFacesMessage(String messageKey) {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = BradescoTHMessageUtils.getMessage(
					facesContext, messageKey);
			return facesMessage.getSummary();
		}

		return Constants.EMPTY;
	}

	/**
	 * Obtem o valor do atributo messageKey, com o valor das variaveis.
	 *
	 * @param messageKey
	 *            - Chave da mensagem
	 * @param params
	 *            - Array de parametros
	 * @return Mensagem definida pelo atributo messageKey, com as variaveis
	 *         preenchidas.
	 */
	public String getFacesMessage(String messageKey, Object[] params) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = BradescoTHMessageUtils.getMessage(
				facesContext, messageKey, params);
		return facesMessage.getSummary();
	}

	/**
	 * Insere um novo mensagem de erro GLOBAL no FacesMessages. O mensagem é
	 * obtenido pela sua chave.
	 *
	 * @param messageKey
	 *            - Chave da mensagem
	 */
	public void addMessageErrorMessage(String messageKey) {
		addMessageErrorMessage(null, messageKey);
	}

	/**
	 * Insere um novo mensagem de erro no FacesMessages. O mensagem é obtenido
	 * pela sua chave, e associado no compenente correspondente.
	 *
	 * @param clientId
	 *            - id do componente
	 * @param messageKey
	 *            - Chave da mensagem
	 */
	public void addMessageErrorMessage(String clientId, String messageKey) {
		String msg = getFacesMessage(messageKey);
		FacesUtils.addErrorMessage(clientId, msg);
	}

	/**
	 * Insere um novo mensagem de erro GLOBAL no FacesMessages. O mensagem é
	 * obtenido pela sua chave, com o valor das variaveis.
	 *
	 * @param messageKey
	 *            - Chave da mensagem
	 * @param params
	 *            - Array de parametros
	 */
	public void addMessageErrorMessage(String messageKey, Object[] params) {
		addMessageErrorMessage(null, messageKey, params);
	}

	/**
	 * Insere um novo mensagem de erro no FacesMessages. O mensagem é obtenido
	 * pela sua chave, com o valor das variaveis, e associado no compenente
	 * correspondente.
	 *
	 * @param clientId
	 *            - id do componente
	 * @param messageKey
	 *            - Chave da mensagem
	 * @param params
	 *            - Array de parametros
	 */
	public void addMessageErrorMessage(String clientId, String messageKey,
			Object[] params) {
		String msg = getFacesMessage(messageKey, params);
		FacesUtils.addErrorMessage(clientId, msg);
	}

	/**
	 * <p>
	 * Recupera o objeto HttpServletRequest.
	 * </p>
	 *
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getServletRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * Formatar uma string com o número 0 a esquerda de acordo com o tamanho.
	 *
	 * @param value
	 *            - Valor a ser formatado.
	 * @param size
	 *            - Tamanho do campo.
	 * @return Retorna uma string com zeros à esquerda.
	 */
	public String formatNumber(String value, int size) {
		String ret = null;
		if (value == null) {
			value = "";
		}
		if (value.length() > size) {
			ret = value.substring(0, size);
		} else {
			ret = value;
			if (value.length() < size) {
				for (int i = value.length(); i < size; i++) {
					ret = "0" + ret;
				}
			}
		}
		return ret;
	}

	/**
	 * Formata um valor com zeros a direita para ser apresentado na tela.
	 *
	 * @param valor
	 *            Valor a ser formatado
	 * @param digitos
	 *            Número de digitos do lado direito.
	 * @return Valor formatado.
	 * @see
	 */
	protected String adicionaZerosEsquerda(String valor, int digitos) {
		// calculo
		while (valor.length() < digitos) {
			valor = Numeros.ZERO + valor;
		}

		return valor;
	}

	/**
	 * Formatar uma string com o caracter " " a direita de acordo com o tamanho.
	 *
	 * @param value
	 *            - Valor a ser formatado.
	 * @param size
	 *            - Tamanho do campo.
	 * @return Retorna uma string foramtada.
	 */
	public String formatString(String value, int size) {
		String ret = null;
		if (value == null) {
			value = "";
		}
		if (value.length() > size) {
			ret = value.substring(0, size);
		} else {
			ret = value;
			if (value.length() < size) {
				for (int i = value.length(); i < size; i++) {
					ret += " ";
				}
			}
		}
		return ret;
	}

	/**
	 * Formata um bloco de texto autenticado para exibição.
	 *
	 * @param autenticada
	 *            Valor da String de autenticação.
	 * @return Retorna um objeto da classe <tt>String</tt> com os dados de
	 *         autenticação prontos para exibição.
	 */
	public String formatarTextoAutenticado2(String autenticada) {
		StringBuffer ret = new StringBuffer();
		ret.append(autenticada.charAt(0));
		for (int i = 1; i < (autenticada.length() - 1); i++) {
			ret.append(autenticada.charAt(i));
		}
		ret.append(autenticada.charAt(autenticada.length() - 1));
		return ret.toString();
	}

	/**
	 * Reseteamos el managed bean
	 *
	 * @param mBean
	 *            Nome do managed bean.
	 */
	public void liberaManagedBean(String mBean) {
		try {
			FacesContext.getCurrentInstance().getApplication()
					.createValueBinding("#{" + mBean + "}")
					.setValue(FacesContext.getCurrentInstance(), null);
		} catch (Exception e) {
			BradescoCommonServiceFactory.getLogManager().warn(
					SiteUtil.class,
					"No ha sido posible liberamos el managed Bean[" + mBean
							+ "]");
		}
	}

	/**
	 * Objetivo: Verificar se a String é nula ou vazia.
	 *
	 * @param pSString
	 *            String a ser comparada.
	 * @return <i>true</i>, se a String for nula ou vazia; <i>false</i>, caso
	 *         contrário.
	 */
	public boolean isEmptyOrNull(String pSString) {
		return (pSString == null || pSString.trim().equals(STRING_EMPTY));
	}

	/**
	 * Nome: isNotNull
	 * <p>
	 * Propósito: verifica se todos os itens nao sao nulos, se um item for
	 * igual.
	 *
	 * @param params
	 *            the params
	 * @return true, se for not null
	 * @see SiteUtil.
	 */
	public boolean isNotNull(Object... params) {
		boolean isNotNull = Boolean.TRUE;
		for (Object param : params) {
			isNotNull = isNotNull && param != null;
			if (not(isNotNull))
				break;
		}
		return isNotNull;
	}

	/**
	 *
	 * Nome: isNot Propósito: Negar a expressão booleana.
	 *
	 * @param expressao
	 *            expressao a se verificar
	 * @return a negacao da expressao booleana
	 * @see Referências Externas
	 */
	public boolean not(boolean expressao) {
		return !expressao;
	}

	public RiccMessages getMessages() {
		return RiccMessages.getInstance();
	}

	public boolean isNot(boolean flag) {
		if (flag == Boolean.TRUE) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	public String tratarParametroString(Object param) {

		String retorno = VAZIO;

		try {
			if (isEmptyOrNull(param)) {
				retorno = VAZIO;
			} else {
				String str = param.toString();

				retorno = String.valueOf(str);
			}
		} catch (Exception e) {
			retorno = VAZIO;
		}
		return retorno;
	}

	public Integer tratarParametroInteger(Object param) {
		Integer retorno = Numeros.ZERO;
		try {
			if (isEmptyOrNull(param)) {
				retorno = Numeros.ZERO;
			} else {
				String strNumero = param.toString();
				strNumero = strNumero.replace(".", "");
				retorno = Integer.valueOf(strNumero);
			}
		} catch (Exception e) {
			retorno = Numeros.ZERO;
		}
		return retorno;
	}

	public String tratarDuasCasasDecimais(Double param) {
		String retorno = VAZIO;

		try {
			if (isEmptyOrNull(param)) {
				retorno = VAZIO;
			} else {
				DecimalFormat df = new DecimalFormat("##0.00");
				retorno = df.format(param);
			}
		} catch (Exception e) {
			retorno = VAZIO;
		}
		return retorno;
	}

	public boolean isNotNull(Object object) {

		return object != null;
	}

	public boolean isNull(Object object) {
		return object == null;
	}

	public boolean isEmptyOrNull(Object object) {
		// Verificar se o objeto é nulo ou vazio

		if (object == null || "".equals(object.toString())) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public boolean isEmptyZeroOrNull(Object object) {

		if (object == null || "".equals(object.toString())) {
			return Boolean.TRUE;
		}

		if (object instanceof Number
				&& new BigDecimal("0.00").equals(new BigDecimal(String
						.valueOf(object)))) {

			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public boolean isNotEmptyOrNull(Object object) {
		// Verificar se o objeto é nulo ou vazio

		if (object == null || "".equals(object.toString())) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public Integer converterBooleanSimNao(Boolean key) {
		// converter 1 - Sim / 2 - Não
		if (key) {
			return 1;
		} else {
			return 2;
		}
	}

	public boolean validarTodosCamposEntradaString(String... entrada) {

		for (int i = 0; i < entrada.length; i++) {
			if (entrada[i] == null || "".equals(entrada[i])) {
				return false;
			}
		}

		return true;
	}

	public boolean validaUmCampoPreenchidoString(String... entrada) {

		for (int i = 0; i < entrada.length; i++) {
			if (entrada[i] != null & !"".equals(entrada[i])) {
				return true;
			}
		}

		return false;
	}

	public List<TipoQuestionarioVO> carregarListaSegmento() {
		ArrayList<TipoQuestionarioVO> listaSegmento = new ArrayList<TipoQuestionarioVO>();
		TipoQuestionarioVO item = null;
		for (SegmentoEnum segmentoEnum : SegmentoEnum.values()) {
			item = new TipoQuestionarioVO();
			item.setCodigo(segmentoEnum.getCodigo().longValue());
			item.setDescricao(segmentoEnum.getDescricao());
			item.setNomeBean(segmentoEnum.getBeanTelaManutencao());
			listaSegmento.add(item);
		}
		return listaSegmento;
	}

	public List<TipoQuestionarioVO> carregarListaSetor() {
		ArrayList<TipoQuestionarioVO> listaSetor = new ArrayList<TipoQuestionarioVO>();

		TipoQuestionarioVO item = null;
		for (SetorEnum setor : SetorEnum.values()) {
			item = new TipoQuestionarioVO();
			item.setCodigo(setor.getCodigo().longValue());
			item.setDescricao(setor.getDescricao());
			item.setNomeBean(setor.getBeanTelaManutencao());
			listaSetor.add(item);
		}
		return listaSetor;
	}

	public List<TipoQuestionarioVO> carregarComboSetor(
			List<TipoQuestionarioVO> comboSetor,
			List<TipoQuestionarioVO> listaSetoresTabela) {
		comboSetor = carregarListaSetor();
		for (TipoQuestionarioVO itemSelecionado : listaSetoresTabela) {
			comboSetor.remove(itemSelecionado);
		}
		return comboSetor;
	}

	public List<SelectItem> carregarComboStatusTodos() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.STATUS_TODOS, "TODOS"));
		lista.add(new SelectItem(RiccConstants.STATUS_ATIVO, "ATIVO"));
		lista.add(new SelectItem(RiccConstants.STATUS_PENDENTE, "PENDENTE"));
		lista.add(new SelectItem(RiccConstants.STATUS_HISTORICO, "HISTORICO"));
		return lista;
	}

	public String converterCodStatus(int codigo) {
		String codigoString = String.valueOf(codigo);
		if (codigoString.equals(RiccConstants.STATUS_ATIVO)) {
			return "ATIVO";
		} else if (codigoString.equals(RiccConstants.STATUS_PENDENTE)) {
			return "PENDENTE";
		} else if (codigoString.equals(RiccConstants.STATUS_HISTORICO)) {
			return "HISTORICO";
		} else
			return null;
	}

	public List<SelectItem> carregarComboTipoPesquisa() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.PESQUISA_CNPJ, "CNPJ"));
		lista.add(new SelectItem(RiccConstants.PESQUISA_NUMERO_GRUPO,
				"NUMERO GRUPO"));
		lista.add(new SelectItem(RiccConstants.PESQUISA_NOME_GRUPO,
				"NOME GRUPO"));

		return lista;
	}

	public boolean selecaoNaoVazia(List listaSelecao, String listaLabel) {
		if (listaSelecao.isEmpty()) {
			RiccMessages.getInstance().getMsgSelecioneUmItemLista(listaLabel);
			return false;
		}
		return true;
	}

	public Integer nullToInteger(Object valor) {

		if (isNotEmptyOrNull(valor)) {
			try {
				return Integer.parseInt(String.valueOf(valor));
			} catch (Exception e) {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public String nullToString(Object object) {
		if (object == null) {
			return "";
		} else {
			return String.valueOf(object);
		}
	}

	public Long nullToLong(Object valor) {

		if (isNotEmptyOrNull(valor)) {
			try {
				return Long.parseLong(String.valueOf(valor));
			} catch (Exception e) {
				return 0l;
			}
		} else {
			return 0l;
		}
	}

	public boolean valorVazio(String valor) {
		valor = (valor == null || "".equals(valor)) ? "0" : valor
				.replace(".", "").replace(",", "").replace("-", "");
		return valor.matches("0+");
	}

	public String adicionarDecimais(String valor) {
		if (valor.length() < 3 && !valor.contains(",")) {
			valor += ",00";
		}
		return valor;
	}

	public BigInteger valueToMainframeBigInteger(String valor) {
		if (isEmptyOrNull(valor)) {
			return BigInteger.ZERO;
		}

		// Tratamento espicifico para quando o campo já vem formatado da tabela

		if (valor.length() == 0 || valor.equals("-")) {
			return BigInteger.ZERO;
		} else {
			valor = valor.replace(".", "");
		}
		return new BigInteger(valor);
	}

	public BigDecimal valueToMainframeBigDecimal(String valor) {
		if (isEmptyOrNull(valor)) {
			return BigDecimal.ZERO.setScale(2);
		}

		// Tratamento espicifico para quando o campo já vem formatado da tabela

		if (valor.length() == 0 || valor.equals("-")) {
			return BigDecimal.ZERO.setScale(2);
		} else if (valor.length() < 3) {
			valor = valor + ".00";
		}
		// verifica se possui virgula, para evitar de formatar numero já
		// formatado
		else if (valor.indexOf(",") >= 0) {
			valor = valor.replace(".", "");
			valor = valor.replace(",", ".");
		}
		// Verifica se existe ponto no numero que não seja o ponto/virgula do
		// padrão americano
		else if (valor.indexOf(".") >= 0
				&& ((valor.indexOf(".") + 3) != valor.length())) {
			valor = valor.replace(".", "");
		}
		return new BigDecimal(valor);
	}

	public String valueToMainframeString(String valor) {
		if (valor == null) {
			return null;
		}

		if (valor.equals(RiccConstants.VAZIO)) {
			return RiccConstants.VAZIO;
		}

		if (valor.length() == 0 || valor.equals("-")) {
			return "";
		} else {
			valor = valor.replace(".", "");
			valor = valor.replace(",", ".");
			return valor;
		}
	}

	public String formatValoresToString(String valor) {
		DecimalFormat format = new DecimalFormat();
		BigDecimal valorBD = new BigDecimal(0);
		if (isNotEmptyOrNull(valor)) {

			format = (DecimalFormat) NumberFormat.getNumberInstance(PT_BR);
			format.applyPattern(DECIMAL_PATTERN);
			valorBD = new BigDecimal(valor);

			return format.format(valorBD);
		}
		return "0,00";
	}

	public String formatValoresUmaCasaToString(String valor) {
		DecimalFormat format = new DecimalFormat();
		BigDecimal valorBD = new BigDecimal(0);
		if (isNotEmptyOrNull(valor)) {

			format = (DecimalFormat) NumberFormat.getNumberInstance(PT_BR);
			format.applyPattern(DECIMAL_UMA_CASA_PATTERN);
			valorBD = new BigDecimal(valor);

			return format.format(valorBD);
		}
		return "0,0";
	}

	public String formatValoresToStringInteger(String valor) {
		DecimalFormat format = new DecimalFormat();
		BigDecimal valorBD = new BigDecimal(0);
		if (isNotEmptyOrNull(valor)) {

			format = (DecimalFormat) NumberFormat.getNumberInstance(PT_BR);
			format.applyPattern(INTEGER_PATTERN);
			valorBD = new BigDecimal(valor);

			return format.format(valorBD);
		}
		return "0";
	}

	public String formatNumericosToString(String valor) {
		DecimalFormat format = new DecimalFormat();
		BigDecimal valorBD = new BigDecimal(0);
		if (isNotEmptyOrNull(valor)) {

			format = (DecimalFormat) NumberFormat.getNumberInstance(PT_BR);
			format.applyPattern(INTEGER_PATTERN);
			valorBD = new BigDecimal(valor);

			return format.format(valorBD);
		}
		return "0";
	}

	public String retirarMascaraNumericos(String valor) {
		if (valor.length() == 0) {
			return "0";
		}
		return valor.replace(".", "");
	}

	/**
	 * Metodo que realiza o Log da Aplicacao RICC
	 * 
	 * @param message
	 */
	public void log(String message) {
		BradescoCommonServiceFactory.getLogManager().info(ILogManager.INFO,
				"RICC LOG:" + message);
	}

	public void logError(Exception e) {
		BradescoFacesUtils.addErrorModalMessage(e.getMessage(), null,
				BradescoViewExceptionActionType.ACTION);
	}

	public void retirarMensagemDuplicada() {
		Iterator<FacesMessage> mensagem = FacesContext.getCurrentInstance()
				.getMessages();
		int x = 0;
		while (mensagem.hasNext()) {
			x++;
			mensagem.next();
			if (x > 1) {
				mensagem.remove();
			}
		}
	}

	/**
	 * Metodo que realiza o Log da Aplicacao PCCF
	 * 
	 * @param message
	 */
	public void log(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);

		if (e instanceof ConnectorExecutionException) {
			ConnectorExecutionException ex = (ConnectorExecutionException) e;
			BradescoCommonServiceFactory.getLogManager().info(
					ILogManager.ERROR, ex.getCode() + " - " + ex.getMessage());
		} else {
			BradescoCommonServiceFactory.getLogManager().info(
					ILogManager.ERROR, e.getMessage());
		}

		BradescoCommonServiceFactory.getLogManager().info(ILogManager.ERROR,
				sw.toString());
	}

	public String toJson(Object src) {
		Gson gson = new Gson();
		return gson.toJson(src);
	}

	public Throwable throwException(String nomeFluxo, Exception e) {

		log(e);
		if (e instanceof ConnectorExecutionException) {
			ConnectorExecutionException _cee = (ConnectorExecutionException) e;
			if ((null != _cee.getCause().getMessage())
					&& _cee.getCause().getMessage()
							.contains(RiccConstants.MAINFRAME_CONSULTA_VAZIA)) {
				throw new RiccException(RiccConstants.MAINFRAME_CONSULTA_VAZIA,
						_cee);
			} else if ((null != _cee.getCause().getMessage())
					&& _cee.getCause()
							.getMessage()
							.contains(
									RiccConstants.MAINFRAME_VALIDACAO_PORCENTAGEM)) {
				throw new RiccMensagemException(
						"Soma percentual maior que 100,00%!");
			} else {
				throw new RiccMensagemException(formataMensagemException(
						nomeFluxo, e));
			}

		} else {
			throw new RiccException(e);
		}

	}

	public String formataMensagemException(String nomeFluxo, Throwable exception) {
		StringBuilder retorno = new StringBuilder();

		if (null != nomeFluxo) {
			retorno.append(nomeFluxo);
			retorno.append(" - ");
		}

		if (null != exception.getCause().getMessage()) {
			retorno.append(exception.getCause().getMessage());
		} else {
			retorno.append("ERRO AO TENTAR ACIONAR O FLUXO");
		}

		return retorno.toString();
	}

	public void trataExceptionRecebida(Exception e) {

		if (e instanceof RiccException) {
			RiccException _e = (RiccException) e;
			if (!_e.getLocalizedMessage().equals(
					RiccConstants.MAINFRAME_CONSULTA_VAZIA)) {
				logError(new Exception(e.getCause().getMessage()));
			}
		} else {
			if (isNotEmptyOrNull(e.getMessage())) {
				logError(e);
			} else {
				logExceptionTratada(e);
			}
		}

	}

	private void logExceptionTratada(Exception e) {
		StringBuilder msgException = new StringBuilder();

		StackTraceElement _stackElement = null;
		for (StackTraceElement obj : e.getStackTrace()) {
			if (obj.getClassName().contains("ricc")) {
				_stackElement = obj;
				break;
			}
		}

		String tipoException = e.getClass().toString().replace("class", "")
				.trim();
		msgException.append("Ocorreu erro de: ");
		msgException.append(tipoException);
		msgException.append("<br><br>");
		if (isNotEmptyOrNull(_stackElement)) {
			String fileException = _stackElement.getFileName();
			String methodException = _stackElement.getMethodName();
			int lineException = _stackElement.getLineNumber();

			msgException.append("No arquivo: ");
			msgException.append(fileException);
			msgException.append("<br><br>");
			msgException.append("Método: ");
			msgException.append(methodException);
			msgException.append("<br><br>");
			msgException.append("Linha: ");
			msgException.append(lineException);
		} else {
			msgException.append("Mais detalhes no log da aplicação.");
		}

		logError(new Exception(msgException.toString()));

	}

	public String getFlgSinalCampo(String valor) {
		if (valorVazio(valor)) {
			return "";
		} else {
			if (valor.contains("-")) {
				return "-";
			} else {
				return "+";
			}
		}
	}

	public String checkNullSaida(String campo, String flagNull) {
		return flagNull.equalsIgnoreCase("S") ? "" : campo;
	}

	public String checkNullEntrada(String campo) {
		return isEmptyOrNull(campo) ? "S" : "N";
	}

	public List<SelectItem> carregarExemploComboTreinamento() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_1, "OPÇÃO 1"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_2, "OPÇÃO 2"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_3, "OPÇÃO 3"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_4, "OPÇÃO 4"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_5, "OPÇÃO 5"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_6, "OPÇÃO 6"));
		return lista;
	}

	// combo cidade LeonardoCliente RICC
	public List<SelectItem> carregarComboLeonardoCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_1,
				"Aracaju"));
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_2,
				"Barueri"));
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_3,
				"Curitiba"));
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_4,
				"Rio Branco"));
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_5,
				"Osasco"));
		lista.add(new SelectItem(RiccConstants.COMBO_CIDADE_LEONARDO_OPCAO_6,
				"São Paulo"));
		return lista;
	}

	// combo estado LeonardoCliente RICC
	public List<SelectItem> carregarComboLeonardoEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_1,
				"Acre"));
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_2,
				"Bahia"));
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_3,
				"Ceará"));
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_4,
				"Minas Gerais"));
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_5,
				"Sergipe"));
		lista.add(new SelectItem(RiccConstants.COMBO_ESTADO_LEONARDO_OPCAO_6,
				"São Paulo"));
		return lista;
	}

	public List<SelectItem> carregarComboCidadeAndre() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_1,
				"Osasco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_2,
				"Barueri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_3,
				"Carapicuiba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_4,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_5,
				"Niterói"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_6,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_7,
				"Curitiba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_8,
				"Salvador"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_9,
				"Belo Horizonte"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_CIDADE_10,
				"Goiânia"));
		return lista;
	}

	public List<SelectItem> carregarComboEstadoAndre() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_1,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_2,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_3,
				"Paraná"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_4,
				"Bahia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_5,
				"Minas Gerais"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_6,
				"Goiás"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_7,
				"Tocantins"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_8,
				"Acre"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_9,
				"Sergipe"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ANDRE_ESTADO_10,
				"Amazonas"));
		return lista;
	}

	public List<SelectItem> carregarIsaacComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_CIDADE,
				"Selecione Cidade"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_PARIS, "Paris"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_HONGKONG,
				"HONG KONG"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_LONDRES,
				"Londres"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_MADRI, "Madri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_NOVAYORK,
				"Nova York"));

		return lista;
	}

	public List<SelectItem> carregarIsaacComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_ESTADO,
				"Selecione Estado"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_CALIFORNIA,
				"California"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_FLORIDA,
				"Flórida"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_BAHIA, "Bahia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ISAAC_PARANA,
				"Paraná"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ISAAC_SANTA_CATARINA,
				"Santa Catarina"));
		return lista;
	}

	// Metodos Wellington

	public List<SelectItem> wellingtonCarregarExemploComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1,
				RiccConstants.TREINAMENTO_WELLINGTON_SELECIONE_ESTADO));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_2,
				RiccConstants.TREINAMENTO_WELLINGTON_SP));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_3,
				RiccConstants.TREINAMENTO_WELLINGTON_RJ));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_4,
				RiccConstants.TREINAMENTO_WELLINGTON_ES));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_5,
				RiccConstants.TREINAMENTO_WELLINGTON_MG));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_6,
				RiccConstants.TREINAMENTO_WELLINGTON_BA));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_7,
				RiccConstants.TREINAMENTO_WELLINGTON_RO));
		return lista;

	}

	public List<SelectItem> wellingtonCarregarExemploComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1,
				RiccConstants.TREINAMENTO_WELLINGTON_SELECIONE_CIDADE));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_2,
				RiccConstants.TREINAMENTO_WELLINGTON_SP));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_3,
				RiccConstants.TREINAMENTO_WELLINGTON_OSASCO));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_4,
				RiccConstants.TREINAMENTO_WELLINGTON_RJ));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_5,
				RiccConstants.TREINAMENTO_WELLINGTON_ARRAIAL_DO_CABO));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_6,
				RiccConstants.TREINAMENTO_WELLINGTON_VILA_VELHA));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_7,
				RiccConstants.TREINAMENTO_WELLINGTON_VITORIA));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_8,
				RiccConstants.TREINAMENTO_WELLINGTON_BELO_HORIZONTE));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_9,
				RiccConstants.TREINAMENTO_WELLINGTON_SALVADOR));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_10,
				RiccConstants.TREINAMENTO_WELLINGTON_PORTO_VELHO));
		return lista;

	}

	public List<SelectItem> carregarAndersonCidades() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_CIDADE_BARUERI, "Barueri"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_CIDADE_CARAPICUIBA,
				"Carapicuiba"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_CIDADE_OSASCO, "Osasco"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_CIDADE_JANDIRA, "Jandira"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_CIDADE_ITAPEVI, "Itapevi"));

		return lista;
	}

	public List<SelectItem> carregarAndersonEstados() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_ESTADO_SAOPAULO, "São Paulo"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_ESTADO_RIODEJANEIRO,
				"Rio de Janeiro"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_ESTADO_MINASGERAIS,
				"Minas Gerais"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_ESTADO_ACRE, "Acre"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ANDERSON_ESTADO_BAHIA, "Bahia"));

		return lista;
	}

	public List<SelectItem> joaogilCarregarRadioSexo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_SEXO1,
				"MASCULINO"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_SEXO2,
				"FEMININO"));
		return lista;
	}

	public List<SelectItem> joaogilCarregarComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO1,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO2,
				"Rio de Janeiro"));
		return lista;
	}

	public List<SelectItem> joaogilCarregarComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO1,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO2,
				"São José do Rio Preto"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO3,
				"Ourinhos"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO4,
				"Olímpia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_JOAOGIL_CODIGO5,
				"Rio de Janeiro"));
		return lista;
	}

	public List<SelectItem> carregarEnzoComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_1,
				"-Selecione uma Cidade-"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_2, "São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_3, "Osasco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_4, "Barueri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_5, "Pinheiros"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_6, "Quitauna"));
		return lista;
	}

	public List<SelectItem> carregarEnzoComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_1,
				"-Selecione um Estado-"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_2, "São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_3,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_4, "Acre"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_5, "Amazonas"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_OPCAO_6,
				"Minas Gerais"));
		return lista;
	}

	public List<SelectItem> carregarComboCidadeJoaoCarlos() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.SELECIONE_CIDADE_TREINAMENTO_JOAO_CARLOS,
				"Selecione a cidade"));
		lista.add(new SelectItem(RiccConstants.OSASCO_TREINAMENTO_JOAO_CARLOS,
				"Osasco"));
		lista.add(new SelectItem(
				RiccConstants.RIO_DE_JANEIRO_TREINAMENTO_JOAO_CARLOS,
				"Rio de Janeiro"));
		lista.add(new SelectItem(
				RiccConstants.BELO_HORIZONTE_TREINAMENTO_JOAO_CARLOS,
				"Belo Horizonte"));
		lista.add(new SelectItem(
				RiccConstants.CURITIBA_TREINAMENTO_JOAO_CARLOS, "Curitiba"));
		lista.add(new SelectItem(
				RiccConstants.FLORIANOPOLIS_TREINAMENTO_JOAO_CARLOS,
				"Florianópolis"));
		return lista;
	}

	public List<SelectItem> carregarComboEstadoJoaoCarlos() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.SELECIONE_ESTADO_TREINAMENTO_JOAO_CARLOS,
				"Selecione o Estado"));
		lista.add(new SelectItem(
				RiccConstants.SAO_PAULO_TREINAMENTO_JOAO_CARLOS, "São Paulo"));
		lista.add(new SelectItem(
				RiccConstants.RIO_DE_JANEIRO_TREINAMENTO_JOAO_CARLOS,
				"Rio de Janeiro"));
		lista.add(new SelectItem(
				RiccConstants.MINAS_GERAIS_TREINAMENTO_JOAO_CARLOS,
				"Minas Gerais"));
		lista.add(new SelectItem(RiccConstants.PARANA_TREINAMENTO_JOAO_CARLOS,
				"Paraná"));
		lista.add(new SelectItem(
				RiccConstants.SANTA_CATARINA_TREINAMENTO_JOAO_CARLOS,
				"Santa Catarina"));

		return lista;
	}

	public List<SelectItem> enricoCarregarComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();

		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_OSASCO, "Osasco"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_SAO_PAULO, "São Paulo"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_JANDIRA, "Jandira"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_ITAPEVI, "Itapevi"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_SAO_BERNARDO,
				"São Bernardo"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_BARUERI, "Barueri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ENRICO_CIDADE_MAUA,
				"Mauá"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_SANTO_ANDRE,
				"Santo André"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_CIDADE_CARAPICUIBA,
				"Carapicuíba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ENRICO_CIDADE_COTIA,
				"Cotia"));
		return lista;
	}

	public List<SelectItem> enricoCarregarComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_RIO_DE_JANEIRO,
				"Rio de Janeiro"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_SAO_PAULO, "São Paulo"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_MINAS_GERAIS,
				"Minas Gerais"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_ESPIRITO_SANTO,
				"Espirito Santo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ENRICO_ESTADO_GOIAS,
				"Goiás"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ENRICO_ESTADO_BAHIA,
				"Bahia"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_PARANA, "Paraná"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_ENRICO_ESTADO_ACRE,
				"Acre"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_MATO_GROSSO,
				"Mato Grosso"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_ENRICO_ESTADO_SANTA_CATARINA,
				"Santa Catarina"));
		return lista;
	}

	public List<SelectItem> carregarExemploComboCidadeVitoria() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_1,
				"-Selecione Cidade-"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_2,
				"Barueri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_3,
				"Santana de Parnaíba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_4,
				"Cabo Frio"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_5,
				"Mauriti"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_CIDADE_6,
				"Porto de Galinhas"));
		return lista;
	}

	public List<SelectItem> carregarExemploComboEstadoVitoria() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_1,
				"-Selecione Estado-"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_2,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_3,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_4,
				"Ceara"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_5,
				"Sergipe"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VITORIA_ESTADO_6,
				"Pernambuco"));
		return lista;
	}

	public List<SelectItem> pedroCarregarComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_SP,
				"SP"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_RJ,
				"RJ"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_MG,
				"MG"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_ES,
				"ES"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_BA,
				"BA"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_RS,
				"RS"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_PA,
				"PA"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_PR,
				"PR"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_RR,
				"RR"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_ESTADO_SE,
				"SE"));
		return lista;
	}

	public List<SelectItem> pedroCarregarComboSexo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_PEDRO_SEXO_MASCULINO, "Masculino"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_SEXO_FEMININO,
				"Feminino"));
		return lista;
	}

	public List<SelectItem> pedroCarregarComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_1,
				"Osasco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_2,
				"Parati"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_3,
				"Ouro Preto"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_4,
				"Vitória"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_5,
				"Salvador"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_6,
				"Porto Alegre"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_7,
				"Belém"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_8,
				"Cascavel"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_9,
				"Boa Vista"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_PEDRO_CIDADE_10,
				"Tobias Barreto"));
		return lista;
	}

	/**
	 * @description Método responsávle por popular uma lista de constantes para
	 *              a combo box cidade
	 * @author Matheus Poda
	 * @name carregarComboCidadeMatheus
	 * @see MatheusClienteBeen
	 * @return List<SelectItem>
	 */
	public List<SelectItem> carregarComboCidadeMatheus() {
		List<SelectItem> lista = new ArrayList<SelectItem>();

		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_0,
				"-Selecione uma Cidade-"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_1, "Osasco"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_2, "Carapicuiba"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_3, "Barueri"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_4, "Búzios"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_CIDADE_OPCAO_5, "Copacabana"));
		return lista;
	}

	/**
	 * @description Método responsávle por popular uma lista de constantes para
	 *              a combo box estado
	 * @author Matheus Poda
	 * @name carregarComboEstadoMatheus
	 * @see MatheusClienteBeen
	 * @return List<SelectItem>
	 */
	public List<SelectItem> carregarComboEstadoMatheus() {
		List<SelectItem> lista = new ArrayList<SelectItem>();

		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_ESTADO_OPCAO_0,
				"-Selecione um Estado-"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_ESTADO_OPCAO_1, "São Paulo"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_MATHEUS_ESTADO_OPCAO_2,
				"Rio de Janeiro"));
		return lista;
	}

	public List<SelectItem> felipeCarregarExemploComboCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_0, "-Selecione-"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_1, "São Paulo"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_2, "Barueri"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_3, "Osasco"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_4, "Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_5, "Niterói"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_6, "Petrópolis"));
		return lista;
	}

	public List<SelectItem> felipeCarregarExemploComboEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_0, "-Selecione-"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_1, "São Paulo"));
		lista.add(new SelectItem(RiccConstants.FELIPE_OPCAO_2, "Rio de Janeiro"));
		return lista;
	}

	public List<SelectItem> carregarComboCidadesGuilherme() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_1,
				"Cotia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_2,
				"Osasco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_3,
				"Pelourinho"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_4,
				"Belo Horizonte"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_5,
				"Palmas"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_6,
				"Macaé"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_7,
				"Rio Negrinho"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_8,
				"Jandira"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_9,
				"Mauá"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_CIDADE_10,
				"Passa Quatro"));

		return lista;
	}

	public List<SelectItem> carregarComboEstadosGuilherme() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_ESTADO_1,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_ESTADO_2,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_ESTADO_3,
				"Minas Gerais"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_ESTADO_4,
				"Tocantins"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUILHERME_ESTADO_5,
				"Santa Catarina"));

		return lista;
	}

	public List<SelectItem> carregarNataliaEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_1,
				"- Selecione Estado -"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_2,
				"Acre - AC"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_3,
				"Alagoas - AL"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_4,
				"Amazonas - AM"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_5,
				"Amapá - AP"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_6,
				"Bahia - BA"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_7,
				"Ceará - CE"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_8,
				"Distrito Federal - DF"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_9,
				"Espírito Santo - ES"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_10,
				"Goiás - GO"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_11,
				"Maranhão - MA"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_12,
				"Mato Grosso - MT"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_13,
				"Mato Grosso do Sul - MS"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_14,
				"Minas Gerais - MG"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_15,
				"Pará - PA"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_16,
				"Paraíba - PB"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_17,
				"Paraná - PR"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_18,
				"Pernambuco - PE"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_19,
				"Piauí - PI"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_20,
				"Rio de Janeiro - RJ"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_21,
				"Rio Grande do Norte - RN"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_22,
				"Rio Grande do Sul - RS"));

		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_23,
				"Rondônia - RO"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_24,
				"Roraima - RR"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_25,
				"Santa Catarina - SC"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_26,
				"São Paulo - SP"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_27,
				"Sergipe - SE"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_ESTADO_28,
				"Tocantins - TO"));

		return lista;
	}

	public List<SelectItem> carregarNataliaCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_1,
				"- Selecione Cidade -"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_2,
				"Rio Branco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_3,
				"Maceió"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_4,
				"Macapá"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_5,
				"Manaus"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_6,
				"Salvador"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_7,
				"Fortaleza"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_8,
				"Brasília"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_9,
				"Serra"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_10,
				"Goiânia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_11,
				"São Luís"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_12,
				"Cuiabá"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_13,
				"Campo Grande"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_14,
				"Belo Horizonte"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_15,
				"Belém"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_16,
				"João Pessoa"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_17,
				"Curitiba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_18,
				"Recife"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_19,
				"Teresina"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_20,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_21,
				"Natal"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_22,
				"Porto Alegre"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_23,
				"Porto Velho"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_24,
				"Boa Vista"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_25,
				"Joinville"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_26,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_27,
				"Aracaju"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_NATALIA_CIDADE_28,
				"	Palmas"));

		return lista;
	}

	public List<SelectItem> carregarExemploComboCidadeClaudio() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.CIDADE_OSASCO_CLAUDIO, "Osasco"));
		lista.add(new SelectItem(RiccConstants.CIDADE_COTIA_CLAUDIO, "Cotia"));
		lista.add(new SelectItem(RiccConstants.CIDADE_SAO_PAULO_CLAUDIO,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.CIDADE_CARAPICUIBA_CLAUDIO,
				"Carapicuiba"));
		lista.add(new SelectItem(RiccConstants.CIDADE_BARUERI_CLAUDIO,
				"Barueri"));
		lista.add(new SelectItem(RiccConstants.CIDADE_RIO_DE_JANEIRO_CLAUDIO,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.CIDADE_SAO_CAETANO_CLAUDIO,
				"São Caetano"));
		lista.add(new SelectItem(RiccConstants.CIDADE_BANGU_CLAUDIO, "Bangu"));
		lista.add(new SelectItem(RiccConstants.CIDADE_RIBEIRAO_PRETO_CLAUDIO,
				"Ribeirão preto"));
		lista.add(new SelectItem(RiccConstants.CIDADE_TIJUCA_CLAUDIO, "Tijuca"));
		return lista;

	}

	public List<SelectItem> carregarExemploComboEstadoClaudio() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.ESTADO_RIO_DE_JANEIRO_CLAUDIO,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.ESTADO_SAO_PAULO_CLAUDIO,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.ESTADO_MINAS_GERAIS_CLAUDIO,
				"Minas Gerais"));
		lista.add(new SelectItem(RiccConstants.ESTADO_SANTA_CATARINA_CLAUDIO,
				"Santa Catarina"));
		lista.add(new SelectItem(RiccConstants.ESTADO_BAHIA_CLAUDIO, "Bahia"));
		lista.add(new SelectItem(RiccConstants.ESTADO_PERNAMBUCO_CLAUDIO,
				"Pernambuco"));
		lista.add(new SelectItem(RiccConstants.ESTADO_GOIAS_CLAUDIO, "Goias"));
		lista.add(new SelectItem(RiccConstants.ESTADO_ALAGOAS_CLAUDIO,
				"Alagoas"));
		lista.add(new SelectItem(RiccConstants.ESTADO_PARA_CLAUDIO, "Para"));
		lista.add(new SelectItem(RiccConstants.ESTADO_TOCANTINS_CLAUDIO,
				"Tocantins"));
		return lista;
	}

	public List<SelectItem> carregarComboBoxCidadesGustavo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_1,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_2,
				"Barueri"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_3,
				"Itapevi"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_4,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_5,
				"Curitiba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_6,
				"Recife"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_7,
				"João Pessoa"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_8,
				"Teresina"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_9,
				"Natal"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_10,
				"Porto Alegre"));

		return lista;
	}

	public List<SelectItem> carregarComboBoxEstadosGustavo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_1,
				"Acre"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_2,
				"Alagoas"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_3,
				"Amapá"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_4,
				"Amazonas"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_5,
				"Bahia"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_6,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_7,
				"Rio de Janeiro"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_8,
				"Rio Grande do Norte"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_9,
				"Rio Grande do Sul"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_GUSTAVO_OPCAO_10,
				"Rondônia"));

		return lista;
	}

	public List<SelectItem> comboViniciusCidade() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VINICIUS_OSASCO,
				"Osasco"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VINICIUS_BARUERI,
				"Barueri"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_VINICIUS_CARAPICUIBA, "Carapicuiba"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VINICIUS_SANTOS,
				"Santos"));
		return lista;
	}

	public List<SelectItem> comboViniciusEstado() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VINICIUS_SAO_PAULO,
				"São Paulo"));
		lista.add(new SelectItem(RiccConstants.TREINAMENTO_VINICIUS_PARANA,
				"Parana"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_VINICIUS_RIO_JANEIRO,
				"Rio de Janeiro"));
		lista.add(new SelectItem(
				RiccConstants.TREINAMENTO_VINICIUS_MINAS_GERAIS, "Minas Gerais"));
		return lista;
	}

	// COMBOS TELA MENSAGEM
	public List<SelectItem> carregarComboStatus() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(
				RiccConstants.STATUS_MENSAGEM_PENDENTE_AUTORIZACAO,
				RiccConstants.STATUS_MENSAGEM_PENDENTE_AUTORIZACAO));
		lista.add(new SelectItem(RiccConstants.STATUS_MENSAGEM_EM_ANDAMENTO,
				RiccConstants.STATUS_MENSAGEM_EM_ANDAMENTO));
		lista.add(new SelectItem(RiccConstants.STATUS_MENSAGEM_AUTORIZADA,
				RiccConstants.STATUS_MENSAGEM_AUTORIZADA));
		lista.add(new SelectItem(RiccConstants.STATUS_MENSAGEM_DEVOLVIDA,
				RiccConstants.STATUS_MENSAGEM_DEVOLVIDA));
		lista.add(new SelectItem(RiccConstants.STATUS_MENSAGEM_COPIADA,
				RiccConstants.STATUS_MENSAGEM_COPIADA));
		lista.add(new SelectItem(RiccConstants.STATUS_MENSAGEM_EXCLUIDA,
				RiccConstants.STATUS_MENSAGEM_EXCLUIDA));
		return lista;
	}

	public List<SelectItem> carregarComboMoeda() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.MOEDA_REAL,
				RiccConstants.MOEDA_REAL));
		lista.add(new SelectItem(RiccConstants.MOEDA_DOLAR,
				RiccConstants.MOEDA_DOLAR));
		lista.add(new SelectItem(RiccConstants.MOEDA_EURO,
				RiccConstants.MOEDA_EURO));
		return lista;
	}

	public List<SelectItem> carregarComboCodigoMensagem() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TIPO_MENSAGEM_103,
				RiccConstants.TIPO_MENSAGEM_103));
		lista.add(new SelectItem(RiccConstants.TIPO_MENSAGEM_108,
				RiccConstants.TIPO_MENSAGEM_108));
		lista.add(new SelectItem(RiccConstants.TIPO_MENSAGEM_113,
				RiccConstants.TIPO_MENSAGEM_113));
		return lista;
	}

	public List<SelectItem> carregarComboTipoTransmissao() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.TIPO_TRANSMISSAO_ENVIADA,
				RiccConstants.TIPO_TRANSMISSAO_ENVIADA));
		lista.add(new SelectItem(RiccConstants.TIPO_TRANSMISSAO_RECEBIDA,
				RiccConstants.TIPO_TRANSMISSAO_RECEBIDA));
		return lista;
	}

	// COMBOS TELA INCLUIR COMPONENTES

	public List<SelectItem> carregarComboTipoComponente() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.CAMPO_SWIFT,
				RiccConstants.CAMPO_SWIFT));
		lista.add(new SelectItem(RiccConstants.SUB_CAMPO,
				RiccConstants.SUB_CAMPO));
		lista.add(new SelectItem(RiccConstants.GRUPO_TAGS_XML,
				RiccConstants.GRUPO_TAGS_XML));
		return lista;
	}

	public List<SelectItem> carregarComboGrupoComponente() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants._13_C_TIME_INDICATION,
				RiccConstants._13_C_TIME_INDICATION));
		lista.add(new SelectItem(RiccConstants._20_SENDERS_REFERENCE,
				RiccConstants._20_SENDERS_REFERENCE));
		lista.add(new SelectItem(RiccConstants._23B_BANK_OPERATION_CODE,
				RiccConstants._23B_BANK_OPERATION_CODE));
		return lista;
	}

	public List<SelectItem> carregarComboBlocoCampo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.BASIC_HEADER,
				RiccConstants.BASIC_HEADER));
		lista.add(new SelectItem(RiccConstants.APPLICATION_HEADER,
				RiccConstants.APPLICATION_HEADER));
		lista.add(new SelectItem(RiccConstants.USER_HEADER,
				RiccConstants.USER_HEADER));
		lista.add(new SelectItem(RiccConstants.TEXT, RiccConstants.TEXT));
		lista.add(new SelectItem(RiccConstants.TRAILER, RiccConstants.TRAILER));
		return lista;
	}

	public List<SelectItem> carregarComboTipoDados() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.GRUPO_DE_DADOS,
				RiccConstants.GRUPO_DE_DADOS));
		lista.add(new SelectItem(RiccConstants.MOEDA, RiccConstants.MOEDA));
		lista.add(new SelectItem(RiccConstants.DATA, RiccConstants.DATA));
		lista.add(new SelectItem(RiccConstants.VALOR, RiccConstants.VALOR));
		lista.add(new SelectItem(RiccConstants.TEXTO, RiccConstants.TEXTO));
		lista.add(new SelectItem(RiccConstants.REFERENCIA,
				RiccConstants.REFERENCIA));
		return lista;
	}

	public List<SelectItem> carregarComboFormatoCampo() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(RiccConstants.GRUPO_DADOS,
				RiccConstants.GRUPO_DADOS));
		lista.add(new SelectItem(RiccConstants.A_ALFABETICO,
				RiccConstants.A_ALFABETICO));
		lista.add(new SelectItem(RiccConstants.C_A_Z_MAIS_0_9,
				RiccConstants.C_A_Z_MAIS_0_9));
		lista.add(new SelectItem(RiccConstants.N_NUMERICO,
				RiccConstants.N_NUMERICO));
		lista.add(new SelectItem(RiccConstants.X_CARACTER_X,
				RiccConstants.X_CARACTER_X));
		lista.add(new SelectItem(RiccConstants.Z_CARACTER_Z,
				RiccConstants.Z_CARACTER_Z));
		return lista;
	}

}
