package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DadosGerarBoletoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;


/**
 * 
  * Nome: TradeFinMonitViewHelper.java
  * 
  * Propï¿½sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 31/12/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrï¿½o hexavision.
 */
public class TradeFinMonitViewHelper {
	
	private String valueMaisMenosFluxoPagto = "+";
	
	private String valueMaisMenosPrecificacao = "+";
	
	private String valueMaisMenosComissaoInterna = "+";
	
	private String valueMaisMenosMercadoria = "+";
	
	private String valueMaisMenosOperacaoVinculada = "+";

    private String valueMaisMenosResponsavelEmpresa = "+";
	
	private String valueMaisMenosTarifas = "+";
	
    private String valueMaisMenosComissao = "+";
    
    private boolean renderFluxoPagto = true;
    
    private boolean renderPrecificacao = true;
    
    private boolean renderComissaoInterna = true;
    
    private boolean renderMercadoria = true;
    
    private boolean renderOperacaoVinculada = true;
    
    private boolean renderResponsavelEmpresa = true;
    
    private boolean renderTarifas = true;
    
    private boolean renderComissao = true;
    
    private Boolean renderFechar = Boolean.FALSE;
    
    private boolean renderModalFluxoPgt = false;
    
    private boolean renderModalComissaoInt = false;
    
    private boolean renderModalComissaoExt = false;
    
    private boolean renderModalComissaoBanqueiro = false;
    
    private boolean renderModalGarantias = false;
    
    private boolean renderModalFecharCotarCustorExterno = false;
    
	private boolean renderBotoes = false;
    
    private boolean renderTaxaEqualizacao = false;
    
    private boolean renderTipoDesepesa = false;
    
    private boolean renderValorLiborTravada = true;
    
    private String fluxoPgtSelecionado = null;
    
	private String comissaoIntSelecionado = null; 
    
    private String comissaoExtSelecionado = null;
    
    private String comissaoBanqueiroSelecionado = null;
     
    private String ctcSelecionado = null;
    
    private String bancoSelecionado = null;
    
    private String descricaoMomento;
    private String filtroMoeda;
    
    private String filtroMotivoPerda;
        
    private boolean renderModal = false;
    private boolean renderModalFecharLC = false;
    
    private boolean renderModalForFaiting = false;
    
    private boolean renderModalDevolver = false;
    
    private boolean disabledAprovCtc = true;
    private boolean disabledFunding = true;
    private boolean disabledDesemb = true;
    private boolean disabledAditar = true;
	private boolean disabledAlongar = true;
    private boolean disabledProrrogar = true;
    private boolean disabledRadioCustoExterno = true;
    private boolean disabledLibor = true;
    private boolean disabledLiborMeses = true;
    private boolean disabledTaxaFixa = true;
    
    /** Variável do tipo boolean. */
    private boolean operaComLimite = Boolean.TRUE;
    
    private List<SelectItem> comboMotivosPerdaItens = new ArrayList<SelectItem>();
    
    private Boolean iniciarDadosViaConsulta = Boolean.FALSE;
    
    // Variavel de controle do botão 'Gerar Boleto' da tela 'Duplicar'.
    private DadosGerarBoletoVO gerarBoletoDuplicar = new DadosGerarBoletoVO();
    
    private boolean renderModalCliente;
    
    private Boolean renderModalUnidExt = Boolean.FALSE;
    
    private Integer itemSelecListaComissaoExterna;
    
    /** Variavel Binding CPF */
    private UICpf cpfBinding = new UICpf();
    
    /** Variavel Binding CNPJ */
    private UICnpj cnpjBinding = new UICnpj();
    
    /** Página de retorno do botão voltar da tela de detalhe */
    private String paginaOrigem = null;
    
    private Boolean renderLastroLca = Boolean.FALSE;
    
    /** Variavel do tipo Boolean. */
    private Boolean marcarTodos = Boolean.FALSE;
    
    /** 
     * Variavel do tipo InfoClienteCambioListaRestricao. 
     */
    private Integer[] itemSelectLista = null;
    
    private Boolean renderModalComissao = Boolean.FALSE;

    private Integer telaCtcPend;

    private List<SelectItem> comboUnidadeExterna = new ArrayList<SelectItem>();

    private List<SelectItem> comboUnidadeNegocio = new ArrayList<SelectItem>();

    private List<SelectItem> comboSegmento = new ArrayList<SelectItem>();
    
    private List<SelectItem> comboStatus = new ArrayList<SelectItem>();
    
    private List<SelectItem> comboOperador = new ArrayList<SelectItem>();
    
    protected List<SelectItem> comboMoeda = new ArrayList<SelectItem>();
    
    protected List<SelectItem> comboPaisRestricao = new ArrayList<SelectItem>();
    
    protected List<SelectItem> comboPeriodoDaTaxa = new ArrayList<SelectItem>();
    
    protected ArrayList<SelectItem> comboFuncao = new ArrayList<SelectItem>();
    
    private Boolean isUnidadeExt = Boolean.FALSE;

    private Integer tradeFinanceMonitor = 0;
    
    private Integer tradeFinanceLog = 0;
    
    private Integer tradefinanceMonitFormalizacao = 0;
    
    private Integer tradeFinanceMonitCustoExterno = 0;

    private boolean telaIniciaUnidade = Boolean.TRUE;
    
    /** Variavel do tipo Boolean. */
    private Boolean custoExterno = Boolean.FALSE;
    
    /** Variavel do tipo Boolean. */
    private Boolean unidadeExterna = Boolean.FALSE;
    
    /** Variavel do tipo Boolean. */
    private Boolean divergente = Boolean.FALSE;

    /** Variavel do tipo Boolean. */
    private Boolean semSelecao = Boolean.FALSE;
    
