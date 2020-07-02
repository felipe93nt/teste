var $jB = jQuery.noConflict();

	//Retorna a API do modal de impressão (em javascript)
	function getSeiApi() {
		var evalString = "return seiAPI;";
		try {
			var seiApi = new Function(evalString)();
			return seiApi;
		} catch (e) {
		}
		return null;
	};

	$jBR(document).ready(function() {
		$jB(".btnDetalhe").click(function() {
			var c = $jB(this).attr("class");
			var re = new RegExp(/\bbtn_[0-9]+\b/);
			var m = re.exec(c);
			var s = "";
			if (m != null) {
				for (i = 0; i < m.length; i++) {
					s = s + m[i] + "\n";
				}
				s = s.replace("btn_", "");
				var seiApi = getSeiApi();

				seiApi.prepareSEI("&#35;{seiBean.actionComprovante}", {
					cId : s
				},'print', false,false,null,false);
				var id = s;
				$jB(".detalhe_" + id).hide();
				seiApi.executeSEI( {}, function() {
					var seiApi = getSeiApi();
					var html = $jB(".detalhe_" + id).html();

					if (html == "") {
						html = seiApi.getHtmlContent();
						$jB(".detalhe_" + id).html(html);
					}

					$jB(".detalhe_" + id).slideDown(1000);
				});
			}
		});


		$jB(".seiSelectAll").click(function() {

			 var n = $jB(".seiSelectAll input:checked").length;
			if (n == 1)
				$jB(".compcheck input").attr ("checked","checked");
			if (n == 0)
				$jB(".compcheck input").removeAttr ("checked");
			}
		);
	});

	function getLoteIDs () {
		var ids = new Array ();
		$jB('.compcheck input').each (function (index, value) {
			if ($jB(value).is('input:checked')) {
 				ids.push(index);
			}
		});
		var args = new Object ();
		var i = 0;
		args['lote']=true;
		for (x in ids)
		{
			args["c"+i] = ids[x];
			i += 1;
		}
		args["cLength"] = ids.length;
		args['formatos'] = 'pdf,html';
		return args;
	};


	function getComprovanteID (id) {
		var jID = "#"+id.replace(/\:/g, '\\:');
		var css = $jB(jID).attr ("class");
		var re = new RegExp(/\bcomprovante[0-9]+\b/);
		var m = re.exec(css);
		var s = "";
		if (m != null) {
			for (i = 0; i < m.length; i++) {
				s = s + m[i] + "\n";
			}
			s = s.replace ("comprovante","");
		}
		return {cId : s, formatos : 'pdf,html'};

	};