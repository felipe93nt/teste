/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumSimNaoInformado {

    /**
     * 
     */
    SIM("1", "Sim"),
    
    
    /**
     * 
     */
    NAO("2", "Não"),
    
    /**
     * 
     */
    NAO_INFORMADO("3", "Não informado");
    
    private String codigo;
    
    private String descricao;
    
    private EnumSimNaoInformado(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumSimNaoInformado fromCode(String code) {
        if(code.equals(SIM.codigo))
            return SIM;
        else if(code.equals(NAO.codigo))
            return NAO;
        else
            return NAO_INFORMADO;
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
