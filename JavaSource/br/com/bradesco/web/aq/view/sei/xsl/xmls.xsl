<xsl:stylesheet version="1.0"
	xmlns="urn:schemas-microsoft-com:office:spreadsheet" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:msxsl="urn:schemas-microsoft-com:xslt" xmlns:user="urn:my-scripts"
	xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel"
	xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet">

	<xsl:strip-space elements="*" />
	<xsl:decimal-format name="brazil" decimal-separator=","
		grouping-separator="." />
	<xsl:output method="xml" encoding="UTF-8" indent="yes" />
	<xsl:template match="/">
		<xsl:processing-instruction name="mso-application">
			progid="Excel.Sheet"
		</xsl:processing-instruction>
		<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
			xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel"
			xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:html="http://www.w3.org/TR/REC-html40">
			<Styles>
				<Style ss:ID="Default" ss:Name="Normal">
					<Alignment ss:Vertical="Bottom" />
					<Borders />
					<Font />
					<Interior />
					<NumberFormat />
					<Protection />
				</Style>
				<Style ss:ID="negrito">
					<Alignment ss:Horizontal="Left" ss:Vertical="Bottom"
						ss:WrapText="1" />
					<Font x:Family="Swiss" ss:Bold="1" />
				</Style>
			</Styles>

			<Worksheet ss:Name="Saldo">
				<Table ss:ExpandedColumnCount="6" x:FullColumns="1"
					x:FullRows="1">
					<Column ss:AutoFitWidth="0" ss:Width="100" />
					<Column ss:AutoFitWidth="0" ss:Width="100" />
					<Column ss:AutoFitWidth="0" ss:Width="100" />
					<Column ss:AutoFitWidth="0" ss:Width="100" />
					<Column ss:AutoFitWidth="0" ss:Width="100" />
					<Row>
						<Cell ss:StyleID="negrito" ss:MergeAcross="2">
							<ss:Data ss:Type="String">Bradesco Internet Banking</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:MergeAcross="2">
							<ss:Data ss:Type="String">
								<xsl:value-of select="/html/body/div/div/ul/li[3]" />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:MergeAcross="2">
							<ss:Data ss:Type="String">

							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Agência | Conta</xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Disponível (R$) (A)</xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Bloqueado (R$) (B)</xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Investimentos (R$) (C + D)</xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Total (R$) (A + B + C + D)</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='substring(/html/body/div/div[2]/p, 10)' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody[2]/tr/td[4]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody[2]/tr/td[4]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[3]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr/td[3])' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='/html/body/div/div[2]/div/div/h2' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table/tbody/tr/td[3])' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>A - Disponível</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/thead/tr/th[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/thead/tr/th[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/thead/tr/th[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody/tr[2]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[2]/a)' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody/tr[3]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[2]/tbody[2]/tr/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[2]/tbody[2]/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>B - Bloqueado</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody/tr[2]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody/tr[3]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody/tr[4]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[3]/tbody/tr[5]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>C e D - Investimentos</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[4]/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div/table[5]/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Saldo total para investimento</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table/tbody/tr/td[3]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div[2]/h2[2])' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/thead/tr/th[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[2]/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[2]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[2])' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[4]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text>Crédito Global</xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[4]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[7]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[10]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[14]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/thead/tr/th[17]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[4]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[7]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[10]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[14]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody/tr/td[16]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[4]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[7]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div/div[3]/table/tbody[2]/tr/td[10]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:text></xsl:text>
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="negrito" ss:MergeAcross="2">
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div[2]/div/ul/li)' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='/html/body/div/div[2]/div[2]/div/ul/li[2]/span' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='/html/body/div/div[2]/div[2]/div/ul/li[3]/span' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div[2]/div/ul/li[4]/p)' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div[2]/div/ul/li[2]/span[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='/html/body/div/div[2]/div[2]/div/ul/li[3]/span[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='/html/body/div/div[2]/div[2]/div/ul/li[4]/p[2]' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of select='/html/body/div/div[2]/div[2]/div/ul[2]/li' />
								<xsl:text> </xsl:text>
								<xsl:value-of select='/html/body/div/div[2]/div[2]/div/ul[2]/li[2]' />
							</ss:Data>
						</Cell>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div[2]/div/ul[2]/li[3])' />
							</ss:Data>
						</Cell>
					</Row>
					<Row>
						<Cell>
							<ss:Data ss:Type="String">
								<xsl:value-of
									select='normalize-space(/html/body/div/div[2]/div[2]/div[2]/p)' />
							</ss:Data>
						</Cell>
					</Row>
				</Table>
			</Worksheet>
		</Workbook>
	</xsl:template>
</xsl:stylesheet>