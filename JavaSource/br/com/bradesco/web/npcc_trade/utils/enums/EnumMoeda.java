/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
*
* Nome: EnumMoeda 
* 
* Propósito: Carrega os Dados para os Combos de moeda que são fixos na baixa
*
* Data: 31/08/2015 <br/>
* 
* @author BRQ <br/>
*         copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
public enum EnumMoeda {

    /**
     * 
     */
    DEFAULT(0, ""),
    
    /**
     * 
     */
    ME(1, "ME"),
    
    
    /**
     * 
     */
    MN(2, "MN");
    
    private Integer codigo;
    
    private String descricao;
    
    private EnumMoeda(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return EnumMoeda
     */
    public static EnumMoeda fromCode(Integer code) {
        switch(code) {
        case 0:
            return DEFAULT;
        case 1:
            return ME;
        case 2:
            return MN;
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
