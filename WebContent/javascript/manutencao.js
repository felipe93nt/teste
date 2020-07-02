/**
 * ARQUIVO JAVASCRIPT COM FUNÇÕES PARA A TELA DE INCLUIR MENSAGENS DO SISTEMA
 * SWRM DE MENSAGENS
 */

function esconderForm(value) {
	var x = document.getElementById("conteudo");
	if (value == '103') {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}

function esconderHeader(x, y) {
	if (x.style.display == "none") {
		x.style.display = "block";
		y.className = "icon-collapse-alt icon-large";
	} else {
		x.style.display = "none";
		y.className = "icon-expand-alt icon-large";
	}
}

function esconderTabela() {
	document.getElementById("divTabela").style.display = "block";
}

function abrirModal() {
	document.getElementById("botaoLupa").click();
}

function showTable(elemento) {
	elemento.style.display = "block";
}
