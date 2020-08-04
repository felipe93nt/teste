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
* Data: 27/09/2016 <br/>
* 
* @author BRQ <br/>
*         copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
public enum EnumPendTotais {

    /**
     * 
     */
    DEFAULT(0, ""),
    
    /**
     * 
     */
    OPERACOES_DE_DESEMBOLSADAS(1, "OPERACOES DE DESEMBOLSADAS"),
    
    /**
     * 
     */
    TOTAIS_GERAIS_DE_DESEMBOLSADAS(2, "TOTAIS GERAIS DE DESEMBOLSADAS"),
    
    /**
     * 
     */
    OPERACOES_A_DESEMBOLSAR(3, "OPERACOES A DESEMBOLSAR"),
    
    /**
     * 
     */
    TOTAIS_GERAIS_A_DESEMBOLSAR(4, "TOTAIS GERAIS A DESEMBOLSAR");
    
    private Integer codigo;
    
    private String descricao;
    
    private EnumPendTotais(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return EnumPendTotais
     */
    public static EnumPendTotais fromCode(Integer code) {
        switch(code) {
        case 0:
            return DEFAULT;
        case 1:
            return OPERACOES_DE_DESEMBOLSADAS;
        case 2:
            return TOTAIS_GERAIS_DE_DESEMBOLSADAS;
        case 3:
            return OPERACOES_A_DESEMBOLSAR;
        case 4:
            return TOTAIS_GERAIS_A_DESEMBOLSAR;
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

