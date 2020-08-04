<?xml version="1.0" encoding="UTF-8"?>
<!--
	Document : ods.xsl
	Created on : 1 de Dezembro de 2011, 15:00
	Author : CPM Braxis - Christian Lacerda
	Description: XSL para arquivos ODS
-->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
	xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
	xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
	xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
	xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
	xmlns:fo="urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"
	xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:dc="http://purl.org/dc/elements/1.1/"
	xmlns:meta="urn:oasis:names:tc:opendocument:xmlns:meta:1.0"
	xmlns:number="urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0"
	xmlns:svg="urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"
	xmlns:chart="urn:oasis:names:tc:opendocument:xmlns:chart:1.0"
	xmlns:dr3d="urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0" xmlns:math="http://www.w3.org/1998/Math/MathML"
	xmlns:form="urn:oasis:names:tc:opendocument:xmlns:form:1.0"
	xmlns:script="urn:oasis:names:tc:opendocument:xmlns:script:1.0"
	xmlns:ooo="http://openoffice.org/2004/office" xmlns:ooow="http://openoffice.org/2004/writer"
	xmlns:oooc="http://openoffice.org/2004/calc" xmlns:dom="http://www.w3.org/2001/xml-events"
	xmlns:xforms="http://www.w3.org/2002/xforms" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	exclude-result-prefixes="office style text table draw fo xlink dc meta number svg chart dr3d math form script ooo ooow oooc dom xforms xsd xsi">

	<xsl:output method="xml" encoding="UTF-8" indent="yes" />
	<xsl:strip-space elements="*" />
	<xsl:decimal-format name="brazil" decimal-separator=","
		grouping-separator="." />
	<xsl:template match="/">
		<office:document-content
			xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
			xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
			xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
			xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
			xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
			xmlns:fo="urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"
			xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:meta="urn:oasis:names:tc:opendocument:xmlns:meta:1.0"
			xmlns:number="urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0"
			xmlns:svg="urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"
			xmlns:chart="urn:oasis:names:tc:opendocument:xmlns:chart:1.0"
			xmlns:dr3d="urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0"
			xmlns:math="http://www.w3.org/1998/Math/MathML" xmlns:form="urn:oasis:names:tc:opendocument:xmlns:form:1.0"
			xmlns:script="urn:oasis:names:tc:opendocument:xmlns:script:1.0"
			xmlns:dom="http://www.w3.org/2001/xml-events" xmlns:xforms="http://www.w3.org/2002/xforms"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns:presentation="urn:oasis:names:tc:opendocument:xmlns:presentation:1.0">

			<office:font-face-decls>
				<style:font-face style:name="Arial" svg:font-family="Arial"
					style:font-pitch="variable" />
				<style:font-face style:name="Arial Unicode MS"
					svg:font-family="&apos;Arial Unicode MS&apos;"
					style:font-family-generic="system" style:font-pitch="variable" />
				<style:font-face style:name="Tahoma"
					svg:font-family="Tahoma" style:font-family-generic="system"
					style:font-pitch="variable" />
			</office:font-face-decls>
			<office:automatic-styles>
				<style:style style:name="co1" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="2.267cm" />
				</style:style>
				<style:style style:name="co2" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="4.189cm" />
				</style:style>
				<style:style style:name="co3" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="5.055cm" />
				</style:style>
				<style:style style:name="co4" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="6.054cm" />
				</style:style>
				<style:style style:name="co5" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="2.224cm" />
				</style:style>
				<style:style style:name="co6" style:family="table-column">
					<style:table-column-properties
						fo:break-before="auto" style:column-width="2.113cm" />
				</style:style>
				<style:style style:name="ro1" style:family="table-row">
					<style:table-row-properties
						style:row-height="0.453cm" fo:break-before="auto"
						style:use-optimal-row-height="true" />
				</style:style>
				<style:style style:name="ro2" style:family="table-row">
					<style:table-row-properties
						style:row-height="2.21cm" fo:break-before="auto"
						style:use-optimal-row-height="false" />
				</style:style>
				<style:style style:name="ro3" style:family="table-row">
					<style:table-row-properties
						style:row-height="0.473cm" fo:break-before="auto"
						style:use-optimal-row-height="true" />
				</style:style>
				<style:style style:name="ta1" style:family="table"
					style:master-page-name="Default">
					<style:table-properties table:display="true"
						style:writing-mode="lr-tb" />
				</style:style>
				<style:style style:name="ce1" style:family="table-cell"
					style:parent-style-name="Default">
					<style:text-properties fo:font-weight="bold"
						style:font-weight-asian="bold" style:font-weight-complex="bold" />
				</style:style>
				<style:style style:name="ce2" style:family="table-cell"
					style:parent-style-name="Default">
					<style:table-cell-properties
						fo:border-bottom="none" fo:border-left="none" fo:border-right="0.002cm solid #000000"
						fo:border-top="none" />
				</style:style>
				<style:style style:name="ce3" style:family="table-cell"
					style:parent-style-name="Default">
					<style:table-cell-properties
						fo:border-bottom="none" fo:border-left="none" fo:border-right="none"
						fo:border-top="0.002cm solid #000000" />
				</style:style>
				<style:style style:name="gr1" style:family="graphic">
					<style:graphic-properties draw:stroke="none"
						draw:fill="none" draw:textarea-horizontal-align="center"
						draw:textarea-vertical-align="middle" draw:color-mode="standard"
						draw:luminance="0%" draw:contrast="0%" draw:gamma="100%" draw:red="0%"
						draw:green="0%" draw:blue="0%" fo:clip="rect(0cm, 0cm, 0cm, 0cm)"
						draw:image-opacity="100%" style:mirror="none" />
				</style:style>
				<style:style style:name="P1" style:family="paragraph">
					<style:paragraph-properties
						fo:text-align="center" />
				</style:style>
				<style:style style:name="T1" style:family="text">
					<style:text-properties fo:font-weight="bold"
						style:font-weight-asian="bold" style:font-weight-complex="bold" />
				</style:style>
				<style:style style:name="T2" style:family="text">
					<style:text-properties fo:font-weight="normal"
						style:font-weight-asian="normal" style:font-weight-complex="normal" />
				</style:style>
			</office:automatic-styles>

			<office:body>
				<office:spreadsheet>
				<table:table table:name="Planilha {position()}" table:style-name="tableDefault">	
					<table:table-column table:style-name="ctable.A" />
					<table:table-column table:style-name="ctable.B" />
					<table:table-column table:style-name="ctable.C" />
					<table:table-column table:style-name="ctable.D" />
					<table:table-column table:style-name="ctable.E" />
					<table:table-column table:style-name="ctable.E" />
					
					<xsl:call-template name="cabecalho" />
					<xsl:call-template name="line_feed" />					
					<xsl:call-template name="total_de_saldos" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="disponivel" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="bloqueado" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="saldo_disponivel_para_investimento" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="demonstrativo_de_investimento" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="limites_de_credito" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="credito_pre_aprovado" />
					<xsl:call-template name="line_feed" />
					<xsl:call-template name="footer" />					
										
				 </table:table>	
				 			
				</office:spreadsheet>
			</office:body>
		</office:document-content>
	</xsl:template>
	
	<xsl:template name="cabecalho">
		<table:table-row table:style-name="ro2">
			<table:table-cell table:number-columns-spanned="2"
				table:number-rows-spanned="1">
				<draw:frame table:end-cell-address="&apos;Extratos {position()}&apos;.A2"
					table:end-x="2.978cm" table:end-y="0.014cm" draw:z-index="0"
					draw:name="Figuras 1" draw:style-name="gr1" draw:text-style-name="P1"
					svg:width="2.978cm" svg:height="2.215cm" svg:x="0cm" svg:y="20cm">
					<draw:image xlink:href="Pictures/logo_comprovante.gif"
						xlink:type="simple" xlink:show="embed" xlink:actuate="onLoad">
						<text:p />
					</draw:image>
				</draw:frame>
			</table:table-cell>
			<table:covered-table-cell />
			<table:table-cell table:style-name="ce1"
				office:value-type="string">
				<text:p>
					<text:span text:style-name="T1">
						<xsl:value-of select="normalize-space(/html/body/div/div/h2)" />
					</text:span>
				</text:p>
				<text:p />
				<text:p>
					<text:span text:style-name="T2">
						<xsl:value-of select="normalize-space(/html/body/div/div/ul/li)" />						
					</text:span>
				</text:p>
				<text:p>
					<text:span text:style-name="T2">
						<xsl:value-of select="normalize-space(/html/body/div/div/ul/li[2])" />						
					</text:span>
				</text:p>
				<text:p>
					<text:span text:style-name="T2">						
						<xsl:value-of select="normalize-space(/html/body/div/div/ul/li[3])" />												
					</text:span>
				</text:p>
				
				
			</table:table-cell>
			<table:table-cell table:number-columns-repeated="2" />
		</table:table-row>
	</xsl:template>
	
	<xsl:template name="total_de_saldos">
	
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/h2)" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr/td[3])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
	</xsl:template>
	<xsl:template name="disponivel">
	
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/h2[2])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT HEADER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/thead/tr/th[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/thead/tr/th[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT FOOTER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody[2]/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
	</xsl:template>
	<xsl:template name="bloqueado">
	
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/h2[3])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT HEADER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/thead/tr/th[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/thead/tr/th[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT -->		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT FOOTER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody[2]/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody[2]/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
	</xsl:template>
	<xsl:template name="saldo_disponivel_para_investimento">
		
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/h2)" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT FOOTER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[3])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
	</xsl:template>
	<xsl:template name="demonstrativo_de_investimento">
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/h2[2])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT HEADER -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT -->		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[2]/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[2]/a)" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[4])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- FOOTNOTE -->
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[2]/p)" />
				</text:p>
			</table:table-cell>			
		</table:table-row>
		
	</xsl:template>
	
	<xsl:template name="limites_de_credito">
		
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/h2)" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT HEADER-->		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[4])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[7])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[10])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[14])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/thead/tr/th[17])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT -->		
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[4])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[7])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[10])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[14])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[16])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>	
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[2])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[4])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[7])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[10])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[14])" />
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[15])" />
				</text:p>
			</table:table-cell>
		</table:table-row>
		
	</xsl:template>
	
	<xsl:template name="credito_pre_aprovado">
		<!-- SECTION -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/h2[2])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT HEADER -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[2])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[4])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[8])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
		<!-- CONTENT -->
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[2]/a)" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[4])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[6])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[2]/a)" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[4])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[6])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		
	</xsl:template>
	
	<xsl:template name="footer">
		<table:table-row>
			<table:table-cell office:value-type="string" table:number-columns-spanned="5">
				<text:p>
				<xsl:value-of select="normalize-space(/html/body/div/div[2]/div/div[3]/p)" />
				</text:p>
			</table:table-cell>
			<table:covered-table-cell table:number-columns-repeated="6" />	
		</table:table-row>		
		<table:table-row>
			<table:table-cell office:value-type="string" table:number-columns-spanned="5">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/p[2])" />					
				</text:p>
			</table:table-cell>
			<table:covered-table-cell table:number-columns-repeated="6" />	
		</table:table-row>
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<text:span text:style-name="T1">
						<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul/li)" />					
					</text:span>
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul/li[2])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul/li[3])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul/li[4])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div[2]/p)" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
		<table:table-row>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul[2]/li)" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul[2]/li[2])" />					
				</text:p>
			</table:table-cell>
			<table:table-cell office:value-type="string">
				<text:p>
					<xsl:value-of select="normalize-space(/html/body/div/div[2]/div[2]/div/ul[2]/li[3])" />					
				</text:p>
			</table:table-cell>
		</table:table-row>
	</xsl:template>
	
	<xsl:template name="line_feed">		
		<table:table-row>
			<table:table-cell office:value-type="string"
				table:number-columns-spanned="6">
				<text:p>
				</text:p>
			</table:table-cell>
			<table:covered-table-cell
				table:number-columns-repeated="6" />
		</table:table-row>
	</xsl:template>	
</xsl:stylesheet>