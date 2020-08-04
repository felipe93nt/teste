<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : SALDO_XLS.xsl
    Created on : 19 de Setembro de 2010, 17:04
    Author     : Scopus
    Description:
       XSL para arquivos XSL
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
			<office:body>
				<office:spreadsheet>
					<table:table table:name="NPCC_TRADE">	
							<!-- Title -->
							<table:table-row>
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										<xsl:value-of select="/html/body/span[1]" />									
									</text:p>
								</table:table-cell>
							</table:table-row>
							<!-- End Title -->
							
							<!-- Empty Row -->
							<table:table-row>								
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										
									</text:p>
								</table:table-cell>								
							</table:table-row>
							<!-- End Empty Row -->
							
							<xsl:if test="/html/body/span[2]">
							<!-- Title -->
							<table:table-row>
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										<xsl:value-of select="/html/body/span[2]" />									
									</text:p>
								</table:table-cell>
							</table:table-row>
							<!-- End Title -->
							
							<!-- Empty Row -->
							<table:table-row>								
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										
									</text:p>
								</table:table-cell>								
							</table:table-row>
							<!-- End Empty Row -->
							
							</xsl:if>
							
							<!-- Header -->
							<table:table-row>
								<xsl:for-each select="/html/body/table[1]/thead/tr/th">
									<table:table-column />
									<table:table-cell office:value-type="string">
										<text:p>
											<xsl:value-of select="label" />									
										</text:p>
									</table:table-cell>
				                </xsl:for-each>								
							</table:table-row>
							<!-- End Header -->
							
							<!-- Body -->
							<xsl:for-each select="/html/body/table[1]/tbody/tr">
								<table:table-row>
									<!-- For Each -->
									<xsl:for-each select="td">
										<table:table-column />
										<table:table-cell office:value-type="string">
											<text:p>
												<xsl:value-of select="label" />							
											</text:p>
										</table:table-cell>
									</xsl:for-each>
									<!-- End For Each -->
								</table:table-row>
			                </xsl:for-each>	
							<!-- End Body -->
							
							<xsl:if test="/html/body/table[2]">
								<!-- Header -->
							<table:table-row>
								<xsl:for-each select="/html/body/table[2]/thead/tr/th">
									<table:table-column />
									<table:table-cell office:value-type="string">
										<text:p>
											<xsl:value-of select="label" />									
										</text:p>
									</table:table-cell>
				                </xsl:for-each>								
							</table:table-row>
							<!-- End Header -->
							
							<!-- Body -->
							<xsl:for-each select="/html/body/table[2]/tbody/tr">
								<table:table-row>
									<!-- For Each -->
									<xsl:for-each select="td">
										<table:table-column />
										<table:table-cell office:value-type="string">
											<text:p>
												<xsl:value-of select="label" />							
											</text:p>
										</table:table-cell>
									</xsl:for-each>
									<!-- End For Each -->
								</table:table-row>
			                </xsl:for-each>	
							<!-- End Body -->
							</xsl:if>
							
							<!-- Empty Row -->
							<table:table-row>								
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										
									</text:p>
								</table:table-cell>								
							</table:table-row>
							<!-- End Empty Row -->
							
							<xsl:if test="/html/body/span[3]">
							<!-- Title -->
							<table:table-row>
								<table:table-column />
								<table:table-cell office:value-type="string">
									<text:p>
										<xsl:value-of select="/html/body/span[3]" />									
									</text:p>
								</table:table-cell>
							</table:table-row>
							<!-- End Title -->
							
							</xsl:if>
							
							<xsl:if test="/html/body/table[3]">
								<!-- Header -->
							<table:table-row>
								<xsl:for-each select="/html/body/table[3]/thead/tr/th">
									<table:table-column />
									<table:table-cell office:value-type="string">
										<text:p>
											<xsl:value-of select="label" />									
										</text:p>
									</table:table-cell>
				                </xsl:for-each>								
							</table:table-row>
							<!-- End Header -->
							
							<!-- Body -->
							<xsl:for-each select="/html/body/table[3]/tbody/tr">
								<table:table-row>
									<!-- For Each -->
									<xsl:for-each select="td">
										<table:table-column />
										<table:table-cell office:value-type="string">
											<text:p>
												<xsl:value-of select="label" />							
											</text:p>
										</table:table-cell>
									</xsl:for-each>
									<!-- End For Each -->
								</table:table-row>
			                </xsl:for-each>	
							<!-- End Body -->
							</xsl:if>
							
							<xsl:if test="/html/body/table[4]">
								<!-- Header -->
							<table:table-row>
								<xsl:for-each select="/html/body/table[4]/thead/tr/th">
									<table:table-column />
									<table:table-cell office:value-type="string">
										<text:p>
											<xsl:value-of select="label" />									
										</text:p>
									</table:table-cell>
				                </xsl:for-each>								
							</table:table-row>
							<!-- End Header -->
							
							<!-- Body -->
							<xsl:for-each select="/html/body/table[4]/tbody/tr">
								<table:table-row>
									<!-- For Each -->
									<xsl:for-each select="td">
										<table:table-column />
										<table:table-cell office:value-type="string">
											<text:p>
												<xsl:value-of select="label" />							
											</text:p>
										</table:table-cell>
									</xsl:for-each>
									<!-- End For Each -->
								</table:table-row>
			                </xsl:for-each>	
							<!-- End Body -->
							</xsl:if>
							
					</table:table>	
				</office:spreadsheet>
			</office:body>
		</office:document-content>
	</xsl:template>
</xsl:stylesheet>