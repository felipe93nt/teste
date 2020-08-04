/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumPastasGcc {

    /**
     * 
     */
    EMAIL(0, "Email"),
    
    /**
     * 
     */
    DIVERSOS(1, "Diversos");
    
    private Integer codigo;
    
    private String descricao;
    
    private EnumPastasGcc(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return EnumMoeda
     */
    public static EnumPastasGcc fromCode(Integer code) {
        switch(code) {
        case 0:
            return EMAIL;
        case 1:
            return DIVERSOS;
        
        }
        throw new IllegalArgumentException("Inconsistência nos dados informados: " + code);
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
