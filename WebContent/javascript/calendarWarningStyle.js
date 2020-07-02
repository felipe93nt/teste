
//renomeia o jQuery para evitar problemas de compatibilidade
var $jB = jQuery.noConflict();

function calendarValidationUtils (parameterMap) {
	
	this.bundle = new Function ('return '+ parameterMap ['bundleFunction']+'();')();
	this.bundlePrefix = parameterMap ['bundlePrefix'];
	
	this.replaceAscii = function (text) {
		var ini = text.indexOf('&#');
		var fin = text.indexOf(';', ini);
		while (ini >= 0 && fin > ini) {
			var ascii = text.substring(ini + 2, fin);
			if (ascii > 0) {
				var str = String.fromCharCode(ascii);
				text = text.replace('&#' + ascii + ';', str);
			}
			ini = text.indexOf('&#', ini + 1);
			fin = text.indexOf(';', ini);
		}
		return text;
	};
	
	this.toogleFieldErr = function (inputID, enable) {
		if (enable) 
			$jB("#" + inputID).closest(".form_fieldset").addClass("form_erro");
		 else 
			$jB("#" + inputID).closest(".form_fieldset").removeClass("form_erro");
	};
		
	this.toogleInputErr = function (inputID, enable) {
		if (enable) 
			$jB("#" + inputID).addClass("erro_input");
		else
			$jB("#" + inputID).removeClass("erro_input");
				
	};
	
	this.handleInputErr = function (parameterMap, type) {
		if (parameterMap[type]=="INVALID") 
			this.toogleInputErr (parameterMap[type+"ID"],true);
		else
			this.toogleInputErr (parameterMap[type+"ID"],false);
	};
	
	this.handleErrorMessage = function (parameterMap)
	{
		var msgID = "";
		if (parameterMap['day']=="INVALID")
			msgID+="day_";
		if (parameterMap['month']=="INVALID")
			msgID+="month_";
		if (parameterMap['year']=="INVALID")
			msgID+="year_";
		if (parameterMap['period']=="BIGGER")
			msgID+="bigger_";
		if (parameterMap['period']=="SMALLER")
			msgID+="smaller_";
		var message = this.getString ("c_"+msgID+'error');
		if (message!=null && msgID!="")
			$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg').text(message);
		else
			$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg').text("");
			
	};
	
	this.handleTitleMessage = function (parameterMap)
	{
		
		var dayTitle = parameterMap['dayTitle'];
		if (dayTitle==null||dayTitle=='null')
			dayTitle = "";
		var monthTitle = parameterMap['monthTitle'];
		if (monthTitle==null||monthTitle=='null')
			monthTitle = "";
		var yearTitle = parameterMap['yearTitle'];
		if (yearTitle==null||yearTitle=='null')
			yearTitle = "";
		$jB('#'+parameterMap['monthID']).attr('title',monthTitle);
		$jB('#'+parameterMap['dayID']).attr('title',dayTitle);
		$jB('#'+parameterMap['yearID']).attr('title',yearTitle);
		
		
		var msgID = "";
		if (parameterMap['day']=="INVALID")
			msgID+="day_";
		if (parameterMap['month']=="INVALID")
			msgID+="month_";
		if (parameterMap['year']=="INVALID")
			msgID+="year_";
		var message = this.getString ("c_"+msgID+'error_title');
		if (message!=null && message!=undefined&& msgID!="") {
			if (parameterMap['day']=="INVALID")
				$jB('#'+parameterMap['dayID']).attr('title',message);
			if (parameterMap['month']=="INVALID")
				$jB('#'+parameterMap['monthID']).attr('title',message);
			if (parameterMap['year']=="INVALID")
				$jB('#'+parameterMap['yearID']).attr('title',message);
		}
			
	};
	
	this.getString = function (key) {
		var value = this.bundle[this.bundlePrefix+key];
		if (value==null||value==undefined)
			value = this.bundle[key];
		if (value==null||value==undefined)
			return null;
		return this.replaceAscii(value);
	};
	
		
	this.validate = function (parameterMap)
	{
		this.handleInputErr (parameterMap,'day');
		this.handleInputErr (parameterMap,'month');
		this.handleInputErr (parameterMap,'year');
		this.handleErrorMessage (parameterMap);
		if (!parameterMap['overall']) {
			this.toogleFieldErr (parameterMap['dayID'],true);			
			this.handleErrorMessage (parameterMap);		
		} else if (parameterMap['period'] == 'VALID') {
			this.toogleFieldErr (parameterMap['dayID'],false);		
			this.handleErrorMessage (parameterMap);			
		}
		else {
			this.toogleFieldErr (parameterMap['dayID'],false);		
			this.handleErrorMessage (parameterMap);
		}							
	};
	
	this.savePeriodValidationState = function (parameterMap) {
		
		var fieldId = parameterMap['dayID']; 
		var calendarID = this.getCalendarPeriodID (fieldId);
		var status = parameterMap['overall'];
		var periodStatus = parameterMap['period'];
		//Se for o calendário da data inicial, validá-lo ou invalidá-lo
		if (fieldId.indexOf("begin") != -1) {
			if (status) {
				$jB.data(document.body, calendarID+'overallBegin', 'VALID');
			} else {
				$jB.data(document.body, calendarID+'overallBegin', 'INVALID');
			}
			$jB.data(document.body, calendarID+'periodBegin', periodStatus);
		}
		//Se for o calendário da data final, validá-lo ou invalidá-lo
		if (fieldId.indexOf("end") != -1) {
			if (status) {
				$jB.data(document.body, calendarID+'overallEnd', 'VALID');
			} else {
				$jB.data(document.body, calendarID+'overallEnd', 'INVALID');
			}
			$jB.data(document.body, calendarID+'periodEnd', periodStatus);
		}
	};
	
	this.readPeriodValidationState = function (calendarID,stateID){		
		return $jB.data(document.body, calendarID+stateID);
	};
	
	this.getCalendarPeriodID = function (fieldId) {
		if (fieldId.indexOf("begin") != -1) 
			return fieldId.substring(0, fieldId.indexOf("_begin"));
		if (fieldId.indexOf("end") != -1) 
			return fieldId.substring(0, fieldId.indexOf("_end"));
	};
	
	this.getCalendarPeriodType = function (fieldId) {
		if (fieldId.indexOf("begin") != -1) 
			return "begin";
		if (fieldId.indexOf("end") != -1) 
			return "end";
	};
	
	this.handlePeriodErrorMessage = function (parameterMap)
	{
		var msgID = "";
		var cType = this.getCalendarPeriodType (parameterMap['dayID']);
		if (parameterMap['day']=="INVALID")
			msgID+="day_";
		if (parameterMap['month']=="INVALID")
			msgID+="month_";
		if (parameterMap['year']=="INVALID")
			msgID+="year_";
		var pType = cType == 'end' ? 'End' : 'Begin';
		if (parameterMap['period' + pType]=="BIGGER")
			msgID+="bigger_";
		if (parameterMap['period' + pType]=="SMALLER")
			msgID+="smaller_";
		var message = this.getString ("c_"+msgID+'error');
		if (!parameterMap['overall'] || parameterMap['overallBegin'] == 'INVALID' || parameterMap['overallEnd'] == 'INVALID' || parameterMap['periodBegin'] == 'BIGGER' || parameterMap['periodBegin'] == 'SMALLER' || parameterMap['periodEnd'] == 'SMALLER' || parameterMap['periodEnd'] == 'BIGGER') {
			if (cType=='begin') {
				if(!parameterMap['overall'] || parameterMap['period' + pType] == 'BIGGER' || parameterMap['period' + pType] == 'SMALLER'){
					var prefix = this.getString ("c_start_period_date");
					$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg1').html('<b>' + prefix + '</b>' + ': ' + message);
					
				}
				else
					$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg1').html('');
			}
			if (cType=='end') {
				if (!parameterMap['overall'] || parameterMap['period' + pType] == 'BIGGER' || parameterMap['period' + pType] == 'SMALLER'){
					var prefix = this.getString ("c_end_period_date");
					$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg2').html('<b>' + prefix + '</b>' + ': ' + message);
				}
				else
					$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg2').html('');
			}
		} else if (parameterMap['periodBegin'] != 'BIGGER' && parameterMap['periodBegin'] != 'SMALLER' && parameterMap['periodEnd'] != 'BIGGER' && parameterMap['periodEnd'] != 'SMALLER') {
			$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg1').html('');				
			$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg2').html('');
			$jB('#' + parameterMap['dayID']).closest('.form_fieldset').children('.erro_msg3').html('');
		}
	};
	
	
	
};




