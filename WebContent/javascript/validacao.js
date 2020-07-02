/**
 *
 */

function validarCamposInclusao(gridCampos, idBotao) {
	var inputs = gridCampos.getElementsByTagName('input');
	var form = inputs[0].form.name;
	var botao = document.getElementById(form + ':' + idBotao);
	botao.disabled = false;
	for (var i = 0; i<inputs.length; i++) {
		if (inputs[i].value.length == 0) {
			botao.disabled = true;
			return;
		} 
	}
}

function validarCamposInclusaoSemDatas(gridCampos, idBotao) {
	var inputs = gridCampos.getElementsByTagName('input');
	var form = inputs[0].form.name;
	var botao = document.getElementById(form + ':' + idBotao);
	botao.disabled = false;
	for (var i = 0; i<inputs.length; i++) {
		if (inputs[i].value.length == 0 && !inputs[i].className.includes('UICalendar')) {
			botao.disabled = true;
			return;
		} 
	}
}

function validarCamposInclusaoComRadio(gridCampos, idBotao) {
	var inputs = gridCampos.getElementsByTagName('input');
	var form = inputs[0].form.name;
	var botao = document.getElementById(form + ':' + idBotao);
	botao.disabled = false;
	var radios = new Array();
	for (var i = 0; i<inputs.length; i++) {
		if (inputs[i].value.length == 0) {
			botao.disabled = true;
			return;
		} 
		if (inputs[i].type == 'radio') {
			radios.push(inputs[i]);
		}
	}
	
	if (radios.length > 0) {
		botao.disabled = true;
		for (var i = 0; i<radios.length; i++) {
			if (radios[i].checked) {
				botao.disabled = false;
			}
		}
	}
}

function validarHora(horaTela) {
	var horaVal = horaTela.value;

	var hora = horaVal.substring(0,2);
	var minuto = horaVal.substring(3,5);
	var segundo = horaVal.substring(6, horaVal.length);

	if (hora > 23 || minuto > 59 || segundo > 59) {
		horaTela.value = '';
		alert('Hora inválida!');
		horaTela.focus();
		return false;
	}
	return true;
}

function cleanClipboard() {
    clipboardData.clearData();
}

function allowOnlyLetter(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	if (key < 20) return;
	key = String.fromCharCode( key );
	var regex = /[a-zA-Z]/;
	if( !regex.test(key) ) {
		theEvent.returnValue = false;
		if(theEvent.preventDefault) theEvent.preventDefault();
	}
}

function parseToUpperCase(obj) {
	obj.value = obj.value.toUpperCase();
}

function allowOnlyLetterAndNumber(evt) {
	var theEvent = window.event;
	var key = theEvent.keyCode || theEvent.which;
	if (key < 20) return;
	key = String.fromCharCode( key );
	var regex = /[a-zA-Z0-9 ]/;
	if( !regex.test(key) ) {
		theEvent.returnValue = false;
		if(theEvent.preventDefault) theEvent.preventDefault();
	}
}

function allowOnlyNumber(evt) {
	var theEvent = window.event;
	var key = theEvent.keyCode || theEvent.which;
	if (key < 20) return;
	key = String.fromCharCode( key );
	var regex = /[0-9]/;
	if( !regex.test(key) ) {
		theEvent.returnValue = false;
		if(theEvent.preventDefault) theEvent.preventDefault();
	}
}

function validarPesquisaLike(nome) {
	var nome = nome.value;

	if (nome.length < 3) {
		alert('Digite ao menos 3 caracteres como filtro de pesquisa');
		nome.focus();
		return false;
	}
	return true;
}

//renomeia o jQuery para evitar problemas de compatibilidade

var $jB = jQuery.noConflict();



function habilitarBotoesSelecao(idForm, idTabela, idBotoes) {
	var tabela = document.getElementById(idForm + ':' + idTabela);
	var arrayBotoes = new Array();

	for (var i = 0; i < idBotoes.length; i++) {
		arrayBotoes.push(document.getElementById(idForm + ':' + idBotoes[i]));
	}

	var tabelaBody = document.getElementById(idForm + ':' + idTabela + ':tbody_element');

	for (var i = 0; i < arrayBotoes.length; i++) {
		arrayBotoes[i].disabled = true;
	}

	if (tabelaBody != null) {
		for (var i = 0; i < tabelaBody.rows.length; i++) {
			var radio = tabelaBody.rows[i].cells.item(0).childNodes[0];
			if (radio.checked) {
				for (var j = 0; j < arrayBotoes.length; j++) {
					arrayBotoes[j].disabled = false;
				}
				break;
			}
		}
	}

}

function habilitarBotaoOnclick(idComponente, idBotoes) {
	var n = idComponente.indexOf(':', 0);
	var idForm = idComponente.substring(0, n);
	var idTabela = idComponente.substring(n+1, id.length);

    var tabela = document.getElementById(idComponente);
    tabela.onclick = function() {
    	habilitarBotoesSelecao(idForm, idTabela, idBotoes);
    };
};

function formatarValor(campo) {

	var v = campo.value;

	if(v == "0,00") {
		campo.value = '0,0';
		return;
	}

	if(v.charAt(0) == '0' && v.length > 3) {
		campo.value = v.substring(0,4);
		return;
	}

	v=v.replace(/\D/g,"")
	v=v.replace(/(\d{1})(\d{14})$/,"$1.$2")
	v=v.replace(/(\d{1})(\d{11})$/,"$1.$2")
	v=v.replace(/(\d{1})(\d{8})$/,"$1.$2")
	v=v.replace(/(\d{1})(\d{5})$/,"$1.$2")
	v=v.replace(/(\d{1})(\d{1,2})$/,"$1,$2")

	campo.value = v;
}

