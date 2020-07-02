var $jB = jQuery.noConflict();
$jB( document ).ready(function() {
	
	loadMasksJQuery();
});

$jB( window ).on('load', function() {

	limparRadio();
	reposicionaTela();

});