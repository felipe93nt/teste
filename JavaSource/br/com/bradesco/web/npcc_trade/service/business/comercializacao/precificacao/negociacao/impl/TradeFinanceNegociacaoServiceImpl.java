/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.impl
 * 
 * Propï¿½sito: Uso exclusivo do Bradesco, contï¿½m
 *            informaçães a respeito do Cambio.
 * 
 * Data da Criação: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia.Alterarcomplgarantiarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia.Alterarcomplgarantiaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia.Npccwwjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia.Npccwwjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting.Baixasaldoforfaitingrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting.Baixasaldoforfaitingresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting.Npccww6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting.Npccww6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Calcprazototaloperlcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Calcprazototaloperlcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Npccwx3erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Npccwx3erequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Npccwx3sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria.Calcularsomatoriarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria.Calcularsomatoriaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria.Npccwv8erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria.Npccwv8sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons.Cliedadosnegocconsrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons.Cliedadosnegocconsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons.Npccwxberequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons.Npccwxbsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Consbeneficafiancadorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Consbeneficafiancadoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Npccwzmerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Npccwzmsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto.Consultapilotorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto.Consultapilotoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto.Npccwcderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto.Npccwcdsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit.Convvlrpramoedalimitrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit.Convvlrpramoedalimitresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit.Npccwwzerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit.Npccwwzsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt.Cotacforfaitingaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt.Cotacforfaitingaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt.Npccwweerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt.Npccwwesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl.Cotacforfaitinginclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl.Cotacforfaitinginclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl.Npccwv5erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl.Npccwv5sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt.Cotacworkcapitalaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt.Cotacworkcapitalaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt.Npccwwkerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt.Npccwwksresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl.Cotacworkcapitalinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl.Cotacworkcapitalinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl.Npccww1erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl.Npccww1sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt.Cotacaolei4131altrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt.Cotacaolei4131altresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt.Npccww9erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt.Npccww9sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl.Cotacaolei4131inclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl.Cotacaolei4131inclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl.Npccwv0erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl.Npccwv0sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt.Cotacaoppealtrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt.Cotacaoppealtresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt.Npccwwierequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt.Npccwwisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl.Cotacaoppeinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl.Cotacaoppeinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl.Npccwv9erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl.Npccwv9sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons.Custoexternoconsrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons.Custoexternoconsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons.Npccwyrerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons.Npccwyrsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Custototalforfaitingrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Custototalforfaitingresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Npccwzierequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Npccwzierequest_lstcadis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Npccwzisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt.Dadosbasegp1gp3altrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt.Dadosbasegp1gp3altresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt.Npccwwberequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt.Npccwwbsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl.Dadosbasegp1gp3inclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl.Dadosbasegp1gp3inclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl.Npccwv2erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl.Npccwv2sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Desinclforfaitingrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Desinclforfaitingresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Npccwwxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Npccwwxerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting.Npccwwxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt.Desfazimentoaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt.Desfazimentoaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt.Npccw55erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt.Npccw55sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl.Desfazimentoinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl.Desfazimentoinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl.Npccw0cerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl.Npccw0csresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Flxpgtprcjrsinclfakerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Flxpgtprcjrsinclfakeresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Npccwwgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Npccwwgerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE.Npccwwgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt.Finimpdiretoaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt.Finimpdiretoaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt.Npccwwcerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt.Npccwwcsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl.Finimpdiretoinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl.Finimpdiretoinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl.Npccwv3erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl.Npccwv3sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt.Finimpindiretoaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt.Finimpindiretoaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt.Npccwwderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt.Npccwwdsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl.Finimpindiretoinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl.Finimpindiretoinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl.Npccwv4erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl.Npccwv4sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Fluxovalidacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Fluxovalidacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2erequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2erequest_lstmerc;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao.Npccwx2sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame.Fluxovalidacaopagamerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame.Fluxovalidacaopagameresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame.Npccwx8erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame.Npccwx8sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Flxpgtprincjuroscalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Flxpgtprincjuroscalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Npccwwverequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Npccwwvsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Npccwwvsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Fndrflxpgtcmssexaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Fndrflxpgtcmssexaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Npccwxserequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Npccwxserequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Npccwxssresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Fndrflxpgtcmssexinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Fndrflxpgtcmssexinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Npccwymerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Npccwymerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Npccwymsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Fndrflxpgtcmssinaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Fndrflxpgtcmssinaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Npccwxnerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Npccwxnerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Npccwxnsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Fndrflxpgtcmssininclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Fndrflxpgtcmssininclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Npccwylerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Npccwylerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Npccwylsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Fndrflxpgtprcjrsaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Fndrflxpgtprcjrsaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyferequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyferequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyferequest_lstmer;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyfsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl.Fndrflxpgtprcjrsinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl.Fndrflxpgtprcjrsinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl.Npccwykerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl.Npccwykerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl.Npccwyksresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Fndrgrtvnctrfobsaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Fndrgrtvnctrfobsaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstava;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstgar;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lsttar;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxerequest_lstvin;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt.Npccwzxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Fndrgrtvnctrfobsinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Fndrgrtvnctrfobsinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstava;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstgar;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstmer;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lsttar;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynerequest_lstvin;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl.Npccwynsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Forftngdesembolsoaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Forftngdesembolsoaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqerequest_lstlis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqerequest_lstmer;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt.Npccwyqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Incaltfundingdesplcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Incaltfundingdesplcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Npccwv6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Npccwv6erequest_listadsp;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC.Npccwv6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia.Incluircomplgarantiarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia.Incluircomplgarantiaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia.Npccwyierequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia.Npccwyisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Incluirparcelalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Incluirparcelalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Npccwv1erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Npccwv1erequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC.Npccwv1sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico.Inecindeconomicorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico.Inecindeconomicoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico.Inecwpaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico.Inecwpasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Mercadoriasmodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Mercadoriasmodallistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList.Npccwwnsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0erequest_lstrbt;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0erequest_lsttde;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Npccww0sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Observcotacaoinclaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt.Observcotacaoinclaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl.Npccww7erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl.Npccww7sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl.Opervinculadalcinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl.Opervinculadalcinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Npccwwqsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Operacoesclientelistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList.Operacoesclientelistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzperequest_listapc;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzperequest_listapr;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzpsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Przmedoperdesembcalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Przmedoperdesembcalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite.Npccww8erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite.Npccww8sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite.Somaaboutvalorlimiterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite.Somaaboutvalorlimiteresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest_lstcadis;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Spreadnegoccalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Spreadnegoccalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc.Npccwzcerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc.Npccwzcsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc.Taxasforfaitingcalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc.Taxasforfaitingcalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc.Npccww4erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc.Npccww4sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc.Validstatusvinculolcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc.Validstatusvinculolcresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ITradeFinanceNegociacaoService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CalcPrazoTotalOperLcVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TaxasForfaitingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CadastroNacionalPessoa;
import br.com.bradesco.web.npcc_trade.utils.components.LineBreaks;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TradeFinanceNegociacaoServiceImpl.java
 * 
 * Proposito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrï¿½o
 *      hexavision.
 */
@Named("tradeFinanceNegociacaoService")
@SessionScoped
public class TradeFinanceNegociacaoServiceImpl extends BaseService implements ITradeFinanceNegociacaoService {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     */
    public TradeFinanceNegociacaoServiceImpl() {
        super();
    }

    /**
     * Nome: getMercadoriasModalList
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public List<TradeFinNegocListasVO> getMercadoriasModalList(TrdFinNegMercadoriaVO filtro) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getMercadoriasModalList | MERCADORIASMODALLIST ------- ");

            List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();

            TradeFinNegocListasVO objTo = null;

            Mercadoriasmodallistrequest request = new Mercadoriasmodallistrequest();
            Mercadoriasmodallistresponse response = new Mercadoriasmodallistresponse();
            Npccwwnerequest entrada = new Npccwwnerequest();
            Npccwwnsresponse saida = new Npccwwnsresponse();
            request.setNpccwwnerequest(entrada);
            response.setNpccwwnsresponse(saida);

            entrada.setTipopesquisa(filtro.getTipoPesquisaMercadoria());
            entrada.setCmcadocmbiomcsul(0L);
            entrada.setRmcadoopercmbio(filtro.getRmcadoopercmbio());

            // Executa chamada CWS - Fluxo: NPCCIAOY - Books: NPCCWWNE / NPCCWWNS
            listaComPaginacao(request, response, "MERCADORIASMODALLIST", "NPCCIAOY");

            for (int i = 0; i < response.getNpccwwnsresponse().getQtdeocorr(); i++) {

                Npccwwnsresponse_lista objFrom = response.getNpccwwnsresponse().getLista().get(i);
                objTo = new TradeFinNegocListasVO();

                // Copia os valores das propriedades com o mesmo nome
                objTo.setCmcadoopercmbio(objFrom.getLista_cmcadoopercmbio());
                objTo.setRmcadoopercmbio(objFrom.getLista_rmcadoopercmbio());
                objTo.setAtivoSimNao(EnumSimNao.fromCode(objFrom.getLista_ntpositcmbio()).getDescricao());
                objTo.setNtpositcmbio(objFrom.getLista_ntpositcmbio());
                objTo.setCindcdlicenmcado(objFrom.getLista_cindcdlicenmcado());
                objTo.setCmcadorestcmbio(objFrom.getLista_cmcadorestcmbio());

                lista.add(objTo);
            }

            return lista;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getMercadoriasModalList | MERCADORIASMODALLIST ------- ");
        }
    }

    /**
     * Nome: getOperacoesVinculadas
     * 
     * Propï¿½sito: Retorna lista de operaçães vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public List<TrdFinNegOperVincVO> getOperacoesVinculadas(TrdFinNegOperVincVO OpVcVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getOperacoesVinculadas | OPERACOESCLIENTELIST ------- ");

            List<TrdFinNegOperVincVO> lista = new ArrayList<TrdFinNegOperVincVO>();

            TrdFinNegOperVincVO objTo = null;

            Operacoesclientelistrequest request = new Operacoesclientelistrequest();
            Operacoesclientelistresponse response = new Operacoesclientelistresponse();
            Npccwwqerequest entrada = new Npccwwqerequest();
            Npccwwqsresponse saida = new Npccwwqsresponse();
            request.setNpccwwqerequest(entrada);
            response.setNpccwwqsresponse(saida);

            entrada.setCunicclicmbio(OpVcVO.getCunicclicmbio());

            if (OpVcVO.getDataPesquisa() == null || OpVcVO.getDataPesquisa().getBeginDate() == null) {
                entrada.setDatainio("");
            } else {
                String dtEmissaoIni = SiteUtil.dataWebToMainframe(OpVcVO.getDataPesquisa().getBeginDate());
                entrada.setDatainio(dtEmissaoIni.equals("0") ? "" : dtEmissaoIni);
            }
            if (OpVcVO.getDataPesquisa() == null || OpVcVO.getDataPesquisa().getEndDate() == null) {
                entrada.setDatafim("");
            } else {
                String dtEmissaoFim = SiteUtil.dataWebToMainframe(OpVcVO.getDataPesquisa().getEndDate());
                entrada.setDatafim(dtEmissaoFim.equals("0") ? "" : dtEmissaoFim);
            }

            entrada.setDanobase(OpVcVO.getDanobase());
            entrada.setNbletocmbioano(OpVcVO.getNumoperacao());
            entrada.setCprodtservc(OpVcVO.getCprodtservc());
            entrada.setCindcdeconmmoeda(OpVcVO.getCindcdeconmmoeda());

            // Executa chamada CWS - Fluxo: NPCCIAPC - Books: NPCCWWQE / NPCCWWQS
            listaComPaginacao(request, response, "OPERACOESCLIENTELIST", "NPCCIAPC");

            for (int i = 0; i < response.getNpccwwqsresponse().getQtdeocorr(); i++) {

                Npccwwqsresponse_lista objFrom = response.getNpccwwqsresponse().getLista().get(i);
                objTo = new TrdFinNegOperVincVO();

                // Copia os valores das propriedades
                objTo.setNbletonegoccmbio(objFrom.getLista_nbletonegoccmbio());
                objTo.setNbletocmbioano(objFrom.getLista_nbletocmbioano());
                objTo.setDfimnegoccmbio(objFrom.getLista_dfimnegoccmbio());
                String dataWeb = null;
                if (SiteUtil.isEmptyOrNull(objFrom.getLista_dfimnegoccmbio()) ||
                                objFrom.getLista_dfimnegoccmbio().contains("00000")) {
                    objTo.setDataVencimento("");
                } else {
                    dataWeb = SiteUtil.dateTimeMainframeToWeb(objFrom.getLista_dfimnegoccmbio());
                    objTo.setDataVencimento(dataWeb.substring(0, 10));
                }
                objTo.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
                objTo.setIindcdeconmmoeda(objFrom.getLista_iindcdeconmmoeda());
                objTo.setVnegocmoedaestrg(objFrom.getLista_vnegocmoedaestrg());
                objTo.setValorMoeda(SiteUtil.formatarValorWeb(objFrom.getLista_vnegocmoedaestrg()));
                objTo.setCprodtservc(objFrom.getLista_cprodtservc());
                objTo.setIprodtservc(objFrom.getLista_iprodtservc());

                lista.add(objTo);
            }

            return lista;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getOperacoesVinculadas | OPERACOESCLIENTELIST ------- ");
        }
    }

    /**
     * Nome: getConverterValorParaMoedaLimite
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public String getConverterValorParaMoedaLimite(TrdFinNegocInclVO negocInclVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getConverterValorParaMoedaLimite | CONVVLRPRAMOEDALIMIT ------- ");

            String valorMoedaLimite = null;

            Convvlrpramoedalimitrequest request = new Convvlrpramoedalimitrequest();
            Convvlrpramoedalimitresponse response = new Convvlrpramoedalimitresponse();
            Npccwwzerequest entrada = new Npccwwzerequest();
            Npccwwzsresponse saida = new Npccwwzsresponse();
            request.setNpccwwzerequest(entrada);
            response.setNpccwwzsresponse(saida);

            entrada.setNbletonegoccmbio(0L);
            entrada.setDfchtobletocmbio(negocInclVO.getDfchtobletocmbio());
            entrada.setCindcdeconmmoeda(negocInclVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(negocInclVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(negocInclVO.getCeconmmoedalim());

            // Fluxo: NPCCIASH - Books: NPCCWWZE / NPCCWWZS
            listaSemPaginacao(request, response, "CONVVLRPRAMOEDALIMIT");

            valorMoedaLimite = SiteUtil.formatarValorWeb(response.getNpccwwzsresponse().getSvlimit());

            return valorMoedaLimite;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getComissaoInternaExterna | CONVVLRPRAMOEDALIMIT ------- ");
        }
    }
    
    /**
     * Nome: somaAboutValorLimite
     * 
     * Propósito: Somar o percentual do about no valor na moeda do limite
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public String somaAboutValorLimite(TrdFinNegocInclVO negocInclVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.somaAboutValorLimite | SOMAABOUTVALORLIMITE ------- ");

            String valorMoedaLimite = null;

            Somaaboutvalorlimiterequest request = new Somaaboutvalorlimiterequest();
            Somaaboutvalorlimiteresponse response = new Somaaboutvalorlimiteresponse();
            Npccww8erequest entrada = new Npccww8erequest();
            Npccww8sresponse saida = new Npccww8sresponse();
            request.setNpccww8erequest(entrada);
            response.setNpccww8sresponse(saida);

            entrada.setPcobervarprodt(SiteUtil.formatarPontosVirgula(negocInclVO.getVlimcobervar()));
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(negocInclVO.getVmoedalimgerc()));

            // Fluxo: NPCCIAP9 - Books: NPCCWW8E / NPCCWW8S
            listaSemPaginacao(request, response, "SOMAABOUTVALORLIMITE");

            valorMoedaLimite = SiteUtil.formatarValorWeb(response.getNpccww8sresponse().getVnegocmoedaestrg());

            return valorMoedaLimite;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.somaAboutValorLimite | SOMAABOUTVALORLIMITE ------- ");
        }
    }

    /**
     * Nome: getFluxoPagtoDePrincipalJuros
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    @SuppressWarnings("finally")
	public Boolean getFluxoPagtoDePrincipalJuros(TrdFinNegFluxoPagtoVO flxPagtoVO, boolean prazoOperacaoAjustado) {
        BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getFluxoPagtoDePrincipalJuros | FLXPGTPRINCJUROSCALC ------- ");

        List<TrdFinNegParcelaVO> lista = new ArrayList<TrdFinNegParcelaVO>();
        List<TrdFinNegParcelaVO> listaPrincJuros = new ArrayList<TrdFinNegParcelaVO>();
        
        TrdFinNegParcelaVO objTo = null;
        
        Flxpgtprincjuroscalcrequest request = new Flxpgtprincjuroscalcrequest();
        Flxpgtprincjuroscalcresponse response = new Flxpgtprincjuroscalcresponse();
        Npccwwverequest entrada = new Npccwwverequest();
        Npccwwvsresponse saida = new Npccwwvsresponse();
        try{
            request.setNpccwwverequest(entrada);
            response.setNpccwwvsresponse(saida);
            
            entrada.setTdiaopercmbio(flxPagtoVO.getTdiaopercmbio());
            entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPagtoVO.getDateFluxoPgto()));
            entrada.setVprevtdsembcmbio(SiteUtil.webMoedaToMainframe(flxPagtoVO.getVprevtdsembcmbio()));
            entrada.setTdiacarenprinc(flxPagtoVO.getTdiacarenprinc());
            entrada.setCindcdpcobrprinc(flxPagtoVO.getCfluxoliqdcprinc());
            entrada.setTdiacarenjuro(flxPagtoVO.getJurosCarencia());
            entrada.setCindcdpcobrjuros(flxPagtoVO.getCodJurosPeriodicidade());
            entrada.setCindcdfcobrcotac(flxPagtoVO.getCodJurosMomento());
            entrada.setCindcdeconmc(flxPagtoVO.getCindcdeconmc());
            entrada.setCpais(flxPagtoVO.getCpais());
            entrada.setPrzoperajustado(prazoOperacaoAjustado ? "S" : "N");
            
            // Por: Cláudio Tadeu em 14/10/2019 - IN? - País Desembolso
            entrada.setCpaismoedadsemb(flxPagtoVO.getCpaismoedadsemb());
            // *****
            
            // Fluxo: NPCCIAO6 - Books: NPCCWWVE / NPCCWWVS
            /*IN2068072
            //listaSemPaginacao(request, response, "FLXPGTPRINCJUROSCALC"); */
            listaComPaginacao(request, response, "FLXPGTPRINCJUROSCALC", "NPCCIAO6");
            
            flxPagtoVO.setQtdeocorrprinc(response.getNpccwwvsresponse().getQtdeocorrprinc());
            flxPagtoVO.setQtdeocorrjuros(response.getNpccwwvsresponse().getQtdeocorrjuros());
            
            if (flxPagtoVO.getCfluxoliqdcprinc().equals(flxPagtoVO.getCodJurosPeriodicidade())) {
            	String vPrinc = flxPagtoVO.getVprevtdsembcmbio().replace(".", "");
            	
        		// IN2754700 - Alexandre Rodrigues - INICIO
            	if (flxPagtoVO.getQtdeocorrprinc() < flxPagtoVO.getQtdeocorrjuros()) {
            		List<TrdFinNegParcelaVO> listaParcelas = new ArrayList<TrdFinNegParcelaVO>();
            		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");            		
            		String devedorTmp = flxPagtoVO.getVprevtdsembcmbio().replace(".", "").replace(",", ".");
            		BigDecimal saldoDevedor = new BigDecimal(devedorTmp);
            		int prazoParcela = 0;
            		
            		for (int i = 0; i < response.getNpccwwvsresponse().getQtdeocorr(); i++) {
	            		Npccwwvsresponse_lista objFrom = response.getNpccwwvsresponse().getLista().get(i);
	            		boolean parcelaExistente = false;
	            		
	            		for (TrdFinNegParcelaVO parcelaAlteracao : listaParcelas) {
	            			if (parcelaAlteracao.getDvctopcelatrade().equals(objFrom.getLista_dvctopcelatrade())) {
	            				parcelaExistente = true;
	            				
	            				if (objFrom.getLista_tpparcela().equals("P")) {
	            					parcelaAlteracao.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
	            				}
	            				else if (objFrom.getLista_tpparcela().equals("J")) {
	            					parcelaAlteracao.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));		
	            				}	            				
	            			}
	            		}
	            		
            			if (!parcelaExistente) {
            				TrdFinNegParcelaVO parcelaInclusao = new TrdFinNegParcelaVO();
            				parcelaInclusao.setTpparcela(objFrom.getLista_tpparcela());
            				parcelaInclusao.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            				parcelaInclusao.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            				parcelaInclusao.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
            				parcelaInclusao.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            				parcelaInclusao.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            				parcelaInclusao.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            				parcelaInclusao.setVpcelamesatrade(objFrom.getLista_vpcelamesatrade());
            				
            				parcelaInclusao.setValorPrincipalParcelaFluxoPgto("0,00");
            				parcelaInclusao.setValorJurosParcelaFluxoPgto("0,00");
            				
            				if (objFrom.getLista_tpparcela().equals("P")) {
            					parcelaInclusao.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
            				}
            				else if (objFrom.getLista_tpparcela().equals("J")) {
            					parcelaInclusao.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));		
            				}
            				
