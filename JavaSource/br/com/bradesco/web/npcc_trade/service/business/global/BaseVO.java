/**
*
* Nome: BaseVO.java
* Propósito: Fornecer atributos base para todos os VO<p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 08/07/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.global;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSituacao;


/**
 *
 * Nome: BaseVO.java
 * Propósito: <p>Fornecer atributos base para todos os VO </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 08/07/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public abstract class BaseVO {

	/** CODIGO SITUACAO ATIVO */
	private Integer ntpositcmbio = null;
	
	/** DESCRICAO SITUACAO ATIVO */
	private EnumSituacao rtpositcmbio = null;
	
	/** DESCRICAO MOTIVO */
	private String rjustfsitcmbio = null;
	
	/** CODIGO USUARIO DE INCLUSAO */
	private String cusuarincl = null;
	
	/** NOME USUARIO DE INCLUSAO */
	private String iusuarincl = null;
	
	/** HORA DE INCLUSAO */
	private String hinclreg = null;
	
	/** CODIGO USUARIO DE MANUTENCAO */
	private String cusuarmanut = null;
	
	/** NOME USUARIO DE MANUTENCAO */
	private String iusuarmanut = null;
	
	/** HORA DA MANUTENCAO */
	private String hmanutreg = null;
	
	/** CÓDIGO TIPO DE MANUTENÇÃO. */
	private String cindcdtpomanut = null;

	/** HORA DE INCLUSAO HISTÓRICO. */
	private String hinclreghist = null;
	
	/**
	 * Método construtor da classe. 
	 */
	public BaseVO() {
		super();
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
     * @return o valor do iusuarincl
     */
    public String getIusuarincl() {
        return iusuarincl;
    }

    /**
     * @param iusuarincl seta o novo valor para o campo iusuarincl
     */
    public void setIusuarincl(String iusuarincl) {
        this.iusuarincl = iusuarincl;
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
     * @return o valor do iusuarmanut
     */
    public String getIusuarmanut() {
        return iusuarmanut;
    }

    /**
     * @param iusuarmanut seta o novo valor para o campo iusuarmanut
     */
    public void setIusuarmanut(String iusuarmanut) {
        this.iusuarmanut = iusuarmanut;
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
     * @return the rtpositcmbio
     */
    public EnumSituacao getRtpositcmbio() {
        if(!SiteUtil.isEmptyOrNull(this.ntpositcmbio))
            this.rtpositcmbio = EnumSituacao.fromCode(this.ntpositcmbio);
        return this.rtpositcmbio;
    }

    /**
     * @param rtpositcmbio2 the rtpositcmbio to set
     */
    public void setRtpositcmbio(EnumSituacao rtpositcmbio) {
        this.rtpositcmbio = rtpositcmbio;
    }

	/**
	 * @return o valor do cindcdtpomanut
	 */
	public String getCindcdtpomanut() {
		return cindcdtpomanut;
	}

	/**
	 * @param cindcdtpomanut seta o novo valor para o campo cindcdtpomanut
	 */
	public void setCindcdtpomanut(String cindcdtpomanut) {
		this.cindcdtpomanut = cindcdtpomanut;
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
	 * @return o valor do hinclregformated
	 */
	public String getHinclregformated() {
		return SiteUtil.dateTimeMainframeToWeb(hinclreg);
	}
	
	/**
	 * @return o valor do hmanutregformated
	 */
	public String getHmanutregformated() {
		return SiteUtil.dateTimeMainframeToWeb(hmanutreg);
	}
	
	 /**
     * @return o valor do hinclreghistformated
     */
    public String getHinclreghistformated() {
        return SiteUtil.dateTimeMainframeToWeb(hinclreghist);
    }

}
