package br.com.bradesco.web.ricc.model.cadastro.questionarioempresas;

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
import br.com.bradesco.web.ricc.model.segmento.PerspectivasVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

//Questionario Empresas
public class QuestionarioEmpresasVO extends QuestionarioSegmentoVO {

	// 1. Descrever a Atividade da Empresa/Grupo e Informações revelantes do
	// histórico
	private String descAtividadeEmpresa = "";

	// 2. Ornanograma de Controle Acionário (até acionista final, com respectivo
	// % de participação)
	private String organogramaControleAcionario = "";

	// 3. Quadro administrativo
	private QuadroAdministrativoVO quadroAdministrativo = new QuadroAdministrativoVO();
	private List<QuadroAdministrativoVO> quadroAdministrativoSelecionado = new ArrayList<QuadroAdministrativoVO>();
	private List<QuadroAdministrativoVO> listaQuadroAdministrativo = carregarQuadroAdministrativo();
	private List<QuadroAdministrativoVO> copiaListaQuadroAdministrativo = carregarQuadroAdministrativo();
	private String descQuadroAdministrativo = "";

	// 4. Detalhamento do Patrimônio (caso haja divergência do detalhado e do
	// cadastro)
	private DetalhamentoPatrimonioVO detalhamentoPatrimonio = new DetalhamentoPatrimonioVO();
	private List<DetalhamentoPatrimonioVO> detalhamentoPatrimonioSelecionado = new ArrayList<DetalhamentoPatrimonioVO>();
	private List<DetalhamentoPatrimonioVO> listaDetalhamentoPatrimonio = carregarDetalhamentoPatrimonio();
	private List<DetalhamentoPatrimonioVO> copiaListaDetalhamentoPatrimonio = carregarDetalhamentoPatrimonio();
	private String valorTotalPatrimonio = "";
	private String descDetalhamentoPatrimonio = "";

	// 5. Capacidade Produtiva (se aplicável)
	private CapacidadeProdutivaVO capacidadeProdutiva = new CapacidadeProdutivaVO();
	private List<CapacidadeProdutivaVO> capacidadeProdutivaSelecionado = new ArrayList<CapacidadeProdutivaVO>();
	private List<CapacidadeProdutivaVO> listaCapacidadeProdutiva = carregarCapacidadeProdutiva();
	private List<CapacidadeProdutivaVO> copiaListaCapacidadeProdutiva = carregarCapacidadeProdutiva();
	private String descCapacidadeProdutiva = "";
	private String totalCapacidade = "";
	private String totalProducao = "";

	// 6. Principais Fornecedores, Clientes e Concorrentes
	private FornecedorVO fornecedor = new FornecedorVO();
	private List<FornecedorVO> fornecedorSelecionado = new ArrayList<FornecedorVO>();
	private List<FornecedorVO> listaFornecedores = carregarFornecedor();
	private List<FornecedorVO> copiaListaFornecedores = carregarFornecedor();
	private String descFornecedores = "";

	private ClienteVO cliente = new ClienteVO();
	private List<ClienteVO> clienteSelecionado = new ArrayList<ClienteVO>();
	private List<ClienteVO> listaClientes = carregarCliente();
	private List<ClienteVO> copiaListaClientes = carregarCliente();

	private FormaRecebimentoVO recebimento = new FormaRecebimentoVO();
	private List<FormaRecebimentoVO> recebimentoSelecionado = new ArrayList<FormaRecebimentoVO>();
	private List<FormaRecebimentoVO> listaRecebimento = carregarFormaRecebimento();
	private List<FormaRecebimentoVO> copiaListaRecebimento = carregarFormaRecebimento();
	private String descRecebimento = "";

	private ConcorrenteVO concorrente = new ConcorrenteVO();
	private List<ConcorrenteVO> concorrenteSelecionado = new ArrayList<ConcorrenteVO>();
	private List<ConcorrenteVO> listaConcorrente = carregarConcorrente();
	private List<ConcorrenteVO> copiaListaConcorrente = carregarConcorrente();
	private String descConcorrente = "";
	
