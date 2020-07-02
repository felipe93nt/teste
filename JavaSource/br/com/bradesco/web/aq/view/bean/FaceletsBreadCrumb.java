/**
 * Nome: br.com.bradesco.web.aq.view.bean
 * Propósito: Classes de uso comum para a funcionalidade <br/>
 * Data da Criação: 30/11/2015
 *
 * @author vinicius.christ / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 *         Compilador: 1.6.0_45 <br/>
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.aq.view.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.bradesco.web.ricc.enums.SegmentoEnum;

/**
 * Nome: FaceletsBreadCrumb </br> Propósito: Classe FaceletsBreadCrumb
 *
 * Data: <30/11/2015> <br/>
 * .
 *
 * @author vinicius.christ / Capgemini </br> copyright Copyright (c) 2015
 * @version 1.0
 * @see
 */
@Named("faceletsBreadCrumb")
@ApplicationScoped
public class FaceletsBreadCrumb {

	/** Atributo rb. */
	ResourceBundle rb = getResourceBundle();

	/**
	 * Nome: getResourceBundle
	 *
	 * Propósito: Método get para o atributo 'resourceBundle'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'resourceBundle'
	 */
	public ResourceBundle getResourceBundle() {
		String bundleLocation = FacesContext.getCurrentInstance()
				.getApplication().getMessageBundle();
		Locale locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		ClassLoader loader = FaceletsBreadCrumb.class.getClassLoader();
		ResourceBundle rb = ResourceBundle.getBundle(bundleLocation, locale,
				loader);
		return rb;
	}

	/**
	 * Nome: getValue
	 *
	 * Propósito: Método get para o atributo 'value'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @param key
	 *            the key
	 * @return 'value'
	 */
	public String getValue(String key) {
		String value = null;
		try {
			value = rb.getString(key);
		} catch (Exception e) {
			value = key;
		}
		return value;
	}

	/**
	 * Nome: getarqGestorCache
	 *
	 * Propósito: Método get para o atributo 'arqGestorCache'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorCache'
	 */
	public List<String> getarqGestorCache() {
		List<String> arqGestorCache = new ArrayList<String>();
		arqGestorCache.add(getValue("path_cadastrocache"));
		arqGestorCache.add(getValue("path_listacache"));
		return arqGestorCache;
	}

	/**
	 * Nome: getarqGestorCacheList
	 *
	 * Propósito: Método get para o atributo 'arqGestorCacheList'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorCacheList'
	 */
	public List<String> getarqGestorCacheList() {
		List<String> arqGestorCacheList = new ArrayList<String>();
		arqGestorCacheList.add(getValue("path_cadastrocache"));
		arqGestorCacheList.add(getValue("path_listacache"));
		return arqGestorCacheList;
	}

	/**
	 * Nome: getibCambio
	 *
	 * Propósito: Método get para o atributo 'ibCambio'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibCambio'
	 */
	public List<String> getibCambio() {
		List<String> ibCambio = new ArrayList<String>();
		ibCambio.add(getValue("menu_internetBanking"));
		ibCambio.add(getValue("menu_internetBanking_servicios"));
		return ibCambio;
	}

	/**
	 * Nome: getUIJsValueSet
	 *
	 * Propósito: Método get para o atributo 'UIJsValueSet'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIJsValueSet'
	 */
	public List<String> getUIJsValueSet() {
		List<String> UIJsValueSet = new ArrayList<String>();
		UIJsValueSet.add(getValue("menu.label.key.uiJsValueSet"));
		return UIJsValueSet;
	}

	/**
	 * Nome: getapplicationcacheHTML
	 *
	 * Propósito: Método get para o atributo 'applicationcacheHTML'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'applicationcacheHTML'
	 */
	public List<String> getapplicationcacheHTML() {
		List<String> applicationcacheHTML = new ArrayList<String>();
		applicationcacheHTML.add(getValue("path_cacheHTML"));
		return applicationcacheHTML;
	}

	/**
	 * Nome: getUISecretPhrase
	 *
	 * Propósito: Método get para o atributo 'UISecretPhrase'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UISecretPhrase'
	 */
	public List<String> getUISecretPhrase() {
		List<String> UISecretPhrase = new ArrayList<String>();
		UISecretPhrase.add(getValue("path_messages"));
		return UISecretPhrase;
	}

	/**
	 * Nome: getPresApplicationcomponents1 Propósito: Método get para o atributo
	 * 'presApplicationcomponents1' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents1'
	 */
	public List<String> getPresApplicationcomponents1() {
		List<String> presApplicationcomponents1 = new ArrayList<String>();
		presApplicationcomponents1.add(getValue("path_exemplo"));
		return presApplicationcomponents1;
	}

	/**
	 * Nome: getpresApplicationcomponents1 Propósito: Método get para o atributo
	 * 'presApplicationcomponents1' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents1'
	 */
	public List<String> getpresApplicationcomponents1() {
		List<String> presApplicationcomponents1 = new ArrayList<String>();
		presApplicationcomponents1.add(getValue("path_exemplo"));
		return presApplicationcomponents1;
	}

	/**
	 * Nome: getpresApplicationcomponents10
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents10'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents10'
	 */
	public List<String> getpresApplicationcomponents10() {
		List<String> presApplicationcomponents10 = new ArrayList<String>();
		presApplicationcomponents10
				.add(getValue("path_scrollabledatatable.colunas"));
		return presApplicationcomponents10;
	}

	/**
	 * Nome: getpresApplicationcomponents11
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents11'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents11'
	 */
	public List<String> getpresApplicationcomponents11() {
		List<String> presApplicationcomponents11 = new ArrayList<String>();
		presApplicationcomponents11.add(getValue("path_dualList"));
		return presApplicationcomponents11;
	}

	/**
	 * Nome: getpresApplicationcomponents12
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents12'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents12'
	 */
	public List<String> getpresApplicationcomponents12() {
		List<String> presApplicationcomponents12 = new ArrayList<String>();
		presApplicationcomponents12
				.add(getValue("menu.labelKey.uiDetailDataTable"));
		return presApplicationcomponents12;
	}

	/**
	 * Nome: getpresApplicationcomponents13
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents13'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents13'
	 */
	public List<String> getpresApplicationcomponents13() {
		List<String> presApplicationcomponents13 = new ArrayList<String>();
		presApplicationcomponents13
				.add(getValue("menu.labelKey.scrollabledatatable.selection"));
		return presApplicationcomponents13;
	}

	/**
	 * Nome: getpresApplicationcomponents14
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents14'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents14'
	 */
	public List<String> getpresApplicationcomponents14() {
		List<String> presApplicationcomponents14 = new ArrayList<String>();
		presApplicationcomponents14
				.add(getValue("menu.labelKey.scrollabledatatable.headergroup"));
		return presApplicationcomponents14;
	}

	/**
	 * Nome: getpresApplicationcomponents15
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents15'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents15'
	 */
	public List<String> getpresApplicationcomponents15() {
		List<String> presApplicationcomponents15 = new ArrayList<String>();
		presApplicationcomponents15
				.add(getValue("menu.labelKey.scrollabledatatable.horizontal"));
		return presApplicationcomponents15;
	}

	/**
	 * Nome: getpresApplicationcomponents16
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents16'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents16'
	 */
	public List<String> getpresApplicationcomponents16() {
		List<String> presApplicationcomponents16 = new ArrayList<String>();
		presApplicationcomponents16
				.add(getValue("path_scrollabledatatable.sort"));
		return presApplicationcomponents16;
	}

	/**
	 * Nome: getpresApplicationcomponents17
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents17'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents17'
	 */
	public List<String> getpresApplicationcomponents17() {
		List<String> presApplicationcomponents17 = new ArrayList<String>();
		presApplicationcomponents17.add(getValue("path_agencia"));
		return presApplicationcomponents17;
	}

	/**
	 * Nome: getpresApplicationcomponents18
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents18'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents18'
	 */
	public List<String> getpresApplicationcomponents18() {
		List<String> presApplicationcomponents18 = new ArrayList<String>();
		presApplicationcomponents18.add(getValue("path_agenciaConta"));
		return presApplicationcomponents18;
	}

	/**
	 * Nome: getpresApplicationcomponents2 Propósito: Método get para o atributo
	 * 'presApplicationcomponents2' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents2'
	 */
	public List<String> getpresApplicationcomponents2() {
		List<String> presApplicationcomponents2 = new ArrayList<String>();
		presApplicationcomponents2.add(getValue("path_alcada"));
		return presApplicationcomponents2;
	}

	/**
	 * Nome: getUIConta
	 *
	 * Propósito: Método get para o atributo 'UIConta'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIConta'
	 */
	public List<String> getUIConta() {
		List<String> UIConta = new ArrayList<String>();
		UIConta.add(getValue("menu.label.key.uiConta"));
		return UIConta;
	}

	/**
	 * Nome: getUIDeclaracaoConcordancia
	 *
	 * Propósito: Método get para o atributo 'UIDeclaracaoConcordancia'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIDeclaracaoConcordancia'
	 */
	public List<String> getUIDeclaracaoConcordancia() {
		List<String> UIDeclaracaoConcordancia = new ArrayList<String>();
		UIDeclaracaoConcordancia
				.add(getValue("menu.label.key.uiDeclaracaoConcordancia"));
		return UIDeclaracaoConcordancia;
	}

