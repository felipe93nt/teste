package br.com.bradesco.web.ricc.model.cadastro.questionariocorporate;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.segmento.CartaoVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.PerspectivasVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class QuestionarioCorporateVO extends QuestionarioSegmentoVO{

	// 1. Descrever a Atividade da Empresa/Grupo e Informações revelantes do
	// histórico
	private String descAtividadeEmpresa = "";

	// 2. Ornanograma de Controle Acionário (até acionista final, com respectivo
	// % de participação)
	private String organogramaControleAcionario = "";

	// Quadro de Ativos
	private QuadroAtivosCorporateVO quadroAtivos = new QuadroAtivosCorporateVO();
	private List<QuadroAtivosCorporateVO> quadroAtivosSelecionado = new ArrayList<QuadroAtivosCorporateVO>();
	private List<QuadroAtivosCorporateVO> listaQuadroAtivos = carregaListaQuadroAtivo();
	private List<QuadroAtivosCorporateVO> copiaListaQuadroAtivos = carregaListaQuadroAtivoCopia();
	private String descQuadroAtivos = "";

	// 3. Quadro administrativo
	private QuadroAdministrativoVO quadroAdministrativo = new QuadroAdministrativoVO();
	private List<QuadroAdministrativoVO> quadroAdministrativoSelecionado = new ArrayList<QuadroAdministrativoVO>();
	private List<QuadroAdministrativoVO> listaQuadroAdministrativo = carregaListaQuadroAdministrativo();
	private List<QuadroAdministrativoVO> copiaListaQuadroAdministrativo = carregaListaQuadroAdministrativoCopia();
	private String descQuadroAdministrativo = "";

	// 4.Principais Fornecedores, Clientes e Concorrentes
	// Fornecedores
	private FornecedorVO fornecedor = new FornecedorVO();
	private List<FornecedorVO> fornecedorSelecionado = new ArrayList<FornecedorVO>();
	private List<FornecedorVO> listaFornecedor = carregaListaFornecedor();
	private String descFornecedor = "";
	private List<FornecedorVO> copiaListaFornecedor = carregaListaFornecedorCopia();

	// Clientes
	private ClienteVO cliente = new ClienteVO();
	private List<ClienteVO> clienteSelecionado = new ArrayList<ClienteVO>();
	private List<ClienteVO> listaCliente = carregaListaCliente();
	private List<ClienteVO> copiaListaCliente = carregaListaClienteCopia();

	// Forma de Recebimento
	private FormaRecebimentoVO recebimento = new FormaRecebimentoVO();
	private List<FormaRecebimentoVO> recebimentoSelecionado = new ArrayList<FormaRecebimentoVO>();
	private List<FormaRecebimentoVO> listaRecebimento = carregaListaRecebimento();
	private String descFormaRecebimento = "";
	private List<FormaRecebimentoVO> copiaListaRecebimento = carregaListaRecebimentoCopia();

	// Principais Concorrentes
	private ConcorrenteVO concorrente = new ConcorrenteVO();
	private List<ConcorrenteVO> concorrenteSelecionado = new ArrayList<ConcorrenteVO>();
	private List<ConcorrenteVO> listaConcorrente = carregaListaConcorrente();
	private String descConcorrente = "";
	private List<ConcorrenteVO> copiaListaConcorrente = carregaListaConcorrenteCopia();
	
	// Detalhar carteira de contratos do cliente (se aplicavel ao setor de
	// atuação)
	private CarteiraContratosVO carteira = new CarteiraContratosVO();
	private List<CarteiraContratosVO> carteiraSelecionado = new ArrayList<CarteiraContratosVO>();
	private List<CarteiraContratosVO> listaCarteira = carregaListaCarteiraContratos();
	private String descCarteira = "";
	private String totalContrato = "";
	private String totalSaldoContrato = "";
	private List<CarteiraContratosVO> copiaListaCarteira = carregaListaCarteiraContratosCopia();
	
	// 5.Situação Econômica-Financeira

	// Highlights Empresa
	private String nomeHighlightsEmpresa = "";
	private HighlightsEmpresaVO balancoA = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO balancoB = new HighlightsEmpresaVO();
	private HighlightsEmpresaVO balancoC = new HighlightsEmpresaVO();
	private String descSituacaoFinanceira = "";

	// 6.Endividamento Bancário
	private EndividamentoBancarioVO endividamento = new EndividamentoBancarioVO();
	private List<EndividamentoBancarioVO> endividamentoSelecionado = new ArrayList<EndividamentoBancarioVO>();
	private List<EndividamentoBancarioVO> listaEndividamento = carregaListaEndividamento();
	private String endividamentoTotalModalidade = "";
	private String endividamentoTotalSaldo = "";
	private String descEndividamentoBancario = "";
	private List<EndividamentoBancarioVO> copiaListaEndividamento = carregaListaEndividamentoCopia();
	
	// Exposição cambial e Política de Hedge
	private String moedaExportacao = "";
	private ImportacoesExportacoesVO volumeA = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO volumeB = new ImportacoesExportacoesVO();
	private ImportacoesExportacoesVO volumeC = new ImportacoesExportacoesVO();
	private String principaisPaisesExportaImporta = "";
	private String detalheProtecaoCambialEmpresa = "";

	// Projeção Encerramento do Ano Fiscal
	private PerspectivasVO projecao = new PerspectivasVO();
	private String detalheEstrategiaProjecao = "";
	private String detalhePrincipaisInvestimentos = "";

	// Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC:
	private VolumeBradescoVO volumeBradesco = new VolumeBradescoVO();

	// CARTÕES
	private CartaoVO cartao = new CartaoVO();
	private List<CartaoVO> cartaoSelecionado = new ArrayList<CartaoVO>();
	private List<CartaoVO> listaCartao = new ArrayList<CartaoVO>();
	private String descReciprocidades = "";

	private List<QuadroAtivosCorporateVO> carregaListaQuadroAtivo() {
		List<QuadroAtivosCorporateVO> lista = new ArrayList<QuadroAtivosCorporateVO>(10);
		for (int i = 0; i < 10; i++) {
			lista.add(new QuadroAtivosCorporateVO());
		}
		return lista;
	}
	
	private List<EndividamentoBancarioVO> carregaListaEndividamento() {
		List<EndividamentoBancarioVO> lista = new ArrayList<EndividamentoBancarioVO>(15);
		for (int i = 0; i < 15; i++) {
			lista.add(new EndividamentoBancarioVO());
		}
		return lista;
	}
	
	private List<EndividamentoBancarioVO> carregaListaEndividamentoCopia(){
		List<EndividamentoBancarioVO> lista = new ArrayList<EndividamentoBancarioVO>(15);
		for (int i = 0; i < 15; i++) {
			lista.add(new EndividamentoBancarioVO());
		}
		return lista;
	}

	private List<CarteiraContratosVO> carregaListaCarteiraContratos() {
		List<CarteiraContratosVO> lista = new ArrayList<CarteiraContratosVO>(30);
		for (int i = 0; i < 30; i++) {
			lista.add(new CarteiraContratosVO());
		}
		return lista;
	}
	
	private List<CarteiraContratosVO> carregaListaCarteiraContratosCopia() {
		List<CarteiraContratosVO> lista = new ArrayList<CarteiraContratosVO>(30);
		for (int i = 0; i < 30; i++) {
			lista.add(new CarteiraContratosVO());
		}
		return lista;
	}	

	private List<ConcorrenteVO> carregaListaConcorrente() {
		List<ConcorrenteVO> lista = new ArrayList<ConcorrenteVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new ConcorrenteVO());
		}
		return lista;
	}

	private List<ConcorrenteVO> carregaListaConcorrenteCopia() {
		List<ConcorrenteVO> lista = new ArrayList<ConcorrenteVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new ConcorrenteVO());
		}
		return lista;
	}

	private List<FormaRecebimentoVO> carregaListaRecebimentoCopia() {
		List<FormaRecebimentoVO> lista = new ArrayList<FormaRecebimentoVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new FormaRecebimentoVO());
		}
		return lista;
	}

	private List<ClienteVO> carregaListaCliente() {
		List<ClienteVO> lista = new ArrayList<ClienteVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new ClienteVO());
		}
		return lista;
	}
	
	private List<FormaRecebimentoVO> carregaListaRecebimento() {
		List<FormaRecebimentoVO> lista = new ArrayList<FormaRecebimentoVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new FormaRecebimentoVO());
		}
		return lista;
	}

	private List<ClienteVO> carregaListaClienteCopia() {
		List<ClienteVO> lista = new ArrayList<ClienteVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new ClienteVO());
		}
		return lista;
	}

	private List<FornecedorVO> carregaListaFornecedor() {
		List<FornecedorVO> lista = new ArrayList<FornecedorVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new FornecedorVO());
		}
		return lista;
	}

	private List<QuadroAtivosCorporateVO> carregaListaQuadroAtivoCopia(){
		List<QuadroAtivosCorporateVO> lista = new ArrayList<QuadroAtivosCorporateVO>(10);
		for (int i = 0; i < 10; i++) {
			lista.add(new QuadroAtivosCorporateVO());
		}
		return lista;
	}	
	
	private List<QuadroAdministrativoVO> carregaListaQuadroAdministrativo() {
		List<QuadroAdministrativoVO> lista = new ArrayList<QuadroAdministrativoVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new QuadroAdministrativoVO());
		}
		return lista;
	}
	
	private List<FornecedorVO> carregaListaFornecedorCopia() {
		List<FornecedorVO> lista = new ArrayList<FornecedorVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new FornecedorVO());
		}
		return lista;
	}
	
	private List<QuadroAdministrativoVO> carregaListaQuadroAdministrativoCopia() {
		List<QuadroAdministrativoVO> lista = new ArrayList<QuadroAdministrativoVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new QuadroAdministrativoVO());
		}
		return lista;
	}
	
	public String getTotalContratoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalContrato);
	}
	
	public String getTotalSaldoContratoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalSaldoContrato);
	}

	public String getEndividamentoTotalSaldoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(endividamentoTotalSaldo);
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

	public QuadroAtivosCorporateVO getQuadroAtivos() {
		return quadroAtivos;
	}

	public void setQuadroAtivos(QuadroAtivosCorporateVO quadroAtivos) {
		this.quadroAtivos = quadroAtivos;
	}

	public List<QuadroAtivosCorporateVO> getQuadroAtivosSelecionado() {
		return quadroAtivosSelecionado;
	}

	public void setQuadroAtivosSelecionado(
			List<QuadroAtivosCorporateVO> quadroAtivosSelecionado) {
		this.quadroAtivosSelecionado = quadroAtivosSelecionado;
	}

	public List<QuadroAtivosCorporateVO> getListaQuadroAtivos() {
		return listaQuadroAtivos;
	}

	public void setListaQuadroAtivos(
			List<QuadroAtivosCorporateVO> listaQuadroAtivos) {
		this.listaQuadroAtivos = listaQuadroAtivos;
	}

	public String getDescQuadroAtivos() {
		return descQuadroAtivos;
	}

	public void setDescQuadroAtivos(String descQuadroAtivos) {
		this.descQuadroAtivos = descQuadroAtivos;
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

	public String getDescFornecedor() {
		return descFornecedor;
	}

	public void setDescFornecedor(String descFornecedor) {
		this.descFornecedor = descFornecedor;
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

	public String getDescFormaRecebimento() {
		return descFormaRecebimento;
	}

	public void setDescFormaRecebimento(String descFormaRecebimento) {
		this.descFormaRecebimento = descFormaRecebimento;
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

	public void setListaConcorrente(
			List<ConcorrenteVO> listaConcorrente) {
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

	public void setListaCarteira(
			List<CarteiraContratosVO> listaCarteira) {
		this.listaCarteira = listaCarteira;
	}

	public String getDescCarteira() {
		return descCarteira;
	}

	public void setDescCarteira(String descCarteira) {
		this.descCarteira = descCarteira;
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

	public String getDescSituacaoFinanceira() {
		return descSituacaoFinanceira;
	}

	public void setDescSituacaoFinanceira(String descSituacaoFinanceira) {
		this.descSituacaoFinanceira = descSituacaoFinanceira;
	}

	public EndividamentoBancarioVO getEndividamento() {
		return endividamento;
	}

	public void setEndividamento(EndividamentoBancarioVO endividamento) {
		this.endividamento = endividamento;
	}

	public List<EndividamentoBancarioVO> getEndividamentoSelecionado() {
		return endividamentoSelecionado;
	}

	public void setEndividamentoSelecionado(
			List<EndividamentoBancarioVO> endividamentoSelecionado) {
		this.endividamentoSelecionado = endividamentoSelecionado;
	}

	public List<EndividamentoBancarioVO> getListaEndividamento() {
		return listaEndividamento;
	}

	public void setListaEndividamento(
			List<EndividamentoBancarioVO> listaEndividamento) {
		this.listaEndividamento = listaEndividamento;
	}

	public String getEndividamentoTotalModalidade() {
		return endividamentoTotalModalidade;
	}

	public void setEndividamentoTotalModalidade(String endividamentoTotalModalidade) {
		this.endividamentoTotalModalidade = endividamentoTotalModalidade;
	}

	public String getEndividamentoTotalSaldo() {
		return endividamentoTotalSaldo;
	}
	

	public void setEndividamentoTotalSaldo(String endividamentoTotalSaldo) {
		this.endividamentoTotalSaldo = endividamentoTotalSaldo;
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

	public String getPrincipaisPaisesExportaImporta() {
		return principaisPaisesExportaImporta;
	}

	public void setPrincipaisPaisesExportaImporta(
			String principaisPaisesExportaImporta) {
		this.principaisPaisesExportaImporta = principaisPaisesExportaImporta;
	}

	public String getDetalheProtecaoCambialEmpresa() {
		return detalheProtecaoCambialEmpresa;
	}

	public void setDetalheProtecaoCambialEmpresa(
			String detalheProtecaoCambialEmpresa) {
		this.detalheProtecaoCambialEmpresa = detalheProtecaoCambialEmpresa;
	}

	public PerspectivasVO getProjecao() {
		return projecao;
	}

	public void setProjecao(PerspectivasVO projecao) {
		this.projecao = projecao;
	}

	public String getDetalheEstrategiaProjecao() {
		return detalheEstrategiaProjecao;
	}

	public void setDetalheEstrategiaProjecao(String detalheEstrategiaProjecao) {
		this.detalheEstrategiaProjecao = detalheEstrategiaProjecao;
	}

	public String getDetalhePrincipaisInvestimentos() {
		return detalhePrincipaisInvestimentos;
	}

	public void setDetalhePrincipaisInvestimentos(
			String detalhePrincipaisInvestimentos) {
		this.detalhePrincipaisInvestimentos = detalhePrincipaisInvestimentos;
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

	public List<QuadroAtivosCorporateVO> getCopiaListaQuadroAtivos() {
		return copiaListaQuadroAtivos;
	}

	public void setCopiaListaQuadroAtivos(
			List<QuadroAtivosCorporateVO> copiaListaQuadroAtivos) {
		this.copiaListaQuadroAtivos = copiaListaQuadroAtivos;
	}

	public List<QuadroAdministrativoVO> getCopiaListaQuadroAdministrativo() {
		return copiaListaQuadroAdministrativo;
	}

	public void setCopiaListaQuadroAdministrativo(
			List<QuadroAdministrativoVO> copiaListaQuadroAdministrativo) {
		this.copiaListaQuadroAdministrativo = copiaListaQuadroAdministrativo;
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

	public List<EndividamentoBancarioVO> getCopiaListaEndividamento() {
		return copiaListaEndividamento;
	}

	public void setCopiaListaEndividamento(
			List<EndividamentoBancarioVO> copiaListaEndividamento) {
		this.copiaListaEndividamento = copiaListaEndividamento;
	}

}
