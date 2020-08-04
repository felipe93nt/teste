/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumSituacao {

    /**
     * 
     */
    SIM(1, "Sim"),
    
    
    /**
     * 
     */
    NAO(2, "N�o"),
    
    /**
     * 
     */
    PENDENTE(3, "Pendente");
    
    private Integer codigo;
    
    private String descricao;
    
    private EnumSituacao(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumSituacao fromCode(Integer code) {
        switch(code) {
        case 1:
            return SIM;
        case 2:
            return NAO;
        case 3:
            return PENDENTE;
        }
        throw new IllegalArgumentException("Inconsist�ncia nos dados informados: " + code);
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
