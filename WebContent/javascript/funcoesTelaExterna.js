var $TC = jQuery.noConflict();

/*
 * File: funcoesTelaExterna.js
 * 
 * Funções utilizadas pelos elementos com tela externa.
 */

/*
 * Function: getData Recupera os dados de todos os elementos de entrada de dados
 * visuais do quadro atual Retorno: dados dos elementos concatenados com "|"
 */
function getData() {
	var elementsData = "";
	var inputs = $TC(':input:not(input[type=hidden], input[type=button], input[type=image], input[type=reset], input[type=submit])');
	if (inputs.length > 0) {
		$TC(inputs).each(function(index, value) {
			elementsData += $TC(value).val().replace(/\|/g, '&#124') + '|';
		});
		if (elementsData.length > 0) {
			elementsData = elementsData.substring(0, elementsData.length - 1);
		}
	}
	return elementsData;
}

/*
 * Function: exportData Exporta os dados para a área compartilhada do componente
 * UIAppFrame Parâmetros: hiddenId - O ID do hidden de compartilhamento Retorno:
 * Nenhum
 */
function exportData(hiddenId) {
	hiddenId = hiddenId.replace(/\:/g, '\\:');
	var data = getData();
	var mainHiddenId = $TC('#' + hiddenId).val();
	$TC('#' + mainHiddenId, window.parent.document).val(data);
	syncData(mainHiddenId);
}

/*
 * Function: syncData Mantem os dados do componente e de exibição sincronizados
 * UIAppFrame Parâmetros: hiddenId - O ID do hidden de compartilhamento Retorno:
 * Nenhum
 */
function syncData(hiddenID) {
	var value = $TC('#' + hiddenID, window.parent.document).val();
	$TC('#exportedValues', window.parent.document).val(value);
	$TC('#frameValuesLabel', window.parent.document).css('display', 'inline');
}

/*
 * Function: setData Atribui dados a todos os elementos de entrada de dados
 * visuais de determinado frame Parâmetros: frameId - O ID do frame cujos dados
 * devem ser recuperados data - Os dados, separados por pipes ("|"), a serem
 * atribuídos Retorno: Nenhum
 */
function setData(frameId, dataId) {
	frameId = frameId.replace(/\:/g, '\\:');
	dataId = dataId.replace(/\:/g, '\\:');
	data = $TC("#" + dataId).val();
	if (jQuery) {
		var frame = $TC('#' + frameId);
		if (frame.length > 0) {
			var contents = frame.contents();
			if (contents) {
				var inputs = $TC(
						':input:not(input[type=hidden], input[type=button], input[type=image], input[type=reset], input[type=submit])',
						contents);
				if (inputs.length > 0 && data) {
					var elementsData = data.split('|');
					$TC(elementsData).each(
							function(index, elementData) {
								$TC(inputs[index]).val(
										elementData.replace(/&#124/g, '|'));
							});
					syncData(dataId);
				}
			}
		}
	}
}