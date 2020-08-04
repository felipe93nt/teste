/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 23/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MotivoPerdaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboTipoDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
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
import br.com.bradesco.web.npcc_trade.service.business.global.commonXml.ICommonXmlService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCobrancaComissao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumComissaoSobre;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumMoeda;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPrazoProex;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNao;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoInformado;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 *
 * Nome: SelectItemBean
 * 
 * Prop�sito: Carrega os Dados para os Combos/Radios
 *
 * Data: 17/06/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named(value = "selectItemBean")
@SessionScoped
public class SelectItemBean implements Serializable {

    /**
     * Atributes
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constant selecione
     */
    private final String SELECIONE = "Selecione...";

    @Inject
    @Named("commonXmlService")
    private ICommonXmlService commonXmlService;

    @Inject
    @Named("commonService")
    private ICommonService commonService;

    /** Variavel est�tica do tipo String valor "C�digo". */
    private static final String CODIGO = "C�digo";

    /** Variavel est�tica do tipo String valor "descri��o". */
    private static final String DESCRICAO = "Descri��o";

    /**
     * Retorna a descri��o de um SelectItem presente em uma lista de acordo com o valor fornecido
     */
    public String getSelectItemLabelByValue(Object value, List<SelectItem> selectItemList) {
        Iterator<SelectItem> itr = selectItemList.iterator();
        String label = null;
        while (itr.hasNext()) {
            SelectItem si = itr.next();
            if (si.getValue().equals(value)) {
                label = si.getLabel();
                break;
            }
        }
        return label;
    }
    
    /**
     * Select item para campos SIM e N�O
     */
    public List<SelectItem> getSimNao() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        for (EnumSimNao enumValue : EnumSimNao.values()) {
            list.add(new SelectItem(enumValue.getCodigo(), enumValue.getDescricao()));
        }

