/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 13/01/2016
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;

/**
 * Nome: TrdFinNegFluxoPagtoVO.java
 * 
 * Propósito: Área com Dados Temporários de trabalho
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegFluxoPagtoVO extends TrdFinNegComumVO implements Cloneable{

	private Integer seqFluxoPagto = 0;

	private Integer tdiaopercmbio = 0;
	
	private Date dateFluxoPgto = null;
	private String dprevtdsembcmbio = null;
 
	private String vprevtdsembcmbio = null;
	
	private Integer tdiacarenprinc = 0;
	
	private Integer cfluxoliqdcprinc = 0;

	
	// ajustar os campos a baixo
	private String nomePrincPeriodicidade = null;

	private Integer princQtdParcelas = 0;
	
	private Integer jurosCarencia = 0;

	private Integer codJurosPeriodicidade = 0;

	private String nomeJurosPeriodicidade = null;
	
	private Integer jurosQtdParcelas = 0;

	private Integer codJurosMomento = 0;

	private String nomeJurosMomento = null;
	
	private Integer tdiafinandsemb = 0;

	private Integer przomediooperd = null;

	private String przomedioopera = null;

    private Integer qtdeocorrprinc = 0;

    private Integer qtdeocorrjuros = 0;
    
    /** CODIGO DO PAIS DE ORIGEM MOEDA **/
    private Integer cpais = 0;
      
    /**  DESCRICAO DO PAIS DE ORIGEM MOEDA **/
    private String ipais = null;
    
    private Integer ndsembcmbiotrade = 0;
    
    private Integer cindcdeconmc = 0;
    
    /** PAIS DA MOEDA DESEMBOLSO **/
    private Integer cpaisdsemb = 0;

    /* LISTA-PARCELAS */
    private List<TrdFinNegParcelaVO> listaParcelasFluxoPgto = new ArrayList<TrdFinNegParcelaVO>();

    /*** Campos para calculo dos Prazos Medios da Operacao e Desembolso(fluxo NPCCIARH) ***/

    private Integer przomediodsemb = 0;
    
	// NPCCWWVE-REGISTRO.NPCCWWVE-CPAIS-MOEDA-DSEMB
	private Integer cpaismoedadsemb = 0;
    

    public boolean isPeriodicidadeIrregular() {
        
        if (cfluxoliqdcprinc.equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) == true ||
                        codJurosPeriodicidade.equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isTodasPeriodicidadeIrregular() {
        
        if (cfluxoliqdcprinc.equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo()) == true &&
                        codJurosPeriodicidade.equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo())) {
            return true;
        }
        return false;
    }

    
    public TrdFinNegFluxoPagtoVO copy() {
        try {
            return (TrdFinNegFluxoPagtoVO)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Cria Comparator para ordenar arquivos de relatorio por data e hora
    class DateComparator implements Comparator<TrdFinNegFluxoPagtoVO> {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        @Override
        public int compare(TrdFinNegFluxoPagtoVO fluxo1, TrdFinNegFluxoPagtoVO fluxo2){
            
            Date data1 = new Date();
            Date data2 = new Date();
            
            try {
                data1 = SiteUtil.stringToDate(fluxo1.getDprevtdsembcmbio(), "dd/MM/yyyy");
                data2 = SiteUtil.stringToDate(fluxo2.getDprevtdsembcmbio(), "dd/MM/yyyy");
            } catch (ParseException e) {
                e.printStackTrace();
            }
           
            return data1.compareTo(data2);
        }
    }
    
    /**
     * Nome: getDateComparator
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 24/07/2017
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public DateComparator getDateComparator(){
        return new DateComparator();
    }
    
	/**
	 * @return o valor do seqFluxoPagto
	 */
	public Integer getSeqFluxoPagto() {
		return seqFluxoPagto;
	}

	/**
	 * @param seqFluxoPagto seta o novo valor para o campo seqFluxoPagto
	 */
	public void setSeqFluxoPagto(Integer seqFluxoPagto) {
		this.seqFluxoPagto = seqFluxoPagto;
	}

	/**
	 * @return o valor do tdiaopercmbio
	 */
	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}

	/**
	 * @param tdiaopercmbio seta o novo valor para o campo tdiaopercmbio
	 */
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	/**
	 * @return o valor do dateFluxoPgto
	 */
	public Date getDateFluxoPgto() {
		return dateFluxoPgto;
	}

	/**
	 * @param dateFluxoPgto seta o novo valor para o campo dateFluxoPgto
	 */
	public void setDateFluxoPgto(Date dateFluxoPgto) {
		this.dateFluxoPgto = dateFluxoPgto;
	}

	

	/**
	 * @return o valor do nomePrincPeriodicidade
	 */
	public String getNomePrincPeriodicidade() {
		return nomePrincPeriodicidade;
	}

	/**
	 * @param nomePrincPeriodicidade seta o novo valor para o campo nomePrincPeriodicidade
	 */
	public void setNomePrincPeriodicidade(String nomePrincPeriodicidade) {
		this.nomePrincPeriodicidade = nomePrincPeriodicidade;
	}

	/**
	 * @return o valor do princQtdParcelas
	 */
	public Integer getPrincQtdParcelas() {
		return princQtdParcelas;
	}

	/**
	 * @param princQtdParcelas seta o novo valor para o campo princQtdParcelas
	 */
	public void setPrincQtdParcelas(Integer princQtdParcelas) {
		this.princQtdParcelas = princQtdParcelas;
	}

	/**
	 * @return o valor do jurosCarencia
	 */
	public Integer getJurosCarencia() {
		return jurosCarencia;
	}

	/**
	 * @param jurosCarencia seta o novo valor para o campo jurosCarencia
	 */
	public void setJurosCarencia(Integer jurosCarencia) {
		this.jurosCarencia = jurosCarencia;
	}

	/**
	 * @return o valor do codJurosPeriodicidade
	 */
	public Integer getCodJurosPeriodicidade() {
		return codJurosPeriodicidade;
	}

	/**
	 * @param codJurosPeriodicidade seta o novo valor para o campo codJurosPeriodicidade
	 */
	public void setCodJurosPeriodicidade(Integer codJurosPeriodicidade) {
		this.codJurosPeriodicidade = codJurosPeriodicidade;
	}

	/**
	 * @return o valor do nomeJurosPeriodicidade
	 */
	public String getNomeJurosPeriodicidade() {
		return nomeJurosPeriodicidade;
	}

	/**
	 * @param nomeJurosPeriodicidade seta o novo valor para o campo nomeJurosPeriodicidade
	 */
	public void setNomeJurosPeriodicidade(String nomeJurosPeriodicidade) {
		this.nomeJurosPeriodicidade = nomeJurosPeriodicidade;
	}

	/**
	 * @return o valor do jurosQtdParcelas
	 */
	public Integer getJurosQtdParcelas() {
		return jurosQtdParcelas;
	}

	/**
	 * @param jurosQtdParcelas seta o novo valor para o campo jurosQtdParcelas
	 */
	public void setJurosQtdParcelas(Integer jurosQtdParcelas) {
		this.jurosQtdParcelas = jurosQtdParcelas;
	}

	/**
	 * @return o valor do codJurosMomento
	 */
	public Integer getCodJurosMomento() {
		return codJurosMomento;
	}

	/**
	 * @param codJurosMomento seta o novo valor para o campo codJurosMomento
	 */
	public void setCodJurosMomento(Integer codJurosMomento) {
		this.codJurosMomento = codJurosMomento;
	}

	/**
	 * @return o valor do nomeJurosMomento
	 */
	public String getNomeJurosMomento() {
		return nomeJurosMomento;
	}

	/**
	 * @param nomeJurosMomento seta o novo valor para o campo nomeJurosMomento
	 */
	public void setNomeJurosMomento(String nomeJurosMomento) {
		this.nomeJurosMomento = nomeJurosMomento;
	}

	/**
	 * @return o valor do tdiafinandsemb
	 */
	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}

	/**
	 * @param tdiafinandsemb seta o novo valor para o campo tdiafinandsemb
	 */
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	/**
	 * @return o valor do listaParcelasFluxoPgto
	 */
	public List<TrdFinNegParcelaVO> getListaParcelasFluxoPgto() {
		return listaParcelasFluxoPgto;
	}

	/**
	 * @param listaParcelasFluxoPgto seta o novo valor para o campo listaParcelasFluxoPgto
	 */
	public void setListaParcelasFluxoPgto(List<TrdFinNegParcelaVO> listaParcelasFluxoPgto) {
		this.listaParcelasFluxoPgto = listaParcelasFluxoPgto;
	}

	/**
	 * @return o valor do przomedioopera
	 */
	public String getPrzomedioopera() {
		return przomedioopera;
	}

	/**
	 * @param przomedioopera seta o novo valor para o campo przomedioopera
	 */
	public void setPrzomedioopera(String przomedioopera) {
		this.przomedioopera = przomedioopera;
	}

    /**
     * @return o valor do qtdeocorrprinc
     */
    public Integer getQtdeocorrprinc() {
        return qtdeocorrprinc;
    }

    /**
     * @param qtdeocorrprinc seta o novo valor para o campo qtdeocorrprinc
     */
    public void setQtdeocorrprinc(Integer qtdeocorrprinc) {
        this.qtdeocorrprinc = qtdeocorrprinc;
    }

    /**
     * @return o valor do qtdeocorrjuros
     */
    public Integer getQtdeocorrjuros() {
        return qtdeocorrjuros;
    }

    /**
     * @param qtdeocorrjuros seta o novo valor para o campo qtdeocorrjuros
     */
    public void setQtdeocorrjuros(Integer qtdeocorrjuros) {
        this.qtdeocorrjuros = qtdeocorrjuros;
    }

    /**
     * @return o valor do przomediooperd
     */
    public Integer getPrzomediooperd() {
        return przomediooperd;
    }

    /**
     * @param przomediooperd seta o novo valor para o campo przomediooperd
     */
    public void setPrzomediooperd(Integer przomediooperd) {
        this.przomediooperd = przomediooperd;
    }

    /**
     * @return o valor do dprevtdsembcmbio
     */
    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do vprevtdsembcmbio
     */
    public String getVprevtdsembcmbio() {
        return vprevtdsembcmbio;
    }

    /**
     * @param vprevtdsembcmbio seta o novo valor para o campo vprevtdsembcmbio
     */
    public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
        this.vprevtdsembcmbio = vprevtdsembcmbio;
    }

    /**
     * @return o valor do tdiacarenprinc
     */
    public Integer getTdiacarenprinc() {
        return tdiacarenprinc;
    }

    /**
     * @param tdiacarenprinc seta o novo valor para o campo tdiacarenprinc
     */
    public void setTdiacarenprinc(Integer tdiacarenprinc) {
        this.tdiacarenprinc = tdiacarenprinc;
    }

    /**
     * @return o valor do cfluxoliqdcprinc
     */
    public Integer getCfluxoliqdcprinc() {
        return cfluxoliqdcprinc;
    }

    /**
     * @param cfluxoliqdcprinc seta o novo valor para o campo cfluxoliqdcprinc
     */
    public void setCfluxoliqdcprinc(Integer cfluxoliqdcprinc) {
        this.cfluxoliqdcprinc = cfluxoliqdcprinc;
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

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}

	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public Integer getCindcdeconmc() {
		return cindcdeconmc;
	}

	public void setCindcdeconmc(Integer cindcdeconmc) {
		this.cindcdeconmc = cindcdeconmc;
	}

    public Integer getCpaisdsemb() {
        return cpaisdsemb;
    }

    public void setCpaisdsemb(Integer cpaisdsemb) {
        this.cpaisdsemb = cpaisdsemb;
    }

    public String getIpais() {
        return ipais;
    }

    public void setIpais(String ipais) {
        this.ipais = ipais;
    }
    
	public Integer getCpaismoedadsemb() {
		return cpaismoedadsemb;
	}
	
	public void setCpaismoedadsemb(Integer cpaismoedadsemb) {
		this.cpaismoedadsemb = cpaismoedadsemb;
	}
    
}