	private CarteiraContratosVO carteira = new CarteiraContratosVO();
	private List<CarteiraContratosVO> carteiraSelecionado = new ArrayList<CarteiraContratosVO>();
	private List<CarteiraContratosVO> listaCarteira = carregarCarteiraContratos();
	private List<CarteiraContratosVO> copiaListaCarteira = carregarCarteiraContratos();
	private String descCarteira = "";
	private String totalContrato = "";
	private String totalSaldoContrato = "";

	// 7. Situação Econômica-Financeira
	private FaturamentoConsolidadoVO faturamentoConsolidadoA = new FaturamentoConsolidadoVO();
	private FaturamentoConsolidadoVO faturamentoConsolidadoB = new FaturamentoConsolidadoVO();
	private FaturamentoConsolidadoVO faturamentoConsolidadoC = new FaturamentoConsolidadoVO();

	private FaturamentoPorSegmentoVO faturamentoSegmento = new FaturamentoPorSegmentoVO();

	private String nomeHighlightsEmpresa = "";
	private HighlightsEmpresaVO highlightsA = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO highlightsB = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO highlightsC = new HighlightsEmpresaVO();

	private String descFaturamento = "";

	// 8. Endividamento Bancário
	private EndividamentoBancarioVO endividamentoBancario = new EndividamentoBancarioVO();
	private List<EndividamentoBancarioVO> endividamentoBancarioSelecionado = new ArrayList<EndividamentoBancarioVO>();
	private List<EndividamentoBancarioVO> listaEndividamentoBancario = carregarEndividamentoBancario();
	private List<EndividamentoBancarioVO> copiaListaEndividamentoBancario = carregarEndividamentoBancario();
	private String totalSaldoEndividamentoBancario = "";
	private String descEndividamentoBancario = "";

	// 9. Exposição cambial e Política de Hedge
	private String moedaExportacao = "";
	private ImportacoesExportacoesVO volumeA = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO volumeB = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO volumeC = new ImportacoesExportacoesVO();

	private String paisesExportaImporta = "";
	private String detalheProtecaoCambialEmpresa = "";

	// 10. Perspectivas
	private PerspectivasVO perspectiva = new PerspectivasVO();
	private String detalheEstrategiaProjecao = "";
	private String detalheInvestimentosConcluidosPlanejados = "";

	// 11. Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC
	private VolumeBradescoVO volumeBradesco = new VolumeBradescoVO();

	private CartaoVO cartao = new CartaoVO();
	private List<CartaoVO> cartaoSelecionado = new ArrayList<CartaoVO>();
	private List<CartaoVO> listaCartao = new ArrayList<CartaoVO>();

	private String descReciprocidades = "";
	
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
	
	public String getValorTotalPatrimonioFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorTotalPatrimonio);
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
	
	public String getTotalSaldoEndividamentoBancarioFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalSaldoEndividamentoBancario);
	}
	
	public String getDescAtividadeEmpresa() {
		return descAtividadeEmpresa;
	}

	public void setDescAtividadeEmpresa(String descAtividadeEmpresa) {
		this.descAtividadeEmpresa = descAtividadeEmpresa;
	}

	public String getOrganogramaControleAcionario() {
		return organogramaControleAcionario;
	}

	public void setOrganogramaControleAcionario(
			String organogramaControleAcionario) {
		this.organogramaControleAcionario = organogramaControleAcionario;
	}

	public QuadroAdministrativoVO getQuadroAdministrativo() {
		return quadroAdministrativo;
	}

	public void setQuadroAdministrativo(
			QuadroAdministrativoVO quadroAdministrativo) {
		this.quadroAdministrativo = quadroAdministrativo;
	}

	public List<QuadroAdministrativoVO> getQuadroAdministrativoSelecionado() {
		return quadroAdministrativoSelecionado;
	}

	public void setQuadroAdministrativoSelecionado(
			List<QuadroAdministrativoVO> quadroAdministrativoSelecionado) {
		this.quadroAdministrativoSelecionado = quadroAdministrativoSelecionado;
	}

	public List<QuadroAdministrativoVO> getListaQuadroAdministrativo() {
		return listaQuadroAdministrativo;
	}

	public void setListaQuadroAdministrativo(
			List<QuadroAdministrativoVO> listaQuadroAdministrativo) {
		this.listaQuadroAdministrativo = listaQuadroAdministrativo;
	}

	public String getDescQuadroAdministrativo() {
		return descQuadroAdministrativo;
	}

	public void setDescQuadroAdministrativo(String descQuadroAdministrativo) {
		this.descQuadroAdministrativo = descQuadroAdministrativo;
	}

	public DetalhamentoPatrimonioVO getDetalhamentoPatrimonio() {
		return detalhamentoPatrimonio;
	}

	public void setDetalhamentoPatrimonio(
			DetalhamentoPatrimonioVO detalhamentoPatrimonio) {
		this.detalhamentoPatrimonio = detalhamentoPatrimonio;
	}

	public List<DetalhamentoPatrimonioVO> getDetalhamentoPatrimonioSelecionado() {
		return detalhamentoPatrimonioSelecionado;
	}

	public void setDetalhamentoPatrimonioSelecionado(
			List<DetalhamentoPatrimonioVO> detalhamentoPatrimonioSelecionado) {
		this.detalhamentoPatrimonioSelecionado = detalhamentoPatrimonioSelecionado;
	}

	public List<DetalhamentoPatrimonioVO> getListaDetalhamentoPatrimonio() {
		return listaDetalhamentoPatrimonio;
	}

	public void setListaDetalhamentoPatrimonio(
			List<DetalhamentoPatrimonioVO> listaDetalhamentoPatrimonio) {
		this.listaDetalhamentoPatrimonio = listaDetalhamentoPatrimonio;
	}

	public String getValorTotalPatrimonio() {
		return valorTotalPatrimonio;
	}

	public void setValorTotalPatrimonio(String valorTotalPatrimonio) {
		this.valorTotalPatrimonio = valorTotalPatrimonio;
	}

	public String getDescDetalhamentoPatrimonio() {
		return descDetalhamentoPatrimonio;
	}

	public void setDescDetalhamentoPatrimonio(String descDetalhamentoPatrimonio) {
		this.descDetalhamentoPatrimonio = descDetalhamentoPatrimonio;
	}

	public CapacidadeProdutivaVO getCapacidadeProdutiva() {
		return capacidadeProdutiva;
	}

	public void setCapacidadeProdutiva(
			CapacidadeProdutivaVO capacidadeProdutiva) {
		this.capacidadeProdutiva = capacidadeProdutiva;
	}

	public List<CapacidadeProdutivaVO> getCapacidadeProdutivaSelecionado() {
		return capacidadeProdutivaSelecionado;
	}

	public void setCapacidadeProdutivaSelecionado(
			List<CapacidadeProdutivaVO> capacidadeProdutivaSelecionado) {
		this.capacidadeProdutivaSelecionado = capacidadeProdutivaSelecionado;
	}

	public List<CapacidadeProdutivaVO> getListaCapacidadeProdutiva() {
		return listaCapacidadeProdutiva;
	}

	public void setListaCapacidadeProdutiva(
			List<CapacidadeProdutivaVO> listaCapacidadeProdutiva) {
		this.listaCapacidadeProdutiva = listaCapacidadeProdutiva;
	}

	public String getDescCapacidadeProdutiva() {
		return descCapacidadeProdutiva;
	}

	public void setDescCapacidadeProdutiva(String descCapacidadeProdutiva) {
		this.descCapacidadeProdutiva = descCapacidadeProdutiva;
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

	public List<FornecedorVO> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(
			List<FornecedorVO> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
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

	public void setClienteSelecionado(List<ClienteVO> clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<ClienteVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteVO> listaClientes) {
		this.listaClientes = listaClientes;
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

	public void setListaRecebimento(List<FormaRecebimentoVO> listaRecebimento) {
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

	public List<ConcorrenteVO> getConcorrenteSelecionado() {
		return concorrenteSelecionado;
	}

	public void setConcorrenteSelecionado(
			List<ConcorrenteVO> concorrenteSelecionado) {
		this.concorrenteSelecionado = concorrenteSelecionado;
	}

	public List<ConcorrenteVO> getListaConcorrente() {
		return listaConcorrente;
	}

	public void setListaConcorrente(List<ConcorrenteVO> listaConcorrente) {
		this.listaConcorrente = listaConcorrente;
	}

	public String getDescConcorrente() {
		return descConcorrente;
	}

	public void setDescConcorrente(String descConcorrente) {
		this.descConcorrente = descConcorrente;
	}

	public CarteiraContratosVO getCarteira() {
		return carteira;
	}

	public void setCarteira(CarteiraContratosVO carteira) {
		this.carteira = carteira;
	}

	public List<CarteiraContratosVO> getCarteiraSelecionado() {
		return carteiraSelecionado;
	}

	public void setCarteiraSelecionado(
			List<CarteiraContratosVO> carteiraSelecionado) {
		this.carteiraSelecionado = carteiraSelecionado;
	}

	public List<CarteiraContratosVO> getListaCarteira() {
		return listaCarteira;
	}

	public void setListaCarteira(List<CarteiraContratosVO> listaCarteira) {
		this.listaCarteira = listaCarteira;
	}

	public String getDescCarteira() {
		return descCarteira;
	}

	public void setDescCarteira(String descCarteira) {
		this.descCarteira = descCarteira;
	}

	public FaturamentoConsolidadoVO getFaturamentoConsolidadoA() {
		return faturamentoConsolidadoA;
	}

	public void setFaturamentoConsolidadoA(
			FaturamentoConsolidadoVO faturamentoConsolidadoA) {
		this.faturamentoConsolidadoA = faturamentoConsolidadoA;
	}

	public FaturamentoConsolidadoVO getFaturamentoConsolidadoB() {
		return faturamentoConsolidadoB;
	}

	public void setFaturamentoConsolidadoB(
			FaturamentoConsolidadoVO faturamentoConsolidadoB) {
		this.faturamentoConsolidadoB = faturamentoConsolidadoB;
	}

	public FaturamentoConsolidadoVO getFaturamentoConsolidadoC() {
		return faturamentoConsolidadoC;
	}

	public void setFaturamentoConsolidadoC(
			FaturamentoConsolidadoVO faturamentoConsolidadoC) {
		this.faturamentoConsolidadoC = faturamentoConsolidadoC;
	}

	public FaturamentoPorSegmentoVO getFaturamentoSegmento() {
		return faturamentoSegmento;
	}

	public void setFaturamentoSegmento(
			FaturamentoPorSegmentoVO faturamentoSegmento) {
		this.faturamentoSegmento = faturamentoSegmento;
	}

	public String getNomeHighlightsEmpresa() {
		return nomeHighlightsEmpresa;
	}

	public void setNomeHighlightsEmpresa(String nomeHighlightsEmpresa) {
		this.nomeHighlightsEmpresa = nomeHighlightsEmpresa;
	}

	public HighlightsEmpresaVO getHighlightsA() {
		return highlightsA;
	}

	public void setHighlightsA(HighlightsEmpresaVO highlightsA) {
		this.highlightsA = highlightsA;
	}

	public HighlightsEmpresaVO getHighlightsB() {
		return highlightsB;
	}

	public void setHighlightsB(HighlightsEmpresaVO highlightsB) {
		this.highlightsB = highlightsB;
	}

	public HighlightsEmpresaVO getHighlightsC() {
		return highlightsC;
	}

	public void setHighlightsC(HighlightsEmpresaVO highlightsC) {
		this.highlightsC = highlightsC;
	}

	public String getDescFaturamento() {
		return descFaturamento;
	}

	public void setDescFaturamento(String descFaturamento) {
		this.descFaturamento = descFaturamento;
	}

	public EndividamentoBancarioVO getEndividamentoBancario() {
		return endividamentoBancario;
	}

	public void setEndividamentoBancario(
			EndividamentoBancarioVO endividamentoBancario) {
		this.endividamentoBancario = endividamentoBancario;
	}

	public List<EndividamentoBancarioVO> getEndividamentoBancarioSelecionado() {
		return endividamentoBancarioSelecionado;
	}

	public void setEndividamentoBancarioSelecionado(
			List<EndividamentoBancarioVO> endividamentoBancarioSelecionado) {
		this.endividamentoBancarioSelecionado = endividamentoBancarioSelecionado;
	}

	public List<EndividamentoBancarioVO> getListaEndividamentoBancario() {
		return listaEndividamentoBancario;
	}

	public void setListaEndividamentoBancario(
			List<EndividamentoBancarioVO> listaEndividamentoBancario) {
		this.listaEndividamentoBancario = listaEndividamentoBancario;
	}

	public String getTotalSaldoEndividamentoBancario() {
		return totalSaldoEndividamentoBancario;
	}


	public void setTotalSaldoEndividamentoBancario(
			String totalSaldoEndividamentoBancario) {
		this.totalSaldoEndividamentoBancario = totalSaldoEndividamentoBancario;
	}

	public String getDescEndividamentoBancario() {
		return descEndividamentoBancario;
	}

	public void setDescEndividamentoBancario(String descEndividamentoBancario) {
		this.descEndividamentoBancario = descEndividamentoBancario;
	}

	public String getMoedaExportacao() {
		return moedaExportacao;
	}

	public void setMoedaExportacao(String moedaExportacao) {
		this.moedaExportacao = moedaExportacao;
	}

	public ImportacoesExportacoesVO getVolumeA() {
		return volumeA;
	}

	public void setVolumeA(ImportacoesExportacoesVO volumeA) {
		this.volumeA = volumeA;
	}

	public ImportacoesExportacoesVO getVolumeB() {
		return volumeB;
	}

	public void setVolumeB(ImportacoesExportacoesVO volumeB) {
		this.volumeB = volumeB;
	}

	public ImportacoesExportacoesVO getVolumeC() {
		return volumeC;
	}

	public void setVolumeC(ImportacoesExportacoesVO volumeC) {
		this.volumeC = volumeC;
	}

	public String getPaisesExportaImporta() {
		return paisesExportaImporta;
	}

	public void setPaisesExportaImporta(String paisesExportaImporta) {
		this.paisesExportaImporta = paisesExportaImporta;
	}

	public String getDetalheProtecaoCambialEmpresa() {
		return detalheProtecaoCambialEmpresa;
	}

	public void setDetalheProtecaoCambialEmpresa(
			String detalheProtecaoCambialEmpresa) {
		this.detalheProtecaoCambialEmpresa = detalheProtecaoCambialEmpresa;
	}

	public PerspectivasVO getPerspectiva() {
		return perspectiva;
	}

	public void setPerspectiva(PerspectivasVO perspectiva) {
		this.perspectiva = perspectiva;
	}

	public String getDetalheEstrategiaProjecao() {
		return detalheEstrategiaProjecao;
	}

	public void setDetalheEstrategiaProjecao(String detalheEstrategiaProjecao) {
		this.detalheEstrategiaProjecao = detalheEstrategiaProjecao;
	}

	public String getDetalheInvestimentosConcluidosPlanejados() {
		return detalheInvestimentosConcluidosPlanejados;
	}

	public void setDetalheInvestimentosConcluidosPlanejados(
			String detalheInvestimentosConcluidosPlanejados) {
		this.detalheInvestimentosConcluidosPlanejados = detalheInvestimentosConcluidosPlanejados;
	}

	public VolumeBradescoVO getVolumeBradesco() {
		return volumeBradesco;
	}

	public void setVolumeBradesco(VolumeBradescoVO volumeBradesco) {
		this.volumeBradesco = volumeBradesco;
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

	public String getDescReciprocidades() {
		return descReciprocidades;
	}

	public void setDescReciprocidades(String descReciprocidades) {
		this.descReciprocidades = descReciprocidades;
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

	public List<QuadroAdministrativoVO> getCopiaListaQuadroAdministrativo() {
		return copiaListaQuadroAdministrativo;
	}

	public void setCopiaListaQuadroAdministrativo(
			List<QuadroAdministrativoVO> copiaListaQuadroAdministrativo) {
		this.copiaListaQuadroAdministrativo = copiaListaQuadroAdministrativo;
	}

	public List<DetalhamentoPatrimonioVO> getCopiaListaDetalhamentoPatrimonio() {
		return copiaListaDetalhamentoPatrimonio;
	}

	public void setCopiaListaDetalhamentoPatrimonio(
			List<DetalhamentoPatrimonioVO> copiaListaDetalhamentoPatrimonio) {
		this.copiaListaDetalhamentoPatrimonio = copiaListaDetalhamentoPatrimonio;
	}

	public List<CapacidadeProdutivaVO> getCopiaListaCapacidadeProdutiva() {
		return copiaListaCapacidadeProdutiva;
	}

	public void setCopiaListaCapacidadeProdutiva(
			List<CapacidadeProdutivaVO> copiaListaCapacidadeProdutiva) {
		this.copiaListaCapacidadeProdutiva = copiaListaCapacidadeProdutiva;
	}

	public List<FornecedorVO> getCopiaListaFornecedores() {
		return copiaListaFornecedores;
	}

	public void setCopiaListaFornecedores(List<FornecedorVO> copiaListaFornecedores) {
		this.copiaListaFornecedores = copiaListaFornecedores;
	}

	public List<ClienteVO> getCopiaListaClientes() {
		return copiaListaClientes;
	}

	public void setCopiaListaClientes(List<ClienteVO> copiaListaClientes) {
		this.copiaListaClientes = copiaListaClientes;
	}

	public List<FormaRecebimentoVO> getCopiaListaRecebimento() {
		return copiaListaRecebimento;
	}

	public void setCopiaListaRecebimento(
			List<FormaRecebimentoVO> copiaListaRecebimento) {
		this.copiaListaRecebimento = copiaListaRecebimento;
	}

	public List<ConcorrenteVO> getCopiaListaConcorrente() {
		return copiaListaConcorrente;
	}

	public void setCopiaListaConcorrente(List<ConcorrenteVO> copiaListaConcorrente) {
		this.copiaListaConcorrente = copiaListaConcorrente;
	}

	public List<CarteiraContratosVO> getCopiaListaCarteira() {
		return copiaListaCarteira;
	}

	public void setCopiaListaCarteira(List<CarteiraContratosVO> copiaListaCarteira) {
		this.copiaListaCarteira = copiaListaCarteira;
	}

	public List<EndividamentoBancarioVO> getCopiaListaEndividamentoBancario() {
		return copiaListaEndividamentoBancario;
	}

	public void setCopiaListaEndividamentoBancario(
			List<EndividamentoBancarioVO> copiaListaEndividamentoBancario) {
		this.copiaListaEndividamentoBancario = copiaListaEndividamentoBancario;
	}
	
}
