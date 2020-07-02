function loadMasks() {
	includeJavaScript('/javascript/jquery-1.3.2.min.js', loadLibMasks);
	}

function loadLibMasks() {
	includeJavaScript('/javascript/jquery.meio.mask.js', loadMasksJQuery);
}

function loadMasksJQuery() {
	(function($){
		
		var isIphone = (window.orientation != undefined),
			// browsers like firefox2 and before and opera doenst have the onPaste event, but the paste feature can be done with the onInput event.
			pasteEvent = (($.browser.opera || ($.browser.mozilla && parseFloat($.browser.version.substr(0,3)) < 1.9 ))? 'input': 'paste');
			
		$.event.special.paste = {
			setup: function() {
		    	if(this.addEventListener)
		        	this.addEventListener(pasteEvent, pasteHandler, false);
	   			else if (this.attachEvent)
					this.attachEvent(pasteEvent, pasteHandler);
			},

			teardown: function() {
				if(this.removeEventListener)
		        	this.removeEventListener(pasteEvent, pasteHandler, false);
	   			else if (this.detachEvent)
					this.detachEvent(pasteEvent, pasteHandler);
			}
		};
		
		// the timeout is set because we can't get the value from the input without it
		function pasteHandler(e){
			var self = this;
			e = $.event.fix(e || window.e);
			e.type = 'paste';
			// Execute the right handlers by setting the event type to paste
			setTimeout(function(){ $.event.handle.call(self, e); }, 1);
		};

		$.extend({
			mask : {
				
				// the mask rules. You may add yours!
				// number rules will be overwritten
				rules : {
					'z': /[a-z]/,
					'Z': /[A-Z]/,
					'a': /[a-zA-Z]/,
					'*': /[0-9a-zA-Z]/,
					'@': /[0-9a-zA-Z������������������]/
				},
				
				// these keys will be ignored by the mask.
				// all these numbers where obtained on the keydown event
				keyRepresentation : {
					8	: 'backspace',
					9	: 'tab',
					13	: 'enter',
					16	: 'shift',
					17	: 'control',
					18	: 'alt',
					27	: 'esc',
					33	: 'page up',
					34	: 'page down',
					35	: 'end',
					36	: 'home',
					37	: 'left',
					38	: 'up',
					39	: 'right',
					40	: 'down',
					45	: 'insert',
					46	: 'delete',
					116	: 'f5',
					123 : 'f12',
					224	: 'command'
				},
				
				iphoneKeyRepresentation : {
					10	: 'go',
					127	: 'delete'
				},
				
				signals : {
					'+' : '',
					'-' : '-'
				},
				
				// default settings for the plugin
				options : {
					attr: 'alt', // an attr to look for the mask name or the mask itself
					mask: null, // the mask to be used on the input
					type: 'fixed', // the mask of this mask
					maxLength: -1, // the maxLength of the mask
					defaultValue: '', // the default value for this input
					signal: false, // this should not be set, to use signal at masks put the signal you want ('-' or '+') at the default value of this mask.
								   // See the defined masks for a better understanding.
					
					textAlign: true, // use false to not use text-align on any mask (at least not by the plugin, you may apply it using css)
					selectCharsOnFocus: false, // select all chars from input on its focus
					autoTab: false, // auto focus the next form element when you type the mask completely
					setSize: false, // sets the input size based on the length of the mask (work with fixed and reverse masks only)
					fixedChars : '[(),.:/ -]', // fixed chars to be used on the masks. You may change it for your needs!
					
					onInvalid : function(){},
					onValid : function(){},
					onOverflow : function(){}
				},
				
				// masks. You may add yours!
				// Ex: $.fn.setMask.masks.msk = {mask: '999'}
				// and then if the 'attr' options value is 'alt', your input should look like:
				// <input type="text" name="some_name" id="some_name" alt="msk" />
				masks : {
					 valorDuasCasasPDC:{ mask : '99,999.999.9', type : 'reverse' },
					 valorDuasCasas:{ mask : '99,999.999.999.999.999', type : 'reverse'},
					 valorDuasCasas9:{ mask : '99,999.999.999', type : 'reverse'},
					 valorSemCasas:{ mask : '999.999.999.999.999', type : 'reverse', defaultValue: '+'},
					 valorSemCasas15:{ mask : '999.999.999.999.999', type : 'reverse'},
					 valorSemCasas19: { mask : '999.999.999.999.999.999.9', type : 'reverse'},
					 valorSemCasas9:{ mask : '999.999.999', type : 'reverse', defaultValue: '' },
					 valorSemCasas10:{ mask : '999.999.999.9', type : 'reverse'},
					 valorDuasCasasNegativo:{ mask : '99,999.999.999.999.999', type : 'reverse', defaultValue: '+'},
					 valorSemCasasNegativo:{ mask : '999.999.999.999.999', type : 'reverse', defaultValue: '+'},
					 valorDuasCasasSaque:{ mask : '99,999.999.999.999.9', type : 'reverse' },
					
					 valorDuasCasasBen:{ mask : '99,999.999.999.999.9', type : 'reverse' },
					
					 valorDuasCasasDefault:{ mask : '99,999.999.999.999.999', type : 'reverse', defaultValue: '' },
					 valorSemCasasDefault:{ mask : '999.999.999.999.999', type : 'reverse', defaultValue: '' },
					 valorDuasCasasMax3:{ mask : '9,99', type : 'reverse' },
					 valorDuasCasasTrezeDigitosDefault:{ mask : '99,999.999.999.999.9', type : 'reverse', defaultValue: '' },
					 valorDuasCasasMax5:{ mask : '99,999', type : 'reverse', defaultValue: '' },
					 valorUmaCasaMax4:{ mask : '9,999', type : 'reverse', defaultValue: '' },
					 valorCincoCasas:{ mask : '99999,999.999.999.999', type : 'reverse' },
					 valorCincoCasasMax5:{ mask : '99999,999.99', type : 'reverse' },
					 valorCincoCasasDefault:{ mask : '99999,999.999.999.999', type : 'reverse', defaultValue: '' },
					 percentualDuasCasas:{ mask : '99,999', type : 'reverse', defaultValue: ''},
				     percentualDuasCasasSemDefault:{ mask : '99,99'},
				     percentualTresCasas:{ mask : '999,999', type : 'reverse', defaultValue: ''},
				     percentualCincoCasas:{ mask: '99999,999', type : 'reverse', defaultValue: ''},
				     percentualDuasCasasDecimais:{ mask: '99,999', type : 'reverse'},
				     percentualDuasCasasDecimaisNegativo:{ mask: '99,999', type : 'reverse', defaultValue: '+'},
				    
				     valorBeneficio:{ mask: '99,999.999.9' ,type : 'reverse' },
				     valorSaque:{ mask: '99,999.999.9',type : 'reverse' },
				     valorSalario:{ mask: '99,999.999.9',type : 'reverse' },
				     
				     numero9Formatado:{ mask : '999.999.999', type : 'reverse', defaultValue: '' },
				     
				     indice:{ mask : '99999999,999999999', type : 'reverse', defaultValue: '000000000'},
				     numerico18:{ mask:'9', type:'repeat', 'maxLength': 18 },
					 numerico16:{ mask:'9', type:'repeat', 'maxLength': 16 },
					 numerico15:{ mask:'9', type:'repeat', 'maxLength': 15 },
					 numerico14:{ mask : '99999999999999' },
					 numerico13:{ mask:'9', type:'repeat', 'maxLength': 13 },
					 numerico12:{ mask :  '999999999999' },
					 numerico11:{ mask : '99999999999' },
				     numerico10:{ mask : '9999999999' },
				     numerico9:{ mask : '999999999' },
				     numerico8:{ mask : '99999999' },
				     numerico7:{ mask : '9999999' },
				     numerico6:{ mask : '999999' },
				     numerico5:{ mask : '99999' },
				     numerico4:{ mask : '9999' },
				     numerico3:{ mask : '999' },
				     numerico2:{ mask : '99' },
				     numerico1:{ mask : '9' },
				     numerico:{ mask : '9', type : 'repeat' },
				     numerico6Sinal:{ mask : '999999', type : 'reverse', defaultValue: '+'},
				     horaMinSeg:{ mask : '99:99:99', type : 'reverse' },
				     cpf:{ mask : '999.999.999'},
				     cpfCompleto:{ mask : '999.999.999-99'},
				     cnpj:{ mask : '99.999.999'},
				     cnpjCompleto: { mask : '99.999.999/9999-99'},
				     filial:{ mask : '9999'},
				     digitoCpfCnpj:{ mask : '99'},
				     cep:{ mask : '99999'},
				     cepComplemento:{ mask : '999'},   
				     ddd:{ mask : '999'},
				     telefone:{ mask : '99999-9999'},
				     telefoneComDdd:{ mask : '(99)99999-9999'},
				     beneficio:{ mask : '9-9999999999',type:'reverse'},
				     matricula:{ mask : '999.999.999.99',type:'reverse'},
				     agencia:{ mask : '99999'},
				     conta:{ mask : '99999999999**'},
				     data:{ mask : '99/99/9999'},
				     diasDefault:{ mask : '99', type:'reverse', defaultValue:'0'},
				     contaMascara: { mask : '99999-9' },
				     contaOfertaMascara: { mask : '9-9999999',type:'reverse' },
				     agenciaMascara: { mask : '9-9999',type:'reverse' },
				     mes_ano: { mask : '99/9999' },
				     anoSafra: { mask : '99/99' },
				     alfa: { mask : '*', type:'repeat'},
				     cincoMilCaracteres: { mask : '@', type:'repeat', 'maxLength': 5000},
				     
				     rgLeonardo:{ mask : '99.999.999'},
				     rgLeonardoCompleto:{ mask : '99.999.999-9'},
				     
				     rgJoaoCarlos:{ mask : '99.999.999-*'},
				     cepJoaoCarlos:{ mask : '99999-999'},
				     telefoneComDddJoaoCarlos:{ mask : '(99)9999-9999'},
				     celularComDddJoaoCarlos:{ mask : '(99)99999-9999'},	
				     
				     // mask Vitória
				     rgVitoria:{ mask : '99.999.999-9'},
				     cepVitoria:{ mask : '99999-999'},
				     celularComDddVitoria:{ mask : '(99) 99999-9999'},
				     
				  // Mascaras Wellington
				     wellingtonRg:{ mask : '99.999.999-9'},
				     wellingtonCepCompleto:{ mask : '99999-999'},
				     wellingtonTelefone:{ mask : '(99)9999-9999'},
				     wellingtonCelular:{ mask : '(99)99999-9999'},
				     
				     // Mascaras treinamento pedro
				     pedroCepCompleto: { mask : '99999-999'},
				     pedroRgCompleto: { mask : '99.999.999-*'},
				     pedroTelefoneResidencialComDdd: { mask : '(99)9999-9999'},
				     
				     rgCompletoMatheus: { mask : '99.999.999-*'},
				     cepCompletoMatheus:{ mask: '99999-999'},
				     telefoneNormalMatheus:{ mask : '(99)9999-9999'},
				     
				     cepCompletoAnderson:{ mask: '99999-999'},
				     telefoneNormalAnderson:{ mask : '(99)9999-9999'},
				     rgCompletoAnderson: { mask : '99.999.999-*'},
				     
				     //MASCARAS TELA MENSAGEM
				     hora:{mask: '99'},
				     minuto:{mask: '99'},
				     isn_osn:{mask: '999999'},
				     correspondente:{mask: '***********'},
				     departamento:{mask: '***'},
				     referencia:{mask:'99999999999'}
				     
				},
						
				init : function(){
					// if has not inited...
					if( !this.hasInit ){

						var self = this, i,
							keyRep = (isIphone)? this.iphoneKeyRepresentation: this.keyRepresentation;
							
						this.ignore = false;
				
						// constructs number rules
						for(i=0; i<=9; i++) this.rules[i] = new RegExp('[0-'+i+']');
					
						this.keyRep = keyRep;
						// ignore keys array creation for iphone or the normal ones
						this.ignoreKeys = [];
						$.each(keyRep,function(key){
							self.ignoreKeys.push( parseInt(key) );
						});
						
						this.hasInit = true;
					}
				},
				
				set: function(el,options){
					
					var maskObj = this,
						$el = $(el),
						mlStr = 'maxLength';
					
					options = options || {};
					this.init();
					
					return $el.each(function(){
						
						if(options.attr) maskObj.options.attr = options.attr;
						
						var $this = $(this),
							o = $.extend({}, maskObj.options),
							attrValue = $this.attr(o.attr),
							tmpMask = '';
							
						// then we look for the 'attr' option
						tmpMask = (typeof options == 'string')? options: (attrValue != '')? attrValue: null;
						if(tmpMask) o.mask = tmpMask;
						
						// then we see if it's a defined mask
						if(maskObj.masks[tmpMask]) o = $.extend(o, maskObj.masks[tmpMask]);
						
						// then it looks if the options is an object, if it is we will overwrite the actual options
						if(typeof options == 'object' && options.constructor != Array) o = $.extend(o, options);
						
						//then we look for some metadata on the input
						if($.metadata) o = $.extend(o, $this.metadata());
						
						if(o.mask != null){
							
							if($this.data('mask')) maskObj.unset($this);
							
							var defaultValue = o.defaultValue,
								reverse = (o.type=='reverse'),
								fixedCharsRegG = new RegExp(o.fixedChars, 'g');
							
							if(o.maxLength == -1) o.maxLength = $this.attr(mlStr);
							
							o = $.extend({}, o,{
								fixedCharsReg: new RegExp(o.fixedChars),
								fixedCharsRegG: fixedCharsRegG,
								maskArray: o.mask.split(''),
								maskNonFixedCharsArray: o.mask.replace(fixedCharsRegG, '').split('')
							});
							
							//setSize option (this is not removed from the input (while removing the mask) since this would be kind of funky)
							if((o.type=='fixed' || reverse) && o.setSize && !$this.attr('size')) $this.attr('size', o.mask.length);
							
							//sets text-align right for reverse masks
							if(reverse && o.textAlign) $this.css('text-align', 'right');
							
							if(this.value!='' || defaultValue!=''){
								// apply mask to the current value of the input or to the default value
								var val = maskObj.string((this.value!='')? this.value: defaultValue, o);
								//setting defaultValue fixes the reset button from the form
								this.defaultValue = val;
								$this.val(val);
							}
							
							// compatibility patch for infinite mask, that is now repeat
							if(o.type=='infinite') o.type = 'repeat';
							
							$this.data('mask', o);
							
							// removes the maxLength attribute (it will be set again if you use the unset method)
							$this.removeAttr(mlStr);
							
							// setting the input events
							$this.bind('keydown.mask', {func:maskObj._onKeyDown, thisObj:maskObj}, maskObj._onMask)
								.bind('keypress.mask', {func:maskObj._onKeyPress, thisObj:maskObj}, maskObj._onMask)
								.bind('keyup.mask', {func:maskObj._onKeyUp, thisObj:maskObj}, maskObj._onMask)
								.bind('paste.mask', {func:maskObj._onPaste, thisObj:maskObj}, maskObj._onMask)
								.bind('focus.mask', maskObj._onFocus)
								.bind('blur.mask', maskObj._onBlur)
								.bind('change.mask', maskObj._onChange);
						}
					});
				},
				
				//unsets the mask from el
				unset : function(el){
					var $el = $(el);
					
					return $el.each(function(){
						var $this = $(this);
						if($this.data('mask')){
							var maxLength = $this.data('mask').maxLength;
							if(maxLength != -1) $this.attr('maxLength', maxLength);
							$this.unbind('.mask')
								.removeData('mask');
						}
					});
				},
				
				//masks a string
				string : function(str, options){
					this.init();
					var o={};
					if(typeof str != 'string') str = String(str);
					switch(typeof options){
						case 'string':
							// then we see if it's a defined mask	
							if(this.masks[options]) o = $.extend(o, this.masks[options]);
							else o.mask = options;
							break;
						case 'object':
							o = options;
					}
					if(!o.fixedChars) o.fixedChars = this.options.fixedChars;

					var fixedCharsReg = new RegExp(o.fixedChars),
						fixedCharsRegG = new RegExp(o.fixedChars, 'g');
						
					// insert signal if any
					if( (o.type=='reverse') && o.defaultValue ){
						if( typeof this.signals[o.defaultValue.charAt(0)] != 'undefined' ){
							var maybeASignal = str.charAt(0);
							o.signal = (typeof this.signals[maybeASignal] != 'undefined') ? this.signals[maybeASignal] : this.signals[o.defaultValue.charAt(0)];
							o.defaultValue = o.defaultValue.substring(1);
						}
					}
					
					return this.__maskArray(str.split(''),
								o.mask.replace(fixedCharsRegG, '').split(''),
								o.mask.split(''),
								o.type,
								o.maxLength,
								o.defaultValue,
								fixedCharsReg,
								o.signal);
				},
				
				// all the 3 events below are here just to fix the change event on reversed masks.
				// It isn't fired in cases that the keypress event returns false (needed).
				_onFocus: function(e){
					var $this = $(this), dataObj = $this.data('mask');
					dataObj.inputFocusValue = $this.val();
					dataObj.changed = false;
					if(dataObj.selectCharsOnFocus) $this.select();
					
					//Caso seja reverse, seta o cursos no fim do campo
					if(dataObj.type=='reverse'){
						var len = $this.val().length;
						$this.context.setSelectionRange(len, len);
					}
				},
				
				_onBlur: function(e){
					var $this = $(this), dataObj = $this.data('mask');
					if(dataObj.inputFocusValue != $this.val() && !dataObj.changed)
						$this.trigger('change');
				},
				
				_onChange: function(e){
					$(this).data('mask').changed = true;
				},
				
				_onMask : function(e){
					var thisObj = e.data.thisObj,
						o = {};
					o._this = e.target;
					o.$this = $(o._this);
					// if the input is readonly it does nothing
					if(o.$this.attr('readonly')) return true;
					o.data = o.$this.data('mask');
					o[o.data.type] = true;
					o.value = o.$this.val();
					o.nKey = thisObj.__getKeyNumber(e);
					o.range = thisObj.__getRange(o._this);
					o.valueArray = o.value.split('');
					return e.data.func.call(thisObj, e, o);
				},
				
				_onKeyDown : function(e,o){
					// lets say keypress at desktop == keydown at iphone (theres no keypress at iphone)
					this.ignore = $.inArray(o.nKey, this.ignoreKeys) > -1 || e.ctrlKey || e.metaKey || e.altKey;
					if(this.ignore){
						var rep = this.keyRep[o.nKey];
						o.data.onValid.call(o._this, rep? rep: '', o.nKey);
					}
					return isIphone ? this._keyPress(e, o) : true;
				},
				
				_onKeyUp : function(e, o){
					//9=TAB_KEY 16=SHIFT_KEY
					//this is a little bug, when you go to an input with tab key
					//it would remove the range selected by default, and that's not a desired behavior
					if(o.nKey==9 || o.nKey==16) return true;
					
					if(o.data.type=='repeat'){
						this.__autoTab(o);
						return true;
					}

					return this._onPaste(e, o);
				},
				
				_onPaste : function(e,o){
					// changes the signal at the data obj from the input
					if(o.reverse) this.__changeSignal(e.type, o);
					
					var $thisVal = this.__maskArray(
						o.valueArray,
						o.data.maskNonFixedCharsArray,
						o.data.maskArray,
						o.data.type,
						o.data.maxLength,
						o.data.defaultValue,
						o.data.fixedCharsReg,
						o.data.signal
					);
					
					o.$this.val( $thisVal );
					// this makes the caret stay at first position when 
					// the user removes all values in an input and the plugin adds the default value to it (if it haves one).
					if( !o.reverse && o.data.defaultValue.length && (o.range.start==o.range.end) )
						this.__setRange(o._this, o.range.start, o.range.end);
						
					//fix so ie's and safari's caret won't go to the end of the input value.
					if( ($.browser.msie || $.browser.safari) && !o.reverse)
						this.__setRange(o._this,o.range.start,o.range.end);
					
					if(this.ignore) return true;
					
					this.__autoTab(o);
					return true;
				},
				
				_onKeyPress: function(e, o){
					
					if(this.ignore) return true;
					
					// changes the signal at the data obj from the input
					if(o.reverse) this.__changeSignal(e.type, o);
					
					var c = String.fromCharCode(o.nKey),
						rangeStart = o.range.start,
						rawValue = o.value,
						maskArray = o.data.maskArray;
					
					if(o.reverse){
						 	// the input value from the range start to the value start
						var valueStart = rawValue.substr(0, rangeStart),
							// the input value from the range end to the value end
							valueEnd = rawValue.substr(o.range.end, rawValue.length);
						
						rawValue = valueStart+c+valueEnd;
						//necessary, if not decremented you will be able to input just the mask.length-1 if signal!=''
						//ex: mask:99,999.999.999 you will be able to input 99,999.999.99
						if(o.data.signal && (rangeStart-o.data.signal.length > 0)) rangeStart-=o.data.signal.length;
					}

					var valueArray = rawValue.replace(o.data.fixedCharsRegG, '').split(''),
						// searches for fixed chars begining from the range start position, till it finds a non fixed
						extraPos = this.__extraPositionsTill(rangeStart, maskArray, o.data.fixedCharsReg);
					
					o.rsEp = rangeStart+extraPos;
					
					if(o.repeat) o.rsEp = 0;
					
					// if the rule for this character doesnt exist (value.length is bigger than mask.length)
					// added a verification for maxLength in the case of the repeat type mask
					if( !this.rules[maskArray[o.rsEp]] || (o.data.maxLength != -1 && valueArray.length >= o.data.maxLength && o.repeat)){
						// auto focus on the next input of the current form
						o.data.onOverflow.call(o._this, c, o.nKey);
						return false;
					}
					
					// if the new character is not obeying the law... :P
					else if( !this.rules[maskArray[o.rsEp]].test( c ) ){
						o.data.onInvalid.call(o._this, c, o.nKey);
						return false;
					}
					
					else o.data.onValid.call(o._this, c, o.nKey);
					
					var $thisVal = this.__maskArray(
						valueArray,
						o.data.maskNonFixedCharsArray,
						maskArray,
						o.data.type,
						o.data.maxLength,
						o.data.defaultValue,
						o.data.fixedCharsReg,
						o.data.signal,
						extraPos
					);
					
					o.$this.val( $thisVal );
					
					return (o.reverse)? this._keyPressReverse(e, o): (o.fixed)? this._keyPressFixed(e, o): true;
				},
				
				_keyPressFixed: function(e, o){

					if(o.range.start==o.range.end){
						// the 0 thing is cause theres a particular behavior i wasnt liking when you put a default
						// value on a fixed mask and you select the value from the input the range would go to the
						// end of the string when you enter a char. with this it will overwrite the first char wich is a better behavior.
						// opera fix, cant have range value bigger than value length, i think it loops thought the input value...
						if((o.rsEp==0 && o.value.length==0) || o.rsEp < o.value.length)
							this.__setRange(o._this, o.rsEp, o.rsEp+1);	
					}
					else
						this.__setRange(o._this, o.range.start, o.range.end);
						
					return true;
				},
				
				_keyPressReverse: function(e, o){
					//fix for ie
					//this bug was pointed by Pedro Martins
					//it fixes a strange behavior that ie was having after a char was inputted in a text input that
					//had its content selected by any range 
					if($.browser.msie && ((o.range.start==0 && o.range.end==0) || o.range.start != o.range.end ))
						this.__setRange(o._this, o.value.length);
					return false;
				},
				
				__autoTab: function(o){
					if(o.data.autoTab
						&& (
							(
								o.$this.val().length >= o.data.maskArray.length 
								&& !o.repeat 
							) || (
								o.data.maxLength != -1
								&& o.valueArray.length >= o.data.maxLength
								&& o.repeat
							)
						)
					){
						var nextEl = this.__getNextInput(o._this, o.data.autoTab);
						if(nextEl){
							o.$this.trigger('blur');
							nextEl.focus().select();
						}
					}
				},
				
				// changes the signal at the data obj from the input			
				__changeSignal : function(eventType,o){
					if(o.data.signal!==false){
						var inputChar = (eventType=='paste')? o.value.charAt(0): String.fromCharCode(o.nKey);
						if( this.signals && (typeof this.signals[inputChar] != 'undefined') ){
							o.data.signal = this.signals[inputChar];
						}
					}
				},
				
				__getKeyNumber : function(e){
					return (e.charCode||e.keyCode||e.which);
				},
				
				// this function is totaly specific to be used with this plugin, youll never need it
				// it gets the array representing an unmasked string and masks it depending on the type of the mask
				__maskArray : function(valueArray, maskNonFixedCharsArray, maskArray, type, maxlength, defaultValue, fixedCharsReg, signal, extraPos){
					if(type == 'reverse') valueArray.reverse();
					valueArray = this.__removeInvalidChars(valueArray, maskNonFixedCharsArray, type=='repeat'||type=='infinite');
					if(defaultValue) valueArray = this.__applyDefaultValue.call(valueArray, defaultValue);
					valueArray = this.__applyMask(valueArray, maskArray, extraPos, fixedCharsReg);
					switch(type){
						case 'reverse':
							valueArray.reverse();
							return (signal || '')+valueArray.join('').substring(valueArray.length-maskArray.length);
						case 'infinite': case 'repeat':
							var joinedValue = valueArray.join('');
							return (maxlength != -1 && valueArray.length >= maxlength)? joinedValue.substring(0, maxlength): joinedValue;
						default:
							return valueArray.join('').substring(0, maskArray.length);
					}
					return '';
				},
				
				// applyes the default value to the result string
				__applyDefaultValue : function(defaultValue){
					var defLen = defaultValue.length,thisLen = this.length,i;
					//removes the leading chars
					for(i=thisLen-1;i>=0;i--){
						if(this[i]==defaultValue.charAt(0)) this.pop();
						else break;
					}
					// apply the default value
					for(i=0;i<defLen;i++) if(!this[i])
						this[i] = defaultValue.charAt(i);
						
					return this;
				},
				
				// Removes values that doesnt match the mask from the valueArray
				// Returns the array without the invalid chars.
				__removeInvalidChars : function(valueArray, maskNonFixedCharsArray, repeatType){
					// removes invalid chars
					for(var i=0, y=0; i<valueArray.length; i++ ){
						if( maskNonFixedCharsArray[y] &&
							this.rules[maskNonFixedCharsArray[y]] &&
							!this.rules[maskNonFixedCharsArray[y]].test(valueArray[i]) ){
								valueArray.splice(i,1);
								if(!repeatType) y--;
								i--;
						}
						if(!repeatType) y++;
					}
					return valueArray;
				},
				
				// Apply the current input mask to the valueArray and returns it. 
				__applyMask : function(valueArray, maskArray, plus, fixedCharsReg){
					if( typeof plus == 'undefined' ) plus = 0;
					// apply the current mask to the array of chars
					for(var i=0; i<valueArray.length+plus; i++ ){
						if( maskArray[i] && fixedCharsReg.test(maskArray[i]) )
							valueArray.splice(i, 0, maskArray[i]);
					}
					return valueArray;
				},
				
				// searches for fixed chars begining from the range start position, till it finds a non fixed
				__extraPositionsTill : function(rangeStart, maskArray, fixedCharsReg){
					var extraPos = 0;
					while(fixedCharsReg.test(maskArray[rangeStart++])){
						extraPos++;
					}
					return extraPos;
				},
				
				__getNextInput: function(input, selector){
					var formEls = input.form.elements,
						initialInputIndex = $.inArray(input, formEls) + 1,
						$input = null,
						i;
					// look for next input on the form of the pased input
					for(i = initialInputIndex; i < formEls.length; i++){
						$input = $(formEls[i]);
						if(this.__isNextInput($input, selector))
							return $input;
					}
						
					var forms = document.forms,
						initialFormIndex = $.inArray(input.form, forms) + 1,
						y, tmpFormEls = null;
					// look for the next forms for the next input
					for(y = initialFormIndex; y < forms.length; y++){
						tmpFormEls = forms[y].elements;
						for(i = 0; i < tmpFormEls.length; i++){
							$input = $(tmpFormEls[i]);
							if(this.__isNextInput($input, selector))
								return $input;
						}
					}
					return null;
				},
				
				__isNextInput: function($formEl, selector){
					var formEl = $formEl.get(0);
					return formEl
						&& (formEl.offsetWidth > 0 || formEl.offsetHeight > 0)
						&& formEl.nodeName != 'FIELDSET'
						&& (selector === true || (typeof selector == 'string' && $formEl.is(selector)));
				},
				
				// http://www.bazon.net/mishoo/articles.epl?art_id=1292
				__setRange : function(input, start, end) {
					if(typeof end == 'undefined') end = start;
					if (input.setSelectionRange){
						input.setSelectionRange(start, end);
					}
					else{
						// assumed IE
						var range = input.createTextRange();
						range.collapse();
						range.moveStart('character', start);
						range.moveEnd('character', end - start);
						range.select();
					}
				},
				
				// adaptation from http://digitarald.de/project/autocompleter/
				__getRange : function(input){
					if (!$.browser.msie) return {start: input.selectionStart, end: input.selectionEnd};
					var pos = {start: 0, end: 0},
						range = document.selection.createRange();
					pos.start = 0 - range.duplicate().moveStart('character', -100000);
					pos.end = pos.start + range.text.length;
					return pos;
				},
				
				//deprecated
				unmaskedVal : function(el){
					return $(el).val().replace($.mask.fixedCharsRegG, '');
				}
				
			}
		});
		
		$.fn.extend({
			setMask : function(options){
				return $.mask.set(this, options);
			},
			unsetMask : function(){
				return $.mask.unset(this);
			},
			//deprecated
			unmaskedVal : function(){
				return $.mask.unmaskedVal(this[0]);
			}
		});
	})(jQuery);
	setMasks();
}

