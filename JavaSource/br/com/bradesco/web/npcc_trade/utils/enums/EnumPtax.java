package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumPtax {

	 /**
     * 
     */
    PTAX_D0(Numeros.UM, "D-0"),
	
	/**
     * 
     */
	PTAX_D1(Numeros.DOIS, "D-1"),

    /**
     * 
     */
	PTAX_D2(Numeros.TRES, "D-2"),
    
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
    private EnumPtax(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
	}
    
    /**
     * @param codigo
     * @return
     */
    public static EnumPtax fromCode(int code) {
        switch(code) {
        case 1:
            return PTAX_D0;
        case 2:
            return PTAX_D1;
        case 3:
        	return PTAX_D2;
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
