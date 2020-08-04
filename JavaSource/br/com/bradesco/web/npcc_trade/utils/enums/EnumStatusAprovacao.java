package br.com.bradesco.web.npcc_trade.utils.enums;

public enum EnumStatusAprovacao {

	/**
     * 
     */
    PENDENTE(7, "Pendente de Aprovação"),
    
    /**
     * 
     */
    APROVADO(8, "Aprovado"),
    
    /**
     * 
     */
    REJEITADO(9, "Rejeitado"),
    
    /**
     * 
     */
    DEFAULT(0, " ");
    
    private int codigo;
    
    private String descricao;
    
    private EnumStatusAprovacao(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumStatusAprovacao fromCode(int code) {
        switch(code) {
        case 7:
            return PENDENTE;
        case 8:
            return APROVADO;
        case 9:
        	return REJEITADO;
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
