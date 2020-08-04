package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean;

import java.io.Serializable;
import java.util.MissingResourceException;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

public class TradeFinanceLogDiferencasVo implements Serializable {
    
	private static final long serialVersionUID = 1L;

	/*Nome do campo*/
    private String titulo = null;
    
    /*Valor Antes*/
    private String antes = null;
    
    /*Valor Depois*/
    private String depois = null;
    
    /*Indicador se houve alteração*/
    private Boolean houveAlteracao = null;

    
    /*Construtores*/
    
    public TradeFinanceLogDiferencasVo() {
        super();
    }
    
    public TradeFinanceLogDiferencasVo(String bundleKey) {
        this();
        
        if (!SiteUtil.isEmptyOrNull(bundleKey)) {
            try {
                this.titulo = SiteUtil.getBundleValue(bundleKey);
            } catch (MissingResourceException e) {
                this.titulo = null;
            }
        }
    }
    
    public TradeFinanceLogDiferencasVo(Object antes, Object depois) {
        this();
        
        if (antes != null) {
            this.antes = antes.toString();
        }
        
        if (depois != null) {
            this.depois = depois.toString(); 
        }        
    }
    
    public TradeFinanceLogDiferencasVo(Object antes, Object depois, boolean houveAlteracao) {
        this(antes, depois);
        
        this.houveAlteracao = houveAlteracao;
    }
    
    public TradeFinanceLogDiferencasVo(String bundleKey, Object antes, Object depois) {
        this(antes, depois);
        
        try {
            this.titulo = SiteUtil.getBundleValue(bundleKey);
        } catch (MissingResourceException e) {
            this.titulo = null;
        }
    }
    
    public TradeFinanceLogDiferencasVo(String bundleKey, Object antes, Object depois, boolean houveAlteracao) {
        this(bundleKey, antes, depois);
           
        this.houveAlteracao = houveAlteracao;
    }
    
    /*Métodos*/
        
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAntes() {
		return antes;
	}

	public void setAntes(String antes) {
		this.antes = antes;
	}

	public String getDepois() {
		return depois;
	}

	public void setDepois(String depois) {
		this.depois = depois;
	}

	public Boolean getHouveAlteracao() {
		return houveAlteracao;
	}

	public void setHouveAlteracao(Boolean houveAlteracao) {
		this.houveAlteracao = houveAlteracao;
	}

    
}