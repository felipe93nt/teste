package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumMomentoJuro {

    /**
     * 
     */
    MOMENTO_JURO_ANTECIPADO(Numeros.UM, "Antecipado"),
	
	/**
     * 
     */
	MOMENTO_JURO_POSTECIPADO(Numeros.DOIS, "Postecipado"),

    /**
     * 
     */
	MOMENTO_JURO_UNICO(Numeros.TRES, "Único"),
    
    /**
     * 
     */
    DEFAULT(Numeros.ZERO, " ");
    
    private Integer codigo;
    
    private String descricao;

	    /**
	     * Construtor
	     * 
	     * @param @param arg0
	     * @param @param arg1
	     */
    private EnumMomentoJuro(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
	}
    
    /**
     * @param codigo
     * @return
     */
    public static EnumMomentoJuro fromCode(int code) {
        switch(code) {
        case 1:
            return MOMENTO_JURO_ANTECIPADO;
        case 2:
            return MOMENTO_JURO_POSTECIPADO;
        case 3:
        	return MOMENTO_JURO_UNICO;
        default:
        	return DEFAULT;
        }
    }
    
    /**
     * @return descrição
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

}