    /** Variavel do tipo Integer. */
    private Integer codCpfCnpjSelecionado = null;
    
    
    /** Variavel para a paginacao **/
    private String nomeStateIdLista = null;
    
    
    /** verificar se for a tela do LOG não mostrar os botões Detalhar do cliente e
     * no aprovação de crédito não mostrar o botão do garantia
     */
    private boolean disabledBotaoDetGar = true;
    
    /** Titulo Garantia Tela Implementar e Alterar Garantia **/
    private String titulo = null;
    
    /** SubTitulo Garantia Tela Implementar e Alterar Garantia **/
    private String subTitulo = null;
   
    /** BENEFICIARIO MODAL **/
    private String nomeStateIdListaSelBeneficiario = null;
    /** BENEFICIARIO MODAL **/
    private String modalId = null;
    /** BENEFICIARIO MODAL **/
    private Boolean RenderModalBeneficiario =  Boolean.FALSE;
    /** BENEFICIARIO MODAL **/
    private Integer itemSelecListaBeneficiario = 0;
    
    private String stateIdListaDespesas = null;
    private Integer itemSelecListaDespesas = 0;

    private String stateIdListaCotacoes = null;
    private Integer itemSelecListaCotacoes = 0;
    
    /** Responsavel pelas Despeasas - Garantia Internacional **/
    private String stateIdListaRespDesp = null;
    private Integer itemSelecListaRespDesp = 0;
    
    private Date dataValidadeCotacao = new Date();
    
    private List<SelectItem> comboTipoDespesas = new ArrayList<SelectItem>();
    private List<SelectItem> comboPorConta = new ArrayList<SelectItem>();
    private List<SelectItem> comboPorContaGarantia = new ArrayList<SelectItem>();
    private List<SelectItem> comboPeriodicidade = new ArrayList<SelectItem>();
    private List<SelectItem> comboFormaPagamento = new ArrayList<SelectItem>();
    
    private Integer funcaoSelecionada = 0;
    
    /** Variáveis usadas na tela "Agenda de Operações com Swap **/
    private List<SelectItem> comboStatusSwap = new ArrayList<SelectItem>();
    private boolean disabledBaixar = true;
    private boolean disabledDetalhar = true;
    /** FIM - Variáveis usadas na tela "Agenda de Operações com Swap **/
    
    private boolean renderMonitor = true;
    
    private Integer tradeFinanceAgendaSWAP = 0;
    
    private String telaLogChamada = null;
    
    private String telaLog = null;
    
    private String telaLogDiferencas = null;
    
    /**
     * Nome: getTipoPesquisaCpfCnpj
     * 
     * Propï¿½sito: Monta a lista de Radio Button de Tipo de Pesquisa para CPF/CNPJ
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public List<SelectItem> getTipoPesquisaCpfCnpj() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "CNPJ"));
        tipo.add(new SelectItem(Numeros.NUM3, "CPF"));
        return tipo;
    }
    
    
    /** Usado no tradeFinaceLOG **/
    private boolean isBuscaBoleto;
    private boolean isBuscaContrato;
    
    /** DESABILITA / HABILITA INPUT DE DATA E DIAS GARANTIA COMPL **/
    private boolean disabledDiasContraGarantia = true;
    private boolean disabledDataContraGarantia = true;
    
	/**
     * @return o valor do renderModalComissao
     */
    public Boolean getRenderModalComissao() {
        return renderModalComissao;
    }

    /**
     * @param renderModalComissao seta o novo valor para o campo renderModalComissao
     */
    public void setRenderModalComissao(Boolean renderModalComissao) {
        this.renderModalComissao = renderModalComissao;
    }

    /**
     * @return o valor do telaCtcPend
     */
    public Integer getTelaCtcPend() {
        return telaCtcPend;
    }

    /**
     * @param telaCtcPend seta o novo valor para o campo telaCtcPend
     */
    public void setTelaCtcPend(Integer telaCtcPend) {
        this.telaCtcPend = telaCtcPend;
    }

    /**
     * @return o valor do comboUnidadeExterna
     */
    public List<SelectItem> getComboUnidadeExterna() {
        return comboUnidadeExterna;
    }

    /**
     * @param comboUnidadeExterna seta o novo valor para o campo comboUnidadeExterna
     */
    public void setComboUnidadeExterna(List<SelectItem> comboUnidadeExterna) {
        this.comboUnidadeExterna = comboUnidadeExterna;
    }

    /**
     * @return o valor do comboUnidadeNegocio
     */
    public List<SelectItem> getComboUnidadeNegocio() {
        return comboUnidadeNegocio;
    }

    /**
     * @param comboUnidadeNegocio seta o novo valor para o campo comboUnidadeNegocio
     */
    public void setComboUnidadeNegocio(List<SelectItem> comboUnidadeNegocio) {
        this.comboUnidadeNegocio = comboUnidadeNegocio;
    }

    /**
     * @return o valor do comboSegmento
     */
    public List<SelectItem> getComboSegmento() {
        return comboSegmento;
    }

    /**
     * @param comboSegmento seta o novo valor para o campo comboSegmento
     */
    public void setComboSegmento(List<SelectItem> comboSegmento) {
        this.comboSegmento = comboSegmento;
    }

    /**
     * @return o valor do isUnidadeExt
     */
    public Boolean getIsUnidadeExt() {
        return isUnidadeExt;
    }

    /**
     * @param isUnidadeExt seta o novo valor para o campo isUnidadeExt
     */
    public void setIsUnidadeExt(Boolean isUnidadeExt) {
        this.isUnidadeExt = isUnidadeExt;
    }

    /**
     * @return o valor do tradeFinanceMonitor
     */
    public Integer getTradeFinanceMonitor() {
        return tradeFinanceMonitor;
    }

    /**
     * @param tradeFinanceMonitor seta o novo valor para o campo tradeFinanceMonitor
     */
    public void setTradeFinanceMonitor(Integer tradeFinanceMonitor) {
        this.tradeFinanceMonitor = tradeFinanceMonitor;
    }

    /**
     * @return o valor do telaIniciaUnidade
     */
    public boolean isTelaIniciaUnidade() {
        return telaIniciaUnidade;
    }

