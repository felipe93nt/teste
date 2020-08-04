<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<!-- Importacao de funcoes numéricas -->

	<xsl:output method="xml" indent="no" omit-xml-declaration="yes"
		encoding="iso-8859-1" />
	<xsl:decimal-format name="brazil" decimal-separator="," grouping-separator="." />
	<xsl:template match="/">
		<xsl:text disable-output-escaping="yes"><![CDATA[OFXHEADER:100
DATA:OFXSGML
VERSION:102
SECURITY:NONE
ENCODING:USASCII
CHARSET:1252
COMPRESSION:NONE
OLDFILEUID:NONE
NEWFILEUID:NONE

<OFX>
<SIGNONMSGSRSV1>
<SONRS>
<STATUS>
<CODE>0
<SEVERITY>INFO
</STATUS>
<DTSERVER>00000000000000
<LANGUAGE>POR
</SONRS>
</SIGNONMSGSRSV1>
<BANKMSGSRSV1>]]></xsl:text>
		<xsl:call-template name="content" />
		<xsl:text disable-output-escaping="yes">
<![CDATA[</BANKMSGSRSV1>
</OFX>
]]></xsl:text>
	</xsl:template>

	<xsl:template name="content">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRNRS>
<TRNUID>1001
<STATUS>
<CODE>0
<SEVERITY>INFO
</STATUS>
<STMTRS>
<CURDEF>BRL
<BANKACCTFROM>
<BANKID>0237
<ACCTID>]]></xsl:text>
		<xsl:text>1133/56535</xsl:text>
		<xsl:text disable-output-escaping="yes">
<![CDATA[<ACCTTYPE>CHECKING
</BANKACCTFROM>
<BANKTRANLIST>
<DTSTART>]]>
</xsl:text>
		<xsl:call-template name="data" />
		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTEND>]]></xsl:text>
		<xsl:call-template name="data" />

		<!-- INICIO Lancamentos Extratos -->

		<!-- <xsl:call-template name="lancamento1" /> -->
		<xsl:call-template name="lancamento2" />
		<xsl:call-template name="lancamento3" />
		<xsl:call-template name="lancamento4" />
		<xsl:call-template name="lancamento5" />
		<xsl:call-template name="lancamento6" />
		<xsl:call-template name="lancamento7" />
		<xsl:call-template name="lancamento8" />
		<xsl:call-template name="lancamento9" />
		<xsl:call-template name="lancamento10" />
		
		<xsl:call-template name="lancamentoFuturo1" />
		<xsl:call-template name="lancamentoFuturo2" />
		<xsl:call-template name="lancamentoFuturo3" />
		<xsl:call-template name="lancamentoFuturo4" />
		
		
		<!-- FIM Lancamentos Extratos -->

		<xsl:text disable-output-escaping="yes">
<![CDATA[</BANKTRANLIST>
<LEDGERBAL>
<BALAMT>]]></xsl:text>
 <xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody[2]/tr/td[10],'.','')" />
 <xsl:text disable-output-escaping="yes">
<![CDATA[
<DTASOF>00000000
</LEDGERBAL>
</STMTRS>
</STMTTRNRS>]]></xsl:text>
	</xsl:template>

<!-- 18/05/09 SALDO ANTERIOR 199.347.900,10  -->
	<xsl:template name="lancamento1">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="credit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110518</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr/td[12],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:call-template name="conta" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:call-template name="conta" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>