            				listaParcelas.add(parcelaInclusao);
            			}
	            	}
	
	            	Collections.sort(listaParcelas, new Comparator<TrdFinNegParcelaVO>() {
            			public int compare(TrdFinNegParcelaVO o1, TrdFinNegParcelaVO o2) {
        					Date dataInicial = o1.getVenctoFluxDate();
        					Date dataFinal = o2.getVenctoFluxDate();
        					
        					return dataInicial.compareTo(dataFinal);
            			}
            		});
	            	
	            	for (TrdFinNegParcelaVO parcela : listaParcelas) {
	            		String principalTmp = parcela.getValorPrincipalParcelaFluxoPgto().replace(".",  "").replace(",", ".");
	            		BigDecimal valorPrincipal = new BigDecimal(principalTmp);

            			saldoDevedor = saldoDevedor.subtract(valorPrincipal);
            			BigDecimal valorParcela = saldoDevedor.add(valorPrincipal);
            			
            			parcela.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			parcela.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(valorParcela.toString()));
	            	}
	            	
            		for (int i = 1; i < listaParcelas.size(); i++) {
            			prazoParcela = calcularDiferencaEntreDatas(listaParcelas.get(i-1).getVencimentoFluxoPgto(), listaParcelas.get(i).getVencimentoFluxoPgto());
            			listaParcelas.get(i).setTdianegocpcela(prazoParcela);
					}
	            	
	            	listaPrincJuros = new ArrayList<TrdFinNegParcelaVO>(listaParcelas);
            	}
        		// IN2754700 - Alexandre Rodrigues - TERMINO
            	
            	else {	
	            	for (int i = 0; i < response.getNpccwwvsresponse().getQtdeocorr(); i++) {
	            		Npccwwvsresponse_lista objFrom = response.getNpccwwvsresponse().getLista().get(i);
	            		objTo = new TrdFinNegParcelaVO();
	
	            		// Copia os valores das propriedades
	            		if (objFrom.getLista_tpparcela().equals("P")) {
	            			objTo.setTpparcela(objFrom.getLista_tpparcela());
	            			objTo.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
	            			objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
	            			objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
	            			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
	            			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
	            			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
	            			objTo.setVpcelamesatrade(objFrom.getLista_vpcelamesatrade());
	            			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));

	            			objTo.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
	
	            			vPrinc = vPrinc.replace(",", ".");
	            			String vParce = objFrom.getLista_vpcelamesatrade().replace(",", ".");
	            			vParce = vParce.replace(",", ".");
	
	            			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

	            			objTo.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
	            			vPrinc = saldoDevedor.toString();
	            			
	            			lista.add(objTo);
	            		} else if (objFrom.getLista_tpparcela().equals("J")) {
	            			objTo.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
	            			listaPrincJuros.add(objTo);
	            		}
	            	}
	
	            	for (int i = 0; i < lista.size(); i++) {
	            		listaPrincJuros.get(i).setTpparcela(lista.get(i).getTpparcela());
	            		listaPrincJuros.get(i).setNpceladsembtrade(lista.get(i).getNpceladsembtrade());
	            		listaPrincJuros.get(i).setTdianegocpcela(lista.get(i).getTdianegocpcela());
	            		listaPrincJuros.get(i).setDvctopcelatrade(lista.get(i).getDvctopcelatrade());
	            		listaPrincJuros.get(i).setVenctoFluxDate(lista.get(i).getVenctoFluxDate());
	            		listaPrincJuros.get(i).setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(lista.get(i).getVencimentoFluxoPgto()));
	            		listaPrincJuros.get(i).setVpcelamesatrade(lista.get(i).getVpcelamesatrade());
	            		listaPrincJuros.get(i).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorParcelaFluxoPgto()));

	            		listaPrincJuros.get(i).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorPrincipalParcelaFluxoPgto()));
	            		listaPrincJuros.get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorSaldoDevedorFluxoPgto()));
	            	}
            	}
            } else {
            	String vPrinc = flxPagtoVO.getVprevtdsembcmbio().replace(".", "");
            	
            	for (int i = 0; i < response.getNpccwwvsresponse().getQtdeocorr(); i++) {
            		Npccwwvsresponse_lista objFrom = response.getNpccwwvsresponse().getLista().get(i);
            		objTo = new TrdFinNegParcelaVO();

            		// Copia os valores das propriedades
            		if (objFrom.getLista_tpparcela().equals("P")) {
            			objTo.setTpparcela(objFrom.getLista_tpparcela());
            			objTo.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            			objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            			objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
            			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setVpcelamesatrade(objFrom.getLista_vpcelamesatrade());
            			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
            			objTo.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));

            			vPrinc = vPrinc.replace(",", ".");
            			String vParce = objFrom.getLista_vpcelamesatrade().replace(",", ".");
            			vParce = vParce.replace(",", ".");

            			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

            			objTo.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			vPrinc = saldoDevedor.toString();
            			
            			lista.add(objTo);
            		} else if (objFrom.getLista_tpparcela().equals("J")) {
            			objTo.setTpparcela(objFrom.getLista_tpparcela());
            			objTo.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            			objTo.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            			objTo.setDvctopcelatrade(objFrom.getLista_dvctopcelatrade());
            			objTo.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			objTo.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));

            			listaPrincJuros.add(objTo);
            		}
            	}

            	if (listaPrincJuros.size() % lista.size() != 0) {
            		for (int i = 0; i < lista.size(); i++) {
            			String dataTemp = lista.get(i).getVencimentoFluxoPgto();
            			
            			for (int j = 0; j < listaPrincJuros.size(); j++) {
            				String dataAux = listaPrincJuros.get(j).getVencimentoFluxoPgto();
            				
            				if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
            					listaPrincJuros.get(j).setTpparcela(lista.get(i).getTpparcela());
            					listaPrincJuros.get(j).setNpceladsembtrade(lista.get(i).getNpceladsembtrade());
            					listaPrincJuros.get(j).setVpcelamesatrade(lista.get(i).getVpcelamesatrade());
            					listaPrincJuros.get(j).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorParcelaFluxoPgto()));

            					listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorPrincipalParcelaFluxoPgto()));
            					listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorSaldoDevedorFluxoPgto()));
            					break;
            				} else if (j == listaPrincJuros.size() -1) {
            					listaPrincJuros.add(lista.get(i));
            				}
            			}
            		}

            		final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            		Comparator<TrdFinNegParcelaVO> cmp = new Comparator<TrdFinNegParcelaVO>() {
            			public int compare(TrdFinNegParcelaVO o1, TrdFinNegParcelaVO o2) {
            				Date dataInicial = null;
            				Date dataFinal = null;
            				try {
            					dataInicial = sdf1.parse(o1.getVencimentoFluxoPgto());
            					dataFinal = sdf1.parse(o2.getVencimentoFluxoPgto());
            				} catch (ParseException e) {
            					e.printStackTrace();
            				}
            				return dataInicial.compareTo(dataFinal); 
            			}
            		};
            		Collections.sort(listaPrincJuros, cmp);
            		int prazoTemp = 0;
            		for (int i = 1; i < listaPrincJuros.size(); i++) {
            			prazoTemp = calcularDiferencaEntreDatas(listaPrincJuros.get(i-1).getVencimentoFluxoPgto(), listaPrincJuros.get(i).getVencimentoFluxoPgto());
            			listaPrincJuros.get(i).setTdianegocpcela(prazoTemp);
					}
            	} else {
            		for (int i = 0; i < lista.size(); i++) {
            			String dataTemp = lista.get(i).getVencimentoFluxoPgto();
            			for (int j = 0; j < listaPrincJuros.size(); j++) {
            				String dataAux = listaPrincJuros.get(j).getVencimentoFluxoPgto();
            				if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
            					listaPrincJuros.get(j).setTpparcela(lista.get(i).getTpparcela());
            					listaPrincJuros.get(j).setNpceladsembtrade(lista.get(i).getNpceladsembtrade());
            					listaPrincJuros.get(j).setVpcelamesatrade(lista.get(i).getVpcelamesatrade());
            					listaPrincJuros.get(j).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorParcelaFluxoPgto()));

            					listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorPrincipalParcelaFluxoPgto()));
            					listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorSaldoDevedorFluxoPgto()));
            					break;
            				} else if (j == listaPrincJuros.size() -1) {
            					listaPrincJuros.add(lista.get(i));
            				}
            			}
            		}
				}
            	
            	String vPrincAux = flxPagtoVO.getVprevtdsembcmbio().replace(".", "");
            	for (int i = 0; i < listaPrincJuros.size(); i++) {
            		if (listaPrincJuros.get(i).getTpparcela().equals("J")) {
            			listaPrincJuros.get(i).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrincAux));

            			vPrincAux = vPrincAux.replace(",",".");
            			String vParce = "0.00";
            			if (listaPrincJuros.get(i).getValorPrincipalParcelaFluxoPgto() != null) {
            				vParce = listaPrincJuros.get(i).getValorPrincipalParcelaFluxoPgto().replace(",",".");
            			}
            			vParce = vParce.replace(",",".");
            			BigDecimal saldoDevedor = new BigDecimal(vPrincAux).subtract(new BigDecimal(vParce));

            			listaPrincJuros.get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			vPrincAux = saldoDevedor.toString();
            		} else {
            			vPrincAux = listaPrincJuros.get(i).getValorSaldoDevedorFluxoPgto().replace(".", "");
            		}
            	}
            }
            flxPagtoVO.setListaParcelasFluxoPgto(listaPrincJuros);
            
            return Boolean.TRUE;

        } catch (Exception e){
        	System.out.println("erro");
        } finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getFluxoPagtoDePrincipalJuros | FLXPGTPRINCJUROSCALC ------- ");
            return saida.getQtdeocorr() > Numeros.ZERO;
        }
    }
    
    public int calcularDiferencaEntreDatas(String dataAtual, String dataSeguinte) {
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataMaior = null;
		Date dataMenor = null;
		try {
			dataMaior = (Date)formatter.parse(dataSeguinte);
			dataMenor = (Date)formatter.parse(dataAtual);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(dataMenor);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(dataMaior);

		Long diferencaDiasLong = ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24*60*60*1000));
   		
		int diferencaDias = Integer.valueOf((int) diferencaDiasLong.longValue());
		
   		return diferencaDias;
	}
    
    /**
     * Nome: getCustoExterno
     * 
     * Propï¿½sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 06/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrï¿½o hexavision.
     */
    public Boolean getCustoExterno(TrdFinNegPrecificacaoVO precificacaoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getCustoExterno | CUSTOEXTERNOCONS ------- ");

            Custoexternoconsrequest request = new Custoexternoconsrequest();
            Custoexternoconsresponse response = new Custoexternoconsresponse();
            Npccwyrerequest entrada = new Npccwyrerequest();
            Npccwyrsresponse saida = new Npccwyrsresponse();
            request.setNpccwyrerequest(entrada);
            response.setNpccwyrsresponse(saida);

            entrada.setCindcdeconmmoeda(precificacaoVO.getCindcdeconmmoeda());
            entrada.setPrzomediodsemb(precificacaoVO.getPrzomediodsemb());
            entrada.setCprodtservc(precificacaoVO.getCprodtservc());

            // Fluxo: NPCCIAT9 - Books: NPCCWWYE / NPCCWWYS
            listaSemPaginacao(request, response, "CUSTOEXTERNOCONS");

            precificacaoVO.setValidadecotac(response.getNpccwyrsresponse().getValidadecotac());
            precificacaoVO.setDtcotac(SiteUtil.stringDataWebToMainframe(response.getNpccwyrsresponse().getDtcotac()));
            precificacaoVO.setDataCotacaoFormat(SiteUtil.stringDataMainframeToWeb(precificacaoVO.getDtcotac()));
            precificacaoVO.setCustoext(response.getNpccwyrsresponse().getCustoext());
            precificacaoVO.setCustoExternoFormat(SiteUtil.trocarPontoPorVirgula(precificacaoVO.getCustoext()));
            precificacaoVO.setIsglindcdfonte(response.getNpccwyrsresponse().getIsglindcdfonte());
            precificacaoVO.setPrzomediodsembm(response.getNpccwyrsresponse().getPrzomediodsembm());
            precificacaoVO.setSpreadclean(response.getNpccwyrsresponse().getSpreadclean());
            precificacaoVO.setDlimfndngcmbio(response.getNpccwyrsresponse().getDlimfndngcmbio());

            return true;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getCustoExterno | CUSTOEXTERNOCONS ------- ");
        }


    }

    /**
     * Nome: getClienteDadosRatingSegmento
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void getClienteDadosRatingSegmento(TrdFinNegocInclVO trdFinNegocVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getClienteDadosRatingSegmento | CLIEDADOSNEGOCCONS ------- ");

            Cliedadosnegocconsrequest request = new Cliedadosnegocconsrequest();
            Cliedadosnegocconsresponse response = new Cliedadosnegocconsresponse();
            Npccwxberequest entrada = new Npccwxberequest();
            Npccwxbsresponse saida = new Npccwxbsresponse();
            request.setNpccwxberequest(entrada);
            response.setNpccwxbsresponse(saida);

            entrada.setCunicpssoacmbio(trdFinNegocVO.getCunicclicmbio());
            entrada.setCdcpfcnpj(trdFinNegocVO.getCdcpfcnpj());
            if (trdFinNegocVO.getCdfilial() <= Numeros.ZERO) {
                entrada.setTipopessoa("F");
                entrada.setCdfilial(Numeros.ZERO);
            } else {
                entrada.setTipopessoa("J");
                entrada.setCdfilial(trdFinNegocVO.getCdfilial());
            }
            entrada.setCdctrlcpfcnpj(trdFinNegocVO.getCdctrlcpfcnpj());

            // Fluxo: NPCCIAPQ - Books: NPCCWXBE / NPCCWXBS
            listaSemPaginacao(request, response, "CLIEDADOSNEGOCCONS");        
                  
            trdFinNegocVO.setCtposgmtocli(saida.getCtposgmtocli());
            trdFinNegocVO.setIsgmto(saida.getIsgmto());
            trdFinNegocVO.setCrting(saida.getCrting());
            trdFinNegocVO.setCpssoaundorgnz(saida.getCpssoaundorgnz());
            trdFinNegocVO.setNsequndorgnz(saida.getNsequndorgnz());
            trdFinNegocVO.setIrzscial(saida.getIrzscial());
            trdFinNegocVO.setIciddeender(saida.getIciddeender());
            trdFinNegocVO.setCsgluf(saida.getCsgluf());
            trdFinNegocVO.setCpais(saida.getCpais());
            trdFinNegocVO.setNomeundorgnz(saida.getNomeundorgnz());
            
            if(trdFinNegocVO.isTelaInicioNegociacao()){
                trdFinNegocVO.getDadosPrecificacao().getUnidadeExternaVO().setCbanqrcmbio(saida.getCbanqrcmbio());
                trdFinNegocVO.getDadosPrecificacao().getUnidadeExternaVO().setIbanqrcmbio(saida.getIbanqrcmbio());
                trdFinNegocVO.getDadosPrecificacao().getUnidadeExternaVO().setImunintlcmbio(saida.getImunintlcmbio());
            }

            setMsgRetorno(response.getTexmens());

            return;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getClienteDadosRatingSegmento | CLIEDADOSNEGOCCONS ------- ");
        }

    }

    /**
     * Nome: getSpreadNegociado
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    
    public TrdFinNegComissaoVO getSpreadNegociado(TrdFinNegComissaoVO comissaoVO, List<TrdFinNegComissaoVO> listaComissoes, 
            ComissaoCollection comissaoAdicional, Integer prazoMedio, String ptxfixacmbio) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.getSpreadNegociado | SPREADNEGOCCALC ------- ");
            
            List<Npccwxxerequest_lista> listaDesembolso = new ArrayList<Npccwxxerequest_lista>();
            List<Npccwxxerequest_lstcadis> listaAdicional = new ArrayList<Npccwxxerequest_lstcadis>();

            Spreadnegoccalcrequest request = new Spreadnegoccalcrequest();
            Spreadnegoccalcresponse response = new Spreadnegoccalcresponse();
            Npccwxxerequest entrada = new Npccwxxerequest();
            Npccwxxsresponse saida = new Npccwxxsresponse();
            request.setNpccwxxerequest(entrada);
            response.setNpccwxxsresponse(saida);

            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomiscmbio());
            entrada.setVlxcomiscmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxcomiscmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPjuronegoccmbio()));
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setVlxoperaccmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVlxoperaccmbio()));
            entrada.setPrzoperaccmbio(comissaoVO.getPrzoperaccmbio());
            entrada.setCcomiscartanacio(comissaoVO.getCcomiscartanacio());
            entrada.setCindcdnegocswap(comissaoVO.getCindcdnegocswap());
            
            if (SiteUtil.isEmptyOrNull(ptxfixacmbio)) {
            	ptxfixacmbio = new String("0.00");
			}
            if (ptxfixacmbio.equals("0.00") || ptxfixacmbio.equals("0,00")) {
            	entrada.setVtravaliborcmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVtravaliborcmbio()));
			} else {
				entrada.setVtravaliborcmbio(SiteUtil.webMoedaToMainframe("0.00"));
			}
            
            entrada.setPtxcustoexter(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxcustoexter()));
            entrada.setPtximpstrenda(SiteUtil.formatarPontosVirgula(comissaoVO.getPtximpstrenda()));
            entrada.setPrzoperaclibor(comissaoVO.getPrzoperaclibor());
            entrada.setCprodtservc(comissaoVO.getCprodtservc());
            entrada.setVlimcobervar(SiteUtil.formatarPontosVirgula(comissaoVO.getVlimcobervar()));
            
            entrada.setPtxfixacmbio(SiteUtil.webMoedaToMainframe(ptxfixacmbio));
            entrada.setQtdeprzomedio(prazoMedio);
            entrada.setTdiafinandsemb(comissaoVO.getTdiafinandsemb());
            
            for (Iterator<TrdFinNegComissaoVO> iterator = listaComissoes.iterator(); iterator.hasNext();) {
                TrdFinNegComissaoVO item = (TrdFinNegComissaoVO) iterator.next();
                Npccwxxerequest_lista itemComissao = new Npccwxxerequest_lista();
                itemComissao.setLista_vprevtcomiscmbio(SiteUtil.webMoedaToMainframe(item.getVprevtcomiscmbio()));
                
                listaDesembolso.add(itemComissao);
            }
            
            entrada.setLista(listaDesembolso);
            entrada.setQtdocorr(listaDesembolso.size());
            
            for (Iterator<IComissaoExterna> iterator =  comissaoAdicional.getComissaoAdicional().iterator(); iterator.hasNext();) {
                TrdFinNegComissaoVO itemLista = (TrdFinNegComissaoVO) iterator.next();
                Npccwxxerequest_lstcadis comisAdis = new Npccwxxerequest_lstcadis();
                
                comisAdis.setLstcadis_vlrcomisadic(SiteUtil.formatarPontosVirgula(itemLista.getVprevtcomiscmbio()));
                listaAdicional.add(comisAdis);
            }
            
            entrada.setLstcadis(listaAdicional);
            entrada.setQtdcomisadic(listaAdicional.size());

            // Fluxo: NPCCIASO - Books: NPCCWXXE / NPCCWXXS
            listaSemPaginacao(request, response, "SPREADNEGOCCALC");

            comissaoVO.setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(response.getNpccwxxsresponse().getVtxspreadnegoc()));
            comissaoVO.setPtxflatpnalt(SiteUtil.trocarPontoPorVirgula(response.getNpccwxxsresponse().getPtxflatpnalt()));
            comissaoVO.setVlxtotalcomis(SiteUtil.trocarPontoPorVirgula(response.getNpccwxxsresponse().getVlxtotalcomis()));
            comissaoVO.setDsccustototal(response.getNpccwxxsresponse().getDsccustototal().replaceAll("_", "+"));
            comissaoVO.setVtxspreadtot(SiteUtil.trocarPontoPorVirgula(response.getNpccwxxsresponse().getVtxspreadtot()));

            // Manter o spread aprovado no limite (selecionado no modal de limites)
            comissaoVO.setPtxcustototal(comissaoVO.getPtxcustototal());
        } catch (NpccTradeWebException e){
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.getSpreadNegociado | SPREADNEGOCCALC ------- ");
        }
        return comissaoVO;
    }
    
    // METODOS INCLUIR

    /**
     * Nome: incluirFinimpOuRefinimpDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFinimpOuRefinimpDireto | FINIMPDIRETOINCL ------- ");

            Finimpdiretoinclrequest request = new Finimpdiretoinclrequest();
            Finimpdiretoinclresponse response = new Finimpdiretoinclresponse();
            Npccwv3erequest entrada = new Npccwv3erequest();
            Npccwv3sresponse saida = new Npccwv3sresponse();
            request.setNpccwv3erequest(entrada);
            response.setNpccwv3sresponse(saida);

            entrada.setCaditvbletocmbio(finDiretoVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finDiretoVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finDiretoVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finDiretoVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finDiretoVO.getCsitbletocmbio());
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setNseqcontrlim(finDiretoVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finDiretoVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finDiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finDiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finDiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finDiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finDiretoVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finDiretoVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finDiretoVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finDiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finDiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finDiretoVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finDiretoVO.getCeconmmoedadsemb());
            entrada.setCrting(finDiretoVO.getCrting());

            entrada.setCindcdnegocswap(finDiretoVO.getCindcdnegocswap());
            if (finDiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finDiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finDiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finDiretoVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finDiretoVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finDiretoVO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(finDiretoVO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finDiretoVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finDiretoVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finDiretoVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finDiretoVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(finDiretoVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(finDiretoVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finDiretoVO.getCmodcontrcmbio());
            entrada.setDprevtdsembcmbio(finDiretoVO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finDiretoVO.getRjustfdqmto());
            entrada.setDprevtembrq(finDiretoVO.getDprevtembrq());

            // Fluxo: NPCCIAPT - Books: NPCCWV3E / NPCCWV3S
            listaSemPaginacao(request, response, "FINIMPDIRETOINCL");

            setMsgRetorno(response.getTexmens());

            finDiretoVO.setNbletonegoccmbio(response.getNpccwv3sresponse().getNbletonegoccmbio());
            finDiretoVO.setHinclreg(response.getNpccwv3sresponse().getHinclreg());
            finDiretoVO.setNbletocmbioano(response.getNpccwv3sresponse().getNbletocmbioano());
            finDiretoVO.setDanobase(response.getNpccwv3sresponse().getDanobase());

            return finDiretoVO;

        }catch(Exception e){
            setMsgRetorno(null);
            System.out.println("erro");
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFinimpOuRefinimpDireto | FINIMPDIRETOINCL ------- ");
        }
        return finDiretoVO;

    }

    /**
     * Nome: incluirFinimpOuRefinimpIndireto
     * 
     * Propï¿½sito: Finimp Indireto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpIndireto(TrdFinNegocInclVO finIndiretoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFinimpOuRefinimpIndireto | FINIMPINDIRETOINCL ------- ");

            Finimpindiretoinclrequest request = new Finimpindiretoinclrequest();
            Finimpindiretoinclresponse response = new Finimpindiretoinclresponse();
            Npccwv4erequest entrada = new Npccwv4erequest();
            Npccwv4sresponse saida = new Npccwv4sresponse();
            request.setNpccwv4erequest(entrada);
            response.setNpccwv4sresponse(saida);

            entrada.setCaditvbletocmbio(finIndiretoVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finIndiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finIndiretoVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finIndiretoVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finIndiretoVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finIndiretoVO.getCsitbletocmbio());
            entrada.setCprodtservc(finIndiretoVO.getCprodtservc());
            entrada.setNseqcontrlim(finIndiretoVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finIndiretoVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finIndiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finIndiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finIndiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finIndiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finIndiretoVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finIndiretoVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finIndiretoVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finIndiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finIndiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finIndiretoVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finIndiretoVO.getCeconmmoedadsemb());
            entrada.setCrting(finIndiretoVO.getCrting());

            entrada.setCindcdnegocswap(finIndiretoVO.getCindcdnegocswap());
            if (finIndiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finIndiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finIndiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finIndiretoVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finIndiretoVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finIndiretoVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finIndiretoVO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(finIndiretoVO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finIndiretoVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finIndiretoVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finIndiretoVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finIndiretoVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVmultanegoccmbio()));

            entrada.setCsegurtrnspmcado(finIndiretoVO.getCsegurtrnspmcado());

            entrada.setCsegurmcadoorgnz(finIndiretoVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finIndiretoVO.getCmodcontrcmbio());

            entrada.setDprevtdsembcmbio(finIndiretoVO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finIndiretoVO.getRjustfdqmto());
            entrada.setDprevtembrq(finIndiretoVO.getDprevtembrq());

            // Fluxo: NPCCIAPU - Books: NPCCWV4E / NPCCWV4S
            listaSemPaginacao(request, response, "FINIMPINDIRETOINCL");

            setMsgRetorno(response.getTexmens());

            finIndiretoVO.setNbletonegoccmbio(response.getNpccwv4sresponse().getNbletonegoccmbio());
            finIndiretoVO.setHinclreg(response.getNpccwv4sresponse().getHinclreg());
            finIndiretoVO.setNbletocmbioano(response.getNpccwv4sresponse().getNbletocmbioano());
            finIndiretoVO.setDanobase(response.getNpccwv4sresponse().getDanobase());

            return finIndiretoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFinimpOuRefinimpIndireto | FINIMPINDIRETOINCL ------- ");
        }
    }

    /**
     * Nome: incluirLei4131
     * 
     * Propï¿½sito: Incluir cotação LEI 4131
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirLei4131(TrdFinNegocInclVO finLei4131VO) {


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirLei4131 | COTACAOLEI4131INCL ------- ");

            Cotacaolei4131inclrequest request = new Cotacaolei4131inclrequest();
            Cotacaolei4131inclresponse response = new Cotacaolei4131inclresponse();
            Npccwv0erequest entrada = new Npccwv0erequest();
            Npccwv0sresponse saida = new Npccwv0sresponse();
            request.setNpccwv0erequest(entrada);
            response.setNpccwv0sresponse(saida);

            entrada.setCaditvbletocmbio(finLei4131VO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finLei4131VO.getCunicclicmbio());
            entrada.setCpssoajurid(finLei4131VO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finLei4131VO.getNsequndorgnz());
            entrada.setCtposgmtocli(finLei4131VO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finLei4131VO.getCsitbletocmbio());
            entrada.setCprodtservc(finLei4131VO.getCprodtservc());
            entrada.setNseqcontrlim(finLei4131VO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finLei4131VO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finLei4131VO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finLei4131VO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finLei4131VO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finLei4131VO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finLei4131VO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finLei4131VO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finLei4131VO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finLei4131VO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finLei4131VO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finLei4131VO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finLei4131VO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finLei4131VO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finLei4131VO.getCeconmmoedadsemb());
            entrada.setCrting(finLei4131VO.getCrting());

            entrada.setCindcdnegocswap(finLei4131VO.getCindcdnegocswap());
            if (finLei4131VO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finLei4131VO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finLei4131VO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finLei4131VO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finLei4131VO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finLei4131VO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finLei4131VO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(finLei4131VO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finLei4131VO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finLei4131VO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finLei4131VO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finLei4131VO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finLei4131VO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finLei4131VO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finLei4131VO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finLei4131VO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finLei4131VO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finLei4131VO.getVmultanegoccmbio()));

            entrada.setCsegurtrnspmcado(finLei4131VO.getCsegurtrnspmcado());

            entrada.setCsegurmcadoorgnz(finLei4131VO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finLei4131VO.getCmodcontrcmbio());

            entrada.setDprevtdsembcmbio(finLei4131VO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finLei4131VO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(SiteUtil.formatarPontosVirgula(finLei4131VO.getRjustfdqmto()));

            // Fluxo: NPCCIAPZ - Books: NPCCWV0E / NPCCWV0S
            listaSemPaginacao(request, response, "COTACAOLEI4131INCL");

            setMsgRetorno(response.getTexmens());

            finLei4131VO.setNbletonegoccmbio(response.getNpccwv0sresponse().getNbletonegoccmbio());
            finLei4131VO.setHinclreg(response.getNpccwv0sresponse().getHinclreg());
            finLei4131VO.setNbletocmbioano(response.getNpccwv0sresponse().getNbletocmbioano());
            finLei4131VO.setDanobase(response.getNpccwv0sresponse().getDanobase());

            return finLei4131VO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirLei4131 | COTACAOLEI4131INCL ------- ");
        }

    }

    /**
     * Nome: incluirPPE
     * 
     * Propï¿½sito: Incluir cotação PPE
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirPPE(TrdFinNegocInclVO finPpeVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirPPE | COTACAOPPEINCL ------- ");

            Cotacaoppeinclrequest request = new Cotacaoppeinclrequest();
            Cotacaoppeinclresponse response = new Cotacaoppeinclresponse();
            Npccwv9erequest entrada = new Npccwv9erequest();
            Npccwv9sresponse saida = new Npccwv9sresponse();
            request.setNpccwv9erequest(entrada);
            response.setNpccwv9sresponse(saida);

            entrada.setCaditvbletocmbio(finPpeVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finPpeVO.getCunicclicmbio());
            entrada.setCpssoajurid(finPpeVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finPpeVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finPpeVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finPpeVO.getCsitbletocmbio());
            entrada.setCprodtservc(finPpeVO.getCprodtservc());
            entrada.setNseqcontrlim(finPpeVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finPpeVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finPpeVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finPpeVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finPpeVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finPpeVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finPpeVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finPpeVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finPpeVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finPpeVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finPpeVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finPpeVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finPpeVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finPpeVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finPpeVO.getCeconmmoedadsemb());
            entrada.setCrting(finPpeVO.getCrting());

            entrada.setCindcdnegocswap(finPpeVO.getCindcdnegocswap());
            if (finPpeVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finPpeVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finPpeVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finPpeVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finPpeVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finPpeVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finPpeVO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(finPpeVO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finPpeVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finPpeVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finPpeVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finPpeVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finPpeVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finPpeVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finPpeVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finPpeVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finPpeVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finPpeVO.getVmultanegoccmbio()));

            entrada.setCsegurtrnspmcado(finPpeVO.getCsegurtrnspmcado());

            entrada.setCsegurmcadoorgnz(finPpeVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finPpeVO.getCmodcontrcmbio());

            entrada.setDprevtdsembcmbio(finPpeVO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finPpeVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finPpeVO.getRjustfdqmto());

            // Fluxo: NPCCIAP1 - Books: NPCCWV9E / NPCCWV9S
            listaSemPaginacao(request, response, "COTACAOPPEINCL");

            setMsgRetorno(response.getTexmens());

            finPpeVO.setNbletonegoccmbio(response.getNpccwv9sresponse().getNbletonegoccmbio());
            finPpeVO.setHinclreg(response.getNpccwv9sresponse().getHinclreg());
            finPpeVO.setNbletocmbioano(response.getNpccwv9sresponse().getNbletocmbioano());
            finPpeVO.setDanobase(response.getNpccwv9sresponse().getDanobase());

            return finPpeVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirPPE | COTACAOPPEINCL ------- ");
        }

    }

    /**
     * Nome: incluirWorkingCapital
     * 
     * Propï¿½sito: Incluir cotação Working Capital
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirWorkingCapital(TrdFinNegocInclVO finWorkCapitalVO) {


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirWorkingCapital | COTACWORKCAPITALINCL ------- ");

            Cotacworkcapitalinclrequest request = new Cotacworkcapitalinclrequest();
            Cotacworkcapitalinclresponse response = new Cotacworkcapitalinclresponse();
            Npccww1erequest entrada = new Npccww1erequest();
            Npccww1sresponse saida = new Npccww1sresponse();
            request.setNpccww1erequest(entrada);
            response.setNpccww1sresponse(saida);

            entrada.setCaditvbletocmbio(finWorkCapitalVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finWorkCapitalVO.getCunicclicmbio());
            entrada.setCpssoajurid(finWorkCapitalVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finWorkCapitalVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finWorkCapitalVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finWorkCapitalVO.getCsitbletocmbio());
            entrada.setCprodtservc(finWorkCapitalVO.getCprodtservc());
            entrada.setNseqcontrlim(finWorkCapitalVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finWorkCapitalVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finWorkCapitalVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finWorkCapitalVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finWorkCapitalVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finWorkCapitalVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finWorkCapitalVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finWorkCapitalVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finWorkCapitalVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finWorkCapitalVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finWorkCapitalVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finWorkCapitalVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finWorkCapitalVO.getCeconmmoedadsemb());
            entrada.setCrting(finWorkCapitalVO.getCrting());

            entrada.setCindcdnegocswap(finWorkCapitalVO.getCindcdnegocswap());
            if (finWorkCapitalVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finWorkCapitalVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finWorkCapitalVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finWorkCapitalVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finWorkCapitalVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finWorkCapitalVO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(finWorkCapitalVO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finWorkCapitalVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finWorkCapitalVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finWorkCapitalVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finWorkCapitalVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVmultanegoccmbio()));

            entrada.setCsegurtrnspmcado(finWorkCapitalVO.getCsegurtrnspmcado());

            entrada.setCsegurmcadoorgnz(finWorkCapitalVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finWorkCapitalVO.getCmodcontrcmbio());

            entrada.setDprevtdsembcmbio(finWorkCapitalVO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finWorkCapitalVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finWorkCapitalVO.getRjustfdqmto());

            // Fluxo: NPCCIAP3 - Books: NPCCWW1E / NPCCWW1S
            listaSemPaginacao(request, response, "COTACWORKCAPITALINCL");

            setMsgRetorno(response.getTexmens());

            finWorkCapitalVO.setNbletonegoccmbio(response.getNpccww1sresponse().getNbletonegoccmbio());
            finWorkCapitalVO.setHinclreg(response.getNpccww1sresponse().getHinclreg());
            finWorkCapitalVO.setNbletocmbioano(response.getNpccww1sresponse().getNbletocmbioano());
            finWorkCapitalVO.setDanobase(response.getNpccww1sresponse().getDanobase());

            return finWorkCapitalVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirWorkingCapital | COTACWORKCAPITALINCL ------- ");
        }

    }

    /**
     * Nome: incluirForfaiting
     * 
     * Propï¿½sito: Incluir cotação Forfaiting
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO incluirForfaiting(TrdFinNegocInclVO forfaitingVO) {


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirForfaiting | COTACFORFAITINGINCL ------- ");

            String dtPeriodoIni = null;
            String dtPeriodoFim = null;

            Cotacforfaitinginclrequest request = new Cotacforfaitinginclrequest();
            Cotacforfaitinginclresponse response = new Cotacforfaitinginclresponse();
            Npccwv5erequest entrada = new Npccwv5erequest();
            Npccwv5sresponse saida = new Npccwv5sresponse();
            request.setNpccwv5erequest(entrada);
            response.setNpccwv5sresponse(saida);

            entrada.setCaditvbletocmbio(forfaitingVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(forfaitingVO.getCunicclicmbio());
            entrada.setCpssoajurid(forfaitingVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(forfaitingVO.getNsequndorgnz());
            entrada.setCtposgmtocli(forfaitingVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(forfaitingVO.getCsitbletocmbio());
            entrada.setCprodtservc(forfaitingVO.getCprodtservc());
            entrada.setNseqcontrlim(forfaitingVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(forfaitingVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(forfaitingVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(forfaitingVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(forfaitingVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(forfaitingVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(forfaitingVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(forfaitingVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(forfaitingVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(forfaitingVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(forfaitingVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(forfaitingVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(forfaitingVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(forfaitingVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(forfaitingVO.getCeconmmoedadsemb());
            entrada.setCrting(forfaitingVO.getCrting());

            entrada.setCindcdnegocswap(forfaitingVO.getCindcdnegocswap());
            if (forfaitingVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (forfaitingVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (forfaitingVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(forfaitingVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(forfaitingVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(forfaitingVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(forfaitingVO.getTdiavalddletra());

            entrada.setDvalddnegoccmbio(forfaitingVO.getDvalddnegoccmbio());

            entrada.setDprevtgarntexpdi(SiteUtil.dataWebToMainframe(forfaitingVO.getDprevtgarntexpdi()));

            entrada.setCcomiscartanacio(forfaitingVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(forfaitingVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(forfaitingVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(forfaitingVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVmultanegoccmbio()));

            entrada.setCsegurtrnspmcado(forfaitingVO.getCsegurtrnspmcado());

            entrada.setCsegurmcadoorgnz(forfaitingVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(forfaitingVO.getCmodcontrcmbio());
            entrada.setCtpojurotrade(forfaitingVO.getCtpojurotrade());

            /**** Dados diferenciados FORFAITING *****/
            entrada.setCcobrcomisadcio(forfaitingVO.getCcobrcomisadcio());
            entrada.setPcobervarprodt(SiteUtil.formatarPontosVirgula(forfaitingVO.getPcobervarprodt()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getPjuronegoccmbio()));

            if (forfaitingVO.getDataPrevDesemb() == null || forfaitingVO.getDataPrevDesemb().getInicio() == null
                    || forfaitingVO.getDataPrevDesemb().getFim() == null) {
                entrada.setDabertcntragarnt("");
                entrada.setDvctocntragarnt("");
            } else {
                dtPeriodoIni = SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevDesemb().getInicio());
                entrada.setDabertcntragarnt(dtPeriodoIni.equals("0") ? "" : dtPeriodoIni);
                dtPeriodoFim = SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevDesemb().getFim());
                entrada.setDvctocntragarnt(dtPeriodoFim.equals("0") ? "" : dtPeriodoFim);
            }
            
            if (forfaitingVO.getDataPrevEmbarq() == null || forfaitingVO.getDataPrevEmbarq().getInicio() == null
                    || forfaitingVO.getDataPrevEmbarq().getFim() == null) {
                entrada.setDprevtinicembrq("");
                entrada.setDprevtfimembrq("");
            } else {
                dtPeriodoIni = SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevEmbarq().getInicio());
                entrada.setDprevtinicembrq(dtPeriodoIni.equals("0") ? "" : dtPeriodoIni);
                dtPeriodoFim = SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevEmbarq().getFim());
                entrada.setDprevtfimembrq(dtPeriodoFim.equals("0") ? "" : dtPeriodoFim);
            }
            
            entrada.setDprevtdsembcmbio(forfaitingVO.getDprevtdsembcmbio());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(forfaitingVO.getRjustfdqmto());

            // Fluxo: NPCCIAPW - Books: NPCCWV5E / NPCCWV5S
            listaSemPaginacao(request, response, "COTACFORFAITINGINCL");

            setMsgRetorno(response.getTexmens());

            forfaitingVO.setNbletonegoccmbio(response.getNpccwv5sresponse().getNbletonegoccmbio());
            forfaitingVO.setHinclreg(response.getNpccwv5sresponse().getHinclreg());
            forfaitingVO.setNbletocmbioano(response.getNpccwv5sresponse().getNbletocmbioano());
            forfaitingVO.setDanobase(response.getNpccwv5sresponse().getDanobase());

            return forfaitingVO;
        }catch (Exception e){
            setMsgRetorno(null);
            System.out.println("erro");
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirForfaiting | COTACFORFAITINGINCL ------- ");
        }
        return forfaitingVO;

    }

    /**
     * Nome: incluirDesembolsoForfaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 14/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void incluirDesembolsoForfaiting(TradeFinanceDesembolsoVO desembolsoVO) {


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirDesembolsoForfaiting | DESINCLFORFAITING ------- ");

            Desinclforfaitingrequest request = new Desinclforfaitingrequest();
            Desinclforfaitingresponse response = new Desinclforfaitingresponse();
            Npccwwxerequest entrada = new Npccwwxerequest();
            Npccwwxsresponse saida = new Npccwwxsresponse();
            request.setNpccwwxerequest(entrada);
            response.setNpccwwxsresponse(saida);

            entrada.setNbletonegoccmbio(desembolsoVO.getNbletonegoccmbio());
            entrada.setHinclreg(desembolsoVO.getHinclreg());
            entrada.setDprevtdsembcmbio(desembolsoVO.getDataDesembolsoFormat());
            entrada.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVprevtdsembcmbio()));
            entrada.setVdsembnegoccmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVdsembnegoccmbio()));
            entrada.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVtxliborcmbio()));
            entrada.setPtxjurofndng(SiteUtil.formatarPontosVirgula(desembolsoVO.getPtxjurofndng()));
            entrada.setPspreadtxcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getPspreadtxcmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getPjuronegoccmbio()));
            entrada.setTdiafinandsemb(desembolsoVO.getTdiafinandsemb());
            entrada.setVjurodsembcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVjurodsembcmbio()));
            entrada.setCmomencobrcmbio(desembolsoVO.getCmomencobrcmbio());

            entrada.setQtdoclist(0);

            List<Npccwwxerequest_lstlis> lista = new ArrayList<Npccwwxerequest_lstlis>();
            entrada.setLstlis(lista);

            // Fluxo: NPCCIAQC - Books: NPCCWWXE / NPCCWWXS
            listaSemPaginacao(request, response, "DESINCLFORFAITING");


        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirDesembolsoForfaiting | DESINCLFORFAITING ------- ");
        }


    }

    /**
     * Nome: incluirFluxoPagtoPrincJurosFinimpDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirFluxoPagtoPrincJurosFinimpDireto(TrdFinNegFluxoPagtoVO flxPgtVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoPrincJurosFinimpDireto | FNDRFLXPGTPRCJRSINCL ------- ");

            Fndrflxpgtprcjrsinclrequest request = new Fndrflxpgtprcjrsinclrequest();
            Fndrflxpgtprcjrsinclresponse response = new Fndrflxpgtprcjrsinclresponse();
            Npccwykerequest entrada = new Npccwykerequest();
            Npccwyksresponse saida = new Npccwyksresponse();
            request.setNpccwykerequest(entrada);
            response.setNpccwyksresponse(saida);

            entrada.setNbletonegoccmbio(flxPgtVO.getNbletonegoccmbio());
            entrada.setHinclreg(flxPgtVO.getHinclreg());
            entrada.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(flxPgtVO.getVprevtdsembcmbio()));
            entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPgtVO.getDateFluxoPgto()));
            entrada.setTdiacarenprinc(flxPgtVO.getTdiacarenprinc());
            entrada.setCfluxoliqdcprinc(flxPgtVO.getCfluxoliqdcprinc());
            entrada.setQpcelatradeprinc(flxPgtVO.getQtdeocorrprinc());
            entrada.setTdiacarenjuro(flxPgtVO.getJurosCarencia());
            entrada.setTdiafinandsemb(flxPgtVO.getTdiafinandsemb());
            entrada.setCfluxoliqdcjuro(flxPgtVO.getCodJurosPeriodicidade());
            entrada.setQpcelatradejuro(flxPgtVO.getQtdeocorrjuros());
            entrada.setCmomencobrcmbio(flxPgtVO.getCodJurosMomento());
            entrada.setQtdoclist(flxPgtVO.getListaParcelasFluxoPgto().size());

            List<Npccwykerequest_lstlis> lista = new ArrayList<Npccwykerequest_lstlis>();

            for (Iterator<TrdFinNegParcelaVO> iterator = flxPgtVO.getListaParcelasFluxoPgto().iterator(); iterator
                            .hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwykerequest_lstlis itemLista = new Npccwykerequest_lstlis();

                itemLista.setLstlis_tipopcelatrade(itemParcela.getTpparcela());
                itemLista.setLstlis_npceladsembtrade(itemParcela.getNpceladsembtrade());
                itemLista.setLstlis_tdianegocpcela(itemParcela.getTdianegocpcela());
                itemLista.setLstlis_dvctopcelatrade(itemParcela.getDvctopcelatrade());
                itemLista.setLstlis_vpcelamesatrade(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelamesatrade()));

                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            // Fluxo: NPCCIASQ - Books: NPCCWYKE / NPCCWYKS
            listaSemPaginacao(request, response, "FNDRFLXPGTPRCJRSINCL");

            return;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoPrincJurosFinimpDireto | FNDRFLXPGTPRCJRSINCL ------- ");
        }


    }
    
    /**
     * Nome: incluirFluxoPagtoPrincJurosNCEAditarFace
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirFluxoPagtoPrincJurosNCEAditarFaKe(TrdFinNegFluxoPagtoVO flxPgtVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoPrincJurosNCEAditarFaKe | FLXPGTPRCJRSINCLFAKE ------- ");
            
            Flxpgtprcjrsinclfakerequest request = new Flxpgtprcjrsinclfakerequest();
            Flxpgtprcjrsinclfakeresponse response = new Flxpgtprcjrsinclfakeresponse();
            Npccwwgerequest entrada = new Npccwwgerequest();
            Npccwwgsresponse saida = new Npccwwgsresponse();
            request.setNpccwwgerequest(entrada);
            response.setNpccwwgsresponse(saida);
            
            entrada.setNbletonegoccmbio(flxPgtVO.getNbletonegoccmbio());
            entrada.setHinclreg(flxPgtVO.getHinclreg());
            entrada.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(flxPgtVO.getVprevtdsembcmbio()));
            entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPgtVO.getDateFluxoPgto()));
            entrada.setTdiacarenprinc(flxPgtVO.getTdiacarenprinc());
            entrada.setCfluxoliqdcprinc(flxPgtVO.getCfluxoliqdcprinc());
            entrada.setQpcelatradeprinc(flxPgtVO.getQtdeocorrprinc());
            entrada.setTdiacarenjuro(flxPgtVO.getJurosCarencia());
            entrada.setTdiafinandsemb(flxPgtVO.getTdiafinandsemb());
            entrada.setCfluxoliqdcjuro(flxPgtVO.getCodJurosPeriodicidade());
            entrada.setQpcelatradejuro(flxPgtVO.getQtdeocorrjuros());
            entrada.setCmomencobrcmbio(flxPgtVO.getCodJurosMomento());
            entrada.setQtdoclist(flxPgtVO.getListaParcelasFluxoPgto().size());

            entrada.setNdsembcmbiotrade(flxPgtVO.getNdsembcmbiotrade());
            
            List<Npccwwgerequest_lstlis> lista = new ArrayList<Npccwwgerequest_lstlis>();
            
            for (Iterator<TrdFinNegParcelaVO> iterator = flxPgtVO.getListaParcelasFluxoPgto().iterator(); iterator
                    .hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();
                
                Npccwwgerequest_lstlis itemLista = new Npccwwgerequest_lstlis();
                
                itemLista.setLstlis_tipopcelatrade(itemParcela.getTpparcela());
                itemLista.setLstlis_npceladsembtrade(itemParcela.getNpceladsembtrade());
                itemLista.setLstlis_tdianegocpcela(itemParcela.getTdianegocpcela());
                itemLista.setLstlis_dvctopcelatrade(itemParcela.getDvctopcelatrade());
                itemLista.setLstlis_vpcelamesatrade(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelamesatrade()));
                
                lista.add(itemLista);
                
            }
            entrada.setLstlis(lista);
            
            // Fluxo: NPCCIASQ - Books: NPCCWWGE / NPCCWWGS
            listaSemPaginacao(request, response, "FLXPGTPRCJRSINCLFAKE");
            
            return;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoPrincJurosNCEAditarFaKe | FLXPGTPRCJRSINCLFAKE ------- ");
        }
        
        
    }

    /**
     * Nome: incluirFluxoPagtoComissaoExternaFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirFluxoPagtoComissaoExternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoExternaFinOuRefinDireto | FNDRFLXPGTCMSSEXINCL ------- ");

            Fndrflxpgtcmssexinclrequest request = new Fndrflxpgtcmssexinclrequest();
            Fndrflxpgtcmssexinclresponse response = new Fndrflxpgtcmssexinclresponse();
            Npccwymerequest entrada = new Npccwymerequest();
            Npccwymsresponse saida = new Npccwymsresponse();
            request.setNpccwymerequest(entrada);
            response.setNpccwymsresponse(saida);

            entrada.setCprodtservc(codProduto);
            entrada.setNbletonegoccmbio(comissaoVO.getNbletonegoccmbio());
            entrada.setHinclreg(comissaoVO.getHinclreg());
            entrada.setCcondceconc(comissaoVO.getCcondceconc());            
            
            if(codProduto.equals(EnumProduto.LC_IMPORTACAO.getCodigo()) || codProduto.equals(EnumProduto.GARANTIAS_EXPEDIDAS_FINANCEIRA.getCodigo())
                            || codProduto.equals(EnumProduto.GARANTIAS_EXPEDIDAS_IMPORTACAO.getCodigo())) {
                
                entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPjuronegoccmbio()));
            }else {
                entrada.setPcomisnegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPjuronegoccmbio()));
            }
            
            if(comissaoVO.getListaParcelasComissao() != null && comissaoVO.getListaParcelasComissao().size() > 0){
                entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getListaParcelasComissao().get(0).getPjuronegoccmbio()));
            }
            
            if(comissaoVO.getCfluxoperdccmbio() == EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) {
                entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPjuronegoccmbio()));
            }
            entrada.setVprevtcomiscmbio(SiteUtil.webMoedaToMainframe(comissaoVO.getVprevtcomiscmbio()));
            entrada.setCperdcjurocmbio(comissaoVO.getCperdcjurocmbio());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setCfluxoperdccmbio(comissaoVO.getCfluxoperdccmbio());
            entrada.setCmomencobrcmbio(comissaoVO.getCodMomentoComissao());
            entrada.setQpcelacmbiotrade(comissaoVO.getQpcelacmbiotrade());
            entrada.setCrespcomisexter(comissaoVO.getCrespcomisexter());

            entrada.setQtdoclist(comissaoVO.getListaParcelasComissao().size());

            List<Npccwymerequest_lstlis> lista = new ArrayList<Npccwymerequest_lstlis>();

            for (Iterator<TrdFinNegParcelaVO> iterator = comissaoVO.getListaParcelasComissao().iterator(); iterator
                            .hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwymerequest_lstlis itemLista = new Npccwymerequest_lstlis();

                itemLista.setLstlis_npcelacomisexter(itemParcela.getNpcelacomis());
                itemLista.setLstlis_dvctopcelatrade(SiteUtil.stringDataWebToMainframe(itemParcela.getDvctopcelatrade()));
                itemLista.setLstlis_vpcelacomiscmbio(itemParcela.getVpcelacomiscmbio());

                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            // Fluxo: NPCCIASS - Books: NPCCWYME / NPCCWYMS
            listaSemPaginacao(request, response, "FNDRFLXPGTCMSSEXINCL");

            return;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoExternaFinOuRefinDireto | FNDRFLXPGTCMSSEXINCL ------- ");
        }


    }

    /**
     * Nome: incluirFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoInternaFinOuRefinDireto | FNDRFLXPGTCMSSININCL ------- ");

            Fndrflxpgtcmssininclrequest request = new Fndrflxpgtcmssininclrequest();
            Fndrflxpgtcmssininclresponse response = new Fndrflxpgtcmssininclresponse();
            Npccwylerequest entrada = new Npccwylerequest();
            Npccwylsresponse saida = new Npccwylsresponse();
            request.setNpccwylerequest(entrada);
            response.setNpccwylsresponse(saida);

            entrada.setCprodtservc(codProduto);
            entrada.setNbletonegoccmbio(comissaoVO.getNbletonegoccmbio());
            entrada.setHinclreg(comissaoVO.getHinclreg());
            entrada.setCfluxoperdccmbio(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setVprevtcomiscmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getVprevtcomiscmbio()));
            entrada.setVmincobrcomis(SiteUtil.formatarPontosVirgula(comissaoVO.getVmincobrcomis()));
            entrada.setVtxspreadaprov(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxcustototal()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(comissaoVO.getVtxspreadnegoc()));
            entrada.setPtxflatpnalt(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxflatpnalt()));
            entrada.setPcomisnegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPcomisnegoccmbio()));
            entrada.setQpcelacmbiotrade(comissaoVO.getQpcelacmbiotrade());
            entrada.setCcobrcomiscmbio(comissaoVO.getCcobrcomiscmbio());
            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomisintrn());
            entrada.setCmomencobrcmbio(comissaoVO.getCodMomentoComissao());        

            List<Npccwylerequest_lstlis> lista = new ArrayList<Npccwylerequest_lstlis>();

            for (Iterator<TrdFinNegParcelaVO> iterator = comissaoVO.getListaParcelasComissao().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwylerequest_lstlis itemLista = new Npccwylerequest_lstlis();

                itemLista.setLstlis_npcelacomisintrn(itemParcela.getNpcelacomis());
                itemLista.setLstlis_dvctopcelatrade(SiteUtil.trocarBarraPorPonto(itemParcela.getDvctopcelatrade()));
                itemLista.setLstlis_vpcelacomiscmbio(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelacomiscmbio()));
                itemLista.setLstlis_vcustofincrcmbio(SiteUtil.formatarPontosVirgula(itemParcela.getVcustofincrcmbio()));

                lista.add(itemLista);

            }
            entrada.setLstlis(lista);
            entrada.setQtdoclist(lista.size());

            // Fluxo: NPCCIASR - Books: NPCCWYLE / NPCCWYLS
            listaSemPaginacao(request, response, "FNDRFLXPGTCMSSININCL");

            return;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoInternaFinOuRefinDireto | FNDRFLXPGTCMSSININCL ------- ");
        }


    }
    
    /**
     * Nome: incluirFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto, String ccomiscartanacio) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoInternaFinOuRefinDireto | FNDRFLXPGTCMSSININCL ------- ");

            Fndrflxpgtcmssininclrequest request = new Fndrflxpgtcmssininclrequest();
            Fndrflxpgtcmssininclresponse response = new Fndrflxpgtcmssininclresponse();
            Npccwylerequest entrada = new Npccwylerequest();
            Npccwylsresponse saida = new Npccwylsresponse();
            request.setNpccwylerequest(entrada);
            response.setNpccwylsresponse(saida);

            entrada.setCprodtservc(codProduto);
            entrada.setNbletonegoccmbio(comissaoVO.getNbletonegoccmbio());
            entrada.setHinclreg(comissaoVO.getHinclreg());
            entrada.setCfluxoperdccmbio(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setVprevtcomiscmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getVprevtcomiscmbio()));
            entrada.setVmincobrcomis(SiteUtil.formatarPontosVirgula(comissaoVO.getVmincobrcomis()));
            entrada.setVtxspreadaprov(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxcustototal()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(comissaoVO.getVtxspreadnegoc()));
            entrada.setPtxflatpnalt(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxflatpnalt()));
            entrada.setPcomisnegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPcomisnegoccmbio()));
            entrada.setQpcelacmbiotrade(comissaoVO.getQpcelacmbiotrade());
            entrada.setCcobrcomiscmbio(comissaoVO.getCcobrcomiscmbio());
            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomisintrn());
            entrada.setCmomencobrcmbio(comissaoVO.getCodMomentoComissao());        

            List<Npccwylerequest_lstlis> lista = new ArrayList<Npccwylerequest_lstlis>();
            
            if (ccomiscartanacio.equals("Sim") || ccomiscartanacio.equals("1") ) {
                for (Iterator<TrdFinNegParcelaVO> iterator = comissaoVO.getListaParcelasComissao().iterator(); iterator.hasNext();) {
                    TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                    Npccwylerequest_lstlis itemLista = new Npccwylerequest_lstlis();

                    itemLista.setLstlis_npcelacomisintrn(itemParcela.getNpcelacomis());
                    itemLista.setLstlis_dvctopcelatrade(SiteUtil.trocarBarraPorPonto(itemParcela.getDvctopcelatrade()));
                    itemLista.setLstlis_vpcelacomiscmbio(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelacomiscmbio()));
                    itemLista.setLstlis_vcustofincrcmbio(SiteUtil.formatarPontosVirgula(itemParcela.getVcustofincrcmbio()));

                    lista.add(itemLista);

                }
			}
            entrada.setLstlis(lista);
            entrada.setQtdoclist(lista.size());

            // Fluxo: NPCCIASR - Books: NPCCWYLE / NPCCWYLS
            listaSemPaginacao(request, response, "FNDRFLXPGTCMSSININCL");

            return;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirFluxoPagtoComissaoInternaFinOuRefinDireto | FNDRFLXPGTCMSSININCL ------- ");
        }


    }
    
    /**
     * Nome: incluirGarantiasVinculosTarifasObservacoesFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public void incluirGarantiasVinculosTarifasObsFinOuRefinDireto(TrdFinNegocInclVO finDiretoVO, TrdFinNegPrecificacaoVO precificacaoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirGarantiasVinculosTarifasObsFinOuRefinDireto | FNDRGRTVNCTRFOBSINCL ------- ");

            Fndrgrtvnctrfobsinclrequest request = new Fndrgrtvnctrfobsinclrequest();
            Fndrgrtvnctrfobsinclresponse response = new Fndrgrtvnctrfobsinclresponse();
            Npccwynerequest entrada = new Npccwynerequest();
            Npccwynsresponse saida = new Npccwynsresponse();
            request.setNpccwynerequest(entrada);
            response.setNpccwynsresponse(saida);

            entrada.setLstmer(new ArrayList<Npccwynerequest_lstmer>());
            entrada.setLstvin(new ArrayList<Npccwynerequest_lstvin>());
            entrada.setLsttar(new ArrayList<Npccwynerequest_lsttar>());
            entrada.setLstgar(new ArrayList<Npccwynerequest_lstgar>());
            entrada.setLstava(new ArrayList<Npccwynerequest_lstava>());


            entrada.setHinclreg(finDiretoVO.getHinclreg());
            entrada.setNbletonegoccmbio(finDiretoVO.getNbletonegoccmbio());
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());
            
            /*** CUSTO EXTERNO - TFNDNG_NEGOC_CMBIO ***/
            if(finDiretoVO.getProduto().isNce()
                    || EnumProduto.LC_IMPORTACAO.getCodigo().equals(finDiretoVO.getProduto().getCodigo())
                    || EnumProduto.PROEX.getCodigo().equals(finDiretoVO.getProduto().getCodigo())
                    || finDiretoVO.getProduto().isGarantia() 
                    || finDiretoVO.getProduto().isBndesPos()
                    || finDiretoVO.getProduto().isBndesPre()){
                
                entrada.setCbanqrcmbiofndng(SiteUtil.getLong(Numeros.ZERO));
                entrada.setDcotacfndngcmbio("");
                entrada.setDlimfndngcmbio("");
                entrada.setPtxfixacmbio("");            
                entrada.setCindcdeconmmoelib(Numeros.ZERO);
                entrada.setTdiaopercmbio(Numeros.ZERO);
                entrada.setTmesliborcmbio(Numeros.ZERO);
                entrada.setVtxliborcmbio("");
                
            } else {
                entrada.setCbanqrcmbiofndng(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
                entrada.setDcotacfndngcmbio(SiteUtil.stringDataWebToMainframe(finDiretoVO.getDadosPrecificacao().getDtcotac()));
                entrada.setDlimfndngcmbio(SiteUtil.stringDataWebToMainframe(finDiretoVO.getDadosPrecificacao().getDlimfndngcmbio()));
                entrada.setPtxfixacmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getDadosPrecificacao().getCustoext()));
                entrada.setCindcdeconmmoelib(finDiretoVO.getDadosPrecificacao().getCindcdeconmmoeda());
                entrada.setTdiaopercmbio(finDiretoVO.getDadosPrecificacao().getValidadecotac());
                entrada.setTmesliborcmbio(finDiretoVO.getDadosPrecificacao().getPrzomediodsembm());
                entrada.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getDadosPrecificacao().getSpreadclean()));
            }
            
            entrada.setCbanqrcmbiorcdor(finDiretoVO.getDadosPrecificacao().getBancoReembolsadorVO().getCbanqrcmbio());
            entrada.setCbanqrcmbioaviso(finDiretoVO.getDadosPrecificacao().getBancoAvisadorVO().getCbanqrcmbio());
            
            /*** CONTATO ***/
            entrada.setContato_contatonome(finDiretoVO.getObsCotacaoVO().getNomecttclicmbio());
            entrada.setContato_contatotele(finDiretoVO.getObsCotacaoVO().getTelcttclicmbio());

            /*** ROF ***/
            entrada.setContatorof_nome(finDiretoVO.getObsCotacaoVO().getNomerof());
            entrada.setContatorof_telefone(finDiretoVO.getObsCotacaoVO().getTelrof());
            
            if (finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo3() != null && finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo4() != null) {
                entrada.setContatorof_cpf(SiteUtil.formatarCPFCCNPJ(
                                SiteUtil.nullToInteger(finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo1()
                                                + finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo2()
                                                + finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo3()), Numeros.ZERO,
                                                SiteUtil.nullToInteger(finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo4())));

            } else {
                entrada.setContatorof_cpf("");
            }
            entrada.setContatorof_cargo(finDiretoVO.getObsCotacaoVO().getCargorof());
            entrada.setContatorof_email(finDiretoVO.getObsCotacaoVO().getEmailrof());

            /*** OUTRAS ESPECIFICAÇÕES ***/
            entrada.setOutrasespcs(LineBreaks.formatToMainframe(finDiretoVO.getObsCotacaoVO().getOutrasespcs()));

            /*** OBSERVAÇOES ***/
            entrada.setObservacao(LineBreaks.formatToMainframe(finDiretoVO.getObsCotacaoVO().getObservacaoInclusao()));//confirmar as outras obs
            
            /*** MOTIVO ***/
            entrada.setMotivo(finDiretoVO.getMotivo());

            /*** AVALISTAS - TAVALS_GARNT_CMBIO (20 OCORRENCIAS) ***/
            entrada.setQtdocaval(finDiretoVO.getListaAvalistasInclusao().size());
            
            //Aline -  Alteração no dia 25/08/2016
            //Derick - feito 27/07 solicitacao do Leandro
            entrada.setCunicpssoaindica(finDiretoVO.getDadosPrecificacao().getBancoIndicadoVO().getCbanqrcmbio());
            
            if (finDiretoVO.getProduto().isBndesPos() || finDiretoVO.getProduto().equals(EnumProduto.PROEX)) {
                entrada.setCunicpssoaindica(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
               
            } else {
                entrada.setCunicpssoacmbiot(finDiretoVO.getEcunicpssoacmbiot());
            }
            
            for (Iterator<GarantiasAvaListaVO> iterator = finDiretoVO.getListaAvalistasInclusao().iterator(); iterator.hasNext();) {
                
                GarantiasAvaListaVO itemAvalista = (GarantiasAvaListaVO) iterator.next();

                Npccwynerequest_lstava itemLista = new Npccwynerequest_lstava();

                itemLista.setLstava_cunicpssoacmbio(itemAvalista.getCunicpssoacmbio());

                entrada.getLstava().add(itemLista);

            }

            /*** MERCADORIA - TMCADO_CMBIO_TRADE (20 OCORRENCIAS) ***/
            entrada.setQtdocmerc(finDiretoVO.getListaMercadoria().size());

            for (Iterator<TrdFinNegMercadoriaVO> iterator = finDiretoVO.getListaMercadoria().iterator(); iterator.hasNext();) {
                TrdFinNegMercadoriaVO itemMerc = (TrdFinNegMercadoriaVO) iterator.next();

                Npccwynerequest_lstmer itemLista = new Npccwynerequest_lstmer();

                itemLista.setLstmer_ndsembcmbiotrade(itemMerc.getNdsembcmbiotrade());
                itemLista.setLstmer_cmcadoopercmbio(itemMerc.getCmcadoopercmbio());
                itemLista.setLstmer_cpais(itemMerc.getCpais());
                itemLista.setLstmer_cpaisembrq(itemMerc.getCpaisembrq());
                itemLista.setLstmer_cunicpssoamcado(itemMerc.getCunicpssoamcado());
                itemLista.setLstmer_cpaisbnefc(itemMerc.getCpaisbnefc());
                itemLista.setLstmer_dprevtembrq(SiteUtil.dataWebToMainframe(itemMerc.getDprevtembrq()));
                itemLista.setLstmer_qprevtembrqcmbio(itemMerc.getQprevtembrqcmbio());
                entrada.getLstmer().add(itemLista);
            }

            /*** VINCULO - TVNCLO_NEGOC_TRADE (20 OCORRENCIAS) ***/
            entrada.setQtdocvinc(finDiretoVO.getListaOperacaoVinculada().size());

            for (Iterator<TrdFinNegOperVincVO> iterator = finDiretoVO.getListaOperacaoVinculada().iterator(); iterator.hasNext();) {
                TrdFinNegOperVincVO itemOperVinc = (TrdFinNegOperVincVO) iterator.next();

                Npccwynerequest_lstvin itemLista = new Npccwynerequest_lstvin();

                itemLista.setLstvin_nbletonegocvnclo(itemOperVinc.getNbletonegoccmbio());
                
                if(SiteUtil.isEmptyOrNull(itemOperVinc.getCindcdvncloimpor())){
                    itemOperVinc.setCindcdvncloimpor("N");
                }
                itemLista.setLstvin_cindcdvncloimpor(itemOperVinc.getCindcdvncloimpor());

                entrada.getLstvin().add(itemLista);

            }

            /*** TARIFAS - TTARIF_BLETO_CMBIO (20 OCORRENCIAS) ***/
            entrada.setQtdoctari(finDiretoVO.getListaTarifas().size());

            for (Iterator<TrdFinNegTarifaVO> iterator = finDiretoVO.getListaTarifas().iterator(); iterator.hasNext();) {
                TrdFinNegTarifaVO itemTarifa = (TrdFinNegTarifaVO) iterator.next();

                Npccwynerequest_lsttar itemLista = new Npccwynerequest_lsttar();

                itemLista.setLsttar_ccondceconc(itemTarifa.getCcondceconc());
                itemLista.setLsttar_cindcdeconmmoetar(itemTarifa.getCindcdeconmmoeda());
                itemLista.setLsttar_vtarifopercmbio(SiteUtil.webMoedaToMainframe(itemTarifa.getVdespbletocmbio()));

                entrada.getLsttar().add(itemLista);

            }

            /*** GARANTIAS - TGARNT_CMBIO_EXGDO (20 OCORRENCIAS) ***/
            entrada.setQtdocgarn(finDiretoVO.getListaGarantiasInclusao().size());

            for (GarantiasVO itemGarantia : finDiretoVO.getListaGarantiasInclusao()) {

                Npccwynerequest_lstgar itemLista = new Npccwynerequest_lstgar();

                itemLista.setLstgar_ccatlggarnt(itemGarantia.getCcaractpogarnt());
                itemLista.setLstgar_cindcdeconmmoegar(itemGarantia.getCindcdeconmmoegar());
                itemLista.setLstgar_vtxgarntcmbio(SiteUtil.formatarPontosVirgula(itemGarantia.getVtxgarntcmbio()));
                itemLista.setLstgar_dvctogarntcmbio(SiteUtil.stringDataWebToMainframe(itemGarantia.getDvctogarntcmbio()));
                itemLista.setLstgar_cindcdgarntprinc(itemGarantia.getCindcdgarntprinc());
                itemLista.setLstgar_cidtfdgarntadcio(itemGarantia.getCidtfdgarntadcio());
                itemLista.setLstgar_rcomplgarntcmbio(itemGarantia.getRcomplgarntcmbio());

                entrada.getLstgar().add(itemLista);

            }
            
            // Executa chamada CWS - Fluxo: NPCCIAST - Books: NPCCWYNE / NPCCWYNS
            listaSemPaginacao(request, response, "FNDRGRTVNCTRFOBSINCL");

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirGarantiasVinculosTarifasObsFinOuRefinDireto | FNDRGRTVNCTRFOBSINCL ------- ");
        }

    }

    /**
     * 
     * Nome: incluirDadosBasicosGp1Gp3
     * Propósito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     * @throws Exception 
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 18/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO) {

       
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirDadosBasicosGp1Gp3 | DADOSBASEGP1GP3INCL ------- ");

            Dadosbasegp1gp3inclrequest request = new Dadosbasegp1gp3inclrequest();
            Dadosbasegp1gp3inclresponse response = new Dadosbasegp1gp3inclresponse();
            Npccwv2erequest entrada = new Npccwv2erequest();
            Npccwv2sresponse saida = new Npccwv2sresponse();
            request.setNpccwv2erequest(entrada);
            response.setNpccwv2sresponse(saida);


            entrada.setCusuarmanut(SiteUtil.recuperarUsuarioLogado());
            entrada.setHmanutreg(finDiretoVO.getHmanutreg());
            entrada.setNbletocmbioorige(finDiretoVO.getNbletocmbioorige());
            entrada.setCtpocanal(finDiretoVO.getCtpocanal());
            entrada.setNtpoclasfpssoa(finDiretoVO.getNtpoclasfpssoa());
            entrada.setVutlzdlimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVutlzdlimgerc()));
            entrada.setVsdolimsensi(SiteUtil.formatarPontosVirgula(finDiretoVO.getVsdolimsensi()));
            entrada.setCsitbletoaprov(finDiretoVO.getCsitbletoaprov());
            entrada.setCmotvobletocmbio(finDiretoVO.getCmotvobletocmbio());
            entrada.setCusuarincl(finDiretoVO.getCusuarincl());
            entrada.setCpssoajuridcli(finDiretoVO.getCpssoajuridcli());
            entrada.setNsequndcli(finDiretoVO.getNsequndcli());
            entrada.setDvalddlimcmbio(finDiretoVO.getDvalddlimcmbio());
            entrada.setNppstapontucmbio(finDiretoVO.getNppstapontucmbio());
            entrada.setCeconmmoedaequal(finDiretoVO.getCeconmmoedaequal());
            entrada.setCmoedaeconmrecta(finDiretoVO.getCmoedaeconmrecta());
            entrada.setCunicpssoacta(finDiretoVO.getCunicpssoacta());
            entrada.setCmodldprodtcmbio(finDiretoVO.getCmodldprodtcmbio());

            if (finDiretoVO.getPeriodoValidadeProposta() != null && finDiretoVO.getPeriodoValidadeProposta().getInicio() != null) {
                entrada.setDinicvalddppsta(SiteUtil.dataWebToMainframe(finDiretoVO.getPeriodoValidadeProposta().getInicio()));             
                entrada.setDfimvalddppsta(SiteUtil.dataWebToMainframe(finDiretoVO.getPeriodoValidadeProposta().getFim()));
            }
            
            entrada.setDinicvalddcmbio(finDiretoVO.getDinicvalddcmbio());
            
            entrada.setDfimnegoccmbio(finDiretoVO.getDfimnegoccmbio());    
            entrada.setCnegoccmbioindmd(finDiretoVO.getCnegoccmbioindmd());
            entrada.setDlimembrqcmbio(finDiretoVO.getDlimembrqcmbio());
            entrada.setDlimdoctoembrq(finDiretoVO.getDlimdoctoembrq());
            entrada.setDprevtgarntexpdi(SiteUtil.dataWebToMainframe(finDiretoVO.getDprevtgarntexpdi()));
            entrada.setTdiavalddcarta(finDiretoVO.getTdiavalddcarta());
            entrada.setQprevtembrqcmbio(finDiretoVO.getQprevtembrqcmbio());
            entrada.setQregexporcmbio(finDiretoVO.getQregexporcmbio());
            entrada.setCindcdembrqpcial(finDiretoVO.getCindcdembrqpcial());
            entrada.setCpermtrnsfcarta(finDiretoVO.getCpermtrnsfcarta());
            entrada.setCindcdcartaidpdt(finDiretoVO.getCindcdcartaidpdt());
            entrada.setCcartaconverecdd(finDiretoVO.getCcartaconverecdd());
            entrada.setCindcdlastrcarta(finDiretoVO.getCindcdlastrcarta());
            entrada.setCindcdlastragric(finDiretoVO.getCindcdlastragric());
            entrada.setCpermvarcmbio(finDiretoVO.getCpermvarcmbio());
            entrada.setCtpoembrqcmbio(finDiretoVO.getCtpoembrqcmbio());
            entrada.setCidtfdbndesporte(finDiretoVO.getCidtfdbndesporte());
            entrada.setCidtfdbndesgrp(finDiretoVO.getCidtfdbndesgrp());
            entrada.setCprznegoccmbio(finDiretoVO.getCprznegoccmbio());
            entrada.setCidtfdcartacsndo(finDiretoVO.getCidtfdcartacsndo());
            entrada.setCtpojurotrade(finDiretoVO.getCtpojurotrade());
            entrada.setCcobrcomismtori(finDiretoVO.getCcobrcomismtori());
            entrada.setCcobrcomisagte(finDiretoVO.getCcobrcomisagte());
            entrada.setCidtfdformacomis(finDiretoVO.getCidtfdformacomis());
            entrada.setVprevtcmbioequal(SiteUtil.formatarPontosVirgula(finDiretoVO.getVprevtcmbioequal()));
            entrada.setVprevtrectacmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVprevtrectacmbio()));
            entrada.setVtxremunbndes(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxremunbndes()));
            entrada.setVtxremuncmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxremuncmbio()));
            entrada.setVlimcobervar(SiteUtil.formatarPontosVirgula(finDiretoVO.getVlimcobervar()));
            entrada.setPcobervarprodt(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcobervarprodt()));
            
            //precificação
            entrada.setPtxcdifinan(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxcdifinan()));            
            entrada.setPcdimaiscmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcdimaiscmbio()));
            entrada.setPfixajurocmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPfixajurocmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadnegoc()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxmoracmbio()));
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmultanegoccmbio()));
            entrada.setInfocomplbndes(finDiretoVO.getGrupomercadoriaboleto());
            
            entrada.setCbasejuromora(finDiretoVO.getCbasejuromora());                            
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPjuronegoccmbio()));            
            entrada.setPtotjurocmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtotjurocmbio()));
            entrada.setPcomismtoricmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcomismtoricmbio()));
            entrada.setPagtefincrcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPagtefincrcmbio()));
            entrada.setPtxequalcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxequalcmbio()));
            entrada.setIorgextercmbio(finDiretoVO.getIorgextercmbio());
            entrada.setCfluxoperdccmbio(finDiretoVO.getCfluxoperdccmbio());
            entrada.setCindcdcartacnfdo(finDiretoVO.getCindcdcartacnfdo());

            entrada.setDvctocntragarnt(SiteUtil.dataWebToMainframe(finDiretoVO.getDvctocntragarnt()));
            entrada.setDprevtinicembrq(finDiretoVO.getDprevtinicembrq());
            entrada.setDprevtfimembrq(finDiretoVO.getDprevtfimembrq());

            entrada.setCindcdcntragarnt(finDiretoVO.getCindcdcntragarnt());
            entrada.setTdiacntragarnt(finDiretoVO.getTdiacntragarnt());
            entrada.setDabertcntragarnt(SiteUtil.dataWebToMainframe(finDiretoVO.getDabertcntragarnt()));
            entrada.setCindcdrenovcntra(finDiretoVO.getCindcdrenovcntra());
            entrada.setQdiaalertcntra(finDiretoVO.getQdiaalertcntra());
            entrada.setDalertvctocntra(SiteUtil.dataWebToMainframe(finDiretoVO.getDalertvctocntra()));
            entrada.setCindcdcustoexter(finDiretoVO.getCindcdcustoexter());

            entrada.setCaditvbletocmbio(finDiretoVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finDiretoVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finDiretoVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finDiretoVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finDiretoVO.getCsitbletocmbio());
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setNseqcontrlim(finDiretoVO.getNseqcontrlim());
            entrada.setCpssoaanlsecredt(finDiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finDiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finDiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finDiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finDiretoVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finDiretoVO.getCeconmmoedalim());
            entrada.setNctabcriacmbio(finDiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finDiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finDiretoVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finDiretoVO.getCeconmmoedadsemb());

            entrada.setCindcdnegocswap(finDiretoVO.getCindcdnegocswap());
            if (finDiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finDiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finDiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setCtpocotactx(finDiretoVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(finDiretoVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finDiretoVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(finDiretoVO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(finDiretoVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(finDiretoVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finDiretoVO.getQprzmedcmbio());            
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtravaliborcmbio()));
            entrada.setCsegurtrnspmcado(finDiretoVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(finDiretoVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finDiretoVO.getCmodcontrcmbio());
            entrada.setCrting(finDiretoVO.getCrting());
            entrada.setCcobrcomisadcio(finDiretoVO.getCcobrcomisadcio());            
            entrada.setDprevtdsembcmbio(finDiretoVO.getDprevtdsembcmbio());
            entrada.setVagtefincrcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVagtefincrcmbio()));
            entrada.setVbcomtoricmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVbcomtoricmbio()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finDiretoVO.getRjustfdqmto());
            entrada.setDlimenviorsumo(finDiretoVO.getDlimenviorsumo());
            if(finDiretoVO.getVtxspreadtot() != null)
            	entrada.setVtxspreadtot(Double.parseDouble(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadtot())));
            entrada.setCtpoprzcmbio(finDiretoVO.getCtpoprzcmbio());

            // Usado no garantia, lc, e finimp Eca
            entrada.setCidtfdrespdesp(SiteUtil.getInt(finDiretoVO.getCidtfdrespdesp()));
            // Fluxo: NPCCIAPV - Books: NPCCWV2E / NPCCWV2S
        try{
            listaSemPaginacao(request, response, "DADOSBASEGP1GP3INCL");

            setMsgRetorno(response.getTexmens());

            finDiretoVO.setNbletonegoccmbio(response.getNpccwv2sresponse().getNbletonegoccmbio());
            finDiretoVO.setHinclreg(response.getNpccwv2sresponse().getHinclreg());
            finDiretoVO.setNbletocmbioano(response.getNpccwv2sresponse().getNbletocmbioano());
            finDiretoVO.setDanobase(response.getNpccwv2sresponse().getDanobase());

            return finDiretoVO;

        }catch(Exception e){
            setMsgRetorno(e.getMessage());
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirDadosBasicosGp1Gp3 | DADOSBASEGP1GP3INCL ------- ");
        }
		return finDiretoVO;

    }

    // METODOS ALTERAR

    /**
     * Nome: alterarFinimpOuRefinimpDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFinimpOuRefinimpDireto | FINIMPDIRETOALT ------- ");

            Finimpdiretoaltrequest request = new Finimpdiretoaltrequest();
            Finimpdiretoaltresponse response = new Finimpdiretoaltresponse();
            Npccwwcerequest entrada = new Npccwwcerequest();
            Npccwwcsresponse saida = new Npccwwcsresponse();
            request.setNpccwwcerequest(entrada);
            response.setNpccwwcsresponse(saida);

            entrada.setNbletonegoccmbio(finDiretoVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(finDiretoVO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(finDiretoVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finDiretoVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finDiretoVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finDiretoVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finDiretoVO.getCsitbletocmbio());
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setNseqcontrlim(finDiretoVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finDiretoVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finDiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finDiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finDiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finDiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finDiretoVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finDiretoVO.getCeconmmoedalim());
            entrada.setCmodldprodtcmbio(finDiretoVO.getCmodldprodtcmbio());
            entrada.setNctabcriacmbio(finDiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finDiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finDiretoVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finDiretoVO.getCeconmmoedadsemb());

            entrada.setCindcdnegocswap(finDiretoVO.getCindcdnegocswap());
            if (finDiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finDiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finDiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            
            entrada.setCtpocotactx(finDiretoVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(finDiretoVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finDiretoVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(finDiretoVO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(finDiretoVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(finDiretoVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finDiretoVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finDiretoVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(finDiretoVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(finDiretoVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finDiretoVO.getCmodcontrcmbio());
            entrada.setDprevtdsembcmbio(finDiretoVO.getDprevtdsembcmbio());
            entrada.setCsitbletoaprov(finDiretoVO.getCsitbletoaprov());
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finDiretoVO.getRjustfdqmto());
            entrada.setDprevtembrq(finDiretoVO.getDprevtembrq());
            
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadtot()));

            // NPCCIAQG
            listaSemPaginacao(request, response, "FINIMPDIRETOALT");

            setMsgRetorno(response.getTexmens());

            finDiretoVO.setNbletonegoccmbio(response.getNpccwwcsresponse().getNbletonegoccmbio());
            finDiretoVO.setHinclreg(response.getNpccwwcsresponse().getHinclreg());

            return finDiretoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFinimpOuRefinimpDireto | FINIMPDIRETOALT ------- ");
        }

    }

    /**
     * Nome: alterarFinimpOuRefinimpIndireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpIndireto(TrdFinNegocInclVO finIndiretoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFinimpOuRefinimpIndireto | FINIMPINDIRETOALT ------- ");

            Finimpindiretoaltrequest request = new Finimpindiretoaltrequest();
            Finimpindiretoaltresponse response = new Finimpindiretoaltresponse();
            Npccwwderequest entrada = new Npccwwderequest();
            Npccwwdsresponse saida = new Npccwwdsresponse();
            request.setNpccwwderequest(entrada);
            response.setNpccwwdsresponse(saida);

            entrada.setNbletonegoccmbio(finIndiretoVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(finIndiretoVO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(finIndiretoVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(finIndiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finIndiretoVO.getCpssoajurid());
            entrada.setNsequndorgnz(finIndiretoVO.getNsequndorgnz());

            entrada.setCtposgmtocli(finIndiretoVO.getCtposgmtocli());
            entrada.setCprodtservc(finIndiretoVO.getCprodtservc());
            entrada.setCmodldprodtcmbio(finIndiretoVO.getCmodldprodtcmbio());
            entrada.setCsitbletocmbio(finIndiretoVO.getCsitbletocmbio());
            entrada.setNseqcontrlim(finIndiretoVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(finIndiretoVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(finIndiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finIndiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finIndiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finIndiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finIndiretoVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(finIndiretoVO.getCeconmmoedalim());

            entrada.setNctabcriacmbio(finIndiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finIndiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finIndiretoVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(finIndiretoVO.getCeconmmoedadsemb());

            entrada.setCindcdnegocswap(finIndiretoVO.getCindcdnegocswap());

            if (finIndiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }

            if (finIndiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finIndiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }

            entrada.setCtpocotactx(finIndiretoVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finIndiretoVO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(finIndiretoVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(finIndiretoVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(finIndiretoVO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(finIndiretoVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(finIndiretoVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(finIndiretoVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(finIndiretoVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(finIndiretoVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(finIndiretoVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(finIndiretoVO.getCmodcontrcmbio());
            entrada.setCsitbletoaprov(finIndiretoVO.getCsitbletoaprov());
            entrada.setDprevtdsembcmbio(finIndiretoVO.getDprevtdsembcmbio());
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(finIndiretoVO.getRjustfdqmto());
            entrada.setDprevtembrq(finIndiretoVO.getDprevtembrq());
            
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(finIndiretoVO.getVtxspreadtot()));

            // Fluxo - NPCCIAQH Book - NPCCWWDE/S
            listaSemPaginacao(request, response, "FINIMPINDIRETOALT");

            setMsgRetorno(response.getTexmens());

            finIndiretoVO.setNbletonegoccmbio(response.getNpccwwdsresponse().getNbletonegoccmbio());
            finIndiretoVO.setHinclreg(response.getNpccwwdsresponse().getHinclreg());
            finIndiretoVO.setNbletonegoccmbio(response.getNpccwwdsresponse().getNbletonegoccmbio());

            return finIndiretoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFinimpOuRefinimpIndireto | FINIMPINDIRETOALT ------- ");
        }

    }

    /**
     * Nome: alterarLei4131
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarLei4131(TrdFinNegocInclVO lei4131VO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarLei4131 | COTACAOLEI4131ALT ------- ");

            Cotacaolei4131altrequest request = new Cotacaolei4131altrequest();
            Cotacaolei4131altresponse response = new Cotacaolei4131altresponse();
            Npccww9erequest entrada = new Npccww9erequest();
            Npccww9sresponse saida = new Npccww9sresponse();
            request.setNpccww9erequest(entrada);
            response.setNpccww9sresponse(saida);

            entrada.setNbletonegoccmbio(lei4131VO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(lei4131VO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(lei4131VO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(lei4131VO.getCunicclicmbio());
            entrada.setCpssoajurid(lei4131VO.getCpssoajurid());
            entrada.setNsequndorgnz(lei4131VO.getNsequndorgnz());

            entrada.setCtposgmtocli(lei4131VO.getCtposgmtocli());
            entrada.setCprodtservc(lei4131VO.getCprodtservc());
            entrada.setCmodldprodtcmbio(lei4131VO.getCmodldprodtcmbio());
            entrada.setCsitbletocmbio(lei4131VO.getCsitbletocmbio());
            entrada.setNseqcontrlim(lei4131VO.getNseqcontrlim());
            entrada.setNppstapontucmbio(lei4131VO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(lei4131VO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(lei4131VO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(lei4131VO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(lei4131VO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(lei4131VO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(lei4131VO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(lei4131VO.getCeconmmoedalim());

            entrada.setNctabcriacmbio(lei4131VO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(lei4131VO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(lei4131VO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(lei4131VO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(lei4131VO.getCeconmmoedadsemb());
            entrada.setCsitbletoaprov(lei4131VO.getCsitbletoaprov());

            entrada.setCindcdnegocswap(lei4131VO.getCindcdnegocswap());

            if (lei4131VO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }

            if (lei4131VO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (lei4131VO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }

            entrada.setCtpocotactx(lei4131VO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(lei4131VO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(lei4131VO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(lei4131VO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(lei4131VO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(lei4131VO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(lei4131VO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(lei4131VO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(lei4131VO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(lei4131VO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(lei4131VO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(lei4131VO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(lei4131VO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(lei4131VO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(lei4131VO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(lei4131VO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(lei4131VO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(lei4131VO.getCmodcontrcmbio());
            entrada.setDprevtdsembcmbio(lei4131VO.getDprevtdsembcmbio());
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(lei4131VO.getRjustfdqmto());
            entrada.setDprevtembrq(lei4131VO.getDprevtembrq());
            
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(lei4131VO.getVtxspreadtot()));

            listaSemPaginacao(request, response, "COTACAOLEI4131ALT");

            setMsgRetorno(response.getTexmens());

            lei4131VO.setNbletonegoccmbio(response.getNpccww9sresponse().getNbletonegoccmbio());
            lei4131VO.setHinclreg(response.getNpccww9sresponse().getHinclreg());
            lei4131VO.setNbletonegoccmbio(response.getNpccww9sresponse().getNbletonegoccmbio());

            return lei4131VO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarLei4131 | COTACAOLEI4131ALT ------- ");
        }
    }

    /**
     * Nome: alterarPPE
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarPPE(TrdFinNegocInclVO ppeVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarPPE | COTACAOPPEALT ------- ");

            Cotacaoppealtrequest request = new Cotacaoppealtrequest();
            Cotacaoppealtresponse response = new Cotacaoppealtresponse();
            Npccwwierequest entrada = new Npccwwierequest();
            Npccwwisresponse saida = new Npccwwisresponse();
            request.setNpccwwierequest(entrada);
            response.setNpccwwisresponse(saida);

            entrada.setNbletonegoccmbio(ppeVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(ppeVO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(ppeVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(ppeVO.getCunicclicmbio());
            entrada.setCpssoajurid(ppeVO.getCpssoajurid());
            entrada.setNsequndorgnz(ppeVO.getNsequndorgnz());

            entrada.setCtposgmtocli(ppeVO.getCtposgmtocli());
            entrada.setCprodtservc(ppeVO.getCprodtservc());
            entrada.setCmodldprodtcmbio(ppeVO.getCmodldprodtcmbio());
            entrada.setCsitbletocmbio(ppeVO.getCsitbletocmbio());
            entrada.setNseqcontrlim(ppeVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(ppeVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(ppeVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(ppeVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(ppeVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(ppeVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(ppeVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(ppeVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(ppeVO.getCeconmmoedalim());

            entrada.setNctabcriacmbio(ppeVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(ppeVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(ppeVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(ppeVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(ppeVO.getCeconmmoedadsemb());

            entrada.setCindcdnegocswap(ppeVO.getCindcdnegocswap());

            if (ppeVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }

            if (ppeVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (ppeVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }

            entrada.setCtpocotactx(ppeVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(ppeVO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(ppeVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(ppeVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(ppeVO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(ppeVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(ppeVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(ppeVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(ppeVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(ppeVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(ppeVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(ppeVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(ppeVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(ppeVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(ppeVO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(ppeVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(ppeVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(ppeVO.getCmodcontrcmbio());
            entrada.setCsitbletoaprov(ppeVO.getCsitbletoaprov());
            entrada.setDprevtdsembcmbio(ppeVO.getDprevtdsembcmbio());
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(ppeVO.getRjustfdqmto());
            entrada.setDprevtembrq(ppeVO.getDprevtembrq());
            
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(ppeVO.getVtxspreadtot()));

            listaSemPaginacao(request, response, "COTACAOPPEALT");

            setMsgRetorno(response.getTexmens());

            ppeVO.setNbletonegoccmbio(response.getNpccwwisresponse().getNbletonegoccmbio());
            ppeVO.setHinclreg(response.getNpccwwisresponse().getHinclreg());
            ppeVO.setNbletonegoccmbio(response.getNpccwwisresponse().getNbletonegoccmbio());

            return ppeVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarPPE | COTACAOPPEALT ------- ");
        }
    }

    /**
     * Nome: alterarWorkingCapital
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarWorkingCapital(TrdFinNegocInclVO wrkCapitalVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarWorkingCapital | COTACWORKCAPITALALT ------- ");

            Cotacworkcapitalaltrequest request = new Cotacworkcapitalaltrequest();
            Cotacworkcapitalaltresponse response = new Cotacworkcapitalaltresponse();
            Npccwwkerequest entrada = new Npccwwkerequest();
            Npccwwksresponse saida = new Npccwwksresponse();
            request.setNpccwwkerequest(entrada);
            response.setNpccwwksresponse(saida);

            entrada.setNbletonegoccmbio(wrkCapitalVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(wrkCapitalVO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(wrkCapitalVO.getCaditvbletocmbio());
            entrada.setCunicclicmbio(wrkCapitalVO.getCunicclicmbio());
            entrada.setCpssoajurid(wrkCapitalVO.getCpssoajurid());
            entrada.setNsequndorgnz(wrkCapitalVO.getNsequndorgnz());

            entrada.setCtposgmtocli(wrkCapitalVO.getCtposgmtocli());
            entrada.setCprodtservc(wrkCapitalVO.getCprodtservc());
            entrada.setCmodldprodtcmbio(wrkCapitalVO.getCmodldprodtcmbio());
            entrada.setCsitbletocmbio(wrkCapitalVO.getCsitbletocmbio());
            entrada.setNseqcontrlim(wrkCapitalVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(wrkCapitalVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(wrkCapitalVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(wrkCapitalVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(wrkCapitalVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(wrkCapitalVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(wrkCapitalVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(wrkCapitalVO.getCeconmmoedalim());

            entrada.setNctabcriacmbio(wrkCapitalVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(wrkCapitalVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(wrkCapitalVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(wrkCapitalVO.getCeconmmoedadsemb());

            entrada.setCindcdnegocswap(wrkCapitalVO.getCindcdnegocswap());

            if (wrkCapitalVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }

            if (wrkCapitalVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (wrkCapitalVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }

            entrada.setCtpocotactx(wrkCapitalVO.getCtpocotactx());
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getPtxswapcmpdo()));
            entrada.setCindcdnegoccarta(wrkCapitalVO.getCindcdnegoccarta());
            entrada.setTdiavalddletra(wrkCapitalVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(wrkCapitalVO.getDvalddnegoccmbio());
            entrada.setCcomiscartanacio(wrkCapitalVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(wrkCapitalVO.getCindcdnegocarbtr());
            entrada.setQprzmedcmbio(wrkCapitalVO.getQprzmedcmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(wrkCapitalVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVmultanegoccmbio()));
            entrada.setCsegurtrnspmcado(wrkCapitalVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(wrkCapitalVO.getCsegurmcadoorgnz());
            entrada.setCmodcontrcmbio(wrkCapitalVO.getCmodcontrcmbio());
            entrada.setCsitbletoaprov(wrkCapitalVO.getCsitbletoaprov());

            entrada.setDprevtdsembcmbio(wrkCapitalVO.getDprevtdsembcmbio());
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(wrkCapitalVO.getRjustfdqmto());
            entrada.setDprevtembrq(wrkCapitalVO.getDprevtembrq());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(wrkCapitalVO.getVtxspreadtot()));

            listaSemPaginacao(request, response, "COTACWORKCAPITALALT");

            setMsgRetorno(response.getTexmens());

            wrkCapitalVO.setNbletonegoccmbio(response.getNpccwwksresponse().getNbletonegoccmbio());
            wrkCapitalVO.setHinclreg(response.getNpccwwksresponse().getHinclreg());
            wrkCapitalVO.setNbletonegoccmbio(response.getNpccwwksresponse().getNbletonegoccmbio());

            return wrkCapitalVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarWorkingCapital | COTACWORKCAPITALALT ------- ");
        }
    }

    /**
     * Nome: alterarForfaiting
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarForfaiting(TrdFinNegocInclVO forfaitingVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarForfaiting | COTACFORFAITINGALT ------- ");

            // DADOS BÁSICOS
            Cotacforfaitingaltrequest request = new Cotacforfaitingaltrequest();
            Cotacforfaitingaltresponse response = new Cotacforfaitingaltresponse();
            Npccwweerequest entrada = new Npccwweerequest();
            Npccwwesresponse saida = new Npccwwesresponse();

            entrada.setNbletonegoccmbio(forfaitingVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(forfaitingVO.getNbletocmbioano());
            entrada.setCunicclicmbio(forfaitingVO.getCunicclicmbio());
            entrada.setCpssoajurid(forfaitingVO.getCpssoajurid());       
            entrada.setNsequndorgnz(forfaitingVO.getNsequndorgnz());
            entrada.setCtposgmtocli(forfaitingVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(forfaitingVO.getCsitbletocmbio());
            entrada.setCprodtservc(forfaitingVO.getCprodtservc());       
            entrada.setCmodldprodtcmbio(forfaitingVO.getCmodldprodtcmbio());
            entrada.setNseqcontrlim(forfaitingVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(forfaitingVO.getNppstapontucmbio());
            entrada.setCpssoaanlsecredt(forfaitingVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(forfaitingVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(forfaitingVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(forfaitingVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(forfaitingVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(forfaitingVO.getVnegocmoedaestrg()));
            entrada.setCeconmmoedalim(forfaitingVO.getCeconmmoedalim());
            entrada.setCrting(forfaitingVO.getCrting());             
            entrada.setNctabcriacmbio(forfaitingVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(forfaitingVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(forfaitingVO.getTdiaopercmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(forfaitingVO.getVmoedalimgerc()));
            entrada.setCeconmmoedadsemb(forfaitingVO.getCeconmmoedadsemb());
            entrada.setTdiavalddletra(forfaitingVO.getTdiavalddletra());
            entrada.setDvalddnegoccmbio(forfaitingVO.getDvalddnegoccmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtravaliborcmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxspreadnegoc()));
            entrada.setCbasejuromora(forfaitingVO.getCbasejuromora());
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getVmultanegoccmbio()));
            entrada.setCmodcontrcmbio(forfaitingVO.getCmodcontrcmbio());
            entrada.setDprevtgarntexpdi(SiteUtil.dataWebToMainframe(forfaitingVO.getDprevtgarntexpdi()));
            entrada.setDprevtinicembrq(SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevEmbarq().getInicio()));
            entrada.setDprevtfimembrq(SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevEmbarq().getFim()));
            entrada.setCcobrcomisadcio(forfaitingVO.getCcobrcomisadcio());
            entrada.setPcobervarprodt(SiteUtil.formatarPontosVirgula(forfaitingVO.getPcobervarprodt()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(forfaitingVO.getPjuronegoccmbio()));
            entrada.setDabertcntragarnt(SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevDesemb().getInicio()));
            entrada.setDvctocntragarnt(SiteUtil.dataWebToMainframe(forfaitingVO.getDataPrevDesemb().getFim()));
            entrada.setDprevtdsembcmbio(forfaitingVO.getDprevtdsembcmbio());
            entrada.setCtpojurotrade(forfaitingVO.getCtpojurotrade());
            entrada.setVsdolimsensi(SiteUtil.formatarPontosVirgula(forfaitingVO.getVmoedalimgerc()));
            entrada.setCsitbletoaprov(forfaitingVO.getCsitbletoaprov());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(forfaitingVO.getVtxspreadtot()));
            
            // Justificativa informada no modal de operações desenquadradas
            entrada.setRjustfdqmto(forfaitingVO.getRjustfdqmto());
            entrada.setDprevtembrq(forfaitingVO.getDprevtembrq());

            request.setNpccwweerequest(entrada);
            response.setNpccwwesresponse(saida);

            // ALTERAÇÃO DOS DADOS BÁSICOS
            // Executa chamada CWS - Fluxo: NPCCIAQJ - Books: NPCCWWEE / NPCCWWES
            listaSemPaginacao(request, response, "COTACFORFAITINGALT");

            setMsgRetorno(response.getTexmens());

            forfaitingVO.setNbletonegoccmbio(response.getNpccwwesresponse().getNbletonegoccmbio());
            forfaitingVO.setHmanutreg(response.getNpccwwesresponse().getHmanutreg());

            return forfaitingVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarForfaiting | COTACFORFAITINGALT ------- ");
        }
    }

        /**
        * Nome: alterarDesembolsoEouMercadoriaForfainting
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 25/08/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
        */
    public void alterarDesembolsoEouMercadoriaForfainting(TradeFinanceDesembolsoVO desembolsoVO,
                    List<TrdFinNegMercadoriaVO> listaMercadoria){

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarDesembolsoForfainting | FORFTNGDESEMBOLSOALT ------- ");

            // DESEMBOLSOS E MERCADORIAS
            Forftngdesembolsoaltrequest requestDesembolso = new Forftngdesembolsoaltrequest();
            Forftngdesembolsoaltresponse responseDesembolso = new Forftngdesembolsoaltresponse();

            Npccwyqerequest entradaDesembolso;
            Npccwyqsresponse saidaDesembolso = new Npccwyqsresponse();

            entradaDesembolso = new Npccwyqerequest();
            entradaDesembolso.setLstlis(new ArrayList<Npccwyqerequest_lstlis>());
            entradaDesembolso.setLstmer(new ArrayList<Npccwyqerequest_lstmer>());

            entradaDesembolso.setNbletonegoccmbio(desembolsoVO.getNbletonegoccmbio());
            entradaDesembolso.setNdsembcmbiotrade(desembolsoVO.getSeqDesembolso());
            entradaDesembolso.setHmanutreg(desembolsoVO.getHinclreg());

            entradaDesembolso.setDprevtdsembcmbio(desembolsoVO.getDataDesembolsoFormat());
            entradaDesembolso.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVprevtdsembcmbio()));
            entradaDesembolso.setVdsembnegoccmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVdsembnegoccmbio()));
            entradaDesembolso.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVtxliborcmbio()));
            entradaDesembolso.setPtxjurofndng(SiteUtil.formatarPontosVirgula(desembolsoVO.getPtxjurofndng()));
            entradaDesembolso.setPspreadtxcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getPspreadtxcmbio()));
            entradaDesembolso.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getPjuronegoccmbio()));
            entradaDesembolso.setTdiafinandsemb(desembolsoVO.getTdiafinandsemb());
            entradaDesembolso.setVjurodsembcmbio(SiteUtil.formatarPontosVirgula(desembolsoVO.getVjurodsembcmbio()));
            entradaDesembolso.setCmomencobrcmbio(desembolsoVO.getCmomencobrcmbio());

            //INICIO - CAMPOS SEM DEFINICAO NO BOOK
            entradaDesembolso.setVtxvaroper(null); 
            entradaDesembolso.setVtxcmbiovarvl(null);
            entradaDesembolso.setCpermvarpatrm(null);
            entradaDesembolso.setCindcdcmbiovarvl(null);
            entradaDesembolso.setIorgexterfinan(null);
            entradaDesembolso.setTdiacarenprinc(0);
            entradaDesembolso.setCfluxoliqdcprinc(0);
            entradaDesembolso.setQpcelatradeprinc(0);
            entradaDesembolso.setTdiacarenjuro(0);
            entradaDesembolso.setCfluxoliqdcjuro(0);
            entradaDesembolso.setQpcelatradejuro(0);
            entradaDesembolso.setCmomencobrcmbio(0);
            entradaDesembolso.setQtdoclist(0);
            entradaDesembolso.setLstlis(new ArrayList<Npccwyqerequest_lstlis>());
            //FIM - CAMPOS SEM DEFINICAO NO BOOK


            /*** MERCADORIA - TMCADO_CMBIO_TRADE (20 OCORRENCIAS) ***/
            entradaDesembolso.setQtdocmerc(listaMercadoria.size());

            for (Iterator<TrdFinNegMercadoriaVO> iterator = listaMercadoria.iterator(); iterator.hasNext();) {
                TrdFinNegMercadoriaVO itemMerc = (TrdFinNegMercadoriaVO) iterator.next();

                Npccwyqerequest_lstmer itemLista = new Npccwyqerequest_lstmer();

                itemLista.setLstmer_cmcadoopercmbio(itemMerc.getCmcadoopercmbio());
                itemLista.setLstmer_nmcadocmbiotrade(itemMerc.getNmcadocmbiotrade());
                itemLista.setLstmer_cpais(itemMerc.getCpais());
                itemLista.setLstmer_cunicpssoamcado(itemMerc.getCunicpssoamcado());
                itemLista.setLstmer_cpaisbnefc(itemMerc.getCpaisbnefc());
                itemLista.setLstmer_dprevtembrqm(SiteUtil.dataWebToMainframe(itemMerc.getDprevtembrq()));

                entradaDesembolso.getLstmer().add(itemLista);
            }

            requestDesembolso.setNpccwyqerequest(entradaDesembolso);
            responseDesembolso.setNpccwyqsresponse(saidaDesembolso);

            // ALTERAÇÃO DOS DESEMBOLSOS E MERCADORIAS
            // Executa chamada CWS - Fluxo: NPCCIAT8 - Books: NPCCWYQE / NPCCWYQS
            listaSemPaginacao(requestDesembolso, responseDesembolso, "FORFTNGDESEMBOLSOALT");

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarDesembolsoForfainting | FORFTNGDESEMBOLSOALT ------- ");
        }

    }
    
    public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJurosCtcPend(TrdFinNegFluxoPagtoVO flxPgtVO, List<MercadoriaVO> listaMercadoria) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoPrincJuros | FNDRFLXPGTPRCJRSALT ------- ");

            Fndrflxpgtprcjrsaltrequest request = new Fndrflxpgtprcjrsaltrequest();
            Fndrflxpgtprcjrsaltresponse response = new Fndrflxpgtprcjrsaltresponse();
            Npccwyferequest entrada = new Npccwyferequest();
            Npccwyfsresponse saida = new Npccwyfsresponse();
            request.setNpccwyferequest(entrada);
            response.setNpccwyfsresponse(saida);
            
            
            List<TrdFinNegParcelaVO> listaParcelasFluxoPgtoAux = flxPgtVO.getListaParcelasFluxoPgto();
            flxPgtVO.setListaParcelasFluxoPgto(null);
            flxPgtVO.setListaParcelasFluxoPgto(listaParcelasFluxoPgtoAux);
            
            entrada.setLstlis(new ArrayList<Npccwyferequest_lstlis>());
            entrada.setLstmer(new ArrayList<Npccwyferequest_lstmer>());

            entrada.setNbletonegoccmbio(flxPgtVO.getNbletonegoccmbio());
            entrada.setNdsembcmbiotrade(flxPgtVO.getSeqFluxoPagto());
            entrada.setHmanutreg(flxPgtVO.getHinclreg());

            entrada.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(flxPgtVO.getVprevtdsembcmbio()));
            entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPgtVO.getDateFluxoPgto()));
            entrada.setTdiacarenprinc(flxPgtVO.getTdiacarenprinc());
            entrada.setCfluxoliqdcprinc(flxPgtVO.getCfluxoliqdcprinc());
            entrada.setQpcelatradeprinc(flxPgtVO.getQtdeocorrprinc());
            entrada.setTdiacarenjuro(flxPgtVO.getJurosCarencia());
            entrada.setTdiafinandsemb(flxPgtVO.getTdiafinandsemb());
            entrada.setCfluxoliqdcjuro(flxPgtVO.getCodJurosPeriodicidade());
            entrada.setQpcelatradejuro(flxPgtVO.getQtdeocorrjuros());
            entrada.setCmomencobrcmbio(flxPgtVO.getCodJurosMomento());
            entrada.setQtdoclist(flxPgtVO.getListaParcelasFluxoPgto().size());
            
            List<Npccwyferequest_lstlis> lista = new ArrayList<Npccwyferequest_lstlis>();

			for (Iterator<TrdFinNegParcelaVO> iterator = flxPgtVO.getListaParcelasFluxoPgto().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwyferequest_lstlis itemLista = new Npccwyferequest_lstlis();

                itemLista.setLstlis_tipopcelatrade(itemParcela.getTpparcela());
                itemLista.setLstlis_npceladsembtrade(itemParcela.getNpceladsembtrade());
                itemLista.setLstlis_tdianegocpcela(itemParcela.getTdianegocpcela());
                itemLista.setLstlis_dvctopcelatrade(itemParcela.getDvctopcelatrade().replace("/", "."));
                itemLista.setLstlis_vpcelamesatrade(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelamesatrade()));
                
                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            /*** MERCADORIA - TMCADO_CMBIO_TRADE (20 OCORRENCIAS) ***/
            entrada.setQtdocmerc(listaMercadoria.size());
            
            for (Iterator<MercadoriaVO> iterator = listaMercadoria.iterator(); iterator.hasNext();) {
            	MercadoriaVO itemMerc = (MercadoriaVO) iterator.next();

                Npccwyferequest_lstmer itemLista = new Npccwyferequest_lstmer();

                itemLista.setLstmer_cmcadoopercmbio(itemMerc.getCmcadoopercmbio());
                itemLista.setLstmer_nmcadocmbiotrade(itemMerc.getNmcadocmbiotrade());
                itemLista.setLstmer_cpais(itemMerc.getCpais());
                itemLista.setLstmer_cunicpssoamcado(itemMerc.getCunicpssoamcado());
                itemLista.setLstmer_cpaisbnefc(itemMerc.getCpaisbnefc());
                itemLista.setLstmer_dprevtembrq(SiteUtil.stringDataWebToMainframe(itemMerc.getDprevtembrq()));

                entrada.getLstmer().add(itemLista);
            }

            //NPCCIAQV
            listaSemPaginacao(request, response, "FNDRFLXPGTPRCJRSALT");

            return flxPgtVO;
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoPrincJuros | FNDRFLXPGTPRCJRSALT ------- ");
        }


    }
    
    /**
     * Nome: alterarFluxoPagtoPrincJuros
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJuros(TrdFinNegFluxoPagtoVO flxPgtVO, List<TrdFinNegMercadoriaVO> listaMercadoria) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoPrincJuros | FNDRFLXPGTPRCJRSALT ------- ");

            Fndrflxpgtprcjrsaltrequest request = new Fndrflxpgtprcjrsaltrequest();
            Fndrflxpgtprcjrsaltresponse response = new Fndrflxpgtprcjrsaltresponse();
            Npccwyferequest entrada = new Npccwyferequest();
            Npccwyfsresponse saida = new Npccwyfsresponse();
            request.setNpccwyferequest(entrada);
            response.setNpccwyfsresponse(saida);
            
            
            List<TrdFinNegParcelaVO> listaParcelasFluxoPgtoAux = formatarParcelasFluxoPagamento(flxPgtVO);
            flxPgtVO.setListaParcelasFluxoPgto(null);
            flxPgtVO.setListaParcelasFluxoPgto(listaParcelasFluxoPgtoAux);
            
            entrada.setLstlis(new ArrayList<Npccwyferequest_lstlis>());
            entrada.setLstmer(new ArrayList<Npccwyferequest_lstmer>());

            entrada.setNbletonegoccmbio(flxPgtVO.getNbletonegoccmbio());
            entrada.setNdsembcmbiotrade(flxPgtVO.getSeqFluxoPagto());
            entrada.setHmanutreg(flxPgtVO.getHinclreg());

            entrada.setVprevtdsembcmbio(SiteUtil.formatarPontosVirgula(flxPgtVO.getVprevtdsembcmbio()));
            entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPgtVO.getDateFluxoPgto()));
            entrada.setTdiacarenprinc(flxPgtVO.getTdiacarenprinc());
            entrada.setCfluxoliqdcprinc(flxPgtVO.getCfluxoliqdcprinc());
            entrada.setQpcelatradeprinc(flxPgtVO.getQtdeocorrprinc());
            entrada.setTdiacarenjuro(flxPgtVO.getJurosCarencia());
            entrada.setTdiafinandsemb(flxPgtVO.getTdiafinandsemb());
            entrada.setCfluxoliqdcjuro(flxPgtVO.getCodJurosPeriodicidade());
            entrada.setQpcelatradejuro(flxPgtVO.getQtdeocorrjuros());
            entrada.setCmomencobrcmbio(flxPgtVO.getCodJurosMomento());
            entrada.setQtdoclist(flxPgtVO.getListaParcelasFluxoPgto().size());
            
            List<Npccwyferequest_lstlis> lista = new ArrayList<Npccwyferequest_lstlis>();

			for (Iterator<TrdFinNegParcelaVO> iterator = flxPgtVO.getListaParcelasFluxoPgto().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwyferequest_lstlis itemLista = new Npccwyferequest_lstlis();

                itemLista.setLstlis_tipopcelatrade(itemParcela.getTpparcela());
                itemLista.setLstlis_npceladsembtrade(itemParcela.getNpceladsembtrade());
                itemLista.setLstlis_tdianegocpcela(itemParcela.getTdianegocpcela());
                itemLista.setLstlis_dvctopcelatrade(itemParcela.getDvctopcelatrade().replace("/", "."));
                itemLista.setLstlis_vpcelamesatrade(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelamesatrade()));
                
                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            /*** MERCADORIA - TMCADO_CMBIO_TRADE (20 OCORRENCIAS) ***/
            entrada.setQtdocmerc(listaMercadoria.size());

            for (Iterator<TrdFinNegMercadoriaVO> iterator = listaMercadoria.iterator(); iterator.hasNext();) {
                TrdFinNegMercadoriaVO itemMerc = (TrdFinNegMercadoriaVO) iterator.next();

                Npccwyferequest_lstmer itemLista = new Npccwyferequest_lstmer();

                itemLista.setLstmer_cmcadoopercmbio(itemMerc.getCmcadoopercmbio());
                itemLista.setLstmer_nmcadocmbiotrade(itemMerc.getNmcadocmbiotrade());
                itemLista.setLstmer_cpais(itemMerc.getCpais());
                itemLista.setLstmer_cunicpssoamcado(itemMerc.getCunicpssoamcado());
                itemLista.setLstmer_cpaisbnefc(itemMerc.getCpaisbnefc());
                itemLista.setLstmer_dprevtembrq(SiteUtil.dataWebToMainframe(itemMerc.getDprevtembrq()));

                entrada.getLstmer().add(itemLista);
            }

            //NPCCIAQV
            listaSemPaginacao(request, response, "FNDRFLXPGTPRCJRSALT");

            return flxPgtVO;
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoPrincJuros | FNDRFLXPGTPRCJRSALT ------- ");
        }


    }
    
	public List<TrdFinNegParcelaVO> formatarParcelasFluxoPagamento(TrdFinNegFluxoPagtoVO flxPgtVO) {
    	List<TrdFinNegParcelaVO> listaPrinc = new ArrayList<TrdFinNegParcelaVO>();
    	List<TrdFinNegParcelaVO> listaJuros = new ArrayList<TrdFinNegParcelaVO>();

    	TrdFinNegParcelaVO objTo = null;
    	List<TrdFinNegParcelaVO> listaParcelasFluxoPgto = flxPgtVO.getListaParcelasFluxoPgto();
    	
    	
    	if (flxPgtVO.getCfluxoliqdcprinc().equals(flxPgtVO.getCodJurosPeriodicidade())) {
    		for (int i = 0; i < listaParcelasFluxoPgto.size(); i++) {

    			TrdFinNegParcelaVO objFrom = listaParcelasFluxoPgto.get(i);
    			objTo = new TrdFinNegParcelaVO();

    			objTo.setTpparcela("P");
    			objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    			objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    			objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    			objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
    			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));

    			listaPrinc.add(objTo);

    			objTo = new TrdFinNegParcelaVO();

    			objTo.setTpparcela("J");
    			objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    			objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    			objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    			objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    			objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    			objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
    			objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));

    			listaJuros.add(objTo);
    		}
    		int numeroParcela = 1;
    		for (int i = 0; i < listaJuros.size(); i++) {
    			listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
    			numeroParcela++;
    			listaJuros.get(i).setNpceladsembtrade(numeroParcela);
    			numeroParcela++;
    			listaPrinc.add(listaJuros.get(i));
    		}
    	} else {
			for (int i = 0; i < listaParcelasFluxoPgto.size(); i++) {
				TrdFinNegParcelaVO objFrom = listaParcelasFluxoPgto.get(i);
				if (objFrom.getTpparcela().equals("P")) {
					objTo = new TrdFinNegParcelaVO();
					
					objTo.setTpparcela("P");
					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVpcelamesatrade(objFrom.getValorPrincipalParcelaFluxoPgto());
					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorPrincipalParcelaFluxoPgto()));

					listaPrinc.add(objTo);
					if (objFrom.getValorJurosParcelaFluxoPgto() != null) {
						objTo = new TrdFinNegParcelaVO();
    					
    					objTo.setTpparcela("J");
    					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
    					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
    					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
    					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
    					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
    					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
    					
    					listaJuros.add(objTo);
					}
				} else {
					objTo = new TrdFinNegParcelaVO();

					objTo.setTpparcela("J");
					objTo.setNpceladsembtrade(objFrom.getNpceladsembtrade());
					objTo.setTdianegocpcela(objFrom.getTdianegocpcela());
					objTo.setDvctopcelatrade(objFrom.getDvctopcelatrade());
					objTo.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVencimentoFluxoPgto(SiteUtil.stringDataMainframeToWeb(objFrom.getDvctopcelatrade()));
					objTo.setVpcelamesatrade(objFrom.getValorJurosParcelaFluxoPgto());
					objTo.setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getValorJurosParcelaFluxoPgto()));
					
					listaJuros.add(objTo);
				}
			}
			int numeroParcela = 1;
			for (int i = 0; i < listaJuros.size(); i++) {
				if (i < flxPgtVO.getQtdeocorrprinc()) {
    				listaPrinc.get(i).setNpceladsembtrade(numeroParcela);
    				numeroParcela++;
				}
				listaJuros.get(i).setNpceladsembtrade(numeroParcela);
				numeroParcela++;
				listaPrinc.add(listaJuros.get(i));
			}
		}
        return listaPrinc;
	}
	
    /**
     * Nome: alterarFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoInterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoComissaoInterna | FNDRFLXPGTCMSSINALT ------- ");

            Fndrflxpgtcmssinaltrequest request = new Fndrflxpgtcmssinaltrequest();
            Fndrflxpgtcmssinaltresponse response = new Fndrflxpgtcmssinaltresponse();
            Npccwxnerequest entrada = new Npccwxnerequest();
            Npccwxnsresponse saida = new Npccwxnsresponse();
            request.setNpccwxnerequest(entrada);
            response.setNpccwxnsresponse(saida);
            
            entrada.setCprodtservc(codProduto);
            entrada.setNbletonegoccmbio(comissaoVO.getNbletonegoccmbio());
            entrada.setHinclreg(comissaoVO.getHinclreg());
            entrada.setNcomisintrncmbio(comissaoVO.getNcomisintrncmbio());
            entrada.setCfluxoperdccmbio(comissaoVO.getCfluxoperdccmbio());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setVprevtcomiscmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getVprevtcomiscmbio()));
            entrada.setVmincobrcomis(SiteUtil.formatarPontosVirgula(comissaoVO.getVmincobrcomis()));
            entrada.setVtxspreadaprov(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxcustototal()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(comissaoVO.getVtxspreadnegoc()));
            entrada.setPtxflatpnalt(SiteUtil.formatarPontosVirgula(comissaoVO.getPtxflatpnalt()));
            entrada.setPcomisnegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPcomisnegoccmbio()));
            entrada.setQpcelacmbiotrade(comissaoVO.getQpcelacmbiotrade());
            entrada.setCcobrcomiscmbio(comissaoVO.getCcobrcomiscmbio());
            entrada.setCcobrcomisintrn(comissaoVO.getCcobrcomisintrn());
            entrada.setCmomencobrcmbio(comissaoVO.getCodMomentoComissao());

            entrada.setQtdoclist(comissaoVO.getListaParcelasComissao().size());

            List<Npccwxnerequest_lstlis> lista = new ArrayList<Npccwxnerequest_lstlis>();

            for (Iterator<TrdFinNegParcelaVO> iterator = comissaoVO.getListaParcelasComissao().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwxnerequest_lstlis itemLista = new Npccwxnerequest_lstlis();

                itemLista.setLstlis_npcelacomisintrn(itemParcela.getNpcelacomis());
                itemLista.setLstlis_dvctopcelatrade(itemParcela.getDvctopcelatrade().replace("/", "."));
                itemLista.setLstlis_vpcelacomiscmbio(SiteUtil.formatarPontosVirgula(itemParcela.getVpcelacomiscmbio()));
                itemLista.setLstlis_vcustofincrcmbio(itemParcela.getVcustofincrcmbio());

                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            // Fluxo: NPCCIAQE - Books: NPCCWXNE / NPCCWXNS
            listaSemPaginacao(request, response, "FNDRFLXPGTCMSSINALT");

            return comissaoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoComissaoInterna | FNDRFLXPGTCMSSINALT ------- ");
        }

    }

    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoExterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoComissaoExterna | FNDRFLXPGTCMSSEXALT ------- ");

            Fndrflxpgtcmssexaltrequest request = new Fndrflxpgtcmssexaltrequest();
            Fndrflxpgtcmssexaltresponse response = new Fndrflxpgtcmssexaltresponse();
            Npccwxserequest entrada = new Npccwxserequest();
            Npccwxssresponse saida = new Npccwxssresponse();
            request.setNpccwxserequest(entrada);
            response.setNpccwxssresponse(saida);
            
            entrada.setCprodtservc(codProduto);
            entrada.setNbletonegoccmbio(comissaoVO.getNbletonegoccmbio());
            entrada.setHinclreg(comissaoVO.getHinclreg());
            entrada.setNcomisextertrade(comissaoVO.getNcomisextertrade());
            entrada.setCcondceconc(comissaoVO.getCcondceconc());
            entrada.setPcomisnegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPcomisnegoccmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getPjuronegoccmbio()));
            entrada.setVprevtcomiscmbio(SiteUtil.formatarPontosVirgula(comissaoVO.getVprevtcomiscmbio()));

            entrada.setCperdcjurocmbio(comissaoVO.getCperdcjurocmbio());
            entrada.setCindcdeconmmoeda(comissaoVO.getCindcdeconmmoeda());
            entrada.setCfluxoperdccmbio(comissaoVO.getCfluxoperdccmbio());
            entrada.setCmomencobrcmbio(comissaoVO.getCodMomentoComissao());
            entrada.setQpcelacmbiotrade(comissaoVO.getQpcelacmbiotrade());
            entrada.setCrespcomisexter(comissaoVO.getCrespcomisexter());

            entrada.setQtdoclist(comissaoVO.getListaParcelasComissao().size());

            List<Npccwxserequest_lstlis> lista = new ArrayList<Npccwxserequest_lstlis>();

            for (Iterator<TrdFinNegParcelaVO> iterator = comissaoVO.getListaParcelasComissao().iterator(); iterator.hasNext();) {
                TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();

                Npccwxserequest_lstlis itemLista = new Npccwxserequest_lstlis();

                itemLista.setLstlis_npcelacomisexter(itemParcela.getNpcelacomis());
                itemLista.setLstlis_dvctopcelatrade(SiteUtil.stringDataWebToMainframe(itemParcela.getDvctopcelatrade()));
                itemLista.setLstlis_vpcelacomiscmbio(itemParcela.getVpcelacomiscmbio());

                lista.add(itemLista);

            }
            entrada.setLstlis(lista);

            // Fluxo: NPCCIAQS - Books: NPCCWXSE / NPCCWXSS
            listaSemPaginacao(request, response, "FNDRFLXPGTCMSSEXALT");

            return comissaoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarFluxoPagtoComissaoExterna | FNDRFLXPGTCMSSEXALT ------- ");
        }


    }

    /**
     * Nome: alterarGarantiasVinculosTarifasObsFinOuRefinDireto
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public TrdFinNegocInclVO alterarGarantiasVinculosTarifasObs(TrdFinNegocInclVO finDiretoVO,
                    TrdFinNegPrecificacaoVO precificacaoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarGarantiasVinculosTarifasObs | FNDRGRTVNCTRFOBSALT ------- ");

            Fndrgrtvnctrfobsaltrequest request = new Fndrgrtvnctrfobsaltrequest();
            Fndrgrtvnctrfobsaltresponse response = new Fndrgrtvnctrfobsaltresponse();
            Npccwzxerequest entrada = new Npccwzxerequest();
            Npccwzxsresponse saida = new Npccwzxsresponse();
            request.setNpccwzxerequest(entrada);
            response.setNpccwzxsresponse(saida);

            entrada.setLstvin(new ArrayList<Npccwzxerequest_lstvin>());
            entrada.setLsttar(new ArrayList<Npccwzxerequest_lsttar>());
            entrada.setLstgar(new ArrayList<Npccwzxerequest_lstgar>());
            entrada.setLstava(new ArrayList<Npccwzxerequest_lstava>());
          
            entrada.setCsitbletocmbio(finDiretoVO.getCsitbletocmbio());
            entrada.setNbletonegoccmbio(finDiretoVO.getNbletonegoccmbio());
            if(finDiretoVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                entrada.setHmanutreg(finDiretoVO.getHmanutreg());
            } else {
                entrada.setHmanutreg(finDiretoVO.getHinclreg());
            }
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());

            /*** CUSTO EXTERNO - TFNDNG_NEGOC_CMBIO ***/
            if(finDiretoVO.getProduto().isNce()
                    || EnumProduto.LC_IMPORTACAO.getCodigo().equals(finDiretoVO.getProduto().getCodigo())
                    || EnumProduto.PROEX.getCodigo().equals(finDiretoVO.getProduto().getCodigo())
                    || finDiretoVO.getProduto().isGarantia() 
                    || finDiretoVO.getProduto().isBndesPos()
                    || finDiretoVO.getProduto().isBndesPre()
                    || EnumProduto.FINIMP_ECA.getCodigo().equals(finDiretoVO.getProduto().getCodigo())){
                
                entrada.setCbanqrcmbiofndng(SiteUtil.getLong(Numeros.ZERO));
                entrada.setDcotacfndngcmbio("");
                entrada.setDlimfndngcmbio("");
                entrada.setPtxfixacmbio("");            
                entrada.setCindcdeconmmoelib(Numeros.ZERO);
                entrada.setTdiaopercmbio(Numeros.ZERO);
                entrada.setTmesliborcmbio(Numeros.ZERO);
                entrada.setVtxliborcmbio("");
                
                
            } else {
                
                entrada.setCbanqrcmbiofndng(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
                entrada.setDcotacfndngcmbio(SiteUtil.stringDataWebToMainframe(finDiretoVO.getDadosPrecificacao().getDtcotac()));
                entrada.setDlimfndngcmbio(SiteUtil.stringDataWebToMainframe(finDiretoVO.getDadosPrecificacao().getDlimfndngcmbio()));
                entrada.setPtxfixacmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getDadosPrecificacao().getCustoext()));
                entrada.setCindcdeconmmoelib(finDiretoVO.getDadosPrecificacao().getCindcdeconmmoeda());
                entrada.setTdiaopercmbio(finDiretoVO.getDadosPrecificacao().getValidadecotac());
                entrada.setTmesliborcmbio(finDiretoVO.getDadosPrecificacao().getPrzomediodsembm());
                entrada.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getDadosPrecificacao().getSpreadclean()));
                entrada.setCbanqrcmbiorcdor(finDiretoVO.getDadosPrecificacao().getBancoReembolsadorVO().getCbanqrcmbio());
                
                
            }
            
            
            entrada.setCbanqrcmbiorcdor(finDiretoVO.getDadosPrecificacao().getBancoReembolsadorVO().getCbanqrcmbio());          
           

            /*** CONTATO ***/
            entrada.setContato_contatonome(finDiretoVO.getObsCotacaoVO().getNomecttclicmbio());
            entrada.setContato_contatotele(finDiretoVO.getObsCotacaoVO().getTelcttclicmbio());

            /*** ROF ***/
            entrada.setContatorof_nome(finDiretoVO.getObsCotacaoVO().getNomerof());
            entrada.setContatorof_telefone(finDiretoVO.getObsCotacaoVO().getTelrof());
            if (finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo3() != null && finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo4() != null) {
                entrada.setContatorof_cpf(SiteUtil.formatarCPFCCNPJ(
                                SiteUtil.nullToInteger(finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo1()
                                                + finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo2()
                                                + finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo3()), Numeros.ZERO,
                                                SiteUtil.nullToInteger(finDiretoVO.getObsCotacaoVO().getRof_cpf().getCpfCampo4())));

            } else {
                entrada.setContatorof_cpf("");
            }
            entrada.setContatorof_cargo(finDiretoVO.getObsCotacaoVO().getCargorof());
            entrada.setContatorof_email(finDiretoVO.getObsCotacaoVO().getEmailrof());

            /*** OUTRAS ESPECIFICAçãES ***/
            entrada.setOutrasespcs(LineBreaks.formatToMainframe(finDiretoVO.getObsCotacaoVO().getOutrasespcs()));

            /*** OBSERVAçãES ***/
            entrada.setObservacao(LineBreaks.formatToMainframe(finDiretoVO.getObsCotacaoVO().getObservacaoInclusao())); //CONFIRMAR OUTAS OBS

            /*** MOTIVO ***/
            entrada.setMotivo(finDiretoVO.getMotivo());

            /*** AVALISTAS - TAVALS_GARNT_CMBIO (20 OCORRENCIAS) ***/
            entrada.setQtdocaval(finDiretoVO.getListaAvalistasInclusao().size());

            if(finDiretoVO.getProduto().isGarantia()) {
                entrada.setCunicpssoaindica(precificacaoVO.getBancoIndicadoVO().getCbanqrcmbio());
            }else{
                entrada.setCunicpssoaindica(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
            }
            
            // ALine - Alteração de acordo com o Leandro
            if (finDiretoVO.getProduto().isBndesPos() || finDiretoVO.getProduto().equals(EnumProduto.PROEX)) {
                entrada.setCunicpssoaindica(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCbanqrcmbio());
            
            } else {
                entrada.setCunicpssoacmbiot(finDiretoVO.getEcunicpssoacmbiot());
            }
            
            /*** AVISADOR ***/
            entrada.setCbanqrcmbioaviso(finDiretoVO.getCbanqrcmbioaviso());

            for (Iterator<GarantiasAvaListaVO> iterator = finDiretoVO.getListaAvalistasInclusao().iterator(); iterator.hasNext();) {
                GarantiasAvaListaVO itemAvalista = (GarantiasAvaListaVO) iterator.next();

                Npccwzxerequest_lstava itemLista = new Npccwzxerequest_lstava();

                itemLista.setLstava_cunicpssoacmbio(itemAvalista.getCunicpssoacmbio());

                entrada.getLstava().add(itemLista);

            }

            /*** VINCULO - TVNCLO_NEGOC_TRADE (20 OCORRENCIAS) ***/
            entrada.setQtdocvinc(finDiretoVO.getListaOperacaoVinculada().size());

            for (Iterator<TrdFinNegOperVincVO> iterator = finDiretoVO.getListaOperacaoVinculada().iterator(); iterator.hasNext();) {
                TrdFinNegOperVincVO itemOperVinc = (TrdFinNegOperVincVO) iterator.next();

                Npccwzxerequest_lstvin itemLista = new Npccwzxerequest_lstvin();

                itemLista.setLstvin_nbletonegocvnclo(itemOperVinc.getNbletonegoccmbio());
                
                if(SiteUtil.isEmptyOrNull(itemOperVinc.getCindcdvncloimpor())){
                    itemOperVinc.setCindcdvncloimpor("N");
                }
                itemLista.setLstvin_cindcdvncloimpor(itemOperVinc.getCindcdvncloimpor());

                entrada.getLstvin().add(itemLista);

            }

            /*** TARIFAS - TTARIF_BLETO_CMBIO (20 OCORRENCIAS) ***/
            entrada.setQtdoctari(finDiretoVO.getListaTarifas().size());

            for (Iterator<TrdFinNegTarifaVO> iterator = finDiretoVO.getListaTarifas().iterator(); iterator.hasNext();) {
                TrdFinNegTarifaVO itemTarifa = (TrdFinNegTarifaVO) iterator.next();

                Npccwzxerequest_lsttar itemLista = new Npccwzxerequest_lsttar();

                itemLista.setLsttar_cindcdeconmmoetar(itemTarifa.getCindcdeconmmoeda());
                itemLista.setLsttar_ccondceconc(itemTarifa.getCcondceconc());
                itemLista.setLsttar_ntarifbletocmbio(itemTarifa.getNtarifbletocmbio());
                itemLista.setLsttar_vtarifopercmbio(SiteUtil.webMoedaToMainframe(itemTarifa.getVdespbletocmbio()));

                entrada.getLsttar().add(itemLista);

            }

            /*** GARANTIAS - TGARNT_CMBIO_EXGDO (20 OCORRENCIAS) ***/
            entrada.setQtdocgarn(finDiretoVO.getListaGarantiasInclusao().size());

            Integer contador = 1;

            for (GarantiasVO itemGarantia : finDiretoVO.getListaGarantiasInclusao()) {

                Npccwzxerequest_lstgar itemLista = new Npccwzxerequest_lstgar();

                itemLista.setLstgar_ccatlggarnt(itemGarantia.getCcaractpogarnt());
                itemLista.setLstgar_cindcdeconmmoegar(itemGarantia.getCindcdeconmmoegar());
                //            itemLista.setLstgar_vtxgarntcmbio(SiteUtil.webMoedaToMainframe(itemGarantia.getVtxgarntcmbio()));
                //            itemLista.setLstgar_dvctogarntcmbio(SiteUtil.stringDataWebToMainframe(itemGarantia.getDvctogarntcmbio()));

                itemLista.setLstgar_vtxgarntcmbio(SiteUtil.formatarPontosVirgula(itemGarantia.getVtxgarntcmbio()));
                itemLista.setLstgar_dvctogarntcmbio(SiteUtil.stringDataWebToMainframe(itemGarantia.getDvctogarntcmbio()));
                itemLista.setLstgar_cindcdgarntprinc(itemGarantia.getCindcdgarntprinc());
                itemLista.setLstgar_cidtfdgarntadcio(itemGarantia.getCidtfdgarntadcio());
                itemLista.setLstgar_rcomplgarntcmbio(itemGarantia.getRcomplgarntcmbio());

                //adicionado para controle mainframe Derick 05/07/2016
                itemLista.setLstgar_ngarntcmbio(contador++);

                entrada.getLstgar().add(itemLista);

            }

            // Executa chamada CWS - Fluxo: NPCCIAQZ - Books: NPCCWZXE / NPCCWZXS
            listaSemPaginacao(request, response, "FNDRGRTVNCTRFOBSALT");

            setMsgRetorno(response.getTexmens());

            return finDiretoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarGarantiasVinculosTarifasObs | FNDRGRTVNCTRFOBSALT ------- ");
        }

    }

    public TrdFinNegocInclVO alterarDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO, TradeFinanceVO dadosBasicos) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.alterarDadosBasicosGp1Gp3 | DADOSBASEGP1GP3ALT ------- ");

            Dadosbasegp1gp3altrequest request = new Dadosbasegp1gp3altrequest();
            Dadosbasegp1gp3altresponse response = new Dadosbasegp1gp3altresponse();
            Npccwwberequest entrada = new Npccwwberequest();
            Npccwwbsresponse saida = new Npccwwbsresponse();
            request.setNpccwwberequest(entrada);
            response.setNpccwwbsresponse(saida);

            entrada.setCusuarmanut(SiteUtil.recuperarUsuarioLogado());
            entrada.setHmanutreg(finDiretoVO.getHmanutreg());
            entrada.setNbletocmbioorige(finDiretoVO.getNbletocmbioorige());
            entrada.setCtpocanal(finDiretoVO.getCtpocanal());
            entrada.setNtpoclasfpssoa(finDiretoVO.getNtpoclasfpssoa());
            entrada.setVutlzdlimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVutlzdlimgerc()));
            entrada.setVsdolimsensi(SiteUtil.formatarPontosVirgula(finDiretoVO.getVsdolimsensi()));
            entrada.setCsitbletoaprov(finDiretoVO.getCsitbletoaprov());
            entrada.setCmotvobletocmbio(finDiretoVO.getCmotvobletocmbio());
            entrada.setCusuarincl(finDiretoVO.getCusuarincl());
            entrada.setCpssoajuridcli(finDiretoVO.getCpssoajuridcli());
            entrada.setNsequndcli(finDiretoVO.getNsequndcli());
            entrada.setDvalddlimcmbio(finDiretoVO.getDvalddlimcmbio());
            entrada.setNppstapontucmbio(finDiretoVO.getNppstapontucmbio());
            entrada.setCeconmmoedaequal(finDiretoVO.getCeconmmoedaequal());
            entrada.setCmoedaeconmrecta(finDiretoVO.getCmoedaeconmrecta());
            entrada.setCunicpssoacta(finDiretoVO.getCunicpssoacta());

            if (finDiretoVO.getPeriodoValidadeProposta() != null && finDiretoVO.getPeriodoValidadeProposta().getInicio() != null) {
                entrada.setDinicvalddppsta(SiteUtil.dataWebToMainframe(finDiretoVO.getPeriodoValidadeProposta().getInicio()));
                entrada.setDfimvalddppsta(SiteUtil.dataWebToMainframe(finDiretoVO.getPeriodoValidadeProposta().getFim()));   
            }
            
            entrada.setDinicvalddcmbio(finDiretoVO.getDinicvalddcmbio());
            entrada.setDfimnegoccmbio(finDiretoVO.getDfimnegoccmbio());
            
            entrada.setCnegoccmbioindmd(finDiretoVO.getCnegoccmbioindmd());
            entrada.setDlimembrqcmbio(finDiretoVO.getDlimembrqcmbio());
            entrada.setDlimdoctoembrq(finDiretoVO.getDlimdoctoembrq());
            entrada.setDprevtgarntexpdi(SiteUtil.dataWebToMainframe(finDiretoVO.getDprevtgarntexpdi()));
            entrada.setTdiavalddcarta(finDiretoVO.getTdiavalddcarta());
            entrada.setQprevtembrqcmbio(finDiretoVO.getQprevtembrqcmbio());
            entrada.setQregexporcmbio(finDiretoVO.getQregexporcmbio());
            entrada.setCindcdembrqpcial(finDiretoVO.getCindcdembrqpcial());
            entrada.setCpermtrnsfcarta(finDiretoVO.getCpermtrnsfcarta());
            entrada.setCindcdcartaidpdt(finDiretoVO.getCindcdcartaidpdt());
            entrada.setCcartaconverecdd(finDiretoVO.getCcartaconverecdd());
            entrada.setCindcdlastrcarta(finDiretoVO.getCindcdlastrcarta());
            entrada.setCindcdlastragric(finDiretoVO.getCindcdlastragric());
            entrada.setCpermvarcmbio(finDiretoVO.getCpermvarcmbio());
            entrada.setCtpoembrqcmbio(finDiretoVO.getCtpoembrqcmbio());
            entrada.setCidtfdbndesporte(finDiretoVO.getCidtfdbndesporte());
            entrada.setCidtfdbndesgrp(finDiretoVO.getCidtfdbndesgrp());
            entrada.setCprznegoccmbio(finDiretoVO.getCprznegoccmbio());
            entrada.setCidtfdcartacsndo(finDiretoVO.getCidtfdcartacsndo());
            entrada.setCtpojurotrade(finDiretoVO.getCtpojurotrade());
            entrada.setCcobrcomismtori(finDiretoVO.getCcobrcomismtori());
            entrada.setCidtfdformacomis(finDiretoVO.getCidtfdformacomis());
            entrada.setVprevtcmbioequal(SiteUtil.formatarPontosVirgula(finDiretoVO.getVprevtcmbioequal()));
            entrada.setVprevtrectacmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVprevtrectacmbio()));
            entrada.setVtxremunbndes(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxremunbndes()));
            entrada.setVtxremuncmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxremuncmbio()));
            entrada.setVlimcobervar(SiteUtil.formatarPontosVirgula(finDiretoVO.getVlimcobervar()));
            entrada.setPcobervarprodt(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcobervarprodt()));
            entrada.setPtxcdifinan(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxcdifinan()));
            entrada.setPcdimaiscmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcdimaiscmbio()));
            entrada.setPjuronegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPjuronegoccmbio()));
            entrada.setPfixajurocmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPfixajurocmbio()));
            entrada.setPtotjurocmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtotjurocmbio()));
            entrada.setPcomismtoricmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPcomismtoricmbio()));
            entrada.setPagtefincrcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPagtefincrcmbio()));
            entrada.setPtxequalcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxequalcmbio()));
            entrada.setIorgextercmbio(finDiretoVO.getIorgextercmbio());
            entrada.setCfluxoperdccmbio(finDiretoVO.getCfluxoperdccmbio());
            entrada.setDprevtinicembrq(finDiretoVO.getDprevtinicembrq());
            entrada.setDprevtfimembrq(finDiretoVO.getDprevtfimembrq());
            entrada.setCindcdcntragarnt(dadosBasicos.getCindcdcntragarnt());
            entrada.setTdiacntragarnt(dadosBasicos.getTdiacntragarnt());
            entrada.setDvctocntragarnt(SiteUtil.dataWebToMainframe(dadosBasicos.getDvctocntragarnt()));
            entrada.setDabertcntragarnt(SiteUtil.dataWebToMainframe(dadosBasicos.getDabertcntragarnt()));
            entrada.setCindcdrenovcntra(dadosBasicos.getCindcdrenovcntra());
            entrada.setQdiaalertcntra(dadosBasicos.getQdiaalertcntra());
            entrada.setDalertvctocntra(SiteUtil.dataWebToMainframe(dadosBasicos.getDalertvctocntra()));
            entrada.setCindcdcustoexter(dadosBasicos.getCindcdcustoexter());
            entrada.setCaditvbletocmbio(finDiretoVO.getCaditvbletocmbio());
            entrada.setCindcdcartacnfdo(finDiretoVO.getCindcdcartacnfdo());
            entrada.setCcobrcomisagte(finDiretoVO.getCcobrcomisagte());
            entrada.setCmodldprodtcmbio(finDiretoVO.getCmodldprodtcmbio());
            entrada.setInfocomplbndes(finDiretoVO.getGrupomercadoriaboleto());
            entrada.setNbletonegoccmbio(finDiretoVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(finDiretoVO.getNbletocmbioano());
            entrada.setCunicclicmbio(finDiretoVO.getCunicclicmbio());
            entrada.setCpssoajurid(finDiretoVO.getCpssoaundorgnz());
            entrada.setNsequndorgnz(finDiretoVO.getNsequndorgnz());
            entrada.setCtposgmtocli(finDiretoVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(finDiretoVO.getCsitbletocmbio());
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setNseqcontrlim(finDiretoVO.getNseqcontrlim());
            entrada.setCpssoaanlsecredt(finDiretoVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(finDiretoVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(finDiretoVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(finDiretoVO.getNseqsoltcanlse());
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            entrada.setCeconmmoedalim(finDiretoVO.getCeconmmoedalim());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmoedalimgerc()));

            entrada.setCindcdnegocswap(finDiretoVO.getCindcdnegocswap());
            if (finDiretoVO.isCindcdnegoclibor() == Boolean.TRUE) {
                entrada.setCindcdnegoclibor("1");
            } else {
                entrada.setCindcdnegoclibor("2");
            }
            if (finDiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            if (finDiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCnegocswapestrg("1");
            } else {
                entrada.setCnegocswapestrg("2");
            }
            entrada.setPtxswapcmpdo(SiteUtil.formatarPontosVirgula(finDiretoVO.getPtxswapcmpdo()));

            entrada.setCindcdnegoccarta(finDiretoVO.getCindcdnegoccarta());

            entrada.setDvalddnegoccmbio(finDiretoVO.getDvalddnegoccmbio());

            entrada.setCcomiscartanacio(finDiretoVO.getCcomiscartanacio());

            entrada.setCindcdnegocarbtr(finDiretoVO.getCindcdnegocarbtr());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtravaliborcmbio()));
            entrada.setVimpstnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVimpstnegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxmoracmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadnegoc()));
            entrada.setVmultanegoccmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVmultanegoccmbio()));

            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(finDiretoVO.getVnegocmoedaestrg()));
            entrada.setNctabcriacmbio(finDiretoVO.getNctabcriacmbio());
            entrada.setCtponegoccmbio(finDiretoVO.getCtponegoccmbio());
            entrada.setTdiaopercmbio(finDiretoVO.getTdiaopercmbio());
            entrada.setCeconmmoedadsemb(finDiretoVO.getCeconmmoedadsemb());
            entrada.setCtpocotactx(finDiretoVO.getCtpocotactx());
            entrada.setTdiavalddletra(finDiretoVO.getTdiavalddletra());
            entrada.setQprzmedcmbio(finDiretoVO.getQprzmedcmbio());
            entrada.setCbasejuromora(finDiretoVO.getCbasejuromora());
            entrada.setCcobrcomisadcio(finDiretoVO.getCcobrcomisadcio());
            entrada.setCmodcontrcmbio(finDiretoVO.getCmodcontrcmbio());
            entrada.setCeconmmoedaequal(finDiretoVO.getCeconmmoedaequal());
            entrada.setCsegurtrnspmcado(finDiretoVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(finDiretoVO.getCsegurmcadoorgnz());            
            entrada.setCunicpssoacmbiot(finDiretoVO.getEcunicpssoacmbiot());
            entrada.setCrting(finDiretoVO.getCrting());
            entrada.setVagtefincrcmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVagtefincrcmbio()));
            entrada.setVbcomtoricmbio(SiteUtil.formatarPontosVirgula(finDiretoVO.getVbcomtoricmbio()));


            // Justificativa informada no modal de operações desenquadradas
            entrada.setDprevtdsembcmbio(finDiretoVO.getDprevtdsembcmbio());
            entrada.setRjustfdqmto(finDiretoVO.getRjustfdqmto());
            entrada.setDprevtembrq(finDiretoVO.getDprevtembrq());
             
            entrada.setDlimenviorsumo(finDiretoVO.getDlimenviorsumo());
            if(finDiretoVO.getVtxspreadtot() != null)
            	entrada.setVtxspreadtot(Double.parseDouble(SiteUtil.formatarPontosVirgula(finDiretoVO.getVtxspreadtot())));
            entrada.setCtpoprzcmbio(finDiretoVO.getCtpoprzcmbio());
            
            // FLUXO: NPCCIAQI BOOKS:NPCCWWBE/S
            listaSemPaginacao(request, response, "DADOSBASEGP1GP3ALT");

            finDiretoVO.setHinclreg(response.getNpccwwbsresponse().getHinclreg());

            setMsgRetorno(response.getTexmens());

            return finDiretoVO;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.alterarDadosBasicosGp1Gp3 | DADOSBASEGP1GP3ALT ------- ");
        }
    }


    /**
     * Nome: fluxoValidacao
     * 
     * Propï¿½sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 02/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrï¿½o hexavision.
     */
    public String fluxoValidacao(TrdFinNegocInclVO finDiretoVO,
                    TrdFinNegPrecificacaoVO precifVO,
                    Integer tipoAcesso,
                    List<TradeFinanceDesembolsoVO> listaDesembolso) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.fluxoValidacao | FLUXOVALIDACAO ------- ");

            TrdFinNegFluxoPagtoVO itemFluxo = null;
            List<Npccwx2erequest_lista> listaDesembolsoV = null;
            Npccwx2erequest_lista itemDesembolso = null;
            List<Npccwx2erequest_lstmerc> listaMercadoriaV = null;
            Npccwx2erequest_lstmerc itemMercadoria = null;
            
            Fluxovalidacaorequest request = new Fluxovalidacaorequest();
            Fluxovalidacaoresponse response = new Fluxovalidacaoresponse();
            Npccwx2erequest entrada = new Npccwx2erequest();
            Npccwx2sresponse saida = new Npccwx2sresponse();
            request.setNpccwx2erequest(entrada);
            response.setNpccwx2sresponse(saida);
            
            entrada.setValoroperacao(SiteUtil.webMoedaToMainframe(finDiretoVO.getVnegocmoedaestrg()));
            entrada.setTdiafinandsemb(finDiretoVO.getTdiaopercmbio());
            entrada.setSpreadclean(SiteUtil.formatarPontosVirgula(precifVO.getSpreadclean()));
            entrada.setCindcdtipoacces(tipoAcesso);
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setCindcdnegoccarta(finDiretoVO.getCindcdnegoccarta());
            entrada.setNbletonegoccmbio(finDiretoVO.getNbletonegoccmbio());
            entrada.setDvalddnegoccmbio(finDiretoVO.getDvalddnegoccmbio().replace("/", "."));
            entrada.setCbanqrcmbiofndng(precifVO.getUnidadeExternaVO().getCbanqrcmbio());
            entrada.setCpais(finDiretoVO.getDadosPrecificacao().getUnidadeExternaVO().getCpais());
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            entrada.setPtxfixacmbio(SiteUtil.trocarVirgulaPorPonto(precifVO.getPtxfixacmbio()));
            entrada.setVtravaliborcmbio(SiteUtil.trocarVirgulaPorPonto(finDiretoVO.getVtravaliborcmbio()));
            
            if (finDiretoVO.isCnegocswapestrg() == Boolean.TRUE) {
                entrada.setCindcdnegocswap("1");
            } else {
                entrada.setCindcdnegocswap("2");
            }
            if(finDiretoVO.isCnegocswapfluxo() == Boolean.TRUE) {
                entrada.setCnegocswapfluxo("1");
            } else {
                entrada.setCnegocswapfluxo("2");
            }
            
            listaDesembolsoV = new ArrayList<Npccwx2erequest_lista>();
            
            if(EnumProduto.PRODUTO_FORFAITING.getCodigo().equals(finDiretoVO.getProduto().getCodigo()) && listaDesembolso.size() > Numeros.ZERO){

                for (Iterator<TradeFinanceDesembolsoVO> iterator = listaDesembolso.iterator(); iterator.hasNext();) {
                    
                    TradeFinanceDesembolsoVO lista = iterator.next();                   
                    itemDesembolso = new Npccwx2erequest_lista();
                    itemDesembolso.setLista_vprevtdsembcmbio(SiteUtil.webMoedaToMainframe(lista.getVprevtdsembcmbio()));
                    itemDesembolso.setLista_dprevtdsembcmbio(lista.getDataDesembolsoFormat().replace("/", "."));
                    itemDesembolso.setLista_vtxliborcmbio(SiteUtil.webMoedaToMainframe(lista.getVtxliborcmbio()));
                    itemDesembolso.setLista_ptxjurofndng(SiteUtil.webMoedaToMainframe(lista.getPtxjurofndng()));
                    itemDesembolso.setLista_pjuronegoccmbio(SiteUtil.webMoedaToMainframe(lista.getPjuronegoccmbio()));
                    itemDesembolso.setLista_pspreadtxcmbio(SiteUtil.webMoedaToMainframe(lista.getPspreadtxcmbio()));
                    itemDesembolso.setLista_tdiafinandsemb1(lista.getTdiafinandsemb());
                    itemDesembolso.setLista_vjurodsembcmbio(SiteUtil.webMoedaToMainframe(lista.getVjurodsembcmbio()));
                    itemDesembolso.setLista_vdsembnegoccmbio(SiteUtil.webMoedaToMainframe(lista.getVdsembnegoccmbio()));
                    
                    listaDesembolsoV.add(itemDesembolso);
                }
                entrada.setQtdocorr(listaDesembolsoV.size());
            }
            
            else if (finDiretoVO.getListaFluxos().size() > Numeros.ZERO) {              
                
                for (Iterator<TrdFinNegFluxoPagtoVO> iterator = finDiretoVO.getListaFluxos().iterator(); iterator.hasNext();) {
                    
                    itemFluxo = (TrdFinNegFluxoPagtoVO) iterator.next();
                    itemDesembolso = new Npccwx2erequest_lista();
                    itemDesembolso.setLista_cindcdpcobrprinc(itemFluxo.getCfluxoliqdcprinc());
                    itemDesembolso.setLista_vprevtdsembcmbio(SiteUtil.webMoedaToMainframe(itemFluxo.getVprevtdsembcmbio()));
                    itemDesembolso.setLista_dprevtdsembcmbio(itemFluxo.getDprevtdsembcmbio().replace("/", "."));
                    itemDesembolso.setLista_cfluxoliqdcprinc(itemFluxo.getCfluxoliqdcprinc());
                    itemDesembolso.setLista_cfluxoliqdcjuro(itemFluxo.getCodJurosPeriodicidade());

                    // Enviar todos os campos de Fluxo de Pgto., Mercadoria e SWAP
                    itemDesembolso.setLista_tdiacarenprinc(itemFluxo.getTdiacarenprinc());
                    itemDesembolso.setLista_tdiacarenjuro(itemFluxo.getJurosCarencia());
                    itemDesembolso.setLista_qpcelatradeprinc(itemFluxo.getPrincQtdParcelas());
                    itemDesembolso.setLista_qpcelatradejuro(itemFluxo.getJurosQtdParcelas());
                    itemDesembolso.setLista_cmomencobrcmbio(itemFluxo.getCodJurosMomento());
                    itemDesembolso.setLista_ndsembcmbiotrade(itemFluxo.getSeqFluxoPagto());

                    listaDesembolsoV.add(itemDesembolso);
                }
                entrada.setQtdocorr(listaDesembolsoV.size());
            } else {
                entrada.setQtdocorr(Numeros.NUM0);
            }
            
            entrada.setLista(listaDesembolsoV);

            /*** MERCADORIA - TMCADO_CMBIO_TRADE (20 OCORRENCIAS) ***/
            listaMercadoriaV = new ArrayList<Npccwx2erequest_lstmerc>();
            
            entrada.setQtdocorrmerc(finDiretoVO.getListaMercadoria().size());

            for (Iterator<TrdFinNegMercadoriaVO> iterator = finDiretoVO.getListaMercadoria().iterator(); iterator.hasNext();) {
                TrdFinNegMercadoriaVO itemMerc = (TrdFinNegMercadoriaVO) iterator.next();
                
                itemMercadoria = new Npccwx2erequest_lstmerc();

                itemMercadoria.setLstmerc_cmcadoopercmbio(itemMerc.getCmcadoopercmbio());
                itemMercadoria.setLstmerc_cpaisbnefc(itemMerc.getCpaisbnefc());
                itemMercadoria.setLstmerc_cpaisorigm(itemMerc.getCpais());
                itemMercadoria.setLstmerc_cunicpssoacmbio(itemMerc.getCunicpssoamcado());
                itemMercadoria.setLstmerc_dprevtembrq(SiteUtil.dataWebToMainframe(itemMerc.getDprevtembrq()));
                itemMercadoria.setLstmerc_ndsembmcadotrade(itemMerc.getNdsembcmbiotrade());
                
                listaMercadoriaV.add(itemMercadoria);
            }
            
            entrada.setLstmerc(listaMercadoriaV);
            entrada.setCindcdeconmmoeda(finDiretoVO.getCindcdeconmmoeda());
            
            //Valor mínimo comissão interna
            List<TrdFinNegComissaoVO> listaComissaoInterna = finDiretoVO.getListaComissaoInterna();
            for (TrdFinNegComissaoVO trdFinNegComissaoVO : listaComissaoInterna) {
                entrada.setVmincobrcomis(SiteUtil.webMoedaToMainframe(trdFinNegComissaoVO.getVlxtotalcomis()));
			}
            
            // Fluxo: NPCCIAPH - Books: NPCCWX2E / NPCCWX2S
            listaSemPaginacao(request, response, "FLUXOVALIDACAO");

            finDiretoVO.setCsitbletocmbio(response.getNpccwx2sresponse().getCsitbletocmbio());

            return response.getNpccwx2sresponse().getInformativo();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.fluxoValidacao | FLUXOVALIDACAO ------- ");
        }

    }
    
    /**
     * Nome: fluxoValidacaopagame
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 02/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Integer fluxoValidacaoPagamento(TrdFinNegocInclVO finDiretoVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.fluxoValidacaoPagamento | FLUXOVALIDACAOPAGAMENTO ------- ");


            Fluxovalidacaopagamerequest request = new Fluxovalidacaopagamerequest();
            Fluxovalidacaopagameresponse response = new Fluxovalidacaopagameresponse();
            Npccwx8erequest entrada = new Npccwx8erequest();
            Npccwx8sresponse saida = new Npccwx8sresponse();
            request.setNpccwx8erequest(entrada);
            response.setNpccwx8sresponse(saida);            
                       
            entrada.setCprodtservc(finDiretoVO.getCprodtservc());
            entrada.setCmodldprodtcmbio(finDiretoVO.getCmodldprodtcmbio());
            entrada.setTdiaopercmbio(finDiretoVO.getTdiaopercmbio());
            entrada.setTdiacarenprinc(finDiretoVO.getPrevDesembolsoVO().getTdiacarenprinc());
            entrada.setCindcdpcobrprinc(finDiretoVO.getCfluxoperdccmbio());
            entrada.setQtdeocorrprinc(finDiretoVO.getPrevDesembolsoVO().getQpcelatradeprinc());


            // Fluxo: NPCCIAPN  - Books: NPCCWX8E / NPCCWX8S
            listaSemPaginacao(request, response, "FLUXOVALIDACAOPAGAME");

            return response.getNpccwx8sresponse().getQtdeocorrprinc();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.fluxoValidacaoPagamento | FLUXOVALIDACAOPAGAMENTO ------- ");
        }

    }

    /**
     * Nome: calcTaxasForfaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 13/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Boolean calcTaxasForfaiting(TaxasForfaitingVO TxVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcTaxasForfaiting | TAXASFORFAITINGCALC ------- ");

            Taxasforfaitingcalcrequest request = new Taxasforfaitingcalcrequest();
            Taxasforfaitingcalcresponse response = new Taxasforfaitingcalcresponse();
            Npccwzcerequest entrada = new Npccwzcerequest();
            Npccwzcsresponse saida = new Npccwzcsresponse();
            request.setNpccwzcerequest(entrada);
            response.setNpccwzcsresponse(saida);

            entrada.setJurosembded(TxVO.getJurosembded());
            entrada.setVnegocmoedaestrg(SiteUtil.webMoedaToMainframe(TxVO.getVnegocmoedaestrg()));
            entrada.setTdiaopercmbio(TxVO.getTdiaopercmbio());
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(TxVO.getVtravaliborcmbio()));
            entrada.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(TxVO.getVtxliborcmbio()));
            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(TxVO.getVtxspreadnegoc()));

            listaSemPaginacao(request, response, "TAXASFORFAITINGCALC");

            TxVO.setTaxajuros(SiteUtil.trocarPontoPorVirgula(response.getNpccwzcsresponse().getTaxajuros()));
            TxVO.setTaxadescontada(SiteUtil.trocarPontoPorVirgula(response.getNpccwzcsresponse().getTaxadescontada()));
            TxVO.setValorjuros(SiteUtil.formatarValorWeb(response.getNpccwzcsresponse().getValorjuros()));
            TxVO.setValorsaque(SiteUtil.formatarValorWeb(response.getNpccwzcsresponse().getValorsaque()));

            return true;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.calcTaxasForfaiting | TAXASFORFAITINGCALC ------- ");
        }

    }

    /**
     * Nome: incluirAlterarObservacoesCotacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 31/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirAlterarObservacoesCotacao(ObservacoesCotacaoVO obsVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirAlterarObservacoesCotacao | OBSERVCOTACAOINCLALT ------- ");

            Observcotacaoinclaltrequest request = new Observcotacaoinclaltrequest();
            Observcotacaoinclaltresponse response = new Observcotacaoinclaltresponse();
            Npccww0erequest entrada = new Npccww0erequest();
            Npccww0sresponse saida = new Npccww0sresponse();
            request.setNpccww0erequest(entrada);
            response.setNpccww0sresponse(saida);

            entrada.setCtpooper(obsVO.getCtpooper());
            entrada.setHinclreg(obsVO.getHinclreg());
            entrada.setNbletonegoccmbio(obsVO.getNbletonegoccmbio());
            entrada.setCunicclicmbio(obsVO.getCunicclicmbio());
            entrada.setQtdocrebt(obsVO.getQtdocrebt());
            entrada.setQtdoctxde(obsVO.getQtdoctxde());
            entrada.setNomecttclicmbio(obsVO.getNomecttclicmbio());
            entrada.setTelcttclicmbio(obsVO.getTelcttclicmbio());
            entrada.setFpgtocomplcmbio(obsVO.getFpgtocomplcmbio());
            entrada.setNidtfdcartacsndo(obsVO.getNidtfdcartacsndo());
            entrada.setDespconf(obsVO.getDespconf());
            entrada.setDespdesc(obsVO.getDespdesc());
            entrada.setFormamor(obsVO.getFormamor());
            entrada.setGarantias(obsVO.getGarantias());
            entrada.setAmortizar(obsVO.getAmortizar());
            entrada.setPagajuro(obsVO.getPagajuro());
            entrada.setPartbnds(obsVO.getPartbnds());
            entrada.setOrcamento(obsVO.getOrcamento());
            entrada.setGaranbnds(obsVO.getGaranbnds());
            entrada.setGaranbrad(obsVO.getGaranbrad());
            entrada.setTxapre(obsVO.getTxapre());
            entrada.setCustfin(obsVO.getCustfin());
            entrada.setMercadoria(obsVO.getMercadoria());
            entrada.setDadosnome(obsVO.getDadosnome());

            CadastroNacionalPessoa cpfCnpj = null;

            // Verifica qual é o tipo de documento para quebrar o campo em 3 partes
            if (obsVO.getCodCpfCnpj().equals(Numeros.TRES)) {

                // Quebra o cpf para envio ao MF
                if (!SiteUtil.isEmptyOrNull(obsVO.getCpfDeposit().toString())) {
                    cpfCnpj = new CadastroNacionalPessoa(obsVO.getCpfDeposit().toString());
                }
            } else if (obsVO.getCodCpfCnpj().equals(Numeros.DOIS)) {

                // Quebra o cnpj para envio ao MF
                if (!SiteUtil.isEmptyOrNull(obsVO.getCnpjDeposit().toString())) {
                    cpfCnpj = new CadastroNacionalPessoa(obsVO.getCnpjDeposit().toString());
                }
            }

            if (cpfCnpj != null) {
                entrada.setDadoscpfcnpjr(cpfCnpj.getBase());
                entrada.setDadoscpfcnpjf(cpfCnpj.getFilial());
                entrada.setDadoscpfcnpjd(cpfCnpj.getDigito());
            }

            entrada.setDadosender(obsVO.getDadosender());
            entrada.setDadosident(obsVO.getDadosident());
            entrada.setDadosorgao(obsVO.getDadosorgao());
            entrada.setDadosestci(obsVO.getDadosestci());
            entrada.setDadosregci(obsVO.getDadosregci());
            entrada.setCargonome(obsVO.getCargonome());
            entrada.setCargoemail(obsVO.getCargoemail());
            entrada.setGarangarant(obsVO.getGarangarant());
            entrada.setGaranimport(obsVO.getGaranimport());
            entrada.setGarancondbgar(obsVO.getGarancondbgar());
            entrada.setGarancondbman(obsVO.getGarancondbman());
            entrada.setGarancondagfi(obsVO.getGarancondagfi());
            entrada.setFinalidade(obsVO.getFinalidade());
            entrada.setRetirnome(obsVO.getRetirnome());
            entrada.setRetirender(obsVO.getRetirender());
            entrada.setRetircidade(obsVO.getRetircidade());
            entrada.setRetirtele(obsVO.getRetirtele());
            entrada.setRetiremail(obsVO.getRetiremail());

            entrada.setLstrbt(new ArrayList<Npccww0erequest_lstrbt>());

            for (ListaRebateVO itemRebate : obsVO.getListaRebate()) {

                Npccww0erequest_lstrbt objRebate = new Npccww0erequest_lstrbt();
                objRebate.setLstrbt_rebate(LineBreaks.addCaracterToMainframe(itemRebate.getRebate()));
                entrada.getLstrbt().add(objRebate);
            }

            entrada.setLsttde(new ArrayList<Npccww0erequest_lsttde>());

            for (ListaTaxaDescontoVO itemTaxa : obsVO.getListaTaxa()) {

                Npccww0erequest_lsttde objTxDesc = new Npccww0erequest_lsttde();
                objTxDesc.setLsttde_txades(LineBreaks.addCaracterToMainframe(itemTaxa.getTxades()));
                entrada.getLsttde().add(objTxDesc);
            }

            // Fluxo: NPCCIAP2 - Books: NPCCWW0E / NPCCWW0S
            listaSemPaginacao(request, response, "OBSERVCOTACAOINCLALT");

            setMsgRetorno(response.getTexmens());

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirAlterarObservacoesCotacao | OBSERVCOTACAOINCLALT ------- ");
        }
    }

    /**
     * Nome: calcCustoTotalForfaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 01/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String calcCustoTotalForfaiting(TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO, TrdFinNegocInclVO custoTotalForfaiting,
                    String vtxspreadnegoc,
                    String vtravaliborcmbio,
                    Integer przliborcmbio,
                    String vtxliborcmbio) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcCustoTotalForfaiting | CUSTOTOTALFORFAITING ------- ");
            
            List<Npccwzierequest_lstcadis> listaAdiciona = new ArrayList<Npccwzierequest_lstcadis>();
            
            Custototalforfaitingrequest request = new Custototalforfaitingrequest();
            Custototalforfaitingresponse response = new Custototalforfaitingresponse();
            Npccwzierequest entrada = new Npccwzierequest();
            Npccwzisresponse saida = new Npccwzisresponse();
            request.setNpccwzierequest(entrada);
            response.setNpccwzisresponse(saida);

            entrada.setVtxspreadnegoc(SiteUtil.formatarPontosVirgula(vtxspreadnegoc));
            entrada.setVtravaliborcmbio(SiteUtil.formatarPontosVirgula(vtravaliborcmbio));
            entrada.setPrzliborcmbio(przliborcmbio);
            entrada.setVtxliborcmbio(SiteUtil.formatarPontosVirgula(vtxliborcmbio));
            
            entrada.setPtxfixacmbio(SiteUtil.formatarPontosVirgula(trdFinNegPrecificacaoVO.getCustoExternoFormat()));
            entrada.setVlrcomisdsemb(SiteUtil.formatarPontosVirgula(trdFinNegPrecificacaoVO.getVlrcomisdsemb()));
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(custoTotalForfaiting.getVnegocmoedaestrg()));
            entrada.setTdiaopercmbio(custoTotalForfaiting.getTdiaopercmbio());
            
            for (Iterator<IComissaoExterna> iterator =  custoTotalForfaiting.getListaComissaoExterna().getComissaoAdicional().iterator(); iterator.hasNext();) {
                TrdFinNegComissaoVO itemLista = (TrdFinNegComissaoVO) iterator.next();
                Npccwzierequest_lstcadis comisAdis = new Npccwzierequest_lstcadis();
                
                comisAdis.setLstcadis_vlrcomisadic(SiteUtil.formatarPontosVirgula(itemLista.getVprevtcomiscmbio()));
                listaAdiciona.add(comisAdis);
            }
            
            entrada.setQtdcomisadic(listaAdiciona.size());
            entrada.setLstcadis(listaAdiciona);
 
            // Fluxo: NPCCIARA - Books: NPCCWZIE / NPCCWZIS
            listaSemPaginacao(request, response, "CUSTOTOTALFORFAITING");

            custoTotalForfaiting.setVtxspreadtot(SiteUtil.trocarPontoPorVirgula(response.getNpccwzisresponse().getVtxspreadtot()));
            return SiteUtil.trocarPontoPorVirgula(response.getNpccwzisresponse().getDsccustototal().replaceAll("_", "+"));

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.calcCustoTotalForfaiting | CUSTOTOTALFORFAITING ------- ");
        }
    }

    /**
     * Nome: calcularSomatoria
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 16/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */  
    public Double calcularSomatoria(Double juros, Double pagamento) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcularSomatoria | CALCULARSOMATORIA ------- ");

            Calcularsomatoriarequest request = new Calcularsomatoriarequest();        
            Calcularsomatoriaresponse response = new Calcularsomatoriaresponse();
            Npccwv8erequest entrada = new Npccwv8erequest();
            Npccwv8sresponse saida = new Npccwv8sresponse();
            request.setNpccwv8erequest(entrada);
            response.setNpccwv8sresponse(saida);

            entrada.setPjuronegoccmbio(juros);
            entrada.setPagtefincrcmbio(pagamento);

            // Fluxo: NPCCIAP0 - Books: NPCCWV8E / NPCCWV8S
            listaSemPaginacao(request, response, "CALCULARSOMATORIA");                

            return response.getNpccwv8sresponse().getPtotjurocmbio();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.calcularSomatoria | CALCULARSOMATORIA ------- ");
        }

    }

    /**
     * Nome: incluirParcelasDesembolso
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 24/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void incluirParcelasDesembolso(Long numBoleto, String registroManutencao, List<ParcelaVO> listaParcelas) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirParcelasDesembolso | INCLUIRPARCELALC ------- ");

            Incluirparcelalcrequest request = new Incluirparcelalcrequest();        
            Incluirparcelalcresponse response = new Incluirparcelalcresponse();
            Npccwv1erequest entrada = new Npccwv1erequest();
            Npccwv1sresponse saida = new Npccwv1sresponse();
            request.setNpccwv1erequest(entrada);
            response.setNpccwv1sresponse(saida);

            entrada.setNbletonegoccmbio(numBoleto);
            entrada.setHmanutreg(registroManutencao);
            entrada.setQtdeocorr(listaParcelas.size());

            Npccwv1erequest_lista parcela = null;
            List<Npccwv1erequest_lista> lista = new ArrayList<Npccwv1erequest_lista>();

            for (ParcelaVO itemLista : listaParcelas) {
                parcela = new Npccwv1erequest_lista();
                parcela.setLista_npceladsembcarta(itemLista.getNpceladsembcarta());
                parcela.setLista_vpcelacartaprevt(SiteUtil.formatarPontosVirgula(itemLista.getVpcelacartaprevt()));
                parcela.setLista_vpcelacredtprevt(SiteUtil.formatarPontosVirgula(itemLista.getVpcelacreditprevt()));
                parcela.setLista_cprzpcelacarta(itemLista.getCprzpcelacarta());
                parcela.setLista_tdiapgtocarta(itemLista.getTdiapgtocarta());
                lista.add(parcela);
            }

            entrada.setLista(lista);

            // Fluxo: NPCCIAPS - Books: NPCCWV1E / NPCCWV1S
            listaSemPaginacao(request, response, "INCLUIRPARCELALC");         

            setMsgRetorno(response.getTexmens());

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirParcelasDesembolso | INCLUIRPARCELALC ------- ");
        }
    }

    /**
     * Nome: calcularPrazoTotalOperacaoLC
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 27/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public int calcularPrazoTotalOperacaoLC(CalcPrazoTotalOperLcVO calcPrazoTotalOperLcVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcularPrazoTotalOperacaoLC | CALCPRAZOTOTALOPERLC ------- ");

            Calcprazototaloperlcrequest request = new Calcprazototaloperlcrequest();        
            Calcprazototaloperlcresponse response = new Calcprazototaloperlcresponse();
            Npccwx3erequest entrada = new Npccwx3erequest();
            Npccwx3sresponse saida = new Npccwx3sresponse();
            request.setNpccwx3erequest(entrada);
            response.setNpccwx3sresponse(saida);

            entrada.setDlimembrqcmbio(calcPrazoTotalOperLcVO.getDlimembrqcmbio());
            entrada.setCprznegoccmbio(calcPrazoTotalOperLcVO.getCprznegoccmbio());
            entrada.setTdiavalddcarta(calcPrazoTotalOperLcVO.getTdiavalddcarta());
            entrada.setTdiavalddletra(calcPrazoTotalOperLcVO.getTdiavalddletra());
            entrada.setQtdeocorr(calcPrazoTotalOperLcVO.getListaTdiapgtocarta().size());

            Npccwx3erequest_lista prazoParcela = new Npccwx3erequest_lista();
            List<Npccwx3erequest_lista> lista = new ArrayList<Npccwx3erequest_lista>();

            for (int i = 0; i < calcPrazoTotalOperLcVO.getListaTdiapgtocarta().size(); i++) {
                prazoParcela.setLista_tdiapgtocarta(calcPrazoTotalOperLcVO.getListaTdiapgtocarta().get(i));
                lista.add(prazoParcela);
                prazoParcela = new Npccwx3erequest_lista();
            }

            entrada.setLista(lista);

            // Fluxo: NPCCIAPI - Books: NPCCWX3E / NPCCWX3S
            listaSemPaginacao(request, response, "CALCPRAZOTOTALOPERLC");         

            setMsgRetorno(response.getTexmens());

            return saida.getStdiaoperdcmbio();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.calcularPrazoTotalOperacaoLC | CALCPRAZOTOTALOPERLC ------- ");
        }
    }

    /**
     * Nome: incluirAlterarDespesasFunindgLC
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 24/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void incluirAlterarDespesasFundingLC(Long numBoleto, String registroManutencao, ListaCotacoesExternasVO cotacaoFunding, String flagProc) {

        try {
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirAlterarDespesasFundingLC | INCALTFUNDINGDESPLC ------- ");

            Incaltfundingdesplcrequest request = new Incaltfundingdesplcrequest();        
            Incaltfundingdesplcresponse response = new Incaltfundingdesplcresponse();
            Npccwv6erequest entrada = new Npccwv6erequest();
            Npccwv6sresponse saida = new Npccwv6sresponse();
            request.setNpccwv6erequest(entrada);
            response.setNpccwv6sresponse(saida);

            entrada.setNbletonegoccmbio(numBoleto);
            entrada.setCusuariosess(cotacaoFunding.getCusuarmanut());
            entrada.setHmanutreg(registroManutencao);
            entrada.setQtdedsp(cotacaoFunding.getListaDespesas().size());
            entrada.setFlagproc(flagProc);
           
            
            /** Dados da Cotação Funding **/
            entrada.setDadosfdg_dcotacfndngcmbio(SiteUtil.stringDataWebToMainframe(cotacaoFunding.getDcotacfndngcmbio()));
            entrada.setDadosfdg_cbanqrcmbiofndng(cotacaoFunding.getCbanqrcmbiofndng());
            entrada.setDadosfdg_cbanqrcmbiorcdor(cotacaoFunding.getCbanqrcmbiorcdor());
            entrada.setDadosfdg_cbanqrcmbioaviso(cotacaoFunding.getCbanqrcmbioaviso());
            entrada.setDadosfdg_dlimfndngcmbio(SiteUtil.stringDataWebToMainframe(cotacaoFunding.getDlimfndngcmbio()));
            entrada.setDadosfdg_ptxfixacmbio(SiteUtil.formatarPontosVirgula(cotacaoFunding.getPtxfixacmbio()));
            entrada.setDadosfdg_cindcdeconmmoelib(cotacaoFunding.getCindcdeconmmoelib());
            entrada.setDadosfdg_tdiaopercmbio(cotacaoFunding.getTdiaopercmbio());
            entrada.setDadosfdg_tmesliborcmbio(cotacaoFunding.getTmesliborcmbio());
            entrada.setDadosfdg_vtxliborcmbio(SiteUtil.formatarPontosVirgula(cotacaoFunding.getVtxliborcmbio()));
            entrada.setDadosfdg_cindcdfndngutl(cotacaoFunding.getCindcdfndngutlzd());
            entrada.setDadosfdg_cfndng(cotacaoFunding.getCfndng());
            
            Npccwv6erequest_listadsp despesa = null;
            List<Npccwv6erequest_listadsp> lista = new ArrayList<Npccwv6erequest_listadsp>();

            for (ListaDespesasVO itemLista : cotacaoFunding.getListaDespesas()) {
                /** Dados das Despesas LC **/
                despesa = new Npccwv6erequest_listadsp();
                despesa.setListadsp_ndespbletocmbio(itemLista.getNdespbletocmbio());
                despesa.setListadsp_ctpodespcmbio(itemLista.getCtpodespcmbio());
                despesa.setListadsp_cfluxoperdccmbio(itemLista.getCfluxoperdccmbio());
                despesa.setListadsp_cidtfdrespdesp(itemLista.getCidtfdrespdesp());
                despesa.setListadsp_vdespbletocmbio(SiteUtil.formatarPontosVirgula(itemLista.getVdespbletocmbio()));
                despesa.setListadsp_pdespnegoccmbio(SiteUtil.formatarPontosVirgula(itemLista.getPdespnegoccmbio()));
                despesa.setListadsp_cbasebletonegoc(itemLista.getCbasebletonegoc());
                despesa.setListadsp_cindcdeconmmoeda(itemLista.getCindcdeconmmoeda());
                despesa.setListadsp_vmindespcmbio(SiteUtil.formatarPontosVirgula(itemLista.getVmindespcmbio()));
                despesa.setListadsp_cformacobrdesp(itemLista.getCformacobrdesp());
                lista.add(despesa);
            }

            entrada.setListadsp(lista);

            // Fluxo: NPCCIAPX - Books: NPCCWV6E / NPCCWV6S
            listaSemPaginacao(request, response, "INCALTFUNDINGDESPLC");         

            setMsgRetorno(response.getTexmens());

        } finally {
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirAlterarDespesasFundingLC | INCALTFUNDINGDESPLC ------- ");
        }        
    }

    /**
     * Nome: calcularPrazosMediosOperacaoDesembolso
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 11/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Boolean calcularPrazosMediosOperacaoDesembolso(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    List<TrdFinNegFluxoPagtoVO> listaFluxo) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcularPrazosMediosOperacaoDesembolso | PRZMEDOPERDESEMBCALC ------- ");

            TrdFinNegFluxoPagtoVO itemFluxo = null;
            List<Npccwzperequest_listapc> listaParcelas = null;
            List<Npccwzperequest_listapr> listaPrazoMedio = null;
            Npccwzperequest_listapr itemPrazo = null;

            Przmedoperdesembcalcrequest request = new Przmedoperdesembcalcrequest();
            Przmedoperdesembcalcresponse response = new Przmedoperdesembcalcresponse();
            Npccwzperequest entrada = new Npccwzperequest();
            Npccwzpsresponse saida = new Npccwzpsresponse();
            request.setNpccwzperequest(entrada);
            response.setNpccwzpsresponse(saida);

            if (SiteUtil.isEmptyOrNull(flxPagtoVO.getVprevtdsembcmbio()) == false &&
                            flxPagtoVO.getDateFluxoPgto() != null) {
                entrada.setVprevtdsembcmbio(SiteUtil.webMoedaToMainframe(flxPagtoVO.getVprevtdsembcmbio()));
                entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(flxPagtoVO.getDateFluxoPgto()));

                entrada.setQtdeocorrpcela(flxPagtoVO.getListaParcelasFluxoPgto().size());
                listaParcelas = new ArrayList<Npccwzperequest_listapc>();
                for (Iterator<TrdFinNegParcelaVO> iterator = flxPagtoVO.getListaParcelasFluxoPgto().iterator();
                                iterator.hasNext();) {
                    TrdFinNegParcelaVO itemParcela = (TrdFinNegParcelaVO) iterator.next();
                    Npccwzperequest_listapc itemParcelaOut = new Npccwzperequest_listapc();

                    itemParcelaOut.setListapc_npceladsembtrade(itemParcela.getNpceladsembtrade());
                    itemParcelaOut.setListapc_npceladsembtrade(itemParcela.getNpceladsembtrade());
                    itemParcelaOut.setListapc_tdianegocpcela(itemParcela.getTdianegocpcela());
                    itemParcelaOut.setListapc_dvctopcelatrade(itemParcela.getDvctopcelatrade());
                    itemParcelaOut.setListapc_vpcelamesatrade(SiteUtil.webMoedaToMainframe(itemParcela.getValorPrincipalParcelaFluxoPgto()));
                    itemParcelaOut.setListapc_tpparcela(itemParcela.getTpparcela());

                    listaParcelas.add(itemParcelaOut);

                }
                entrada.setListapc(listaParcelas);

            } else {
                entrada.setQtdeocorrpcela(Numeros.NUM0);
                listaParcelas = new ArrayList<Npccwzperequest_listapc>();
                entrada.setListapc(listaParcelas);
            }

            listaPrazoMedio = new ArrayList<Npccwzperequest_listapr>();
            if (listaFluxo.size() > Numeros.ZERO) {
                for (Iterator<TrdFinNegFluxoPagtoVO> iterator = listaFluxo.iterator(); iterator.hasNext();) {
                    itemFluxo = (TrdFinNegFluxoPagtoVO) iterator.next();
                    if (flxPagtoVO == null || flxPagtoVO.getSeqFluxoPagto() != itemFluxo.getSeqFluxoPagto()) {
                        itemPrazo = new Npccwzperequest_listapr();
                        itemPrazo.setListapr_przomediodsemb(itemFluxo.getPrzomediodsemb());

                        listaPrazoMedio.add(itemPrazo);
                    }
                }
                entrada.setQtdeocorrprzom(listaPrazoMedio.size());
            } else {
                entrada.setQtdeocorrprzom(Numeros.NUM0);
            }
            entrada.setListapr(listaPrazoMedio);

            // Fluxo: NPCCIARH - Books: NPCCWZPE / NPCCWZPS
            listaSemPaginacao(request, response, "PRZMEDOPERDESEMBCALC");

            flxPagtoVO.setPrzomediooperd(response.getNpccwzpsresponse().getPrzomediooperd());
            flxPagtoVO.setPrzomedioopera(SiteUtil.trocarPontoPorVirgula(response.
                            getNpccwzpsresponse().getPrzomedioopera()));
            flxPagtoVO.setPrzomediodsemb(response.getNpccwzpsresponse().getPrzomediodsemb());
            flxPagtoVO.setTdiafinandsemb(response.getNpccwzpsresponse().getTdiafinandsemb());

            return Boolean.TRUE;
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.calcularPrazosMediosOperacaoDesembolso | PRZMEDOPERDESEMBCALC ------- ");
        }
    }

        /**
        * Nome: calcularPrazoMedioComAnaliseFluxoPagto
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 03/08/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
        */
    public Boolean calcularPrazoMedioComAnaliseFluxoPagto(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    TrdFinNegocInclVO trdFinNegVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcularPrazoMedioComAnaliseFluxoPagto | PRZMEDOPERDESEMBCALC ------- ");


            return Boolean.TRUE;

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.calcularPrazoMedioComAnaliseFluxoPagto | PRZMEDOPERDESEMBCALC ------- ");
        }
    }
    

    /**
     * Nome: incluirComplGarantia
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 21/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String incluirComplGarantia(TrdFinNegocInclVO saidaDados , Long nbletonegoccmbio) {

        Incluircomplgarantiarequest request = new Incluircomplgarantiarequest();
        Incluircomplgarantiaresponse response = new Incluircomplgarantiaresponse();


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirComplGarantia | INCLUIRCOMPLGARANTIA ------- ");

            Npccwyierequest entrada = new Npccwyierequest();
            Npccwyisresponse saida = new Npccwyisresponse();

            request.setNpccwyierequest(entrada);
            response.setNpccwyisresponse(saida);

            entrada.setNbletonegoccmbio(nbletonegoccmbio);
            entrada.setCunicpssoacmbiob(saidaDados.getCunicpssoacmbiob());
            entrada.setCunicpssoacmbioa(saidaDados.getCunicpssoacmbioa());
            entrada.setCindcdcntragarnt(saidaDados.getCindcdcntragarnt()); 
            entrada.setTdiacntragarnt(saidaDados.getTdiacntragarnt());

            entrada.setDvctocntragarnt(SiteUtil.dataWebToMainframe(saidaDados.getDvctocntragarnt()));
            entrada.setDabertcntragarnt(SiteUtil.dataWebToMainframe(saidaDados.getDabertcntragarnt()));
            entrada.setCindcdrenovcntra(saidaDados.getCindcdrenovcntra());
            entrada.setQdiaalertcntra(saidaDados.getQdiaalertcntra());
            entrada.setDalertvctocntra(SiteUtil.dataWebToMainframe(saidaDados.getDalertvctocntra()));
            entrada.setCindcdcustoexter(saidaDados.getCindcdcustoexter());

            // FLUXO: NPCCIAQX BOOK: NPCCWYIE/S
            listaSemPaginacao(request, response, "INCLUIRCOMPLGARANTIA");

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirComplGarantia | INCLUIRCOMPLGARANTIA ------- ");
        }

        return response.getTexmens();
    }

    public String alterarComplGarantia (TrdFinNegocInclVO saidaDados , Long nbletonegoccmbio) {

        Alterarcomplgarantiarequest request = new Alterarcomplgarantiarequest();
        Alterarcomplgarantiaresponse response = new Alterarcomplgarantiaresponse();


        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.incluirComplGarantia | INCLUIRCOMPLGARANTIA ------- ");

            Npccwwjerequest entrada = new Npccwwjerequest();
            Npccwwjsresponse saida = new Npccwwjsresponse();

            request.setNpccwwjerequest(entrada);
            response.setNpccwwjsresponse(saida);

            entrada.setNbletonegoccmbio(nbletonegoccmbio);
            entrada.setCunicpssoacmbiob(saidaDados.getCunicpssoacmbiob());
            entrada.setCunicpssoacmbioa(saidaDados.getCunicpssoacmbioa());
            entrada.setCindcdcntragarnt(saidaDados.getCindcdcntragarnt()); 
            entrada.setTdiacntragarnt(saidaDados.getTdiacntragarnt());

            entrada.setDvctocntragarnt(SiteUtil.dataWebToMainframe(saidaDados.getDvctocntragarnt()));
            entrada.setDabertcntragarnt(SiteUtil.dataWebToMainframe(saidaDados.getDabertcntragarnt()));
            entrada.setCindcdrenovcntra(saidaDados.getCindcdrenovcntra());
            entrada.setQdiaalertcntra(saidaDados.getQdiaalertcntra());
            entrada.setDalertvctocntra(SiteUtil.dataWebToMainframe(saidaDados.getDalertvctocntra()));
            entrada.setCindcdcustoexter(saidaDados.getCindcdcustoexter());
            entrada.setHinclreghist(saidaDados.getHinclreg());
            entrada.setCsitbletocmbio(saidaDados.getCsitbletocmbio());

            // FLUXO: NPCCIAQP  BOOK: NPCCWWJE/S
            listaSemPaginacao(request, response, "ALTERARCOMPLGARANTIA");

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirComplGarantia | INCLUIRCOMPLGARANTIA ------- ");
        }

        return response.getTexmens();
    }

    @Override
    public BeneficiarioVO obterBeneficiario(TrdFinNegMercadoriaVO saidaDados, Integer flagbeneorafia) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
            
            Consbeneficafiancadorequest request = new Consbeneficafiancadorequest();
            Consbeneficafiancadoresponse response = new Consbeneficafiancadoresponse();
            
            Npccwzmerequest entrada = new Npccwzmerequest();
            Npccwzmsresponse saida = new Npccwzmsresponse();
            
            request.setNpccwzmerequest(entrada);
            response.setNpccwzmsresponse(saida);

            entrada.setCunicpssoa(saidaDados.getCunicpssoamcado());
            entrada.setFlagbeneorafia(flagbeneorafia);
            
        
            // FLUXO: NPCCIARE BOOK: NPCCWZME/S 
            listaComPaginacao(request, response, "CONSBENEFICAFIANCADO", "NPCCIARE");
            
            setMsgRetorno(response.getTexmens());
            
            BeneficiarioVO saidaBenf = new BeneficiarioVO();
            
            saidaBenf.setCunicpssoadcmbio(saida.getCunicpssoadcmbio());
            saidaBenf.setIciddcmbio(saida.getIciddcmbio());
            saidaBenf.setIpaiscmbio(saida.getIpaiscmbio());
            saidaBenf.setLogrdcmbio(saida.getLogrdcmbio());
            
            return saidaBenf;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
        }
    }
    
    @Override
    public BeneficiarioVO obterAfiancador(TradeFinNegocListasVO saidaDados, Integer flagbeneorafia) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
            
            Consbeneficafiancadorequest request = new Consbeneficafiancadorequest();
            Consbeneficafiancadoresponse response = new Consbeneficafiancadoresponse();
            
            Npccwzmerequest entrada = new Npccwzmerequest();
            Npccwzmsresponse saida = new Npccwzmsresponse();
            
            request.setNpccwzmerequest(entrada);
            response.setNpccwzmsresponse(saida);

            entrada.setCunicpssoa(saidaDados.getCunicpssoacmbiot());
            entrada.setFlagbeneorafia(flagbeneorafia);
            
            // Só acessa esses dados se for Afiancado 
            // 1 beneficiario - 2 incluir na lupinha incluir e alterar / 3 - consulta ,
                entrada.setCclub(saidaDados.getCdclub());
                entrada.setCdcpfcnpj(saidaDados.getCdcpfcnpj());
                entrada.setCdctrlcpfcnpj(saidaDados.getCdctrlcpfcnpj());
                entrada.setCdfilial(saidaDados.getCdfilial());
           
            // FLUXO: NPCCIARE BOOK: NPCCWZME/S 
            listaComPaginacao(request, response, "CONSBENEFICAFIANCADO", "NPCCIARE");
            
            setMsgRetorno(response.getTexmens());
            
            BeneficiarioVO saidaAfianc = new BeneficiarioVO();
            
            saidaAfianc.setCunicpssoadcmbio(saida.getCunicpssoadcmbio());
            saidaAfianc.setIciddcmbio(saida.getIciddcmbio());
            saidaAfianc.setIpaiscmbio(saida.getIpaiscmbio());
            saidaAfianc.setLogrdcmbio(saida.getLogrdcmbio());
            
            return saidaAfianc;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
        }
    }
    
    /**
     * Nome: operVinculadaLcIncl
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 31/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public void operVinculadaLcIncl(VincularOperacaoLcVO vo) {
         try{
             BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.operVinculadaLcIncl ------- ");
             
             Opervinculadalcinclrequest request = new Opervinculadalcinclrequest();
             Opervinculadalcinclresponse response = new Opervinculadalcinclresponse();
             
             Npccww7erequest entrada = new Npccww7erequest();
             Npccww7sresponse saida = new Npccww7sresponse();
             
             request.setNpccww7erequest(entrada);
             response.setNpccww7sresponse(saida);

             entrada.setNbletonegoccmbio(vo.getNbletonegoccmbio());
             entrada.setNbletovncloimpor(vo.getNbletovncloimpor());
             entrada.setHinclreg(vo.getHinclreg());
            
             // FLUXO: NPCCIARE BOOK: NPCCWZME/S 
             listaSemPaginacao(request, response, "OPERVINCULADALCINCL");
             
             setMsgRetorno(response.getTexmens());
             
         }finally{
             BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.operVinculadaLcIncl ------- ");
         }
     }
     
     /**
      * Nome: validStatusVinculoLc
      * 
      * Propósito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manutenção: 31/05/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequação ao padrão hexavision.
      */
      public VincularOperacaoLcVO validStatusVinculoLc(VincularOperacaoLcVO vo){
          try{
              BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.validStatusVinculoLc ------- ");
              
              VincularOperacaoLcVO result = new VincularOperacaoLcVO();
              
              Validstatusvinculolcrequest request = new Validstatusvinculolcrequest();
              Validstatusvinculolcresponse response = new Validstatusvinculolcresponse();
              
              Npccww4erequest entrada = new Npccww4erequest();
              Npccww4sresponse saida = new Npccww4sresponse();
              
              request.setNpccww4erequest(entrada);
              response.setNpccww4sresponse(saida);

              entrada.setNbletonegoccmbio(vo.getNbletonegoccmbio());
              entrada.setCprodtservc(vo.getCprodtservc());
              entrada.setCsitbletocmbio(vo.getCsitbletocmbio());
             
              // FLUXO: NPCCIAQB BOOK: NPCCWW4E/S 
              listaSemPaginacao(request, response, "VALIDSTATUSVINCULOLC");
              
              setMsgRetorno(response.getTexmens());
              
              result.setCsitequal(saida.getCsitequal());
              result.setNbletovncloimpor(saida.getNbletovncloimpor());
              result.setCprodtservc(saida.getCprodtservc());
              result.setHinclreghist(saida.getHmanutreg());
              result.setCsitbletocmbio(saida.getCsitbletocmbio());
              result.setCsitbletoaprov(saida.getCsitbletoaprov());
              result.setCmodcontrcmbio(saida.getCmodcontrcmbio());
              
              return result;
              
          }finally{
              BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.validStatusVinculoLc ------- ");
          }
      }



      /**
       * Nome: inecIndicadorEconomico
       * 
       * Propósito: 
       *
       * @param : 
       * @return : 
       * @throws :
       * @exception : 
       * @see : Referencias externas.  
       *
       * Registro  de Manutenção: 13/12/2016
       *        - Autor: BRQ
       *        - Responsavel: Equipe Web
       *        - Adequação ao padrão hexavision.
       */
    @Override
    public Integer inecIndicadorEconomico(Integer ecindcdeconm) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.inecIndicadorEconomico ------- ");
            
            Inecindeconomicorequest request = new Inecindeconomicorequest();
            Inecindeconomicoresponse response = new Inecindeconomicoresponse();
            
            Inecwpaerequest entrada = new Inecwpaerequest();
            Inecwpasresponse saida = new Inecwpasresponse();
            
            request.setInecwpaerequest(entrada);
            response.setInecwpasresponse(saida);
            
            entrada.setEcindcdeconm(ecindcdeconm);
            
            // FLUXO: INECIAG6 BOOK: INECWPAE/S
            listaSemPaginacao(request, response, "INECINDECONOMICO");
            
            setMsgRetorno(response.getTexmens());
                        
            return saida.getCpais();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.inecIndicadorEconomico ------- ");
        }
            
    }
    
    /**
     * Nome: desfazimentoIncl
     * 
     * Proposito: Desfazer Inclusão
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public Long desfazimentoIncl(Long nbletonegcmbio) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.desfazimentoIncl | DESFAZIMENTOINCL ------- ");

            Desfazimentoinclrequest request = new Desfazimentoinclrequest();
            Desfazimentoinclresponse response = new Desfazimentoinclresponse();
            Npccw0cerequest entrada = new Npccw0cerequest();
            Npccw0csresponse saida = new Npccw0csresponse();
            request.setNpccw0cerequest(entrada);
            response.setNpccw0csresponse(saida);

            entrada.setNbletonegoccmbio(nbletonegcmbio);

            // Fluxo: NPCCIAPF - Books: NPCCW0CE / NPCCW0CS
            listaSemPaginacao(request, response, "DESFAZIMENTOINCL");
            
            setMsgRetorno(response.getTexmens());

            return saida.getNbletonegoccmbio();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.desfazimentoIncl | DESFAZIMENTOINCL ------- ");
        }
    }
    
    /**
     * Nome: desfazimentoAlt
     * 
     * Proposito: Desfazer Alteração
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public Long desfazimentoAlt(Long nbletonegcmbio) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.desfazimentoAlt | DESFAZIMENTOALT ------- ");

            Desfazimentoaltrequest request = new Desfazimentoaltrequest();
            Desfazimentoaltresponse response = new Desfazimentoaltresponse();
            Npccw55erequest entrada = new Npccw55erequest();
            Npccw55sresponse saida = new Npccw55sresponse();
            request.setNpccw55erequest(entrada);
            response.setNpccw55sresponse(saida);
            
            entrada.setNbletonegoccmbio(nbletonegcmbio);

            // Fluxo: NPCCIAPK - Books: NPCCW55E / NPCCW55S
            listaSemPaginacao(request, response, "DESFAZIMENTOALT");
            
            setMsgRetorno(response.getTexmens());

            return saida.getNbletonegoccmbio();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.desfazimentoAlt | DESFAZIMENTOALT ------- ");
        }
    }
    
    /**
     * Nome: baixarSaldoForfaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 24/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void baixarSaldoForfaiting(TrdFinNegocInclVO negociacaoVO, TradeFinanceDesembolsoVO desembVO) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceNegociacaoServiceImpl.baixarSaldoForfaiting | BAIXASALDOFORFAITING ------- ");

            Baixasaldoforfaitingrequest request = new Baixasaldoforfaitingrequest();        
            Baixasaldoforfaitingresponse response = new Baixasaldoforfaitingresponse();
            Npccww6erequest entrada = new Npccww6erequest();
            Npccww6sresponse saida = new Npccww6sresponse();
            request.setNpccww6erequest(entrada);
            response.setNpccww6sresponse(saida);
            
            entrada.setNbletonegoccmbio(negociacaoVO.getNbletonegoccmbio());
            entrada.setCeconmmoedalim(negociacaoVO.getCeconmmoedalim());
            entrada.setNppstapontucmbio(negociacaoVO.getNppstapontucmbio());
            entrada.setNseqcontrlim(negociacaoVO.getNseqcontrlim());
            entrada.setSaldoadsembolsar(SiteUtil.webMoedaToMainframe(desembVO.getSaldoDesembolsar()));
            entrada.setCsitbletocmbio(negociacaoVO.getCsitbletocmbio());

            // Fluxo: NPCCIAP6 - Books: NPCCWW6E / NPCCWW6S
            listaSemPaginacao(request, response, "BAIXASALDOFORFAITING");         

            setMsgRetorno(response.getTexmens());

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.baixarSaldoForfaiting | BAIXASALDOFORFAITING ------- ");
        }
    }
    
    /**
     * Nome: consultarSituacaoPiloto
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 16/05/2017
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public InformacaoPilotoVO consultarSituacaoPiloto(Long codigoUnicoCliente) {
        InformacaoPilotoVO infoPiloto = new InformacaoPilotoVO();
        
        Consultapilotorequest request = new Consultapilotorequest();
        Consultapilotoresponse response = new Consultapilotoresponse();
        
        Npccwcderequest entrada = new Npccwcderequest();
        Npccwcdsresponse saida = new Npccwcdsresponse();
        
        request.setNpccwcderequest(entrada);
        response.setNpccwcdsresponse(saida);
        
        entrada.setCunicclicmbio(codigoUnicoCliente == null  ? Numeros.ZERO : codigoUnicoCliente);
        
        // Fluxo: NPCCIABJ - Books: NPCCWCDE / NPCCWCDS
        listaSemPaginacao(request, response, "CONSULTAPILOTO");
        
        if (saida.getCpilotcmbioativo() != null && saida.getCpilotcmbioativo() == 1) {
            infoPiloto.setPilotoAtivo(true);
        }

        if (saida.getCpartcpilotcmbio() != null && saida.getCpartcpilotcmbio() == 1) {
            infoPiloto.setClientePiloto(true);
        }

        return infoPiloto;
        
    }
}
