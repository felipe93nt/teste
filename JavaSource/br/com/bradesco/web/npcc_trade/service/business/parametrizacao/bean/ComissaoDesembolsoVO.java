package br.com.bradesco.web.npcc_trade.service.business.parametrizacao.bean;

import java.io.Serializable;
import java.math.BigDecimal;


import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;


/**
 * Nome: ComissaoDesembolsoVO.java
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
public class ComissaoDesembolsoVO extends BaseVO implements Serializable,
		Cloneable, Comparable<ComissaoDesembolsoVO> {
	/**
	 * 
	 */
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 8396464401281842661L;

	/* FUNCAO               PIC X(001) */
	private String funcao = null;

	/* CINDCD-ECONM-MOEDA   PIC 9(005).  */
	private Integer cindcdeconmmoeda = null;
	
	/* DESCR-ECONM-MOEDA    PIC X(044).  */
	private String descreconmmoeda = null;
	
	/* CPRODT-SERVC         PIC 9(008) */ 
	private Integer cprodtservc = null;
	
	/* CPRODT-DESC          PIC X(060). */
	private String cprodtdesc = null;

	/*  VLIM-COMIS-FIXA      PIC 9(015)V99.  */ 
	private String vlimcomisfixa = null;
	
	/* VCOMIS-FIXA          PIC 9(015)V99.  */
	private String vcomisfixa = null;

	/* HMANUT-REG           PIC X(026). */
	//private String hmanutreg = null;

//	// Indicador para o checkbox de descricao tarifa
//	private boolean selecionada = false;
//
//	// Indicador para o checkbox de alteracao
//	private boolean operAlteracao = false;
//

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public ComissaoDesembolsoVO() {
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
	public ComissaoDesembolsoVO copy() {
		try {
			return (ComissaoDesembolsoVO) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

//		if (getRprodtservc() != null) {
//			buffer.append(String.format("[%d] %s - ", getCprodtservc(),
//					getRprodtservc()));
//		}

		// Verifica se há conteúdo para exibir
		if (buffer.length() > 0) {
			return buffer.substring(buffer.lastIndexOf("-"));
		} else {
			return super.toString();
		}
	}

//	@Override
//	public boolean equals(Object otherObject) {
//		// Verifica se o objeto não é nulo ou se há dados para comparar
//		if (otherObject == null) {
//			return false;
//		}
//
//		// Verifica se o objeto passado é uma instancia válida para comparar
//		if (otherObject instanceof ComissaoDesembolsoVO) {
//			boolean equal = true;
//			ComissaoDesembolsoVO instance = (ComissaoDesembolsoVO) otherObject;
//
//			equal &= getCprodtservc() != null
//					&& getCprodtservc().equals(instance.getCprodtservc());
//			equal &= getCcondceconc() != null
//					&& getCcondceconc().equals(instance.getCcondceconc());
//
//			return equal;
//		} else {
//			return false;
//		}
//	}

	@Override
	public int compareTo(ComissaoDesembolsoVO next) {
		final int EQUAL = 0;
		
		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
		//Validar com Renan
		int firstComparison = getCprodtservc().compareTo(next.getCprodtservc());
		int thirdComparison = getCindcdeconmmoeda().compareTo(next.getCindcdeconmmoeda());
		int finalComparison = 0;

		// Segue a ordem de prioridade e retorna o resultado da comparação
		if (firstComparison != EQUAL) {
			finalComparison = firstComparison;
		} else {
			finalComparison = thirdComparison;
		}

		return finalComparison;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getDescreconmmoeda() {
		return descreconmmoeda;
	}

	public void setDescreconmmoeda(String descreconmmoeda) {
		this.descreconmmoeda = descreconmmoeda;
	}

	public String getCprodtdesc() {
		return cprodtdesc;
	}

	public void setCprodtdesc(String cprodtdesc) {
		this.cprodtdesc = cprodtdesc;
	}

	public String getVlimcomisfixa() {
		return vlimcomisfixa;
	}

	public void setVlimcomisfixa(String vlimcomisfixa) {
		this.vlimcomisfixa = vlimcomisfixa;
	}

	public String getVcomisfixa() {
		return vcomisfixa;
	}

	public void setVcomisfixa(String vcomisfixa) {
		this.vcomisfixa = vcomisfixa;
	}




}
