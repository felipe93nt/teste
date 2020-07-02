package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.utils.SiteUtil;

/**
 * @name GraosFibrasVO
 * @author Foursys
 * @see GraosFibrasVO.java
 * @version 1.0
 * @since 13/09/2018
 */
public class GraosFibrasVO implements Comparable<GraosFibrasVO>, Serializable {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = -4249591634209766512L;

	/**
	 * Atributo nomeProdutor Tipo String
	 */
	private String nomeProdutor = "";

	/**
	 * Atributo areaPropria Tipo AreaPropriaAgronegocioVO
	 */
	private AreaPropriaAgronegocioVO areaPropria = new AreaPropriaAgronegocioVO();
	/**
	 * Atributo areaPropriaSelecionado Tipo List<AreaPropriaAgronegocioVO>
	 */
	private List<AreaPropriaAgronegocioVO> areaPropriaSelecionado = new ArrayList<AreaPropriaAgronegocioVO>();
	/**
	 * Atributo listaAreaPropria Tipo List<AreaPropriaAgronegocioVO>
	 */
	private List<AreaPropriaAgronegocioVO> listaAreaPropria = new ArrayList<AreaPropriaAgronegocioVO>();
	
	private List<AreaPropriaAgronegocioVO> copiaListaAreaPropria = new ArrayList<AreaPropriaAgronegocioVO>();
	/**
	 * Atributo somaAreaTotalPropria Tipo String
	 */
	private String somaAreaTotalPropria = "";
	/**
	 * Atributo somaAreaProdutivaPropria Tipo String
	 */
	private String somaAreaProdutivaPropria = "";
	/**
	 * Atributo somaValorMercado Tipo String
	 */
	private String somaValorMercado = "";
	/**
	 * Atributo somaValorMercadoHectares Tipo String
	 */
	private String somaValorMercadoHectares = "";

	/**
	 * Atributo areaArrendada Tipo AreaArrendadaAgronegocioVO
	 */
	private AreaArrendadaAgronegocioVO areaArrendada = new AreaArrendadaAgronegocioVO();
	/**
	 * Atributo areaArrendadaSelecionado Tipo List<AreaArrendadaAgronegocioVO>
	 */
	private List<AreaArrendadaAgronegocioVO> areaArrendadaSelecionado = new ArrayList<AreaArrendadaAgronegocioVO>();
	/**
	 * Atributo listaAreaArrendada Tipo List<AreaArrendadaAgronegocioVO>
	 */
	private List<AreaArrendadaAgronegocioVO> listaAreaArrendada = new ArrayList<AreaArrendadaAgronegocioVO>();
	
	private List<AreaArrendadaAgronegocioVO> copiaListaAreaArrendada = new ArrayList<AreaArrendadaAgronegocioVO>();
	/**
	 * Atributo listaAreaArrendadaSelecionado Tipo
	 * List<AreaArrendadaAgronegocioVO>
	 */
	private List<AreaArrendadaAgronegocioVO> listaAreaArrendadaSelecionado = new ArrayList<AreaArrendadaAgronegocioVO>();
	/**
	 * Atributo somaAreaTotalArrendada Tipo String
	 */
	private String somaAreaTotalArrendada = "";
	/**
	 * Atributo somaAreaProdutivaArrendada Tipo String
	 */
	private String somaAreaProdutivaArrendada = "";
	/**
	 * Atributo somaCustoArrendamento Tipo String
	 */
	private String somaCustoArrendamento = "";

	/**
	 * Atributo graoSoja Tipo TipoGraoVO
	 */
	private TipoGraoVO graoSoja = new TipoGraoVO();
	/**
	 * Atributo graoMilho Tipo TipoGraoVO
	 */
	private TipoGraoVO graoMilho = new TipoGraoVO();
	/**
	 * Atributo fibraAlgodao Tipo FibrasVO
	 */
	private FibrasVO fibraAlgodao = new FibrasVO();
	
