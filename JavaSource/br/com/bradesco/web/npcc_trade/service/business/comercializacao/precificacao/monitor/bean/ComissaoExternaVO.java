package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;

public class ComissaoExternaVO implements IComissaoExterna {
	
    /** 
     * TIPO COMISSAO - ADICIONAL ou BANQUEIRO
     */
    private EnumTipoComissao tipoComissao;
    private Integer crespcomisexter = 0;
    
    /**
     * CONDIÇÃO PARA EXIBIR VALOR OU TAXA
     */
    private Boolean renderValor = false;
    
    /**
     * CONDIÇÃO PARA EXIBIR MOEDA
     */
    private Boolean renderMoeda = false;
    
    private Boolean renderTipoPeriodo = false;
    
	/**
	 * NUMERO DA COMISSAO EXTERNA
	 */
	private Integer ncomisextertrade;
	
	/**
	 * TIPO DA COMISSAO EXTERNA
	 */
	private Integer ccondceconc;
	
	/**
	 * NOME TIPO DA COMISSAO EXTERNA
	 */
	private String icondeconc;  
	
	/**
	 * VALOR DA COMISSAO EXTERNA
	 */
	private String vpcelacomiscmbio;
	
	/**
	 * TAXA %
	 */
	private String pcomisnegoccmbio;
	
	/**
	 * CODIGO PERIODO JURO CAMBIO
	 */
	private Integer cperdcjurocmbio;
	
	/**
	 * DESCRICAO PERIODO JURO CAMBIO
	 */
	private String iperdcjurocmbio;
	
	/**
	 * CODIGO DA MOEDA
	 */
	private Integer cindcdeconmmoeda;
	
	/**
	 * FORMATAR O VALOR MOEDA -CINDCD-ECONM-MOEDA + -ISGL-INDCD-FONTE
	 */
	private String formataValorMoeda;

	/**
	 * SIMBOLO DA MOEDA
	 */
	private String isglindcdfonte;  

	/**
	 * SIMBOLO DA MOEDA
	 */
	private String formatasglindcdfonte;  
	
	/**
	 * CODIGO DA PERIODICIDADE
	 */
	private Integer cfluxoperdccmbio;
	
	/**
	 * DESCRICAO PERIODICIDADE
	 */
	private String ifluxoperdccmbio;
	
	/**
	 * CODIGO DO MOMENTO
	 */
	private Integer cmomencobrcmbio;
	
	/**
	 * QTDE PARCELAS
	 */
	private Integer qpcelacmbiotrade;
	
	/**
	 * NUMERO DA  PARCELA
	 */
	private Integer npcelacomisexter;
	
	/**
	 * DATA VENCIMENTO PARCELA
	 */
	private String  dvctopcelatrade;
	
	/**
	 * PRAZO DA PARCELA
	 */
	private Integer prazoparcela;
	
	/**
	 * DESCRICAO MOMENTO
	 */
	private String descrmomento;
	
	/**
     * From List
     */
    private Boolean fromList = Boolean.FALSE;
	
	private List<ComissaoExternaVO> lista = new ArrayList<ComissaoExternaVO>();


	public Integer getncomisextertrade() {
		return ncomisextertrade;
	}

	public void setncomisextertrade(Integer ncomisextertrade) {
		this.ncomisextertrade = ncomisextertrade;
	}

	public Integer getccondceconc() {
		return ccondceconc;
	}

	public void setccondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	public String geticondeconc() {
		return icondeconc;
	}

	public void seticondeconc(String icondeconc) {
		this.icondeconc = icondeconc;
	}

	public String getvpcelacomiscmbio() {
		return vpcelacomiscmbio;
	}

	public void setvpcelacomiscmbio(String vpcelacomiscmbio) {
		this.vpcelacomiscmbio = vpcelacomiscmbio;
	}

	public String getpcomisnegoccmbio() {
		return pcomisnegoccmbio;
	}

	public void setpcomisnegoccmbio(String pcomisnegoccmbio) {
		this.pcomisnegoccmbio = pcomisnegoccmbio;
	}

	public Integer getcperdcjurocmbio() {
		return cperdcjurocmbio;
	}

	public void setcperdcjurocmbio(Integer cperdcjurocmbio) {
		this.cperdcjurocmbio = cperdcjurocmbio;
	}

	public String getiperdcjurocmbio() {
		return iperdcjurocmbio;
	}

	public void setiperdcjurocmbio(String iperdcjurocmbio) {
		this.iperdcjurocmbio = iperdcjurocmbio;
	}

	public Integer getcindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setcindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getisglindcdfonte() {
		return isglindcdfonte;
	}

