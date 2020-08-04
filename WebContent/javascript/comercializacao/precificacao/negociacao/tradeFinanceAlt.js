/**
 * tradeFinanceAlt.js
 * @version: v1.0.0
 * @author: Nicholas M. Dantas
 *
 * Created by Nicholas M. Dantas on 2016-02-25.
 *
 * Copyright (c) 2016 Bradesco
 *
 * Funcionalidades uteis para tela de negociacao mesa trade
 */

(function ($) {
	'use strict';
	
	$(document).ready(function () {		
		var doGerarBoleto = $('#formTrdFinNegIncl\\:gerarBoletoAlt');
		var $seiLinkGerarBoleto = $('#formTrdFinNegIncl\\:btnGerarBoleto');
		
		if(doGerarBoleto.val() && doGerarBoleto.val().toLowerCase() === 'true') {
			setTimeout(function() {
				$seiLinkGerarBoleto.click();
				doGerarBoleto.val('false');
			}, 1000);
		}
	});
	
})(jQuery.noConflict());