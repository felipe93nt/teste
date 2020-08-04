package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DadosGerarBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoVinculadaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.TrataErroUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.SessionBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.aditar.TradeFinAditarBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.prgAlong.TradeFinPrgAlongBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoInclBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: TradeFinMonitBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Monitor - Trade Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

@Named("tradeFinMonitBean")
@SessionScoped
public class TradeFinMonitBean extends TradeFinMonitBaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 4807885081576357960L;

    /** Variavel do tipo String. */
    private char[] produtoAndSituacaoBinario = new char[15];
    
	@Inject
    @Named("tradeFinPrgAlongBean")
    private TradeFinPrgAlongBean tradeFinPrgAlongBean;
    
    @Inject
    @Named("tradeFinAditarBean")
    private TradeFinAditarBean tradeFinAditarBean;
    
    @Inject
    @Named("tradeFinanceNegociacaoInclBean")
    private TradeFinanceNegociacaoInclBean tradeFinanceNegociacaoInclBean;
    
    /**
     * Construtor
     * 
     * @param
     */
    public TradeFinMonitBean() {
        super();
    }

    /**
     * 
     * Nome: iniciar
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
    public String iniciar() {

        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciar <<<<<<<<<<<");
            
            // Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);
                
                listenerLimparPesquisa(null);
                limparCpfCnpjCliente(null);                
                
        
                getViewHelper().setTradeFinanceMonitor(Numeros.UM);
                getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        
                // carrega combos
                setProduto(getSelectItemBean().getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
        
                // carregar combos da tela monitor
                getViewHelper().setComboSegmento(getSelectItemBean().getComboSegmento());
                getViewHelper().setComboStatus(getSelectItemBean().getListaSituacaoBoleto());
                getViewHelper().setComboOperador(getSelectItemBean().getOperador());
                getViewHelper().setComboMoeda(getSelectItemBean().getMoeda());
                getViewHelper().setComboUnidadeNegocio(getSelectItemBean().getComboUnidadeNegocio());
                getViewHelper().setComboPaisRestricao(getSelectItemBean().getComboPaisRestricao());
        
                getViewHelper().setDisabledBotaoDetGar(true);
                setProdutoAndSituacaoBinario(StringUtils.leftPad(Integer.toBinaryString(0), Numeros.QUINZE, "0").toCharArray());
        
                getViewHelper().setCnpjBinding(new UICnpj());
                getViewHelper().setCpfBinding(new UICpf());
                
                tradeFinanceBean.getViewHelper().setDisabledBotaoDetGar(true);
                
                if(tradeFinanceBean.getViewHelper().getGerarBoletoDuplicar() != null 
                        && tradeFinanceBean.getViewHelper().getGerarBoletoDuplicar().getGerarBoleto()) {
                    iniciarPesquisaGerarBoleto();
                }
                
            }
    
            return "tradeFinMonitList";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciar <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: habilitaMonitBotoes
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void habilitaMonitBotoes(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.habilitaMonitBotoes  <<<<<<<<<<<");
	
	        setTradeFinanceListaVO(getLista().get(SiteUtil.getInt(getViewHelper().getCtcSelecionado())));
	
	        int codigoProdutoSelecionado = tradeFinanceListaVO.getProduto().getCodigo();
	                
	        // Recebe o código binário referente aos botões de produto e situação selecionados
	        String produtoBinario = getLista().get(SiteUtil.getInt(getViewHelper().getCtcSelecionado())).getEnumAcaoProduto().getChave();
	        String situacaoBinario = getLista().get(SiteUtil.getInt(getViewHelper().getCtcSelecionado())).getEnumAcaoSituacao().getChave();
	
	        String gerarBoletoBinario = "111111111101111";
	        // Habilita botão 'Gerar Boleto' se cotação tiver modelo de boleto.
	        if (!SiteUtil.isEmptyOrNull(getTradeFinanceListaVO().getCmodcontrcmbio())) {
	            gerarBoletoBinario = "111111111111111";
	        } 
	        
	        if (getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Perdido") || 
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Aguardando DSN") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Baixada") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Pendente complemento") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Pendente custo externo") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Pendente de unidade externa") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Recotar custo externo") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Devolvido") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Divergente") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Divergente div. Int.") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Divergência Devolvida") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Pendente – Desenquadrada") ||
        		getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Perdido – Desenquadrada")) {
	        		
	        	// Desabilita Botão Gerar Boleto
	        	gerarBoletoBinario = "111111111101111";
	        } if (codigoProdutoSelecionado == 644 && getTradeFinanceListaVO().getDsitbletocmbio().equalsIgnoreCase("Em negociação")) {
	        	// Habilita botão Gerar Boleto
	        	gerarBoletoBinario = "111111111111111";
	        }
	        
	        // Se o status tiver como pendente de aprovação(01), habilitar somente o botão da consulta.
	        String pendenteCotacaoBinario = "111111111111111";
	        if (getTradeFinanceListaVO().getCsitbletoaprov() == Numeros.UM) {
	        	pendenteCotacaoBinario = "000000010000001";
	        }
	        
	        // Converte o código binário para inteiro e faz a comparação(AND) entre eles
	        int produtoInteiro = Integer.parseInt(produtoBinario, 2);
	        int situacaoInteiro = Integer.parseInt(situacaoBinario, 2);
	        int gerarBoletoInteiro = Integer.parseInt(gerarBoletoBinario, 2);
	        int pendenteCotacaoInteiro = Integer.parseInt(pendenteCotacaoBinario, 2);
	        int produtoAndSituacaoInteiro = produtoInteiro & situacaoInteiro & gerarBoletoInteiro & pendenteCotacaoInteiro;
	
	        // Converte o número inteiro para binário e adiciona, caso necessário, espaços a esquerda.
	        setProdutoAndSituacaoBinario(StringUtils.leftPad(Integer.toBinaryString(produtoAndSituacaoInteiro),Numeros.QUINZE, "0").toCharArray());
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.habilitaMonitBotoes  <<<<<<<<<<<");
    	}	        

    }

    /**
     * 
     * Nome: consultar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String consultar() {
    	String proximaTela = null;
    	
    	try {
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.consultar  <<<<<<<<<<<");

	        // Verifica se a chamada foi feita pela URL, ou se há um item selecionado na lista
	        if (hasQueryString()) {
	        	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Acesso Externo] TradeFinMonitBean.consultar  <<<<<<<<<<<");
	        	
	            Map<String, String> params = getQueryString();

	            if (params.containsKey("boleto") && params.containsKey("produto")) {
	            	forceBuildSession();
	                setExternalAccess(true);
	                tradeFinanceBean.setExternalAccess(true);

	                getTradeFinanceListaVO().setNbletonegoccmbio(Long.parseLong(params.get("boleto")));
	                getTradeFinanceListaVO().setCprodtservc(Integer.parseInt(params.get("produto")));
	            }
	        } else {
	            setExternalAccess(false);
	            tradeFinanceBean.setExternalAccess(false);
	        }
	    	
	        
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	        tradeFinanceBean.setFluxoPgtVO(new FluxoPagamentoVO());
	        tradeFinanceBean.setFluxoPgtList(new ArrayList<FluxoPagamentoVO>());
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_CONSULTAR);
	        
	        if(getTradeFinanceBean().getTradeFinanceVO().getRestricoes() != null && getTradeFinanceBean().getTradeFinanceVO().getRestricoes().size() > 0) {
	            getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.TRUE);
	        } else {
	            getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.FALSE);
	        }
	        
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	        	proximaTela = "finimpDiretoCons";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	        	proximaTela = "refinimpDiretoCons";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	        	proximaTela = "finimpIndiretoCons";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	        	proximaTela = "refinimpIndiretoCons";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	        	proximaTela = "lei4131Cons";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	        	proximaTela = "cotacaoPPECons";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	        	proximaTela = "workingCapitalCons";
	        }
	
	        // FORFAITING 644
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
//                carregarQuadroJurosForfaiting();
	
	        	proximaTela = "forfaitingCons";
	        }
	
	        // BNDES PRE
	        if (tradeFinanceListaVO.getProduto().isBndesPre()) {
	
	        	proximaTela = "bndesPreCons";
	        }
	
	        // BNDES POS
	        if (tradeFinanceListaVO.getProduto().isBndesPos()) {
	
	        	proximaTela = "bndesPosCons";
	        }
	
	        // NCE
	        if (tradeFinanceListaVO.getProduto().isNce()) {
	
	            // TODO RENDER TEMPORARIO
	            tradeFinanceBean.getViewHelper().setRenderLastroLca(Boolean.TRUE);
	            
	            proximaTela = "nceCons";
	        }
	
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
	        	proximaTela = "finimpEcaCons";
	        }
	
	        // PROEX 642
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
	        	proximaTela = "proexCons";
	        }
	
	        // GARANTIA INTERNACIONAL EXPEDIDAS
	        if (tradeFinanceListaVO.getProduto().isGarantia()) {
	        	proximaTela = "garantiaIntExpCons";
	        }
	
	        // LC IMPORTAÇÃO 2018
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	        	proximaTela = "lcImportacaoCons";
	        }
	        
	        // Caso seja um acesso externo altera o caso de navegação
	        if (isExternalAccess()) {
	            setNavigationData(getNavigationCaseUrl(proximaTela));
	        }
    	
    	} catch (NpccTradeWebException e) {
    		// Apenas faz o tratamento abaixo se for uma tentativa de acesso externo
            if (isExternalAccess()) {
            	String mensagem = null;

                // Se não possuir mensagem de erro, pode ser erro no conector
                if (SiteUtil.isEmptyOrNull(e.getMessage())) {
                    // Verifica se a causa é do erro do conector
                    if (e.getCause() != null && e.getCause() instanceof CTGServiceException) {
                        mensagem = ((CTGServiceException) e.getCause()).getMessage();
                    }
                } else {
                    mensagem = e.getMessage();
                }
                
                // Obtem o bean de sessao para armazenar a mensagem
            	SessionBean sessionBean = evaluateExpression("#{sessionBean}");
            	
            	// Validação de nulidade
            	if (sessionBean != null) {
            		sessionBean.setErrorMessage(mensagem);
            	}
	    		
            	// Reinicia o view object da tela
		        setTradeFinanceVO(new TradeFinanceVO());
		        
		        // Redireciona para a tela de erro padrão para os casos de acesso externo
		        redirectTo("/template/errorPages/externalError.xhtml");
		        
		        return null;
            } else {
            	throw e;
            }
    	} finally {
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.consultar  <<<<<<<<<<<");
    	}
    	
		return proximaTela;
    }
    
    public String actionExportar(){
        return super.actionExportar(true);
    }

    /**
     * 
     * Nome: iniciarFunding
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarFunding() {
    	
    	try{
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarFunding  <<<<<<<<<<<");
	    	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_FUNDING);
	
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoFndg";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoFndg";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoFndg";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoFndg";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Fndg";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEFndg";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalFndg";
	        }
	
	        // FORFAITING 644
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	
	            return "forfaitingConsFndg";
	        }
	
	        return null;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarFunding  <<<<<<<<<<<");
    	}
    }
    
    	/**
    	* Nome: iniciarIncluirDesembolsos
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 15/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String iniciarIncluirDesembolsos() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarIncluirDesembolsos  <<<<<<<<<<<");
            
            if (tradeFinanceListaVO.getNbletonegoccmbio() == null
                            || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
                NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
                return "";
            }
    
            tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_INC_DESEMBOLSO);
            
            // informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
            // de alteração devem ser carregados
            tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
    
            // FORFAITING 644
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
    
                return "forfaitingInclDesemb";
            }
    
            return null;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarIncluirDesembolsos  <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: fechar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void iniciarFechar() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarFechar  <<<<<<<<<<<");
	    	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return;
	        }
	        
	        getViewHelper().setRenderModalFecharLC(Boolean.FALSE);
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_FECHAR);
	        
	        // Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
	
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	            
	            redirectTo(getNavigationCaseUrl("finimpDiretoFch"));
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            redirectTo(getNavigationCaseUrl("refinimpDiretoFch"));
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            redirectTo(getNavigationCaseUrl("finimpIndiretoFch"));
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            redirectTo(getNavigationCaseUrl("refinimpIndiretoFch"));
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            redirectTo(getNavigationCaseUrl("lei4131Fch"));
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            redirectTo(getNavigationCaseUrl("cotacaoPPEFch"));
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            redirectTo(getNavigationCaseUrl("workingCapitalFch"));
	        }
	
	        // FORFAITING 644
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	
	            redirectTo(getNavigationCaseUrl("forfaitingConsFch"));
	        }
	
	        // ECA 1715
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
	
	            redirectTo(getNavigationCaseUrl("finimpEcaFch"));
	        }
	
	        // PROEX(2018)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
	
	            redirectTo(getNavigationCaseUrl("proexFch"));
	        }
	        
	        //LC de Importação (2018)
	        if(tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	            redirectTo(getNavigationCaseUrl("lcImportacaoFch"));
	        }
	        
	        //NCE(1713, 622, 624, 638,639,640)
	        if(tradeFinanceListaVO.getProduto().isNce()) {
	            redirectTo(getNavigationCaseUrl("nceFch"));
	        }
	        
	        //BNDES PRE(663, 664, 665, 666, 667, 670, 3934)
	        if(tradeFinanceListaVO.getProduto().isBndesPre()) {
	            redirectTo(getNavigationCaseUrl("bndesPreFch"));
	        }
	        
	        // BNDS POS(661, 662)
	        if(tradeFinanceListaVO.getProduto().isBndesPos()) {
	            redirectTo(getNavigationCaseUrl("bndesPosFch"));
	        }
	        
	        // GARANTIA(17,69,3933)
	        if(tradeFinanceListaVO.getProduto().isGarantia()) {
	            redirectTo(getNavigationCaseUrl("garantiaIntExpFch"));
	        }
	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarFechar  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: iniciarBaixar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarBaixar() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarBaixar  <<<<<<<<<<<");
	    	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_BAIXAR);
	        
	        if(getTradeFinanceBean().getTradeFinanceVO().getRestricoes() != null && getTradeFinanceBean().getTradeFinanceVO().getRestricoes().size() > 0) {
                getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.TRUE);
            } else {
                getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.FALSE);
            }
	
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoBaixa";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoBaixa";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoBaixa";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoBaixa";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Baixa";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEBaixa";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalBaixa";
	        }
	
	        // FORFAITING 644
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	
	            return "forfaitingConsBaixa";
	        }
	        
	        // FINIMP ECA (1715)
    		if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
    			
    			return "finimpEcaBaixa";
    		}
    		
    		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
    		if (tradeFinanceListaVO.getProduto().isNce()) {
    			
    			return "nceBaixa";
    		}
    		
    		// GARANTIA (1769, 39333)
    		if(tradeFinanceListaVO.getProduto().isGarantia()) {
    		    return "garantiaIntExpBaixa";
    		}

		    // BNDES PRE (663, 664, 3934, 665, 666, 667, 670)
	        if (tradeFinanceListaVO.getProduto().isBndesPre()) {
	        	
				return "bndesPreBaixa";
			}

	        // BNDES POS
	        if (tradeFinanceListaVO.getProduto().isBndesPos()) {
	        	
				return "bndesPosBaixa";
			}
	        
	        // PROEX (642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
	        	
				return "proexBaixa";
			}
	        
	        // LC IMPORTAÇÃO 2018
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	        	
	        	return "lcImportacaoBaixa";
	        }
	        
	
	        return null;
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarBaixar  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: iniciarPerdido
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarPerdido() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarPerdido  <<<<<<<<<<<");
	    	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_PERDIDO);
	        
	        if(getTradeFinanceBean().getTradeFinanceVO().getRestricoes() != null && getTradeFinanceBean().getTradeFinanceVO().getRestricoes().size() > 0) {
                getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.TRUE);
            } else {
                getTradeFinanceBean().getTradeFinanceVO().setRenderRestricoes(Boolean.FALSE);
            }
	
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoPrd";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoPrd";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoPrd";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoPrd";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Prd";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEPrd";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalPrd";
	        }
	
	        // FORFAITING (644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	
	            return "forfaitingConsPrd";
	        }
	        
	        // Proex (642)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
    
                return "proexPrd";
            }
            
            // N.C.E 
            if (tradeFinanceListaVO.getProduto().isNce()) {
    
                return "ncePrd";
            }
            
            // BNDES PRE
            if (tradeFinanceListaVO.getProduto().isBndesPre()) {
    
                return "bndesPrePrd";
            }
            
            // BNDES POS
            if (tradeFinanceListaVO.getProduto().isBndesPos()) {
    
                return "bndesPosPrd";
            }
            
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
	            return "finimpEcaPrd";
	        }
	
	        // GARANTIA INTERNACIONAL EXPEDIDAS
	        if (tradeFinanceListaVO.getProduto().isGarantia()) {
	            return "garantiaIntExpPrd";
	        }
	
	        // LC IMPORTAÇÃO 2018
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	            return "lcImportacaoPrd";
	        }
	
	        return null;
    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarPerdido  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: iniciarAlterar
     * 
     * Propósito: Carrega os dados do boleto e redireciona para tela de alteração
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarAlterar() {
    	
    	try{
    		
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarAlterar  <<<<<<<<<<<");
    		
    		setFuncaoExecutando(EnumTradeFinance.FUNCAO_TIPO_INCLUSAO.getCodigo());
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_ALTERAR);
	
	        // informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
	        // de alteração devem ser carregados
	        tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
	        
	        // Verifica a situação para do piloto e cliente ativo
	        situacaoPiloto();
	        
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoAlt";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoAlt";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoAlt";
	        }
	        
	        // PROEX (642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
	        	
				return "proexAlt";
			}
	        
	        // LC IMPORTAÇÃO 2018
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
	        	
	        	return "lcImportacaoAlt";
	        }
	        	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoAlt";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Alt";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEAlt";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalAlt";
	        }
	
	        // FORFAITING 644
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	
	            return "forfaitingAlt";
	        }
	        
    		// FINIMP ECA (1715)
    		if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
    			
    			return "finimpEcaAlt";
    		}
    		
    		// COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
    		if (tradeFinanceListaVO.getProduto().isNce()) {
    			
    			return "nceAlt";
    		}
    		
    		// GARANTIA (1769, 39333)
    		if(tradeFinanceListaVO.getProduto().isGarantia()) {
    		    return "garantiaIntExpAlt";
    		}

		    // BNDES PRE (663, 664, 3934, 665, 666, 667, 670)
	        if (tradeFinanceListaVO.getProduto().isBndesPre()) {
	        	
				return "bndesPreAlt";
			}

	        // BNDES POS
	        if (tradeFinanceListaVO.getProduto().isBndesPos()) {
	        	
				return "bndesPosAlt";
			}
	        
	        
	        return null;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarAlterar  <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: iniciarDivergente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarDivergente() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarDivergente  <<<<<<<<<<<");
	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_DIVERGENTE);
	
	        // informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
	        // de alteração devem ser carregados
	        tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
	        
	        // Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
	
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoDvgt";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoDvgt";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoDvgt";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoDvgt";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Dvgt";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEDvgt";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalDvgt";
	        }
	        
            // FORFAITING (644)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
                
                return "forfaitingDvgt";
            }
	        
	        // PROEX (642)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
    
                return "proexDvgt";
            }
            
	        // BNDES PRE
	        if (tradeFinanceListaVO.getProduto().isBndesPre()) {
	        	
				return "bndesPreDvgt";
			}
            
	        // BNDES POS
	        if (tradeFinanceListaVO.getProduto().isBndesPos()) {
	
				return "bndesPosDvgt";
	        }
	        
	        // NCE
            if (tradeFinanceListaVO.getProduto().isNce()) {
    
                return "nceDvgt";
            }

            //GARANTIA
            if(tradeFinanceListaVO.getProduto().isGarantia()) {
                return "garantiaIntExpDvgt";
            }
            
            // LC Importacao
            if(tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                return "lcImportacaoDvgt";
            }
            
            // FINIMP ECA
            if(tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                return "finimpEcaDvgt";
            }
	
	        return null;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarDivergente  <<<<<<<<<<<");
    	}
    }

    /**
     * Nome: iniciarDuplicar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarDuplicar() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarDuplicar  <<<<<<<<<<<");
	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_DUPLICAR);
	        //segundo Kanban
	        //O processo de Duplicar não deverá trazer as Operações Vinculadas da cotação original.
	        //Este conceito é válido para todos produtos do Mesa Trade.
	        tradeFinanceBean.setOprVincList(new ArrayList<OperacaoVinculadaVO>());
	        
	        // Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
	        
	        // NCE
            if(tradeFinanceListaVO.getProduto().isNce()){   

            	tradeFinanceNegociacaoInclBean.getViewHelper().setCheckPercCDI(Boolean.FALSE);
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPtxcdifinan(SiteUtil.formatarValorWeb(Numeros.ZERO));
            	tradeFinanceNegociacaoInclBean.getViewHelper().setCheckMaisCDI(Boolean.FALSE);
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPcdimaiscmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
        		tradeFinanceNegociacaoInclBean.getViewHelper().setCheckTaxaPre(Boolean.FALSE);
        		tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPfixajurocmbio(SiteUtil.formatarValorWeb(Numeros.ZERO));
            	
            	if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPtxcdifinan()) == false){
            		tradeFinanceNegociacaoInclBean.getViewHelper().setCheckPercCDI(Boolean.TRUE);
            		tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPtxcdifinan(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPtxcdifinan()));
            	}
            	
            	else if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPcdimaiscmbio()) == false){
            		tradeFinanceNegociacaoInclBean.getViewHelper().setCheckMaisCDI(Boolean.TRUE);
            		tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPcdimaiscmbio(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPcdimaiscmbio()));
            	}
            	
            	else if(SiteUtil.isValueZero(this.getTradeFinanceBean().getTradeFinanceVO().getPfixajurocmbio()) == false){
            		tradeFinanceNegociacaoInclBean.getViewHelper().setCheckTaxaPre(Boolean.TRUE);
            		tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPfixajurocmbio(SiteUtil.formatarValorWeb(this.getTradeFinanceBean().getTradeFinanceVO().getPfixajurocmbio()));
            	}
            	
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVtxspreadnegoc(this.getTradeFinanceBean().getTradeFinanceVO().getVtxspreadnegoc());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVtxspreadtot(this.getTradeFinanceBean().getTradeFinanceVO().getVtxspreadtot());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVimpstnegoccmbio(this.getTradeFinanceBean().getTradeFinanceVO().getVimpstnegoccmbio());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setViofnegoccmbio(this.getTradeFinanceBean().getTradeFinanceVO().getViofnegoccmbio());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVtxmoracmbio(this.getTradeFinanceBean().getTradeFinanceVO().getVtxmoracmbio());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVmultanegoccmbio(this.getTradeFinanceBean().getTradeFinanceVO().getVmultanegoccmbio());
            	tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setCindcdlastragric(this.getTradeFinanceBean().getTradeFinanceVO().getCindcdlastragric());           	
            }
            listenerTratarIndicadorEconomico(null);
	        // informa o bean 'TradeFinanceNegociacaoBean.java' que os dados da tela
	        // de alteração devem ser carregados
	        tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
	        
	        tradeFinanceNegociacaoInclBean.setIsDuplicar(true);
	        
	        // FINIMP DIRETO (1644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)) {
	
	            return "finimpDiretoIncl";
	        }
	
	        // REFINIMP DIRETO (1646)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)) {
	
	            return "refinimpDiretoIncl";
	        }
	
	        // FINIMP INDIRETO (2692)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)) {
	
	            return "finimpIndiretoIncl";
	        }
	
	        // REFINIMP INDIRETO (1717)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)) {
	
	            return "refinimpIndiretoIncl";
	        }
	
	        // LEI 4131 (2010)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
	
	            return "lei4131Incl";
	        }
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEIncl";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalIncl";
	        }
	
	        // FORFAITING (644)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
	            
	            return "forfaitingIncl";
	        }
	        
	        // FINIMP ECA (1715)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                
                return "finimpEcaIncl";
            }
            
            // PROEX (642)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PROEX)) {
                
                return "proexEqualizacaoIncl";
            }
            
            // COTACAO N.C.E (622, 624, 638, 639, 640, 1713)
            if (tradeFinanceListaVO.getProduto().isNce()) {
                
                return "nceIncl";
            }
            
            // GARANTIA INTERNACIONAL EXPEDIDA (1769, 3933)
            if(tradeFinanceListaVO.getProduto().isGarantia()) {
                
                return "garantiaIntExpIncl";
            }
            
            // BNDES Pós (661, 662)
            if (tradeFinanceListaVO.getProduto().isBndesPos()) {
                
                return "bndesPosIncl";
            }
            
            // BNDES Pré (663, 664, 665, 666, 667, 670, 3934)
            if (tradeFinanceListaVO.getProduto().isBndesPre()) {
                
                return "bndesPreIncl";
            }
            
            // CARTA DE CRÉDITO DE IMPORTAÇÃO (2018)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                
                return "lcImportacaoIncl";
            }
	
	        return null;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarDuplicar  <<<<<<<<<<<");
    	}
    }
    
	/**
     * Nome: listenerTratarIndicadorEconomico
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
    public void listenerTratarIndicadorEconomico(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoAltBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    		
    		if (tradeFinanceNegociacaoInclBean.getViewHelper().isCheckPercCDI() == Boolean.FALSE
    						&& tradeFinanceNegociacaoInclBean.getViewHelper().isCheckPercCDI() == Boolean.FALSE
    						&& tradeFinanceNegociacaoInclBean.getViewHelper().isCheckTaxaPre() == Boolean.FALSE) {
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckPercCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckMaisCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckTaxaPre(Boolean.FALSE);
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    			
    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPtxcdifinan(null);
    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPcdimaiscmbio(null);
    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setPfixajurocmbio(null);
    		}
    		
    		if (tradeFinanceNegociacaoInclBean.getViewHelper().isCheckPercCDI() == Boolean.TRUE) {
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckPercCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckMaisCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckTaxaPre(Boolean.TRUE);
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledPercCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    		} 

    		
    		if (tradeFinanceNegociacaoInclBean.getViewHelper().isCheckMaisCDI() == Boolean.TRUE) {
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckMaisCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckTaxaPre(Boolean.TRUE);            
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledMaisCDI(Boolean.FALSE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledTaxaPre(Boolean.TRUE);
    		}

    		
    		if (tradeFinanceNegociacaoInclBean.getViewHelper().isCheckTaxaPre() == Boolean.TRUE) {
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckPercCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckMaisCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledCheckTaxaPre(Boolean.FALSE);
    			
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledPercCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledMaisCDI(Boolean.TRUE);
    			tradeFinanceNegociacaoInclBean.getViewHelper().setDisabledTaxaPre(Boolean.FALSE);
    		} 


    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoAltBean.listenerTratarIndicadorEconomico <<<<<<<<<<<");
    	}


    }

    /**
     * 
     * Nome: iniciarProrrogar
     * 
     * Propósito: Carrega os dados para prorrogar uma cotação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarProrrogar() {
        
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarProrrogar  <<<<<<<<<<<");
    
            if (tradeFinanceListaVO.getNbletonegoccmbio() == null
                            || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
                NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
                return "";
            }
            
            tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_PRORROGAR);
         
            // informa o bean 'tradeFinPrgAlongBean.java' que os dados da tela
            // de prorrogar devem ser carregados
            tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
            tradeFinPrgAlongBean.setIniciarPagina(Boolean.TRUE);
            tradeFinPrgAlongBean.setCodAcaoAlongarProrrogar(ConstantesTradeFinance.FUNC_PRORROGAR);
            // Combo de despesa por conta (Garantia, lc e finimpEca)
            tradeFinPrgAlongBean.getViewHelper().setComboPorContaGarantia(selectItemBean.getComboPorContaGarantia());
            
            // Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
    
            // LEI 4131 (2010)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)) {
    
                return "lei4131Prrg";
            }
    
            // PPE (1642)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
               
                return "cotacaoPPEPrrg";
            }
    
            // WORKING CAPITAL (2011)
            if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
    
                return "workingCapitalPrrg";
            }
            
            if (tradeFinanceListaVO.getProduto().isGarantia()) {
            	
                // Combo de despesa por conta (Garantia, lc e finimpEca)
                tradeFinPrgAlongBean.getViewHelper().setCidtfdrespdesp(tradeFinanceBean.getTradeFinanceVO().getCidtfdrespdesp().toString());
                
            	return "garantiaIntExpPrrg";
            }
            
            NpcFacesUtils.addInfoModalMessage("Função não prevista para o produto selecionado.", false);
    
            return null;
            
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarProrrogar  <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: iniciarAlongar
     * 
     * Propósito: Carrega os dados para alongar uma cotação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarAlongar() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarAlongar  <<<<<<<<<<<");
	
	        if (tradeFinanceListaVO.getNbletonegoccmbio() == null
	                        || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
	            NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
	            return "";
	        }
	
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_ALONGAR);
	
	        // informa o bean 'tradeFinPrgAlongBean.java' que os dados da tela
	        // de alongar devem ser carregados
	        tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
	        tradeFinPrgAlongBean.setIniciarPagina(Boolean.TRUE);
	        tradeFinPrgAlongBean.setCodAcaoAlongarProrrogar(ConstantesTradeFinance.FUNC_ALONGAR);
	        
	        // Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
	
	        // PPE (1642)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_P_P_E)) {
	
	            return "cotacaoPPEAlong";
	        }
	
	        // WORKING CAPITAL (2011)
	        if (tradeFinanceListaVO.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)) {
	
	            return "workingCapitalAlong";
	        }
	
	        NpcFacesUtils.addInfoModalMessage("Função não prevista para o produto selecionado.", false);
	
	        return null;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarAlongar  <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: iniciarAditar
     * 
     * Propósito: Carrega os dados para aditar uma cotação nce
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciarAditar() {
    	
    	try{
    		
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarAditar  <<<<<<<<<<<");
    		
    		if (tradeFinanceListaVO.getNbletonegoccmbio() == null
    				|| tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
    			NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
    			return "";
    		}

    		tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_ADITAR);
    		
    		// informa o bean 'tradeFinPrgAlongBean.java' que os dados da tela
    		// de alongar devem ser carregados
    		tradeFinanceBean.getViewHelper().setIniciarDadosViaConsulta(Boolean.TRUE);
    		
    		tradeFinAditarBean.setIniciarPagina(Boolean.TRUE);
    		
    		// Verifica a situação para do piloto e cliente ativo
            situacaoPiloto();
    		
    		// PPE (1642)
    		if (tradeFinanceListaVO.getProduto().isNce()) {
    			
    			return "nceAditar";
    		}
    		
    		NpcFacesUtils.addInfoModalMessage("Função não prevista para o produto selecionado.", false);
    		
    		return null;
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarAditar  <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: gerarArquivo
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void gerarArquivo(AjaxBehaviorEvent event) {
        
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.gerarArquivo  <<<<<<<<<<<");
            
            if (validaCamposDataBatch()) {                            
                
                tradeFinanceMonitService.gerarArquivoBacthMonitor(filtroVO);
                
                BradescoFacesUtils.addInfoModalMessage(tradeFinanceMonitService.getMsgRetorno(), 
                                "/content/comercializacao/precificacao/monitor/tradeFinMonitList.xhtml",
                                BradescoViewExceptionActionType.PATH, "submit", false);
            }

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.gerarArquivo  <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: pesquisar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.pesquisar  <<<<<<<<<<<");
	    	
	        if (validarCamposData() && validarFiltrosAdicionais()) {	                    	
	        	getViewHelper().setCtcSelecionado(null);
	            lista.clear();
	            
	            getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
	            
	            lista = tradeFinanceMonitService.pesquisarCotacoes(filtroVO);
	
	            setProdutoAndSituacaoBinario(StringUtils.leftPad(Integer.toBinaryString(0), Numeros.QUINZE, "0").toCharArray());
	        }

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.pesquisar  <<<<<<<<<<<");
    	}
    }
    
	/**
	* Nome: retomarPesquisaMonit
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 08/09/2017
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public String retomarPesquisaMonit() {
        
        try{
            setIniciarPagina(false);
            pesquisar(null);
        } catch (NpccTradeWebException e) {
            TrataErroUtil.getInstance().tratarRetornoPesquisaVaziaMainframe(e);
            lista = new ArrayList<TradeFinanceListaVO>();
            getLogManager().error("[TradeFinMonitBaseBean.retomarPesquisaMonit] Erro: " + e.getMessage());
        }finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.retomarPesquisaMonit <<<<<<<<<<<");
        }
        
        return "/content/comercializacao/precificacao/monitor/tradeFinMonitList.xhtml";
    }
    
    /**
     * Nome: validarFiltrosAdicionais
     * 
     * Propósito:
     *
     * @param :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 26/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public boolean validarFiltrosAdicionais() {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBaseBean.validarCamposData <<<<<<<<<<<");
	    	
	        Boolean isValid = true;
	        
	        // valida filtro prazo (dias)
			if (SiteUtil.isEmptyOrNull(filtroVO.getTdiadecmbio()) == false
					&& SiteUtil.isEmptyOrNull(filtroVO.getTdiaatecmbio()) == false) {
				if (filtroVO.getTdiadecmbio() > filtroVO.getTdiaatecmbio()) {
				    BradescoFacesUtils.addInfoModalMessage("Os campos Prazo (Dias) estão com o valor DE maior que o valor ATÉ.", false);
					isValid &= false;
				}
			}

			// valida filtro prazo médio (dias)
			if (SiteUtil.isEmptyOrNull(filtroVO.getQprzmedde()) == false
					&& SiteUtil.isEmptyOrNull(filtroVO.getQprzmedate()) == false) {
				if (filtroVO.getQprzmedde() > filtroVO.getQprzmedate()) {
				    BradescoFacesUtils.addInfoModalMessage("Os campos Prazo Médio (Dias) estão com o valor DE maior que o valor ATÉ.", false);
					isValid &= false;
				}
			}		
			
	        // valida filtro valor ME
			if (SiteUtil.isEmptyOrNull(filtroVO.getValormede()) == false
					&& SiteUtil.isEmptyOrNull(filtroVO.getValormeate()) == false) {
				if (SiteUtil.webMoedaToDouble(filtroVO.getValormede()
						.replaceAll("\\.", "").replaceAll("\\,", ".")) > SiteUtil
						.webMoedaToDouble(filtroVO.getValormeate()
								.replaceAll("\\.", "").replaceAll("\\,", "."))) {
				    BradescoFacesUtils.addInfoModalMessage("Os campos de Valor ME estão com o valor DE maior que o valor ATÉ.", false);
					isValid &= false;
				}
			}	
	
	        return isValid;
	        
	    }finally{
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBaseBean.validarCamposData <<<<<<<<<<<");
		}
    }
    
    /**
     * Nome: exportar
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
    public String exportar() {    
        getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());
        
        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista", 
                        tradeFinanceMonitService.pesquisarCotacoesExportacao(getFiltroVO()));        

        return "tradeFinMonitListExportTemplate";
    }

    /**
     * 
     * Nome: paginarCotacao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarCotacao(ActionEvent event) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.paginarCotacao  <<<<<<<<<<<");
	    	
	        if (indicativa) {
	            filtroVO.setCtponegoccmbio(Numeros.UM);
	        } else if (firme) {
	            filtroVO.setCtponegoccmbio(Numeros.DOIS);
	        }
	
	        getViewHelper().setCtcSelecionado(null);
	        setLista(tradeFinanceMonitService.pesquisarCotacoes(filtroVO));

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.paginarCotacao  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: selecionarIndicativa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void selecionarIndicativa(AjaxBehaviorEvent ajaxBehaviorEvent) {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.selecionarIndicativa  <<<<<<<<<<<");
	    	
	        filtroVO.setCtponegoccmbio(null);
	        if (indicativa) {
	            filtroVO.setCtponegoccmbio(Numeros.UM);
	            firme = Boolean.FALSE;
	        }
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.selecionarIndicativa  <<<<<<<<<<<");
    	}        
    }

    /**
     * 
     * Nome: selecionarFirme
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void selecionarFirme(AjaxBehaviorEvent ajaxBehaviorEvent) {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.selecionarFirme  <<<<<<<<<<<");
	    	
	        filtroVO.setCtponegoccmbio(null);
	        if (firme) {
	            filtroVO.setCtponegoccmbio(Numeros.DOIS);
	            indicativa = Boolean.FALSE;
	        }

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.selecionarFirme  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: gerarBoleto
     * 
     * Propósito: Gerar boleto apartir do item selecionado na lista
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String gerarBoleto() {
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.gerarBoleto  <<<<<<<<<<<");
	        
	        tradeFinanceBean.getViewHelper().setGerarBoletoDuplicar(new DadosGerarBoletoVO());
	        
	        // carrega dado do boleto
	        tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_GERAR_BOLETO);
	        
	        // Passagem do objeto do combo de produto para capturar descição do produto
	        tradeFinanceBean.setComboProduto(getProduto());
	        
	        return tradeFinanceBean.gerarBoleto();
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.gerarBoleto  <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
     * Nome: iniciarPesquisaGerarBoleto
     * 
     * Propósito: Inicia a tela de pesquisa com a última cotação duplicada para gerar o boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    private void iniciarPesquisaGerarBoleto() {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarPesquisaGerarBoleto  <<<<<<<<<<<");
	        
	        // Carrega filtro com os dados da cotação gerada
	        getFiltroVO().setDanobase(tradeFinanceBean.getViewHelper().getGerarBoletoDuplicar().getDanobase());
	        getFiltroVO().setNbletocmbioano(tradeFinanceBean.getViewHelper().getGerarBoletoDuplicar().getNbletocmbioano());
	        
	        // realiza a pesquisa
	        lista.clear();
	        lista = tradeFinanceMonitService.pesquisarCotacoes(filtroVO);
	        
	        // marca item na lista
	        getViewHelper().setCtcSelecionado("0");
	        
	        // habilta botoes
	        habilitaMonitBotoes(null);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarPesquisaGerarBoleto  <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: getSelectItemRadioCtc
     * 
     * Propósito: preencher lista auxiliar para selecao de flux de pagamentos na tela
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtc() {

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.getSelectItemRadioCtc  <<<<<<<<<<<");
	    	
	        List<SelectItem> list = new ArrayList<SelectItem>();
	        for (int index = 0; index < getLista().size(); index++) {
	            list.add(new SelectItem(index, ""));
	        }
	        
	        return list;
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.getSelectItemRadioCtc  <<<<<<<<<<<");
    	}
    }
    
    
    	/**
    	* Nome: iniciarAprovar
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
    public String iniciarAprovar() {

            try{
                
                BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitBean.iniciarAprovar  <<<<<<<<<<<");
                
                if (tradeFinanceListaVO.getNbletonegoccmbio() == null
                                || tradeFinanceListaVO.getNbletonegoccmbio() <= Numeros.NUM0_LONG) {
                    NpcFacesUtils.addInfoModalMessage("Selecione item.", false);
                    return "";
                }
        
                tradeFinanceBean.obterDadosBasicos(tradeFinanceListaVO, ConstantesTradeFinance.FUNC_APROVAR_CTC);
                
                // FINIMP ECA (1715)
                if (tradeFinanceListaVO.getProduto().equals(EnumProduto.FINIMP_ECA)) {
                    
                    return "finimpEcaAprovar";
                }
                
                // LC IMPORTACAO (2018)
                if (tradeFinanceListaVO.getProduto().equals(EnumProduto.LC_IMPORTACAO)) {
                    
                    return "lcImportacaoAprovar";
                }
                // GARANTIA(17,69,3933)
                if(tradeFinanceListaVO.getProduto().isGarantia()) {
                    return "garantiaIntExpAprovar";
                }
        
                return null;
                
            }finally{
                BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitBean.iniciarAprovar  <<<<<<<<<<<");
            }
    }
    
    public void situacaoPiloto() {
        
        InformacaoPilotoVO informacaoPilotoVO = new InformacaoPilotoVO();
        informacaoPilotoVO = tradeFinanceNegociacaoService.consultarSituacaoPiloto(tradeFinanceListaVO.getCunicclicmbio());
        
        // Caso o piloto está ativo e o cliente nao opera com limite
        // Não irá liberar para operar com limite
        if(informacaoPilotoVO.isPilotoAtivo()
                        && !informacaoPilotoVO.isClientePiloto()) {
            tradeFinanceBean.getViewHelper().setOperaComLimite(false);
        } else {
            tradeFinanceBean.getViewHelper().setOperaComLimite(true);
        }
    }
    
    public void continuarConfirmar() {
        
    }
   
    /**
     * @return o valor do produtoAndSituacaoBinario
     */
    public char[] getProdutoAndSituacaoBinario() {
        return produtoAndSituacaoBinario;
    }

    /**
     * @param produtoAndSituacaoBinario seta o novo valor para o campo produtoAndSituacaoBinario
     */
    public void setProdutoAndSituacaoBinario(char[] produtoAndSituacaoBinario) {
        this.produtoAndSituacaoBinario = produtoAndSituacaoBinario;
    }
   
}
