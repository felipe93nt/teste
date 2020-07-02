package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import java.io.Serializable;

import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;

public class QuestionarioTransportesVO extends QuestionarioSegmentoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Dados Transportes DATABASE
	private DadosTransportesDatabaseVO dadosTransportesDatabase = new DadosTransportesDatabaseVO();
	// ---------------------------

	// Abertura do Faturamento EBITDA
	private FaturamentoEbitdaVO faturamentoEbitda = new FaturamentoEbitdaVO();
	// ------------------------------

	// Principais Custos Operacionais
	private PrincipaisCustosOperacionaisVO principaisCustosOperacionais = new PrincipaisCustosOperacionaisVO();
	// ------------------------------

	// Tipos de Contratos
	private TipoContratosVO tipoContratosAno1 = new TipoContratosVO();
	private TipoContratosVO tipoContratosAno2 = new TipoContratosVO();
	private TipoContratosVO tipoContratosAno3 = new TipoContratosVO();
	private TipoContratosVO tipoContratosAnoExpectativa = new TipoContratosVO();
	// ------------------------------

	// Para Transportes de Cargas
	private TransportesCargasVO transportesCargasAno1 = new TransportesCargasVO();
	private TransportesCargasVO transportesCargasAno2 = new TransportesCargasVO();
	private TransportesCargasVO transportesCargasAno3 = new TransportesCargasVO();
	private TransportesCargasVO transportesCargasAnoExpectativa = new TransportesCargasVO();
	// ------------------------------

	// Para Locadoras
	private LocadorasVO locadoras = new LocadorasVO();
	// ------------------------------

	// Para Transportes de Passageiros
	private TransportesPassageirosVO transportesPassageirosAno1 = new TransportesPassageirosVO();
	private TransportesPassageirosVO transportesPassageirosAno2 = new TransportesPassageirosVO();
	private TransportesPassageirosVO transportesPassageirosAno3 = new TransportesPassageirosVO();
	private TransportesPassageirosVO transportesPassageirosAnoExpectativa = new TransportesPassageirosVO();

	// ------------------------------

	public DadosTransportesDatabaseVO getDadosTransportesDatabase() {
		return dadosTransportesDatabase;
	}

	public void setDadosTransportesDatabase(
			DadosTransportesDatabaseVO dadosTransportesDatabase) {
		this.dadosTransportesDatabase = dadosTransportesDatabase;
	}

	public FaturamentoEbitdaVO getFaturamentoEbitda() {
		return faturamentoEbitda;
	}

	public void setFaturamentoEbitda(FaturamentoEbitdaVO faturamentoEbitda) {
		this.faturamentoEbitda = faturamentoEbitda;
	}

	public PrincipaisCustosOperacionaisVO getPrincipaisCustosOperacionais() {
		return principaisCustosOperacionais;
	}

	public void setPrincipaisCustosOperacionais(
			PrincipaisCustosOperacionaisVO principaisCustosOperacionais) {
		this.principaisCustosOperacionais = principaisCustosOperacionais;
	}

	public TipoContratosVO getTipoContratosAno1() {
		return tipoContratosAno1;
	}

	public void setTipoContratosAno1(TipoContratosVO tipoContratosAno1) {
		this.tipoContratosAno1 = tipoContratosAno1;
	}

	public TipoContratosVO getTipoContratosAno2() {
		return tipoContratosAno2;
	}

	public void setTipoContratosAno2(TipoContratosVO tipoContratosAno2) {
		this.tipoContratosAno2 = tipoContratosAno2;
	}

	public TipoContratosVO getTipoContratosAno3() {
		return tipoContratosAno3;
	}

	public void setTipoContratosAno3(TipoContratosVO tipoContratosAno3) {
		this.tipoContratosAno3 = tipoContratosAno3;
	}

	public TipoContratosVO getTipoContratosAnoExpectativa() {
		return tipoContratosAnoExpectativa;
	}

	public void setTipoContratosAnoExpectativa(
			TipoContratosVO tipoContratosAnoExpectativa) {
		this.tipoContratosAnoExpectativa = tipoContratosAnoExpectativa;
	}

	public TransportesCargasVO getTransportesCargasAno1() {
		return transportesCargasAno1;
	}

	public void setTransportesCargasAno1(
			TransportesCargasVO transportesCargasAno1) {
		this.transportesCargasAno1 = transportesCargasAno1;
	}

	public TransportesCargasVO getTransportesCargasAno2() {
		return transportesCargasAno2;
	}

	public void setTransportesCargasAno2(
			TransportesCargasVO transportesCargasAno2) {
		this.transportesCargasAno2 = transportesCargasAno2;
	}

	public TransportesCargasVO getTransportesCargasAno3() {
		return transportesCargasAno3;
	}

	public void setTransportesCargasAno3(
			TransportesCargasVO transportesCargasAno3) {
		this.transportesCargasAno3 = transportesCargasAno3;
	}

	public TransportesCargasVO getTransportesCargasAnoExpectativa() {
		return transportesCargasAnoExpectativa;
	}

	public void setTransportesCargasAnoExpectativa(
			TransportesCargasVO transportesCargasAnoExpectativa) {
		this.transportesCargasAnoExpectativa = transportesCargasAnoExpectativa;
	}

	public LocadorasVO getLocadoras() {
		return locadoras;
	}

	public void setLocadoras(LocadorasVO locadoras) {
		this.locadoras = locadoras;
	}

	public TransportesPassageirosVO getTransportesPassageirosAno1() {
		return transportesPassageirosAno1;
	}

	public void setTransportesPassageirosAno1(
			TransportesPassageirosVO transportesPassageirosAno1) {
		this.transportesPassageirosAno1 = transportesPassageirosAno1;
	}

	public TransportesPassageirosVO getTransportesPassageirosAno2() {
		return transportesPassageirosAno2;
	}

	public void setTransportesPassageirosAno2(
			TransportesPassageirosVO transportesPassageirosAno2) {
		this.transportesPassageirosAno2 = transportesPassageirosAno2;
	}

	public TransportesPassageirosVO getTransportesPassageirosAno3() {
		return transportesPassageirosAno3;
	}

	public void setTransportesPassageirosAno3(
			TransportesPassageirosVO transportesPassageirosAno3) {
		this.transportesPassageirosAno3 = transportesPassageirosAno3;
	}

	public TransportesPassageirosVO getTransportesPassageirosAnoExpectativa() {
		return transportesPassageirosAnoExpectativa;
	}

	public void setTransportesPassageirosAnoExpectativa(
			TransportesPassageirosVO transportesPassageirosAnoExpectativa) {
		this.transportesPassageirosAnoExpectativa = transportesPassageirosAnoExpectativa;
	}


}
