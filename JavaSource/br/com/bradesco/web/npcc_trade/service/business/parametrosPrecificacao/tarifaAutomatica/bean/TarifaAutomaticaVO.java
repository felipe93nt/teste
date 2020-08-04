package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;

/**
 * Nome: TarifaAutomaticaVO.java
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
public class TarifaAutomaticaVO extends BaseVO implements Serializable,
		Cloneable, Comparable<TarifaAutomaticaVO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2481288771232889994L;
	
	private static String param;
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	/* CPRODT-SERVC PIC 9(008). */
	private Integer cprodtservc = null;

	/* RPRODT-SERVC PIC X(100). */
	private String rprodtservc = null;

	/* COPER PIC 9(005). */
	private Integer coper = null;

	/* ROPER PIC X(060). */
	private String roper = null;

	/* CCONDC-ECONC PIC 9(005). */
	private Integer ccondceconc = null;

	/* ICONDC-ECONC PIC X(060). */
	private String icondceconc = null;

	/* IND-AUT PIC X(001). */
	private String indaut = null;

	// Indicador para o checkbox de tarifa automatica
	private boolean automatica = false;

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public TarifaAutomaticaVO() {
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
	 * @return o valor do ccondceconc
	 */
	public Integer getCcondceconc() {
		return ccondceconc;
	}

	/**
	 * @param ccondceconc
	 *            seta o novo valor para o campo ccondceconc
	 */
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	/**
	 * @return o valor do icondceconc
	 */
	public String getIcondceconc() {
		return icondceconc;
	}

	/**
	 * @param icondceconc
	 *            seta o novo valor para o campo icondceconc
	 */
	public void setIcondceconc(String icondceconc) {
		this.icondceconc = icondceconc;
	}

	/**
	 * @return o valor do indaut
	 */
	public String getIndaut() {
		return indaut;
	}

	/**
	 * @param indaut
	 *            seta o novo valor para o campo indaut
	 */
	public void setIndaut(String indaut) {
		this.indaut = indaut;
	}

	/**
	 * @return o valor do automatica
	 */
	public boolean isAutomatica() {
		return automatica;
	}

	/**
	 * @param automatica
	 *            seta o novo valor para o campo automatica
	 */
	public void setAutomatica(boolean automatica) {
		this.automatica = automatica;
	}

	/**
	 * Nome: copy
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 14/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public TarifaAutomaticaVO copy() {
		try {
			return (TarifaAutomaticaVO) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		if (getRprodtservc() != null) {
			buffer.append(String.format("[%d] %s - ", getCprodtservc(),
					getRprodtservc()));
		}

		if (getRoper() != null) {
			buffer.append(String.format("[%d] %s - ", getCoper(), getRoper()));
		}

		if (getIcondceconc() != null) {
			buffer.append(String.format("[%d] %s - ", getCcondceconc(),
					getIcondceconc()));
		}

		// Verifica se há conteúdo para exibir
		if (buffer.length() > 0) {
			return buffer.substring(buffer.lastIndexOf("-"));
		} else {
			return super.toString();
		}
	}

	@Override
	public boolean equals(Object otherObject) {
		// Verifica se o objeto não é nulo ou se há dados para comparar
		if (otherObject == null) {
			return false;
		}

		// Verifica se o objeto passado é uma instancia válida para comparar
		if (otherObject instanceof TarifaAutomaticaVO) {
			boolean equal = true;
			TarifaAutomaticaVO instance = (TarifaAutomaticaVO) otherObject;

			equal &= getCprodtservc() != null
					&& getCprodtservc().equals(instance.getCprodtservc());
			equal &= getCoper() != null
					&& getCoper().equals(instance.getCoper());
			equal &= getCcondceconc() != null
					&& getCcondceconc().equals(instance.getCcondceconc());

			return equal;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(TarifaAutomaticaVO next) {
		final int EQUAL = 0;

		int firstComparison = getRprodtservc().compareTo(next.getRprodtservc());
		int secondComparison = getRoper().compareTo(next.getRoper());
		int thirdComparison = getIcondceconc().compareTo(next.getIcondceconc());
		int finalComparison = 0;

		// Segue a ordem de prioridade e retorna o resultado da comparação
		if (firstComparison != EQUAL) {
			finalComparison = firstComparison;
		} else if (secondComparison != EQUAL) {
			finalComparison = secondComparison;
		} else {
			finalComparison = thirdComparison;
		}

		return finalComparison;
	}
}
