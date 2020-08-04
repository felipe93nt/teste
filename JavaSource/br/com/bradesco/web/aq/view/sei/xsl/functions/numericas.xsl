<!--
    Document   : FuncoesUtil.xsl
    Created on : 31 de Agosto de 2010, 16:24
    Author     : Scopus
    Description:
       XSL com funções númericas
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    
   <xsl:template name="FormatarNumero_US">
        <xsl:param name="Num"/>
        <xsl:if test="boolean(number(substring-after($Num,'E')))">
            <xsl:call-template name="RemoverNotacaoCientifica_US">
                <xsl:with-param name="m"
                                select="substring-before($Num,'E')" />
                <xsl:with-param name="e" select="substring-after($Num,'E')" />
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="not(boolean(number(substring-after($Num,'E'))))">
            <xsl:value-of select="format-number($Num, '0.00')"/>
        </xsl:if>
    </xsl:template>
    <xsl:template name="RemoverNotacaoCientifica_US">
        <xsl:param name="m" />
        <xsl:param name="e" />
        <xsl:choose>
            <xsl:when test="$e = 0 or not(boolean($e))">
                <xsl:value-of select="format-number($m, '0.00')"/>
            </xsl:when>
            <xsl:when test="$e &gt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica_US">
                    <xsl:with-param name="m" select="$m * 10" />
                    <xsl:with-param name="e" select="$e - 1" />
                </xsl:call-template>
            </xsl:when>
            <xsl:when test="$e &lt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica_US">
                    <xsl:with-param name="m" select="$m div 10" />
                    <xsl:with-param name="e" select="$e + 1" />
                </xsl:call-template>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template name="FormatarNumero">
        <xsl:param name="Num"/>
        <xsl:if test="boolean(number(substring-after($Num,'E')))">
            <xsl:call-template name="RemoverNotacaoCientifica">
                <xsl:with-param name="m"
                                select="substring-before($Num,'E')" />
                <xsl:with-param name="e" select="substring-after($Num,'E')" />
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="not(boolean(number(substring-after($Num,'E'))))">
            <xsl:value-of select="format-number($Num, '###.###.###.##0,00', 'brazil')"/>
        </xsl:if>
    </xsl:template>
    <xsl:template name="RemoverNotacaoCientifica">
        <xsl:param name="m" />
        <xsl:param name="e" />
        <xsl:choose>
            <xsl:when test="$e = 0 or not(boolean($e))">
                <xsl:value-of select="format-number($m, '###.###.###.##0,00', 'brazil')"/>
            </xsl:when>
            <xsl:when test="$e &gt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica">
                    <xsl:with-param name="m" select="$m * 10" />
                    <xsl:with-param name="e" select="$e - 1" />
                </xsl:call-template>
            </xsl:when>
            <xsl:when test="$e &lt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica">
                    <xsl:with-param name="m" select="$m div 10" />
                    <xsl:with-param name="e" select="$e + 1" />
                </xsl:call-template>
            </xsl:when>
        </xsl:choose>
    </xsl:template> 
    
    <xsl:template name="FormatarNumero_BR">
        <xsl:param name="Num"/>
        <xsl:if test="boolean(number(substring-after($Num,'E')))">
            <xsl:call-template name="RemoverNotacaoCientifica_BR">
                <xsl:with-param name="m"
                                select="substring-before($Num,'E')" />
                <xsl:with-param name="e" select="substring-after($Num,'E')" />
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="not(boolean(number(substring-after($Num,'E'))))">
            <xsl:value-of select="format-number($Num, '###########0,00', 'brazil')"/>
        </xsl:if>
    </xsl:template>
    <xsl:template name="RemoverNotacaoCientifica_BR">
        <xsl:param name="m" />
        <xsl:param name="e" />
        <xsl:choose>
            <xsl:when test="$e = 0 or not(boolean($e))">
                <xsl:value-of select="format-number($m, '###########0,00', 'brazil')"/>
            </xsl:when>
            <xsl:when test="$e &gt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica_BR">
                    <xsl:with-param name="m" select="$m * 10" />
                    <xsl:with-param name="e" select="$e - 1" />
                </xsl:call-template>
            </xsl:when>
            <xsl:when test="$e &lt; 0">
                <xsl:call-template name="RemoverNotacaoCientifica_BR">
                    <xsl:with-param name="m" select="$m div 10" />
                    <xsl:with-param name="e" select="$e + 1" />
                </xsl:call-template>
            </xsl:when>
        </xsl:choose>
    </xsl:template>   

</xsl:stylesheet>
