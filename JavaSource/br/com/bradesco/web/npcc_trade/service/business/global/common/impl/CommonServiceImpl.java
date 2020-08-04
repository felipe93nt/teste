/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.annotations.Cache;
import br.com.bradesco.web.aq.application.pagination.PaginationAPI;
import br.com.bradesco.web.aq.application.pagination.PaginationRequest;
import br.com.bradesco.web.aq.application.pagination.PaginationResponse;
import br.com.bradesco.web.aq.application.pagination.cws.CWSPaginationAPIAdapterImpl;
import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.pagination.factory.PaginationAPIFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Comboclausularequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Comboclausularesponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Npccwvserequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Npccwvssresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula.Npccwvssresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Combomodalidaderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Combomodalidaderesponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Npccwicerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Npccwicsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Npccwicsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Combomodeloboletorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Combomodeloboletoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Npccwvterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Npccwvtsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto.Npccwvtsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Combomoedarequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Combomoedaresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Npcdwazerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Npcdwazsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda.Npcdwazsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Combomoedaoperacaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Combomoedaoperacaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Npccwh6erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Npccwh6sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao.Npccwh6sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Combopaisrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Combopaisresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Npcdwa3erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Npcdwa3sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Npcdwa3sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Combopaisrestricaorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Combopaisrestricaoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Npccwwperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Npccwwpsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao.Npccwwpsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Comboperiodicidaderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Comboperiodicidaderesponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Npccwwuerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Npccwwusresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Npccwwusresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Comboprodutorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Comboprodutoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Npccwiaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Npccwiasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto.Npccwiasresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Combosegmentorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Combosegmentoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Npccwh8erequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Npccwh8sresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento.Npccwh8sresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Combotarifasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Combotarifasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Npccwieerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Npccwiesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas.Npccwiesresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Combotipoclausularequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Combotipoclausularesponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Npccwvferequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Npccwvfsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Npccwvfsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Combotipocomissoesrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Combotipocomissoesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Npccwwserequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Npccwwssresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes.Npccwwssresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Combotipodespesasrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Combotipodespesasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Npccwigerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Npccwigsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Npccwigsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Combotomadorrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Combotomadorresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Npccwwterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Npccwwtsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Npccwwtsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Combounidadenegociorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Combounidadenegocioresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Npccwzkerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Npccwzksresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Npccwzksresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc.Datalimitcotacaocalcrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc.Datalimitcotacaocalcresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc.Npccwhferequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc.Npccwhfsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes.Detalhartarifadespesrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes.Detalhartarifadespesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes.Npccwiderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes.Npccwidsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Garantiaadicionaconsrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Garantiaadicionaconsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Npccwyperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Npccwypsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Npccwypsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Listasituacaoboletorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Listasituacaoboletoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Npccwjxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Npccwjxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto.Npccwjxsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Listasituacaobolagexrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Listasituacaobolagexresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Npccwnzerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Npccwnzsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex.Npccwnzsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Motivoperdalistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Motivoperdalistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Npccwcrerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Npccwcrsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList.Npccwcrsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvuerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvusresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvusresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Operadormodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Operadormodallistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet.Npcdwayerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet.Npcdwaysresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet.Paisdetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet.Paisdetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Unidextmodallistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Npccwvxerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Npccwvxsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Validaprevisaodesembrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb.Validaprevisaodesembresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MotivoPerdaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboTipoDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboModalidadeVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboMoedaOperacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboMoedaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboPaisRestricaoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboPaisVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboProdutoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboSegmentoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoGarantiaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboUnidadeNegocioVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ListaSituacaoBoletoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: CommonServiceImpl.java
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
 *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