function setMasks() {
	(function(jQuery){
		jQuery(function(){
			jQuery('input:text').setMask();
		});
	})(jQuery);
}

function includeJavaScript(jsFile, loadFunction) {
	var domScript = document.createElement("script");
	domScript.type = "text/javascript";
	domScript.src = jsFile;
	document.body.appendChild(domScript);

	domScript.onreadystatechange = function () {
		if (domScript.readyState == 'loaded' || domScript.readyState == 'complete') {
			loadFunction();
		}
	}
}


function imposeMaxLength(obj, maxlenght) {
	var mlength = obj.getAttribute ? parseInt(maxlenght) : ""
	if (obj.getAttribute && obj.value.length > mlength) {
		obj.value = obj.value.substring(0, mlength)
	}
}

function setDynamicHeight(){
	var collectionTabelas = document.getElementsByClassName("scrollableColumns");
	for(i = 0; i < collectionTabelas.length; i++){
		var tabela = collectionTabelas[i];
		tabela.style.height = "auto";
		tabela.style.maxHeight = "200px";
		
		//Scroll vertical
		tabela.style.overflowY = "auto";
		//Scroll horizontal
		tabela.style.overflowX = "hidden";
	}
}

/*
 * Funcao para alinhar os totalizadores das tabelas com as colunas de width dinamico
 */