	/**
	 * Nome: getUIParagraph
	 *
	 * Propósito: Método get para o atributo 'UIParagraph'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIParagraph'
	 */
	public List<String> getUIParagraph() {
		List<String> UIParagraph = new ArrayList<String>();
		UIParagraph.add(getValue("path_paragraph"));
		return UIParagraph;
	}

	/**
	 * Nome: getpresApplicationcomponents24
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents24'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents24'
	 */
	public List<String> getpresApplicationcomponents24() {
		List<String> presApplicationcomponents24 = new ArrayList<String>();
		presApplicationcomponents24.add(getValue("path_criptografia"));
		return presApplicationcomponents24;
	}

	/**
	 * Nome: getUINumeroIdentificacao
	 *
	 * Propósito: Método get para o atributo 'UINumeroIdentificacao'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UINumeroIdentificacao'
	 */
	public List<String> getUINumeroIdentificacao() {
		List<String> UINumeroIdentificacao = new ArrayList<String>();
		UINumeroIdentificacao.add(getValue("path_numeroIdentificacao"));
		return UINumeroIdentificacao;
	}

	/**
	 * Nome: getpresApplicationcomponents3 Propósito: Método get para o atributo
	 * 'presApplicationcomponents3' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents3'
	 */
	public List<String> getpresApplicationcomponents3() {
		List<String> presApplicationcomponents3 = new ArrayList<String>();
		presApplicationcomponents3.add(getValue("path_calendar"));
		return presApplicationcomponents3;
	}

	/**
	 * Nome: getpresApplicationcomponents4 Propósito: Método get para o atributo
	 * 'presApplicationcomponents4' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents4'
	 */
	public List<String> getpresApplicationcomponents4() {
		List<String> presApplicationcomponents4 = new ArrayList<String>();
		presApplicationcomponents4.add(getValue("path_modalmessages"));
		return presApplicationcomponents4;
	}

	/**
	 * Nome: getpresApplicationcomponents5 Propósito: Método get para o atributo
	 * 'presApplicationcomponents5' Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents5'
	 */
	public List<String> getpresApplicationcomponents5() {
		List<String> presApplicationcomponents5 = new ArrayList<String>();
		presApplicationcomponents5.add(getValue("path_scrollabledatatable"));
		return presApplicationcomponents5;
	}

	/**
	 * Nome: getpresApplicationcomponents6
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents6'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents6'
	 */
	public List<String> getpresApplicationcomponents6() {
		List<String> presApplicationcomponents6 = new ArrayList<String>();
		presApplicationcomponents6.add(getValue("path_editableDataTable"));
		return presApplicationcomponents6;
	}

	/**
	 * Nome: getpresApplicationcomponents7
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents7'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents7'
	 */
	public List<String> getpresApplicationcomponents7() {
		List<String> presApplicationcomponents7 = new ArrayList<String>();
		presApplicationcomponents7.add(getValue("path_modal"));
		return presApplicationcomponents7;
	}

	/**
	 * Nome: getpresApplicationcomponents8
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents8'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents8'
	 */
	public List<String> getpresApplicationcomponents8() {
		List<String> presApplicationcomponents8 = new ArrayList<String>();
		presApplicationcomponents8.add(getValue("path_scrollAnchor"));
		return presApplicationcomponents8;
	}

	/**
	 * Nome: getCNPJValidator
	 *
	 * Propósito: Método get para o atributo 'CNPJValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'CNPJValidator'
	 */
	public List<String> getCNPJValidator() {
		List<String> CNPJValidator = new ArrayList<String>();
		CNPJValidator.add(getValue("path_messages"));
		return CNPJValidator;
	}

	/**
	 * Nome: getCPFValidator
	 *
	 * Propósito: Método get para o atributo 'CPFValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'CPFValidator'
	 */
	public List<String> getCPFValidator() {
		List<String> CPFValidator = new ArrayList<String>();
		CPFValidator.add(getValue("menu.label.key.uiCpfValidator"));
		return CPFValidator;
	}

	/**
	 * Nome: getlabTestcharCountercomponents
	 *
	 * Propósito: Método get para o atributo 'labTestcharCountercomponents'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'labTestcharCountercomponents'
	 */
	public List<String> getlabTestcharCountercomponents() {
		List<String> labTestcharCountercomponents = new ArrayList<String>();
		labTestcharCountercomponents.add(getValue("path_charCounter"));
		return labTestcharCountercomponents;
	}

	/**
	 * Nome: getlabTestcnpjib
	 *
	 * Propósito: Método get para o atributo 'labTestcnpjib'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'labTestcnpjib'
	 */
	public List<String> getlabTestcnpjib() {
		List<String> labTestcnpjib = new ArrayList<String>();
		labTestcnpjib.add(getValue("menu.labelKey.uiCnpj"));
		return labTestcnpjib;
	}

	/**
	 * Nome: getcommandLinkAjax
	 *
	 * Propósito: Método get para o atributo 'commandLinkAjax'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'commandLinkAjax'
	 */
	public List<String> getcommandLinkAjax() {
		List<String> commandLinkAjax = new ArrayList<String>();
		commandLinkAjax.add(getValue("path_commandLinkAjax"));
		return commandLinkAjax;
	}

	/**
	 * Nome: getlabTestformib
	 *
	 * Propósito: Método get para o atributo 'labTestformib'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'labTestformib'
	 */
	public List<String> getlabTestformib() {
		List<String> labTestformib = new ArrayList<String>();
		labTestformib.add(getValue("path_form"));
		return labTestformib;
	}

	/**
	 * Nome: getapplicationcomponentsUIHelper
	 *
	 * Propósito: Método get para o atributo 'applicationcomponentsUIHelper'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'applicationcomponentsUIHelper'
	 */
	public List<String> getapplicationcomponentsUIHelper() {
		List<String> applicationcomponentsUIHelper = new ArrayList<String>();
		applicationcomponentsUIHelper.add(getValue("label_ajuda"));
		return applicationcomponentsUIHelper;
	}

	/**
	 * Nome: getKeepState
	 *
	 * Propósito: Método get para o atributo 'keepState'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'keepState'
	 */
	public List<String> getKeepState() {
		List<String> KeepState = new ArrayList<String>();
		KeepState.add(getValue("path_keepState"));
		return KeepState;
	}

	/**
	 * Nome: getUILi
	 *
	 * Propósito: Método get para o atributo 'UILi'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UILi'
	 */
	public List<String> getUILi() {
		List<String> UILi = new ArrayList<String>();
		UILi.add(getValue("path_uiLi"));
		return UILi;
	}

	/**
	 * Nome: getlabTestsubmitCheckib
	 *
	 * Propósito: Método get para o atributo 'labTestsubmitCheckib'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'labTestsubmitCheckib'
	 */
	public List<String> getlabTestsubmitCheckib() {
		List<String> labTestsubmitCheckib = new ArrayList<String>();
		labTestsubmitCheckib.add(getValue("path_submitCheck"));
		return labTestsubmitCheckib;
	}

	/**
	 * Nome: getPDCDataScroller
	 *
	 * Propósito: Método get para o atributo 'PDCDataScroller'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'PDCDataScroller'
	 */
	public List<String> getPDCDataScroller() {
		List<String> PDCDataScroller = new ArrayList<String>();
		PDCDataScroller.add(getValue("menu.labelKey.pdcdatascroller"));
		return PDCDataScroller;
	}

	/**
	 * Nome: getpresApplicationcomponentsaddresource
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsaddresource'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsaddresource'
	 */
	public List<String> getpresApplicationcomponentsaddresource() {
		List<String> presApplicationcomponentsaddresource = new ArrayList<String>();
		presApplicationcomponentsaddresource.add(getValue("path_addResource"));
		return presApplicationcomponentsaddresource;
	}

	/**
	 * Nome: getpresApplicationcomponentsbundlewrite
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsbundlewrite'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsbundlewrite'
	 */
	public List<String> getpresApplicationcomponentsbundlewrite() {
		List<String> presApplicationcomponentsbundlewrite = new ArrayList<String>();
		presApplicationcomponentsbundlewrite.add(getValue("path_bundlewrite"));
		return presApplicationcomponentsbundlewrite;
	}

	/**
	 * Nome: getpresApplicationcomponentsdiv
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponentsdiv'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsdiv'
	 */
	public List<String> getpresApplicationcomponentsdiv() {
		List<String> presApplicationcomponentsdiv = new ArrayList<String>();
		presApplicationcomponentsdiv.add(getValue("path_grafic"));
		return presApplicationcomponentsdiv;
	}

	/**
	 * Nome: getpresApplicationcomponentsextInputHidden
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsextInputHidden'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsextInputHidden'
	 */
	public List<String> getpresApplicationcomponentsextInputHidden() {
		List<String> presApplicationcomponentsextInputHidden = new ArrayList<String>();
		presApplicationcomponentsextInputHidden.add(getValue("path_grafic"));
		return presApplicationcomponentsextInputHidden;
	}

