package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumComissaoSobre {

	TOTAL(Numeros.UM, "Total"),

	SALDO_DEVEDOR(Numeros.DOIS, "Saldo Devedor"),
		
    DEFAULT(Numeros.ZERO, " ");
  
    private Integer codigo;
    
    private String descricao;
    
    /**
     * Construtor
     * 
     * @param @param arg0
     * @param @param arg1
     */
	private EnumComissaoSobre(Integer codigo, String descricao){
	    this.codigo = codigo;
	    this.descricao = descricao;
	}

	 /**
     * @param codigo
     * @return
     */
    public static EnumComissaoSobre fromCode(int code) {
        switch(code) {
        case 1:
            return TOTAL;
        case 2:
            return SALDO_DEVEDOR;
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
