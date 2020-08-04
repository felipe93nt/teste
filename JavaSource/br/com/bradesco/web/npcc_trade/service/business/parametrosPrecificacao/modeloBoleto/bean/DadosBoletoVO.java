package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaAprLmtCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;

/**
 * 
 * Nome: DadosBoletoVO.java
 * 
 * Propósito:
 * <p>
 * Dados para impressão de uma boleto
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class DadosBoletoVO implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    
    protected int numeroClausula = Numeros.TRES;

    private String template = SiteUtil.STRING_EMPTY;

    private String titulo = SiteUtil.STRING_EMPTY;

    private String subTitulo = SiteUtil.STRING_EMPTY;

    private String operacao = SiteUtil.STRING_EMPTY;
    
    private String dataPorExtenso = SiteUtil.STRING_EMPTY;
    
    private ComissaoInternaVO primeiroItemLista = new ComissaoInternaVO();

    /**
     * Dados básico boleto*/
    private TradeFinanceVO dadosBasico = new TradeFinanceVO();
    
    /**
     * Exportador / Pais*/
    private List<MercadoriaVO> mercadoriaList = new ArrayList<MercadoriaVO>();
    
    /**
     * Previsão Desembolso */
    private List<FluxoPagamentoVO> fluxoPgtList = new ArrayList<FluxoPagamentoVO>();
    private String descrmomen = null;
    
    /**
     * Comissão*/
    private List<ComissaoInternaVO> comissaoIntList = new ArrayList<ComissaoInternaVO>();
    
    /**
     * Comissão do Banqueiro*/
    private ComissaoCollection comissaoExtList = new ComissaoCollection();
    
    /**
     * Tarifas*/
    private List<TarifaVO> tarifaList = new ArrayList<TarifaVO>();

    /**
     * Clásulas*/
    private List<ClausulasBoletoVO> clausulas = new ArrayList<ClausulasBoletoVO>();
    
    /**
     * Garantias aprovadas*/
    private List<GarantiasVO> garantiasAprovList = new ArrayList<GarantiasVO>();
    
    /**
     * Garantias Adicionais*/
    private List<GarantiasVO> garantiaAdicionalList = new ArrayList<GarantiasVO>();
    
    /**
     * Avalistas*/
    private List<GarantiasAvaListaVO> garantiasAvaList = new ArrayList<GarantiasAvaListaVO>();
    
    /**
     * Avalistas aprovados*/
    private List<GarantiasAvaAprLmtCreditoVO> garantiasAprlmtList = new ArrayList<GarantiasAvaAprLmtCreditoVO>();

    /** Lista de Despesas Funding - Custo no Exterior pelo Desembolso **/
    private List<ListaDespesasVO> listaDespesasExteriorDesemb = new ArrayList<ListaDespesasVO>();
    private ListaResponsavelDespesaVO responsavelDespesa = new ListaResponsavelDespesaVO();

    /**
     * Variável de controle de apresentação de comissão interna no produto "Pre- pagamento de importacao"
     */
    Boolean renderComissaInt = Boolean.TRUE;
  

	/**
     * Variável de controle de apresentação de Custos no Exterior pelo Desembolso
     */
    Boolean renderDadosBanqueiro = Boolean.FALSE;
    
    /**
     * CARTA DE CREDITO DE IMPORTACAO - CUSTO EXTERIOR PELA EMISSÃO
     */
    private CotacoesExternasVO cotacoesListCustExt = new CotacoesExternasVO();
    private ListaCotacoesExternasVO responsavelDespesaCustExt = new ListaCotacoesExternasVO();

    
    /**
     * 
     * Nome: setTemplateAndCabecalho
     * 
     * Propósito: Carrega titulo e subtitulo do boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void setTemplateAndCabecalho(EnumProduto produto) {
    
        switch (produto.getCodigo()) {
        case 644:
            setTemplate("forfaitingPrintTemplate");
            setTitulo("COTAÇÃO DE DESCONTO DE SAQUE / FORFAITING");
            setSubTitulo("(Pessoa Jurídica)");
            break;
        case 1717:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO DE REFINANCIAMENTO DE IMPORTAÇÃO");
            setSubTitulo("(LINHA DE BANCO A BANCO - INDIRETO)");
            break;
        case 1644:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO DE FINANCIAMENTO DE IMPORTAÇÃO");
            setSubTitulo("(LINHA DE BANCO AO IMPORTADOR - DIRETO)");
            break;
        case 1642:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO PRÉ-PAGAMENTO EXPORTAÇÃO");
            setSubTitulo("(Pessoa Jurídica)");
            break;
        case 1646:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO DE REFINANCIAMENTO DE IMPORTAÇÃO");
            setSubTitulo("(LINHA DE BANCO DIRETO AO IMPORTADOR)");
            break;
        case 2010:
            setTemplate("lei4131PrintTemplate");
            setTitulo("COTAÇÃO DE EMPRÉSTIMO DIRETO – LEI 4.131");
            setSubTitulo("(Pessoa Jurídica)");
            break;
        case 2011:
            setTemplate("workingCapitalPrintTemplate");
            setTitulo("WORKING CAPITAL");
            setSubTitulo("");
            break;
        case 2692:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO DE FINANCIAMENTO DE IMPORTAÇÃO");
            setSubTitulo("(LINHA DE BANCO A BANCO - INDIRETO)");
            break;
        case 642:
            setTemplate("proexPrintTemplate");
            setTitulo("PROEX");
            setSubTitulo("");
            break;
        // 1715 - Financiamento à Importação de Longo Prazo - Export Credit Agencies   
        case 1715:
            setTemplate("cotacaoPrintTemplate");
            setTitulo("COTAÇÃO DE FINANCIAMENTO DE IMPORTAÇÃO");
            setSubTitulo("(EXPORT CREDIT AGENCIES)");
            break;
        //1769	Stand By Letter Of Credit Financeira
        //3933	Stand By Letter Of Credit Importação
        case 1769:
        case 3933:
            setTemplate("standbyPrintTemplate");
            setTitulo("GARANTIA INTERNACIONAL EXPEDIDA");
            setSubTitulo((new StringBuilder("")).append("(").append(produto.getDescricao()).append(")").toString());
            break;
        //2018	Carta de Crédito de Importação
        case 2018:
            setTemplate("lcImpPrintTemplate");
            setTitulo("COTAÇÃO PARA ABERTURA DE CARTA DE CRÉDITO DE IMPORTAÇÃO IRREVOGÁVEL");
            setSubTitulo("(Intransferível ou Transferível Confirmada ou Não-Confirmada)");
            break;
        // 661 - BNDES POS - Buyer Credit    
        case 661:
            setTemplate("bndesPosPrintTemplate");
            setTitulo((new StringBuilder("PROPOSTA ")).append(produto.BNDES_POS_BUYER.getDescricao().trim()).toString().toUpperCase());
            setSubTitulo((new StringBuilder("")).append("(NOME DA EMPRESA: ").append(this.getDadosBasico().getNomecompletocli().trim()).append(")").toString());
            break;
        // 662 - BNDES POS - Supplier Credit
        case 662:
            setTemplate("bndesPosPrintTemplate");
            setTitulo((new StringBuilder("PROPOSTA ")).append(produto.BNDES_POS_SUPPLIER.getDescricao().trim()).toString().toUpperCase());
            setSubTitulo((new StringBuilder("")).append("(").append(this.getDadosBasico().getNomecompletocli().trim()).append(")").toString());
            break;
        
            //663,  "BNDES-Exim - Pré-Embarque Ágil", 1),
            //664,  "BNDES-Exim - Pré-Embarque Âncora", 1),
            //3934, "BNDES-Exim - Pré-Embarque de Sustentação do Investimento - PSI", 1),
            //665,  "BNDES-Exim - Pré-Embarque Automóveis", 1),
            //666,  "BNDES-Exim - Pré-Embarque Especial", 1),
            //667,  "BNDES-Exim - Pré-Embarque Normal", 1),
            //670,  "BNDES-Exim - Pré-Embarque Revitaliza", 1),
            case 663:
            case 664:
            case 3934:
            case 665:
            case 666:
            case 667:
            case 670:
            	setTemplate("bndesPrePrintTemplate");
                setTitulo("COTAÇÃO DE FINANCIAMENTO BNDES-EXIM PRÉ EMBARQUE");
                setSubTitulo("");
                break;

			//1713, "Nota de Crédito à Exportação (NCE)", 4),
			//638, "Nota de Crédito à Exportação Compror (NCE Compror)", 4),
			//639, "Nota de Crédito à Exportação Indiretos (NCE Indiretos)", 4),
			//640, "Nota de Crédito à Exportação Revolving (NCE Revolving)", 4),
            case 1713:
            case 638:
            case 639:
            case 640:
            	setTemplate("ncePrintTemplate");
                setTitulo("COTAÇÃO DE NOTA DE CRÉDITO À EXPORTAÇÃO");
                setSubTitulo("");
                break;
                
        default:
            setTemplate("cotacaoPrintTemplate");
            break;
        }
    }
    
    /**
     * 
     * Nome: getDescrmomen
     * 
     * Propósito: Retorna o descrição do momento do juros, pega o promeiro registro da lista de Fluxo de pagamento
     *
     * @return : String
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String getDescrmomen() {
        if(getFluxoPgtList() != null && getFluxoPgtList().size() > Numeros.ZERO) {
            this.descrmomen = getFluxoPgtList().get(0).getDescrmomen();
        }
        
        return this.descrmomen;
    }
    
    /**
     * @return o valor do numeroClausula
     */
    public String getNextNumeroClausula() {
        return SiteUtil.arabicoToRomano(numeroClausula++) + ". ";
    }

    /**
     * @return o valor do clausulas
     */
    public List<ClausulasBoletoVO> getClausulas() {
        return clausulas;
    }

    /**
     * @param clausulas
     *            seta o novo valor para o campo clausulas
     */
    public void setClausulas(List<ClausulasBoletoVO> clausulas) {
        this.clausulas = clausulas;
    }

    /**
     * @return o valor do titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo
     *            seta o novo valor para o campo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return o valor do subTitulo
     */
    public String getSubTitulo() {
        return subTitulo;
    }

    /**
     * @param subTitulo
     *            seta o novo valor para o campo subTitulo
     */
    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    /**
     * @return o valor do operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao
     *            seta o novo valor para o campo operacao
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return o valor do template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @param template
     *            seta o novo valor para o campo template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return o valor do dadosBasico
     */
    public TradeFinanceVO getDadosBasico() {
        return dadosBasico;
    }

    /**
     * @param dadosBasico seta o novo valor para o campo dadosBasico
     */
    public void setDadosBasico(TradeFinanceVO dadosBasico) {
        this.dadosBasico = dadosBasico;
    }

    /**
     * @return o valor do comissaoExtList
     */
    public ComissaoCollection getComissaoExtList() {
        return comissaoExtList;
    }

    /**
     * @param comissaoExtList seta o novo valor para o campo comissaoExtList
     */
    public void setComissaoExtList(ComissaoCollection comissaoExtList) {
        this.comissaoExtList = comissaoExtList;
    }

    /**
     * @return o valor do mercadoriaList
     */
    public List<MercadoriaVO> getMercadoriaList() {
        return mercadoriaList;
    }

    /**
     * @param mercadoriaList seta o novo valor para o campo mercadoriaList
     */
    public void setMercadoriaList(List<MercadoriaVO> mercadoriaList) {
        this.mercadoriaList = mercadoriaList;
    }

    /**
     * @return o valor do fluxoPgtList
     */
    public List<FluxoPagamentoVO> getFluxoPgtList() {
        return fluxoPgtList;
    }

    /**
     * @param fluxoPgtList seta o novo valor para o campo fluxoPgtList
     */
    public void setFluxoPgtList(List<FluxoPagamentoVO> fluxoPgtList) {
        this.fluxoPgtList = fluxoPgtList;
    }

    /**
     * @return o valor do comissaoIntList
     */
    public List<ComissaoInternaVO> getComissaoIntList() {
        return comissaoIntList;
    }

    /**
     * @param comissaoIntList seta o novo valor para o campo comissaoIntList
     */
    public void setComissaoIntList(List<ComissaoInternaVO> comissaoIntList) {
        this.comissaoIntList = comissaoIntList;
    }

    /**
     * @return o valor do tarifaList
     */
    public List<TarifaVO> getTarifaList() {
        return tarifaList;
    }

    /**
     * @param tarifaList seta o novo valor para o campo tarifaList
     */
    public void setTarifaList(List<TarifaVO> tarifaList) {
        this.tarifaList = tarifaList;
    }

    /**
     * @param descrmomen seta o novo valor para o campo descrmomen
     */
    public void setDescrmomen(String descrmomen) {
        this.descrmomen = descrmomen;
    }

    /**
     * @return o valor do garantiasAprovList
     */
    public List<GarantiasVO> getGarantiasAprovList() {
        return garantiasAprovList;
    }

    /**
     * @param garantiasAprovList seta o novo valor para o campo garantiasAprovList
     */
    public void setGarantiasAprovList(List<GarantiasVO> garantiasAprovList) {
        this.garantiasAprovList = garantiasAprovList;
    }

    /**
     * @return o valor do garantiaAdicionalList
     */
    public List<GarantiasVO> getGarantiaAdicionalList() {
        return garantiaAdicionalList;
    }

    /**
     * @param garantiaAdicionalList seta o novo valor para o campo garantiaAdicionalList
     */
    public void setGarantiaAdicionalList(List<GarantiasVO> garantiaAdicionalList) {
        this.garantiaAdicionalList = garantiaAdicionalList;
    }

    /**
     * @return o valor do garantiasAvaList
     */
    public List<GarantiasAvaListaVO> getGarantiasAvaList() {
        return garantiasAvaList;
    }

    /**
     * @param garantiasAvaList seta o novo valor para o campo garantiasAvaList
     */
    public void setGarantiasAvaList(List<GarantiasAvaListaVO> garantiasAvaList) {
        this.garantiasAvaList = garantiasAvaList;
    }

    /**
     * @return o valor do garantiasAprlmtList
     */
    public List<GarantiasAvaAprLmtCreditoVO> getGarantiasAprlmtList() {
        return garantiasAprlmtList;
    }

    /**
     * @param garantiasAprlmtList seta o novo valor para o campo garantiasAprlmtList
     */
    public void setGarantiasAprlmtList(List<GarantiasAvaAprLmtCreditoVO> garantiasAprlmtList) {
        this.garantiasAprlmtList = garantiasAprlmtList;
    }

    /**
     * @return o valor do numeroClausula
     */
    public int getNumeroClausula() {
        return numeroClausula;
    }

    /**
     * @param numeroClausula seta o novo valor para o campo numeroClausula
     */
    public void setNumeroClausula(int numeroClausula) {
        this.numeroClausula = numeroClausula;
    }

	/**
	 * @return the listaDespesasExteriorDesemb
	 */
	public List<ListaDespesasVO> getListaDespesasExteriorDesemb() {
		return listaDespesasExteriorDesemb;
	}

	/**
	 * @param listaDespesasExteriorDesemb the listaDespesasExteriorDesemb to set
	 */
	public void setListaDespesasExteriorDesemb(
			List<ListaDespesasVO> listaDespesasExteriorDesemb) {
		this.listaDespesasExteriorDesemb = listaDespesasExteriorDesemb;
	}
	
	/**
	 * @return the renderDadosBanqueiro
	 */
	public Boolean getRenderDadosBanqueiro() {
		return renderDadosBanqueiro;
	}

	/**
	 * @param renderDadosBanqueiro the renderDadosBanqueiro to set
	 */
	public void setRenderDadosBanqueiro(Boolean renderDadosBanqueiro) {
		this.renderDadosBanqueiro = renderDadosBanqueiro;
	}

	public Boolean getRenderComissaInt() {
		return renderComissaInt;
	}

	public void setRenderComissaInt(Boolean renderComissaInt) {
		this.renderComissaInt = renderComissaInt;
	}
	/**
	 * @return the responsavelDespesa
	 */
	public ListaResponsavelDespesaVO getResponsavelDespesa() {
		return responsavelDespesa;
	}

	/**
	 * @param responsavelDespesa the responsavelDespesa to set
	 */
	public void setResponsavelDespesa(ListaResponsavelDespesaVO responsavelDespesa) {
		this.responsavelDespesa = responsavelDespesa;
	}

	/**
	 * @return the cotacoesListCustExt
	 */
	public CotacoesExternasVO getCotacoesListCustExt() {
		return cotacoesListCustExt;
	}

	/**
	 * @param cotacoesListCustExt the cotacoesListCustExt to set
	 */
	public void setCotacoesListCustExt(CotacoesExternasVO cotacoesListCustExt) {
		this.cotacoesListCustExt = cotacoesListCustExt;
	}

	/**
	 * @return the responsavelDespesaCustExt
	 */
	public ListaCotacoesExternasVO getResponsavelDespesaCustExt() {
		return responsavelDespesaCustExt;
	}

	/**
	 * @param responsavelDespesaCustExt the responsavelDespesaCustExt to set
	 */
	public void setResponsavelDespesaCustExt(
			ListaCotacoesExternasVO responsavelDespesaCustExt) {
		this.responsavelDespesaCustExt = responsavelDespesaCustExt;
	}

	/**
	 * @return retorna data por Extenso
	 */
	public String getDataPorExtenso() {
		return dataPorExtenso;
	}

	/**
	 * @param dataPorExtenso seta data por Extenso
	 */
	public void setDataPorExtenso(String dataPorExtenso) {
		this.dataPorExtenso = dataPorExtenso;
	}

    /**
     * @return the primeiroItemLista
     */
    public ComissaoInternaVO getPrimeiroItemLista() {
        return primeiroItemLista;
    }

    /**
     * @param primeiroItemLista the primeiroItemLista to set
     */
    public void setPrimeiroItemLista(ComissaoInternaVO primeiroItemLista) {
        this.primeiroItemLista = primeiroItemLista;
    }
	
}
