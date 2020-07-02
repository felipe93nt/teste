/**
 * Nome: br.com.bradesco.web.ricc.service.business.questionarioprojeto
 * Compilador: JDK 1.5
 * Propósito: INSERIR O PROPÓSITO DAS CLASSES DO PACOTE
 * Data da criação: <dd/MM/yyyy>
 * Parâmetros de compilação: -d
 */
package br.com.bradesco.web.ricc.service.business.questionarioprojeto;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.ConstrutoresFornecedoresVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.EstruturaSocietariaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.UsosFontesVO;

public interface IQuestionarioProjetoService extends Serializable{
	
	void manutencaoRelatorioProjeto(QuestionarioProjetoVO objInput, String tipoManutencao);
	
	void manutencaoEstruturaSocietaria(QuestionarioProjetoVO objInput, String tipoManutencao, EstruturaSocietariaVO acionista);
	
	void manutencaoQuadroUsosFontes(QuestionarioProjetoVO objInput, String tipoManutencao, UsosFontesVO usosFontes);

	void manutencaoConstrutoresFornecedores(QuestionarioProjetoVO objInput, String tipoManutencao, ConstrutoresFornecedoresVO construtoresFornecedores);

	QuestionarioProjetoVO consultaRelatorioProjeto(QuestionarioProjetoVO objInput);
	
	List<EstruturaSocietariaVO> consultaEstruturaSocietaria(QuestionarioProjetoVO objInput);
	
	List<ConstrutoresFornecedoresVO> consultaConstrutoresFornecedores(QuestionarioProjetoVO objInput, int tipoConstrutorFornecedor);
	
	List<UsosFontesVO> consultaQuadroUsosFontes(QuestionarioProjetoVO objInput, int tipoUsosFontes);
	
}