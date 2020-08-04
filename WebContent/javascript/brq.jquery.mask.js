/**
 * brq.jquery.mask.js
 * @version: v1.0.0
 * @author: Nicholas M. Dantas
 *
 * Created by Nicholas M. Dantas on 2015-12-21.
 *
 * Copyright (c) 2015 Bradesco
 *
 * Adaptacao do framework de Igor Escobar para a
 * utilizacao de mascaras dentro da arquitetura AWB.
 */

(function (){
	'use scrict';
	
	String.prototype.replaceAll = function (oldValue, newValue) {
		var self = this;

		return self.replace(new RegExp('[' + oldValue + ']', 'g'), newValue);
	};
	
	var $ = jQuery.noConflict();

	var knownTypes = [
		{ type: 'integer', mask: '0' },
		{ type: 'date', mask: '00/00/0000' },
		{ type: 'hour', mask: '00:00:00' },
		{ type: 'cpf', mask: '000.000.000-00', reverse: true },
		{ type: 'cnpj', mask: '000.000.000/0000-00', reverse: false },
		{ type: 'phone', mask: '0000-00000' },
		{ type: 'money', mask: '#0,00', reverse: false },
		{ type: 'money-dot', mask: '#.##0,00', reverse: true },
		{ type: 'referencia-bradesco', mask: '0000/000000000' },
		{ type: 'ddd-phone', mask: '(00)00000-0000' }
	];

	function loadMasks() {
		var masksSettings = [];

		$(':text[alt]').each(function () {
			var $element = $(this);
			var maskSettings = parseJson($element.attr('alt'));
			var hasMask = $element.data('hasMask');
			
			if (hasMask === undefined || hasMask === null) {
				$element.data('hasMask', false);
			} else {
				$element.data('hasMask', hasMask);
			}

			maskSettings.element = $element;
			maskSettings.identity = $element.attr('id');
			maskSettings.size = parseInt($element.attr('maxlength')) || 0;

			masksSettings.push(maskSettings);
		});

		// Percorre todos os itens que devem ter mascaras
		for (var i = 0; i < masksSettings.length; i++) {
			var maskSettings = masksSettings[i];
			
			// Caso ja haja mascara, nao repete a associação
			if (maskSettings.element.data('hasMask')) {
				continue;
			}

			var selectedKnownType = searchForKnownType(maskSettings.type || undefined);

			// Verifica se foi encontrado um tipo conhecido
			if (selectedKnownType) {
				selectedKnownType.reverse = maskSettings.reverse != undefined ? maskSettings.reverse : selectedKnownType.reverse;
				
				// Verifica se o tipo e um inteiro
				// Alguns dos tipos precisam de tratamento diferenciado
				switch (selectedKnownType.type) {
					case 'integer':
						var mask = '';

						// Customiza a mascara para o valor atribuido em maxlength
						for (var j = 0; j < maskSettings.size; j++) {
							mask += selectedKnownType.mask;
						}

						maskSettings.element.mask(mask);
						
						break;
						
					case 'ddd-phone':
						var behavior = function (val) {
						  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
						};

						var options = {
							onKeyPress: function(val, e, field, options) {
						    	field.mask(behavior.apply({}, arguments), options);
							}
						};
						
						maskSettings.element.mask(behavior, options);
						
						break;
					
					case 'referencia-bradesco':
						maskSettings.element.mask(selectedKnownType.mask, selectedKnownType);

						maskSettings.element.on('blur', function() {
							var $element = $(this);
							var value = $.trim($element.val());

							// Apenas formata se algum valor foi inserido
							if (value == undefined || value == '' || value.length == 14) {
								// Remove caso haja mensagem
								$element.next('span').remove();

								return;
							} else if (value.length < 4) {
								// Insere a mensagem de erro
								if (!$element.next().is('span')) {
									$element.after("<span class='error mask-error'><br/>O ano é obrigatório</span>");
								}

								return;
							} else {
								// Remove caso haja mensagem
								$element.next('span').remove();
								
								var slashIndex = value.indexOf('/');

								// Caso haja barra complementa o numero do boleto com
								// zeros a esquerda
								if (slashIndex > -1) {
									var components = value.split('/');
									var number = components[1];

									number = repeat('0', 9 - number.length) + number;

									$element.val(components[0] + '/' + number);
								} else { 
									$element.val(value + '/000000000');
								}
							}
						});						
						break; 
						
					case 'money':
						// Efetua a subtracao do tamanha da virgula (1) + as casas decimais (2) - Total (3)
						maskSettings.wholePartSize = maskSettings.size - 3;
						maskSettings.decimalPartSize = 2;
						maskSettings.handleThousandsGroups = maskSettings.separate ? true : false;
						maskSettings.element.attr('alt', JSON.stringify(maskSettings));
						
						setDecimalBehavior(maskSettings);
						break;
						
					case 'money-dot':
						// Efetua a subtracao do tamanha da virgula (1) + as casas decimais (2) - Total (3)
						var dots = Math.ceil(maskSettings.size / 3) - 1;
						
						// A subtração por 1 é devido à virgula
						maskSettings.element.attr('maxlength', maskSettings.size + dots - 1);
						maskSettings.element.attr('alt', JSON.stringify(maskSettings));
						
						maskSettings.element.mask(selectedKnownType.mask, selectedKnownType);
						
						var hasAjaxRequest = maskSettings.element.hasAjaxRequest();
						maskSettings.element.data('hasAjaxRequest', hasAjaxRequest);
						
						if (hasAjaxRequest) {
							maskSettings.element.removeAttr('onblur');
							maskSettings.element.removeAttr('onchange');
							maskSettings.element.removeAttr('onclick');							
						}

						maskSettings.element.off('change.brq.mask').on('change.brq.mask', function() {
							var el = this;
							var length = el.value.length;
							
							if (length > 0 && length <= 2) {
								var paddingValue = repeat('0', 2 - length) + el.value;
								
								paddingValue = '0,' + paddingValue;
								
								el.value = paddingValue;
							}
							
							var defaultValue = 0.0; 
							var value = 0.0; 
							
							// Se nao possuir virgula muda a forma de fazer a conversao
							if (el.defaultValue.indexOf(',') == -1) {
								defaultValue = parseFloat(el.defaultValue, 10);
							} else {
								defaultValue = parseFloat(el.defaultValue.replace(/[.]/g, '').replace(',', '.'), 10);
							}
							
							// Se nao possuir virgula muda a forma de fazer a conversao
							if (el.value.indexOf(',') == -1) {
								value = parseFloat(el.value, 10);
							} else {
								value = parseFloat(el.value.replace(/[.]/g, '').replace(',', '.'), 10);
							}
							
							if ($(el).data('hasAjaxRequest') && value != defaultValue) {
								$(el).callAjaxRequest();
							}
						});
						
						break;
						
					default:
						maskSettings.element.mask(selectedKnownType.mask, selectedKnownType);
						break;
				}
			} else {
				var customDecimalMask = maskSettings.wholePartSize || maskSettings.decimalPartSize;

				// caso necessite de uma formatacao decimal
				if (customDecimalMask) {
					maskSettings.handleThousandsGroups = maskSettings.separate ? true : false;
					setDecimalBehavior(maskSettings);
				} else if (maskSettings.mask) {
					maskSettings.element.mask(maskSettings.mask, maskSettings);
				} else {
					return;
				}
			}
			
			maskSettings.element.data('hasMask', true);
		}
	}

	function setDecimalBehavior(maskSettings) {
		var wholePartSize = maskSettings.wholePartSize || 0;
		var decimalPartSize = maskSettings.decimalPartSize || 0;						
		var checkOnBlur = maskSettings.checkOnBlur || true;
		var defaultValue = maskSettings.default;
		var allowNegative = maskSettings.allowNegative;
		var handleThousandsGroups = maskSettings.handleThousandsGroups;
		var newValue = '';
		var mask = ''; 
		var options = {
			translation: {
		      'D': {
		        pattern: /[0-9]/, 
		        optional: true
		      }		      
		    }
		};

		// Caso haja um valor default e nao haja valor no elemento
		// seta o valor default
		if (defaultValue != undefined && maskSettings.element.val() == '') {
			var formatedValue = defaultValue.toString().replace('.', ',');

			maskSettings.element.val(formatedValue);
		}
		
		// Ajusta o valor decimal quando perder o foco no campo
		if (checkOnBlur) {												
			maskSettings.element.on('blur', function () {							
				adjustField($(this));
			});
		}
		
		// Verifica se deve fazer tratar os separadores de milhares
		if (handleThousandsGroups) {
			maskSettings.element.on('focus', function () {							
				clearThousandsGroups($(this));
			});
		}

		adjustField(maskSettings.element, decimalPartSize);
		newValue = maskSettings.element.val();

		$.extend(options, maskSettings);

		// Percorre a quantidade exata para a parte inteira
		for (var j = 0; j < wholePartSize; j++) {
			mask += maskSettings.reverse ?  '0' : 'D';
		}

		mask += ",";

		// Percorre a quantidade exata para a parte decimal
		for (var j = 0; j < decimalPartSize; j++) {
			mask += maskSettings.reverse ? 'D' : '0';
		}
		
		// Caso haja necessidade de entradas negativas permite o caracter '-' 
		if (allowNegative) {
			var negativeTranslation = {
				'N': {
		    	  pattern: /[-]/, 
		    	  optional: true
				}
			};
			
			$.extend(options.translation, negativeTranslation);
			
			mask = 'N' + mask;
		}

		maskSettings.element.mask(mask, options);
		
		// Nos casos que se deve separar os milhares atriui-se o valor manualmente
		if (handleThousandsGroups) {
			maskSettings.element.val(newValue);
		}
	}
	
	function searchForKnownType(type) {
		// Caso nenhum tipo tenha sido passado retorna undefined
		if (!type) {
			return undefined;
		}

		var selectedKnownType = undefined;

		// Percorre todos os tipos conhecidos a procura do tipo passado
		// Caso nao encontre retornara undefined
		for (var i = 0; i < knownTypes.length; i++) {
			var knownType = knownTypes[i];

			// Verifica se e o tipo passado
			if (knownType.type == $.trim(type.toLowerCase())) {
				selectedKnownType = knownType;
				break;
			}
		}

		return selectedKnownType;
	}
	
	function repeat(character, numberOfTimes) {
		var newText = '';
		
		// Percorre todos 
		for (var j = 0; j < numberOfTimes; j++) {
			newText += character;
		}
		
		return newText;
	}
	
	function format($element) {
		var settings = parseJson($element.attr('alt'));
	}
	
	function clearThousandsGroups($element) {
		var currentValue = $element.val();
		
		// Caso haja algum valor informado retira a mascara de milhares
		if (currentValue) {
			var cleanValue = currentValue.replaceAll('.', '');
			
			$element.val(cleanValue);
		}
	}

	function adjustField($element) {
		var settings = parseJson($element.attr('alt'));
		var decimalPartSize = settings.decimalPartSize || 0;
		var applyThousandsGroups = settings.handleThousandsGroups;
		var value = $.trim($element.val());
		
		// Apenas formata se algum valor foi inserido
		if (value == undefined || value == '') {
			return;
		}
		
		value = value.replaceAll('.', '');
		var currentValueParts = value.split(',');
		var commaIndex = value.indexOf(',');
			
		// Verifica se alguma virgula foi digitada
		if (commaIndex > -1) {
			var addMinusSignal = currentValueParts[0].indexOf('-') > -1;
			
			// Verifica se apenas foi informado o sinal de menos
			if (currentValueParts[0] == '-') {
				currentValueParts[0] = '0';
			}
			
			value = commaIndex === 0 ? '0' + value : (parseInt(currentValueParts[0]).toString() + ',' + currentValueParts[1]);
			value += repeat('0', decimalPartSize - currentValueParts[1].length);			
			
			// Caso tenha perdido o sinal na conversão o adiciona novamente
			if (addMinusSignal && value.indexOf('-') == -1) {
				value = addMinusSignal ? ('-' + value) : value;
			}
		} else {
			value += ',';
			value += repeat('0', decimalPartSize);
		}
		
		// Caso haja a necessidade de adicionar os separadores de milhar
		if (applyThousandsGroups) {
			currentValueParts = value.split(',');
			var THOUSANDS_SEPARATOR = '.';
			var newValue = '';
			var patternsToIgnore = ['-', ',', '.'];
			var startIndex = currentValueParts[0].length - 1;
			
			// Verifica se há a necessidade de adicionar os delimitadores de milhar
			if (startIndex > 2) {			
				// Percorre toda a mascara atual afim de montar a nova com os separadores
				for (var i = startIndex; i > -1; i--) {
					var shouldFormat = true;
					shouldFormat &= patternsToIgnore.indexOf(currentValueParts[0][i]) === -1;
					shouldFormat &= i < startIndex;
					shouldFormat &= (startIndex - i) % 3 === 0;
					shouldFormat &= (startIndex - i) > 0;
					
					// Verifica se é um dos caracteres que devem ser ignorados
					if (shouldFormat) {
						newValue = currentValueParts[0][i] + THOUSANDS_SEPARATOR + newValue;
					} else {
						newValue = currentValueParts[0][i] + newValue;
					}
				}
			
				value = newValue + ',' + currentValueParts[1];
			}
		}

		$element.val(value);
	}
	
	function parseJson(stringValue) {
		try {
			return JSON.parse(stringValue.replace(/'/g, "\""));
		} catch (e) {
			return {};
		}
	}
	
	function init() {
		loadMasks();
		
		$('form').submit(checkFormBeforSubmit);
	}
	
	function loadMasksOnAjaxRequest(data) {
		// Teste
		if (data.status == 'begin') {
			/*var $div = $('<div id="divAjaxLoader" class="ui-widget-overlay ui-front" style="z-index: 99;"></div>');
			var $image = $('<img src="/npcd/images/square-loader.gif" style="position: absolute;left: 42%;top: 33%;margin: auto;width: 200px;z-index: 100;" />');
			$div.append($image);
			
			$('body').append($div);
			$div.show();*/
		}
		
		// caso obtenha sucesso na chamada carrega as mascaras
		if (data.status == 'success') {
			loadMasks();
		}
		
		// Teste
		if (data.status == 'complete') {
			/*$('#divAjaxLoader').remove();*/
		}
	}
	
	function checkFormBeforSubmit(event) {
		//console.log('Submit try');

		// Verifica se deve prevenir o evento
		if ($('.mask-error').length > 0) {
			// Percorre todos os itens
			$('.mask-error').first().prev(':text').focus();
			//console.log('Submit canceled');

			event.preventDefault();
			
			return false;
		}
	}

	$(document).ready(init);	
	
	jsf.ajax.addOnEvent(loadMasksOnAjaxRequest);
})();


/**
 * jquery.mask.js
 * @version: v1.13.4
 * @author: Igor Escobar
 *
 * Created by Igor Escobar on 2012-03-10. Please report any bug at http://blog.igorescobar.com
 *
 * Copyright (c) 2012 Igor Escobar http://blog.igorescobar.com
 *
 * The MIT License (http://www.opensource.org/licenses/mit-license.php)
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

/* jshint laxbreak: true */
/* global define, jQuery, Zepto */

'use strict';

// UMD (Universal Module Definition) patterns for JavaScript modules that work everywhere.
// https://github.com/umdjs/umd/blob/master/jqueryPluginCommonjs.js
(function (factory) {

    if (typeof define === 'function' && define.amd) {
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        module.exports = factory(require('jquery'));
    } else {
        factory(jQuery || Zepto);
    }

}(function ($) {

    var Mask = function (el, mask, options) {
        el = $(el);

        var jMask = this, oldValue = el.val(), regexMask;

        mask = typeof mask === 'function' ? mask(el.val(), undefined, el,  options) : mask;

        var p = {
            invalid: [],
            getCaret: function () {
                try {
                    var sel,
                        pos = 0,
                        ctrl = el.get(0),
                        dSel = document.selection,
                        cSelStart = ctrl.selectionStart;

                    // IE Support
                    if (dSel && navigator.appVersion.indexOf('MSIE 10') === -1) {
                        sel = dSel.createRange();
                        sel.moveStart('character', el.is('input') ? -el.val().length : -el.text().length);
                        pos = sel.text.length;
                    }
                    // Firefox support
                    else if (cSelStart || cSelStart === '0') {
                        pos = cSelStart;
                    }

                    return pos;
                } catch (e) {}
            },
            setCaret: function(pos) {
                try {
                    if (el.is(':focus')) {
                        var range, ctrl = el.get(0);

                        if (ctrl.setSelectionRange) {
                            ctrl.setSelectionRange(pos,pos);
                        } else if (ctrl.createTextRange) {
                            range = ctrl.createTextRange();
                            range.collapse(true);
                            range.moveEnd('character', pos);
                            range.moveStart('character', pos);
                            range.select();
                        }
                    }
                } catch (e) {}
            },
            events: function() {
                el
                .on('input.mask keyup.mask', p.behaviour)
                .on('paste.mask drop.mask', function() {
                    setTimeout(function() {
                        el.keydown().keyup();
                    }, 100);
                })
                .on('change.mask', function(){
                    el.data('changed', true);
                })
                .on('blur.mask', function(){
                    if (oldValue !== el.val() && !el.data('changed')) {
                        el.triggerHandler('change');
                    }
                    el.data('changed', false);
                })
                // it's very important that this callback remains in this position
                // otherwhise oldValue it's going to work buggy
                .on('blur.mask', function() {
                    oldValue = el.val();
                })
                // select all text on focus
                .on('focus.mask', function (e) {
                    if (options.selectOnFocus === true) {
                        $(e.target).select();
                    }
                })
                // clear the value if it not complete the mask
                .on('focusout.mask', function() {
                    if (options.clearIfNotMatch && !regexMask.test(p.val())) {
                       p.val('');
                   }
                });
            },
            getRegexMask: function() {
                var maskChunks = [], translation, pattern, optional, recursive, oRecursive, r;

                for (var i = 0; i < mask.length; i++) {
                    translation = jMask.translation[mask.charAt(i)];

                    if (translation) {

                        pattern = translation.pattern.toString().replace(/.{1}$|^.{1}/g, '');
                        optional = translation.optional;
                        recursive = translation.recursive;

                        if (recursive) {
                            maskChunks.push(mask.charAt(i));
                            oRecursive = {digit: mask.charAt(i), pattern: pattern};
                        } else {
                            maskChunks.push(!optional && !recursive ? pattern : (pattern + '?'));
                        }

                    } else {
                        maskChunks.push(mask.charAt(i).replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'));
                    }
                }

                r = maskChunks.join('');

                if (oRecursive) {
                    r = r.replace(new RegExp('(' + oRecursive.digit + '(.*' + oRecursive.digit + ')?)'), '($1)?')
                         .replace(new RegExp(oRecursive.digit, 'g'), oRecursive.pattern);
                }

                return new RegExp(r);
            },
            destroyEvents: function() {
                el.off(['input', 'keydown', 'keyup', 'paste', 'drop', 'blur', 'focusout', ''].join('.mask '));
            },
            val: function(v) {
                var isInput = el.is('input'),
                    method = isInput ? 'val' : 'text',
                    r;

                if (arguments.length > 0) {
                    if (el[method]() !== v) {
                        el[method](v);
                    }
                    r = el;
                } else {
                    r = el[method]();
                }

                return r;
            },
            getMCharsBeforeCount: function(index, onCleanVal) {
                for (var count = 0, i = 0, maskL = mask.length; i < maskL && i < index; i++) {
                    if (!jMask.translation[mask.charAt(i)]) {
                        index = onCleanVal ? index + 1 : index;
                        count++;
                    }
                }
                return count;
            },
            caretPos: function (originalCaretPos, oldLength, newLength, maskDif) {
                var translation = jMask.translation[mask.charAt(Math.min(originalCaretPos - 1, mask.length - 1))];

                return !translation ? p.caretPos(originalCaretPos + 1, oldLength, newLength, maskDif)
                                    : Math.min(originalCaretPos + newLength - oldLength - maskDif, newLength);
            },
            behaviour: function(e) {
                e = e || window.event;
                p.invalid = [];
                var keyCode = e.keyCode || e.which;
                if ($.inArray(keyCode, jMask.byPassKeys) === -1) {

                    var caretPos = p.getCaret(),
                        currVal = p.val(),
                        currValL = currVal.length,
                        changeCaret = caretPos < currValL,
                        newVal = p.getMasked(),
                        newValL = newVal.length,
                        maskDif = p.getMCharsBeforeCount(newValL - 1) - p.getMCharsBeforeCount(currValL - 1);

                    p.val(newVal);

                    // change caret but avoid CTRL+A
                    if (changeCaret && !(keyCode === 65 && e.ctrlKey)) {
                        // Avoid adjusting caret on backspace or delete
                        if (!(keyCode === 8 || keyCode === 46)) {
                            caretPos = p.caretPos(caretPos, currValL, newValL, maskDif);
                        }
                        p.setCaret(caretPos);
                    }

                    return p.callbacks(e);
                }
            },
            getMasked: function(skipMaskChars) {
                var buf = [],
                    value = p.val(),
                    m = 0, maskLen = mask.length,
                    v = 0, valLen = value.length,
                    offset = 1, addMethod = 'push',
                    resetPos = -1,
                    lastMaskChar,
                    check;

                if (valLen > maskLen && mask.indexOf('#') == -1) {
                    return value.substring(0, maskLen);
                }

                if (options.reverse) {
                    addMethod = 'unshift';
                    offset = -1;
                    lastMaskChar = 0;
                    m = maskLen - 1;
                    v = valLen - 1;
                    check = function () {
                        return m > -1 && v > -1;
                    };
                } else {
                    lastMaskChar = maskLen - 1;
                    check = function () {
                        return m < maskLen && v < valLen;
                    };
                }

                while (check()) {
                    var maskDigit = mask.charAt(m),
                        valDigit = value.charAt(v),
                        translation = jMask.translation[maskDigit];

                    if (translation) {
                        if (valDigit.match(translation.pattern)) {
                            buf[addMethod](valDigit);
                             if (translation.recursive) {
                                if (resetPos === -1) {
                                    resetPos = m;
                                } else if (m === lastMaskChar) {
                                    m = resetPos - offset;
                                }

                                if (lastMaskChar === resetPos) {
                                    m -= offset;
                                }
                            }
                            m += offset;
                        } else if (translation.optional) {
                            m += offset;
                            v -= offset;
                        } else if (translation.fallback) {
                            buf[addMethod](translation.fallback);
                            m += offset;
                            v -= offset;
                        } else {
                          p.invalid.push({p: v, v: valDigit, e: translation.pattern});
                        }
                        v += offset;
                    } else {
                        if (!skipMaskChars) {
                            buf[addMethod](maskDigit);
                        }

                        if (valDigit === maskDigit) {
                            v += offset;
                        }

                        m += offset;
                    }
                }

                var lastMaskCharDigit = mask.charAt(lastMaskChar);
                if (maskLen === valLen + 1 && !jMask.translation[lastMaskCharDigit]) {
                    buf.push(lastMaskCharDigit);
                }

                return buf.join('');
            },
            callbacks: function (e) {
                var val = p.val(),
                    changed = val !== oldValue,
                    defaultArgs = [val, e, el, options],
                    callback = function(name, criteria, args) {
                        if (typeof options[name] === 'function' && criteria) {
                            options[name].apply(this, args);
                        }
                    };

                callback('onChange', changed === true, defaultArgs);
                callback('onKeyPress', changed === true, defaultArgs);
                callback('onComplete', val.length === mask.length, defaultArgs);
                callback('onInvalid', p.invalid.length > 0, [val, e, el, p.invalid, options]);
            }
        };


        // public methods
        jMask.mask = mask;
        jMask.options = options;
        jMask.remove = function() {
            var caret = p.getCaret();
            p.destroyEvents();
            p.val(jMask.getCleanVal());
            p.setCaret(caret - p.getMCharsBeforeCount(caret));
            return el;
        };

        // get value without mask
        jMask.getCleanVal = function() {
           return p.getMasked(true);
        };

       jMask.init = function(onlyMask) {
            onlyMask = onlyMask || false;
            options = options || {};

            jMask.byPassKeys = $.jMaskGlobals.byPassKeys;
            jMask.translation = $.jMaskGlobals.translation;

            jMask.translation = $.extend({}, jMask.translation, options.translation);
            jMask = $.extend(true, {}, jMask, options);

            regexMask = p.getRegexMask();

            if (onlyMask === false) {

                if (options.placeholder) {
                    el.attr('placeholder' , options.placeholder);
                }

                // this is necessary, otherwise if the user submit the form
                // and then press the "back" button, the autocomplete will erase
                // the data. Works fine on IE9+, FF, Opera, Safari.
                if ($('input').length && 'oninput' in $('input')[0] === false && el.attr('autocomplete') === 'on') {
                  el.attr('autocomplete', 'off');
                }

                p.destroyEvents();
                p.events();

                var caret = p.getCaret();
                p.val(p.getMasked());
                p.setCaret(caret + p.getMCharsBeforeCount(caret, true));

            } else {
                p.events();
                p.val(p.getMasked());
            }
        };

        jMask.init(!el.is('input'));
    };

    $.maskWatchers = {};
    var HTMLAttributes = function () {
            var input = $(this),
                options = {},
                prefix = 'data-mask-',
                mask = input.attr('data-mask');

            if (input.attr(prefix + 'reverse')) {
                options.reverse = true;
            }

            if (input.attr(prefix + 'clearifnotmatch')) {
                options.clearIfNotMatch = true;
            }

            if (input.attr(prefix + 'selectonfocus') === 'true') {
               options.selectOnFocus = true;
            }

            if (notSameMaskObject(input, mask, options)) {
                return input.data('mask', new Mask(this, mask, options));
            }
        },
        notSameMaskObject = function(field, mask, options) {
            options = options || {};
            var maskObject = $(field).data('mask'),
                stringify = JSON.stringify,
                value = $(field).val() || $(field).text();
            try {
                if (typeof mask === 'function') {
                    mask = mask(value);
                }
                return typeof maskObject !== 'object' || stringify(maskObject.options) !== stringify(options) || maskObject.mask !== mask;
            } catch (e) {}
        };


    $.fn.mask = function(mask, options) {
        options = options || {};
        var selector = this.selector,
            globals = $.jMaskGlobals,
            interval = $.jMaskGlobals.watchInterval,
            maskFunction = function() {
                if (notSameMaskObject(this, mask, options)) {
                    return $(this).data('mask', new Mask(this, mask, options));
                }
            };

        $(this).each(maskFunction);

        if (selector && selector !== '' && globals.watchInputs) {
            clearInterval($.maskWatchers[selector]);
            $.maskWatchers[selector] = setInterval(function(){
                $(document).find(selector).each(maskFunction);
            }, interval);
        }
        return this;
    };

    $.fn.unmask = function() {
        clearInterval($.maskWatchers[this.selector]);
        delete $.maskWatchers[this.selector];
        return this.each(function() {
            var dataMask = $(this).data('mask');
            if (dataMask) {
                dataMask.remove().removeData('mask');
            }
        });
    };

    $.fn.cleanVal = function() {
        return this.data('mask').getCleanVal();
    };

    $.applyDataMask = function(selector) {
        selector = selector || $.jMaskGlobals.maskElements;
        var $selector = (selector instanceof $) ? selector : $(selector);
        $selector.filter($.jMaskGlobals.dataMaskAttr).each(HTMLAttributes);
    };

    var globals = {
        maskElements: 'input,td,span,div',
        dataMaskAttr: '*[data-mask]',
        dataMask: true,
        watchInterval: 300,
        watchInputs: true,
        watchDataMask: false,
        byPassKeys: [9, 16, 17, 18, 36, 37, 38, 39, 40, 91],
        translation: {
            '0': {pattern: /\d/},
            '9': {pattern: /\d/, optional: true},
            '#': {pattern: /\d/, recursive: true},
            'A': {pattern: /[a-zA-Z0-9]/},
            'S': {pattern: /[a-zA-Z]/}
        }
    };

    $.jMaskGlobals = $.jMaskGlobals || {};
    globals = $.jMaskGlobals = $.extend(true, {}, globals, $.jMaskGlobals);

    // looking for inputs with data-mask attribute
    if (globals.dataMask) { $.applyDataMask(); }

    setInterval(function(){
        if ($.jMaskGlobals.watchDataMask) { $.applyDataMask(); }
    }, globals.watchInterval);
}));