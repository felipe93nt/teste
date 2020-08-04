package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;




public class TradeFinNegocListasVO {

    /***************  Atributos comum para as Listas **************/

	private String iredzdpssoacmbio = null;

	private Long cunicpssoacmbio = 0L;
	
	/******** Lista Limites ******/

	private Long cpssoajurid = 0L;

	private String cpssoajuriddesc = null;

	private Integer cprodtservcoper = 0;

	private String descrprodtlimite = null;

	private Integer cindcdeconmmoeda = 0;

	private String descrmoeda = null;

	private String vutlzdlimgerc = null;
	private String valorLimite = null;

	private String vdispnlimgerc = null;
	private String valorDisponivel = null;

	private String dvctolimgerc = null;
	private String dataVencimento = null;

	private Integer pvctolimgerc = 0;

	private String pspreadprodt = null;
	private String txSpread = null;

	private Integer ccatlggarntprinc = 0;

	private String descrgarntprinc = null;
	
	/******** Lista Fluxo Pagto e Fluxo Comissao ******/
	private String dataFuxo = null;

	private String prazoFuxo = null;

	private String valorFuxo = null;
	
	private String periodicidadeFuxo = null;

	private String momentoFuxo = null;

	private String moedaFuxo = null;
	
	/******** Lista Mercadoria ******/

	private Integer cmcadoopercmbio = 0;

	private String rmcadoopercmbio = null;

	private Long cmcadocmbiomcsul = 0L;

	private String ringlsmcadocmbio = null;

	private String cindcdlicenmcado = null;

	private String cmcadorestcmbio = null;

	private Integer ntpositcmbio = 0;

	private String ativoSimNao = null;

	private String rjustfsitcmbio = null;

	private String cusuarincl = null;

	private String hinclreg = null;

	private String cusuarmanut = null;

	private String hmanutreg = null;
	
	/******** Lista Operacao Vinculada ******/
	private String numOperacao = null;

	private String moedaOperacaoVinculada = null;
	
	private String valorOperacaoVinculada = null;
	
	private String produto = null;
	
	/******** Lista Tarifas ******/
	private String codigoTarifa = null;

	private String descrTarifa = null;
	
	private String moedaTarifa = null;
	
	private String valorTarifa = null;
	
	/******** Lista Comissao ******/

    /***************  Modal Selecionar Cliente **************/

	private Integer cdcpfcnpj = 0;

	private Integer cdfilial = 0;

	private Integer cdctrlcpfcnpj = 0;
	
	private String cpfCnpjFormatado = null;
	
	private String bconome = null;

	private Integer cagbcria = null;
	
	private Long cctabcriacli = null;

	private String cdigbcriacli = null;
	
	private String contaDvFormatado = null;

	private Integer nctabcriacmbio = 0;
	
	private EnumSimNaoStr pilotoativo = null;
	

    /***************  Tela Modal Selecionar Unidade Externa **************/
	private String ibanqrcmbio = null;

	private Long cbanqrcmbio = 0L;

	private String cidbanqrswift = null;

	private String cflialbanqrswift = null;

	private Integer cpais = 0;

	private String ipais = null;

	private Long cmunintlcmbio = 0L;

	private String imunintlcmbio = null;

	private Integer ctrocamsgemswift = 0;

	private Integer cindcdbloqueado = 0;

    /***************  Modal Selecionar Beneficiario **************/

	private String ipssoacmbio = null;

	private String iciddeender = null;

	private String ipaiscoplt = null;

    /***************  Modal Selecionar Tomador **************/
	
	/**
	 * CODIGO DO CLIENTE TOMADOR
	 */
	private Long cunicpssoacmbiot = 0L;
    
    /**
     * DESCRICAO CLIENTE TOMADOR
     */
    private String ncunicpssoacmbiot;

//    private String iciddeender = null;
    
