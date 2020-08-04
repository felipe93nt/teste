package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumTipoCotacao {

	 /**
     * 
     */
    TIPO_INDICATIVA(Numeros.UM, "Cotação Indicativa"),
	
	/**
     * 
     */
	TIPO_FIRME(Numeros.DOIS, "Cotação Firme"),
    
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
	private EnumTipoCotacao(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumTipoCotacao fromCode(int code) {
        switch(code) {
        case 1:
            return TIPO_INDICATIVA;
        case 2:
            return TIPO_FIRME;
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
