package br.com.bradesco.web.npcc_trade.utils.enums;

public enum EnumMotivoDevolver {

	/**
     * 
     */
    PENDENTE_CUSTO_EXTERNO(1, "Pendente Cotar Custo Externo"),
    
    /**
     * 
     */
    FORMALIZACAO_ANALISAR(5, "Unidade Externa"),
    
    /**
     * 
     */
    DEFAULT(0, " ");
    
    private int codigo;
    
    private String descricao;
    
    private EnumMotivoDevolver(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumMotivoDevolver fromCode(int code) {
        switch(code) {
        case 1:
            return PENDENTE_CUSTO_EXTERNO;
        case 5:
            return FORMALIZACAO_ANALISAR;
        default:
        	return DEFAULT;
        }	
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
