/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author douglasMartinez
 *
 */
public enum EnumSituacaoAtivoInativo {

    /**
     * 
     */
    ATIVO(1, "Ativo"),
    
    
    /**
     * 
     */
    INATIVO(2, "Inativo");
    
    
    private Integer codigo;
    
    private String descricao;
    
    private EnumSituacaoAtivoInativo(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumSituacaoAtivoInativo fromCode(Integer code) {
        switch(code) {
        case 1:
            return ATIVO;
        case 2:
            return INATIVO;
        }
        throw new IllegalArgumentException("Inconsistência nos dados informados: " + code);
    }
    
    /**
     * @return
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
