/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
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
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.impl;

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
import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno.Alterarcustoexternorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno.Alterarcustoexternoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno.Npccwygerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno.Npccwygsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro.Aprovarbanqueirorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro.Aprovarbanqueiroresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro.Npccwycerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro.Npccwycsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Combodatadesembolsorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Combodatadesembolsoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Npccwx7erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Npccwx7sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Npccwx7sresponse_listadtdsemb;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Comissaoexternadetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Comissaoexternadetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Npccwxkerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Npccwxksresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet.Npccwxksresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Comissaoforfaitingrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Comissaoforfaitingresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Npccwyoerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Npccwyosresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Npccwyosresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Comissaointernadetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Comissaointernadetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Npccwxferequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Npccwxfsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet.Npccwxfsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao.Confirmaformalizacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao.Confirmaformalizacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao.Npccwkjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao.Npccwkjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Consbeneficafiancadorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Consbeneficafiancadoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Npccwzmerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado.Npccwzmsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Consultarcotacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Consultarcotacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxasresponse_lstrbt;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao.Npccwxasresponse_lsttde;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Cotacoesdivergentesrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Cotacoesdivergentesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Npccwyherequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Npccwyhsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Npccwyhsresponse_saida_listadepara;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Cotacoesexternasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Cotacoesexternasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Npccwyderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Npccwydsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas.Npccwydsresponse_listacontac;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Cotacoesfechadasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Cotacoesfechadasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Npccwzverequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Npccwzvsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Npccwzvsresponse_gride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Cotacoespendcomplrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Cotacoespendcomplresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Npccwyjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Npccwyjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Npccwyjsresponse_gride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Dadosbasicosrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Dadosbasicosresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1sresponse_pcelasfndng;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1sresponse_restricoes;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Dadosforfaitingrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Dadosforfaitingresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4sresponse_pcelasfndng;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4sresponse_restricoes;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Dadosfundinginclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Dadosfundinginclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Npccwwyerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Npccwwyerequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl.Npccwwysresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Fluxopagamentodetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Fluxopagamentodetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Npccwxderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Npccwxdsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet.Npccwxdsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Fluxopagamentolistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Fluxopagamentolistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Npccwxcerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Npccwxcsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList.Npccwxcsresponse_listamesa;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc.Npccwwvsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor.Gerarbatchmonitorrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor.Gerarbatchmonitorresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor.Npccwkwerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor.Npccwkwsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao.Incluirprorrogacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao.Incluirprorrogacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao.Npccww5erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao.Npccww5sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Listadespesasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Listadespesasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Npccwyberequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Npccwybsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas.Npccwybsresponse_listadesp;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Mercadoriaslistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Mercadoriaslistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Npccwxgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Npccwxgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList.Npccwxgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Npccwxjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Npccwxjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Npccwxjsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Obtercomissaoexternarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna.Obtercomissaoexternaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Npccwxeerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Npccwxesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Npccwxesresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Obtercomissaointernarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Obtercomissaointernaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar.Npccwxterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar.Npccwxtsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar.Obterconfirmarbaixarrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar.Obterconfirmarbaixarresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda.Npccwxqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda.Npccwxqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda.Obterconfirmarperdarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda.Obterconfirmarperdaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Npccwyeerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Npccwyesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Npccwyesresponse_gride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Obtercotacoespendrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Obtercotacoespendresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Npccwdjerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Npccwdjsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Npccwdjsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Obtertarifarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Obtertarifaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Npccwzferequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Npccwzfsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Npccwzfsresponse_listaparce;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Parcelasdesembolsorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Parcelasdesembolsoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao.Npccwx9erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao.Npccwx9sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao.Previsaoprorrogacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao.Previsaoprorrogacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Npccwyaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Npccwyasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Npccwyasresponse_listaresp;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Responsaveldespesasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas.Responsaveldespesasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Npccwxherequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Npccwxhsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Npccwxhsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Tradefinoprvinclistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList.Tradefinoprvinclistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Npccwwrerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Npccwwrsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Npccwwrsresponse_gride;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Tradefinancemntlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Tradefinancemntlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Npccww3erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Npccww3erequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Npccww3sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Validadataaprovdesprequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp.Validadataaprovdespresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.CustoExternoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DataDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DeParaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FundingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoVinculadaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaParcelasDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CadastroNacionalPessoa;
import br.com.bradesco.web.npcc_trade.utils.components.LineBreaks;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumAcaoProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumAcaoSituacao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCobrancaComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumGrupoBNDES;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumMomentoJuro;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPorte;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPtax;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumStatusAprovacao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoCotacao;
import br.com.bradesco.web.npcc_trade.view.bean.ResponsavelDespesaVO;

