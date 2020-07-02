package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.viewhelper;

import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CapitalInvestidoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.CustosOperacionaisVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TipoContratosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesCargasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.TransportesPassageirosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.ValoresLocadorasVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class Equipe1ConsultaQuestionarioTransportesViewHelper extends AbstractViewHelper {

	private static final long serialVersionUID = -9204063849971006413L;
	
	private QuestionarioTransportesVO model;
	
	@Override
	public void inicializar() {
		model = new QuestionarioTransportesVO();
	}

	public QuestionarioTransportesVO getModel() {
		return model;
	}

	public void setModel(
			QuestionarioTransportesVO questionarioTransporte) {
		this.model = questionarioTransporte;
	}

	/**
	  * Nome: getCustosOperacionaisAno
	  * Propósito: 
	  * Retornar as informações de custo operacional
	  * referente ao ano passado por parâmetro
	  * para facilitar os calculos em cima desses dados
	  * @param ano
	  * 1 - Ano 1
	  * 2 - Ano 2
	  * 3 - Ano 3	
	  * 4 - Ano expectativa	
	  * @return CustosOperacionaisVO
	  * @see: QuestionarioTransportesViewHelper
	  */
	public CustosOperacionaisVO getCustosOperacionaisAno(int ano){
		switch (ano) {
		case 1:
			return this.model.getPrincipaisCustosOperacionais().getCustosOperacionaisAno1();
		case 2:
			return this.model.getPrincipaisCustosOperacionais().getCustosOperacionaisAno2();
		case 3:
			return this.model.getPrincipaisCustosOperacionais().getCustosOperacionaisAno3();
		case 4:
			return this.model.getPrincipaisCustosOperacionais().getCustosOperacionaisAnoExpectativa();
		}
		return null;
	}
	
	public TipoContratosVO getTipoContratosAno(int ano){
		switch (ano) {
		case 1:
			return this.model.getTipoContratosAno1();
		case 2:
			return this.model.getTipoContratosAno2();
		case 3:
			return this.model.getTipoContratosAno3();
		case 4:
			return this.model.getTipoContratosAnoExpectativa();
		}
		return null;
	}

	public TransportesCargasVO getTransporteCargasAno(int ano) {
		switch (ano) {
		case 1:
			return this.model.getTransportesCargasAno1();
		case 2:
			return this.model.getTransportesCargasAno2();
		case 3:
			return this.model.getTransportesCargasAno3();
		case 4:
			return this.model.getTransportesCargasAnoExpectativa();
		}
		return null;
	}

	public ValoresLocadorasVO getValoresLocadorasAno(int ano) {
		switch (ano) {
		case 1:
			return this.model.getLocadoras().getValoresLocadorasAno1();
		case 2:
			return this.model.getLocadoras().getValoresLocadorasAno2();
		case 3:
			return this.model.getLocadoras().getValoresLocadorasAno3();
		case 4:
			return this.model.getLocadoras().getValoresLocadorasAnoExpectativa();
		}
		return null;
	}
	
	public CapitalInvestidoVO getCapexAno(int ano){
		switch (ano) {
		case 1:
			return this.model.getPrincipaisCustosOperacionais().getCapexAno1();
		case 2:
			return this.model.getPrincipaisCustosOperacionais().getCapexAno2();
		case 3:
			return this.model.getPrincipaisCustosOperacionais().getCapexAno3();
		case 4:
			return this.model.getPrincipaisCustosOperacionais().getCapexAnoExpectativa();
		}
		return null;
	}
	
	public TransportesPassageirosVO getTransportesPassageirosAno(int ano){
		switch (ano) {
		case 1:
			return this.model.getTransportesPassageirosAno1();
		case 2:
			return this.model.getTransportesPassageirosAno2();
		case 3:
			return this.model.getTransportesPassageirosAno3();
		case 4:
			return this.model.getTransportesPassageirosAnoExpectativa();
		}
		return null;
	
	}
	
	
}
