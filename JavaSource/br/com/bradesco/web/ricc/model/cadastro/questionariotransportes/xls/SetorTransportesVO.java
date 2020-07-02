package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.xls;

import java.math.BigDecimal;

public class SetorTransportesVO {
	
	private String dataBase;
	
	private BigDecimal quantidadeVeiculos;
	private BigDecimal valorDaFrota;
	private BigDecimal saldoDevedor;
	
	private Integer idadeMedia;
	private BigDecimal desembolsoLeasingFiname;
	private BigDecimal desembolsoCagiro;
	private BigDecimal faturamentoMedioMensal;
	
	private Double percentualFrotaPropria;
	private Double margemEBITDA;
	
	private Double varejoFaturamento;
	private Double varejoEBITDA;
	private Double saudeFaturamento;
	private Double saudeEBITDA;
	private Double quimicoFaturamento;
	private Double quimicoEBITDA;
	private Double agroFaturamento;
	private Double agroEBITDA;

	private String descricaoOutros;
	private Double outrosFaturamento;
	private Double outrosEBITDA;

	private Double setorPublicoFaturamento;
	private Double setorPublicoEBITDA;
	private Double receitasVistaFaturamento;
	private Double receitasVistaEBITDA;
	private Double receitasPrazoFaturamento;
	private Double receitasPrazoEBITDA;
	
	private String detalharSituacaoPrincipaisContratos;
	private String licitacoesSeusVencimentos;
	private String outorgaVencimentosUltimosValores;
	
	private String anoPrincipalCustoOperacional;
	
	private Double combustiveis1;
	private Double combustiveis2;
	private Double combustiveis3;
	private Double combustiveis4;
	
	private Double maoDeObra1;
	private Double maoDeObra2;
	private Double maoDeObra3;
	private Double maoDeObra4;
	
	private Double outros1;
	private Double outros2;
	private Double outros3;
	private Double outros4;
	
	private BigDecimal recursosProprios1;
	private BigDecimal recursosProprios2;
	private BigDecimal recursosProprios3;
	private BigDecimal recursosProprios4;
	
	private BigDecimal recursosTerceiros1;
	private BigDecimal recursosTerceiros2;
	private BigDecimal recursosTerceiros3;
	private BigDecimal recursosTerceiros4;

	private String detalharPrincipaisInvestimentos;
	
	private Double tpContratoAPerformar1;
	private Double tpContratoAPerformar2;
	private Double tpContratoAPerformar3;
	private Double tpContratoAPerformar4;
	
	private Double tpContratoTakeOrPay1;
	private Double tpContratoTakeOrPay2;
	private Double tpContratoTakeOrPay3;
	private Double tpContratoTakeOrPay4;
	
	private Double tpContratoLocacao1;
	private Double tpContratoLocacao2;
	private Double tpContratoLocacao3;
	private Double tpContratoLocacao4;
	
	private Double tpContratoSpot1;
	private Double tpContratoSpot2;
	private Double tpContratoSpot3;
	private Double tpContratoSpot4;
	
	private Double frotaPropria1;
	private Double frotaPropria2;
	private Double frotaPropria3;
	private Double frotaPropria4;
	
	private Double frotaAgregados1;
	private Double frotaAgregados2;
	private Double frotaAgregados3;
	private Double frotaAgregados4;

	private Double frotaTerceiros1;
	private Double frotaTerceiros2;
	private Double frotaTerceiros3;
	private Double frotaTerceiros4;
	
	private Double faturamentoLocacao1;
	private Double faturamentoLocacao2;
	private Double faturamentoLocacao3;
	private Double faturamentoLocacao4;
	
	private String descricaoFaturamentoOutros;
	private Double faturamentoOutros1;
	private Double faturamentoOutros2;
	private Double faturamentoOutros3;
	private Double faturamentoOutros4;

	private Double faturamentoVendaDeVeiculos1;
	private Double faturamentoVendaDeVeiculos2;
	private Double faturamentoVendaDeVeiculos3;
	private Double faturamentoVendaDeVeiculos4;
	
	private BigDecimal frotaUnidadesTotal1;
	private BigDecimal frotaUnidadesTotal2;
	private BigDecimal frotaUnidadesTotal3;
	private BigDecimal frotaUnidadesTotal4;
	
	private BigDecimal frotaUnidadesVendaVeiculos1;
	private BigDecimal frotaUnidadesVendaVeiculos2;
	private BigDecimal frotaUnidadesVendaVeiculos3;
	private BigDecimal frotaUnidadesVendaVeiculos4;
	
