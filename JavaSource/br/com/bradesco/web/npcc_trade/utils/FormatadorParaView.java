/**
 * Nome: br.com.bradesco.web.npcd.utils.FormatadorParaView
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * Data da Criação: 07/08/2015
 *
 * @see : Referencias externas.
 *
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


/**
  * Nome: FormatadorParaView.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 07/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class FormatadorParaView extends FormatadorNumerico {

	@Override
	protected DecimalFormat getFormatoMilhar() {
		Locale locale;
		locale = SiteUtil.PT_BR;
		DecimalFormat retorno;
		retorno = (DecimalFormat) NumberFormat.getInstance(locale);
		retorno.applyPattern(SiteUtil.DECIMAL_PATTERN);
		return (retorno);
	}

	@Override
	protected DecimalFormat getFormatoPercentual() {
		Locale locale;
		locale = SiteUtil.PT_BR;
		DecimalFormat retorno;
		retorno = (DecimalFormat) NumberFormat.getInstance(locale);
		retorno.applyPattern("##0.00");
		return (retorno);
	}
	
	@Override
	protected DecimalFormat getFormatoPercentualCincoCasas() {
		Locale locale;
		locale = SiteUtil.PT_BR;
		DecimalFormat retorno;
		retorno = (DecimalFormat) NumberFormat.getInstance(locale);
		retorno.applyPattern(SiteUtil.DECIMAL_PATTERN_CINCO_CASAS);
		return (retorno);
	}
}