	/**
	 * Nome: getpresApplicationcomponentshtmlTag
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponentshtmlTag'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentshtmlTag'
	 */
	public List<String> getpresApplicationcomponentshtmlTag() {
		List<String> presApplicationcomponentshtmlTag = new ArrayList<String>();
		presApplicationcomponentshtmlTag.add(getValue("path_htmltag"));
		return presApplicationcomponentshtmlTag;
	}

	/**
	 * Nome: getpresApplicationcomponentsjscss
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponentsjscss'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsjscss'
	 */
	public List<String> getpresApplicationcomponentsjscss() {
		List<String> presApplicationcomponentsjscss = new ArrayList<String>();
		presApplicationcomponentsjscss.add(getValue("menu.labelKey.jscss"));
		return presApplicationcomponentsjscss;
	}

	/**
	 * Nome: getapplicationcomponentsmyfacesCore
	 *
	 * Propósito: Método get para o atributo 'applicationcomponentsmyfacesCore'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'applicationcomponentsmyfacesCore'
	 */
	public List<String> getapplicationcomponentsmyfacesCore() {
		List<String> applicationcomponentsmyfacesCore = new ArrayList<String>();
		applicationcomponentsmyfacesCore
				.add(getValue("menu.labelkey.myfacescore"));
		return applicationcomponentsmyfacesCore;
	}

	/**
	 * Nome: getapplicationcomponentsmyfacesHtml
	 *
	 * Propósito: Método get para o atributo 'applicationcomponentsmyfacesHtml'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'applicationcomponentsmyfacesHtml'
	 */
	public List<String> getapplicationcomponentsmyfacesHtml() {
		List<String> applicationcomponentsmyfacesHtml = new ArrayList<String>();
		applicationcomponentsmyfacesHtml
				.add(getValue("menu.labelkey.myfaceshtml"));
		return applicationcomponentsmyfacesHtml;
	}

	/**
	 * Nome: getapplicationcomponentstomahawk
	 *
	 * Propósito: Método get para o atributo 'applicationcomponentstomahawk'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'applicationcomponentstomahawk'
	 */
	public List<String> getapplicationcomponentstomahawk() {
		List<String> applicationcomponentstomahawk = new ArrayList<String>();
		applicationcomponentstomahawk.add(getValue("path_tomahawk"));
		return applicationcomponentstomahawk;
	}

	/**
	 * Nome: getpresApplicationcomponentsuiboletocobranca
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsuiboletocobranca'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsuiboletocobranca'
	 */
	public List<String> getpresApplicationcomponentsuiboletocobranca() {
		List<String> presApplicationcomponentsuiboletocobranca = new ArrayList<String>();
		presApplicationcomponentsuiboletocobranca
				.add(getValue("path_boletoCobranca"));
		return presApplicationcomponentsuiboletocobranca;
	}

	/**
	 * Nome: getpresApplicationcomponentsuiboletopagamento
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsuiboletopagamento'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsuiboletopagamento'
	 */
	public List<String> getpresApplicationcomponentsuiboletopagamento() {
		List<String> presApplicationcomponentsuiboletopagamento = new ArrayList<String>();
		presApplicationcomponentsuiboletopagamento
				.add(getValue("path_boletoPagamento"));
		return presApplicationcomponentsuiboletopagamento;
	}

	/**
	 * Nome: getpresApplicationcomponentsuileftzero
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsuileftzero'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsuileftzero'
	 */
	public List<String> getpresApplicationcomponentsuileftzero() {
		List<String> presApplicationcomponentsuileftzero = new ArrayList<String>();
		presApplicationcomponentsuileftzero.add(getValue("path_leftzero"));
		return presApplicationcomponentsuileftzero;
	}

	/**
	 * Nome: getpresApplicationcomponentsuinextfocus
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsuinextfocus'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsuinextfocus'
	 */
	public List<String> getpresApplicationcomponentsuinextfocus() {
		List<String> presApplicationcomponentsuinextfocus = new ArrayList<String>();
		presApplicationcomponentsuinextfocus.add(getValue("path_nextfocus"));
		return presApplicationcomponentsuinextfocus;
	}

	/**
	 * Nome: getpresApplicationcomponentsuisavestate
	 *
	 * Propósito: Método get para o atributo
	 * 'presApplicationcomponentsuisavestate'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponentsuisavestate'
	 */
	public List<String> getpresApplicationcomponentsuisavestate() {
		List<String> presApplicationcomponentsuisavestate = new ArrayList<String>();
		presApplicationcomponentsuisavestate.add(getValue("path_savestate"));
		return presApplicationcomponentsuisavestate;
	}

	/**
	 * Nome: getpresArchitecturecomponentSEI
	 *
	 * Propósito: Método get para o atributo 'presArchitecturecomponentSEI'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturecomponentSEI'
	 */
	public List<String> getpresArchitecturecomponentSEI() {
		List<String> presArchitecturecomponentSEI = new ArrayList<String>();
		presArchitecturecomponentSEI.add(getValue("menu.labelKey.exemploSei1"));
		return presArchitecturecomponentSEI;
	}

	/**
	 * Nome: getpresArchitecturecomponentSEI2
	 *
	 * Propósito: Método get para o atributo 'presArchitecturecomponentSEI2'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturecomponentSEI2'
	 */
	public List<String> getpresArchitecturecomponentSEI2() {
		List<String> presArchitecturecomponentSEI = new ArrayList<String>();
		presArchitecturecomponentSEI.add(getValue("menu.labelKey.exemploSei2"));
		return presArchitecturecomponentSEI;
	}

	/**
	 * Nome: getpresArchitecturecomponentSEI3
	 *
	 * Propósito: Método get para o atributo 'presArchitecturecomponentSEI3'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturecomponentSEI3'
	 */
	public List<String> getpresArchitecturecomponentSEI3() {
		List<String> presArchitecturecomponentSEI3 = new ArrayList<String>();
		presArchitecturecomponentSEI3
				.add(getValue("menu.labelKey.exemploSei3"));
		return presArchitecturecomponentSEI3;
	}

	/**
	 * Nome: getUIApplet
	 *
	 * Propósito: Método get para o atributo 'UIApplet'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIApplet'
	 */
	public List<String> getUIApplet() {
		List<String> UIApplet = new ArrayList<String>();
		UIApplet.add(getValue("path_applet"));
		return UIApplet;
	}

	/**
	 * Nome: getUIEmbed
	 *
	 * Propósito: Método get para o atributo 'UIEmbed'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIEmbed'
	 */
	public List<String> getUIEmbed() {
		List<String> UIEmbed = new ArrayList<String>();
		UIEmbed.add(getValue("menu.labelkey.embed"));
		return UIEmbed;
	}

	/**
	 * Nome: getarchitecturecomponentextUIDataTable
	 *
	 * Propósito: Método get para o atributo
	 * 'architecturecomponentextUIDataTable'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'architecturecomponentextUIDataTable'
	 */
	public List<String> getarchitecturecomponentextUIDataTable() {
		List<String> architecturecomponentextUIDataTable = new ArrayList<String>();
		architecturecomponentextUIDataTable.add(getValue("path_dataTable"));
		return architecturecomponentextUIDataTable;
	}

	/**
	 * Nome: getdataUser
	 *
	 * Propósito: Método get para o atributo 'dataUser'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'dataUser'
	 */
	public List<String> getdataUser() {
		List<String> dataUser = new ArrayList<String>();
		dataUser.add(getValue("path_uiDataUser"));
		return dataUser;
	}

	/**
	 * Nome: getpresArchitecturecomponents
	 *
	 * Propósito: Método get para o atributo 'presArchitecturecomponents'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturecomponents'
	 */
	public List<String> getpresArchitecturecomponents() {
		List<String> presArchitecturecomponents = new ArrayList<String>();
		presArchitecturecomponents.add(getValue("path_exemplo"));
		return presArchitecturecomponents;
	}

	/**
	 * Nome: getbuffer
	 *
	 * Propósito: Método get para o atributo 'buffer'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'buffer'
	 */
	public List<String> getbuffer() {
		List<String> buffer = new ArrayList<String>();
		buffer.add(getValue("menu.label.key.uiBuffer"));
		return buffer;
	}

	/**
	 * Nome: getuiDataList
	 *
	 * Propósito: Método get para o atributo 'uiDataList'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'uiDataList'
	 */
	public List<String> getuiDataList() {
		List<String> uiDataList = new ArrayList<String>();
		uiDataList.add(getValue("menu.label.key.uiBrDataList"));
		return uiDataList;
	}

	/**
	 * Nome: getAWBCommandButton
	 *
	 * Propósito: Método get para o atributo 'AWBCommandButton'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'AWBCommandButton'
	 */
	public List<String> getAWBCommandButton() {
		List<String> AWBCommandButton = new ArrayList<String>();
		AWBCommandButton.add(getValue("path_messages"));
		return AWBCommandButton;
	}

	/**
	 * Nome: getPdcCommandButton
	 *
	 * Propósito: Método get para o atributo 'pdcCommandButton'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'pdcCommandButton'
	 */
	public List<String> getPdcCommandButton() {
		List<String> PdcCommandButton = new ArrayList<String>();
		PdcCommandButton.add(getValue("path_messages"));
		return PdcCommandButton;
	}

