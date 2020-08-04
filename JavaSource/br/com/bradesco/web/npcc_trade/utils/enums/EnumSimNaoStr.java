/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumSimNaoStr {

    /**
     * 
     */
    SIM("1", "Sim"),
    
    
    /**
     * 
     */
    NAO("2", "Não");
    
    private String codigo;
    
    private String descricao;
    
    private EnumSimNaoStr(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumSimNaoStr fromCode(String code) {
        if(code.equals(SIM.codigo))
            return SIM;
        else
            return NAO;
    }
    
    public static EnumSimNaoStr fromDescricao(String descricao){
        if(descricao != null && descricao.equals(SIM.descricao))
            return SIM;
        else 
            return NAO;
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
    public String getCodigo() {
        return codigo;
    }

}
