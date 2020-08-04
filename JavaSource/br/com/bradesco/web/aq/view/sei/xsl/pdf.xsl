<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="xml" encoding="UTF-8" indent="no" />

	<xsl:template match="node()|@*">
		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="/">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="head">
		<xsl:copy>
			<xsl:text disable-output-escaping="yes"> 
<![CDATA[ 
<style type="text/css"> 
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td,a {margin:0;padding:0;}
body {font:11px Tahoma, Arial, Sans-Serif;color:#333;}
h1,h2,h3,h4,h5,h6 {font-size:100%;font-weight:normal;}
hr{width:100%;height:1px;border-width:1px 0 0;border-top:1px solid #E5E5E5;clear:both;margin:0;*margin:-7px 0;display:block;}

.comprovante {background:#FFF;padding:15px 0 10px 0;width:722px;font-size:100%;}

</style> ]]> 
			</xsl:text>
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>