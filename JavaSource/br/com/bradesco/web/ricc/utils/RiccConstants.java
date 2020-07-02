package br.com.bradesco.web.ricc.utils;

/**
 * @name RiccConstants
 * @author Foursys
 * @see RiccConstants.java
 * @version 1.0
 * @since 13/09/2018
 */
public final class RiccConstants {

	// Util
	public static final String FORMATO_DIA_MES_ANO = "dd.MM.yyyy";
	public static final String FORMATO_DIA_MES_ANO_BARRA = "dd/MM/yyyy";
	public static final String FORMATO_ANO_MES_DIA = "yyyy.MM.dd";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy '-' HH:mm:ss";
	public static final String TIMESTAMP = "yyyy-MM-dd-HH.mm.ss.SSSSSS";
	public static final String TIMESTAMP_MENOR = "yyyy-MM-dd-HH.mm.ss";
	public static final String FORMATO_HORA = "HH:mm:ss";
	public static final String VAZIO = "";
	public static final String SIM = "Sim";
	public static final String NAO = "Não";
	public static final String NA = "N/A";

	/********************************
	 * BEANS *
	 *******************************/

	public static final String BEAN_CADASTRAMENTO_RIC = "cadastramentoRicBean";

	public static final String BEAN_QUESTIONARIO_CORPORATE = "questionarioCorporateBean";
	public static final String BEAN_QUESTIONARIO_EMPRESAS = "questionarioEmpresasBean";
	public static final String BEAN_QUESTIONARIO_ALTOVAREJO = "questionarioAltoVarejoBean";
	public static final String BEAN_QUESTIONARIO_LARGE_CORPORATE = "questionarioLargeCorporateBean";

	public static final String BEAN_QUESTIONARIO_AGRONEGOCIO = "questionarioAgronegocioBean";
	public static final String BEAN_QUESTIONARIO_IMOBILIARIO = "questionarioImobiliarioBean";
	public static final String BEAN_QUESTIONARIO_TRANSPORTES = "questionarioTransportesBean";
	public static final String BEAN_QUESTIONARIO_PROJETOS = "questionarioProjetoBean";

	public static final String BEAN_CONSULTA_QUESTIONARIO_CORPORATE = "consultaQuestionarioCorporateBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_EMPRESAS = "consultaQuestionarioEmpresasBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_ALTOVAREJO = "consultaQuestionarioAltoVarejoBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_LARGE_CORPORATE = "consultaQuestionarioLargeCorporateBean";

	public static final String BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO = "consultaQuestionarioAgronegocioBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO = "consultaQuestionarioImobiliarioBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_TRANSPORTES = "consultaQuestionarioTransportesBean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_PROJETOS = "consultaQuestionarioProjetoBean";

	public static final String BEAN_DUPLAVALIDACAO_PARAMETRIZACAO = "duplaValidacaoBean";

	/********************************
	 * TELAS *
	 *******************************/

	public static final String TELA1_MENU1 = "menu1.tela1";
	public static final String TELA_INICIO = "teste.iniciar";
	public static final String TELA_PARAMETRIZACAO_RELATORIO = "parametrizacao.relatorio.iniciar";
	public static final String TELA_CADASTRO_RIC = "cadastro.ric.iniciar";
	public static final String TELA_DUPLAVALIDACAO_PARAMETRIZACAO = "duplavalidacao.parametrizacao.iniciar";
	public static final String TELA_TREINAMENTO_AJUDA = "treinamento.ajuda.iniciar";

	public static final String TELA_ANDRE_CLIENTE = "treinamento.andre.iniciar";
	public static final String TELA_ANDRE_CLIENTE_CONSULTAR = "consulta.treinamento.andre.iniciar";
	public static final String TELA_TREINAMENTO_LEONARDO_CLIENTE = "treinamento.leonardo.iniciar";
	public static final String TELA_TREINAMENTO_LEONARDO_CLIENTE_CONSULTA = "treinamento.leonardo.consulta.iniciar";
	public static final String TELA_TREINAMENTO_ISAAC = "treinamento.isaac.iniciar";
	public static final String TELA_TREINAMENTO_ISAAC_CONSULTA = "treinamento.isaac.consulta";

	// MANUTENCAO
	public static final String TELA_QUESTIONARIO_ALTOVAREJO = "cadastro.ric.altoVarejo.iniciar";
	public static final String TELA_QUESTIONARIO_CORPORATE = "cadastro.ric.corporate.iniciar";
	public static final String TELA_QUESTIONARIO_EMPRESAS = "cadastro.ric.empresas.iniciar";
	public static final String TELA_QUESTIONARIO_LARGE_CORPORATE = "cadastro.ric.largecorporate.iniciar";
	public static final String TELA_QUESTIONARIO_PROJETO = "cadastro.questionario.projeto.iniciar";
	public static final String TELA_QUESTIONARIO_IMOBILIARIO = "cadastro.questionario.imobiliario.iniciar";
	public static final String TELA_QUESTIONARIO_AGRONEGOCIO = "cadastro.questionario.agronegocio.iniciar";
	public static final String TELA_QUESTIONARIO_TRANSPORTES = "cadastro.questionario.transportes.iniciar";

	// CONSULTA
	public static final String TELA_CONSULTA_QUESTIONARIO_EMPRESAS = "cadastro.consulta.questionario.empresas.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_AGRONEGOCIO = "cadastro.consulta.questionario.agronegocio.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_IMOBILIARIO = "cadastro.consulta.questionario.imobiliario.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_PROJETO = "cadastro.consulta.questionario.projeto.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_TRANSPORTES = "cadastro.consulta.questionario.transportes.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_CORPORATE = "cadastro.consulta.questionario.corporate.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_ALTOVAREJO = "cadastro.consulta.questionario.altoVarejo.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_LARGE_CORPORATE = "cadastro.consulta.questionario.largecorporate.iniciar";

	/********************************
	 * MENSAGENS *
	 *******************************/

	public static final String FILTRO_DEVE_SER_SELECIONADO = "msg_filtro_deve_ser_selecionado";
	public static final String OPERACAO_EFETUADA_COM_SUCESSO = "msg_operacao_efetuada_com_sucesso";
	public static final String SELECIONE_UM_ITEM_NA_LISTA = "msg_selecione_um_item_lista";
	public static final String COMBINACAO_FILTROS_INVALIDA = "msg_combinacao_filtros_invalida";
	public static final String TIPO_PESQUISA_INVALIDO = "msg_tipo_pesquisa_invalido";
	public static final String O_CAMPO = "msg_o_campo";
	public static final String TODOS_OS_CAMPOS = "msg_todos_campos";
	public static final String TODOS_OS_CAMPOS_COLUNA = "msg_todos_campos_primeira_coluna";
	public static final String DE_DOIS_PONTOS = "msg_de_dois_pontos";
	public static final String DO_BLOCO = "msg_do_bloco";
	public static final String OBRIGATORIO = "msg_obrigatorio";
	public static final String OBRIGATORIOS = "msg_obrigatorios";
	public static final String ESPACO = " ";
	public static final String CENTRO_CUSTO = "rotulo_centro_custo";
	public static final String CODIGO_PROCESSO_NEGOCIO = "rotulo_codigo_processo_negocio";
	public static final String INCLUSAO_EFETUADA_SUCESSO = "msg_inclusao_sucesso";
	public static final String EXCLUSAO_EFETUADA_SUCESSO = "msg_exclusao_sucesso";
	public static final String CADASTRO_EFETUADO_SUCESSO = "msg_cadastro_efetuado";
	public static final String RELATORIO_SALVO_SUCESSO = "msg_salvar_sucesso";
	public static final String RELATORIO_CONCLUIDO_SUCESSO = "msg_concluir_sucesso";
	public static final String PERCENTUAL_TOTAL_CEM = "msg_percentual_obrigatorio";
	public static final String PERCENTUAL_VAZIO = "msg_percentual_vazio";
	public static final String PERCENTUAL_MAIOR_QUE_CEM = "msg_percentual_maior_que_cem";
	public static final String DATA_INVALIDA = "msg_data_invalida";
	public static final String SOMA_PERCENTUAL_MAIOR_QUE_CEM = "msg_soma_percentual_maior_que_cem";
	public static final String ANO_CUSTOS_OPERACIONAIS_OBRIGATORIO = "msg_campo_ano_custos_operacionais";