	/**
	 * Nome: getUIAppFrame
	 *
	 * Propósito: Método get para o atributo 'UIAppFrame'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIAppFrame'
	 */
	public List<String> getUIAppFrame() {
		List<String> UIAppFrame = new ArrayList<String>();
		UIAppFrame.add(getValue("path_uiAppFrame"));
		return UIAppFrame;
	}

	/**
	 * Nome: getcalendarPeriod
	 *
	 * Propósito: Método get para o atributo 'calendarPeriod'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'calendarPeriod'
	 */
	public List<String> getcalendarPeriod() {
		List<String> calendarPeriod = new ArrayList<String>();
		calendarPeriod.add(getValue("menu.labelKey.uiCalendarPeriod"));
		return calendarPeriod;
	}

	/**
	 * Nome: getcalendarValidator
	 *
	 * Propósito: Método get para o atributo 'calendarValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'calendarValidator'
	 */
	public List<String> getcalendarValidator() {
		List<String> calendarValidator = new ArrayList<String>();
		calendarValidator.add(getValue("menu.label.key.uiCalendarValidator"));
		return calendarValidator;
	}

	/**
	 * Nome: getcnpjValidator
	 *
	 * Propósito: Método get para o atributo 'cnpjValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'cnpjValidator'
	 */
	public List<String> getcnpjValidator() {
		List<String> cnpjValidator = new ArrayList<String>();
		cnpjValidator.add(getValue("menu.label.key.uiCnpjValidator"));
		return cnpjValidator;
	}

	/**
	 * Nome: getcommonsValidator
	 *
	 * Propósito: Método get para o atributo 'commonsValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'commonsValidator'
	 */
	public List<String> getcommonsValidator() {
		List<String> commonsValidator = new ArrayList<String>();
		commonsValidator.add(getValue("menu.label.key.uiCommonsValidator"));
		return commonsValidator;
	}

	/**
	 * Nome: getconditionalRequiredValidator
	 *
	 * Propósito: Método get para o atributo 'conditionalRequiredValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'conditionalRequiredValidator'
	 */
	public List<String> getconditionalRequiredValidator() {
		List<String> conditionalRequiredValidator = new ArrayList<String>();
		conditionalRequiredValidator
				.add(getValue("menu.label.key.uiConditionalRequiredValidator"));
		return conditionalRequiredValidator;
	}

	/**
	 * Nome: getcpfValidator
	 *
	 * Propósito: Método get para o atributo 'cpfValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'cpfValidator'
	 */
	public List<String> getcpfValidator() {
		List<String> cpfValidator = new ArrayList<String>();
		cpfValidator.add(getValue("menu.labelKey.cpfValidator"));
		return cpfValidator;
	}

	/**
	 * Nome: getequalsFieldValidator
	 *
	 * Propósito: Método get para o atributo 'equalsFieldValidator'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'equalsFieldValidator'
	 */
	public List<String> getequalsFieldValidator() {
		List<String> equalsFieldValidator = new ArrayList<String>();
		equalsFieldValidator
				.add(getValue("menu.label.key.uiEqualsFieldValueValidator"));
		return equalsFieldValidator;
	}

	/**
	 * Nome: getmascara
	 *
	 * Propósito: Método get para o atributo 'mascara'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'mascara'
	 */
	public List<String> getmascara() {
		List<String> mascara = new ArrayList<String>();
		mascara.add(getValue("menu.labelKey.uiMascara"));
		return mascara;
	}

	/**
	 * Nome: getmodalPanel
	 *
	 * Propósito: Método get para o atributo 'modalPanel'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'modalPanel'
	 */
	public List<String> getmodalPanel() {
		List<String> modalPanel = new ArrayList<String>();
		modalPanel.add(getValue("menu.labelKey.uiModalPanel"));
		return modalPanel;
	}

	/**
	 * Nome: getUIObjectManager
	 *
	 * Propósito: Método get para o atributo 'UIObjectManager'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'UIObjectManager'
	 */
	public List<String> getUIObjectManager() {
		List<String> UIObjectManager = new ArrayList<String>();
		UIObjectManager.add(getValue("menu.labelKey.objetos"));
		return UIObjectManager;
	}

	/**
	 * Nome: getpopUp
	 *
	 * Propósito: Método get para o atributo 'popUp'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'popUp'
	 */
	public List<String> getpopUp() {
		List<String> popUp = new ArrayList<String>();
		popUp.add(getValue("menu.labelKey.uiPopup"));
		return popUp;
	}

	/**
	 * Nome: getpresArqcomponentscaptcha
	 *
	 * Propósito: Método get para o atributo 'presArqcomponentscaptcha'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArqcomponentscaptcha'
	 */
	public List<String> getpresArqcomponentscaptcha() {
		List<String> presArqcomponentscaptcha = new ArrayList<String>();
		presArqcomponentscaptcha.add(getValue("path_captcha"));
		return presArqcomponentscaptcha;
	}

	/**
	 * Nome: getbrCommandSearch
	 *
	 * Propósito: Método get para o atributo 'brCommandSearch'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'brCommandSearch'
	 */
	public List<String> getbrCommandSearch() {
		List<String> brCommandSearch = new ArrayList<String>();
		brCommandSearch.add(getValue("menu.labelKey.uiCommandSearch"));
		return brCommandSearch;
	}

	/**
	 * Nome: getcalendarSchedule
	 *
	 * Propósito: Método get para o atributo 'calendarSchedule'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'calendarSchedule'
	 */
	public List<String> getcalendarSchedule() {
		List<String> calendarSchedule = new ArrayList<String>();
		calendarSchedule.add(getValue("menu.label.key.uiCalendarSchedule"));
		return calendarSchedule;
	}

	/**
	 * Nome: getcollapsiblePanel
	 *
	 * Propósito: Método get para o atributo 'collapsiblePanel'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'collapsiblePanel'
	 */
	public List<String> getcollapsiblePanel() {
		List<String> collapsiblePanel = new ArrayList<String>();
		collapsiblePanel.add(getValue("menu.labelKey.uiCollapsiblePanel"));
		return collapsiblePanel;
	}

	/**
	 * Nome: getcomparacao
	 *
	 * Propósito: Método get para o atributo 'comparacao'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'comparacao'
	 */
	public List<String> getcomparacao() {
		List<String> comparacao = new ArrayList<String>();
		comparacao.add(getValue("menu.labelKey.uiComparacao"));
		return comparacao;
	}

	/**
	 * Nome: getpresCustomcomponents1
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents1'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents1'
	 */
	public List<String> getpresCustomcomponents1() {
		List<String> presCustomcomponents1 = new ArrayList<String>();
		presCustomcomponents1.add(getValue("path_command"));
		return presCustomcomponents1;
	}

	/**
	 * Nome: getpresCustomcomponents2
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents2'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents2'
	 */
	public List<String> getpresCustomcomponents2() {
		List<String> presCustomcomponents2 = new ArrayList<String>();
		presCustomcomponents2.add(getValue("path_grafic"));
		return presCustomcomponents2;
	}

	/**
	 * Nome: getpresCustomcomponents3
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents3'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents3'
	 */
	public List<String> getpresCustomcomponents3() {
		List<String> presCustomcomponents3 = new ArrayList<String>();
		presCustomcomponents3.add(getValue("path_input"));
		return presCustomcomponents3;
	}

	/**
	 * Nome: getpresCustomcomponents4
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents4'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents4'
	 */
	public List<String> getpresCustomcomponents4() {
		List<String> presCustomcomponents4 = new ArrayList<String>();
		presCustomcomponents4.add(getValue("path_output"));
		return presCustomcomponents4;
	}

	/**
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents5'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents5'
	 */
	public List<String> getpresCustomcomponents5() {
		List<String> presCustomcomponents5 = new ArrayList<String>();
		presCustomcomponents5.add(getValue("path_messages"));
		return presCustomcomponents5;
	}

	/**
	 * Nome: getpresCustomcomponents6
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents6'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents6'
	 */
	public List<String> getpresCustomcomponents6() {
		List<String> presCustomcomponents6 = new ArrayList<String>();
		presCustomcomponents6.add(getValue("path_select"));
		return presCustomcomponents6;
	}

	/**
	 * Nome: getpresCustomcomponents7
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents7'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents7'
	 */
	public List<String> getpresCustomcomponents7() {
		List<String> presCustomcomponents7 = new ArrayList<String>();
		presCustomcomponents7.add(getValue("path_panelgrid"));
		return presCustomcomponents7;
	}

	/**
	 * Nome: getpresCustomcomponents8
	 *
	 * Propósito: Método get para o atributo 'presCustomcomponents8'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presCustomcomponents8'
	 */
	public List<String> getpresCustomcomponents8() {
		List<String> presCustomcomponents8 = new ArrayList<String>();
		presCustomcomponents8.add(getValue("path_scrollabledatatable.pag"));
		return presCustomcomponents8;
	}

	/**
	 * Nome: getimageViewer
	 *
	 * Propósito: Método get para o atributo 'imageViewer'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'imageViewer'
	 */
	public List<String> getimageViewer() {
		List<String> imageViewer = new ArrayList<String>();
		imageViewer.add(getValue("menu.label.key.uiImageViewer"));
		return imageViewer;
	}

