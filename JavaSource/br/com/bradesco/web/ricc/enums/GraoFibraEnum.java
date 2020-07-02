package br.com.bradesco.web.ricc.enums;

import java.util.HashMap;
import java.util.Map;

public enum GraoFibraEnum {
	
	SOJA(1, "Soja", "Grão"),
	MILHO(2, "Milho", "Grão"),
	ALGODAO(3, "Algodão", "Fibra");
	
	private Integer codTipoRamo = 0;
	private String tipoRamo = null;
	private String categoria = null;
	private static Map<Integer, GraoFibraEnum> graoFibraMap = new HashMap<Integer, GraoFibraEnum>();
	
	private GraoFibraEnum(Integer codTipoRamo, String tipoRamo, String categoria) {
		this.codTipoRamo = codTipoRamo;
		this.tipoRamo = tipoRamo;
		this.categoria = categoria;
	}
	
	public static String getCategoriaByCod(Integer codTipoRamo) {
		return getEnumByCod(codTipoRamo).getCategoria();
	}
	
	public Integer getCodTipoRamo() {
		return codTipoRamo;
	}

	public void setCodTipoRamo(Integer codTipoRamo) {
		this.codTipoRamo = codTipoRamo;
	}

	public String getTipoRamo() {
		return tipoRamo;
	}

	public void setTipoRamo(String tipoRamo) {
		this.tipoRamo = tipoRamo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	static {
        for (GraoFibraEnum graoFibraEnum : GraoFibraEnum.values()) {
        	graoFibraMap.put(graoFibraEnum.getCodTipoRamo(), graoFibraEnum);
        }
    }
	
	public static GraoFibraEnum getEnumByCod(Integer codTipoRamo) {
		return graoFibraMap.get(codTipoRamo);
	}
	
}
