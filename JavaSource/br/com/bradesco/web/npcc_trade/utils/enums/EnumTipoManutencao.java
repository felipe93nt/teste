/**
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.enums;


/**
 * @author thiagoito
 *
 */
public enum EnumTipoManutencao {

	/**
     * 
     */
    DEFAULT("0", ""),
	
	/**
     * 
     */
    INCLUSAO("1", "Inclusão"),
    
    /**
     * 
     */
    ALTERACAO("2", "Alteração"),
    
    /**
     * 
     */
    INCLUSAO_PENDENTE("3", "Inclusão - Pendente de aprovação"),
    
    /**
     * 
     */
    ALTERACAO_PENDENTE("4", "Alteração - Pendente de aprovação"),
    
    /**
     * 
     */
    APROVADO_INCLUSAO("5", "Aprovado - Inclusão"),
    
    /**
     * 
     */
    APROVADO_ALTERACAO("6", "Aprovado - Alteração"),
    
    /**
     * 
     */
    REJEITADO_INCLUSAO("7", "Rejeitado - Inclusão"),
    
    /**
     * 
     */
    REJEITADO_ALTERACAO("8", "Rejeitado - Alteração"),
    
    /**
     * 
     */
    BLOQUEIO_PENDENTE("9", "Bloqueio - Pendente de aprovação"),
    
    /**
     * 
     */
    DESBLOQUEIO_PENDENTE("A", "Desbloqueio - Pendente de aprovação"),
    
    /**
     * 
     */
    APROVADO_BLOQUEIO("B", "Aprovado - Bloqueio"),
    
    /**
     * 
     */
    APROVADO_DESBLOQUEIO("C", "Aprovado - Desbloqueio"),
    
    /**
     * 
     */
    IMPEDIR_PENDENTE("D", "Impedir - Pendente de aprovação"),
    
    /**
     * 
     */
    DESIMPEDIR_PENDENTE("E", "Desimpedir - Pendente de aprovação"),
    
    /**
     * 
     */
    APROVADO_IMPEDIR("F", "Aprovado - Impedir"),
    
    /**
     * 
     */
    APROVADO_DESIMPEDIR("G", "Aprovado - Desimpedir");
   
    private String codigo;
    
    private String descricao;
    
    private EnumTipoManutencao(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumTipoManutencao fromCode(String code) {
        // retorna pelo código
        if(code.equals(INCLUSAO.codigo))
            return INCLUSAO;
        else if(code.equals(ALTERACAO.codigo))
            return ALTERACAO;
        else if(code.equals(INCLUSAO_PENDENTE.codigo))
            return INCLUSAO_PENDENTE;
        else if(code.equals(ALTERACAO_PENDENTE.codigo))
            return ALTERACAO_PENDENTE;
        else if(code.equals(APROVADO_INCLUSAO.codigo))
            return APROVADO_INCLUSAO;
        else if(code.equals(APROVADO_ALTERACAO.codigo))
            return APROVADO_ALTERACAO;
        else if(code.equals(REJEITADO_INCLUSAO.codigo))
            return REJEITADO_INCLUSAO;
        else if(code.equals(REJEITADO_ALTERACAO.codigo))
            return REJEITADO_ALTERACAO;
        else if(code.equals(BLOQUEIO_PENDENTE.codigo))
            return BLOQUEIO_PENDENTE;
        else if(code.equals(DESBLOQUEIO_PENDENTE.codigo))
            return DESBLOQUEIO_PENDENTE;
        else if(code.equals(APROVADO_BLOQUEIO.codigo))
            return APROVADO_BLOQUEIO;
        else if(code.equals(APROVADO_DESBLOQUEIO.codigo))
            return APROVADO_DESBLOQUEIO;
        else if(code.equals(IMPEDIR_PENDENTE.codigo))
            return IMPEDIR_PENDENTE;
        else if(code.equals(DESIMPEDIR_PENDENTE.codigo))
            return DESIMPEDIR_PENDENTE;
        else if(code.equals(APROVADO_IMPEDIR.codigo))
            return APROVADO_IMPEDIR;
        else if(code.equals(APROVADO_DESIMPEDIR.codigo))
            return APROVADO_DESIMPEDIR;

        return DEFAULT;
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
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static Boolean isTipoInclusao(String code) {
    	
        if(code.equals(INCLUSAO.codigo))
            return Boolean.TRUE;
        else if(code.equals(ALTERACAO.codigo))
            return Boolean.FALSE;
        else if(code.equals(INCLUSAO_PENDENTE.codigo))
            return Boolean.TRUE;
        else if(code.equals(ALTERACAO_PENDENTE.codigo))
            return Boolean.FALSE;
        else if(code.equals(APROVADO_INCLUSAO.codigo))
            return Boolean.TRUE;
        else if(code.equals(APROVADO_ALTERACAO.codigo))
            return Boolean.FALSE;
        else if(code.equals(REJEITADO_INCLUSAO.codigo))
            return Boolean.TRUE;
        else if(code.equals(REJEITADO_ALTERACAO.codigo))
            return Boolean.FALSE;
        else if(code.equals(BLOQUEIO_PENDENTE.codigo))
            return Boolean.TRUE;
        else if(code.equals(DESBLOQUEIO_PENDENTE.codigo))
            return Boolean.TRUE;
        else if(code.equals(APROVADO_BLOQUEIO.codigo))
            return Boolean.FALSE;
        else if(code.equals(APROVADO_DESBLOQUEIO.codigo))
            return Boolean.FALSE;
        else if(code.equals(IMPEDIR_PENDENTE.codigo))
            return Boolean.TRUE;
        else if(code.equals(DESIMPEDIR_PENDENTE.codigo))
            return Boolean.TRUE;
        else if(code.equals(APROVADO_IMPEDIR.codigo))
            return Boolean.FALSE;
        else if(code.equals(APROVADO_DESIMPEDIR.codigo))
            return Boolean.FALSE;

        return Boolean.FALSE;
    	
    }

}
