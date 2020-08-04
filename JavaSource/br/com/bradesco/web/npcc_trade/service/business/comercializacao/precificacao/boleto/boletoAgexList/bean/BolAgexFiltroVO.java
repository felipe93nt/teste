package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean;

import java.util.Date;

import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

/**
 * 
  * Nome: BolAgexFiltroVO.java
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
public class BolAgexFiltroVO {

    /*
     * INCLUSAO A EFETIVAR BAIXA A EFETIVAR ESTORNO A EFETIVAR
     */
    private Integer estatus = 0;
    /* CLIENTE */
    private Long ecunicclicmbio = 0L;
    /* PRODUTO */
    private Integer ecprodtservc = 0;
    /* NUMERO DO BOLETO */
    private Integer enbletonegoccmbioano = null;
    private Integer edanobase = null;
    /* PERIODO INICIAL DE PESQUISA */
    private String edataini = null;
    /* PERIODO FINAL DE PESQUISA */
    private String edatafim = null;
    /* PERIODO INICIAL DE PESQUISA */
    /* PERIODO FINAL DE PESQUISA */
    private CalendarioPeriodo dataInicioFim = new CalendarioPeriodo();
    
    private Integer ccatlggarntprinc = null;
    
    /* CLIENTE */
    private CnpjDataType cnpj = new CnpjDataType();
    private CpfDataType cpf = new CpfDataType();
    private String nomeCliente = null;

    /*TIPO DE INFORMACAO - 0-TUDO / 1-ESTORNO / 2-BAIXA*/
	private Integer flagBaixEstrn = 0;
    
    
	/**
	 * PERIODO DA COTACAO
	 */
	private CalendarPeriodDataType periodoCotacao = null;
	
	/**
	 * PERIDO DE FECHAMETNO 
	 */
	private CalendarPeriodDataType periodoFech = null;
	
	/**
	 * CODIGO UNICO CLIENTE
	 */
	private Long cunicclicmbio = 0L;
	
	/**
	 * NOME DO CLIENTE
	 */
	private String nmcliente = null;
		
	/**
	 * OPERADOR
	 */
	private String nmopr = null;	
	
	/**
	 * CODIGO TIPO DE SEGMENTO
	 */
	private Integer ctposgmtocli = 0;

	/**
	 * CODIGO STATUS BOLETO
	 */
	private Integer csitbletocmbio = 0;

	/**
	 * CODIGO OPERADOR 
	 */
	private String cusuarinclt = null;

	/**
	 * CODIGO DA MOEDA
	 */
	private Integer cindcdeconmmoeda = 0;

	/**
	 * CODIGO DO PRODUTO
	 */
	private Integer cprodtservc = 0;

	/**
	 * CODIGO UNIDADE NEGOCIO
	 */
	private Integer nsequndorgnz = 0;

	/**
	 * CODIGO UNIDADE EXTERNA
	 */
	private Long cbcoextcmbio = null;

	/**
	 * INDICADOR SWAP 1 - SIM / 2 - NAO
	 */
	private String cindcdnegocswap = null;

	/**
	 * 1 - INDICATIVA/ 2 - FIRME
	 */
	private Integer ctponegoccmbio = 0;

	/**
	 * NUMERO DA COTACAO (BOLETO)
	 */
	private Integer nbletocmbioano;

	/**
	 * NUMERO DA COTACAO (BOLETO)
	 */
	private Integer nbletocmbio;
	
	
	/**
	 * PRAZO EM DIAS DE
	 */
	private Integer tdiadecmbio = 0;

	/**
	 * PRAZO EM DIAS ATE
	 */
	private Integer tdiaatecmbio = 0;

	/**
	 * PRAZO MEDIO EM DIAS DE
	 */
	private Integer qprzmedde = 0;

	/**
	 * PRAZO MEDIO EM DIAS
	 */
	private Integer qprzmedate = 0;

	/**
	 * VALOR ME ATE
	 */
	private String valormede;

	/**
	 * VALOR ME ATE
	 */
	private String valormeate;

	/**
	 * CODIGO PAíS COM RESTRICAO
	 */
	private Integer cpaisrest = 0;

	/**
	 * CODIGO DA FUNCIONALIDADE
	 */
	private Integer funcao;
	
	/**
	 * ANO BASE DA COTACAO
	 */
	private Integer danobase;
	
	
	/**
	 * NUMERO DA OPERACAO NO EXTERIOR
	 */
	private String numoperexterior;
	
	/**
	 * VALOR ME ATE
	 */
	private String valorboleto;

	/**
	 * OBSERVACOES
	 */
	private String observacao;

	private String tomador;
    
	/**
	 * CODIGO UNIDADE EXTERNA
	 */
	private UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();

	/**
	 * TAXA SPREAD NEGOCIADA
	 */
	private String svtxspreadnegoc = null;
	
	/** PRAZO OPERACAO BOLETO ***/
	private Integer tdiaprazo = 0;

	/**
	 * Data de fechamento da operação
	 */
	private Date fechamento = null;
	
	/**
	 * Data de vencimento da operação
	 */
	private Date vencimento = null;
	
	/**
	 * Codigo Identificador Pessoa
	 */
	private Long cunicpssoacmbio = 0L;

	/**
	 * CODIGO DA MODALIDADE
	 */
	private Integer cmodldprodtcmbio;
	
    // Informações de LIMITE
    private Long ncontrlim = null;
    private String vdispnlimgerc = null;
	
	
	
    /**
     * Construtor
     * 
     * @param
     */
    public BolAgexFiltroVO() {
        super();
    }

    /**
     * @return o valor do estatus
     */
    public Integer getEstatus() {
        return estatus;
    }

    /**
     * @param estatus seta o novo valor para o campo estatus
     */
    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    /**
     * @return o valor do ecunicclicmbio
     */
    public Long getEcunicclicmbio() {
        return ecunicclicmbio;
    }

    /**
     * @param ecunicclicmbio seta o novo valor para o campo ecunicclicmbio
     */
    public void setEcunicclicmbio(Long ecunicclicmbio) {
        this.ecunicclicmbio = ecunicclicmbio;
    }

    /**
     * @return o valor do ecprodtservc
     */
    public Integer getEcprodtservc() {
        return ecprodtservc;
    }

    /**
     * @param ecprodtservc seta o novo valor para o campo ecprodtservc
     */
    public void setEcprodtservc(Integer ecprodtservc) {
        this.ecprodtservc = ecprodtservc;
    }

    /**
     * @return o valor do edataini
     */
    public String getEdataini() {
        return edataini;
    }

    /**
     * @param edataini seta o novo valor para o campo edataini
     */
    public void setEdataini(String edataini) {
        this.edataini = edataini;
    }

    /**
     * @return o valor do edatafim
     */
    public String getEdatafim() {
        return edatafim;
    }

    /**
     * @param edatafim seta o novo valor para o campo edatafim
     */
    public void setEdatafim(String edatafim) {
        this.edatafim = edatafim;
    }

    /**
     * @return o valor do dataInicioFim
     */
    public CalendarioPeriodo getDataInicioFim() {
        return dataInicioFim;
    }

    /**
     * @param dataInicioFim seta o novo valor para o campo dataInicioFim
     */
    public void setDataInicioFim(CalendarioPeriodo dataInicioFim) {
        this.dataInicioFim = dataInicioFim;
    }

    /**
     * @return o valor do cnpj
     */
    public CnpjDataType getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj seta o novo valor para o campo cnpj
     */
    public void setCnpj(CnpjDataType cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return o valor do cpf
     */
    public CpfDataType getCpf() {
        return cpf;
    }

    /**
     * @param cpf seta o novo valor para o campo cpf
     */
    public void setCpf(CpfDataType cpf) {
        this.cpf = cpf;
    }

    /**
     * @return o valor do nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente seta o novo valor para o campo nomeCliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

	/**
	 * @return the flagBaixEstrn
	 */
	public Integer getFlagBaixEstrn() {
		return flagBaixEstrn;
	}

	/**
	 * @param flagBaixEstrn the flagBaixEstrn to set
	 */
	public void setFlagBaixEstrn(Integer flagBaixEstrn) {
		this.flagBaixEstrn = flagBaixEstrn;
	}

	/**
	 * @return the periodoCotacao
	 */
	public CalendarPeriodDataType getPeriodoCotacao() {
		return periodoCotacao;
	}

	/**
	 * @param periodoCotacao the periodoCotacao to set
	 */
	public void setPeriodoCotacao(CalendarPeriodDataType periodoCotacao) {
		this.periodoCotacao = periodoCotacao;
	}

	/**
	 * @return the periodoFech
	 */
	public CalendarPeriodDataType getPeriodoFech() {
		return periodoFech;
	}

	/**
	 * @param periodoFech the periodoFech to set
	 */
	public void setPeriodoFech(CalendarPeriodDataType periodoFech) {
		this.periodoFech = periodoFech;
	}

	/**
	 * @return the cunicclicmbio
	 */
	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}

	/**
	 * @param cunicclicmbio the cunicclicmbio to set
	 */
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	/**
	 * @return the nmcliente
	 */
	public String getNmcliente() {
		return nmcliente;
	}

	/**
	 * @param nmcliente the nmcliente to set
	 */
	public void setNmcliente(String nmcliente) {
		this.nmcliente = nmcliente;
	}

	/**
	 * @return the nmopr
	 */
	public String getNmopr() {
		return nmopr;
	}

	/**
	 * @param nmopr the nmopr to set
	 */
	public void setNmopr(String nmopr) {
		this.nmopr = nmopr;
	}

	/**
	 * @return the ctposgmtocli
	 */
	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}

	/**
	 * @param ctposgmtocli the ctposgmtocli to set
	 */
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	/**
	 * @return the csitbletocmbio
	 */
	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}

	/**
	 * @param csitbletocmbio the csitbletocmbio to set
	 */
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	/**
	 * @return the cusuarinclt
	 */
	public String getCusuarinclt() {
		return cusuarinclt;
	}

	/**
	 * @param cusuarinclt the cusuarinclt to set
	 */
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}

	/**
	 * @return the cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	/**
	 * @param cindcdeconmmoeda the cindcdeconmmoeda to set
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	/**
	 * @return the cprodtservc
	 */
	public Integer getCprodtservc() {
		return cprodtservc;
	}

	/**
	 * @param cprodtservc the cprodtservc to set
	 */
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	/**
	 * @return the nsequndorgnz
	 */
	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}

	/**
	 * @param nsequndorgnz the nsequndorgnz to set
	 */
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	/**
	 * @return the cbcoextcmbio
	 */
	public Long getCbcoextcmbio() {
		return cbcoextcmbio;
	}

	/**
	 * @param cbcoextcmbio the cbcoextcmbio to set
	 */
	public void setCbcoextcmbio(Long cbcoextcmbio) {
		this.cbcoextcmbio = cbcoextcmbio;
	}

	/**
	 * @return the cindcdnegocswap
	 */
	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}

	/**
	 * @param cindcdnegocswap the cindcdnegocswap to set
	 */
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	/**
	 * @return the ctponegoccmbio
	 */
	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}

	/**
	 * @param ctponegoccmbio the ctponegoccmbio to set
	 */
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
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
	 * @return the nbletocmbio
	 */
	public Integer getNbletocmbio() {
		return nbletocmbio;
	}

	/**
	 * @param nbletocmbio the nbletocmbio to set
	 */
	public void setNbletocmbio(Integer nbletocmbio) {
		this.nbletocmbio = nbletocmbio;
	}

	/**
	 * @return the tdiadecmbio
	 */
	public Integer getTdiadecmbio() {
		return tdiadecmbio;
	}

	/**
	 * @param tdiadecmbio the tdiadecmbio to set
	 */
	public void setTdiadecmbio(Integer tdiadecmbio) {
		this.tdiadecmbio = tdiadecmbio;
	}

	/**
	 * @return the tdiaatecmbio
	 */
	public Integer getTdiaatecmbio() {
		return tdiaatecmbio;
	}

	/**
	 * @param tdiaatecmbio the tdiaatecmbio to set
	 */
	public void setTdiaatecmbio(Integer tdiaatecmbio) {
		this.tdiaatecmbio = tdiaatecmbio;
	}

	/**
	 * @return the qprzmedde
	 */
	public Integer getQprzmedde() {
		return qprzmedde;
	}

	/**
	 * @param qprzmedde the qprzmedde to set
	 */
	public void setQprzmedde(Integer qprzmedde) {
		this.qprzmedde = qprzmedde;
	}

	/**
	 * @return the qprzmedate
	 */
	public Integer getQprzmedate() {
		return qprzmedate;
	}

	/**
	 * @param qprzmedate the qprzmedate to set
	 */
	public void setQprzmedate(Integer qprzmedate) {
		this.qprzmedate = qprzmedate;
	}

	/**
	 * @return the valormede
	 */
	public String getValormede() {
		return valormede;
	}

	/**
	 * @param valormede the valormede to set
	 */
	public void setValormede(String valormede) {
		this.valormede = valormede;
	}

	/**
	 * @return the valormeate
	 */
	public String getValormeate() {
		return valormeate;
	}

	/**
	 * @param valormeate the valormeate to set
	 */
	public void setValormeate(String valormeate) {
		this.valormeate = valormeate;
	}

	/**
	 * @return the cpaisrest
	 */
	public Integer getCpaisrest() {
		return cpaisrest;
	}

	/**
	 * @param cpaisrest the cpaisrest to set
	 */
	public void setCpaisrest(Integer cpaisrest) {
		this.cpaisrest = cpaisrest;
	}

	/**
	 * @return the funcao
	 */
	public Integer getFuncao() {
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

	/**
	 * @return the danobase
	 */
	public Integer getDanobase() {
		return danobase;
	}

	/**
	 * @param danobase the danobase to set
	 */
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}

	/**
	 * @return the numoperexterior
	 */
	public String getNumoperexterior() {
		return numoperexterior;
	}

	/**
	 * @param numoperexterior the numoperexterior to set
	 */
	public void setNumoperexterior(String numoperexterior) {
		this.numoperexterior = numoperexterior;
	}

	/**
	 * @return the valorboleto
	 */
	public String getValorboleto() {
		return valorboleto;
	}

	/**
	 * @param valorboleto the valorboleto to set
	 */
	public void setValorboleto(String valorboleto) {
		this.valorboleto = valorboleto;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the tomador
	 */
	public String getTomador() {
		return tomador;
	}

	/**
	 * @param tomador the tomador to set
	 */
	public void setTomador(String tomador) {
		this.tomador = tomador;
	}

	/**
	 * @return the unidadeExternaVO
	 */
	public UnidadeExternaVO getUnidadeExternaVO() {
		return unidadeExternaVO;
	}

	/**
	 * @param unidadeExternaVO the unidadeExternaVO to set
	 */
	public void setUnidadeExternaVO(UnidadeExternaVO unidadeExternaVO) {
		this.unidadeExternaVO = unidadeExternaVO;
	}

	/**
	 * @return the svtxspreadnegoc
	 */
	public String getSvtxspreadnegoc() {
		return svtxspreadnegoc;
	}

	/**
	 * @param svtxspreadnegoc the svtxspreadnegoc to set
	 */
	public void setSvtxspreadnegoc(String svtxspreadnegoc) {
		this.svtxspreadnegoc = svtxspreadnegoc;
	}

	/**
	 * @return the tdiaprazo
	 */
	public Integer getTdiaprazo() {
		return tdiaprazo;
	}

	/**
	 * @param tdiaprazo the tdiaprazo to set
	 */
	public void setTdiaprazo(Integer tdiaprazo) {
		this.tdiaprazo = tdiaprazo;
	}

	/**
	 * @return the fechamento
	 */
	public Date getFechamento() {
		return fechamento;
	}

	/**
	 * @param fechamento the fechamento to set
	 */
	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	/**
	 * @return the vencimento
	 */
	public Date getVencimento() {
		return vencimento;
	}

	/**
	 * @param vencimento the vencimento to set
	 */
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
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
	 * @return the cmodldprodtcmbio
	 */
	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}

	/**
	 * @param cmodldprodtcmbio the cmodldprodtcmbio to set
	 */
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	/**
	 * @return the ncontrlim
	 */
	public Long getNcontrlim() {
		return ncontrlim;
	}

	/**
	 * @param ncontrlim the ncontrlim to set
	 */
	public void setNcontrlim(Long ncontrlim) {
		this.ncontrlim = ncontrlim;
	}

	/**
	 * @return the vdispnlimgerc
	 */
	public String getVdispnlimgerc() {
		return vdispnlimgerc;
	}

	/**
	 * @param vdispnlimgerc the vdispnlimgerc to set
	 */
	public void setVdispnlimgerc(String vdispnlimgerc) {
		this.vdispnlimgerc = vdispnlimgerc;
	}

	public Integer getCcatlggarntprinc() {
		return ccatlggarntprinc;
	}

	public void setCcatlggarntprinc(Integer ccatlggarntprinc) {
		this.ccatlggarntprinc = ccatlggarntprinc;
	}

	/**
	 * @return the enbletonegoccmbioano
	 */
	public Integer getEnbletonegoccmbioano() {
		return enbletonegoccmbioano;
	}

	/**
	 * @param enbletonegoccmbioano the enbletonegoccmbioano to set
	 */
	public void setEnbletonegoccmbioano(Integer enbletonegoccmbioano) {
		this.enbletonegoccmbioano = enbletonegoccmbioano;
	}

	/**
	 * @return the edanobase
	 */
	public Integer getEdanobase() {
		return edanobase;
	}

	/**
	 * @param edanobase the edanobase to set
	 */
	public void setEdanobase(Integer edanobase) {
		this.edanobase = edanobase;
	}
    
    
}
