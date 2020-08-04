package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumCobrancaComissao {

	/**
     * 
     */
	COBRANCA_VALOR(Numeros.UM, "Valor"),

    /**
     * 
     */
	COBRANCA_FLAT(Numeros.DOIS, "Flat"),
	
	/**
     * 
     */
    COBRANCA_A_A(Numeros.TRES, "A.A."),
    
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
	private EnumCobrancaComissao(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumCobrancaComissao fromCode(int code) {
        switch(code) {
        case 1:
            return COBRANCA_VALOR;
        case 2:
            return COBRANCA_FLAT;
        case 3:
        	return COBRANCA_A_A;
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
