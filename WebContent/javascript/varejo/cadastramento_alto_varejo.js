var $jB = jQuery.noConflict();
var formPagina = 'formVarejo';

$jB( document ).ready(function() {

	loadMasksJQuery();

	$jB(':text').each(function(){
		if($jB(this).val() == '0,00'){
    		$jB(this).val('');
    	}
	});
});

$jB( window ).on("load", function() {
	alinharTotalizadores(formPagina, 'TableEndividamento', 'totalizadorEndividamento');
	limparRadio();
	reposicionaTela();
});