	/**
	 * Nome: getpresIndicadorpassos1
	 *
	 * Propósito: Método get para o atributo 'presIndicadorpassos1'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presIndicadorpassos1'
	 */
	public List<String> getpresIndicadorpassos1() {
		List<String> presIndicadorpassos1 = new ArrayList<String>();
		presIndicadorpassos1.add(getValue("path_indicadorpassos1"));
		presIndicadorpassos1.add(getValue("path_indicadorpassos2"));
		presIndicadorpassos1.add(getValue("path_indicadorpassos3"));
		return presIndicadorpassos1;
	}

	/**
	 * Nome: getpresIndicadorpassos2
	 *
	 * Propósito: Método get para o atributo 'presIndicadorpassos2'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presIndicadorpassos2'
	 */
	public List<String> getpresIndicadorpassos2() {
		List<String> presIndicadorpassos2 = new ArrayList<String>();
		presIndicadorpassos2.add(getValue("path_indicadorpassos1"));
		presIndicadorpassos2.add(getValue("path_indicadorpassos2"));
		presIndicadorpassos2.add(getValue("path_indicadorpassos3"));
		return presIndicadorpassos2;
	}

	/**
	 * Nome: getpresIndicadorpassos3
	 *
	 * Propósito: Método get para o atributo 'presIndicadorpassos3'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presIndicadorpassos3'
	 */
	public List<String> getpresIndicadorpassos3() {
		List<String> presIndicadorpassos3 = new ArrayList<String>();
		presIndicadorpassos3.add(getValue("path_indicadorpassos1"));
		presIndicadorpassos3.add(getValue("path_indicadorpassos2"));
		presIndicadorpassos3.add(getValue("path_indicadorpassos3"));
		return presIndicadorpassos3;
	}

	/**
	 * Nome: getnavpagTesteMenu
	 *
	 * Propósito: Método get para o atributo 'navpagTesteMenu'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'navpagTesteMenu'
	 */
	public List<String> getnavpagTesteMenu() {
		List<String> navpagTesteMenu = new ArrayList<String>();
		navpagTesteMenu.add(getValue("menu.labelKey.testeRegrasMenu"));
		return navpagTesteMenu;
	}

	/**
	 * Nome: getpresArchitecturepaginationAPI
	 *
	 * Propósito: Método get para o atributo 'presArchitecturepaginationAPI'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturepaginationAPI'
	 */
	public List<String> getpresArchitecturepaginationAPI() {
		List<String> presArchitecturepaginationAPI = new ArrayList<String>();
		presArchitecturepaginationAPI.add(getValue("path_apiPaginacao"));
		return presArchitecturepaginationAPI;
	}

	/**
	 * Nome: getpresArchitecturemultiPagination
	 *
	 * Propósito: Método get para o atributo 'presArchitecturemultiPagination'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presArchitecturemultiPagination'
	 */
	public List<String> getpresArchitecturemultiPagination() {
		List<String> presArchitecturemultiPagination = new ArrayList<String>();
		presArchitecturemultiPagination.add(getValue("path_paginationMult"));
		return presArchitecturemultiPagination;
	}

	/**
	 * Nome: getsecretPhrase
	 *
	 * Propósito: Método get para o atributo 'secretPhrase'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'secretPhrase'
	 */
	public List<String> getsecretPhrase() {
		List<String> secretPhrase = new ArrayList<String>();
		secretPhrase.add(getValue("menu.label.key.uiSecretPhrase"));
		return secretPhrase;
	}

	/**
	 * Nome: getconsultarprodutoservico
	 *
	 * Propósito: Método get para o atributo 'consultarprodutoservico'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'consultarprodutoservico'
	 */
	public List<String> getconsultarprodutoservico() {
		List<String> consultarprodutoservico = new ArrayList<String>();
		consultarprodutoservico.add(getValue("menu_internetBanking"));
		return consultarprodutoservico;
	}

	/**
	 * Nome: getmemoryDataScroller
	 *
	 * Propósito: Método get para o atributo 'memoryDataScroller'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'memoryDataScroller'
	 */
	public List<String> getmemoryDataScroller() {
		List<String> memoryDataScroller = new ArrayList<String>();
		memoryDataScroller.add(getValue("menu.labelKey.memorydatascroller"));
		return memoryDataScroller;
	}

	/**
	 * Nome: getpagSessaoUnif
	 *
	 * Propósito: Método get para o atributo 'pagSessaoUnif'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'pagSessaoUnif'
	 */
	public List<String> getpagSessaoUnif() {
		List<String> pagSessaoUnif = new ArrayList<String>();
		pagSessaoUnif.add(getValue("menu.labelKey.sessaoUnificada"));
		return pagSessaoUnif;
	}

	/**
	 * Nome: gettxtDataScroller
	 *
	 * Propósito: Método get para o atributo 'txtDataScroller'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'txtDataScroller'
	 */
	public List<String> gettxtDataScroller() {
		List<String> txtDataScroller = new ArrayList<String>();
		txtDataScroller.add(getValue("menu.labelKey.txtdatascroller"));
		return txtDataScroller;
	}

	/**
	 * Nome: getarqCriptografia
	 *
	 * Propósito: Método get para o atributo 'arqCriptografia'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqCriptografia'
	 */
	public List<String> getarqCriptografia() {
		List<String> arqCriptografia = new ArrayList<String>();
		arqCriptografia.add(getValue("path_criptografia"));
		return arqCriptografia;
	}

	/**
	 * Nome: getarqGestorAlertas
	 *
	 * Propósito: Método get para o atributo 'arqGestorAlertas'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorAlertas'
	 */
	public List<String> getarqGestorAlertas() {
		List<String> arqGestorAlertas = new ArrayList<String>();
		arqGestorAlertas.add(getValue("path_alertas"));
		return arqGestorAlertas;
	}

	/**
	 * Nome: getarqGestorObjetos
	 *
	 * Propósito: Método get para o atributo 'arqGestorObjetos'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorObjetos'
	 */
	public List<String> getarqGestorObjetos() {
		List<String> arqGestorObjetos = new ArrayList<String>();
		arqGestorObjetos.add(getValue("path_objetos"));
		return arqGestorObjetos;
	}

	/**
	 * Nome: getarqGestorSesion
	 *
	 * Propósito: Método get para o atributo 'arqGestorSesion'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorSesion'
	 */
	public List<String> getarqGestorSesion() {
		List<String> arqGestorSesion = new ArrayList<String>();
		arqGestorSesion.add(getValue("path_sessao"));
		return arqGestorSesion;
	}

	/**
	 * Nome: getkeepalive
	 *
	 * Propósito: Método get para o atributo 'keepalive'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'keepalive'
	 */
	public List<String> getkeepalive() {
		List<String> keepalive = new ArrayList<String>();
		keepalive.add(getValue("path_keepalive"));
		return keepalive;
	}

	/**
	 * Nome: getarqLanzamientoExcepciones
	 *
	 * Propósito: Método get para o atributo 'arqLanzamientoExcepciones'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqLanzamientoExcepciones'
	 */
	public List<String> getarqLanzamientoExcepciones() {
		List<String> arqLanzamientoExcepciones = new ArrayList<String>();
		arqLanzamientoExcepciones.add(getValue("path_excecoes"));
		return arqLanzamientoExcepciones;
	}

	/**
	 * Nome: getactionpage
	 *
	 * Propósito: Método get para o atributo 'actionpage'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'actionpage'
	 */
	public List<String> getactionpage() {
		List<String> actionpage = new ArrayList<String>();
		actionpage.add(getValue("path_appframe"));
		return actionpage;
	}

	/**
	 * Nome: getibExtrato
	 *
	 * Propósito: Método get para o atributo 'ibExtrato'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibExtrato'
	 */
	public List<String> getibExtrato() {
		List<String> ibExtrato = new ArrayList<String>();
		ibExtrato.add(getValue("menu_internetBanking"));
		ibExtrato.add(getValue("menu_internetBanking_servicios"));
		return ibExtrato;
	}

	/**
	 * Nome: getarqFiltro
	 *
	 * Propósito: Método get para o atributo 'arqFiltro'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqFiltro'
	 */
	public List<String> getarqFiltro() {
		List<String> arqFiltro = new ArrayList<String>();
		arqFiltro.add(getValue("menu_arquitectura"));
		arqFiltro.add(getValue("menu_arquitectura_filtro"));
		return arqFiltro;
	}

	/**
	 * Nome: getarqLog
	 *
	 * Propósito: Método get para o atributo 'arqLog'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqLog'
	 */
	public List<String> getarqLog() {
		List<String> arqLog = new ArrayList<String>();
		arqLog.add(getValue("path_log"));
		return arqLog;
	}

	/**
	 * Nome: getarqGestorMonitor
	 *
	 * Propósito: Método get para o atributo 'arqGestorMonitor'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqGestorMonitor'
	 */
	public List<String> getarqGestorMonitor() {
		List<String> arqGestorMonitor = new ArrayList<String>();
		arqGestorMonitor.add(getValue("path_monitor"));
		return arqGestorMonitor;
	}

	/**
	 * Nome: getibTeste1
	 *
	 * Propósito: Método get para o atributo 'ibTeste1'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibTeste1'
	 */
	public List<String> getibTeste1() {
		List<String> ibTeste1 = new ArrayList<String>();
		ibTeste1.add(getValue("menu_internetBanking"));
		ibTeste1.add(getValue("menu_internetBanking_servicios"));
		return ibTeste1;
	}

