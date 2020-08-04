<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" encoding="UTF-8" indent="yes"/>
		
	<xsl:template match="*">
		<xsl:copy>			
			<xsl:call-template name="head" />
			<xsl:call-template name="body" />			
		</xsl:copy>
		<xsl:element name="{local-name()}">
				<xsl:for-each select="@*">
					<!-- remove attribute prefix (if any) -->
					<xsl:attribute name="{local-name()}">
						<xsl:value-of select="." />
					</xsl:attribute>
				</xsl:for-each>
			</xsl:element>
    </xsl:template>
	
	<xsl:template name="head" match="head">
		<xsl:copy>
	
	<xsl:text disable-output-escaping="yes"> <![CDATA[ <style type="text/css"> 

body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td,a {margin:0;padding:0;}

body {background-color:#E4E4E4;}
body, select {font:11px Tahoma, Arial, Sans-Serif;color:#333;}

ul {list-style:none;}
h1,h2,h3,h4,h5,h6 {font-size:100%;font-weight:normal;}
q:before,q:after {content:'';}

hr{width:100%;height:1px;border-width:1px 0 0;border-top:1px solid #E5E5E5;clear:both;margin:0;*margin:-7px 0;display:block;}

a {text-decoration:none;color:#666;}
a:hover {color:#CC092F;text-decoration:underline;}
.after {zoom:1;}
.after:after {content:".";display:block;clear:both;visibility:hidden;height:0;overflow:hidden;}
.none {display:none;}

.fl {float:left !important;}

.clr {clear:both !important;zoom:1;}
table sup {font-size:78% !important;}

.bb0 {border-bottom:0 !important}

.boxEsconder.boxDesabilitar h2 {filter:alpha(opacity=50);opacity:0.5;width:100%;}
.boxEsconder.boxDesabilitar > ul > li {filter:alpha(opacity=50);opacity:0.5;width:100%;}

h2.ttlTp2{font-weight:700;padding:5px 0;}

p a {text-decoration:underline;}

hr.hr02{border-top-color:#AFAFAF;}

.after{zoom:1;}
#topo:after,
.boxDados:after,
.boxForm:after,
.listaPromocoes li:after,
.boxExp:after{content:".";display:block;clear:both;visibility:hidden;height:0;overflow:hidden;}
.mr10{margin-right:10px}

#topo #listaTempo {clear:both;}
#topo #listaTempo li {float:left;margin:14px 4px 0 40px;height:30px;}
#topo #listaTempo li.tempo {cursor:pointer;padding-left:77px;line-height:1;}
#topo #listaTempo li.tempo span,
#topo #listaTempo li.tempo2 span,
#topo #listaTempo li.tempo3 span,
#topo #listaTempo li.tempo4 span,
#topo #listaTempo li.tempo5 span {background:url(../../imagens/geral/ico_relogio.gif) 0 0 no-repeat;font-weight:bold;margin-left:4px;padding-left:16px;display:inline-block;line-height:15px;}
#topo #listaTempo li.tempo2 span {background-position:-63px 0;}
#topo #listaTempo li.tempo3 span {background-position:-125px 0;}
#topo #listaTempo li.tempo4 span {background-position:-187px 0;}
#topo #listaTempo li.tempo5 span {background-position:-249px 0;}
#topo #listaMenuPrincipal {clear:both;width:100%;height:64px;}

#topo #formBuscar {float:right;margin-top:10px;line-height:1;}
#topo #formBuscar * {float:left;}
#topo #formBuscar label {margin-right:5px;line-height:22px;}
#topo #formBuscar div {background:url(../../imagens/geral/btn_buscar.gif) top left no-repeat;}
#topo #formBuscar input.frmText {border:0;background:transparent;width:220px;height:20px;padding:5px 0 0 7px;font:100%/130% Tahoma, Arial, Sans-Serif;color:#333;}

#topo #listaMenuSuperior {float:right;}
#topo #listaMenuSuperior li a {color:#FFF;line-height:25px;}
#topo #listaMenuSuperior li.primeiro {padding:0 20px;}
#topo #listaMenuSuperior li.sair a {text-indent:-9999px;display:block;height:24px;}

.txtNumRepTrans div {width:300px;}

.chkLst li{display:block;float:left;padding:3px 15px 3px 0;}
.chkLst li input{margin-right:3px;vertical-align:middle;}
.chkLst li label{vertical-align:middle;}

ul.listaTp4 {padding:12px 0;width:215px;}
ul.listaTp4 li {background:url(../../imagens/home/ico_atendimento.gif) 0px 0px no-repeat;float:left;height:34px}
ul.listaTp4 li a {padding:4px 0 0}
ul.listaTp4 li.tel {width:90px;border-right:solid 1px #E5E5E5;}
ul.listaTp4 li.tel a {display:block;padding-left:33px;padding-right:15px;}
ul.listaTp4 li.gerente {background-position:-3px -45px;margin-left:14px;width:96px;}
ul.listaTp4 li.gerente a {display:block;padding-left:26px;padding-right:15px;}
.drop{border:1px dashed #C6C6C6;}
#ccc;border-right:1px solid #ccc;border-bottom:1px solid #ccc;}
.info {color:#666;font-size:90%;}
.info a {text-decoration:underline;}

.btnSolicitar2,.btnUtilizar,.btnAddOutroCel,.btnSalvarComb, 
.btnSolicitar2{background-position:0 -2174px;width:73px;}
.btnUtilizar{background-position:0 -2194px;width:67px;}

.zebrado2 .odd {background:#F3F3F3;}
.zebrado2 .odd .zebrado3 .odd {background:#CACACA;}

.tabHover4 .hover {background:#CACACA !important;}
.lineClick td {cursor:pointer;}
.lineClick td a , .lineClick td a:hover {color:#333;text-decoration:none;}

.positivo {color:#0000A0 !important;}
.pb10 {padding-bottom:10px;}

body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td,a {margin:0;padding:0;}
body {background-color:#FFF;padding:10px;}
body, select {font:11px Tahoma, Arial, Sans-Serif;color:#333;}
table {border-collapse:collapse;border-spacing:0;}
ol,ul {list-style:none;}
h1,h2,h3,h4,h5,h6 {font-size:100%;font-weight:normal;}
q:before,q:after {content:'';}
hr {width:100%;height:1px;border-width:1px 0 0;border-top:1px solid #333;clear:both;*margin:-7px 0;display:block;}

table {font-size:100% !important;}
table sup {font-size:78% !important;}
select, input, textarea {visibility:hidden; display:none;}
a {text-decoration:none;color:#333;cursor:default;}
a:hover {color:#333;text-decoration:none;}
.boxListaComprovante,
.after {zoom:1;}
.boxListaComprovante:after,
.after:after {content:".";display:block;clear:both;visibility:hidden;height:0;overflow:hidden;}
.fl {float:left;}

.comprovante {background:#FFF;padding:15px 0 10px 0;width:722px;font-size:100%;}

.quebraPagina .pba {page-break-after:always;}
.topo, .topoModal .dados, .base {background:none !important;padding:15px 15px 10px 15px;border-bottom:1px solid #333;zoom:1;}
.dados {padding:0 0 10px;}
.topo h2 {font-size:128%;line-height:150%;font-weight:bold;float:left;}
.topoModal h2 {font-size:128%;line-height:150%;font-weight:bold;float:left;}
.topo ul.lstTopoComp,
.topoModal ul.lstTopoComp {float:left;width:520px;}
.topo ul.lstTopoComp li,
.topoModal ul.lstTopoComp li {margin-top:3px;}
.topo .icoLogo {display:block;float:left;}

.efetuado .topo .icoLogo,
.efetuado .topoModal .icoLogo {background:url(../../imagens/geral/ico_logo_comprovante_print.gif) top left no-repeat;width:86px;height:85px;margin-right:30px;}

.efetuado .topo .icoLogo3 {background:url(../../imagens/geral/ico_logo_sp_print.gif) top left no-repeat;width:76px;height:98px;margin-right:30px;}
.capitalizacao .topo .icoLogo {background:url(../../imagens/geral/bradesco_capitalizacao_print.gif) 0 0 no-repeat;width:95px;height:85px;margin-right:30px;}

.baseSac {margin:10px 0;width:710px;font-size:80%;}
.baseSac div.sac {width:575px;padding:0 10px;float:left;border-right:1px;}
.baseSac ul.sac {border-bottom:1px;padding-bottom:5px;margin-bottom:5px;width:100%;}
.baseSac ul.sac li {float:left;}
.baseSac ul.sac li.sac {width:95px;font-weight:bold;text-align:right;margin-right:15px;}
.baseSac ul.sac li.alo {width:85px;}
.baseSac ul.sac li.deficiente {width:155px;}
.baseSac ul.sac li.mensagem {width:200px;}
.baseSac ul.sac li span {display:block;}
.baseSac ul.sac li .fone, .baseSac ul.ouvidoria li.fone {color:#333;}
.baseSac ul.ouvidoria li.ouvidoria {font-weight:bold;}
.baseSac ul.ouvidoria li.mensagem {}
.baseSac ul.ouvidoria li {display:inline;margin-right:15px;}
.baseSac div.fale {float:left;width:90px;margin:0 10px;line-height:150%;}
.baseSac div.fale a {text-decoration:none;}

h2.agrupador, .boxTermo h2{font-weight:bold;padding:20px 0 10px 0}
h2.agrupador span{font-weight:normal !important}
h2.ttlTp01{font-size:12px;font-weight:700;padding:15px 0}
h2.tituloMsg {font-size:128%;line-height:150%;font-weight:bold;}
.info {font-size:90%;font-weight:normal;}
.positivo {color:#000;}
.noBorder,.noBorder td {border:none !important;}
.borda2{border-bottom:1px solid #333}
.clr {clear:both !important;}
.mb10{margin-bottom:10px !important}
.mt10{margin-top:10px}
.mr5{margin-right:5px}
.mr10{margin-right:10px !important}
.pb10{padding-bottom:10px !important}
.pt5{padding-top:5px !important}
.pt10{padding-top:10px !important}
.pl5{padding-left:5px !important}
.pr5{padding-right:5px !important}
.ptb10{padding-top:10px !important;padding-bottom:10px !important}

.tableFix{table-layout:fixed}
table td.sep{width:10px}
td.direita, th.direita{text-align:right !important}
td.center, th.center{text-align:center !important}

.tabTp1 {width:100% !important;}
.tabTp1 .frmCheck {margin-right:5px !important;}
.tabTp1 thead th {font-weight:bold;line-height:1.3;padding:8px 0;border-top:solid 1px #333;border-bottom:solid 1px #333;text-align:left;color:#333;}
.tabTp1 thead th a {color:#333;text-decoration:none;cursor:default;}
.tabTp1 thead th a:hover {color:#333;text-decoration:none;}
.tabTp1 thead tr.ico {display:none !important;border:none !important;}
.tabTp1 tbody {vertical-align:top;}
.tabTp1 tbody td {line-height:140%;padding:8px 0;border-bottom:solid 1px #CCC;}
.tabTp1 tbody tr.click td {font-weight:bold;}
.tabTp1 tbody tr.expansive * {color:#666;border-color:#666;}
tbody.total td , tbody.total2 td , tbody.total3 td {font-weight:bold;border-bottom:solid 1px #333;}

.boxListaComprovante {display:none !important;}

.none {display:none !important;}
.boxExp {display:block;}

.mt10{margin-top:10px !important;}
.mr5{margin-right:5px}
.mr10{margin-right:10px !important}
.mb10{margin-bottom:10px !important}
.pb10{padding-bottom:10px !important}
.pt5{padding-top:5px !important}
.pt10{padding-top:10px !important}
.pl5{padding-left:5px !important}
.pr5{padding-right:5px !important}
.ptb10{padding-top:10px !important;padding-bottom:10px !important}

.noBorder, .noBorder td, .noBorder div {border:0 !important;}

.w320{width:100%}
.w350{width:100%}

.borda2, tr.borda2 td{border-bottom:1px solid #999}
.tabBranco{background:#FFF;}
.tableFix{table-layout:fixed}

h2.agrupador{font-weight:bold;padding:20px 0 10px 0}
h2.agrupador span{font-weight:normal !important}
h2.tituloMsg {font-size:128%;line-height:150%;font-weight:bold;}
h2.tituloMsg2 {font-size:180%;line-height:200%;}

.boxComprovanteLote, .boxComprovanteLote1 {padding:20px 0 0 0;background:#FFF;border:1px solid #CCCCCC;margin-bottom:10px;}
.boxComprovanteLote .topo, .boxComprovanteLote .dados, .boxComprovanteLote .base,
.boxComprovanteLote1 .topo, .boxComprovanteLote1 .dados, .boxComprovanteLote1 .base {background:none !important;padding:0 15px 10px 15px;border-bottom:1px solid #E5E5E5}
.boxComprovanteLote .topo h2, .boxComprovanteLote1 .topo h2 {font-size:128%;line-height:150%;font-weight:bold;float:left;width:500px}
.boxComprovanteLote .topo ul.lstTopoComp, .boxComprovanteLote1 .topo ul.lstTopoComp  {float:right;width:520px}
.boxComprovanteLote .topo .icoLogo, .boxComprovanteLote1 .topo .icoLogo  {display:block;float:left;}
.boxComprovanteLote .dados table, .boxComprovanteLote1 .dados table{width:100%;}
.boxComprovanteLote .base {padding:10px 15px 10px 15px;border-bottom:none !important;}

.efetuado .topo .icoLogo,
.efetuado .topoModal .icoLogo {background:url(../../imagens/geral/ico_logo_comprovante.gif) top left no-repeat;width:86px;height:85px;margin-right:30px;}
.agendado .topo .icoLogo,

.efetuado .topo .icoLogo3 {background:url(../../imagens/geral/ico_logo_sp.gif) no-repeat 0 50%;width:86px;height:98px;margin-right:30px;}

table td.sep{width:10px}
td.direita, th.direita{text-align:right !important}
input.m{text-align:right !important}
td.center, th.center{text-align:center !important}

.tabTp1 .frmCheck {margin-right:5px !important;}
.tabTp1 thead {background-color:#CCC;}
.tabTp1 thead th {font-weight:bold;line-height:1.3;border:none !important;}
.tabTp1 thead.ln1 th {background:url(../../imagens/geral/bgr_tabela1.jpg) top left repeat-x;font-weight:bold;height:37px;text-align:left;}
.tabTp1IntExp thead th.sep,
.tabTp1 thead.ln1 th.sep {background:url(../../imagens/geral/bgr_tabela1_sep.gif) top left no-repeat;width:2px;height:37px;}
.tabTp1IntExp thead th,
.tabTp1 thead.ln2 th {background:url(../../imagens/geral/bgr_tabela2.jpg) top left repeat-x;font-weight:bold;height:47px;text-align:left;}
.tabTp1 thead.ln2 th.sep {background:url(../../imagens/geral/bgr_tabela2_sep.gif) top left no-repeat;width:2px;height:47px;}
.tabTp1 thead.ln3 th {background:url(../../imagens/geral/bgr_tabela3.jpg) top left repeat-x;font-weight:bold;height:74px;text-align:left;}
.tabTp1 thead.ln3 th.sep {background:url(../../imagens/geral/bgr_tabela3_sep.gif) top left no-repeat;width:2px;height:74px;}
.tabTp1 tbody {vertical-align:top;}
.tabTp1 tr.ln1 th {background:url(../../imagens/geral/bgr_tabela1.jpg) top left repeat-x;font-weight:bold;height:37px;text-align:left;}
.tabTp1 tr.ln1 th.sep {background:url(../../imagens/geral/bgr_tabela1_sep.gif) top left no-repeat;width:2px;height:37px;}
.tabTp1 tr.ln2 th {background:url(../../imagens/geral/bgr_tabela2.jpg) top left repeat-x;font-weight:bold;height:47px;text-align:left;}
.tabTp1 tr.ln2 th.sep {background:url(../../imagens/geral/bgr_tabela2_sep.gif) top left no-repeat;width:2px;height:47px;}
.tabTp1 tbody.on {background:#E4E4E4;border-top:1px solid #CCC;}
.tabTp1 tbody.on2 {background:#CACACA;}
.tabTp1 tbody.over2 {background:#CACACA;}
.tabTp1 tbody.on2 .tdT {border-top:solid 1px #AAA;}
.tabTp1 tbody.on2 .tdB {border-bottom:solid 1px #AAA;}
.tabTp1 tbody.on2 tr.click td {font-weight:bold;}
.tabTp1 tbody tr.click td {cursor:pointer;}
.tabTp1 tbody tr.indisponivel td, .tabTp1 tbody tr.indisponivel td a {color:#999;}
.tabTp1 tbody tr.indisponivel td span.disponivel {color:#333;}
.tabTp1 tbody tr.desc td {color:#666;padding:0 !important;}
.tabTp1 tbody tr.even {background:#E4E4E4;}
.tabTp1 tbody tr.on {background:#E4E4E4;border-top:1px solid #CCC;border-top:1px solid #CCC;}
.tabTp1 tbody td {line-height:140%;padding:8px 0;}
.tabTp1 tbody td span.expansivel {background:url(../../imagens/geral/ico_mais_menos.gif) 0 0 no-repeat;font-size:1px;display:block;text-indent:-9999px;width:11px;height:11px;cursor:pointer;margin-top:2px;}
.tabTp1 tbody td span.expansivelOn {background:url(../../imagens/geral/ico_mais_menos.gif) 0 -49px repeat-x;}
.tabTp1 tbody td span.desc {color:#666;display:block;}
.tabTp1 tbody.total {background:#E4E4E4;font-weight:bold;}
.tabTp1 tbody.total2 {background:#CACACA;font-weight:bold;}
.tabTp1 tbody.total3 {background:#999;font-weight:bold;}
.tabTp1 tbody.total3 * {color:#FFF;}
.tabTp1 tbody.total4 {background:#E4E4E4;}
.tabTp1 tbody.total4 td {border-bottom:1px solid #CDCDCD;}
.tabTp1 tbody.total5 {background:#CACACA;}
.tabTp1 tbody.total5 td {border-bottom:1px solid #999;}
.tabTp1 tbody.total tr.expansive {font-weight:normal;}

.boxListaComprovante {zoom:1;}


			</style> ]]> </xsl:text> 
		</xsl:copy>	
    </xsl:template>
	
	<xsl:template name="body" match="body">
        <xsl:copy-of select="."/>
    </xsl:template>
	
</xsl:stylesheet>