<!-- TED Crédito Automático Bco: 135 | Ag: 0654 | CC: 056587-6 | Pell Comput 0000722 1.185.000,00 	  -->	
	<xsl:template name="lancamento2">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="credit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110518</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[2]/td[8],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[2]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[2]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[2]/td[4]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[2]/td[4]/span[3])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- 19/05/09 Pagamento Fornecedor Pagamento da mensalidade 0048342 - 37.981,10 		 -->	
	<xsl:template name="lancamento3">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110519</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[3]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[3]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[3]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[3]/td[4]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[3]/td[4]/span[3])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- DOC Crédito Automático Bco: 122 | Ag: 1133 | CC: 0565350-0 | Daniele And 0563848  -106.872,00 -->	
	<xsl:template name="lancamento4">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110519</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[4]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[4]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[4]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[4]/td[4]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[4]/td[4]/span[3])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- 20/05/09 Pagamento FGTS 0563948 0563948 -452.300,12 -->	
	<xsl:template name="lancamento5">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110520</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[5]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[5]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[5]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[5]/td[4]/span)" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- Cheque Compensado Bco: 122 | Ag: 1133 | CC: 0565350-0 0888447 157,00  -->	
	<xsl:template name="lancamento6">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="credit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110520</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[6]/td[8],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[6]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[6]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[6]/td[4]/span[2])" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[6]/td[4]/span[3])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- Tarifa Cartão Empresa 0040742 0040742 -50,00 -->	
	<xsl:template name="lancamento7">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110520</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[7]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[7]/td[6]" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[7]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[7]/td[4])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>	
	
	<!-- Transf. Bradesco Ag: 1733 | CC: 000312-8 | Cia Andres Ltda 0562233 7.689,00 -->	
	<xsl:template name="lancamento8">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="credit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110520</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[8]/td[8],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[8]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[8]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[8]/td[4])" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[8]/td[4]/span)" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- Transf. Bradesco Ag: 1654 | CC: 056566-0 | Daniele Andres 0562233 - 542.119,22-->	
	<xsl:template name="lancamento9">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110519</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[9]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[9]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[9]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[9]/td[4]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[9]/td[4]/span[2])" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!--Tarifa Cartão Empresa 0043568 -50,00 -->	
	<xsl:template name="lancamento10">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110519</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/table/tbody/tr[10]/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[10]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr[10]/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/table/tbody/tr[10]/td[4])" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!--21/05/09 TED Crédito Automático Bco: 135 | Ag: 1133 | CC: 055435-3 | Guilherme D 1111722 -5.000,00 -->	
	<xsl:template name="lancamentoFuturo1">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110521</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[10],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[6]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[4]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[4]/span[2])" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!--Pagamento Fornecedor Fornecedor de materiais de escritório 1148342 - 400,00  -->	
	<xsl:template name="lancamentoFuturo2">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110521</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[2]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[2]/span[2])" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- Pagamento Fornecedor Bco: 135 | Ag: 1133 | CC: 0565350-0 | Guilherme D 2222722 -100,00  -->	
	<xsl:template name="lancamentoFuturo3">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="debit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110521</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[8],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[2]/span)" />
		<xsl:text>-</xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[2]/span[2])" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>
	
<!-- Salário 0048355 4.000,00-->	
	<xsl:template name="lancamentoFuturo4">
		<xsl:text disable-output-escaping="yes">
<![CDATA[<STMTTRN>
<TRNTYPE>]]></xsl:text>
		<xsl:call-template name="credit" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<DTPOSTED>]]></xsl:text>
		<xsl:text>20110521</xsl:text>

		<xsl:text disable-output-escaping="yes">
<![CDATA[<TRNAMT>]]></xsl:text>
		<xsl:value-of select="translate(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[6],'.','')" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<FITID>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[4]" />

		<xsl:text disable-output-escaping="yes">
<![CDATA[<CHECKNUM>]]></xsl:text>
		<xsl:value-of select="html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[4]" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[<MEMO>]]></xsl:text>
		<xsl:value-of select="normalize-space(html/body/div/div[2]/div/div/div/div[2]/table/tbody/tr[4]/td[2]/span)" />
		
		<xsl:text disable-output-escaping="yes">
<![CDATA[</STMTTRN>]]></xsl:text>
	</xsl:template>

	
	
	<!-- Valores Estáticos -->
	<xsl:template name="credit">
		<xsl:text>CREDIT</xsl:text>
	</xsl:template>
	
	<xsl:template name="debit">
		<xsl:text>DEBIT</xsl:text>
	</xsl:template>
	
	<xsl:template name="data">
		<xsl:text>20110520</xsl:text>
	</xsl:template>
	
	<xsl:template name="conta">
		<xsl:text>412563</xsl:text>
	</xsl:template>

</xsl:stylesheet>