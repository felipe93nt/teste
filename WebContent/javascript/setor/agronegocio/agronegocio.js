var $jB = jQuery.noConflict();

$jB( document ).ready(function() {
	loadMasksJQuery();
	
});

$jB( window ).on("load", function() {
	if (document.getElementById('formGraosFibras:gridGraos') != null) {
		alinharTotalizadores('formGraosFibras', 'tblAreaPropria', 'totalizadoresAreaPropria');
		alinharTotalizadores('formGraosFibras', 'tblAreaArrendada', 'totalizadoresAreaArrendada');
	} else if (document.getElementById('formUsinas:gridUsinas') != null) {
		
	}
	limparRadio();
	reposicionaTela();
	document.getElementById(formName+':scrollPointIndex').value = 0;
});

window.onload = function() {
	loadMasksJQuery();
	verificaValidacaoTotal();
};

function atualizarValores() {
	if (document.getElementById('formGraosFibras:gridGraos') != null) {
		document.formGraosFibras.submit();
	} else if (document.getElementById('formUsinas:gridUsinas') != null) {
		document.formUsinas.submit();
	}
}


function limparRadio() {
	if (document.getElementById('formGraosFibras:gridGraos') != null) {
		for (i = 0; i < document.formGraosFibras.elements.length; i++) {
			if (document.formGraosFibras.elements[i].type == "radio")
				// Se cair no if, e radio de tabela
				// nextSibling representa a label de descricao do radio
				if (null == document.formGraosFibras.elements[i].nextSibling) {
					document.formGraosFibras.elements[i].checked = 0
				}
		}

	} else {
		for (i = 0; i < document.formUsinas.elements.length; i++) {
			if (document.formUsinas.elements[i].type == "radio")
				// Se cair no if, e radio de tabela
				// nextSibling representa a label de descricao do radio
				if (null == document.formUsinas.elements[i].nextSibling) {
					document.formUsinas.elements[i].checked = 0
				}
		}
	}
}