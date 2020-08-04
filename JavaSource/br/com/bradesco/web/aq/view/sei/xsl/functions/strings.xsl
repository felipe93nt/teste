<!--
    Document   : FuncoesUtil.xsl
    Created on : 31 de Agosto de 2010, 16:24
    Author     : Scopus
    Description:
       XSL com funções string
-->


<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	 <xsl:template name="RemoverTagsXml">
        <xsl:param name="value"/>
        <xsl:choose>
            <xsl:when test="contains($value, '&lt;')">
                <xsl:value-of select="substring-before($value, '&lt;')"/>
                <xsl:call-template name="RemoverTagsXml">
                    <xsl:with-param name="value" select="substring-after($value, '&gt;')"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$value"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>