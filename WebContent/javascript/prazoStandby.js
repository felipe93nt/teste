/**
 * prazoStandby.js
 * 
 * @version: v1.0.0
 * @author: Felipe G. Osorio
 *
 * Created by Felipe G. Osorio on 2017-06-26.
 *
 * Copyright (c) 2016 Bradesco
 *
 * Funcionalidade que permite inclusao/alteracao de prazo com a tecla enter
 */

jQuery(document).keydown(function(event) {
	var AJAX_ENTER_ACTION = 'action-on-enter';
	var $target = jQuery(event.target);
	var btnIncluir = jQuery('.btnPrazo').get(0);
	var btnAlterar = jQuery('.btnPrazo').get(1);
	
	// Permite a pesquisa pela tecla Enter [13], para os inputs marcados com a classe abaixo
	if (($target.hasClass(AJAX_ENTER_ACTION) || $target.is(':input[type="submit"]')) && event.which === 13) {
    	
    	// Libera o enter para os componentes de botao
		if ($target.is(':input[type="submit"]')) {
			$target.click();
		}
		
		// Verifica qual botão está habilitado para atribuir a chamada do método correto
    	if(!btnIncluir.disabled){
			var $ajaxAction = jQuery('#' + btnIncluir.id.replace(':', '\\:'));
			
		} else if (!btnAlterar.disabled) {
			var $ajaxAction = jQuery('#' + btnAlterar.id.replace(':', '\\:'));
		}
		
		$ajaxAction.click();
		return false;
    }
});