    /**
     * @param telaIniciaUnidade seta o novo valor para o campo telaIniciaUnidade
     */
    public void setTelaIniciaUnidade(boolean telaIniciaUnidade) {
        this.telaIniciaUnidade = telaIniciaUnidade;
    }

    /**
     * @return o valor do custoExterno
     */
    public Boolean getCustoExterno() {
        return custoExterno;
    }

    /**
     * @param custoExterno seta o novo valor para o campo custoExterno
     */
    public void setCustoExterno(Boolean custoExterno) {
        this.custoExterno = custoExterno;
    }

    /**
     * @return o valor do unidadeExterna
     */
    public Boolean getUnidadeExterna() {
        return unidadeExterna;
    }

    /**
	 * @return o valor do codCpfCnpjSelecionado
	 */
	public Integer getCodCpfCnpjSelecionado() {
		return codCpfCnpjSelecionado;
	}

	/**
	 * @param codCpfCnpjSelecionado seta o novo valor para o campo codCpfCnpjSelecionado
	 */
	public void setCodCpfCnpjSelecionado(Integer codCpfCnpjSelecionado) {
		this.codCpfCnpjSelecionado = codCpfCnpjSelecionado;
	}

	/**
     * @param unidadeExterna seta o novo valor para o campo unidadeExterna
     */
    public void setUnidadeExterna(Boolean unidadeExterna) {
        this.unidadeExterna = unidadeExterna;
    }

    /**
     * @return o valor do divergente
     */
    public Boolean getDivergente() {
        return divergente;
    }

    /**
     * @param divergente seta o novo valor para o campo divergente
     */
    public void setDivergente(Boolean divergente) {
        this.divergente = divergente;
    }

    /**
     * @return o valor do semSelecao
     */
    public Boolean getSemSelecao() {
        return semSelecao;
    }

    /**
     * @param semSelecao seta o novo valor para o campo semSelecao
     */
    public void setSemSelecao(Boolean semSelecao) {
        this.semSelecao = semSelecao;
    }



    public String getValueMaisMenosFluxoPagto() {
		return valueMaisMenosFluxoPagto;
	}

	public void setValueMaisMenosFluxoPagto(String valueMaisMenosFluxoPagto) {
		this.valueMaisMenosFluxoPagto = valueMaisMenosFluxoPagto;
	}

	public String getValueMaisMenosPrecificacao() {
		return valueMaisMenosPrecificacao;
	}

	public void setValueMaisMenosPrecificacao(String valueMaisMenosPrecificacao) {
		this.valueMaisMenosPrecificacao = valueMaisMenosPrecificacao;
	}

	public String getValueMaisMenosComissaoInterna() {
		return valueMaisMenosComissaoInterna;
	}

	public void setValueMaisMenosComissaoInterna(
			String valueMaisMenosComissaoInterna) {
		this.valueMaisMenosComissaoInterna = valueMaisMenosComissaoInterna;
	}

	public String getValueMaisMenosMercadoria() {
		return valueMaisMenosMercadoria;
	}

	public void setValueMaisMenosMercadoria(String valueMaisMenosMercadoria) {
		this.valueMaisMenosMercadoria = valueMaisMenosMercadoria;
	}

	public String getValueMaisMenosOperacaoVinculada() {
		return valueMaisMenosOperacaoVinculada;
	}

	public void setValueMaisMenosOperacaoVinculada(
			String valueMaisMenosOperacaoVinculada) {
		this.valueMaisMenosOperacaoVinculada = valueMaisMenosOperacaoVinculada;
	}

	public String getValueMaisMenosResponsavelEmpresa() {
		return valueMaisMenosResponsavelEmpresa;
	}

	public void setValueMaisMenosResponsavelEmpresa(
			String valueMaisMenosResponsavelEmpresa) {
		this.valueMaisMenosResponsavelEmpresa = valueMaisMenosResponsavelEmpresa;
	}

	public String getValueMaisMenosTarifas() {
		return valueMaisMenosTarifas;
	}

	public void setValueMaisMenosTarifas(String valueMaisMenosTarifas) {
		this.valueMaisMenosTarifas = valueMaisMenosTarifas;
	}

	public String getValueMaisMenosComissao() {
		return valueMaisMenosComissao;
	}

	public void setValueMaisMenosComissao(String valueMaisMenosComissao) {
		this.valueMaisMenosComissao = valueMaisMenosComissao;
	}

	public boolean isRenderFluxoPagto() {
		return renderFluxoPagto;
	}

	public void setRenderFluxoPagto(boolean renderFluxoPagto) {
		this.renderFluxoPagto = renderFluxoPagto;
	}

	public boolean isRenderPrecificacao() {
		return renderPrecificacao;
	}

	public void setRenderPrecificacao(boolean renderPrecificacao) {
		this.renderPrecificacao = renderPrecificacao;
	}

	public boolean isRenderComissaoInterna() {
		return renderComissaoInterna;
	}

	public void setRenderComissaoInterna(boolean renderComissaoInterna) {
		this.renderComissaoInterna = renderComissaoInterna;
	}

	public boolean isRenderMercadoria() {
		return renderMercadoria;
	}

	public void setRenderMercadoria(boolean renderMercadoria) {
		this.renderMercadoria = renderMercadoria;
	}

	public boolean isRenderOperacaoVinculada() {
		return renderOperacaoVinculada;
	}

	public void setRenderOperacaoVinculada(boolean renderOperacaoVinculada) {
		this.renderOperacaoVinculada = renderOperacaoVinculada;
	}

	public boolean isRenderResponsavelEmpresa() {
		return renderResponsavelEmpresa;
	}

	public void setRenderResponsavelEmpresa(boolean renderResponsavelEmpresa) {
		this.renderResponsavelEmpresa = renderResponsavelEmpresa;
	}

	public boolean isRenderTarifas() {
		return renderTarifas;
	}