	public void setisglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	public Integer getcfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}

	public void setcfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public String getifluxoperdccmbio() {
		return ifluxoperdccmbio;
	}

	public void setifluxoperdccmbio(String ifluxoperdccmbio) {
		this.ifluxoperdccmbio = ifluxoperdccmbio;
	}

	public Integer getcmomencobrcmbio() {
		return cmomencobrcmbio;
	}

	public void setcmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}

	public Integer getqpcelacmbiotrade() {
		return qpcelacmbiotrade;
	}

	public void setqpcelacmbiotrade(Integer qpcelacmbiotrade) {
		this.qpcelacmbiotrade = qpcelacmbiotrade;
	}

	public Integer getnpcelacomisexter() {
		return npcelacomisexter;
	}

	public void setnpcelacomisexter(Integer npcelacomisexter) {
		this.npcelacomisexter = npcelacomisexter;
	}

	public String getdvctopcelatrade() {
		return dvctopcelatrade;
	}

	public void setdvctopcelatrade(String dvctopcelatrade) {
		this.dvctopcelatrade = dvctopcelatrade;
	}

	public Integer getprazoparcela() {
		return prazoparcela;
	}

	public void setprazoparcela(Integer prazoparcela) {
		this.prazoparcela = prazoparcela;
	}

	public List<ComissaoExternaVO> getLista() {
		return lista;
	}

	public void setLista(List<ComissaoExternaVO> lista) {
		this.lista = lista;
	}

	public String getdescrmomento() {
		return descrmomento;
	}

	public void setdescrmomento(String descrmomento) {
		this.descrmomento = descrmomento;
	}

    /**
     * @return o valor do fromList
     */
    public Boolean getFromList() {
        return fromList;
    }

    /**
     * @param fromList seta o novo valor para o campo fromList
     */
    public void setFromList(Boolean fromList) {
        this.fromList = fromList;
    }

    /**
     * @return o valor do formataValorMoeda
     */
    public String getFormataValorMoeda() {
        
       if(isglindcdfonte != null ) {
           return cindcdeconmmoeda + "-" + isglindcdfonte;
       }
       
       return formataValorMoeda;
    }

    /**
     * @param formataValorMoeda seta o novo valor para o campo formataValorMoeda
     */
    public void setFormataValorMoeda(String formataValorMoeda) {
        this.formataValorMoeda = formataValorMoeda;
    }

	/**
	 * @return the formataSglindcdfonte
	 */
	public String getFormataSglindcdfonte() {
		formatasglindcdfonte = isglindcdfonte;
		formatasglindcdfonte = formatasglindcdfonte.substring(formatasglindcdfonte.indexOf("-") + 1).trim();
		
		return formatasglindcdfonte;
	}

	/**
	 * @param formataSglindcdfonte the formataSglindcdfonte to set
	 */
	public void setFormataSglindcdfonte(String formatasglindcdfonte) {
		this.formatasglindcdfonte = formatasglindcdfonte;
	}

    /**
     * @return o valor do tipoComissao
     */
    public EnumTipoComissao getTipoComissao() {
        if(!SiteUtil.isEmptyOrNull(this.crespcomisexter))
            this.tipoComissao = EnumTipoComissao.fromCode(this.crespcomisexter);
        return tipoComissao;
    }

    /**
     * @param tipoComissao seta o novo valor para o campo tipoComissao
     */
    public void setTipoComissao(EnumTipoComissao tipoComissao) {
        if(tipoComissao != null)
            this.crespcomisexter = tipoComissao.getCodigo();
        this.tipoComissao = tipoComissao;
    }

    /**
     * @return o valor do crespcomisexter
     */
    public Integer getCrespcomisexter() {
        return crespcomisexter;
    }

    /**
     * @param crespcomisexter seta o novo valor para o campo crespcomisexter
     */
    public void setCrespcomisexter(Integer crespcomisexter) {
        this.crespcomisexter = crespcomisexter;
    }

    /**
     * @return the renderValor
     */
    public Boolean getRenderValor() {
        return renderValor;
    }

    /**
     * @param renderValor the renderValor to set
     */
    public void setRenderValor(Boolean renderValor) {
        this.renderValor = renderValor;
    }

    /**
     * @return the renderMoeda
     */
    public Boolean getRenderMoeda() {
        return renderMoeda;
    }

    /**
     * @param renderMoeda the renderMoeda to set
     */
    public void setRenderMoeda(Boolean renderMoeda) {
        this.renderMoeda = renderMoeda;
    }

    /**
     * @return the renderTipoPeriodo
     */
    public Boolean getRenderTipoPeriodo() {
        return renderTipoPeriodo;
    }

    /**
     * @param renderTipoPeriodo the renderTipoPeriodo to set
     */
    public void setRenderTipoPeriodo(Boolean renderTipoPeriodo) {
        this.renderTipoPeriodo = renderTipoPeriodo;
    }
    
    
}
