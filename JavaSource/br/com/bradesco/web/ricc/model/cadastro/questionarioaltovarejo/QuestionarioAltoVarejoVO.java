package br.com.bradesco.web.ricc.model.cadastro.questionarioaltovarejo;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.ricc.model.segmento.CapacidadeProdutivaVO;
import br.com.bradesco.web.ricc.model.segmento.CartaoVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.DetalhamentoPatrimonioVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoConsolidadoVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoPorSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class QuestionarioAltoVarejoVO extends QuestionarioSegmentoVO {
	
	private String nomeRelatorio = "";
	/*
	 * 1.Descrever a Atividade da Empresa/Grupo e Informações revelantes do
	 * histórico
	 */
	private String descAtividade = "";
	/*
	 * 2. Ornanograma de Controle Acionário (até acionista final, com respectivo
	 * % de participação)
	 */
	private String descOrganograma = "";
	/*
	 * 3. Quadro administrativo
	 */
	private QuadroAdministrativoVO administrador = new QuadroAdministrativoVO();
	private List<QuadroAdministrativoVO> admsSelecionado = new ArrayList<QuadroAdministrativoVO>();
	private List<QuadroAdministrativoVO> listaAdms = carregarQuadroAdministrativo();
	private List<QuadroAdministrativoVO> copiaListaAdms = carregarQuadroAdministrativo();
	private String descPlanoSucessao = "";
	/*
	 * 4.Detalhamento do Patrimônio (caso haja divergência do detalhado e do
	 * cadastro)
	 */
	private DetalhamentoPatrimonioVO patrimonio = new DetalhamentoPatrimonioVO();
	private List<DetalhamentoPatrimonioVO> patrimonioSelecionado = new ArrayList<DetalhamentoPatrimonioVO>();
	private List<DetalhamentoPatrimonioVO> listaPatrimonio = carregarDetalhamentoPatrimonio();
	private List<DetalhamentoPatrimonioVO> copiaListaPatrimonio = carregarDetalhamentoPatrimonio();
	private String totalPatrimonio = "";
	private String comentPatrimonio = "";
	/*
	 * 5.Capacidade Produtiva (se aplicável)
	 */
	private CapacidadeProdutivaVO capacidadeProd = new CapacidadeProdutivaVO();
	private List<CapacidadeProdutivaVO> capacidadeSelecionado = new ArrayList<CapacidadeProdutivaVO>();
	private List<CapacidadeProdutivaVO> listaCapacidade = carregarCapacidadeProdutiva();
	private List<CapacidadeProdutivaVO> copiaListaCapacidade = carregarCapacidadeProdutiva();
	private String descCapacidadeProd = "";
	private String totalCapacidade = "";
	private String totalProducao = "";
	/*
	 * 6.Principais Fornecedores, Clientes e Concorrentes
	 */
	private FornecedorVO fornecedor = new FornecedorVO();
	private List<FornecedorVO> fornecedorSelecionado = new ArrayList<FornecedorVO>();
	private List<FornecedorVO> listaFornecedor = carregarFornecedor();
	private List<FornecedorVO> copiaListaFornecedor = carregarFornecedor();
	private String descFornecedores = "";

	private ClienteVO cliente = new ClienteVO();
	private List<ClienteVO> clienteSelecionado = new ArrayList<ClienteVO>();
	private List<ClienteVO> listaCliente = carregarCliente();
	private List<ClienteVO> copiaListaCliente = carregarCliente();

	private FormaRecebimentoVO recebimento = new FormaRecebimentoVO();
	private List<FormaRecebimentoVO> recebimentoSelecionado = new ArrayList<FormaRecebimentoVO>();
	private List<FormaRecebimentoVO> listaRecebimento = carregarFormaRecebimento();
	private List<FormaRecebimentoVO> copiaListaRecebimento = carregarFormaRecebimento();
	private String descRecebimento = "";

	private ConcorrenteVO concorrente = new ConcorrenteVO();
	private List<ConcorrenteVO> concorrentesSelecionado = new ArrayList<ConcorrenteVO>();
	private List<ConcorrenteVO> listaConcorrentes = carregarConcorrente();
	private List<ConcorrenteVO> copiaListaConcorrentes = carregarConcorrente();
	private String descConcorrentes = "";
	
	/*
	 * Detalhar carteira de contratos do cliente (se aplicavel ao setor de
	 * atuação)
	 */
	private CarteiraContratosVO contrato = new CarteiraContratosVO();
	private List<CarteiraContratosVO> contratoSelecionado = new ArrayList<CarteiraContratosVO>();
	private List<CarteiraContratosVO> listaContrato = carregarCarteiraContratos();
	private List<CarteiraContratosVO> copiaListaContrato = carregarCarteiraContratos();
	private String descContrato = "";
	private String totalContrato = "";
	private String totalSaldoContrato = "";
	/*
	 * 7.Situação Econômica-Financeira
	 */
	private FaturamentoConsolidadoVO faturamentoA = new FaturamentoConsolidadoVO();
	private FaturamentoConsolidadoVO faturamentoB = new FaturamentoConsolidadoVO();
	private FaturamentoConsolidadoVO faturamentoC = new FaturamentoConsolidadoVO();
	private String descFaturamento = "";

	private FaturamentoPorSegmentoVO faturamento = new FaturamentoPorSegmentoVO();

	private String nomeHighlightsEmpresa = "";
	private HighlightsEmpresaVO balancoA = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO balancoB = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO balancoC = new HighlightsEmpresaVO();
	private String descBalanco = "";
	/*
	 * 8.Endividamento Bancário
	 */
	private EndividamentoBancarioVO divida = new EndividamentoBancarioVO();
	private List<EndividamentoBancarioVO> dividasSelecionado = new ArrayList<EndividamentoBancarioVO>();
	private List<EndividamentoBancarioVO> listaDividas = carregarEndividamentoBancario();
	private List<EndividamentoBancarioVO> copiaListaDividas = carregarEndividamentoBancario();
	private String totalSaldo = "";
	private String descDivida = "";
	/*
	 * 9.Mercado Externo (se aplicável)
	 */
	private String moedaExportacao = "";
	private ImportacoesExportacoesVO importacaoExportacaoA = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO importacaoExportacaoB = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO importacaoExportacaoC = new ImportacoesExportacoesVO();

	/*
	 * 10.Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC
	 */
	private VolumeBradescoVO volume = new VolumeBradescoVO();

	/*
	 * CARTÕES
	 */
	private CartaoVO cartao = new CartaoVO();
	private List<CartaoVO> cartaoSelecionado = new ArrayList<CartaoVO>();
	private List<CartaoVO> listaCartao = new ArrayList<CartaoVO>();
	private List<CartaoVO> copiaListaCartao = new ArrayList<CartaoVO>();
	private String descCartao = "";

	/*
	 * RELATÓRIOS SETORIAIS
	 */
	
	public List<QuadroAdministrativoVO> carregarQuadroAdministrativo() {
		
		List<QuadroAdministrativoVO> lista = new ArrayList<QuadroAdministrativoVO>(Numeros.CINCO);
		for (int i = 0; i < Numeros.CINCO; i++) {
			lista.add(new QuadroAdministrativoVO());
		}
		return lista;
	}
	
	public List<DetalhamentoPatrimonioVO> carregarDetalhamentoPatrimonio() {
		
		List<DetalhamentoPatrimonioVO> lista = new ArrayList<DetalhamentoPatrimonioVO>(10);
		for (int i = 0; i < 10; i++) {
			lista.add(new DetalhamentoPatrimonioVO());
		}
		return lista;
	}
	
	public List<CapacidadeProdutivaVO> carregarCapacidadeProdutiva() {
		
		List<CapacidadeProdutivaVO> lista = new ArrayList<CapacidadeProdutivaVO>(10);
		for (int i = 0; i < 10; i++) {
			lista.add(new CapacidadeProdutivaVO());
		}
		return lista;
	}
	
	public List<FornecedorVO> carregarFornecedor() {
		
		List<FornecedorVO> lista = new ArrayList<FornecedorVO>(Numeros.CINCO);
		for (int i = 0; i < Numeros.CINCO; i++) {
			lista.add(new FornecedorVO());
		}
		return lista;
	}
	
	public List<ClienteVO> carregarCliente() {
		
		List<ClienteVO> lista = new ArrayList<ClienteVO>(Numeros.CINCO);
		for (int i = 0; i < Numeros.CINCO; i++) {
			lista.add(new ClienteVO());
		}
		return lista;
	}
	
	public List<FormaRecebimentoVO> carregarFormaRecebimento() {
		
		List<FormaRecebimentoVO> lista = new ArrayList<FormaRecebimentoVO>(Numeros.CINCO);
		for (int i = 0; i < Numeros.CINCO; i++) {
			lista.add(new FormaRecebimentoVO());
		}
		return lista;
	}
	
	public List<ConcorrenteVO> carregarConcorrente() {
		
		List<ConcorrenteVO> lista = new ArrayList<ConcorrenteVO>(Numeros.CINCO);
		for (int i = 0; i < Numeros.CINCO; i++) {
			lista.add(new ConcorrenteVO());
		}
		return lista;
	}
	
	public List<CarteiraContratosVO> carregarCarteiraContratos() {
		
		List<CarteiraContratosVO> lista = new ArrayList<CarteiraContratosVO>(30);
		for (int i = 0; i < 30; i++) {
			lista.add(new CarteiraContratosVO());
		}
		return lista;
	}
	
	public List<EndividamentoBancarioVO> carregarEndividamentoBancario() {
		
		List<EndividamentoBancarioVO> lista = new ArrayList<EndividamentoBancarioVO>(15);
		for (int i = 0; i < 15; i++) {
			lista.add(new EndividamentoBancarioVO());
		}
		return lista;
	}
	
	public String getTotalPatrimonioFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalPatrimonio);
	}
	
	public String getTotalCapacidadeFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalCapacidade);
	}
	
	public String getTotalProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalProducao);
	}
	
	public String getTotalContratoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalContrato);
	}
	
	public String getTotalSaldoContratoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalSaldoContrato);
	}
	
	public String getTotalSaldoFormatado(){
		return SiteUtil.getInstance().formatValoresToStringInteger(totalSaldo);
	}
	
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public String getDescAtividade() {
		return descAtividade;
	}

	public void setDescAtividade(String descAtividade) {
		this.descAtividade = descAtividade;
	}

	public String getDescOrganograma() {
		return descOrganograma;
	}

	public void setDescOrganograma(String descOrganograma) {
		this.descOrganograma = descOrganograma;
	}


	public QuadroAdministrativoVO getAdministrador() {
		return administrador;
	}

	public void setAdministrador(QuadroAdministrativoVO administrador) {
		this.administrador = administrador;
	}

	public List<QuadroAdministrativoVO> getAdmsSelecionado() {
		return admsSelecionado;
	}

	public void setAdmsSelecionado(
			List<QuadroAdministrativoVO> admsSelecionado) {
		this.admsSelecionado = admsSelecionado;
	}

	public List<QuadroAdministrativoVO> getListaAdms() {
		return listaAdms;
	}

	public void setListaAdms(List<QuadroAdministrativoVO> listaAdms) {
		this.listaAdms = listaAdms;
	}

	public String getDescPlanoSucessao() {
		return descPlanoSucessao;
	}

	public void setDescPlanoSucessao(String descPlanoSucessao) {
		this.descPlanoSucessao = descPlanoSucessao;
	}

	public DetalhamentoPatrimonioVO getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(DetalhamentoPatrimonioVO patrimonio) {
		this.patrimonio = patrimonio;
	}

	public List<DetalhamentoPatrimonioVO> getPatrimonioSelecionado() {
		return patrimonioSelecionado;
	}

	public void setPatrimonioSelecionado(
			List<DetalhamentoPatrimonioVO> patrimonioSelecionado) {
		this.patrimonioSelecionado = patrimonioSelecionado;
	}

	public List<DetalhamentoPatrimonioVO> getListaPatrimonio() {
		return listaPatrimonio;
	}

	public void setListaPatrimonio(List<DetalhamentoPatrimonioVO> listaPatrimonio) {
		this.listaPatrimonio = listaPatrimonio;
	}

	public String getTotalPatrimonio() {
		return totalPatrimonio;
	}
	
	public void setTotalPatrimonio(String totalPatrimonio) {
		this.totalPatrimonio = totalPatrimonio;
	}

	public String getComentPatrimonio() {
		return comentPatrimonio;
	}

	public void setComentPatrimonio(String comentPatrimonio) {
		this.comentPatrimonio = comentPatrimonio;
	}

	public CapacidadeProdutivaVO getCapacidadeProd() {
		return capacidadeProd;
	}

	public void setCapacidadeProd(CapacidadeProdutivaVO capacidadeProd) {
		this.capacidadeProd = capacidadeProd;
	}

	public List<CapacidadeProdutivaVO> getCapacidadeSelecionado() {
		return capacidadeSelecionado;
	}

	public void setCapacidadeSelecionado(
			List<CapacidadeProdutivaVO> capacidadeSelecionado) {
		this.capacidadeSelecionado = capacidadeSelecionado;
	}

	public List<CapacidadeProdutivaVO> getListaCapacidade() {
		return listaCapacidade;
	}

	public void setListaCapacidade(
			List<CapacidadeProdutivaVO> listaCapacidade) {
		this.listaCapacidade = listaCapacidade;
	}

	public String getDescCapacidadeProd() {
		return descCapacidadeProd;
	}

	public void setDescCapacidadeProd(String descCapacidadeProd) {
		this.descCapacidadeProd = descCapacidadeProd;
	}

	public FornecedorVO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorVO fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<FornecedorVO> getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(
			List<FornecedorVO> fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public List<FornecedorVO> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<FornecedorVO> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	public String getDescFornecedores() {
		return descFornecedores;
	}

	public void setDescFornecedores(String descFornecedores) {
		this.descFornecedores = descFornecedores;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public List<ClienteVO> getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(
			List<ClienteVO> clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<ClienteVO> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<ClienteVO> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public FormaRecebimentoVO getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(FormaRecebimentoVO recebimento) {
		this.recebimento = recebimento;
	}

	public List<FormaRecebimentoVO> getRecebimentoSelecionado() {
		return recebimentoSelecionado;
	}

	public void setRecebimentoSelecionado(
			List<FormaRecebimentoVO> recebimentoSelecionado) {
		this.recebimentoSelecionado = recebimentoSelecionado;
	}

	public List<FormaRecebimentoVO> getListaRecebimento() {
		return listaRecebimento;
	}

	public void setListaRecebimento(
			List<FormaRecebimentoVO> listaRecebimento) {
		this.listaRecebimento = listaRecebimento;
	}

	public String getDescRecebimento() {
		return descRecebimento;
	}

	public void setDescRecebimento(String descRecebimento) {
		this.descRecebimento = descRecebimento;
	}

	public ConcorrenteVO getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(ConcorrenteVO concorrente) {
		this.concorrente = concorrente;
	}

	public List<ConcorrenteVO> getConcorrentesSelecionado() {
		return concorrentesSelecionado;
	}

	public void setConcorrentesSelecionado(
			List<ConcorrenteVO> concorrentesSelecionado) {
		this.concorrentesSelecionado = concorrentesSelecionado;
	}

	public List<ConcorrenteVO> getListaConcorrentes() {
		return listaConcorrentes;
	}

	public void setListaConcorrentes(
			List<ConcorrenteVO> listaConcorrentes) {
		this.listaConcorrentes = listaConcorrentes;
	}

	public String getDescConcorrentes() {
		return descConcorrentes;
	}

	public void setDescConcorrentes(String descConcorrentes) {
		this.descConcorrentes = descConcorrentes;
	}

	public CarteiraContratosVO getContrato() {
		return contrato;
	}

	public void setContrato(CarteiraContratosVO contrato) {
		this.contrato = contrato;
	}

	public List<CarteiraContratosVO> getContratoSelecionado() {
		return contratoSelecionado;
	}

	public void setContratoSelecionado(
			List<CarteiraContratosVO> contratoSelecionado) {
		this.contratoSelecionado = contratoSelecionado;
	}

	public List<CarteiraContratosVO> getListaContrato() {
		return listaContrato;
	}

	public void setListaContrato(List<CarteiraContratosVO> listaContrato) {
		this.listaContrato = listaContrato;
	}

	public String getDescContrato() {
		return descContrato;
	}

	public void setDescContrato(String descContrato) {
		this.descContrato = descContrato;
	}

	public FaturamentoConsolidadoVO getFaturamentoA() {
		return faturamentoA;
	}

	public void setFaturamentoA(FaturamentoConsolidadoVO faturamentoA) {
		this.faturamentoA = faturamentoA;
	}

	public FaturamentoConsolidadoVO getFaturamentoB() {
		return faturamentoB;
	}

	public void setFaturamentoB(FaturamentoConsolidadoVO faturamentoB) {
		this.faturamentoB = faturamentoB;
	}

	public FaturamentoConsolidadoVO getFaturamentoC() {
		return faturamentoC;
	}

	public void setFaturamentoC(FaturamentoConsolidadoVO faturamentoC) {
		this.faturamentoC = faturamentoC;
	}

	public String getDescFaturamento() {
		return descFaturamento;
	}

	public void setDescFaturamento(String descFaturamento) {
		this.descFaturamento = descFaturamento;
	}

	public FaturamentoPorSegmentoVO getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(FaturamentoPorSegmentoVO faturamento) {
		this.faturamento = faturamento;
	}

	public String getNomeHighlightsEmpresa() {
		return nomeHighlightsEmpresa;
	}

	public void setNomeHighlightsEmpresa(String nomeHighlightsEmpresa) {
		this.nomeHighlightsEmpresa = nomeHighlightsEmpresa;
	}

	public HighlightsEmpresaVO getBalancoA() {
		return balancoA;
	}

	public void setBalancoA(HighlightsEmpresaVO balancoA) {
		this.balancoA = balancoA;
	}

	public HighlightsEmpresaVO getBalancoB() {
		return balancoB;
	}

	public void setBalancoB(HighlightsEmpresaVO balancoB) {
		this.balancoB = balancoB;
	}

	public HighlightsEmpresaVO getBalancoC() {
		return balancoC;
	}

	public void setBalancoC(HighlightsEmpresaVO balancoC) {
		this.balancoC = balancoC;
	}

	public String getDescBalanco() {
		return descBalanco;
	}

	public void setDescBalanco(String descBalanco) {
		this.descBalanco = descBalanco;
	}

	public EndividamentoBancarioVO getDivida() {
		return divida;
	}

	public void setDivida(EndividamentoBancarioVO divida) {
		this.divida = divida;
	}

	public List<EndividamentoBancarioVO> getDividasSelecionado() {
		return dividasSelecionado;
	}

	public void setDividasSelecionado(
			List<EndividamentoBancarioVO> dividasSelecionado) {
		this.dividasSelecionado = dividasSelecionado;
	}

	public List<EndividamentoBancarioVO> getListaDividas() {
		return listaDividas;
	}

	public void setListaDividas(List<EndividamentoBancarioVO> listaDividas) {
		this.listaDividas = listaDividas;
	}

	public String getTotalSaldo() {
		return totalSaldo;
	}

	public void setTotalSaldo(String totalSaldo) {
		this.totalSaldo = totalSaldo;
	}

	public String getDescDivida() {
		return descDivida;
	}

	public void setDescDivida(String descDivida) {
		this.descDivida = descDivida;
	}

	public String getMoedaExportacao() {
		return moedaExportacao;
	}

	public void setMoedaExportacao(String moedaExportacao) {
		this.moedaExportacao = moedaExportacao;
	}

	public ImportacoesExportacoesVO getImportacaoExportacaoA() {
		return importacaoExportacaoA;
	}

	public void setImportacaoExportacaoA(
			ImportacoesExportacoesVO importacaoExportacaoA) {
		this.importacaoExportacaoA = importacaoExportacaoA;
	}

	public ImportacoesExportacoesVO getImportacaoExportacaoB() {
		return importacaoExportacaoB;
	}

	public void setImportacaoExportacaoB(
			ImportacoesExportacoesVO importacaoExportacaoB) {
		this.importacaoExportacaoB = importacaoExportacaoB;
	}

	public ImportacoesExportacoesVO getImportacaoExportacaoC() {
		return importacaoExportacaoC;
	}

	public void setImportacaoExportacaoC(
			ImportacoesExportacoesVO importacaoExportacaoC) {
		this.importacaoExportacaoC = importacaoExportacaoC;
	}

	public VolumeBradescoVO getVolume() {
		return volume;
	}

	public void setVolume(VolumeBradescoVO volume) {
		this.volume = volume;
	}

	public CartaoVO getCartao() {
		return cartao;
	}

	public void setCartao(CartaoVO cartao) {
		this.cartao = cartao;
	}

	public List<CartaoVO> getCartaoSelecionado() {
		return cartaoSelecionado;
	}

	public void setCartaoSelecionado(List<CartaoVO> cartaoSelecionado) {
		this.cartaoSelecionado = cartaoSelecionado;
	}

	public List<CartaoVO> getListaCartao() {
		return listaCartao;
	}

	public void setListaCartao(List<CartaoVO> listaCartao) {
		this.listaCartao = listaCartao;
	}

	public String getDescCartao() {
		return descCartao;
	}

	public void setDescCartao(String descCartao) {
		this.descCartao = descCartao;
	}
	
	public String getTotalContrato() {
		return totalContrato;
	}

	public void setTotalContrato(String totalContrato) {
		this.totalContrato = totalContrato;
	}

	public String getTotalSaldoContrato() {
		return totalSaldoContrato;
	}

	public void setTotalSaldoContrato(String totalSaldoContrato) {
		this.totalSaldoContrato = totalSaldoContrato;
	}

	public String getTotalCapacidade() {
		return totalCapacidade;
	}

	public void setTotalCapacidade(String totalCapacidade) {
		this.totalCapacidade = totalCapacidade;
	}

	public String getTotalProducao() {
		return totalProducao;
	}

	public void setTotalProducao(String totalProducao) {
		this.totalProducao = totalProducao;
	}

	public List<QuadroAdministrativoVO> getCopiaListaAdms() {
		return copiaListaAdms;
	}

	public void setCopiaListaAdms(List<QuadroAdministrativoVO> copiaListaAdms) {
		this.copiaListaAdms = copiaListaAdms;
	}

	public List<DetalhamentoPatrimonioVO> getCopiaListaPatrimonio() {
		return copiaListaPatrimonio;
	}

	public void setCopiaListaPatrimonio(
			List<DetalhamentoPatrimonioVO> copiaListaPatrimonio) {
		this.copiaListaPatrimonio = copiaListaPatrimonio;
	}

	public List<CapacidadeProdutivaVO> getCopiaListaCapacidade() {
		return copiaListaCapacidade;
	}

	public void setCopiaListaCapacidade(
			List<CapacidadeProdutivaVO> copiaListaCapacidade) {
		this.copiaListaCapacidade = copiaListaCapacidade;
	}

	public List<FornecedorVO> getCopiaListaFornecedor() {
		return copiaListaFornecedor;
	}

	public void setCopiaListaFornecedor(List<FornecedorVO> copiaListaFornecedor) {
		this.copiaListaFornecedor = copiaListaFornecedor;
	}

	public List<ClienteVO> getCopiaListaCliente() {
		return copiaListaCliente;
	}

	public void setCopiaListaCliente(List<ClienteVO> copiaListaCliente) {
		this.copiaListaCliente = copiaListaCliente;
	}

	public List<FormaRecebimentoVO> getCopiaListaRecebimento() {
		return copiaListaRecebimento;
	}

	public void setCopiaListaRecebimento(
			List<FormaRecebimentoVO> copiaListaRecebimento) {
		this.copiaListaRecebimento = copiaListaRecebimento;
	}

	public List<ConcorrenteVO> getCopiaListaConcorrentes() {
		return copiaListaConcorrentes;
	}

	public void setCopiaListaConcorrentes(List<ConcorrenteVO> copiaListaConcorrentes) {
		this.copiaListaConcorrentes = copiaListaConcorrentes;
	}

	public List<CarteiraContratosVO> getCopiaListaContrato() {
		return copiaListaContrato;
	}

	public void setCopiaListaContrato(List<CarteiraContratosVO> copiaListaContrato) {
		this.copiaListaContrato = copiaListaContrato;
	}

	public List<EndividamentoBancarioVO> getCopiaListaDividas() {
		return copiaListaDividas;
	}

	public void setCopiaListaDividas(List<EndividamentoBancarioVO> copiaListaDividas) {
		this.copiaListaDividas = copiaListaDividas;
	}

	public List<CartaoVO> getCopiaListaCartao() {
		return copiaListaCartao;
	}

	public void setCopiaListaCartao(List<CartaoVO> copiaListaCartao) {
		this.copiaListaCartao = copiaListaCartao;
	}
}