function alinharTotalizadores(idForm, idTabela, idGridTotalizadores) {
	try {
		//Array dos headers das colunas da tabela
		var colunas = document.getElementById('normalMainDiv' + idTabela).getElementsByClassName('thOut');
		
		//Array dos panelGrids com as labels de totalizador
		var totalizadores = document.getElementById(idForm + ':' + idGridTotalizadores).getElementsByTagName('table');
		
		// se cair no if, tem coluna com radio
		if (colunas[0].className.search('scrollableSelection') > 0) {
			totalizadores[0].width = new Number(colunas[0].style.minWidth.slice(0, colunas[0].style.minWidth.indexOf('px'))) + 
				new Number(colunas[1].style.width.slice(0, colunas[1].style.width.indexOf('px')));
			for (var i = 1; i < totalizadores.length; i++) {
				totalizadores[i].width = new Number(colunas[i+1].style.width.slice(0, colunas[i+1].style.width.indexOf('px'))) + 2;
			}
		} else {
			for (var i = 0; i < totalizadores.length; i++) {
				totalizadores[i].width = new Number(colunas[i].style.width.slice(0, colunas[i].style.width.indexOf('px'))) + 2;
			}
		}
	} catch (e) {
		return;
	}
}

//Funcao para recuperar o nome do form atual
function searchFormByField() {
	for(var i=0; i < document.forms.length; i++){
		if(document.getElementById(document.forms[i].name+':scrollPointIndex')!=null){
			formName = document.forms[i].name;
			return;
		}
	}
}

