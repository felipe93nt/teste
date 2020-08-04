(function(global, $) {
	
	var BUTTON_VIEW = '.open-external-access';
	var HIDDEN_PRODUCT = 'hdnCodigoProduto';
	var HIDDEN_CODE = 'hdnNumeroBoleto';
	var HIDDEN_URL = 'hdnUrlRoteador';
	
	$(document).ready(function() {
		bind();		
	});
	
	function bind() {
		var $buttonView = $(BUTTON_VIEW);
		var $product = $('[name$=' + HIDDEN_PRODUCT + ']');
		var $code = $('[name$=' + HIDDEN_CODE + ']');
		var $url = $('[name$=' + HIDDEN_URL + ']');
		
		$buttonView.removeAttr('onclick');
		
		$buttonView.off('click').on('click', function(event) {
			var width = $(global).width() * 0.95;
			
			App.navigation.open($url.val(), {
				boleto: $code.val(),
				produto: $product.val()
			}, {
				width: width, 
				height: 600
			});
			
			event.preventDefault();
			event.stopPropagation();
			
			return false;
		});
	}
	
	App.ajax.onSuccess(bind);	
	
})(window, jQuery.noConflict());