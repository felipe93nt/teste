/**
 * Nome: br.com.bradesco.web.npcc_trade.utils.enums
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 14/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.utils.enums;

/**
 * Nome: EnumProduto.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 14/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public enum EnumProduto {

    /**
     * 
     */
    CODIGO_DA_MESA_MESA_DE_CAMBIO(1, "Mesa de C�mbio"),

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
    CODIGO_CAMBIO_PRONTO(1, "C�mbio Pronto"),

    /**
     * 
     */
    CODIGO_CAMBIO_FUTURO(2, "C�mbio Futuro"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_ZERO(0, "Zerado"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_COMPRA(1, "C�digo Compra"),

    /**
     * 
     */
    CODIGO_COMPRA_VENDA_VENDA(2, "C�digo Venda"),

    /**
     * 
     */
    PRODUTO_FINIMP_DIRETO(1644, "Financiamento de Importa��o Direto"),

    /**
     * 
     */
    PRODUTO_REFINIMP_DIRETO(1646, "Refinanciamento de Importa��o Direto"),

    /**
     * 
     */
    PRODUTO_FINIMP_INDIRETO(2692, "Financiamento de Importa��o Banco a Banco"),

    /**
     * 
     */
    PRODUTO_REFINIMP_INDIRETO(1717, "Refinanciamento de Importa��o Banco a Banco"),

    /**
     * 
     */
    PRODUTO_LEI_4131(2010, "Empr�stimo Internacional - Lei 4.131"),

    /**
     * 
     */
    PRODUTO_P_P_E(1642, "Pr�-pagamento de Exporta��o"),

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
    PROEX(642, "Proex - Equaliza��o"),

    /**
	     */
    CCE_CEDULA_EXPORTACAO(622, "C�dula de Cr�dito � Exporta��o (CCE)", 4),

    /**
	     */
    CCE_CEDULA_EXPORTACAO_INDIRETO(624, "C�dula de Cr�dito � Exporta��o Indiretos (CCE Indiretos)", 4),

    /**
	     */
    NCE_CREDITO_EXPORTACAO(1713, "Nota de Cr�dito � Exporta��o (NCE)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_COMPOR(638, "Nota de Cr�dito � Exporta��o Compror (NCE Compror)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_INDIRETO(639, "Nota de Cr�dito � Exporta��o Indiretos (NCE Indiretos)", 4),

    /**
	     */
    NCE_NOTA_EXPORTACAO_REVOLVING(640, "Nota de Cr�dito � Exporta��o Revolving (NCE Revolving)", 4),

    /**
	     */
    BNDES_POS_BUYER(661, "BNDES-Exim - P�s-Embarque Buyer Credit", 2),

    /**
	     */
    BNDES_POS_SUPPLIER(662, "BNDES-Exim - P�s-Embarque Supplier Credit", 2),

    /**
	     */
    BNDES_PRE_AGIL(663, "BNDES-Exim - Pr�-Embarque �gil", 1),

    /**
	     */
    BNDES_PRE_ANCORA(664, "BNDES-Exim - Pr�-Embarque �ncora", 1),

    /**
	     */
    BNDES_PRE_SUSTENTANCAO_INVEST(3934, "BNDES-Exim - Pr�-Embarque de Sustenta��o do Investimento - PSI", 1),

    /**
	     */
    BNDES_PRE_AUTOMOVEIS(665, "BNDES-Exim - Pr�-Embarque Autom�veis", 1),

    /**
	     */
    BNDES_PRE_ESPECIAL(666, "BNDES-Exim - Pr�-Embarque Especial", 1),

    /**
	     */
    BNDES_PRE_NORMAL(667, "BNDES-Exim - Pr�-Embarque Normal", 1),

    /**
	     */
    BNDES_PRE_REVITALIZA(670, "BNDES-Exim - Pr�-Embarque Revitaliza", 1),

    /**
	     */
    FINIMP_ECA(1715, "Financiamento � Importa��o de Longo Prazo - Export Credit Agencies"),

    /**
	     */
    LC_IMPORTACAO(2018, "Carta de Cr�dito de Importa��o"),

    /**
	     */
    GARANTIAS_EXPEDIDAS_FINANCEIRA(1769, "Stand By Letter Of Credit Financeira", 3),

    /**
	     */
    GARANTIAS_EXPEDIDAS_IMPORTACAO(3933, "Stand By Letter Of Credit Importa��o", 3),

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
    DEFAULT(0, "Produto n�o encontrado.");

    private Integer codigo;

    private String descricao;
    
    private boolean garantia = false; 
    
    private boolean nce = false;
    
    private boolean bndesPre = false;
   
    private boolean bndesPos = false;

    /**
     * 
     * Nome: fromCode Prop�sito:
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
     *      Registro de Manuten��o: 20/06/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
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
     * @return descri��o
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
