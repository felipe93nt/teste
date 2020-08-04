<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" />

 <xsl:strip-space elements="*" />
   
   <!--
   &#10; = quebra de linha
   &#x09; = tab
   -->

	<xsl:template match="/">
		<xsl:call-template name="topo_titulo" />
		<xsl:call-template name="topo_descricao" />
		<xsl:call-template name="agencia_conta" />
		<xsl:call-template name="total_dos_saldos_label" />
		<xsl:call-template name="total_dos_saldos_valor" />
		<xsl:call-template name="disponivel_label" />
		<xsl:call-template name="disponivel_valor" />
		<xsl:call-template name="bloqueado_label" />
		<xsl:call-template name="bloqueado_valor" />
		<xsl:call-template name="inv_sembaixa" />
		<xsl:call-template name="inv_carencia" />
		<xsl:call-template name="saldo_disponivel" />
		<xsl:call-template name="demo_invest_label" />
		<xsl:call-template name="demo_invest_valor" />
		<xsl:call-template name="obs_invest" />
		<xsl:call-template name="limite_credito_label" />
		<xsl:call-template name="limite_credito_valor" />
		<xsl:call-template name="cred_pre_aprovado_label" />
		<xsl:call-template name="cred_pre_aprovado_valor" />
	</xsl:template>

	<!-- Saldo de Conta Corrente -->
	<xsl:template name="topo_titulo">
		<xsl:value-of select="descendant::body/div/div/h2" />
		<xsl:text>&#10;</xsl:text>
	</xsl:template>

	<!-- Sadia Indústria de Alimentos S/A | CNPJ:70.741.426/0001-81 -->
	<!-- Nome do usuário: Pedro Silva -->
	<!-- Data da operação: 20/05/2009 - 12h43 -->
	
	<xsl:template name="topo_descricao">
		<xsl:for-each select="descendant::body/div/div/ul/li">
			<xsl:value-of select="normalize-space(.)" />
			<xsl:value-of select="'&#10;'" />
		</xsl:for-each>	
	</xsl:template>

	<!-- Saldo de: Ag: 1133 | CC: 056535-0 -->
	<xsl:template name="agencia_conta">
		<xsl:value-of select="descendant::body/div/div/p/strong" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>

	<!-- Total dos Saldos -->
	<xsl:template name="total_dos_saldos_label">
		<xsl:value-of select="descendant::body/div/div/div/div/h2" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>

	<!-- Posição(A+B+C+D);194.012.280,00 -->
	<xsl:template name="total_dos_saldos_valor">
		<xsl:value-of select="descendant::body/div/div/div/div/table/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table/tbody/tr/td[3])" />
		<xsl:text>&#10;</xsl:text>
	</xsl:template>
	
	<!-- Disponível -->
	<xsl:template name="disponivel_label">
		<xsl:value-of select="descendant::body/div/div/div/div/h2[2]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>

	<xsl:template name="disponivel_valor">
		<!-- Produto;Saldo (R$) -->
		<xsl:value-of select="descendant::body/div/div/div/div/table/thead/tr/th[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table/thead/tr/th[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Conta-Corrente;30.000.000,00 -->
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />		
		<!-- Conta-Poupança;8.143.000,00  -->
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr[2]/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr[2]/td[4]" />
		<xsl:value-of select="'&#10;'" />		
		<!-- Conta-Investimento (sem remuneração);5.000.000,00 	 -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[2]/tbody/tr[3]/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr[3]/td[4]" />
		<xsl:value-of select="'&#10;'" />	
		<!-- Investimento com baixa automática;500.000,00 -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[2]/tbody/tr[4]/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody/tr[4]/td[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Total (A);43.643.000,00 -->
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody[2]/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[2]/tbody[2]/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- Bloqueado -->
	<xsl:template name="bloqueado_label">
		<xsl:value-of select="descendant::body/div/div/div/div/h2[3]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<xsl:template name="bloqueado_valor">
		<!-- Tipo de Saldo;Saldo (R$) -->	
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/thead/tr/th[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/thead/tr/th[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Vinculado do dia;346.000,00 --> 	
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />		
		<!-- Vinculado do dia Conta de Investimento;0,00 --> 	
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[3]/tbody/tr[2]/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr[2]/td[4]" />
		<xsl:value-of select="'&#10;'" />		
		<!-- Vinculado de dias anteriores;15.000,00 --> 	
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[3]/tbody/tr[3]/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr[3]/td[4]" />
		<xsl:value-of select="'&#10;'" />	
		<!-- Vinculado do dia anterior Conta de Investimento;0,00 --> 	
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[3]/tbody/tr[4]/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr[4]/td[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Bloqueio judicial;8.000,00 --> 	
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr[5]/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody/tr[5]/td[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Total (B);369.000,00 -->
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody[2]/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[3]/tbody[2]/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- Investimento sem baixa automática (C);2.000.000,00 -->	
	<xsl:template name="inv_sembaixa">
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div/table[4]/tbody/tr/td[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[4]/tbody/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- Investimento em carência (D);148.000.280,00 -->
	<xsl:template name="inv_carencia">
		<xsl:value-of select="descendant::body/div/div/div/div/table[5]/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div/table[5]/tbody/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>	

	<!-- Saldo Disponível para Investimento -->	
	<xsl:template name="saldo_disponivel">
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[2]/h2)" />
		<xsl:value-of select="'&#10;'" />
	<!-- Total;148.003,00 -->
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table/tbody/tr/td[3]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>	
	
	<!-- Demonstrativo de Investimentos -->	
	<xsl:template name="demo_invest_label">
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[2]/h2[2])" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<xsl:template name="demo_invest_valor">
		<!-- Produto;Saldo (R$) -->	
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table/thead/tr/th[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table/thead/tr/th[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Fundo Vênus;8.003,00 -->
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table[2]/tbody/tr/td[2]/a" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table[2]/tbody/tr/td[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- CDB **;40.000,00 	-->	
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[2]/a" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table[2]/tbody/tr[2]/td[4]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Poupança Integrada;100.000,00 -->	
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[2]/a)" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[2]/table[2]/tbody/tr[3]/td[4]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- ** Investimentos com baixa automática -->	
	<xsl:template name="obs_invest">
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[2]/p)" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- Limites de Crédito -->
	<xsl:template name="limite_credito_label">
		<xsl:value-of select="descendant::body/div/div/div/div[3]/h2" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<xsl:template name="limite_credito_valor">
		<!-- Produto;Limite Total (R$); Limite Utilizado (R$);Limite a Utilizar (R$);Vencimento;Taxas -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[4])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[7])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[10])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[14])" />
		<xsl:value-of select="';'" />	
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table/thead/tr/th[17])" />
		<xsl:value-of select="'&#10;'" />
		<!-- Cheque Especial;1.000,00;0,00;1.000,00;20/05/10;8,36 a.m./162,07 a.a. -->
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[7]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[10]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[14]" />
		<xsl:value-of select="';'" />	
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody/tr/td[16]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Crédito Online;1.000,00;0,00;1.000,00;; -->
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[2]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[4]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[7]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[10]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[14]" />
		<xsl:value-of select="';'" />	
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table/tbody[2]/tr/td[16]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<!-- Crédito Pré-Aprovado -->
	<xsl:template name="cred_pre_aprovado_label">
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/h2[2])" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
	
	<xsl:template name="cred_pre_aprovado_valor">
	<!-- Produto;Limite Pré-Aprovado (R$);Validade -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table[2]/thead/tr/th[2])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table[2]/thead/tr/th[4])" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table[2]/thead/tr/th[8])" />
		<xsl:value-of select="'&#10;'" />
		<!-- Limite Rotativo Flex PJ;30.000,00;20/05/10 -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table[2]/tbody/tr/td[2]/a)" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table[2]/tbody/tr/td[4]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table[2]/tbody/tr/td[6]" />
		<xsl:value-of select="'&#10;'" />
		<!-- Conta Garantida utilizada;10.000,00;20/05/10 -->
		<xsl:value-of select="normalize-space(descendant::body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[2]/a)" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[4]" />
		<xsl:value-of select="';'" />
		<xsl:value-of select="descendant::body/div/div/div/div[3]/table[2]/tbody/tr[2]/td[6]" />
		<xsl:value-of select="'&#10;'" />
	</xsl:template>
</xsl:stylesheet>