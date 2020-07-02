var $jB = jQuery.noConflict();
$jB( document ).ready(function() {
	
	loadMasksJQuery();
});

window.onload = function() {
	trocarCorBotao();
	alinharTotalizadores('formQuestionario', 'tblLandBank', 'totalizadoresLandBank')
	limparRadio();
	reposicionaTela();
	document.getElementById(formName+':scrollPointIndex').value = 0;
};

function atualizarValores() {
	if (document.getElementById('formQuestionario:gridQuestionario') != null) {
		document.formQuestionario.submit();
	} else if (document.getElementById('formObrasAndamento:gridObrasAndamento') != null) {
		document.formObrasAndamento.submit();
	} else if (document.getElementById('formObrasConcluidas:gridObrasConcluidas') != null) {
		document.formObrasConcluidas.submit();
	}
}

function limparRadio() {
	for (i = 0; i < document.formQuestionario.elements.length; i++) {
		if (document.formQuestionario.elements[i].type == "radio")
			document.formQuestionario.elements[i].checked = 0;
	}
	for (i = 0; i < document.formObrasAndamento.elements.length; i++) {
		if (document.formObrasAndamento.elements[i].type == "radio")
			document.formObrasAndamento.elements[i].checked = 0;
	}
	for (i = 0; i < document.formObrasConcluidas.elements.length; i++) {
		if (document.formObrasConcluidas.elements[i].type == "radio")
			document.formObrasConcluidas.elements[i].checked = 0;
	}
}

function setDynamicSize(){
	var collectionTabelas = document.getElementsByClassName("scrollableColumns");
	for(i = 0; i < collectionTabelas.length; i++){
		var tabela = collectionTabelas[i];
		tabela.style.height = "auto";
		tabela.style.maxHeight = "200px";
		//Scroll vertical
		tabela.style.overflowY = "auto";
		tabela.style.overflowX = "hidden";
	}
}

function setScrollHorizontal(formId, tabelaId) {
	var widthTela = '1300px';
	var id = formId + ':' + tabelaId;
	try {
		document.getElementById(id).style.overflowY = 'auto';
		document.getElementById(id).style.overflowX = 'auto';
		document.getElementById(id).style.width = widthTela;
	} catch (e) {
		return;
	}
	
}

function trocarCorBotao() {
	loadMasksJQuery();
	var btQuestionario = document.getElementById('questionarioImobiliarioHeaderFormID:btnAbaQuestionario');
	var btAndamento    = document.getElementById('questionarioImobiliarioHeaderFormID:btnAbaAndamento');
	var btConcluidas   = document.getElementById('questionarioImobiliarioHeaderFormID:btnAbaConcluidas');
	
	btQuestionario.style.color = "#000000";
	btAndamento.style.color = "#000000";   
    btConcluidas.style.color = "#000000";
    
    if(btQuestionario.disabled) {
    	btQuestionario.style.color = "#F7F7FE"
    }
    
    if(btAndamento.disabled) {
    	btAndamento.style.color = "#F7F7FE"
    }
    
    if(btConcluidas.disabled) {
    	btConcluidas.style.color = "#F7F7FE"
    }
    
}

function afterLoad(data) {
	if(data.status == 'begin'){
		
	}
	
	if(data.status == 'success'){
		$jB("form").submit(function(){
			  alert("Submitted");
		});
	}
}