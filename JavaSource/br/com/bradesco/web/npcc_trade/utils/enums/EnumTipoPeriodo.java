/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumTipoPeriodo {

    /**
     * 
     */
    DIA(1, "Dia(s)"),
    
    /**
     * 
     */
    ANO(2, "Ano(s)");
    
    private int codigo;
    
    private String descricao;
    
    private EnumTipoPeriodo(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumTipoPeriodo fromCode(int code) {
        switch(code) {
        case 1:
            return DIA;
        case 2:
            return ANO;
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