	public void setRenderTarifas(boolean renderTarifas) {
		this.renderTarifas = renderTarifas;
	}

	public boolean isRenderComissao() {
		return renderComissao;
	}

	public void setRenderComissao(boolean renderComissao) {
		this.renderComissao = renderComissao;
	}

	public boolean isRenderModalFluxoPgt() {
		return renderModalFluxoPgt;
	}

	public void setRenderModalFluxoPgt(boolean renderModalFluxoPgt) {
		this.renderModalFluxoPgt = renderModalFluxoPgt;
	}

	public boolean isRenderModalComissaoInt() {
		return renderModalComissaoInt;
	}

	public void setRenderModalComissaoInt(boolean renderModalComissaoInt) {
		this.renderModalComissaoInt = renderModalComissaoInt;
	}

	public boolean isRenderModalComissaoExt() {
		return renderModalComissaoExt;
	}

	public void setRenderModalComissaoExt(boolean renderModalComissaoExt) {
		this.renderModalComissaoExt = renderModalComissaoExt;
	}

	public String getComissaoIntSelecionado() {
		return comissaoIntSelecionado;
	}

	public void setComissaoIntSelecionado(String comissaoIntSelecionado) {
		this.comissaoIntSelecionado = comissaoIntSelecionado;
	}

	public String getComissaoExtSelecionado() {
		return comissaoExtSelecionado;
	}

	public void setComissaoExtSelecionado(String comissaoExtSelecionado) {
		this.comissaoExtSelecionado = comissaoExtSelecionado;
	}

	public boolean isRenderModalGarantias() {
		return renderModalGarantias;
	}

	public void setRenderModalGarantias(boolean renderModalGarantias) {
		this.renderModalGarantias = renderModalGarantias;
	}

	public String getFluxoPgtSelecionado() {
		return fluxoPgtSelecionado;
	}

	public void setFluxoPgtSelecionado(String fluxoPgtSelecionado) {
		this.fluxoPgtSelecionado = fluxoPgtSelecionado;
	}

	public String getDescricaoMomento() {
		return descricaoMomento;
	}

	public void setDescricaoMomento(String descricaoMomento) {
		this.descricaoMomento = descricaoMomento;
	}

	public String getFiltroMoeda() {
		return filtroMoeda;
	}

	public void setFiltroMoeda(String filtroMoeda) {
		this.filtroMoeda = filtroMoeda;
	}

	public List<SelectItem> getComboMotivosPerdaItens() {
		if(comboMotivosPerdaItens == null){
			
		}
		return comboMotivosPerdaItens;
	}

	public void setComboMotivosPerdaItens(List<SelectItem> comboMotivosPerdaItens) {
		this.comboMotivosPerdaItens = comboMotivosPerdaItens;
	}

	public String getFiltroMotivoPerda() {
		return filtroMotivoPerda;
	}

	public void setFiltroMotivoPerda(String filtroMotivoPerda) {
		this.filtroMotivoPerda = filtroMotivoPerda;
	}

	/**
	 * @return o valor do ctcSelecionado
	 */
	public String getCtcSelecionado() {
		return ctcSelecionado;
	}

	/**
	 * @param ctcSelecionado seta o novo valor para o campo ctcSelecionado
	 */
	public void setCtcSelecionado(String ctcSelecionado) {
		this.ctcSelecionado = ctcSelecionado;
	}

	public boolean isRenderModal() {
		return renderModal;
	}

	public void setRenderModal(boolean renderModal) {
		this.renderModal = renderModal;
	}
	
	public boolean isRenderModalFecharLC() {
		return renderModalFecharLC;
	}
	
	public void setRenderModalFecharLC(boolean renderModalFecharLC) {
		this.renderModalFecharLC = renderModalFecharLC;
	}
	
    public boolean isRenderBotoes() {
			return renderBotoes;
	}

   public void setRenderBotoes(boolean renderBotoes) {
			this.renderBotoes = renderBotoes;
	}
   
	public boolean isRenderModalCliente() {
		return renderModalCliente;
	}

	public void setRenderModalCliente(boolean renderModalCliente) {
		this.renderModalCliente = renderModalCliente;
	}

    /**
     * @return o valor do iniciarDadosViaConsulta
     */
    public Boolean getIniciarDadosViaConsulta() {
        return iniciarDadosViaConsulta;
    }

    /**
     * @param iniciarDadosViaConsulta seta o novo valor para o campo iniciarDadosViaConsulta
     */
    public void setIniciarDadosViaConsulta(Boolean iniciarDadosViaConsulta) {
        this.iniciarDadosViaConsulta = iniciarDadosViaConsulta;
    }

	public Boolean getRenderModalUnidExt() {
		return renderModalUnidExt;
	}

	public void setRenderModalUnidExt(Boolean renerModalUnidExt) {
		this.renderModalUnidExt = renerModalUnidExt;
	}

	public Integer getItemSelecListaComissaoExterna() {
		return itemSelecListaComissaoExterna;
	}

	public void setItemSelecListaComissaoExterna(
			Integer itemSelecListaComissaoExterna) {
		this.itemSelecListaComissaoExterna = itemSelecListaComissaoExterna;
	}

    /**
     * @return o valor do disabledAprovCtc
     */
    public boolean isDisabledAprovCtc() {
        return disabledAprovCtc;
    }

    /**
     * @param disabledAprovCtc seta o novo valor para o campo disabledAprovCtc
     */
    public void setDisabledAprovCtc(boolean disabledAprovCtc) {
        this.disabledAprovCtc = disabledAprovCtc;
    }

    /**
     * @return o valor do disabledFunding
     */
    public boolean isDisabledFunding() {
        return disabledFunding;
    }

    /**
     * @param disabledFunding seta o novo valor para o campo disabledFunding
     */
    public void setDisabledFunding(boolean disabledFunding) {
        this.disabledFunding = disabledFunding;
    }

