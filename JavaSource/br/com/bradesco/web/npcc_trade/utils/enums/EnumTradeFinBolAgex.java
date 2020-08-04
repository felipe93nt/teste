package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumTradeFinBolAgex {


    /**
     * 
     */
    CODIGO_DA_MESA_MESA_TRADE(2, "Mesa Trade"),

    /**
     * 
     */
    PESQUISA_UNID_EXTERNA_POR_NOME(Numeros.TRES, "Pesquisa Unidade Externa Por Nome"),


    /**
     * 
     */
    PESQUISA_UNID_EXTERNA_POR_CODIGO(Numeros.UM, "Pesquisa Unidade Externa Por Código"),
    
    /**
     * 
     */
    PESQUISA_UNID_EXTERNA_BANQUEIRO_CAMBIO(Numeros.DOZE, "BRADESCO");


    private int codigo;

    private String descricao;

    /**
     * Construtor
     * 
     * @param @param arg0
     * @param @param arg1
     */
    private EnumTradeFinBolAgex(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
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
