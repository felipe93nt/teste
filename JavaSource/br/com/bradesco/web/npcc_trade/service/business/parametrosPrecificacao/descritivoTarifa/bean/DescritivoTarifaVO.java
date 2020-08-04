package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean;

import java.io.Serializable;
import java.util.Date;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;


/**
 * Nome: DescritivoTarifaVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : Bradesco S.A.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 */
public class DescritivoTarifaVO extends BaseVO implements Serializable,
		Cloneable, Comparable<DescritivoTarifaVO> {
	/**
	 * 
	 */
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 8396464401281842661L;

	/* CPRODT-SERVC PIC 9(008). */
	private Integer cprodtservc = null;

	/* DTINICI      PIC X(010). */ 
	private Date dtinici = null;

	/* DTFINAL      PIC X(010). */ 
	private Date dtfinal = null;
	
	/* CFUNCAO         PIC  X(001). */
	private String cfuncao = null;
	
	/* CCONDC-ECONC PIC 9(005). */
	private Integer ccondceconc = null;

	/* DCCOND-ECONC PIC X(050). */
	private String dccondeconc = null;

	/* DALTER PIC X(050) */
	private String dalter = null;

	// Indicador para o checkbox de descricao tarifa
	private boolean selecionada = false;

	// Indicador para o checkbox de alteracao
	private boolean operAlteracao = false;


	/**
	 * Construtor
	 * 
	 * @param
	 */
	public DescritivoTarifaVO() {
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
	 * @return o valor do selecionada
	 */
	public boolean isSelecionada() {
		return selecionada;
	}

	/**
	 * @param selecionada
	 *            seta o novo valor para o campo selecionada
	 */
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
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
	 */
	public DescritivoTarifaVO copy() {
		try {
			return (DescritivoTarifaVO) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

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
		if (otherObject instanceof DescritivoTarifaVO) {
			boolean equal = true;
			DescritivoTarifaVO instance = (DescritivoTarifaVO) otherObject;

			equal &= getCprodtservc() != null
					&& getCprodtservc().equals(instance.getCprodtservc());
			equal &= getCcondceconc() != null
					&& getCcondceconc().equals(instance.getCcondceconc());

			return equal;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(DescritivoTarifaVO next) {
		int thirdComparison = getDccondeconc().compareTo(next.getDccondeconc());
		int finalComparison = 0;

			finalComparison = thirdComparison;

		return finalComparison;
	}

	public boolean isOperAlteracao() {
		return operAlteracao;
	}

	public void setOperAlteracao(boolean operAlteracao) {
		this.operAlteracao = operAlteracao;
	}

	public String getDccondeconc() {
		return dccondeconc;
	}

	public void setDccondeconc(String dccondeconc) {
		this.dccondeconc = dccondeconc;
	}

	public String getDalter() {
		return dalter;
	}

	public void setDalter(String dalter) {
		this.dalter = dalter;
	}

	public Date getDtinici() {
		return dtinici;
	}

	public void setDtinici(Date dtinici) {
		this.dtinici = dtinici;
	}

	public Date getDtfinal() {
		return dtfinal;
	}

	public void setDtfinal(Date dtfinal) {
		this.dtfinal = dtfinal;
	}

	public String getCfuncao() {
		return cfuncao;
	}

	public void setCfuncao(String cfuncao) {
		this.cfuncao = cfuncao;
	}

}