    /**
     * @return o valor do disabledDesemb
     */
    public boolean isDisabledDesemb() {
        return disabledDesemb;
    }

    /**
     * @param disabledDesemb seta o novo valor para o campo disabledDesemb
     */
    public void setDisabledDesemb(boolean disabledDesemb) {
        this.disabledDesemb = disabledDesemb;
    }

    /**
     * @return o valor do disabledAditar
     */
    public boolean isDisabledAditar() {
        return disabledAditar;
    }

    /**
     * @param disabledAditar seta o novo valor para o campo disabledAditar
     */
    public void setDisabledAditar(boolean disabledAditar) {
        this.disabledAditar = disabledAditar;
    }

    /**
     * @return o valor do disabledAlongar
     */
    public boolean isDisabledAlongar() {
        return disabledAlongar;
    }

    /**
     * @param disabledAlongar seta o novo valor para o campo disabledAlongar
     */
    public void setDisabledAlongar(boolean disabledAlongar) {
        this.disabledAlongar = disabledAlongar;
    }

    /**
     * @return o valor do disabledProrrogar
     */
    public boolean isDisabledProrrogar() {
        return disabledProrrogar;
    }

    /**
     * @param disabledProrrogar seta o novo valor para o campo disabledProrrogar
     */
    public void setDisabledProrrogar(boolean disabledProrrogar) {
        this.disabledProrrogar = disabledProrrogar;
    }

    /**
     * @return o valor do renderModalForFaiting
     */
    public boolean isRenderModalForFaiting() {
        return renderModalForFaiting;
    }

    /**
     * @param renderModalForFaiting seta o novo valor para o campo renderModalForFaiting
     */
    public void setRenderModalForFaiting(boolean renderModalForFaiting) {
        this.renderModalForFaiting = renderModalForFaiting;
    }

    /**
     * @return o valor do cpfBinding
     */
    public UICpf getCpfBinding() {
        return cpfBinding;
    }

    /**
     * @param cpfBinding seta o novo valor para o campo cpfBinding
     */
    public void setCpfBinding(UICpf cpfBinding) {
        this.cpfBinding = cpfBinding;
    }

    /**
     * @return o valor do cnpjBinding
     */
    public UICnpj getCnpjBinding() {
        return cnpjBinding;
    }

    /**
     * @param cnpjBinding seta o novo valor para o campo cnpjBinding
     */
    public void setCnpjBinding(UICnpj cnpjBinding) {
        this.cnpjBinding = cnpjBinding;
    }

    /**
     * @return o valor do paginaOrigem
     */
    public String getPaginaOrigem() {
        return paginaOrigem;
    }

    /**
     * @param paginaOrigem seta o novo valor para o campo paginaOrigem
     */
    public void setPaginaOrigem(String paginaOrigem) {
        this.paginaOrigem = paginaOrigem;
    }

    /**
     * @return o valor do renderModalDevolver
     */
    public boolean isRenderModalDevolver() {
        return renderModalDevolver;
    }

    /**
     * @param renderModalDevolver seta o novo valor para o campo renderModalDevolver
     */
    public void setRenderModalDevolver(boolean renderModalDevolver) {
        this.renderModalDevolver = renderModalDevolver;
    }

    /**
     * @return o valor do renderTaxaEqualizacao
     */
    public boolean isRenderTaxaEqualizacao() {
        return renderTaxaEqualizacao;
    }

    /**
     * @param renderTaxaEqualizacao seta o novo valor para o campo renderTaxaEqualizacao
     */
    public void setRenderTaxaEqualizacao(boolean renderTaxaEqualizacao) {
        this.renderTaxaEqualizacao = renderTaxaEqualizacao;
    }

	public Boolean getRenderLastroLca() {
		return renderLastroLca;
	}

	public void setRenderLastroLca(Boolean renderLastroLca) {
		this.renderLastroLca = renderLastroLca;
	}

    /**
     * @return o valor do marcarTodos
     */
    public Boolean getMarcarTodos() {
        return marcarTodos;
    }

    /**
     * @param marcarTodos seta o novo valor para o campo marcarTodos
     */
    public void setMarcarTodos(Boolean marcarTodos) {
        this.marcarTodos = marcarTodos;
    }

    /**
     * @return o valor do itemSelectLista
     */
    public Integer[] getItemSelectLista() {
        return itemSelectLista;
    }

    /**
     * @param itemSelectLista seta o novo valor para o campo itemSelectLista
     */
    public void setItemSelectLista(Integer[] itemSelectLista) {
        this.itemSelectLista = itemSelectLista;
    }

    /**
     * @return o valor do bancoSelecionado
     */
    public String getBancoSelecionado() {
        return bancoSelecionado;
    }

    /**
     * @param bancoSelecionado seta o novo valor para o campo bancoSelecionado
     */
    public void setBancoSelecionado(String bancoSelecionado) {
        this.bancoSelecionado = bancoSelecionado;
    }

    /**
     * @return o valor do renderTipoDesepesa
     */
    public boolean isRenderTipoDesepesa() {
        return renderTipoDesepesa;
    }

    /**
     * @param renderTipoDesepesa seta o novo valor para o campo renderTipoDesepesa
     */
    public void setRenderTipoDesepesa(boolean renderTipoDesepesa) {
        this.renderTipoDesepesa = renderTipoDesepesa;
    }

    public boolean isRenderValorLiborTravada() {
		return renderValorLiborTravada;
	}

	public void setRenderValorLiborTravada(boolean renderValorLiborTravada) {
		this.renderValorLiborTravada = renderValorLiborTravada;
	}

	public Boolean getRenderFechar() {
        return renderFechar;
    }

    public void setRenderFechar(Boolean renderFechar) {
        this.renderFechar = renderFechar;
    }

    /**
     * @return o valor do tradefinanceMonitFormalizacao
     */
    public Integer getTradefinanceMonitFormalizacao() {
        return tradefinanceMonitFormalizacao;
    }