	/********************************
	 * CODIGOS *
	 *******************************/

	// SEGMENTO
	public static final Long SEGMENTO_CORPORATE = 1L;
	public static final Long SEGMENTO_EMPRESAS = 2L;
	public static final Long SEGMENTO_ALTOVAREJO = 3L;
	public static final Long SEGMENTO_LARGE_CORPORATE = 4L;

	// SETOR
	public static final Long SETOR_AGRONEGOCIO = 1L;
	public static final Long SETOR_IMOBILIARIO = 2L;
	public static final Long SETOR_PROJETOS = 3L;
	public static final Long SETOR_TRANSPORTES = 4L;

	// TIPO AREA
	public static final String NOME_PRODUTOR = "0";
	public static final String AREA_PROPRIA = "1";
	public static final String AREA_ARRENDADA = "2";

	// TIPO CLIENTE
	public static final String COD_TIPO_FORNECEDOR = "1";
	public static final String COD_TIPO_CLIENTE = "2";
	public static final String COD_TIPO_FORMA_RECEBIMENTO = "3";
	public static final String COD_TIPO_CONCORRENTE = "4";

	// TIPOS MANUNTENCAO
	public static final String MANUTENCAO_INCLUSAO = "1";
	public static final String MANUTENCAO_EXCLUSAO = "2";
	public static final String MANUTENCAO_ALTERACAO = "3";

	// TIPOS DE PESQUISA
	public static final String PESQUISA_CNPJ = "1";
	public static final String PESQUISA_NUMERO_GRUPO = "2";
	public static final String PESQUISA_NOME_GRUPO = "3";

	// STATUS
	public static final String STATUS_ATIVO = "1";
	public static final String STATUS_PENDENTE = "2";
	public static final String STATUS_HISTORICO = "3";
	public static final String STATUS_TODOS = "4";

	// TIPO COMENTARIO
	public static final String TIPO_COMENTARIO_SEGMENTO = "1";
	public static final String TIPO_COMENTARIO_QUADRO_ADM = "2";
	public static final String TIPO_COMENTARIO_PATRIMONIO = "3";
	public static final String TIPO_COMENTARIO_CAPAC_PRODUTIVA = "4";
	public static final String TIPO_COMENTARIO_CLIENTE_FORNECEDOR = "5";
	public static final String TIPO_COMENTARIO_CONTRATOS_CLIENTE = "6";
	public static final String TIPO_COMENTARIO_FATURAMENTO_CONSOLIDADO = "7";
	public static final String TIPO_COMENTARIO_BALANCO_EMPRESA = "8";
	public static final String TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO = "9";
	public static final String TIPO_COMENTARIO_RECIPROCIDADE = "10";
	public static final String TIPO_COMENTARIO_QUADRO_ATIVOS = "11";
	public static final String TIPO_COMENTARIO_EXP_CAMBIAL = "12";
	public static final String TIPO_COMENTARIO_PERSPECTIVAS = "13";
	public static final String TIPO_COMENTARIO_IMOBILIARIO = "14";
	public static final String TIPO_COMENTARIO_TRANSPORTE = "15";
	public static final String TIPO_COMENTARIO_PROJETOS = "16";

	/********************************
	 * CODIGOS MAINFRAME *
	 *******************************/

	public static final String MAINFRAME_CONSULTA_VAZIA = "RICC0199";
	public static final String MAINFRAME_VALIDACAO_PORCENTAGEM = "RICC0035";

	// TREINAMENTO RICC
	public static final String TREINAMENTO_OPCAO_1 = "Opção 1 - ComboBox Treinamento";
	public static final String TREINAMENTO_OPCAO_2 = "Opção 2 - ComboBox Treinamento";
	public static final String TREINAMENTO_OPCAO_3 = "Opção 3 - ComboBox Treinamento";
	public static final String TREINAMENTO_OPCAO_4 = "Opção 4 - ComboBox Treinamento";
	public static final String TREINAMENTO_OPCAO_5 = "Opção 5 - ComboBox Treinamento";
	public static final String TREINAMENTO_OPCAO_6 = "Opção 6 - ComboBox Treinamento";

	public static final String TREINAMENTO_ANDRE_CIDADE_1 = "Osasco";
	public static final String TREINAMENTO_ANDRE_CIDADE_2 = "Barueri";
	public static final String TREINAMENTO_ANDRE_CIDADE_3 = "Carapicuiba";
	public static final String TREINAMENTO_ANDRE_CIDADE_4 = "São Paulo";
	public static final String TREINAMENTO_ANDRE_CIDADE_5 = "Niterói";
	public static final String TREINAMENTO_ANDRE_CIDADE_6 = "Rio de Janeiro";
	public static final String TREINAMENTO_ANDRE_CIDADE_7 = "Curitiba";
	public static final String TREINAMENTO_ANDRE_CIDADE_8 = "Salvador";
	public static final String TREINAMENTO_ANDRE_CIDADE_9 = "Belo horizonte";
	public static final String TREINAMENTO_ANDRE_CIDADE_10 = "Goiania";

	public static final String TREINAMENTO_ANDRE_ESTADO_1 = "São Paulo";
	public static final String TREINAMENTO_ANDRE_ESTADO_2 = "Rio de Janeiro";
	public static final String TREINAMENTO_ANDRE_ESTADO_3 = "Paraná";
	public static final String TREINAMENTO_ANDRE_ESTADO_4 = "Bahia";
	public static final String TREINAMENTO_ANDRE_ESTADO_5 = "Minas Gerais";
	public static final String TREINAMENTO_ANDRE_ESTADO_6 = "Goiás";
	public static final String TREINAMENTO_ANDRE_ESTADO_7 = "Tocantins";
	public static final String TREINAMENTO_ANDRE_ESTADO_8 = "Acre";
	public static final String TREINAMENTO_ANDRE_ESTADO_9 = "Sergipe";
	public static final String TREINAMENTO_ANDRE_ESTADO_10 = "Amazonas";

