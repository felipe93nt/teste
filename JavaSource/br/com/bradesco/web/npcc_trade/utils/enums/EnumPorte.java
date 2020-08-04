package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumPorte {

	/**
     * 
     */
    GRANDE(Numeros.UM, "GRANDE"),
	
	/**
     * 
     */
	MPME(Numeros.DOIS, "MPME"),
    
	/**
     * 
     */
	MEDIA_GRANDE(Numeros.TRES, "MEDIA GRANDE"),
	
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
	private EnumPorte(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumPorte fromCode(int code) {
        switch(code) {
        case 1:
            return GRANDE;
        case 2:
            return MPME;
        case 3:
        	return MEDIA_GRANDE;
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
