/**
 * Nome: br.com.bradesco.web.ricc.service.business.questionariotransportes
 * Compilador: JDK 1.5
 * Propósito: INSERIR O PROPÓSITO DAS CLASSES DO PACOTE
 * Data da criação: <dd/MM/yyyy>
 * Parâmetros de compilação: -d
 */
package br.com.bradesco.web.ricc.service.business.questionariotransportes;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CapitalInvestidoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.DadosTransportesDatabaseVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.FaturamentoEbitdaVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.LocadorasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TipoContratosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesCargasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesPassageirosVO;

public interface IQuestionarioTransportesService extends Serializable{
	
	void manutencaoDadosSetorTransportes(QuestionarioTransportesVO questionario, String tipoManutencao);
	DadosTransportesDatabaseVO consultaDadosSetorTransportes(QuestionarioTransportesVO questionario);
	
	void manutencaoAberturaFaturamentoEmpresa(QuestionarioTransportesVO questionario);
	FaturamentoEbitdaVO consultaAberturaFaturamentoEmpresa(QuestionarioTransportesVO questionario);
	
	void manutencaoCustosOperacionais(QuestionarioTransportesVO questionario);
	List<CustosOperacionaisVO> consultaCustosOperacionais(QuestionarioTransportesVO questionario);
	
	void manutencaoCapex(QuestionarioTransportesVO questionario);
	List<CapitalInvestidoVO> consultaCapex(QuestionarioTransportesVO questionario);

	void manutencaoTiposContratos(QuestionarioTransportesVO questionario);
	List<TipoContratosVO> consultaTiposContratos(QuestionarioTransportesVO questionario);
	
	void manutencaoTransportesCargas(QuestionarioTransportesVO questionario);
	List<TransportesCargasVO> consultaTransportesCargas(QuestionarioTransportesVO questionario);
	
	void manutencaoLocadoras(QuestionarioTransportesVO questionario);
	LocadorasVO consultaLocadoras(QuestionarioTransportesVO questionario);
	
	void manutencaoTransportesPassageiros(QuestionarioTransportesVO questionario);
	List<TransportesPassageirosVO> consultaTransportesPassageiros(QuestionarioTransportesVO questionario);
	
}