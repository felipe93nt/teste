/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 * Nome: ComboPaisVO.java
 * 
 * Propósito: Campos de pais
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class ComboPaisVO {

    /**
     * Construtor
     * 
     * @param
     */
    public ComboPaisVO() {
        super();
    }

    /** CODIGO PAIS AGEO - PIC 9(005) */
    private Integer cdpaisageo = null;

    /** NOME DO PAIS - PIC X(060). */
    private String nomepais = null;

    /** CODIGO DO PAIS BACEN - PIC X(010). */
    private String cdpaisbacen = null;
    
	private String cindcdriscoestrg = null;

	private String cindcdlvgemdinhe = null;

	private String cindcdprisofscal = null;

    public String getCindcdriscoestrg() {
		return cindcdriscoestrg;
	}

	public void setCindcdriscoestrg(String cindcdriscoestrg) {
		this.cindcdriscoestrg = cindcdriscoestrg;
	}

	public String getCindcdlvgemdinhe() {
		return cindcdlvgemdinhe;
	}

	public void setCindcdlvgemdinhe(String cindcdlvgemdinhe) {
		this.cindcdlvgemdinhe = cindcdlvgemdinhe;
	}

	public String getCindcdprisofscal() {
		return cindcdprisofscal;
	}

	public void setCindcdprisofscal(String cindcdprisofscal) {
		this.cindcdprisofscal = cindcdprisofscal;
	}

	/**
     * @return the cdpaisageo
     */
    public Integer getCdpaisageo() {
        return cdpaisageo;
    }

    /**
     * @param cdpaisageo the cdpaisageo to set
     */
    public void setCdpaisageo(Integer cdpaisageo) {
        this.cdpaisageo = cdpaisageo;
    }

    /**
     * @return the nomepais
     */
    public String getNomepais() {
        return nomepais;
    }

    /**
     * @param nomepais the nomepais to set
     */
    public void setNomepais(String nomepais) {
        this.nomepais = nomepais;
    }

    /**
     * @return the cdpaisbacen
     */
    public String getCdpaisbacen() {
        return cdpaisbacen;
    }

    /**
     * @param cdpaisbacen the cdpaisbacen to set
     */
    public void setCdpaisbacen(String cdpaisbacen) {
        this.cdpaisbacen = cdpaisbacen;
    }

    
}
