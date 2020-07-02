var $jB = jQuery.noConflict();

$jB( document ).ready(function() {
	
	loadMasksJQuery();
	
	$jB(':text').each(function(){
		if($jB(this).val() == '0,00' 
			&& document.getElementById('formParametrizacaoRelatorio:flgAltoVarejoSelecionado').value == 'false'){
			
    		$jB(this).val('');
    	}
	});
});


/**
 *
 */
function validarRiscoTotal(campo) {
	//Alto varejo - ação de seleção
	if(campo.value == 3 && campo.checked == true) {
		document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').disabled = false;
		document.getElementById('formParametrizacaoRelatorio:flgAltoVarejoSelecionado').value = true;
	} 
	//Alto varejo - ação de tirar a seleção
	else if(campo.value == 3 && campo.checked == false){
		document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').value = "";
		document.getElementById('formParametrizacaoRelatorio:valorRiscoTotalHidden').value = "";
		document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').disabled = true;
		document.getElementById('formParametrizacaoRelatorio:flgAltoVarejoSelecionado').value = false;
	}
	//Outras opções, desabilitam somente se o alto varejo não estiver selecionado
	else {
		if(!document.getElementById('formParametrizacaoRelatorio:flgAltoVarejoSelecionado').value){
			document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').value = "";
			document.getElementById('formParametrizacaoRelatorio:valorRiscoTotalHidden').value = "";
			document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').disabled = true;
		}
	}
	
}

window.onload = function(){
	
	if(document.getElementById('formParametrizacaoRelatorio:flgAltoVarejoSelecionado').value == true){
		document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').disabled = false;
	}
}

function salvaValorRiscoTotal(){
	document.getElementById('formParametrizacaoRelatorio:valorRiscoTotalHidden').value = document.getElementById('formParametrizacaoRelatorio:idRiscoTotal').value;
}