//--- INICIO tratamento para salvar posicao do scroll e reposicionar a pagina
var formName;
// Funcao para setar a posicao do scroll quando realiza o submit
function setScrollPos() {
	searchFormByField();
	var divY = document.getElementById('pageContent').scrollTop;
	document.getElementById(formName+':scrollPointIndex').value = divY;
}

// Para as paginas com multiplos forms
function setScrollPosForms(form) {
	searchFormByField();
	var divY = document.getElementById('pageContent').scrollTop;
	document.getElementById(form+':scrollPointIndex').value = divY;
}

function reposicionaTela() {
	searchFormByField();
	var scrollPosition = document.getElementById(formName+':scrollPointIndex').value;
	if(null != scrollPosition && 0 != scrollPosition) {
		document.getElementById('pageContent').scrollTop = scrollPosition;
	}
}

function limparRadio() {
	searchFormByField();
	var formAtivo = document.getElementById(formName);
	for (i = 0; i < formAtivo.elements.length; i++) {
		/*
		 * Se cair no if, e radio de tabela
		 * nextSibling representa a label de descricao do radio
		 */
		if (formAtivo.elements[i].type == 'radio' && null == formAtivo.elements[i].nextSibling) {
			formAtivo.elements[i].checked = 0
		}
	}
}

