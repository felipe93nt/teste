package br.com.bradesco.web.npcc_trade.utils.enums;

/** 
 * Cada zero(0) e um(1) das chaves(são números binários) abaixo são referentes a esses botões(nessa ordem):
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
public enum EnumAcaoProduto {

    /**
     * 
     */
    PRODUTO_FINIMP_DIRETO(1644, "010000111111111"),

    /**
     * 
     */
    PRODUTO_REFINIMP_DIRETO(1646, "010000111111111"),

    /**
     * 
     */
    PRODUTO_FINIMP_INDIRETO(2692, "010000111111111"),

    /**
     * 
     */
    PRODUTO_REFINIMP_INDIRETO(1717, "010000111111111"),

    /**
     * 
     */
    PRODUTO_LEI_4131(2010, "010001111111111"),

    /**
     * 
     */
    PRODUTO_P_P_E(1642, "010011111111111"),

    /**
     * 
     */
    PRODUTO_WORKING_CAPITAL(2011, "010011111111111"),

    /**
    * 
    */
    PRODUTO_FORFAITING(644, "011000111111111"),

    /**
	     */
    PROEX(642, "000000111111111"),

    /**
     */
    CCE_CEDULA_CREDITO_EXPORTACAO(622, "000100111111111"),
    
    /**
     */
    CCE_CEDULA_CREDITO_EXPORTACAO_INDIRETOS(624, "000100111111111"),

    /**
	     */
    NCE_CREDITO_EXPORTACAO(1713, "000100111111111"),

    /**
	     */
    NCE_NOTA_EXPORTACAO_COMPOR(638, "000100111111111"),

    /**
	     */
    NCE_NOTA_EXPORTACAO_INDIRETO(639, "000100111111111"),

    /**
	     */
    NCE_NOTA_EXPORTACAO_REVOLVING(640, "000100111111111"),

    /**
	     */
    BNDES_POS_BUYER(661, "000000111111111"),

    /**
	     */
    BNDES_POS_SUPPLIER(662, "000000111111111"),

    /**
	     */
    BNDES_PRE_AGIL(663, "000000111111111"),

    /**
	     */
    BNDES_PRE_ANCORA(664, "000000111111111"),

    /**
	     */
    BNDES_PRE_SUSTENTANCAO_INVEST(3934, "000000111111111"),

    /**
	     */
    BNDES_PRE_AUTOMOVEIS(665, "000000111111111"),

    /**
	     */
    BNDES_PRE_ESPECIAL(666, "000000111111111"),

    /**
	     */
    BNDES_PRE_NORMAL(667, "000000111111111"),

    /**
	     */
    BNDES_PRE_REVITALIZA(670, "000000111111111"),

    /**
	     */
    FINIMP_ECA(1715, "100000111111111"),

    /**
	     */
    LC_IMPORTACAO(2018, "100000111111111"),

    /**
	     */
    GARANTIAS_EXPEDIDAS_FINANCEIRA(1769, "100001111111111"),

    /**
	     */
    GARANTIAS_EXPEDIDAS_IMPORTACAO(3933, "100001111111111"),
	
    /**
     * 
     */
    DEFAULT(0, "000000111111111");
    
    private int codigo;
    
    private String chave;
    
    private EnumAcaoProduto(int codigo, String chave){
        this.codigo = codigo;
        this.chave = chave;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumAcaoProduto fromCode(int code) {
        switch(code) {
        case 1644:
            return PRODUTO_FINIMP_DIRETO;
        case 1646:
            return PRODUTO_REFINIMP_DIRETO;
        case 2692:
            return PRODUTO_FINIMP_INDIRETO;
        case 1717:
            return PRODUTO_REFINIMP_INDIRETO;
        case 2010:
        	return PRODUTO_LEI_4131;
        case 1642:
        	return PRODUTO_P_P_E;
        case 2011:
        	return PRODUTO_WORKING_CAPITAL;
        case 644:
        	return PRODUTO_FORFAITING;
        case 642:
        	return PROEX;
        case 1713:
        	return NCE_CREDITO_EXPORTACAO;
        case 638:
        	return NCE_NOTA_EXPORTACAO_COMPOR;
        case 639:
        	return NCE_NOTA_EXPORTACAO_INDIRETO;
        case 640:
        	return NCE_NOTA_EXPORTACAO_REVOLVING;
        case 622:
        	return CCE_CEDULA_CREDITO_EXPORTACAO;
        case 624:
        	return CCE_CEDULA_CREDITO_EXPORTACAO_INDIRETOS;
        case 661:
        	return BNDES_POS_BUYER;
        case 662:
        	return BNDES_POS_SUPPLIER;
        case 663:
        	return BNDES_PRE_AGIL;
        case 664:
        	return BNDES_PRE_ANCORA;
        case 3934:
        	return BNDES_PRE_SUSTENTANCAO_INVEST;
        case 665:
        	return BNDES_PRE_AUTOMOVEIS;
        case 666:
        	return BNDES_PRE_ESPECIAL;
        case 667:
        	return BNDES_PRE_NORMAL;
        case 670:
        	return BNDES_PRE_REVITALIZA;
        case 1715:
        	return FINIMP_ECA;
        case 2018:
        	return LC_IMPORTACAO;
        case 1769:
        	return GARANTIAS_EXPEDIDAS_FINANCEIRA;
        case 3933:
        	return GARANTIAS_EXPEDIDAS_IMPORTACAO;
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
