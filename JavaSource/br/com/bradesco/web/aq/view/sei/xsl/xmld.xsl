<?xml version="1.0" encoding="ISO-8859-1" ?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:w="http://schemas.microsoft.com/office/word/2003/wordml"
	xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w10="urn:schemas-microsoft-com:office:word"
	xmlns:wx="http://schemas.microsoft.com/office/word/2003/auxHint" xmlns:o="urn:schemas-microsoft-com:office:office"  
	xmlns:doc="http://www.oasis-open.org/docbook/xml/4.0" xmlns:wsp="http://schemas.microsoft.com/office/word/2003/wordml/sp2"
	exclude-result-prefixes="doc" >
	
	<xsl:preserve-space elements="*" />
	<xsl:output method="xml" indent="yes" encoding="UTF-8" />
	<xsl:decimal-format name="brazil" decimal-separator=","
		grouping-separator="." />
	<doc:reference>
		<title>Extratos</title>
	</doc:reference>
	<xsl:template match="/">
		<xsl:processing-instruction name="mso-application">
			<xsl:text>progid="Word.Document"</xsl:text>
		</xsl:processing-instruction>
		<xsl:text></xsl:text>
		<w:wordDocument xmlns:w="http://schemas.microsoft.com/office/word/2003/wordml">
			<w:body>			
				<xsl:call-template name="content" />
			</w:body>
		</w:wordDocument>
	</xsl:template>
	
	<xsl:template name="content">
	
	<!-- Imagem cabeçalho -->
		<w:p>
			<w:r>
				<w:pict>
					
