<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:v="urn:schemas-microsoft-com:vml"
	xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
	xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
	xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
	xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
	xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
	xmlns:fo="urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"
	xmlns:xlink="http://www.w3.org/1999/xlink" 
	xmlns:svg="urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"
	xmlns:dom="http://www.w3.org/2001/xml-events"
	exclude-result-prefixes="office style text table draw fo xlink svg dom">

	<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" />
	<xsl:strip-space elements="*" />
	<xsl:decimal-format name="brazil" decimal-separator="," grouping-separator="." />

	<xsl:template match="/">
		<office:document-content
			xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
			xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
			xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
			xmlns:table="urn:oasis:names:tc:opendocument:xmlns:table:1.0"
			xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
			xmlns:fo="urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"
			xmlns:xlink="http://www.w3.org/1999/xlink"
			xmlns:svg="urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"
			xmlns:dom="http://www.w3.org/2001/xml-events" 
			xmlns:presentation="urn:oasis:names:tc:opendocument:xmlns:presentation:1.0">
			
			<office:font-face-decls>
				<style:font-face style:name="Arial" svg:font-family="Arial"
					style:font-pitch="variable" />
				<style:font-face style:name="Arial1"
					svg:font-family="Arial" style:font-family-generic="swiss"
					style:font-pitch="variable" />
				<style:font-face style:name="Arial"
					svg:font-family="&apos;Arial&apos;"
					style:font-family-generic="swiss" style:font-pitch="variable" />
				<style:font-face style:name="Arial1"
					svg:font-family="&apos;Arial&apos;" style:font-adornments="Regular"
					style:font-family-generic="swiss" style:font-pitch="variable" />
				<style:font-face style:name="Arial Unicode MS"
					svg:font-family="&apos;Arial Unicode MS&apos;"
					style:font-family-generic="system" style:font-pitch="variable" />
				<style:font-face style:name="Tahoma"
					svg:font-family="Tahoma" style:font-family-generic="system"
					style:font-pitch="variable" />
			</office:font-face-decls>
			<office:styles>
				<style:default-style style:family="graphic">
					<style:graphic-properties
						draw:shadow-offset-x="0.3cm" draw:shadow-offset-y="0.3cm"
						draw:start-line-spacing-horizontal="0.283cm"
						draw:start-line-spacing-vertical="0.283cm"
						draw:end-line-spacing-horizontal="0.283cm"
						draw:end-line-spacing-vertical="0.283cm" style:flow-with-text="true" />
					<style:paragraph-properties
						fo:text-align="start" style:text-autospace="ideograph-alpha"
						style:line-break="strict" style:writing-mode="lr-tb"
						style:font-independent-line-spacing="false">
						<style:tab-stops />
					</style:paragraph-properties>
					<style:text-properties fo:color="#000000"
						fo:font-size="8pt" fo:language="pt" fo:country="BR"
						style:font-size-asian="12pt" style:language-asian="en"
						style:country-asian="US" style:font-size-complex="12pt"
						style:language-complex="en" style:country-complex="US" />
				</style:default-style>
				<style:default-style style:family="paragraph">
					<style:paragraph-properties
						fo:text-align="start" style:justify-single-word="false"
						style:text-autospace="ideograph-alpha" style:punctuation-wrap="hanging"
						style:line-break="strict" style:writing-mode="page" />
					<style:text-properties fo:color="#000000"
						style:font-name="Arial" fo:font-size="8pt" fo:language="pt"
						fo:country="BR" style:font-name-asian="Arial Unicode MS"
						style:font-size-asian="12pt" style:language-asian="en"
						style:country-asian="US" style:font-name-complex="Tahoma"
						style:font-size-complex="12pt" style:language-complex="en"
						style:country-complex="US" />
				</style:default-style>
				<style:default-style style:family="table">
					<style:table-properties table:border-model="separating" />
				</style:default-style>
				<style:default-style style:family="table-row">
					<style:table-row-properties
						fo:keep-together="auto" />
				</style:default-style>
				<style:style style:name="Standard" style:family="paragraph"
					style:class="text" />
				<style:style style:name="Table_20_Contents"
					style:display-name="Table Contents" style:family="paragraph"
					style:parent-style-name="Standard" style:class="extra">
					<style:paragraph-properties
						text:number-lines="false" text:line-number="0" />
				</style:style>
				<style:style style:name="Header" style:family="paragraph"
					style:parent-style-name="Standard" style:class="extra">
					<style:paragraph-properties
						text:number-lines="false" text:line-number="0">
						<style:tab-stops>
							<style:tab-stop style:position="8.625cm"
								style:type="center" />
							<style:tab-stop style:position="17.251cm"
								style:type="right" />
						</style:tab-stops>
					</style:paragraph-properties>
				</style:style>				
				<style:style style:name="Footer" style:family="paragraph"
					style:parent-style-name="Standard" style:class="extra">
					<style:paragraph-properties
						text:number-lines="false" text:line-number="0">
						<style:tab-stops>
							<style:tab-stop style:position="8.625cm"
								style:type="center" />
							<style:tab-stop style:position="17.251cm"
								style:type="right" />
						</style:tab-stops>
					</style:paragraph-properties>
				</style:style>				
				<style:style style:name="Graphics" style:family="graphic">
					<style:graphic-properties
						text:anchor-type="paragraph" svg:x="0cm" svg:y="0cm" style:wrap="none"
						style:vertical-pos="top" style:vertical-rel="paragraph"
						style:horizontal-pos="center" style:horizontal-rel="paragraph" />
				</style:style>
				<text:outline-style style:name="Outline">
					<text:outline-level-style text:level="1"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="0.762cm"
								fo:text-indent="-0.762cm" fo:margin-left="0.762cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="2"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="1.016cm"
								fo:text-indent="-1.016cm" fo:margin-left="1.016cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="3"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="1.27cm"
								fo:text-indent="-1.27cm" fo:margin-left="1.27cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="4"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="1.524cm"
								fo:text-indent="-1.524cm" fo:margin-left="1.524cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="5"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="1.778cm"
								fo:text-indent="-1.778cm" fo:margin-left="1.778cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="6"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="2.032cm"
								fo:text-indent="-2.032cm" fo:margin-left="2.032cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="7"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="2.286cm"
								fo:text-indent="-2.286cm" fo:margin-left="2.286cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="8"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="2.54cm"
								fo:text-indent="-2.54cm" fo:margin-left="2.54cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="9"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="2.794cm"
								fo:text-indent="-2.794cm" fo:margin-left="2.794cm" />
						</style:list-level-properties>
					</text:outline-level-style>
					<text:outline-level-style text:level="10"
						style:num-format="">
						<style:list-level-properties
							text:list-level-position-and-space-mode="label-alignment">
							<style:list-level-label-alignment
								text:label-followed-by="listtab" text:list-tab-stop-position="3.048cm"
								fo:text-indent="-3.048cm" fo:margin-left="3.048cm" />
						</style:list-level-properties>
					</text:outline-level-style>
				</text:outline-style>
				<text:notes-configuration text:note-class="footnote"
					style:num-format="1" text:start-value="0" text:footnotes-position="page"
					text:start-numbering-at="document" />
				<text:notes-configuration text:note-class="endnote"
					style:num-format="i" text:start-value="0" />
				<text:linenumbering-configuration
					text:number-lines="false" text:offset="0.499cm" style:num-format="1"
					text:number-position="left" text:increment="5" />
			</office:styles>
			
			<office:automatic-styles>
				<style:style style:name="Tabela21" style:family="table">
					<style:table-properties style:width="17.251cm"
						table:align="margins" style:shadow="none" />
				</style:style>
				<style:style style:name="Tabela21.A" style:family="table-column">
					<style:table-column-properties
						style:column-width="3.528cm" style:rel-column-width="2000*" />
				</style:style>
				<style:style style:name="Tabela21.B" style:family="table-column">
					<style:table-column-properties
						style:column-width="6.593cm" style:rel-column-width="3738*" />
				</style:style>
				<style:style style:name="Tabela21.C" style:family="table-column">
					<style:table-column-properties
						style:column-width="7.13cm" style:rel-column-width="4042*" />
				</style:style>
				<style:style style:name="Tabela21.A1" style:family="table-cell">
					<style:table-cell-properties
						fo:padding="0.097cm" fo:border="none" />
				</style:style>
				<style:style style:name="Tabela21.B1" style:family="table-cell">
					<style:table-cell-properties
						fo:padding="0.097cm" fo:border-left="0.002cm solid #000000"
						fo:border-right="none" fo:border-top="none" fo:border-bottom="none" />
				</style:style>
				<style:style style:name="Tabela21.A2" style:family="table-cell">
					<style:table-cell-properties
						fo:padding="0.097cm" fo:border-left="none" fo:border-right="none"
						fo:border-top="none" fo:border-bottom="0.002cm solid #000000" />
				</style:style>
				<style:style style:name="MP1" style:family="paragraph"
					style:parent-style-name="Header">
					<style:paragraph-properties
						fo:margin-left="3.286cm" fo:margin-right="0cm" fo:text-align="start"
						style:justify-single-word="false" fo:text-indent="0cm"
						style:auto-text-indent="false" />
				</style:style>				
				<style:style style:name="MP3" style:family="paragraph"
					style:parent-style-name="Table_20_Contents">
					<style:paragraph-properties
						fo:text-align="center" style:justify-single-word="false" />
				</style:style>
				<style:style style:name="MT1" style:family="text">
					<style:text-properties style:font-name="Arial"
						fo:font-weight="bold" style:font-weight-asian="bold"
						style:font-weight-complex="bold" />
				</style:style>				
				<style:style style:name="MT3" style:family="text">
					<style:text-properties style:font-name="Arial1"
						fo:font-weight="bold" style:font-weight-asian="bold"
						style:font-weight-complex="bold" />
				</style:style>
				<style:style style:name="Mfr1" style:family="graphic"
					style:parent-style-name="Graphics">
					<style:graphic-properties
						style:run-through="foreground" style:wrap="run-through"
						style:number-wrapped-paragraphs="no-limit" style:vertical-pos="top"
						style:vertical-rel="paragraph" style:horizontal-pos="left"
						style:horizontal-rel="paragraph" style:mirror="none"
						fo:clip="rect(0cm, 0cm, 0cm, 0cm)" draw:luminance="0%"
						draw:contrast="0%" draw:red="0%" draw:green="0%" draw:blue="0%"
						draw:gamma="100%" draw:color-inversion="false" draw:image-opacity="100%"
						draw:color-mode="standard" />
				</style:style>				
				<style:page-layout style:name="Mpm1">
					<style:page-layout-properties
						fo:page-width="21.001cm" fo:page-height="29.7cm" style:num-format="1"
						style:print-orientation="portrait" fo:margin-top="0.97cm"
						fo:margin-bottom="0.61cm" fo:margin-left="1.75cm" fo:margin-right="2cm"
						style:writing-mode="lr-tb" style:footnote-max-height="0cm">
						<style:footnote-sep style:width="0.018cm"
							style:distance-before-sep="0.101cm" style:distance-after-sep="0.101cm"
							style:adjustment="left" style:rel-width="25%" style:color="#000000" />
					</style:page-layout-properties>
					<style:header-style>
						<style:header-footer-properties
							fo:min-height="0cm" fo:margin-bottom="0.499cm" />
					</style:header-style>
					<style:footer-style>
						<style:header-footer-properties
							fo:min-height="0cm" fo:margin-top="0.499cm" />
					</style:footer-style>
				</style:page-layout>				
				<style:style style:name="T1" style:family="text">
					<style:text-properties style:font-name="Arial"
						fo:font-weight="bold" style:font-weight-asian="bold"
						style:font-weight-complex="bold" />
				</style:style>				
				
				<style:style style:name="T3" style:family="text">
					<style:text-properties
						style:font-weight-asian="bold" />
				</style:style>				
				
				<style:style style:name="fr1" style:family="graphic"
					style:parent-style-name="Graphics">
					<style:graphic-properties
						style:run-through="foreground" style:wrap="run-through"
						style:number-wrapped-paragraphs="no-limit" style:vertical-pos="top"
						style:vertical-rel="paragraph" style:horizontal-pos="left"
						style:horizontal-rel="paragraph" style:mirror="none"
						fo:clip="rect(0cm, 0cm, 0cm, 0cm)" draw:luminance="0%"
						draw:contrast="0%" draw:red="0%" draw:green="0%" draw:blue="0%"
						draw:gamma="100%" draw:color-inversion="false" draw:image-opacity="100%"
						draw:color-mode="standard" />
				</style:style>
			</office:automatic-styles>
			<office:master-styles>
				<style:master-page style:name="Standard"
					style:page-layout-name="Mpm1">
					<style:header>
					</style:header>
					<style:footer>

					</style:footer>
				</style:master-page>
			</office:master-styles>


			<office:body>
				<office:text>
						<xsl:call-template name="header" />	
						<xsl:call-template name="total_de_saldos" />
						<xsl:call-template name="disponivel" />
						<xsl:call-template name="bloqueado" />
						<xsl:call-template name="saldo_disponivel_para_investimento" />
						<xsl:call-template name="demonstrativo_de_investimento" />
						<xsl:call-template name="limites_de_credito" />
						<xsl:call-template name="credito_pre_aprovado" />
						<xsl:call-template name="footer" />	
				</office:text>
			</office:body>
		</office:document-content>
	</xsl:template>
	
	
	<xsl:template name="header">
	
		<table:table>		
			<table:table-column table:number-columns-repeated="1" />	

		<!-- Imagem: -->
			<table:table-row>
				<table:table-cell office:value-type="string">					
					<text:p text:style-name="MP1">
						<draw:frame draw:style-name="Mfr1" draw:name="figura2"
							text:anchor-type="paragraph" svg:width="2.831cm" svg:height="2.196cm"
							draw:z-index="1">
							<draw:image xlink:href="Pictures/logo_comprovante.gif"
								xlink:type="simple" xlink:show="embed" xlink:actuate="onLoad" />
						</draw:frame>
						<text:span text:style-name="MT1"><xsl:text>Bradesco Internet Banking</xsl:text></text:span>
					</text:p>
					
				<!-- Linha em Branco -->
					<text:p text:style-name="MP1">
						<text:span text:style-name="MP1" />
					</text:p>
				
				<!-- Titulo: Saldo de Conta Corrente -->
					<text:p text:style-name="MP1">
						<text:span text:style-name="MTP">
							<xsl:value-of select="html/body/div/div/h2" />
						</text:span>
					</text:p>
					
				<!--Descrição dados da conta-->
					<xsl:for-each select="html/body/div/div/ul/li">	
						<text:p text:style-name="MP1">
							<text:span text:style-name="MP1">
								<xsl:value-of select="normalize-space(.)" />
								<xsl:value-of select="'&#x09;'" />
							</text:span>
						</text:p>
					</xsl:for-each>
					
				<!--Agencia/Conta-->
					<text:p text:style-name="MP1">
						<text:span text:style-name="MP1">
							<xsl:value-of select="html/body/div/div/p/strong" />
						</text:span>
					</text:p>
					
				</table:table-cell>
			</table:table-row>
			
		</table:table>
		<text:p text:style-name="Header" />
		<text:p text:style-name="Header" />
	</xsl:template>

	<xsl:template name="total_de_saldos">	
	
		<table:table>		
			<table:table-column table:number-columns-repeated="2" />	

			
		<!-- Total dos Saldos -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/h2" />
					</text:p>
				</table:table-cell>
			</table:table-row>

		<!-- Posição(A+B+C+D) 	194.012.280,00 -->	
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="html/body/div/div[2]/div/div/table/tbody/tr/td[3]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	<xsl:template name="disponivel">
	
		<table:table>
			<table:table-column table:number-columns-repeated="2" />
			
			<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
		
			<!-- Disponível -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/h2[2]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
		
		<!-- Cabeçalho da Tabela: Produto - Saldo -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/thead/tr/th[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/thead/tr/th[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Conta-Corrente		30.000.000,00	 -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Conta-Poupança		8.143.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Conta-Investimento (sem remuneração)		5.000.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Investimento com baixa automática		500.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Total (A)	43.643.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody[2]/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[2]/tbody/tr[4]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="bloqueado">
	
		<table:table>
			<table:table-column table:number-columns-repeated="2" />
			
			<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			
		<!-- Bloqueado -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/h2[3]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Tipo de Saldo - Saldo (R$) -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/thead/tr/th[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/thead/tr/th[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Vinculado do dia		346.000,00 -->		
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		
		<!-- Vinculado do dia Conta de Investimento	0,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Vinculado de dias anteriores		15.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Vinculado do dia anterior Conta de Investimento		0,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Bloqueio Judicial		8.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Total (B)		369.000,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">					
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody[2]/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[3]/tbody[2]/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Linha em branco -->
				<table:table-row>
					<table:table-cell office:value-type="string">
					</table:table-cell>
				</table:table-row>
				
			
		<!-- Investimento sem baixa automática (C)	2.000.000,00 -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Linha em branco -->
				<table:table-row>
					<table:table-cell office:value-type="string">
					</table:table-cell>
				</table:table-row>
		
		<!-- Investimento em carência (D)	148.000.280,00	-->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="saldo_disponivel_para_investimento">
	
		<table:table>
			<table:table-column table:number-columns-repeated="2" />
			
		<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			
		<!-- Saldo Disponível para Investimento -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p> 
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/h2" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Total	 148.003,00 -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[3]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="demonstrativo_de_investimento">
		<table:table>
			<table:table-column table:number-columns-repeated="2" />
			
		<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
				
		<!-- Demonstrativo de Investimentos -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/h2[2]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			
		<!-- Produto	 - Saldo (R$) -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Fundo Vênus		8.003,00 -->		
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- CDB **		40.000,00 -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[2]/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Poupança Integrada	100.000,00 -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[2]/a" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[4]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- ** Investimentos com baixa automática -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[2]/p" />
					</text:p>
				</table:table-cell>			
			</table:table-row>	
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="limites_de_credito">
		
		<table:table>
			<table:table-column table:number-columns-repeated="6" />
			
			<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			
		<!-- Limites de Crédito -->	
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/h2" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Produto Limite Total (R$) Limite Utilizado (R$) Limite a Utilizar (R$) Vencimento Taxas-->		
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[4]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[7]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[10]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[14]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/thead/tr/th[17]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Cheque Especial 1.000,00 0,00 1.000,00 20/05/10 8,36 a.m./162,07 a.a -->		
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[4]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[7]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[10]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[14]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[16]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Crédito Online 1.000,00 0,00 1.000,00 -->
			<table:table-row>	
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[2]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[4]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[7]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[10]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[14]" />
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[15]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="credito_pre_aprovado">
		
		<table:table>
			<table:table-column table:number-columns-repeated="3" />
			
			<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			
		<!-- Credito Pre Aprovado -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/h2[2]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Produto	Limite Pré-Aprovado (R$) Validade -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[2]" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[4]" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/thead/tr/th[8]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<!-- Limite Rotativo Flex PJ 30.000,00 20/05/10 -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[2]/a" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[4]" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr/td[6]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Conta Garantida utilizada 10.000,00 20/05/10 -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[2]/a" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[4]" />					
					</text:p>
				</table:table-cell>
				<table:table-cell office:value-type="string">
					<text:p>
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/table[2]/tbody/tr[2]/td[6]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
	</xsl:template>
	
	
	<xsl:template name="footer">
	
		<table:table>
			<table:table-column table:number-columns-repeated="1" />
			
			<!-- 2 Linhas em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			
		<!-- Sujeito à análise de crédito. Para contratação, dirija-se a sua Agência. -->
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p text:style-name="Table_20_Contents">
						<xsl:value-of select="/html/body/div/div[2]/div/div[3]/p" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		<!-- Linha em branco -->
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
		
		<!-- Os dados acima tem como base 20/05/2009 as 12h43 e estao sujeitos a alteracoes. Os creditos bloqueados nao estao disponiveis para utilizacao. -->	
			<table:table-row>
				<table:table-cell office:value-type="string">
					<text:p text:style-name="Table_20_Contents">
						<xsl:value-of select="/html/body/div/div[2]/p[2]" />					
					</text:p>
				</table:table-cell>
			</table:table-row>
			
		</table:table>
		
		
		<!-- 2 Linhas em branco -->
		<table:table>
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
		</table:table>
			
		<table:table>
			<table:table-column table:number-columns-repeated="1" />
		<!-- Footer -->
			<table:table-row>
			<!-- SAC - Serviço de Apoio ao Cliente -->
				<table:table-cell office:value-type="string">
					<text:p text:style-name="Footer">
						<text:span text:style-name="MT3">
							<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li)" />
						</text:span>
					</text:p>
				</table:table-cell>
			</table:table-row>	
		</table:table>		
		
		<!-- Linha em branco -->
		<table:table>
			<table:table-row>
				<table:table-cell office:value-type="string">
				</table:table-cell>
			</table:table-row>
		</table:table>
				
				
		<table:table table:name="Tabela21" table:style-name="Tabela21">
			<table:table-column table:style-name="Tabela21.A" />
			<table:table-column table:style-name="Tabela21.B" />
			<table:table-column table:style-name="Tabela21.C" />			
			<table:table-row>
				<!-- Alo Bradesco 0800 704 8383-->
				<table:table-cell table:style-name="Tabela21.A1" office:value-type="string">
					<text:p text:style-name="MP3">
						<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[2]/span" />				
					</text:p>
					<text:p text:style-name="MP3">
						 <xsl:value-of select="html/body/div/div/div[2]/div/ul/li[2]/span[2]" />
					</text:p>
				</table:table-cell>
			
			<!-- Deficiente Auditivo ou de Fala 0800 722 0099 -->
				<table:table-cell table:style-name="Tabela21.B1" office:value-type="string">
					<text:p text:style-name="MP3">
						<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[3]/span" />	
					</text:p>
					<text:p text:style-name="MP3">
						<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[3]/span[2]" />		
					</text:p>
				</table:table-cell>
			
			<!-- Cancelamentos, Reclamações e Informações. Atendimento 24 horas por dia, 7 dias por semana. -->
				<table:table-cell table:style-name="Tabela21.B1" office:value-type="string">
					<text:p text:style-name="MP3">
						<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li[4]/p)" />		
					</text:p>
					<text:p text:style-name="MP3">
						<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li[4]/p[2])" />		
					</text:p>
				</table:table-cell>				
			</table:table-row>
			
		</table:table>	
			
		<table:table>
			<table:table-column table:number-columns-repeated="1" />
			<table:table-row>			
			<!-- Ouvidoria 0800 727 9933 Atendimento de segunda a sexta-feira das 8h às 18h, exceto feriados. -->
				<table:table-cell table:style-name="Tabela21.A2" office:value-type="string">
					<text:p text:style-name="Table_20_Contents">
						<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li" />
						<xsl:value-of select="'&#x09;'" />
						<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li[2]" />
						<xsl:value-of select="'&#x09;'" />
						<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li[3]" />
					</text:p>
				</table:table-cell>
			</table:table-row>
			
			<table:table-row>	
			<!-- Demais telefones consulte o site Fale Conosco -->
				<table:table-cell table:style-name="Tabela21.A1" office:value-type="string">
					<text:p text:style-name="Table_20_Contents">
						<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div[2]/p)" />	
					</text:p>
				</table:table-cell>
			</table:table-row>
		</table:table>
		<text:p text:style-name="Footer" />	
	</xsl:template>
	
</xsl:stylesheet>