	// COMBO CIDADE LEONARDOCLIENTE RICC
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_1 = "Aracaju";
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_2 = "Barueri";
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_3 = "Curitiba";
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_4 = "Rio Branco";
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_5 = "Osasco";
	public static final String COMBO_CIDADE_LEONARDO_OPCAO_6 = "São Paulo";

	// COMBO ESTADO LEONARDOCLIENTE RICC
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_1 = "Acre";
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_2 = "Bahia";
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_3 = "Ceará";
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_4 = "Minas Gerais";
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_5 = "Sergipe";
	public static final String COMBO_ESTADO_LEONARDO_OPCAO_6 = "São Paulo";

	public static final String TREINAMENTO_ISAAC_CIDADE = "Selecione Cidade - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_PARIS = "Paris - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_HONGKONG = "Hong Kong - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_MADRI = "Madri - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_LONDRES = "Londres - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_NOVAYORK = "Nova York - ComboBox Treinamento Isaac";

	public static final String TREINAMENTO_ISAAC_ESTADO = "Selecione Estado - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_CALIFORNIA = "California - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_FLORIDA = "Flórida - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_BAHIA = "Bahia - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_PARANA = "Paraná - ComboBox Treinamento Isaac";
	public static final String TREINAMENTO_ISAAC_SANTA_CATARINA = "Santa Catarina- ComboBox Treinamento Isaac";

	// Wellington Constants
	public static final String TREINAMENTO_WELLINGTON_OPCAO_1 = "Opção 1 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_2 = "Opção 2 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_3 = "Opção 3 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_4 = "Opção 4 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_5 = "Opção 5 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_6 = "Opção 6 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_7 = "Opção 6 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_8 = "Opção 6 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_9 = "Opção 6 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_OPCAO_10 = "Opção 6 - ComboBox Treinamento";
	public static final String TREINAMENTO_WELLINGTON_SP = "São Paulo";
	public static final String TREINAMENTO_WELLINGTON_RJ = "Rio de Janeiro";
	public static final String TREINAMENTO_WELLINGTON_MG = "Minas Gerais";
	public static final String TREINAMENTO_WELLINGTON_ES = "Espirito Santo";
	public static final String TREINAMENTO_WELLINGTON_BA = "Bahia";
	public static final String TREINAMENTO_WELLINGTON_RO = "Rondonia";
	public static final String TREINAMENTO_WELLINGTON_OSASCO = "Osasco";
	public static final String TREINAMENTO_WELLINGTON_ARRAIAL_DO_CABO = "Arraial do Cabo";
	public static final String TREINAMENTO_WELLINGTON_VILA_VELHA = "Vila Velha";
	public static final String TREINAMENTO_WELLINGTON_VITORIA = "Vitória";
	public static final String TREINAMENTO_WELLINGTON_BELO_HORIZONTE = "Belo Horizonte";
	public static final String TREINAMENTO_WELLINGTON_SALVADOR = "Salvador";
	public static final String TREINAMENTO_WELLINGTON_PORTO_VELHO = "Porto Velho";
	public static final String TREINAMENTO_WELLINGTON_SELECIONE_ESTADO = "-Selecione o Estado-";
	public static final String TREINAMENTO_WELLINGTON_SELECIONE_CIDADE = "-Selecione a Cidade-";
	public static final String TELA_TREINAMENTO_INSERIR_CLIENTE = "treinamento.inserir.cliente.iniciar";
	public static final String TELA_TREINAMENTO_CONSULTAR_CLIENTE = "treinamento.consultar.cliente.iniciar";
	public static final String TELA_TREINAMENTO_TESTE_INSERIR_CLIENTE = "treinamento.inserir.teste.cliente.iniciar";
	public static final String TELA_TREINAMENTO_TESTE_CONSULTAR_CLIENTE = "treinamento.consultar.teste.cliente.iniciar";

	public static final String TELA_ANDERSON_CLIENTE_CADASTRO = "anderson.cliente.cadastro.iniciar";
	public static final String TELA_ANDERSON_TESTE_CADASTRO = "anderson.teste.cadastro.iniciar";
	public static final String TELA_ANDERSON_TESTE_CONSULTA = "anderson.teste.consulta.iniciar";
	public static final String TELA_ANDERSON_CLIENTE_CONSULTA = "anderson.cliente.consulta.iniciar";

	// TREINAMENTO ANDERSON CIDADES
	public static final String TREINAMENTO_ANDERSON_CIDADE_BARUERI = "Barueri";
	public static final String TREINAMENTO_ANDERSON_CIDADE_CARAPICUIBA = "Carapicuiba";
	public static final String TREINAMENTO_ANDERSON_CIDADE_JANDIRA = "Jandira";
	public static final String TREINAMENTO_ANDERSON_CIDADE_OSASCO = "Osasco";
	public static final String TREINAMENTO_ANDERSON_CIDADE_ITAPEVI = "Itapevi";

	// TREINAMENTO ANDERSON ESTADOS
	public static final String TREINAMENTO_ANDERSON_ESTADO_SAOPAULO = "São Paulo";
	public static final String TREINAMENTO_ANDERSON_ESTADO_RIODEJANEIRO = "Rio de Janeiro";
	public static final String TREINAMENTO_ANDERSON_ESTADO_MINASGERAIS = "Minas Gerais";
	public static final String TREINAMENTO_ANDERSON_ESTADO_ACRE = "Acre";
	public static final String TREINAMENTO_ANDERSON_ESTADO_BAHIA = "Bahia";

	public static final String TREINAMENTO_JOAOGIL_SEXO1 = "M";
	public static final String TREINAMENTO_JOAOGIL_SEXO2 = "F";
	public static final String TREINAMENTO_JOAOGIL_CODIGO1 = "1";
	public static final String TREINAMENTO_JOAOGIL_CODIGO2 = "2";
	public static final String TREINAMENTO_JOAOGIL_CODIGO3 = "3";
	public static final String TREINAMENTO_JOAOGIL_CODIGO4 = "4";
	public static final String TREINAMENTO_JOAOGIL_CODIGO5 = "5";

	public static final String TELA_TREINAMENTO_JOAOGIL_CLIENTE = "treinamento.joaoGil.iniciar";
	public static final String TELA_TREINAMENTO_JOAOGIL_CONSULTA = "treinamento.joaoGil.iniciarConsulta";

	public static final String TELA_TREINAMENTO_ENZO_ESTADO_SP = "treinamento.enzo.iniciar";
	public static final String TELA_TREINAMENTO_ENZO_ESTADO_SP2 = "treinamento.enzo.consulta";
	public static final String TELA_TREINAMENTO_ENZO_TESTE_CADASTRO = "treinamento.enzo.iniciarTesteCadastro";

	public static final String TELA_TREINAMENTO_ENZO_TESTE_CONSULTA = "treinamento.enzo.iniciarTesteConsulta";

	public static final String TELA_TREINAMENTO_JOAOCARLOS_CADASTRO_CLIENTE = "joao.carlos.cadastro.cliente.iniciar";
	public static final String TELA_TREINAMENTO_JOAOCARLOS_CONSULTA_CLIENTE = "joao.carlos.consulta.cliente.iniciar";