<w:binData w:name="wordml://01000001.gif">
R0lGODlhawBTAOYAAE1OU4yMkMoAJGZmZtbW18UAEdQxUuR9kurq68TFxry8voKDhq2tr1VWWtpM
aN7e3/Pz9M0OM+yhr3R1eZ2eoczMzN9ke+bm5/PGz/G/yVBRVumWpswAM88bPl5fY7Cxs////5mZ
mdhCXoiJjPbU225vc/ro7Hl6faSlp/3z9e+0v+BrgoaGiswGLLa3udIlRt1bdFpbYMgAIWZmZu/v
70pSUmxtceeKnHx9gZmZmd7e5vng5lJTWNna2+qbq+JyiM4SN9U3Uaioq8wJMNhJZa+wsr/Awt5S
c7S1t+2qtvXP18sBKXFxdfT09IqLjllaXv/m7+aUrXN7e88ZPLW9vd7m5uWBlNAfQv73+eN3jN5r
e/C4w9MpStZKa9tSbfnj6Nbe3vfe3t5jc/fFzvvt8MkBJn+AhKCho8cAGe2ntdc7WdhDYOFwhuue
reuYqOR5jv///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH5
BAEHAHAALAAAAABrAFMAAAf/gHCCg4SFhoeGQ4qLjI2Oj5BDiJOUlZaXh5Gam4+Ynp+giJyjnKGm
p5ekqpCora6Eqksys7Mtqq+4qKMCaBFqRMBctaO5xaCcAmppSl8pziZKb0MypcbWlptANyYg3RkS
4FtYYWsCm9fok5oRKt0mWS9AERGKUyskXmWa6fyFkAICrHRL4aPgDQswuMQTAGTNFFus+kl0JKBF
kBUpQKQg4ywFlm4gsKiA8QLgPon9HK250a6bBWDAHPzwkeEjCDIHhEVCmZJRBAtWXmQAoYKW0QJD
HGzrFsYBtU480zmSUSCCEhAWIC1BgybIhoH5oEa99kiGmi8gDECEhEYGm487/zqsXTQW3aMyV0iA
uDL3kawDHw88ZVSXrKMlLTCAeNF3SIvHjbi1GUy3sDG2aUBwaQxEHiMZO0C4oazI8uWyXkCsmLtk
jYQ0FswpAsItbCPTxSLJyJBhCSMBK7pJeIpGYBLfjnDnilRGjQk1j2VwtfBxdAs0MIhGaCxJ+StN
AsR48U2EDRAY1dGUYUPCyhDkyb272sTwcZK0XqrLaEFEjfqd8rWiyn0G5CcaNSadFOApA+KnHykL
6kIKgQaOBmGEpjRY4IPEYBiKhhWSBqCHn4DIYTUkeqJKOwZkB8JwF6aIiSoHYPCCCFtk8INsKMqI
DSlAXDFPBx0AwZ1YPlayCv9ySzR5S5I/riJlaVAqOeWUVVp55SpZdunll2CGKeaYZF4CAQEVpFlB
D6/QkCYCZQ5CgAcA1FmnBwS0UkGdSMQpyJwAeGADnQBMQAMqewLQp5+AngFHDyfUySYBeT6gwAVw
PJCAAgrkScimPVTAg6JycuqpIAhwaoQOhFTAaQWDILCpEQ/UBegHgowAwBMXIBBDDBQMAAADcNhg
pwZCDKIrAA2Y8QSpcKBwbLKZlmCnDU3AAcECdgIAawLG3rkoT4CWEMICGgBAQaaj2mkEHCcEQEG4
sEpbZwMApOsCHArU6UQAdeaJAwA2oLDAAoKYUecTAwzwQA+jNjBCDHXCSi7/oXaeIMgDz/LwAQEQ
ENIDxQrAIWwDFTwAMAD7CouDIE4AEAINwmosZ50TPHABpgA/UXIFdNqMEqBMnMtDDE5AcMGzLw8i
BBM22JDuGRAIizAcie6b7gAUhGCtxrryMMAItUrbwLuDCFvCIJF6EBWgKAjCQMAIPLuuICufcEK6
Mxs7giBZwzGqBg3wwEMDL19gBr7MPiDtE6fCgS8TbAMQw9t0xg3H3N4igO/dD9C57wUUh1AsAAMI
8kGd+9I5wQU6VEEAq4OEoG+/6hKi8ABwNmGsDZgDYAYDZrTbg+e5Z0pnCASEUKfpMQPAghDpsgzH
Gcwy0EMP1CqQAAEf4GsE/w3PyuzCvi74S0D01A5dfbeOPvD8INzaSWcAytvZQLpFaDtBtwCAU/3u
hCkFMK5O72IBAJvGkwsEgAUQdAIFSgYHBDyQgnC4QAjilQAkLGBfcCDACCYQggoYzGI0oIAZTrCA
u1UgABM4QQjYJIgEhIAJHJQbC1iouSSFDBGHmsQPCUGDIRICAUYURBL9xMQmOvGJUIyiFKdIxVBA
8IpYzKIWt8jFLnrxi2AMIxerSMYymvGMaEyjGsl4gSDK5wKUIkCtQBE5wGXLFU7AoCFo4MZcQABO
hajCAGzABCYMgAWfQIANAImqBtTRFBPAFSICgLZiUIBYhRCVHB9AgAFU0v8SdWPkxnBxgkUZ4YFn
gNMHPMCCD9AwAQGYoSB0IAQWEOuULDgDpuS2ABQcygg2OMEHLAa41CmLWhU4ly8BFwIWhKBWCPDA
oRBQBDYt04YsoMAu4ZAABrggALybRCn51QAKFGEBE4BAAJ5QAjMkAA4fYEIFVvlOvaEgTeX8wALW
BoeDEWBeCDiDBwZghnGF0ANIhMADbFCFEDLhDEg4gRPYFQIkBAChNPBAtnCASDgglAA8CMEHRpC6
C4xNASNowDvF2ScGUE4QHngABHAAQpN5SoVwKMFKP8BPk4XKmHCYQMkC0MNB9KBQJ8BBDK5GiAdc
bk6DsIECEDCAC+xwEAj/TQBQB+Aq4AlCqpQYp0vT9gAajDOEMWCAEPSpMSbstKcDIIAQBqCAtT4U
DgFwVCFAaoQEJOADNqChXIVAgSccdBBMUAANYhCAGJgBq7ICqg0q0EnKKgBPYW3pS01W1hNQ0HMo
EAIKGJAnG7w1bQRAAg+QIAQhuIBn7RtEBYAarYkCLQBCCIFhoSqIEihWej14AgizulVYFaEBARjB
Slm6uc06LKh3gwMTQKi0Yp1WEA7rQUwFcYGQjWCimdSosvA3go424alu661iHQmHEHiVuGmDVSdp
1cdD2IBYKEgvHDSQp/QNgFgEKMEg7wuHGFBQCJcTBH/hOdASTABWFdAAhtdEhrqGDaAEmErAE0IA
wwZ8DABY/QACABCyESdLAxcw4CBUCoEJTKBrONArIh4AJwTQMISyTQDtLuBXAhyqB0G0sZzu2AO/
zjGECbjxn/zqV0YSgAEKWFOeTgVkHAuiB6zKEw1u3AMIaBUORaxADOq7xkKELgQdPEF0y4wIBDDg
ksQcRCAAADs=
</w:binData>
					<v:shape id="_x0000_s1026" type="#_x0000_t75"
						style="position:absolute;margin-left:0;margin-top:0;width:80.25pt;height:62.25pt;z-index:1;mso-position-horizontal:left">
						<v:imagedata src="wordml://01000001.gif" o:title="logo_comprovante" />
						<w10:wrap type="square" side="right" />
					</v:shape>
				</w:pict>
			</w:r>
			<w:r wsp:rsidRPr="002137C5">
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
				<!-- Titulo: Saldo de Conta Corrente -->
					<xsl:value-of select="html/body/div/div/h2" />
				</w:t>
			</w:r>
		</w:p>
	
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!--Descrição dados da conta-->	
		<xsl:for-each select="html/body/div/div/ul/li">
			<w:p>
				<w:r>
					<w:rPr>
						<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
						<wx:font wx:val="Arial" />
						<w:sz w:val="18" />
						<w:sz-cs w:val="18" />
						<w:lang w:val="PT-BR" />
					</w:rPr>
				
					<w:t>
						<xsl:value-of select="normalize-space(.)" />
						<xsl:value-of select="'&#x09;'" />
					</w:t>
				</w:r>
			</w:p>
		</xsl:for-each>	
		
	<!--Agencia/Conta-->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="html/body/div/div/p/strong" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--2 Linhas em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Titulo da Tabela - Total de Saldos-->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="html/body/div/div/div/div/h2" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 1 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			
		<!--Linha 1: 	 Posição(A+B+C+D)	 194.012.280,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Posição(A+B+C+D) -->
								<xsl:value-of select="html/body/div/div/div/div/table/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 194.012.280,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table/tbody/tr/td[3]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Disponivel-->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="html/body/div/div/div/div/h2[2]" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 2 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			
			<!-- Cabeçalho: Produto - Saldo -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
						<w:b />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Produto -->
								<xsl:value-of select="html/body/div/div/div/div/table/thead/tr/th[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Cabeçalho da Tabela: Saldo -->
								<xsl:value-of select="html/body/div/div/div/div/table/thead/tr/th[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!--Linha 1 da tabela: 	 Conta-Corrente		30.000.000,00-->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Conta-Corrente -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 30.000.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!--Linha 2 da tabela: 	Conta-Poupança		8.143.000,00-->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Conta-Poupança -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr[2]/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 8.143.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr[2]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!--Linha 3 da tabela: 	Conta-Investimento (sem remuneração) 5.000.000,00-->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Conta-Investimento (sem remuneração) -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[2]/tbody/tr[3]/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 5.000.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr[3]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!--Linha 4 da tabela: 	Investimento com baixa automática		500.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Investimento com baixa automática -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[2]/tbody/tr[4]/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 500.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody/tr[4]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!--Linha 5 da tabela: 	Total (A)		43.643.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Total (A)		 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody[2]/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 43.643.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[2]/tbody[2]/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Bloqueado -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="html/body/div/div/div/div/h2[3]" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 3 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			
			<!-- Cabeçalho: 	Tipo de Saldo - Saldo (R$)	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Tipo de Saldo -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/thead/tr/th[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Saldo (R$) -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/thead/tr/th[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 1: 	Vinculado do dia - 346.000,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Vinculado do dia -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 346.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 2: 	Vinculado do dia Conta de Investimento		0,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Vinculado do dia Conta de Investimento -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[3]/tbody/tr[2]/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 0,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr[2]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 3: 	Vinculado de dias anteriores		15.000,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Vinculado de dias anteriores -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[3]/tbody/tr[3]/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 15.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr[3]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 4: Vinculado do dia anterior Conta de Investimento		0,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Vinculado do dia anterior Conta de Investimento -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[3]/tbody/tr[4]/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 0,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr[4]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 5: Bloqueio Judicial		8.000,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Bloqueio Judicial -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr[5]/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 8.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody/tr[5]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 6: Total (B)		369.000,00	 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Total (B) -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody[2]/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 369.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[3]/tbody[2]/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		</w:tbl>
		
		<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 4 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="2500" />
			</w:tblGrid>
			
		<!--Linha 1: Investimento sem baixa automática (C)		2.000.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Investimento sem baixa automática (C) -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div/table[4]/tbody/tr/td[2])" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- 2.000.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[4]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 5 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="2500" />
			</w:tblGrid>
			
			<!--Linha 1: Investimento em carência (D)		148.000.280,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Investimento em carência (D) -->
								<xsl:value-of select="html/body/div/div/div/div/table[5]/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 148.000.280,00 -->
								<xsl:value-of select="html/body/div/div/div/div/table[5]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Saldo Disponível para Investimento -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="normalize-space(html/body/div/div/div/div[2]/h2)" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 6 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="2500" />
			</w:tblGrid>
			
			<!--Linha 1: Total	 148.003,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Total -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 148.003,00 -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table/tbody/tr/td[3]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Demonstrativo de Investimentos -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="normalize-space(html/body/div/div/div/div[2]/h2[2])" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 7 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			
		<!-- Cabeçalho: 	Produto	 - Saldo (R$) -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Produto -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table/thead/tr/th[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Saldo (R$) -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table/thead/tr/th[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 1: 	Fundo Vênus		8.003,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Fundo Vênus -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table[2]/tbody/tr/td[2]/a" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 8.003,00 -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table[2]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 2: 	CDB **		40.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- CDB ** -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[2]/a" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 40.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 3: Poupança Integrada	100.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Poupança Integrada -->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[2]/a)" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 100.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 4: ** Investimentos com baixa automática -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="5000" w:type="pct" />
						<w:gridSpan w:val="4" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="00DF7225"
						wsp:rsidRDefault="00DF7225">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="00DF7225">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- ** Investimentos com baixa automática-->
								<xsl:value-of select="normalize-space(html/body/div/div/div/div[2]/p)" />
							</w:t>
						</w:r>						
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Limites de Crédito -->	
		<w:p>
			<w:r>
			<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="html/body/div/div/div/div[3]/h2" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Tabela 8 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="2500" />
			</w:tblGrid>
			
		<!--Cabeçalho:  Produto Limite Total (R$) Limite Utilizado (R$) Limite a Utilizar (R$) Vencimento Taxas-->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1300" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Produto -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Limite Total (R$) -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!--Limite Utilizado (R$) -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[7]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Limite a Utilizar (R$) -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[10]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Vencimento -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[14]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="840" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Taxas -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/thead/tr/th[17]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		<!-- Linha 1:  Cheque Especial 1.000,00 0,00 1.000,00 20/05/10 8,36 a.m./162,07 a.a -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1300" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Cheque Especial -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 1.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 0,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[7]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 1.000,00  -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[10]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 20/05/10 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[14]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="840" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 8,36 a.m./162,07 a.a. -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody/tr/td[16]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 2:  Crédito Online 1.000,00 0,00 1.000,00 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1300" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Crédito Online  -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 1.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 0,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[7]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 1.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[10]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="715" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- "  " -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[14]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="840" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- "  " -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table/tbody[2]/tr/td[16]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Credito Pre Aprovado -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:b />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="normalize-space(html/body/div/div/div/div[3]/h2[2])" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
		<!-- Tabela 9 -->
		<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="tabela1" />
				<w:tblW w:w="3000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="5000" />
			</w:tblGrid>
			
		<!-- Cabeçalho:  Produto	Limite Pré-Aprovado (R$) Validade -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Produto	 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/thead/tr/th[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Limite Pré-Aprovado (R$) -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/thead/tr/th[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Validade -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/thead/tr/th[8]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 1:  Limite Rotativo Flex PJ 30.000,00 20/05/10 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Limite Rotativo Flex PJ -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr/td[2]/a" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 30.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 20/05/10 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr/td[6]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			
		<!-- Linha 2:  Conta Garantida utilizada 10.000,00 20/05/10 -->
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2000" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Conta Garantida utilizada-->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[2]/a" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 10.000,00 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[4]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1500" w:type="pct" />
						<w:gridSpan w:val="2" />
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 20/05/10 -->
								<xsl:value-of select="html/body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[6]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
		
	<!-- 2 Linhas em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		
	<!-- Sujeito à análise de crédito. Para contratação, dirija-se a sua Agência. -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="normalize-space(html/body/div/div/div/div[3]/p)" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--Linha em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
	
	<!-- Os dados acima tem como base 20/05/2009 as 12h43 e estao sujeitos a alteracoes. Os creditos bloqueados nao estao disponiveis para utilizacao. -->	
		<w:p>
			<w:r>
				<w:rPr>
					<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
					<wx:font wx:val="Arial" />
					<w:sz w:val="18" />
					<w:sz-cs w:val="18" />
					<w:lang w:val="PT-BR" />
				</w:rPr>
				<w:t>
					<xsl:value-of select="normalize-space(html/body/div/div/p[2])" />
				</w:t>
			</w:r>
		</w:p>
		
	<!--3 Linhas em branco-->
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
		<w:p>
			<w:r>
				<w:t>
				</w:t>
			</w:r>
		</w:p>
	
	<!--Rodape-->
	<w:tbl>
			<w:tblPr>
				<w:tblStyle w:val="rodape" />
				<w:tblW w:w="5000" w:type="pct" />
				<w:tblLook w:val="01E0" />
			</w:tblPr>
			<w:tblGrid>
				<w:gridCol w:w="1959" />
				<w:gridCol w:w="1598" />
				<w:gridCol w:w="1822" />
				<w:gridCol w:w="5841" />
			</w:tblGrid>
			<w:tr wsp:rsidR="002137C5" wsp:rsidTr="00DF7225">
				<w:trPr>
					<w:trHeight w:val="261" />
				</w:trPr>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="5000" w:type="pct" />
						<w:gridSpan w:val="4" />
					</w:tcPr>
					<w:p wsp:rsidR="002137C5" wsp:rsidRDefault="002137C5"
						wsp:rsidP="002137C5">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- SAC - Serviço de Apoio ao Cliente -->
								<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li)" /></w:t>
						</w:r>
					</w:p>
					<w:p wsp:rsidR="002137C5" wsp:rsidRDefault="002137C5">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:b />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
					</w:p>
				</w:tc>
			</w:tr>
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:trPr>
					<w:trHeight w:val="419" />
				</w:trPr>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="873" w:type="pct" />
						<w:tcBorders>
							<w:bottom w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
							<w:right w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Alo Bradesco-->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[2]/span" /></w:t>
						</w:r>
					</w:p>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="000B65D6">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- 0800 704 8383 -->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[2]/span[2]" /></w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1524" w:type="pct" />
						<w:gridSpan w:val="2" />
						<w:tcBorders>
							<w:left w:val="single" w:sz="4" wx:bdrwidth="10" w:space="0"
								w:color="auto" />
							<w:bottom w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
							<w:right w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Deficiente Auditivo ou de Fala -->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[3]/span" />
								</w:t>
						</w:r>
					</w:p>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00506C43">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- 0800 722 0099 -->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul/li[3]/span[2]" />
								</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="2603" w:type="pct" />
						<w:tcBorders>
							<w:left w:val="single" w:sz="4" wx:bdrwidth="10" w:space="0"
								w:color="auto" />
							<w:bottom w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Cancelamentos, Reclamações e Informações. -->
								<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li[4]/p)" />
								</w:t>
						</w:r>
					</w:p>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00002C7E">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Atendimento 24 horas por dia, 7 dias por semana. -->
								<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div/ul/li[4]/p[2])" />
								</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="1585" w:type="pct" />
						<w:gridSpan w:val="2" />
						<w:tcBorders>
							<w:top w:val="single" w:sz="4" wx:bdrwidth="10" w:space="0"
								w:color="auto" />
							<w:bottom w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
							<!-- Ouvidoria 0800 727 9933 -->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li" />
								<xsl:value-of select="'&#x09;'" />
								<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li[2]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="3415" w:type="pct" />
						<w:gridSpan w:val="2" />
						<w:tcBorders>
							<w:top w:val="single" w:sz="4" wx:bdrwidth="10" w:space="0"
								w:color="auto" />
							<w:bottom w:val="single" w:sz="4" wx:bdrwidth="10"
								w:space="0" w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="002137C5"
						wsp:rsidRDefault="00DF7225" wsp:rsidP="00ED42BE">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="002137C5">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Atendimento de segunda a sexta-feira das 8h às 18h, exceto feriados. -->
								<xsl:value-of select="html/body/div/div/div[2]/div/ul[2]/li[3]" />
							</w:t>
						</w:r>
					</w:p>
				</w:tc>
			</w:tr>
			<w:tr wsp:rsidR="00DF7225" wsp:rsidTr="00DF7225">
				<w:tc>
					<w:tcPr>
						<w:tcW w:w="5000" w:type="pct" />
						<w:gridSpan w:val="4" />
						<w:tcBorders>
							<w:top w:val="single" w:sz="4" wx:bdrwidth="10" w:space="0"
								w:color="auto" />
						</w:tcBorders>
					</w:tcPr>
					<w:p wsp:rsidR="00DF7225" wsp:rsidRPr="00DF7225"
						wsp:rsidRDefault="00DF7225">
						<w:pPr>
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
						</w:pPr>
						<w:r wsp:rsidRPr="00DF7225">
							<w:rPr>
								<w:rFonts w:ascii="Arial" w:h-ansi="Arial" w:cs="Arial" />
								<wx:font wx:val="Arial" />
								<w:sz w:val="18" />
								<w:sz-cs w:val="18" />
								<w:lang w:val="PT-BR" />
							</w:rPr>
							<w:t>
								<!-- Demais telefones consulte o site Fale Conosco -->
								<xsl:value-of select="normalize-space(html/body/div/div/div[2]/div[2]/p)" />
							</w:t>
						</w:r>						
					</w:p>
				</w:tc>
			</w:tr>
		</w:tbl>
			
	</xsl:template>
	
	
</xsl:stylesheet>

	