	//Totais Proprios Formatado
	public String getSomaAreaTotalPropriaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaAreaTotalPropria);
	}
	public String getSomaAreaProdutivaPropriaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaAreaProdutivaPropria);
	}
	public String getSomaValorMercadoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaValorMercado);
	}
	public String getSomaValorMercadoHectaresFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaValorMercadoHectares);
	}
	
	//Totais arrendado formatado
	public String getSomaAreaTotalArrendadaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaAreaTotalArrendada);
	}
	public String getSomaAreaProdutivaArrendadaFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(somaAreaProdutivaArrendada);
	}
	public String getSomaCustoArrendamentoFormatado() {
		return SiteUtil.getInstance().formatValoresUmaCasaToString(somaCustoArrendamento);
	}

	/**
	 * @return the nomeProdutor
	 */
	public String getNomeProdutor() {
		return nomeProdutor;
	}

	/**
	 * @param nomeProdutor
	 *            the nomeProdutor to set
	 */
	public void setNomeProdutor(String nomeProdutor) {
		this.nomeProdutor = nomeProdutor;
	}

	/**
	 * @return the areaPropria
	 */
	public AreaPropriaAgronegocioVO getAreaPropria() {
		return areaPropria;
	}

	/**
	 * @param areaPropria
	 *            the areaPropria to set
	 */
	public void setAreaPropria(AreaPropriaAgronegocioVO areaPropria) {
		this.areaPropria = areaPropria;
	}

	/**
	 * @return the areaPropriaSelecionado
	 */
	public List<AreaPropriaAgronegocioVO> getAreaPropriaSelecionado() {
		return areaPropriaSelecionado;
	}

	/**
	 * @param areaPropriaSelecionado
	 *            the areaPropriaSelecionado to set
	 */
	public void setAreaPropriaSelecionado(
			List<AreaPropriaAgronegocioVO> areaPropriaSelecionado) {
		this.areaPropriaSelecionado = areaPropriaSelecionado;
	}

	/**
	 * @return the listaAreaPropria
	 */
	public List<AreaPropriaAgronegocioVO> getListaAreaPropria() {
		return listaAreaPropria;
	}

	/**
	 * @param listaAreaPropria
	 *            the listaAreaPropria to set
	 */
	public void setListaAreaPropria(
			List<AreaPropriaAgronegocioVO> listaAreaPropria) {
		this.listaAreaPropria = listaAreaPropria;
	}
	
	public List<AreaPropriaAgronegocioVO> getCopiaListaAreaPropria() {
		return copiaListaAreaPropria;
	}

	public void setCopiaListaAreaPropria(
			List<AreaPropriaAgronegocioVO> copiaListaAreaPropria) {
		this.copiaListaAreaPropria = copiaListaAreaPropria;
	}

	/**
	 * @return the somaAreaTotalPropria
	 */
	public String getSomaAreaTotalPropria() {
		return somaAreaTotalPropria;
	}

	/**
	 * @param somaAreaTotalPropria
	 *            the somaAreaTotalPropria to set
	 */
	public void setSomaAreaTotalPropria(String somaAreaTotalPropria) {
		this.somaAreaTotalPropria = somaAreaTotalPropria;
	}

	/**
	 * @return the somaAreaProdutivaPropria
	 */
	public String getSomaAreaProdutivaPropria() {
		return somaAreaProdutivaPropria;
	}

	/**
	 * @param somaAreaProdutivaPropria
	 *            the somaAreaProdutivaPropria to set
	 */
	public void setSomaAreaProdutivaPropria(String somaAreaProdutivaPropria) {
		this.somaAreaProdutivaPropria = somaAreaProdutivaPropria;
	}

	/**
	 * @return the somaValorMercado
	 */
	public String getSomaValorMercado() {
		return somaValorMercado;
	}

	/**
	 * @param somaValorMercado
	 *            the somaValorMercado to set
	 */
	public void setSomaValorMercado(String somaValorMercado) {
		this.somaValorMercado = somaValorMercado;
	}

	/**
	 * @return the somaValorMercadoHectares
	 */
	public String getSomaValorMercadoHectares() {
		return somaValorMercadoHectares;
	}

	/**
	 * @param somaValorMercadoHectares
	 *            the somaValorMercadoHectares to set
	 */
	public void setSomaValorMercadoHectares(String somaValorMercadoHectares) {
		this.somaValorMercadoHectares = somaValorMercadoHectares;
	}

	/**
	 * @return the areaArrendada
	 */
	public AreaArrendadaAgronegocioVO getAreaArrendada() {
		return areaArrendada;
	}

	/**
	 * @param areaArrendada
	 *            the areaArrendada to set
	 */
	public void setAreaArrendada(AreaArrendadaAgronegocioVO areaArrendada) {
		this.areaArrendada = areaArrendada;
	}

	/**
	 * @return the areaArrendadaSelecionado
	 */
	public List<AreaArrendadaAgronegocioVO> getAreaArrendadaSelecionado() {
		return areaArrendadaSelecionado;
	}

	/**
	 * @param areaArrendadaSelecionado
	 *            the areaArrendadaSelecionado to set
	 */
	public void setAreaArrendadaSelecionado(
			List<AreaArrendadaAgronegocioVO> areaArrendadaSelecionado) {
		this.areaArrendadaSelecionado = areaArrendadaSelecionado;
	}

	/**
	 * @return the listaAreaArrendada
	 */
	public List<AreaArrendadaAgronegocioVO> getListaAreaArrendada() {
		return listaAreaArrendada;
	}

	/**
	 * @param listaAreaArrendada
	 *            the listaAreaArrendada to set
	 */
	public void setListaAreaArrendada(
			List<AreaArrendadaAgronegocioVO> listaAreaArrendada) {
		this.listaAreaArrendada = listaAreaArrendada;
	}
	
	public List<AreaArrendadaAgronegocioVO> getCopiaListaAreaArrendada() {
		return copiaListaAreaArrendada;
	}

	public void setCopiaListaAreaArrendada(
			List<AreaArrendadaAgronegocioVO> copiaListaAreaArrendada) {
		this.copiaListaAreaArrendada = copiaListaAreaArrendada;
	}

	/**
	 * @return the listaAreaArrendadaSelecionado
	 */
	public List<AreaArrendadaAgronegocioVO> getListaAreaArrendadaSelecionado() {
		return listaAreaArrendadaSelecionado;
	}

	/**
	 * @param listaAreaArrendadaSelecionado
	 *            the listaAreaArrendadaSelecionado to set
	 */
	public void setListaAreaArrendadaSelecionado(
			List<AreaArrendadaAgronegocioVO> listaAreaArrendadaSelecionado) {
		this.listaAreaArrendadaSelecionado = listaAreaArrendadaSelecionado;
	}

	/**
	 * @return the somaAreaTotalArrendada
	 */
	public String getSomaAreaTotalArrendada() {
		return somaAreaTotalArrendada;
	}

	/**
	 * @param somaAreaTotalArrendada
	 *            the somaAreaTotalArrendada to set
	 */
	public void setSomaAreaTotalArrendada(String somaAreaTotalArrendada) {
		this.somaAreaTotalArrendada = somaAreaTotalArrendada;
	}

	/**
	 * @return the somaAreaProdutivaArrendada
	 */
	public String getSomaAreaProdutivaArrendada() {
		return somaAreaProdutivaArrendada;
	}

	/**
	 * @param somaAreaProdutivaArrendada
	 *            the somaAreaProdutivaArrendada to set
	 */
	public void setSomaAreaProdutivaArrendada(String somaAreaProdutivaArrendada) {
		this.somaAreaProdutivaArrendada = somaAreaProdutivaArrendada;
	}

	/**
	 * @return the somaCustoArrendamento
	 */
	public String getSomaCustoArrendamento() {
		return somaCustoArrendamento;
	}

	/**
	 * @param somaCustoArrendamento
	 *            the somaCustoArrendamento to set
	 */
	public void setSomaCustoArrendamento(String somaCustoArrendamento) {
		this.somaCustoArrendamento = somaCustoArrendamento;
	}

	/**
	 * @return the graoSoja
	 */
	public TipoGraoVO getGraoSoja() {
		return graoSoja;
	}

	/**
	 * @param graoSoja
	 *            the graoSoja to set
	 */
	public void setGraoSoja(TipoGraoVO graoSoja) {
		this.graoSoja = graoSoja;
	}

	/**
	 * @return the graoMilho
	 */
	public TipoGraoVO getGraoMilho() {
		return graoMilho;
	}

	/**
	 * @param graoMilho
	 *            the graoMilho to set
	 */
	public void setGraoMilho(TipoGraoVO graoMilho) {
		this.graoMilho = graoMilho;
	}

	/**
	 * @return the fibraAlgodao
	 */
	public FibrasVO getFibraAlgodao() {
		return fibraAlgodao;
	}

	/**
	 * @param fibraAlgodao
	 *            the fibraAlgodao to set
	 */
	public void setFibraAlgodao(FibrasVO fibraAlgodao) {
		this.fibraAlgodao = fibraAlgodao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((areaArrendada == null) ? 0 : areaArrendada.hashCode());
		result = prime
				* result
				+ ((areaArrendadaSelecionado == null) ? 0
						: areaArrendadaSelecionado.hashCode());
		result = prime * result
				+ ((areaPropria == null) ? 0 : areaPropria.hashCode());
		result = prime
				* result
				+ ((areaPropriaSelecionado == null) ? 0
						: areaPropriaSelecionado.hashCode());
		result = prime * result
				+ ((fibraAlgodao == null) ? 0 : fibraAlgodao.hashCode());
		result = prime * result
				+ ((graoMilho == null) ? 0 : graoMilho.hashCode());
		result = prime * result
				+ ((graoSoja == null) ? 0 : graoSoja.hashCode());
		result = prime
				* result
				+ ((listaAreaArrendada == null) ? 0 : listaAreaArrendada
						.hashCode());
		result = prime
				* result
				+ ((listaAreaArrendadaSelecionado == null) ? 0
						: listaAreaArrendadaSelecionado.hashCode());
		result = prime
				* result
				+ ((listaAreaPropria == null) ? 0 : listaAreaPropria.hashCode());
		result = prime * result
				+ ((nomeProdutor == null) ? 0 : nomeProdutor.hashCode());
		result = prime
				* result
				+ ((somaAreaProdutivaArrendada == null) ? 0
						: somaAreaProdutivaArrendada.hashCode());
		result = prime
				* result
				+ ((somaAreaProdutivaPropria == null) ? 0
						: somaAreaProdutivaPropria.hashCode());
		result = prime
				* result
				+ ((somaAreaTotalArrendada == null) ? 0
						: somaAreaTotalArrendada.hashCode());
		result = prime
				* result
				+ ((somaAreaTotalPropria == null) ? 0 : somaAreaTotalPropria
						.hashCode());
		result = prime
				* result
				+ ((somaCustoArrendamento == null) ? 0 : somaCustoArrendamento
						.hashCode());
		result = prime
				* result
				+ ((somaValorMercado == null) ? 0 : somaValorMercado.hashCode());
		result = prime
				* result
				+ ((somaValorMercadoHectares == null) ? 0
						: somaValorMercadoHectares.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GraosFibrasVO)) {
			return false;
		}
		GraosFibrasVO other = (GraosFibrasVO) obj;
		if (areaArrendada == null) {
			if (other.areaArrendada != null) {
				return false;
			}
		} else if (!areaArrendada.equals(other.areaArrendada)) {
			return false;
		}
		if (areaArrendadaSelecionado == null) {
			if (other.areaArrendadaSelecionado != null) {
				return false;
			}
		} else if (!areaArrendadaSelecionado
				.equals(other.areaArrendadaSelecionado)) {
			return false;
		}
		if (areaPropria == null) {
			if (other.areaPropria != null) {
				return false;
			}
		} else if (!areaPropria.equals(other.areaPropria)) {
			return false;
		}
		if (areaPropriaSelecionado == null) {
			if (other.areaPropriaSelecionado != null) {
				return false;
			}
		} else if (!areaPropriaSelecionado.equals(other.areaPropriaSelecionado)) {
			return false;
		}
		if (fibraAlgodao == null) {
			if (other.fibraAlgodao != null) {
				return false;
			}
		} else if (!fibraAlgodao.equals(other.fibraAlgodao)) {
			return false;
		}
		if (graoMilho == null) {
			if (other.graoMilho != null) {
				return false;
			}
		} else if (!graoMilho.equals(other.graoMilho)) {
			return false;
		}
		if (graoSoja == null) {
			if (other.graoSoja != null) {
				return false;
			}
		} else if (!graoSoja.equals(other.graoSoja)) {
			return false;
		}
		if (listaAreaArrendada == null) {
			if (other.listaAreaArrendada != null) {
				return false;
			}
		} else if (!listaAreaArrendada.equals(other.listaAreaArrendada)) {
			return false;
		}
		if (listaAreaArrendadaSelecionado == null) {
			if (other.listaAreaArrendadaSelecionado != null) {
				return false;
			}
		} else if (!listaAreaArrendadaSelecionado
				.equals(other.listaAreaArrendadaSelecionado)) {
			return false;
		}
		if (listaAreaPropria == null) {
			if (other.listaAreaPropria != null) {
				return false;
			}
		} else if (!listaAreaPropria.equals(other.listaAreaPropria)) {
			return false;
		}
		if (nomeProdutor == null) {
			if (other.nomeProdutor != null) {
				return false;
			}
		} else if (!nomeProdutor.equals(other.nomeProdutor)) {
			return false;
		}
		if (somaAreaProdutivaArrendada == null) {
			if (other.somaAreaProdutivaArrendada != null) {
				return false;
			}
		} else if (!somaAreaProdutivaArrendada
				.equals(other.somaAreaProdutivaArrendada)) {
			return false;
		}
		if (somaAreaProdutivaPropria == null) {
			if (other.somaAreaProdutivaPropria != null) {
				return false;
			}
		} else if (!somaAreaProdutivaPropria
				.equals(other.somaAreaProdutivaPropria)) {
			return false;
		}
		if (somaAreaTotalArrendada == null) {
			if (other.somaAreaTotalArrendada != null) {
				return false;
			}
		} else if (!somaAreaTotalArrendada.equals(other.somaAreaTotalArrendada)) {
			return false;
		}
		if (somaAreaTotalPropria == null) {
			if (other.somaAreaTotalPropria != null) {
				return false;
			}
		} else if (!somaAreaTotalPropria.equals(other.somaAreaTotalPropria)) {
			return false;
		}
		if (somaCustoArrendamento == null) {
			if (other.somaCustoArrendamento != null) {
				return false;
			}
		} else if (!somaCustoArrendamento.equals(other.somaCustoArrendamento)) {
			return false;
		}
		if (somaValorMercado == null) {
			if (other.somaValorMercado != null) {
				return false;
			}
		} else if (!somaValorMercado.equals(other.somaValorMercado)) {
			return false;
		}
		if (somaValorMercadoHectares == null) {
			if (other.somaValorMercadoHectares != null) {
				return false;
			}
		} else if (!somaValorMercadoHectares
				.equals(other.somaValorMercadoHectares)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(GraosFibrasVO o) {
		return this.hashCode() - o.hashCode();
	}

}
