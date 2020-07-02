//renomeia o jQuery para evitar problemas de compatibilidade
var $jB = jQuery.noConflict();

function aguarde(data){
		 var status = data.status;
		 var source = data.source;

		    switch (status) {
		        case "begin":
		        	$jB("#aguarde").dialog({
		        		height: 10,
		        		width: 10,
		        		modal: true,
		        		resizable: false,
		        		closeable: false,
		        		dialogClass: "aguarde"
		        	});
		            break;
		        case "complete":
		        	$jB("#aguarde").dialog("close");
		            break;
		        case "success":
		            break;
		    }
	}

var x = setInterval(function() {

var now = new Date().getTime();

var distance = countDownDate - now;

var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
var seconds = Math.floor((distance % (1000 * 60)) / 1000);

document.getElementById("session_countdown").innerHTML = 'Sessão expira em: ' + minutes + "m " + seconds + "s ";

if (distance < 0) {
 clearInterval(x);
 document.getElementById("session_countdown").style.color = 'red';
 document.getElementById("session_countdown").innerHTML = "SESSÃO EXPIRADA";
}
}, 1000);
