package br.com.bradesco.web.npcc_trade.utils.enums;

public enum EnumPendencia {

	/**
     * 
     */
    CUSTO_EXTERNO(32, "Cotar Custo Externo"),
    
    /**
     * 
     */
    RECOTAR_CUSTO_EXTERNO(34, "Recotar Custo Externo"),
    
    /**
     * 
     */
    UNID_EXT(33, "Unidade Externa"),
    
    /**
     * 
     */
    PENDENCIA_CUSTO_EXTERNO(35, "Pendência Cotar Custo Externo"),
    
    /**
     * 
     */
    PENDENCIA_FECHADAS_ANALISAR(36, "Pendência Cotações Fechadas Analisar"),
    
    /**
     * 
     */
    DIVERGENTE(37, "Divergente Div. Int."),
    
    /**
     * 
     */
    DEFAULT(0, " ");
    
    private int codigo;
    
    private String descricao;
    
    private EnumPendencia(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumPendencia fromCode(int code) {
        switch(code) {
        case 32:
            return CUSTO_EXTERNO;
        case 33:
            return UNID_EXT;
        case 35:
            return PENDENCIA_CUSTO_EXTERNO;
        case 36:
            return PENDENCIA_FECHADAS_ANALISAR;
        case 37:
        	return DIVERGENTE;
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