	public static final String TELA_TESTE_JOAOCARLOS_CADASTRO = "joao.carlos.teste.cadastro.iniciar";
	public static final String TELA_TESTE_JOAOCARLOS_CONSULTA = "joao.carlos.teste.consulta.iniciar";

	public static final String SELECIONE_CIDADE_TREINAMENTO_JOAO_CARLOS = "Selecione a cidade";
	public static final String OSASCO_TREINAMENTO_JOAO_CARLOS = "Osasco";
	public static final String RIO_DE_JANEIRO_TREINAMENTO_JOAO_CARLOS = "Rio de Janeiro";
	public static final String BELO_HORIZONTE_TREINAMENTO_JOAO_CARLOS = "Belo Horizonte";
	public static final String CURITIBA_TREINAMENTO_JOAO_CARLOS = "Curitiba";
	public static final String FLORIANOPOLIS_TREINAMENTO_JOAO_CARLOS = "Florianópolis";

	public static final String SELECIONE_ESTADO_TREINAMENTO_JOAO_CARLOS = "Selecione o Estado";
	public static final String SAO_PAULO_TREINAMENTO_JOAO_CARLOS = "São Paulo";
	public static final String MINAS_GERAIS_TREINAMENTO_JOAO_CARLOS = "Minas Gerais";
	public static final String PARANA_TREINAMENTO_JOAO_CARLOS = "Paraná";
	public static final String SANTA_CATARINA_TREINAMENTO_JOAO_CARLOS = "Santa Catarina";

	public static final String BEAN_ENRICO_CLIENTE = "enricoClienteBean";
	public static final String TELA_ENRICO_CLIENTE = "enrico.cliente.iniciar";
	public static final String TELA_ENRICO_CLIENTE_CONSULTA = "enrico.cliente.consulta.iniciar";
	public static final String TELA_ENRICO_TESTE_CADASTRO = "enrico.teste.cadastro";
	public static final String TELA_ENRICO_TESTE_CONSULTA = "enrico.teste.consulta";

	public static final String TREINAMENTO_ENRICO_CIDADE_SELECIONE_CIDADE = "Selecione a Cidade - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_OSASCO = "Osasco - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_SAO_PAULO = "São Paulo - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_JANDIRA = "Jandira - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_ITAPEVI = "Itapevi - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_SAO_BERNARDO = "São Bernardo - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_BARUERI = "Barueri - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_MAUA = "Mauá - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_SANTO_ANDRE = "Santo André - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_CARAPICUIBA = "Carapicuiba - ComboBox Cidade";
	public static final String TREINAMENTO_ENRICO_CIDADE_COTIA = "Cotia - ComboBox Cidade";

	public static final String TREINAMENTO_ENRICO_ESTADO_SELECIONE_ESTADO = "Selecione o Estado - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_RIO_DE_JANEIRO = "Rio de Janeiro - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_SAO_PAULO = "São Paulo - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_MINAS_GERAIS = "Minas Gerais - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_ESPIRITO_SANTO = "Espirito Santo - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_GOIAS = "Goias - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_BAHIA = "Bahia - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_PARANA = "Paraná - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_ACRE = "Acre - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_MATO_GROSSO = "Mato Grosso - ComboBox Estado";
	public static final String TREINAMENTO_ENRICO_ESTADO_SANTA_CATARINA = "Santa Catarina - ComboBox Estado";

	// TREINAMENTO RICC VITORIA
	public static final String TREINAMENTO_VITORIA_CIDADE_1 = "Cidade 1 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_CIDADE_2 = "Cidade 2 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_CIDADE_3 = "Cidade 3 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_CIDADE_4 = "Cidade 4 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_CIDADE_5 = "Cidade 5 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_CIDADE_6 = "Cidade 6 - ComboBox Treinamento";

	public static final String TREINAMENTO_VITORIA_ESTADO_1 = "Estado 1 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_ESTADO_2 = "Estado 2 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_ESTADO_3 = "Estado 3 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_ESTADO_4 = "Estado 4 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_ESTADO_5 = "Estado 5 - ComboBox Treinamento";
	public static final String TREINAMENTO_VITORIA_ESTADO_6 = "Estado 6 - ComboBox Treinamento";

	public static final String TELA_TREINAMENTO_VITORIA = "treinamento.vitoria.iniciar";
	public static final String TELA_TREINAMENTO_VITORIA_CONSULTA = "treinamento.vitoria.consulta";

	public static final String TREINAMENTO_PEDRO_ESTADO_SP = "São Paulo - SP";
	public static final String TREINAMENTO_PEDRO_ESTADO_RJ = "Rio de Janeiro - RJ";
	public static final String TREINAMENTO_PEDRO_ESTADO_MG = "Minas Gerais - MG";
	public static final String TREINAMENTO_PEDRO_ESTADO_ES = "Espírito Santo - ES";
	public static final String TREINAMENTO_PEDRO_ESTADO_BA = "Bahia - BA";
	public static final String TREINAMENTO_PEDRO_ESTADO_RS = "Rio Grande do Sul - RS";
	public static final String TREINAMENTO_PEDRO_ESTADO_PA = "Pará - PA";
	public static final String TREINAMENTO_PEDRO_ESTADO_PR = "Paraná - PR";
	public static final String TREINAMENTO_PEDRO_ESTADO_RR = "Roraima - RR";
	public static final String TREINAMENTO_PEDRO_ESTADO_SE = "Sergipe - SE";
	public static final String TREINAMENTO_PEDRO_SEXO_MASCULINO = "M";
	public static final String TREINAMENTO_PEDRO_SEXO_FEMININO = "F";
	public static final String TREINAMENTO_PEDRO_CIDADE_1 = "Osasco";
	public static final String TREINAMENTO_PEDRO_CIDADE_2 = "Parati";
	public static final String TREINAMENTO_PEDRO_CIDADE_3 = "Ouro Preto";
	public static final String TREINAMENTO_PEDRO_CIDADE_4 = "Vitória";
	public static final String TREINAMENTO_PEDRO_CIDADE_5 = "Salvador";
	public static final String TREINAMENTO_PEDRO_CIDADE_6 = "Porto Alegre";
	public static final String TREINAMENTO_PEDRO_CIDADE_7 = "Belém";
	public static final String TREINAMENTO_PEDRO_CIDADE_8 = "Cascavel";
	public static final String TREINAMENTO_PEDRO_CIDADE_9 = "Boa Vista";
	public static final String TREINAMENTO_PEDRO_CIDADE_10 = "Tobias Barreto";

	public static final String TELA_TREINAMENTO_PEDRO_CLIENTE = "treinamento.pedro.cliente.iniciar";
	public static final String TELA_TREINAMENTO_PEDRO_CLIENTE_CONSULTA = "treinamento.pedro.cliente.consulta.iniciar";
	public static final String TREINAMENTO_PEDRO_TESTE_CADASTRO_INICIAR = "treinamento.pedro.teste.cadastro.iniciar";
	public static final String TREINAMENTO_PEDRO_TESTE_CONSULTA_INICIAR = "treinamento.pedro.teste.consulta.iniciar";
	public static final String TELA_TREINAMENTO_SWRM_TESTE = "treinamento.pedro.swrm.teste.iniciar";
	public static final String TELA_TREINAMENTO_PEDRO_CADASTRO = "treinamento.pedro.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_PEDRO_CONSULTA = "treinamento.pedro.consulta.iniciar";

