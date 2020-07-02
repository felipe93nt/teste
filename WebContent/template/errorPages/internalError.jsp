<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://bradesco.com.br/components-html" prefix="awb-h"%>
<%@ taglib uri="http://bradesco.com.br/components-core" prefix="awb-f"%>
<%@ taglib prefix="awb-br"  uri="http://bradesco.com.br/components-br"%>
<%@ taglib uri="http://bradesco.com.br/presentation_core" prefix="presCore"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;CHARSET=iso-8859-1" />
	<title>Página de Erro</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/css/tiles.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/css/components.css"/>">
	<link rel="stylesheet" type="text/css" media="print" href="<c:url value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/css/print.css"/>">
</head>
<body >
<awb-f:view>
		<presCore:addResource resource="js/jquery.js" />
		<presCore:addResource resource="js/brquery.js" />
		<script type="text/javascript">
		window.onload = getClock();

		function getClock() {
			var nowadays = new Date();
		    var currentTime = nowadays.getHours();
		    var currentMinute = nowadays.getMinutes();

		    if(currentMinute < 10){
		    	currentMinute = "0" + currentMinute;
		    }

		    var printableHour = currentTime + ":" + currentMinute;
			if ( document.getElementById('clockOutputText') != null) {
		   	 document.getElementById('clockOutputText').innerHTML = printableHour;
			}

			setTimeout("getClock()",1000);
		}

		</script>
		<awb-h:panelGrid cellpadding="0" cellspacing="0" border="0"
			columns="4"
			columnClasses="tsubHeaderColumn1,tsubHeaderColumn2,tsubHeaderColumn3,tsubHeaderColumn4"
			styleClass="theaderPanelGrid">
			<awb-h:panelGroup>
				<awb-h:panelGrid cellpadding="0" cellspacing="0" border="0"
					columns="1">
					<awb-h:panelGroup>
 						<img src="${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/images/logo_marca.png" class="img_logo" />
 					</awb-h:panelGroup>
				</awb-h:panelGrid>
			</awb-h:panelGroup>
			<awb-h:panelGroup>

			</awb-h:panelGroup>
			<awb-h:panelGroup>
				<awb-h:panelGrid cellpadding="2" cellspacing="0" border="0"
					columns="3" id="panelClock">
					<awb-h:outputLabel styleClass="msg_header3"
						value="#{sessionBean.dataAtual}" title="#{sessionBean.dataAtual}" />
					<awb-h:graphicImage styleClass="img_iconeTempo"
						url="#{request.contextPath}/faces/javax.faces.resource/template/root/images/icone_tempo.gif" />
					<awb-h:outputLabel styleClass="msg_header3"
						id="clockOutputText" value="" />
				</awb-h:panelGrid>

				<awb-h:panelGrid cellpadding="2" cellspacing="0" border="0"
					columns="3">
 					<img class="bullet" src="${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/images/bullet.jpg"
 						style="vertical-align:middle;" />
					<awb-h:outputLabel styleClass="msg_header3"
						value="#{sessionBean.saudacao}" title="#{sessionBean.saudacao}" />
					<awb-h:outputLabel styleClass="msg_header4"
						value="#{sessionBean.username}" title="#{sessionBean.username}" />
				</awb-h:panelGrid>
			</awb-h:panelGroup>


			<awb-h:form>
				<awb-h:panelGroup>
					<awb-h:panelGrid cellpadding="0" cellspacing="0" border="0"
						columns="1" >

						<awb-h:panelGrid cellpadding="0" cellspacing="0" border="0" columns="1"
							>
								<awb-h:commandButton action="logout" id="btn_sair" title="sair" value="sair"
								onclick='if (!confirm("Será realizado o logout da aplicação")) return false;'>
								<awb-f:actionListener type="br.com.bradesco.web.aq.view.actionlisteners.LogoutController"  />
								</awb-h:commandButton>
						</awb-h:panelGrid>
						<awb-h:panelGrid cellpadding="0" cellspacing="0" border="0"
							columns="1"  styleClass="heigh_link_ajuda">
							<awb-h:outputLink styleClass="link_ajuda"
								value="#{helpBean.helpAction}" target="#{helpBean.helpAction}"
								id="ajudaLink">
								<awb-h:outputLabel value="Ajuda" />
							</awb-h:outputLink>

						</awb-h:panelGrid>
					</awb-h:panelGrid>
				</awb-h:panelGroup>
			</awb-h:form>

			<awb-h:panelGroup >
			</awb-h:panelGroup>

			<awb-h:panelGroup>
			</awb-h:panelGroup>

			<awb-h:panelGroup>
			</awb-h:panelGroup>

			<awb-h:panelGroup>
			</awb-h:panelGroup>
		</awb-h:panelGrid>
		<table border="0" cellspacing="6" width="100%">
		<thead><tr><th class="tmainMenuPanel" scope="colgroup" colspan="1"></th></tr></thead>
				<tbody>
				<tr><td class="HtmlOutputTextTitleColorBradesco"><h4> EXCE&#199;&#195;O DA APLICA&#199;&#195;O</h4></td></tr>
				<tr><td class="HtmlOutputTextBradesco"> Detectada Throwable Exception: ${pageContext.errorData.throwable}</td></tr>
				<tr><td class="HtmlOutputTextBradesco"> <b>C&#243;digo do erro: </b>${pageContext.errorData.statusCode} </td></tr>
				<tr><td class="HtmlOutputTextBradesco"> <b>Detalhe do Erro: </b>${pageContext.errorData.throwable.cause}</td></tr>
				<tr><td class="HtmlOutputTextBradesco"> Verifique o arquivo de log para visualizar o registro do erro</td></tr>
				<tr><td class="HtmlOutputTextBradesco"><a href="${pageContext.request.contextPath}/content/index.xhtml">Voltar a página principal</a></td></tr>

				</tbody>
			</table>
		<div style="position:fixed; bottom:0px; width: 100%;">
		<awb-h:panelGrid width="100%" columns="3" cellpadding="0" cellspacing="0"
			 styleClass="tfooterpanelGrid"
			columnClasses="tfooterColumnLeft,tfooterColumnAuto,tfooterColumnRight">
			<awb-h:panelGroup>
				<img src="${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/images/canto_rodape.gif" />
			</awb-h:panelGroup>
			<img src="${pageContext.request.contextPath}/faces/javax.faces.resource/template/root/images/pixel_invisivel.gif" />
			<awb-h:panelGroup>
				<awb-h:outputLabel value="#{msgs[label_footer]}" styleClass="footerText" />
				<awb-br:versionInfo />
			</awb-h:panelGroup>
		</awb-h:panelGrid>
		</div>
</awb-f:view>
</body>
</html>