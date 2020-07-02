package br.com.bradesco.web.ricc.service.business.questionarioimobiliario;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AbaQuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AreaAtuacaoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.HistoricoLancamentosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.LandBankVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasAndamentoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasConcluidasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;


public interface IQuestionarioImobiliarioService extends Serializable {
	
	//Aba Questionario
	void manutencaoDetalheSetorImobiliario(QuestionarioImobiliarioVO objInput, String tipoManutencao, AbaQuestionarioImobiliarioVO questionario);
	
	AbaQuestionarioImobiliarioVO consultaDetalheSetorImobiliario(QuestionarioImobiliarioVO objInput);
	
	void manutencaoAreaAtuacao(QuestionarioImobiliarioVO objInput, String tipoManutencao, AreaAtuacaoVO areaAtuacao);
	
	List<AreaAtuacaoVO> consultaAreaAtuacao(QuestionarioImobiliarioVO objInput);
	
	void manutencaoHistoricoLancamentos(QuestionarioImobiliarioVO objInput, String tipoManutencao, HistoricoLancamentosVO historicoLancamentos, String anoAnterior);
	
	List<HistoricoLancamentosVO> consultaHistoricoLancamentos(QuestionarioImobiliarioVO objInput, StringBuilder vgvTotal, StringBuilder qtdTotal);
	
	void manutencaoLandBank(QuestionarioImobiliarioVO objInput, String tipoManutencao, LandBankVO landBank);
	
	List<LandBankVO> consultaLandBank(QuestionarioImobiliarioVO objInput, StringBuilder totalTerreno, StringBuilder totalProjetada);
	
	//Aba ObrasAndamento
	void manutencaoObrasAndamento (QuestionarioImobiliarioVO objInput, String tipoManutencao, ObrasAndamentoVO obrasAndamento);
	
	QuestionarioImobiliarioVO consultaObrasAndamento(QuestionarioImobiliarioVO objInput, StringBuilder dataBase);
	
	//Aba ObrasConcluidas
	void manutencaoObrasConcluidas (QuestionarioImobiliarioVO objInput, String tipoManutencao, ObrasConcluidasVO obrasConcluidas);
	
	QuestionarioImobiliarioVO consultaObrasConcluidas (QuestionarioImobiliarioVO objInput, StringBuilder dataBase);
	
	void manutencaoComentarios(QuestionarioImobiliarioVO questionario, List<ComentarioVO> comentarios, String tipoManutencao) throws RiccException;
	
	List<ComentarioVO> consultaComentarios(QuestionarioImobiliarioVO questionario, ComentarioEnum comentario);
}