	// MATHEUS TREINAMENTO
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_0 = "Opção 0 - Selecione a Cidade";
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_1 = "Opção 1 - Osasco";
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_2 = "Opção 2 - Carapicuiba";
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_3 = "Opção 3 - Barueri";
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_4 = "Opção 4 - Búzios";
	public static final String TREINAMENTO_MATHEUS_CIDADE_OPCAO_5 = "Opção 5 - Copacabana";

	public static final String TREINAMENTO_MATHEUS_ESTADO_OPCAO_0 = "Opção 0 - Selecione o Estado";
	public static final String TREINAMENTO_MATHEUS_ESTADO_OPCAO_1 = "Opção 1 - São Paulo";
	public static final String TREINAMENTO_MATHEUS_ESTADO_OPCAO_2 = "Opção 2 - Rio de Janeiro";

	public static final String TELA_TREINAMENTO_MATHEUS_CLIENTE = "matheus.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_MATHEUS_CLIENTE_CONSULTAR = "matheus.consultar.iniciar";
	public static final String TELA_TREINAMENTO_MATHEUS_TESTE_CADASTRO = "matheus.teste.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_MATHEUS_TESTE_CONSULTA = "matheus.teste.consulta.iniciar";

	public static final String FELIPE_OPCAO_0 = "0";
	public static final String FELIPE_OPCAO_1 = "1";
	public static final String FELIPE_OPCAO_2 = "2";
	public static final String FELIPE_OPCAO_3 = "3";
	public static final String FELIPE_OPCAO_4 = "4";
	public static final String FELIPE_OPCAO_5 = "5";
	public static final String FELIPE_OPCAO_6 = "6";

	public static final String TELA_FELIPE_CLIENTE_INSERIR = "treinamento.felipe.iniciar";
	public static final String TELA_FELIPE_CLIENTE_CONSULTAR = "felipe.iniciar.consultar";
	public static final String TELA_FELIPE_TESTE_CLIENTE_CADASTRO = "felipe.iniciar.teste.cadastro";
	public static final String TELA_FELIPE_TESTE_CLIENTE_CONSULTA = "felipe.iniciar.teste.consultar";
	public static final String TELA_FELIPE_EXPERIENCIA_CLIENTE_CADASTRO = "felipe.iniciar.experiencia.cadastro";
	public static final String TELA_FELIPE_EXPERIENCIA_CLIENTE_CONSULTA = "felipe.iniciar.experiencia.consultar";

	// TREINAMENTO CIDADES (GUILHERME)
	public static final String TREINAMENTO_GUILHERME_CIDADE_1 = "Cotia - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_2 = "Osasco - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_3 = "Pelourinho - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_4 = "Belo Horizonte - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_5 = "Palmas - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_6 = "Macaé- ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_7 = "Rio Negrinho - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_8 = "Jandira - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_9 = "Mauá - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_CIDADE_10 = "Passa Quatro - ComboBox Treinamento";

	// TREINAMENTO ESTADOS (GUILHERME)
	public static final String TREINAMENTO_GUILHERME_ESTADO_1 = "São Paulo - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_ESTADO_2 = "Rio de Janeiro - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_ESTADO_3 = "Minas Gerais - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_ESTADO_4 = "Tocantins - ComboBox Treinamento";
	public static final String TREINAMENTO_GUILHERME_ESTADO_5 = "Santa Catarina - ComboBox Treinamento";

	public static final String TELA_GUILHERME_CLIENTE_INSERIR = "treinamento.guilherme.iniciar";
	public static final String TELA_GUILHERME_CLIENTE_CONSULTAR = "treinamento.guilherme.consultar.iniciar";

	// TELA TREINAMENTO NATALIA
	public static final String TELA_TREINAMENTO_NATALIA_CLIENTE = "treinamento.natalia.cliente.iniciar";
	public static final String TELA_TREINAMENTO_NATALIA_CONSULTA = "treinamento.natalia.consulta.iniciar";

	// TREINAMENTO NATALIA ESTADO
	public static final String TREINAMENTO_NATALIA_ESTADO_1 = "- Selecione Estado -";
	public static final String TREINAMENTO_NATALIA_ESTADO_2 = "Acre - AC";
	public static final String TREINAMENTO_NATALIA_ESTADO_3 = "Alagoas - AL";
	public static final String TREINAMENTO_NATALIA_ESTADO_4 = "Amazonas - AM";
	public static final String TREINAMENTO_NATALIA_ESTADO_5 = "Amapá - AP";
	public static final String TREINAMENTO_NATALIA_ESTADO_6 = "Bahia - BA";
	public static final String TREINAMENTO_NATALIA_ESTADO_7 = "Ceará - CE";
	public static final String TREINAMENTO_NATALIA_ESTADO_8 = "Distrito Federal - DF";
	public static final String TREINAMENTO_NATALIA_ESTADO_9 = "Espírito Santo - ES";
	public static final String TREINAMENTO_NATALIA_ESTADO_10 = "Goiás - GO";
	public static final String TREINAMENTO_NATALIA_ESTADO_11 = "Maranhão - MA";
	public static final String TREINAMENTO_NATALIA_ESTADO_12 = "Mato Grosso - MT";
	public static final String TREINAMENTO_NATALIA_ESTADO_13 = "Mato Grosso do Sul - MS";
	public static final String TREINAMENTO_NATALIA_ESTADO_14 = "Minas Gerais - MG";
	public static final String TREINAMENTO_NATALIA_ESTADO_15 = "Pará - PA";
	public static final String TREINAMENTO_NATALIA_ESTADO_16 = "Paraíba - PB";
	public static final String TREINAMENTO_NATALIA_ESTADO_17 = "Paraná - PR";
	public static final String TREINAMENTO_NATALIA_ESTADO_18 = "Pernambuco - PE";
	public static final String TREINAMENTO_NATALIA_ESTADO_19 = "Piauí - PI";
	public static final String TREINAMENTO_NATALIA_ESTADO_20 = "Rio de Janeiro - RJ";
	public static final String TREINAMENTO_NATALIA_ESTADO_21 = "Rio Grande do Norte - RN";
	public static final String TREINAMENTO_NATALIA_ESTADO_22 = "Rio Grande do Sul - RS";
	public static final String TREINAMENTO_NATALIA_ESTADO_23 = "Rondônia - RO";
	public static final String TREINAMENTO_NATALIA_ESTADO_24 = "Roraima - RR";
	public static final String TREINAMENTO_NATALIA_ESTADO_25 = "Santa Catarina - SC";
	public static final String TREINAMENTO_NATALIA_ESTADO_26 = "São Paulo - SP";
	public static final String TREINAMENTO_NATALIA_ESTADO_27 = "Sergipe - SE";
	public static final String TREINAMENTO_NATALIA_ESTADO_28 = "Tocantins - TO";