    /**
     * @param tradefinanceMonitFormalizacao seta o novo valor para o campo tradefinanceMonitFormalizacao
     */
    public void setTradefinanceMonitFormalizacao(Integer tradefinanceMonitFormalizacao) {
        this.tradefinanceMonitFormalizacao = tradefinanceMonitFormalizacao;
    }

    /**
     * @return o valor do tradeFinanceMonitCustoExterno
     */
    public Integer getTradeFinanceMonitCustoExterno() {
        return tradeFinanceMonitCustoExterno;
    }

    /**
     * @param tradeFinanceMonitCustoExterno seta o novo valor para o campo tradeFinanceMonitCustoExterno
     */
    public void setTradeFinanceMonitCustoExterno(Integer tradeFinanceMonitCustoExterno) {
        this.tradeFinanceMonitCustoExterno = tradeFinanceMonitCustoExterno;
    }

    /**
     * @return o valor do comboStatus
     */
    public List<SelectItem> getComboStatus() {
        return comboStatus;
    }

    /**
     * @param comboStatus seta o novo valor para o campo comboStatus
     */
    public void setComboStatus(List<SelectItem> comboStatus) {
        this.comboStatus = comboStatus;
    }

    /**
     * @return o valor do comboOperador
     */
    public List<SelectItem> getComboOperador() {
        return comboOperador;
    }

    /**
     * @param comboOperador seta o novo valor para o campo comboOperador
     */
    public void setComboOperador(List<SelectItem> comboOperador) {
        this.comboOperador = comboOperador;
    }

    /**
     * @return o valor do comboMoeda
     */
    public List<SelectItem> getComboMoeda() {
        return comboMoeda;
    }

    /**
     * @param comboMoeda seta o novo valor para o campo comboMoeda
     */
    public void setComboMoeda(List<SelectItem> comboMoeda) {
        this.comboMoeda = comboMoeda;
    }

    /**
     * @return o valor do comboPaisRestricao
     */
    public List<SelectItem> getComboPaisRestricao() {
        return comboPaisRestricao;
    }

    /**
     * @param comboPaisRestricao seta o novo valor para o campo comboPaisRestricao
     */
    public void setComboPaisRestricao(List<SelectItem> comboPaisRestricao) {
        this.comboPaisRestricao = comboPaisRestricao;
    }

    /**
     * @return o valor do nomeStateIdLista
     */
    public String getNomeStateIdLista() {
        return nomeStateIdLista;
    }

    /**
     * @param nomeStateIdLista seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String nomeStateIdLista) {
        this.nomeStateIdLista = nomeStateIdLista;
    }

    /**
     * @return o valor do isBuscaBoleto
     */
    public boolean isBuscaBoleto() {
        return isBuscaBoleto;
    }

    /**
     * @param isBuscaBoleto seta o novo valor para o campo isBuscaBoleto
     */
    public void setBuscaBoleto(boolean isBuscaBoleto) {
        this.isBuscaBoleto = isBuscaBoleto;
    }

    /**
     * @return o valor do isBuscaContrato
     */
    public boolean isBuscaContrato() {
        return isBuscaContrato;
    }

    /**
     * @param isBuscaContrato seta o novo valor para o campo isBuscaContrato
     */
    public void setBuscaContrato(boolean isBuscaContrato) {
        this.isBuscaContrato = isBuscaContrato;
    }

    /**
     * @return o valor do tradeFinanceLog
     */
    public Integer getTradeFinanceLog() {
        return tradeFinanceLog;
    }

    /**
     * @param tradeFinanceLog seta o novo valor para o campo tradeFinanceLog
     */
    public void setTradeFinanceLog(Integer tradeFinanceLog) {
        this.tradeFinanceLog = tradeFinanceLog;
    }

    /**
     * @return o valor do disabledBotaoDetGar
     */
    public boolean isDisabledBotaoDetGar() {
        return disabledBotaoDetGar;
    }

    /**
     * @param disabledBotaoDetGar seta o novo valor para o campo disabledBotaoDetGar
     */
    public void setDisabledBotaoDetGar(boolean disabledBotaoDetGar) {
        this.disabledBotaoDetGar = disabledBotaoDetGar;
    }

    /**
     * @return o valor do gerarBoletoDuplicar
     */
    public DadosGerarBoletoVO getGerarBoletoDuplicar() {
        return gerarBoletoDuplicar;
    }

    /**
     * @param gerarBoletoDuplicar seta o novo valor para o campo gerarBoletoDuplicar
     */
    public void setGerarBoletoDuplicar(DadosGerarBoletoVO gerarBoletoDuplicar) {
        this.gerarBoletoDuplicar = gerarBoletoDuplicar;
    }

    /**
     * @return o valor do titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo seta o novo valor para o campo titulo
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
     * @param subTitulo seta o novo valor para o campo subTitulo
     */
    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    /**
     * @return o valor do nomeStateIdListaSelBeneficiario
     */
    public String getNomeStateIdListaSelBeneficiario() {
        return nomeStateIdListaSelBeneficiario;
    }

    /**
     * @param nomeStateIdListaSelBeneficiario seta o novo valor para o campo nomeStateIdListaSelBeneficiario
     */
    public void setNomeStateIdListaSelBeneficiario(String nomeStateIdListaSelBeneficiario) {
        this.nomeStateIdListaSelBeneficiario = nomeStateIdListaSelBeneficiario;
    }

    /**
     * @return o valor do modalId
     */
    public String getModalId() {
        return modalId;
    }

    /**
     * @param modalId seta o novo valor para o campo modalId
     */
    public void setModalId(String modalId) {
        this.modalId = modalId;
    }

    /**
     * @return o valor do renderModalBeneficiario
     */
    public Boolean getRenderModalBeneficiario() {
        return RenderModalBeneficiario;
    }

    /**
     * @param renderModalBeneficiario seta o novo valor para o campo renderModalBeneficiario
     */
    public void setRenderModalBeneficiario(Boolean renderModalBeneficiario) {
        RenderModalBeneficiario = renderModalBeneficiario;
    }

