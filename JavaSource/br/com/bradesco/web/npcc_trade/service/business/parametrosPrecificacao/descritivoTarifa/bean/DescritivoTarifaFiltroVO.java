package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Nome: DescritivoTarifaFiltroVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 14/06/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class DescritivoTarifaFiltroVO implements Serializable {
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 6433157229653497162L;

	/* CPRODT-SERVC PIC 9(008). */
	private Integer cprodtservc = 0;

	/* RPRODT-SERVC PIC X(030). */
	private String rprodtservc = null;

	/* COPER PIC 9(005). */
	private Integer coper = 0;

	/* ROPER PIC X(030). */
	private String roper = null;

	private Date inicio;

	private Date fim;

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public DescritivoTarifaFiltroVO() {
		super();
	}

	/**
	 * @return o valor do cprodtservc
	 */
	public Integer getCprodtservc() {
		return cprodtservc;
	}

	/**
	 * @param cprodtservc
	 *            seta o novo valor para o campo cprodtservc
	 */
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	/**
	 * @return o valor do rprodtservc
	 */
	public String getRprodtservc() {
		return rprodtservc;
	}

	/**
	 * @param rprodtservc
	 *            seta o novo valor para o campo rprodtservc
	 */
	public void setRprodtservc(String rprodtservc) {
		this.rprodtservc = rprodtservc;
	}

	/**
	 * @return o valor do coper
	 */
	public Integer getCoper() {
		return coper;
	}

	/**
	 * @param coper
	 *            seta o novo valor para o campo coper
	 */
	public void setCoper(Integer coper) {
		this.coper = coper;
	}

	/**
	 * @return o valor do roper
	 */
	public String getRoper() {
		return roper;
	}

	/**
	 * @param roper
	 *            seta o novo valor para o campo roper
	 */
	public void setRoper(String roper) {
		this.roper = roper;
	}

	/**
	 * @return o valor do inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            seta o novo valor para o campo inicio
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return o valor do fim
	 */
	public Date getFim() {
		return fim;
	}

	/**
	 * @param fim
	 *            seta o novo valor para o campo fim
	 */
	public void setFim(Date fim) {
		this.fim = fim;
	}
}