/**
 * Nome: TradeFinanceMonitServiceImpl.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
@Named("tradeFinanceMonitService")
@SessionScoped
public class TradeFinanceMonitServiceImpl extends BaseService implements ITradeFinanceMonitService {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     */
    public TradeFinanceMonitServiceImpl() {
        super();
    }

    /**
     * 
     * Nome: obterOperacaoVinculada
     * 
     * Propósito: Obter lista de operacoes vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<OperacaoVinculadaVO> obterOperacaoVinculada(Long nBleto, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterOperacaoVinculada | TRADEFINOPRVINCLIST ------- ");
            
            List<OperacaoVinculadaVO> lista = new ArrayList<OperacaoVinculadaVO>();
            
            Tradefinoprvinclistrequest request = new Tradefinoprvinclistrequest();
            Tradefinoprvinclistresponse response = new Tradefinoprvinclistresponse();
            
            Npccwxherequest entrada = new Npccwxherequest();
            Npccwxhsresponse saida = new Npccwxhsresponse();
            
            request.setNpccwxherequest(entrada);
            response.setNpccwxhsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo - NPCCIAPD / NPCCWXHE - NPCCWXHS
            listaSemPaginacao(request, response, "TRADEFINOPRVINCLIST");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxhsresponse_lista objFrom = saida.getLista().get(i);
                OperacaoVinculadaVO operacoesVO = new OperacaoVinculadaVO();
                
                operacoesVO.setNbletonegocvnclo(objFrom.getLista_nbletonegocvnclo());
                operacoesVO.setNbletocmbioano(objFrom.getLista_nbletocmbioano());
                operacoesVO.setIindcdeconmmoeda(objFrom.getLista_iindcdeconmmoeda());
                operacoesVO.setVnegocmoedaestr(objFrom.getLista_vnegocmoedaestrg());
                operacoesVO.setIprodtservc(objFrom.getLista_iprodtservc());
                operacoesVO.setCindcdvncloimpor(objFrom.getLista_cindcdvncloimpor());
                
                lista.add(operacoesVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterOperacaoVinculada | TRADEFINOPRVINCLIST ------- ");
        }

    }

    /**
     * 
     * Nome: obterMercadoria
     * 
     * Propósito: Obter lista de mercadorias
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<MercadoriaVO> obterMercadoria(Long nBleto, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterMercadoria | MERCADORIASLIST ------- ");
            
            List<MercadoriaVO> lista = new ArrayList<MercadoriaVO>();
            
            Mercadoriaslistrequest request = new Mercadoriaslistrequest();
            Mercadoriaslistresponse response = new Mercadoriaslistresponse();
            
            Npccwxgerequest entrada = new Npccwxgerequest();
            Npccwxgsresponse saida = new Npccwxgsresponse();
            
            request.setNpccwxgerequest(entrada);
            response.setNpccwxgsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo - NPCCIAOX / NPCCWXGE - NPCCWXGS
            listaSemPaginacao(request, response, "MERCADORIASLIST");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxgsresponse_lista objFrom = saida.getLista().get(i);
                MercadoriaVO mercadoriaVO = new MercadoriaVO();
                
                mercadoriaVO.setNmcadocmbiotrade(objFrom.getLista_nmcadocmbiotrade());
                mercadoriaVO.setCmcadoopercmbio(objFrom.getLista_cmcadoopercmbio());
                mercadoriaVO.setRmcadoopercmbio(objFrom.getLista_rmcadoopercmbio());
                mercadoriaVO.setCpais(objFrom.getLista_cpais());
                mercadoriaVO.setCpaisembrq(objFrom.getLista_cpaisembrq());
                mercadoriaVO.setIpaisembrq(objFrom.getLista_ipaisembrq());
                mercadoriaVO.setIpais(objFrom.getLista_ipais());
                mercadoriaVO.setCunicpssoamcado(objFrom.getLista_cunicpssoamcado());
                mercadoriaVO.setIunicpssoamcado(objFrom.getLista_iunicpssoamcado());
                mercadoriaVO.setCpaisbnefc(objFrom.getLista_cpaisbnefc());
                mercadoriaVO.setIpaisbnefc(objFrom.getLista_ipaisbnefc());
                mercadoriaVO.setDprevtembrq(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dprevtembrq()));
                mercadoriaVO.setDprevtinicembrq(objFrom.getLista_dprevtinicembrq());
                mercadoriaVO.setDprevtfimembrq(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dprevtfimembrq()));
                mercadoriaVO.setCpaisembrq(objFrom.getLista_cpaisembrq());
                mercadoriaVO.setNdsembcmbiotrade(objFrom.getLista_ndsembcmbiotrade());
                
                lista.add(mercadoriaVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterMercadoria | MERCADORIASLIST ------- ");
        }

    }

    /**
     * 
     * Nome: obterTarifa
     * 
     * Propósito: Obter lista de operacoes vinculadas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TarifaVO> obterTarifa(Long nBleto) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterTarifa | OBTERTARIFA ------- ");
            
            List<TarifaVO> lista = new ArrayList<TarifaVO>();
            
            Obtertarifarequest request = new Obtertarifarequest();
            Obtertarifaresponse response = new Obtertarifaresponse();
            
            Npccwdjerequest entrada = new Npccwdjerequest();
            Npccwdjsresponse saida = new Npccwdjsresponse();
            
            request.setNpccwdjerequest(entrada);
            response.setNpccwdjsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            // Fluxo - NPCCIACA / NPCCWDJE - NPCCWDJS
            listaSemPaginacao(request, response, "OBTERTARIFA");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwdjsresponse_lista objFrom = saida.getLista().get(i);
                TarifaVO tarifaVO = new TarifaVO();
                
                tarifaVO.setCindcddesptarf(objFrom.getLista_cindcddesptarf());
                tarifaVO.setCcondceconc(objFrom.getLista_ccondceconc());
                tarifaVO.setNtarifbletocmbio(objFrom.getLista_ntarifbletocmbio());
                tarifaVO.setCtpodespcmbio(objFrom.getLista_ctpodespcmbio());
                tarifaVO.setNdespbletocmbio(objFrom.getLista_ndespbletocmbio());
                tarifaVO.setCtpodespcmbio(objFrom.getLista_ctpodespcmbio());
                tarifaVO.setNdespbletocmbio(objFrom.getLista_ndespbletocmbio());
                tarifaVO.setItpodespcmbio(objFrom.getLista_itpodespcmbio());
                tarifaVO.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
                tarifaVO.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());
                tarifaVO.setVdespbletocmbio(objFrom.getLista_vdespbletocmbio());
                tarifaVO.setTotbrldesptarf(saida.getTotbrldesptarf());
                tarifaVO.setTotusddesptarf(saida.getTotusddesptarf());
                
                lista.add(tarifaVO);
                
            }
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterTarifa | OBTERTARIFA ------- ");
        }

    }

    /**
     * 
     * Nome: obterDadosBasicos
     * 
     * Propósito: Consulta dados basicos
     *
     * @param :
     * @return : 
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public TradeFinanceVO obterDadosBasicos(TradeFinanceListaVO listaVO, Integer funcao) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterDadosBasicos | DADOSBASICOS ------- ");
            
            Dadosbasicosrequest request = new Dadosbasicosrequest();
            Dadosbasicosresponse response = new Dadosbasicosresponse();
            
            Npccwx1erequest entrada = new Npccwx1erequest();
            Npccwx1sresponse saida = new Npccwx1sresponse();
            
            request.setNpccwx1erequest(entrada);
            response.setNpccwx1sresponse(saida);
            
            entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setFuncao(funcao);
            entrada.setCprodtservc(listaVO.getCprodtservc());
            entrada.setCsitbletocmbio(listaVO.getCsitbletocmbio());
            entrada.setCsitbletoaprov(listaVO.getCsitbletoaprov());
            entrada.setCmodcontrcmbio(listaVO.getCmodcontrcmbio());
            
            if (listaVO.getHinclreghist() == null) {
                
                entrada.setHinclreghist(" ");
                
            } else {
                entrada.setHinclreghist(listaVO.getHinclreghist());
            }
            
            // Fluxo - NPCCIAPG / NPCCWX1E - NPCCWX1S
            listaSemPaginacao(request, response, "DADOSBASICOS");
            
            TradeFinanceVO dadosBasicosVO = new TradeFinanceVO();
            
            dadosBasicosVO.setPcelasfndng(new ArrayList<FundingVO>());
            dadosBasicosVO.setRestricoes(new ArrayList<String>());
            dadosBasicosVO.setCsitbletoaprov(saida.getCsitbletoaprov());
            dadosBasicosVO.setNomecompletocli(saida.getNomecompletocli());
            dadosBasicosVO.setCctabcriaclicmbio(saida.getCctabcriacmbio());
            dadosBasicosVO.setTdiaopercmbioprcf(saida.getTdiacmbioprcf());
            dadosBasicosVO.setNbletonegoccmbio(saida.getNbletonegoccmbio());
            dadosBasicosVO.setDanobase(saida.getDanobase());
            dadosBasicosVO.setCunicclicmbio(saida.getCunicclicmbio());
            dadosBasicosVO.setCunicpssoacmbio(saida.getCunicpssoacmbio());
            dadosBasicosVO.setNcunicclicmbio(saida.getNcunicclicmbio());
            dadosBasicosVO.setCpfcnpj(saida.getCpfcnpj());
            dadosBasicosVO.setCflial(saida.getCflial());
            dadosBasicosVO.setCctrl(saida.getCctrl());
            dadosBasicosVO.setNctabcriacmbio(saida.getNctabcriacmbio());
            dadosBasicosVO.setDigtcctabcria(saida.getDigtcctabcria());
            dadosBasicosVO.setCbco(saida.getCbco());
            dadosBasicosVO.setNomesocial(saida.getNomesocial());
            dadosBasicosVO.setCagbcria(saida.getCagbcria());
            dadosBasicosVO.setCidade(saida.getCidade());
            dadosBasicosVO.setEstado(saida.getEstado());
            dadosBasicosVO.setCpssoajurid(saida.getCpssoajurid());
            dadosBasicosVO.setNsequndorgnz(saida.getNsequndorgnz());
            dadosBasicosVO.setNomeundorgnz(saida.getNomeundorgnz());
            dadosBasicosVO.setCrting(saida.getCrting());
            dadosBasicosVO.setCtposgmtocli(saida.getCtposgmtocli());
            dadosBasicosVO.setDtposgmtocli(saida.getDtposgmtocli());
            dadosBasicosVO.setCprodtservc(saida.getCprodtservc());
            dadosBasicosVO.setDprodtservc(saida.getDprodtservc());
            dadosBasicosVO.setCmodldprodtcmbio(saida.getCmodldprodtcmbio());
            dadosBasicosVO.setDmodldprodtcmbio(saida.getDmodldprodtcmbio());
            dadosBasicosVO.setCtponegoccmbio(saida.getCtponegoccmbio());
            dadosBasicosVO.setGrupomercadoriaboleto(saida.getInfocomplbndes());
            
            if(!SiteUtil.isEmptyOrNull(EnumTipoCotacao.fromCode(dadosBasicosVO.getCtponegoccmbio()).getDescricao()))
                dadosBasicosVO.setDescrctc(EnumTipoCotacao.fromCode(dadosBasicosVO.getCtponegoccmbio()).getDescricao().substring(8).trim());  
            
            dadosBasicosVO.setCsitbletocmbio(saida.getCsitbletocmbio());
            dadosBasicosVO.setDsitbletocmbio(saida.getDsitbletocmbio());
            dadosBasicosVO.setDvalddnegoccmbio(SiteUtil.trocarPontoPorBarra(saida.getDvalddnegoccmbio()));
            dadosBasicosVO.setCusuarinclt(saida.getCusuarinclt());
            dadosBasicosVO.setNusuarinclt(saida.getNusuarinclt());
            dadosBasicosVO.setNseqcontrlim(saida.getNseqcontrlim());
            dadosBasicosVO.setCindcdeconmmoeda(saida.getCindcdeconmmoeda());
            dadosBasicosVO.setSimbleconmmoeda(saida.getSimbleconmmoeda());
            dadosBasicosVO.setDescreconmmoeda(saida.getDescreconmmoeda());
            dadosBasicosVO.setVnegocmoedaestrg(SiteUtil.formatarValorWeb(saida.getVnegocmoedaestrg()));
            dadosBasicosVO.setTdiaopercmbio(saida.getTdiaopercmbio());
            dadosBasicosVO.setCeconmmoedadsemb(saida.getCeconmmoedadsemb());
            dadosBasicosVO.setSimbleconmdsemb(saida.getSimbleconmdsemb());
            dadosBasicosVO.setDescreconmdsemb(saida.getDescreconmdsemb());
            dadosBasicosVO.setDprevtdsembcmbio(SiteUtil.trocarPontoPorBarra(saida.getDprevtdsembcmbio()));
            dadosBasicosVO.setCeconmmoedalim(saida.getCeconmmoedalim());
            dadosBasicosVO.setSimbleconmlim(saida.getSimbleconmlim());
            dadosBasicosVO.setDescreconmlim(saida.getDescreconmlim());
            dadosBasicosVO.setVmoedalimgerc(SiteUtil.formatarValorWeb(saida.getVmoedalimgerc()));
            dadosBasicosVO.setCindcdnegocswap(SiteUtil.indicadorSimNao(saida.getCindcdnegocswap()));
            dadosBasicosVO.setCindcdnegoclibor(saida.getCindcdnegoclibor());
            dadosBasicosVO.setCnegocswapfluxo(saida.getCnegocswapfluxo());
            dadosBasicosVO.setCnegocswapestrg(saida.getCnegocswapestrg());
            dadosBasicosVO.setCtpocotactx(saida.getCtpocotactx());
            dadosBasicosVO.setDescrptax(EnumPtax.fromCode(dadosBasicosVO.getCtpocotactx()).getDescricao());
            dadosBasicosVO.setPtxswapcmpdo(SiteUtil.formatarValorWeb(saida.getPtxswapcmpdo()));
            dadosBasicosVO.setCindcdnegoccarta(SiteUtil.indicadorSimNao(saida.getCindcdnegoccarta()));
            dadosBasicosVO.setTdiavalddletra(saida.getTdiavalddletra());
            dadosBasicosVO.setCcomiscartanacio(SiteUtil.indicadorSimNao(saida.getCcomiscartanacio()));          
            dadosBasicosVO.setCindcdnegocarbtr(SiteUtil.indicadorSimNao(saida.getCindcdnegocarbtr()));
            dadosBasicosVO.setCbanqrcmbiofndng(saida.getCbanqrcmbiofndng());
            dadosBasicosVO.setCbanqrcmbiorcdor(saida.getCbanqrcmbiorcdor());
            dadosBasicosVO.setDbcoextcmbio(saida.getDbcoextcmbio());
            dadosBasicosVO.setDcotacfndngcmbio(SiteUtil.trocarPontoPorBarra(saida.getDcotacfndngcmbio()));
            dadosBasicosVO.setPtxfixacmbio(SiteUtil.formatarValorWeb(saida.getPtxfixacmbio()));
            dadosBasicosVO.setCindcdeconmlibor(saida.getCindcdeconmlibor());
            dadosBasicosVO.setSimbleconmlibor(saida.getSimbleconmlibor());
            dadosBasicosVO.setTmesliborcmbio(saida.getTmesliborcmbio());
            dadosBasicosVO.setVtxliborcmbio(SiteUtil.formatarValorWeb(saida.getVtxliborcmbio()));
            dadosBasicosVO.setVtravaliborcmbio(SiteUtil.formatarValorWeb(saida.getVtravaliborcmbio()));
            dadosBasicosVO.setVimpstnegoccmbio(SiteUtil.formatarValorWeb(saida.getVimpstnegoccmbio()));
            dadosBasicosVO.setViofnegoccmbio(SiteUtil.formatarValorWeb(saida.getViofnegoccmbio()));
            dadosBasicosVO.setVtxmoracmbio(SiteUtil.formatarValorWeb(saida.getVtxmoracmbio()));
            dadosBasicosVO.setCbasejuromora(saida.getCbasejuromora());
            dadosBasicosVO.setVmultanegoccmbio(SiteUtil.formatarValorWeb(saida.getVmultanegoccmbio()));
            dadosBasicosVO.setCsegurtrnspmcado(SiteUtil.indicadorSimNao(saida.getCsegurtrnspmcado()));
            dadosBasicosVO.setCsegurmcadoorgnz(SiteUtil.indicadorSimNao(saida.getCsegurmcadoorgnz()));
            dadosBasicosVO.setCmodcontrcmbio(saida.getCmodcontrcmbio());
            dadosBasicosVO.setDmodcontrcmbio(saida.getDmodcontrcmbio());
            dadosBasicosVO.setQprzmedcmbio(saida.getQprzmedcmbio());
            dadosBasicosVO.setQprzmedcmbioano(SiteUtil.formatarValorWeb(saida.getQprzmedcmbioano()));
            dadosBasicosVO.setDescctotal(SiteUtil.trocarUnderlinePorMais(saida.getDescctotal()));
            dadosBasicosVO.setCrtinglvgemdnhe(saida.getRrtinglvgemdnhe());
            dadosBasicosVO.setPercreentrg(SiteUtil.formatarValorWeb(saida.getPercreentrg()));
            dadosBasicosVO.setPercdientrg(SiteUtil.formatarValorWeb(saida.getPercdientrg()));
            dadosBasicosVO.setCindcdcontrfalt(saida.getCindcdcontrfalt());
            dadosBasicosVO.setDabertctacli(saida.getDabertctacli());
            dadosBasicosVO.setDfundcnasc(SiteUtil.trocarPontoPorBarra(saida.getDfundcnasc()));
            dadosBasicosVO.setQdiavencdcontr(saida.getQdiavencdcontr());
            dadosBasicosVO.setQcontrdoctopend(saida.getQcontrdoctopend());
            dadosBasicosVO.setDfchtobletocmbio(SiteUtil.trocarPontoPorVirgula(saida.getDfchtobletocmbio()));
            dadosBasicosVO.setDprodtservc(saida.getDprodtservc());
            dadosBasicosVO.setCmodldprodtdesc(saida.getCmodldprodtdesc());
            dadosBasicosVO.setPareceroperador(saida.getPareceroperador());
            dadosBasicosVO.setParecerdsn(saida.getParecerdsn());
            dadosBasicosVO.setNbletocmbioano(saida.getNbletocmbioano());
            dadosBasicosVO.setDinclreg(SiteUtil.trocarPontoPorBarra(saida.getDinclreg()));
            dadosBasicosVO.setFuncionario(saida.getCusuarinclt() + " - " + saida.getNusuarinclt());
            dadosBasicosVO.setPzroprdiaano(saida.getQprzmedcmbio() + "/"
                    + SiteUtil.trocarPontoPorVirgula(Double.toString(saida.getQprzmedcmbioano())));
            dadosBasicosVO.setCmovtcincel(saida.getCmovtcincel());
            dadosBasicosVO.setRinfoenvolmdia(saida.getRinfoenvolmdia());
            dadosBasicosVO.setTxtinformativo(saida.getTxtinformativo());
            dadosBasicosVO.setRclasfexportentrg(saida.getRclasfexportentrg());
            dadosBasicosVO.setRclasfimportentrg(saida.getRclasfimportentrg());
            
            dadosBasicosVO.setNcunicpssoacmbiot(saida.getNcunicpsoacmbiot());
            dadosBasicosVO.setCunicpssoacmbiot(saida.getCunicpssoacmbiot());
            
            dadosBasicosVO.setCunicpssoaindica(saida.getCunicpssoaindica());
            
            if(SiteUtil.getDouble(saida.getPercreentrg()) > SiteUtil.getDouble("0.00") 
                    || (SiteUtil.getDouble(saida.getPercreentrg()) == SiteUtil.getDouble("0.00") && !SiteUtil.isEmptyOrNull(saida.getRclasfexportentrg())) ){
            	dadosBasicosVO.setReentregue(SiteUtil.trocarPontoPorVirgula(Double.toString(saida.getPercreentrg())) + "%" + " - " + saida.getRclasfexportentrg());
            }
            
            if(SiteUtil.getDouble(saida.getPercdientrg()) > SiteUtil.getDouble("0.00")
                    || (SiteUtil.getDouble(saida.getPercdientrg()) == SiteUtil.getDouble("0.00") && !SiteUtil.isEmptyOrNull(saida.getRclasfimportentrg()) )){
            	dadosBasicosVO.setDientregue(SiteUtil.trocarPontoPorVirgula(Double.toString(saida.getPercdientrg())) + "%" + " - " + saida.getRclasfimportentrg());
            }
            
            dadosBasicosVO.setCpfCnpjFormatado(CadastroNacionalPessoa.format(dadosBasicosVO.getCpfcnpj(),
                    dadosBasicosVO.getCflial(), dadosBasicosVO.getCctrl()));
            dadosBasicosVO.setNcotacao(dadosBasicosVO.getDanobase() + dadosBasicosVO.getNbletocmbioano().toString());
            dadosBasicosVO.setCaditvbletocmbio(saida.getCaditvbletocmbio());
            dadosBasicosVO.setVtxspreadnegoc(SiteUtil.formatarValorWeb(saida.getVtxspreadnegoc()));
            dadosBasicosVO.setVtxspreadaprov(SiteUtil.formatarValorWeb(saida.getVtxspreadaprov()));
            dadosBasicosVO.setVtxspreadtot(SiteUtil.formatarValorWeb(saida.getVtxspreadtot()));

            
            // DADOS DO NCE | CONFIRMAR OBJ
            dadosBasicosVO.setPcdimaiscmbio(SiteUtil.formatarValorWeb(saida.getPcdimaiscmbio()));
            dadosBasicosVO.setPtxcdifinan(SiteUtil.formatarValorWeb(saida.getPtxcdifinan()));
            dadosBasicosVO.setPfixajurocmbio(SiteUtil.formatarValorWeb(saida.getPfixajurocmbio()));
            
            if(SiteUtil.isValueZero(Double.toString(saida.getPcdimaiscmbio())) == false) {
                dadosBasicosVO.setValorTxJuros(dadosBasicosVO.getPcdimaiscmbio());
            } 
            else if(SiteUtil.isValueZero(Double.toString(saida.getPtxcdifinan())) == false) {
                dadosBasicosVO.setValorTxJuros(dadosBasicosVO.getPtxcdifinan());
            }
            else {
                dadosBasicosVO.setValorTxJuros(dadosBasicosVO.getPfixajurocmbio());
            }
            
            dadosBasicosVO.setIorgextercmbio(saida.getIorgextercmbio());
            dadosBasicosVO.setCindcdlastrcarta(saida.getCindcdlastrcarta());
            dadosBasicosVO.setCcartaconverecdd(saida.getCcartaconverecdd());
            dadosBasicosVO.setDvctodsembcmbio(saida.getDvctodsembcmbio());
            dadosBasicosVO.setValorjuros(SiteUtil.trocarPontoPorVirgula(saida.getValorjuros()));
            dadosBasicosVO.setValorsaque(SiteUtil.trocarPontoPorVirgula(saida.getValorsaque()));
            dadosBasicosVO.setTaxajuros(saida.getTaxajuros());
            dadosBasicosVO.setTaxadescontada(saida.getTaxadescontada());
            dadosBasicosVO.setCtpojurotrade(saida.getCtpojurotrade());
            dadosBasicosVO.setCcobrcomisadcio(saida.getCcobrcomisadcio());
            dadosBasicosVO.setPcobervarprodt(SiteUtil.trocarPontoPorVirgula(saida.getPcobervarprodt()));
            dadosBasicosVO.setCindcdecon(saida.getCindcdecon());
            dadosBasicosVO.setQpcelatradeprinc(saida.getQpcelatradeprinc());
            dadosBasicosVO.setDprevtinicembrq(SiteUtil.trocarPontoPorBarra(saida.getDprevtinicembrq()));
            dadosBasicosVO.setDprevtfimembrq(SiteUtil.trocarPontoPorBarra(saida.getDprevtfimembrq()));
            dadosBasicosVO.setCidtfdbndesgrp(saida.getCidtfdbndesgrp());
            dadosBasicosVO.setDescrGrupo(EnumGrupoBNDES.fromCode(saida.getCidtfdbndesgrp()).getDescricao());
            dadosBasicosVO.setCidtfdbndesporte(saida.getCidtfdbndesporte());
            dadosBasicosVO.setDescrPorte(EnumPorte.fromCode(dadosBasicosVO.getCidtfdbndesporte()).getDescricao());
            dadosBasicosVO.setCeconmmoedaequal(saida.getCeconmmoedaequal());
            dadosBasicosVO.setPtxequalcmbio(SiteUtil.formatarValorWeb(saida.getPtxequalcmbio()));
            dadosBasicosVO.setVprevtcmbioequal(SiteUtil.formatarValorWeb(saida.getVprevtcmbioequal()));
            dadosBasicosVO.setCmoedaeconmrecta(saida.getCmoedaeconmrecta());
            dadosBasicosVO.setDinicvalddcmbio(SiteUtil.trocarPontoPorBarra(saida.getDinicvalddcmbio()));
            dadosBasicosVO.setDfimnegoccmbio(SiteUtil.trocarPontoPorBarra(saida.getDfimnegoccmbio()));
            dadosBasicosVO.setQregexporcmbio(saida.getQregexporcmbio());
            dadosBasicosVO.setQprevtembrqcmbio(saida.getQprevtembrqcmbio());
            dadosBasicosVO.setVprevtrectacmbio(SiteUtil.formatarValorWeb(saida.getVprevtrectacmbio()));
            dadosBasicosVO.setCfluxoperdccmbio(saida.getCfluxoperdccmbio());
            dadosBasicosVO.setSimblmoedaequal(saida.getSimblmoedaequal());
            dadosBasicosVO.setSimblrectacmbio(saida.getSimblrectacmbio());
            dadosBasicosVO.setDbcocred(saida.getDbcocred());
            dadosBasicosVO.setDfchtobletodesc(SiteUtil.trocarPontoPorBarra(saida.getDfchtobletodesc()));
            dadosBasicosVO.setVlrmoedaestrang(SiteUtil.formatarValorWeb(saida.getVlrmoedaestrang()));
            dadosBasicosVO.setCprodtdesc(saida.getCprodtdesc());
            dadosBasicosVO.setCeconmmoedadesc(saida.getCeconmmoedadesc());
            dadosBasicosVO.setVtxrentbcmbio(SiteUtil.trocarPontoPorVirgula(saida.getVtxrentbcmbio()));
            
            dadosBasicosVO.setUltimoFechamento(dadosBasicosVO.getDfchtobletodesc() + " " + "-" +  dadosBasicosVO.getCprodtdesc() + " " + "/ Remessa:" + " " + saida.getCeconmmoedadesc() 
                            + "  "+ dadosBasicosVO.getVlrmoedaestrang() + " " + "- Rentabilidade:" + " " +  dadosBasicosVO.getVtxrentbcmbio() + "%");
            dadosBasicosVO.setIfluxoperdccmbio(saida.getIfluxoperdccmbio());
            dadosBasicosVO.setTdiacarenprinc(saida.getTdiacarenprinc());
            dadosBasicosVO.setNppstapontucmbio(saida.getNppstapontucmbio());
            dadosBasicosVO.setDbcorecebedor(saida.getDbcorecebedor());
            dadosBasicosVO.setDlimfndngcmbio(SiteUtil.trocarPontoPorBarra(saida.getDlimfndngcmbio()));
            dadosBasicosVO.setCidtfdcartacsndo(saida.getCidtfdcartacsndo());   
            dadosBasicosVO.setCindcdlastragric(saida.getCindcdlastragric());
            dadosBasicosVO.setPagtefincrcmbio(SiteUtil.formatarValorWeb(saida.getPagtefincrcmbio()));
            dadosBasicosVO.setPjuronegoccmbio(SiteUtil.formatarValorWeb(saida.getPjuronegoccmbio()));
            dadosBasicosVO.setPtotjurocmbio(SiteUtil.formatarValorWeb(saida.getPtotjurocmbio()));
            dadosBasicosVO.setVtxremunbndes(SiteUtil.formatarValorWeb(saida.getVtxremunbndes()));
            dadosBasicosVO.setPcomismtoricmbio(SiteUtil.formatarValorWeb(saida.getPcomismtoricmbio()));
            dadosBasicosVO.setCcobrcomisagte(saida.getCcobrcomisagte());
            dadosBasicosVO.setCcobrcomismtori(saida.getCcobrcomismtori());
            dadosBasicosVO.setVagtefincrcmbio(SiteUtil.formatarValorWeb(saida.getVagtefincrcmbio()));
            dadosBasicosVO.setVbcomtoricmbio(SiteUtil.formatarValorWeb(saida.getVbcomtoricmbio()));
            dadosBasicosVO.setDvctocntragarnt(SiteUtil.dataMainframeToWeb(saida.getDvctocntragarnt()));
            dadosBasicosVO.setDabertcntragarnt(SiteUtil.dataMainframeToWeb(saida.getDabertcntragarnt()));
            dadosBasicosVO.setDalertvctocntra(SiteUtil.dataMainframeToWeb(saida.getDalertvctocntra()));
            dadosBasicosVO.setCindcdcntragarnt(saida.getCindcdcntragarnt());
            dadosBasicosVO.setTdiacntragarnt(saida.getTdiacntragarnt());
            dadosBasicosVO.setCindcdrenovcntra(saida.getCindcdrenovcntra());
            dadosBasicosVO.setQdiaalertcntra(saida.getQdiaalertcntra());
            dadosBasicosVO.setCindcdcustoexter(saida.getCindcdcustoexter());
            dadosBasicosVO.setEndereco(saida.getEndereco());
            dadosBasicosVO.setPais(saida.getPais());
            dadosBasicosVO.setCnegoccmbioindmd(saida.getCnegoccmbioindmd());
            dadosBasicosVO.setDprevtgarntexpdi(SiteUtil.trocarPontoPorBarra(saida.getDprevtgarntexpdi()));
            dadosBasicosVO.setCindcdembrqpcial(saida.getCindcdembrqpcial());
            dadosBasicosVO.setDlimembrqcmbio(SiteUtil.trocarPontoPorBarra(saida.getDlimembrqcmbio()));
            dadosBasicosVO.setCprznegoccmbio(saida.getCprznegoccmbio());
            dadosBasicosVO.setVlimcobervar(SiteUtil.formatarValorWeb(saida.getVlimcobervar()));
            dadosBasicosVO.setCpermtrnsfcarta(saida.getCpermtrnsfcarta());
            dadosBasicosVO.setCindcdcartaidpdt(saida.getCindcdcartaidpdt());
            dadosBasicosVO.setCindcdcartacnfdo(saida.getCindcdcartacnfdo());
            dadosBasicosVO.setValddcarta(saida.getValddcarta());
            dadosBasicosVO.setInddqmto(saida.getInddqmto());
            
            dadosBasicosVO.setDinicvalddppsta(SiteUtil.trocarPontoPorBarra(saida.getDinicvalddppsta()));
            dadosBasicosVO.setDfimvalddppsta(SiteUtil.trocarPontoPorBarra(saida.getDfimvalddppsta()));
            dadosBasicosVO.setDlimenviorsumo(SiteUtil.trocarPontoPorBarra(saida.getDlimenviorsumo()));
            dadosBasicosVO.setPraca(saida.getPraca());
            dadosBasicosVO.setCidtfdrespdesp(saida.getCidtfdrespdesp());
            dadosBasicosVO.setCsitbletoaprov(saida.getCsitbletoaprov());
            
            dadosBasicosVO.setDescjurosbleto(saida.getDescjurosbleto());
            dadosBasicosVO.setCtpoprzcmbio(saida.getCtpoprzcmbio());
            
            // Lista de parcelas de Funding
            for (int i = 0; i < saida.getQtdepcelas(); i++) {
                
                Npccwx1sresponse_pcelasfndng objFrom = saida.getPcelasfndng().get(i);
                FundingVO fundingVO = new FundingVO();
                fundingVO.setcexterreftfndng(objFrom.getPcelasfndng_cexterreftfndng());
                fundingVO.setcindcdeconmmoeda(objFrom.getPcelasfndng_cindcdmoedafndg());
                fundingVO.setvpcelafndngcmbio(SiteUtil.formatarValorWeb(objFrom.getPcelasfndng_vpcelafndngcmbio()));
                fundingVO.setdescreconmmoeda(objFrom.getPcelasfndng_deseconmmoedafndg());
                
                dadosBasicosVO.getPcelasfndng().add(fundingVO);
            }
            
            // Lista de restricões
            for (int i = 0; i < saida.getQtderest(); i++) {
                
                Npccwx1sresponse_restricoes objFrom = saida.getRestricoes().get(i);
                String descricao = objFrom.getRestricoes_crestcli() + " - " + objFrom.getRestricoes_rrestcli();
                
                dadosBasicosVO.getRestricoes().add(descricao);
            }
            
            return dadosBasicosVO;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterDadosBasicos | DADOSBASICOS ------- ");
        }

    }

    /**
     * 
     * Nome: comissaoInternaDet
     * 
     * Propósito: Obter detalhes da comissão interna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComissaoInternaVO> comissaoInternaDet(Long nBleto, Integer nComissao, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.comissaoInternaDet | COMISSAOINTERNADET ------- ");
            
            List<ComissaoInternaVO> lista = new ArrayList<ComissaoInternaVO>();
            
            Comissaointernadetrequest request = new Comissaointernadetrequest();
            Comissaointernadetresponse response = new Comissaointernadetresponse();
            
            Npccwxferequest entrada = new Npccwxferequest();
            Npccwxfsresponse saida = new Npccwxfsresponse();
            
            request.setNpccwxferequest(entrada);
            response.setNpccwxfsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            entrada.setNcomisintrntrade(nComissao);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo - NPCCIAO8 / NPCCWXFE - NPCCWXFS
            listaSemPaginacao(request, response, "COMISSAOINTERNADET");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxfsresponse_lista objFrom = saida.getLista().get(i);
                ComissaoInternaVO comissaoInternaVO = new ComissaoInternaVO();
                comissaoInternaVO.setNpcelacomisintrn(objFrom.getLista_npcelacomisintrn());
                comissaoInternaVO.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
                comissaoInternaVO.setVpcelacomiscmbio(objFrom.getLista_vpcelacomiscmbio());
                comissaoInternaVO.setPrazoparcela(objFrom.getLista_prazoparcela());
                lista.add(comissaoInternaVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.comissaoInternaDet | COMISSAOINTERNADET ------- ");
        }

    }

    /**
     * 
     * Nome: comissaoExternaDet
     * 
     * Propósito: Obter detalhes da comissão externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComissaoExternaVO> comissaoExternaDet(Long nBleto, Integer nComissao, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.comissaoExternaDet | COMISSAOEXTERNADET ------- ");
            
            List<ComissaoExternaVO> lista = new ArrayList<ComissaoExternaVO>();
            
            Comissaoexternadetrequest request = new Comissaoexternadetrequest();
            Comissaoexternadetresponse response = new Comissaoexternadetresponse();
            
            Npccwxkerequest entrada = new Npccwxkerequest();
            Npccwxksresponse saida = new Npccwxksresponse();
            
            request.setNpccwxkerequest(entrada);
            response.setNpccwxksresponse(saida);
            
            entrada.setNcomisextertrade(nComissao);
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo - NPCCIAO2 / NPCCWXKE - NPCCWXKS
            listaSemPaginacao(request, response, "COMISSAOEXTERNADET");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxksresponse_lista objFrom = saida.getLista().get(i);
                ComissaoExternaVO comissaoExternaVO = new ComissaoExternaVO();
                
                comissaoExternaVO.setnpcelacomisexter(objFrom.getLista_npcelacomisexter());
                comissaoExternaVO.setdvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
                comissaoExternaVO.setvpcelacomiscmbio(objFrom.getLista_vpcelacomiscmbio());
                comissaoExternaVO.setprazoparcela(objFrom.getLista_prazoparcela());
                
                lista.add(comissaoExternaVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.comissaoExternaDet | COMISSAOEXTERNADET ------- ");
        }
    }

    /**
     * 
     * Nome: obterFluxoPgtList
     * 
     * Propósito: Obter lista de fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<FluxoPagamentoVO> obterFluxoPgtList(Long nBleto, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterFluxoPgtList | FLUXOPAGAMENTOLIST ------- ");
            
            List<FluxoPagamentoVO> lista = new ArrayList<FluxoPagamentoVO>();
            
            FluxoPagamentoVO fluxoPagamentoVO = null;
            
            Fluxopagamentolistrequest request = new Fluxopagamentolistrequest();
            Fluxopagamentolistresponse response = new Fluxopagamentolistresponse();
            
            Npccwxcerequest entrada = new Npccwxcerequest();
            Npccwxcsresponse saida = new Npccwxcsresponse();
            
            request.setNpccwxcerequest(entrada);
            response.setNpccwxcsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo - NPCCIAO4 - Books: NPCCWXCE / NPCCWXCS
            listaSemPaginacao(request, response, "FLUXOPAGAMENTOLIST");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxcsresponse_listamesa objFrom = saida.getListamesa().get(i);
                
                fluxoPagamentoVO = new FluxoPagamentoVO();
                
                fluxoPagamentoVO.setNdsembcmbiotrade(objFrom.getListamesa_ndsembcmbiotrade());
                fluxoPagamentoVO.setDprevtdsembcmbio(SiteUtil.trocarPontoPorBarra(objFrom.getListamesa_dprevtdsembcmbio()));
                fluxoPagamentoVO.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getListamesa_dprevtdsembcmbio()));
                fluxoPagamentoVO.setTdiafinandsemb(objFrom.getListamesa_tdiafinandsemb());
                fluxoPagamentoVO.setVprevtdsembcmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getListamesa_vprevtdsembcmbio()));
                fluxoPagamentoVO.setTdiacarenprinc(objFrom.getListamesa_tdiacarenprinc());
                fluxoPagamentoVO.setCfluxoliqdcprinc(objFrom.getListamesa_cfluxoliqdcprinc());
                fluxoPagamentoVO.setQpcelatradeprinc(objFrom.getListamesa_qpcelatradeprinc());
                fluxoPagamentoVO.setTdiacarenjuro(objFrom.getListamesa_tdiacarenjuro());
                fluxoPagamentoVO.setCfluxoliqdcjuro(objFrom.getListamesa_cfluxoliqdcjuro());
                fluxoPagamentoVO.setQpcelatradejuro(objFrom.getListamesa_qpcelatradejuro());
                fluxoPagamentoVO.setCmomencobrcmbio(objFrom.getListamesa_cmomencobrcmbio());
                fluxoPagamentoVO.setDfluxoliqdcprinc(objFrom.getListamesa_dfluxoliqdcprinc());
                fluxoPagamentoVO.setDfluxoliqdcjuro(objFrom.getListamesa_dfluxoliqdcjuro());
                fluxoPagamentoVO.setDescrmomen(EnumMomentoJuro.fromCode(fluxoPagamentoVO.getCmomencobrcmbio()).getDescricao());
                
                lista.add(fluxoPagamentoVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterFluxoPgtList | FLUXOPAGAMENTOLIST ------- ");
        }
    }
    
    /**
     * 
     * Nome: obterFluxoPgtDet
     * 
     * Propósito: Obter lista de detalhes do fluxo de pagamento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public FluxoPagamentoVO obterFluxoPgtDet(FluxoPagamentoVO fluxoPagamento, Long nBleto, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterFluxoPgtDet | FLUXOPAGAMENTODET ------- ");
            
            List<FluxoPagamentoVO> lista = new ArrayList<FluxoPagamentoVO>();
            List<FluxoPagamentoVO> listaPrincJuros = new ArrayList<FluxoPagamentoVO>();
            
            Fluxopagamentodetrequest request = new Fluxopagamentodetrequest();
            Fluxopagamentodetresponse response = new Fluxopagamentodetresponse();
            
            Npccwxderequest entrada = new Npccwxderequest();
            Npccwxdsresponse saida = new Npccwxdsresponse();
            
            request.setNpccwxderequest(entrada);
            response.setNpccwxdsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            entrada.setNdsembcmbiotrade(fluxoPagamento.getNdsembcmbiotrade());
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo NPCCIAO5 - Books: NPCCWXDE / NPCCWXDS
            listaSemPaginacao(request, response, "FLUXOPAGAMENTODET");
            
            // Lista
            if (fluxoPagamento.getCfluxoliqdcprinc().equals(fluxoPagamento.getCfluxoliqdcjuro())) {
            	String vPrinc = fluxoPagamento.getVprevtdsembcmbio().replace(".", "");
            	
        		// IN2754700 - Alexandre Rodrigues - INICIO
            	int qtdePrincipal = 0;
            	int qtdeJuros = 0;
            	
            	for (int i = 0; i < saida.getQtdeocorr(); i++) {
            		Npccwxdsresponse_lista objFrom = saida.getLista().get(i);
            		
            		if (objFrom.getLista_tipojuros().trim().equalsIgnoreCase("P")) {
            			qtdePrincipal++;
            		}
            		else if (objFrom.getLista_tipojuros().trim().equalsIgnoreCase("J")) {
            			qtdeJuros++;
            		}
            	}
            	
            	if (qtdePrincipal < qtdeJuros) {
            		List<FluxoPagamentoVO> listaParcelas = new ArrayList<FluxoPagamentoVO>();
            		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");            		
            		String devedorTmp = fluxoPagamento.getVprevtdsembcmbio().replace(".", "").replace(",", ".");
            		BigDecimal saldoDevedor = new BigDecimal(devedorTmp);
            		int prazoParcela = 0;
            		
            		for (int i = 0; i < saida.getQtdeocorr(); i++) {
            			Npccwxdsresponse_lista objFrom = saida.getLista().get(i);
	            		boolean parcelaExistente = false;
	            		
	            		for (FluxoPagamentoVO parcelaAlteracao : listaParcelas) {
	            			if (parcelaAlteracao.getDvctopcelatrade().equals(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()))) {
	            				parcelaExistente = true;
	            				
	            				if (objFrom.getLista_tipojuros().equals("P")) {
	            					parcelaAlteracao.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
	            				}
	            				else if (objFrom.getLista_tipojuros().equals("J")) {
	            					parcelaAlteracao.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));		
	            				}	            				
	            			}
	            		}
	            		
            			if (!parcelaExistente) {
            				FluxoPagamentoVO parcelaInclusao = new FluxoPagamentoVO();
            				parcelaInclusao.setTipojuros(objFrom.getLista_tipojuros());
            				parcelaInclusao.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            				parcelaInclusao.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            				parcelaInclusao.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
            				parcelaInclusao.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            				parcelaInclusao.setVpcelamesatrade(objFrom.getLista_vpcelamesatrade());
            				
            				parcelaInclusao.setValorPrincipalParcelaFluxoPgto("0,00");
            				parcelaInclusao.setValorJurosParcelaFluxoPgto("0,00");
            				
            				if (objFrom.getLista_tipojuros().equals("P")) {
            					parcelaInclusao.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
            				}
            				else if (objFrom.getLista_tipojuros().equals("J")) {
            					parcelaInclusao.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));		
            				}
            				
            				listaParcelas.add(parcelaInclusao);
            			}
	            	}
	
	            	Collections.sort(listaParcelas, new Comparator<FluxoPagamentoVO>() {
            			public int compare(FluxoPagamentoVO o1, FluxoPagamentoVO o2) {
        					Date dataInicial = o1.getVenctoFluxDate();
        					Date dataFinal = o2.getVenctoFluxDate();
        					
        					return dataInicial.compareTo(dataFinal);
            			}
            		});
	            	
	            	for (FluxoPagamentoVO parcela : listaParcelas) {
	            		String principalTmp = parcela.getValorPrincipalParcelaFluxoPgto().replace(".",  "").replace(",", ".");
	            		BigDecimal valorPrincipal = new BigDecimal(principalTmp);

            			saldoDevedor = saldoDevedor.subtract(valorPrincipal);
            			BigDecimal valorParcela = saldoDevedor.add(valorPrincipal);
            			
            			parcela.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			parcela.setVpcelamesatrade(SiteUtil.formatarValorWeb(valorParcela.toString()));
	            	}
	            	
            		for (int i = 1; i < listaParcelas.size(); i++) {
            			prazoParcela = calcularDiferencaEntreDatas(listaParcelas.get(i-1).getDvctopcelatrade(), listaParcelas.get(i).getDvctopcelatrade());
            			listaParcelas.get(i).setTdianegocpcela(prazoParcela);
					}
	            	
	            	listaPrincJuros = new ArrayList<FluxoPagamentoVO>(listaParcelas);
            	}
        		// IN2754700 - Alexandre Rodrigues - TERMINO
            	
            	else {
                	for (int i = 0; i < saida.getQtdeocorr(); i++) {
                		Npccwxdsresponse_lista objFrom = saida.getLista().get(i);
                		FluxoPagamentoVO fluxoPagamentoVO = new FluxoPagamentoVO();

                		if (objFrom.getLista_tipojuros().equals("P")) {
                			fluxoPagamentoVO.setTipojuros(objFrom.getLista_tipojuros());
                			fluxoPagamentoVO.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
                			fluxoPagamentoVO.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
                			fluxoPagamentoVO.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
                			fluxoPagamentoVO.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
                			fluxoPagamentoVO.setVpcelamesatrade(SiteUtil.formatarValorWeb(vPrinc));
                			fluxoPagamentoVO.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));

                			vPrinc = vPrinc.replace(",", ".");
                			String vParce = objFrom.getLista_vpcelamesatrade().replace(",", ".");
                			vParce = vParce.replace(",", ".");

                			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

                			fluxoPagamentoVO.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
                			vPrinc = saldoDevedor.toString();
                			lista.add(fluxoPagamentoVO);
                		} else if (objFrom.getLista_tipojuros().equals("J")) {
                			fluxoPagamentoVO.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
                			listaPrincJuros.add(fluxoPagamentoVO);
                		}
                	}

                	for (int i = 0; i < lista.size(); i++) {
                		listaPrincJuros.get(i).setTipojuros(lista.get(i).getTipojuros());
                		listaPrincJuros.get(i).setNpceladsembtrade(lista.get(i).getNpceladsembtrade());
                		listaPrincJuros.get(i).setTdianegocpcela(lista.get(i).getTdianegocpcela());
                		listaPrincJuros.get(i).setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(lista.get(i).getDvctopcelatrade()));
                		listaPrincJuros.get(i).setVenctoFluxDate(lista.get(i).getVenctoFluxDate());
                		listaPrincJuros.get(i).setVpcelamesatrade(lista.get(i).getVpcelamesatrade());
                		listaPrincJuros.get(i).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorPrincipalParcelaFluxoPgto()));
                		listaPrincJuros.get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(i).getValorSaldoDevedorFluxoPgto()));
                	}            		
            	}
            } else {
        		String vPrinc = fluxoPagamento.getVprevtdsembcmbio().replaceAll("\\.","").replace(",",".");
        		
            	for (int j = 0; j < saida.getQtdeocorr(); j++) {
            		Npccwxdsresponse_lista objFrom = saida.getLista().get(j);
            		FluxoPagamentoVO fluxoPagamentoVO = new FluxoPagamentoVO();
            		// Copia os valores das propriedades
            		if (objFrom.getLista_tipojuros().equals("P")) {
            			fluxoPagamentoVO.setTipojuros(objFrom.getLista_tipojuros());
            			fluxoPagamentoVO.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            			fluxoPagamentoVO.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            			fluxoPagamentoVO.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
            			fluxoPagamentoVO.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			
            			fluxoPagamentoVO.setVpcelamesatrade(SiteUtil.formatarValorWeb(vPrinc));
            			fluxoPagamentoVO.setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));

            			vPrinc = vPrinc.replace(",", ".");
            			String vParce = objFrom.getLista_vpcelamesatrade().replace(",", ".");
            			vParce = vParce.replace(",", ".");

            			BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

            			fluxoPagamentoVO.setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			vPrinc = saldoDevedor.toString();
            			lista.add(fluxoPagamentoVO);
            		} else if (objFrom.getLista_tipojuros().equals("J")) {
            			fluxoPagamentoVO.setTipojuros(objFrom.getLista_tipojuros());
            			fluxoPagamentoVO.setNpceladsembtrade(objFrom.getLista_npceladsembtrade());
            			fluxoPagamentoVO.setTdianegocpcela(objFrom.getLista_tdianegocpcela());
            			fluxoPagamentoVO.setDvctopcelatrade(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dvctopcelatrade()));
            			fluxoPagamentoVO.setVenctoFluxDate(SiteUtil.dataMainframeToWeb(objFrom.getLista_dvctopcelatrade()));
            			fluxoPagamentoVO.setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(objFrom.getLista_vpcelamesatrade()));
            			listaPrincJuros.add(fluxoPagamentoVO);
            		}
            	}
            	if (listaPrincJuros.size() % lista.size() != 0) {
            		for (int t = 0; t < lista.size(); t++) {
            			String dataTemp = lista.get(t).getDvctopcelatrade();
            			for (int j = 0; j < listaPrincJuros.size(); j++) {
            				String dataAux = listaPrincJuros.get(j).getDvctopcelatrade();
            				try {
								if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
									listaPrincJuros.get(j).setTipojuros(lista.get(t).getTipojuros());
									listaPrincJuros.get(j).setNpceladsembtrade(lista.get(t).getNpceladsembtrade());
									listaPrincJuros.get(j).setVpcelamesatrade(lista.get(t).getVpcelamesatrade());
									//listaPrincJuros.get(j).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorJurosParcelaFluxoPgto()));

									listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorPrincipalParcelaFluxoPgto()));
									listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(t).getValorSaldoDevedorFluxoPgto()));
									break;
								} else if (j == listaPrincJuros.size() -1) {
									listaPrincJuros.add(lista.get(t));
								}
							} catch (ParseException e) {
								e.printStackTrace();
							}
            			}
            		}

            		final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

            		Comparator<FluxoPagamentoVO> cmp = new Comparator<FluxoPagamentoVO>() {
            			public int compare(FluxoPagamentoVO o1, FluxoPagamentoVO o2) {
            				Date dataInicial = null;
            				Date dataFinal = null;
            				try {
            					dataInicial = sdf1.parse(o1.getDvctopcelatrade());
            					dataFinal = sdf1.parse(o2.getDvctopcelatrade());
            				} catch (ParseException e) {
            					e.printStackTrace();
            				}
            				return dataInicial.compareTo(dataFinal); 
            			}
            		};
            		Collections.sort(listaPrincJuros, cmp);
            		int prazoTemp = 0;
            		for (int i = 1; i < listaPrincJuros.size(); i++) {
            			prazoTemp = calcularDiferencaEntreDatas(listaPrincJuros.get(i-1).getDvctopcelatrade(), listaPrincJuros.get(i).getDvctopcelatrade());
            			listaPrincJuros.get(i).setTdianegocpcela(prazoTemp);
					}
            	} else {
            		for (int z = 0; z < lista.size(); z++) {
            			String dataTemp = lista.get(z).getDvctopcelatrade();
            			for (int j = 0; j < listaPrincJuros.size(); j++) {
            				String dataAux = listaPrincJuros.get(j).getDvctopcelatrade();
            				try {
								if (SiteUtil.stringToDate(dataTemp, "dd/MM/yyyy").equals(SiteUtil.stringToDate(dataAux, "dd/MM/yyyy"))) {
									listaPrincJuros.get(j).setTipojuros(lista.get(z).getTipojuros());
									listaPrincJuros.get(j).setNpceladsembtrade(lista.get(z).getNpceladsembtrade());
									listaPrincJuros.get(j).setVpcelamesatrade(lista.get(z).getVpcelamesatrade());
									//listaPrincJuros.get(j).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorParcelaFluxoPgto()));

									listaPrincJuros.get(j).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorPrincipalParcelaFluxoPgto()));
									listaPrincJuros.get(j).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(lista.get(z).getValorSaldoDevedorFluxoPgto()));
									break;
								} else if (j == listaPrincJuros.size() -1) {
									listaPrincJuros.add(lista.get(z));
								}
							} catch (ParseException e) {
								e.printStackTrace();
							}
            			}
            		}
				}
            	String vPrincAux = fluxoPagamento.getVprevtdsembcmbio().replaceAll("\\.","").replace(",",".");
            	for (int t = 0; t < listaPrincJuros.size(); t++) {
            		if (listaPrincJuros.get(t).getTipojuros().equals("J")) {
            			listaPrincJuros.get(t).setVpcelamesatrade(SiteUtil.formatarValorWeb(vPrincAux));

            			vPrincAux = vPrincAux.replace(",",".");
            			String vParce = "0.00";
            			if (listaPrincJuros.get(t).getValorPrincipalParcelaFluxoPgto() != null) {
            				vParce = listaPrincJuros.get(t).getValorPrincipalParcelaFluxoPgto().replace(",",".");
            			}
            			vParce = vParce.replace(",",".");
            			BigDecimal saldoDevedor = new BigDecimal(vPrincAux).subtract(new BigDecimal(vParce));

            			listaPrincJuros.get(t).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
            			vPrincAux = saldoDevedor.toString();
            		} else {
            			vPrincAux = listaPrincJuros.get(t).getValorSaldoDevedorFluxoPgto().replace(".", "");
            		}
            	}
            }
        	fluxoPagamento.setLista(listaPrincJuros);
        	fluxoPagamento.setPrzomediodsemb(saida.getPrzomediodsemb());
        	fluxoPagamento.setNdsembcmbiotrade(saida.getNdsembcmbiotrade());
            
            return fluxoPagamento;
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterFluxoPgtDet | FLUXOPAGAMENTODET ------- ");
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
		
   		System.out.println(diferencaDias);
   		
   		return diferencaDias;
	}
    
    /**
     * 
     * Nome: obterComissaoExterna
     * 
     * Propósito: Obter detalhes da comissão externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public ComissaoCollection obterComissaoExterna(Long nBleto, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterComissaoExterna | OBTERCOMISSAOEXTERNA ------- ");
            
            ComissaoCollection lista = new ComissaoCollection();
            
            Obtercomissaoexternarequest request = new Obtercomissaoexternarequest();
            Obtercomissaoexternaresponse response = new Obtercomissaoexternaresponse();
            
            Npccwxjerequest entrada = new Npccwxjerequest();
            Npccwxjsresponse saida = new Npccwxjsresponse();
            
            request.setNpccwxjerequest(entrada);
            response.setNpccwxjsresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo NPCCIAO1 - Books: NPCCWXJE / NPCCWXJS
            listaSemPaginacao(request, response, "OBTERCOMISSAOEXTERNA");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxjsresponse_lista objFrom = saida.getLista().get(i);
                ComissaoExternaVO comissaoExternaVO = new ComissaoExternaVO();
                
                comissaoExternaVO.setncomisextertrade(objFrom.getLista_ncomisextertrade());
                comissaoExternaVO.setccondceconc(objFrom.getLista_ccondceconc());
                comissaoExternaVO.seticondeconc(objFrom.getLista_icondeconc());
                comissaoExternaVO.setvpcelacomiscmbio(objFrom.getLista_vpcelacomiscmbio());
                comissaoExternaVO.setpcomisnegoccmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_pcomisnegoccmbio()));
                comissaoExternaVO.setcperdcjurocmbio(objFrom.getLista_cperdcjurocmbio());
                comissaoExternaVO.setiperdcjurocmbio(objFrom.getLista_iperdcjurocmbio());
                comissaoExternaVO.setcindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
                comissaoExternaVO.setisglindcdfonte(objFrom.getLista_isglindcdfonte());
                comissaoExternaVO.setcfluxoperdccmbio(objFrom.getLista_cfluxoperdccmbio());
                comissaoExternaVO.setifluxoperdccmbio(objFrom.getLista_ifluxoperdccmbio());
                comissaoExternaVO.setcmomencobrcmbio(objFrom.getLista_cmomencobrcmbio());
                comissaoExternaVO.setqpcelacmbiotrade(objFrom.getLista_qpcelacmbiotrade());
                comissaoExternaVO.setdescrmomento(EnumMomentoJuro.fromCode(comissaoExternaVO.getcmomencobrcmbio()).getDescricao());
                comissaoExternaVO.setiperdcjurocmbio(EnumCobrancaComissao.fromCode(objFrom.getLista_cperdcjurocmbio()).getDescricao());
                
                comissaoExternaVO.setCrespcomisexter(objFrom.getLista_crespcomisexter());
                
                // marca item como fromList, para a cotar custos externo não incluir esse item novamente.
                comissaoExternaVO.setFromList(Boolean.TRUE);
                
                if (comissaoExternaVO.getiperdcjurocmbio().equalsIgnoreCase(EnumCobrancaComissao.COBRANCA_VALOR.getDescricao())) {
                    comissaoExternaVO.setRenderValor(Boolean.TRUE);
                    comissaoExternaVO.setRenderMoeda(Boolean.TRUE);
                }
                
                if (comissaoExternaVO.getiperdcjurocmbio().equalsIgnoreCase(EnumCobrancaComissao.COBRANCA_A_A.getDescricao())
                                || comissaoExternaVO.getiperdcjurocmbio().equalsIgnoreCase(EnumCobrancaComissao.COBRANCA_FLAT.getDescricao())) {
                    comissaoExternaVO.setRenderTipoPeriodo(Boolean.TRUE);
                }
                
                lista.add(comissaoExternaVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterComissaoExterna | OBTERCOMISSAOEXTERNA ------- ");
        }

    }

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Propósito: Obter comissão interna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsave ção ao padrão hexavision.
     */
    public List<ComissaoInternaVO> obterComissaoInterna(Long nBleto, String hinclreghist, String vtxspreadtot) {

        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterComissaoInterna | OBTERCOMISSAOINTERNA ------- ");
            
            List<ComissaoInternaVO> lista = new ArrayList<ComissaoInternaVO>();
            
            Obtercomissaointernarequest request = new Obtercomissaointernarequest();
            Obtercomissaointernaresponse response = new Obtercomissaointernaresponse();
            
            Npccwxeerequest entrada = new Npccwxeerequest();
            Npccwxesresponse saida = new Npccwxesresponse();
            
            request.setNpccwxeerequest(entrada);
            response.setNpccwxesresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            
            if (hinclreghist == null) {
                entrada.setHinclreghist(" ");
            } else {
                entrada.setHinclreghist(hinclreghist);
            }
            
            // Fluxo NPCCIAO7 - Books: NPCCWXEE / NPCCWXES
            listaSemPaginacao(request, response, "OBTERCOMISSAOINTERNA");
            
            // Lista
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwxesresponse_lista objFrom = saida.getLista().get(i);
                ComissaoInternaVO comissaoInternaVO = new ComissaoInternaVO();
                
                comissaoInternaVO.setVprevtcomistotal(SiteUtil.trocarPontoPorVirgula(saida.getVprevtcomistotal()));
                
                comissaoInternaVO.setCcobrcomisintrn(objFrom.getLista_ccobrcomisintrn());
                comissaoInternaVO.setNcomisintrntrade(objFrom.getLista_ncomisintrncmbio());
                comissaoInternaVO.setNcomisintrncmbio(objFrom.getLista_ncomisintrncmbio());
                comissaoInternaVO.setCfluxoperdccmbio(objFrom.getLista_cfluxoperdccmbio());
                comissaoInternaVO.setIfluxoperdccmbio(objFrom.getLista_ifluxoperdccmbio());
                comissaoInternaVO.setCmomencobrcmbio(objFrom.getLista_cmomencobrcmbio());
                comissaoInternaVO.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
                comissaoInternaVO.setIsglindcdeconmmoeda(objFrom.getLista_isglindcdfonte());
                comissaoInternaVO.setVprevtcomiscmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_vprevtcomiscmbio()));
                comissaoInternaVO.setDprevtdsembcmbio(SiteUtil.trocarPontoPorBarra(objFrom.getLista_dprevtdsembcmbio()));
                comissaoInternaVO.setCcobrcomiscmbio(objFrom.getLista_ccobrcomiscmbio());
                comissaoInternaVO.setVmincobrcomis(objFrom.getLista_vmincobrcomis());
                comissaoInternaVO.setVtxspreadaprov(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_vtxspreadaprov()));
                comissaoInternaVO.setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_vtxspreadnegoc()));
                
                // Na consulta esse campo vem no dados básico
                comissaoInternaVO.setVtxspreadtot(vtxspreadtot);
                comissaoInternaVO.setVlxtotalcomis(SiteUtil.trocarPontoPorVirgula(saida.getVprevtcomistotal()));
                
                comissaoInternaVO.setPcomisnegoccmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_pcomisnegoccmbio()));
                comissaoInternaVO.setPtxflatpnalt(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_ptxflatpnalt()));
                
                comissaoInternaVO.setDescrmomen(EnumMomentoJuro.fromCode(comissaoInternaVO.getCmomencobrcmbio())
                        .getDescricao());
                
                comissaoInternaVO.setDescrComissao(EnumCobrancaComissao.fromCode(comissaoInternaVO.getCcobrcomisintrn())
                        .getDescricao());
                
                if(EnumCobrancaComissao.fromCode(comissaoInternaVO.getCcobrcomisintrn()).equals(EnumCobrancaComissao.COBRANCA_VALOR)) {
                    comissaoInternaVO.setValorComissaoBoleto(comissaoInternaVO.getVlxtotalcomis());
                } else if(EnumCobrancaComissao.fromCode(comissaoInternaVO.getCcobrcomisintrn()).equals(EnumCobrancaComissao.COBRANCA_FLAT)) {
                        comissaoInternaVO.setValorComissaoBoleto(objFrom.getLista_ptxflatpnalt());
                } else {
                    comissaoInternaVO.setValorComissaoBoleto(objFrom.getLista_pcomisnegoccmbio());
                }
                
                comissaoInternaVO.setDesccomisbleto(objFrom.getLista_desccomisbleto());
                
                comissaoInternaVO.setDescrmomento(EnumMomentoJuro.fromCode(comissaoInternaVO.getCmomencobrcmbio()).getDescricao());
                
                lista.add(comissaoInternaVO);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterComissaoInterna | OBTERCOMISSAOINTERNA ------- ");
        }

    }

    /**
     * 
     * Nome: confirmarPerda
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarPerda(TradeFinanceVO tradeFinanceVO, Integer csitbleto) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.confirmarPerda | OBTERCONFIRMARPERDA ------- ");
            
            Obterconfirmarperdarequest request = new Obterconfirmarperdarequest();
            Obterconfirmarperdaresponse response = new Obterconfirmarperdaresponse();
            
            Npccwxqerequest entrada = new Npccwxqerequest();
            Npccwxqsresponse saida = new Npccwxqsresponse();
            
            request.setNpccwxqerequest(entrada);
            response.setNpccwxqsresponse(saida);
            
            entrada.setNbletonegoccmbio(tradeFinanceVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(tradeFinanceVO.getNbletocmbioano());
            entrada.setDanobase(tradeFinanceVO.getDanobase());
            entrada.setCaditvbletocmbio(tradeFinanceVO.getCaditvbletocmbio());
            entrada.setCsitbletocmbio(csitbleto);
            entrada.setCmotvobletocmbio(tradeFinanceVO.getCmotvobletocmbio());
            entrada.setCprodtservc(tradeFinanceVO.getCprodtservc());
            entrada.setDfchtobletocmbio(SiteUtil.trocarVirgulaPorPonto(tradeFinanceVO.getDfchtobletocmbio()));
            entrada.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
            
            entrada.setCunicclicmbio(tradeFinanceVO.getCunicclicmbio());
            entrada.setCindcdeconmmoeda(tradeFinanceVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.webMoedaToMainframe(tradeFinanceVO.getVnegocmoedaestrg()));
            entrada.setCsitbletoaprov(tradeFinanceVO.getCsitbletoaprov());
            
            if (tradeFinanceVO.getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                entrada.setCindcdnegoccarta("N");
            } else {
                if (tradeFinanceVO.getCindcdnegoccarta().toUpperCase().equals("SIM")) {
                    entrada.setCindcdnegoccarta("S");
                } else {
                    entrada.setCindcdnegoccarta("N");
                }
            }
            entrada.setCindcdcartaidpdt(tradeFinanceVO.getCindcdcartaidpdt());
            entrada.setTdiavalddcarta(tradeFinanceVO.getTdiavalddletra());
            
            // Correção de envio de informação incorreta (valor com virgula separando as decimais) para o Mainframe
            entrada.setVtxspreadnegoc(SiteUtil.webMoedaToMainframe(tradeFinanceVO.getVtxspreadnegoc()));
            entrada.setDlimembrqcmbio(tradeFinanceVO.getDlimembrqcmbio().replace("/", "."));
            entrada.setTdiaopercmbio(tradeFinanceVO.getTdiaopercmbio());
            
            if (tradeFinanceVO.getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                entrada.setDprevtdsembcmbio(tradeFinanceVO.getDataPrevDesemb().getInicioFormatado().replace("/", "."));
            } else {
                entrada.setDprevtdsembcmbio(tradeFinanceVO.getDprevtdsembcmbio().replace("/", "."));
            }
            entrada.setRjustfdqmto(tradeFinanceVO.getRjustfdqmto());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(tradeFinanceVO.getVtxspreadtot()));
            
            //NPCCIAQR - NPCCWXQE/NPCCWXQS
            listaSemPaginacao(request, response, "OBTERCONFIRMARPERDA");
            
            return response.getTexmens();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.confirmarPerda | OBTERCONFIRMARPERDA ------- ");
        }
    }

    /**
     * 
     * Nome: confirmarBaixar
     * 
     * Propósito: Obter detalhes da comissão externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarBaixar(TradeFinanceVO tradeFinanceVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.confirmarBaixar | OBTERCONFIRMARBAIXAR ------- ");
            
            Obterconfirmarbaixarrequest request = new Obterconfirmarbaixarrequest();
            Obterconfirmarbaixarresponse response = new Obterconfirmarbaixarresponse();
            
            Npccwxterequest entrada = new Npccwxterequest();
            Npccwxtsresponse saida = new Npccwxtsresponse();
            
            request.setNpccwxterequest(entrada);
            response.setNpccwxtsresponse(saida);
            
            entrada.setNbletonegoccmbio(tradeFinanceVO.getNbletonegoccmbio());
            entrada.setCmotvobletocmbio(tradeFinanceVO.getCmotvobletocmbio());
            entrada.setCindcdeconmpnalt(tradeFinanceVO.getCindcdeconmpnalt());
            entrada.setVpnaltanteccmbio(SiteUtil.trocarVirgulaPorPonto(tradeFinanceVO.getVpnaltanteccmbio()));
            entrada.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
            entrada.setCindcdeconmmoeda(tradeFinanceVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.trocarVirgulaPorPonto(tradeFinanceVO.getVnegocmoedaestrg()));
            entrada.setCsitbletoaprov(tradeFinanceVO.getCsitbletoaprov());

            
            // BOOKS: NPCCWXTE FLUXO: NPCCIAQT
            listaSemPaginacao(request, response, "OBTERCONFIRMARBAIXAR");
            
            return response.getTexmens();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.confirmarBaixar | OBTERCONFIRMARBAIXAR ------- ");
        }

    }

    /**
     * 
     * Nome: obterCotacoesPend
     * 
     * Propósito: Obter detalhes da comissão externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPend(TradeFinanceFiltroVO filtroVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesPend | OBTERCOTACOESPEND ------- ");
            
            List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();
            
            Obtercotacoespendrequest request = new Obtercotacoespendrequest();
            Obtercotacoespendresponse response = new Obtercotacoespendresponse();
            
            Npccwyeerequest entrada = new Npccwyeerequest();
            Npccwyesresponse saida = new Npccwyesresponse();
            
            request.setNpccwyeerequest(entrada);
            response.setNpccwyesresponse(saida);
            
            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().getInicio() == null
                    || filtroVO.getPeriodoCotacao().getFim() == null) {
                entrada.setDeperiodocotacao("");
                entrada.setAteperiodocotacao("");
            } else {
                entrada.setDeperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getInicio()));
                entrada.setAteperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setCusuarinclt(filtroVO.getCusuarincl());
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setCprodtservc(filtroVO.getCprodtservc());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setNsequndorgnz(Integer.parseInt(filtroVO.getNsequndorgnz()));
            entrada.setCbcoextcmbio(filtroVO.getUnidadeExternaVO().getCbanqrcmbio());
            entrada.setCsitcustext(filtroVO.getCsitcustext());
            entrada.setCsitunidext(filtroVO.getCsitunidext());
            entrada.setCsitdiverg(filtroVO.getCsitdiverg());
            
            // FLUXO: NPCCIAQ0 BOOKS: Npccwye/s
            listaComPaginacao(request, response, "OBTERCOTACOESPEND", "NPCCIAQ0");
            
            // trata retorno
            this.setMsgRetorno(response.getTexmens());
            
            for (int i = Numeros.ZERO; i < response.getNpccwyesresponse().getQtdeocorr(); i++) {
                
                Npccwyesresponse_gride objFrom = response.getNpccwyesresponse().getGride().get(i);
                TradeFinanceListaVO objTo = new TradeFinanceListaVO();
                
                objTo.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
                objTo.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtcotacao()));
                objTo.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
                objTo.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
                objTo.setCpfcnpj(objFrom.getGride_scpfcnpj());
                objTo.setCfilial(objFrom.getGride_scflial());
                objTo.setCctrl(objFrom.getGride_scctrl());
                objTo.setNsequndorgnz(objFrom.getGride_snsequndorgnz());
                objTo.setNomeundorgnz(objFrom.getGride_snomeundorgnz());
                objTo.setCbcoextcmbio(objFrom.getGride_scbcoextcmbio());
                objTo.setDbcoextcmbio(objFrom.getGride_sdbcoextcmbio());
                objTo.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
                objTo.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
                objTo.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svlrmoedaestrang()));
                objTo.setCprodtservc(objFrom.getGride_scprodtservc());
                objTo.setDprodtservc(objFrom.getGride_sdprodtservc());
                objTo.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
                objTo.setCmodldprodtdesc(objFrom.getGride_scmodldprodtdesc());
                objTo.setCsitbletocmbio(objFrom.getGride_scsitbletocmbio());
                objTo.setCsitbletoaprov(objFrom.getGride_scsitbletoaprov());
                objTo.setDsitbletocmbio(objFrom.getGride_sdsitbletocmbio());
                objTo.setCusuarinclt(objFrom.getGride_scusuarinclt());
                objTo.setNusuarinclt(objFrom.getGride_snusuarinclt());
                objTo.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
                objTo.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(objTo.getCpfcnpj(), objTo.getCfilial(),
                        objTo.getCctrl()));
                
                lista.add(objTo);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesPend | OBTERCOTACOESPEND ------- ");
        }

    }

    /**
     * Nome: obterCotacoesPendExportacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPendExportacao(TradeFinanceFiltroVO filter) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesPendExportacao | OBTERCOTACOESPEND ------- ");
            
            List<TradeFinanceListaVO> records = new ArrayList<TradeFinanceListaVO>();
            
            Obtercotacoespendrequest request = new Obtercotacoespendrequest();
            Obtercotacoespendresponse response = new Obtercotacoespendresponse();
            Npccwyeerequest input = new Npccwyeerequest();
            Npccwyesresponse output = new Npccwyesresponse();
            
            if (filter.getPeriodoCotacao() == null || filter.getPeriodoCotacao().getInicio() == null
                    || filter.getPeriodoCotacao().getFim() == null) {
                input.setDeperiodocotacao("");
                input.setAteperiodocotacao("");
            } else {
                input.setDeperiodocotacao(SiteUtil.dataWebToMainframe(filter.getPeriodoCotacao().getInicio()));
                input.setAteperiodocotacao(SiteUtil.dataWebToMainframe(filter.getPeriodoCotacao().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filter.getNbletocmbioano())) {
                input.setDanobase(null);
            } else {
                input.setDanobase(filter.getDanobase());
            }
            
            input.setCunicclicmbio(filter.getCunicclicmbio());
            input.setCusuarinclt(filter.getCusuarincl());
            input.setNbletocmbioano(filter.getNbletocmbioano());
            input.setCprodtservc(filter.getCprodtservc());
            input.setCtposgmtocli(filter.getCtposgmtocli());
            input.setNsequndorgnz(Integer.parseInt(filter.getNsequndorgnz()));
            input.setCbcoextcmbio(filter.getUnidadeExternaVO().getCbanqrcmbio());
            input.setCsitcustext(filter.getCsitcustext());
            input.setCsitunidext(filter.getCsitunidext());
            input.setCsitdiverg(filter.getCsitdiverg());
            
            request.setNpccwyeerequest(input);
            response.setNpccwyesresponse(output);
            
            // Executa chamada CWS - Fluxo: NPCCIAQ0 - Books: NPCCWYEE / NPCCWYES
            List<Obtercotacoespendresponse> pages = autoPaginate(request, response, "OBTERCOTACOESPEND");
            
            // Percorre todas as paginas obtidas do MF
            for (Obtercotacoespendresponse page : pages) {
                Npccwyesresponse currentOutput = page.getNpccwyesresponse();
                
                // Percorre todas as ocorrencias de cada pagina
                for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                    Npccwyesresponse_gride occurrence = currentOutput.getGride().get(i);
                    TradeFinanceListaVO record = new TradeFinanceListaVO();
                    
                    record.setNbletocmbioano(occurrence.getGride_snbletocmbioano());
                    record.setDtcotacao(SiteUtil.trocarPontoPorBarra(occurrence.getGride_sdtcotacao()));
                    record.setCunicclicmbio(occurrence.getGride_scunicclicmbio());
                    record.setNcunicclicmbio(occurrence.getGride_sncunicclicmbio());
                    record.setCpfcnpj(occurrence.getGride_scpfcnpj());
                    record.setCfilial(occurrence.getGride_scflial());
                    record.setCctrl(occurrence.getGride_scctrl());
                    record.setNsequndorgnz(occurrence.getGride_snsequndorgnz());
                    record.setNomeundorgnz(occurrence.getGride_snomeundorgnz());
                    record.setCbcoextcmbio(occurrence.getGride_scbcoextcmbio());
                    record.setDbcoextcmbio(occurrence.getGride_sdbcoextcmbio());
                    record.setCindcdeconmmoeda(occurrence.getGride_scindcdeconmmoeda());
                    record.setSimbleconmmoeda(occurrence.getGride_ssimbleconmmoeda());
                    record.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svlrmoedaestrang()));
                    record.setCprodtservc(occurrence.getGride_scprodtservc());
                    record.setDprodtservc(occurrence.getGride_sdprodtservc());
                    record.setCmodldprodtcmbio(occurrence.getGride_scmodldprodtcmbio());
                    record.setCmodldprodtdesc(occurrence.getGride_scmodldprodtdesc());
                    record.setCsitbletocmbio(occurrence.getGride_scsitbletocmbio());
                    record.setCsitbletoaprov(occurrence.getGride_scsitbletoaprov());
                    record.setDsitbletocmbio(occurrence.getGride_sdsitbletocmbio());
                    record.setCusuarinclt(occurrence.getGride_scusuarinclt());
                    record.setNusuarinclt(occurrence.getGride_snusuarinclt());
                    record.setNbletonegoccmbio(occurrence.getGride_snbletonegoccmbio());
                    record.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(record.getCpfcnpj(), record.getCfilial(),
                            record.getCctrl()));
                    
                    records.add(record);
                }
            }
            
            return records;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesPendExportacao | OBTERCOTACOESPEND ------- ");
        }
    }
    
    /**
     * 
     * Nome: obterCotacoesFechadas
     * 
     * Propósito: Obter detalhes da comissão externa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadas(TradeFinanceFiltroVO filtroVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesFechadas | COTACOESFECHADAS ------- ");
            
            List<TradeFinanceListaVO> listaVO = new ArrayList<TradeFinanceListaVO>();
            
            Cotacoesfechadasrequest request = new Cotacoesfechadasrequest();
            Cotacoesfechadasresponse response = new Cotacoesfechadasresponse();
            
            Npccwzverequest entrada = new Npccwzverequest();
            Npccwzvsresponse saida = new Npccwzvsresponse();
            
            request.setNpccwzverequest(entrada);
            response.setNpccwzvsresponse(saida);
            
            if (filtroVO.getPeriodoFech() == null || filtroVO.getPeriodoFech().getInicio() == null
                    || filtroVO.getPeriodoFech().getFim() == null) {
                entrada.setDeperiodofechmto("");
                entrada.setAteperiodofechmto("");
            } else {
                entrada.setDeperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getInicio()));
                entrada.setAteperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getFim()));
            }
            
            if (filtroVO.getNbletocmbioano() == null || filtroVO.getNbletocmbioano().equals("")) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setCusuarinclt(filtroVO.getCusuarincl());
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setCprodtservc(filtroVO.getCprodtservc());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setNsequndorgnz(Integer.parseInt(filtroVO.getNsequndorgnz()));
            
            listaComPaginacao(request, response, "COTACOESFECHADAS", "NPCCIARL");
            
            // trata retorno
            this.setMsgRetorno(response.getTexmens());
            
            for (int i = Numeros.ZERO; i < response.getNpccwzvsresponse().getQtdeocorr(); i++) {
                
                Npccwzvsresponse_gride objFrom = response.getNpccwzvsresponse().getGride().get(i);
                TradeFinanceListaVO objTo = new TradeFinanceListaVO();
                
                if(!objFrom.getGride_sdtfechamento().equals("01.01.0001"))
                    objTo.setDtfechamento(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtfechamento()));
                else 
                    objTo.setDtfechamento(null);
                
                objTo.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
                objTo.setDivergente(objFrom.getGride_sdivergente());
                objTo.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
                objTo.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
                objTo.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
                objTo.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
                objTo.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svlrmoedaestrang()));
                objTo.setCprodtservc(objFrom.getGride_scprodtservc());
                objTo.setDprodtservc(objFrom.getGride_sdprodtservc());
                objTo.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
                objTo.setCmodldprodtdesc(objFrom.getGride_scmodldprodtdesc());
                objTo.setCusuarinclt(objFrom.getGride_scusuarinclt());
                objTo.setNusuarinclt(objFrom.getGride_snusuarinclt());
                objTo.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
                objTo.setCsitbletoaprov(objFrom.getGride_scsitbletoaprov());
                
                listaVO.add(objTo);
            }
            
            return listaVO;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesFechadas | COTACOESFECHADAS ------- ");
        }

    }
    
    /**
     * 
     * Nome: cotacoesFechadas
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadasExportacao(TradeFinanceFiltroVO filter) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesFechadasExportacao | COTACOESFECHADAS ------- ");
            
            List<TradeFinanceListaVO> records = new ArrayList<TradeFinanceListaVO>();
            
            Cotacoesfechadasrequest request = new Cotacoesfechadasrequest();
            Cotacoesfechadasresponse response = new Cotacoesfechadasresponse();
            Npccwzverequest input = new Npccwzverequest();
            Npccwzvsresponse output = new Npccwzvsresponse();
            
            if (filter.getPeriodoFech() == null || filter.getPeriodoFech().getInicio() == null
                    || filter.getPeriodoFech().getFim() == null) {
                input.setDeperiodofechmto("");
                input.setAteperiodofechmto("");
            } else {
                input.setDeperiodofechmto(SiteUtil.dataWebToMainframe(filter.getPeriodoFech().getInicio()));
                input.setAteperiodofechmto(SiteUtil.dataWebToMainframe(filter.getPeriodoFech().getFim()));
            }
            
            if (filter.getNbletocmbioano() == null || filter.getNbletocmbioano().equals("")) {
                input.setDanobase(null);
            } else {
                input.setDanobase(filter.getDanobase());
            }
            
            input.setCunicclicmbio(filter.getCunicclicmbio());
            input.setCusuarinclt(filter.getCusuarincl());
            input.setNbletocmbioano(filter.getNbletocmbioano());
            input.setCprodtservc(filter.getCprodtservc());
            input.setCtposgmtocli(filter.getCtposgmtocli());
            input.setNsequndorgnz(Integer.parseInt(filter.getNsequndorgnz()));
            
            request.setNpccwzverequest(input);
            response.setNpccwzvsresponse(output);
            
            // Executa chamada CWS - Fluxo: NPCCIARL - Books: NPCCWZVE / NPCCWZVS
            List<Cotacoesfechadasresponse> pages = autoPaginate(request, response, "COTACOESFECHADAS");
            
            // Percorre todas as paginas obtidas do MF
            for (Cotacoesfechadasresponse page : pages) {
                Npccwzvsresponse currentOutput = page.getNpccwzvsresponse();
                
                // Percorre todas as ocorrencias de cada pagina
                for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                    Npccwzvsresponse_gride occurrence = currentOutput.getGride().get(i);
                    TradeFinanceListaVO record = new TradeFinanceListaVO();
                    
                    record.setDtfechamento(SiteUtil.trocarPontoPorBarra(occurrence.getGride_sdtfechamento()));
                    record.setNbletocmbioano(occurrence.getGride_snbletocmbioano());
                    record.setDivergente(occurrence.getGride_sdivergente());
                    record.setCunicclicmbio(occurrence.getGride_scunicclicmbio());
                    record.setNcunicclicmbio(occurrence.getGride_sncunicclicmbio());
                    record.setCindcdeconmmoeda(occurrence.getGride_scindcdeconmmoeda());
                    record.setSimbleconmmoeda(occurrence.getGride_ssimbleconmmoeda());
                    record.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svlrmoedaestrang()));
                    record.setCprodtservc(occurrence.getGride_scprodtservc());
                    record.setDprodtservc(occurrence.getGride_sdprodtservc());
                    record.setCmodldprodtcmbio(occurrence.getGride_scmodldprodtcmbio());
                    record.setCmodldprodtdesc(occurrence.getGride_scmodldprodtdesc());
                    record.setCusuarinclt(occurrence.getGride_scusuarinclt());
                    record.setNusuarinclt(occurrence.getGride_snusuarinclt());
                    record.setNbletonegoccmbio(occurrence.getGride_snbletonegoccmbio());
                    record.setCsitbletoaprov(occurrence.getGride_scsitbletoaprov());
                    
                    records.add(record);
                }
            }
            
            return records;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesFechadasExportacao | COTACOESFECHADAS ------- ");
        }
    }

    /**
     * 
     * Nome: confirmarDadosFunding
     * 
     * Propósito: Retorna a descricao da Cotacao de acordo com o codigo
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarDadosFunding(Long nBleto, List<FundingVO> lista, String valorME, Integer codMoeda) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.confirmarDadosFunding | DADOSFUNDINGINCL ------- ");
            
            Dadosfundinginclrequest request = new Dadosfundinginclrequest();
            Dadosfundinginclresponse response = new Dadosfundinginclresponse();
            
            Npccwwyerequest entrada = new Npccwwyerequest();
            Npccwwysresponse saida = new Npccwwysresponse();
            
            request.setNpccwwyerequest(entrada);
            response.setNpccwwysresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            entrada.setVfndngnegoccmbio(SiteUtil.formatarPontosVirgula(valorME));
            entrada.setCindcdmoedaoper(codMoeda);
            entrada.setLista(new ArrayList<Npccwwyerequest_lista>());
            
            for (int i = 0; i < lista.size(); i++) {
                FundingVO objFrom = lista.get(i);
                Npccwwyerequest_lista objTo = new Npccwwyerequest_lista();
                
                objTo.setLista_cexterreftfndng(objFrom.getcexterreftfndng());
                objTo.setLista_cindcdeconmmoeda(objFrom.getcindcdeconmmoeda());
                objTo.setLista_vpcelafndngcmbio(SiteUtil.formatarPontosVirgula(objFrom.getvpcelafndngcmbio()));
                entrada.getLista().add(objTo);
            }
            entrada.setQtdeocorr(lista.size());
            // executa chamada CWS - Fluxo NPCCIAQD - Books: NPCCWWYE / NPCCWWYS
            listaSemPaginacao(request, response, "DADOSFUNDINGINCL");
            
            return response.getTexmens();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.confirmarDadosFunding | DADOSFUNDINGINCL ------- ");
        }
    }

    /**
     * 
     * Nome: pesquisarCotacoes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoes(TradeFinanceFiltroVO filtroVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.pesquisarCotacoes | TRADEFINANCEMNTLIST ------- ");
            
            List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();
            Tradefinancemntlistrequest request = new Tradefinancemntlistrequest();
            Tradefinancemntlistresponse response = new Tradefinancemntlistresponse();
            
            Npccwwrerequest entrada = new Npccwwrerequest();
            Npccwwrsresponse saida = new Npccwwrsresponse();
            
            request.setNpccwwrerequest(entrada);
            
            response.setNpccwwrsresponse(saida);
            
            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().getInicio() == null
                    || filtroVO.getPeriodoCotacao().getFim() == null) {
                entrada.setDeperiodocotacao("");
                entrada.setAteperiodocotacao("");
            } else {
                entrada.setDeperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getInicio()));
                entrada.setAteperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getFim()));
            }
            
            if (filtroVO.getPeriodoFech() == null || filtroVO.getPeriodoFech().getInicio() == null
                    || filtroVO.getPeriodoFech().getFim() == null) {
                entrada.setDeperiodofechmto("");
                entrada.setAteperiodofechmto("");
            } else {
                entrada.setDeperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getInicio()));
                entrada.setAteperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(filtroVO.getCsitbletocmbio());
            entrada.setCusuarinclt(filtroVO.getCusuarincl());
            entrada.setCindcdeconmmoeda(filtroVO.getCindcdeconmmoeda());
            entrada.setCprodtservc(filtroVO.getCprodtservc());
            entrada.setNsequndorgnz(SiteUtil.getInt(filtroVO.getNsequndorgnz()));
            entrada.setCbcoextcmbio(filtroVO.getUnidadeExternaVO().getCbanqrcmbio());
            
            if (filtroVO.getCindcdnegocswap() != null && filtroVO.getCindcdnegocswap()) {
                entrada.setCindcdnegocswap(Numeros.UM.toString());
            } else {
                entrada.setCindcdnegocswap(SiteUtil.STRING_EMPTY);
            }
            
            entrada.setCtponegoccmbio(filtroVO.getCtponegoccmbio());
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setTdiadecmbio(filtroVO.getTdiadecmbio());
            entrada.setTdiaatecmbio(filtroVO.getTdiaatecmbio());
            entrada.setQprzmedde(filtroVO.getQprzmedde());
            entrada.setQprzmedate(filtroVO.getQprzmedate());
            entrada.setValormede(SiteUtil.webMoedaToMainframe(filtroVO.getValormede()));
            entrada.setValormeate(SiteUtil.webMoedaToMainframe(filtroVO.getValormeate()));
            entrada.setCpaisrest(filtroVO.getCpaisrest());
            
            // FLUXO: NPCCIARM BOOK: NPCCWWRE/S
            listaComPaginacao(request, response, "TRADEFINANCEMNTLIST", "NPCCIARM");
            
            // Lista de parcelas de Funding
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwwrsresponse_gride objFrom = saida.getGride().get(i);
                TradeFinanceListaVO listaVO = new TradeFinanceListaVO();
                
                listaVO.setCsitbletocmbio(objFrom.getGride_scsitbletocmbio());
                listaVO.setDsitbletocmbio(objFrom.getGride_sdsitbletocmbio());
                listaVO.setCsitbletoaprov(objFrom.getGride_scsitbletoaprov());
                listaVO.setStatusAprovacao(EnumStatusAprovacao.fromCode(objFrom.getGride_scsitbletoaprov()).getDescricao());
                listaVO.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtcotacao()));
                listaVO.setCusuarinclt(objFrom.getGride_scusuarinclt());
                listaVO.setNusuarinclt(objFrom.getGride_snusuarinclt());
                listaVO.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
                listaVO.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
                listaVO.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
                listaVO.setCpfcnpj(objFrom.getGride_scpfcnpj());
                listaVO.setCfilial(objFrom.getGride_scflial());
                listaVO.setCctrl(objFrom.getGride_scctrl());
                listaVO.setCtposgmtocli(objFrom.getGride_sctposgmtocli());
                listaVO.setDtposgmtocli(objFrom.getGride_sdtposgmtocli());
                listaVO.setCtponegoccmbio(objFrom.getGride_sctponegoccmbio());
                listaVO.setNsequndorgnz(objFrom.getGride_snsequndorgnz());
                listaVO.setNomeundorgnz(objFrom.getGride_snomeundorgnz());
                listaVO.setAgcmrcl(objFrom.getGride_sagcmrcl());
                listaVO.setCprodtservc(objFrom.getGride_scprodtservc());
                listaVO.setDprodtservc(objFrom.getGride_sdprodtservc());
                listaVO.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
                listaVO.setCmodldprodtdesc(objFrom.getGride_scmodldprodtdesc());
                listaVO.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
                listaVO.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
                listaVO.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svlrmoedaestrang()));
                listaVO.setVlreqvlntedolar(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svlreqvlntedolar()));
                listaVO.setCindcdnegocswap(SiteUtil.indicadorSimNao(objFrom.getGride_scindcdnegocswap()));
                listaVO.setTdiaopercmbio(objFrom.getGride_stdiaopercmbio());
                listaVO.setQprzmedcmbio(objFrom.getGride_sqprzmedcmbio());
                listaVO.setNseqcontrlim(objFrom.getGride_snseqcontrlim());
                listaVO.setVtxspreadaprov(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svtxspreadaprov()));
                listaVO.setCusto(objFrom.getGride_scusto());
                listaVO.setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_svtxspreadnegoc()));
                listaVO.setPtxswapcmpdo(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_sptxswapcmpdo()));
                listaVO.setSpreaddolar(SiteUtil.trocarPontoPorVirgula(objFrom.getGride_sspreaddolar()));
                listaVO.setCbcoextcmbio(objFrom.getGride_scbcoextcmbio());
                listaVO.setDbcoextcmbio(objFrom.getGride_sdbcoextcmbio());
                listaVO.setDfchtobletocmbio(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdfchtobletocmbio()));
                listaVO.setCaditvbletocmbio(objFrom.getGride_scaditvbletocmbio());
                
                if (objFrom.getGride_scaditvbletocmbio() > 0) {
                    
                    listaVO.setCaditvbletocmbiostr("Sim");
                    
                } else {
                    
                    listaVO.setCaditvbletocmbiostr("Não");
                }
                
                listaVO.setCpais(objFrom.getGride_scpais());
                listaVO.setDpais(objFrom.getGride_sdpais());
                listaVO.setCpaisembrq(objFrom.getGride_scpaisembrq());
                listaVO.setDpaisembrq(objFrom.getGride_sdpaisembrq());
                listaVO.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
                listaVO.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(listaVO.getCpfcnpj(), listaVO.getCfilial(),
                        listaVO.getCctrl()));
                listaVO.setEnumAcaoProduto(EnumAcaoProduto.fromCode(objFrom.getGride_scprodtservc()));
                listaVO.setEnumAcaoSituacao(EnumAcaoSituacao.fromCode(objFrom.getGride_scsitbletocmbio()));
                
                listaVO.setCmodcontrcmbio(objFrom.getGride_scmodcontrcmbio());
                
                lista.add(listaVO);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.pesquisarCotacoes | TRADEFINANCEMNTLIST ------- ");
        }
    }
    
    /**
     * Nome: pesquisarCotacoesExportacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoesExportacao(TradeFinanceFiltroVO filter) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.pesquisarCotacoesExportacao | TRADEFINANCEMNTLIST ------- ");
            
            List<TradeFinanceListaVO> records = new ArrayList<TradeFinanceListaVO>();
            
            Tradefinancemntlistrequest request = new Tradefinancemntlistrequest();
            Tradefinancemntlistresponse response = new Tradefinancemntlistresponse();
            Npccwwrerequest input = new Npccwwrerequest();
            Npccwwrsresponse output = new Npccwwrsresponse();
            
            if (filter.getPeriodoCotacao() == null || filter.getPeriodoCotacao().getInicio() == null
                    || filter.getPeriodoCotacao().getFim() == null) {
                input.setDeperiodocotacao("");
                input.setAteperiodocotacao("");
            } else {
                input.setDeperiodocotacao(SiteUtil.dataWebToMainframe(filter.getPeriodoCotacao().getInicio()));
                input.setAteperiodocotacao(SiteUtil.dataWebToMainframe(filter.getPeriodoCotacao().getFim()));
            }
            
            if (filter.getPeriodoFech() == null || filter.getPeriodoFech().getInicio() == null
                    || filter.getPeriodoFech().getFim() == null) {
                input.setDeperiodofechmto("");
                input.setAteperiodofechmto("");
            } else {
                input.setDeperiodofechmto(SiteUtil.dataWebToMainframe(filter.getPeriodoFech().getInicio()));
                input.setAteperiodofechmto(SiteUtil.dataWebToMainframe(filter.getPeriodoFech().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filter.getNbletocmbioano())) {
                input.setDanobase(null);
            } else {
                input.setDanobase(filter.getDanobase());
            }
         
            input.setCunicclicmbio(filter.getCunicclicmbio());
            input.setCtposgmtocli(filter.getCtposgmtocli());
            input.setCsitbletocmbio(filter.getCsitbletocmbio());
            input.setCusuarinclt(filter.getCusuarincl());
            input.setCindcdeconmmoeda(filter.getCindcdeconmmoeda());
            input.setCprodtservc(filter.getCprodtservc());
            input.setNsequndorgnz(SiteUtil.getInt(filter.getNsequndorgnz()));
            input.setCbcoextcmbio(filter.getUnidadeExternaVO().getCbanqrcmbio());
            
            if (filter.getCindcdnegocswap() != null && filter.getCindcdnegocswap()) {
                input.setCindcdnegocswap(Numeros.UM.toString());
            } else {
                input.setCindcdnegocswap(SiteUtil.STRING_EMPTY);
            }
            
            input.setCtponegoccmbio(filter.getCtponegoccmbio());
            input.setNbletocmbioano(filter.getNbletocmbioano());
            input.setTdiadecmbio(filter.getTdiadecmbio());
            input.setTdiaatecmbio(filter.getTdiaatecmbio());
            input.setQprzmedde(filter.getQprzmedde());
            input.setQprzmedate(filter.getQprzmedate());
            input.setValormede(SiteUtil.webMoedaToMainframe(filter.getValormede()));
            input.setValormeate(SiteUtil.webMoedaToMainframe(filter.getValormeate()));
            input.setCpaisrest(filter.getCpaisrest());
                      
            request.setNpccwwrerequest(input);
            response.setNpccwwrsresponse(output);
            
            // Executa chamada CWS - Fluxo: NPCCIARM - Books: NPCCWWRE / NPCCWWRS
            List<Tradefinancemntlistresponse> pages = autoPaginate(request, response, "TRADEFINANCEMNTLIST");
            
            // Percorre todas as paginas obtidas do MF
            for (Tradefinancemntlistresponse page : pages) {
                Npccwwrsresponse currentOutput = page.getNpccwwrsresponse();
                
                // Percorre todas as ocorrencias de cada pagina
                for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                    Npccwwrsresponse_gride occurrence = currentOutput.getGride().get(i);
                    TradeFinanceListaVO record = new TradeFinanceListaVO();
                    
                    record.setCsitbletocmbio(occurrence.getGride_scsitbletocmbio());
                    record.setDsitbletocmbio(occurrence.getGride_sdsitbletocmbio());
                    record.setCsitbletoaprov(occurrence.getGride_scsitbletoaprov());
                    record.setStatusAprovacao(EnumStatusAprovacao.fromCode(occurrence.getGride_scsitbletoaprov()).getDescricao());
                    record.setDtcotacao(SiteUtil.trocarPontoPorBarra(occurrence.getGride_sdtcotacao()));
                    record.setCusuarinclt(occurrence.getGride_scusuarinclt());
                    record.setNusuarinclt(occurrence.getGride_snusuarinclt());
                    record.setNbletonegoccmbio(occurrence.getGride_snbletonegoccmbio());
                    record.setCunicclicmbio(occurrence.getGride_scunicclicmbio());
                    record.setNcunicclicmbio(occurrence.getGride_sncunicclicmbio());
                    record.setCpfcnpj(occurrence.getGride_scpfcnpj());
                    record.setCfilial(occurrence.getGride_scflial());
                    record.setCctrl(occurrence.getGride_scctrl());
                    record.setCtposgmtocli(occurrence.getGride_sctposgmtocli());
                    record.setDtposgmtocli(occurrence.getGride_sdtposgmtocli());
                    record.setCtponegoccmbio(occurrence.getGride_sctponegoccmbio());
                    record.setNsequndorgnz(occurrence.getGride_snsequndorgnz());
                    record.setNomeundorgnz(occurrence.getGride_snomeundorgnz());
                    record.setAgcmrcl(occurrence.getGride_sagcmrcl());
                    record.setCprodtservc(occurrence.getGride_scprodtservc());
                    record.setDprodtservc(occurrence.getGride_sdprodtservc());
                    record.setCmodldprodtcmbio(occurrence.getGride_scmodldprodtcmbio());
                    record.setCmodldprodtdesc(occurrence.getGride_scmodldprodtdesc());
                    record.setCindcdeconmmoeda(occurrence.getGride_scindcdeconmmoeda());
                    record.setSimbleconmmoeda(occurrence.getGride_ssimbleconmmoeda());
                    record.setVlrmoedaestrang(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svlrmoedaestrang()));
                    record.setVlreqvlntedolar(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svlreqvlntedolar()));
                    record.setCindcdnegocswap(SiteUtil.indicadorSimNao(occurrence.getGride_scindcdnegocswap()));
                    record.setTdiaopercmbio(occurrence.getGride_stdiaopercmbio());
                    record.setQprzmedcmbio(occurrence.getGride_sqprzmedcmbio());
                    record.setNseqcontrlim(occurrence.getGride_snseqcontrlim());
                    record.setVtxspreadaprov(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svtxspreadaprov()));
                    record.setCusto(occurrence.getGride_scusto());
                    record.setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_svtxspreadnegoc()));
                    record.setPtxswapcmpdo(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_sptxswapcmpdo()));
                    record.setSpreaddolar(SiteUtil.trocarPontoPorVirgula(occurrence.getGride_sspreaddolar()));
                    record.setCbcoextcmbio(occurrence.getGride_scbcoextcmbio());
                    record.setDbcoextcmbio(occurrence.getGride_sdbcoextcmbio());
                    record.setDfchtobletocmbio(SiteUtil.trocarPontoPorBarra(occurrence.getGride_sdfchtobletocmbio()));
                    record.setCaditvbletocmbio(occurrence.getGride_scaditvbletocmbio());
                    
                    if (occurrence.getGride_scaditvbletocmbio() > 0) {
                        record.setCaditvbletocmbiostr("Sim");
                    } else {
                        record.setCaditvbletocmbiostr("Não");
                    }
                    
                    record.setCpais(occurrence.getGride_scpais());
                    record.setDpais(occurrence.getGride_sdpais());
                    record.setCpaisembrq(occurrence.getGride_scpaisembrq());
                    record.setDpaisembrq(occurrence.getGride_sdpaisembrq());
                    record.setNbletocmbioano(occurrence.getGride_snbletocmbioano());
                    record.setCpfCnpjFormatado(SiteUtil.formatarCPFCCNPJ(record.getCpfcnpj(), record.getCfilial(),
                            record.getCctrl()));
                    record.setEnumAcaoProduto(EnumAcaoProduto.fromCode(occurrence.getGride_scprodtservc()));
                    record.setEnumAcaoSituacao(EnumAcaoSituacao.fromCode(occurrence.getGride_scsitbletocmbio()));
                    
                    record.setCmodcontrcmbio(occurrence.getGride_scmodcontrcmbio());
                    
                    records.add(record);
                }
            }
            
            return records;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.pesquisarCotacoesExportacao | TRADEFINANCEMNTLIST ------- ");
        }
    }
    
    
    /**
     * Nome: obterCotacoesPendenteExportacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 17/11/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPendenteExportacao(TradeFinanceFiltroVO filtroVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesPendenteExportacao | COTACOESPENDCOMPL ------- ");
            
            List<TradeFinanceListaVO> records = new ArrayList<TradeFinanceListaVO>();
            
            Cotacoespendcomplrequest request = new Cotacoespendcomplrequest();
            Cotacoespendcomplresponse response = new Cotacoespendcomplresponse();
            
            Npccwyjerequest entrada = new Npccwyjerequest();
            Npccwyjsresponse saida = new Npccwyjsresponse();
            
            request.setNpccwyjerequest(entrada);
            response.setNpccwyjsresponse(saida);
            
            
            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().getInicio() == null
                    || filtroVO.getPeriodoCotacao().getFim() == null) {
                entrada.setPeriodocotacaoi("");
                entrada.setPeriodocotacaof("");
            } else {
                entrada.setPeriodocotacaoi(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getInicio()));
                entrada.setPeriodocotacaof(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            
            entrada.setCpssoajurid(filtroVO.getCpssoajurid());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setNsequndorgnz(SiteUtil.getInt(filtroVO.getNsequndorgnz()));
            
            // FLUXO: NPCCIASP BOOK: NPCCWYJE/S
            List<Cotacoespendcomplresponse> pages = autoPaginate(request, response, "COTACOESPENDCOMPL");
            
            // Percorre todas as paginas obtidas do MF
            for (Cotacoespendcomplresponse page : pages) {
                Npccwyjsresponse currentOutput = page.getNpccwyjsresponse();
                
                // Percorre todas as ocorrencias de cada pagina
                for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                    Npccwyjsresponse_gride occurrence = currentOutput.getGride().get(i);
                    TradeFinanceListaVO record = new TradeFinanceListaVO();
            
                    record.setCindcdeconmmoeda(occurrence.getGride_scindcdeconmmoeda());
                    record.setCmodldprodtcmbio(occurrence.getGride_scmodldprodtcmbio());
                    record.setCprodtservc(occurrence.getGride_scprodtservc());
                    record.setCsitbletocmbio(occurrence.getGride_scsitbletocmbio());
                    record.setCunicclicmbio(occurrence.getGride_scunicclicmbio());
                    record.setDmodldprodtcmbio(occurrence.getGride_sdmodldprodtcmbio());
                    record.setDprodtservc(occurrence.getGride_sdprodtservc());
                    record.setDsitbletocmbio(occurrence.getGride_sdsitbletocmbio());
                    record.setDtcotacao(SiteUtil.trocarPontoPorBarra(occurrence.getGride_sdtcotacao()));
                    record.setNbletocmbioano(occurrence.getGride_snbletocmbioano());
                    record.setNbletonegoccmbio(occurrence.getGride_snbletonegoccmbio());
                    record.setNcunicclicmbio(occurrence.getGride_sncunicclicmbio());
                    record.setSimbleconmmoeda(occurrence.getGride_ssimbleconmmoeda());
                    record.setVnegocmoedaestrg(occurrence.getGride_svnegocmoedaestrg());
                
                    records.add(record);
                }
                
            }
            
            return records;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesPendenteExportacao | COTACOESPENDCOMPL ------- ");
        }
    }

    /**
     * 
     * Nome: obterCotacoesDiverg
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adeq/o/ouação ao padrão
     *      hexavision.
     */
    public List<DeParaListaVO> obterCotacoesDiverg(TradeFinanceListaVO listaVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesDiverg | COTACOESDIVERGENTES ------- ");
            
            List<DeParaListaVO> lista = new ArrayList<DeParaListaVO>();
            
            Cotacoesdivergentesrequest request = new Cotacoesdivergentesrequest();
            Cotacoesdivergentesresponse response = new Cotacoesdivergentesresponse();
            
            Npccwyherequest entrada = new Npccwyherequest();
            Npccwyhsresponse saida = new Npccwyhsresponse();
            
            request.setNpccwyherequest(entrada);
            response.setNpccwyhsresponse(saida);
            
            entrada.setEntrada_nbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setEntrada_csitbletoaprov(listaVO.getCsitbletoaprov());
            
            listaSemPaginacao(request, response, "COTACOESDIVERGENTES");
            
            // trata retorno
            this.setMsgRetorno(response.getTexmens());
            
            for (int i = 0; i < response.getNpccwyhsresponse().getSaida_qtdeocorr(); i++) {
                Npccwyhsresponse_saida_listadepara objFrom = response.getNpccwyhsresponse().getSaida_listadepara().get(i);
                DeParaListaVO objTo = new DeParaListaVO();
                
                objTo.setNcampo(objFrom.getSaida_listadepara_ncampo().toUpperCase());
                objTo.setPcampo(objFrom.getSaida_listadepara_pcampo().toUpperCase());
                objTo.setDcampo(objFrom.getSaida_listadepara_dcampo().toUpperCase());
                
                // Indica se há valores diferentes para serem destacados em vermelhos na tela
                if(!objTo.getDcampo().equals(objTo.getPcampo())){
                   objTo.setDiferente(Boolean.TRUE); 
                }
                
                lista.add(objTo);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesDiverg | COTACOESDIVERGENTES ------- ");
        }
    }

    /**
     * 
     * Nome: alterarCustoExterno
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String alterarCustoExterno(String atuaComiss, CustoExternoVO custoExternoVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.alterarCustoExterno | ALTERARCUSTOEXTERNO ------- ");
            
            Alterarcustoexternorequest request = new Alterarcustoexternorequest();
            Alterarcustoexternoresponse response = new Alterarcustoexternoresponse();
            
            Npccwygerequest entrada = new Npccwygerequest();
            Npccwygsresponse saida = new Npccwygsresponse();
            
            request.setNpccwygerequest(entrada);
            response.setNpccwygsresponse(saida);
            
            entrada.setAtuacomiss(atuaComiss);
            entrada.setIorgextercmbio(custoExternoVO.getIorgextercmbio());
            entrada.setNbletonegoccmbio(custoExternoVO.getNbletonegoccmbio());
            entrada.setCsitbletocmbio(custoExternoVO.getCsitbletocmbio());
            entrada.setDlimfndngcmbio(custoExternoVO.getDlimfndngcmbio());
            entrada.setCbanqrcmbiofndng(custoExternoVO.getCbanqrcmbiofndng());
            entrada.setCbanqrcmbiorcdor(custoExternoVO.getCbanqrcmbiorcdor());
            entrada.setPtxfixacmbio(SiteUtil.trocarVirgulaPorPonto(custoExternoVO.getPtxfixacmbio()));
            entrada.setCindcdeconmmoeda(custoExternoVO.getCindcdeconmmoeda());
            entrada.setTmesliborcmbio(custoExternoVO.getTmesliborcmbio());
            entrada.setVtxliborcmbio(SiteUtil.trocarVirgulaPorPonto(custoExternoVO.getVtxliborcmbio()));
            entrada.setObservacao(LineBreaks.formatToMainframe(custoExternoVO.getObservacao()));
            
            entrada.setVlrcomisdsemb(SiteUtil.webMoedaToMainframe(custoExternoVO.getVlrcomisdsemb()));
            entrada.setTdiaopercmbio(custoExternoVO.getTdiaopercmbio());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(custoExternoVO.getVnegocmoedaestrg()));
            entrada.setCprodtservc(custoExternoVO.getCprodtservc());
            
            // FLUXO: NPCCIAQW BOOK: NPCCWYGE/S
            listaSemPaginacao(request, response, "ALTERARCUSTOEXTERNO");
            
            custoExternoVO.setShmanutreg(saida.getShmanutreg());
            
            return response.getTexmens();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.alterarCustoExterno | ALTERARCUSTOEXTERNO ------- ");
        }
    }

    /**
     * 
     * Nome: obterDadosBasicosForFaiting
     * 
     * Propï¿½sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
     *      hexavision.
     */
  public TradeFinanceVO obterDadosBasicosForFaiting(TradeFinanceListaVO listaVO, Integer funcao) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterDadosBasicosForFaiting | DADOSFORFAITING ------- ");
            
            Dadosforfaitingrequest request = new Dadosforfaitingrequest();
            Dadosforfaitingresponse response = new Dadosforfaitingresponse();
            
            Npccwx4erequest entrada = new Npccwx4erequest();
            Npccwx4sresponse saida = new Npccwx4sresponse();
            
            request.setNpccwx4erequest(entrada);
            response.setNpccwx4sresponse(saida);
            
            entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setFuncao(funcao);
            entrada.setCprodtservc(listaVO.getCprodtservc());
            entrada.setCsitbletocmbio(listaVO.getCsitbletocmbio());
            entrada.setCsitbletoaprov(listaVO.getCsitbletoaprov());
            
            if (listaVO.getHinclreghist() == null) {
                
                entrada.setHinclreg(" ");
                
            } else {
                entrada.setHinclreg(listaVO.getHinclreghist());
            }
            
            // executa chamada CWS - Fluxo NPCCIAPJ - Books: NPCCWX4E / NPCCWX4S
            listaSemPaginacao(request, response, "DADOSFORFAITING");
            
            // Recupera menssagem de retorno
            setMsgRetorno(response.getTexmens());
            
            TradeFinanceVO dadosBasicosForfaitingVO = new TradeFinanceVO();
            dadosBasicosForfaitingVO.setRestricoes(new ArrayList<String>());
            dadosBasicosForfaitingVO.setCunicclicmbio(saida.getCunicclicmbio());
            dadosBasicosForfaitingVO.setCunicpssoacmbio(saida.getCunicpssoacmbio());
            dadosBasicosForfaitingVO.setNcunicclicmbio(saida.getNcunicclicmbio());
            dadosBasicosForfaitingVO.setDinclreg(SiteUtil.trocarPontoPorBarra(saida.getDinclreg()));
            dadosBasicosForfaitingVO.setTppessoa(saida.getTppessoa());
            dadosBasicosForfaitingVO.setCpfcnpj(saida.getCpfcnpj());
            dadosBasicosForfaitingVO.setCflial(saida.getCflial());
            dadosBasicosForfaitingVO.setCctrl(saida.getCctrl());
            dadosBasicosForfaitingVO.setNctabcriacmbio(saida.getNctabcriacmbio());
            dadosBasicosForfaitingVO.setCbco(saida.getCbco());
            dadosBasicosForfaitingVO.setNomesocial(saida.getNomesocial());
            dadosBasicosForfaitingVO.setCagbcria(saida.getCagbcria());
            dadosBasicosForfaitingVO.setCctabcriacmbio(Long.bitCount(saida.getCctabcriacmbio()));
            dadosBasicosForfaitingVO.setDigtcctabcria(saida.getDigtcctabcria());
            dadosBasicosForfaitingVO.setCidade(saida.getCidade());
            dadosBasicosForfaitingVO.setEstado(saida.getEstado());
            dadosBasicosForfaitingVO.setCpssoajurid(saida.getCpssoajurid());
            dadosBasicosForfaitingVO.setNsequndorgnz(saida.getNsequndorgnz());
            dadosBasicosForfaitingVO.setNomeundorgnz(saida.getNomeundorgnz());
            dadosBasicosForfaitingVO.setCrting(saida.getCrting());
            dadosBasicosForfaitingVO.setCtposgmtocli(saida.getCtposgmtocli());
            dadosBasicosForfaitingVO.setDtposgmtocli(saida.getDtposgmtocli());
            dadosBasicosForfaitingVO.setCprodtservc(saida.getCprodtservc());
            dadosBasicosForfaitingVO.setDprodtservc(saida.getDprodtservc());
            dadosBasicosForfaitingVO.setCtponegoccmbio(saida.getCtponegoccmbio());
            dadosBasicosForfaitingVO.setCsitbletocmbio(saida.getCsitbletocmbio());
            dadosBasicosForfaitingVO.setDsitbletocmbio(saida.getDsitbletocmbio());
            
            dadosBasicosForfaitingVO.setDanobase(saida.getDanobase());
            dadosBasicosForfaitingVO.setNbletocmbioano(saida.getNbletocmbioano());
            dadosBasicosForfaitingVO.setNbletonegoccmbio(saida.getNbletonegoccmbio());
           
            dadosBasicosForfaitingVO.setDvalddnegoccmbio(SiteUtil.trocarPontoPorBarra(saida.getDvalddnegoccmbio()));
            dadosBasicosForfaitingVO.setCusuarinclt(saida.getCusuarinclt());
            dadosBasicosForfaitingVO.setNusuarinclt(saida.getNusuarinclt());
            dadosBasicosForfaitingVO.setNseqcontrlim(saida.getNseqcontrlim());
            dadosBasicosForfaitingVO.setNppstapontucmbio(saida.getNppstapontucmbio());
            dadosBasicosForfaitingVO.setCindcdeconmmoeda(saida.getCindcdeconmmoeda());
            dadosBasicosForfaitingVO.setSimbleconmmoeda(saida.getSimbleconmmoeda());
            dadosBasicosForfaitingVO.setDescreconmmoeda(saida.getDescreconmmoeda());
            dadosBasicosForfaitingVO.setVnegocmoedaestrg(saida.getVnegocmoedaestrg());
            dadosBasicosForfaitingVO.setCeconmmoedadsemb(saida.getCeconmmoedadsemb());
            dadosBasicosForfaitingVO.setSimbleconmdsemb(saida.getSimbleconmdsemb());
            dadosBasicosForfaitingVO.setDescreconmdsemb(saida.getDescreconmdsemb());
            dadosBasicosForfaitingVO.setCeconmmoedalim(saida.getCeconmmoedalim());
            dadosBasicosForfaitingVO.setSimbleconmlim(saida.getSimbleconmlim());
            dadosBasicosForfaitingVO.setDescreconmlim(saida.getDescreconmlim());
            dadosBasicosForfaitingVO.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(saida.getVmoedalimgerc()));
            dadosBasicosForfaitingVO.setTdiavalddletra(saida.getTdiavalddletra());
            dadosBasicosForfaitingVO.setTdiaopercmbio(saida.getTdiaopercmbio());
            dadosBasicosForfaitingVO.setDbcoextcmbio(saida.getDbcoextcmbio());
            dadosBasicosForfaitingVO.setDcotacfndngcmbio(SiteUtil.trocarPontoPorBarra(saida.getDcotacfndngcmbio()));
            dadosBasicosForfaitingVO.setCindcdeconmlibor(saida.getCindcdeconmlibor());
            dadosBasicosForfaitingVO.setSimbleconmlibor(saida.getSimbleconmlibor());
            dadosBasicosForfaitingVO.setTmesliborcmbio(saida.getTmesliborcmbio());
            dadosBasicosForfaitingVO.setVtxliborcmbio(saida.getVtxliborcmbio());
            dadosBasicosForfaitingVO.setVtxmoracmbio(SiteUtil.trocarPontoPorVirgula(saida.getVtxmoracmbio()));
            dadosBasicosForfaitingVO.setCbasejuromora(saida.getCbasejuromora());
            dadosBasicosForfaitingVO.setVmultanegoccmbio(SiteUtil.trocarPontoPorVirgula(saida.getVmultanegoccmbio()));
            dadosBasicosForfaitingVO.setCmodcontrcmbio(saida.getCmodcontrcmbio());
            dadosBasicosForfaitingVO.setDmodcontrcmbio(saida.getDmodcontrcmbio());
            dadosBasicosForfaitingVO.setCunicpssoacmbiot(saida.getCunicpssoacmbiot());
            dadosBasicosForfaitingVO.setCmovtcincel(saida.getCmovtcincel());
            dadosBasicosForfaitingVO.setCrtinglvgemdnhe(saida.getRrtinglvgemdnhe());
            dadosBasicosForfaitingVO.setPercreentrg(saida.getPercreentrg());
            dadosBasicosForfaitingVO.setPercdientrg(saida.getPercdientrg());
            dadosBasicosForfaitingVO.setCindcdcontrfalt(saida.getCindcdcontrfalt());
            dadosBasicosForfaitingVO.setDabertctacli(saida.getDabertctacli());
            dadosBasicosForfaitingVO.setDfundcnasc(saida.getDfundcnasc());
            dadosBasicosForfaitingVO.setQdiavencdcontr(saida.getQdiavencdcontr());
            dadosBasicosForfaitingVO.setQcontrdoctopend(saida.getQcontrdoctopend());
            dadosBasicosForfaitingVO.setCmodldprodtdesc(saida.getCmodldprodtdesc());
            dadosBasicosForfaitingVO.setCeconmmoedadesc(saida.getCeconmmoedadesc());
            dadosBasicosForfaitingVO.setVlrmoedaestrang(saida.getVlrmoedaestrang());
            dadosBasicosForfaitingVO.setVtxrentbcmbio(saida.getVtxrentbcmbio());
            dadosBasicosForfaitingVO.setTxtinformativo(saida.getTxtinformativo());
            dadosBasicosForfaitingVO.setRinfoenvolmdia(saida.getRinfoenvolmdia());
            dadosBasicosForfaitingVO.setPareceroperador(saida.getPareceroperador());
            dadosBasicosForfaitingVO.setParecerdsn(saida.getParecerdsn());
            dadosBasicosForfaitingVO.getDataPrevEmbarq().setInicio(SiteUtil.
                            dataMainframeToWeb(saida.getDprevtinicembrq()));
            dadosBasicosForfaitingVO.getDataPrevEmbarq().setFim(SiteUtil.
                            dataMainframeToWeb(saida.getDprevtfimembrq()));
            dadosBasicosForfaitingVO.setDprevtfimembrq(SiteUtil.trocarPontoPorBarra(saida.getDprevtfimembrq()));
            dadosBasicosForfaitingVO.setDprevtgarntexpdi(SiteUtil.trocarPontoPorBarra(saida.getDprevtgarntexpdi()));
            dadosBasicosForfaitingVO.getDataPrevDesemb().setInicio(SiteUtil.
                            dataMainframeToWeb(saida.getDabertcntragarnt()));
            dadosBasicosForfaitingVO.setDabertcntragarnt(SiteUtil.dataMainframeToWeb(saida.getDabertcntragarnt()));
            dadosBasicosForfaitingVO.getDataPrevDesemb().setFim(SiteUtil.
                            dataMainframeToWeb(saida.getDvctocntragarnt()));
            dadosBasicosForfaitingVO.setDvctocntragarnt(SiteUtil.dataMainframeToWeb(saida.getDvctocntragarnt()));
            dadosBasicosForfaitingVO.setTdiacmbioprcf(saida.getTdiacmbioprcf());
            dadosBasicosForfaitingVO.setDlimfndngcmbio(SiteUtil.trocarPontoPorBarra(saida.getDlimfndngcmbio()));
            dadosBasicosForfaitingVO.setCustototal(saida.getCustototal());
            dadosBasicosForfaitingVO.setValorjuros(saida.getValorjuros());
            dadosBasicosForfaitingVO.setValorsaque(saida.getValorsaque());
            dadosBasicosForfaitingVO.setTaxajuros(saida.getTaxajuros());
            dadosBasicosForfaitingVO.setTaxadescontada(saida.getTaxadescontada());
            dadosBasicosForfaitingVO.setNcunicpsoacmbiot(saida.getNcunicpsoacmbiot());
            dadosBasicosForfaitingVO.setCcobrcomisadcio(saida.getCcobrcomisadcio());
            dadosBasicosForfaitingVO.setPcobervarprodt(SiteUtil.trocarPontoPorVirgula(saida.getPcobervarprodt()));
            dadosBasicosForfaitingVO.setRclasfexportentrg(saida.getRclasfexportentrg());
            dadosBasicosForfaitingVO.setRclasfimportentrg(saida.getRclasfimportentrg());
            dadosBasicosForfaitingVO.setCprodtdesc(saida.getCprodtdesc());
            dadosBasicosForfaitingVO.setDtcotacao(SiteUtil.trocarPontoPorBarra(saida.getDinclreg()));
            dadosBasicosForfaitingVO.setCtpojurotrade(saida.getCtpojurotrade());
            dadosBasicosForfaitingVO.setCmodldprodtcmbio(saida.getCmodldprodtcmbio());
            dadosBasicosForfaitingVO.setCmodldprodtdesc(saida.getCmodldprodtdesc());
            dadosBasicosForfaitingVO.setDfchtobletodesc(saida.getDfchtobletodesc());
            dadosBasicosForfaitingVO.setInddqmto(saida.getInddqmto());
            dadosBasicosForfaitingVO.setVtxspreadaprov(SiteUtil.trocarPontoPorVirgula(saida.getVtxspreadaprov()));
            dadosBasicosForfaitingVO.setVtxspreadnegoc(SiteUtil.trocarPontoPorVirgula(saida.getVtxspreadnegoc()));
            dadosBasicosForfaitingVO.setCbanqrcmbiofndng(saida.getCbanqrcmbiofndng());
            dadosBasicosForfaitingVO.setCpfCnpjFormatado(CadastroNacionalPessoa.format(dadosBasicosForfaitingVO.getCpfcnpj(),
                            dadosBasicosForfaitingVO.getCflial(), dadosBasicosForfaitingVO.getCctrl()));
            dadosBasicosForfaitingVO.setCctabcriaclicmbio(saida.getCctabcriacmbio());
            dadosBasicosForfaitingVO.setDmodldprodtcmbio(saida.getDmodldprodtcmbio());
            dadosBasicosForfaitingVO.setNcotacao(saida.getNbletocmbioano().toString());
            dadosBasicosForfaitingVO.setDprevtinicembrq(SiteUtil.trocarPontoPorBarra(saida.getDprevtinicembrq()));
            dadosBasicosForfaitingVO.setNcunicpssoacmbiot(saida.getNcunicpsoacmbiot());
            dadosBasicosForfaitingVO.setPcobervarprodt(SiteUtil.trocarPontoPorVirgula(saida.getPcobervarprodt()));
            dadosBasicosForfaitingVO.setTdiaopercmbioprcf(saida.getTdiacmbioprcf());
            dadosBasicosForfaitingVO.setPtxfixacmbio(SiteUtil.trocarPontoPorVirgula(saida.getPtxfixacmbio()));
            dadosBasicosForfaitingVO.setVtravaliborcmbio(SiteUtil.trocarPontoPorVirgula(saida.getVtravaliborcmbio()));
            dadosBasicosForfaitingVO.setNomecompletocli(saida.getNomecompletocli());
            dadosBasicosForfaitingVO.setDfchtobletocmbio(saida.getDfchtobletocmbio());
            dadosBasicosForfaitingVO.setDlimembrqcmbio(saida.getDlimembrqcmbio());
            dadosBasicosForfaitingVO.setPraca(saida.getPraca());
            dadosBasicosForfaitingVO.setDescctotal(SiteUtil.trocarUnderlinePorMais((saida.getDescctotal())));
            dadosBasicosForfaitingVO.setCindcdcartaidpdt(saida.getCindcdcartaidpdt());
            dadosBasicosForfaitingVO.setCsitbletoaprov(saida.getCsitbletoaprov());
            
            dadosBasicosForfaitingVO.setDescjurobleto(saida.getDescjurobleto());
            dadosBasicosForfaitingVO.setComissaodsemblso(saida.getComissaodsemblso());
            dadosBasicosForfaitingVO.setVlrcomisdsemb(SiteUtil.trocarPontoPorVirgula(saida.getVlrcomisdsemb()));
            dadosBasicosForfaitingVO.setVtxspreadtot(SiteUtil.trocarPontoPorVirgula(saida.getVtxspreadtot()));
            dadosBasicosForfaitingVO.setCbanqrcmbiorcdor(saida.getCbanqrcmbiorcdor());
            dadosBasicosForfaitingVO.setDbcorecebedor(saida.getDbcoreembolsador());
            
            EnumTipoCotacao tipoCotacao = EnumTipoCotacao.fromCode(dadosBasicosForfaitingVO.getCtponegoccmbio());
            if(!tipoCotacao.equals(EnumTipoCotacao.DEFAULT)) {
                dadosBasicosForfaitingVO.setDescrctc(tipoCotacao.getDescricao().substring(8).trim());                
            }
            
            // Lista de parcelas de Funding
            for (int i = 0; i < saida.getQtdepcelas(); i++) {
                
                Npccwx4sresponse_pcelasfndng objFrom = saida.getPcelasfndng().get(i);
                FundingVO fundingVO = new FundingVO();
                fundingVO.setcexterreftfndng(objFrom.getPcelasfndng_cexterreftfndng());
                fundingVO.setcindcdeconmmoeda(objFrom.getPcelasfndng_cindcdmoedafndg());
                fundingVO.setvpcelafndngcmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getPcelasfndng_vpcelafndngcmbio()));
                fundingVO.setdescreconmmoeda(objFrom.getPcelasfndng_deseconmmoedafndg());
                
                dadosBasicosForfaitingVO.getPcelasfndng().add(fundingVO);
            }

            // Lista de restricoes
            for (int i = 0; i < saida.getQtderest(); i++) {
                
                Npccwx4sresponse_restricoes objFrom = saida.getRestricoes().get(i);
                String descricao = objFrom.getRestricoes_crestcli() + " - " + objFrom.getRestricoes_rrestcli();
                
                dadosBasicosForfaitingVO.getRestricoes().add(descricao);
            }
            
            return dadosBasicosForfaitingVO;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterDadosBasicosForFaiting | DADOSFORFAITING ------- ");
        }
    }
          
    /**
     * Nome: obterDesembolsoForFaiting
     * 
     * PropÃ³sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de ManutenÃ§Ã£o: 29/04/2016 - Autor: BRQ - Responsavel: Equipe Web - AdequaÃ§Ã£o ao padrÃ£o
     *      hexavision.
     */
    public void obterDesembolsoForFaiting(TradeFinanceListaVO listaVO, TradeFinanceVO dadosBasicosForfaitingVO, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterDesembolsoForFaiting | COMISSAOFORFAITING ------- ");
            
            Comissaoforfaitingrequest request = new Comissaoforfaitingrequest();
            Comissaoforfaitingresponse response = new Comissaoforfaitingresponse();
            
            List<TradeFinanceDesembolsoVO> lista = new ArrayList<TradeFinanceDesembolsoVO>();
            Npccwyoerequest entrada = new Npccwyoerequest();
            Npccwyosresponse saida = new Npccwyosresponse();
            
            request.setNpccwyoerequest(entrada);
            response.setNpccwyosresponse(saida);
            
            entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setHinclreg(hinclreghist);
         
            
            // executa chamada CWS - Fluxo NPCCIATR - Books: NPCCWYOE / NPCCWYOS
            listaSemPaginacao(request, response, "COMISSAOFORFAITING");
            
            // Recupera menssagem de retorno
            setMsgRetorno(response.getTexmens());
            
            dadosBasicosForfaitingVO.setSvaloradsemb(response.getNpccwyosresponse().getSvaloradsemb());
            
            // Lista desembolso
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwyosresponse_lista objFrom = response.getNpccwyosresponse().getLista().get(i);
                
                TradeFinanceDesembolsoVO objTo = new TradeFinanceDesembolsoVO();
                
                objTo.setDprevtdsembcmbio(SiteUtil.dataMainframeToWeb(objFrom.getLista_dprevtdsembcmbio()));
                objTo.setVprevtdsembcmbio(objFrom.getLista_vprevtdsembcmbio());
                objTo.setVtxliborcmbio(objFrom.getLista_vtxliborcmbio());
                objTo.setPtxjurofndng(objFrom.getLista_ptxjurofndng());
                objTo.setPspreadtxcmbio(objFrom.getLista_pspreadtxcmbio());
                objTo.setPjuronegoccmbio(SiteUtil.trocarPontoPorVirgula(objFrom.getLista_pjuronegoccmbio()));
                objTo.setTdiafinandsemb(objFrom.getLista_tdiafinandsemb());
                objTo.setVjurodsembcmbio(objFrom.getLista_vjurodsembcmbio());
                objTo.setVdsembnegoccmbio(objFrom.getLista_vdsembnegoccmbio());
                
                lista.add(objTo);
                
            }
            dadosBasicosForfaitingVO.setListaDesembolso(lista);
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterDesembolsoForFaiting | COMISSAOFORFAITING ------- ");
        }
    }

    /**
     * 
     * Nome: listaDataDesembolso
     * 
     * Propósito: Retorna uma lista de desembolsos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<DataDesembolsoVO> listaDataDesembolso(Long nbletonegoccmbio) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.listaDataDesembolso | COMBODATADESEMBOLSO ------- ");
            
            List<DataDesembolsoVO> lista = new ArrayList<DataDesembolsoVO>();
            
            Combodatadesembolsorequest request = new Combodatadesembolsorequest();
            Combodatadesembolsoresponse response = new Combodatadesembolsoresponse();
            
            Npccwx7erequest entrada = new Npccwx7erequest();
            Npccwx7sresponse saida = new Npccwx7sresponse();
            
            request.setNpccwx7erequest(entrada);
            response.setNpccwx7sresponse(saida);
            
            entrada.setNbletonegoccmbio(nbletonegoccmbio);
            
            listaSemPaginacao(request, response, "COMBODATADESEMBOLSO");
            
            for (int i = 0; i < response.getNpccwx7sresponse().getQtdeocorr(); i++) {
                Npccwx7sresponse_listadtdsemb objFrom = response.getNpccwx7sresponse().getListadtdsemb().get(i);
                DataDesembolsoVO objTo = new DataDesembolsoVO();
                
                objTo.setNdsembcmbiotrade(objFrom.getListadtdsemb_ndsembcmbiotrade());
                objTo.setDprevtdsembcmbio(SiteUtil.trocarPontoPorBarra(objFrom.getListadtdsemb_dprevtdsembcmbio()));
                objTo.setTdiafinandsemb(objFrom.getListadtdsemb_tdiafinandsemb());
                objTo.setVprevtdsembcmbio(objFrom.getListadtdsemb_vprevtdsembcmbio());
                
                lista.add(objTo);
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.listaDataDesembolso | COMBODATADESEMBOLSO ------- ");
        }
    }

    /**
     * 
     * Nome: obterProrrogacaoPrevisaoDesembolso
     * 
     * Propósito: Obter data de previsão do desembolso
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/05/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String obterProrrogacaoPrevisaoDesembolso(Long nBleto, Integer ndsemb, Integer caditv) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterProrrogacaoPrevisaoDesembolso | PREVISAOPRORROGACAO ------- ");
            
            Previsaoprorrogacaorequest request = new Previsaoprorrogacaorequest();
            Previsaoprorrogacaoresponse response = new Previsaoprorrogacaoresponse();
            Npccwx9erequest entrada = new Npccwx9erequest();
            Npccwx9sresponse saida = new Npccwx9sresponse();
            
            request.setNpccwx9erequest(entrada);
            response.setNpccwx9sresponse(saida);
            
            entrada.setNbletonegoccmbio(nBleto);
            entrada.setNdsembcmbiotrade(ndsemb);
            entrada.setCaditvbletocmbio(caditv);
            
            // FLUXO: NPCCIAPO BOOK: Npccwx9E/S
            listaSemPaginacao(request, response, "PREVISAOPRORROGACAO");
            
            return SiteUtil.trocarPontoPorBarra(saida.getSaida_dprevtprorrog());
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterProrrogacaoPrevisaoDesembolso | PREVISAOPRORROGACAO ------- ");
        }
    }

    /**
     * 
     * Nome: incluirProrrogacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirProrrogacao(TrdFinNegocInclVO negocInclVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.incluirProrrogacao | INCLUIRPRORROGACAO ------- ");
            
            Incluirprorrogacaorequest request = new Incluirprorrogacaorequest();
            Incluirprorrogacaoresponse response = new Incluirprorrogacaoresponse();
            Npccww5erequest entrada = new Npccww5erequest();
            Npccww5sresponse saida = new Npccww5sresponse();
            
            request.setNpccww5erequest(entrada);
            response.setNpccww5sresponse(saida);
            
            entrada.setNbletonegoccmbio(negocInclVO.getNbletonegoccmbio());
            entrada.setDanobase(negocInclVO.getDanobase());
            entrada.setNbletocmbioano(negocInclVO.getNbletocmbioano());
            entrada.setCaditvbletocmbio(negocInclVO.getCaditvbletocmbio());
            entrada.setDfchtobletocmbio(negocInclVO.getDfchtobletocmbio());
            entrada.setCunicclicmbio(negocInclVO.getCunicclicmbio());
            entrada.setCprodtservc(negocInclVO.getCprodtservc());
            entrada.setCmodldprodtcmbio(negocInclVO.getCmodldprodtcmbio());
            entrada.setCpssoajurid(negocInclVO.getCpssoajurid());
            entrada.setNsequndorgnz(negocInclVO.getNsequndorgnz());
            entrada.setCindcdeconmmoeda(negocInclVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(SiteUtil.formatarPontosVirgula(negocInclVO.getVnegocmoedaestrg()));
            entrada.setCtposgmtocli(negocInclVO.getCtposgmtocli());
            entrada.setNseqcontrlim(negocInclVO.getNseqcontrlim());
            entrada.setCpssoaanlsecredt(negocInclVO.getCpssoaanlsecredt());
            entrada.setDanosoltcanlse(negocInclVO.getDanosoltcanlse());
            entrada.setNsoltcanlsecredt(negocInclVO.getNsoltcanlsecredt());
            entrada.setNseqsoltcanlse(negocInclVO.getNseqsoltcanlse());
            entrada.setCeconmmoedalim(negocInclVO.getCeconmmoedalim());
            entrada.setCsitbletocmbio(negocInclVO.getCsitbletocmbio());
            entrada.setCrting(negocInclVO.getCrting());
            entrada.setCeconmmoedadsemb(negocInclVO.getCeconmmoedadsemb());
            entrada.setNctabcriacmbio(negocInclVO.getNctabcriacmbio());
            entrada.setCmodcontrcmbio(negocInclVO.getCmodcontrcmbio());
            entrada.setTdiaopercmbio(negocInclVO.getTdiaopercmbio());
            entrada.setTdiavalddletra(negocInclVO.getTdiavalddletra());
            entrada.setQprzmedcmbio(negocInclVO.getQprzmedcmbio());
            entrada.setDvalddnegoccmbio(negocInclVO.getDvalddnegoccmbio());
            entrada.setCindcdnegocswap(negocInclVO.getCindcdnegocswap());
            entrada.setCnegocswapfluxo(negocInclVO.isCnegocswapfluxo() ? "1" : "2");
            entrada.setCnegocswapestrg(negocInclVO.isCnegocswapestrg() ? "1" : "2");
            entrada.setCindcdnegoccarta(negocInclVO.getCindcdnegoccarta());
            entrada.setCcomiscartanacio(negocInclVO.getCcomiscartanacio());
            entrada.setCindcdnegocarbtr(negocInclVO.getCindcdnegocarbtr());
            entrada.setCsegurtrnspmcado(negocInclVO.getCsegurtrnspmcado());
            entrada.setCsegurmcadoorgnz(negocInclVO.getCsegurmcadoorgnz());
            entrada.setCindcdnegoclibor(negocInclVO.isCindcdnegoclibor() ? "1" : "2");
            entrada.setCtpocotactx(negocInclVO.getCtpocotactx());
            entrada.setCtponegoccmbio(negocInclVO.getCtponegoccmbio());
            entrada.setVmoedalimgerc(SiteUtil.formatarPontosVirgula(negocInclVO.getVmoedalimgerc()));
            entrada.setVtxspreadnegoc(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getVtxspreadnegoc()));
            entrada.setVtravaliborcmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getVtravaliborcmbio()));
            entrada.setPtxswapcmpdo(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getPtxswapcmpdo()));
            entrada.setVimpstnegoccmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getVimpstnegoccmbio()));
            entrada.setVmultanegoccmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getVmultanegoccmbio()));
            entrada.setViofnegoccmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getViofnegoccmbio()));
            entrada.setVtxmoracmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getVtxmoracmbio()));
            entrada.setNppstapontucmbio(negocInclVO.getNppstapontucmbio());
            entrada.setDprevtdsembcmbio(negocInclVO.getDprevtdsembcmbio());
            entrada.setRjustfdqmto(negocInclVO.getRjustfdqmto());
            
            entrada.setCindcdtipoacces(negocInclVO.getCindcdtipoacces());
            
            entrada.setPcdimaiscmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getPcdimaiscmbio()));
            entrada.setPtxcdifinan(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getPtxcdifinan()));
            entrada.setPfixajurocmbio(SiteUtil.trocarVirgulaPorPonto(negocInclVO.getPfixajurocmbio()));
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(negocInclVO.getVtxspreadtot()));
            
            // FLUXO: NPCCIAP7 BOOK: NPCCWW5E/S
            listaSemPaginacao(request, response, "INCLUIRPRORROGACAO");
            
            negocInclVO.setMsgRetorno(response.getTexmens());
            
            negocInclVO.setNbletonegoccmbio(response.getNpccww5sresponse().getSaida_nbletonegoccmbio());
            negocInclVO.setHinclreg(response.getNpccww5sresponse().getSaida_hinclreg());
            negocInclVO.setNbletocmbioano(response.getNpccww5sresponse().getSaida_nbletocmbioano());
            negocInclVO.setDanobase(response.getNpccww5sresponse().getSaida_danobase());
            
            return negocInclVO;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.incluirProrrogacao | INCLUIRPRORROGACAO ------- ");
        }
    }
    
    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Propósito: Obter dados complemento dos dados básicos
     *
     * @param : TradeFinanceListaVO listaVO
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO) {
        return obterDadosBasicosCompl(listaVO, "");
    }

    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Propósito: Obter dados complemento dos dados básicos
     *
     * @param : TradeFinanceListaVO listaVO
     *          String hinclreghist - Parametro utilizado apenas na consulta de log
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO, String hinclreghist) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterDadosBasicosCompl | CONSULTARCOTACAO ------- ");
            
            Consultarcotacaorequest request = new Consultarcotacaorequest();
            Consultarcotacaoresponse response = new Consultarcotacaoresponse();
            
            Npccwxaerequest entrada = new Npccwxaerequest();
            Npccwxasresponse saida = new Npccwxasresponse();
            
            request.setNpccwxaerequest(entrada);
            response.setNpccwxasresponse(saida);
            
            entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setHinclreghist(hinclreghist);
            
            // FLUXO: NPCCIAPP BOOK: NPCCWXAE/S
            listaSemPaginacao(request, response, "CONSULTARCOTACAO");
            
            setMsgRetorno(response.getTexmens());
            
            ObservacoesCotacaoVO dadosBasicosVO = new ObservacoesCotacaoVO();
            
            List<ListaRebateVO> listaRebate = new ArrayList<ListaRebateVO>();
            
            List<ListaTaxaDescontoVO> listaTaxa = new ArrayList<ListaTaxaDescontoVO>();
            
            dadosBasicosVO.setNomerof(saida.getNomerof());
            dadosBasicosVO.setTelrof(saida.getTelrof());
            dadosBasicosVO.setCpfrof(saida.getCpfrof());
            dadosBasicosVO.setCargorof(saida.getCargorof());
            dadosBasicosVO.setEmailrof(saida.getEmailrof());
            dadosBasicosVO.setObservacao1(LineBreaks.formatMainFrameToWeb(saida.getObservacao1()));
            dadosBasicosVO.setObservacao2(LineBreaks.formatMainFrameToWeb(saida.getObservacao2()));
            dadosBasicosVO.setObservacao3(LineBreaks.formatMainFrameToWeb(saida.getObservacao3()));
            dadosBasicosVO.setObservacao4(LineBreaks.formatMainFrameToWeb(saida.getObservacao4()));
            dadosBasicosVO.setObservacao5(LineBreaks.formatMainFrameToWeb(saida.getObservacao5()));
            dadosBasicosVO.setObservacao6(LineBreaks.formatMainFrameToWeb(saida.getObservacao6()));
            dadosBasicosVO.setObservacao7(LineBreaks.formatMainFrameToWeb(saida.getObservacao7()));
            dadosBasicosVO.setObservacao8(LineBreaks.formatMainFrameToWeb(saida.getObservacao8()));
            dadosBasicosVO.setObservacao9(LineBreaks.formatMainFrameToWeb(saida.getObservacao9()));
            dadosBasicosVO.setObservacao10(LineBreaks.formatMainFrameToWeb(saida.getObservacao10()));
            dadosBasicosVO.setOutrasespcs(LineBreaks.formatMainFrameToWeb(saida.getOutrasespcs()));
            dadosBasicosVO.setDivergente(saida.getDivergente());
            dadosBasicosVO.setNomecttclicmbio(saida.getNomecttclicmbio());
            dadosBasicosVO.setTelcttclicmbio(saida.getTelcttclicmbio());
            dadosBasicosVO.setDespconf(saida.getDespconf());
            dadosBasicosVO.setDespdesc(saida.getDespdesc());
            dadosBasicosVO.setFormamor(saida.getFormamor());
            dadosBasicosVO.setGarantias(saida.getGarantias());
            dadosBasicosVO.setAmortizar(saida.getAmortizar());
            dadosBasicosVO.setPagajuro(saida.getPagajuro());
            dadosBasicosVO.setPartbnds(saida.getPartbnds());
            dadosBasicosVO.setOrcamento(LineBreaks.formatMainFrameToWeb(saida.getOrcamento()));
            dadosBasicosVO.setGaranbnds(saida.getGaranbnds());
            dadosBasicosVO.setGaranbrad(saida.getGaranbrad());
            dadosBasicosVO.setTxapre(saida.getTxapre());
            dadosBasicosVO.setCustfin(saida.getCustfin());
            dadosBasicosVO.setMercadoria(saida.getMercadoria());
            dadosBasicosVO.setDadosnome(saida.getDadosnome());
            
            dadosBasicosVO.setDadoscpfcnpjr(saida.getDadoscpfcnpjr());
            dadosBasicosVO.setDadoscpfcnpjf(saida.getDadoscpfcnpjf());
            dadosBasicosVO.setDadoscpfcnpjd(saida.getDadoscpfcnpjd());
            
            dadosBasicosVO.setDadoscpfcnpj(CadastroNacionalPessoa.format(saida.getDadoscpfcnpjr(),
                    saida.getDadoscpfcnpjf(), saida.getDadoscpfcnpjd()));
            
            dadosBasicosVO.setDadosender(saida.getDadosender());
            dadosBasicosVO.setDadosident(saida.getDadosident());
            dadosBasicosVO.setDadosorgao(saida.getDadosorgao());
            dadosBasicosVO.setDadosestci(saida.getDadosestci());
            dadosBasicosVO.setDadosregci(saida.getDadosregci());
            dadosBasicosVO.setCargonome(saida.getCargonome());
            dadosBasicosVO.setCargoemail(saida.getCargoemail());
            dadosBasicosVO.setGarangarant(saida.getGarangarant());
            dadosBasicosVO.setGaranimport(saida.getGaranimport());
            dadosBasicosVO.setGarancondbgar(saida.getGarancondbgar());
            dadosBasicosVO.setGarancondbman(saida.getGarancondbman());
            dadosBasicosVO.setGarancondagfi(saida.getGarancondagfi());
            dadosBasicosVO.setDoctoconsig(saida.getDoctoconsig());
            dadosBasicosVO.setFormapagto(saida.getFormapagto());
            dadosBasicosVO.setFinalidade(saida.getFinalidade());
            dadosBasicosVO.setRetirnome(saida.getRetirada_retirnome());
            dadosBasicosVO.setRetircidade(saida.getRetirada_retircidade());
            dadosBasicosVO.setRetirender(saida.getRetirada_retirender());
            dadosBasicosVO.setRetirtele(saida.getRetirada_retirtele());        
            dadosBasicosVO.setRetiremail(saida.getRetirada_retiremail());
            
            
            // Lista REBATE
            for (int i = 0; i < saida.getQtdocrebt(); i++) {
                
                Npccwxasresponse_lstrbt objFrom = saida.getLstrbt().get(i);
                
                ListaRebateVO rebate = new ListaRebateVO();
                rebate.setRebate(LineBreaks.formatToWeb(objFrom.getLstrbt_rebate()));
                
                listaRebate.add(rebate);
            }
            
            // Lista TAXA DE DESCONTO
            for (int i = 0; i < saida.getQtdoctxde(); i++) {
                
                Npccwxasresponse_lsttde objFrom = saida.getLsttde().get(i);
                
                ListaTaxaDescontoVO taxa = new ListaTaxaDescontoVO();
                taxa.setTxades(LineBreaks.formatToWeb(objFrom.getLsttde_txades()));
                
                listaTaxa.add(taxa);
            }
            
            dadosBasicosVO.setListaRebate(listaRebate);
            dadosBasicosVO.setListaTaxa(listaTaxa);
            
            return dadosBasicosVO;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterDadosBasicosCompl | CONSULTARCOTACAO ------- ");
        }

    }

    @Override
    public CotacoesExternasVO obterCotacoesExternas(Long numBoleto, String hmanut, Integer cindcdaprovbanq) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesExternas | COTACOESEXTERNAS ------- ");
            
            Cotacoesexternasrequest request = new Cotacoesexternasrequest();
            Cotacoesexternasresponse response = new Cotacoesexternasresponse();
            
            Npccwyderequest entrada = new Npccwyderequest();
            Npccwydsresponse saida = new Npccwydsresponse();
            
            request.setNpccwyderequest(entrada);
            response.setNpccwydsresponse(saida);
            
            entrada.setNbletonegoccmbio(numBoleto);
            entrada.setHmanutreg(hmanut);
            entrada.setCindcdaprovbanq(cindcdaprovbanq);
            
            // FLUXO: NPCCIAQ1 BOOK: NPCCWYDE/S
            listaSemPaginacao(request, response, "COTACOESEXTERNAS");
            
            setMsgRetorno(response.getTexmens());
            
            CotacoesExternasVO ctcExt = new CotacoesExternasVO();
            List<ListaCotacoesExternasVO> listaCtcExt = new ArrayList<ListaCotacoesExternasVO>();
            
            ctcExt.setCusuariosess(saida.getCusuariosess());
            ctcExt.setNusuariosess(saida.getNusuariosess());
            
            // LISTA COTAÇOES EXTERNAS
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwydsresponse_listacontac objFrom = saida.getListacontac().get(i);
                
                ListaCotacoesExternasVO lista = new ListaCotacoesExternasVO();
                
                lista.setCbanqrcmbioaviso(objFrom.getListacontac_cbanqrcmbioaviso());
                lista.setCbanqrcmbiofndng(objFrom.getListacontac_cbanqrcmbiofndng());
                lista.setCbanqrcmbiorcdor(objFrom.getListacontac_cbanqrcmbiorcdor());
                lista.setCfndng(objFrom.getListacontac_cfndng());
                lista.setCindcdfndngutlzd(objFrom.getListacontac_cindcdfndngutlzd());
                lista.setCusuarmanut(objFrom.getListacontac_cusuarmanut());
                lista.setDcotacfndngcmbio(SiteUtil.trocarPontoPorBarra(objFrom.getListacontac_dcotacfndngcmbio()));
                lista.setDlimfndngcmbio(SiteUtil.trocarPontoPorBarra(objFrom.getListacontac_dlimfndngcmbio()));
                lista.setNbanqrcmbioaviso(objFrom.getListacontac_nbanqrcmbioaviso());
                lista.setNbanqrcmbiofndng(objFrom.getListacontac_nbanqrcmbiofndng());
                lista.setNbanqrcmbiorcdor(objFrom.getListacontac_nbanqrcmbiorcdor());
                lista.setNindcdfndngutlzd(objFrom.getListacontac_nindcdfndngutlzd());
                lista.setNusuarmanut(objFrom.getListacontac_nusuarmanut());
                lista.setPracacmbioaviso(objFrom.getListacontac_pracacmbioaviso());
                lista.setPracacmbiofndmg(objFrom.getListacontac_pracacmbiofndng());
                lista.setPracacmbiorcdor(objFrom.getListacontac_pracacmbiorcdor());
                
                listaCtcExt.add(lista);
            }
            
            ctcExt.setListaCotacoes(listaCtcExt);
            
            
            return ctcExt;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesExternas | COTACOESEXTERNAS ------- ");
        }
    }

    @Override
    public List<ListaDespesasVO> obterDespesas(Long codFunding, Long numBoleto, String hmanut) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterDespesas | LISTADESPESAS ------- ");
            
            Listadespesasrequest request = new Listadespesasrequest();
            Listadespesasresponse response = new Listadespesasresponse();
            
            Npccwyberequest entrada = new Npccwyberequest();
            Npccwybsresponse saida = new Npccwybsresponse();
            
            request.setNpccwyberequest(entrada);
            response.setNpccwybsresponse(saida);
            
            entrada.setCfndng(codFunding);
            entrada.setNbletonegoccmbio(numBoleto);
            entrada.setHmanutreg(hmanut);
            
            // FLUXO: NPCCIAPB BOOK: NPCCWYBE/S
            listaSemPaginacao(request, response, "LISTADESPESAS");
            
            setMsgRetorno(response.getTexmens());
            
            List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
            
            // LISTA COTAÇOES EXTERNAS
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwybsresponse_listadesp objFrom = saida.getListadesp().get(i);
                
                ListaDespesasVO despesas = new ListaDespesasVO();
                
                despesas.setCbasebletonegoc(objFrom.getListadesp_cbasebletonegoc());
                despesas.setCfluxoperdccmbio(objFrom.getListadesp_cfluxoperdccmbio());
                despesas.setCformacobrdesp(objFrom.getListadesp_cformacobrdesp());
                despesas.setCidtfdrespdesp(objFrom.getListadesp_cidtfdrespdesp());
                despesas.setCindcdeconmmoeda(objFrom.getListadesp_cindcdeconmmoeda());
                despesas.setCtpodespcmbio(objFrom.getListadesp_ctpodespcmbio());
                despesas.setNbasebletonegoc(objFrom.getListadesp_nbasebletonegoc());
                despesas.setNdespbletocmbio(objFrom.getListadesp_ndespbletocmbio());
                despesas.setNfluxoperdccmbio(objFrom.getListadesp_nfluxoperdccmbio());
                despesas.setNformacobrdesp(objFrom.getListadesp_nformacobrdesp());
                despesas.setNidtfdrespdesp(objFrom.getListadesp_nidtfdrespdesp());
                despesas.setNindcdeconmmoeda(objFrom.getListadesp_nindcdeconmmoeda());
                despesas.setNtpodespcmbio(objFrom.getListadesp_ntpodespcmbio());
                despesas.setPdespnegoccmbio(objFrom.getListadesp_pdespnegoccmbio());
                despesas.setVdespbletocmbio(objFrom.getListadesp_vdespbletocmbio());
                despesas.setVmindespcmbio(objFrom.getListadesp_vmindespcmbio());
                
                listaDespesas.add(despesas);
                
            }
            return listaDespesas;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterDespesas | LISTADESPESAS ------- ");
        }
    }

    @Override
    public List<ListaParcelasDesembolsoVO> obterParcelasDesembolso(TradeFinanceListaVO listaVO, String hmanut) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterParcelasDesembolso | PARCELASDESEMBOLSO ------- ");
            
            List<ListaParcelasDesembolsoVO> lista = new ArrayList<ListaParcelasDesembolsoVO>();
            
            Parcelasdesembolsorequest request = new Parcelasdesembolsorequest();
            Parcelasdesembolsoresponse response = new Parcelasdesembolsoresponse();
            
            Npccwzferequest entrada = new Npccwzferequest();
            Npccwzfsresponse saida = new Npccwzfsresponse();
            
            request.setNpccwzferequest(entrada);
            response.setNpccwzfsresponse(saida);
            
            entrada.setNbletonegoccmbio(listaVO.getNbletonegoccmbio());
            entrada.setHmanutreg(hmanut);
            
            // FLUXO: NPCCIAQ8 BOOK: NPCCWZFE/S
            listaSemPaginacao(request, response, "PARCELASDESEMBOLSO");
            
            setMsgRetorno(response.getTexmens());
            
            // LISTA COTAÇOES EXTERNAS
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwzfsresponse_listaparce objFrom = saida.getListaparce().get(i);
                
                ListaParcelasDesembolsoVO parcela = new ListaParcelasDesembolsoVO();
                
                parcela.setCprzpcelacarta(objFrom.getListaparce_cprzpcelacarta());
                parcela.setNpceladsembcarta(objFrom.getListaparce_npceladsembcarta());
                parcela.setNprzpcelacarta(objFrom.getListaparce_nprzpcelacarta());
                parcela.setTdiapgtocarta(objFrom.getListaparce_tdiapgtocarta());
                parcela.setVpcelacartaprevt(SiteUtil.trocarPontoPorVirgula(objFrom.getListaparce_vpcelacartaprevt()));
                parcela.setVpcelacreditprevt(objFrom.getListaparce_vpcelacreditprevt());
                
                lista.add(parcela);
                
            }
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterParcelasDesembolso | PARCELASDESEMBOLSO ------- ");
        }

    }

    @Override
    public ResponsavelDespesaVO obterResponsavelDespesas(Long numBleto, String hmanut, Integer cindcdaprovbanq) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterResponsavelDespesas | RESPONSAVELDESPESAS ------- ");
            
            Responsaveldespesasrequest request = new Responsaveldespesasrequest();
            Responsaveldespesasresponse response = new Responsaveldespesasresponse();
            
            Npccwyaerequest entrada = new Npccwyaerequest();
            Npccwyasresponse saida = new Npccwyasresponse();
            
            request.setNpccwyaerequest(entrada);
            response.setNpccwyasresponse(saida);
            
            entrada.setNbletonegoccmbio(numBleto);
            entrada.setHmanutreg(hmanut);
            entrada.setCindcdaprovbanq(cindcdaprovbanq);
            
            // FLUXO: NPCCIAPA BOOK: NPCCWYAE/S
            listaSemPaginacao(request, response, "RESPONSAVELDESPESAS");
            
            setMsgRetorno(response.getTexmens());
            
            List<ListaResponsavelDespesaVO> list = new ArrayList<ListaResponsavelDespesaVO>();
            ResponsavelDespesaVO despesas = new ResponsavelDespesaVO();
            
            despesas.setDlimfndngcmbio(SiteUtil.trocarPontoPorBarra(saida.getDlimfndngcmbio()));
            despesas.setCunicpssoacmbio(saida.getCunicpssoacmbio());
            despesas.setCunicpssoadesc(saida.getCunicpssoadesc());
            despesas.setCunicpssoabnf(saida.getCunicpssoabnf());
            despesas.setCunicpssoaafi(saida.getCunicpssoaafi());
            despesas.setCunicpssoaimun(saida.getCunicpssoaimun());
            
            
            // LISTA COTAÇOES EXTERNAS
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                Npccwyasresponse_listaresp objFrom = saida.getListaresp().get(i);
                
                ListaResponsavelDespesaVO saidaList = new  ListaResponsavelDespesaVO();
                
                saidaList.setCbanqrcmbio(objFrom.getListaresp_cbanqrcmbio());
                saidaList.setCidbanqrswift(objFrom.getListaresp_cidbanqrswift());
                saidaList.setImunindcmbio(objFrom.getListaresp_imunindcmbio());
                saidaList.setIpais(objFrom.getListaresp_ipais());
                saidaList.setNbanqrcmbio(objFrom.getListaresp_nbanqrcmbio());
                saidaList.setNfuncresp(objFrom.getListaresp_nfuncresp());
                saidaList.setCindcdfndngutlzd(objFrom.getListaresp_cindcdfndngutlzd());
                saidaList.setNindcdfndngutlzd(objFrom.getListaresp_nindcdfndngutlzd());
                saidaList.setCfndng(objFrom.getListaresp_cfndng());
                
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
                if(objFrom.getListaresp_nfuncresp().equalsIgnoreCase("EMISSOR")){
                	saidaList.setCfuncao(Numeros.UM);
                	saidaList.setCbanqrcmbiofndg(Integer.valueOf(saidaList.getCbanqrcmbio().toString()));
                } else if(objFrom.getListaresp_nfuncresp().equalsIgnoreCase("CONFIRMADOR")){
                	saidaList.setCfuncao(Numeros.DOIS);
                	saidaList.setCbanqrcmbiorcdor(Integer.valueOf(saidaList.getCbanqrcmbio().toString()));
                } else if(objFrom.getListaresp_nfuncresp().equalsIgnoreCase("AVISADOR")){
                	saidaList.setCfuncao(Numeros.TRES);
                	saidaList.setCbanqrcmbioaviso(Integer.valueOf(saidaList.getCbanqrcmbio().toString()));
                }                
// IN2833579 - ERRO GARANTIA INTERNACIONAL(STANDBY) ERRO CONFIRMAR DA TELA DE FECHAMENTO
                
                list.add(saidaList);
                
            }
            despesas.setListaDespesa(list);
            
            return despesas;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterResponsavelDespesas | RESPONSAVELDESPESAS ------- ");
        }
    }
    
    public List<TradeFinanceListaVO> obterCotacoesPendente(TradeFinanceFiltroVO filtroVO) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterCotacoesPendente | COTACOESPENDCOMPL ------- ");
            
            List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();
            
            Cotacoespendcomplrequest request = new Cotacoespendcomplrequest();
            Cotacoespendcomplresponse response = new Cotacoespendcomplresponse();
            
            Npccwyjerequest entrada = new Npccwyjerequest();
            Npccwyjsresponse saida = new Npccwyjsresponse();
            
            request.setNpccwyjerequest(entrada);
            response.setNpccwyjsresponse(saida);
            
            
            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().getInicio() == null
                    || filtroVO.getPeriodoCotacao().getFim() == null) {
                entrada.setPeriodocotacaoi("");
                entrada.setPeriodocotacaof("");
            } else {
                entrada.setPeriodocotacaoi(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getInicio()));
                entrada.setPeriodocotacaof(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getFim()));
            }
            
            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            
            entrada.setCpssoajurid(filtroVO.getCpssoajurid());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setNsequndorgnz(SiteUtil.getInt(filtroVO.getNsequndorgnz()));
            
            // FLUXO: NPCCIASP BOOK: NPCCWYJE/S
            listaComPaginacao(request, response, "COTACOESPENDCOMPL", "NPCCIASP");
            
            setMsgRetorno(response.getTexmens());
            
            // LISTA COTACÕES PENDENTES DE COMPLEMENTO
            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                
                TradeFinanceListaVO ctcPendCompl = new TradeFinanceListaVO();
                
                Npccwyjsresponse_gride objFrom = saida.getGride().get(i);
                
                ctcPendCompl.setCindcdeconmmoeda(objFrom.getGride_scindcdeconmmoeda());
                ctcPendCompl.setCmodldprodtcmbio(objFrom.getGride_scmodldprodtcmbio());
                ctcPendCompl.setCprodtservc(objFrom.getGride_scprodtservc());
                ctcPendCompl.setCsitbletocmbio(objFrom.getGride_scsitbletocmbio());
                ctcPendCompl.setCunicclicmbio(objFrom.getGride_scunicclicmbio());
                ctcPendCompl.setDmodldprodtcmbio(objFrom.getGride_sdmodldprodtcmbio());
                ctcPendCompl.setDprodtservc(objFrom.getGride_sdprodtservc());
                ctcPendCompl.setDsitbletocmbio(objFrom.getGride_sdsitbletocmbio());
                ctcPendCompl.setDtcotacao(SiteUtil.trocarPontoPorBarra(objFrom.getGride_sdtcotacao()));
                ctcPendCompl.setNbletocmbioano(objFrom.getGride_snbletocmbioano());
                ctcPendCompl.setNbletonegoccmbio(objFrom.getGride_snbletonegoccmbio());
                ctcPendCompl.setNcunicclicmbio(objFrom.getGride_sncunicclicmbio());
                ctcPendCompl.setSimbleconmmoeda(objFrom.getGride_ssimbleconmmoeda());
                ctcPendCompl.setVnegocmoedaestrg(objFrom.getGride_svnegocmoedaestrg());
                
                lista.add(ctcPendCompl);
                
            }
            
            return lista;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.obterCotacoesPendente | COTACOESPENDCOMPL ------- ");
        }
    }
    
    @Override
    public BeneficiarioVO obterConsBenefAfianc(Long cunicpssoacmbio, Integer flagbeneorafia, Long cpssoaJuridic, TradeFinanceVO saidaDados) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
            
            Consbeneficafiancadorequest request = new Consbeneficafiancadorequest();
            Consbeneficafiancadoresponse response = new Consbeneficafiancadoresponse();
            
            Npccwzmerequest entrada = new Npccwzmerequest();
            Npccwzmsresponse saida = new Npccwzmsresponse();
            
            request.setNpccwzmerequest(entrada);
            response.setNpccwzmsresponse(saida);

            entrada.setCunicpssoa(cunicpssoacmbio);
            entrada.setFlagbeneorafia(flagbeneorafia);
            
            // Só acessa esses dados se for Afiancado 
            // 1 beneficiario - 2 incluir na lupinha incluir e alterar / 3 - consulta ,
            if(flagbeneorafia.equals(2)) {
                entrada.setCclub(cpssoaJuridic);
                
                entrada.setCdcpfcnpj(saidaDados.getCpfcnpj());
                entrada.setCdfilial(saidaDados.getCflial());
                entrada.setCdctrlcpfcnpj(saidaDados.getCctrl());
               
            }else if(flagbeneorafia.equals(3)) {
                entrada.setCclub(cpssoaJuridic);
            
      
            }
        
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
    
        /**
        * Nome: aprovarBanqueiro
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 05/08/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
        */
    public String aprovarBanqueiro(Long codFunding, Long numBoleto) {
        
        try{
            
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.obterBeneficiarioAfiancador | CONSBENEFICAFIANCADO ------- ");
            
            Aprovarbanqueirorequest request = new Aprovarbanqueirorequest();
            Aprovarbanqueiroresponse response = new Aprovarbanqueiroresponse();
            
            Npccwycerequest entrada = new Npccwycerequest();
            Npccwycsresponse saida = new Npccwycsresponse();
            
            request.setNpccwycerequest(entrada);
            response.setNpccwycsresponse(saida);

            entrada.setCfndng(codFunding);
            entrada.setNbletonegoccmbio(numBoleto);

            // FLUXO: NPCCIAQU BOOK: NPCCWYCE/S 
            listaSemPaginacao(request, response, "APROVARBANQUEIRO");
            
            setMsgRetorno(response.getTexmens());
            
            return response.getTexmens();

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.incluirComplGarantia | INCLUIRCOMPLGARANTIA ------- ");
        }
    }

    @Override
    public String validaDataAprovRespDesp(CotacoesExternasVO dadosSaida, ResponsavelDespesaVO listaDespesa, TradeFinanceVO produto) {

        try{

            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.validaDataAprovRespDesp | VALIDADATAAPROVDESP ------- ");

            Validadataaprovdesprequest request = new Validadataaprovdesprequest();
            Validadataaprovdespresponse response = new Validadataaprovdespresponse();

            Npccww3erequest entrada = new Npccww3erequest();
            Npccww3sresponse saida = new Npccww3sresponse();

            request.setNpccww3erequest(entrada);
            response.setNpccww3sresponse(saida);
            
            List<Npccww3erequest_lista> lista = new ArrayList<Npccww3erequest_lista>();

            
            if(produto.getProduto().isGarantia()) {
                
                for (Iterator<ListaResponsavelDespesaVO> iterator = listaDespesa.getListaDespesa().iterator(); iterator.hasNext();) {

                    ListaResponsavelDespesaVO itemAvalista = (ListaResponsavelDespesaVO) iterator.next();
                    Npccww3erequest_lista itemLista = new Npccww3erequest_lista();

                    itemLista.setLista_cindcdfndngutlzd(itemAvalista.getCindcdfndngutlzd());
                    itemLista.setLista_dlimfndngcmbio(listaDespesa.getDlimfndngcmbio());
                    
                    lista.add(itemLista);
                }

            } else {
             
                for (Iterator<ListaCotacoesExternasVO> iterator = dadosSaida.getListaCotacoes().iterator(); iterator.hasNext();) {

                    ListaCotacoesExternasVO itemAvalista = (ListaCotacoesExternasVO) iterator.next();
                    Npccww3erequest_lista itemLista = new Npccww3erequest_lista();

                    itemLista.setLista_cindcdfndngutlzd(itemAvalista.getCindcdfndngutlzd());
                    itemLista.setLista_dlimfndngcmbio(SiteUtil.stringDataWebToMainframe(itemAvalista.getDlimfndngcmbio()));

                    lista.add(itemLista);
                }

            }

            entrada.setLista(lista);
            
            entrada.setQtddocorr(lista.size());

            // FLUXO: NPCCIAQA BOOK: NPCCWW3E/S 
            listaSemPaginacao(request, response, "VALIDADATAAPROVDESP");          
            
            setMsgRetorno(response.getTexmens());

            return SiteUtil.getString(saida.getCsitfecha());

        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.validaDataAprovRespDesp | VALIDADATAAPROVDESP ------- ");
        }
    }
    
    /**
     * 
     * Nome: confirmarFormalizacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarFormalizacao(TradeFinanceVO tradeFinanceVO, Integer csitbleto) {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.confirmarFormalizacao | CONFIRMAFORMALIZACAO ------- ");
            
            Confirmaformalizacaorequest request = new Confirmaformalizacaorequest();
            Confirmaformalizacaoresponse response = new Confirmaformalizacaoresponse();
            
            Npccwkjerequest entrada = new Npccwkjerequest();
            Npccwkjsresponse saida = new Npccwkjsresponse();
            
            request.setNpccwkjerequest(entrada);
            response.setNpccwkjsresponse(saida);
            
            entrada.setNbletonegoccmbio(tradeFinanceVO.getNbletonegoccmbio());
            entrada.setNbletocmbioano(tradeFinanceVO.getNbletocmbioano());
            entrada.setDanobase(tradeFinanceVO.getDanobase());
            entrada.setCaditvbletocmbio(tradeFinanceVO.getCaditvbletocmbio());
            entrada.setCsitbletocmbio(csitbleto);
            entrada.setCmotvobletocmbio(tradeFinanceVO.getCmotvobletocmbio());
            entrada.setCprodtservc(tradeFinanceVO.getCprodtservc());
            entrada.setDfchtobletocmbio(SiteUtil.trocarVirgulaPorPonto(tradeFinanceVO.getDfchtobletocmbio()));
            entrada.setNseqcontrlim(tradeFinanceVO.getNseqcontrlim());
            entrada.setNppstapontucmbio(tradeFinanceVO.getNppstapontucmbio());
            
            entrada.setCunicclicmbio(tradeFinanceVO.getCunicclicmbio());
            entrada.setCindcdeconmmoeda(tradeFinanceVO.getCindcdeconmmoeda());
            entrada.setVnegocmoedaestrg(tradeFinanceVO.getVnegocmoedaestrg());
            entrada.setCsitbletoaprov(tradeFinanceVO.getCsitbletoaprov());
            
            if (tradeFinanceVO.getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                entrada.setCindcdnegoccarta("N");
            } else {
                if (tradeFinanceVO.getCindcdnegoccarta().toUpperCase().equals("SIM")) {
                    entrada.setCindcdnegoccarta("S");
                } else {
                    entrada.setCindcdnegoccarta("N");
                }
            }
            entrada.setCindcdcartaidpdt(tradeFinanceVO.getCindcdcartaidpdt());
            entrada.setTdiavalddcarta(tradeFinanceVO.getTdiavalddletra());
            entrada.setVtxspreadnegoc(SiteUtil.webMoedaToMainframe(tradeFinanceVO.getVtxspreadnegoc()));
            entrada.setDlimembrqcmbio(tradeFinanceVO.getDlimembrqcmbio().replace("/", "."));
            entrada.setTdiaopercmbio(tradeFinanceVO.getTdiaopercmbio());
            
            if (tradeFinanceVO.getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo())) {
                entrada.setDprevtdsembcmbio(tradeFinanceVO.getDataPrevDesemb().getInicioFormatado().replace("/", "."));
            } else {
                entrada.setDprevtdsembcmbio(tradeFinanceVO.getDprevtdsembcmbio().replace("/", "."));
            }
            entrada.setRjustfdqmto(tradeFinanceVO.getRjustfdqmto());
            entrada.setVtxspreadtot(SiteUtil.formatarPontosVirgula(tradeFinanceVO.getVtxspreadtot()));
            
            //NPCCIAHA - NPCCWKJE/NPCCWKJS
            listaSemPaginacao(request, response, "CONFIRMAFORMALIZACAO");
            
            return response.getTexmens();
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceMonitServiceImpl.confirmarFormalizacao | CONFIRMAFORMALIZACAO ------- ");
        }
    }
    
    /**
     * Nome: gerarArquivoBacthMonitor
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 05/08/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
 public String gerarArquivoBacthMonitor(TradeFinanceFiltroVO filtroVO) {
     
     try{
         
         BradescoCommonServiceFactory.getLogManager().info("     --------  [Inicio] TradeFinanceMonitServiceImpl.gerarArquivoBacthMonitor | GERARBATCHMONITOR ------- ");
         
         Gerarbatchmonitorrequest request = new Gerarbatchmonitorrequest();
         Gerarbatchmonitorresponse response = new Gerarbatchmonitorresponse();
         
         Npccwkwerequest entrada = new Npccwkwerequest();
         Npccwkwsresponse saida = new Npccwkwsresponse();
         
         request.setNpccwkwerequest(entrada);
         response.setNpccwkwsresponse(saida);

            if (filtroVO.getPeriodoCotacao() == null || filtroVO.getPeriodoCotacao().getInicio() == null
                            || filtroVO.getPeriodoCotacao().getFim() == null) {
                entrada.setDeperiodocotacao("");
                entrada.setAteperiodocotacao("");
            } else {
                entrada.setDeperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getInicio()));
                entrada.setAteperiodocotacao(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoCotacao().getFim()));
            }

            if (filtroVO.getPeriodoFech() == null || filtroVO.getPeriodoFech().getInicio() == null
                            || filtroVO.getPeriodoFech().getFim() == null) {
                entrada.setDeperiodofechmto("");
                entrada.setAteperiodofechmto("");
            } else {
                entrada.setDeperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getInicio()));
                entrada.setAteperiodofechmto(SiteUtil.dataWebToMainframe(filtroVO.getPeriodoFech().getFim()));
            }
            
            entrada.setCunicclicmbio(filtroVO.getCunicclicmbio());
            entrada.setCtposgmtocli(filtroVO.getCtposgmtocli());
            entrada.setCsitbletocmbio(filtroVO.getCsitbletocmbio());
            entrada.setCusuarinclt(filtroVO.getCusuarincl());
            entrada.setCindcdeconmmoeda(filtroVO.getCindcdeconmmoeda());
            entrada.setCprodtservc(filtroVO.getCprodtservc());
            entrada.setNsequndorgnz(SiteUtil.getInt(filtroVO.getNsequndorgnz()));
            entrada.setCbcoextcmbio(filtroVO.getUnidadeExternaVO().getCbanqrcmbio());
            
            if (filtroVO.getCindcdnegocswap() != null && filtroVO.getCindcdnegocswap()) {
                entrada.setCindcdnegocswap(Numeros.UM.toString());
            } else {
                entrada.setCindcdnegocswap(SiteUtil.STRING_EMPTY);
            }
            
            entrada.setCtponegoccmbio(filtroVO.getCtponegoccmbio());
            if (SiteUtil.isEmptyOrNull(filtroVO.getNbletocmbioano())) {
                entrada.setDanobase(null);
            } else {
                entrada.setDanobase(filtroVO.getDanobase());
            }
            entrada.setNbletocmbioano(filtroVO.getNbletocmbioano());
            entrada.setTdiadecmbio(filtroVO.getTdiadecmbio());
            entrada.setTdiaatecmbio(filtroVO.getTdiaatecmbio());
            entrada.setQprzmedde(filtroVO.getQprzmedde());
            entrada.setQprzmedate(filtroVO.getQprzmedate());
            entrada.setValormede(SiteUtil.webMoedaToMainframe(filtroVO.getValormede()));
            entrada.setValormeate(SiteUtil.webMoedaToMainframe(filtroVO.getValormeate()));
            entrada.setCpaisrest(filtroVO.getCpaisrest());

         // FLUXO: NPCCIAHS BOOK: NPCCWKWE/S 
         listaSemPaginacao(request, response, "GERARBATCHMONITOR");
         
         setMsgRetorno(response.getTexmens());
         
         return response.getTexmens();

     }finally{
         BradescoCommonServiceFactory.getLogManager().info("     --------  [Fim] TradeFinanceNegociacaoServiceImpl.gerarArquivoBacthMonitor | GERARBATCHMONITOR ------- ");
     }
 }

}
