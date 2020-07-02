var $jB = jQuery.noConflict();
var idForm = 'formIniciarCorporate';

$jB( document ).ready(function() {

	loadMasksJQuery();

	$jB(':text').each(function(){
		if($jB(this).val() == '0,00'){
    		$jB(this).val('');
    	}
	});
});

$jB( window ).on("load", function() {
	alinharTotalizadores(idForm, 'TableEndividamentoBancario', 'totalizadorEndividamento');
	limparRadio();
	reposicionaTela();
});

function renderModalExclusao(){
	document.getElementById('formIniciarCorporate:flagModalId').value = true;
}