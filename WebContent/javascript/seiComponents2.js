	var $jB = jQuery.noConflict();

	//Retorna a API do SEI
	function getSeiApi() {
		var evalString = "return seiAPI;";
		try {
			var seiApi = new Function(evalString)();
			return seiApi;
		} catch (e) {
		}
		return null;
	};

	function getExtratoID(id) {
		return {
			formatos : 'qif,ofx,ofc'
		};

	};

	function getSaldoID(id) {
		return {
			formatos : 'txt,odt,xmld,xls,csv,xmls,pdf,html,xhtml'
		};

	};