    /** CODIGO DO CLUB **/
    private Long cdclub = 0L;
	/**
	 * @return o valor do iredzdpssoacmbio
	 */
	public String getIredzdpssoacmbio() {
		return iredzdpssoacmbio;
	}

	/**
	 * @param iredzdpssoacmbio seta o novo valor para o campo iredzdpssoacmbio
	 */
	public void setIredzdpssoacmbio(String iredzdpssoacmbio) {
		this.iredzdpssoacmbio = iredzdpssoacmbio;
	}

	/**
	 * @return o valor do cunicpssoacmbio
	 */
	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}

	/**
	 * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
	 */
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	/**
	 * @return o valor do cpssoajurid
	 */
	public Long getCpssoajurid() {
		return cpssoajurid;
	}

	/**
	 * @param cpssoajurid seta o novo valor para o campo cpssoajurid
	 */
	public void setCpssoajurid(Long cpssoajurid) {
		this.cpssoajurid = cpssoajurid;
	}

	/**
	 * @return o valor do cpssoajuriddesc
	 */
	public String getCpssoajuriddesc() {
		return cpssoajuriddesc;
	}

	/**
	 * @param cpssoajuriddesc seta o novo valor para o campo cpssoajuriddesc
	 */
	public void setCpssoajuriddesc(String cpssoajuriddesc) {
		this.cpssoajuriddesc = cpssoajuriddesc;
	}

	/**
	 * @return o valor do cprodtservcoper
	 */
	public Integer getCprodtservcoper() {
		return cprodtservcoper;
	}

	/**
	 * @param cprodtservcoper seta o novo valor para o campo cprodtservcoper
	 */
	public void setCprodtservcoper(Integer cprodtservcoper) {
		this.cprodtservcoper = cprodtservcoper;
	}

	/**
	 * @return o valor do descrprodtlimite
	 */
	public String getDescrprodtlimite() {
		return descrprodtlimite;
	}

	/**
	 * @param descrprodtlimite seta o novo valor para o campo descrprodtlimite
	 */
	public void setDescrprodtlimite(String descrprodtlimite) {
		this.descrprodtlimite = descrprodtlimite;
	}

	/**
	 * @return o valor do cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	/**
	 * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	/**
	 * @return o valor do descrmoeda
	 */
	public String getDescrmoeda() {
		return descrmoeda;
	}

	/**
	 * @param descrmoeda seta o novo valor para o campo descrmoeda
	 */
	public void setDescrmoeda(String descrmoeda) {
		this.descrmoeda = descrmoeda;
	}

	/**
	 * @return o valor do vutlzdlimgerc
	 */
	public String getVutlzdlimgerc() {
		return vutlzdlimgerc;
	}

	/**
	 * @param vutlzdlimgerc seta o novo valor para o campo vutlzdlimgerc
	 */
	public void setVutlzdlimgerc(String vutlzdlimgerc) {
		this.vutlzdlimgerc = vutlzdlimgerc;
	}

	/**
	 * @return o valor do vdispnlimgerc
	 */
	public String getVdispnlimgerc() {
		return vdispnlimgerc;
	}

	/**
	 * @param vdispnlimgerc seta o novo valor para o campo vdispnlimgerc
	 */
	public void setVdispnlimgerc(String vdispnlimgerc) {
		this.vdispnlimgerc = vdispnlimgerc;
	}

	/**
	 * @return o valor do dvctolimgerc
	 */
	public String getDvctolimgerc() {
		return dvctolimgerc;
	}

	/**
	 * @param dvctolimgerc seta o novo valor para o campo dvctolimgerc
	 */
	public void setDvctolimgerc(String dvctolimgerc) {
		this.dvctolimgerc = dvctolimgerc;
	}

	/**
	 * @return o valor do pvctolimgerc
	 */
	public Integer getPvctolimgerc() {
		return pvctolimgerc;
	}

	/**
	 * @param pvctolimgerc seta o novo valor para o campo pvctolimgerc
	 */
	public void setPvctolimgerc(Integer pvctolimgerc) {
		this.pvctolimgerc = pvctolimgerc;
	}

	/**
	 * @return o valor do pspreadprodt
	 */
	public String getPspreadprodt() {
		return pspreadprodt;
	}

	/**
	 * @param pspreadprodt seta o novo valor para o campo pspreadprodt
	 */
	public void setPspreadprodt(String pspreadprodt) {
		this.pspreadprodt = pspreadprodt;
	}

	/**
	 * @return o valor do ccatlggarntprinc
	 */
	public Integer getCcatlggarntprinc() {
		return ccatlggarntprinc;
	}

	/**
	 * @param ccatlggarntprinc seta o novo valor para o campo ccatlggarntprinc
	 */
	public void setCcatlggarntprinc(Integer ccatlggarntprinc) {
		this.ccatlggarntprinc = ccatlggarntprinc;
	}

	/**
	 * @return o valor do descrgarntprinc
	 */
	public String getDescrgarntprinc() {
		return descrgarntprinc;
	}

	/**
	 * @param descrgarntprinc seta o novo valor para o campo descrgarntprinc
	 */
	public void setDescrgarntprinc(String descrgarntprinc) {
		this.descrgarntprinc = descrgarntprinc;
	}

	/**
	 * @return o valor do dataFuxo
	 */
	public String getDataFuxo() {
		return dataFuxo;
	}

	/**
	 * @param dataFuxo seta o novo valor para o campo dataFuxo
	 */
	public void setDataFuxo(String dataFuxo) {
		this.dataFuxo = dataFuxo;
	}

	/**
	 * @return o valor do prazoFuxo
	 */
	public String getPrazoFuxo() {
		return prazoFuxo;
	}

	/**
	 * @param prazoFuxo seta o novo valor para o campo prazoFuxo
	 */
	public void setPrazoFuxo(String prazoFuxo) {
		this.prazoFuxo = prazoFuxo;
	}

	/**
	 * @return o valor do valorFuxo
	 */
	public String getValorFuxo() {
		return valorFuxo;
	}

	/**
	 * @param valorFuxo seta o novo valor para o campo valorFuxo
	 */
	public void setValorFuxo(String valorFuxo) {
		this.valorFuxo = valorFuxo;
	}

	/**
	 * @return o valor do periodicidadeFuxo
	 */
	public String getPeriodicidadeFuxo() {
		return periodicidadeFuxo;
	}

	/**
	 * @param periodicidadeFuxo seta o novo valor para o campo periodicidadeFuxo
	 */
	public void setPeriodicidadeFuxo(String periodicidadeFuxo) {
		this.periodicidadeFuxo = periodicidadeFuxo;
	}

	/**
	 * @return o valor do momentoFuxo
	 */
	public String getMomentoFuxo() {
		return momentoFuxo;
	}

	/**
	 * @param momentoFuxo seta o novo valor para o campo momentoFuxo
	 */
	public void setMomentoFuxo(String momentoFuxo) {
		this.momentoFuxo = momentoFuxo;
	}

	/**
	 * @return o valor do moedaFuxo
	 */
	public String getMoedaFuxo() {
		return moedaFuxo;
	}

	/**
	 * @param moedaFuxo seta o novo valor para o campo moedaFuxo
	 */
	public void setMoedaFuxo(String moedaFuxo) {
		this.moedaFuxo = moedaFuxo;
	}

	/**
	 * @return o valor do cmcadoopercmbio
	 */
	public Integer getCmcadoopercmbio() {
		return cmcadoopercmbio;
	}

	/**
	 * @param cmcadoopercmbio seta o novo valor para o campo cmcadoopercmbio
	 */
	public void setCmcadoopercmbio(Integer cmcadoopercmbio) {
		this.cmcadoopercmbio = cmcadoopercmbio;
	}

	/**
	 * @return o valor do rmcadoopercmbio
	 */
	public String getRmcadoopercmbio() {
		return rmcadoopercmbio;
	}

	/**
	 * @param rmcadoopercmbio seta o novo valor para o campo rmcadoopercmbio
	 */
	public void setRmcadoopercmbio(String rmcadoopercmbio) {
		this.rmcadoopercmbio = rmcadoopercmbio;
	}

	/**
	 * @return o valor do cmcadocmbiomcsul
	 */
	public Long getCmcadocmbiomcsul() {
		return cmcadocmbiomcsul;
	}

	/**
	 * @param cmcadocmbiomcsul seta o novo valor para o campo cmcadocmbiomcsul
	 */
	public void setCmcadocmbiomcsul(Long cmcadocmbiomcsul) {
		this.cmcadocmbiomcsul = cmcadocmbiomcsul;
	}

	/**
	 * @return o valor do ringlsmcadocmbio
	 */
	public String getRinglsmcadocmbio() {
		return ringlsmcadocmbio;
	}

	/**
	 * @param ringlsmcadocmbio seta o novo valor para o campo ringlsmcadocmbio
	 */
	public void setRinglsmcadocmbio(String ringlsmcadocmbio) {
		this.ringlsmcadocmbio = ringlsmcadocmbio;
	}

	/**
	 * @return o valor do cindcdlicenmcado
	 */
	public String getCindcdlicenmcado() {
		return cindcdlicenmcado;
	}

	/**
	 * @param cindcdlicenmcado seta o novo valor para o campo cindcdlicenmcado
	 */
	public void setCindcdlicenmcado(String cindcdlicenmcado) {
		this.cindcdlicenmcado = cindcdlicenmcado;
	}

	/**
	 * @return o valor do cmcadorestcmbio
	 */
	public String getCmcadorestcmbio() {
		return cmcadorestcmbio;
	}

	/**
	 * @param cmcadorestcmbio seta o novo valor para o campo cmcadorestcmbio
	 */
	public void setCmcadorestcmbio(String cmcadorestcmbio) {
		this.cmcadorestcmbio = cmcadorestcmbio;
	}

	/**
	 * @return o valor do ntpositcmbio
	 */
	public Integer getNtpositcmbio() {
		return ntpositcmbio;
	}

	/**
	 * @param ntpositcmbio seta o novo valor para o campo ntpositcmbio
	 */
	public void setNtpositcmbio(Integer ntpositcmbio) {
		this.ntpositcmbio = ntpositcmbio;
	}

	/**
	 * @return o valor do ativoSimNao
	 */
	public String getAtivoSimNao() {
		return ativoSimNao;
	}

	/**
	 * @param ativoSimNao seta o novo valor para o campo ativoSimNao
	 */
	public void setAtivoSimNao(String ativoSimNao) {
		this.ativoSimNao = ativoSimNao;
	}

	/**
	 * @return o valor do rjustfsitcmbio
	 */
	public String getRjustfsitcmbio() {
		return rjustfsitcmbio;
	}

	/**
	 * @param rjustfsitcmbio seta o novo valor para o campo rjustfsitcmbio
	 */
	public void setRjustfsitcmbio(String rjustfsitcmbio) {
		this.rjustfsitcmbio = rjustfsitcmbio;
	}

	/**
	 * @return o valor do cusuarincl
	 */
	public String getCusuarincl() {
		return cusuarincl;
	}

	/**
	 * @param cusuarincl seta o novo valor para o campo cusuarincl
	 */
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
	}

	/**
	 * @return o valor do hinclreg
	 */
	public String getHinclreg() {
		return hinclreg;
	}

	/**
	 * @param hinclreg seta o novo valor para o campo hinclreg
	 */
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	/**
	 * @return o valor do cusuarmanut
	 */
	public String getCusuarmanut() {
		return cusuarmanut;
	}

	/**
	 * @param cusuarmanut seta o novo valor para o campo cusuarmanut
	 */
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	/**
	 * @return o valor do hmanutreg
	 */
	public String getHmanutreg() {
		return hmanutreg;
	}

	/**
	 * @param hmanutreg seta o novo valor para o campo hmanutreg
	 */
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	/**
	 * @return o valor do numOperacao
	 */
	public String getNumOperacao() {
		return numOperacao;
	}

	/**
	 * @param numOperacao seta o novo valor para o campo numOperacao
	 */
	public void setNumOperacao(String numOperacao) {
		this.numOperacao = numOperacao;
	}

	/**
	 * @return o valor do moedaOperacaoVinculada
	 */
	public String getMoedaOperacaoVinculada() {
		return moedaOperacaoVinculada;
	}

	/**
	 * @param moedaOperacaoVinculada seta o novo valor para o campo moedaOperacaoVinculada
	 */
	public void setMoedaOperacaoVinculada(String moedaOperacaoVinculada) {
		this.moedaOperacaoVinculada = moedaOperacaoVinculada;
	}

	/**
	 * @return o valor do valorOperacaoVinculada
	 */
	public String getValorOperacaoVinculada() {
		return valorOperacaoVinculada;
	}

	/**
	 * @param valorOperacaoVinculada seta o novo valor para o campo valorOperacaoVinculada
	 */
	public void setValorOperacaoVinculada(String valorOperacaoVinculada) {
		this.valorOperacaoVinculada = valorOperacaoVinculada;
	}

	/**
	 * @return o valor do produto
	 */
	public String getProduto() {
		return produto;
	}

	/**
	 * @param produto seta o novo valor para o campo produto
	 */
	public void setProduto(String produto) {
		this.produto = produto;
	}

	/**
	 * @return o valor do codigoTarifa
	 */
	public String getCodigoTarifa() {
		return codigoTarifa;
	}

	/**
	 * @param codigoTarifa seta o novo valor para o campo codigoTarifa
	 */
	public void setCodigoTarifa(String codigoTarifa) {
		this.codigoTarifa = codigoTarifa;
	}

	/**
	 * @return o valor do descrTarifa
	 */
	public String getDescrTarifa() {
		return descrTarifa;
	}

	/**
	 * @param descrTarifa seta o novo valor para o campo descrTarifa
	 */
	public void setDescrTarifa(String descrTarifa) {
		this.descrTarifa = descrTarifa;
	}

	/**
	 * @return o valor do moedaTarifa
	 */
	public String getMoedaTarifa() {
		return moedaTarifa;
	}

	/**
	 * @param moedaTarifa seta o novo valor para o campo moedaTarifa
	 */
	public void setMoedaTarifa(String moedaTarifa) {
		this.moedaTarifa = moedaTarifa;
	}

	/**
	 * @return o valor do valorTarifa
	 */
	public String getValorTarifa() {
		return valorTarifa;
	}

	/**
	 * @param valorTarifa seta o novo valor para o campo valorTarifa
	 */
	public void setValorTarifa(String valorTarifa) {
		this.valorTarifa = valorTarifa;
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
	 * @return o valor do cpfCnpjFormatado
	 */
	public String getCpfCnpjFormatado() {
		return cpfCnpjFormatado;
	}

	/**
	 * @param cpfCnpjFormatado seta o novo valor para o campo cpfCnpjFormatado
	 */
	public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
		this.cpfCnpjFormatado = cpfCnpjFormatado;
	}

	/**
	 * @return o valor do bconome
	 */
	public String getBconome() {
		return bconome;
	}

	/**
	 * @param bconome seta o novo valor para o campo bconome
	 */
	public void setBconome(String bconome) {
		this.bconome = bconome;
	}

	/**
	 * @return o valor do cagbcria
	 */
	public Integer getCagbcria() {
		return cagbcria;
	}

	/**
	 * @param cagbcria seta o novo valor para o campo cagbcria
	 */
	public void setCagbcria(Integer cagbcria) {
		this.cagbcria = cagbcria;
	}

	/**
	 * @return o valor do cctabcriacli
	 */
	public Long getCctabcriacli() {
		return cctabcriacli;
	}

	/**
	 * @param cctabcriacli seta o novo valor para o campo cctabcriacli
	 */
	public void setCctabcriacli(Long cctabcriacli) {
		this.cctabcriacli = cctabcriacli;
	}

	/**
	 * @return o valor do cdigbcriacli
	 */
	public String getCdigbcriacli() {
		return cdigbcriacli;
	}

	/**
	 * @param cdigbcriacli seta o novo valor para o campo cdigbcriacli
	 */
	public void setCdigbcriacli(String cdigbcriacli) {
		this.cdigbcriacli = cdigbcriacli;
	}

	/**
	 * @return o valor do contaDvFormatado
	 */
	public String getContaDvFormatado() {
		return contaDvFormatado;
	}

	/**
	 * @param contaDvFormatado seta o novo valor para o campo contaDvFormatado
	 */
	public void setContaDvFormatado(String contaDvFormatado) {
		this.contaDvFormatado = contaDvFormatado;
	}

	/**
	 * @return o valor do nctabcriacmbio
	 */
	public Integer getNctabcriacmbio() {
		return nctabcriacmbio;
	}

	/**
	 * @param nctabcriacmbio seta o novo valor para o campo nctabcriacmbio
	 */
	public void setNctabcriacmbio(Integer nctabcriacmbio) {
		this.nctabcriacmbio = nctabcriacmbio;
	}

	/**
	 * @return o valor do ibanqrcmbio
	 */
	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}

	/**
	 * @param ibanqrcmbio seta o novo valor para o campo ibanqrcmbio
	 */
	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	/**
	 * @return o valor do cbanqrcmbio
	 */
	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}

	/**
	 * @param cbanqrcmbio seta o novo valor para o campo cbanqrcmbio
	 */
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	/**
	 * @return o valor do cidbanqrswift
	 */
	public String getCidbanqrswift() {
		return cidbanqrswift;
	}

	/**
	 * @param cidbanqrswift seta o novo valor para o campo cidbanqrswift
	 */
	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	/**
	 * @return o valor do cflialbanqrswift
	 */
	public String getCflialbanqrswift() {
		return cflialbanqrswift;
	}

	/**
	 * @param cflialbanqrswift seta o novo valor para o campo cflialbanqrswift
	 */
	public void setCflialbanqrswift(String cflialbanqrswift) {
		this.cflialbanqrswift = cflialbanqrswift;
	}

	/**
	 * @return o valor do cpais
	 */
	public Integer getCpais() {
		return cpais;
	}

	/**
	 * @param cpais seta o novo valor para o campo cpais
	 */
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	/**
	 * @return o valor do ipais
	 */
	public String getIpais() {
		return ipais;
	}

	/**
	 * @param ipais seta o novo valor para o campo ipais
	 */
	public void setIpais(String ipais) {
		this.ipais = ipais;
	}

	/**
	 * @return o valor do cmunintlcmbio
	 */
	public Long getCmunintlcmbio() {
		return cmunintlcmbio;
	}

	/**
	 * @param cmunintlcmbio seta o novo valor para o campo cmunintlcmbio
	 */
	public void setCmunintlcmbio(Long cmunintlcmbio) {
		this.cmunintlcmbio = cmunintlcmbio;
	}

	/**
	 * @return o valor do imunintlcmbio
	 */
	public String getImunintlcmbio() {
		return imunintlcmbio;
	}

	/**
	 * @param imunintlcmbio seta o novo valor para o campo imunintlcmbio
	 */
	public void setImunintlcmbio(String imunintlcmbio) {
		this.imunintlcmbio = imunintlcmbio;
	}

	/**
	 * @return o valor do ctrocamsgemswift
	 */
	public Integer getCtrocamsgemswift() {
		return ctrocamsgemswift;
	}

	/**
	 * @param ctrocamsgemswift seta o novo valor para o campo ctrocamsgemswift
	 */
	public void setCtrocamsgemswift(Integer ctrocamsgemswift) {
		this.ctrocamsgemswift = ctrocamsgemswift;
	}

	/**
	 * @return o valor do cindcdbloqueado
	 */
	public Integer getCindcdbloqueado() {
		return cindcdbloqueado;
	}

	/**
	 * @param cindcdbloqueado seta o novo valor para o campo cindcdbloqueado
	 */
	public void setCindcdbloqueado(Integer cindcdbloqueado) {
		this.cindcdbloqueado = cindcdbloqueado;
	}

	/**
	 * @return o valor do ipssoacmbio
	 */
	public String getIpssoacmbio() {
		return ipssoacmbio;
	}

	/**
	 * @param ipssoacmbio seta o novo valor para o campo ipssoacmbio
	 */
	public void setIpssoacmbio(String ipssoacmbio) {
		this.ipssoacmbio = ipssoacmbio;
	}

	/**
	 * @return o valor do iciddeender
	 */
	public String getIciddeender() {
		return iciddeender;
	}

	/**
	 * @param iciddeender seta o novo valor para o campo iciddeender
	 */
	public void setIciddeender(String iciddeender) {
		this.iciddeender = iciddeender;
	}

	/**
	 * @return o valor do ipaiscoplt
	 */
	public String getIpaiscoplt() {
		return ipaiscoplt;
	}

	/**
	 * @param ipaiscoplt seta o novo valor para o campo ipaiscoplt
	 */
	public void setIpaiscoplt(String ipaiscoplt) {
		this.ipaiscoplt = ipaiscoplt;
	}

	/**
	 * @return o valor do valorLimite
	 */
	public String getValorLimite() {
		return valorLimite;
	}

	/**
	 * @param valorLimite seta o novo valor para o campo valorLimite
	 */
	public void setValorLimite(String valorLimite) {
		this.valorLimite = valorLimite;
	}

	/**
	 * @return o valor do valorDisponivel
	 */
	public String getValorDisponivel() {
		return valorDisponivel;
	}

	/**
	 * @param valorDisponivel seta o novo valor para o campo valorDisponivel
	 */
	public void setValorDisponivel(String valorDisponivel) {
		this.valorDisponivel = valorDisponivel;
	}

	/**
	 * @return o valor do dataVencimento
	 */
	public String getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento seta o novo valor para o campo dataVencimento
	 */
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return o valor do txSpread
	 */
	public String getTxSpread() {
		return txSpread;
	}

	/**
	 * @param txSpread seta o novo valor para o campo txSpread
	 */
	public void setTxSpread(String txSpread) {
		this.txSpread = txSpread;
	}

	public Long getCunicpssoacmbiot() {
		return cunicpssoacmbiot;
	}

	public void setCunicpssoacmbiot(Long cunicpssoacmbiot) {
		this.cunicpssoacmbiot = cunicpssoacmbiot;
	}

	public String getNcunicpssoacmbiot() {
		return ncunicpssoacmbiot;
	}

	public void setNcunicpssoacmbiot(String ncunicpssoacmbiot) {
		this.ncunicpssoacmbiot = ncunicpssoacmbiot;
	}

    /**
     * @return o valor do cdclub
     */
    public Long getCdclub() {
        return cdclub;
    }

    /**
     * @param cdclub seta o novo valor para o campo cdclub
     */
    public void setCdclub(Long cdclub) {
        this.cdclub = cdclub;
    }

    /**
     * @param pilotoativo seta o novo valor para o campo pilotoativo
     */
    public void setPilotoativo(EnumSimNaoStr pilotoativo) {
        this.pilotoativo = pilotoativo;
    }

    /**
     * @return o valor do pilotoativo
     */
    public EnumSimNaoStr getPilotoativo() {
        return pilotoativo;
    }
    
}
