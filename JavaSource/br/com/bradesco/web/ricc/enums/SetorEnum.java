/**
 * @name br.com.bradesco.web.ricc.enums
 */
package br.com.bradesco.web.ricc.enums;

import java.util.HashMap;
import java.util.Map;

import br.com.bradesco.web.ricc.utils.RiccConstants;

/**
 * @name SetorEnum
 * @author Foursys
 * @see SetorEnum.java
 * @version 1.0
 * @since 11/09/2018
 */
public enum SetorEnum {
	AGRONEGOCIO(1, "Agronegócio", 
			RiccConstants.BEAN_QUESTIONARIO_AGRONEGOCIO, 
			RiccConstants.BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO, 
			RiccConstants.TELA_QUESTIONARIO_AGRONEGOCIO, 
			RiccConstants.TELA_CONSULTA_QUESTIONARIO_AGRONEGOCIO, 
			"label_agronegocio"),
	IMOBILIARIO(2, "Imobiliário", 
			RiccConstants.BEAN_QUESTIONARIO_IMOBILIARIO, 
			RiccConstants.BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO, 
			RiccConstants.TELA_QUESTIONARIO_IMOBILIARIO, 
			RiccConstants.TELA_CONSULTA_QUESTIONARIO_IMOBILIARIO, 
			"label_imobiliario"),
	PROJETOS(3, "Projetos", 
			RiccConstants.BEAN_QUESTIONARIO_PROJETOS, 
			RiccConstants.BEAN_CONSULTA_QUESTIONARIO_PROJETOS, 
			RiccConstants.TELA_QUESTIONARIO_PROJETO, 
			RiccConstants.TELA_CONSULTA_QUESTIONARIO_PROJETO, 
			"label_projetos"),
	TRANSPORTE(4, "Transportes", 
			RiccConstants.BEAN_QUESTIONARIO_TRANSPORTES, 
			RiccConstants.BEAN_CONSULTA_QUESTIONARIO_TRANSPORTES, 
			RiccConstants.TELA_QUESTIONARIO_TRANSPORTES, 
			RiccConstants.TELA_CONSULTA_QUESTIONARIO_TRANSPORTES, 
			"label_transportes");

	/**
	 * Atributo codSetor 
	 * Tipo String
	 */
	private Integer codigo = null;
	private String descricao = null;
	private String beanTelaManutencao = null;
	private String beanTelaConsulta = null;
	private String tilesTelaManutencao = null;
	private String tilesTelaConsulta = null;
	private String labelSetor = null;

	private static final Map<Integer, SetorEnum> HASH_MAP = new HashMap<Integer, SetorEnum>();
	static {
		for (SetorEnum setor : values()) {
			HASH_MAP.put(setor.getCodigo(), setor);
		}
	}

	private SetorEnum(Integer codigo, String descricao,
			String beanTelaManutencao, String beanTelaConsulta,
			String tilesTelaManutencao, String tilesTelaConsulta,
			String labelSetor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.beanTelaManutencao = beanTelaManutencao;
		this.beanTelaConsulta = beanTelaConsulta;
		this.tilesTelaManutencao = tilesTelaManutencao;
		this.tilesTelaConsulta = tilesTelaConsulta;
		this.labelSetor = labelSetor;
	}
	
	public SetorEnum getByCodigo(Integer codigo) {
		return HASH_MAP.get(codigo);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoString() {
		return codigo.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBeanTelaManutencao() {
		return beanTelaManutencao;
	}

	public void setBeanTelaManutencao(String beanTelaManutencao) {
		this.beanTelaManutencao = beanTelaManutencao;
	}

	public String getBeanTelaConsulta() {
		return beanTelaConsulta;
	}

	public void setBeanTelaConsulta(String beanTelaConsulta) {
		this.beanTelaConsulta = beanTelaConsulta;
	}

	public String getTilesTelaManutencao() {
		return tilesTelaManutencao;
	}

	public void setTilesTelaManutencao(String tilesTelaManutencao) {
		this.tilesTelaManutencao = tilesTelaManutencao;
	}

	public String getTilesTelaConsulta() {
		return tilesTelaConsulta;
	}

	public void setTilesTelaConsulta(String tilesTelaConsulta) {
		this.tilesTelaConsulta = tilesTelaConsulta;
	}

	public String getLabelSetor() {
		return labelSetor;
	}

	public void setLabelSetor(String labelSetor) {
		this.labelSetor = labelSetor;
	}

}