function blockEnter() {
	//Função para bloquear a ativação de botões pela tecla enter
	try {
		if (event.keyCode == 13 && !event.srcElement.className.includes('Textarea')) {
			event.preventDefault();
			return;
		}		
	} catch (e) {
		if (event.keyCode == 13 && !(event.srcElement.className.substring(9, 17) == 'Textarea')) {
			event.preventDefault();
			return;
		}
	}
	
}

	function vNumero(obj,formato){
		
		if(event.keyCode == 9 || event.keyCode == 16){
			return;
		}
		
	var formatoPercent = formato == '9(3)V9(2)';
		
	  var reDecimal = /^((\d+|\d{1,3}(\.\d{3})+)(\,\d*)?|\,\d+)?$/;
	  var valor=obj.value;
	  if(valor=="") return;
	  var neg=valor.substring(0,1)=="-";
	  if(neg){
		  valor = valor.substring(1);
	  }
	  var ints,decs;
	  formato=formato.split("V");
	  function f(s){
	    var conta=0;
	    var r=/\(\d+\)/;
	    var mult=s.match(r);
	    if(mult)
	      conta+=parseInt(mult[0].replace(/\D/g,""),10)-1;
	    var noves=s.replace(r,"").match(/9/g);
	    if(noves)
	      conta+=noves.length;
	    return conta;
	  }
	  ints=f(formato[0]);
	  decs=formato.length>1?f(formato[1]):0;
	    
//	  if(! reDecimal.test( valor ) ) {
//	    obj.value = "";
//	    obj.focus();
//	    return;
//	  }
	  
	  if(formatoPercent){
		  valor=valor.replace(",",".");
		  valor = fmtPercentual(valor);
	  }else{
		  valor=valor.replace(/(^0*)|[^0-9,]/g,"").replace(",",".");
	  }
	  
	  
	  partes=valor.split(".");
	  if(partes[0].length==0){
	    valor="0"+valor;
	  }
	  if(partes[0].length>ints){
	    obj.value="";
	    obj.focus();
	    return;
	  }
	  if(partes.length>1){
	    if(decs==0){
	      obj.value="";
	      obj.focus();
	      return;
	    }
	    if(partes[1].length>decs){
	      obj.value="";
	      obj.focus();
	      return;
	    }
	  }
	  if(neg)valor="-"+valor;
	  if(decs>0){
	    obj.value=fmtMoeda(valor,decs);
	  }else{
		  obj.value=fmtValor(valor);
	  }
	}
	
	function fmtPercentual (valor){
		var tmp = valor.replace(",", ".").replace(".", "");
		
		if(tmp.length > 3 && tmp.substring(0,1) == '0' && tmp.substring(1,2)){
			valor = valor.substring(1);
			if(valor.substring(0,1) == '.'){
				valor = valor.substring(1);
			}
		}
		
		if(tmp.length > 2 && tmp.substring(0,1) == '0' && tmp.substring(1,2) == '0' && tmp.substring(2,3) == '0'){
			valor = valor.substring(1);
			if(valor.substring(0,1) == '.'){
				valor = valor.substring(1);
			}
			
			if(valor.length > 2 && valor.substring(0,1) == '0' && valor.substring(1,2) == '0'){
				valor = valor.substring(1);
			}
		}
		return valor;
		
	}
	
	function fmtMoeda(valor,decimais){
		  var v = valor+"";
		  if(!decimais)decimais=2;
		  var ret="";
		  var neg=v.substring(0,1)=="-";
		  v=v.replace(/[^\d\.]/g,"");
		  v=v.split(".");
		  var pos=v[0].length;
		  while(pos>3){
		    ret="."+v[0].substring(pos-3,pos)+ret;
		    pos-=3;
		  }
		  ret=v[0].substring(0,pos)+ret;
		  var dec=v[1]?v[1]:"";
		  ret+=dec.substring(0,decimais);
		  if(neg)ret="-"+ret;

		  return ret;
	}
	
	function fmtValor(valor){
		  var v = valor+"";
		  var ret="";
		  var neg=v.substring(0,1)=="-";
		  v=v.replace(/[^\d\.]/g,"");
		  v=v.split(".");
		  var pos=v[0].length;
		  while(pos>3){
		    ret="."+v[0].substring(pos-3,pos)+ret;
		    pos-=3;
		  }
		  ret=v[0].substring(0,pos)+ret;
		  
		  if(neg)ret="-"+ret;
		  
		  return ret;
	}
