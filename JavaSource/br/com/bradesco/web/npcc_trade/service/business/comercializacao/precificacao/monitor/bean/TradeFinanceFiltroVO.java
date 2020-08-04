package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

/**
  * Nome: TradeFinanceFiltroVO.java
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
  * Registro  de Manutenção: 07/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class TradeFinanceFiltroVO {

    /* PERIODO INICIAL DE PESQUISA */
    /* PERIODO FINAL DE PESQUISA */
    private CalendarioPeriodo dataInicioFim = new CalendarioPeriodo();
    
    /**
     * PERIODO DA COTACAO
     */
    private CalendarioPeriodo periodoCotacao = new CalendarioPeriodo();

    /**
     * PERIDO DE FECHAMETNO
     */
    private CalendarioPeriodo periodoFech = new CalendarioPeriodo();

    /**
     * CNPJ
     */
    private CnpjDataType cnpj = new CnpjDataType();

    /**
     * CPF
     */
    private CpfDataType cpf = new CpfDataType();

    /**
     * CODIGO UNICO CLIENTE
     */
    private Long cunicclicmbio = null;

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
    private Integer ctposgmtocli = null;

    /**
     * CODIGO STATUS BOLETO
     */
    private Integer csitbletocmbio = null;

    /**
     * CODIGO OPERADOR
     */
    private String cusuarincl = null;

    /**
     * NOME OPERADOR
     */
    private String nmusuarinc = null;

    /**
     * CODIGO DA MOEDA
     */
    private Integer cindcdeconmmoeda = null;

    /**
     * CODIGO DO PRODUTO
     */
    private Integer cprodtservc = null;

    /**
     * CODIGO UNIDADE NEGOCIO
     */
    private String nsequndorgnz = null;

    /**
     * CODIGO UNIDADE EXTERNA
     */
    private UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();

    /**
     * INDICADOR SWAP 1 - SIM / 2 - NAO
     */
    private Boolean cindcdnegocswap;

    /**
     * 1 - INDICATIVA/ 2 - FIRME
     */
    private Integer ctponegoccmbio = null;

    /**
     * NUMERO DA COTACAO (BOLETO)
     */
    private Integer nbletocmbioano;

    /**
     * PRAZO EM DIAS DE
     */
    private Integer tdiadecmbio = null;

    /**
     * PRAZO EM DIAS ATE
     */
    private Integer tdiaatecmbio = null;

    /**
     * PRAZO MEDIO EM DIAS DE
     */
    private Integer qprzmedde = null;

    /**
     * PRAZO MEDIO EM DIAS
     */
    private Integer qprzmedate = null;

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
    private Integer cpaisrest = null;

    /**
     * CODIGO DA FUNCIONALIDADE
     */
    private Integer funcao;

    /**
     * ANO BASE DA COTACAO
     */
    private Integer danobase;

    /**
     * SITUACAO DA PENDENCIA = 32 CUSTO EXTERNO
     */
    private Integer csitcustext;

    /**
     * SITUACAO DA PENDENCIA = 33 UNIDADE EXTERNA
     */
    private Integer csitunidext;

    /**
     * SITUACAO DA PENDENCIA = 37 DIVERGENTE
     */
    private Integer csitdiverg;

    private OperadorVO operadorVO = new OperadorVO();
    
    /**  PESSOA JURIDICA **/
    private Long cpssoajurid = 0L;

    /* Campos específicos usados na tela "Agenda de Operações com SWAP" */    
    
    /** PERÍODO VENCIMENTO SWAP **/
    private CalendarioPeriodo periodoSwap = new CalendarioPeriodo();
    
    /** STATUS SWAP, ONDE: 1 - EM SER, 2 - BAIXADO **/
    private String cindcdliqdcswap = null;
 
    /** FUNDING **/
    private Long cbanqrcmbiofndng = 0L;
        
    /* Fim - campos da tela "Agenda de Operações com SWAP" */
   
    /**
     * @return o valor do periodoCotacao
     */
    public CalendarioPeriodo getPeriodoCotacao() {
        return periodoCotacao;
    }

    /**
     * @param periodoCotacao seta o novo valor para o campo periodoCotacao
     */
    public void setPeriodoCotacao(CalendarioPeriodo periodoCotacao) {
        this.periodoCotacao = periodoCotacao;
    }

    /**
     * @return o valor do periodoFech
     */
    public CalendarioPeriodo getPeriodoFech() {
        return periodoFech;
    }

    /**
     * @param periodoFech seta o novo valor para o campo periodoFech
     */
    public void setPeriodoFech(CalendarioPeriodo periodoFech) {
        this.periodoFech = periodoFech;
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
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    /**
     * @return o valor do nmcliente
     */
    public String getNmcliente() {
        return nmcliente;
    }

    /**
     * @param nmcliente seta o novo valor para o campo nmcliente
     */
    public void setNmcliente(String nmcliente) {
        this.nmcliente = nmcliente;
    }

    /**
     * @return o valor do nmopr
     */
    public String getNmopr() {
        return nmopr;
    }

    /**
     * @param nmopr seta o novo valor para o campo nmopr
     */
    public void setNmopr(String nmopr) {
        this.nmopr = nmopr;
    }

    /**
     * @return o valor do ctposgmtocli
     */
    public Integer getCtposgmtocli() {
        return ctposgmtocli;
    }

    /**
     * @param ctposgmtocli seta o novo valor para o campo ctposgmtocli
     */
    public void setCtposgmtocli(Integer ctposgmtocli) {
        this.ctposgmtocli = ctposgmtocli;
    }

    /**
     * @return o valor do csitbletocmbio
     */
    public Integer getCsitbletocmbio() {
        return csitbletocmbio;
    }

    /**
     * @param csitbletocmbio seta o novo valor para o campo csitbletocmbio
     */
    public void setCsitbletocmbio(Integer csitbletocmbio) {
        this.csitbletocmbio = csitbletocmbio;
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
     * @return o valor do nmusuarinc
     */
    public String getNmusuarinc() {
        return nmusuarinc;
    }

    /**
     * @param nmusuarinc seta o novo valor para o campo nmusuarinc
     */
    public void setNmusuarinc(String nmusuarinc) {
        this.nmusuarinc = nmusuarinc;
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
     * @return o valor do cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }

    /**
     * @param cprodtservc seta o novo valor para o campo cprodtservc
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    /**
     * @return o valor do nsequndorgnz
     */
    public String getNsequndorgnz() {
        return nsequndorgnz;
    }

    /**
     * @param nsequndorgnz seta o novo valor para o campo nsequndorgnz
     */
    public void setNsequndorgnz(String nsequndorgnz) {
        this.nsequndorgnz = nsequndorgnz;
    }

    /**
     * @return o valor do unidadeExternaVO
     */
    public UnidadeExternaVO getUnidadeExternaVO() {
        return unidadeExternaVO;
    }

    /**
     * @param unidadeExternaVO seta o novo valor para o campo unidadeExternaVO
     */
    public void setUnidadeExternaVO(UnidadeExternaVO unidadeExternaVO) {
        this.unidadeExternaVO = unidadeExternaVO;
    }

    /**
     * @return o valor do cindcdnegocswap
     */
    public Boolean getCindcdnegocswap() {
        return cindcdnegocswap;
    }

    /**
     * @param cindcdnegocswap seta o novo valor para o campo cindcdnegocswap
     */
    public void setCindcdnegocswap(Boolean cindcdnegocswap) {
        this.cindcdnegocswap = cindcdnegocswap;
    }

    /**
     * @return o valor do ctponegoccmbio
     */
    public Integer getCtponegoccmbio() {
        return ctponegoccmbio;
    }

    /**
     * @param ctponegoccmbio seta o novo valor para o campo ctponegoccmbio
     */
    public void setCtponegoccmbio(Integer ctponegoccmbio) {
        this.ctponegoccmbio = ctponegoccmbio;
    }

    /**
     * @return o valor do nbletocmbioano
     */
    public Integer getNbletocmbioano() {
        return nbletocmbioano;
    }

    /**
     * @param nbletocmbioano seta o novo valor para o campo nbletocmbioano
     */
    public void setNbletocmbioano(Integer nbletocmbioano) {
        this.nbletocmbioano = nbletocmbioano;
    }

    /**
     * @return o valor do tdiadecmbio
     */
    public Integer getTdiadecmbio() {
        return tdiadecmbio;
    }

    /**
     * @param tdiadecmbio seta o novo valor para o campo tdiadecmbio
     */
    public void setTdiadecmbio(Integer tdiadecmbio) {
        this.tdiadecmbio = tdiadecmbio;
    }

    /**
     * @return o valor do tdiaatecmbio
     */
    public Integer getTdiaatecmbio() {
        return tdiaatecmbio;
    }

    /**
     * @param tdiaatecmbio seta o novo valor para o campo tdiaatecmbio
     */
    public void setTdiaatecmbio(Integer tdiaatecmbio) {
        this.tdiaatecmbio = tdiaatecmbio;
    }

    /**
     * @return o valor do qprzmedde
     */
    public Integer getQprzmedde() {
        return qprzmedde;
    }

    /**
     * @param qprzmedde seta o novo valor para o campo qprzmedde
     */
    public void setQprzmedde(Integer qprzmedde) {
        this.qprzmedde = qprzmedde;
    }

    /**
     * @return o valor do qprzmedate
     */
    public Integer getQprzmedate() {
        return qprzmedate;
    }

    /**
     * @param qprzmedate seta o novo valor para o campo qprzmedate
     */
    public void setQprzmedate(Integer qprzmedate) {
        this.qprzmedate = qprzmedate;
    }

    /**
     * @return o valor do valormede
     */
    public String getValormede() {
        return valormede;
    }

    /**
     * @param valormede seta o novo valor para o campo valormede
     */
    public void setValormede(String valormede) {
        this.valormede = valormede;
    }

    /**
     * @return o valor do valormeate
     */
    public String getValormeate() {
        return valormeate;
    }

    /**
     * @param valormeate seta o novo valor para o campo valormeate
     */
    public void setValormeate(String valormeate) {
        this.valormeate = valormeate;
    }

    /**
     * @return o valor do cpaisrest
     */
    public Integer getCpaisrest() {
        return cpaisrest;
    }

    /**
     * @param cpaisrest seta o novo valor para o campo cpaisrest
     */
    public void setCpaisrest(Integer cpaisrest) {
        this.cpaisrest = cpaisrest;
    }

    /**
     * @return o valor do funcao
     */
    public Integer getFuncao() {
        return funcao;
    }

    /**
     * @param funcao seta o novo valor para o campo funcao
     */
    public void setFuncao(Integer funcao) {
        this.funcao = funcao;
    }

    /**
     * @return o valor do danobase
     */
    public Integer getDanobase() {
        return danobase;
    }

    /**
     * @param danobase seta o novo valor para o campo danobase
     */
    public void setDanobase(Integer danobase) {
        this.danobase = danobase;
    }

    /**
     * @return o valor do csitcustext
     */
    public Integer getCsitcustext() {
        return csitcustext;
    }

    /**
     * @param csitcustext seta o novo valor para o campo csitcustext
     */
    public void setCsitcustext(Integer csitcustext) {
        this.csitcustext = csitcustext;
    }

    /**
     * @return o valor do csitunidext
     */
    public Integer getCsitunidext() {
        return csitunidext;
    }

    /**
     * @param csitunidext seta o novo valor para o campo csitunidext
     */
    public void setCsitunidext(Integer csitunidext) {
        this.csitunidext = csitunidext;
    }

    /**
     * @return o valor do csitdiverg
     */
    public Integer getCsitdiverg() {
        return csitdiverg;
    }

    /**
     * @param csitdiverg seta o novo valor para o campo csitdiverg
     */
    public void setCsitdiverg(Integer csitdiverg) {
        this.csitdiverg = csitdiverg;
    }

    /**
     * @return o valor do operadorVO
     */
    public OperadorVO getOperadorVO() {
        return operadorVO;
    }

    /**
     * @param operadorVO seta o novo valor para o campo operadorVO
     */
    public void setOperadorVO(OperadorVO operadorVO) {
        this.operadorVO = operadorVO;
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
     * @return o valor do periodoSwap
     */
    public CalendarioPeriodo getPeriodoSwap() {
        return periodoSwap;
    }

    /**
     * @param periodoSwap seta o novo valor para o campo periodoSwap
     */
    public void setPeriodoSwap(CalendarioPeriodo periodoSwap) {
        this.periodoSwap = periodoSwap;
    }

    /**
     * @return o valor do cindcdliqdcswap
     */
    public String getCindcdliqdcswap() {
        return cindcdliqdcswap;
    }

    /**
     * @param cindcdliqdcswap seta o novo valor para o campo cindcdliqdcswap
     */
    public void setCindcdliqdcswap(String cindcdliqdcswap) {
        this.cindcdliqdcswap = cindcdliqdcswap;
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

	public CalendarioPeriodo getDataInicioFim() {
		return dataInicioFim;
	}

	public void setDataInicioFim(CalendarioPeriodo dataInicioFim) {
		this.dataInicioFim = dataInicioFim;
	}

}
