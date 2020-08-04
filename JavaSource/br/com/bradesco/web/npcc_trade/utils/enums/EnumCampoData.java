/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumCampoData {

    /**
     * 
     */
    LIMITE_COTACAO(1, "Limite Cotação"),
    
    /**
     * 
     */
    PREVISAO_DESEMBOLSO(2, "Previsão de Desembolso"),
    
    /**
     * 
     */
    DISPONIBILIDADE_LINHA(3, "Disponibilidade da Linha"),
    
    /**
     * 
     */
    PREVISAO_DESEMBOLSO_INICIO(4, "Inicio Previsão de Desembolso"),
    
    /**
     * 
     */
    PREVISAO_DESEMBOLSO_FIM(5, "Fim Previsão de Desembolso"),
    
    /**
     * 
     */
    PREVISAO_EMBARQUE_INICIO(6, "Inicio Previsão de Embarque"),
    
    /**
     * 
     */
    PREVISAO_EMBARQUE_FIM(7, "Fim Previsão de Embarque"),
    
    /**
     * 
     */
    VENCIMENTO_SAQUE(8, "Vencimento Saque"),
    
    /**
     * 
     */
    PREVISAO_EMISSAO(9, "Previsão de Emissao");
    
    private int codigo;
    
    private String descricao;
    
    private EnumCampoData(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumCampoData fromCode(int code) {
        switch(code) {
        case 1:
            return LIMITE_COTACAO;
        case 2:
            return PREVISAO_DESEMBOLSO;
        case 3:
            return DISPONIBILIDADE_LINHA;
        case 4:
            return PREVISAO_DESEMBOLSO_INICIO;
        case 5:
            return PREVISAO_DESEMBOLSO_FIM;
        case 6:
            return PREVISAO_EMBARQUE_INICIO;
        case 7:
            return PREVISAO_EMBARQUE_FIM;
        case 8:
            return VENCIMENTO_SAQUE;
        case 9:
        	return PREVISAO_EMISSAO;
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