    /**
     * @return o valor do itemSelecListaBeneficiario
     */
    public Integer getItemSelecListaBeneficiario() {
        return itemSelecListaBeneficiario;
    }

    /**
     * @param itemSelecListaBeneficiario seta o novo valor para o campo itemSelecListaBeneficiario
     */
    public void setItemSelecListaBeneficiario(Integer itemSelecListaBeneficiario) {
        this.itemSelecListaBeneficiario = itemSelecListaBeneficiario;
    }

    /**
     * @return o valor do stateIdListaDespesas
     */
    public String getStateIdListaDespesas() {
        return stateIdListaDespesas;
    }

    /**
     * @param stateIdListaDespesas seta o novo valor para o campo stateIdListaDespesas
     */
    public void setStateIdListaDespesas(String stateIdListaDespesas) {
        this.stateIdListaDespesas = stateIdListaDespesas;
    }

    /**
     * @return o valor do itemSelecListaDespesas
     */
    public Integer getItemSelecListaDespesas() {
        return itemSelecListaDespesas;
    }

    /**
     * @param itemSelecListaDespesas seta o novo valor para o campo itemSelecListaDespesas
     */
    public void setItemSelecListaDespesas(Integer itemSelecListaDespesas) {
        this.itemSelecListaDespesas = itemSelecListaDespesas;
    }

    /**
     * @return o valor do stateIdListaCotacoes
     */
    public String getStateIdListaCotacoes() {
        return stateIdListaCotacoes;
    }

    /**
     * @param stateIdListaCotacoes seta o novo valor para o campo stateIdListaCotacoes
     */
    public void setStateIdListaCotacoes(String stateIdListaCotacoes) {
        this.stateIdListaCotacoes = stateIdListaCotacoes;
    }

    /**
     * @return o valor do itemSelecListaCotacoes
     */
    public Integer getItemSelecListaCotacoes() {
        return itemSelecListaCotacoes;
    }

    /**
     * @param itemSelecListaCotacoes seta o novo valor para o campo itemSelecListaCotacoes
     */
    public void setItemSelecListaCotacoes(Integer itemSelecListaCotacoes) {
        this.itemSelecListaCotacoes = itemSelecListaCotacoes;
    }

    /**
     * @return o valor do dataValidadeCotacao
     */
    public Date getDataValidadeCotacao() {
        return dataValidadeCotacao;
    }

    /**
     * @param dataValidadeCotacao seta o novo valor para o campo dataValidadeCotacao
     */
    public void setDataValidadeCotacao(Date dataValidadeCotacao) {
        this.dataValidadeCotacao = dataValidadeCotacao;
    }

    /**
     * @return o valor do comboTipoDespesas
     */
    public List<SelectItem> getComboTipoDespesas() {
        return comboTipoDespesas;
    }

    /**
     * @param comboTipoDespesas seta o novo valor para o campo comboTipoDespesas
     */
    public void setComboTipoDespesas(List<SelectItem> comboTipoDespesas) {
        this.comboTipoDespesas = comboTipoDespesas;
    }

    /**
     * @return o valor do comboPorConta
     */
    public List<SelectItem> getComboPorConta() {
        return comboPorConta;
    }

    /**
     * @param comboPorConta seta o novo valor para o campo comboPorConta
     */
    public void setComboPorConta(List<SelectItem> comboPorConta) {
        this.comboPorConta = comboPorConta;
    }

    /**
     * @return o valor do comboPeriodicidade
     */
    public List<SelectItem> getComboPeriodicidade() {
        return comboPeriodicidade;
    }

    /**
     * @param comboPeriodicidade seta o novo valor para o campo comboPeriodicidade
     */
    public void setComboPeriodicidade(List<SelectItem> comboPeriodicidade) {
        this.comboPeriodicidade = comboPeriodicidade;
    }

    /**
     * @return o valor do comboFormaPagamento
     */
    public List<SelectItem> getComboFormaPagamento() {
        return comboFormaPagamento;
    }

    /**
     * @param comboFormaPagamento seta o novo valor para o campo comboFormaPagamento
     */
    public void setComboFormaPagamento(List<SelectItem> comboFormaPagamento) {
        this.comboFormaPagamento = comboFormaPagamento;
    }

 
    public List<SelectItem> getComboPeriodoDaTaxa() {
        return comboPeriodoDaTaxa;
    }

    public void setComboPeriodoDaTaxa(List<SelectItem> comboPeriodoDaTaxa) {
        this.comboPeriodoDaTaxa = comboPeriodoDaTaxa;
    }
    
    public String getStateIdListaRespDesp() {
        return stateIdListaRespDesp;
    }

    public void setStateIdListaRespDesp(String stateIdListaRespDesp) {
        this.stateIdListaRespDesp = stateIdListaRespDesp;
    }

    public Integer getItemSelecListaRespDesp() {
        return itemSelecListaRespDesp;
    }

    public void setItemSelecListaRespDesp(Integer itemSelecListaRespDesp) {
        this.itemSelecListaRespDesp = itemSelecListaRespDesp;
    }

    public ArrayList<SelectItem> getComboFuncao() {
        return comboFuncao;
    }

    public void setComboFuncao(ArrayList<SelectItem> comboFuncao) {
        this.comboFuncao = comboFuncao;
    }

    public Integer getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(Integer funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
    }

    /**
     * @return o valor do comboStatusSwap
     */
    public List<SelectItem> getComboStatusSwap() {
        return comboStatusSwap;
    }

    /**
     * @param comboStatusSwap seta o novo valor para o campo comboStatusSwap
     */
    public void setComboStatusSwap(List<SelectItem> comboStatusSwap) {
        this.comboStatusSwap = comboStatusSwap;
    }

    /**
     * @return o valor do disabledBaixar
     */
    public boolean isDisabledBaixar() {
        return disabledBaixar;
    }

