package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean;


/**
 * 
  * Nome: BolAgexListVO.java
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
  * Registro  de Manutenção: 18/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class BolAgexListVO {
    
    /* STATUS DO BOLETO */
    private Integer sstatus = 0;
    
    /* TIPO DE PESSOA */
    private String stppessoa = null;
    
	/**
     * NUMERO BASE CPF/CNPJ CLIENTE
	 */
    private Integer scpfcnpj = 0;
    
    /* NUMERO FILIAL CPF/CNPJ */
    private Integer scflialcnpj = 0;
    
    /* NUMERO CONTROLE CPF/CNPJ */
    private Integer scctrlcpfcnpj = 0;
    
    /*CPF CNPJ Completo*/
    private String cpfCnpj;
    
    /* DESCRICAO DO CPF/CNPJ */
    private String scunicclidesc = null;
    
	/**
     * CODIGO UNICO DO CLIENTE
	 */
    private Long scunicclicmbio = 0L;
    
	/**
	 * CODIGO DO PRODUTO
	 */
	private Integer scprodtservc = 0;
    
    /* DESCRICAO DO PRODUTO */
    private String scprodtdesc = null;

	/**
     * NUMERO DO BOLETO CAMBIO 
	 * NUMERO BOLETO (NUMERO COTACAO)
	 */
   
    private Long snbletonegoccmbio = null;  
    private Integer sdanobase = null;
    /* UNIDADE EXTERNA */
    private Long scbanqrcmbio = 0L;
    
    /* NR.OPERACAO */
    private String scopercmbioexter = null;
    
    /* TOMADOR */
    private String stomador = null;
    
    /* OBSERVACAO */
    private String sobservacao = null;
    
	/**
	 * TAXA SPREAD NEGOCIADA
	 */
	private String svtxspreadnegoc = null;
    
	/**
	 * PRAZO DIAS
	 */
	private Integer stdiaopercmbio = 0;
    
	/**
     * INDICADOR ECONOMICO DA MOEDA
	 * CODIGO DA MOEDA
	 */
    private Integer scindcdeconmmoeda = 0;
    
    /* DESCRICAO DA MOEDA */
    private String sisglindcdfonte = null;
    
    /* VALOR NEGOCIACAO DA MOEDA ESTRANGEIRA(VALOR DO BOLETO) */
    private String svnegocmoedaestrg = null;
    
	/**
     * NUMERO SEQUENCIAL CONTRATO LIMITE GERENCIAL
	 * NUMERO DE APROVACAO DE CREDITO
	 */
    private Long snseqcontrlim = 0L;    
    
    /* LIMITE SENSIBILIZADO(SALDO DO BOLETO) */
    /* SALDO LIMITE GERENCIAL */
    private String svsdolimsensi = null;
    
	/**
     * DATA FECHAMENTO DO BOLETO CAMBIO
	 */
    private String sdfchtobletocmbio = null;
    
    /* DATA VENCIMENTO DO BOLETO CAMBIO */
    private String sdfimnegoccmbio = null;
    
    /* VALOR DA ULTIMA BAIXA - npccwn2i */
    private String svultbaixacmbio = null;
    /* VALOR DO ULTIMO ESTORNO - npccwn2i */
    private String svultestrncmbio = null;  
    
    /* CAMPOS DE LIMITE GERENCIAL */
    /* CODIGO DO PRODUTO LIMITE GERENCIAL */
    private Integer scprodtlimitege = 0;
    
    /* DESCRICAO DO PRODUTO LIMITE GERENCIAL */
    private String sdescprodtlimge = null;
    
    /* DESCRICAO DA GARANTIA LIMITE  */
    private String sdescgarantia = null;
    
    /* CODIGO MOEDA LIMITE GERENCIAL */
    private Integer scodmoedage = 0;
    
    /* DESCRICAO MOEDA LIMITE GERENCIAL */
    private String sdescmoedage = null;
    
    /* VALOR LIMITE GERENCIAL */
    private String svalorlimge = null;   
    
    /* VALOR DISPONIVEL LIMITE GERENCIAL */
    private String svalordispge = null;
    
    /* DATA FECHAMENTO LIMITE GERENCIAL */
    private String sdfchtolimitege = null;
    
    /* CODIGO PESSOA JURIDICA CONTRATO NEGOCIO */
    private Long scpssoajuridge = 0L;
    
    /* CODIGO TIPO CONTRATO NEGOCIO */
    private Integer sctpocontrge = 0;
    
    /* NUMERO SEQUENCIAL CONTRATO NEGOCIO */
    private Long snseqcontrge = 0L;    
    
    /* NUMERO SEQUENCIAL CONTRATO NEGOCIO LIMITE GERENCIAL */
    private Long sncontrlimge = 0L;
    /* USUARIO INCLUSAO */
    private String scusuarincl = null;

    
    /*
    VARIÁVEIS PARA CONSULTA LOG           
    */
    
    /*NOME DO CLIENTE*/
    private String snomecliente = null;
    /*CPF/CNPJ CORPO  */ 
    private Integer sccpfcnpj = 0;
    /*CPF/CNPJ FILIAL    */ 
    private Integer scflialcpfcnpj = 0;
    /*UNIDADE EXTERNA  */ 
    private String sdcbanqrcmbio = null;
    /*TOMADOR*/ 
    private String srtomobsbleto = null;
    /*OBSERVACAO*/
    private String srobsbletocmbio = null;
    /*DATA INCLUSAO '17/05/2016'*/  
    private String shinclreg = null;
    /*DATA DE MANUTENCAO '17/05/2016'  */
    private String shmanutreg = null;
    /*USUARIO*/                                    
    private String scusuar = null;
    /*NOME USUARIO*/ 
    private String snomefunc = null;
    /*MANUTENCAO EFETUADA*/
    private String stipomanut = null;
    
    /*DESCRIÇÃO DO STATUS*/
	private String sdescstatus = null;
	
    /* STATUS DO BOLETO - Código e Descrição */
    private String statusCodDesc = "";
    
	/*NOME DO BANQUEIRO NO EXTERIOR*/
	private String sdescbanqueiro = null;
	
	/*NOME DO BANQUEIRO NO EXTERIOR*/
	private String banqrCodNom = "";
    
	/**
	 * CODIGO STATUS BOLETO
	 */
	private Integer scsitbletocmbio = 0;

	/**
	 * DESCRICAO STATUS BOLETO
	 */
	private String sdsitbletocmbio = null;

	/**
	 * CODIGO STATUS APROVACAO BOLETO
	 */ 
	private Integer scsitbletoaprov = 0;

	/**
	 * DATA DA COTACAO
	 */
	private String sdtcotacao = null;

	/**
	 * CODIGO OPERADOR
	 */
	private String scusuarinclt = null;

	/**
	 * NOME DO OPERADOR
	 */
	private String snusuarinclt = null;

	
	/**
	 * NUMERO BOLETO + ANO (NUMERO COTACAO)
	 */
	private Integer nbletocmbioano = null;
	
	/**
	 * NOME DO CLIENTE
	 */
	private String sncunicclicmbio = null;
	
	/**
	 * 	FILIAL CPF CNPJ
	 */
	private Integer scfilial =  null;
	
	/**
	 * CONTROLE CPF/CNPJ
	 */
	private Integer scctrl =  null;
	
	/**
	 * CODIGO DO SEGMENTO
	 */
	private Integer sctposgmtocli = 0;

	/**
	 * DESCRICAO DO TIPO DE SEGMENTO
	 */
	private String sdtposgmtocli = null;

	/**
	 * CODIGO DA UNIDADE DE NEGOCIO
	 */
	private Integer snsequndorgnz = 0;

	/**
	 * NOME DA UNIDADE DE NEGOCIO
	 */
	private String snomeundorgnz = null;

	/**
	 * CODIGO DA AGENCIA COMERCIAL
	 */
	private Integer sagcmrcl = 0;

	/**
	 * DESCRICAO DO PRODUTO
	 */
	private String sdprodtservc = null;

	/**
	 * SIMBOLO DA MOEDA
	 */
	private String ssimbleconmmoeda = null;

	/**
	 * VALOR DA MOEDA ESTRANGEIRA
	 */
	private String svlrmoedaestrang = null;
	
	/**
	 * VALOR EQUIVALENTE AO DOLAR
	 */
	private String svlreqvlntedolar = null;

	/**
	 * INDICADOR NEGOCIACAO CMBIO SWAT
	 */
	private String scindcdnegocswap = null;
	
	/**
	 * PRAZO MEDIA DIAS
	 */
	private Integer sqprzmedcmbio = 0;

	/**
	 * TAXA SPREAD CREDITO APROVADO
	 */
	private String svtxspreadaprov = null;

	/**
	 * CUSTO
	 */
	private String scusto = null;

	/**
	 * TAXA SWAP COMPARTILHADA
	 */
	private String sptxswapcmpdo = null;

	/**
	 * SPREAD EM DOLAR 	
	 */
	private String sspreaddolar = null;

	/**
	 * CODIGO UNIDADE EXTERNA
	 */
	private Long scbcoextcmbio = 0L;

	/**
	 * NOME DA UNIDADE EXTERNA
	 */
	private String sdbcoextcmbio = null;

	/**
	 * DESCRICAO STATUS BOLETO
	 */
	private String sdsitbletocmbio2 = null;

	/**
	 * PRORROGACAO BOLETO (SIM/NAO)
	 */
	private Integer scaditvbletocmbio = 0;

	/**
	 * CODIGO DO PAIS
	 */
	private Integer scpais = 0;

	/**
	 * NOME DO PAIS
	 */
	private String sdpais = null;

	/**
	 * CODIGO DO PAIS DE EMBARQUE
	 */
	private Integer scpaisembrq = 0;

	/**
	 * NOME PAIS DE EMBARQUE
	 */
	private String sdpaisembrq = null;
	
	private String sdivergente;
	
	private String sdtfechamento;
			      
	private Integer sctponegoccmbio;
	
	private String statusAprovacao;
	
	private Long snbletocmbioano;
	
	private Long cpssoa;
	
	private String nmbnefc;
	
	private String cpfCnpjFormatado;

	private Long cunicpssoacmbio = 0L;
	
    /*Quantidade de ocorrências*/
    private Integer qtdeocorr = 0;
	
    private String refBradesco = null;
	
    /**
     * @return o valor do sstatus
     */
    public Integer getSstatus() {
        return sstatus;
    }
    /**
     * @param sstatus seta o novo valor para o campo sstatus
     */
    public void setSstatus(Integer sstatus) {
        this.sstatus = sstatus;
    }
    /**
     * @return o valor do stppessoa
     */
    public String getStppessoa() {
        return stppessoa;
    }
    /**
     * @param stppessoa seta o novo valor para o campo stppessoa
     */
    public void setStppessoa(String stppessoa) {
        this.stppessoa = stppessoa;
    }
    /**
     * @return o valor do scpfcnpj
     */
    public Integer getScpfcnpj() {
        return scpfcnpj;
    }
    /**
     * @param scpfcnpj seta o novo valor para o campo scpfcnpj
     */
    public void setScpfcnpj(Integer scpfcnpj) {
        this.scpfcnpj = scpfcnpj;
    }
    /**
     * @return o valor do scflialcnpj
     */
    public Integer getScflialcnpj() {
        return scflialcnpj;
    }
    /**
     * @param scflialcnpj seta o novo valor para o campo scflialcnpj
     */
    public void setScflialcnpj(Integer scflialcnpj) {
        this.scflialcnpj = scflialcnpj;
    }
    /**
     * @return o valor do scctrlcpfcnpj
     */
    public Integer getScctrlcpfcnpj() {
        return scctrlcpfcnpj;
    }
    /**
     * @param scctrlcpfcnpj seta o novo valor para o campo scctrlcpfcnpj
     */
    public void setScctrlcpfcnpj(Integer scctrlcpfcnpj) {
        this.scctrlcpfcnpj = scctrlcpfcnpj;
    }
    /**
     * @return o valor do scunicclidesc
     */
    public String getScunicclidesc() {
        return scunicclidesc;
    }
    /**
     * @param scunicclidesc seta o novo valor para o campo scunicclidesc
     */
    public void setScunicclidesc(String scunicclidesc) {
        this.scunicclidesc = scunicclidesc;
    }
    /**
     * @return o valor do scunicclicmbio
     */
    public Long getScunicclicmbio() {
        return scunicclicmbio;
    }
    /**
     * @param scunicclicmbio seta o novo valor para o campo scunicclicmbio
     */
    public void setScunicclicmbio(Long scunicclicmbio) {
        this.scunicclicmbio = scunicclicmbio;
    }
    /**
     * @return o valor do scprodtservc
     */
    public Integer getScprodtservc() {
        return scprodtservc;
    }
    /**
     * @param scprodtservc seta o novo valor para o campo scprodtservc
     */
    public void setScprodtservc(Integer scprodtservc) {
        this.scprodtservc = scprodtservc;
    }
    /**
     * @return o valor do scprodtdesc
     */
    public String getScprodtdesc() {
        return scprodtdesc;
    }
    /**
     * @param scprodtdesc seta o novo valor para o campo scprodtdesc
     */
    public void setScprodtdesc(String scprodtdesc) {
        this.scprodtdesc = scprodtdesc;
    }
 
    /**
     * @return o valor do scbanqrcmbio
     */
    public Long getScbanqrcmbio() {
        return scbanqrcmbio;
    }
    /**
     * @param scbanqrcmbio seta o novo valor para o campo scbanqrcmbio
     */
    public void setScbanqrcmbio(Long scbanqrcmbio) {
        this.scbanqrcmbio = scbanqrcmbio;
    }
    /**
     * @return o valor do scopercmbioexter
     */
    public String getScopercmbioexter() {
        return scopercmbioexter;
    }
    /**
     * @param scopercmbioexter seta o novo valor para o campo scopercmbioexter
     */
    public void setScopercmbioexter(String scopercmbioexter) {
        this.scopercmbioexter = scopercmbioexter;
    }
    /**
     * @return o valor do stomador
     */
    public String getStomador() {
        return stomador;
    }
    /**
     * @param stomador seta o novo valor para o campo stomador
     */
    public void setStomador(String stomador) {
        this.stomador = stomador;
    }
    /**
     * @return o valor do sobservacao
     */
    public String getSobservacao() {
        return sobservacao;
    }
    /**
     * @param sobservacao seta o novo valor para o campo sobservacao
     */
    public void setSobservacao(String sobservacao) {
        this.sobservacao = sobservacao;
    }
    /**
     * @return o valor do svtxspreadnegoc
     */
    public String getSvtxspreadnegoc() {
        return svtxspreadnegoc;
    }
    /**
     * @param svtxspreadnegoc seta o novo valor para o campo svtxspreadnegoc
     */
    public void setSvtxspreadnegoc(String svtxspreadnegoc) {
        this.svtxspreadnegoc = svtxspreadnegoc;
    }
    /**
     * @return o valor do stdiaopercmbio
     */
    public Integer getStdiaopercmbio() {
        return stdiaopercmbio;
    }
    /**
     * @param stdiaopercmbio seta o novo valor para o campo stdiaopercmbio
     */
    public void setStdiaopercmbio(Integer stdiaopercmbio) {
        this.stdiaopercmbio = stdiaopercmbio;
    }
    /**
     * @return o valor do scindcdeconmmoeda
     */
    public Integer getScindcdeconmmoeda() {
        return scindcdeconmmoeda;
    }
    /**
     * @param scindcdeconmmoeda seta o novo valor para o campo scindcdeconmmoeda
     */
    public void setScindcdeconmmoeda(Integer scindcdeconmmoeda) {
        this.scindcdeconmmoeda = scindcdeconmmoeda;
    }
    /**
     * @return o valor do sisglindcdfonte
     */
    public String getSisglindcdfonte() {
        return sisglindcdfonte;
    }
    /**
     * @param sisglindcdfonte seta o novo valor para o campo sisglindcdfonte
     */
    public void setSisglindcdfonte(String sisglindcdfonte) {
        this.sisglindcdfonte = sisglindcdfonte;
    }
    /**
     * @return o valor do svnegocmoedaestrg
     */
    public String getSvnegocmoedaestrg() {
        return svnegocmoedaestrg;
    }
    /**
     * @param svnegocmoedaestrg seta o novo valor para o campo svnegocmoedaestrg
     */
    public void setSvnegocmoedaestrg(String svnegocmoedaestrg) {
        this.svnegocmoedaestrg = svnegocmoedaestrg;
    }
    /**
     * @return o valor do snseqcontrlim
     */
    public Long getSnseqcontrlim() {
        return snseqcontrlim;
    }
    /**
     * @param snseqcontrlim seta o novo valor para o campo snseqcontrlim
     */
    public void setSnseqcontrlim(Long snseqcontrlim) {
        this.snseqcontrlim = snseqcontrlim;
    }
    /**
     * @return o valor do svsdolimsensi
     */
    public String getSvsdolimsensi() {
        return svsdolimsensi;
    }
    /**
     * @param svsdolimsensi seta o novo valor para o campo svsdolimsensi
     */
    public void setSvsdolimsensi(String svsdolimsensi) {
        this.svsdolimsensi = svsdolimsensi;
    }
    /**
     * @return o valor do sdfchtobletocmbio
     */
    public String getSdfchtobletocmbio() {
        return sdfchtobletocmbio;
    }
    /**
     * @param sdfchtobletocmbio seta o novo valor para o campo sdfchtobletocmbio
     */
    public void setSdfchtobletocmbio(String sdfchtobletocmbio) {
        this.sdfchtobletocmbio = sdfchtobletocmbio;
    }
    /**
     * @return o valor do sdfimnegoccmbio
     */
    public String getSdfimnegoccmbio() {
        return sdfimnegoccmbio;
    }
    /**
     * @param sdfimnegoccmbio seta o novo valor para o campo sdfimnegoccmbio
     */
    public void setSdfimnegoccmbio(String sdfimnegoccmbio) {
        this.sdfimnegoccmbio = sdfimnegoccmbio;
    }
    /**
     * @return o valor do svultbaixacmbio
     */
    public String getSvultbaixacmbio() {
        return svultbaixacmbio;
    }
    /**
     * @param svultbaixacmbio seta o novo valor para o campo svultbaixacmbio
     */
    public void setSvultbaixacmbio(String svultbaixacmbio) {
        this.svultbaixacmbio = svultbaixacmbio;
    }
    /**
     * @return o valor do svultestrncmbio
     */
    public String getSvultestrncmbio() {
        return svultestrncmbio;
    }
    /**
     * @param svultestrncmbio seta o novo valor para o campo svultestrncmbio
     */
    public void setSvultestrncmbio(String svultestrncmbio) {
        this.svultestrncmbio = svultestrncmbio;
    }
    /**
     * @return o valor do scprodtlimitege
     */
    public Integer getScprodtlimitege() {
        return scprodtlimitege;
    }
    /**
     * @param scprodtlimitege seta o novo valor para o campo scprodtlimitege
     */
    public void setScprodtlimitege(Integer scprodtlimitege) {
        this.scprodtlimitege = scprodtlimitege;
    }
    /**
     * @return o valor do sdescprodtlimge
     */
    public String getSdescprodtlimge() {
        return sdescprodtlimge;
    }
    /**
     * @param sdescprodtlimge seta o novo valor para o campo sdescprodtlimge
     */
    public void setSdescprodtlimge(String sdescprodtlimge) {
        this.sdescprodtlimge = sdescprodtlimge;
    }
    /**
     * @return o valor do scodmoedage
     */
    public Integer getScodmoedage() {
        return scodmoedage;
    }
    /**
     * @param scodmoedage seta o novo valor para o campo scodmoedage
     */
    public void setScodmoedage(Integer scodmoedage) {
        this.scodmoedage = scodmoedage;
    }
    /**
     * @return o valor do sdescmoedage
     */
    public String getSdescmoedage() {
        return sdescmoedage;
    }
    /**
     * @param sdescmoedage seta o novo valor para o campo sdescmoedage
     */
    public void setSdescmoedage(String sdescmoedage) {
        this.sdescmoedage = sdescmoedage;
    }
    /**
     * @return o valor do svalorlimge
     */
    public String getSvalorlimge() {
        return svalorlimge;
    }
    /**
     * @param svalorlimge seta o novo valor para o campo svalorlimge
     */
    public void setSvalorlimge(String svalorlimge) {
        this.svalorlimge = svalorlimge;
    }
    /**
     * @return o valor do svalordispge
     */
    public String getSvalordispge() {
        return svalordispge;
    }
    /**
     * @param svalordispge seta o novo valor para o campo svalordispge
     */
    public void setSvalordispge(String svalordispge) {
        this.svalordispge = svalordispge;
    }
    /**
     * @return o valor do sdfchtolimitege
     */
    public String getSdfchtolimitege() {
        return sdfchtolimitege;
    }
    /**
     * @param sdfchtolimitege seta o novo valor para o campo sdfchtolimitege
     */
    public void setSdfchtolimitege(String sdfchtolimitege) {
        this.sdfchtolimitege = sdfchtolimitege;
    }
    /**
     * @return o valor do scpssoajuridge
     */
    public Long getScpssoajuridge() {
        return scpssoajuridge;
    }
    /**
     * @param scpssoajuridge seta o novo valor para o campo scpssoajuridge
     */
    public void setScpssoajuridge(Long scpssoajuridge) {
        this.scpssoajuridge = scpssoajuridge;
    }
    /**
     * @return o valor do sctpocontrge
     */
    public Integer getSctpocontrge() {
        return sctpocontrge;
    }
    /**
     * @param sctpocontrge seta o novo valor para o campo sctpocontrge
     */
    public void setSctpocontrge(Integer sctpocontrge) {
        this.sctpocontrge = sctpocontrge;
    }
    /**
     * @return o valor do snseqcontrge
     */
    public Long getSnseqcontrge() {
        return snseqcontrge;
    }
    /**
     * @param snseqcontrge seta o novo valor para o campo snseqcontrge
     */
    public void setSnseqcontrge(Long snseqcontrge) {
        this.snseqcontrge = snseqcontrge;
    }
    /**
     * @return o valor do sncontrlimge
     */
    public Long getSncontrlimge() {
        return sncontrlimge;
    }
    /**
     * @param sncontrlimge seta o novo valor para o campo sncontrlimge
     */
    public void setSncontrlimge(Long sncontrlimge) {
        this.sncontrlimge = sncontrlimge;
    }
    /**
     * @return o valor do scusuarincl
     */
    public String getScusuarincl() {
        return scusuarincl;
    }
    /**
     * @param scusuarincl seta o novo valor para o campo scusuarincl
     */
    public void setScusuarincl(String scusuarincl) {
        this.scusuarincl = scusuarincl;
    }
    /**
     * @return o valor do snomecliente
     */
    public String getSnomecliente() {
        return snomecliente;
    }
    /**
     * @param snomecliente seta o novo valor para o campo snomecliente
     */
    public void setSnomecliente(String snomecliente) {
        this.snomecliente = snomecliente;
    }
    /**
     * @return o valor do sccpfcnpj
     */
    public Integer getSccpfcnpj() {
        return sccpfcnpj;
    }
    /**
     * @param sccpfcnpj seta o novo valor para o campo sccpfcnpj
     */
    public void setSccpfcnpj(Integer sccpfcnpj) {
        this.sccpfcnpj = sccpfcnpj;
    }
    /**
     * @return o valor do scflialcpfcnpj
     */
    public Integer getScflialcpfcnpj() {
        return scflialcpfcnpj;
    }
    /**
     * @param scflialcpfcnpj seta o novo valor para o campo scflialcpfcnpj
     */
    public void setScflialcpfcnpj(Integer scflialcpfcnpj) {
        this.scflialcpfcnpj = scflialcpfcnpj;
    }
    /**
     * @return o valor do sdcbanqrcmbio
     */
    public String getSdcbanqrcmbio() {
        return sdcbanqrcmbio;
    }
    /**
     * @param sdcbanqrcmbio seta o novo valor para o campo sdcbanqrcmbio
     */
    public void setSdcbanqrcmbio(String sdcbanqrcmbio) {
        this.sdcbanqrcmbio = sdcbanqrcmbio;
    }
    /**
     * @return o valor do srtomobsbleto
     */
    public String getSrtomobsbleto() {
        return srtomobsbleto;
    }
    /**
     * @param srtomobsbleto seta o novo valor para o campo srtomobsbleto
     */
    public void setSrtomobsbleto(String srtomobsbleto) {
        this.srtomobsbleto = srtomobsbleto;
    }
    /**
     * @return o valor do srobsbletocmbio
     */
    public String getSrobsbletocmbio() {
        return srobsbletocmbio;
    }
    /**
     * @param srobsbletocmbio seta o novo valor para o campo srobsbletocmbio
     */
    public void setSrobsbletocmbio(String srobsbletocmbio) {
        this.srobsbletocmbio = srobsbletocmbio;
    }
    /**
     * @return o valor do shinclreg
     */
    public String getShinclreg() {
        return shinclreg;
    }
    /**
     * @param shinclreg seta o novo valor para o campo shinclreg
     */
    public void setShinclreg(String shinclreg) {
        this.shinclreg = shinclreg;
    }
    /**
     * @return o valor do shmanutreg
     */
    public String getShmanutreg() {
        return shmanutreg;
    }
    /**
     * @param shmanutreg seta o novo valor para o campo shmanutreg
     */
    public void setShmanutreg(String shmanutreg) {
        this.shmanutreg = shmanutreg;
    }
    /**
     * @return o valor do scusuar
     */
    public String getScusuar() {
        return scusuar;
    }
    /**
     * @param scusuar seta o novo valor para o campo scusuar
     */
    public void setScusuar(String scusuar) {
        this.scusuar = scusuar;
    }
    /**
     * @return o valor do snomefunc
     */
    public String getSnomefunc() {
        return snomefunc;
    }
    /**
     * @param snomefunc seta o novo valor para o campo snomefunc
     */
    public void setSnomefunc(String snomefunc) {
        this.snomefunc = snomefunc;
    }
    /**
     * @return o valor do stipomanut
     */
    public String getStipomanut() {
        return stipomanut;
    }
    /**
     * @param stipomanut seta o novo valor para o campo stipomanut
     */
    public void setStipomanut(String stipomanut) {
        this.stipomanut = stipomanut;
    }
    /**
     * @return o valor do cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    /**
     * @param cpfCnpj seta o novo valor para o campo cpfCnpj
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
	/**
	 * @return the sdescstatus
	 */
	public String getSdescstatus() {
		return sdescstatus;
	}
	/**
	 * @param sdescstatus the sdescstatus to set
	 */
	public void setSdescstatus(String sdescstatus) {
		this.sdescstatus = sdescstatus;
	}
	/**
	 * @return the sdescbanqueiro
	 */
	public String getSdescbanqueiro() {
		return sdescbanqueiro;
	}
	/**
	 * @param sdescbanqueiro the sdescbanqueiro to set
	 */
	public void setSdescbanqueiro(String sdescbanqueiro) {
		this.sdescbanqueiro = sdescbanqueiro;
	}
	/**
	 * @return the statusCodDesc
	 */
	public String getStatusCodDesc() {
		return statusCodDesc;
	}
	/**
	 * @param statusCodDesc the statusCodDesc to set
	 */
	public void setStatusCodDesc(String statusCodDesc) {
		this.statusCodDesc = statusCodDesc;
	}
	/**
	 * @return the banqrCodNom
	 */
	public String getBanqrCodNom() {
		return banqrCodNom;
	}
	/**
	 * @param banqrCodNom the banqrCodNom to set
	 */
	public void setBanqrCodNom(String banqrCodNom) {
		this.banqrCodNom = banqrCodNom;
	}
	/**
	 * @return the scsitbletocmbio
	 */
	public Integer getScsitbletocmbio() {
		return scsitbletocmbio;
	}
	/**
	 * @param scsitbletocmbio the scsitbletocmbio to set
	 */
	public void setScsitbletocmbio(Integer scsitbletocmbio) {
		this.scsitbletocmbio = scsitbletocmbio;
	}
	/**
	 * @return the sdsitbletocmbio
	 */
	public String getSdsitbletocmbio() {
		return sdsitbletocmbio;
	}
	/**
	 * @param sdsitbletocmbio the sdsitbletocmbio to set
	 */
	public void setSdsitbletocmbio(String sdsitbletocmbio) {
		this.sdsitbletocmbio = sdsitbletocmbio;
	}
	/**
	 * @return the scsitbletoaprov
	 */
	public Integer getScsitbletoaprov() {
		return scsitbletoaprov;
	}
	/**
	 * @param scsitbletoaprov the scsitbletoaprov to set
	 */
	public void setScsitbletoaprov(Integer scsitbletoaprov) {
		this.scsitbletoaprov = scsitbletoaprov;
	}
	/**
	 * @return the sdtcotacao
	 */
	public String getSdtcotacao() {
		return sdtcotacao;
	}
	/**
	 * @param sdtcotacao the sdtcotacao to set
	 */
	public void setSdtcotacao(String sdtcotacao) {
		this.sdtcotacao = sdtcotacao;
	}
	/**
	 * @return the scusuarinclt
	 */
	public String getScusuarinclt() {
		return scusuarinclt;
	}
	/**
	 * @param scusuarinclt the scusuarinclt to set
	 */
	public void setScusuarinclt(String scusuarinclt) {
		this.scusuarinclt = scusuarinclt;
	}
	/**
	 * @return the snusuarinclt
	 */
	public String getSnusuarinclt() {
		return snusuarinclt;
	}
	/**
	 * @param snusuarinclt the snusuarinclt to set
	 */
	public void setSnusuarinclt(String snusuarinclt) {
		this.snusuarinclt = snusuarinclt;
	}
	/**
	 * @return the nbletocmbioano
	 */
	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	/**
	 * @param nbletocmbioano the nbletocmbioano to set
	 */
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}
	/**
	 * @return the sncunicclicmbio
	 */
	public String getSncunicclicmbio() {
		return sncunicclicmbio;
	}
	/**
	 * @param sncunicclicmbio the sncunicclicmbio to set
	 */
	public void setSncunicclicmbio(String sncunicclicmbio) {
		this.sncunicclicmbio = sncunicclicmbio;
	}
	/**
	 * @return the scfilial
	 */
	public Integer getScfilial() {
		return scfilial;
	}
	/**
	 * @param scfilial the scfilial to set
	 */
	public void setScfilial(Integer scfilial) {
		this.scfilial = scfilial;
	}
	/**
	 * @return the scctrl
	 */
	public Integer getScctrl() {
		return scctrl;
	}
	/**
	 * @param scctrl the scctrl to set
	 */
	public void setScctrl(Integer scctrl) {
		this.scctrl = scctrl;
	}
	/**
	 * @return the sctposgmtocli
	 */
	public Integer getSctposgmtocli() {
		return sctposgmtocli;
	}
	/**
	 * @param sctposgmtocli the sctposgmtocli to set
	 */
	public void setSctposgmtocli(Integer sctposgmtocli) {
		this.sctposgmtocli = sctposgmtocli;
	}
	/**
	 * @return the sdtposgmtocli
	 */
	public String getSdtposgmtocli() {
		return sdtposgmtocli;
	}
	/**
	 * @param sdtposgmtocli the sdtposgmtocli to set
	 */
	public void setSdtposgmtocli(String sdtposgmtocli) {
		this.sdtposgmtocli = sdtposgmtocli;
	}
	/**
	 * @return the snsequndorgnz
	 */
	public Integer getSnsequndorgnz() {
		return snsequndorgnz;
	}
	/**
	 * @param snsequndorgnz the snsequndorgnz to set
	 */
	public void setSnsequndorgnz(Integer snsequndorgnz) {
		this.snsequndorgnz = snsequndorgnz;
	}
	/**
	 * @return the snomeundorgnz
	 */
	public String getSnomeundorgnz() {
		return snomeundorgnz;
	}
	/**
	 * @param snomeundorgnz the snomeundorgnz to set
	 */
	public void setSnomeundorgnz(String snomeundorgnz) {
		this.snomeundorgnz = snomeundorgnz;
	}
	/**
	 * @return the sagcmrcl
	 */
	public Integer getSagcmrcl() {
		return sagcmrcl;
	}
	/**
	 * @param sagcmrcl the sagcmrcl to set
	 */
	public void setSagcmrcl(Integer sagcmrcl) {
		this.sagcmrcl = sagcmrcl;
	}
	/**
	 * @return the sdprodtservc
	 */
	public String getSdprodtservc() {
		return sdprodtservc;
	}
	/**
	 * @param sdprodtservc the sdprodtservc to set
	 */
	public void setSdprodtservc(String sdprodtservc) {
		this.sdprodtservc = sdprodtservc;
	}
	/**
	 * @return the ssimbleconmmoeda
	 */
	public String getSsimbleconmmoeda() {
		return ssimbleconmmoeda;
	}
	/**
	 * @param ssimbleconmmoeda the ssimbleconmmoeda to set
	 */
	public void setSsimbleconmmoeda(String ssimbleconmmoeda) {
		this.ssimbleconmmoeda = ssimbleconmmoeda;
	}
	/**
	 * @return the svlrmoedaestrang
	 */
	public String getSvlrmoedaestrang() {
		return svlrmoedaestrang;
	}
	/**
	 * @param svlrmoedaestrang the svlrmoedaestrang to set
	 */
	public void setSvlrmoedaestrang(String svlrmoedaestrang) {
		this.svlrmoedaestrang = svlrmoedaestrang;
	}
	/**
	 * @return the svlreqvlntedolar
	 */
	public String getSvlreqvlntedolar() {
		return svlreqvlntedolar;
	}
	/**
	 * @param svlreqvlntedolar the svlreqvlntedolar to set
	 */
	public void setSvlreqvlntedolar(String svlreqvlntedolar) {
		this.svlreqvlntedolar = svlreqvlntedolar;
	}
	/**
	 * @return the scindcdnegocswap
	 */
	public String getScindcdnegocswap() {
		return scindcdnegocswap;
	}
	/**
	 * @param scindcdnegocswap the scindcdnegocswap to set
	 */
	public void setScindcdnegocswap(String scindcdnegocswap) {
		this.scindcdnegocswap = scindcdnegocswap;
	}
	/**
	 * @return the sqprzmedcmbio
	 */
	public Integer getSqprzmedcmbio() {
		return sqprzmedcmbio;
	}
	/**
	 * @param sqprzmedcmbio the sqprzmedcmbio to set
	 */
	public void setSqprzmedcmbio(Integer sqprzmedcmbio) {
		this.sqprzmedcmbio = sqprzmedcmbio;
	}
	/**
	 * @return the svtxspreadaprov
	 */
	public String getSvtxspreadaprov() {
		return svtxspreadaprov;
	}
	/**
	 * @param svtxspreadaprov the svtxspreadaprov to set
	 */
	public void setSvtxspreadaprov(String svtxspreadaprov) {
		this.svtxspreadaprov = svtxspreadaprov;
	}
	/**
	 * @return the scusto
	 */
	public String getScusto() {
		return scusto;
	}
	/**
	 * @param scusto the scusto to set
	 */
	public void setScusto(String scusto) {
		this.scusto = scusto;
	}
	/**
	 * @return the sptxswapcmpdo
	 */
	public String getSptxswapcmpdo() {
		return sptxswapcmpdo;
	}
	/**
	 * @param sptxswapcmpdo the sptxswapcmpdo to set
	 */
	public void setSptxswapcmpdo(String sptxswapcmpdo) {
		this.sptxswapcmpdo = sptxswapcmpdo;
	}
	/**
	 * @return the sspreaddolar
	 */
	public String getSspreaddolar() {
		return sspreaddolar;
	}
	/**
	 * @param sspreaddolar the sspreaddolar to set
	 */
	public void setSspreaddolar(String sspreaddolar) {
		this.sspreaddolar = sspreaddolar;
	}
	/**
	 * @return the scbcoextcmbio
	 */
	public Long getScbcoextcmbio() {
		return scbcoextcmbio;
	}
	/**
	 * @param scbcoextcmbio the scbcoextcmbio to set
	 */
	public void setScbcoextcmbio(Long scbcoextcmbio) {
		this.scbcoextcmbio = scbcoextcmbio;
	}
	/**
	 * @return the sdbcoextcmbio
	 */
	public String getSdbcoextcmbio() {
		return sdbcoextcmbio;
	}
	/**
	 * @param sdbcoextcmbio the sdbcoextcmbio to set
	 */
	public void setSdbcoextcmbio(String sdbcoextcmbio) {
		this.sdbcoextcmbio = sdbcoextcmbio;
	}
	/**
	 * @return the sdsitbletocmbio2
	 */
	public String getSdsitbletocmbio2() {
		return sdsitbletocmbio2;
	}
	/**
	 * @param sdsitbletocmbio2 the sdsitbletocmbio2 to set
	 */
	public void setSdsitbletocmbio2(String sdsitbletocmbio2) {
		this.sdsitbletocmbio2 = sdsitbletocmbio2;
	}
	/**
	 * @return the scaditvbletocmbio
	 */
	public Integer getScaditvbletocmbio() {
		return scaditvbletocmbio;
	}
	/**
	 * @param scaditvbletocmbio the scaditvbletocmbio to set
	 */
	public void setScaditvbletocmbio(Integer scaditvbletocmbio) {
		this.scaditvbletocmbio = scaditvbletocmbio;
	}
	/**
	 * @return the scpais
	 */
	public Integer getScpais() {
		return scpais;
	}
	/**
	 * @param scpais the scpais to set
	 */
	public void setScpais(Integer scpais) {
		this.scpais = scpais;
	}
	/**
	 * @return the sdpais
	 */
	public String getSdpais() {
		return sdpais;
	}
	/**
	 * @param sdpais the sdpais to set
	 */
	public void setSdpais(String sdpais) {
		this.sdpais = sdpais;
	}
	/**
	 * @return the scpaisembrq
	 */
	public Integer getScpaisembrq() {
		return scpaisembrq;
	}
	/**
	 * @param scpaisembrq the scpaisembrq to set
	 */
	public void setScpaisembrq(Integer scpaisembrq) {
		this.scpaisembrq = scpaisembrq;
	}
	/**
	 * @return the sdpaisembrq
	 */
	public String getSdpaisembrq() {
		return sdpaisembrq;
	}
	/**
	 * @param sdpaisembrq the sdpaisembrq to set
	 */
	public void setSdpaisembrq(String sdpaisembrq) {
		this.sdpaisembrq = sdpaisembrq;
	}
	/**
	 * @return the sdivergente
	 */
	public String getSdivergente() {
		return sdivergente;
	}
	/**
	 * @param sdivergente the sdivergente to set
	 */
	public void setSdivergente(String sdivergente) {
		this.sdivergente = sdivergente;
	}
	/**
	 * @return the sdtfechamento
	 */
	public String getSdtfechamento() {
		return sdtfechamento;
	}
	/**
	 * @param sdtfechamento the sdtfechamento to set
	 */
	public void setSdtfechamento(String sdtfechamento) {
		this.sdtfechamento = sdtfechamento;
	}
	/**
	 * @return the sctponegoccmbio
	 */
	public Integer getSctponegoccmbio() {
		return sctponegoccmbio;
	}
	/**
	 * @param sctponegoccmbio the sctponegoccmbio to set
	 */
	public void setSctponegoccmbio(Integer sctponegoccmbio) {
		this.sctponegoccmbio = sctponegoccmbio;
	}
	/**
	 * @return the statusAprovacao
	 */
	public String getStatusAprovacao() {
		return statusAprovacao;
	}
	/**
	 * @param statusAprovacao the statusAprovacao to set
	 */
	public void setStatusAprovacao(String statusAprovacao) {
		this.statusAprovacao = statusAprovacao;
	}
	/**
	 * @return the snbletocmbioano
	 */
	public Long getSnbletocmbioano() {
		return snbletocmbioano;
	}
	/**
	 * @param snbletocmbioano the snbletocmbioano to set
	 */
	public void setSnbletocmbioano(Long snbletocmbioano) {
		this.snbletocmbioano = snbletocmbioano;
	}
	/**
	 * @return the cpssoa
	 */
	public Long getCpssoa() {
		return cpssoa;
	}
	/**
	 * @param cpssoa the cpssoa to set
	 */
	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
	}
	/**
	 * @return the nmbnefc
	 */
	public String getNmbnefc() {
		return nmbnefc;
	}
	/**
	 * @param nmbnefc the nmbnefc to set
	 */
	public void setNmbnefc(String nmbnefc) {
		this.nmbnefc = nmbnefc;
	}
	/**
	 * @return the cpfCnpjFormatado
	 */
	public String getCpfCnpjFormatado() {
		return cpfCnpjFormatado;
	}
	/**
	 * @param cpfCnpjFormatado the cpfCnpjFormatado to set
	 */
	public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
		this.cpfCnpjFormatado = cpfCnpjFormatado;
	}
	/**
	 * @return the cunicpssoacmbio
	 */
	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	/**
	 * @param cunicpssoacmbio the cunicpssoacmbio to set
	 */
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}
	/**
	 * @return the qtdeocorr
	 */
	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	/**
	 * @param qtdeocorr the qtdeocorr to set
	 */
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}
	/**
	 * @return the sdescgarantia
	 */
	public String getSdescgarantia() {
		return sdescgarantia;
	}
	/**
	 * @param sdescgarantia the sdescgarantia to set
	 */
	public void setSdescgarantia(String sdescgarantia) {
		this.sdescgarantia = sdescgarantia;
	}

	/**
	 * @return the snbletonegoccmbio
	 */
	public Long getSnbletonegoccmbio() {
		return snbletonegoccmbio;
	}
	/**
	 * @param snbletonegoccmbio the snbletonegoccmbio to set
	 */
	public void setSnbletonegoccmbio(Long snbletonegoccmbio) {
		this.snbletonegoccmbio = snbletonegoccmbio;
	}
	/**
	 * @return the sdanobase
	 */
	public Integer getSdanobase() {
		return sdanobase;
	}
	/**
	 * @param sdanobase the sdanobase to set
	 */
	public void setSdanobase(Integer sdanobase) {
		this.sdanobase = sdanobase;
	}
	/**
     * @return the refBradesco
     */
    public String getRefBradesco() {
        return refBradesco;
    }
    /**
     * @param refBradesco the refBradesco to set
     */
    public void setRefBradesco(String refBradesco) {
        this.refBradesco = refBradesco;
    }
    
    
}