	/**
	 * Nome: getibTransferencia2
	 *
	 * Propósito: Método get para o atributo 'ibTransferencia2'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibTransferencia2'
	 */
	public List<String> getibTransferencia2() {
		List<String> ibTransferencia2 = new ArrayList<String>();
		ibTransferencia2.add(getValue("menu_internetBanking"));
		ibTransferencia2.add(getValue("menu_internetBanking_servicios"));
		return ibTransferencia2;
	}

	/**
	 * Nome: getibTransferencia3
	 *
	 * Propósito: Método get para o atributo 'ibTransferencia3'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibTransferencia3'
	 */
	public List<String> getibTransferencia3() {
		List<String> ibTransferencia3 = new ArrayList<String>();
		ibTransferencia3.add(getValue("menu_internetBanking"));
		ibTransferencia3.add(getValue("menu_internetBanking_servicios"));
		return ibTransferencia3;
	}

	/**
	 * Nome: getibTransferenciaFail
	 *
	 * Propósito: Método get para o atributo 'ibTransferenciaFail'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'ibTransferenciaFail'
	 */
	public List<String> getibTransferenciaFail() {
		List<String> ibTransferenciaFail = new ArrayList<String>();
		ibTransferenciaFail.add(getValue("menu_internetBanking"));
		ibTransferenciaFail.add(getValue("menu_internetBanking_servicios"));
		return ibTransferenciaFail;
	}

	/**
	 * Nome: getuiScrollableDataTable
	 *
	 * Propósito: Método get para o atributo 'uiScrollableDataTable'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'uiScrollableDataTable'
	 */
	public List<String> getuiScrollableDataTable() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.uiScrollableDataTable"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getActionParam
	 *
	 * Propósito: Método get para o atributo 'actionParam'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'actionParam'
	 */
	public List<String> getActionParam() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.uiActionParameter"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getRegion
	 *
	 * Propósito: Método get para o atributo 'region'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'region'
	 */
	public List<String> getRegion() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.uiRegion"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getjsFuncion
	 *
	 * Propósito: Método get para o atributo 'jsFuncion'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'jsFuncion'
	 */
	public List<String> getjsFuncion() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.jsfunction"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getnaomultiPagination
	 *
	 * Propósito: Método get para o atributo 'naomultiPagination'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'naomultiPagination'
	 */
	public List<String> getnaomultiPagination() {
		List<String> presArchitecturemultiPagination = new ArrayList<String>();
		presArchitecturemultiPagination.add(getValue("path_paginationNaoMult"));
		return presArchitecturemultiPagination;
	}