	// TREINAMENTO NATALIA CIDADE
	public static final String TREINAMENTO_NATALIA_CIDADE_1 = "- Selecione Cidade -";
	public static final String TREINAMENTO_NATALIA_CIDADE_2 = "Rio Branco";
	public static final String TREINAMENTO_NATALIA_CIDADE_3 = "Maceió";
	public static final String TREINAMENTO_NATALIA_CIDADE_4 = "Macapá";
	public static final String TREINAMENTO_NATALIA_CIDADE_5 = "Manaus";
	public static final String TREINAMENTO_NATALIA_CIDADE_6 = "Salvador";
	public static final String TREINAMENTO_NATALIA_CIDADE_7 = "Fortaleza";
	public static final String TREINAMENTO_NATALIA_CIDADE_8 = "Brasília";
	public static final String TREINAMENTO_NATALIA_CIDADE_9 = "Serra";
	public static final String TREINAMENTO_NATALIA_CIDADE_10 = "Goiânia";
	public static final String TREINAMENTO_NATALIA_CIDADE_11 = "São Luís";
	public static final String TREINAMENTO_NATALIA_CIDADE_12 = "Cuiabá";
	public static final String TREINAMENTO_NATALIA_CIDADE_13 = "Campo Grande";
	public static final String TREINAMENTO_NATALIA_CIDADE_14 = "Belo Horizonte";
	public static final String TREINAMENTO_NATALIA_CIDADE_15 = "Belém";
	public static final String TREINAMENTO_NATALIA_CIDADE_16 = "João Pessoa";
	public static final String TREINAMENTO_NATALIA_CIDADE_17 = "Curitiba";
	public static final String TREINAMENTO_NATALIA_CIDADE_18 = "Recife";
	public static final String TREINAMENTO_NATALIA_CIDADE_19 = "Teresina";
	public static final String TREINAMENTO_NATALIA_CIDADE_20 = "Rio de Janeiro";
	public static final String TREINAMENTO_NATALIA_CIDADE_21 = "Natal";
	public static final String TREINAMENTO_NATALIA_CIDADE_22 = "Porto Alegre";
	public static final String TREINAMENTO_NATALIA_CIDADE_23 = "Porto Velho";
	public static final String TREINAMENTO_NATALIA_CIDADE_24 = "Boa Vista";
	public static final String TREINAMENTO_NATALIA_CIDADE_25 = "Joinville";
	public static final String TREINAMENTO_NATALIA_CIDADE_26 = "São Paulo";
	public static final String TREINAMENTO_NATALIA_CIDADE_27 = "Aracaju";
	public static final String TREINAMENTO_NATALIA_CIDADE_28 = "	Palmas";

	public static final String TELA_CLAUDIO_CLIENTE = "claudio.cliente.iniciar";
	public static final String TELA_CLAUDIO_CLIENTE_CONSULTA = "claudio.cliente.consulta.iniciar";
	public static final String TELA_CLAUDIO_TESTE_CADASTRAR = "claudio.teste.cadastro";
	public static final String TELA_CLAUDIO_TESTE_CONSULTA = "claudio.teste.consulta";

	public static final String CIDADE_OSASCO_CLAUDIO = "Osasco - ComboBox Cidade";
	public static final String CIDADE_COTIA_CLAUDIO = "Cotia - ComboBox Cidade";
	public static final String CIDADE_SAO_PAULO_CLAUDIO = "São Paulo - ComboBox Cidade";
	public static final String CIDADE_CARAPICUIBA_CLAUDIO = "Carapicuiba - ComboBox Cidade";
	public static final String CIDADE_BARUERI_CLAUDIO = "Barueri - ComboBox Cidade";
	public static final String CIDADE_RIO_DE_JANEIRO_CLAUDIO = "Rio de Janeiro - ComboBox Cidade";
	public static final String CIDADE_SAO_CAETANO_CLAUDIO = "São Caetano - ComboBox Cidade";
	public static final String CIDADE_BANGU_CLAUDIO = "Bangu - ComboBox Cidade";
	public static final String CIDADE_RIBEIRAO_PRETO_CLAUDIO = "Ribeirão preto - ComboBox Cidade";
	public static final String CIDADE_TIJUCA_CLAUDIO = "Tijuca - ComboBox Cidade";

	public static final String ESTADO_SAO_PAULO_CLAUDIO = "São Paulo - ComboBox Estado";
	public static final String ESTADO_RIO_DE_JANEIRO_CLAUDIO = "Rio de Janeiro - ComboBox Estado";
	public static final String ESTADO_MINAS_GERAIS_CLAUDIO = "Minas Gerais - ComboBox Estado";
	public static final String ESTADO_SANTA_CATARINA_CLAUDIO = "Santa Catarina - ComboBox Estado";
	public static final String ESTADO_BAHIA_CLAUDIO = "Bahia - ComboBox Estado";
	public static final String ESTADO_PERNAMBUCO_CLAUDIO = "Pernambuco - ComboBox Estado";
	public static final String ESTADO_GOIAS_CLAUDIO = "Goias - ComboBox Estado";
	public static final String ESTADO_ALAGOAS_CLAUDIO = "Alagoas - ComboBox Estado";
	public static final String ESTADO_PARA_CLAUDIO = "Para - ComboBox Estado";
	public static final String ESTADO_TOCANTINS_CLAUDIO = "Tocantins - ComboBox Estado";

	public static final String TELA_TREINAMENTO_GUSTAVO = "treinamento.gustavo.iniciar";
	public static final String TELA_TREINAMENTO_GUSTAVO_CONSULTA = "treinamento.gustavo.consulta.iniciar";
	public static final String TELA_TREINAMENTO_TESTE_GUSTAVO = "treinamento.gustavo.teste.iniciar";
	public static final String TELA_TREINAMENTO_TESTE_GUSTAVO_CONSULTA = "treinamento.gustavo.teste.consulta.iniciar";

	public static final String TREINAMENTO_GUSTAVO_OPCAO_1 = "Opção 1 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_2 = "Opção 2 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_3 = "Opção 3 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_4 = "Opção 4 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_5 = "Opção 5 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_6 = "Opção 6 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_7 = "Opção 7 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_8 = "Opção 8 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_9 = "Opção 9 ";
	public static final String TREINAMENTO_GUSTAVO_OPCAO_10 = "Opção 10 ";

	/**************************
	 * TELA CADASTRO VINICIUS *
	 **************************/
	public static final String TELA_TREINAMENTO_VINICIUS_CADASTRO = "treinamento.vinicius.iniciar";
	public static final String TELA_TREINAMENTO_VINICIUS_CONSULTA = "treinamento.vinicius.consulta";
	public static final String TELA_TREINAMENTO_VINICIUS_TESTE = "treinamento.vinicius.teste";

	public static final String TREINAMENTO_VINICIUS_OSASCO = "Osasco - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_BARUERI = "Barueri - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_CARAPICUIBA = "Carapicuiba - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_SANTOS = "Santos - ComboBox Treinamento";

