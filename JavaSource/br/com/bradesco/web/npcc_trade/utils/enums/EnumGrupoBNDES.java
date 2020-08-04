package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumGrupoBNDES {
	/**
     * 
     */
    GRUPO_UM(Numeros.UM, "Grupo I"),
	
	/**
     * 
     */
	GRUPO_DOIS(Numeros.DOIS, "Grupo II"),

    /**
     * 
     */
	GRUPO_TRES(Numeros.TRES, "Grupo III"),
	
    /**
     * 
     */
	GRUPO_1A(Numeros.QUATRO, "Grupo 1A"),
	
    /**
     * 
     */
	GRUPO_SERVICO(Numeros.CINCO, "Serviços"),
    
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
	private EnumGrupoBNDES(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumGrupoBNDES fromCode(int code) {
        switch(code) {
        case 1:
            return GRUPO_UM;
        case 2:
            return GRUPO_DOIS;
        case 3:
        	return GRUPO_TRES;
        case 4:
        	return GRUPO_1A;
        case 5:
        	return GRUPO_SERVICO;
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