	/**
	 * Nome: getStatus
	 *
	 * Propósito: Método get para o atributo 'status'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'status'
	 */
	public List<String> getStatus() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.status"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getawbdatascroller
	 *
	 * Propósito: Método get para o atributo 'awbdatascroller'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'awbdatascroller'
	 */
	public List<String> getawbdatascroller() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.awbdatascroller"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getconectores
	 *
	 * Propósito: Método get para o atributo 'conectores'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'conectores'
	 */
	public List<String> getconectores() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("path_conectores"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getarqPlataformaOpen1
	 *
	 * Propósito: Método get para o atributo 'arqPlataformaOpen1'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqPlataformaOpen1'
	 */
	public List<String> getarqPlataformaOpen1() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao
				.add(getValue("menu.labelKey.arquitetura.plataformaopen.exemplo"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getarqPlataformaOpen2
	 *
	 * Propósito: Método get para o atributo 'arqPlataformaOpen2'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'arqPlataformaOpen2'
	 */
	public List<String> getarqPlataformaOpen2() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao
				.add(getValue("menu.labelKey.arquitetura.plataformaopen.exemplo2"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getcache
	 *
	 * Propósito: Método get para o atributo 'cache'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'cache'
	 */
	public List<String> getcache() {
		List<String> listaCaminhoPao = new ArrayList<String>();
		listaCaminhoPao.add(getValue("menu.labelKey.cache"));
		return listaCaminhoPao;
	}

	/**
	 * Nome: getpresApplicationcomponents7
	 *
	 * Propósito: Método get para o atributo 'presApplicationcomponents7'
	 *
	 * Data: 30/11/2015 <br/>
	 * .
	 *
	 * @author vinicius.christ copyright Copyright (c) 2015 <br/>
	 * @return 'presApplicationcomponents7'
	 */
	public List<String> getModalContent() {
		List<String> presApplicationcomponents7 = new ArrayList<String>();
		presApplicationcomponents7
				.add(getValue("menu.labelKey.uiModalContent"));
		return presApplicationcomponents7;
	}

	public List<String> getPathParametrizacaoRelatorio() {
		List<String> lista = new ArrayList<String>(3);
		lista.add(getValue("label_parametrizacao"));
		lista.add(getValue("label_parametrizacao_relatorio"));
		return lista;
	}

	public List<String> getPathQuestionarioCorporate() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));
		lista.add(getValue("label_corporate"));
		return lista;
	}

	public List<String> getPathQuestionarioLargeCorporate() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));
		lista.add(getValue("label_large_corporate"));
		return lista;
	}

	public List<String> getPathQuestionarioEmpresas() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));
		lista.add(getValue("label_empresas"));
		return lista;
	}

	public List<String> getPathAltoVarejo() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));
		lista.add(getValue("label_alto_varejo"));
		return lista;
	}

	public List<String> getPathCadastroRelatorio() {
		List<String> lista = new ArrayList<String>(2);
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));
		return lista;
	}

	public List<String> getPathQuestionarioSetor(String paginaAnteriorTiles,
			String setor) {
		List<String> lista = new ArrayList<String>(4);
		lista.add(getValue("label_cadastro"));
		lista.add(getValue("label_cadastramento_ric"));

		String labelSegmento = SegmentoEnum
				.getSegmentoLabelByPaginaAnteriorTiles(paginaAnteriorTiles);
		lista.add(getValue(labelSegmento));
		lista.add(getValue(setor));
		return lista;
	}

	public List<String> getPathDuplaValidacaoParam() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_dupla_validacao"));
		lista.add(getValue("label_parametrizacao_relatorio"));

		return lista;
	}

	/*
	 * conteúdo do treinamento RICC
	 */

	public List<String> getPathTreinamentoAjuda() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_ajuda"));

		return lista;
	}

	public List<String> getPathLeonardoCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_leonardo"));
		lista.add(getValue("label_treinamento_title_leonardo_cliente"));
		return lista;
	}

	public List<String> getPathTreinamentoAndreCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_andre_treinamento"));
		lista.add(getValue("label_andre"));
		lista.add(getValue("label_andre_title"));

		return lista;
	}

	public List<String> getPathIsaacCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_isaac"));
		lista.add(getValue("label_treinamento_isaac_cliente"));

		return lista;
	}

	public List<String> getPathCadastroClienteWellington() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_wellington_treinamento"));
		lista.add(getValue("label_treinamento_wellington"));
		lista.add(getValue("label_treinamento_wellington_cliente"));

		return lista;
	}

	public List<String> getPathTesteCadastroClienteWellington() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_wellington_treinamento"));
		lista.add(getValue("menu_arquitectura_filtro_teste"));
		lista.add(getValue("label_wellington"));
		lista.add(getValue("label_cadastro"));

		return lista;
	}

	public List<String> getPathTesteConsultaClienteWellington() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_wellington_treinamento"));
		lista.add(getValue("menu_arquitectura_filtro_teste"));
		lista.add(getValue("label_wellington"));
		lista.add(getValue("label_consultar"));

		return lista;
	}

	public List<String> getPathAndersonClienteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_anderson"));
		lista.add(getValue("label_treinamento_anderson_cadastro"));

		return lista;
	}

	public List<String> getPathAndersonClienteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_anderson"));
		lista.add(getValue("label_treinamento_anderson_consulta"));

		return lista;
	}

	public List<String> getPathAndersonTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_anderson"));
		lista.add(getValue("label_treinamento_anderson_cadastro"));

		return lista;
	}

	public List<String> getPathCadastroClienteJoaoGil() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_joaogil"));
		lista.add(getValue("label_treinamento_joaogil_cliente"));

		return lista;
	}

	public List<String> getPathCadastroEnzo() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_enzo"));
		lista.add(getValue("label_cliente"));

		return lista;
	}

	public List<String> getPathCadastroEnzoTeste() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_enzo"));
		lista.add(getValue("label_cadastro"));

		return lista;
	}

	public List<String> getPathConsultarEnzoTeste() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_enzo"));
		lista.add(getValue("Consulta"));

		return lista;
	}

	public List<String> getPathCadastroClienteJoaoCarlos() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_joao"));
		lista.add(getValue("label_treinamento_joaocarlos_cliente"));

		return lista;
	}

	public List<String> getPathEnricoCadastroCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_enrico"));
		lista.add(getValue("label_treinamento_title_leonardo_cliente"));

		return lista;
	}

	public List<String> getPathEnricoCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_enrico"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathEnricoConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_enrico"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoClienteVitoria() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_vitoria"));
		lista.add(getValue("label_treinamento_title_vitoria"));
		return lista;
	}

	public List<String> getPathTreinamentoClienteConsultarVitoria() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_vitoria"));
		lista.add(getValue("label_treinamento_vitoria_cliente"));
		return lista;
	}

	public List<String> getPathTreinamentoPedroCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_pedro"));
		lista.add(getValue("label_treinamento_pedro_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoPedroSWRM() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_pedro"));
		lista.add(getValue("label_treinamento_pedro_swrm"));

		return lista;
	}

	public List<String> getPathMatheusClienteInserir() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_matheus"));
		lista.add(getValue("label_treinamento_matheus_cadastro"));

		return lista;
	}

	public List<String> getPathFelipeClienteInserir() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_felipe"));
		lista.add(getValue("label_treinamento_felipe_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoGuilhermeCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_guilherme"));
		lista.add(getValue("label_treinamento_guilherme_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoNataliaCadastroCliente() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_natalia"));
		lista.add(getValue("label_treinamento_natalia_cliente"));

		return lista;
	}

	public List<String> getPathClaudioClienteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_claudio"));
		lista.add(getValue("label_treinamento_claudio_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoGustavo() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_gustavo"));
		lista.add(getValue("label_gustavo"));
		lista.add(getValue("label_treinamento_gustavo_cliente"));
		return lista;
	}

	public List<String> getPathViniciusCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_vinicius_treinamento"));
		lista.add(getValue("label_vinicius_vinicius"));
		lista.add(getValue("label_vinicius_cadastro"));

		return lista;
	}

	public List<String> getPathViniciusConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_vinicius_treinamento"));
		lista.add(getValue("label_vinicius_vinicius"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathQuestionarioCorporateEquipe1() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_equipe1"));
		lista.add(getValue("label_corporate"));
		return lista;
	}

	public List<String> getPathQuestionarioCorporateAgronegocioEquipe1() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_equipe1"));
		lista.add(getValue("label_corporate"));
		lista.add(getValue("label_agronegocio"));
		return lista;
	}

	public List<String> getPathQuestionarioCorporateProjetoEquipe1() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_equipe1"));
		lista.add(getValue("label_corporate"));
		lista.add(getValue("label_projetos"));
		return lista;
	}

	public List<String> getPathQuestionarioCorporateImobiliarioEquipe1() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_equipe1"));
		lista.add(getValue("label_corporate"));
		lista.add(getValue("label_imobiliario"));
		return lista;
	}

	public List<String> getPathQuestionarioCorporateTransportesEquipe1() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_equipe1"));
		lista.add(getValue("label_corporate"));
		lista.add(getValue("label_transporte"));
		return lista;
	}

	// Equipe 3 BreadCrumbs
	public List<String> getPathAltoVarejoEquipe3() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_equipe3_2"));
		lista.add(getValue("label_alto_varejo"));
		return lista;
	}

	public List<String> getEquipe3PathImobiliario() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_equipe3_2"));
		lista.add(getValue("label_alto_varejo"));
		lista.add(getValue("label_imobiliario"));
		return lista;
	}

	public List<String> getEquipe3PathTransporte() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_equipe3_2"));
		lista.add(getValue("label_alto_varejo"));
		lista.add(getValue("label_transporte"));
		return lista;
	}

	public List<String> getEquipe3PathProjeto() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_equipe3_2"));
		lista.add(getValue("label_alto_varejo"));
		lista.add(getValue("label_projetos"));
		return lista;
	}

	public List<String> getEquipe3PathAgronegocio() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_equipe3_2"));
		lista.add(getValue("label_alto_varejo"));
		lista.add(getValue("label_agronegocio"));
		return lista;
	}

	/**
	 * EQUIPE 4
	 * */

	public List<String> getPathEquipe4() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_consulta_cliente"));
		lista.add(getValue("label_treinamento_equipe_4"));
		lista.add(getValue("label_large_corporate"));
		return lista;
	}

	public List<String> getPathEquipe4Imobiliario() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_consulta_cliente"));
		lista.add(getValue("label_treinamento_equipe_4"));
		lista.add(getValue("label_large_corporate"));
		lista.add(getValue("label_imobiliario_equipe_4"));
		return lista;
	}

	public List<String> getPathEquipe4Projeto() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_consulta_cliente"));
		lista.add(getValue("label_treinamento_equipe_4"));
		lista.add(getValue("label_large_corporate"));
		lista.add(getValue("label_projeto_equipe_4"));
		return lista;
	}

	public List<String> getPathEquipe4Transporte() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_consulta_cliente"));
		lista.add(getValue("label_treinamento_equipe_4"));
		lista.add(getValue("label_large_corporate"));
		lista.add(getValue("label_transporte_equipe_4"));
		return lista;
	}

	public List<String> getPathEquipe4Agronegocio() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento_consulta_cliente"));
		lista.add(getValue("label_treinamento_equipe_4"));
		lista.add(getValue("label_large_corporate"));
		lista.add(getValue("label_agronegocio_equipe_4"));
		return lista;
	}

	// TESTE GUILHERME

	public List<String> getPathGuilhermeTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_guilherme"));
		lista.add(getValue("label_treinamento_anderson_cadastro"));

		return lista;
	}

	public List<String> getPathGuilhermeTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_guilherme"));
		lista.add(getValue("label_treinamento_anderson_consulta"));

		return lista;
	}

	// BREADCRUMB TESTE LEONARDO
	public List<String> getPathLeonardoTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_leonardo"));
		lista.add(getValue("label_cadastro"));

		return lista;
	}

	public List<String> getPathLeonardoTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_leonardo"));
		lista.add(getValue("label_consultar"));

		return lista;
	}

	public List<String> getPathPedroTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_pedro"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));
		return lista;
	}

	public List<String> getPathPedroTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_pedro"));
		lista.add(getValue("label_treinamento_consulta_cliente"));
		return lista;
	}

	public List<String> getPathTesteJoaogilCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_gil"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathTesteJoaogilConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_gil"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoTesteVitoria() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_vitoria"));
		lista.add(getValue("label_treinamento_title_vitoria"));
		return lista;
	}

	public List<String> getPathTreinamentoTesteConsultarVitoria() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_vitoria"));
		lista.add(getValue("label_consultar"));
		return lista;
	}

	public List<String> getPathMatheusTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_matheus"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathMatheusTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_matheus"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathFelipeTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_felipe"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_felipe_cliente"));

		return lista;
	}

	public List<String> getPathFelipeTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_felipe"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_treinamento_felipe_cliente"));

		return lista;
	}

	public List<String> getPathTreinamentoTesteGustavoCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_gustavo"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));
		return lista;
	}

	public List<String> getPathTreinamentoTesteGustavoConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_gustavo"));
		lista.add(getValue("label_consultar"));
		return lista;
	}

	public List<String> getPathNataliaTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_natalia"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathNataliaTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_natalia"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathTesteJoaoCarlosCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_joao"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));
		return lista;
	}

	public List<String> getPathTesteJoaoCarlosConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_joao"));
		lista.add(getValue("label_treinamento_consulta_cliente"));
		return lista;
	}

	public List<String> getPathTesteAndreCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_andre_treinamento"));
		lista.add(getValue("menu_arquitectura_filtro_teste"));
		lista.add(getValue("label_andre"));
		lista.add(getValue("label_cadastro"));

		return lista;
	}

	public List<String> getPathTesteAndreConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_andre_treinamento"));
		lista.add(getValue("menu_arquitectura_filtro_teste"));
		lista.add(getValue("label_andre"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathIsaacTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_isaac"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	public List<String> getPathIsaacTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_teste"));
		lista.add(getValue("label_isaac"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathClaudioTesteCadastro() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_claudio"));
		lista.add(getValue("label_treinamento_consulta_cliente"));

		return lista;
	}

	public List<String> getPathClaudioTesteConsulta() {
		List<String> lista = new ArrayList<String>();
		lista.add(getValue("label_treinamento"));
		lista.add(getValue("label_treinamento_teste"));
		lista.add(getValue("label_claudio"));
		lista.add(getValue("label_treinamento_cadastro_cliente"));

		return lista;
	}

	/**
	 * Nome: getPathManutencaoMensagem
	 *
	 * Propósito: Método get para o atributo 'PathManutencaoMensagem'
	 *
	 * Data: 09/06/2020 <br/>
	 * 
	 * @return 'pathManutencaoMensagemList'
	 */
	public List<String> getPathManutencaoMensagem() {
		List<String> pathManutencaoMensagemList = new ArrayList<String>();
		pathManutencaoMensagemList.add(getValue("label_manutencao_mensagem"));
		pathManutencaoMensagemList.add(getValue("label_consultar_mensagem"));
		return pathManutencaoMensagemList;
	}

	public List<String> getPathListaMensagem() {
		List<String> pathListaMensagemList = new ArrayList<String>();
		pathListaMensagemList.add(getValue("label_manutencao_mensagem"));
		pathListaMensagemList.add(getValue("label_consultar_mensagem"));
		pathListaMensagemList.add(getValue("label_listar_mensagem"));
		return pathListaMensagemList;
	}

	public List<String> getPathIncluirMensagem() {
		List<String> pathIncluirMensagemList = new ArrayList<String>();
		pathIncluirMensagemList.add(getValue("label_manutencao_mensagem"));
		pathIncluirMensagemList.add(getValue("label_incluir_mensagem"));
		return pathIncluirMensagemList;
	}

	public List<String> getPathDetalharMensagem() {
		List<String> pathDetalharMensagemList = new ArrayList<String>();
		pathDetalharMensagemList.add(getValue("label_manutencao_mensagem"));
		pathDetalharMensagemList.add(getValue("label_consultar_mensagem"));
		pathDetalharMensagemList.add(getValue("label_listar_mensagem"));
		pathDetalharMensagemList.add(getValue("label_detalhar_mensagem"));
		return pathDetalharMensagemList;
	}

	public List<String> getPathAlterarMensagem() {
		List<String> pathAlterarMensagemList = new ArrayList<String>();
		pathAlterarMensagemList.add(getValue("label_manutencao_mensagem"));
		pathAlterarMensagemList.add(getValue("label_consultar_mensagem"));
		pathAlterarMensagemList.add(getValue("label_listar_mensagem"));
		pathAlterarMensagemList.add(getValue("label_alterar_mensagem"));
		return pathAlterarMensagemList;
	}

	public List<String> getPathIncluirTemplate() {
		List<String> pathIncluirTemplateList = new ArrayList<String>();
		pathIncluirTemplateList.add(getValue("label_manutencao_template"));
		pathIncluirTemplateList.add(getValue("label_incluir_template"));
		return pathIncluirTemplateList;
	}

	public List<String> getPathConsultarTemplate() {
		List<String> pathConsultarTemplateList = new ArrayList<String>();
		pathConsultarTemplateList.add(getValue("label_manutencao_template"));
		pathConsultarTemplateList.add(getValue("label_consultar_template"));
		return pathConsultarTemplateList;
	}

	public List<String> getPathListarTemplate() {
		List<String> pathListarTemplateList = new ArrayList<String>();
		pathListarTemplateList.add(getValue("label_manutencao_template"));
		pathListarTemplateList.add(getValue("label_consultar_template"));
		pathListarTemplateList.add(getValue("label_listar_template"));
		return pathListarTemplateList;
	}

	public List<String> getPathDetalharTemplate() {
		List<String> pathDetalharTemplateList = new ArrayList<String>();
		pathDetalharTemplateList.add(getValue("label_manutencao_templates"));
		pathDetalharTemplateList.add(getValue("label_consultar_template"));
		pathDetalharTemplateList.add(getValue("label_listar_template"));
		pathDetalharTemplateList.add(getValue("label_detalhar_template"));
		return pathDetalharTemplateList;
	}

	public List<String> getPathAlterarTemplate() {
		List<String> pathAlterarTemplateList = new ArrayList<String>();
		pathAlterarTemplateList.add(getValue("label_manutencao_templates"));
		pathAlterarTemplateList.add(getValue("label_consultar_template"));
		pathAlterarTemplateList.add(getValue("label_listar_template"));
		pathAlterarTemplateList.add(getValue("label_alterar_template"));
		return pathAlterarTemplateList;
	}

	public List<String> getPathFormatosMensagem() {
		List<String> pathConsultarTemplateList = new ArrayList<String>();
		pathConsultarTemplateList.add(getValue("label_parametrizacao"));
		pathConsultarTemplateList
				.add(getValue("label_incluir_formatos_mensagem"));
		return pathConsultarTemplateList;
	}

	public List<String> getPathIncluirComponenteMensagem() {
		List<String> pathIncluirComponenteMensagemList = new ArrayList<String>();
		pathIncluirComponenteMensagemList
				.add(getValue("label_componente_mensagem"));
		pathIncluirComponenteMensagemList
				.add(getValue("label_incluir_componente_mensagem"));
		return pathIncluirComponenteMensagemList;
	}

	public List<String> getPathConsultarComponenteMensagem() {
		List<String> pathConsultarComponenteMensagemList = new ArrayList<String>();
		pathConsultarComponenteMensagemList
				.add(getValue("label_componente_mensagem"));
		pathConsultarComponenteMensagemList
				.add(getValue("label_consultar_componente_mensagem"));
		return pathConsultarComponenteMensagemList;
	}

	public List<String> getPathConsultarFormatoMensagem() {
		List<String> pathIncluirComponenteMensagemList = new ArrayList<String>();
		pathIncluirComponenteMensagemList.add(getValue("label_parametrizacao"));
		pathIncluirComponenteMensagemList
				.add(getValue("label_consultar_formato_mensagem"));
		return pathIncluirComponenteMensagemList;
	}

	public List<String> getPathAlterarComponenteMensagem() {
		List<String> pathAlterarComponenteMensagemList = new ArrayList<String>();
		pathAlterarComponenteMensagemList
				.add(getValue("label_componente_mensagem"));
		pathAlterarComponenteMensagemList
				.add(getValue("label_consultar_componente_mensagem"));
		pathAlterarComponenteMensagemList
				.add(getValue("label_alterar_componente_mensagem"));
		return pathAlterarComponenteMensagemList;
	}

	public List<String> getPathAlterarFormatoMensagem() {
		List<String> pathIncluirComponenteMensagemList = new ArrayList<String>();
		pathIncluirComponenteMensagemList.add(getValue("label_parametrizacao"));
		pathIncluirComponenteMensagemList
				.add(getValue("label_alterar_formato_mensagem"));
		return pathIncluirComponenteMensagemList;
	}

	public List<String> getPathDetalharFormatoMensagem() {
		List<String> pathIncluirComponenteMensagemList = new ArrayList<String>();
		pathIncluirComponenteMensagemList.add(getValue("label_parametrizacao"));
		pathIncluirComponenteMensagemList
				.add(getValue("label_detalhar_formato_mensagem"));
		return pathIncluirComponenteMensagemList;
	}

	public List<String> getPathExcluirFormatoMensagem() {
		List<String> pathIncluirComponenteMensagemList = new ArrayList<String>();
		pathIncluirComponenteMensagemList.add(getValue("label_parametrizacao"));
		pathIncluirComponenteMensagemList
				.add(getValue("label_excluir_formato_mensagem"));
		return pathIncluirComponenteMensagemList;
	}

	public List<String> getPathConsultarPermissoes() {
		List<String> pathConsultarPermissoesList = new ArrayList<String>();
		pathConsultarPermissoesList.add(getValue("label_parametrizacao"));
		pathConsultarPermissoesList.add(getValue("label_usuarios"));
		pathConsultarPermissoesList.add(getValue("label_consultar_permissoes"));
		return pathConsultarPermissoesList;
	}

	public List<String> getPathIncluirPermissoes() {
		List<String> pathIncluirPermissoesList = new ArrayList<String>();
		pathIncluirPermissoesList.add(getValue("label_parametrizacao"));
		pathIncluirPermissoesList.add(getValue("label_incluir_permissoes"));
		return pathIncluirPermissoesList;
	}

	public List<String> getPathAlterarPermissoes() {
		List<String> pathAlterarPermissoesList = new ArrayList<String>();
		pathAlterarPermissoesList.add(getValue("label_parametrizacao"));
		pathAlterarPermissoesList.add(getValue("label_consultar_permissoes"));
		pathAlterarPermissoesList.add(getValue("label_alterar_permissoes"));
		return pathAlterarPermissoesList;
	}

	public List<String> getPathDetalharPermissoes() {
		List<String> pathDetalharPermissoesList = new ArrayList<String>();
		pathDetalharPermissoesList.add(getValue("label_parametrizacao"));
		pathDetalharPermissoesList.add(getValue("label_consultar_permissoes"));
		pathDetalharPermissoesList.add(getValue("label_detalhar_permissoes"));
		return pathDetalharPermissoesList;
	}
	
    public List<String> getPathIncluirParametrizacaoAlcada() {
		List<String> pathIncluirParametrizacaoAlcadaList = new ArrayList<String>();
		pathIncluirParametrizacaoAlcadaList.add(getValue("label_parametrizacao"));
		pathIncluirParametrizacaoAlcadaList.add(getValue("label_parametrizacao_alcada"));
		pathIncluirParametrizacaoAlcadaList.add(getValue("label_incluir_parametrizacao_alcada"));
		return pathIncluirParametrizacaoAlcadaList;
	}
    
    public List<String> getPathConsultarParametrizacaoAlcada() {
		List<String> pathConsultarParametrizacaoAlcadaList = new ArrayList<String>();
		pathConsultarParametrizacaoAlcadaList.add(getValue("label_parametrizacao"));
		pathConsultarParametrizacaoAlcadaList.add(getValue("label_parametrizacao_alcada"));
		pathConsultarParametrizacaoAlcadaList.add(getValue("label_consultar_parametrizacao_alcada"));
		return pathConsultarParametrizacaoAlcadaList;
	}
    
    public List<String> getPathAlterarParametrizacaoAlcada() {
		List<String> pathAlterarParametrizacaoAlcadaList = new ArrayList<String>();
		pathAlterarParametrizacaoAlcadaList.add(getValue("label_parametrizacao_alcada"));
		pathAlterarParametrizacaoAlcadaList.add(getValue("label_consultar_parametrizacao_alcada"));
		pathAlterarParametrizacaoAlcadaList.add(getValue("label_alterar_parametrizacao_alcada"));
		return pathAlterarParametrizacaoAlcadaList;
	}
}