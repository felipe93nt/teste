package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumTipoComissao {

	 /**
     * 
     */
    ADICIONAL(Numeros.UM, "Comissão Adicional"),
	
	/**
     * 
     */
	BANQUEIRO(Numeros.DOIS, "Comissão Banqueiro");
    
    private Integer codigo;
    
    private String descricao;
    

    /**
     * Construtor
     * 
     * @param @param arg0
     * @param @param arg1
     */
	private EnumTipoComissao(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumTipoComissao fromCode(Integer code) {
        if (code.equals(1)) {
            return ADICIONAL;
        } else if (code.equals(2)) {
             return BANQUEIRO;
        } else {
            throw new IllegalArgumentException("Inconsistência nos dados informados: " + code);
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
