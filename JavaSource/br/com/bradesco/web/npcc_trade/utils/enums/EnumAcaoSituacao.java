package br.com.bradesco.web.npcc_trade.utils.enums;

/** 
 * Cada zero(0) e um(1) dos números binários abaixo são referentes a esses botões(nessa ordem):
 * 	        Aprovar Cotação Banq
 * 			Funding
 * 			Inc. Desembolso
 * 			Aditar
 * 			Alongar
 * 			Prorrogar
 * 			Baixar
 * 			Duplicar
 * 			Divergente
 * 			Exportar Excel
 * 			Gerar Boleto
 * 			Perdido
 * 			Fechar
 * 			Alterar
 * 			Consultar
 * 
 * 	Quando o número referente ao botão for igual a um(1), o mesmo deve estar habilitado na tela,
 * e caso contrário, desabilitado.
 * 
 */
public enum EnumAcaoSituacao {

	/**
     * 
     */
    FECHADO(2, "011000010110001"),
    
    /**
     * 
     */
    AUTORIZADO_DSN(5, "111000110111111"),
    
    /**
     * 
     */
    EM_FORMALIZACAO(16, "011111010110001"),
 
    /**
     * 
     */
    EM_NEGOCIACAO(29, "111000110111111"),
    
    /**
     * 
     */
    EM_NEGOCIACAO_COTADA(30, "011000110111111"),
    
    /**
     * 
     */
    DEVOLVIDO(35, "011000110111011"),
    
    /**
     * 
     */
    DIVERGENTE(36, "011000111111001"),
    
    /**
     * 
     */
    DIVERGENCIA_DEVOLVIDA(38, "011000110111011"),
    
    /**
     * 
     */
    DEFAULT(0, "011000010110001");
    
    private int codigo;
    
    private String chave;
    
    private EnumAcaoSituacao(int codigo, String chave){
        this.codigo = codigo;
        this.chave = chave;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumAcaoSituacao fromCode(int code) {    	
    	switch(code) {
        case 2:
            return FECHADO;
        case 5:
            return AUTORIZADO_DSN;
        case 16:
        	return EM_FORMALIZACAO;
        case 29:
        	return EM_NEGOCIACAO;
        case 30:
        	return EM_NEGOCIACAO_COTADA;
        case 35:
            return DEVOLVIDO;
        case 36:
        	return DIVERGENTE;
        case 38:
            return DIVERGENCIA_DEVOLVIDA;
        default:
        	return DEFAULT;
        }	
    }
    
    /**
     * @return
     */
    public String getChave() {
        return chave;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

}
