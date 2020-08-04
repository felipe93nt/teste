<?xml version="1.0" encoding="ISO-8859-1" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" />
<xsl:template match="/*">
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<fo:layout-master-set>
		<fo:simple-page-master margin-right="0" margin-left="0"
					margin-bottom="2cm" margin-top="0" page-width="31cm"
					page-height="29.7cm" master-name="paginaDefault">
					<fo:region-body margin-top="0.5cm" />
					<fo:region-before extent="0.5cm" />
					<fo:region-after extent="1.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
		<fo:page-sequence master-reference="paginaDefault">
			<fo:flow flow-name="xsl-region-body" line-height="8pt"
					font-size="8pt" text-align="center">
			 	<fo:block>
						<xsl:call-template name="content" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	
 <xsl:template name="content">
	
	<!--Titulo-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<xsl:value-of select="body/div/div/h2" />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Descrição dados da conta-->
	<fo:table>
		<fo:table-body>	
		
			<xsl:for-each select="body/div/div/ul/li">
				<fo:table-row>
					<fo:table-cell number-columns-spanned="2">
							<fo:block text-align="left">
								<xsl:value-of select="."></xsl:value-of>
								<xsl:value-of select="'&#x09;'" />
							</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</xsl:for-each>	
		
		<!-- INICIO QUEBRA 2 LINHAS -->
			<fo:table-row>
				<fo:table-cell>
					<fo:block>
						<fo:leader />
					</fo:block>
					<fo:block>
						<fo:leader />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		<!-- FIM QUEBRA 2 LINHAS -->	
			
		</fo:table-body>
	</fo:table>
	
	
	<!--Agencia/Conta-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<xsl:value-of select="body/div/div/p/strong" />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>

	
	
	<!-- Titulo da Tabela - Total de Saldos-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<xsl:value-of select="body/div/div/div/div/h2" />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha 1 da tabela: 	 Posição(A+B+C+D)	 194.012.280,00 -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="1">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="1">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table/tbody/tr/td[3]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Disponível -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/h2[2]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Cabeçalho da Tabela: Produto - Saldo -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table/thead/tr/th[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table/thead/tr/th[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 1: 	Conta-Corrente		30.000.000,00	 -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Segunda linha da tabela 1: 		Conta-Poupança		8.143.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[2]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[2]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Terceira linha da tabela 1: Conta-Investimento (sem remuneração)		5.000.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[3]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[3]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Quarta linha da tabela 1: Investimento com baixa automática		500.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[4]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody/tr[4]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	
	<!-- Quinta linha da tabela 1: 	Total (A)		43.643.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody[2]/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[2]/tbody[2]/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 3 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Bloqueado -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/h2[3]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Cabeçalho da Tabela 2: 	Tipo de Saldo - Saldo (R$)	 -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/thead/tr/th[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/thead/tr/th[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 2: 	Vinculado do dia		346.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Segunda linha da tabela 2:	Vinculado do dia Conta de Investimento		0,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[2]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[2]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Terceira linha da tabela 2: 	Vinculado de dias anteriores		15.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[3]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[3]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Quarta linha da tabela 2:	Vinculado do dia anterior Conta de Investimento		0,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[4]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[4]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Quinta linha da tabela 2:	Bloqueio Judicial		8.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[5]/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody/tr[5]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	
	<!-- Sexta linha da tabela 2: 	Total (B)		369.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody[2]/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[3]/tbody[2]/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	
	<!-- Primeira linha da tabela 3: 	Investimento sem baixa automática (C)		2.000.000,00 -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[4]/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[4]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 4: 	Investimento em carência (D)		148.000.280,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[5]/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div/table[5]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Saldo Disponível para Investimento -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/h2" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 5: 	 Total	 148.003,00		-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table/tbody/tr/td[3]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Demonstrativo de Investimentos -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/h2[2]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Cabeçalho da Tabela 6: 	Produto	 - Saldo (R$)	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table/thead/tr/th[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table/thead/tr/th[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 6: 	Fundo Vênus		8.003,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr/td[2]/a" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Segunda linha da tabela 6: CDB **		40.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[2]/a" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Terceira linha da tabela 6: Poupança Integrada		100.000,00		-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[2]/a" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[4]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- ** Investimentos com baixa automática	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[2]/p" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Limites de Crédito-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/h2" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Cabeçalho da Tabela 7:  Produto Limite Total (R$) Limite Utilizado (R$) Limite a Utilizar (R$) Vencimento Taxas -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[7]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[10]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[14]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/thead/tr/th[17]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da tabela 6: Cheque Especial 1.000,00 0,00 1.000,00 20/05/10 8,36 a.m./162,07 a.a.-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[7]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[10]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[14]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody/tr/td[16]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Segunda linha da tabela 6:  Crédito Online 1.000,00 0,00 1.000,00	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[7]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[10]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[14]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table/tbody[2]/tr/td[16]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Limites de Crédito-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/h2[2]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Cabeçalho da Tabela 8: Produto	Limite Pré-Aprovado (R$) Validade	-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/thead/tr/th[2]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/thead/tr/th[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/thead/tr/th[8]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Primeira linha da Tabela 8: 30.000,00 20/05/10-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr/td[2]/a" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr/td[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr/td[6]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Segunda linha da Tabela 8: 10.000,00 20/05/10-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[2]/a" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[4]" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[6]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Sujeito à análise de crédito. Para contratação, dirija-se a sua Agência.-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="4">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div/div[3]/p" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	
	<!--Linha em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
	
	<!-- Os dados acima tem como base 20/05/2009 as 12h43 e estao sujeitos a alteracoes. Os creditos bloqueados nao estao disponiveis para utilizacao..-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="4">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/p[2]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
		
	<!-- 2 Linhas em branco-->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left">
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
						<fo:block text-align="left" >
							<fo:leader />
						</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>		
	</fo:table>
		
	<!-- SAC - Serviço de Apoio ao Cliente -->
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>
	</fo:table>
		
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
			<!-- Alo Bradesco  0800 704 8383 -->	
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[2]/span" />
					</fo:block>
				</fo:table-cell>
			<!-- Deficiente Auditivo ou de Fala 0800 722 0099 -->	
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[3]/span" />
					</fo:block>
				</fo:table-cell>
			<!-- Cancelamentos, Reclama??es e Informa??es. Atendimento 24 horas, 7 dias por semana. -->
				<fo:table-cell number-columns-spanned="3">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[4]/p" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>
	</fo:table>
	<fo:table>
		<fo:table-body>	
			<fo:table-row>
			<!-- Alo Bradesco  0800 704 8383 -->	
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[2]/span[2]" />
					</fo:block>
				</fo:table-cell>
			<!-- Deficiente Auditivo ou de Fala 0800 722 0099 -->	
				<fo:table-cell number-columns-spanned="2">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[3]/span[2]" />
					</fo:block>
				</fo:table-cell>
			<!-- Cancelamentos, Reclama??es e Informa??es. Atendimento 24 horas, 7 dias por semana. -->
				<fo:table-cell number-columns-spanned="3">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul/li[4]/p[2]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>
	</fo:table>
	
	<!-- Ouvidoria 0800 727 9933 Atendimento de segunda a sexta-feira, das 8h as 18h, exceto feriados -->	
	<fo:table>
		<fo:table-body>	
			<fo:table-row>	
				<fo:table-cell number-columns-spanned="3">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div/ul[2]/li" />
						<xsl:value-of select="'&#x09;'" />
						<xsl:value-of select="body/div/div/div[2]/div/ul[2]/li[2]" />
						<xsl:value-of select="'&#x09;'" />
						<xsl:value-of select="body/div/div/div[2]/div/ul[2]/li[3]" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>

		<fo:table-body>	
			<fo:table-row>	
				<fo:table-cell number-columns-spanned="3">
					<fo:block text-align="left">
						<xsl:value-of select="body/div/div/div[2]/div[2]/p" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</fo:table-body>
	</fo:table>
	 
</xsl:template>
</xsl:stylesheet>