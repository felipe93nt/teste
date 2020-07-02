package br.com.bradesco.web.ricc.enums;

import java.util.HashMap;
import java.util.Map;

import br.com.bradesco.web.ricc.utils.RiccConstants;

public enum SegmentoEnum {

	CORPORATE (1, "Corporate", RiccConstants.BEAN_QUESTIONARIO_CORPORATE, RiccConstants.BEAN_CONSULTA_QUESTIONARIO_CORPORATE, 
			RiccConstants.TELA_QUESTIONARIO_CORPORATE, RiccConstants.TELA_CONSULTA_QUESTIONARIO_CORPORATE, "label_corporate"),
	EMPRESAS (2, "Corporate One", RiccConstants.BEAN_QUESTIONARIO_EMPRESAS, RiccConstants.BEAN_CONSULTA_QUESTIONARIO_EMPRESAS, 
			RiccConstants.TELA_QUESTIONARIO_EMPRESAS, RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS, "label_empresas"),
	ALTO_VAREJO(3, "Varejo", RiccConstants.BEAN_QUESTIONARIO_ALTOVAREJO, RiccConstants.BEAN_CONSULTA_QUESTIONARIO_ALTOVAREJO, 
			RiccConstants.TELA_QUESTIONARIO_ALTOVAREJO, RiccConstants.TELA_CONSULTA_QUESTIONARIO_ALTOVAREJO, "label_alto_varejo"),
	LARGE_CORPORATE (4, "Large Corporate", RiccConstants.BEAN_QUESTIONARIO_LARGE_CORPORATE, RiccConstants.BEAN_CONSULTA_QUESTIONARIO_LARGE_CORPORATE, 
			RiccConstants.TELA_QUESTIONARIO_LARGE_CORPORATE, RiccConstants.TELA_CONSULTA_QUESTIONARIO_LARGE_CORPORATE, "label_large_corporate");

	private Integer codigo = null;
	private String descricao = null;
	private String beanTelaManutencao = null;
	private String beanTelaConsulta = null;
	private String tilesTelaManutencao = null;
	private String tilesTelaConsulta = null;
	private String labelSegmento = null;

	private static final Map<Integer, SegmentoEnum> HASH_MAP = new HashMap<Integer, SegmentoEnum>();
	static {
		for (SegmentoEnum item : values()) {
			HASH_MAP.put(item.getCodigo(), item);
		}
	}

	private SegmentoEnum(Integer codigo, String descricao,
			String beanTelaManutencao, String beanTelaConsulta,
			String tilesTelaManutencao, String tilesTelaConsulta,
			String labelSegmento) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.beanTelaManutencao = beanTelaManutencao;
		this.beanTelaConsulta = beanTelaConsulta;
		this.tilesTelaManutencao = tilesTelaManutencao;
		this.tilesTelaConsulta = tilesTelaConsulta;
		this.labelSegmento = labelSegmento;
	}

	public static SegmentoEnum getByCodigo(Integer codigo) {
		return HASH_MAP.get(codigo);
	}

	public static String getSegmentoLabelByPaginaAnteriorTiles(
			String tilesPaginaAnterior) {
		for (SegmentoEnum value : values()) {
			if (value.getTilesTelaManutencao().equals(tilesPaginaAnterior)
					|| value.getTilesTelaConsulta().equals(tilesPaginaAnterior)) {
				return value.getLabelSegmento();
			}
		}
		return "label_segmento";
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

	public String getLabelSegmento() {
		return labelSegmento;
	}

	public void setLabelSegmento(String labelSegmento) {
		this.labelSegmento = labelSegmento;
	}

}
