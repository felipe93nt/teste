package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public enum EnumTradeFinance {

    /**
     * 
     */
    ADITIVO_NEGOC_INICIAL(Numeros.ZERO, "Aditivo Emenda - Negociacao Inicial"),

    /**
     * 
     */
    TPO_NEGOC_CMBIO_FIRME(Numeros.NUM2, "Tipo Neg�cio C�mbio Firme"),

    /**
     * 
     */
    STATUS_EM_NEGOCIACAO(Numeros.NUM29, "Em negocia��o"),

    /**
     * 
     */
    STATUS_DIVERGENTE(Numeros.NUM37, "Divergente"),

    /**
     * 
     */
    MOEDA_USD(Numeros.OITO, "Moeda USD"),

    /**
     * 
     */
    SALDO_DEVEDOR(Numeros.NUM2, "Saldo Devedor"),

    /**
     * 
     */
    PERIODICIDADE_SEMESTRAL(Numeros.NUM8, "Periodicidade Semestral"),

    /**
     * 
     */
    PERIODICIDADE_IRREGULAR(Numeros.NUM11, "Periodicidade IRREGULAR"),

    /**
     * 
     */
    PERIODICIDADE_FINAL(Numeros.NUM12, "Periodicidade Final"),

    /**
     * 
     */
    JUROS_DE_MORA_AO_MES(Numeros.UM, "Juros de Mora ao m�s"),

    /**
     * 
     */
    PESQUISA_CLIENTE_POR_NOME(Numeros.UM, "Pesquisa Cliente Por Nome"),

    /**
     * 
     */
    PESQUISA_CLIENTE_POR_CPF_CNPJ(Numeros.DOIS, "Pesquisa Cliente Por CPF ou CNPJ"),

    /**
     * 
     */
    PESQUISA_UNID_EXTERNA_POR_NOME(Numeros.TRES, "Pesquisa Unidade Externa Por Nome"),

    /**
     * 
     */
    PESQUISA_MERCADORIA_POR_NOME(Numeros.UM, "Pesquisa Mercadoria Por Nome"),

    /**
     * 
     */
    PESQUISA_BENEFICIARIO_POR_NOME(Numeros.DOIS, "Pesquisa Beneficiario Por Nome"),

    /**
     * 
     */
    ALTERACAO_VIA_CONSULTA(Numeros.NUM100, "Carga Altera��o via Consulta"),

    /**
     * 
     */
    DUPLICACAO_VIA_CONSULTA(Numeros.NUM200, "Carga Duplica��o via Consulta"),

    /**
     * 
     */
    MAX_LISTA_FLUXO_PRINC_JUROS(Numeros.DEZ, "M�ximo Lista Fluxo Pagto Principal e Juros"),

    /**
     * 
     */
    MAX_LISTA_INCLUSAO_COTACAO(Numeros.VINTE, "M�ximo Lista Inclus�o"),

    /**
     * 
     */
    LIMITE_ACESSO_PESSOA_NACIONAL(Numeros.UM, "TIPO DE ACESSO - PESSOA NACIONAL"),

    /**
     * 
     */
    LIMITE_ACESSO_PESSOA_ESTRANGEIRA(Numeros.DOIS, "TIPO DE ACESSO - PESSOA ESTRANGEIRA"),

    /**
     * 
     */
    TIPO_VINCULO_AVALISTA(Numeros.UM, "TIPO VINCULO AVALISTA"),

    /**
     * 
     */
    TIPO_PAPEL_AVALISTA(Numeros.CINCO, "TIPO PAPEL AVALISTA"),

    /**
     * 
     */
    ACESSO_ALERTA(Numeros.UM, "TIPO ACESSO BOT�O ALERTA"),

    /**
     * 
     */
    ACESSO_AUTORIZA_DSN(Numeros.DOIS, "TIPO ACESSO BOT�O AUTORIZA��O DSN"),

    /**
     * 
     */
    ACESSO_GERAR_BOLETO(Numeros.TRES, "TIPO ACESSO GERAR BOLETO"),

    /**
     * 
     */
    ACESSO_COTAR_CUSTO_EXTERNO(Numeros.QUATRO, "TIPO ACESSO BOT�O COTAR CUSTO EXTERNO"),

    /**
     * 
     */
    ACESSO_CONFIRMAR_INCLUIR(Numeros.CINCO, "TIPO ACESSO BOT�O CONFIRMAR"),
    
    /**
     * 
     */
    ACESSO_FECHAR(Numeros.NOVE, "TIPO ACESSO BOT�O FECHAR"),
    
    /**
     * 
     */
    ACESSO_CONFIRMAR_ALTERAR(Numeros.SESSENTA, "TIPO ACESSO BOT�O CONFIRMAR ALTERAR"),
    
    /**
     * 
     */
    ACESSO_CONFIRMAR_ALTERAR_PRINCIPAIS(Numeros.SEIS, "TIPO ACESSO BOT�O CONFIRMAR ALTERAR PRINCIPAIS"),
    /**
     * 
     */
    ACESSO_CONFIRMAR_DIVERGENTE(Numeros.DEZ, "TIPO ACESSO BOT�O CONFIRMAR DIVERGENTE"),
    
    /**
     * 
     */
    ACESSO_CONFIRMAR_FORFAITING(Numeros.ONZE, "TIPO ACESSO BOT�O CONFIRMAR FORFAITING"),
    
    /**
     * 
     */
    ACESSO_INCLUIR_DESEMBOLSO_FORFAITING(Numeros.CINQUENTA, "TIPO ACESSO BOT�O CONFIRMAR INCLUIR DESEMBOLSO FORFAITING"),
    
    /**
     * 
     */
    ACESSO_BAIXAR_SALDO_FORFAITING(Numeros.CINQUENTA_UM, "TIPO ACESSO BOT�O BAIXAR SALDO FORFAITING"),
    

    /**
     * 
     */
    FUNCAO_TIPO_INCLUSAO(Numeros.NUM10, "FUNCAO TIPO INCLUIR"),

    /**
     * 
     */
    FUNCAO_TIPO_ALTERAR(Numeros.NUM20, "FUNCAO TIPO ALTERAR"),

    /**
     * 
     */
    FUNCAO_TIPO_PRORROGAR_ALONGAR(Numeros.NUM30, "FUNCAO TIPO PRORROGAR/ALONGAR"),

    /**
     * 
     */
    FUNCAO_TIPO_INCLUSAO_DESEMBOLSO(Numeros.NUM40, "FUNCAO TIPO INCLUIR DESEMBOLSO"),

    /**
     * 
     */
    FUNCAO_TIPO_ADITAR(Numeros.NUM50, "FUNCAO TIPO ADITAR NCE"),
    
    /**
     * 
     */
    TIPO_PAPEL_TOMADOR(Numeros.NUM7, "TIPO PAPEL TOMADOR"),

    /**
     * 
     */
    PESQUISA_NOME_TOMADOR(Numeros.NUM3, "TIPO PESQUISA POR NOME TOMADOR"),

    /**
     * 
     */
    OPCAO_JUROS_EMBUTIDOS(Numeros.UM, "OPCAO JUROS EMBUTIDOS"),

    /**
     * 
     */
    OPCAO_JUROS_DEDUZIDOS(Numeros.DOIS, "OPCAO JUROS DEDUZIDOS"),

    /**
     * 
     */
    EVENTO_CALC_TAXAS_OPERACAO(Numeros.NUM11, "Calculo Taxas Opera��o Forfaiting"),

    /**
     * 
     */
    EVENTO_CALC_TAXAS_DESEMBOLSO(Numeros.NUM12, "Calculo Taxas Desembolso Forfaiting"),

    /**
     * 
     */
    EVENTO_ATUALIZACAO(Numeros.NUM100, "Evento Atualizacao do VO Forfaiting"),

    /**
     * 
     */
    EVENTO_INCLUIR_EXCLUIR_DESEMBOLSO(Numeros.NUM200, "Evento Matuten��o dos desembolsos Forfaiting"),

    /**
     * 
     */
    FLUXO_PAGAMENTO(Numeros.NUM90, "Rotina Fluxo de Pagamento"),

    /**
     * 
     */
    COMISSAO_INTERNA(Numeros.NUM100, "Rotina Comiss�o Interna"),

    /**
     * 
     */
    COMISSAO_EXTERNA(Numeros.NUM200, "Rotina Comiss�o Externa"),

    /**
     * 
     */
    DIGITACAO_VALOR(Numeros.NUM100, "Evento Digita��o campo Valor Desembolso"),

    /**
     * 
     */
    BOTAO_INCLUIR(Numeros.NUM200, "Evento Bot�o Incluir Desembolso"),

    /**
     * 
     */
    NAO_ZERAR_SALDO(Numeros.NUM1, "C�digo para n�o zerar Saldo"),

    /**
     * 
     */
    SIM_ZERAR_SALDO(Numeros.NUM2, "C�digo para zerar Saldo"),

    /**
     * 
     */
    TELA_INCLUIR_ALTERAR_FORFAITING(Numeros.NUM100, "Tela Incluir/Alterar forfaiting"),

    /**
     * 
     */
    TELA_INCLUIR_DESEMBOLSO(Numeros.NUM200, "Tela Incluir desembolso forfaiting"),

    /**
     * 
     */
    MOMENTO_UNICO(Numeros.NUM3, "C�digo Momenro �nico");
    
    private int codigo;

    private String descricao;

    /**
     * Construtor
     * 
     * @param @param arg0
     * @param @param arg1
     */
    private EnumTradeFinance(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
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

}
