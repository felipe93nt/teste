<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="text"/>
 <xsl:strip-space elements="*" />
   
	<xsl:template match="/">
          <xsl:call-template name="template_qif" />
	</xsl:template>

	<xsl:template name="template_qif">
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'!Type:Bank'" />
		<xsl:value-of select="'&#10;'" />
		
		<xsl:value-of select="'D'" />
		<xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr/td[2]" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'M'" />
		<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[2]/td[4]/span)" />
		<xsl:value-of select="' '" />
		<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[2]/td[4]/span[3])" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'T'" />
		<xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[2]/td[8],'.',''),',','.')" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'N'" />
		<xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[2]/td[6]" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'LLanc. 1133 056535-0'" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'^'" />
		<xsl:value-of select="'&#10;'" />
		
		<xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[3]/td[2]" />
		<xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[3]/td[4]/span)" />
		<xsl:value-of select="' '" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[3]/td[4]/span[3])" />
        <xsl:value-of select="'&#10;'" />	
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[3]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[4]/td[6]" />
		<xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
		<xsl:value-of select="'&#10;'" />
		<xsl:value-of select="'^'" />
		<xsl:value-of select="'&#10;'" />
          
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[3]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[4]/td[4]/span)" />
        <xsl:value-of select="' '" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[4]/td[4]/span[3])" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[4]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[4]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
          
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[4]/span)" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
          
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[6]/td[4]/span[2])" />
        <xsl:value-of select="' '" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[6]/td[4]/span[3])" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[6]/td[8],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[6]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
        
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[7]/td[4])" />
		<xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[7]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[7]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
        
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[8]/td[4])" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[8]/td[8],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[8]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
        
        <xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[9]/td[4]/span)" />
        <xsl:value-of select="' '" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[9]/td[4]/span[2])" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[9]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[9]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
        
		<xsl:value-of select="'D'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[5]/td[2]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'M'" />
        <xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr[10]/td[4])" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'T'" />
        <xsl:value-of select="translate(translate(/html/body/div/div[2]/div/div/table/tbody/tr[10]/td[10],'.',''),',','.')" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'N'" />
        <xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr[10]/td[6]" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'LLanc. 1133 056535-0'" />
        <xsl:value-of select="'&#10;'" />
        <xsl:value-of select="'^'" />
        <xsl:value-of select="'&#10;'" />
          
   </xsl:template>

</xsl:stylesheet>