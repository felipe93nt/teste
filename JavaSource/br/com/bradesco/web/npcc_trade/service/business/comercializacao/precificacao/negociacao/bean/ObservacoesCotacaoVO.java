package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.view.bean.ResponsavelDespesaVO;


/**
  * Nome: ObservacoesCotacaoVO.java
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
  * Registro  de Manutenção: 31/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ObservacoesCotacaoVO {

    /* NPCCWW0E-REGISTRO.NPCCWW0E-CTPO-OPER */
    private String ctpooper = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-HINCL-REG */
    private String hinclreg = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-NBLETO-NEGOC-CMBIO */
    private Long nbletonegoccmbio = 0L;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-CUNIC-CLI-CMBIO */
    private Long cunicclicmbio = 0L;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-QTD-OC-REBT */
    private Integer qtdocrebt = 0;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-QTD-OC-TXDE */
    private Integer qtdoctxde = 0;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-NOME-CTT-CLI-CMBIO */
    private String nomecttclicmbio = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-TEL-CTT-CLI-CMBIO */
    private String telcttclicmbio = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-FPGTO-COMPL-CMBIO */
    private String fpgtocomplcmbio = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-NIDTFD-CARTA-CSNDO */
    private String nidtfdcartacsndo = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DESP-CONF */
    private String despconf = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DESP-DESC */
    private String despdesc = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-FORM-AMOR */
    private String formamor = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARANTIAS */
    private String garantias = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-AMORTIZAR */
    private String amortizar = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-PAGA-JURO */
    private String pagajuro = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-PART-BNDS */
    private String partbnds = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-ORCAMENTO */
    private String orcamento = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-BNDS */
    private String garanbnds = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-BRAD */
    private String garanbrad = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-TXA-PRE */
    private String txapre = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-CUST-FIN */
    private String custfin = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-MERCADORIA */
    private String mercadoria = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-NOME */
    private String dadosnome = null;
    
    private String dadoscpfcnpj = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-R */
    private Integer dadoscpfcnpjr = 0;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-F */
    private Integer dadoscpfcnpjf = 0;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-CPF-CNPJ-D */
    private Integer dadoscpfcnpjd = 0;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ENDER */
    private String dadosender = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-IDENT */
    private String dadosident = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ORGAO */
    private String dadosorgao = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-ESTCI */
    private String dadosestci = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-DADOS-REGCI */
    private String dadosregci = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-CARGO-NOME */
    private String cargonome = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-CARGO-EMAIL */
    private String cargoemail = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-GARANT */
    private String garangarant = null;
    
    private String garantFormataDados = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-IMPORT */
    private String garanimport = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDBGAR */
    private String garancondbgar = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDBMAN */
    private String garancondbman = null;

    /* NPCCWW0E-REGISTRO.NPCCWW0E-GARAN-CONDAGFI */
    private String garancondagfi = null;
    
    /**
     * DESCRICAO DO NOME ROF
     */
    private String nomerof;

    /**
     * DESCRICAO DO TEL ROF
     */
    private String telrof;

    /**
     * DESCRICAO DO CPF ROF
     */
    private String cpfrof;

    /**
     * DESCRICAO DO CARGO ROF
     */
    private String cargorof;

    /**
     * DESCRICAO DO EMAIL ROF
     */
    private String emailrof;
    
    /**
     * OUTRAS ESPECIFICACOES
     */
    private String outrasespcs;

    
    /**
     * OBSERVACOES:
     */
    private String observacaoInclusao;
    private String observacao1;
    private String observacao2;
    private String observacao3;
    private String observacao4;
    private String observacao5;
    private String observacao6;
    private String observacao7;
    private String observacao8;
    private String observacao9;
    private String observacao10;
    
    /** REBATE **/
    private List<ListaRebateVO> listaRebate = new ArrayList<ListaRebateVO>();
    
    /** TAXA DESCONTO **/
    private List<ListaTaxaDescontoVO> listaTaxa = new ArrayList<ListaTaxaDescontoVO>();
    
    private CpfDataType rof_cpf = new CpfDataType();
    
    /** Codigo Porte **/
    private Integer cidtfdbndesporte = 0;
    
    /** Grupo **/
    private Integer cidtfdbndesgrp = 0;


    private CnpjDataType cnpjDeposit = new CnpjDataType();
    private CpfDataType cpfDeposit = new CpfDataType();
    private Integer codCpfCnpj = Numeros.ZERO;
    
    
    /** divergente **/
    private String divergente;
    
    /** DOCUMENTOS CONSIGNADOS LC IMPORTACAO **/
    private String doctoconsig = null;
    
    /** FORMA DE PAGAMENTO COMPLEMENTAR LC IMPORTACAO **/
    private String formapagto = null;
    
    /** CONSULTA COTAÇÕES EXTERNAS **/
    private List<ListaCotacoesExternasVO> listaCotacoesExt = new ArrayList<ListaCotacoesExternasVO>();
    
    /** CONSULTA DESPESAS **/
    private List<ListaDespesasVO> listaDespesas = new ArrayList<ListaDespesasVO>();
       
    /** CONSULTA PARCELAS DESEMBOLSO **/
    private List<ListaParcelasDesembolsoVO> parcelaDesembList = new ArrayList<ListaParcelasDesembolsoVO>();
    
    /** CONSULTA RESPONSAVEL DESPESAS **/
    private ResponsavelDespesaVO responDespesaList = new ResponsavelDespesaVO();
    
     
    /** Variavel do tipo CnpjDataType. */
    private CnpjDataType cnpj = new CnpjDataType();
    
    /** FINALIDADE GARANTIA**/
    private String finalidade = null;

    /** RETIRADA GARANTIA NOME**/
    private String retirnome = null;

    /** RETIRADA GARANTIA CIDADE**/
    private String retircidade = null;
    
    /** RETIRADA GARANTIA ENDERECO**/
    private String retirender = null;
    
    /** RETIRADA GARANTIA TELEFONE**/
    private String retirtele = null;
    
    /** RETIRADA GARANTIA EMAIL**/
    private String retiremail = null;
   
    // Getters and Setters
    
    /**
     * DESCRICAO COBRANCA DA COMISSAO BC MANDATARIO
     */
    private String descrComissaoBc = null;
    
    /**
     * DESCRICAO COBRANCA DA COMISSAO AGENTE
     */
    private String descrComissaoAg = null;
    
    
    /** BENEFICIARIO / AFIANCADO GARANTIAS **/
    private BeneficiarioVO beneficiario = new BeneficiarioVO();
    
    /**
     * @return o valor do ctpooper
     */
    public String getCtpooper() {
        return ctpooper;
    }

    /**
     * @param ctpooper seta o novo valor para o campo ctpooper
     */
    public void setCtpooper(String ctpooper) {
        this.ctpooper = ctpooper;
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
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
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
     * @return o valor do qtdocrebt
     */
    public Integer getQtdocrebt() {
        return qtdocrebt;
    }

    /**
     * @param qtdocrebt seta o novo valor para o campo qtdocrebt
     */
    public void setQtdocrebt(Integer qtdocrebt) {
        this.qtdocrebt = qtdocrebt;
    }

    /**
     * @return o valor do qtdoctxde
     */
    public Integer getQtdoctxde() {
        return qtdoctxde;
    }

    /**
     * @param qtdoctxde seta o novo valor para o campo qtdoctxde
     */
    public void setQtdoctxde(Integer qtdoctxde) {
        this.qtdoctxde = qtdoctxde;
    }

    /**
     * @return o valor do nomecttclicmbio
     */
    public String getNomecttclicmbio() {
        return nomecttclicmbio;
    }

    /**
     * @param nomecttclicmbio seta o novo valor para o campo nomecttclicmbio
     */
    public void setNomecttclicmbio(String nomecttclicmbio) {
        this.nomecttclicmbio = nomecttclicmbio;
    }

    /**
     * @return o valor do telcttclicmbio
     */
    public String getTelcttclicmbio() {
        return telcttclicmbio;
    }

    /**
     * @param telcttclicmbio seta o novo valor para o campo telcttclicmbio
     */
    public void setTelcttclicmbio(String telcttclicmbio) {
        this.telcttclicmbio = telcttclicmbio;
    }

    /**
     * @return o valor do fpgtocomplcmbio
     */
    public String getFpgtocomplcmbio() {
        return fpgtocomplcmbio;
    }

    /**
     * @param fpgtocomplcmbio seta o novo valor para o campo fpgtocomplcmbio
     */
    public void setFpgtocomplcmbio(String fpgtocomplcmbio) {
        this.fpgtocomplcmbio = fpgtocomplcmbio;
    }

    /**
     * @return o valor do nidtfdcartacsndo
     */
    public String getNidtfdcartacsndo() {
        return nidtfdcartacsndo;
    }

    /**
     * @param nidtfdcartacsndo seta o novo valor para o campo nidtfdcartacsndo
     */
    public void setNidtfdcartacsndo(String nidtfdcartacsndo) {
        this.nidtfdcartacsndo = nidtfdcartacsndo;
    }

    /**
     * @return o valor do despconf
     */
    public String getDespconf() {
        return despconf;
    }

    /**
     * @param despconf seta o novo valor para o campo despconf
     */
    public void setDespconf(String despconf) {
        this.despconf = despconf;
    }

    /**
     * @return o valor do despdesc
     */
    public String getDespdesc() {
        return despdesc;
    }

    /**
     * @param despdesc seta o novo valor para o campo despdesc
     */
    public void setDespdesc(String despdesc) {
        this.despdesc = despdesc;
    }

    /**
     * @return o valor do formamor
     */
    public String getFormamor() {
        return formamor;
    }

    /**
     * @param formamor seta o novo valor para o campo formamor
     */
    public void setFormamor(String formamor) {
        this.formamor = formamor;
    }

    /**
     * @return o valor do garantias
     */
    public String getGarantias() {
        return garantias;
    }

    /**
     * @param garantias seta o novo valor para o campo garantias
     */
    public void setGarantias(String garantias) {
        this.garantias = garantias;
    }

    /**
     * @return o valor do amortizar
     */
    public String getAmortizar() {
        return amortizar;
    }

    /**
     * @param amortizar seta o novo valor para o campo amortizar
     */
    public void setAmortizar(String amortizar) {
        this.amortizar = amortizar;
    }

    /**
     * @return o valor do pagajuro
     */
    public String getPagajuro() {
        return pagajuro;
    }

    /**
     * @param pagajuro seta o novo valor para o campo pagajuro
     */
    public void setPagajuro(String pagajuro) {
        this.pagajuro = pagajuro;
    }

    /**
     * @return o valor do partbnds
     */
    public String getPartbnds() {
        return partbnds;
    }

    /**
     * @param partbnds seta o novo valor para o campo partbnds
     */
    public void setPartbnds(String partbnds) {
        this.partbnds = partbnds;
    }

    /**
     * @return o valor do orcamento
     */
    public String getOrcamento() {
        return orcamento;
    }

    /**
     * @param orcamento seta o novo valor para o campo orcamento
     */
    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    /**
     * @return o valor do garanbnds
     */
    public String getGaranbnds() {
        return garanbnds;
    }

    /**
     * @param garanbnds seta o novo valor para o campo garanbnds
     */
    public void setGaranbnds(String garanbnds) {
        this.garanbnds = garanbnds;
    }

    /**
     * @return o valor do garanbrad
     */
    public String getGaranbrad() {
        return garanbrad;
    }

    /**
     * @param garanbrad seta o novo valor para o campo garanbrad
     */
    public void setGaranbrad(String garanbrad) {
        this.garanbrad = garanbrad;
    }

    /**
     * @return o valor do txapre
     */
    public String getTxapre() {
        return txapre;
    }

    /**
     * @param txapre seta o novo valor para o campo txapre
     */
    public void setTxapre(String txapre) {
        this.txapre = txapre;
    }

    /**
     * @return o valor do custfin
     */
    public String getCustfin() {
        return custfin;
    }

    /**
     * @param custfin seta o novo valor para o campo custfin
     */
    public void setCustfin(String custfin) {
        this.custfin = custfin;
    }

    /**
     * @return o valor do mercadoria
     */
    public String getMercadoria() {
        return mercadoria;
    }

    /**
     * @param mercadoria seta o novo valor para o campo mercadoria
     */
    public void setMercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    /**
     * @return o valor do dadosnome
     */
    public String getDadosnome() {
        return dadosnome;
    }

    /**
     * @param dadosnome seta o novo valor para o campo dadosnome
     */
    public void setDadosnome(String dadosnome) {
        this.dadosnome = dadosnome;
    }

    /**
     * @return o valor do dadosender
     */
    public String getDadosender() {
        return dadosender;
    }

    /**
     * @param dadosender seta o novo valor para o campo dadosender
     */
    public void setDadosender(String dadosender) {
        this.dadosender = dadosender;
    }

    /**
     * @return o valor do dadosident
     */
    public String getDadosident() {
        return dadosident;
    }

    /**
     * @param dadosident seta o novo valor para o campo dadosident
     */
    public void setDadosident(String dadosident) {
        this.dadosident = dadosident;
    }

    /**
     * @return o valor do dadosorgao
     */
    public String getDadosorgao() {
        return dadosorgao;
    }

    /**
     * @param dadosorgao seta o novo valor para o campo dadosorgao
     */
    public void setDadosorgao(String dadosorgao) {
        this.dadosorgao = dadosorgao;
    }

    /**
     * @return o valor do dadosestci
     */
    public String getDadosestci() {
        return dadosestci;
    }

    /**
     * @param dadosestci seta o novo valor para o campo dadosestci
     */
    public void setDadosestci(String dadosestci) {
        this.dadosestci = dadosestci;
    }

    /**
     * @return o valor do dadosregci
     */
    public String getDadosregci() {
        return dadosregci;
    }

    /**
     * @param dadosregci seta o novo valor para o campo dadosregci
     */
    public void setDadosregci(String dadosregci) {
        this.dadosregci = dadosregci;
    }

    /**
     * @return o valor do cargonome
     */
    public String getCargonome() {
        return cargonome;
    }

    /**
     * @param cargonome seta o novo valor para o campo cargonome
     */
    public void setCargonome(String cargonome) {
        this.cargonome = cargonome;
    }

    /**
     * @return o valor do cargoemail
     */
    public String getCargoemail() {
        return cargoemail;
    }

    /**
     * @param cargoemail seta o novo valor para o campo cargoemail
     */
    public void setCargoemail(String cargoemail) {
        this.cargoemail = cargoemail;
    }

    /**
     * @return o valor do garangarant
     */
    public String getGarangarant() {
        return garangarant;
    }

    /**
     * @param garangarant seta o novo valor para o campo garangarant
     */
    public void setGarangarant(String garangarant) {
        this.garangarant = garangarant;
    }

    /**
     * @return o valor do garanimport
     */
    public String getGaranimport() {
        return garanimport;
    }

    /**
     * @param garanimport seta o novo valor para o campo garanimport
     */
    public void setGaranimport(String garanimport) {
        this.garanimport = garanimport;
    }

    /**
     * @return o valor do garancondbgar
     */
    public String getGarancondbgar() {
        return garancondbgar;
    }

    /**
     * @param garancondbgar seta o novo valor para o campo garancondbgar
     */
    public void setGarancondbgar(String garancondbgar) {
        this.garancondbgar = garancondbgar;
    }

    /**
     * @return o valor do garancondbman
     */
    public String getGarancondbman() {
        return garancondbman;
    }

    /**
     * @param garancondbman seta o novo valor para o campo garancondbman
     */
    public void setGarancondbman(String garancondbman) {
        this.garancondbman = garancondbman;
    }

    /**
     * @return o valor do garancondagfi
     */
    public String getGarancondagfi() {
        return garancondagfi;
    }

    /**
     * @param garancondagfi seta o novo valor para o campo garancondagfi
     */
    public void setGarancondagfi(String garancondagfi) {
        this.garancondagfi = garancondagfi;
    }

	public String getNomerof() {
		return nomerof;
	}

	public void setNomerof(String nomerof) {
		this.nomerof = nomerof;
	}

	public String getTelrof() {
		return telrof;
	}

	public void setTelrof(String telrof) {
		this.telrof = telrof;
	}

	public String getCpfrof() {
		return cpfrof;
	}

	public void setCpfrof(String cpfrof) {
		this.cpfrof = cpfrof;
	}

	public String getCargorof() {
		return cargorof;
	}

	public void setCargorof(String cargorof) {
		this.cargorof = cargorof;
	}

	public String getEmailrof() {
		return emailrof;
	}

	public void setEmailrof(String emailrof) {
		this.emailrof = emailrof;
	}

	public String getOutrasespcs() {
		return outrasespcs;
	}

	public void setOutrasespcs(String outrasespcs) {
		this.outrasespcs = outrasespcs;
	}

	public String getObservacao1() {
		return observacao1;
	}

	public void setObservacao1(String observacao1) {
		this.observacao1 = observacao1;
	}

	public String getObservacao2() {
		return observacao2;
	}

	public void setObservacao2(String observacao2) {
		this.observacao2 = observacao2;
	}

	public String getObservacao3() {
		return observacao3;
	}

	public void setObservacao3(String observacao3) {
		this.observacao3 = observacao3;
	}

	public String getObservacao4() {
		return observacao4;
	}

	public void setObservacao4(String observacao4) {
		this.observacao4 = observacao4;
	}

	public String getObservacao5() {
		return observacao5;
	}

	public void setObservacao5(String observacao5) {
		this.observacao5 = observacao5;
	}

	public String getObservacao6() {
		return observacao6;
	}

	public void setObservacao6(String observacao6) {
		this.observacao6 = observacao6;
	}

	public String getObservacao7() {
		return observacao7;
	}

	public void setObservacao7(String observacao7) {
		this.observacao7 = observacao7;
	}

	public String getObservacao8() {
		return observacao8;
	}

	public void setObservacao8(String observacao8) {
		this.observacao8 = observacao8;
	}

	public String getObservacao9() {
		return observacao9;
	}

	public void setObservacao9(String observacao9) {
		this.observacao9 = observacao9;
	}

	public String getObservacao10() {
		return observacao10;
	}

	public void setObservacao10(String observacao10) {
		this.observacao10 = observacao10;
	}

	public List<ListaRebateVO> getListaRebate() {
		return listaRebate;
	}

	public void setListaRebate(List<ListaRebateVO> listaRebate) {
		this.listaRebate = listaRebate;
	}

	public List<ListaTaxaDescontoVO> getListaTaxa() {
		return listaTaxa;
	}

	public void setListaTaxa(List<ListaTaxaDescontoVO> listaTaxa) {
		this.listaTaxa = listaTaxa;
	}

	public CpfDataType getRof_cpf() {
		return rof_cpf;
	}

	public void setRof_cpf(CpfDataType rof_cpf) {
		this.rof_cpf = rof_cpf;
	}

	public Integer getCidtfdbndesporte() {
		return cidtfdbndesporte;
	}

	public void setCidtfdbndesporte(Integer cidtfdbndesporte) {
		this.cidtfdbndesporte = cidtfdbndesporte;
	}
	
	public Integer getCidtfdbndesgrp() {
		return cidtfdbndesgrp;
	}

	public void setCidtfdbndesgrp(Integer cidtfdbndesgrp) {
		this.cidtfdbndesgrp = cidtfdbndesgrp;
	}

    /**
     * @return o valor do cnpjDeposit
     */
    public CnpjDataType getCnpjDeposit() {
        return cnpjDeposit;
    }

    /**
     * @param cnpjDeposit seta o novo valor para o campo cnpjDeposit
     */
    public void setCnpjDeposit(CnpjDataType cnpjDeposit) {
        this.cnpjDeposit = cnpjDeposit;
    }

    /**
     * @return o valor do cpfDeposit
     */
    public CpfDataType getCpfDeposit() {
        return cpfDeposit;
    }

    /**
     * @param cpfDeposit seta o novo valor para o campo cpfDeposit
     */
    public void setCpfDeposit(CpfDataType cpfDeposit) {
        this.cpfDeposit = cpfDeposit;
    }
    
    /**
     * @return o valor do codCpfCnpj
     */
    public Integer getCodCpfCnpj() {
        return codCpfCnpj;
    }

    /**
     * @param codCpfCnpj seta o novo valor para o campo codCpfCnpj
     */
    public void setCodCpfCnpj(Integer codCpfCnpj) {
        this.codCpfCnpj = codCpfCnpj;
    }

    /**
     * @return o valor do dadoscpfcnpjr
     */
    public Integer getDadoscpfcnpjr() {
        return dadoscpfcnpjr;
    }

    /**
     * @param dadoscpfcnpjr seta o novo valor para o campo dadoscpfcnpjr
     */
    public void setDadoscpfcnpjr(Integer dadoscpfcnpjr) {
        this.dadoscpfcnpjr = dadoscpfcnpjr;
    }

    /**
     * @return o valor do dadoscpfcnpjf
     */
    public Integer getDadoscpfcnpjf() {
        return dadoscpfcnpjf;
    }

    /**
     * @param dadoscpfcnpjf seta o novo valor para o campo dadoscpfcnpjf
     */
    public void setDadoscpfcnpjf(Integer dadoscpfcnpjf) {
        this.dadoscpfcnpjf = dadoscpfcnpjf;
    }

    /**
     * @return o valor do dadoscpfcnpjd
     */
    public Integer getDadoscpfcnpjd() {
        return dadoscpfcnpjd;
    }

    /**
     * @param dadoscpfcnpjd seta o novo valor para o campo dadoscpfcnpjd
     */
    public void setDadoscpfcnpjd(Integer dadoscpfcnpjd) {
        this.dadoscpfcnpjd = dadoscpfcnpjd;
    }

	public String getDescrComissaoBc() {
		return descrComissaoBc;
	}

	public void setDescrComissaoBc(String descrComissaoBc) {
		this.descrComissaoBc = descrComissaoBc;
	}

	public String getDescrComissaoAg() {
		return descrComissaoAg;
	}
	
	public void setDescrComissaoAg(String descrComissaoAg) {
		this.descrComissaoAg = descrComissaoAg;
	}

    /**
     * @return o valor do listaCotacoesExt
     */
    public List<ListaCotacoesExternasVO> getListaCotacoesExt() {
        return listaCotacoesExt;
    }

    /**
     * @param listaCotacoesExt seta o novo valor para o campo listaCotacoesExt
     */
    public void setListaCotacoesExt(List<ListaCotacoesExternasVO> listaCotacoesExt) {
        this.listaCotacoesExt = listaCotacoesExt;
    }

    /**
     * @return o valor do listaDespesas
     */
    public List<ListaDespesasVO> getListaDespesas() {
        return listaDespesas;
    }

    /**
     * @param listaDespesas seta o novo valor para o campo listaDespesas
     */
    public void setListaDespesas(List<ListaDespesasVO> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    /**
     * @return o valor do parcelaDesembList
     */
    public List<ListaParcelasDesembolsoVO> getParcelaDesembList() {
        return parcelaDesembList;
    }

    /**
     * @param parcelaDesembList seta o novo valor para o campo parcelaDesembList
     */
    public void setParcelaDesembList(List<ListaParcelasDesembolsoVO> parcelaDesembList) {
        this.parcelaDesembList = parcelaDesembList;
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
     * @return o valor do dadoscpfcnpj
     */
    public String getDadoscpfcnpj() {
        return dadoscpfcnpj;
    }

    /**
     * @param dadoscpfcnpj seta o novo valor para o campo dadoscpfcnpj
     */
    public void setDadoscpfcnpj(String dadoscpfcnpj) {
        this.dadoscpfcnpj = dadoscpfcnpj;
    }

    /**
     * @return o valor do divergente
     */
    public String getDivergente() {
        return divergente;
    }

    /**
     * @param divergente seta o novo valor para o campo divergente
     */
    public void setDivergente(String divergente) {
        this.divergente = divergente;
    }

    /**
     * @return o valor do doctoconsig
     */
    public String getDoctoconsig() {
        return doctoconsig;
    }

    /**
     * @param doctoconsig seta o novo valor para o campo doctoconsig
     */
    public void setDoctoconsig(String doctoconsig) {
        this.doctoconsig = doctoconsig;
    }

    /**
     * @return o valor do formapagto
     */
    public String getFormapagto() {
        return formapagto;
    }

    /**
     * @param formapagto seta o novo valor para o campo formapagto
     */
    public void setFormapagto(String formapagto) {
        this.formapagto = formapagto;
    }

    /**
     * @return o valor do garantFormataDados
     */
    public String getGarantFormataDados() {
        
        if(garangarant.equals("1")) {
            return "Sim";
        }else if(garangarant.equals("2")) {
            return "Não";
        }
        return garantFormataDados;
    }

    /**
     * @param garantFormataDados seta o novo valor para o campo garantFormataDados
     */
    public void setGarantFormataDados(String garantFormataDados) {
        this.garantFormataDados = garantFormataDados;
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
     * @return o valor do retirnome
     */
    public String getRetirnome() {
        return retirnome;
    }

    /**
     * @param retirnome seta o novo valor para o campo retirnome
     */
    public void setRetirnome(String retirnome) {
        this.retirnome = retirnome;
    }

    /**
     * @return o valor do retircidade
     */
    public String getRetircidade() {
        return retircidade;
    }

    /**
     * @param retircidade seta o novo valor para o campo retircidade
     */
    public void setRetircidade(String retircidade) {
        this.retircidade = retircidade;
    }

    /**
     * @return o valor do retirender
     */
    public String getRetirender() {
        return retirender;
    }

    /**
     * @param retirender seta o novo valor para o campo retirender
     */
    public void setRetirender(String retirender) {
        this.retirender = retirender;
    }

    /**
     * @return o valor do retirtele
     */
    public String getRetirtele() {
        return retirtele;
    }

    /**
     * @param retirtele seta o novo valor para o campo retirtele
     */
    public void setRetirtele(String retirtele) {
        this.retirtele = retirtele;
    }

    /**
     * @return o valor do retiremail
     */
    public String getRetiremail() {
        return retiremail;
    }

    /**
     * @param retiremail seta o novo valor para o campo retiremail
     */
    public void setRetiremail(String retiremail) {
        this.retiremail = retiremail;
    }
    
    /**
     * @return o valor do observacaoInclusao
     */
    public String getObservacaoInclusao() {
        return observacaoInclusao;
    }

    /**
     * @param observacaoInclusao seta o novo valor para o campo observacaoInclusao
     */
    public void setObservacaoInclusao(String observacaoInclusao) {
        this.observacaoInclusao = observacaoInclusao;
    }

    /**
     * @return o valor do responDespesaList
     */
    public ResponsavelDespesaVO getResponDespesaList() {
        return responDespesaList;
    }

    /**
     * @param responDespesaList seta o novo valor para o campo responDespesaList
     */
    public void setResponDespesaList(ResponsavelDespesaVO responDespesaList) {
        this.responDespesaList = responDespesaList;
    }

    /**
     * @return o valor do beneficiario
     */
    public BeneficiarioVO getBeneficiario() {
        return beneficiario;
    }

    /**
     * @param beneficiario seta o novo valor para o campo beneficiario
     */
    public void setBeneficiario(BeneficiarioVO beneficiario) {
        this.beneficiario = beneficiario;
    }

    
   
}