function errorStyleChanger (parameterMap)
{
	this.validateCalendar = function (parameterMap)
	{
		var utils = new calendarValidationUtils (parameterMap);
		utils.handleInputErr (parameterMap,'day');
		utils.handleInputErr (parameterMap,'month');
		utils.handleInputErr (parameterMap,'year');
		utils.handleTitleMessage (parameterMap);
		utils.handleErrorMessage (parameterMap);
		if (!parameterMap['overall']) {
			utils.toogleFieldErr (parameterMap['dayID'],true);
		}
		else if (parameterMap['period'] == 'BIGGER' || parameterMap['period'] == 'SMALLER') {
			utils.toogleFieldErr (parameterMap['dayID'],true);
		} else {
			utils.toogleFieldErr (parameterMap['dayID'],false);		
		};
	};
	
	this.validateCalendarPeriod = function (parameterMap)
	{
		var utils = new calendarValidationUtils (parameterMap);
		var calendarID = utils.getCalendarPeriodID (parameterMap['dayID']);
		var calendarType = utils.getCalendarPeriodType (parameterMap['dayID']);
		utils.savePeriodValidationState (parameterMap );
		
		var overallBegin = utils.readPeriodValidationState(calendarID,'overallBegin');
		var overallEnd = utils.readPeriodValidationState(calendarID,'overallEnd');
		var periodBegin = utils.readPeriodValidationState(calendarID,'periodBegin');
		var periodEnd = utils.readPeriodValidationState(calendarID,'periodEnd');
		parameterMap['overallBegin']=overallBegin;
		parameterMap['overallEnd']=overallEnd;
		parameterMap['periodBegin']=periodBegin;
		parameterMap['periodEnd']=periodEnd;
		
		
		utils.handleInputErr (parameterMap,'day');
		utils.handleInputErr (parameterMap,'month');
		utils.handleInputErr (parameterMap,'year');
		utils.handleTitleMessage (parameterMap);
		utils.handlePeriodErrorMessage (parameterMap);
		if (!parameterMap['overall'] || parameterMap['overallBegin'] == 'INVALID' || parameterMap['overallEnd'] == 'INVALID') {
			utils.toogleFieldErr (parameterMap['dayID'],true);			
			utils.handleErrorMessage (parameterMap);
		}
		else if (parameterMap['periodBegin'] == 'BIGGER' || parameterMap['periodEnd'] == 'BIGGER' || parameterMap['periodBegin'] == 'SMALLER' || parameterMap['periodEnd'] == 'SMALLER') {
			utils.toogleFieldErr (parameterMap['dayID'],true);
		} else {
			utils.toogleFieldErr (parameterMap['dayID'],false);		
			utils.handleErrorMessage (parameterMap);			
		};
		
		
	};
	
	var dayID = (parameterMap['dayObject']).id.replace(":", "\\:");
	var monthID = (parameterMap['monthObject']).id.replace(":", "\\:");
	var yearID = (parameterMap['yearObject']).id.replace(":", "\\:");
	parameterMap['dayID'] = dayID;
	parameterMap['monthID'] = monthID;
	parameterMap['yearID'] = yearID;

	if (parameterMap['type']!="calendarPeriod")
		this.validateCalendar (parameterMap);
	else
		this.validateCalendarPeriod (parameterMap);
};
	



