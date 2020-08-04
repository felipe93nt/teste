/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumSimNao {

    /**
     * 
     */
    SIM(1, "Sim"),
    
    
    /**
     * 
     */
    NAO(2, "Não");
    
    private int codigo;
    
    private String descricao;
    
    private EnumSimNao(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumSimNao fromCode(int code) {
        switch(code) {
        case 1:
            return SIM;
        case 2:
            return NAO;
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
    public int getCodigo() {
        return codigo;
    }

}