@Named("commonService")
@SessionScoped
public class CommonServiceImpl extends BaseService implements ICommonService, Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor
     * 
     * @param
     */
    public CommonServiceImpl() {
    }

    /**
     * Nome: getMoeda
     * 
     * Propósito: Carrega o Combo de Moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Cache(key = "comboMoeda", scope = "session")
    public List<ComboMoedaVO> getComboMoeda() {

        List<ComboMoedaVO> lista = new ArrayList<ComboMoedaVO>();

        Combomoedarequest request = new Combomoedarequest();
        Combomoedaresponse response = new Combomoedaresponse();
        Npcdwazerequest entrada = new Npcdwazerequest();
        Npcdwazsresponse saida = new Npcdwazsresponse();
        request.setNpcdwazerequest(entrada);
        response.setNpcdwazsresponse(saida);

        entrada.setCindcdeconmmoeda(Numeros.ZERO);

        listaSemPaginacao(request, response, "COMBOMOEDA");

        for (int i = 0; i < response.getNpcdwazsresponse().getQtdeocorr(); i++) {

            Npcdwazsresponse_lista objFrom = response.getNpcdwazsresponse().getLista().get(i);
            ComboMoedaVO objTo = new ComboMoedaVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * Nome: getComboPais
     * 
     * Propósito: Carrega o Combo de Pais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboPaisVO> getComboPais(Integer cpais, String tipoCombo) {

        List<ComboPaisVO> lista = new ArrayList<ComboPaisVO>();
        ComboPaisVO objTo = null;

        Combopaisrequest request = new Combopaisrequest();
        Combopaisresponse response = new Combopaisresponse();
        Npcdwa3erequest entrada = new Npcdwa3erequest();
        Npcdwa3sresponse saida = new Npcdwa3sresponse();
        request.setNpcdwa3erequest(entrada);
        response.setNpcdwa3sresponse(saida);

        entrada.setCpais(cpais);
        entrada.setTipocombo(tipoCombo);
        
        //Fluxo: NPCDIAA3 - Books: NPCDWA3E / NPCDWA3S
        List<Combopaisresponse> pages = autoPaginate(request, response, "COMBOPAIS");
        
        // Percorre todas as paginas obtidas do MF
        for (Combopaisresponse page : pages) {
            Npcdwa3sresponse currentOutput = page.getNpcdwa3sresponse();
            
            // Percorre todas as ocorrencias de cada pagina
            for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                Npcdwa3sresponse_lista ocurrence = currentOutput.getLista().get(i);
                objTo = new ComboPaisVO();

                // Copia os valores das propriedades com o mesmo nome
                // automaticamente
                SiteUtil.copyPropertiesObjects(ocurrence, objTo, "lista_", true);

                lista.add(objTo);
            }
        }

        return lista;
    }
    
    /**
     * 
     * Nome: detalhar Propósito: detalhar PaisVO
     *
     * @param : Integer
     * @return : PaisVO
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public final ComboPaisVO getDetalhesPais(Integer id) {

    	ComboPaisVO result = new ComboPaisVO();

        Paisdetrequest request = new Paisdetrequest();
        Paisdetresponse response = new Paisdetresponse();
        Npcdwayerequest entrada = new Npcdwayerequest();
        Npcdwaysresponse saida = new Npcdwaysresponse();
        request.setNpcdwayerequest(entrada);
        response.setNpcdwaysresponse(saida);

        entrada.setCpais(id);

        // Fluxo: NPCDIAAY - Books: NPCDWAYE / NPCDWAYS
        listaSemPaginacao(request, response, "PAISDET");

        result.setCdpaisageo(SiteUtil.getInt(saida.getCdpais()));
        result.setNomepais(saida.getNomepais());
        result.setCindcdlvgemdinhe(saida.getCindcdlvgemdinhe());
        result.setCindcdprisofscal(saida.getCindcdprisofscal());
        result.setCindcdriscoestrg(saida.getCindcdriscoestrg());

        return result;
    }

    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Propósito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */

    public List<ComboTipoClausulaVO> getComboTipoClausulasVO() {

        List<ComboTipoClausulaVO> lista = new ArrayList<ComboTipoClausulaVO>();
        ComboTipoClausulaVO objTo = null;

        Combotipoclausularequest request = new Combotipoclausularequest();
        Combotipoclausularesponse response = new Combotipoclausularesponse();
        Npccwvferequest entrada = new Npccwvferequest();
        Npccwvfsresponse saida = new Npccwvfsresponse();
        request.setNpccwvferequest(entrada);
        response.setNpccwvfsresponse(saida);

        entrada.setCtpoclauscmbio(Numeros.ZERO);
        
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("response", response);
        params.put("transactionName", "COMBOTIPOCLAUSULA");

        CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter = new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(
                getAdapterCWS());
        PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI("cws", apiAdapter, params);

        boolean init = false;
        boolean hasMoreData = false;
        // chama o mainframe enquanto ainda houver dados (hasMoreDataRight ==
        // true)
        do {
            PaginationRequest<Combotipoclausularequest> paginationRequest = new PaginationRequest<Combotipoclausularequest>(
                    request);

            // preparando o objeto que vai receber o response da API, que
            // encapsula o response do adaptador
            PaginationResponse<Combotipoclausularesponse> paginationResponse = null;

            if (!init) {
                init = true;
                // inicializa a paginacao atraves da API de paginacao e obtem o
                // retorno do adaptador
                // encapsulado em um response da API
                paginationResponse = paginationAPI.init(paginationRequest);
            } else {
                // obtem a proxima leva de dados do MF e retorna o response da
                // API que encapsula o retorno
                paginationResponse = paginationAPI.next(paginationRequest);
            }

            // atualiza a flag que informa se tem mais dados para frente (a
            // direita)
            hasMoreData = paginationResponse.isHasMoreDataRight();
            response = paginationResponse.getResponse();

            for (int i = 0; i < response.getNpccwvfsresponse().getQtdeocorr(); i++) {

                Npccwvfsresponse_lista objFrom = response.getNpccwvfsresponse().getLista().get(i);
                objTo = new ComboTipoClausulaVO();

                // Copia os valores das propriedades com o mesmo nome
                // automaticamente
                SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);

                lista.add(objTo);
            }

        } while (hasMoreData);
        

        return lista;
    }

    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Propósito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */

    public List<ComboModeloBoletoVO> getComboModeloBoletoVO(Integer codProduto) {

        List<ComboModeloBoletoVO> lista = new ArrayList<ComboModeloBoletoVO>();
        ComboModeloBoletoVO objTo = null;

        Combomodeloboletorequest request = new Combomodeloboletorequest();
        Combomodeloboletoresponse response = new Combomodeloboletoresponse();
        Npccwvterequest entrada = new Npccwvterequest();
        Npccwvtsresponse saida = new Npccwvtsresponse();
        request.setNpccwvterequest(entrada);
        response.setNpccwvtsresponse(saida);

        entrada.setCprodtserv(codProduto);

        // Executa chamada CWS - Fluxo: NPCCIAOP - Books: NPCCWVTE / NPCCWVTS
        listaSemPaginacao(request, response, "COMBOMODELOBOLETO");

        for (int i = 0; i < response.getNpccwvtsresponse().getQtdeocorr(); i++) {

            Npccwvtsresponse_lista objFrom = response.getNpccwvtsresponse().getLista().get(i);
            objTo = new ComboModeloBoletoVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: getComboClausulaVO
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboClausulaVO> getComboClausulaVO(Integer codTipoClausula) {

        List<ComboClausulaVO> lista = new ArrayList<ComboClausulaVO>();
        ComboClausulaVO objTo = null;

        Comboclausularequest request = new Comboclausularequest();
        Comboclausularesponse response = new Comboclausularesponse();
        Npccwvserequest entrada = new Npccwvserequest();
        Npccwvssresponse saida = new Npccwvssresponse();
        request.setNpccwvserequest(entrada);
        response.setNpccwvssresponse(saida);

        entrada.setCtpoclauscmbio(codTipoClausula);

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("response", response);
        params.put("transactionName", "COMBOCLAUSULA");

        CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter = new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(
                getAdapterCWS());
        PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI("cws", apiAdapter, params);

        boolean init = false;
        boolean hasMoreData = false;
        // chama o mainframe enquanto ainda houver dados (hasMoreDataRight ==
        // true)
        do {
            PaginationRequest<Comboclausularequest> paginationRequest = new PaginationRequest<Comboclausularequest>(
                    request);

            // preparando o objeto que vai receber o response da API, que
            // encapsula o response do adaptador
            PaginationResponse<Comboclausularesponse> paginationResponse = null;

            if (!init) {
                init = true;
                // inicializa a paginacao atraves da API de paginacao e obtem o
                // retorno do adaptador
                // encapsulado em um response da API
                paginationResponse = paginationAPI.init(paginationRequest);
            } else {
                // obtem a proxima leva de dados do MF e retorna o response da
                // API que encapsula o retorno
                paginationResponse = paginationAPI.next(paginationRequest);
            }

            // atualiza a flag que informa se tem mais dados para frente (a
            // direita)
            hasMoreData = paginationResponse.isHasMoreDataRight();
            response = paginationResponse.getResponse();

            // processa os dados retornados pelo CWS
            for (int i = 0; i < response.getNpccwvssresponse().getQtdeocorr(); i++) {

                Npccwvssresponse_lista objFrom = response.getNpccwvssresponse().getLista().get(i);
                objTo = new ComboClausulaVO();

                // Copia os valores das propriedades com o mesmo nome
                // automaticamente
                SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);

                objTo.setCtpoclauscmbio(codTipoClausula);

                lista.add(objTo);
            }

        } while (hasMoreData);

        return lista;
    }

    /**
     * Nome: getComboProduto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboProdutoVO> getComboProduto(Integer codMesa, Integer ProntoOuFuturo, Integer CompraOuVenda) {

        List<ComboProdutoVO> lista = new ArrayList<ComboProdutoVO>();


        ComboProdutoVO objTo = null;

        Comboprodutorequest request = new Comboprodutorequest();
        Comboprodutoresponse response = new Comboprodutoresponse();
        Npccwiaerequest entrada = new Npccwiaerequest();
        Npccwiasresponse saida = new Npccwiasresponse();
        request.setNpccwiaerequest(entrada);
        response.setNpccwiasresponse(saida);

        entrada.setCidtfdmesacmbio(codMesa);
        entrada.setCcmbioprodtfutur(ProntoOuFuturo);
        entrada.setCcomczprodtcmbio(CompraOuVenda);

        listaSemPaginacao(request, response, "COMBOPRODUTO");

        for (int i = 0; i < response.getNpccwiasresponse().getQtdeocorr(); i++) {

            Npccwiasresponse_lista objFrom = response.getNpccwiasresponse().getLista().get(i);
            objTo = new ComboProdutoVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);

            lista.add(objTo);
            
        }
        
        Collections.sort(lista);
        
        return lista;
    }

    /**
     * Nome: getComboMoedaOperacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboMoedaOperacaoVO> getComboMoedaOperacao(Integer codProduto) {

        List<ComboMoedaOperacaoVO> lista = new ArrayList<ComboMoedaOperacaoVO>();

        ComboMoedaOperacaoVO objTo = null;

        Combomoedaoperacaorequest request = new Combomoedaoperacaorequest();
        Combomoedaoperacaoresponse response = new Combomoedaoperacaoresponse();
        Npccwh6erequest entrada = new Npccwh6erequest();
        Npccwh6sresponse saida = new Npccwh6sresponse();
        request.setNpccwh6erequest(entrada);
        response.setNpccwh6sresponse(saida);

        entrada.setCprodtservc(codProduto);

        listaSemPaginacao(request, response, "COMBOMOEDAOPERACAO");

        for (int i = 0; i < response.getNpccwh6sresponse().getQtdeocorr(); i++) {

            Npccwh6sresponse_lista objFrom = response.getNpccwh6sresponse().getLista().get(i);
            objTo = new ComboMoedaOperacaoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCindcdeconmmoeda(objFrom.getLista_cindcdeconmmoeda());
            objTo.setCindcdfontecons(objFrom.getLista_cindcdfontecons());
            objTo.setIsglindcdfonte(objFrom.getLista_isglindcdfonte());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * Nome: getComboPeriodicidade
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboCotacaoVO> getComboPeriodicidade(Integer codFluxo) {

        List<ComboCotacaoVO> lista = new ArrayList<ComboCotacaoVO>();

        ComboCotacaoVO objTo = null;

        Comboperiodicidaderequest request = new Comboperiodicidaderequest();
        Comboperiodicidaderesponse response = new Comboperiodicidaderesponse();
        Npccwwuerequest entrada = new Npccwwuerequest();
        Npccwwusresponse saida = new Npccwwusresponse();
        request.setNpccwwuerequest(entrada);
        response.setNpccwwusresponse(saida);

        entrada.setCfluxoperdccmbio(codFluxo);

        listaSemPaginacao(request, response, "COMBOPERIODICIDADE");

        for (int i = 0; i < response.getNpccwwusresponse().getQtdeocorr(); i++) {

            Npccwwusresponse_lista objFrom = response.getNpccwwusresponse().getLista().get(i);
            objTo = new ComboCotacaoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCfluxoperdccmbio(objFrom.getLista_cfluxoperdccmbio());
            objTo.setIfluxoperdccmbio(objFrom.getLista_ifluxoperdccmbio());
            objTo.setPerdcprzomes(objFrom.getLista_perdcprzomes());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * Nome: getComboTipoComissoes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboCotacaoVO> getComboTipoComissoes(Integer codProduto, Integer tela) {

        List<ComboCotacaoVO> lista = new ArrayList<ComboCotacaoVO>();

        ComboCotacaoVO objTo = null;

        Combotipocomissoesrequest request = new Combotipocomissoesrequest();
        Combotipocomissoesresponse response = new Combotipocomissoesresponse();
        Npccwwserequest entrada = new Npccwwserequest();
        Npccwwssresponse saida = new Npccwwssresponse();
        request.setNpccwwserequest(entrada);
        response.setNpccwwssresponse(saida);

        entrada.setCprodtservc(codProduto);
        
        /*CINDC-TELA   = CODIGO DO INDICADOR DE TELA
                1 - TELAS DE INCLUSAO/ALTERACAO(OUTROS)
                2 - TELAS DE CUSTO EXTERNO */
        entrada.setCindctela(tela);

        listaSemPaginacao(request, response, "COMBOTIPOCOMISSOES");

        for (int i = 0; i < response.getNpccwwssresponse().getQtdeocorr(); i++) {

            Npccwwssresponse_lista objFrom = response.getNpccwwssresponse().getLista().get(i);
            objTo = new ComboCotacaoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCcondceconc(objFrom.getLista_ccondceconc());
            objTo.setIcondeconc(objFrom.getLista_icondceconc());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * Nome: getListaUniExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 24/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinNegocListasVO> getListaUniExterna(TrdFinNegPrecificacaoVO filtro) {

        List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();

        Unidextmodallistrequest request = new Unidextmodallistrequest();
        Unidextmodallistresponse response = new Unidextmodallistresponse();
        Npcdwfgerequest bookEntrada = new Npcdwfgerequest();
        Npcdwfgsresponse bookSaida = new Npcdwfgsresponse();
        request.setNpcdwfgerequest(bookEntrada);
        response.setNpcdwfgsresponse(bookSaida);

        // Monta a área de entrada de acordo com o tipo de pesquisa.
        bookEntrada.setTipopesquisa(filtro.getUnidadeExternaVO().getTipoPesquisaUnidExt());
        bookEntrada.setCidbanqrswift(SiteUtil.STRING_EMPTY);
        bookEntrada.setCflialbanqrswift(SiteUtil.STRING_EMPTY);
        bookEntrada.setIbanqrcmbio(filtro.getUnidadeExternaVO().getIbanqrcmbio());

        // executa chamada CWS - Fluxo NPCDIADP - Books: NPCDWFGE / NPCDWFGS
        listaComPaginacao(request, response, "UNIDEXTMODALLIST", "NPCDIADP");

        for (Npcdwfgsresponse_lista objFrom : response.getNpcdwfgsresponse().getLista()) {

            TradeFinNegocListasVO objTo = new TradeFinNegocListasVO();

            // Copia os valores das propriedades
            objTo.setCbanqrcmbio(objFrom.getLista_cbanqrcmbio());
            objTo.setIbanqrcmbio(objFrom.getLista_ibanqrcmbio());
            objTo.setImunintlcmbio(objFrom.getLista_imunintlcmbio());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * Nome: getComboMotivoPerda
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<MotivoPerdaVO> getComboMotivoPerda(Integer codIdt) {
        List<MotivoPerdaVO> listaVO = new ArrayList<MotivoPerdaVO>();
        MotivoPerdaVO motivoPerdaVO = null;

        Motivoperdalistrequest request = new Motivoperdalistrequest();
        Motivoperdalistresponse response = new Motivoperdalistresponse();

        Npccwcrerequest entrada = new Npccwcrerequest();
        Npccwcrsresponse saida = new Npccwcrsresponse();

        request.setNpccwcrerequest(entrada);
        response.setNpccwcrsresponse(saida);

        entrada.setCidtfdmesacmbio(codIdt);

        // executa requisição
        //, "NPCCIAG3"
        listaSemPaginacao(request, response, "MOTIVOPERDALIST");
        this.setMsgRetorno(response.getTexmens());

        for (int i = 0; i < saida.getQtdeocorr(); i++) {

            Npccwcrsresponse_lista objFrom = saida.getLista().get(i);
            motivoPerdaVO = new MotivoPerdaVO();

            motivoPerdaVO.setCmotvobletocmbio(objFrom.getLista_cmotvobletocmbio());
            motivoPerdaVO.setRmotvobletocmbio(objFrom.getLista_rmotvobletocmbio());
            
            /*SiteUtil.copyPropertiesObjects(objFrom, motivoPerdaVO, "lista_", true);

            motivoPerdaVO.setCsitativoinatiDesc(EnumSimNao.fromCode(motivoPerdaVO.getCsitativoinati()));
            if (motivoPerdaVO.getProntofuturo().intValue() == 1) {
                motivoPerdaVO.setProntofuturoChk(Boolean.TRUE);
            } else {
                motivoPerdaVO.setProntofuturoChk(Boolean.FALSE);
            }

            if (motivoPerdaVO.getGarantias().intValue() == 1) {
                motivoPerdaVO.setGarantiasChk(Boolean.TRUE);
            } else {
                motivoPerdaVO.setGarantiasChk(Boolean.FALSE);
            }

            if (motivoPerdaVO.getMesatrade().intValue() == 1) {
                motivoPerdaVO.setMesatradeChk(Boolean.TRUE);
            } else {
                motivoPerdaVO.setMesatradeChk(Boolean.FALSE);
            }*/

            listaVO.add(motivoPerdaVO);
        }

        return listaVO;
    }

    /**
     * Nome: getComboTarifas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboCotacaoVO> getComboTarifas(Integer codProduto, String filtro) {

        List<ComboCotacaoVO> lista = new ArrayList<ComboCotacaoVO>();

        ComboCotacaoVO objTo = null;

        Combotarifasrequest request = new Combotarifasrequest();
        Combotarifasresponse response = new Combotarifasresponse();
        Npccwieerequest entrada = new Npccwieerequest();
        Npccwiesresponse saida = new Npccwiesresponse();
        request.setNpccwieerequest(entrada);
        response.setNpccwiesresponse(saida);

        entrada.setCprodtservc(codProduto);
        entrada.setFiltro(filtro);

        listaSemPaginacao(request, response, "COMBOTARIFAS");

        for (int i = 0; i < response.getNpccwiesresponse().getQtdeocorr(); i++) {

            Npccwiesresponse_lista objFrom = response.getNpccwiesresponse().getLista().get(i);
            objTo = new ComboCotacaoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCtpodespcmbio(objFrom.getLista_ctpodespcmbio());
            objTo.setDtpodespcmbio(objFrom.getLista_dtpodespcmbio());
            objTo.setIdenttrfadeps(objFrom.getLista_identtrfadeps());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: getComboSegmento
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboSegmentoVO> getComboSegmento() {
        List<ComboSegmentoVO> lista = new ArrayList<ComboSegmentoVO>();
        Combosegmentorequest request = new Combosegmentorequest();
        Combosegmentoresponse response = new Combosegmentoresponse();

        Npccwh8erequest entrada = new Npccwh8erequest();
        Npccwh8sresponse saida = new Npccwh8sresponse();

        request.setNpccwh8erequest(entrada);
        response.setNpccwh8sresponse(saida);

        listaSemPaginacao(request, response, "COMBOSEGMENTO");

        for (int i = 0; i < response.getNpccwh8sresponse().getQtdeocorr(); i++) {

            Npccwh8sresponse_lista objFrom = response.getNpccwh8sresponse().getLista().get(i);
            ComboSegmentoVO objTo = new ComboSegmentoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCtposgmtocli(objFrom.getLista_ctposgmtocli());
            objTo.setItpossgtound(objFrom.getLista_itpossgtound());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: getComboPaisRestricao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboPaisRestricaoVO> getComboPaisRestricao() {
        List<ComboPaisRestricaoVO> lista = new ArrayList<ComboPaisRestricaoVO>();

        Combopaisrestricaorequest request = new Combopaisrestricaorequest();
        Combopaisrestricaoresponse response = new Combopaisrestricaoresponse();

        Npccwwperequest entrada = new Npccwwperequest();
        Npccwwpsresponse saida = new Npccwwpsresponse();

        request.setNpccwwperequest(entrada);
        response.setNpccwwpsresponse(saida);

        listaSemPaginacao(request, response, "COMBOPAISRESTRICAO");

        for (int i = 0; i < response.getNpccwwpsresponse().getQtdeocorr(); i++) {

            Npccwwpsresponse_lista objFrom = response.getNpccwwpsresponse().getLista().get(i);
            ComboPaisRestricaoVO objTo = new ComboPaisRestricaoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCodpais(objFrom.getLista_codpais());
            objTo.setNomepais(objFrom.getLista_nomepais());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: getListaSituacaoBoleto
     * 
     * Propósito: Retorna lista de checkbox
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ListaSituacaoBoletoVO> getListaSituacaoBoleto(Integer codMesa, Integer csitbleto) {
        List<ListaSituacaoBoletoVO> lista = new ArrayList<ListaSituacaoBoletoVO>();

        Listasituacaoboletorequest request = new Listasituacaoboletorequest();
        Listasituacaoboletoresponse response = new Listasituacaoboletoresponse();

        Npccwjxerequest entrada = new Npccwjxerequest();
        Npccwjxsresponse saida = new Npccwjxsresponse();

        entrada.setCidtfdmesacmbio(codMesa);
        entrada.setCsitbletocmbio(csitbleto);

        request.setNpccwjxerequest(entrada);
        response.setNpccwjxsresponse(saida);

        listaSemPaginacao(request, response, "LISTASITUACAOBOLETO");

        for (int i = 0; i < response.getNpccwjxsresponse().getQtdeocorr(); i++) {

            Npccwjxsresponse_lista objFrom = response.getNpccwjxsresponse().getLista().get(i);
            ListaSituacaoBoletoVO objTo = new ListaSituacaoBoletoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCsitbletocmbio(objFrom.getLista_csitbletocmbio());
            objTo.setIsitbletocmbio(objFrom.getLista_isitbletocmbio());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: getListaSituacaoBoletoAgex
     * 
     * Propósito: Retorna lista de situação para Trade - Boleto Agex - Consulta
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ListaSituacaoBoletoVO> getListaSituacaoBoletoAgex(Integer codMesa, Integer csitbleto, Integer ctipoPesquisa) {
        List<ListaSituacaoBoletoVO> lista = new ArrayList<ListaSituacaoBoletoVO>();

        Listasituacaobolagexrequest  request = new Listasituacaobolagexrequest();
        Listasituacaobolagexresponse response = new Listasituacaobolagexresponse();

        Npccwnzerequest entrada = new Npccwnzerequest();
        Npccwnzsresponse saida = new Npccwnzsresponse();

        entrada.setCidtfdmesacmbio(codMesa);
        entrada.setCsitbletocmbio(csitbleto);
        entrada.setTipo(ctipoPesquisa);

        request.setNpccwnzerequest(entrada);
        response.setNpccwnzsresponse(saida);

		listaSemPaginacao(request, response, "LISTASITUACAOBOLAGEX");

        for (int i = 0; i < response.getNpccwnzsresponse().getQtdeocorr(); i++) {

            Npccwnzsresponse_lista objFrom = response.getNpccwnzsresponse().getLista().get(i);
            ListaSituacaoBoletoVO objTo = new ListaSituacaoBoletoVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCsitbletocmbio(objFrom.getLista_csitbletocmbio());
            objTo.setIsitbletocmbio(objFrom.getLista_isitbletocmbio());

            lista.add(objTo);
        }

        return lista;
    }

    /**
     * 
     * Nome: listarPaginacaoAutomatica
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public final List<TradeFinNegocListasVO> listarPaginacaoAutomaticaUnidExterna() {
        List<TradeFinNegocListasVO> listaVO = new ArrayList<TradeFinNegocListasVO>();

        try {
            Unidextmodallistrequest request = new Unidextmodallistrequest();
            Unidextmodallistresponse response = new Unidextmodallistresponse();
            Npcdwfgerequest entrada = new Npcdwfgerequest();
            Npcdwfgsresponse saida = new Npcdwfgsresponse();
            request.setNpcdwfgerequest(entrada);
            response.setNpcdwfgsresponse(saida);

            entrada.setTipopesquisa(Numeros.UM);
            entrada.setCbanqrcmbio(1L);
            // entrada.setIbanqrcmbio(ibanqrcmbio);
            // entrada.setCidbanqrswift(1);

            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("response", response);
            params.put("transactionName", "UNIDEXTMODALLIST");

            CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter = new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(
                    getAdapterCWS());
            PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI("cws", apiAdapter, params);

            boolean init = false;
            boolean hasMoreData = false;
            // chama o mainframe enquanto ainda houver dados (hasMoreDataRight ==
            // true)
            do {
                PaginationRequest<Unidextmodallistrequest> paginationRequest = new PaginationRequest<Unidextmodallistrequest>(
                        request);

                // preparando o objeto que vai receber o response da API, que
                // encapsula o response do adaptador
                PaginationResponse<Unidextmodallistresponse> paginationResponse = null;

                if (!init) {
                    init = true;
                    // inicializa a paginacao atraves da API de paginacao e obtem o
                    // retorno do adaptador
                    // encapsulado em um response da API
                    paginationResponse = paginationAPI.init(paginationRequest);
                } else {
                    // obtem a proxima leva de dados do MF e retorna o response da
                    // API que encapsula o retorno
                    paginationResponse = paginationAPI.next(paginationRequest);
                }

                // atualiza a flag que informa se tem mais dados para frente (a
                // direita)
                hasMoreData = paginationResponse.isHasMoreDataRight();
                response = paginationResponse.getResponse();

                // processa os dados retornados pelo CWS
                for (int i = 0; i < response.getNpcdwfgsresponse().getQtdeocorr(); i++) {
                    Npcdwfgsresponse_lista objFrom = response.getNpcdwfgsresponse().getLista().get(i);
                    TradeFinNegocListasVO objTo = new TradeFinNegocListasVO();

                    objTo.setCmunintlcmbio(objFrom.getLista_cmunintlcmbio());
                    objTo.setImunintlcmbio(objFrom.getLista_imunintlcmbio());

                    listaVO.add(objTo);
                }

            } while (hasMoreData);
        } catch (Exception e) {
            listaVO = new ArrayList<TradeFinNegocListasVO>();
        }
        
        return listaVO;
    }

    /**
     * 
     * Nome: getComboUnidadeNegocioList
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboUnidadeNegocioVO> getComboUnidadeNegocioList() {
        List<ComboUnidadeNegocioVO> lista = new ArrayList<ComboUnidadeNegocioVO>();

        try {
            Combounidadenegociorequest request = new Combounidadenegociorequest();
            Combounidadenegocioresponse response = new Combounidadenegocioresponse();
            Npccwzkerequest entrada = new Npccwzkerequest();
            Npccwzksresponse saida = new Npccwzksresponse();

            request.setNpccwzkerequest(entrada);
            response.setNpccwzksresponse(saida);

            entrada.setNsequndorgnz(0); // 0 - Retorna todas a unidades
            entrada.setTipopesquisa(2);
            entrada.setCrconhorgnzm(0);

            listaSemPaginacao(request, response, "COMBOUNIDADENEGOCIO");

            for (int i = 0; i < saida.getQtdeocorr(); i++) {
                Npccwzksresponse_lista objFrom = response.getNpccwzksresponse().getLista().get(i);
                
                ComboUnidadeNegocioVO objTo = new ComboUnidadeNegocioVO();

                objTo.setCpssoajuridsubr(objFrom.getLista_cpssoajuridsubr());
                objTo.setNsequndsubr(objFrom.getLista_nsequndsubr());
                objTo.setCidtfdtpoundsubr(objFrom.getLista_cidtfdtpoundsubr());
                objTo.setCrconhundsubrm(Integer.parseInt(objFrom.getLista_crconhundsubrm()));
                objTo.setCrconhundsubrf(Integer.parseInt(objFrom.getLista_crconhundsubrf()));
                objTo.setIrzscialsubr(objFrom.getLista_irzscialsubr());
                objTo.setCtpoundorgnzsubr(objFrom.getLista_ctpoundorgnzsubr());
                objTo.setItpoundorgnzsubr(objFrom.getLista_itpoundorgnzsubr());

                lista.add(objTo);
            }
        } catch (Exception e) {
            lista = new ArrayList<ComboUnidadeNegocioVO>();
        }
        
        return lista;
    }

    /**
     * Nome: detalharTarifaDespesa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegTarifaVO detalharTarifaDespesa(Long cusuarlimcmbio, Integer ctpodespcmbio, String dtpodespcmbio,
            String ntpositcmbio) {

        TrdFinNegTarifaVO result = null;

        Detalhartarifadespesrequest request = new Detalhartarifadespesrequest();
        Detalhartarifadespesresponse response = new Detalhartarifadespesresponse();

        Npccwiderequest entrada = new Npccwiderequest();
        Npccwidsresponse saida = new Npccwidsresponse();

        request.setNpccwiderequest(entrada);
        response.setNpccwidsresponse(saida);

        entrada.setCusuarlimcmbio(cusuarlimcmbio);
        entrada.setCtpodespcmbio(ctpodespcmbio);
        entrada.setDtpodespcmbio(dtpodespcmbio);
        entrada.setNtpositcmbio(ntpositcmbio);

        listaSemPaginacao(request, response, "DETALHARTARIFADESPES");

        if (response.getNpccwidsresponse() != null) {
            result = new TrdFinNegTarifaVO();
            result.setCindcddesptarf(response.getNpccwidsresponse().getCindcddesptarf());
            result.setDescrdesptarif(response.getNpccwidsresponse().getDescrdesptarif());
            result.setCcondceconc(response.getNpccwidsresponse().getCcondceconc());
            result.setCtpodespcmbio(response.getNpccwidsresponse().getCtpodespcmbio());
            result.setItpodespcmbio(response.getNpccwidsresponse().getItpodespcmbio());
            result.setCindcdeconmmoeda(response.getNpccwidsresponse().getCindcdeconmmoeda());
            result.setIsglindcdfonte(response.getNpccwidsresponse().getIsglindcdfonte());
            result.setVdespbletocmbio(SiteUtil.formatarValorWeb(response.getNpccwidsresponse().getVdespbletocmbio()));
        }

        return result;
    }

    /**
     * 
     * Nome: getComboTipoGarantia
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ComboTipoGarantiaVO> listarGarantiasAdicionais(Integer cdProd) {
        List<ComboTipoGarantiaVO> lista = new ArrayList<ComboTipoGarantiaVO>();

        Garantiaadicionaconsrequest request = new Garantiaadicionaconsrequest();
        Garantiaadicionaconsresponse response = new Garantiaadicionaconsresponse();
        Npccwyperequest entrada = new Npccwyperequest();
        Npccwypsresponse saida = new Npccwypsresponse();

        request.setNpccwyperequest(entrada);
        response.setNpccwypsresponse(saida);

        entrada.setCdprodt(cdProd);
        
        // Fluxo NPCCIATS books NPCCWYPE e NPCCWYPS.
        List<Garantiaadicionaconsresponse> pages = autoPaginate(request, response, "GARANTIAADICIONACONS");
        
        // Percorre todas as paginas obtidas do MF
        for (Garantiaadicionaconsresponse page : pages) {
            Npccwypsresponse currentOutput = page.getNpccwypsresponse();
            
            for (int i = 0; i < currentOutput.getQtdeocorr(); i++) {
                Npccwypsresponse_lista objFrom = currentOutput.getLista().get(i);
                ComboTipoGarantiaVO objTo = new ComboTipoGarantiaVO();

                objTo.setCdgarnt(objFrom.getLista_cdgarnt());
                objTo.setDsgarnt(objFrom.getLista_dsgarnt());
                objTo.setDvctogarantcmbio(objFrom.getLista_dvctogarantcmbio());
                objTo.setCindcdeconmmoegar(objFrom.getLista_cindcdeconmmoegar());

                lista.add(objTo);
            }
        }
        
        return lista;
    }

    /**
     * Nome: getDataLimiteCotacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 05/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Date getDataLimiteCotacao(Date dataAtual) {
        
        Date dataLimiteCotacao = new Date();

        Datalimitcotacaocalcrequest request = new Datalimitcotacaocalcrequest();
        Datalimitcotacaocalcresponse response = new Datalimitcotacaocalcresponse();
        Npccwhferequest entrada = new Npccwhferequest();
        Npccwhfsresponse saida = new Npccwhfsresponse();

        request.setNpccwhferequest(entrada);
        response.setNpccwhfsresponse(saida);

        entrada.setDfchtobleto(SiteUtil.dataWebToMainframe(dataAtual)); // DATA FECHAMENTO
        entrada.setCtpoliqdc(1);    // LIQUIDACAO MN
        entrada.setTdialiqdc(2);    // PRAZO EM DIAS DA LIQUIDACAO
        entrada.setDliqdccmbio(""); // DATA LIQUIDACAO

        // executa chamada CWS - Fluxo NPCCIAE8 - Books: NPCCWHFE / NPCCWHFS
        listaSemPaginacao(request, response, "DATALIMITCOTACAOCALC");
        
        dataLimiteCotacao = SiteUtil.dataMainframeToWeb(response.getNpccwhfsresponse().getDliqdccmbio());

        return dataLimiteCotacao;
    }
    
    /**
     * Nome: getDataLimiteCotacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: /04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Date getDataVencimentoSaque(Date dataAtual, Integer tpliquidacao, Integer prazoletras) {
        
        Date dataLimiteCotacao = new Date();

        Datalimitcotacaocalcrequest request = new Datalimitcotacaocalcrequest();
        Datalimitcotacaocalcresponse response = new Datalimitcotacaocalcresponse();
        Npccwhferequest entrada = new Npccwhferequest();
        Npccwhfsresponse saida = new Npccwhfsresponse();

        request.setNpccwhferequest(entrada);
        response.setNpccwhfsresponse(saida);

        entrada.setDfchtobleto(SiteUtil.dataWebToMainframe(dataAtual)); // DATA FECHAMENTO
        entrada.setCtpoliqdc(tpliquidacao);    // LIQUIDACAO MN
        entrada.setTdialiqdc(prazoletras);    // PRAZO EM DIAS DA LIQUIDACAO
        entrada.setDliqdccmbio(""); // DATA LIQUIDACAO

        // executa chamada CWS - Fluxo NPCCIAE8 - Books: NPCCWHFE / NPCCWHFS
        listaSemPaginacao(request, response, "DATALIMITCOTACAOCALC");
        
        dataLimiteCotacao = SiteUtil.dataMainframeToWeb(response.getNpccwhfsresponse().getDliqdccmbio());

        return dataLimiteCotacao;
    }
    
    /**
     * Nome: getPrazoFinanciamento
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 16/04/2016
     *        - Autor: Sergio C Ferreira
     *        - Responsavel: 
     */
    public Integer getPrazoFinanciamento(Date dataDesembolso, Integer tpliquidacao, Date dataVencimento) {
        
        Integer prazoFinanciamento = Numeros.ZERO;

        Datalimitcotacaocalcrequest request = new Datalimitcotacaocalcrequest();
        Datalimitcotacaocalcresponse response = new Datalimitcotacaocalcresponse();
        Npccwhferequest entrada = new Npccwhferequest();
        Npccwhfsresponse saida = new Npccwhfsresponse();

        request.setNpccwhferequest(entrada);
        response.setNpccwhfsresponse(saida);

        entrada.setDfchtobleto(SiteUtil.dataWebToMainframe(dataDesembolso)); // DATA DESEMBOLSO
        entrada.setCtpoliqdc(tpliquidacao);    // LIQUIDACAO MN
        entrada.setTdialiqdc(Numeros.ZERO);    // PRAZO EM DIAS DA LIQUIDACAO
        entrada.setDliqdccmbio(SiteUtil.dataWebToMainframe(dataVencimento)); 		   // DATA LIQUIDACAO

        // executa chamada CWS - Fluxo NPCCIAE8 - Books: NPCCWHFE / NPCCWHFS
        listaSemPaginacao(request, response, "DATALIMITCOTACAOCALC");
        
        prazoFinanciamento = response.getNpccwhfsresponse().getTdialiqdc();

        return prazoFinanciamento;
    }
    
    
    
    /**
     * Nome: getDataVencimentoFianca
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 12/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Date getDataVencimentoFianca(Date dataPrevistaEmissao, int diasPrazoOperacao) {
        
        Date dataVencFianca = new Date();

        Datalimitcotacaocalcrequest request = new Datalimitcotacaocalcrequest();
        Datalimitcotacaocalcresponse response = new Datalimitcotacaocalcresponse();
        Npccwhferequest entrada = new Npccwhferequest();
        Npccwhfsresponse saida = new Npccwhfsresponse();

        request.setNpccwhferequest(entrada);
        response.setNpccwhfsresponse(saida);

        entrada.setDfchtobleto(SiteUtil.dataWebToMainframe(dataPrevistaEmissao)); // DATA FECHAMENTO
        entrada.setCtpoliqdc(2);                    // LIQUIDACAO ME
        entrada.setTdialiqdc(diasPrazoOperacao);    // PRAZO EM DIAS DA LIQUIDACAO
        entrada.setDliqdccmbio("");                 // DATA LIQUIDACAO

        // executa chamada CWS - Fluxo NPCCIAE8 - Books: NPCCWHFE / NPCCWHFS
        listaSemPaginacao(request, response, "DATALIMITCOTACAOCALC");
        
        dataVencFianca = SiteUtil.dataMainframeToWeb(response.getNpccwhfsresponse().getDliqdccmbio());

        return dataVencFianca;
    }    

    /**
     * 
     * Nome: getComboTomador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adeq/o/ouação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> getComboTomador(Long aprovCredito) {

        List<TradeFinanceListaVO> lista = new ArrayList<TradeFinanceListaVO>();

        Combotomadorrequest request = new Combotomadorrequest();
        Combotomadorresponse response = new Combotomadorresponse();

        Npccwwterequest entrada = new Npccwwterequest();
        Npccwwtsresponse saida = new Npccwwtsresponse();

        request.setNpccwwterequest(entrada);
        response.setNpccwwtsresponse(saida);

        entrada.setNcontrlimgerc(aprovCredito);

        listaSemPaginacao(request, response, "COMBOTOMADOR");

        // trata retorno
        this.setMsgRetorno(response.getTexmens());

        for (int i = 0; i < response.getNpccwwtsresponse().getQtdeocorr(); i++) {
            Npccwwtsresponse_lista objFrom = response.getNpccwwtsresponse().getLista().get(i);
            TradeFinanceListaVO objTo = new TradeFinanceListaVO();

            objTo.setCpssoa(objFrom.getLista_cpssoa());
            objTo.setNmbnefc(objFrom.getLista_nmbnefc());

            lista.add(objTo);
        }

        return lista;

    }
    
    /**
    * Nome: getComboModalidade
    * 
    * Propósito: Carrega a lista de modalidades
    *
    * @param : cprodtservc
    * @return : List<ComboModalidadeVO> 
    * @see : Referencias externas.  
    *
    */
    public List<ComboModalidadeVO> getComboModalidade(Integer cprodtservc) {
        List<ComboModalidadeVO> lista = new ArrayList<ComboModalidadeVO>();

        ComboModalidadeVO objTo = null;
        
        Combomodalidaderequest request = new Combomodalidaderequest();
        Combomodalidaderesponse response = new Combomodalidaderesponse();
        
        Npccwicerequest entrada = new Npccwicerequest();
        Npccwicsresponse saida = new Npccwicsresponse();
        
        request.setNpccwicerequest(entrada);
        response.setNpccwicsresponse(saida);
        
        entrada.setCprodtservc(cprodtservc);
        listaSemPaginacao(request, response, "COMBOMODALIDADE");

        for (int i = 0; i < response.getNpccwicsresponse().getQtdeocorr(); i++) {

            Npccwicsresponse_lista objFrom = response.getNpccwicsresponse().getLista().get(i);
            objTo = new ComboModalidadeVO();

            // Copia os valores das propriedades com o mesmo nome
            objTo.setCmodldprodtcmbio(objFrom.getLista_cmodldprodtcmbio());
            objTo.setImodldprodtcmbio(objFrom.getLista_csglmodldcmbio()+"-"+objFrom.getLista_imodldprodtcmbio());
             
            lista.add(objTo);
        }
        return lista;
    }
    
    /**
     * 
     * Nome: getComboOperador
     * Propósito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<OperadorVO> getComboOperador(){
		List<OperadorVO> lista = new ArrayList<OperadorVO>();
		
		// IN3827741 [587651] - O CAMPO DE BUSCA NÃO ESTÁ TRAZENDO OPERADOR (I397185) - book nova
		Operadormodallistrequest request = new Operadormodallistrequest();
	    Operadormodallistresponse response = new Operadormodallistresponse();
	    Npccwvuerequest entrada = new Npccwvuerequest();
	    Npccwvusresponse saida = new Npccwvusresponse();
	    request.setNpccwvuerequest(entrada);
	    response.setNpccwvusresponse(saida);
		
	    listaSemPaginacao(request, response, "OPERADORMODALLIST");
	    
	    for (int i = 0; i < response.getNpccwvusresponse().getQtdeocorr(); i++) {
	    	
	    	Npccwvusresponse_lista objFrom = response.getNpccwvusresponse().getLista().get(i);
	        OperadorVO objTo = new OperadorVO();
	
	        // Copia os valores das propriedades com o mesmo nome
	        objTo.setCusuarincl(objFrom.getLista_cusuarincl());
	        objTo.setNmusuarinc(objFrom.getLista_nmusuarinc());
	        
	        lista.add(objTo);
	    }
	    
	    return lista;
	}
    
    /**
     * 
     * Nome: getComboTipoDespesas
     * Propósito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 22/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComboTipoDespesasVO> getComboTipoDespesas() {
        List<ComboTipoDespesasVO> lista = new ArrayList<ComboTipoDespesasVO>();
        
        ComboTipoDespesasVO objTo = null;
        
        Combotipodespesasrequest request = new Combotipodespesasrequest();
        Combotipodespesasresponse response = new Combotipodespesasresponse();        
        Npccwigerequest entrada = new Npccwigerequest();
        Npccwigsresponse saida = new Npccwigsresponse();        
        request.setNpccwigerequest(entrada);
        response.setNpccwigsresponse(saida);
        
        entrada.setCtpodespcmbio(0);
        
        // Fluxo: NPCCIAF9 - Books: NPCCWIGE / NPCCWIGS
        listaSemPaginacao(request, response, "COMBOTIPODESPESAS");

        for (int i = 0; i < response.getNpccwigsresponse().getQtdeocorr(); i++) {

            Npccwigsresponse_lista objFrom = response.getNpccwigsresponse().getLista().get(i);
            objTo = new ComboTipoDespesasVO();

            objTo.setNtpositcmbio(objFrom.getLista_ntpositcmbio());
            objTo.setCtpodespcmbio(objFrom.getLista_ctpodespcmbio());
            objTo.setDtpodespcmbio(objFrom.getLista_dtpodespcmbio());
             
            lista.add(objTo);
        }
                
        return lista;
    }
    
    /**
     * Nome: validarDiaUtil
     * 
     * Propósito: Verifica se a data é dia útil no pais informado.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @SuppressWarnings("finally")
	public Boolean validarDiaUtil(Date data, Integer pais, String tpodata, Integer cpaisInec, Integer cpaisbenef, Integer cindcdeconmmoeda) {
    	Validaprevisaodesembrequest request = new Validaprevisaodesembrequest();
    	Validaprevisaodesembresponse response = new Validaprevisaodesembresponse();
    	Npccwvxerequest entrada = new Npccwvxerequest();
    	Npccwvxsresponse saida = new Npccwvxsresponse();
    	try {
    		request.setNpccwvxerequest(entrada);
    		response.setNpccwvxsresponse(saida);

    		entrada.setCpais(pais);
    		entrada.setDprevtdsembcmbio(SiteUtil.dataWebToMainframe(data));
    		entrada.setCpaisdsemb(cpaisInec);
    		entrada.setTpodata(tpodata);
    		entrada.setCpaisbenef(cpaisbenef);
    		entrada.setCindcdeconmmoeda(cindcdeconmmoeda);

    		// Fluxo: NPCCIARP - Books: NPCCWVXE/S
    		listaSemPaginacao(request, response, "VALIDAPREVISAODESEMB");

    		// * NPCCWVXS-DATA-UTIL = 1 - DATA UTIL                    *
    		// *                      2 - DATA NAO UTIL                *
    		return saida.getDatautil() == Numeros.UM;
    	} finally {
    		return saida.getDatautil() == Numeros.UM;
    	}
    }
}
