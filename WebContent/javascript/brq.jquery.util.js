/** Funções javascript util para toda a aplicação */

var localCompleto = new Array();
var projectName;
var STRING_EMPTY = "";
var AJAX_CALLS_SELECTOR = '.ajax-call';
var COLLAPSE_CLOSED = '.panelGrid-expandivel-closed';
var COLLAPSE_OPENED = '.panelGrid-expandivel-opened';

var ajaxCalls = {};

/** Carrega todos os itens como fechado ao carregar a Pagina */
jQuery(document).ready(function() {

  /**
     * Carrega a caminho do Projeto e separa pela barra e Recupera o nome do
     * Projeto
     */
  localCompleto = location.pathname.split('/');
  projectName = "/" + localCompleto[1];
  
  bindAjaxCalls();
  unbindAjaxCalls();
});

App.ajax.onSuccess(bindAjaxCalls);
App.ajax.onSuccess(unbindAjaxCalls);

function bindAjaxCalls() {
	/** Chamada Responsavel pelo Ajax do Calendário */
	jQuery(AJAX_CALLS_SELECTOR).each(function() {
		var self = jQuery(this);
		var classes = self.attr("class").split(' ');
		var methodName = classes[1];
		var formName = self.attr("id").split(":")[0];
		
		var execute = self.attr('onclick').substring(self.attr('onclick').indexOf('{execute:'));
		var indexFimExecute = execute.indexOf("click\\\'}") + 8;
		execute = execute.substring(0, indexFimExecute);
		
		if(execute) {
			var args = JSON.parse(execute.replace(/\\'/g, "\"").replace('execute:', '"execute":').replace('render:', '"render":'));
			
			ajaxCalls[methodName] = {
					$element : self,
					formName : formName,
					call : function() {
						var element = this.$element[0];
						
						jsf.ajax.request(element, null, args);
					}
			};			
		}
		
	});
}

/** Remove o Evento Click dos campos com classe ajax-call */
function unbindAjaxCalls() {
  jQuery(AJAX_CALLS_SELECTOR).removeAttr('onclick');
}

/** Recebe a chamada do Componente Calendar e chama um Evento Ajax */
function verificaData(chamada) {
	ajaxCalls[chamada].call();
}

/** Recebe a chamada do Componente Calendar e chama um Evento Ajax */
function limpaData(component, chamada) {
	component = component.replace(':', '\\\:')
	
	var fieldDay = jQuery("#" + component + "Dia").val();
	var fieldMonth = jQuery("#" + component + "Mes").val();
	var fieldYear = jQuery("#" + component + "Ano").val();
	
	var fieldsFilled = fieldDay && fieldMonth && fieldYear;
	var fieldsEmpty = !fieldDay && !fieldMonth && !fieldYear; 
	
	// Chama o ajax se todos estiverem preenchidos ou se todos estiverem apagados
	if (fieldsFilled || fieldsEmpty) {
		ajaxCalls[chamada].call();
	}
	
}

function textCounter(field, maxlimit) {
	if (field.value.length > maxlimit) {
		field.value = field.value.substring(0, maxlimit);
	}
}

String.prototype.trim = function(){
  return( this.replace(/^\s+|\s+$/g,"") );
}
