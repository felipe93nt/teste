var $jB = jQuery.noConflict();
$jB( document ).ready(function() {
	
	loadMasksJQuery();
	
});

$jB( window ).on('load', function() {
	
	verificaValidacaoTotal();
	reposicionaTela();
	
});

function verificaValidacaoTotal(){
	searchFormByField();
	var campoValidacaoFocoResponse = document.getElementById(formName+':idCampoValidacaoFocoResponse');
	if(null != campoValidacaoFocoResponse.value && "" != campoValidacaoFocoResponse.value){
		document.getElementById(formName + ':' + campoValidacaoFocoResponse.value).focus();
		campoValidacaoFocoResponse.value = null;
	}	
}