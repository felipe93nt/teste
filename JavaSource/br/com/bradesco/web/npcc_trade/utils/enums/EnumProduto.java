/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.enums
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 14/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.utils.enums;

/**
 * Nome: EnumProduto.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public enum EnumProduto {

    /**
     * 
     */
    CODIGO_DA_MESA_MESA_DE_CAMBIO(1, "Mesa de Câmbio"),

    /**
     * 
     */
    CODIGO_DA_MESA_MESA_TRADE(2, "Mesa Trade"),

    /**
     * 
     */
    CODIGO_DA_MESA_GARANTIAS_RECEBIDAS(3, "Garantias Recebidas"),

    /**
     * 
     */
    CODIGO_DA_MESA_TRADE_AGEX(6, "Trade"),

    /**
     * 
     */
    CODIGO_CAMBIO_ZERO(0, "Zerado"),

    /**
     * 
     */
    CODIGO_CAMBIO_PRONTO(1, "Câmbio Pronto"),

    /**
     * 
     */
    CODIGO_CAMBIO_FUTURO(2, "Câmbio Futuro"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_ZERO(0, "Zerado"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_COMPRA(1, "Código Compra"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_VENDA(2, "Código Venda"),

    /**
     * 
     */
    PRODUTO_FINIMP_DIRETO(1644, "Financiamento de Importação Direto"),

    /**
     * 
     */
    PRODUTO_REFINIMP_DIRETO(1646, "Refinanciamento de Importação Direto"),

    /**
     * 
     */
    PRODUTO_FINIMP_INDIRETO(2692, "Financiamento de Importação Banco a Banco"),

    /**
     * 
     */
    PRODUTO_REFINIMP_INDIRETO(1717, "Refinanciamento de Importação Banco a Banco"),

    /**
     * 
     */
    PRODUTO_LEI_4131(2010, "Empréstimo Internacional - Lei 4.131"),

    /**
     * 
     */
    PRODUTO_P_P_E(1642, "Pré-pagamento de Exportação"),

    /**
     * 
     */

    PRODUTO_WORKING_CAPITAL(2011, "Working Capital - Capital de Giro no Exterior"),

    /**
    * 
    */

    PRODUTO_FORFAITING(644, "Desconto de Saque no Exterior - Forfaiting"),

    /**
	     */
    PROEX(642, "Proex - Equalização"),

    /**
	     */
    CCE_CEDULA_EXPORTACAO(622, "Cédula de Crédito à Exportação (CCE)", 4),

    /**
	     */
    CCE_CEDULA_EXPORTACAO_INDIRETO(624, "Cédula de Crédito à Exportação Indiretos (CCE Indiretos)", 4),

    /**
	     */
    NCE_CREDITO_EXPORTACAO(1713, "Nota de Crédito à Exportação (NCE)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_COMPOR(638, "Nota de Crédito à Exportação Compror (NCE Compror)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_INDIRETO(639, "Nota de Crédito à Exportação Indiretos (NCE Indiretos)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_REVOLVING(640, "Nota de Crédito à Exportação Revolving (NCE Revolving)", 4),

    /**
	     */
    BNDES_POS_BUYER(661, "BNDES-Exim - Pós-Embarque Buyer Credit", 2),

    /**
	     */
    BNDES_POS_SUPPLIER(662, "BNDES-Exim - Pós-Embarque Supplier Credit", 2),

    /**
	     */
    BNDES_PRE_AGIL(663, "BNDES-Exim - Pré-Embarque Ágil", 1),

    /**
	     */
    BNDES_PRE_ANCORA(664, "BNDES-Exim - Pré-Embarque Âncora", 1),

    /**
	     */
    BNDES_PRE_SUSTENTANCAO_INVEST(3934, "BNDES-Exim - Pré-Embarque de Sustentação do Investimento - PSI", 1),

    /**
	     */
    BNDES_PRE_AUTOMOVEIS(665, "BNDES-Exim - Pré-Embarque Automóveis", 1),

    /**
	     */
    BNDES_PRE_ESPECIAL(666, "BNDES-Exim - Pré-Embarque Especial", 1),

    /**
	     */
    BNDES_PRE_NORMAL(667, "BNDES-Exim - Pré-Embarque Normal", 1),

    /**
	     */
    BNDES_PRE_REVITALIZA(670, "BNDES-Exim - Pré-Embarque Revitaliza", 1),

    /**
	     */
    FINIMP_ECA(1715, "Financiamento à Importação de Longo Prazo - Export Credit Agencies"),

    /**
	     */
    LC_IMPORTACAO(2018, "Carta de Crédito de Importação"),

    /**
	     */
    GARANTIAS_EXPEDIDAS_FINANCEIRA(1769, "Stand By Letter Of Credit Financeira", 3),

    /**
	     */
    GARANTIAS_EXPEDIDAS_IMPORTACAO(3933, "Stand By Letter Of Credit Importação", 3),

    /**
	 * 
	 */
    TELA_TRADE_FINANCE_MONITOR(1, "1"),

    /**
	 * 
	 */
    TELA_TRADE_FINANCE_CUSTO_EXTERNO(2, "2"),

    /**
	 * 
	 */
    DEFAULT(0, "Produto não encontrado.");

    private Integer codigo;

    private String descricao;
    
    private boolean garantia = false; 
    
    private boolean nce = false;
    
    private boolean bndesPre = false;
   
    private boolean bndesPos = false;

    /**
     * 
     * Nome: fromCode Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static EnumProduto fromCode(int code) {
        switch (code) {
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
        case 622:
            return CCE_CEDULA_EXPORTACAO;
        case 624:
            return CCE_CEDULA_EXPORTACAO_INDIRETO;
        case 1713:
            return NCE_CREDITO_EXPORTACAO;
        case 638:
            return NCE_NOTA_EXPORTACAO_COMPOR;
        case 639:
            return NCE_NOTA_EXPORTACAO_INDIRETO;
        case 640:
            return NCE_NOTA_EXPORTACAO_REVOLVING;
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
     * Construtor
     * 
     * @param @param arg0
     * @param @param arg1
     */
    private EnumProduto(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * Construtor
     * 
     * @param int codigo
     * @param String descricao
     * @param int tipo: BNDSPRE - 1, BNDSPOS - 2, GARANTIA -3  e NCE - 4
     */
    private EnumProduto(Integer codigo, String descricao, int tipo) {
        this(codigo, descricao);
        
        this.bndesPre = tipo == 1;
        this.bndesPos = tipo == 2;
        this.garantia = tipo == 3;
        this.nce = tipo == 4;    
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
    
    /**
     * @return the garantia
     */
    public boolean isGarantia() {
        return garantia;
    }
    
    /**
     * @return the nce
     */
    public boolean isNce() {
        return nce;
    }

    /**
     * @return o valor do bndesPre
     */
    public boolean isBndesPre() {
        return bndesPre;
    }

    /**
     * @param bndesPre seta o novo valor para o campo bndesPre
     */
    public void setBndesPre(boolean bndesPre) {
        this.bndesPre = bndesPre;
    }

    /**
     * @return o valor do bndesPos
     */
    public boolean isBndesPos() {
        return bndesPos;
    }

    /**
     * @param bndesPos seta o novo valor para o campo bndesPos
     */
    public void setBndesPos(boolean bndesPos) {
        this.bndesPos = bndesPos;
    }

    /**
     * @param codigo seta o novo valor para o campo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @param descricao seta o novo valor para o campo descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param garantia seta o novo valor para o campo garantia
     */
    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    /**
     * @param nce seta o novo valor para o campo nce
     */
    public void setNce(boolean nce) {
        this.nce = nce;
    }
    
  
}