    /**
     * @param disabledBaixar seta o novo valor para o campo disabledBaixar
     */
    public void setDisabledBaixar(boolean disabledBaixar) {
        this.disabledBaixar = disabledBaixar;
    }

    /**
     * @return o valor do disabledDetalhar
     */
    public boolean isDisabledDetalhar() {
        return disabledDetalhar;
    }

    /**
     * @param disabledDetalhar seta o novo valor para o campo disabledDetalhar
     */
    public void setDisabledDetalhar(boolean disabledDetalhar) {
        this.disabledDetalhar = disabledDetalhar;
    }

    public boolean isRenderMonitor() {
        return renderMonitor;
    }

    public void setRenderMonitor(boolean renderMonitor) {
        this.renderMonitor = renderMonitor;
    }

    public List<SelectItem> getComboPorContaGarantia() {
        return comboPorContaGarantia;
    }

    public void setComboPorContaGarantia(List<SelectItem> comboPorContaGarantia) {
        this.comboPorContaGarantia = comboPorContaGarantia;
    }

    /**
     * @return the disabledDiasContraGarantia
     */
    public boolean isDisabledDiasContraGarantia() {
        return disabledDiasContraGarantia;
    }

    /**
     * @param disabledDiasContraGarantia the disabledDiasContraGarantia to set
     */
    public void setDisabledDiasContraGarantia(boolean disabledDiasContraGarantia) {
        this.disabledDiasContraGarantia = disabledDiasContraGarantia;
    }

    /**
     * @return the disabledDataContraGarantia
     */
    public boolean isDisabledDataContraGarantia() {
        return disabledDataContraGarantia;
    }

    /**
     * @param disabledDataContraGarantia the disabledDataContraGarantia to set
     */
    public void setDisabledDataContraGarantia(boolean disabledDataContraGarantia) {
        this.disabledDataContraGarantia = disabledDataContraGarantia;
    }
    
    /**
     * @return the RenderModalFecharCotarCustorExterno
     */
    public boolean isRenderModalFecharCotarCustorExterno() {
		return renderModalFecharCotarCustorExterno;
	}

    /**
     * @param RenderModalFecharCotarCustorExterno the RenderModalFecharCotarCustorExterno to set
     */
	public void setRenderModalFecharCotarCustorExterno(
			boolean renderModalFecharCotarCustorExterno) {
		this.renderModalFecharCotarCustorExterno = renderModalFecharCotarCustorExterno;
	}

    /**
     * @return o valor do comissaoBanqueiroSelecionado
     */
    public String getComissaoBanqueiroSelecionado() {
        return comissaoBanqueiroSelecionado;
    }

    /**
     * @param comissaoBanqueiroSelecionado seta o novo valor para o campo comissaoBanqueiroSelecionado
     */
    public void setComissaoBanqueiroSelecionado(String comissaoBanqueiroSelecionado) {
        this.comissaoBanqueiroSelecionado = comissaoBanqueiroSelecionado;
    }

    /**
     * @return o valor do renderModalComissaoBanqueiro
     */
    public boolean isRenderModalComissaoBanqueiro() {
        return renderModalComissaoBanqueiro;
    }

    /**
     * @param renderModalComissaoBanqueiro seta o novo valor para o campo renderModalComissaoBanqueiro
     */
    public void setRenderModalComissaoBanqueiro(boolean renderModalComissaoBanqueiro) {
        this.renderModalComissaoBanqueiro = renderModalComissaoBanqueiro;
    }

    /**
     * @return the operaComLimite
     */
    public boolean isOperaComLimite() {
        return operaComLimite;
    }

    /**
     * @param operaComLimite the operaComLimite to set
     */
    public void setOperaComLimite(boolean operaComLimite) {
        this.operaComLimite = operaComLimite;
    }

    public Integer getTradeFinanceAgendaSWAP() {
        return tradeFinanceAgendaSWAP;
    }

    public void setTradeFinanceAgendaSWAP(Integer tradeFinanceAgendaSWAP) {
        this.tradeFinanceAgendaSWAP = tradeFinanceAgendaSWAP;
    }

	public boolean isDisabledRadioCustoExterno() {
		return disabledRadioCustoExterno;
	}

	public void setDisabledRadioCustoExterno(boolean disabledRadioCustoExterno) {
		this.disabledRadioCustoExterno = disabledRadioCustoExterno;
	}

	public String getTelaLogChamada() {
		return telaLogChamada;
	}

	public void setTelaLogChamada(String telaLogChamada) {
		this.telaLogChamada = telaLogChamada;
	}

	public String getTelaLogDiferencas() {
		return this.telaLogDiferencas;
	}
	
	public String getNomeTelaLogDiferencas() {
		
		if (!SiteUtil.isEmptyOrNull(this.telaLogDiferencas)) {
            try {
                return SiteUtil.getBundleValue(this.telaLogDiferencas);
            } catch (MissingResourceException e) {
                return null;
            }
        }
		return this.telaLogDiferencas;
	}

	public void setTelaLogDiferencas(String telaLogDiferencas) {
		this.telaLogDiferencas = telaLogDiferencas;
	}

	public String getTelaLog() {
		return telaLog;
	}

	public void setTelaLog(String telaLog) {
		this.telaLog = telaLog;
	}

	public boolean isDisabledLibor() {
		return disabledLibor;
	}

	public void setDisabledLibor(boolean disabledLibor) {
		this.disabledLibor = disabledLibor;
	}
	
	public boolean isDisabledLiborMeses() {
		return disabledLiborMeses;
	}

	public void setDisabledLiborMeses(boolean disabledLiborMeses) {
		this.disabledLiborMeses = disabledLiborMeses;
	}
	
	public boolean isDisabledTaxaFixa() {
		return disabledTaxaFixa;
	}

	public void setDisabledTaxaFixa(boolean disabledTaxaFixa) {
		this.disabledTaxaFixa = disabledTaxaFixa;
	}
}
