package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;


/**
 * Nome: ParametroUnidadeExternaVO.java
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
public class ParametroUnidadeExternaVO extends BaseVO implements Serializable,
		Cloneable, Comparable<ParametroUnidadeExternaVO> {
	/**
	 * 
	 */
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 8396464401281842661L;

	/* CPRODT-SERVC PIC 9(008). */
	private Integer cprodtservc = null;
	
	/* descricao do Produto */
	private String descProduto = null;
	
	/* MOEDA */
	private Integer cindcdeconmmoeda = null;

	/* descricao da moeda */
	private String descMoeda = null;
	
	// Valor autorizado por produto
	private String valorAutorizadoPorProduto = null;
	
	// Swift code
	private String cidbanqrswift = null;

	// Nome Banqueiro
	private String ibanqrcmbio = null;
	
	// Valor da moeda estrangeira (utilizado somente para filtro)
	private String vnegocmoedaestrg = null;
	
	// funçao (I, A, E)
	private String funcao = null;
	
	// tipo de pesquisa do Banqueiro
	private int tipoPesquisaBanqueiro = 0;
	
	private List<FaixaOperacaoVO> listaFaixaOperacao = new ArrayList<FaixaOperacaoVO>();
	

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public ParametroUnidadeExternaVO() {
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
	public ParametroUnidadeExternaVO copy() {
		try {
			return (ParametroUnidadeExternaVO) this.clone();
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
		if (otherObject instanceof ParametroUnidadeExternaVO) {
			boolean equal = true;
			ParametroUnidadeExternaVO instance = (ParametroUnidadeExternaVO) otherObject;

			equal &= getCprodtservc() != null
					&& getCprodtservc().equals(instance.getCprodtservc())
					&& getCindcdeconmmoeda().equals(instance.getCindcdeconmmoeda());

			return equal;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(ParametroUnidadeExternaVO next) {
		int finalComparison = 0;

		return finalComparison;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getValorAutorizadoPorProduto() {
		return valorAutorizadoPorProduto;
	}

	public void setValorAutorizadoPorProduto(String valorAutorizadoPorProduto) {
		this.valorAutorizadoPorProduto = valorAutorizadoPorProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getDescMoeda() {
		return descMoeda;
	}

	public void setDescMoeda(String descMoeda) {
		this.descMoeda = descMoeda;
	}

	public int getTipoPesquisaBanqueiro() {
		return tipoPesquisaBanqueiro;
	}

	public void setTipoPesquisaBanqueiro(int tipoPesquisaBanqueiro) {
		this.tipoPesquisaBanqueiro = tipoPesquisaBanqueiro;
	}

	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}

	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	public String getCidbanqrswift() {
		return cidbanqrswift;
	}

	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	public List<FaixaOperacaoVO> getListaFaixaOperacao() {
		return listaFaixaOperacao;
	}

	public void setListaFaixaOperacao(List<FaixaOperacaoVO> listaFaixaOperacao) {
		this.listaFaixaOperacao = listaFaixaOperacao;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}

	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

}