	public static final String TREINAMENTO_VINICIUS_SAO_PAULO = "São Paulo - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_PARANA = "Parana - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_RIO_JANEIRO = "Rio de Janeiro - ComboBox Treinamento";
	public static final String TREINAMENTO_VINICIUS_MINAS_GERAIS = "Minas Gerais - ComboBox Treinamento";

	public static final String TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE = "treinamento.equipe1.consulta.iniciar";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_AGRONEGOCIO = "treinamento.equipe1.consulta.agronegocio.iniciar";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_AGRONEGOCIO_BEAN = "equipe1ConsultaQuestionarioAgronegocioBean";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_PROJETO = "treinamento.equipe1.consulta.projeto.iniciar";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_PROJETO_BEAN = "equipe1ConsultaQuestionarioProjetoBean";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_IMOBILIARIO = "treinamento.equipe1.consulta.imobiliario.iniciar";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_IMOBILIARIO_BEAN = "equipe1ConsultaQuestionarioImobiliarioBean";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_TRANSPORTES = "treinamento.equipe1.consulta.transportes.iniciar";
	public static final String TREINAMENTO_EQUIPE1_CONSULTA_TRANSPORTES_BEAN = "equipe1ConsultaQuestionarioTransportesBean";

	/**************************
	 * TELA CONSULTA EQUIPE2 *
	 **************************/

	public static final String TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2 = "equipe2.cadastro.consulta.questionario.empresas.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_CODGRUPO = "9";
	public static final String TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_NOMEGRUPO = "CEFRI";
	public static final String TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_CODRELATORIO = "562";
	public static final String TELA_CONSULTA_QUESTIONARIO_IMOBILIARIO_EQUIPE2 = "treinamento.equipe2.questionario.imobiliario.iniciar";
	public static final String BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO_EQUIPE2 = "equipe2ConsultaQuestionarioImobiliarioBean";
	public static final String BEAN_EQUIPE2 = "equipe2Bean";

	// Equipe 3 Constants
	public static final String TREINAMENTO_EQUIPE_3_CONSULTA = "equipe3.consulta.questionario.altoVarejo.iniciar";
	public static final String TELA_CONSULTA_QUESTIONARIO_PROJETO_EQUIPE3 = "cadastro.consulta.questionario.projeto.equipe3.iniciar";
	public static final String BEAN_CONSULTA_QUESTIONARIO_PROJETOS_EQUIPE3 = "equipe3ProjetoBean";
	public static final String TELA_CONSULTA_QUESTIONARIO_AGRONEGOCIO_EQUIPE3 = "cadastro.consulta.questionario.agronegocio.equipe3.iniciar";
	public static final String BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO_EQUIPE3 = "equipe3AgronegocioBean";

	public static final String BEAN_CONSULTA_QUESTIONARIO_TRANSPORTE_EQUIPE3 = "equipe3BeanTransportes";
	public static final String TELA_CONSULTA_QUESTIONARIO_TRANSPORTE_EQUIPE3 = "equipe3.consulta.questionario.transportes.iniciar";

	/**
	 * EQUIPE 4
	 * */
	public static final String TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_LARGE_CORPORATE = "cadastro.equipe4bean.consulta.questionario.largecorporate.iniciar";
	public static final String TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO = "cadastro.equipe4bean.consulta.questionario.agronegocio.iniciar";
	public static final String TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_PROJETO = "cadastro.equipe4bean.consulta.questionario.projeto.iniciar";
	public static final String TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_TRANSPORTE = "cadastro.equipe4bean.consulta.questionario.transportes.iniciar";
	public static final String TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO = "cadastro.equipe4bean.consulta.questionario.imobiliario.iniciar";

	public static final String BEAN_CADASTRAMENTO_EQUIPE4BEAN_RIC = "equipe4Bean";

	public static final String BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO_EQUIPE4 = "consultaQuestionarioAgronegocioEquipe4Bean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO_EQUIPE4 = "consultaQuestionarioImobiliarioEquipe4Bean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_TRANSPORTES_EQUIPE4 = "consultaQuestionarioTransportesEquipe4Bean";
	public static final String BEAN_CONSULTA_QUESTIONARIO_PROJETOS_EQUIPE4 = "consultaQuestionarioProjetoEquipe4Bean";

	// TESTE GUILHERME
	public static final String TELA_GUILHERME_TESTE_CONSULTA = "treinamento.guilherme.teste.consultar.iniciar";
	public static final String TELA_GUILHERME_TESTE_CADASTRO = "treinamento.guilherme.teste.cadastrar.iniciar";

	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_1 = "Cotia";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_2 = "Osasco";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_3 = "Pelourinho";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_4 = "Belo Horizonte";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_5 = "Palmas";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_6 = "Macaé";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_7 = "Rio Negrinho";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_8 = "Jandira";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_9 = "Mauá";
	public static final String TREINAMENTO_GUILHERME_TESTE_CIDADE_10 = "Passa Quatro";

	public static final String TREINAMENTO_GUILHERME_TESTE_ESTADO_1 = "São Paulo";
	public static final String TREINAMENTO_GUILHERME_TESTE_ESTADO_2 = "Rio de Janeiro";
	public static final String TREINAMENTO_GUILHERME_TESTE_ESTADO_3 = "Minas Gerais";
	public static final String TREINAMENTO_GUILHERME_TESTE_ESTADO_4 = "Tocantins";
	public static final String TREINAMENTO_GUILHERME_TESTE_ESTADO_5 = "Santa Catarina";

	// CONSTANTS LEONARDO TESTE
	public static final String TELA_TREINAMENTO_LEONARDO_TESTE_CADASTRO = "treinamento.leonardo.teste.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_LEONARDO_TESTE_CONSULTA = "treinamento.leonardo.teste.consulta.iniciar";

	/* ************************
	 * TESTE JOAO GIL *************************
	 */
	public static final String TREINAMENTO_JOAOGIL_TESTE_CADASTRO = "treinamento.joaogil.teste.cadastro";
	public static final String TREINAMENTO_JOAOGIL_TESTE_CONSULTA = "treinamento.joaogil.teste.consulta";

	public static final String TELA_TREINAMENTO_VITORIA_TESTE_CADASTRO = "treinamento.vitoria.teste.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_VITORIA_TESTE_CONSULTA = "treinamento.vitoria.teste.consulta.iniciar";

	public static final String TELA_TREINAMENTO_NATALIA_TESTE_CADASTRO = "treinamento.natalia.teste.cadastro.iniciar";
	public static final String TELA_TREINAMENTO_NATALIA_TESTE_CONSULTA = "treinamento.natalia.teste.consulta.iniciar";

	// Rotulos de Acesso
	public static final String TELA_ANDRE_TESTE_CADASTRO = "cadastro.teste.andre.iniciar";
	public static final String TELA_ANDRE_TESTE_CONSULTA = "consulta.teste.andre.iniciar";

	public static final String TELA_TREINAMENTO_ISAAC_TESTE = "treinamento.isaac.teste";
	public static final String TELA_TREINAMENTO_ISAAC_TESTE_CONSULTA = "treinamento.isaac.teste.consulta";