	private Double reajustesPassagensMunicipal1;
	private Double reajustesPassagensMunicipal2;
	private Double reajustesPassagensMunicipal3;
	private Double reajustesPassagensMunicipal4;
	
	private Double reajustesPassagensIntermunicipal1;
	private Double reajustesPassagensIntermunicipal2;
	private Double reajustesPassagensIntermunicipal3;
	private Double reajustesPassagensIntermunicipal4;

	private Double reajustesPassagensInterestadual1;
	private Double reajustesPassagensInterestadual2;
	private Double reajustesPassagensInterestadual3;
	private Double reajustesPassagensInterestadual4;

	private Double reajustesPassagensInternacional1;
	private Double reajustesPassagensInternacional2;
	private Double reajustesPassagensInternacional3;
	private Double reajustesPassagensInternacional4;

	private Double reajustesPassagensFretamento1;
	private Double reajustesPassagensFretamento2;
	private Double reajustesPassagensFretamento3;
	private Double reajustesPassagensFretamento4;
	
	public String getDataBase() {
		return dataBase;
	}
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	public BigDecimal getQuantidadeVeiculos() {
		return quantidadeVeiculos;
	}
	public void setQuantidadeVeiculos(BigDecimal quantidadeVeiculos) {
		this.quantidadeVeiculos = quantidadeVeiculos;
	}
	public BigDecimal getValorDaFrota() {
		return valorDaFrota;
	}
	public void setValorDaFrota(BigDecimal valorDaFrota) {
		this.valorDaFrota = valorDaFrota;
	}
	public BigDecimal getSaldoDevedor() {
		return saldoDevedor;
	}
	public void setSaldoDevedor(BigDecimal saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}
	public Integer getIdadeMedia() {
		return idadeMedia;
	}
	public void setIdadeMedia(Integer idadeMedia) {
		this.idadeMedia = idadeMedia;
	}
	public BigDecimal getDesembolsoLeasingFiname() {
		return desembolsoLeasingFiname;
	}
	public void setDesembolsoLeasingFiname(BigDecimal desembolsoLeasingFiname) {
		this.desembolsoLeasingFiname = desembolsoLeasingFiname;
	}
	public BigDecimal getDesembolsoCagiro() {
		return desembolsoCagiro;
	}
	public void setDesembolsoCagiro(BigDecimal desembolsoCagiro) {
		this.desembolsoCagiro = desembolsoCagiro;
	}
	public BigDecimal getFaturamentoMedioMensal() {
		return faturamentoMedioMensal;
	}
	public void setFaturamentoMedioMensal(BigDecimal faturamentoMedioMensal) {
		this.faturamentoMedioMensal = faturamentoMedioMensal;
	}
	public Double getPercentualFrotaPropria() {
		return percentualFrotaPropria;
	}
	public void setPercentualFrotaPropria(Double percentualFrotaPropria) {
		this.percentualFrotaPropria = percentualFrotaPropria;
	}
	public Double getMargemEBITDA() {
		return margemEBITDA;
	}
	public void setMargemEBITDA(Double margemEBITDA) {
		this.margemEBITDA = margemEBITDA;
	}
	public Double getVarejoFaturamento() {
		return varejoFaturamento;
	}
	public void setVarejoFaturamento(Double varejoFaturamento) {
		this.varejoFaturamento = varejoFaturamento;
	}
	public Double getVarejoEBITDA() {
		return varejoEBITDA;
	}
	public void setVarejoEBITDA(Double varejoEBITDA) {
		this.varejoEBITDA = varejoEBITDA;
	}
	public Double getSaudeFaturamento() {
		return saudeFaturamento;
	}
	public void setSaudeFaturamento(Double saudeFaturamento) {
		this.saudeFaturamento = saudeFaturamento;
	}
	public Double getSaudeEBITDA() {
		return saudeEBITDA;
	}
	public void setSaudeEBITDA(Double saudeEBITDA) {
		this.saudeEBITDA = saudeEBITDA;
	}
	public Double getQuimicoFaturamento() {
		return quimicoFaturamento;
	}
	public void setQuimicoFaturamento(Double quimicoFaturamento) {
		this.quimicoFaturamento = quimicoFaturamento;
	}
	public Double getQuimicoEBITDA() {
		return quimicoEBITDA;
	}
	public void setQuimicoEBITDA(Double quimicoEBITDA) {
		this.quimicoEBITDA = quimicoEBITDA;
	}
	public Double getAgroFaturamento() {
		return agroFaturamento;
	}
	public void setAgroFaturamento(Double agroFaturamento) {
		this.agroFaturamento = agroFaturamento;
	}
	public Double getAgroEBITDA() {
		return agroEBITDA;
	}
	public void setAgroEBITDA(Double agroEBITDA) {
		this.agroEBITDA = agroEBITDA;
	}
	public String getDescricaoOutros() {
		return descricaoOutros;
	}
	public void setDescricaoOutros(String descricaoOutros) {
		this.descricaoOutros = descricaoOutros;
	}
	public Double getOutrosFaturamento() {
		return outrosFaturamento;
	}
	public void setOutrosFaturamento(Double outrosFaturamento) {
		this.outrosFaturamento = outrosFaturamento;
	}
	public Double getOutrosEBITDA() {
		return outrosEBITDA;
	}
	public void setOutrosEBITDA(Double outrosEBITDA) {
		this.outrosEBITDA = outrosEBITDA;
	}
	public Double getSetorPublicoFaturamento() {
		return setorPublicoFaturamento;
	}
	public void setSetorPublicoFaturamento(Double setorPublicoFaturamento) {
		this.setorPublicoFaturamento = setorPublicoFaturamento;
	}
	public Double getSetorPublicoEBITDA() {
		return setorPublicoEBITDA;
	}
	public void setSetorPublicoEBITDA(Double setorPublicoEBITDA) {
		this.setorPublicoEBITDA = setorPublicoEBITDA;
	}
	public Double getReceitasVistaFaturamento() {
		return receitasVistaFaturamento;
	}
	public void setReceitasVistaFaturamento(Double receitasVistaFaturamento) {
		this.receitasVistaFaturamento = receitasVistaFaturamento;
	}
	public Double getReceitasVistaEBITDA() {
		return receitasVistaEBITDA;
	}
	public void setReceitasVistaEBITDA(Double receitasVistaEBITDA) {
		this.receitasVistaEBITDA = receitasVistaEBITDA;
	}
	public Double getReceitasPrazoFaturamento() {
		return receitasPrazoFaturamento;
	}
	public void setReceitasPrazoFaturamento(Double receitasPrazoFaturamento) {
		this.receitasPrazoFaturamento = receitasPrazoFaturamento;
	}
	public Double getReceitasPrazoEBITDA() {
		return receitasPrazoEBITDA;
	}
	public void setReceitasPrazoEBITDA(Double receitasPrazoEBITDA) {
		this.receitasPrazoEBITDA = receitasPrazoEBITDA;
	}
	public String getDetalharSituacaoPrincipaisContratos() {
		return detalharSituacaoPrincipaisContratos;
	}
	public void setDetalharSituacaoPrincipaisContratos(
			String detalharSituacaoPrincipaisContratos) {
		this.detalharSituacaoPrincipaisContratos = detalharSituacaoPrincipaisContratos;
	}
	public String getLicitacoesSeusVencimentos() {
		return licitacoesSeusVencimentos;
	}
	public void setLicitacoesSeusVencimentos(String licitacoesSeusVencimentos) {
		this.licitacoesSeusVencimentos = licitacoesSeusVencimentos;
	}
	public String getOutorgaVencimentosUltimosValores() {
		return outorgaVencimentosUltimosValores;
	}
	public void setOutorgaVencimentosUltimosValores(
			String outorgaVencimentosUltimosValores) {
		this.outorgaVencimentosUltimosValores = outorgaVencimentosUltimosValores;
	}
	public String getAnoPrincipalCustoOperacional() {
		return anoPrincipalCustoOperacional;
	}
	public void setAnoPrincipalCustoOperacional(String anoPrincipalCustoOperacional) {
		this.anoPrincipalCustoOperacional = anoPrincipalCustoOperacional;
	}
	public Double getCombustiveis1() {
		return combustiveis1;
	}
	public void setCombustiveis1(Double combustiveis1) {
		this.combustiveis1 = combustiveis1;
	}
	public Double getCombustiveis2() {
		return combustiveis2;
	}
	public void setCombustiveis2(Double combustiveis2) {
		this.combustiveis2 = combustiveis2;
	}
	public Double getCombustiveis3() {
		return combustiveis3;
	}
	public void setCombustiveis3(Double combustiveis3) {
		this.combustiveis3 = combustiveis3;
	}
	public Double getCombustiveis4() {
		return combustiveis4;
	}
	public void setCombustiveis4(Double combustiveis4) {
		this.combustiveis4 = combustiveis4;
	}
	public Double getMaoDeObra1() {
		return maoDeObra1;
	}
	public void setMaoDeObra1(Double maoDeObra1) {
		this.maoDeObra1 = maoDeObra1;
	}
	public Double getMaoDeObra2() {
		return maoDeObra2;
	}
	public void setMaoDeObra2(Double maoDeObra2) {
		this.maoDeObra2 = maoDeObra2;
	}
	public Double getMaoDeObra3() {
		return maoDeObra3;
	}
	public void setMaoDeObra3(Double maoDeObra3) {
		this.maoDeObra3 = maoDeObra3;
	}
	public Double getMaoDeObra4() {
		return maoDeObra4;
	}
	public void setMaoDeObra4(Double maoDeObra4) {
		this.maoDeObra4 = maoDeObra4;
	}
	public Double getOutros1() {
		return outros1;
	}
	public void setOutros1(Double outros1) {
		this.outros1 = outros1;
	}
	public Double getOutros2() {
		return outros2;
	}
	public void setOutros2(Double outros2) {
		this.outros2 = outros2;
	}
	public Double getOutros3() {
		return outros3;
	}
	public void setOutros3(Double outros3) {
		this.outros3 = outros3;
	}
	public Double getOutros4() {
		return outros4;
	}
	public void setOutros4(Double outros4) {
		this.outros4 = outros4;
	}
	public BigDecimal getRecursosProprios1() {
		return recursosProprios1;
	}
	public void setRecursosProprios1(BigDecimal recursosProprios1) {
		this.recursosProprios1 = recursosProprios1;
	}
	public BigDecimal getRecursosProprios2() {
		return recursosProprios2;
	}
	public void setRecursosProprios2(BigDecimal recursosProprios2) {
		this.recursosProprios2 = recursosProprios2;
	}
	public BigDecimal getRecursosProprios3() {
		return recursosProprios3;
	}
	public void setRecursosProprios3(BigDecimal recursosProprios3) {
		this.recursosProprios3 = recursosProprios3;
	}
	public BigDecimal getRecursosProprios4() {
		return recursosProprios4;
	}
	public void setRecursosProprios4(BigDecimal recursosProprios4) {
		this.recursosProprios4 = recursosProprios4;
	}
	public BigDecimal getRecursosTerceiros1() {
		return recursosTerceiros1;
	}
	public void setRecursosTerceiros1(BigDecimal recursosTerceiros1) {
		this.recursosTerceiros1 = recursosTerceiros1;
	}
	public BigDecimal getRecursosTerceiros2() {
		return recursosTerceiros2;
	}
	public void setRecursosTerceiros2(BigDecimal recursosTerceiros2) {
		this.recursosTerceiros2 = recursosTerceiros2;
	}
	public BigDecimal getRecursosTerceiros3() {
		return recursosTerceiros3;
	}
	public void setRecursosTerceiros3(BigDecimal recursosTerceiros3) {
		this.recursosTerceiros3 = recursosTerceiros3;
	}
	public BigDecimal getRecursosTerceiros4() {
		return recursosTerceiros4;
	}
	public void setRecursosTerceiros4(BigDecimal recursosTerceiros4) {
		this.recursosTerceiros4 = recursosTerceiros4;
	}
	public String getDetalharPrincipaisInvestimentos() {
		return detalharPrincipaisInvestimentos;
	}
	public void setDetalharPrincipaisInvestimentos(
			String detalharPrincipaisInvestimentos) {
		this.detalharPrincipaisInvestimentos = detalharPrincipaisInvestimentos;
	}
	public Double getTpContratoAPerformar1() {
		return tpContratoAPerformar1;
	}
	public void setTpContratoAPerformar1(Double tpContratoAPerformar1) {
		this.tpContratoAPerformar1 = tpContratoAPerformar1;
	}
	public Double getTpContratoAPerformar2() {
		return tpContratoAPerformar2;
	}
	public void setTpContratoAPerformar2(Double tpContratoAPerformar2) {
		this.tpContratoAPerformar2 = tpContratoAPerformar2;
	}
	public Double getTpContratoAPerformar3() {
		return tpContratoAPerformar3;
	}
	public void setTpContratoAPerformar3(Double tpContratoAPerformar3) {
		this.tpContratoAPerformar3 = tpContratoAPerformar3;
	}
	public Double getTpContratoAPerformar4() {
		return tpContratoAPerformar4;
	}
	public void setTpContratoAPerformar4(Double tpContratoAPerformar4) {
		this.tpContratoAPerformar4 = tpContratoAPerformar4;
	}
	public Double getTpContratoTakeOrPay1() {
		return tpContratoTakeOrPay1;
	}
	public void setTpContratoTakeOrPay1(Double tpContratoTakeOrPay1) {
		this.tpContratoTakeOrPay1 = tpContratoTakeOrPay1;
	}
	public Double getTpContratoTakeOrPay2() {
		return tpContratoTakeOrPay2;
	}
	public void setTpContratoTakeOrPay2(Double tpContratoTakeOrPay2) {
		this.tpContratoTakeOrPay2 = tpContratoTakeOrPay2;
	}
	public Double getTpContratoTakeOrPay3() {
		return tpContratoTakeOrPay3;
	}
	public void setTpContratoTakeOrPay3(Double tpContratoTakeOrPay3) {
		this.tpContratoTakeOrPay3 = tpContratoTakeOrPay3;
	}
	public Double getTpContratoTakeOrPay4() {
		return tpContratoTakeOrPay4;
	}
	public void setTpContratoTakeOrPay4(Double tpContratoTakeOrPay4) {
		this.tpContratoTakeOrPay4 = tpContratoTakeOrPay4;
	}
	public Double getTpContratoLocacao1() {
		return tpContratoLocacao1;
	}
	public void setTpContratoLocacao1(Double tpContratoLocacao1) {
		this.tpContratoLocacao1 = tpContratoLocacao1;
	}
	public Double getTpContratoLocacao2() {
		return tpContratoLocacao2;
	}
	public void setTpContratoLocacao2(Double tpContratoLocacao2) {
		this.tpContratoLocacao2 = tpContratoLocacao2;
	}
	public Double getTpContratoLocacao3() {
		return tpContratoLocacao3;
	}
	public void setTpContratoLocacao3(Double tpContratoLocacao3) {
		this.tpContratoLocacao3 = tpContratoLocacao3;
	}
	public Double getTpContratoLocacao4() {
		return tpContratoLocacao4;
	}
	public void setTpContratoLocacao4(Double tpContratoLocacao4) {
		this.tpContratoLocacao4 = tpContratoLocacao4;
	}
	public Double getTpContratoSpot1() {
		return tpContratoSpot1;
	}
	public void setTpContratoSpot1(Double tpContratoSpot1) {
		this.tpContratoSpot1 = tpContratoSpot1;
	}
	public Double getTpContratoSpot2() {
		return tpContratoSpot2;
	}
	public void setTpContratoSpot2(Double tpContratoSpot2) {
		this.tpContratoSpot2 = tpContratoSpot2;
	}
	public Double getTpContratoSpot3() {
		return tpContratoSpot3;
	}
	public void setTpContratoSpot3(Double tpContratoSpot3) {
		this.tpContratoSpot3 = tpContratoSpot3;
	}
	public Double getTpContratoSpot4() {
		return tpContratoSpot4;
	}
	public void setTpContratoSpot4(Double tpContratoSpot4) {
		this.tpContratoSpot4 = tpContratoSpot4;
	}
	public Double getFrotaPropria1() {
		return frotaPropria1;
	}
	public void setFrotaPropria1(Double frotaPropria1) {
		this.frotaPropria1 = frotaPropria1;
	}
	public Double getFrotaPropria2() {
		return frotaPropria2;
	}
	public void setFrotaPropria2(Double frotaPropria2) {
		this.frotaPropria2 = frotaPropria2;
	}
	public Double getFrotaPropria3() {
		return frotaPropria3;
	}
	public void setFrotaPropria3(Double frotaPropria3) {
		this.frotaPropria3 = frotaPropria3;
	}
	public Double getFrotaPropria4() {
		return frotaPropria4;
	}
	public void setFrotaPropria4(Double frotaPropria4) {
		this.frotaPropria4 = frotaPropria4;
	}
	public Double getFrotaAgregados1() {
		return frotaAgregados1;
	}
	public void setFrotaAgregados1(Double frotaAgregados1) {
		this.frotaAgregados1 = frotaAgregados1;
	}
	public Double getFrotaAgregados2() {
		return frotaAgregados2;
	}
	public void setFrotaAgregados2(Double frotaAgregados2) {
		this.frotaAgregados2 = frotaAgregados2;
	}
	public Double getFrotaAgregados3() {
		return frotaAgregados3;
	}
	public void setFrotaAgregados3(Double frotaAgregados3) {
		this.frotaAgregados3 = frotaAgregados3;
	}
	public Double getFrotaAgregados4() {
		return frotaAgregados4;
	}
	public void setFrotaAgregados4(Double frotaAgregados4) {
		this.frotaAgregados4 = frotaAgregados4;
	}
	public Double getFrotaTerceiros1() {
		return frotaTerceiros1;
	}
	public void setFrotaTerceiros1(Double frotaTerceiros1) {
		this.frotaTerceiros1 = frotaTerceiros1;
	}
	public Double getFrotaTerceiros2() {
		return frotaTerceiros2;
	}
	public void setFrotaTerceiros2(Double frotaTerceiros2) {
		this.frotaTerceiros2 = frotaTerceiros2;
	}
	public Double getFrotaTerceiros3() {
		return frotaTerceiros3;
	}
	public void setFrotaTerceiros3(Double frotaTerceiros3) {
		this.frotaTerceiros3 = frotaTerceiros3;
	}
	public Double getFrotaTerceiros4() {
		return frotaTerceiros4;
	}
	public void setFrotaTerceiros4(Double frotaTerceiros4) {
		this.frotaTerceiros4 = frotaTerceiros4;
	}
	public Double getFaturamentoLocacao1() {
		return faturamentoLocacao1;
	}
	public void setFaturamentoLocacao1(Double faturamentoLocacao1) {
		this.faturamentoLocacao1 = faturamentoLocacao1;
	}
	public Double getFaturamentoLocacao2() {
		return faturamentoLocacao2;
	}
	public void setFaturamentoLocacao2(Double faturamentoLocacao2) {
		this.faturamentoLocacao2 = faturamentoLocacao2;
	}
	public Double getFaturamentoLocacao3() {
		return faturamentoLocacao3;
	}
	public void setFaturamentoLocacao3(Double faturamentoLocacao3) {
		this.faturamentoLocacao3 = faturamentoLocacao3;
	}
	public Double getFaturamentoLocacao4() {
		return faturamentoLocacao4;
	}
	public void setFaturamentoLocacao4(Double faturamentoLocacao4) {
		this.faturamentoLocacao4 = faturamentoLocacao4;
	}
	public String getDescricaoFaturamentoOutros() {
		return descricaoFaturamentoOutros;
	}
	public void setDescricaoFaturamentoOutros(String descricaoFaturamentoOutros) {
		this.descricaoFaturamentoOutros = descricaoFaturamentoOutros;
	}
	public Double getFaturamentoOutros1() {
		return faturamentoOutros1;
	}
	public void setFaturamentoOutros1(Double faturamentoOutros1) {
		this.faturamentoOutros1 = faturamentoOutros1;
	}
	public Double getFaturamentoOutros2() {
		return faturamentoOutros2;
	}
	public void setFaturamentoOutros2(Double faturamentoOutros2) {
		this.faturamentoOutros2 = faturamentoOutros2;
	}
	public Double getFaturamentoOutros3() {
		return faturamentoOutros3;
	}
	public void setFaturamentoOutros3(Double faturamentoOutros3) {
		this.faturamentoOutros3 = faturamentoOutros3;
	}
	public Double getFaturamentoOutros4() {
		return faturamentoOutros4;
	}
	public void setFaturamentoOutros4(Double faturamentoOutros4) {
		this.faturamentoOutros4 = faturamentoOutros4;
	}
	public Double getFaturamentoVendaDeVeiculos1() {
		return faturamentoVendaDeVeiculos1;
	}
	public void setFaturamentoVendaDeVeiculos1(Double faturamentoVendaDeVeiculos1) {
		this.faturamentoVendaDeVeiculos1 = faturamentoVendaDeVeiculos1;
	}
	public Double getFaturamentoVendaDeVeiculos2() {
		return faturamentoVendaDeVeiculos2;
	}
	public void setFaturamentoVendaDeVeiculos2(Double faturamentoVendaDeVeiculos2) {
		this.faturamentoVendaDeVeiculos2 = faturamentoVendaDeVeiculos2;
	}
	public Double getFaturamentoVendaDeVeiculos3() {
		return faturamentoVendaDeVeiculos3;
	}
	public void setFaturamentoVendaDeVeiculos3(Double faturamentoVendaDeVeiculos3) {
		this.faturamentoVendaDeVeiculos3 = faturamentoVendaDeVeiculos3;
	}
	public Double getFaturamentoVendaDeVeiculos4() {
		return faturamentoVendaDeVeiculos4;
	}
	public void setFaturamentoVendaDeVeiculos4(Double faturamentoVendaDeVeiculos4) {
		this.faturamentoVendaDeVeiculos4 = faturamentoVendaDeVeiculos4;
	}
	public BigDecimal getFrotaUnidadesTotal1() {
		return frotaUnidadesTotal1;
	}
	public void setFrotaUnidadesTotal1(BigDecimal frotaUnidadesTotal1) {
		this.frotaUnidadesTotal1 = frotaUnidadesTotal1;
	}
	public BigDecimal getFrotaUnidadesTotal2() {
		return frotaUnidadesTotal2;
	}
	public void setFrotaUnidadesTotal2(BigDecimal frotaUnidadesTotal2) {
		this.frotaUnidadesTotal2 = frotaUnidadesTotal2;
	}
	public BigDecimal getFrotaUnidadesTotal3() {
		return frotaUnidadesTotal3;
	}
	public void setFrotaUnidadesTotal3(BigDecimal frotaUnidadesTotal3) {
		this.frotaUnidadesTotal3 = frotaUnidadesTotal3;
	}
	public BigDecimal getFrotaUnidadesTotal4() {
		return frotaUnidadesTotal4;
	}
	public void setFrotaUnidadesTotal4(BigDecimal frotaUnidadesTotal4) {
		this.frotaUnidadesTotal4 = frotaUnidadesTotal4;
	}
	public BigDecimal getFrotaUnidadesVendaVeiculos1() {
		return frotaUnidadesVendaVeiculos1;
	}
	public void setFrotaUnidadesVendaVeiculos1(
			BigDecimal frotaUnidadesVendaVeiculos1) {
		this.frotaUnidadesVendaVeiculos1 = frotaUnidadesVendaVeiculos1;
	}
	public BigDecimal getFrotaUnidadesVendaVeiculos2() {
		return frotaUnidadesVendaVeiculos2;
	}
	public void setFrotaUnidadesVendaVeiculos2(
			BigDecimal frotaUnidadesVendaVeiculos2) {
		this.frotaUnidadesVendaVeiculos2 = frotaUnidadesVendaVeiculos2;
	}
	public BigDecimal getFrotaUnidadesVendaVeiculos3() {
		return frotaUnidadesVendaVeiculos3;
	}
	public void setFrotaUnidadesVendaVeiculos3(
			BigDecimal frotaUnidadesVendaVeiculos3) {
		this.frotaUnidadesVendaVeiculos3 = frotaUnidadesVendaVeiculos3;
	}
	public BigDecimal getFrotaUnidadesVendaVeiculos4() {
		return frotaUnidadesVendaVeiculos4;
	}
	public void setFrotaUnidadesVendaVeiculos4(
			BigDecimal frotaUnidadesVendaVeiculos4) {
		this.frotaUnidadesVendaVeiculos4 = frotaUnidadesVendaVeiculos4;
	}
	public Double getReajustesPassagensMunicipal1() {
		return reajustesPassagensMunicipal1;
	}
	public void setReajustesPassagensMunicipal1(Double reajustesPassagensMunicipal1) {
		this.reajustesPassagensMunicipal1 = reajustesPassagensMunicipal1;
	}
	public Double getReajustesPassagensMunicipal2() {
		return reajustesPassagensMunicipal2;
	}
	public void setReajustesPassagensMunicipal2(Double reajustesPassagensMunicipal2) {
		this.reajustesPassagensMunicipal2 = reajustesPassagensMunicipal2;
	}
	public Double getReajustesPassagensMunicipal3() {
		return reajustesPassagensMunicipal3;
	}
	public void setReajustesPassagensMunicipal3(Double reajustesPassagensMunicipal3) {
		this.reajustesPassagensMunicipal3 = reajustesPassagensMunicipal3;
	}
	public Double getReajustesPassagensMunicipal4() {
		return reajustesPassagensMunicipal4;
	}
	public void setReajustesPassagensMunicipal4(Double reajustesPassagensMunicipal4) {
		this.reajustesPassagensMunicipal4 = reajustesPassagensMunicipal4;
	}
	public Double getReajustesPassagensIntermunicipal1() {
		return reajustesPassagensIntermunicipal1;
	}
	public void setReajustesPassagensIntermunicipal1(
			Double reajustesPassagensIntermunicipal1) {
		this.reajustesPassagensIntermunicipal1 = reajustesPassagensIntermunicipal1;
	}
	public Double getReajustesPassagensIntermunicipal2() {
		return reajustesPassagensIntermunicipal2;
	}
	public void setReajustesPassagensIntermunicipal2(
			Double reajustesPassagensIntermunicipal2) {
		this.reajustesPassagensIntermunicipal2 = reajustesPassagensIntermunicipal2;
	}
	public Double getReajustesPassagensIntermunicipal3() {
		return reajustesPassagensIntermunicipal3;
	}
	public void setReajustesPassagensIntermunicipal3(
			Double reajustesPassagensIntermunicipal3) {
		this.reajustesPassagensIntermunicipal3 = reajustesPassagensIntermunicipal3;
	}
	public Double getReajustesPassagensIntermunicipal4() {
		return reajustesPassagensIntermunicipal4;
	}
	public void setReajustesPassagensIntermunicipal4(
			Double reajustesPassagensIntermunicipal4) {
		this.reajustesPassagensIntermunicipal4 = reajustesPassagensIntermunicipal4;
	}
	public Double getReajustesPassagensInterestadual1() {
		return reajustesPassagensInterestadual1;
	}
	public void setReajustesPassagensInterestadual1(
			Double reajustesPassagensInterestadual1) {
		this.reajustesPassagensInterestadual1 = reajustesPassagensInterestadual1;
	}
	public Double getReajustesPassagensInterestadual2() {
		return reajustesPassagensInterestadual2;
	}
	public void setReajustesPassagensInterestadual2(
			Double reajustesPassagensInterestadual2) {
		this.reajustesPassagensInterestadual2 = reajustesPassagensInterestadual2;
	}
	public Double getReajustesPassagensInterestadual3() {
		return reajustesPassagensInterestadual3;
	}
	public void setReajustesPassagensInterestadual3(
			Double reajustesPassagensInterestadual3) {
		this.reajustesPassagensInterestadual3 = reajustesPassagensInterestadual3;
	}
	public Double getReajustesPassagensInterestadual4() {
		return reajustesPassagensInterestadual4;
	}
	public void setReajustesPassagensInterestadual4(
			Double reajustesPassagensInterestadual4) {
		this.reajustesPassagensInterestadual4 = reajustesPassagensInterestadual4;
	}
	public Double getReajustesPassagensInternacional1() {
		return reajustesPassagensInternacional1;
	}
	public void setReajustesPassagensInternacional1(
			Double reajustesPassagensInternacional1) {
		this.reajustesPassagensInternacional1 = reajustesPassagensInternacional1;
	}
	public Double getReajustesPassagensInternacional2() {
		return reajustesPassagensInternacional2;
	}
	public void setReajustesPassagensInternacional2(
			Double reajustesPassagensInternacional2) {
		this.reajustesPassagensInternacional2 = reajustesPassagensInternacional2;
	}
	public Double getReajustesPassagensInternacional3() {
		return reajustesPassagensInternacional3;
	}
	public void setReajustesPassagensInternacional3(
			Double reajustesPassagensInternacional3) {
		this.reajustesPassagensInternacional3 = reajustesPassagensInternacional3;
	}
	public Double getReajustesPassagensInternacional4() {
		return reajustesPassagensInternacional4;
	}
	public void setReajustesPassagensInternacional4(
			Double reajustesPassagensInternacional4) {
		this.reajustesPassagensInternacional4 = reajustesPassagensInternacional4;
	}
	public Double getReajustesPassagensFretamento1() {
		return reajustesPassagensFretamento1;
	}
	public void setReajustesPassagensFretamento1(
			Double reajustesPassagensFretamento1) {
		this.reajustesPassagensFretamento1 = reajustesPassagensFretamento1;
	}
	public Double getReajustesPassagensFretamento2() {
		return reajustesPassagensFretamento2;
	}
	public void setReajustesPassagensFretamento2(
			Double reajustesPassagensFretamento2) {
		this.reajustesPassagensFretamento2 = reajustesPassagensFretamento2;
	}
	public Double getReajustesPassagensFretamento3() {
		return reajustesPassagensFretamento3;
	}
	public void setReajustesPassagensFretamento3(
			Double reajustesPassagensFretamento3) {
		this.reajustesPassagensFretamento3 = reajustesPassagensFretamento3;
	}
	public Double getReajustesPassagensFretamento4() {
		return reajustesPassagensFretamento4;
	}
	public void setReajustesPassagensFretamento4(
			Double reajustesPassagensFretamento4) {
		this.reajustesPassagensFretamento4 = reajustesPassagensFretamento4;
	}
	
}