/* periodStyleValidation(status)
 * Valida e estiliza o período
 * Parâmetros: statusMap: Mapa de estados da validação, enviado pela função de callback.
 * 					Possui as seguintes chaves:
 * - period: Resultado da validação de período.
 * - beginDayID: Id do campo de dia do início do período.
 * - beginMonthID: Id do campo de mês do início do período.
 * - beginYearID: Id do campo de ano do início do período.
 * - endDayID: Id do campo de dia do fim do período.
 * - endMonthID: Id do campo de mês do fim do período.
 * - endYearID: Id do campo de ano do fim do período. */
function periodStyleValidation(statusMap) {
	var bundle = new Function ('return '+ statusMap ['bundleFunction']+'();')();
	
	var invalidPeriod = "Data inicial maior que a final";
	if (bundle!=null&&bundle!=undefined)
		invalidPeriod = bundle['c_invalid_period'];
	var status = statusMap['period'];
	var beginDayId = statusMap['beginDayID'];
	beginDayId = beginDayId.replace(":", "\\:");
	
	//Se for o calendário da data inicial, validá-lo ou invalidá-lo
	var beginLimit = $jB.data(document.body, statusMap['calendarID']+'periodBegin');
	var endLimit = $jB.data(document.body, statusMap['calendarID']+'periodEnd');
	if (status) {
		$jB('#' + beginDayId).closest('.form_fieldset').children('.erro_msg3').html('');
		$jB('#' + beginDayId).closest(".form_fieldset").removeClass("form_erro");
	}
	else {
		$jB('#' + beginDayId).closest('.form_fieldset').children('.erro_msg3').html('<b>' + invalidPeriod + '.</b>');
		$jB('#' + beginDayId).closest(".form_fieldset").addClass("form_erro");
	}
}