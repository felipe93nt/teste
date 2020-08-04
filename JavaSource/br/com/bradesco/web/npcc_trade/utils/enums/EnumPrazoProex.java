/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumPrazoProex {
    
    /*
     * 
     */
    DEFAULT(Numeros.ZERO, ""),
    
    /*
     * 
     */
    DIAS(Numeros.UM, "Dias"),
    
    /*
     * 
     */
    MESES(Numeros.DOIS, "Meses"),
    
    /*
     * 
     */
    ANOS(Numeros.TRES, "Anos");
    
    private Integer codigo;
    
    private String descricao;
    
    /**
     * CONSTRUTOR
     */
    private EnumPrazoProex(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public static EnumPrazoProex fromCode(Integer code) {
        if (code.equals(1)) {
            return DIAS;
        } else if (code.equals(2)) {
            return MESES;
        } else if (code.equals(3)) {
            return ANOS;
        } else {
            return DEFAULT;
        }
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
