package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaResponsavelDespesaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPrazoProex;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TradeFinanceVO.java
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
 *      Registro de Manutenção: 14/05/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class TradeFinanceVO {
    /**
     * Numero do boleto
     */
    private Long nbletonegoccmbio = 0L;

    /**
     * NUMERO DA COTACAO FORMATADO
     */
    private String ncotacao;

    /**
     * Codigo do Cliente
     */
    private Long cunicclicmbio = 0L;

    /**
     * Codigo IdentificadorPessoa
     */
    private Long cunicpssoacmbio = 0L;

    /**
     * CODIGO CLIENTE TOMADOR
     */
    private Long cunicpssoacmbiot = 0L;

    /**
     * DESCRICAO CLIENTE TOMADOR
     */
    private String ncunicpssoacmbiot;
    
    private Long cunicpssoaindica = 0L;

    /**
     * Apelido para o cliente
     */
    private String ncunicclicmbio;

    /**
     * Nome do cliente
     */
    private String nomecompletocli;
    
    /**
     * CPF/CNPJ Cliente
     */
    private Integer cpfcnpj;

    /**
     * FILIAL CPF/CNPJ
     */
    private Integer cflial;

    /**
     * CONTROLE CPF/CNPJ
     */
    private Integer cctrl;

    /**
     * Numero da conta bancaria
     */
    private Integer nctabcriacmbio;

    /**
     * DIGITO DA CONTA BANCARIA
     */
    private String digtcctabcria;

    /**
     * Codigo do Banco
     */
    private Integer cbco;

    /**
     * Nome social do banco
     */
    private String nomesocial;

    /**
     * AGENCIA BANCARIA
     */
    private Integer cagbcria;

    /**
     * CONTA CORRENTE
     */
    private Integer cctabcriacmbio;

    /**
     * CIDADE
     */
    private String cidade;

    /**
     * ESTADO
     */
    private String estado;

    /**
     * COD. UNIDADE DE NEGOCIO
     */
    private Long cpssoajurid = 0L;

    /**
     * COD. SEQUENCIAL UNIDADE ORGA
     */
    private Integer nsequndorgnz;

    /**
     * NOME UNIDADE NEGOCIO
     */
    private String nomeundorgnz;

    /**
     * CODIGO RATING
     */
    private String crting;

    /**
     * NOME RATING
     */
    private String rating;

    /**
     * CODIGO SEGMENTO
     */
    private Integer ctposgmtocli;

    /**
     * DESCRICAO DO SEGMENTO
     */
    private String dtposgmtocli;

    /**
     * CODIGO DO PRODUTO
     */
    private Integer cprodtservc;

    /**
     * CODIGO DO TIPO DE COTACAO
     */
    private Integer ctponegoccmbio;

    /**
     * DESCRICAO DO TIPO DE COTACAO
     */
    private String descrctc;

    /**
     * CODIGO DO STATUS DA COTACAO
     */
    private Integer csitbletocmbio;

    /**
     * DESCRICAO DO STATUS
     */
    private String dsitbletocmbio;

    /**
     * LIMITE DE COTACAO
     */
    private String dvalddnegoccmbio;

    /**
     * ID DO OPERADOR
     */
    private String cusuarinclt = null;

    /**
     * NOME OPERADOR
     */
    private String nusuarinclt;

    /**
     * NR APROVACAO DE CREDITO CELIM
     */
    private Long nseqcontrlim = 0L;

    /**
     * CODIGO DA MODALIDADE
     */
    private Integer cmodldprodtcmbio;

    /**
     * NOME DA MODALIDADE
     */
    private String dmodldprodtcmbio;

    /**
     * CODIGO DA MOEDA EM OPERACAO
     */
    private Integer cindcdeconmmoeda;

    /**
     * SIMBOLO DA MOEDA EM OPERACAO
     */
    private String simbleconmmoeda;

    /**
     * NOME DA MOEDA EM OPERACAO
     */
    private String descreconmmoeda;

    /**
     * VALOR ME
     */
    private String vnegocmoedaestrg;

    /**
     * PRAZO DA OPERACAO (EM DIAS)
     */
    private Integer tdiaopercmbio;

    /**
     * CD MOEDA DESEMBOLSO
     */
    private Integer ceconmmoedadsemb;

    /**
     * SIMBOLO DA MOEDA DESEMBOLSO
     */
    private String simbleconmdsemb;

    /**
     * NOME MOEDA DESEMBOLSO
     */
    private String descreconmdsemb;

    /**
     * PREVISAO DESEMBOLSO
     */
    private String dprevtdsembcmbio;

    /**
     * CD MOEDA LIMTIE
     */
    private Integer ceconmmoedalim;

    /**
     * SIMBOLO DA MOEDA LIMITE
     */
    private String simbleconmlim;

    /**
     * DESCRICAO DA MOEDA LIMITE
     */
    private String moedalimite;

    /**
     * NOME DA MOEDA DA OPERACAO
     */
    private String descreconmlim;

    /**
     * VALOR MOEDA LIMITE
     */
    private String vmoedalimgerc;

    /**
     * SWAP
     */
    private String cindcdnegocswap;

    /**
     * LIBOR
     */
    private String cindcdnegoclibor;

    /**
     * FLUXO
     */
    private Integer cindcdnegocswapfluxo;

    /**
     * ME/MN
     */
    private Integer cindcdnegocswapestrg;

    /**
     * PTAX
     */
    private Integer ctpocotactx;

    /**
     * DESCRICAO PTAX
     */
    private String descrptax;

    /**
     * SPREAD ALLIN
     */
    private String ptxswapcmpdo;

    /**
     * STANDBY
     */
    private String cindcdnegoccarta;

    /**
     * PRAZO STANDBY
     */
    private Integer tdiavalddletra;

    /**
     * COMISSAO STANDBY
     */
    private String ccomiscartanacio;

    /**
     * ARBITRAGEM
     */
    private String cindcdnegocarbtr;

    /**
     * PREC. UNID EXTERNA BANCO CORR
     */
    private String dbcoextcmbio;

    /**
     * PRECIFICACAO VALIDADE (DIAS)
     */
    private Integer tdiaopercmbioprcf;

    /**
     * PRECIFICACAO DATA DIAS
     */
    private String dcotacfndngcmbio;

    /**
     * PRECIFICACAO LIBOR CD MOEDA
     */
    private Integer cindcdeconmlibor;

    /**
     * PRECIFICACAO LIBOR SIMB MOEDA
     */
    private String simbleconmlibor;

    /**
     * PRECIFICACAO LIBOR QTDE MESES
     */
    private Integer tmesliborcmbio;

    /**
     * PRECIFICACAO LIBOR %
     */
    private String vtxliborcmbio;

    /**
     * PRECIFICACAO LIBOR TRAVADA
     */
    private String vtravaliborcmbio;

    /**
     * PRECIFICACAO IR
     */
    private String vimpstnegoccmbio;

    /**
     * PRECIFICACAO IOF
     */
    private String viofnegoccmbio;

    /**
     * PRECIFICACAO JUROS MORA
     */
    private String vtxmoracmbio;

    /**
     * PRECIF JUROS DE MORA(A.A/A.M)
     */
    private Integer cbasejuromora;
    
    
    private String formataJuroMora = null;

    /**
     * MULTA
     */
    private String vmultanegoccmbio;

    /**
     * MODELO DE BOLETO
     */
    private Integer cmodcontrcmbio;

    /**
     * DESCRICAO DO MODELO DE BOLETO
     */
    private String dmodcontrcmbio;

    /**
     * PRECIFICACAO TAXA FIXA
     */
    private String ptxfixacmbio;
    
    /**
     * CODIGO DO BANQUEIRO
     */
    private Long cbanqrcmbio = 0L;
    
    /** DESCR. BANQ. **/
    private String nbanqrcmbio = null;
    
    /**
     * CD BANQUEIRO FUNDING
     */
    private Long cbanqrcmbiofndng = 0L;
    
    /** CD BANQUEIRO RECEBEDOR **/
    private Long cbanqrcmbiorcdor = 0L;

    private String dbcorecebedor = null;
    
    private String dlimfndngcmbio = null;
    
    private Integer csitbletoaprov = 0;

	/**
     * FLUXO
     */
    private String cnegocswapfluxo;

    /**
     * ME/MN
     */
    private String cnegocswapestrg;

    /** Juros moeda Naciona 1- SIM ou 2- NÃO **/
    private String montaJurosMoedaNac = null;

    /**
     * CONTA CORRENTE
     */
    private Long cctabcriaclicmbio = 0L;

    /**
     * MERCADORIA CD SEG TRANSPORTE
     */
    private String csegurtrnspmcado;

    /**
     * MERCAD. CD. CLAUS. BENEF BRAD
     */
    private String csegurmcadoorgnz;

    /**
     * FLUXO PGMTO PRAZO MEDIO(DIAS)
     */
    private Integer qprzmedcmbio;

    /**
     * FLUXO PGMTO PRAZO MEDIO(ANOS)
     */
    private String qprzmedcmbioano;

    /**
     * CODIGO DO MOTIVO DO BOLETO
     */
    private Integer cmotvobletocmbio;

    /**
     * DATA FECHAMENTO DO BOLETO
     */
    private String dfchtobletocmbio;

    /**
     * QTDE DE PARCELAS FUNDING
     */
    private Integer qtdepcelas = 0;

    /**
     * ListA DE PARCELAS DO FUNDING
     */
    private List<FundingVO> pcelasfndng = new ArrayList<FundingVO>();

    /**
     * COMISSAO INTERNA CUSTO TOTAL
     */
    private String descctotal;

    /**
     * MENSAGEM
     */
    private String mensagem;

    /**
     * RATING PLD
     */
    private String crtinglvgemdnhe;

    /**
     * ListA DE RESTRICOES
     */
    private List<String> restricoes;
    
    /**
     * Variavel controla Restições
     */
    private Boolean renderRestricoes = false;

    /**
     * RISCO RE ENTREGUE
     */
    private String percreentrg;

    /**
     * RISCO DI ENTREGUE
     */
    private String percdientrg;

    /**
     * QTDE CONTRATOS AUSENTES
     */
    private Integer cindcdcontrfalt = 0;

    /**
     * DATA ABERTURA DA C/C
     */
    private String dabertctacli;

    /**
     * DATA FUNDACAO/NASCIMENTO
     */
    private String dfundcnasc;

    /**
     * QTDE OPERACOES VENCIDAS
     */
    private Integer qdiavencdcontr = 0;

    /**
     * QTDE PENDENCIAS FORMALIZACAO
     */
    private Integer qcontrdoctopend = 0;

    /**
     * DATA DO ULTIMO FECHAMENTO
     */
    private String dtfechamento;

    /**
     * DESCRICAO PRODUTO
     */
    private String dprodtservc;

    /**
     * DESCRICAO DA MODALIDADE
     */
    private String dsmodalidade;

    /**
     * DADOS DA MOEDA
     */
    private String ceconmmoedadesc;

    /**
     * RENTABILIDADE
     */
    private String vtxrentbcmbio;

    /**
     * QTDE DE INFORMATIVOS
     */
    private Integer qtdetxinfo = 0;

    private String vlrmoedaestrang;
    private Integer cbcoextcmbio;
    private String dtcotacao;

    /**
     * DESCRICAO DA OBSERVACAO/ DEVOLVER CUSTO EXTERNO
     */
    private String robsbletocmbio;

    /**
     * TIPO DE OBSERVACAO/ DEVOLVER CUSTO EXTERNO
     */
    private Integer ctpoobsbleto;

    private List<TradeFinanceVO> lista = new ArrayList<TradeFinanceVO>();

    /**
     * ListA DE INFORMATIVOS
     */
    private String txtinformativo;

    /**
     * ENVOLVIMENTO NA MIDIA
     */
    private String rinfoenvolmdia;

    /**
     * PARECER DO OPERADOR
     */
    private String pareceroperador;

    /**
     * PARECER DO DSN
     */
    private String parecerdsn;

    /**
     * DESCRICAO CLIENTE TOMADOR
     */
    private String nunicpssoacmbiot;

    private String nunicclicmbio;
    private String nprodtservc;
    private String nindcdeconmmoeda;
    private String neconmmoedadsemb;
    private String nbanqrcmbiofndng;
    private String nmcadoopercmbio;
    /**
     * NOME PAIS
     */
    private String npais;
    private String nunicpssoamcado;
    /**
     * NOME PAIS BENEFICIARIO
     */
    private String npaisbnefc;

    /**
     * TAXA DE COMPROMISSO
     */
    private String vpnaltanteccmbio;

    /**
     * INDICADOR ECONOMICO (MOEDA)
     */
    private Integer cindcdeconmpnalt;

    /** Taxa Indicador economico **/
    private String pcdimaiscmbio = null;

    /** Taxa Indicador economico **/
    private String ptxcdifinan = null;

    /** Taxa Indicador economico **/
    private String pfixajurocmbio = null;

    private String concatenaTxaIndicador = null;

    private Long scpfcgcclicmbio = 0L;
    private Long scbcoextcmbio = 0L;

    /** PRAZO MÉDIO (DIAS/ANO) **/
    private String pzroprdiaano;

    /**
     * COD. OPR + NOME OPR
     */
    private String funcionario;

    /**
     * DESCR MOVIMENT. INCOMPATIVEL
     */
    private String cmovtcincel;

    /**
     * NUMERO BOLETO CAMBIO ANO
     */
    private Integer nbletocmbioano;

    /**
     * DATA DE CADASTRAMENTO
     */
    private String dinclreg;

    /**
     * DESCRICAO MODALIDADE ALERTA
     */
    private String cmodldprodtdesc;

    /**
     * DESCRICAO DO RE ENTREGUE
     */
    private String reentregue;

    /**
     * DESCRICAO DO RE ENTREGUE
     */
    private String dientregue;

    /**
     * CONTA CORRENTE FORMATADA
     */
    private String conta;

    /**
     * CPF CNPJ FORMATADO
     */
    private String cpfCnpjFormatado;

    /**
     * TIPO DE PESSOA FISICA OU JURIDICA: F/ J
     */
    private String tppessoa;

    /**
     * ANO BASE DO BOLETO
     */
    private Integer danobase;

    /**
     * CODIGO ADITIVO TRATA. EMENDA
     */
    private Integer caditvbletocmbio;

    /**
     * DESCRICAO PRORROGACAO
     */
    private String caditvbletocmbiostr = null;

    /** DATA VENCIMENTO DESEMBOLSO **/
    private String dvctodsembcmbio = null;

    /** PREVISAO EMBARQUE (INICIO) **/
    private String dprevtinicembrq = null;

    /** PREVISAO EMBARQUE (FIM) **/
    private String dprevtfimembrq = null;
 
    /** DATA DISPONIBILIDADE LINHA **/
    private String dprevtgarntexpdi = null;

    /** PRECIFICACAO VALIDADE (DIAS) **/
    private Integer tdiacmbioprcf = 0;

    /** SPREAD APROVADO **/
    private String vtxspreadaprov = null;

    /** SPREAD NEGOCIADO **/
    private String vtxspreadnegoc = null;

    /** COMISSAO INTERNA CUSTO TOTAL **/
    private String custototal = null;

    /** VALOR DE JUROS (EMBUT/DEDUZ) **/
    private String valorjuros = null;

    /** VALOR SAQUE TOTAL **/
    private String valorsaque = null;

    /** TAXA DE JUROS = CUSTO TOTAL **/
    private String taxajuros = null;

    /** TAXA DESCONTADA **/
    private String taxadescontada = null;

    /** NOME CLIENTE TOMADOR **/
    private String ncunicpsoacmbiot = null;

    /**
     * ABOUT: (SIM/NAO) -1 SIM diferente (-) -2 NÂO diferente (-)
     **/
    private String ccobrcomisadcio = null;

    /** PERCENTUAL ABOUT % **/
    private String pcobervarprodt = null;

    /** CLASSIFICACAO EXPORT ENTREGUE **/
    private String rclasfexportentrg = null;

    /** CLASSIFICACAO IMPORT.ENTREGUE **/
    private String rclasfimportentrg = null;

    /** DESCRICAO PRODUTO **/
    private String cprodtdesc = null;

    /** COD. UNICO PESSOA JURIDICA **/
    private Long cpssoaanlsecredt = null;

    /** ANO SOLICITACAO ANALISE CRED. **/
    private Integer danosoltcanlse = null;

    /** NUM. SOLICITACAO ANALISE CRED **/
    private Long nsoltcanlsecredt = null;

    /** NUM. SEQ. IDENT. ANALISE CRED **/
    private Integer nseqsoltcanlse = null;

    /** JUROS NEGOCIACAO **/
    private String pjuronegoccmbio = null;

    /** QTDE OCORRENCIAS RESTRICOES **/
    private Integer qtderest = 0;

    /** INDICADOR DE JUROS EMB/DED **/
    private Integer ctpojurotrade = null;

    /** Taxa Equalização **/
    private String ptxequalcmbio = null;

    /** Moeda Equalizavel **/
    private Integer ceconmmoedaequal = 0;

    /** Valor Equalizavel **/
    private String vprevtcmbioequal = null;

    /** Moeda Receita **/
    private Integer cmoedaeconmrecta = 0;

    /** Valor Receita **/
    private String vprevtrectacmbio = null;
    
    /** ORGAO GOVERNAMENTAL ECA **/
    private String iorgextercmbio = null;
    
    /** ECA SIM 1- 2- NÃO CHECKBOX LC IMPORTACA **/
    private String cindcdlastrcarta = null;
    private String formataEca = null;
    
    /** TRANSFERIVEL LC IMPORTACAO **/
    private String cpermtrnsfcarta = null;
    private String formataTransferivel = null;
    
    /** CONFIRMADA LC IMPORTACAO **/
    private String cindcdcartacnfdo = null;
    private String formataConfirmada = null;
    
    /** ANY BANK LC IMPORTACAO **/
    private String cindcdcartaidpdt = null;
    private String formataAnyBank = null;
    
    /** VIA CCR LC IMPORTACAO **/   
    private String ccartaconverecdd = null;
    private String formataViaCcr = null;
    
    /** PERCENTUAL ABOUT LC IMPORTACAO **/
    private String vlimcobervar = null;

    /** PRAZO LC IMPORTACAO **/
    private Integer cprznegoccmbio = 0;
    private String formataPrazoLC = null;
    
    /** embarque ate lc importacao **/
    private String dlimembrqcmbio = null;

    /** PRAZO MAXIMO APRESENTACAO LC IMPORTACAO **/
    private Integer valddcarta = 0;

    /** EMBARQUE PARCIAL **/
    private String cindcdembrqpcial = null;
    private String nindcdembrqpcial = null;
    private String formataEmbarqueParcial;

    private Integer cindcdecon = 0;

    /** QUANTIDADE DE PARCELAS **/
    private Integer qpcelatradeprinc = 0;

    private String simblmoedaequal = null;
    private String simblrectacmbio = null;

    /** BANCO GARANTIDOR **/
    private String dbcocred = null;

    private String dfchtobletodesc = null;
    
    /** Concatena os dados do Fechamento **/
    private String ultimoFechamento = null;

    /** Descricao da periodicidade BNDES **/
    private String ifluxoperdccmbio = null;

    /** DATA HOJE **/
    private String dataHoje = null;

    /** FINALIDADE GARANTIA**/
    private String finalidade = null;
    
    /** PRAA **/
    private String imunindcmbio = null;
    
    /**
     * DOCUMENTOS CONSIGNADOS 1 - IMPORTADOR 2- BANCO BRADESCO 3 - OUTROS (ABRIR OBSERVACAO)
     * 
     * **/
    private Integer cidtfdcartacsndo = 0;

    /** Total Juros **/
    private String ptotjurocmbio = null;

    /** Remuneração **/
    private String vtxremunbndes = null;

    /** SALDO A DESEMBOLSAR - FORFAITING **/
    private String svaloradsemb = null;

    private List<TradeFinanceDesembolsoVO> listaDesembolso = new ArrayList<TradeFinanceDesembolsoVO>();

    private List<MercadoriaVO> listaMercadoria = new ArrayList<MercadoriaVO>();

    private UnidadeExternaVO unidadeExterna = new UnidadeExternaVO();
    
    private ObservacoesCotacaoVO obsCotacaoVO = new ObservacoesCotacaoVO();

    private CalendarioPeriodo dataPrevEmbarq = new CalendarioPeriodo();

    private CalendarioPeriodo dataPrevDesemb = new CalendarioPeriodo();
    
    private ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();

    /** Grupo **/
    private Integer cidtfdbndesgrp = 0;

    /** Descricao do Grupo **/
    private String descrGrupo = null;

    /** Codigo Porte **/
    private Integer cidtfdbndesporte = 0;

    /** Descricao Porte **/
    private String descrPorte = null;

    /** Quantidade REs **/
    private Integer qregexporcmbio = 0;

    /** Quanrtidade de Embarque **/
    private Integer qprevtembrqcmbio = 0;

    /** Codigo Periodicidade **/
    private Integer cfluxoperdccmbio = 0;

    /** Validade Proposta De **/
    private String dinicvalddcmbio = null;

    /** Validade Proposta Ate **/
    private String dfimnegoccmbio = null;

    /** Qtde de parcelas BNDES Pre **/
    private Integer qpcelacmbiotrade = 0;

    /** Qtd carencia (meses) **/
    private Integer tdiacarenprinc = 0;

    /** Numero de aprv dop credito PEL **/
    private Long nppstapontucmbio = 0L;

    /** HORA DA INCLUSAO DO HISTORICO **/
    private String hinclreghist = null;

    /** MOSTRA O VALOR NA TELA DO DOCUMENTOS CONSIGANDO **/
    private String documentosConsignados = null;

    /** MOSTRA SE SIM OU NÃO COMISSAO COM ABOUT **/
    private String comissaoInterna = null;

    /** Lastro LCA **/
    private String cindcdlastragric = null;

    private String lastroLca = null;

    /** Margem Agente **/
    private String pagtefincrcmbio = "0";

    /** DESPESA POR CONTA **/
    private Integer cidtfdrespdesp = 0;
    
    private String formataDespesaPorConta = null;

    /** COMISSAO BANCO MANDATORIO **/
    private String pcomismtoricmbio = "0";

    /** COBRANCA COMISSAO BANCO MANDATORIO **/
    private Integer ccobrcomismtori = Numeros.NUM3;

    /**
     * Concatena dados se a resposta vir 3 mandar o AA, se for 2 - AM
     */
    private String cobranComissBancoMand = null;

    /** COBRANCA COMISSAO AGENTE **/
    private Integer ccobrcomisagte = Numeros.NUM3;

    /**
     * Concatena dados se a resposta vir 3 mandar o AA, se for 2 - AM
     */
    private String cobranComissAgente = null;

    /** Vencimento proposta GARANTIAS INCL COMPL**/
    private Date dvctocntragarnt = null;
    
    /** Formata Vencimento proposta GARANTIAS INCL COMPL**/
    private String formatadDataVencProsposta = null;

    /** INDETERMINADO GARANTIAS **/
    private String cnegoccmbioindmd = null;

    /** CONTRA GARANTIA **/
    private String cindcdcntragarnt = null;
    private String formataContraGarantia = null;
    
    /** PRAZO CONTRA GARANTIA **/
    private Integer tdiacntragarnt = 0;
    
    /** ABERTURA DAS OFERTAS GARANTIAS INCL COMPL **/
    private Date dabertcntragarnt = null;
    
    private String formataDataDesembIni = null;
    private String formataDataDesembFim = null;
    
    /** FORMATA ABERTURA OFERTAS **/
    private String formataDataAbrtOferta = null;
   
    /** RENOVACAO AUTOMATICA GARANTIA **/
    private String cindcdrenovcntra = null;
    private String formataRenovAutomatica = null;
    
    /** QUANTIDADE PARA ALERTA DIAS **/
    private Integer qdiaalertcntra = 0;
    
    /** DATA PARA ALERTA GARANTIAS INCL COMPL **/
    private Date dalertvctocntra = null;
    
    /** FORMATA DATA ALERTA GARANTIAS INCL COMPL E ALT **/
    private String formataDataAlertGarantias = null;
    
    /** COTAR CUSTO EXTERNO GARANTIA **/
    private String cindcdcustoexter = null;
    private String formataCustoExterno = null;
    
    /** ENDERECO ORDENANTE GARANTIA **/
    private String endereco = null;
    
    /** PAIS ORDENANTE GARANTIA **/
    private String pais = null;
        
    /** CODIGO DO BENEFICIARIO **/
    private Long cunicpssoacmbiob = 0L;

    /** CODIGO DO AFIANCADO**/
    private Long cunicpssoacmbioa = 0L;
    
    /** DADOS DE TELA DO MODAL DO BENEFICIARIO **/
    private Integer tipoPesquisaBeneficiario = 0;
    
    /** Cotação Funding **/
    private ListaCotacoesExternasVO cotacaoFundingVO = new ListaCotacoesExternasVO();
    
    /** Lista de Cotacoes Funding **/
    private List<ListaCotacoesExternasVO> listaCotacoes = new ArrayList<ListaCotacoesExternasVO>();
    
    /** Lista de Responsavel pelas Despesas Garantia Internaicional **/
    private List<ListaResponsavelDespesaVO> listaDespesaGaran = new ArrayList<ListaResponsavelDespesaVO>();
    
    /** Despesa de Funding **/
    private ListaDespesasVO despesaVO = new ListaDespesasVO();
    
    /** Lista de Despesas Funding **/
    private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
    
    /** Codigo do usuario inclusao da despesa  **/
    private String cusuariosess;
    
    /** Nome do usuario inclusao da despesa  **/
    private String nusuariosess;
    
    private String inddqmto = null;
    
    private String rjustfdqmto = null;
    
    /** CODIGO DO CLUB **/
    private Long cclub = 0L;

    /****Utilizado no book Afiancado ***/
    /** CODIGO CPF / CNPJ **/
    private Integer cdcpfcnpj = 0;

    /** CODIGO FILIAL**/
    private Integer cdfilial = 0;
    
    /** CODIGO CONTROLE CPF/CNPJ **/
    private Integer cdctrlcpfcnpj = 0;
    
    /** Utilizado receber valor e carregar valor no campo Taxa de Juros **/
    private String valorTxJuros = null;

	private String dinicvalddppsta = null;

    private String dfimvalddppsta = null;
    
    private String dlimenviorsumo = null;
    
    private String praca = null;
    
    /** COMISSÃO DE DESEMBOLSO  **/
    private String comissaodsemblso = null;
    
    /** CAMPO VALOR DE DESEMBOLSO  **/
    private String vlrcomisdsemb = null;
    
    /** DESCRIÇÃO CAMPO JUROS GERAR BOLETO  **/
    private String descjurosbleto;
    
    /** DESCRIÇÃO CAMPO JUROS GERAR BOLETO FORFAITING **/
    private String descjurobleto;
    
    private String vtxspreadtot = null;
    
    /** CAMPO TIPO DO PRAZO PROEX **/
    private Integer ctpoprzcmbio = 0;
    
    private String descPrazoProex = null;
    
    /** VALOR DO AGENTE FINANCEIRO **/
    private String vagtefincrcmbio = null;
    
    /** VALOR DO BANCO MANDATORIO **/
    private String vbcomtoricmbio = null;
    
    /**
     * Campo Grupo Mercadoria (Boleto)
     */
    private String grupomercadoriaboleto = null;
    

	/**
    * Nome: isForfaitingTipoJuroEmbutido
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 23/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public boolean isForfaitingTipoJuroEmbutido() {
        
        return getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_EMBUTIDOS.getCodigo());
    }

    /**
    * Nome: isForfaitingTipoJuroDeduzido
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 23/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public boolean isForfaitingTipoJuroDeduzido() {
        
        return getCtpojurotrade().equals(EnumTradeFinance.OPCAO_JUROS_DEDUZIDOS.getCodigo());
    }

    	/**
    	* Nome: isSaldoIgualZero
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public boolean isSaldoIgualZero() {
        
        if (svaloradsemb.equals("0,00") || svaloradsemb.equals("0.00")) {
            return true;
        }
        
        return false;
    }
    
    /**
     * @return o valor do cunicpssoacmbiob
     */
    public Long getCunicpssoacmbiob() {
        return cunicpssoacmbiob;
    }

    /**
     * @param cunicpssoacmbiob seta o novo valor para o campo cunicpssoacmbiob
     */
    public void setCunicpssoacmbiob(Long cunicpssoacmbiob) {
        this.cunicpssoacmbiob = cunicpssoacmbiob;
    }

    /**
     * @return o valor do cunicpssoacmbioa
     */
    public Long getCunicpssoacmbioa() {
        return cunicpssoacmbioa;
    }

    /**
     * @param cunicpssoacmbioa seta o novo valor para o campo cunicpssoacmbioa
     */
    public void setCunicpssoacmbioa(Long cunicpssoacmbioa) {
        this.cunicpssoacmbioa = cunicpssoacmbioa;
    }

    /**
     * @return o valor do iorgextercmbio
     */
    public String getIorgextercmbio() {
        return iorgextercmbio;
    }

    /**
     * @param iorgextercmbio seta o novo valor para o campo iorgextercmbio
     */
    public void setIorgextercmbio(String iorgextercmbio) {
        this.iorgextercmbio = iorgextercmbio;
    }

    /**
     * @return o valor do cindcdlastrcarta
     */
    public String getCindcdlastrcarta() {
        return cindcdlastrcarta;
    }

    /**
     * @param cindcdlastrcarta seta o novo valor para o campo cindcdlastrcarta
     */
    public void setCindcdlastrcarta(String cindcdlastrcarta) {
        this.cindcdlastrcarta = cindcdlastrcarta;
    }

    /**
     * @return o valor do ccartaconverecdd
     */
    public String getCcartaconverecdd() {
        return ccartaconverecdd;
    }

    /**
     * @param ccartaconverecdd seta o novo valor para o campo ccartaconverecdd
     */
    public void setCcartaconverecdd(String ccartaconverecdd) {
        this.ccartaconverecdd = ccartaconverecdd;
    }

    /**
     * @return o valor do cindcdecon
     */
    public Integer getCindcdecon() {
        return cindcdecon;
    }

    /**
     * @param cindcdecon seta o novo valor para o campo cindcdecon
     */
    public void setCindcdecon(Integer cindcdecon) {
        this.cindcdecon = cindcdecon;
    }

    /**
     * @return o valor do dvctodsembcmbio
     */
    public String getDvctodsembcmbio() {
        return dvctodsembcmbio;
    }

    /**
     * @param dvctodsembcmbio seta o novo valor para o campo dvctodsembcmbio
     */
    public void setDvctodsembcmbio(String dvctodsembcmbio) {
        this.dvctodsembcmbio = dvctodsembcmbio;
    }

    /**
     * @return o valor do dprevtinicembrq
     */
    public String getDprevtinicembrq() {
        return dprevtinicembrq;
    }

    /**
     * @param dprevtinicembrq seta o novo valor para o campo dprevtinicembrq
     */
    public void setDprevtinicembrq(String dprevtinicembrq) {
        this.dprevtinicembrq = dprevtinicembrq;
    }

    /**
     * @return o valor do dprevtfimembrq
     */
    public String getDprevtfimembrq() {
        return dprevtfimembrq;
    }

    /**
     * @param dprevtfimembrq seta o novo valor para o campo dprevtfimembrq
     */
    public void setDprevtfimembrq(String dprevtfimembrq) {
        this.dprevtfimembrq = dprevtfimembrq;
    }

    /**
     * @return o valor do dprevtgarntexpdi
     */
    public String getDprevtgarntexpdi() {
        return dprevtgarntexpdi;
    }

    /**
     * @param dprevtgarntexpdi seta o novo valor para o campo dprevtgarntexpdi
     */
    public void setDprevtgarntexpdi(String dprevtgarntexpdi) {
        this.dprevtgarntexpdi = dprevtgarntexpdi;
    }

    /**
     * @return o valor do tdiacmbioprcf
     */
    public Integer getTdiacmbioprcf() {
        return tdiacmbioprcf;
    }

    /**
     * @param tdiacmbioprcf seta o novo valor para o campo tdiacmbioprcf
     */
    public void setTdiacmbioprcf(Integer tdiacmbioprcf) {
        this.tdiacmbioprcf = tdiacmbioprcf;
    }

    /**
     * @return o valor do vtxspreadaprov
     */
    public String getVtxspreadaprov() {
        return vtxspreadaprov;
    }

    /**
     * @param vtxspreadaprov seta o novo valor para o campo vtxspreadaprov
     */
    public void setVtxspreadaprov(String vtxspreadaprov) {
        this.vtxspreadaprov = vtxspreadaprov;
    }

    /**
     * @return o valor do vtxspreadnegoc
     */
    public String getVtxspreadnegoc() {
        return vtxspreadnegoc;
    }

    /**
     * @param vtxspreadnegoc seta o novo valor para o campo vtxspreadnegoc
     */
    public void setVtxspreadnegoc(String vtxspreadnegoc) {
        this.vtxspreadnegoc = vtxspreadnegoc;
    }

    /**
     * @return o valor do custototal
     */
    public String getCustototal() {
        return custototal;
    }

    /**
     * @param custototal seta o novo valor para o campo custototal
     */
    public void setCustototal(String custototal) {
        this.custototal = custototal;
    }

    /**
     * @return o valor do valorjuros
     */
    public String getValorjuros() {
        return valorjuros;
    }

    /**
     * @param valorjuros seta o novo valor para o campo valorjuros
     */
    public void setValorjuros(String valorjuros) {
        this.valorjuros = valorjuros;
    }

    /**
     * @return o valor do valorsaque
     */
    public String getValorsaque() {
        return valorsaque;
    }

    /**
     * @param valorsaque seta o novo valor para o campo valorsaque
     */
    public void setValorsaque(String valorsaque) {
        this.valorsaque = valorsaque;
    }

    /**
     * @return o valor do taxajuros
     */
    public String getTaxajuros() {
        return taxajuros;
    }

    /**
     * @param taxajuros seta o novo valor para o campo taxajuros
     */
    public void setTaxajuros(String taxajuros) {
        this.taxajuros = taxajuros;
    }

    /**
     * @return o valor do taxadescontada
     */
    public String getTaxadescontada() {
        return taxadescontada;
    }

    /**
     * @param taxadescontada seta o novo valor para o campo taxadescontada
     */
    public void setTaxadescontada(String taxadescontada) {
        this.taxadescontada = taxadescontada;
    }

    /**
     * @return o valor do ncunicpsoacmbiot
     */
    public String getNcunicpsoacmbiot() {
        return ncunicpsoacmbiot;
    }

    /**
     * @param ncunicpsoacmbiot seta o novo valor para o campo ncunicpsoacmbiot
     */
    public void setNcunicpsoacmbiot(String ncunicpsoacmbiot) {
        this.ncunicpsoacmbiot = ncunicpsoacmbiot;
    }

    /**
     * @return o valor do ccobrcomisadcio 1- SIM diferente (-) 2- NÂO diferente (-)
     */
    public String getCcobrcomisadcio() {
        return ccobrcomisadcio;
    }

    /**
     * @param ccobrcomisadcio seta o novo valor para o campo ccobrcomisadcio
     */
    public void setCcobrcomisadcio(String ccobrcomisadcio) {
        this.ccobrcomisadcio = ccobrcomisadcio;
    }

    /**
     * @return o valor do pcobervarprodt
     */
    public String getPcobervarprodt() {
        return pcobervarprodt;
    }

    /**
     * @param pcobervarprodt seta o novo valor para o campo pcobervarprodt
     */
    public void setPcobervarprodt(String pcobervarprodt) {
        this.pcobervarprodt = pcobervarprodt;
    }

    /**
     * @return o valor do rclasfexportentrg
     */
    public String getRclasfexportentrg() {
        return rclasfexportentrg;
    }

    /**
     * @param rclasfexportentrg seta o novo valor para o campo rclasfexportentrg
     */
    public void setRclasfexportentrg(String rclasfexportentrg) {
        this.rclasfexportentrg = rclasfexportentrg;
    }

    /**
     * @return o valor do rclasfimportentrg
     */
    public String getRclasfimportentrg() {
        return rclasfimportentrg;
    }

    /**
     * @param rclasfimportentrg seta o novo valor para o campo rclasfimportentrg
     */
    public void setRclasfimportentrg(String rclasfimportentrg) {
        this.rclasfimportentrg = rclasfimportentrg;
    }

    /**
     * @return o valor do cprodtdesc
     */
    public String getCprodtdesc() {
        return cprodtdesc;
    }

    /**
     * @param cprodtdesc seta o novo valor para o campo cprodtdesc
     */
    public void setCprodtdesc(String cprodtdesc) {
        this.cprodtdesc = cprodtdesc;
    }

    /**
     * @return o valor do qtderest
     */
    public Integer getQtderest() {
        return qtderest;
    }

    /**
     * @param qtderest seta o novo valor para o campo qtderest
     */
    public void setQtderest(Integer qtderest) {
        this.qtderest = qtderest;
    }

    /**
     * @return o valor do listaDesembolso
     */
    public List<TradeFinanceDesembolsoVO> getListaDesembolso() {
        return listaDesembolso;
    }

    /**
     * @param listaDesembolso seta o novo valor para o campo listaDesembolso
     */
    public void setListaDesembolso(List<TradeFinanceDesembolsoVO> listaDesembolso) {
        this.listaDesembolso = listaDesembolso;
    }

    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    public Long getCunicpssoacmbio() {
        return cunicpssoacmbio;
    }

    public void setCunicpssoacmbio(Long cunicpssoacmbio) {
        this.cunicpssoacmbio = cunicpssoacmbio;
    }

    public String getNcunicclicmbio() {
        return ncunicclicmbio;
    }

    public void setNcunicclicmbio(String ncunicclicmbio) {
        this.ncunicclicmbio = ncunicclicmbio;
    }

    public Integer getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(Integer cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public Integer getCflial() {
        return cflial;
    }

    public void setCflial(Integer cflial) {
        this.cflial = cflial;
    }

    public Integer getCctrl() {
        return cctrl;
    }

    public void setCctrl(Integer cctrl) {
        this.cctrl = cctrl;
    }

    public Integer getNctabcriacmbio() {
        return nctabcriacmbio;
    }

    public void setNctabcriacmbio(Integer nctabcriacmbio) {
        this.nctabcriacmbio = nctabcriacmbio;
    }

    public String getDigtcctabcria() {
        return digtcctabcria;
    }

    public void setDigtcctabcria(String digtcctabcria) {
        this.digtcctabcria = digtcctabcria;
    }

    public Integer getCbco() {
        return cbco;
    }

    public void setCbco(Integer cbco) {
        this.cbco = cbco;
    }

    public String getNomesocial() {
        return nomesocial;
    }

    public void setNomesocial(String nomesocial) {
        this.nomesocial = nomesocial;
    }

    public Integer getCagbcria() {
        return cagbcria;
    }

    public void setCagbcria(Integer cagbcria) {
        this.cagbcria = cagbcria;
    }

    public Integer getCctabcriacmbio() {
        return cctabcriacmbio;
    }

    public void setCctabcriacmbio(Integer cctabcriacmbio) {
        this.cctabcriacmbio = cctabcriacmbio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCpssoajurid() {
        return cpssoajurid;
    }

    public void setCpssoajurid(Long cpssoajurid) {
        this.cpssoajurid = cpssoajurid;
    }

    public Integer getNsequndorgnz() {
        return nsequndorgnz;
    }

    public void setNsequndorgnz(Integer nsequndorgnz) {
        this.nsequndorgnz = nsequndorgnz;
    }

    public String getNomeundorgnz() {
        return nomeundorgnz;
    }

    public void setNomeundorgnz(String nomeundorgnz) {
        this.nomeundorgnz = nomeundorgnz;
    }

    public String getCrting() {
        return crting;
    }

    public void setCrting(String crting) {
        this.crting = crting;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getCtposgmtocli() {
        return ctposgmtocli;
    }

    public void setCtposgmtocli(Integer ctposgmtocli) {
        this.ctposgmtocli = ctposgmtocli;
    }

    public String getDtposgmtocli() {
        return dtposgmtocli;
    }

    public void setDtposgmtocli(String dtposgmtocli) {
        this.dtposgmtocli = dtposgmtocli;
    }

    public Integer getCprodtservc() {
        return cprodtservc;
    }

    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    public Integer getCtponegoccmbio() {
        return ctponegoccmbio;
    }

    public void setCtponegoccmbio(Integer ctponegoccmbio) {
        this.ctponegoccmbio = ctponegoccmbio;
    }

    public String getDescrctc() {
        return descrctc;
    }

    public void setDescrctc(String descrctc) {
        this.descrctc = descrctc;
    }

    public Integer getCsitbletocmbio() {
        return csitbletocmbio;
    }

    public void setCsitbletocmbio(Integer csitbletocmbio) {
        this.csitbletocmbio = csitbletocmbio;
    }

    public String getDsitbletocmbio() {
        return dsitbletocmbio;
    }

    public void setDsitbletocmbio(String dsitbletocmbio) {
        this.dsitbletocmbio = dsitbletocmbio;
    }

    public String getDvalddnegoccmbio() {
        return dvalddnegoccmbio;
    }

    public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
        this.dvalddnegoccmbio = dvalddnegoccmbio;
    }

    public String getCusuarinclt() {
        return cusuarinclt;
    }

    public void setCusuarinclt(String cusuarinclt) {
        this.cusuarinclt = cusuarinclt;
    }

    public String getNusuarinclt() {
        return nusuarinclt;
    }

    public void setNusuarinclt(String nusuarinclt) {
        this.nusuarinclt = nusuarinclt;
    }

    public Long getNseqcontrlim() {
        return nseqcontrlim;
    }

    public void setNseqcontrlim(Long nseqcontrlim) {
        this.nseqcontrlim = nseqcontrlim;
    }

    public Integer getCmodldprodtcmbio() {
        return cmodldprodtcmbio;
    }

    public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
        this.cmodldprodtcmbio = cmodldprodtcmbio;
    }

    public String getDmodldprodtcmbio() {
        return dmodldprodtcmbio;
    }

    public void setDmodldprodtcmbio(String dmodldprodtcmbio) {
        this.dmodldprodtcmbio = dmodldprodtcmbio;
    }

    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }

    public String getSimbleconmmoeda() {
        return simbleconmmoeda;
    }

    public void setSimbleconmmoeda(String simbleconmmoeda) {
        this.simbleconmmoeda = simbleconmmoeda;
    }

    public String getDescreconmmoeda() {
        return descreconmmoeda;
    }

    public void setDescreconmmoeda(String descreconmmoeda) {
        this.descreconmmoeda = descreconmmoeda;
    }

    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    public Integer getTdiaopercmbio() {
        return tdiaopercmbio;
    }

    public void setTdiaopercmbio(Integer tdiaopercmbio) {
        this.tdiaopercmbio = tdiaopercmbio;
    }

    public Integer getCeconmmoedadsemb() {
        return ceconmmoedadsemb;
    }

    public void setCeconmmoedadsemb(Integer ceconmmoedadsemb) {
        this.ceconmmoedadsemb = ceconmmoedadsemb;
    }

    public String getSimbleconmdsemb() {
        return simbleconmdsemb;
    }

    public void setSimbleconmdsemb(String simbleconmdsemb) {
        this.simbleconmdsemb = simbleconmdsemb;
    }

    public String getDescreconmdsemb() {
        return descreconmdsemb;
    }

    public void setDescreconmdsemb(String descreconmdsemb) {
        this.descreconmdsemb = descreconmdsemb;
    }

    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    public Integer getCeconmmoedalim() {
        return ceconmmoedalim;
    }

    public void setCeconmmoedalim(Integer ceconmmoedalim) {
        this.ceconmmoedalim = ceconmmoedalim;
    }

    public String getSimbleconmlim() {
        return simbleconmlim;
    }

    public void setSimbleconmlim(String simbleconmlim) {
        this.simbleconmlim = simbleconmlim;
    }

    public String getDescreconmlim() {
        return descreconmlim;
    }

    public void setDescreconmlim(String descreconmlim) {
        this.descreconmlim = descreconmlim;
    }

    public String getVmoedalimgerc() {
        return vmoedalimgerc;
    }

    public void setVmoedalimgerc(String vmoedalimgerc) {
        this.vmoedalimgerc = vmoedalimgerc;
    }

    public String getCindcdnegocswap() {
        return cindcdnegocswap;
    }

    public void setCindcdnegocswap(String cindcdnegocswap) {
        this.cindcdnegocswap = cindcdnegocswap;
    }

    public String getCindcdnegoclibor() {
        return cindcdnegoclibor;
    }

    public void setCindcdnegoclibor(String cindcdnegoclibor) {
        this.cindcdnegoclibor = cindcdnegoclibor;
    }

    public Integer getCindcdnegocswapfluxo() {
        return cindcdnegocswapfluxo;
    }

    public void setCindcdnegocswapfluxo(Integer cindcdnegocswapfluxo) {
        this.cindcdnegocswapfluxo = cindcdnegocswapfluxo;
    }

    public Integer getCindcdnegocswapestrg() {
        return cindcdnegocswapestrg;
    }

    public void setCindcdnegocswapestrg(Integer cindcdnegocswapestrg) {
        this.cindcdnegocswapestrg = cindcdnegocswapestrg;
    }

    public Integer getCtpocotactx() {
        return ctpocotactx;
    }

    public void setCtpocotactx(Integer ctpocotactx) {
        this.ctpocotactx = ctpocotactx;
    }

    public String getDescrptax() {
        return descrptax;
    }

    public void setDescrptax(String descrptax) {
        this.descrptax = descrptax;
    }

    public String getPtxswapcmpdo() {
        return ptxswapcmpdo;
    }

    public void setPtxswapcmpdo(String ptxswapcmpdo) {
        this.ptxswapcmpdo = ptxswapcmpdo;
    }

    public String getCindcdnegoccarta() {
        return cindcdnegoccarta;
    }

    public void setCindcdnegoccarta(String cindcdnegoccarta) {
        this.cindcdnegoccarta = cindcdnegoccarta;
    }

    public Integer getTdiavalddletra() {
        return tdiavalddletra;
    }

    public void setTdiavalddletra(Integer tdiavalddletra) {
        this.tdiavalddletra = tdiavalddletra;
    }

    public String getCcomiscartanacio() {
        return ccomiscartanacio;
    }

    public void setCcomiscartanacio(String ccomiscartanacio) {
        this.ccomiscartanacio = ccomiscartanacio;
    }

    public String getCindcdnegocarbtr() {
        return cindcdnegocarbtr;
    }

    public void setCindcdnegocarbtr(String cindcdnegocarbtr) {
        this.cindcdnegocarbtr = cindcdnegocarbtr;
    }

    public String getDbcoextcmbio() {
        return dbcoextcmbio;
    }

    public void setDbcoextcmbio(String dbcoextcmbio) {
        this.dbcoextcmbio = dbcoextcmbio;
    }

    public Integer getTdiaopercmbioprcf() {
        return tdiaopercmbioprcf;
    }

    public void setTdiaopercmbioprcf(Integer tdiaopercmbioprcf) {
        this.tdiaopercmbioprcf = tdiaopercmbioprcf;
    }

    public String getDcotacfndngcmbio() {
        return dcotacfndngcmbio;
    }

    public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
        this.dcotacfndngcmbio = dcotacfndngcmbio;
    }

    public Integer getCindcdeconmlibor() {
        return cindcdeconmlibor;
    }

    public void setCindcdeconmlibor(Integer cindcdeconmlibor) {
        this.cindcdeconmlibor = cindcdeconmlibor;
    }

    public String getSimbleconmlibor() {
        return simbleconmlibor;
    }

    public void setSimbleconmlibor(String simbleconmlibor) {
        this.simbleconmlibor = simbleconmlibor;
    }

    public Integer getTmesliborcmbio() {
        return tmesliborcmbio;
    }

    public void setTmesliborcmbio(Integer tmesliborcmbio) {
        this.tmesliborcmbio = tmesliborcmbio;
    }

    public String getVtxliborcmbio() {
        return vtxliborcmbio;
    }

    public void setVtxliborcmbio(String vtxliborcmbio) {
        this.vtxliborcmbio = vtxliborcmbio;
    }

    public String getVtravaliborcmbio() {
        return vtravaliborcmbio;
    }

    public void setVtravaliborcmbio(String vtravaliborcmbio) {
        this.vtravaliborcmbio = vtravaliborcmbio;
    }

    public String getVimpstnegoccmbio() {
        return vimpstnegoccmbio;
    }

    public void setVimpstnegoccmbio(String vimpstnegoccmbio) {
        this.vimpstnegoccmbio = vimpstnegoccmbio;
    }

    public String getViofnegoccmbio() {
        return viofnegoccmbio;
    }

    public void setViofnegoccmbio(String viofnegoccmbio) {
        this.viofnegoccmbio = viofnegoccmbio;
    }

    public String getVtxmoracmbio() {
        return vtxmoracmbio;
    }

    public void setVtxmoracmbio(String vtxmoracmbio) {
        this.vtxmoracmbio = vtxmoracmbio;
    }

    public Integer getCbasejuromora() {
        return cbasejuromora;
    }

    public void setCbasejuromora(Integer cbasejuromora) {
        this.cbasejuromora = cbasejuromora;
    }

    public String getVmultanegoccmbio() {
        return vmultanegoccmbio;
    }

    public void setVmultanegoccmbio(String vmultanegoccmbio) {
        this.vmultanegoccmbio = vmultanegoccmbio;
    }

    public Integer getCmodcontrcmbio() {
        return cmodcontrcmbio;
    }

    public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
        this.cmodcontrcmbio = cmodcontrcmbio;
    }

    public String getDmodcontrcmbio() {
        return dmodcontrcmbio;
    }

    public void setDmodcontrcmbio(String dmodcontrcmbio) {
        this.dmodcontrcmbio = dmodcontrcmbio;
    }

    public String getPtxfixacmbio() {
        return ptxfixacmbio;
    }

    public void setPtxfixacmbio(String ptxfixacmbio) {
        this.ptxfixacmbio = ptxfixacmbio;
    }

    public Long getCbanqrcmbio() {
        return cbanqrcmbio;
    }

    public void setCbanqrcmbio(Long cbanqrcmbio) {
        this.cbanqrcmbio = cbanqrcmbio;
    }
    
    /**
     * @return o valor do nbanqrcmbio
     */
    public String getNbanqrcmbio() {
        return nbanqrcmbio;
    }
    
    /**
     * @param nbanqrcmbio seta o novo valor para o campo nbanqrcmbio
     */
    public void setNbanqrcmbio(String nbanqrcmbio) {
        this.nbanqrcmbio = nbanqrcmbio;
    }
    
    public String getCnegocswapfluxo() {
        return cnegocswapfluxo;
    }

    public void setCnegocswapfluxo(String cnegocswapfluxo) {
        this.cnegocswapfluxo = cnegocswapfluxo;
    }

    public String getCnegocswapestrg() {
        return cnegocswapestrg;
    }

    public void setCnegocswapestrg(String cnegocswapestrg) {
        this.cnegocswapestrg = cnegocswapestrg;
    }

    public Long getCctabcriaclicmbio() {
        return cctabcriaclicmbio;
    }

    public void setCctabcriaclicmbio(Long cctabcriaclicmbio) {
        this.cctabcriaclicmbio = cctabcriaclicmbio;
    }

    public String getCsegurtrnspmcado() {
        return csegurtrnspmcado;
    }

    public void setCsegurtrnspmcado(String csegurtrnspmcado) {
        this.csegurtrnspmcado = csegurtrnspmcado;
    }

    public String getCsegurmcadoorgnz() {
        return csegurmcadoorgnz;
    }

    public void setCsegurmcadoorgnz(String csegurmcadoorgnz) {
        this.csegurmcadoorgnz = csegurmcadoorgnz;
    }

    public Integer getQprzmedcmbio() {
        return qprzmedcmbio;
    }

    public void setQprzmedcmbio(Integer qprzmedcmbio) {
        this.qprzmedcmbio = qprzmedcmbio;
    }

    public String getQprzmedcmbioano() {
        return qprzmedcmbioano;
    }

    public void setQprzmedcmbioano(String qprzmedcmbioano) {
        this.qprzmedcmbioano = qprzmedcmbioano;
    }

    public Integer getCmotvobletocmbio() {
        return cmotvobletocmbio;
    }

    public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
        this.cmotvobletocmbio = cmotvobletocmbio;
    }

    public String getDfchtobletocmbio() {
        return dfchtobletocmbio;
    }

    public void setDfchtobletocmbio(String dfchtobletocmbio) {
        this.dfchtobletocmbio = dfchtobletocmbio;
    }

    public Integer getQtdepcelas() {
        return qtdepcelas;
    }

    public void setQtdepcelas(Integer qtdepcelas) {
        this.qtdepcelas = qtdepcelas;
    }

    public List<FundingVO> getPcelasfndng() {
        return pcelasfndng;
    }

    public void setPcelasfndng(List<FundingVO> pcelasfndng) {
        this.pcelasfndng = pcelasfndng;
    }

    public String getDescctotal() {
        return descctotal;
    }

    public void setDescctotal(String descctotal) {
        this.descctotal = descctotal;
    }

    public String getNcunicpssoacmbiot() {
        return ncunicpssoacmbiot;
    }

    public void setNcunicpssoacmbiot(String ncunicpssoacmbiot) {
        this.ncunicpssoacmbiot = ncunicpssoacmbiot;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCrtinglvgemdnhe() {
        return crtinglvgemdnhe;
    }

    public void setCrtinglvgemdnhe(String crtinglvgemdnhe) {
        this.crtinglvgemdnhe = crtinglvgemdnhe;
    }

    public List<String> getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(List<String> restricoes) {
        this.restricoes = restricoes;
    }

    public String getPercreentrg() {
        return percreentrg;
    }

    public void setPercreentrg(String percreentrg) {
        this.percreentrg = percreentrg;
    }

    public String getPercdientrg() {
        return percdientrg;
    }

    public void setPercdientrg(String percdientrg) {
        this.percdientrg = percdientrg;
    }

    public Integer getCindcdcontrfalt() {
        return cindcdcontrfalt;
    }

    public void setCindcdcontrfalt(Integer cindcdcontrfalt) {
        this.cindcdcontrfalt = cindcdcontrfalt;
    }

    public String getDabertctacli() {
        if(dabertctacli.equals("01.01.0001")) {
            return "";
        }else {
            
            return SiteUtil.trocarPontoPorBarra(dabertctacli);
        }
       
    }

    public void setDabertctacli(String dabertctacli) {
        this.dabertctacli = dabertctacli;
    }

    public String getDfundcnasc() {
        return dfundcnasc;
    }

    public void setDfundcnasc(String dfundcnasc) {
        this.dfundcnasc = dfundcnasc;
    }

    public Integer getQdiavencdcontr() {
        return qdiavencdcontr;
    }

    public void setQdiavencdcontr(Integer qdiavencdcontr) {
        this.qdiavencdcontr = qdiavencdcontr;
    }

    public Integer getQcontrdoctopend() {
        return qcontrdoctopend;
    }

    public void setQcontrdoctopend(Integer qcontrdoctopend) {
        this.qcontrdoctopend = qcontrdoctopend;
    }

    public String getDtfechamento() {
        return dtfechamento;
    }

    public void setDtfechamento(String dtfechamento) {
        this.dtfechamento = dtfechamento;
    }

    public String getDprodtservc() {
        return dprodtservc;
    }

    public void setDprodtservc(String dprodtservc) {
        this.dprodtservc = dprodtservc;
    }

    public String getDsmodalidade() {
        return dsmodalidade;
    }

    public void setDsmodalidade(String dsmodalidade) {
        this.dsmodalidade = dsmodalidade;
    }

    public String getCeconmmoedadesc() {
        return ceconmmoedadesc;
    }

    public void setCeconmmoedadesc(String ceconmmoedadesc) {
        this.ceconmmoedadesc = ceconmmoedadesc;
    }

    public String getVtxrentbcmbio() {
        return vtxrentbcmbio;
    }

    public void setVtxrentbcmbio(String vtxrentbcmbio) {
        this.vtxrentbcmbio = vtxrentbcmbio;
    }

    public Integer getQtdetxinfo() {
        return qtdetxinfo;
    }

    public void setQtdetxinfo(Integer qtdetxinfo) {
        this.qtdetxinfo = qtdetxinfo;
    }

    public String getVlrmoedaestrang() {
        return vlrmoedaestrang;
    }

    public void setVlrmoedaestrang(String vlrmoedaestrang) {
        this.vlrmoedaestrang = vlrmoedaestrang;
    }

    public Integer getCbcoextcmbio() {
        return cbcoextcmbio;
    }

    public void setCbcoextcmbio(Integer cbcoextcmbio) {
        this.cbcoextcmbio = cbcoextcmbio;
    }

    public String getDtcotacao() {
        return dtcotacao;
    }

    public void setDtcotacao(String dtcotacao) {
        this.dtcotacao = dtcotacao;
    }

    public String getRobsbletocmbio() {
        return robsbletocmbio;
    }

    public void setRobsbletocmbio(String robsbletocmbio) {
        this.robsbletocmbio = robsbletocmbio;
    }

    public Integer getCtpoobsbleto() {
        return ctpoobsbleto;
    }

    public void setCtpoobsbleto(Integer ctpoobsbleto) {
        this.ctpoobsbleto = ctpoobsbleto;
    }

    public List<TradeFinanceVO> getLista() {
        return lista;
    }

    public void setLista(List<TradeFinanceVO> lista) {
        this.lista = lista;
    }

    public String getTxtinformativo() {
        return txtinformativo;
    }

    public void setTxtinformativo(String txtinformativo) {
        this.txtinformativo = txtinformativo;
    }

    public String getRinfoenvolmdia() {
        return rinfoenvolmdia;
    }

    public void setRinfoenvolmdia(String rinfoenvolmdia) {
        this.rinfoenvolmdia = rinfoenvolmdia;
    }

    public String getPareceroperador() {
        return pareceroperador;
    }

    public void setPareceroperador(String pareceroperador) {
        this.pareceroperador = pareceroperador;
    }

    public String getParecerdsn() {
        return parecerdsn;
    }

    public void setParecerdsn(String parecerdsn) {
        this.parecerdsn = parecerdsn;
    }

    public Long getCunicpssoacmbiot() {
        return cunicpssoacmbiot;
    }

    public void setCunicpssoacmbiot(Long cunicpssoacmbiot) {
        this.cunicpssoacmbiot = cunicpssoacmbiot;
    }

    public String getNunicpssoacmbiot() {
        return nunicpssoacmbiot;
    }

    public void setNunicpssoacmbiot(String nunicpssoacmbiot) {
        this.nunicpssoacmbiot = nunicpssoacmbiot;
    }

    public String getNunicclicmbio() {
        return nunicclicmbio;
    }

    public void setNunicclicmbio(String nunicclicmbio) {
        this.nunicclicmbio = nunicclicmbio;
    }

    public String getNprodtservc() {
        return nprodtservc;
    }

    public void setNprodtservc(String nprodtservc) {
        this.nprodtservc = nprodtservc;
    }

    public String getNindcdeconmmoeda() {
        return nindcdeconmmoeda;
    }

    public void setNindcdeconmmoeda(String nindcdeconmmoeda) {
        this.nindcdeconmmoeda = nindcdeconmmoeda;
    }

    public String getNeconmmoedadsemb() {
        return neconmmoedadsemb;
    }

    public void setNeconmmoedadsemb(String neconmmoedadsemb) {
        this.neconmmoedadsemb = neconmmoedadsemb;
    }

    public String getNbanqrcmbiofndng() {
        return nbanqrcmbiofndng;
    }

    public void setNbanqrcmbiofndng(String nbanqrcmbiofndng) {
        this.nbanqrcmbiofndng = nbanqrcmbiofndng;
    }

    public String getNmcadoopercmbio() {
        return nmcadoopercmbio;
    }

    public void setNmcadoopercmbio(String nmcadoopercmbio) {
        this.nmcadoopercmbio = nmcadoopercmbio;
    }

    public String getNpais() {
        return npais;
    }

    public void setNpais(String npais) {
        this.npais = npais;
    }

    public String getNunicpssoamcado() {
        return nunicpssoamcado;
    }

    public void setNunicpssoamcado(String nunicpssoamcado) {
        this.nunicpssoamcado = nunicpssoamcado;
    }

    public String getNpaisbnefc() {
        return npaisbnefc;
    }

    public void setNpaisbnefc(String npaisbnefc) {
        this.npaisbnefc = npaisbnefc;
    }

    public String getVpnaltanteccmbio() {
        return vpnaltanteccmbio;
    }

    public void setVpnaltanteccmbio(String vpnaltanteccmbio) {
        this.vpnaltanteccmbio = vpnaltanteccmbio;
    }

    public Integer getCindcdeconmpnalt() {
        return cindcdeconmpnalt;
    }

    public void setCindcdeconmpnalt(Integer cindcdeconmpnalt) {
        this.cindcdeconmpnalt = cindcdeconmpnalt;
    }

    public Long getScpfcgcclicmbio() {
        return scpfcgcclicmbio;
    }

    public void setScpfcgcclicmbio(Long scpfcgcclicmbio) {
        this.scpfcgcclicmbio = scpfcgcclicmbio;
    }

    public Long getScbcoextcmbio() {
        return scbcoextcmbio;
    }

    public void setScbcoextcmbio(Long scbcoextcmbio) {
        this.scbcoextcmbio = scbcoextcmbio;
    }

    public String getPzroprdiaano() {
        return pzroprdiaano;
    }

    public void setPzroprdiaano(String pzroprdiaano) {
        this.pzroprdiaano = pzroprdiaano;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCmovtcincel() {
        return cmovtcincel;
    }

    public void setCmovtcincel(String cmovtcincel) {
        this.cmovtcincel = cmovtcincel;
    }

    public Integer getNbletocmbioano() {
        return nbletocmbioano;
    }

    public void setNbletocmbioano(Integer nbletocmbioano) {
        this.nbletocmbioano = nbletocmbioano;
    }

    public String getDinclreg() {
        return dinclreg;
    }

    public void setDinclreg(String dinclreg) {
        this.dinclreg = dinclreg;
    }

    public String getCmodldprodtdesc() {
        return cmodldprodtdesc;
    }

    public void setCmodldprodtdesc(String cmodldprodtdesc) {
        this.cmodldprodtdesc = cmodldprodtdesc;
    }

    public String getReentregue() {
        return reentregue;
    }

    public void setReentregue(String reentregue) {
        this.reentregue = reentregue;
    }

    public String getDientregue() {
        return dientregue;
    }

    public void setDientregue(String dientregue) {
        this.dientregue = dientregue;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCpfCnpjFormatado() {
        return cpfCnpjFormatado;
    }

    public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
        this.cpfCnpjFormatado = cpfCnpjFormatado;
    }

    public String getTppessoa() {
        return tppessoa;
    }

    public void setTppessoa(String tppessoa) {
        this.tppessoa = tppessoa;
    }

    public Integer getDanobase() {
        return danobase;
    }

    public void setDanobase(Integer danobase) {
        this.danobase = danobase;
    }

    public String getNcotacao() {
        return ncotacao;
    }

    public void setNcotacao(String ncotacao) {
        this.ncotacao = ncotacao;
    }

    public Integer getCaditvbletocmbio() {
        return caditvbletocmbio;
    }

    public void setCaditvbletocmbio(Integer caditvbletocmbio) {
        this.caditvbletocmbio = caditvbletocmbio;
    }

    public String getConta() {
        if (nctabcriacmbio != null) {
            conta = nctabcriacmbio.toString();
            if (digtcctabcria != null && !digtcctabcria.isEmpty()) {
                conta = nctabcriacmbio + "-" + digtcctabcria;
            }
        }
        return conta;
    }

    public String getMoedaoperacao() {
        return simbleconmmoeda + " " + descreconmmoeda;
    }

    public String getMoedadesembolso() {
        return simbleconmdsemb + " " + descreconmdsemb;
    }

    public String getPreclibor() {
        return simbleconmlibor + " " + tmesliborcmbio + " Meses + " + SiteUtil.trocarPontoPorVirgula(vtxliborcmbio) + " %AA";
    }

    public String getReceitaEstimada() {
        return simblrectacmbio + " " + SiteUtil.formatarValorWeb(vprevtrectacmbio);

    }

    public String getValorEqualizavel() {

        return simblmoedaequal + " " + vprevtcmbioequal;
    }

    /**
     * @return o valor do unidadeExterna
     */
    public UnidadeExternaVO getUnidadeExterna() {
        return unidadeExterna;
    }

    /**
     * @param unidadeExterna seta o novo valor para o campo unidadeExterna
     */
    public void setUnidadeExterna(UnidadeExternaVO unidadeExterna) {
        this.unidadeExterna = unidadeExterna;
    }

    /**
     * @return o valor do cpssoaanlsecredt
     */
    public Long getCpssoaanlsecredt() {
        return cpssoaanlsecredt;
    }

    /**
     * @param cpssoaanlsecredt seta o novo valor para o campo cpssoaanlsecredt
     */
    public void setCpssoaanlsecredt(Long cpssoaanlsecredt) {
        this.cpssoaanlsecredt = cpssoaanlsecredt;
    }

    /**
     * @return o valor do danosoltcanlse
     */
    public Integer getDanosoltcanlse() {
        return danosoltcanlse;
    }

    /**
     * @param danosoltcanlse seta o novo valor para o campo danosoltcanlse
     */
    public void setDanosoltcanlse(Integer danosoltcanlse) {
        this.danosoltcanlse = danosoltcanlse;
    }

    /**
     * @return o valor do nsoltcanlsecredt
     */
    public Long getNsoltcanlsecredt() {
        return nsoltcanlsecredt;
    }

    /**
     * @param nsoltcanlsecredt seta o novo valor para o campo nsoltcanlsecredt
     */
    public void setNsoltcanlsecredt(Long nsoltcanlsecredt) {
        this.nsoltcanlsecredt = nsoltcanlsecredt;
    }

    /**
     * @return o valor do nseqsoltcanlse
     */
    public Integer getNseqsoltcanlse() {
        return nseqsoltcanlse;
    }

    /**
     * @param nseqsoltcanlse seta o novo valor para o campo nseqsoltcanlse
     */
    public void setNseqsoltcanlse(Integer nseqsoltcanlse) {
        this.nseqsoltcanlse = nseqsoltcanlse;
    }

    /**
     * @return o valor do pjuronegoccmbio
     */
    public String getPjuronegoccmbio() {
        return pjuronegoccmbio;
    }

    /**
     * @param pjuronegoccmbio seta o novo valor para o campo pjuronegoccmbio
     */
    public void setPjuronegoccmbio(String pjuronegoccmbio) {
        this.pjuronegoccmbio = pjuronegoccmbio;
    }

    /**
     * @return o valor do listaMercadoria
     */
    public List<MercadoriaVO> getListaMercadoria() {
        return listaMercadoria;
    }

    /**
     * @param listaMercadoria seta o novo valor para o campo listaMercadoria
     */
    public void setListaMercadoria(List<MercadoriaVO> listaMercadoria) {
        this.listaMercadoria = listaMercadoria;
    }

    /**
     * @return o valor do ctpojurotrade
     */
    public Integer getCtpojurotrade() {
        return ctpojurotrade;
    }

    /**
     * @param ctpojurotrade seta o novo valor para o campo ctpojurotrade
     */
    public void setCtpojurotrade(Integer ctpojurotrade) {
        this.ctpojurotrade = ctpojurotrade;
    }

    /**
     * @return o valor do ptxequalcmbio
     */
    public String getPtxequalcmbio() {
        return ptxequalcmbio;
    }

    /**
     * @param ptxequalcmbio seta o novo valor para o campo ptxequalcmbio
     */
    public void setPtxequalcmbio(String ptxequalcmbio) {
        this.ptxequalcmbio = ptxequalcmbio;
    }

    /**
     * @return o valor do ceconmmoedaequal
     */
    public Integer getCeconmmoedaequal() {
        return ceconmmoedaequal;
    }

    /**
     * @param ceconmmoedaequal seta o novo valor para o campo ceconmmoedaequal
     */
    public void setCeconmmoedaequal(Integer ceconmmoedaequal) {
        this.ceconmmoedaequal = ceconmmoedaequal;
    }

    /**
     * @return o valor do vprevtcmbioequal
     */
    public String getVprevtcmbioequal() {
        return vprevtcmbioequal;
    }

    /**
     * @param vprevtcmbioequal seta o novo valor para o campo vprevtcmbioequal
     */
    public void setVprevtcmbioequal(String vprevtcmbioequal) {
        this.vprevtcmbioequal = vprevtcmbioequal;
    }

    /**
     * @return o valor do cmoedaeconmrecta
     */
    public Integer getCmoedaeconmrecta() {
        return cmoedaeconmrecta;
    }

    /**
     * @param cmoedaeconmrecta seta o novo valor para o campo cmoedaeconmrecta
     */
    public void setCmoedaeconmrecta(Integer cmoedaeconmrecta) {
        this.cmoedaeconmrecta = cmoedaeconmrecta;
    }

    /**
     * @return o valor do vprevtrectacmbio
     */
    public String getVprevtrectacmbio() {
        return vprevtrectacmbio;
    }

    /**
     * @param vprevtrectacmbio seta o novo valor para o campo vprevtrectacmbio
     */
    public void setVprevtrectacmbio(String vprevtrectacmbio) {
        this.vprevtrectacmbio = vprevtrectacmbio;
    }

    /**
     * @return o valor do cpermtrnsfcarta
     */
    public String getCpermtrnsfcarta() {
        return cpermtrnsfcarta;
    }

    /**
     * @param cpermtrnsfcarta seta o novo valor para o campo cpermtrnsfcarta
     */
    public void setCpermtrnsfcarta(String cpermtrnsfcarta) {
        this.cpermtrnsfcarta = cpermtrnsfcarta;
    }

    /**
     * @return o valor do cindcdcartacnfdo
     */
    public String getCindcdcartacnfdo() {
        return cindcdcartacnfdo;
    }

    /**
     * @param cindcdcartacnfdo seta o novo valor para o campo cindcdcartacnfdo
     */
    public void setCindcdcartacnfdo(String cindcdcartacnfdo) {
        this.cindcdcartacnfdo = cindcdcartacnfdo;
    }

    /**
     * @return o valor do cindcdcartaidpdt
     */
    public String getCindcdcartaidpdt() {
        return cindcdcartaidpdt;
    }

    /**
     * @param cindcdcartaidpdt seta o novo valor para o campo cindcdcartaidpdt
     */
    public void setCindcdcartaidpdt(String cindcdcartaidpdt) {
        this.cindcdcartaidpdt = cindcdcartaidpdt;
    }

    /**
     * @return o valor do vlimcobervar
     */
    public String getVlimcobervar() {
        return vlimcobervar;
    }

    /**
     * @param vlimcobervar seta o novo valor para o campo vlimcobervar
     */
    public void setVlimcobervar(String vlimcobervar) {
        this.vlimcobervar = vlimcobervar;
    }

    /**
     * @return o valor do cprznegoccmbio
     */
    public Integer getCprznegoccmbio() {
        return cprznegoccmbio;
    }

    /**
     * @param cprznegoccmbio seta o novo valor para o campo cprznegoccmbio
     */
    public void setCprznegoccmbio(Integer cprznegoccmbio) {
        this.cprznegoccmbio = cprznegoccmbio;
    }

    /**
     * @return o valor do dlimembrqcmbio
     */
    public String getDlimembrqcmbio() {
        return dlimembrqcmbio;
    }

    /**
     * @param dlimembrqcmbio seta o novo valor para o campo dlimembrqcmbio
     */
    public void setDlimembrqcmbio(String dlimembrqcmbio) {
        this.dlimembrqcmbio = dlimembrqcmbio;
    }

    /**
     * @return o valor do valddcarta
     */
    public Integer getValddcarta() {
        return valddcarta;
    }

    /**
     * @param valddcarta seta o novo valor para o campo valddcarta
     */
    public void setValddcarta(Integer valddcarta) {
        this.valddcarta = valddcarta;
    }

    /**
     * @return o valor do cindcdembrqpcial
     */
    public String getCindcdembrqpcial() {
        return cindcdembrqpcial;
    }

    /**
     * @param cindcdembrqpcial seta o novo valor para o campo cindcdembrqpcial
     */
    public void setCindcdembrqpcial(String cindcdembrqpcial) {
        this.cindcdembrqpcial = cindcdembrqpcial;
    }

    public ObservacoesCotacaoVO getObsCotacaoVO() {
        return obsCotacaoVO;
    }

    public void setObsCotacaoVO(ObservacoesCotacaoVO obsCotacaoVO) {
        this.obsCotacaoVO = obsCotacaoVO;
    }

    /**
     * @return o valor do qpcelatradeprinc
     */
    public Integer getQpcelatradeprinc() {
        return qpcelatradeprinc;
    }

    /**
     * @param qpcelatradeprinc seta o novo valor para o campo qpcelatradeprinc
     */
    public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
        this.qpcelatradeprinc = qpcelatradeprinc;
    }

    public CalendarioPeriodo getDataPrevEmbarq() {
//        try {
//            dataPrevEmbarq.setInicio(SiteUtil.stringToDate(dprevtinicembrq, "dd.MM.yyyy"));
//            dataPrevEmbarq.setFim(SiteUtil.stringToDate(dprevtfimembrq, "dd.MM.yyyy"));
//        } catch (ParseException e) {
//            dataPrevEmbarq = new CalendarioPeriodo();
//        }
        return dataPrevEmbarq;
    }

    public void setDataPrevEmbarq(CalendarioPeriodo dataPrevEmbarq) {
        this.dataPrevEmbarq = dataPrevEmbarq;
    }

    public CalendarioPeriodo getDataPrevDesemb() {
        /*
         * dataPrevDesemb.setBeginDate(SiteUtil.stringToDate(, "dd/MM/yyyy"));
         * dataPrevDesemb.setEndDate(SiteUtil.stringToDate(, "dd/MM/yyyy"));
         */
        return dataPrevDesemb;
    }

    public void setDataPrevDesemb(CalendarioPeriodo dataPrevDesemb) {
        this.dataPrevDesemb = dataPrevDesemb;
    }

    /**
     * @return o valor do dinicvalddcmbio
     */
    public String getDinicvalddcmbio() {
        return dinicvalddcmbio;
    }

    /**
     * @param dinicvalddcmbio seta o novo valor para o campo dinicvalddcmbio
     */
    public void setDinicvalddcmbio(String dinicvalddcmbio) {
        this.dinicvalddcmbio = dinicvalddcmbio;
    }

    /**
     * @return o valor do dfimnegoccmbio
     */
    public String getDfimnegoccmbio() {
        return dfimnegoccmbio;
    }

    /**
     * @param dfimnegoccmbio seta o novo valor para o campo dfimnegoccmbio
     */
    public void setDfimnegoccmbio(String dfimnegoccmbio) {
        this.dfimnegoccmbio = dfimnegoccmbio;
    }

    /**
     * @return o valor do simblmoedaequal
     */
    public String getSimblmoedaequal() {
        return simblmoedaequal;
    }

    /**
     * @param simblmoedaequal seta o novo valor para o campo simblmoedaequal
     */
    public void setSimblmoedaequal(String simblmoedaequal) {
        this.simblmoedaequal = simblmoedaequal;
    }

    /**
     * @return o valor do simblrectacmbio
     */
    public String getSimblrectacmbio() {
        return simblrectacmbio;
    }

    /**
     * @param simblrectacmbio seta o novo valor para o campo simblrectacmbio
     */
    public void setSimblrectacmbio(String simblrectacmbio) {
        this.simblrectacmbio = simblrectacmbio;
    }

    /**
     * @return o valor do dbcocred
     */
    public String getDbcocred() {
        return dbcocred;
    }

    /**
     * @param dbcocred seta o novo valor para o campo dbcocred
     */
    public void setDbcocred(String dbcocred) {
        this.dbcocred = dbcocred;
    }

    public Integer getQregexporcmbio() {
        return qregexporcmbio;
    }

    public void setQregexporcmbio(Integer qregexporcmbio) {
        this.qregexporcmbio = qregexporcmbio;
    }

    public Integer getQprevtembrqcmbio() {
        return qprevtembrqcmbio;
    }

    public void setQprevtembrqcmbio(Integer qprevtembrqcmbio) {
        this.qprevtembrqcmbio = qprevtembrqcmbio;
    }

    public Integer getCfluxoperdccmbio() {
        return cfluxoperdccmbio;
    }

    public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
        this.cfluxoperdccmbio = cfluxoperdccmbio;
    }

    public Integer getCidtfdbndesgrp() {
        return cidtfdbndesgrp;
    }

    public void setCidtfdbndesgrp(Integer cidtfdbndesgrp) {
        this.cidtfdbndesgrp = cidtfdbndesgrp;
    }

    public String getDescrGrupo() {
        return descrGrupo;
    }

    public void setDescrGrupo(String descrGrupo) {
        this.descrGrupo = descrGrupo;
    }

    public Integer getCidtfdbndesporte() {
        return cidtfdbndesporte;
    }

    public void setCidtfdbndesporte(Integer cidtfdbndesporte) {
        this.cidtfdbndesporte = cidtfdbndesporte;
    }

    public String getDescrPorte() {
        return descrPorte;
    }

    public void setDescrPorte(String descrPorte) {
        this.descrPorte = descrPorte;
    }

    /**
     * @return o valor do dfchtobletodesc
     */
    public String getDfchtobletodesc() {
        return dfchtobletodesc;
    }

    /**
     * @param dfchtobletodesc seta o novo valor para o campo dfchtobletodesc
     */
    public void setDfchtobletodesc(String dfchtobletodesc) {
        this.dfchtobletodesc = dfchtobletodesc;
    }

    /**
     * @return o valor do ifluxoperdccmbio
     */
    public String getIfluxoperdccmbio() {
        return ifluxoperdccmbio;
    }

    /**
     * @param ifluxoperdccmbio seta o novo valor para o campo ifluxoperdccmbio
     */
    public void setIfluxoperdccmbio(String ifluxoperdccmbio) {
        this.ifluxoperdccmbio = ifluxoperdccmbio;
    }

    public Integer getQpcelacmbiotrade() {
        return qpcelacmbiotrade;
    }

    public void setQpcelacmbiotrade(Integer qpcelacmbiotrade) {
        this.qpcelacmbiotrade = qpcelacmbiotrade;
    }

    public Integer getTdiacarenprinc() {
        return tdiacarenprinc;
    }

    public void setTdiacarenprinc(Integer tdiacarenprinc) {
        this.tdiacarenprinc = tdiacarenprinc;
    }

    public void setMoedalimite(String moedalimite) {
        this.moedalimite = moedalimite;
    }

    public String getMoedalimite() {
        moedalimite = simbleconmlim + " " + descreconmlim;
        return moedalimite;
    }

    /**
     * @return o valor do dataHoje
     */
    public String getDataHoje() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        this.dataHoje = dateFormat.format(date); 
        return this.dataHoje;

    }

    /**
     * @param dataHoje seta o novo valor para o campo dataHoje
     */
    public void setDataHoje(String dataHoje) {
        this.dataHoje = dataHoje;
    }

    public Long getNppstapontucmbio() {
        return nppstapontucmbio;
    }

    public void setNppstapontucmbio(Long nppstapontucmbio) {
        this.nppstapontucmbio = nppstapontucmbio;
    }

    /**
     * @return o valor do cbanqrcmbiofndng
     */
    public Long getCbanqrcmbiofndng() {
        return cbanqrcmbiofndng;
    }

    /**
     * @param cbanqrcmbiofndng seta o novo valor para o campo cbanqrcmbiofndng
     */
    public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
        this.cbanqrcmbiofndng = cbanqrcmbiofndng;
    }

    /**
     * @return o valor do cbanqrcmbiorcdor
     */
    public Long getCbanqrcmbiorcdor() {
        return cbanqrcmbiorcdor;
    }

    /**
     * @param cbanqrcmbiorcdor seta o novo valor para o campo cbanqrcmbiorcdor
     */
    public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
        this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
    }

    /**
     * @return o valor do hinclreghist
     */
    public String getHinclreghist() {
        return hinclreghist;
    }

    /**
     * @param hinclreghist seta o novo valor para o campo hinclreghist
     */
    public void setHinclreghist(String hinclreghist) {
        this.hinclreghist = hinclreghist;
    }
    
    /**
     * @return o valor do hinclreghist no formato WEB
     */
    public String getHinclreghistFormatado() {
        return SiteUtil.dateTimeMainframeToWeb(hinclreghist);
    }

    /**
     * @return o valor do dbcorecebedor
     */
    public String getDbcorecebedor() {
        return dbcorecebedor;
    }

    /**
     * @param dbcorecebedor seta o novo valor para o campo dbcorecebedor
     */
    public void setDbcorecebedor(String dbcorecebedor) {
        this.dbcorecebedor = dbcorecebedor;
    }

    /**
     * @return o valor do dlimfndngcmbio
     */
    public String getDlimfndngcmbio() {
        return dlimfndngcmbio;
    }

    /**
     * @param dlimfndngcmbio seta o novo valor para o campo dlimfndngcmbio
     */
    public void setDlimfndngcmbio(String dlimfndngcmbio) {
        this.dlimfndngcmbio = dlimfndngcmbio;
    }

    /**
     * @return o valor do caditvbletocmbiostr
     */
    public String getCaditvbletocmbiostr() {
        return caditvbletocmbiostr;
    }

    /**
     * @param caditvbletocmbiostr seta o novo valor para o campo caditvbletocmbiostr
     */
    public void setCaditvbletocmbiostr(String caditvbletocmbiostr) {
        this.caditvbletocmbiostr = caditvbletocmbiostr;
    }

    /**
     * @return o valor do cidtfdcartacsndo
     */

    /**
     * DOCUMENTOS CONSIGNADOS 1 - IMPORTADOR 2- BANCO BRADESCO 3 - OUTROS (ABRIR OBSERVACAO)
     * 
     * @return
     * 
     * **/
    public Integer getCidtfdcartacsndo() {
        return cidtfdcartacsndo;
    }

    /**
     * @param cidtfdcartacsndo seta o novo valor para o campo cidtfdcartacsndo
     */
    public void setCidtfdcartacsndo(Integer cidtfdcartacsndo) {
        this.cidtfdcartacsndo = cidtfdcartacsndo;
    }

    /**
     * @param documentosConsignados seta o novo valor para o campo documentosConsignados
     */
    public String getDocumentosConsignados() {

        if (cidtfdcartacsndo.equals(1)) {
            return "Importador";

        }
        if (cidtfdcartacsndo.equals(2)) {
            return "Banco Bradesco";

        }
        if (cidtfdcartacsndo.equals(3)) {
            return "Outros" + " " + "-";
        }

        return documentosConsignados;
    }

    /**
     * @param documentosConsignados seta o novo valor para o campo documentosConsignados
     */
    public void setDocumentosConsignados(String documentosConsignados) {
        this.documentosConsignados = documentosConsignados;
    }

    /**
     * @return o valor do comissaoInterna
     */
    public String getComissaoInterna() {

        if (ccobrcomisadcio.equals("1")) {
            return "Sim";

        } else if (ccobrcomisadcio.equals("2")) {
            return "Não";

        } else if (!ccobrcomisadcio.equals("1") || ccobrcomisadcio.equals("2")) {
            return "-";
        }

        return comissaoInterna;
    }

    /**
     * @param comissaoInterna seta o novo valor para o campo comissaoInterna
     */
    public void setComissaoInterna(String comissaoInterna) {
        this.comissaoInterna = comissaoInterna;
    }

    /**
     * @return o valor do pcdimaiscmbio
     */
    public String getPcdimaiscmbio() {
        return pcdimaiscmbio;
    }

    /**
     * @param pcdimaiscmbio seta o novo valor para o campo pcdimaiscmbio
     */
    public void setPcdimaiscmbio(String pcdimaiscmbio) {
        this.pcdimaiscmbio = pcdimaiscmbio;
    }

    /**
     * @return o valor do ptxcdifinan
     */
    public String getPtxcdifinan() {
        return ptxcdifinan;
    }

    /**
     * @param ptxcdifinan seta o novo valor para o campo ptxcdifinan
     */
    public void setPtxcdifinan(String ptxcdifinan) {
        this.ptxcdifinan = ptxcdifinan;
    }

    /**
     * @return o valor do pfixajurocmbio
     */
    public String getPfixajurocmbio() {
        return pfixajurocmbio;
    }

    /**
     * @param pfixajurocmbio seta o novo valor para o campo pfixajurocmbio
     */
    public void setPfixajurocmbio(String pfixajurocmbio) {
        this.pfixajurocmbio = pfixajurocmbio;
    }

    /**
     * @return o valor do concatenaTxaIndicador
     */
    public String getConcatenaTxaIndicador() {

        if (SiteUtil.isValueZero(pcdimaiscmbio) == false) {
            return "CDI+" + " " + pcdimaiscmbio;
        }

        if (SiteUtil.isValueZero(ptxcdifinan) == false) {
            return "%CDI" + " " + ptxcdifinan;
        }

        if (SiteUtil.isValueZero(pfixajurocmbio) == false) {
            return "Taxa Pré" + " " + pfixajurocmbio;
        }

        return concatenaTxaIndicador;
    }

    /**
     * @param concatenaTxaIndicador seta o novo valor para o campo concatenaTxaIndicador
     */
    public void setConcatenaTxaIndicador(String concatenaTxaIndicador) {
        this.concatenaTxaIndicador = concatenaTxaIndicador;
    }

    public String getCindcdlastragric() {
        return cindcdlastragric;
    }

    public void setCindcdlastragric(String cindcdlastragric) {
        this.cindcdlastragric = cindcdlastragric;
    }

    /**
     * @return o valor do lastroLca
     */
    public String getLastroLca() {

        if (cindcdlastragric.equals("1")) {
            return "Sim";

        } else if (cindcdlastragric.equals("2")) {
            return "Não";

        } else if (!cindcdlastragric.equals("1") || cindcdlastragric.equals("2")) {
            return "-";
        }
        return lastroLca;
    }

    /**
     * @param lastroLca seta o novo valor para o campo lastroLca
     */
    public void setLastroLca(String lastroLca) {
        this.lastroLca = lastroLca;
    }

    /**
     * @return o valor do montaJurosMoedaNac
     */
    public String getMontaJurosMoedaNac() {

        if (cnegocswapestrg.equals("1")) {
            return "Sim";

        } else if (cnegocswapestrg.equals("2")) {
            return "Não";

        } else if (!cnegocswapestrg.equals("1") || cnegocswapestrg.equals("2")) {
            return "-";
        }

        return montaJurosMoedaNac;
    }

    /**
     * @param montaJurosMoedaNac seta o novo valor para o campo montaJurosMoedaNac
     */
    public void setMontaJurosMoedaNac(String montaJurosMoedaNac) {
        this.montaJurosMoedaNac = montaJurosMoedaNac;
    }

    public EnumProduto getProduto() {
        return EnumProduto.fromCode(this.cprodtservc);
    }

    /**
     * @return o valor do pagtefincrcmbio
     */
    public String getPagtefincrcmbio() {
        return pagtefincrcmbio;
    }

    /**
     * @param pagtefincrcmbio seta o novo valor para o campo pagtefincrcmbio
     */
    public void setPagtefincrcmbio(String pagtefincrcmbio) {
        this.pagtefincrcmbio = pagtefincrcmbio;
    }

    /**
     * @return o valor do ptotjurocmbio
     */
    public String getPtotjurocmbio() {
        return ptotjurocmbio;
    }

    /**
     * @param ptotjurocmbio seta o novo valor para o campo ptotjurocmbio
     */
    public void setPtotjurocmbio(String ptotjurocmbio) {
        this.ptotjurocmbio = ptotjurocmbio;
    }

    /**
     * @return o valor do vtxremunbndes
     */
    public String getVtxremunbndes() {
        return vtxremunbndes;
    }

    /**
     * @param vtxremunbndes seta o novo valor para o campo vtxremunbndes
     */
    public void setVtxremunbndes(String vtxremunbndes) {
        this.vtxremunbndes = vtxremunbndes;
    }

    /**
     * @return o valor do cidtfdrespdesp
     */
    public Integer getCidtfdrespdesp() {
        return cidtfdrespdesp;
    }

    /**
     * @param cidtfdrespdesp seta o novo valor para o campo cidtfdrespdesp
     */
    public void setCidtfdrespdesp(Integer cidtfdrespdesp) {
        this.cidtfdrespdesp = cidtfdrespdesp;
    }

    /**
     * @return o valor do pcomismtoricmbio
     */
    public String getPcomismtoricmbio() {
        return pcomismtoricmbio;
    }

    /**
     * @param pcomismtoricmbio seta o novo valor para o campo pcomismtoricmbio
     */
    public void setPcomismtoricmbio(String pcomismtoricmbio) {
        this.pcomismtoricmbio = pcomismtoricmbio;
    }

    /**
     * @return o valor do ccobrcomismtori
     */
    public Integer getCcobrcomismtori() {
        return ccobrcomismtori;
    }

    /**
     * @param ccobrcomismtori seta o novo valor para o campo ccobrcomismtori
     */
    public void setCcobrcomismtori(Integer ccobrcomismtori) {
        this.ccobrcomismtori = ccobrcomismtori;
    }

    /**
     * @return o valor do ccobrcomisagte
     */
    public Integer getCcobrcomisagte() {
        return ccobrcomisagte;
    }

    /**
     * @param ccobrcomisagte seta o novo valor para o campo ccobrcomisagte
     */
    public void setCcobrcomisagte(Integer ccobrcomisagte) {
        this.ccobrcomisagte = ccobrcomisagte;
    }

    /**
     * @return o valor do cobranComissBancoMand
     */
    public String getCobranComissBancoMand() {
        
		if (ccobrcomismtori.equals(Numeros.NUM2)) {
			return "Flat";

		} else if (ccobrcomismtori.equals(Numeros.NUM3)) {
			return "AA";

		} else if (ccobrcomismtori.equals(Numeros.NUM4)) {
			return "AM";

		}

        return cobranComissBancoMand;
    }

    /**
     * @param cobranComissBancoMand seta o novo valor para o campo cobranComissBancoMand
     */
    public void setCobranComissBancoMand(String cobranComissBancoMand) {
        this.cobranComissBancoMand = cobranComissBancoMand;
    }

    /**
     * @return o valor do cobranComissAgente
     */
    public String getCobranComissAgente() {

        if(ccobrcomisagte.equals(Numeros.NUM2)) {
            return "Flat";
        
        }else if(ccobrcomisagte.equals(Numeros.NUM3)) {
            return "AA";
            
        } else if (ccobrcomisagte.equals(Numeros.NUM4)) {
            return "AM";
        
        } 

        return cobranComissAgente;
    }

    /**
     * @param cobranComissAgente seta o novo valor para o campo cobranComissAgente
     */
    public void setCobranComissAgente(String cobranComissAgente) {
        this.cobranComissAgente = cobranComissAgente;
    }

    /**
     * @return o valor do dvctocntragarnt
     */
    public Date getDvctocntragarnt() {
        return dvctocntragarnt;
    }

    /**
     * @param dvctocntragarnt seta o novo valor para o campo dvctocntragarnt
     */
    public void setDvctocntragarnt(Date dvctocntragarnt) {
        this.dvctocntragarnt = dvctocntragarnt;
    }

    /**
     * @return o valor do cnegoccmbioindmd
     */
    public String getCnegoccmbioindmd() {
        return cnegoccmbioindmd;
    }

    /**
     * @param cnegoccmbioindmd seta o novo valor para o campo cnegoccmbioindmd
     */
    public void setCnegoccmbioindmd(String cnegoccmbioindmd) {
        this.cnegoccmbioindmd = cnegoccmbioindmd;
    }

    /**
     * @return o valor do cindcdcntragarnt
     */
    public String getCindcdcntragarnt() {
        return cindcdcntragarnt;
    }

    /**
     * @param cindcdcntragarnt seta o novo valor para o campo cindcdcntragarnt
     */
    public void setCindcdcntragarnt(String cindcdcntragarnt) {
        this.cindcdcntragarnt = cindcdcntragarnt;
    }

    /**
     * @return o valor do tdiacntragarnt
     */
    public Integer getTdiacntragarnt() {
        return tdiacntragarnt;
    }

    /**
     * @param tdiacntragarnt seta o novo valor para o campo tdiacntragarnt
     */
    public void setTdiacntragarnt(Integer tdiacntragarnt) {
        this.tdiacntragarnt = tdiacntragarnt;
    }

    /**
     * @return o valor do dabertcntragarnt
     */
    public Date getDabertcntragarnt() {
        return dabertcntragarnt;
    }

    /**
     * @param dabertcntragarnt seta o novo valor para o campo dabertcntragarnt
     */
    public void setDabertcntragarnt(Date dabertcntragarnt) {
        this.dabertcntragarnt = dabertcntragarnt;
    }

    /**
     * @return o valor do cindcdrenovcntra
     */
    public String getCindcdrenovcntra() {
        return cindcdrenovcntra;
    }

    /**
     * @param cindcdrenovcntra seta o novo valor para o campo cindcdrenovcntra
     */
    public void setCindcdrenovcntra(String cindcdrenovcntra) {
        this.cindcdrenovcntra = cindcdrenovcntra;
    }

    /**
     * @return o valor do qdiaalertcntra
     */
    public Integer getQdiaalertcntra() {
        return qdiaalertcntra;
    }

    /**
     * @param qdiaalertcntra seta o novo valor para o campo qdiaalertcntra
     */
    public void setQdiaalertcntra(Integer qdiaalertcntra) {
        this.qdiaalertcntra = qdiaalertcntra;
    }

    /**
     * @return o valor do dalertvctocntra
     */
    public Date getDalertvctocntra() {
        return dalertvctocntra;
    }

    /**
     * @param dalertvctocntra seta o novo valor para o campo dalertvctocntra
     */
    public void setDalertvctocntra(Date dalertvctocntra) {
        this.dalertvctocntra = dalertvctocntra;
    }

    /**
     * @return o valor do cindcdcustoexter
     */
    public String getCindcdcustoexter() {
        return cindcdcustoexter;
    }

    /**
     * @param cindcdcustoexter seta o novo valor para o campo cindcdcustoexter
     */
    public void setCindcdcustoexter(String cindcdcustoexter) {
        this.cindcdcustoexter = cindcdcustoexter;
    }

    /**
     * @return o valor do endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco seta o novo valor para o campo endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return o valor do pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais seta o novo valor para o campo pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return o valor do tipoPesquisaBeneficiario
     */
    public Integer getTipoPesquisaBeneficiario() {
        return tipoPesquisaBeneficiario;
    }

    /**
     * @param tipoPesquisaBeneficiario seta o novo valor para o campo tipoPesquisaBeneficiario
     */
    public void setTipoPesquisaBeneficiario(Integer tipoPesquisaBeneficiario) {
        this.tipoPesquisaBeneficiario = tipoPesquisaBeneficiario;
    }

    /**
     * @return o valor do despesaVO
     */
    public ListaDespesasVO getDespesaVO() {
        return despesaVO;
    }

    /**
     * @param despesaVO seta o novo valor para o campo despesaVO
     */
    public void setDespesaVO(ListaDespesasVO despesaVO) {
        this.despesaVO = despesaVO;
    }

    /**
     * @return o valor do cotacaoFundingVO
     */
    public ListaCotacoesExternasVO getCotacaoFundingVO() {
        return cotacaoFundingVO;
    }

    /**
     * @param cotacaoFundingVO seta o novo valor para o campo cotacaoFundingVO
     */
    public void setCotacaoFundingVO(ListaCotacoesExternasVO cotacaoFundingVO) {
        this.cotacaoFundingVO = cotacaoFundingVO;
    }

    /**
     * @return o valor do listaCotacoes
     */
    public List<ListaCotacoesExternasVO> getListaCotacoes() {
        return listaCotacoes;
    }

    /**
     * @param listaCotacoes seta o novo valor para o campo listaCotacoes
     */
    public void setListaCotacoes(List<ListaCotacoesExternasVO> listaCotacoes) {
        this.listaCotacoes = listaCotacoes;
    }

    /**
     * @return o valor do listaDespesas
     */
    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }

    /**
     * @param listaTiposDespesa seta o novo valor para o campo listaDespesas
     */
    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    /**
     * @return o valor do formatadDataVencProsposta
     */
    public String getFormatadDataVencProsposta() {
            
        if(dvctocntragarnt != null) {
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dvctocntragarnt);
            formatadDataVencProsposta = dataFormatada;
        }

        return formatadDataVencProsposta;
    }

    /**
     * @param formatadDataVencProsposta seta o novo valor para o campo formatadDataVencProsposta
     */
    public void setFormatadDataVencProsposta(String formatadDataVencProsposta) {
        this.formatadDataVencProsposta = formatadDataVencProsposta;
    }

    /**
     * @return o valor do formataDataAbrtOferta
     */
    public String getFormataDataAbrtOferta() {
        
        if(dabertcntragarnt != null) {
            
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dabertcntragarnt);
            formataDataAbrtOferta = dataFormatada;
            
        }

        return formataDataAbrtOferta;
      
    }

    /**
     * @param formataDataAbrtOferta seta o novo valor para o campo formataDataAbrtOferta
     */
    public void setFormataDataAbrtOferta(String formataDataAbrtOferta) {
        this.formataDataAbrtOferta = formataDataAbrtOferta;
    }

    /**
     * @return o valor do formataDataAlertGarantias
     */
    public String getFormataDataAlertGarantias() {
        
        if(dalertvctocntra != null) {
            
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dalertvctocntra);
            formataDataAlertGarantias = dataFormatada;
            
        }
  
        return formataDataAlertGarantias;
     
    }

    /**
     * @param formataDataAlertGarantias seta o novo valor para o campo formataDataAlertGarantias
     */
    public void setFormataDataAlertGarantias(String formataDataAlertGarantias) {
        this.formataDataAlertGarantias = formataDataAlertGarantias;
    }

    /**
     * @return o valor do formataPrazoLC
     */
    public String getFormataPrazoLC() {
        
        if(cprznegoccmbio.equals(1)) {
            return "Á Vista";
        
        }if(cprznegoccmbio.equals(2)) {
            return "Prazo";
        
        }if(cprznegoccmbio.equals(3)) {
            return "Mix Payment";
        }
        return formataPrazoLC;
    }

    /**
     * @param formataPrazoLC seta o novo valor para o campo formataPrazoLC
     */
    public void setFormataPrazoLC(String formataPrazoLC) {
        this.formataPrazoLC = formataPrazoLC;
    }

    /**
     * @return o valor do formataEca
     */
    public String getFormataEca() {
        
        if(cindcdlastrcarta.equals("1")) {
            return "Sim";
        }else if(cindcdlastrcarta.equals("2")) {
            return "Não";
        }
        return formataEca;
    }

    /**
     * @param formataEca seta o novo valor para o campo formataEca
     */
    public void setFormataEca(String formataEca) {
        this.formataEca = formataEca;
    }

    /**
     * @return o valor do formataTransferivel
     */
    public String getFormataTransferivel() {
        
        if(cpermtrnsfcarta.equals("1")) {
            return "Sim";
            
        }else if(cpermtrnsfcarta.equals("2")) {
            return "Não";
        }
        return formataTransferivel;
    }

    /**
     * @param formataTransferivel seta o novo valor para o campo formataTransferivel
     */
    public void setFormataTransferivel(String formataTransferivel) {
        this.formataTransferivel = formataTransferivel;
    }

    /**
     * @return o valor do formataAnyBank
     */
    public String getFormataAnyBank() {
        if(cindcdcartaidpdt.equals("1")) {
            return "Sim";
        }else if(cindcdcartaidpdt.equals("2")) {
            return "Não";
        }
        return formataAnyBank;
    }

    /**
     * @param formataAnyBank seta o novo valor para o campo formataAnyBank
     */
    public void setFormataAnyBank(String formataAnyBank) {
        this.formataAnyBank = formataAnyBank;
    }

    /**
     * @return o valor do formataViaCcr
     */
    public String getFormataViaCcr() {
        if(ccartaconverecdd.equals("1")) {
            return "Sim";
        }else if(ccartaconverecdd.equals("2")) {
            return "Não";
        }
        return formataViaCcr;
    }

    /**
     * @param formataViaCcr seta o novo valor para o campo formataViaCcr
     */
    public void setFormataViaCcr(String formataViaCcr) {
        this.formataViaCcr = formataViaCcr;
    }

    /**
     * @return o valor do formataEmbarqueParcial
     */
    public String getFormataEmbarqueParcial() {
        if(cindcdembrqpcial.equals("1")) {
            return "Sim";
        }else if(cindcdembrqpcial.equals("2")) {
            return "Não";
        }
        return formataEmbarqueParcial;
    }

    /**
     * @param formataEmbarqueParcial seta o novo valor para o campo formataEmbarqueParcial
     */
    public void setFormataEmbarqueParcial(String formataEmbarqueParcial) {
        this.formataEmbarqueParcial = formataEmbarqueParcial;
    }

    /**
     * @return o valor do formataContraGarantia
     */
    public String getFormataContraGarantia() {
        if(cindcdcntragarnt.equals("1")) {
            return "Sim";
        }else if (cindcdcntragarnt.equals("2")) {
            return "Não";
        }
        return formataContraGarantia;
    }

    /**
     * @param formataContraGarantia seta o novo valor para o campo formataContraGarantia
     */
    public void setFormataContraGarantia(String formataContraGarantia) {
        this.formataContraGarantia = formataContraGarantia;
    }

    /**
     * @return o valor do formataRenovAutomatica
     */
    public String getFormataRenovAutomatica() {
        if(cindcdrenovcntra.equals("1")) {
            return "Sim";
        }else if (cindcdrenovcntra.equals("2")) {
            return "Não";
        }
        return formataRenovAutomatica;
    }

    /**
     * @param formataRenovAutomatica seta o novo valor para o campo formataRenovAutomatica
     */
    public void setFormataRenovAutomatica(String formataRenovAutomatica) {
        this.formataRenovAutomatica = formataRenovAutomatica;
    }

    /**
     * @return o valor do formataCustoExterno
     */
    public String getFormataCustoExterno() {
        if(cindcdcustoexter.equals("1")) {
            return "Sim";
        }else if (cindcdcustoexter.equals("2")) {
            return "Não";
        }
        return formataCustoExterno;
    }

    /**
     * @param formataCustoExterno seta o novo valor para o campo formataCustoExterno
     */
    public void setFormataCustoExterno(String formataCustoExterno) {
        this.formataCustoExterno = formataCustoExterno;
    }

    /**
     * @return o valor do formataConfirmada
     */
    public String getFormataConfirmada() {
        if(cindcdcartacnfdo.equals("1")) {
            return "Sim";
        }else if(cindcdcartacnfdo.equals("2")) {
            return "Não";
        }
        return formataConfirmada;
    }

    /**
     * @param formataConfirmada seta o novo valor para o campo formataConfirmada
     */
    public void setFormataConfirmada(String formataConfirmada) {
        this.formataConfirmada = formataConfirmada;
    }

    public String getCusuariosess() {
        return cusuariosess;
    }

    public void setCusuariosess(String cusuariosess) {
        this.cusuariosess = cusuariosess;
    }

    public String getNusuariosess() {
        return nusuariosess;
    }

    public void setNusuariosess(String nusuariosess) {
        this.nusuariosess = nusuariosess;
    }

    public List<ListaResponsavelDespesaVO> getListaDespesaGaran() {
        return listaDespesaGaran;
    }

    public void setListaDespesaGaran(List<ListaResponsavelDespesaVO> listaDespesaGaran) {
        this.listaDespesaGaran = listaDespesaGaran;
    }

    /**
     * @return o valor do inddqmto
     */
    public String getInddqmto() {
        return inddqmto;
    }

    /**
     * @param inddqmto seta o novo valor para o campo inddqmto
     */
    public void setInddqmto(String inddqmto) {
        this.inddqmto = inddqmto;
    }

    /**
     * @return o valor do rjustfdqmto
     */
    public String getRjustfdqmto() {
        return rjustfdqmto;
    }

    /**
     * @param rjustfdqmto seta o novo valor para o campo rjustfdqmto
     */
    public void setRjustfdqmto(String rjustfdqmto) {
        this.rjustfdqmto = rjustfdqmto;
    }

    /**
     * @return o valor do finalidade
     */
    public String getFinalidade() {
        return finalidade;
    }
    
    /**
     * @param finalidade seta o novo valor para o campo finalidade
     */
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
    
    /**
     * @return o valor do imunindcmbio
     */
    public String getImunindcmbio() {
        return imunindcmbio;
    }
    
    /**
     * @param imunindcmbio seta o novo valor para o campo imunindcmbio
     */
    public void setImunindcmbio(String imunindcmbio) {
        this.imunindcmbio = imunindcmbio;
    }

	/**
	 * @return the nindcdembrqpcial
	 */
	public String getNindcdembrqpcial() {
		if (this.getCindcdembrqpcial().equals("1") ) {
			return "Parcial";
		} else if (this.getCindcdembrqpcial().equals("2") ) {
				return "Total";
		} else {
			return "";
		}
	}

	/**
	 * @param nindcdembrqpcial the nindcdembrqpcial to set
	 */
	public void setNindcdembrqpcial(String nindcdembrqpcial) {
		this.nindcdembrqpcial = nindcdembrqpcial;
	}

	/**
	 * @return the nomecompletocli
	 */
	public String getNomecompletocli() {
		return nomecompletocli;
	}

	/**
	 * @param nomecompletocli the nomecompletocli to set
	 */
	public void setNomecompletocli(String nomecompletocli) {
		this.nomecompletocli = nomecompletocli;
	}

    /**
     * @return o valor do formataJuroMora
     */
    public String getFormataJuroMora() {
        
		/*
		 * obter o valor do campo NPCCWX1S-CBASE-JURO-MORA referente ao Fluxo NPCCIAPG conforme abaixo:
		 *
		 * Caso valor do campo for '0' formatar o Label período juros Mora com 'A.A.'.
		 * Caso valor do campo for '1' formatar o Label período juros Mora com 'A.M'.
		 * Caso valor do campo for '2' formatar o Label período juros Mora com 'ao bimestre'.
		 * Caso valor do campo for '3' formatar o Label período juros Mora com 'ao trimestre'.
		 * Caso valor do campo for '6' formatar o Label período juros Mora com 'ao semestre'.
		 * 
		 */
        if(cbasejuromora.equals(Numeros.ZERO)) {
            return "A.A";
        
        } else if(cbasejuromora.equals(Numeros.UM)) {
            return "A.M";
            
        } else if(cbasejuromora.equals(Numeros.DOIS)) {
            return "ao bimestre";
            
        } else if(cbasejuromora.equals(Numeros.TRES)) {
            return "ao trimestre";
            
        } else if(cbasejuromora.equals(Numeros.SEIS)) {
            return "ao semestre";
            
        }
    	
        return formataJuroMora;
    }

    /**
     * @param formataJuroMora seta o novo valor para o campo formataJuroMora
     */
    public void setFormataJuroMora(String formataJuroMora) {
        this.formataJuroMora = formataJuroMora;
    }

    /**
     * @return o valor do formataDataDesembIni
     */
    public String getFormataDataDesembIni() {
        
        if(dabertcntragarnt != null) {
            formataDataDesembIni = new SimpleDateFormat("dd/MM/yyyy").format(dabertcntragarnt);
        }
         
        return formataDataDesembIni;
    }

    /**
     * @param formataDataDesembIni seta o novo valor para o campo formataDataDesembIni
     */
    public void setFormataDataDesembIni(String formataDataDesembIni) {
        this.formataDataDesembIni = formataDataDesembIni;
    }

    /**
     * @return o valor do formataDataDesembFim
     */
    public String getFormataDataDesembFim() {
        
        if(dvctocntragarnt != null) {
            formataDataDesembFim = new SimpleDateFormat("dd/MM/yyyy").format(dvctocntragarnt);
        }
        
        return formataDataDesembFim;
    }

    /**
     * @param formataDataDesembFim seta o novo valor para o campo formataDataDesembFim
     */
    public void setFormataDataDesembFim(String formataDataDesembFim) {
        this.formataDataDesembFim = formataDataDesembFim;
    }

    /**
     * @return o valor do cclub
     */
    public Long getCclub() {
        return cclub;
    }

    /**
     * @param cclub seta o novo valor para o campo cclub
     */
    public void setCclub(Long cclub) {
        this.cclub = cclub;
    }

    /**
     * @return o valor do cdcpfcnpj
     */
    public Integer getCdcpfcnpj() {
        return cdcpfcnpj;
    }

    /**
     * @param cdcpfcnpj seta o novo valor para o campo cdcpfcnpj
     */
    public void setCdcpfcnpj(Integer cdcpfcnpj) {
        this.cdcpfcnpj = cdcpfcnpj;
    }

    /**
     * @return o valor do cdfilial
     */
    public Integer getCdfilial() {
        return cdfilial;
    }

    /**
     * @param cdfilial seta o novo valor para o campo cdfilial
     */
    public void setCdfilial(Integer cdfilial) {
        this.cdfilial = cdfilial;
    }

    /**
     * @return o valor do cdctrlcpfcnpj
     */
    public Integer getCdctrlcpfcnpj() {
        return cdctrlcpfcnpj;
    }

    /**
     * @param cdctrlcpfcnpj seta o novo valor para o campo cdctrlcpfcnpj
     */
    public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
        this.cdctrlcpfcnpj = cdctrlcpfcnpj;
    }
    
    /**
     * @return o valor do svaloradsemb
     */
    public String getSvaloradsemb() {
        return svaloradsemb;
    }

    /**
     * @param svaloradsemb seta o novo valor para o campo svaloradsemb
     */
    public void setSvaloradsemb(String svaloradsemb) {
        this.svaloradsemb = svaloradsemb;
    }

    /**
     * @return o valor do dinicvalddppsta
     */
    public String getDinicvalddppsta() {
        return dinicvalddppsta;
    }

    /**
     * @param dinicvalddppsta seta o novo valor para o campo dinicvalddppsta
     */
    public void setDinicvalddppsta(String dinicvalddppsta) {
        this.dinicvalddppsta = dinicvalddppsta;
    }

    /**
     * @return o valor do dfimvalddppsta
     */
    public String getDfimvalddppsta() {
        return dfimvalddppsta;
    }

    /**
     * @param dfimvalddppsta seta o novo valor para o campo dfimvalddppsta
     */
    public void setDfimvalddppsta(String dfimvalddppsta) {
        this.dfimvalddppsta = dfimvalddppsta;
    }

    /**
     * @return o valor do dlimenviorsumo
     */
    public String getDlimenviorsumo() {
        return dlimenviorsumo;
    }

    /**
     * @param dlimenviorsumo seta o novo valor para o campo dlimenviorsumo
     */
    public void setDlimenviorsumo(String dlimenviorsumo) {
        this.dlimenviorsumo = dlimenviorsumo;
    }

    /**
     * @return o valor do praca
     */
    public String getPraca() {
        return praca;
    }

    /**
     * @param praca seta o novo valor para o campo praca
     */
    public void setPraca(String praca) {
        this.praca = praca;
    }

    public String getFormataDespesaPorConta() {
        
        if(cidtfdrespdesp.equals(3)) {
            return "Cliente";
        }else if(cidtfdrespdesp.equals(4)) {
            return "Beneficiário";
        }
        return formataDespesaPorConta;
    }

    public void setFormataDespesaPorConta(String formataDespesaPorConta) {
        this.formataDespesaPorConta = formataDespesaPorConta;
    }

    public String getUltimoFechamento() {
        return ultimoFechamento;
    }

    public void setUltimoFechamento(String ultimoFechamento) {
        this.ultimoFechamento = ultimoFechamento;
    }
    
    public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}

	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
	
	/**
     * @return o valor valorTxJuros
     */
    public String getValorTxJuros() {
        return valorTxJuros;
    }

    /**
     * @param valorTxJuros seta o valor valorTxJuros
     */
    public void setValorTxJuros(String valorTxJuros) {
        this.valorTxJuros = valorTxJuros;
    }

    /**
     * @return o valor do cunicpssoaindica
     */
    public Long getCunicpssoaindica() {
        return cunicpssoaindica;
    }

    /**
     * @param cunicpssoaindica seta o novo valor para o campo cunicpssoaindica
     */
    public void setCunicpssoaindica(Long cunicpssoaindica) {
        this.cunicpssoaindica = cunicpssoaindica;
    }

    /**
     * @return the descjurosbleto
     */
    public String getDescjurosbleto() {
        return descjurosbleto;
    }

    /**
     * @param descjurosbleto the descjurosbleto to set
     */
    public void setDescjurosbleto(String descjurosbleto) {
        this.descjurosbleto = descjurosbleto;
    }

    /**
     * @return the descjurobleto
     */
    public String getDescjurobleto() {
        return descjurobleto;
    }

    /**
     * @param descjurobleto the descjurobleto to set
     */
    public void setDescjurobleto(String descjurobleto) {
        this.descjurobleto = descjurobleto;
    }

    /**
     * @return the comissaodsemblso
     */
    public String getComissaodsemblso() {
        return comissaodsemblso;
    }

    /**
     * @param comissaodsemblso the comissaodsemblso to set
     */
    public void setComissaodsemblso(String comissaodsemblso) {
        this.comissaodsemblso = comissaodsemblso;
    }

    /**
     * @return the vlrcomisdsemb
     */
    public String getVlrcomisdsemb() {
        return vlrcomisdsemb;
    }

    /**
     * @param vlrcomisdsemb the vlrcomisdsemb to set
     */
    public void setVlrcomisdsemb(String vlrcomisdsemb) {
        this.vlrcomisdsemb = vlrcomisdsemb;
    }
    
    /**
     * @return the vtxspreadtot
     */
    public String getVtxspreadtot() {
        return vtxspreadtot;
    }

    /**
     * @param vtxspreadtot the vtxspreadtot to set
     */
    public void setVtxspreadtot(String vtxspreadtot) {
        this.vtxspreadtot = vtxspreadtot;
    }

    /**
     * @return the ctpoprzcmbio
     */
    public Integer getCtpoprzcmbio() {
        return ctpoprzcmbio;
    }

    /**
     * @param ctpoprzcmbio the ctpoprzcmbio to set
     */
    public void setCtpoprzcmbio(Integer ctpoprzcmbio) {
        this.ctpoprzcmbio = ctpoprzcmbio;
    }

    /**
     * @return the descPrazoProex
     */
    public String getDescPrazoProex() {
        this.descPrazoProex = EnumPrazoProex.fromCode(this.ctpoprzcmbio).getDescricao();
        return this.descPrazoProex;
    }

    /**
     * @param descPrazoProex the descPrazoProex to set
     */
    public void setDescPrazoProex(String descPrazoProex) {
        this.descPrazoProex = descPrazoProex;
    }

    /**
     * @return the renderRestricoes
     */
    public Boolean getRenderRestricoes() {
        return renderRestricoes;
    }

    /**
     * @param renderRestricoes the renderRestricoes to set
     */
    public void setRenderRestricoes(Boolean renderRestricoes) {
        this.renderRestricoes = renderRestricoes;
    }
    
    public String getCodJurosMora(){
        switch(getCbasejuromora()){
        case 0:
            return "ao ano";
        case 1:
            return "ao mês";
        case 2:
            return "ao bimestre";
        case 3:
            return "ao trimestre";
        case 6:
            return "ao semestre";
        default:
            return "";
        }
    }

	public String getVagtefincrcmbio() {
		return vagtefincrcmbio;
	}

	public void setVagtefincrcmbio(String vagtefincrcmbio) {
		this.vagtefincrcmbio = vagtefincrcmbio;
	}

	public String getVbcomtoricmbio() {
		return vbcomtoricmbio;
	}

	public void setVbcomtoricmbio(String vbcomtoricmbio) {
		this.vbcomtoricmbio = vbcomtoricmbio;
	}

	public ModeloBoletoVO getModeloBoletoVO() {
		return modeloBoletoVO;
	}

	public void setModeloBoletoVO(ModeloBoletoVO modeloBoletoVO) {
		this.modeloBoletoVO = modeloBoletoVO;
	}
    
    public String getGrupomercadoriaboleto() {
		return grupomercadoriaboleto;
	}

	public void setGrupomercadoriaboleto(String grupomercadoriaboleto) {
		this.grupomercadoriaboleto = grupomercadoriaboleto;
	}
	
	public TradeFinanceVO copy() {
        try {
            return (TradeFinanceVO)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
