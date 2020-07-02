package br.com.bradesco.web.ricc.service.business.questionariosegmento;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SituacaoRelatorioEnum;
import br.com.bradesco.web.ricc.enums.TipoFuncaoEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuadroAtivosCorporateVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
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

public interface ISegmentoService extends Serializable {
	
	void consultaSegmento(QuestionarioSegmentoVO questionario);
	
	void manutencaoQuadroAtivos(QuestionarioSegmentoVO questionario, QuadroAtivosCorporateVO ativos, String tipoManutencao);
	List<QuadroAtivosCorporateVO> consultaQuadroAtivos(QuestionarioSegmentoVO questionario);
	
	void manutencaoQuadroAdministrativo(QuestionarioSegmentoVO questionario, QuadroAdministrativoVO administrador, String tipoManutencao);
	List<QuadroAdministrativoVO> consultaQuadroAdministrativo(QuestionarioSegmentoVO questionario);
	
	void manutencaoDetalhamentoPatrimonio(QuestionarioSegmentoVO questionario, DetalhamentoPatrimonioVO patrimonio, String tipoManutencao);
	List<DetalhamentoPatrimonioVO> consultaDetalhamentoPatrimonio(QuestionarioSegmentoVO questionario, StringBuilder totalizador);
	
	void manutencaoCapacidadeProdutiva(QuestionarioSegmentoVO questionario, CapacidadeProdutivaVO producao, String tipoManutencao);
	List<CapacidadeProdutivaVO> consultaCapacidadeProdutiva(QuestionarioSegmentoVO questionario, StringBuilder totalCapacidade, StringBuilder totalProducao);
	
	void manutencaoCartoes(QuestionarioSegmentoVO questionario, CartaoVO cartao, String tipoManutencao);
	List<CartaoVO> consultaCartoes(QuestionarioSegmentoVO questionario);
	
	void manutencaoCarteiraContratos(QuestionarioSegmentoVO questionario, CarteiraContratosVO carteira, String tipoManutencao);
	List<CarteiraContratosVO> consultaCarteiraContratos(QuestionarioSegmentoVO questionario, StringBuilder totalContrato, StringBuilder totalSaldo);
	
	void manutencaoCliente(QuestionarioSegmentoVO questionario, ClienteVO cliente, String tipoManutencao);
	List<ClienteVO> consultaCliente(QuestionarioSegmentoVO questionario);
	
	void manutencaoConcorrente(QuestionarioSegmentoVO questionario, ConcorrenteVO concorrente, String tipoManutencao);
	List<ConcorrenteVO> consultaConcorrente(QuestionarioSegmentoVO questionario);
	
	void manutencaoEndividamentoBancario(QuestionarioSegmentoVO questionario, EndividamentoBancarioVO endividamento, TipoManutencaoEnum tipoManutencao);
	List<EndividamentoBancarioVO> consultaEndividamentoBancario(QuestionarioSegmentoVO questionario, StringBuilder totalizador);
	
	void manutencaoFaturamentoConsolidado(QuestionarioSegmentoVO questionario, List<FaturamentoConsolidadoVO> listaFaturamento, String tipoManutencao);
	List<FaturamentoConsolidadoVO> consultaFaturamentoConsolidado(QuestionarioSegmentoVO questionario);
	
	void manutencaoFaturamentoSegmento(QuestionarioSegmentoVO questionario, FaturamentoPorSegmentoVO faturamento, TipoManutencaoEnum tipoManutencao);
	FaturamentoPorSegmentoVO consultaFaturamentoSegmento(QuestionarioSegmentoVO questionario);
	
	void manutencaoFormaRecebimento(QuestionarioSegmentoVO questionario, FormaRecebimentoVO recebimento, String tipoManutencao);
	List<FormaRecebimentoVO> consultaFormaRecebimento(QuestionarioSegmentoVO questionario);
	
	void manutencaoFornecedor(QuestionarioSegmentoVO questionario, FornecedorVO fornecedor, String tipoManutencao);
	List<FornecedorVO> consultaFornecedor(QuestionarioSegmentoVO questionario);
	
	void manutencaoHighlightsEmpresa(QuestionarioSegmentoVO questionario,
			List<HighlightsEmpresaVO> listaBalanco,
			TipoManutencaoEnum tipoManutencao,
			String nomeHighlightsEmpresa);
	List<HighlightsEmpresaVO> consultaHighlightsEmpresa(QuestionarioSegmentoVO questionario, StringBuilder nomeHighlightsEmpresa);
	
	void manutencaoImportacoesExportacoes(QuestionarioSegmentoVO questionario,
			List<ImportacoesExportacoesVO> listaVolume, String tipoManutencao,
			String tipoMoeda);
	List<ImportacoesExportacoesVO> consultaImportacoesExportacoes(QuestionarioSegmentoVO questionario, StringBuilder moeda);
	
	void manutencaoPerspectivas(QuestionarioSegmentoVO questionario, PerspectivasVO perspectiva, String tipoManutencao);
	PerspectivasVO consultaPerspectivas(QuestionarioSegmentoVO questionario);
	
	void manutencaoVolumeBradesco(QuestionarioSegmentoVO questionario, VolumeBradescoVO volume, String tipoManutencao);
	VolumeBradescoVO consultaVolumeBradesco(QuestionarioSegmentoVO questionario);
	
	Integer manutencaoSetores(QuestionarioSegmentoVO questionario, TipoQuestionarioVO listaSetor, String tipoManutencao);
	List<TipoQuestionarioVO> consultaSetores(QuestionarioSegmentoVO questionario);
	void manutencaoSetorAgro(QuestionarioSegmentoVO questionario, QuestionarioAgronegocioVO setor, TipoManutencaoEnum tipoManutencao);
	void manutencaoSetorImobiliario(QuestionarioSegmentoVO questionario, QuestionarioImobiliarioVO setor, TipoManutencaoEnum tipoManutencao);
	void manutencaoSetorProjetos(QuestionarioSegmentoVO questionario, QuestionarioProjetoVO setor, TipoManutencaoEnum tipoManutencao);
	void manutencaoSetorTransporte(QuestionarioSegmentoVO questionario, QuestionarioTransportesVO setor, TipoManutencaoEnum tipoManutencao);
	
	void manutencaoComentarios(QuestionarioSegmentoVO questionario, List<ComentarioVO> comentarios, String tipoManutencao);
	List<ComentarioVO> consultaComentarios(QuestionarioSegmentoVO questionario, String codTipoComentario);
	
	String manutencaoRelatorioInfoCredito(QuestionarioSegmentoVO vo, TipoFuncaoEnum tipoFuncao, SituacaoRelatorioEnum situacaoRelatorio, SegmentoEnum segmento);
	String manutencaoRelatorioSegmento(QuestionarioSegmentoVO vo, TipoManutencaoEnum tipoManutencao);
	
	public String excluirRelatorio(String codGrupo, Integer numeroRelatorio);
	
	Integer copiarCadastro(CadastramentoVO itemSelecionado, String codGrupo);
}
