/**
 * app.js
 * 
 * @version: v1.0.0
 * @author: Nicholas M. Dantas
 *
 * Created by Nicholas M. Dantas on 2016-02-25.
 *
 * Copyright (c) 2016 Bradesco
 *
 * Funcionalidades uteis de uso geral
 */

var App = (function (global, $) {
	'use strict';
	
	var SCROLL_TOP_SELECTOR = 'scroll-top';
	
	var AJAX_LOADING = 'ajax-loading';
	
	var AJAX_NO_LOADING = 'ajax-no-loading';
	
	var AJAX_ENTER_ACTION = 'action-on-enter';
	
	var AJAX_LOADING_IMAGE = '/npcc_trade/images/square-loader.gif';
	
	var screenSize = $(global).width() * 0.97;
	
	var replaceAllFunction = function (oldValue, newValue) {
		var self = this;

		return self.replace(new RegExp('[' + oldValue + ']', 'g'), newValue);
	};
	
	var blockedKeys = [13, 27];
	
	var onAjaxBeginCallbacks = [];
	var onAjaxCompleteCallbacks = [];
	var onAjaxSuccessCallbacks = [];
	
	function onAjaxBegin(callback) {
		if (typeof callback === 'function') {
			onAjaxBeginCallbacks.push(callback);
		}
	}
	
	function onAjaxComplete(callback) {
		if (typeof callback === 'function') {
			onAjaxCompleteCallbacks.push(callback);
		}
	}
	
	function onAjaxSuccess(callback) {
		if (typeof callback === 'function') {
			onAjaxSuccessCallbacks.push(callback);
		}
	}
	
	function executeAjaxBeginCallbacks(data) {
		for (var i = 0; i < onAjaxBeginCallbacks.length; i++) {
			onAjaxBeginCallbacks[i](data);
		}
	}
	
	function executeAjaxCompleteCallbacks(data) {
		for (var i = 0; i < onAjaxCompleteCallbacks.length; i++) {
			onAjaxCompleteCallbacks[i](data);
		}
	}
	
	function executeAjaxSuccessCallbacks(data) {
		for (var i = 0; i < onAjaxSuccessCallbacks.length; i++) {
			onAjaxSuccessCallbacks[i](data);
		}
	}
	
	function addPrototypesFunctions() {
		if (!String.prototype.replaceAll) {
			String.prototype.replaceAll = replaceAllFunction;
		}
	}
	
	function applyFullSize(maxSize) {
		var documentWidth = $(document).width() * 0.97;
		
		$('.full-size').width(documentWidth > maxSize ? maxSize : documentWidth);
	}
	
	function keyDownHandler(event) {
		var $target = $(event.target);
		
		if(event.which == 8 && !$target.is(":text") && !$target.is("textarea")) {
			event.preventDefault();
			event.stopPropagation();
			
			return false;
		}
		
		// Verifica se é uma tecla que deve ser bloqueada
		if (blockedKeys.indexOf(event.which) > -1 && !$target.is("textarea")) {
			
			// Permite a pesquisa pela tecla Enter [13], para os inputs marcados com a classe abaixo
			if (($target.hasClass(AJAX_ENTER_ACTION) || $target.is(':input[type="submit"]')) && event.which === 13) {
				
				// Libera o enter para os componentes de botao
				if ($target.hasAjaxRequest()) {
					$target.callAjaxRequest();
				} else if ($target.is(':input[type="submit"]')) {
					$target.click();
				}
				
				var $ajaxAction = $('#' + $target.attr('id').replace(':', '\\:') + '-action');
				
				// Apenas faz a chamada se encontrar apenas um elemento
				// Caso não encontre por id procurará por classes
				if ($ajaxAction.length != 1) {
					var targetId = $target.attr('id').split(':')[1];
					var underlineIndex = targetId.indexOf('_');
					
					// Se possuir underline o input pertence ao componente de CPF/CNPJ
					if (underlineIndex > -1) {
						targetId = targetId.substring(0, underlineIndex);
					}
					
					$ajaxAction = $('.' + targetId + '-action');					
				}
				
				$ajaxAction.click();
				
				// Apenas atualiza o elemento ativo se o namespace UX existir e 
				// Se o enter não for de um modal
				if (!$target.parent().hasClass('uiModalFooterDivIntranet') &&
					!$target.parent().hasClass('simplemodal-close') &&
					UX) {

					UX.activeElement = $target;
				}
			}
			
			event.preventDefault();
			event.stopPropagation();
			
			return false;
		}
	}
	
	function clickHandler(event) {
		var $target = $(event.target);
				
		// Verifica se o elemento clicado possui uma ação associada
		// Se sim, o foco vai para o campo associado
		if ($target.attr('id').indexOf('-action') > -1 && UX) {
			
			var elementId = $target.attr('id').replace('-action', '').replace(/[:]/g, '\\:');

			UX.activeElement = $('#' + elementId);
		}
	}
	
	/**
    * @description 
    *
    * @returns {boolean}
    */
	function isNullOrWhitespace(value) {
		if (!value) {
			return true;
		}
		
		return $.trim(value).length === 0;
	}
	
	/**
    * @description 
    *
    * @returns {boolean}
    */
	function isNullOrWhitespaceOrZero(value) {
		var convertedValue = parseInt(value, 10);
		
		if (!isNaN(convertedValue)) {
			value = convertedValue;
		}
		
		return isNullOrWhitespace(value) || value === 0;
	}
	
	function showAjaxLoading(data) {
		var $source = $(data.source); 
		
		if (!$source.hasClass(AJAX_NO_LOADING)) {    	
			var $div = $('<div id="divAjaxLoader" data-key="' + $source.attr('id') + '"'
					+ ' style="z-index: 99999; background-color: #000000; opacity: 0.3; filter: alpha(opacity=30); width: 100%; height: 100%; position: fixed; bottom: 0; right: 0;"></div>');
			var $image = $('<img src="' + AJAX_LOADING_IMAGE
					+ '" style="position: absolute;left: 42%;top: 33%;margin: auto;width: 200px;z-index: 100;" />');

			$div.append($image);
			$('body').append($div);
			$div.show();
			
			$(document).on('keydown.loading', function(event) {
				event.preventDefault();
				event.stopPropagation();
				
				return false;
			});
		}
	}
	
	function hideAjaxLoading(data) {
		var $source = $(data.source);
		var $loadingTemplate = $('#divAjaxLoader');

		if ($loadingTemplate.attr('data-key') == $source.attr('id')) {
			$loadingTemplate.remove();
			$(document).off('keydown.loading');
		}
	}
	
	function configureSei() {
		$('.sei-button').each(function() {
			var $seiLink = $(this);
			var $previousButton = $seiLink.prev();
			var revAttribute = $seiLink.attr('rev');
			var tabIndex = $seiLink.attr('tabindex');
			var disabled = revAttribute && revAttribute.toLowerCase() === 'true';
			
			if (!$previousButton.hasClass('new-sei-button')) {				
				var $seiButton = $('<input type="button" class="HtmlCommandButtonBradesco new-sei-button" value="'+ $seiLink.attr('title') +'"/>');
				$seiButton.attr('tabindex', tabIndex);
				$seiLink.removeAttr('tabindex');
				
				if (disabled) {
					$seiButton.attr('disabled', true);
				}
				
				$seiButton.off('click').on('click', function () {
					$seiLink.click();
					
					scrollTop();
				});
				
				$seiLink.before($seiButton);
				$seiLink.hide();
			} else {
				if (disabled) {
					$previousButton.attr('disabled', true);
				} else {
					$previousButton.removeAttr('disabled');
				}
			}
		});
	}
	
	function configureScrollTop(data) {
		var $source = $(data.source); 
		
		if ($source.hasClass(SCROLL_TOP_SELECTOR)) {
			scrollTop();
		}
	}
	
	function scrollTop() {
		$('body,html').scrollTop(-1000);
	}
	
	function openWindow(url, params, args) {
		if (!url) {
			return;
		}
		
		var queryString = null;
		
		for (var key in params) {
			if (!queryString) {
				queryString = '?' + key + '=' + params[key];
			} else {
				queryString += '&' + key + '=' + params[key];
			}
		}
		
		if (args) {
			var stringArgs = null;
			
			for (var key in args) {
				if (!stringArgs) {
					stringArgs = key + '=' + args[key];
				} else {
					stringArgs += ',' + key + '=' + args[key];
				}
			}
			
			global.externalAccessWindow = global.open(url + queryString, 'LINK_EXTERNO', stringArgs + ',scrollbars');
			localStorage.setItem('npc-force-reload', true);
			global.externalAccessWindow.focus();
		} else {
			global.open(url + queryString, 'LINK_EXTERNO', 'width=1024,height=600,scrollbars');
		}		
	}
	
	function openWindowCallback() {
		if (!global.externalAccessWindow || !global.externalAccessWindow.App) {
			return;
		}

		if (global.externalAccessWindow.App.info.externalAccess) {
			global.externalAccessWindow.location.reload(true);
			clearInterval(App.timers.openWindow);
		}
	}
	
	function closeWindow() {
		global.close();
	}
	
	function redirect(url) {
		if (!url) {
			return;
		}
		
		// Verifica se é um caminho relativo e adiciona o host à url
		if (url.indexOf('/') === 0) {
			url = global.location.protocol + '//' + global.location.host + url;
		}
		
		global.location.assign(url);
	}
	
	function initialize() {
		applyFullSize(screenSize);
		addPrototypesFunctions();
	}
	
	function parseJson(jsonString) {
		if (!jsonString || jsonString.indexOf('{execute:') == -1) {
			return null;
		}
		
		var ajaxRequestArgs = jsonString.substring(jsonString.indexOf('{execute:'));
		
		var open  = [];
		var close = [];
		var openIndex = ajaxRequestArgs.indexOf('{');
		var closeIndex = ajaxRequestArgs.indexOf('}');
		var executeArgs = '';

		while (openIndex > -1) {
			open.push(openIndex);

			openIndex = ajaxRequestArgs.substring(openIndex + 1).indexOf('{');
		}

		while (closeIndex > -1) {
			close.push(closeIndex + 1);

			closeIndex = ajaxRequestArgs.substring(closeIndex + 1).indexOf('}');
		}

		var i = 0;

		for (i = 1; i < open.length; i++) {
			
			if (close[i] < open[i + 1]) {

				break;
			}
		}

		if (close.length < i) {
			executeArgs = ajaxRequestArgs.slice(open[0], close[i]);
		} else {
			executeArgs = ajaxRequestArgs.slice(open[0], close[0]);
		}
		
		if (executeArgs) {
			return JSON.parse(executeArgs.replace(/\\'/g, "\"")
										 .replace(/'/g, '"')
					                     .replace('execute:', '"execute":')
					                     .replace('render:', '"render":'));
		} else {
			return null;
		}
	}
	
	return {
		info: {
			project: 'npcc_trade'
		},
		init: initialize,
		ajax: {
			onBegin: onAjaxBegin,
			onComplete: onAjaxComplete,
			onSuccess: onAjaxSuccess,
			executeBeginCallbacks: executeAjaxBeginCallbacks,
			executeCompleteCallbacks: executeAjaxCompleteCallbacks,
			executeSuccessCallbacks: executeAjaxSuccessCallbacks,
			
			showLoading: showAjaxLoading,
			hideLoading: hideAjaxLoading
		},
		config: {
			sei: configureSei,
			scrollTop: configureScrollTop
		},
		util: {
			isNullOrWhitespace: isNullOrWhitespace,
			isNullOrWhitespaceOrZero: isNullOrWhitespaceOrZero,
			scrollTop: scrollTop,
			parseJson: parseJson 
		},
		handlers: {
			keyDown: keyDownHandler,
			click: clickHandler
		},
		ui: {
			scrollTop : scrollTop
		},
		navigation: {
			open: openWindow,
			redirect: redirect,
			disconnect: closeWindow
		},
		exportFormats: {
			txt: function () {
				return {  
					formatos: 'txt'
				};
			},
			excel: function () {
				return {  
					formatos: 'xls'
				};
			},
			pdf: function () {
				return {
					formatos: 'pdf'
				};
			},
			pdfExcel: function () {
				return {
					formatos: 'pdf,xls'
				};
			}
		}
	};
})(window, jQuery.noConflict());

(function ($, ajax) {
	'use strict';
	
	// Extende os metodos de instancia do jQuery afim de facilitar a manipulação das chamadas ajax	
	$.fn.extend({
		hasAjaxRequest: function() {
			var ajaxRequest = false;
			
			if (this.attr('onblur') && this.attr('onblur').indexOf('jsf.ajax.request') > -1) {
				this.data('ajaxOnBlur', App.util.parseJson(this.attr('onblur')));
				
				ajaxRequest = true;
			}
			
			if (this.attr('onchange') && this.attr('onchange').indexOf('jsf.ajax.request') > -1) {
				this.data('ajaxOnChange', App.util.parseJson(this.attr('onchange')));
				
				ajaxRequest = true;
			}
			
			if (this.attr('onclick') && this.attr('onclick').indexOf('jsf.ajax.request') > -1) {
				this.data('ajaxOnClick', App.util.parseJson(this.attr('onclick')));
				
				ajaxRequest = true;
			}
			
			return ajaxRequest;
		},
		callAjaxRequest: function() {
			if (this.data('ajaxOnBlur')) {
				ajax.request(this.get(0), null, this.data('ajaxOnBlur'));
			}
			
			if (this.data('ajaxOnChange')) {
				ajax.request(this.get(0), null, this.data('ajaxOnChange'));
			}
			
			if (this.data('ajaxOnClick')) {
				ajax.request(this.get(0), null, this.data('ajaxOnClick'));
			}
		}
	});
	
	function externalAccessBehavior() {
		var $elementToClose = $('.external-access-disconnect');
		var $elementsToHide = $('.external-access-hide');
		
		if ($elementToClose && $elementToClose.length > 0) {
			App.info.externalAccess = true;
			
			$elementToClose.val('Fechar');
			$elementToClose.removeAttr('onclick');	    			
			$elementToClose.off('click').on('click', function(event) {
				// Garante que não haverá propagação ou continuação do evento padrão em todos os browsers
				if (event.preventDefault) {
					event.preventDefault();
				}
				
				if (event.stopPropagation) {
					event.stopPropagation();
				}
				
				App.navigation.disconnect();
				
				return false;
			});
		}
		
		// Oculta todos os elementos não permitidos para o acesso externo
		if ($elementsToHide) {
			$elementsToHide.hide();
		}
	}
		
	if (localStorage.getItem('npc-force-reload')) {				
		localStorage.removeItem('npc-force-reload');
		location.reload(true);
	}
	
	$(document).ready(function () {		
		var configSei = App.config.sei;
		var configScrollTop = App.config.scrollTop;
		var initFunction = App.init;
		var showFunction = App.ajax.showLoading;
		var hideFunction = App.ajax.hideLoading;
		
		App.ajax.onSuccess(configSei);
		App.ajax.onSuccess(configScrollTop);
		App.ajax.onSuccess(initFunction);
		App.ajax.onSuccess(externalAccessBehavior);
		App.ajax.onBegin(showFunction);
		App.ajax.onComplete(hideFunction);		
		
		configSei();
		initFunction();		
		externalAccessBehavior();
		
		$(document).off('keydown');
		$(document).on('keydown', UX.handlers.keyDown);
		$(document).on('keydown', App.handlers.keyDown);
		
		$(document).off('click');
		$(document).on('click', UX.handlers.click);
		$(document).on('click', App.handlers.click);
		
		UX.focus.init();
		UX.ranges.update();
		UX.bindings.calendar();
	});
	
	ajax.addOnEvent(function(data) {
		switch (data.status) {
			case 'begin':
				App.ajax.executeBeginCallbacks(data);
				
				UX.watchers.modalContent.clear();
				UX.watchers.activeElement.clear();
				UX.watchers.confirmationButton.clear();
				
				break;
			case 'complete':
				App.ajax.executeCompleteCallbacks(data);
				
				var $activeElement = $(document.activeElement);
				
				if ($activeElement.length &&
					!$activeElement.is('body') && 
					!$activeElement.is('iframe') && 
					!$activeElement.parent().hasClass('uiModalFooterDivIntranet') &&
					!$activeElement.parent().hasClass('simplemodal-close')) {
					
					UX.activeElement = $activeElement;
				}
				
				break;
			case 'success':
				App.ajax.executeSuccessCallbacks(data);
				
				UX.ajax.callback(data);
			    
				var $activeElement = $(document.activeElement);
				
				// Caso o elemento focado pertenca a um modal não ira procurar pelo botão de confirmação
				if (!$activeElement.parent().hasClass('uiModalFooterDivIntranet') &&
					!$activeElement.parent().hasClass('simplemodal-close') &&
					!$activeElement.is('iframe')) {
					
					UX.watchers.confirmationButton.watch();
				}
				
				break;		
			default:
				break;
		}
	});
})(jQuery.noConflict(), jsf ? jsf.ajax : {});

/**
 * app.ux.js
 * 
 * @version: v1.0.0
 * @author: Nicholas M. Dantas
 *
 * Created by Nicholas M. Dantas on 2016-10-18.
 *
 * Copyright (c) 2016 Bradesco
 *
 * Funcionalidades uteis para experiencia do usuario
 * 
 * Obs.: Este script tem dependencia de app.js
 */

var UX = (function ($) {	
	var modalContentWatcher = new Watcher("ModalContent", 50, function() {
		if ($('.modal-content-dialog').is(':visible') && 
			$('.modal-content-dialog').find('iframe').contents().find('.auto-focus').length == 0) {
			
			$('.modal-content-dialog:visible').focus();
			
			return true;
		} else {
			return false;
		}
	});
	
	var activeElementWatcher = new Watcher("ActiveElement", 50, function() {
		var selector = UX.activeElement.selector;
		
		if ($(selector).is(':visible')) {
			$(selector).focus();
			$(selector).select();
			
			return true;
		} else {
			return false;
		}
	});
	
	var confirmationButtonWatcher = new Watcher("ConfirmationButton", 50, function() {
		// Verifica se o botão está visivel para o usuário
		if ($('.modal-confirmation').is(':visible')) {
			$('.modal-confirmation').focus();
			
			return true;
		} else {
			return false;
		}
	});
	
	function initFocus() {
		var $firstFocus = $('.auto-focus:not([disabled])').first();
		
		// Se não localizou a classe 'auto-focus' tentara
		// encontrar um outro elemento que inicie com 'auto-focus-' 
		// Usado a priore para os casos que o calendario é o primeiro campo
		if (!$firstFocus.length) {
			$firstFocus = $('[class*="auto-focus-"]').first();
		} else if (!$firstFocus.is(':input')) {
			$firstFocus = $firstFocus.find(':input:not([disabled])').first();
		}
		
		// Caso haja um modal aberto na tela
		if ($('.modal-content-dialog').is(':visible')) {
			var $iFrame = $('.modal-content-dialog').find('iframe');
			
			$iFrame.css("visibility", "visible");			
			
			$firstFocus = $iFrame.contents().find('.auto-focus:not([disabled])').first();
		}
		
		$firstFocus.focus();
	}
	
	function updateFocus(force) {
		var ranges = UX.ranges.values;
		var maxIndex = UX.ranges.values.length - 1;
		var targetTabIndex = UX.focus.index;
		var rangeIndex = ranges.indexOf(targetTabIndex);
		
	    if (UX.focus.forward && rangeIndex < maxIndex) {
	    	targetTabIndex = ranges[rangeIndex + 1];
	    } else if (UX.focus.backward && rangeIndex > 0) {
	        targetTabIndex = ranges[rangeIndex - 1];
	    } 
	    
	    // Verifica se não há alguma direcao para direcionar o foco
	    // Caso não haja e exista um elemento ativo na tela, o foco permanecerá neste
	    if (targetTabIndex == 0 && !UX.focus.forward && 
    		!UX.focus.backward && 
    		UX.activeElement instanceof $ &&
    		UX.activeElement.attr('tabindex') != '') {
	    	
	    	targetTabIndex = UX.activeElement.attr('tabindex'); 
	    }
	    
	    // Caso não haja a necessidade de ir para frente ou para tras no tab
	    // Verifica se o elemento ativo não é um radio antes de atualizar
	    // Caso seja, não se pode fazer o seletor pelo atributo tabIndex	    
	    if (UX.activeElement instanceof $ && 
    		!UX.activeElement.is(':radio') && 
    		!UX.focus.forward && 
    		!UX.focus.backward || force) {
	    	
	    	UX.activeElement = $('[tabindex='+ targetTabIndex +']');
	    }
	    
	    // Limpa a ação que determina se o tab deve ir para o próximo campo, pois o foco já esta no campo
	    // desejado após o evento ajax.
		UX.focus.forward = false;
        UX.focus.backward = false;
        
        // Verifica se o objeto é uma instancia do jQuery
	    if (UX.activeElement instanceof $ && UX.activeElement.length) {			    	
	    	var id = UX.activeElement.attr('id').replace(/[:]/g, '\\:');
	    	var $elementToFocus = $('#' + id);
	    	
	    	$elementToFocus.focus();
	    	$elementToFocus.select();
	    	
	    	// TODO: Verificar necessidade desta chamada no garantias
	    	UX.watchers.modalContent.watch();
	    } else {
	    	UX.activeElement = null;
	    }
	}
	
	function updateRanges(content) {
		content = content || document;
		
		var ranges = UX.ranges.values || [];
		var elements = content.querySelectorAll('[tabindex]');
		
		for (var i = 0; i < elements.length; i++) {
			var index = elements[i].tabIndex;
			
			if (index && ranges.indexOf(index) == -1) {
				ranges.push(index);
			}
		}
		
		UX.ranges.values = ranges.sort(numberComparator);
	}
	
	function numberComparator(a, b) {
		return a - b;
	}
	
	function bindTabIndexCalendar() {
		var $calendars = $('.dataCalendario');
		
		$calendars.each(function () {
			var $calendar = $(this);			
			var $fields = $calendar.find(':text');
			var index = parseInt($calendar.find(':text[tabindex]').attr('tabindex'));
			
			$fields.attr('tabindex', index);
			
			/*// Quando a data for informada o foco irá para o proximo componente
			$fields.off('keyup.brq.calendar').on('keyup.brq.calendar', function(event) {
				  var complete = true;
				  
				  $fields.each(function() {
					  complete &= this.value.length > 0;
				  })
				  
				  // Verifica se o valor do ano foi preenchido
				  if (this.value.length === this.maxLength && complete) {
					  UX.focus.forward = true;
			          UX.focus.backward = false;
			          		
			          updateFocus();
				  }
			  });*/
		});
	}
	
	function getCurrentIndex() {
		var tabIndex = $(document.activeElement).attr('tabindex');
		
		if (tabIndex) {
			UX.focus.index = parseInt(tabIndex);
		} else {
			UX.focus.index = 0;
		}
	}
	
	function keyDownHandler(event) {
		var KEY_CODE_TAB = 9;
		var keyCode = event.which;
		
		getCurrentIndex();
		
		if (!event.shiftKey && keyCode === KEY_CODE_TAB) {				
            UX.focus.forward = true;
            UX.focus.backward = false;
        } else if (event.shiftKey && keyCode === KEY_CODE_TAB) {
        	UX.focus.forward = false;
            UX.focus.backward = true;
        } else {
        	UX.focus.forward = false;
            UX.focus.backward = false;
        }
	}
	
	function clickHandler(event) {
		var $target = $(event.target);
		
		if ($target.is(':input')) {
			getCurrentIndex();
			
			// Limpa a ação que determina se o tab deve ir para o próximo campo, pois o foco já esta no campo
		    // desejado após o evento ajax.
			UX.focus.forward = false;
            UX.focus.backward = false;
		} else if ($target.hasClass('UICalendar-a-day')) /* Click Calendario */ {
			// No caso do calendario o foco deve ir para o proximo componente
			UX.focus.forward = true;
            UX.focus.backward = false;
            
            var max = 10;
            var element = $target.get(0);
            
            while (--max) {
            	element = element.parentElement;
            	
            	if (element.className.indexOf('dataCalendario') > -1) {
            		var dayField = element.childNodes[0].childNodes[0];
        			
            		$(dayField).focus();
            		
            		// Salva o estado atual
            		getCurrentIndex();
            		
            		// Força o foco
            		updateFocus(true);
            		
            		// Atualiza para o proximo campo
            		getCurrentIndex();
            		
            		break;
            	}
            }
		}
	}
	
	function ajaxCallback(data) {
		var update = true;
		var $source = $(data.source);
		
		// Verifica se o campo que esta recebendo o foco
		// Não esta contido na atualização do ajax
		var updateTags = data.responseXML.getElementsByTagName('update');
		var searchFilter = UX.activeElement instanceof $ ? UX.activeElement.attr('id').replace('\\:', ':') : null;
		var backFocusToElement = false;
		var hasModalContent = false;
		var htmlContent = '';
		var container = document.createElement('div');
		
		// Caso o elemento seja atualizado 
		for (var i = 0; i < updateTags.length; i++) {
			if (!updateTags[i].textContent && 
				updateTags[i].id != 'formModalMessages' && 
				updateTags[i].id != 'javax.faces.ViewState') {
				
				continue;
			}
			
			var content = updateTags[i].textContent.replace('<![CDATA[').replace(']]>');
			
			htmlContent += content;
			
			if (updateTags[i].textContent.indexOf('UIModalContent') > -1) {
				hasModalContent = true;
			}
			
			if (searchFilter && updateTags[i].textContent.indexOf(searchFilter) > -1) {
				update = false;
				backFocusToElement = true;
			}
		}

		if (backFocusToElement && !hasModalContent) {
			UX.activeElement.selector = '#' + searchFilter.replace(/:/g, '\\:');
			
			UX.watchers.activeElement.watch();
		}
		
		// Verifica se deve atualizar as informações de tab index
		if (update) {
			UX.focus.update();
		} else if (hasModalContent) {
			UX.watchers.modalContent.watch();
		}
		
		if (htmlContent) {
			container.innerHTML = htmlContent;
			
			UX.ranges.update(container);
			UX.bindings.calendar();
		}
	}
	
	return {
		activeElement: {
			
		},
		focus: {
			init: initFocus,
			update: updateFocus,			
			index: 0,
			forward: false,
			backward: false			
		},
		ranges: {
			update: updateRanges,
			values: []
		},
		watchers: {
			modalContent: modalContentWatcher,
			activeElement: activeElementWatcher,
			confirmationButton: confirmationButtonWatcher
		},
		handlers: {
			keyDown: keyDownHandler,
			click: clickHandler
		},
		bindings: {
			calendar: bindTabIndexCalendar
		},
		ajax: {
			callback: ajaxCallback
		}
	};	
})(jQuery.noConflict());

function Watcher(name, time, watchCallback) {
	var self = this;
	
	self.name = name;	
	self.time = time;
	self.intervalId = 0;
	
	self.watch = function() {
		self.intervalId = setInterval(function() {
			if (watchCallback()) {
				self.clear();
			}			
		}, self.time);
	};
	
	self.clear = function() {
		clearInterval(self.intervalId);
	};
}