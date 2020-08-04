package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;
import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;


/**
 * Nome: FaixaOperacaoVO.java
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
public class FaixaOperacaoVO extends BaseVO implements Serializable,
		Cloneable, Comparable<FaixaOperacaoVO> {
	/**
	 * 
	 */
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 8396464401281842661L;

	// Valor De
	private String valorDe = null;

	// Valor Ate
	private String valorAte = null;
	
	// Banco
	private BanqueiroModalVO banco = null;
	

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public FaixaOperacaoVO() {
		super();
		banco = new BanqueiroModalVO();
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
	public FaixaOperacaoVO copy() {
		try {
			return (FaixaOperacaoVO) this.clone();
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
		if (otherObject instanceof FaixaOperacaoVO) {
			boolean equal = true;
			FaixaOperacaoVO instance = (FaixaOperacaoVO) otherObject;

			equal &=   getValorDe() == instance.getValorDe()
					&& getValorAte() == instance.getValorAte();

			return equal;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(FaixaOperacaoVO fo) {
		return SiteUtil.webMoedaToBigDecimal(this.getValorDe()).compareTo(SiteUtil.webMoedaToBigDecimal(fo.getValorDe()));
	}
		        
	public String getValorDe() {
		return valorDe;
	}

	public void setValorDe(String valorDe) {
		this.valorDe = valorDe;
	}

	public String getValorAte() {
		return valorAte;
	}

	public void setValorAte(String valorAte) {
		this.valorAte = valorAte;
	}

	public BanqueiroModalVO getBanco() {
		return banco;
	}

	public void setBanco(BanqueiroModalVO banco) {
		this.banco = banco;
	}

}