	// MANUTENCAO MENSSAGEM
	public static final String TELA_MANUTENCAO_MENSAGEM_CONSULTA = "manutencao.mensagem.iniciar.consulta";
	public static final String STATUS_MENSAGEM_PENDENTE_AUTORIZACAO = "Pendente Autorização";
	public static final String STATUS_MENSAGEM_EM_ANDAMENTO = "Em Andamento";
	public static final String STATUS_MENSAGEM_AUTORIZADA = "Autorizada";
	public static final String STATUS_MENSAGEM_DEVOLVIDA = "Devolvida";
	public static final String STATUS_MENSAGEM_COPIADA = "Copiada";
	public static final String STATUS_MENSAGEM_EXCLUIDA = "Excluida";
	public static final String TIPO_MENSAGEM_103 = "103";
	public static final String TIPO_MENSAGEM_108 = "108";
	public static final String TIPO_MENSAGEM_113 = "113";
	public static final String TIPO_TRANSMISSAO_ENVIADA = "Enviada";
	public static final String TIPO_TRANSMISSAO_RECEBIDA = "Recebida";
	public static final String MOEDA_DOLAR = "USD";
	public static final String MOEDA_REAL = "BRL";
	public static final String MOEDA_EURO = "EUR";

	// Tela de Lista de Mensagens
	public static final String TELA_MANUTENCAO_LISTA_MENSAGEM = "manutencao.lista.mensagem";

	// Tela de Inclusão de Mensagens
	public static final String TELA_MANUTENCAO_INCLUIR_MENSAGEM = "manutencao.incluir.mensagem";

	// Tela de Detalhar Mensagens
	public static final String TELA_MANUTENCAO_DETALHAR_MENSAGEM = "manutencao.detalhar.mensagem";

	// Tela de Alteracao Mensagens
	public static final String TELA_MANUTENCAO_ALTERAR_MENSAGEM = "manutencao.alterar.mensagem";

	// Tela de Inclusão de Templates
	public static final String TELA_MANUTENCAO_INCLUIR_TEMPLATE = "manutencao.incluir.template";

	// Tela de Consultar Template
	public static final String TELA_MANUTENCAO_CONSULTAR_TEMPLATE = "manutencao.consultar.template";

	// Tela de Listar Template
	public static final String TELA_MANUTENCAO_LISTAR_TEMPLATE = "manutencao.listar.template";

	// Tela de Detalhes de Templates
	public static final String TELA_MANUTENCAO_DETALHAR_TEMPLATE = "manutencao.detalhar.template";

	// Tela de Alteracao de Templates
	public static final String TELA_MANUTENCAO_ALTERAR_TEMPLATE = "manutencao.alterar.template";

	// Tela de Parametrizacao de Componentes de Mensagem
	public static final String TELA_PARAMETRIZACAO_COMPONENTES_MENSAGEM = "parametrizacao.componentes.mensagem";

	// INCLUIR COMPONENTE MENSAGEM
	public static final String CAMPO_SWIFT = "Campo SWIFT";
	public static final String SUB_CAMPO = "Sub Campo";
	public static final String GRUPO_TAGS_XML = "Grupo Tags XML";
	public static final String _13_C_TIME_INDICATION = "13C Time Indication";
	public static final String _20_SENDERS_REFERENCE = "20 Sender's Reference";
	public static final String _23B_BANK_OPERATION_CODE = "23B Bank Operation Code";
	public static final String BASIC_HEADER = "Basic Header";
	public static final String APPLICATION_HEADER = "Application Header";
	public static final String USER_HEADER = "User Header";
	public static final String TEXT = "Text";
	public static final String TRAILER = "Trailer";
	public static final String GRUPO_DE_DADOS = "Grupo de Dados";
	public static final String MOEDA = "Moeda";
	public static final String DATA = "Data";
	public static final String VALOR = "Valor";
	public static final String TEXTO = "Texto";
	public static final String REFERENCIA = "Referência";
	public static final String GRUPO_DADOS = "Grupo de Dados";
	public static final String A_ALFABETICO = "Alfabético";
	public static final String C_A_Z_MAIS_0_9 = "A até Z mais 0 a 9 e espaço";
	public static final String N_NUMERICO = "Numérico";
	public static final String X_CARACTER_X = "Caracter set X";
	public static final String Z_CARACTER_Z = "Caracter set Z";

	// Tela de Parametrizacao de Formatos de Mensagem
	public static final String TELA_PARAMETRIZACAO_FORMATOS_MENSAGEM = "parametrizacao.incluir.formatos.mensagem";

	// Tela de Parametrizacao - Cunsultar de Componente de Mensagem
	public static final String TELA_PARAMETRIZACAO_CONSULTAR_COMPONENTE_MENSAGEM = "parametrizacao.consultar.componente.mensagem";

	// Tela de Parametrizacao - Consultar de Formatos de Mensagem
	public static final String TELA_PARAMETRIZACAO_CONSULTAR_FORMATO_MENSAGEM = "parametrizacao.consultar.formatos.mensagem";

	// Tela de Parametrizacao Alterar Componentes de Mensagem
	public static final String TELA_PARAMETRIZACAO_ALTERAR_COMPONENTES_MENSAGEM = "parametrizacao.alterar.componentes.mensagem";

	// Tela de Parametrizacao - Alterar Formatos de Mensagem
	public static final String TELA_PARAMETRIZACAO_ALTERAR_FORMATOS_MENSAGEM = "parametrizacao.alterar.formatos.mensagem";

	// Tela de Parametrizacao - Detalhar Formatos de Mensagem
	public static final String TELA_PARAMETRIZACAO_DETALHAR_FORMATOS_MENSAGEM = "parametrizacao.detalhar.formatos.mensagem";

	// Tela de Parametrizacao - Excluir Formatos de Mensagem
	public static final String TELA_PARAMETRIZACAO_EXCLUIR_FORMATOS_MENSAGEM = "parametrizacao.excluir.formatos.mensagem";

	// Tela de Parametrizacao - Consultar Permissões
	public static final String TELA_CONSULTAR_PERMISSOES = "consultar.permissoes";

	// Tela de Parametrizacao - Incluir Permissoes
	public static final String TELA_PARAMETRIZACAO_INCLUIR_PERMISSOES = "parametrizacao.incluir.permissoes";

	// Tela de Parametrizacao - Detalhar Permissoes
	public static final String TELA_PARAMETRIZACAO_DETALHAR_PERMISSOES = "parametrizacao.detalhar.permissoes";

	// Tela de Parametrizacao - Alterar Permissoes
	public static final String TELA_PARAMETRIZACAO_ALTERAR_PERMISSOES = "parametrizacao.alterar.permissoes";

	// Tela de Parametrizacao - Incluir Parametrizacao Alcada
	public static final String TELA_PARAMETRIZACAO_INCLUIR_ALCADA = "alcada.incluir.parametrizacao.alcada";

	// Tela de Parametrizacao - Consultar Parametrizacao Alcada
	public static final String TELA_PARAMETRIZACAO_CONSULTAR_ALCADA = "alcada.consultar.parametrizacao.alcada";
	
	// Tela de Parametrizacao - Alterar Parametrizacao Alcada
	public static final String TELA_PARAMETRIZACAO_ALTERAR_ALCADA = "alcada.alterar.parametrizacao.alcada";
		
	
}