        return list;
    }

    /**
     * Select item para campos SIM e N�O
     */
    public List<SelectItem> getSimNaoStr() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        for (EnumSimNaoStr enumValue : EnumSimNaoStr.values()) {
            list.add(new SelectItem(enumValue.getCodigo(), enumValue.getDescricao()));
        }

        return list;
    }

    /**
     * Select item para campos SIM e N�O
     */
    public List<SelectItem> getSimNaoInformado() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        for (EnumSimNaoInformado enumValue : EnumSimNaoInformado.values()) {
            list.add(new SelectItem(enumValue.getCodigo(), enumValue.getDescricao()));
        }

        return list;
    }

    /**
     * Select item para campos Moeda. Dados do MF
     */
    public List<SelectItem> getMoeda() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        List<ComboMoedaVO> listMoeda = commonService.getComboMoeda();

        list.add(new SelectItem(Numeros.ZERO, SELECIONE));
        for (Iterator<ComboMoedaVO> iterator = listMoeda.iterator(); iterator.hasNext();) {
            ComboMoedaVO comboMoedaVO = iterator.next();
            list.add(new SelectItem(comboMoedaVO.getCindcdeconmmoeda(), comboMoedaVO.getCindcdfontecons() + " - " 
                            + comboMoedaVO.getIsglindcdeconm() ));
        }

        return list;
    }

    /**
     * Select item para campos de moeda. Dados fixo na baixa.
     */
    public List<SelectItem> getMoedaWeb() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        for (EnumMoeda enumValue : EnumMoeda.values()) {
            if (enumValue.getCodigo() == Numeros.ZERO) {
                list.add(new SelectItem(enumValue.getCodigo(), SELECIONE));
            } else {
                list.add(new SelectItem(enumValue.getCodigo(), enumValue.getDescricao()));
            }
        }

        return list;
    }

    /**
     * Select item para combo de pais
     */
    public List<SelectItem> getPais(String situacaoPais) {

        List<SelectItem> list = new ArrayList<SelectItem>();
        // Aciona o Fluxo de consulta de pa�s passando a situa��o como par�metro
        // ("A" = "Ativo", "T" = "Todos")
        // Executa chamada CWS - Fluxo: NPCDIAA3 - Books: NPCDWA3E / NPCDWA3S
        List<ComboPaisVO> listPais = commonService.getComboPais(Numeros.ZERO, situacaoPais);

        list.add(new SelectItem(Numeros.NUM0, SELECIONE));
        for (Iterator<ComboPaisVO> iterator = listPais.iterator(); iterator.hasNext();) {
            ComboPaisVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCdpaisageo(), comboVO.getNomepais()));
        }

        return list;
    }

    /**
     * 
     * Nome: radioOperacaoTela Prop�sito: Select item para radio de op��es de
     * opera��o nas telas
     *
     * @param : func Integer <BR/>
     * @return : list List<SelectItem>
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     * 
     *      | Tela
     * 
     *      1 - moedaList.xhtml 2 - mercadoriaList.xhtml 3 - despesaList.xhtml 5
     *      - custoExternoList.xhtml 6 - logParametrosList.xhtml 7 -
     *      logParametrosList.xhtml 8 - logParametrosList.xhtml 9 -
     *      logParametrosList.xhtml 10 - depositoCaptacaoList.xhtml 14 -
     *      logParametrosList.xhtml
     */
    public List<SelectItem> radioOperacaoTela(Integer func) {
        List<SelectItem> list = new ArrayList<SelectItem>();
        switch (func) {
        case 1:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Cadastrar"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Manuten��o"));
            break;
        case 2:
            list.add(new SelectItem(Numeros.NUM1.intValue(), DESCRICAO));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "C�digo NCM"));
            break;

        case 3:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Descri��o"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), CODIGO));
            break;

        case 4:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Manuten��o"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Aprovar Manuten��o"));
            break;

        case 5:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Cadastrar"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Manuten��o"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Aprovar Manuten��o"));
            list.add(new SelectItem(Numeros.NUM4.intValue(), "Consultar Hist�rico"));
            break;

        case 6:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Pa�s"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Cidade"));
            break;

        case 7:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Nome"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), CODIGO));
            break;
        case 8:
            list.add(new SelectItem(Numeros.NUM1.intValue(), DESCRICAO));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "C�digo Bacen"));
            break;
        case 9:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "CPF/CNPJ"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Nome do Cliente"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Apelido do Cliente"));
            break;

        case 10:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Cadastrar"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Manuten��o"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Aprovar Manuten��o"));
            list.add(new SelectItem(Numeros.NUM4.intValue(), "Consultar Hist�rico"));
            break;

        case 11:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Swift Code"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Nome"));
            break;

        case 12:
            list.add(new SelectItem(Numeros.NUM1.intValue(), CODIGO));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Swift Code"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Nome"));
            list.add(new SelectItem(Numeros.NUM4.intValue(), "Pa�s"));
            list.add(new SelectItem(Numeros.NUM5.intValue(), "Cidade"));
            break;

        case 13:
            list.add(new SelectItem(Numeros.NUM1.intValue(), CODIGO));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "Nome"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Swift Code"));
            break;

        case 14:
            list.add(new SelectItem(Numeros.NUM1, "Desativar"));
            list.add(new SelectItem(Numeros.NUM2, "Impedir"));
            list.add(new SelectItem(Numeros.NUM3, "Bloquear"));
            break;

        case 15:
            list.add(new SelectItem(Numeros.NUM1.intValue(), "CPF"));
            list.add(new SelectItem(Numeros.NUM2.intValue(), "CNPJ"));
            list.add(new SelectItem(Numeros.NUM3.intValue(), "Nome"));
            break;
        case 16:
            list.add(new SelectItem(Numeros.NUM2.intValue(), CODIGO));
            list.add(new SelectItem(Numeros.NUM1.intValue(), "Nome"));
            break;

        default:
            break;
        }

        return list;
    }

    /*
     * Combos das Telas de Taxas
     */

    /*
     * Prazo da Libor
     */

    /**
     * Retorna os valores possiveis para o radio no prazo da Libor
     * 
     * @return List<SelectItem>
     */
    public List<SelectItem> radioPrazoLibor() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem(1, "Manuten��o"));
        list.add(new SelectItem(2, "Aprovar Manuten��o"));

        return list;
    }

    /**
     * Retorna os valores possiveis para o combo de periodo para prazo da Libor
     * 
     * @return List<SelectItem>
     */
    public List<SelectItem> getPeriodo() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem(1, "Dia(s)"));
        list.add(new SelectItem(2, "Ano(s)"));
        return list;
    }

    /**
     * Nome: getProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 16/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboModeloBoleto(Integer codProduto) {
        List<SelectItem> list = new ArrayList<SelectItem>();

        list.add(new SelectItem(Numeros.NUM0, SELECIONE));
        // recupera a lista de tipos de clausas do MF
        List<ComboModeloBoletoVO> listaTipo = commonService.getComboModeloBoletoVO(codProduto);

        // percore a lista retornada do mainframe montando a lista de SelectItem
        for (Iterator<ComboModeloBoletoVO> iterator = listaTipo.iterator(); iterator.hasNext();) {
            ComboModeloBoletoVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCmodcontrcmbio(), comboVO.getImodcontrcmbio()));
        }

        return list;
    }

    /**
     * Nome: getSegmento
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 16/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getSegmento() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem(1, "Prime"));
        list.add(new SelectItem(2, "Comum"));
        return list;
    }

    /**
     * 
     * Nome: getTipoLogParametro Prop�sito: Carregar o combo de tipos de log de
     * parametros
     *
     * @param : <BR/>
     * @return : tipoLog List<SelectItem>
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoLogParametro() {

        List<SelectItem> tipoLog = new ArrayList<SelectItem>();

        tipoLog.add(new SelectItem(Numeros.NUM0, "Selecione"));
        tipoLog.add(new SelectItem(Numeros.NUM1, "Forma de Liquida��o"));
        tipoLog.add(new SelectItem(Numeros.NUM2, "Tipo de Liquida��o"));
        tipoLog.add(new SelectItem(Numeros.NUM3, "Mercadoria"));
        tipoLog.add(new SelectItem(Numeros.NUM4, "Moeda"));
        tipoLog.add(new SelectItem(Numeros.NUM5, "Pa�s"));
        tipoLog.add(new SelectItem(Numeros.NUM6, "Cidade"));
        tipoLog.add(new SelectItem(Numeros.NUM7, "Despesa"));
        tipoLog.add(new SelectItem(Numeros.NUM8, "Tipo de Org�o"));
        tipoLog.add(new SelectItem(Numeros.NUM9, "Identifica��o Clearing"));
        tipoLog.add(new SelectItem(Numeros.NUM10, "Motivo Banqueiro"));
        tipoLog.add(new SelectItem(Numeros.NUM11, "Motivo Cliente"));

        return tipoLog;
    }

    /**
     * Nome: getTipoLogTaxas
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 14/09/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoLogTaxas() {
        List<SelectItem> tipoLog = new ArrayList<SelectItem>();

        tipoLog.add(new SelectItem(Numeros.NUM0, SELECIONE));
        // tipoLog.add(new SelectItem(Numeros.NUM1, "Par�metros de Captura"));
        tipoLog.add(new SelectItem(Numeros.NUM2, "Taxa PTAX Fechamento"));
        // tipoLog.add(new SelectItem(Numeros.NUM3, "Par�metriza��o de Taxas"));
        tipoLog.add(new SelectItem(Numeros.NUM4, "Taxa de Custo Externo"));
        tipoLog.add(new SelectItem(Numeros.NUM5, "Taxa de Dep�sito / Capta��o"));
        tipoLog.add(new SelectItem(Numeros.NUM6, "Prazo da Libor"));

        return tipoLog;
    }

    /**
     * Nome: getRma
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 26/10/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getRma() {
        List<SelectItem> tipoRma = new ArrayList<SelectItem>();

        tipoRma.add(new SelectItem(Numeros.NUM0, SELECIONE));
        tipoRma.add(new SelectItem(Numeros.NUM1, "Sim"));
        tipoRma.add(new SelectItem(Numeros.NUM2, "N�o"));

        return tipoRma;
    }

    /**
     * 
     * Nome: getTipoUnidade Prop�sito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoUnidade() {

        List<SelectItem> tipoLog = new ArrayList<SelectItem>();

        tipoLog.add(new SelectItem(Numeros.NUM0, "Selecione"));
        tipoLog.add(new SelectItem(Numeros.NUM1, "Matriz"));
        tipoLog.add(new SelectItem(Numeros.NUM2, "Filial"));

        return tipoLog;
    }

    /**
     * 
     * Nome: getTipoConta Prop�sito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoConta() {

        List<SelectItem> tipoLog = new ArrayList<SelectItem>();

        tipoLog.add(new SelectItem(SiteUtil.STRING_EMPTY, "Selecione"));
        tipoLog.add(new SelectItem("C", "Concentration"));
        tipoLog.add(new SelectItem("N", "New Nostro"));

        return tipoLog;
    }

    /**
     * 
     * Nome: getTipoClausula Prop�sito: Carregar combo de Tipo de Clausulas
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoClausula() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        // recupera a lista de tipos de clausas do MF
        List<ComboTipoClausulaVO> listaTipo = commonService.getComboTipoClausulasVO();

        // adiciona a lista o item selecione
        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        // percore a lista retornada do mainframe montando a lista de SelectItem
        for (Iterator<ComboTipoClausulaVO> iterator = listaTipo.iterator(); iterator.hasNext();) {
            ComboTipoClausulaVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCtpoclauscmbio(), comboVO.getItpoclauscmbio()));
        }

        return list;
    }

    /**
     * Nome: getProduto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 16/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getProduto(Integer codMesa, Integer ProntoOuFuturo, Integer CompraOuVenda) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        if (codMesa <= Numeros.ZERO) {
            return list;
        }

        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        List<ComboProdutoVO> listProduto = commonService.getComboProduto(
                EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(), EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());

        for (Iterator<ComboProdutoVO> iterator = listProduto.iterator(); iterator.hasNext();) {
            ComboProdutoVO comboVO = iterator.next();
            if (comboVO.getCprodtservc() > 0) {
                list.add(new SelectItem(comboVO.getCprodtservc(), comboVO.getRprodtservc()));
            }
        }

        return list;
    }

    /**
     * Nome: getMoedaOperacao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 17/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getMoedaOperacao(Integer codProduto) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        if (codProduto <= Numeros.ZERO) {
            return list;
        }

        // Aciona o Fluxo de consulta de Cidades passando o c�digo do pa�s como
        // par�metro
        List<ComboMoedaOperacaoVO> listMoedaOperacao = commonService.getComboMoedaOperacao(codProduto);

        for (Iterator<ComboMoedaOperacaoVO> iterator = listMoedaOperacao.iterator(); iterator.hasNext();) {
            ComboMoedaOperacaoVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCindcdeconmmoeda(), comboVO.getCindcdfontecons() + " - "
                    + comboVO.getIsglindcdfonte()));
        }

        return list;
    }

    /**
     * Nome: getMomento
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getMomentoJuros(Integer rotina, Integer codProduto) {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM2, "Postecipado"));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "Antecipado"));
        
        if (rotina.equals(EnumTradeFinance.COMISSAO_INTERNA.getCodigo())) {
            listaSelectItem.add(new SelectItem(Numeros.NUM3, "�nico"));
        }	

        return listaSelectItem;
    }

    /**
     * Nome: getCodigoBaseJuros
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getCodigoBaseJuros() {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM0, "ao ano"));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "ao m�s"));
        listaSelectItem.add(new SelectItem(Numeros.NUM2, "ao bimestre"));
        listaSelectItem.add(new SelectItem(Numeros.NUM3, "ao trimestre"));
        listaSelectItem.add(new SelectItem(Numeros.NUM6, "ao semestre"));

        return listaSelectItem;
    }

    /**
     * Nome: getSituacao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 19/10/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getSituacao() {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM0, "Selecione..."));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "A desembolsar"));
        listaSelectItem.add(new SelectItem(Numeros.NUM2, "Desembolsadas"));

        return listaSelectItem;
    }
    
    /**
     * Nome: getCodigoCobrancaComissao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getCodigoCobrancaComissao() {

        List<SelectItem> list = new ArrayList<SelectItem>();

        for (EnumCobrancaComissao enumValue : EnumCobrancaComissao.values()) {
            if (!SiteUtil.isEmptyOrNull(enumValue.getCodigo())) {
                list.add(new SelectItem(enumValue.getCodigo(), enumValue.getDescricao()));                
            }
        }

        return list;
    }

    /**
     * Nome: getCodigoComissaoSobre
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboComissaoSobre() {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(EnumComissaoSobre.TOTAL.getCodigo(), EnumComissaoSobre.TOTAL.getDescricao()));
        listaSelectItem.add(new SelectItem(EnumComissaoSobre.SALDO_DEVEDOR.getCodigo(), EnumComissaoSobre.SALDO_DEVEDOR.getDescricao()));

        return listaSelectItem;
    }

    /**
     * Nome: getCodigoTipoCotacao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getCodigoTipoCotacao() {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM0, "Selecione..."));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "Indicativa"));
        listaSelectItem.add(new SelectItem(Numeros.NUM2, "Firme"));

        return listaSelectItem;
    }

    /**
     * Nome: getCodigoPtax
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 12/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getCodigoPtax() {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM0, "Selecione..."));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "D-0"));
        listaSelectItem.add(new SelectItem(Numeros.NUM2, "D-1"));
        listaSelectItem.add(new SelectItem(Numeros.NUM3, "D-2"));

        return listaSelectItem;
    }

    /**
     * 
     * Nome: getComboMotivoPerda
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboMotivoPerda() {

        List<SelectItem> listaMotivoPerda = new ArrayList<SelectItem>();
        List<MotivoPerdaVO> lista = commonService
                .getComboMotivoPerda(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo());
        // adiciona a lista o item selecione
        listaMotivoPerda.add(new SelectItem(Numeros.ZERO, SELECIONE));

        for (Iterator<MotivoPerdaVO> iterator = lista.iterator(); iterator.hasNext();) {
            MotivoPerdaVO motivoPerdaVO = (MotivoPerdaVO) iterator.next();
            listaMotivoPerda.add(new SelectItem(motivoPerdaVO.getCmotvobletocmbio(), motivoPerdaVO
                    .getRmotvobletocmbio()));
        }

        return listaMotivoPerda;
    }

    /**
     * Nome: getPeriodicidade
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 05/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getPeriodicidade(Integer codFluxo) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        // Executa chamada CWS - Fluxo: NPCCIAOZ - Books: NPCCWWUE / NPCCWWUS
        List<ComboCotacaoVO> listPeriodicidade = commonService.getComboPeriodicidade(codFluxo);

        // adiciona a lista o item selecione
        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        for (Iterator<ComboCotacaoVO> iterator = listPeriodicidade.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCfluxoperdccmbio(), comboVO.getIfluxoperdccmbio()));
        }

        return list;
    }

    /**
     * Nome: getPeriodicidadeComissAdicional
     * 
     * Prop�sito: Carrega o combo de periodicidade para Comiss�o adicional, excluindo o item "�nica" do combo
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public List<SelectItem> getPeriodicidadeComissAdicional(Integer codFluxo) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        // Executa chamada CWS - Fluxo: NPCCIAOZ - Books: NPCCWWUE / NPCCWWUS
        List<ComboCotacaoVO> listPeriodicidade = commonService.getComboPeriodicidade(codFluxo);

        // adiciona a lista o item selecione
        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        for (Iterator<ComboCotacaoVO> iterator = listPeriodicidade.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            //Inclui todas as periodicidade menos o "13 - �nica"
            if(comboVO.getCfluxoperdccmbio() != 13 || !comboVO.getIfluxoperdccmbio().equals("�nica"))
            	list.add(new SelectItem(comboVO.getCfluxoperdccmbio(), comboVO.getIfluxoperdccmbio()));
        }

        return list;
    }
    /**
     * Nome: getTipoComissao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 12/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTipoComissao(Integer codProduto, Integer tela) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        // Executa chamada CWS - Fluxo: NPCDIAA3 - Books: NPCDWA3E / NPCDWA3S
        List<ComboCotacaoVO> listTipoComissoes = commonService.getComboTipoComissoes(codProduto, tela);
        
        // adiciona a lista o item selecione
        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        for (Iterator<ComboCotacaoVO> iterator = listTipoComissoes.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCcondceconc(), comboVO.getIcondeconc()));
        }

        return list;
    }

    /**
     * Nome: getTarifas
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 12/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getTarifas(Integer codProduto, String filtro) {

        List<SelectItem> list = new ArrayList<SelectItem>();

        List<ComboCotacaoVO> listTipoComissoes = commonService.getComboTarifas(codProduto, filtro);
        
        list.add(new SelectItem(Numeros.ZERO, SELECIONE));

        for (Iterator<ComboCotacaoVO> iterator = listTipoComissoes.iterator(); iterator.hasNext();) {
            ComboCotacaoVO comboVO = iterator.next();
            list.add(new SelectItem(comboVO.getCtpodespcmbio(), comboVO.getDtpodespcmbio()));
        }

        return list;
    }

    /**
     * 
     * Nome: getComboSegmento
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 26/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboSegmento() {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ComboSegmentoVO> listaSeg = commonService.getComboSegmento();

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        for (Iterator<ComboSegmentoVO> ite = listaSeg.iterator(); ite.hasNext();) {
            ComboSegmentoVO segmentoVO = ite.next();
            lista.add(new SelectItem(segmentoVO.getCtposgmtocli(), segmentoVO.getItpossgtound()));
        }

        return lista;

    }

    /**
     * 
     * Nome: getComboPaisRestricao
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 26/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboPaisRestricao() {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ComboPaisRestricaoVO> listaPais = commonService.getComboPaisRestricao();

        Iterator<ComboPaisRestricaoVO> ite = listaPais.iterator();

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        while (ite.hasNext()) {
            ComboPaisRestricaoVO paisRestricaoVO = ite.next();
            lista.add(new SelectItem(paisRestricaoVO.getCodpais(), paisRestricaoVO.getNomepais()));
        }

        return lista;
    }

    /**
     * 
     * Nome: getComboUnidadeExterna
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboUnidadeExterna() {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<TradeFinNegocListasVO> listaUnid = commonService.listarPaginacaoAutomaticaUnidExterna();

        Iterator<TradeFinNegocListasVO> ite = listaUnid.iterator();

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        while (ite.hasNext()) {
            TradeFinNegocListasVO listasVO = ite.next();
            lista.add(new SelectItem(listasVO.getCmunintlcmbio(), listasVO.getImunintlcmbio()));
        }

        return lista;
    }

    /**
     * 
     * Nome: getComboUnidadeExterna
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboUnidadeNegocio() {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ComboUnidadeNegocioVO> listaUnid = commonService.getComboUnidadeNegocioList();

        Iterator<ComboUnidadeNegocioVO> ite = listaUnid.iterator();

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        while (ite.hasNext()) {
            ComboUnidadeNegocioVO listasVO = ite.next();
            // TODO CONFIRMAR ATRIBUTOS CARREGADOS NO COMBO
            lista.add(new SelectItem(listasVO.getNsequndsubr(), listasVO.toString()));
        }

        return lista;
    }

    /**
     * 
     * Nome: getListaSituacaoBoleto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getListaSituacaoBoleto() {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ListaSituacaoBoletoVO> situacao = commonService.getListaSituacaoBoleto(
                EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(), null);

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        for (Iterator<ListaSituacaoBoletoVO> ite = situacao.iterator(); ite.hasNext();) {
            ListaSituacaoBoletoVO situacaoVO = ite.next();
            lista.add(new SelectItem(situacaoVO.getCsitbletocmbio(), situacaoVO.getIsitbletocmbio()));

        }
        return lista;
    }

    /**
     * 
     * Nome: getListaSituacaoBoleto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    // public List<SelectItem> getListaSituacaoBoletoAgex(String ctipoPesquisa)
    // {
    public List<SelectItem> getListaSituacaoBoletoAgex(Integer ctipoPesquisa) {

        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ListaSituacaoBoletoVO> situacao = commonService.getListaSituacaoBoletoAgex(
                EnumProduto.CODIGO_DA_MESA_TRADE_AGEX.getCodigo(), Numeros.ZERO, ctipoPesquisa);

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        for (Iterator<ListaSituacaoBoletoVO> ite = situacao.iterator(); ite.hasNext();) {
            ListaSituacaoBoletoVO situacaoVO = ite.next();
            lista.add(new SelectItem(situacaoVO.getCsitbletocmbio(), situacaoVO.getIsitbletocmbio()));
        }
        return lista;
    }

    /**
     * 
     * Nome: getComboTipoGarantia
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboTipoGarantia(Integer cdProd) {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<ComboTipoGarantiaVO> tpGaran = commonService.listarGarantiasAdicionais(cdProd);

        for (Iterator<ComboTipoGarantiaVO> ite = tpGaran.iterator(); ite.hasNext();) {
            ComboTipoGarantiaVO combo = ite.next();
            lista.add(new SelectItem(combo.getCdgarnt(), combo.getDsgarnt()));
        }

        return lista;
    }

    /**
     * Nome: getPeriodoDaTaxa
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getPeriodoDaTaxa(Integer codProduto) {

        List<SelectItem> listaSelectItem = new ArrayList<SelectItem>();

        listaSelectItem.add(new SelectItem(Numeros.NUM0, "A.A."));
        listaSelectItem.add(new SelectItem(Numeros.NUM1, "A.M."));
        listaSelectItem.add(new SelectItem(Numeros.NUM7, "Flat"));

        //Se os produtos for de Garantia Internacional Expedida, adiciona 'Custo Fixo' 
        if(EnumProduto.fromCode(codProduto).isGarantia()) {
            listaSelectItem.add(new SelectItem(Numeros.NUM8, "Custo Fixo"));
        }

        //Se produto for L/C de Importa��o, adiciona 'A.T.'
        if(EnumProduto.fromCode(codProduto).equals(EnumProduto.LC_IMPORTACAO)) {
        	listaSelectItem.add(new SelectItem(Numeros.NUM3, "A.T."));
        }

        listaSelectItem.add(new SelectItem(Numeros.NUM9, "All In"));
        
        return listaSelectItem;
    }
    
    public List<SelectItem> getComboTomador(Long aprovCredito) {
        List<SelectItem> lista = new ArrayList<SelectItem>();

        List<TradeFinanceListaVO> listaTomador = commonService.getComboTomador(aprovCredito);

        if (listaTomador.size() > 0) {
            lista.add(new SelectItem(Numeros.NUM0_LONG, SELECIONE));
            for (Iterator<TradeFinanceListaVO> ite = listaTomador.iterator(); ite.hasNext();) {
                TradeFinanceListaVO itemVO = ite.next();
                lista.add(new SelectItem(itemVO.getCpssoa(), itemVO.getNmbnefc()));
            }
        }

        return lista;

    }

    public List<SelectItem> getModalidade(Integer codProduto) {

        List<SelectItem> lista = new ArrayList<SelectItem>();

        if (codProduto <= Numeros.ZERO) {
            return lista;
        }

        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));

        List<ComboModalidadeVO> listModalidade = commonService.getComboModalidade(codProduto);


        Comparator<ComboModalidadeVO> crescente = new ComparatorModalidade();
        // Em ordem crescente do in�cio do mandato
        Collections.sort(listModalidade, crescente);  
        
        for (Iterator<ComboModalidadeVO> iterator = listModalidade.iterator(); iterator.hasNext();) {
            ComboModalidadeVO comboModalidadeVO = (ComboModalidadeVO) iterator.next();
            lista.add(new SelectItem(comboModalidadeVO.getCmodldprodtcmbio(), comboModalidadeVO.getImodldprodtcmbio()));
        }

        return lista;
    }
    
    /**
      * Nome: SelectItemBean.java
      * 
      * Prop�sito: <p> </p>
      *
      * @author :  BRQ<BR/>
      * Equipe : Web <BR>
      * @version:  1.5
      *          Parametro  de compila��o -d
      *
      * @see : Referencias externas. 
      *
      * Registro  de Manuten��o: 09/06/2016
      *	- Autor: BRQ
      *	- Responsavel: Equipe Web
      *	_ Ajuste para deixar no padr�o hexavision.
    */
    class ComparatorModalidade implements Comparator<ComboModalidadeVO> {
        public int compare(ComboModalidadeVO p1, ComboModalidadeVO p2) {
            return ((ComboModalidadeVO)p1).getImodldprodtcmbio()
                    .compareTo(((ComboModalidadeVO)p2).getImodldprodtcmbio());
        }
    }
    
    /**
     * Select item para campos Operador. Dados do MF
     */
    public List<SelectItem> getOperador() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        List<OperadorVO> listaOperador = commonService.getComboOperador();

        // N�o alterar esse campo. String vazia quer dizer que quando eu deixo no campo selecione e informo ao mainframe
        // ele espera em forma de CHAR, quer dizer um campo vazio.
        lista.add(new SelectItem("", SELECIONE));
        for (Iterator<OperadorVO> iterator = listaOperador.iterator(); iterator.hasNext();) {
            OperadorVO operadorVO = iterator.next();
            lista.add(new SelectItem(operadorVO.getCusuarincl(), operadorVO.getCusuarincl() + " - " + operadorVO.getNmusuarinc()));
        }

        return lista;
    }
    
    /**
     * Nome: getComboPrazo
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboPrazo() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "� Vista"));
        lista.add(new SelectItem(Numeros.DOIS, "Prazo"));
        lista.add(new SelectItem(Numeros.TRES, "Mixed Payment"));
        return lista;
    }
    
    /**
     * Nome: getComboAVistaPrazo
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboAVistaPrazo() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "� Vista"));
        lista.add(new SelectItem(Numeros.DOIS, "Prazo"));
        return lista;
    }
    
    /**
     * Nome: getComboPorConta
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboPorConta() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "Importador"));
        lista.add(new SelectItem(Numeros.DOIS, "Exportador"));
        return lista;
    }
    
    /**
     * Nome: getComboPorContaGarantia
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/10/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboPorContaGarantia() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.TRES, "Cliente"));
        lista.add(new SelectItem(Numeros.QUATRO, "Benefici�rio"));
        return lista;
    }
    
    /**
     * Nome: getComboTipoDespesas
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboTipoDespesas() {
        
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));

        // Fluxo: NPCDIAA3 - Books: NPCDWA3E / NPCDWA3S
        List<ComboTipoDespesasVO> listaDespesas = commonService.getComboTipoDespesas();

        for (Iterator<ComboTipoDespesasVO> iterator = listaDespesas.iterator(); iterator.hasNext();) {
            ComboTipoDespesasVO tipoDespesasVO = iterator.next();
            lista.add(new SelectItem(tipoDespesasVO.getCtpodespcmbio(), tipoDespesasVO.getDtpodespcmbio()));
        }

        return lista;
    }

    /**
     * Nome: getComboDocumentosConsignados
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/06/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboDocumentosConsignados() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "Importador"));
        lista.add(new SelectItem(Numeros.DOIS, "Banco Bradesco"));
        lista.add(new SelectItem(Numeros.TRES, "Outros"));
        return lista;
    }
    
    /**
     * Nome: getComboFormaPagamento
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 20/07/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboFormaPagamento() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "Antecipado"));
        lista.add(new SelectItem(Numeros.DOIS, "Postecipado"));
        return lista;
    }       
    
    /**
     * 
    	* Nome: getComboFormaPagamento
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 10/08/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
     */
    public ArrayList<SelectItem> getComboFuncao() {
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(Numeros.ZERO, SELECIONE));
        lista.add(new SelectItem(Numeros.UM, "Reembolsador"));
        lista.add(new SelectItem(Numeros.DOIS, "Confirmador"));
        lista.add(new SelectItem(Numeros.TRES, "Avisador"));
        return lista;
    }
    
    
    
    /**
     * Nome: getComboStatusSwap
     * 
     * Prop�sito: Monta a lista do combo Status da tela "Agenda de Opera��es Swap"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboStatusSwap() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(" ", SELECIONE));
        items.add(new SelectItem(Numeros.UM, "Em ser"));
        items.add(new SelectItem(Numeros.DOIS, "Baixado"));
        return items;
    }      
    
    /**
     * Nome: getComboStatusSwap
     * 
     * Prop�sito: Monta a lista do combo Status da tela "Agenda de Opera��es Swap"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboProdutoVincularLC() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(" ", SELECIONE));
        items.add(new SelectItem(EnumProduto.PRODUTO_FINIMP_DIRETO.getCodigo(), EnumProduto.PRODUTO_FINIMP_DIRETO.getDescricao()));
        items.add(new SelectItem(EnumProduto.PRODUTO_FINIMP_INDIRETO.getCodigo(), EnumProduto.PRODUTO_FINIMP_INDIRETO.getDescricao()));
        items.add(new SelectItem(EnumProduto.FINIMP_ECA.getCodigo(), EnumProduto.FINIMP_ECA.getDescricao()));
        return items;
    }
    
    /**
     * Nome: getcomboPrazoProex
     * 
     * Prop�sito: Monta modalidade de prazo para proex
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getComboPrazoProex() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        items.add(new SelectItem(EnumPrazoProex.DIAS.getCodigo(), EnumPrazoProex.DIAS.getDescricao()));
        items.add(new SelectItem(EnumPrazoProex.MESES.getCodigo(), EnumPrazoProex.MESES.getDescricao()));
        items.add(new SelectItem(EnumPrazoProex.ANOS.getCodigo(), EnumPrazoProex.ANOS.getDescricao()));
        return items;
    }
    
}
