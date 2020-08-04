/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 26/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.math.BigDecimal;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;

/**
 * Nome: TrdFinNegPrecificacaoVO.java
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
 * Registro  de Manutenção: 26/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegPrecificacaoVO implements Cloneable{
	
	private UnidadeExternaVO unidadeExternaVO = new UnidadeExternaVO();
	
	private UnidadeExternaVO bancoReembolsadorVO = new UnidadeExternaVO();
	
	private UnidadeExternaVO bancoAvisadorVO = new UnidadeExternaVO();
	
	private UnidadeExternaVO bancoIndicadoVO = new UnidadeExternaVO();
	
    /* PRECIFICACAO VALIDADE (DIAS) */
    private Integer tdiaopercmbioprcf;

    /* PRECIFICACAO DATA  DIAS  */
    private String dcotacfndngcmbio;
    
    /* PRECIFICACAO TAXA FIXA   */
    private String ptxfixacmbio;    
    
    /* SIMBOLO DA MOEDA EM OPERACAO */
    private String simbleconmmoeda;    
    
    /* PRECIFICACAO LIBOR QTDE MESES */
    private Integer tmesliborcmbio;
    
    /* PRECIFICACAO LIBOR % */
    private String vtxliborcmbio;    

    /****** Campos para Custo Externo *****/
    /* MOEDA */
    private Integer cindcdeconmmoeda = 0;

    /* PRAZO MEDIO DIAS */
    private Integer przomediodsemb = 0;

    /* CODIGO DO PRODUTO */
    private Integer cprodtservc = 0;

    /* DIAS DE VALDIADE DA COTACAO  */
    private Integer validadecotac = 0;

    /* DATA DA COTACAO */
    private String dtcotac = null;
    private String dataCotacaoFormat = null;

    /* CUSTO EXTERNO */
    private String custoext = null;
    private String custoExternoFormat = null;

    /* DESCRICAO MOEDA */
    private String isglindcdfonte = null;

    /* PRAZO */
    private Integer przomediodsembm = 0;

    /* (SPREAD+CLEAN) */
    private String spreadclean = null;

    /* MOEDA+PRAZO+(SPREAD+CLEAN)  */
    private String libor = null;
        
    /* VALIDADE */
    private String dlimfndngcmbio = null;
    
    /* CODIGO UNICO PESSOA TOMADOR */
    private Long cunicpssoacmbiot = 0L;
    
    /*NOME DO TOMADOR*/
    private String ncunicpssoacmbiot = null;
    
    /** Tipo String */
    private String pcobervarprodt = null;
    
    private String praca = null;
    
    /** CAMPO COMISSAO DE DESEMBOLSO */
    private String comissaodsemblso = null;
    
    /** CAMPO VALOR DE DESEMBOLSO */
    private String vlrcomisdsemb = null;
    
    private Boolean taxaFixa = false;
    
    public Boolean getTaxaFixa() {
    	taxaFixaMaiorQueZero(this.getCustoExternoFormat());
		return taxaFixa;
	}

	public void setTaxaFixa(Boolean taxaFixa) {
		this.taxaFixa = taxaFixa;
	}
	
	public void taxaFixaMaiorQueZero(String valor){
		if (valor == null) {
			valor = "0.00";
		}
		BigDecimal seuBigdecimal = new BigDecimal(valor.replace(",", "."));
		if (seuBigdecimal.signum() > 0) {
			setTaxaFixa(true);
		} else {
			setTaxaFixa(false);
		}
	}
	
	 public TrdFinNegPrecificacaoVO copy() {
	        try {
	            return (TrdFinNegPrecificacaoVO)this.clone();
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	            return null;
	        }
	 }
    
    /**
     * @return o valor do tdiaopercmbioprcf
     */
    public Integer getTdiaopercmbioprcf() {
        return tdiaopercmbioprcf;
    }

    /**
     * @param tdiaopercmbioprcf seta o novo valor para o campo tdiaopercmbioprcf
     */
    public void setTdiaopercmbioprcf(Integer tdiaopercmbioprcf) {
        this.tdiaopercmbioprcf = tdiaopercmbioprcf;
    }

    /**
     * @return o valor do dcotacfndngcmbio
     */
    public String getDcotacfndngcmbio() {
        return dcotacfndngcmbio;
    }

    /**
     * @param dcotacfndngcmbio seta o novo valor para o campo dcotacfndngcmbio
     */
    public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
        this.dcotacfndngcmbio = dcotacfndngcmbio;
    }

    /**
     * @return o valor do ptxfixacmbio
     */
    public String getPtxfixacmbio() {
        return ptxfixacmbio;
    }

    /**
     * @param ptxfixacmbio seta o novo valor para o campo ptxfixacmbio
     */
    public void setPtxfixacmbio(String ptxfixacmbio) {
        this.ptxfixacmbio = ptxfixacmbio;
    }

    /**
     * @return o valor do simbleconmmoeda
     */
    public String getSimbleconmmoeda() {
        return simbleconmmoeda;
    }

    /**
     * @param simbleconmmoeda seta o novo valor para o campo simbleconmmoeda
     */
    public void setSimbleconmmoeda(String simbleconmmoeda) {
        this.simbleconmmoeda = simbleconmmoeda;
    }

    /**
     * @return o valor do tmesliborcmbio
     */
    public Integer getTmesliborcmbio() {
        return tmesliborcmbio;
    }

    /**
     * @param tmesliborcmbio seta o novo valor para o campo tmesliborcmbio
     */
    public void setTmesliborcmbio(Integer tmesliborcmbio) {
        this.tmesliborcmbio = tmesliborcmbio;
    }

    /**
     * @return o valor do vtxliborcmbio
     */
    public String getVtxliborcmbio() {
        return vtxliborcmbio;
    }

    /**
     * @param vtxliborcmbio seta o novo valor para o campo vtxliborcmbio
     */
    public void setVtxliborcmbio(String vtxliborcmbio) {
        this.vtxliborcmbio = vtxliborcmbio;
    }

    public String getPreclibor() {
        return simbleconmmoeda + " " + tmesliborcmbio + " Meses + " + vtxliborcmbio + "%AA";  
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
     * @return o valor do przomediodsemb
     */
    public Integer getPrzomediodsemb() {
        return przomediodsemb;
    }

    /**
     * @param przomediodsemb seta o novo valor para o campo przomediodsemb
     */
    public void setPrzomediodsemb(Integer przomediodsemb) {
        this.przomediodsemb = przomediodsemb;
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
     * @return o valor do validadecotac
     */
    public Integer getValidadecotac() {
        return validadecotac;
    }

    /**
     * @param validadecotac seta o novo valor para o campo validadecotac
     */
    public void setValidadecotac(Integer validadecotac) {
        this.validadecotac = validadecotac;
    }

    /**
     * @return o valor do dtcotac
     */
    public String getDtcotac() {
        return dtcotac;
    }

    /**
     * @param dtcotac seta o novo valor para o campo dtcotac
     */
    public void setDtcotac(String dtcotac) {
        this.dtcotac = dtcotac;
    }

    /**
     * @return o valor do custoext
     */
    public String getCustoext() {
        return custoext;
    }

    /**
     * @param custoext seta o novo valor para o campo custoext
     */
    public void setCustoext(String custoext) {
        this.custoext = custoext;
    }

    /**
     * @return o valor do libor
     */
    public String getLibor() {
        return libor;
    }

    /**
     * @param libor seta o novo valor para o campo libor
     */
    public void setLibor(String libor) {
        this.libor = libor;
    }

    /**
     * @return o valor do dataCotacaoFormat
     */
    public String getDataCotacaoFormat() {
        return dataCotacaoFormat;
    }

    /**
     * @param dataCotacaoFormat seta o novo valor para o campo dataCotacaoFormat
     */
    public void setDataCotacaoFormat(String dataCotacaoFormat) {
        this.dataCotacaoFormat = dataCotacaoFormat;
    }

    /**
     * @return o valor do custoExternoFormat
     */
    public String getCustoExternoFormat() {
        return custoExternoFormat;
    }

    /**
     * @param custoExternoFormat seta o novo valor para o campo custoExternoFormat
     */
    public void setCustoExternoFormat(String custoExternoFormat) {
        this.custoExternoFormat = custoExternoFormat;
    }

    /**
     * @return o valor do isglindcdfonte
     */
    public String getIsglindcdfonte() {
        return isglindcdfonte;
    }

    /**
     * @param isglindcdfonte seta o novo valor para o campo isglindcdfonte
     */
    public void setIsglindcdfonte(String isglindcdfonte) {
        this.isglindcdfonte = isglindcdfonte;
    }

    /**
     * @return o valor do przomediodsembm
     */
    public Integer getPrzomediodsembm() {
        return przomediodsembm;
    }

    /**
     * @param przomediodsembm seta o novo valor para o campo przomediodsembm
     */
    public void setPrzomediodsembm(Integer przomediodsembm) {
        this.przomediodsembm = przomediodsembm;
    }

    /**
     * @return o valor do spreadclean
     */
    public String getSpreadclean() {
        return spreadclean;
    }

    /**
     * @param spreadclean seta o novo valor para o campo spreadclean
     */
    public void setSpreadclean(String spreadclean) {
        this.spreadclean = spreadclean;
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

    public UnidadeExternaVO getUnidadeExternaVO() {
		return unidadeExternaVO;
	}

	public void setUnidadeExternaVO(UnidadeExternaVO unidadeExternaVO) {
		this.unidadeExternaVO = unidadeExternaVO;
	}

    /**
     * @return o valor do bancoReembolsadorVO
     */
    public UnidadeExternaVO getBancoReembolsadorVO() {
        return bancoReembolsadorVO;
    }

    /**
     * @param bancoReembolsadorVO seta o novo valor para o campo bancoReembolsadorVO
     */
    public void setBancoReembolsadorVO(UnidadeExternaVO bancoReembolsadorVO) {
        this.bancoReembolsadorVO = bancoReembolsadorVO;
    }

    /**
     * @return o valor do bancoAvisadorVO
     */
    public UnidadeExternaVO getBancoAvisadorVO() {
        return bancoAvisadorVO;
    }

    /**
     * @param bancoAvisadorVO seta o novo valor para o campo bancoAvisadorVO
     */
    public void setBancoAvisadorVO(UnidadeExternaVO bancoAvisadorVO) {
        this.bancoAvisadorVO = bancoAvisadorVO;
    }

    /**
     * @return o valor do bancoIndicadoVO
     */
    public UnidadeExternaVO getBancoIndicadoVO() {
        return bancoIndicadoVO;
    }

    /**
     * @param bancoIndicadoVO seta o novo valor para o campo bancoIndicadoVO
     */
    public void setBancoIndicadoVO(UnidadeExternaVO bancoIndicadoVO) {
        this.bancoIndicadoVO = bancoIndicadoVO;
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
	
}
