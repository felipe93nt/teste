package br.com.bradesco.web.ricc.service.business.questionarioagronegocio.impl;

import java.math.BigDecimal;

import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPlantadaFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPlantadaGraosVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class GraoFibraAux {

	private SiteUtil siteUtil = SiteUtil.getInstance();

	private int codTpoRamo = 0;

	private int nprodRelat = 0;

	private String anoSafra = null;

	private long areaPropr = 0L;

	private String areaProprNull = null;

	private long areaArrend = 0L;

	private String areaArrendNull = null;

	private long produtivKg = 0L;

	private String produtivKgNull = null;

	private long prodGrao = 0L;

	private String prodGraoNull = null;

	private long prodSemnt = 0L;

	private String prodSemntNull = null;

	private int prodSemntKg = 0;

	private String prodSemntKgNull = null;

	private BigDecimal vmedGrao = null;

	private String vmedGraoNull = null;

	private BigDecimal vmedSemnt = null;

	private String vmedSemntNull = null;

	private int vmedSemntKg = 0;

	private String vmedSemntKgNull = null;

	private BigDecimal pvolGraoFix = null;

	private String pvolGraoFixNull = null;

	private BigDecimal vmedGraoFix = null;

	private String vmedGraoFixNull = null;

	private BigDecimal vcustoProd = null;

	private String vcustoProdNull = null;
	private BigDecimal plumaAHect = null;

	private String plumaAHectNull = null;
	private BigDecimal carocoAHect = null;

	private String carocoAHectNull = null;

	private BigDecimal fibrilhaAHect = null;

	private String fibrilhaAHectNull = null;

	private long plumaArroba = 0L;

	private String plumaArrobaNull = null;

	private long carocoArroba = 0L;

	private String carocoArrobaNull = null;

	private long fibrilhaArroba = 0L;

	private String fibrilhaArrobaNull = null;

	private BigDecimal vmedPluma = null;

	private String vmedPlumaNull = null;

	private BigDecimal vmedCaroco = null;

	private String vmedCarocoNull = null;

	private BigDecimal vmedFibrilha = null;

	private String vmedFibrilhaNull = null;

	private BigDecimal pvolPlumaFix = null;

	private String pvolPlumaFixNull = null;

	private BigDecimal vmedPlumaFix = null;

	private String vmedPlumaFixNull = null;

	public int getNprodRelat() {
		return nprodRelat;
	}

	public void setNprodRelat(int nprodRelat) {
		this.nprodRelat = nprodRelat;
	}

	public String getAnoSafra() {
		return anoSafra;
	}

	public void setAnoSafra(String anoSafra) {
		this.anoSafra = anoSafra;
	}

	public long getAreaPropr() {
		return areaPropr;
	}

	public void setAreaPropr(long areaPropr) {
		this.areaPropr = areaPropr;
	}

	public String getAreaProprNull() {
		return areaProprNull;
	}

	public void setAreaProprNull(String areaProprNull) {
		this.areaProprNull = areaProprNull;
	}

	public long getAreaArrend() {
		return areaArrend;
	}

	public void setAreaArrend(long areaArrend) {
		this.areaArrend = areaArrend;
	}

	public String getAreaArrendNull() {
		return areaArrendNull;
	}

	public void setAreaArrendNull(String areaArrendNull) {
		this.areaArrendNull = areaArrendNull;
	}

	public long getProdutivKg() {
		return produtivKg;
	}

	public void setProdutivKg(long produtivKg) {
		this.produtivKg = produtivKg;
	}

	public String getProdutivKgNull() {
		return produtivKgNull;
	}

	public void setProdutivKgNull(String produtivKgNull) {
		this.produtivKgNull = produtivKgNull;
	}

	public long getProdGrao() {
		return prodGrao;
	}

	public void setProdGrao(long prodGrao) {
		this.prodGrao = prodGrao;
	}

	public String getProdGraoNull() {
		return prodGraoNull;
	}

	public void setProdGraoNull(String prodGraoNull) {
		this.prodGraoNull = prodGraoNull;
	}

	public long getProdSemnt() {
		return prodSemnt;
	}

	public void setProdSemnt(long prodSemnt) {
		this.prodSemnt = prodSemnt;
	}

	public String getProdSemntNull() {
		return prodSemntNull;
	}

	public void setProdSemntNull(String prodSemntNull) {
		this.prodSemntNull = prodSemntNull;
	}

	public int getProdSemntKg() {
		return prodSemntKg;
	}

	public void setProdSemntKg(int prodSemntKg) {
		this.prodSemntKg = prodSemntKg;
	}

	public String getProdSemntKgNull() {
		return prodSemntKgNull;
	}

	public void setProdSemntKgNull(String prodSemntKgNull) {
		this.prodSemntKgNull = prodSemntKgNull;
	}

	public BigDecimal getVmedGrao() {
		return vmedGrao;
	}

	public void setVmedGrao(BigDecimal vmedGrao) {
		this.vmedGrao = vmedGrao;
	}

	public String getVmedGraoNull() {
		return vmedGraoNull;
	}

	public void setVmedGraoNull(String vmedGraoNull) {
		this.vmedGraoNull = vmedGraoNull;
	}

	public BigDecimal getVmedSemnt() {
		return vmedSemnt;
	}

	public void setVmedSemnt(BigDecimal vmedSemnt) {
		this.vmedSemnt = vmedSemnt;
	}

	public String getVmedSemntNull() {
		return vmedSemntNull;
	}

	public void setVmedSemntNull(String vmedSemntNull) {
		this.vmedSemntNull = vmedSemntNull;
	}

	public int getVmedSemntKg() {
		return vmedSemntKg;
	}

	public void setVmedSemntKg(int vmedSemntKg) {
		this.vmedSemntKg = vmedSemntKg;
	}

	public String getVmedSemntKgNull() {
		return vmedSemntKgNull;
	}

	public void setVmedSemntKgNull(String vmedSemntKgNull) {
		this.vmedSemntKgNull = vmedSemntKgNull;
	}

	public BigDecimal getPvolGraoFix() {
		return pvolGraoFix;
	}

	public void setPvolGraoFix(BigDecimal pvolGraoFix) {
		this.pvolGraoFix = pvolGraoFix;
	}

	public String getPvolGraoFixNull() {
		return pvolGraoFixNull;
	}

	public void setPvolGraoFixNull(String pvolGraoFixNull) {
		this.pvolGraoFixNull = pvolGraoFixNull;
	}

	public BigDecimal getVmedGraoFix() {
		return vmedGraoFix;
	}

	public void setVmedGraoFix(BigDecimal vmedGraoFix) {
		this.vmedGraoFix = vmedGraoFix;
	}

	public String getVmedGraoFixNull() {
		return vmedGraoFixNull;
	}

	public void setVmedGraoFixNull(String vmedGraoFixNull) {
		this.vmedGraoFixNull = vmedGraoFixNull;
	}

	public BigDecimal getVcustoProd() {
		return vcustoProd;
	}

	public void setVcustoProd(BigDecimal vcustoProd) {
		this.vcustoProd = vcustoProd;
	}

	public String getVcustoProdNull() {
		return vcustoProdNull;
	}

	public void setVcustoProdNull(String vcustoProdNull) {
		this.vcustoProdNull = vcustoProdNull;
	}

	public BigDecimal getPlumaAHect() {
		return plumaAHect;
	}

	public void setPlumaAHect(BigDecimal plumaAHect) {
		this.plumaAHect = plumaAHect;
	}

	public String getPlumaAHectNull() {
		return plumaAHectNull;
	}

	public void setPlumaAHectNull(String plumaAHectNull) {
		this.plumaAHectNull = plumaAHectNull;
	}

	public BigDecimal getCarocoAHect() {
		return carocoAHect;
	}

	public void setCarocoAHect(BigDecimal carocoAHect) {
		this.carocoAHect = carocoAHect;
	}

	public String getCarocoAHectNull() {
		return carocoAHectNull;
	}

	public void setCarocoAHectNull(String carocoAHectNull) {
		this.carocoAHectNull = carocoAHectNull;
	}

	public BigDecimal getFibrilhaAHect() {
		return fibrilhaAHect;
	}

	public void setFibrilhaAHect(BigDecimal fibrilhaAHect) {
		this.fibrilhaAHect = fibrilhaAHect;
	}

	public String getFibrilhaAHectNull() {
		return fibrilhaAHectNull;
	}

	public void setFibrilhaAHectNull(String fibrilhaAHectNull) {
		this.fibrilhaAHectNull = fibrilhaAHectNull;
	}

	public long getPlumaArroba() {
		return plumaArroba;
	}

	public void setPlumaArroba(long plumaArroba) {
		this.plumaArroba = plumaArroba;
	}

	public String getPlumaArrobaNull() {
		return plumaArrobaNull;
	}

	public void setPlumaArrobaNull(String plumaArrobaNull) {
		this.plumaArrobaNull = plumaArrobaNull;
	}

	public long getCarocoArroba() {
		return carocoArroba;
	}

	public void setCarocoArroba(long carocoArroba) {
		this.carocoArroba = carocoArroba;
	}

	public String getCarocoArrobaNull() {
		return carocoArrobaNull;
	}

	public void setCarocoArrobaNull(String carocoArrobaNull) {
		this.carocoArrobaNull = carocoArrobaNull;
	}

	public long getFibrilhaArroba() {
		return fibrilhaArroba;
	}

	public void setFibrilhaArroba(long fibrilhaArroba) {
		this.fibrilhaArroba = fibrilhaArroba;
	}

	public String getFibrilhaArrobaNull() {
		return fibrilhaArrobaNull;
	}

	public void setFibrilhaArrobaNull(String fibrilhaArrobaNull) {
		this.fibrilhaArrobaNull = fibrilhaArrobaNull;
	}

	public BigDecimal getVmedPluma() {
		return vmedPluma;
	}

	public void setVmedPluma(BigDecimal vmedPluma) {
		this.vmedPluma = vmedPluma;
	}

	public String getVmedPlumaNull() {
		return vmedPlumaNull;
	}

	public void setVmedPlumaNull(String vmedPlumaNull) {
		this.vmedPlumaNull = vmedPlumaNull;
	}

	public BigDecimal getVmedCaroco() {
		return vmedCaroco;
	}

	public void setVmedCaroco(BigDecimal vmedCaroco) {
		this.vmedCaroco = vmedCaroco;
	}

	public String getVmedCarocoNull() {
		return vmedCarocoNull;
	}

	public void setVmedCarocoNull(String vmedCarocoNull) {
		this.vmedCarocoNull = vmedCarocoNull;
	}

	public BigDecimal getVmedFibrilha() {
		return vmedFibrilha;
	}

	public void setVmedFibrilha(BigDecimal vmedFibrilha) {
		this.vmedFibrilha = vmedFibrilha;
	}

	public String getVmedFibrilhaNull() {
		return vmedFibrilhaNull;
	}

	public void setVmedFibrilhaNull(String vmedFibrilhaNull) {
		this.vmedFibrilhaNull = vmedFibrilhaNull;
	}

	public BigDecimal getPvolPlumaFix() {
		return pvolPlumaFix;
	}

	public void setPvolPlumaFix(BigDecimal pvolPlumaFix) {
		this.pvolPlumaFix = pvolPlumaFix;
	}

	public String getPvolPlumaFixNull() {
		return pvolPlumaFixNull;
	}

	public void setPvolPlumaFixNull(String pvolPlumaFixNull) {
		this.pvolPlumaFixNull = pvolPlumaFixNull;
	}

	public BigDecimal getVmedPlumaFix() {
		return vmedPlumaFix;
	}

	public void setVmedPlumaFix(BigDecimal vmedPlumaFix) {
		this.vmedPlumaFix = vmedPlumaFix;
	}

	public String getVmedPlumaFixNull() {
		return vmedPlumaFixNull;
	}

	public void setVmedPlumaFixNull(String vmedPlumaFixNull) {
		this.vmedPlumaFixNull = vmedPlumaFixNull;
	}

	public int getCodTpoRamo() {
		return codTpoRamo;
	}

	public void setCodTpoRamo(int codTpoRamo) {
		this.codTpoRamo = codTpoRamo;
	}

	public GraoFibraAux mapearEntradaFibra(AreaPlantadaFibrasVO areaPlantada) {

		GraoFibraAux fibra = new GraoFibraAux();

		if (areaPlantada != null) {

			fibra.setNprodRelat(nprodRelat);
			fibra.setCodTpoRamo(areaPlantada.getCodTipoRamo());
			fibra.setAnoSafra(siteUtil.tratarParametroString(areaPlantada.getAno()));
			fibra.setAreaArrend(parseStringToLong(areaPlantada.getAreaArrendada()));
			fibra.setAreaArrendNull(siteUtil.checkNullEntrada(areaPlantada.getAreaArrendada()));
			fibra.setAreaPropr(parseStringToLong(areaPlantada.getAreaPropria()));
			fibra.setAreaProprNull(siteUtil.checkNullEntrada(areaPlantada.getAreaPropria()));
			// areaPlantada.getAreaTotal();
			fibra.setCarocoAHect(siteUtil.valueToMainframeBigDecimal(areaPlantada.getCarocoHectare()));
			fibra.setCarocoAHectNull(siteUtil.checkNullEntrada(areaPlantada.getCarocoHectare()));
			fibra.setCarocoArroba(parseStringToLong(areaPlantada.getCarocoProducao()));
			fibra.setCarocoArrobaNull(siteUtil.checkNullEntrada(areaPlantada.getCarocoProducao()));
			fibra.setFibrilhaAHect(siteUtil.valueToMainframeBigDecimal(areaPlantada.getFibrilhaHectare()));
			fibra.setFibrilhaAHectNull(siteUtil.checkNullEntrada(areaPlantada.getFibrilhaHectare()));
			fibra.setFibrilhaArroba(parseStringToLong(areaPlantada.getFibrilhaProducao()));
			fibra.setFibrilhaArrobaNull(siteUtil.checkNullEntrada(areaPlantada.getFibrilhaProducao()));
			fibra.setVmedCaroco(siteUtil.valueToMainframeBigDecimal(areaPlantada.getMediaCarocoRP()));
			fibra.setVmedCarocoNull(siteUtil.checkNullEntrada(areaPlantada.getMediaCarocoRP()));
			fibra.setVmedFibrilha(siteUtil.valueToMainframeBigDecimal(areaPlantada.getMediaFibrilhaRP()));
			fibra.setVmedFibrilhaNull(siteUtil.checkNullEntrada(areaPlantada.getMediaFibrilhaRP()));
			fibra.setVmedPluma(siteUtil.valueToMainframeBigDecimal(areaPlantada.getMediaPlumaRP()));
			fibra.setVmedPlumaNull(siteUtil.checkNullEntrada(areaPlantada.getMediaPlumaRP()));
			fibra.setPlumaAHect(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPlumaHectare()));
			fibra.setPlumaAHectNull(siteUtil.checkNullEntrada(areaPlantada.getPlumaHectare()));
			fibra.setPlumaArroba(parseStringToLong(areaPlantada.getPlumaProducao()));
			fibra.setPlumaArrobaNull(siteUtil.checkNullEntrada(areaPlantada.getPlumaProducao()));
			fibra.setPvolPlumaFix(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPorcentagemVolumePluma()));
			fibra.setPvolPlumaFixNull(siteUtil.checkNullEntrada(areaPlantada.getPorcentagemVolumePluma()));
			fibra.setVmedPlumaFix(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPrecoFixadoMomento()));
			fibra.setVmedPlumaFixNull(siteUtil.checkNullEntrada(areaPlantada.getPrecoFixadoMomento()));
			fibra.setVcustoProd(siteUtil.valueToMainframeBigDecimal(areaPlantada.getCustoProducaoRP()));
			fibra.setVcustoProdNull(siteUtil.checkNullEntrada(areaPlantada.getCustoProducaoRP()));
			// areaPlantada.getTotalHectare();
			// areaPlantada.getTotalProducao();
		}

		return fibra;
	}

	public GraoFibraAux mapearEntradaGrao(AreaPlantadaGraosVO areaPlantada) {

		GraoFibraAux grao = new GraoFibraAux();

		if (areaPlantada != null) {
			grao.setCodTpoRamo(areaPlantada.getCodigoTipoRamo());
			grao.setAnoSafra(areaPlantada.getAno() != null ? areaPlantada.getAno() : "");
			grao.setAreaArrend(parseStringToLong(areaPlantada.getAreaArrendada()));
			grao.setAreaArrendNull(siteUtil.checkNullEntrada(areaPlantada.getAreaArrendada()));
			grao.setAreaPropr(parseStringToLong(areaPlantada.getAreaPropria()));
			grao.setAreaProprNull(siteUtil.checkNullEntrada(areaPlantada.getAreaPropria()));
			// areaPlantada.getAreaTotal();
			grao.setVcustoProd(siteUtil.valueToMainframeBigDecimal(areaPlantada.getCustoProducaoRealizado()));
			grao.setVcustoProdNull(siteUtil.checkNullEntrada(areaPlantada.getCustoProducaoRealizado()));
			grao.setPvolGraoFix(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPorcentagemVolumeGraoFixado()));
			grao.setPvolGraoFixNull(siteUtil.checkNullEntrada(areaPlantada.getPorcentagemVolumeGraoFixado()));
			grao.setVmedGrao(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPrecoMedioGrao()));
			grao.setVmedGraoNull(siteUtil.checkNullEntrada(areaPlantada.getPrecoMedioGrao()));
			grao.setVmedGraoFix(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPrecoMedioGraoFixado()));
			grao.setVmedGraoFixNull(siteUtil.checkNullEntrada(areaPlantada.getPrecoMedioGraoFixado()));
			grao.setVmedSemnt(siteUtil.valueToMainframeBigDecimal(areaPlantada.getPrecoMedioSemente()));
			grao.setVmedSemntNull(siteUtil.checkNullEntrada(areaPlantada.getPrecoMedioSemente()));
			grao.setProdGrao(parseStringToLong(areaPlantada.getProducaoGraos()));
			grao.setProdGraoNull(siteUtil.checkNullEntrada(areaPlantada.getProducaoGraos()));
			grao.setProdSemnt(parseStringToLong(areaPlantada.getProducaoSementes()));
			grao.setProdSemntNull(siteUtil.checkNullEntrada(areaPlantada.getProducaoSementes()));
			/*grao.setProdGrao(parseStringToLong(areaPlantada.getProducaoTotal()));
			grao.setProdGraoNull(siteUtil.isEmptyOrNull(areaPlantada.getProducaoTotal()));*/
			grao.setProdutivKg(parseStringToLong(areaPlantada.getProdutividade()));
			grao.setProdutivKgNull(siteUtil.checkNullEntrada(areaPlantada.getProdutividade()));
			grao.setProdSemntKg(siteUtil.tratarParametroInteger(areaPlantada.getPesoSacaSementes()));
			grao.setProdSemntKgNull(siteUtil.checkNullEntrada(areaPlantada.getPesoSacaSementes()));
			grao.setVmedSemntKg(siteUtil.tratarParametroInteger(areaPlantada.getPesoSacaMediaSemente()));
			grao.setVmedSemntKgNull(siteUtil.checkNullEntrada(areaPlantada.getPesoSacaMediaSemente()));
		}

		return grao;

	}

	public AreaPlantadaFibrasVO mapearSaidaFibra(GraoFibraAux fibra) {
		AreaPlantadaFibrasVO areaPlantada = new AreaPlantadaFibrasVO();

		if (fibra != null) {

			areaPlantada.setAno(fibra.getAnoSafra());
			areaPlantada.setAreaArrendada(fibra.getAreaArrendNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getAreaArrend()));
			areaPlantada.setAreaPropria(fibra.getAreaProprNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getAreaPropr()));
			areaPlantada.setCarocoHectare(fibra.getCarocoAHectNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getCarocoAHect()));
//			areaPlantada.setCarocoProducao(fibra.getCarocoArrobaNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getCarocoArroba()));
			areaPlantada.setFibrilhaHectare(fibra.getFibrilhaAHectNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getFibrilhaAHect()));
//			areaPlantada.setFibrilhaProducao(fibra.getFibrilhaArrobaNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getFibrilhaArroba()));
			areaPlantada.setMediaCarocoRP(fibra.getVmedCarocoNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getVmedCaroco()));
			areaPlantada.setMediaFibrilhaRP(fibra.getVmedFibrilhaNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getVmedFibrilha()));
			areaPlantada.setMediaPlumaRP(fibra.getVmedPlumaNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getVmedPluma()));
			areaPlantada.setPlumaHectare(fibra.getPlumaAHectNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getPlumaAHect()));
//			areaPlantada.setPlumaProducao(fibra.getPlumaArrobaNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getPlumaArroba()));
			areaPlantada.setPorcentagemVolumePluma(fibra.getPvolPlumaFixNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getPvolPlumaFix()));
			areaPlantada.setPrecoFixadoMomento(fibra.getVmedPlumaFixNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getVmedPlumaFix()));
			areaPlantada.setCustoProducaoRP(fibra.getVcustoProdNull().equals("S") ? "" : siteUtil.tratarParametroString(fibra.getVcustoProd()));
		}

		return areaPlantada;
	}

	public AreaPlantadaGraosVO mapearSaidaGrao(GraoFibraAux grao) {
		AreaPlantadaGraosVO areaPlantada = new AreaPlantadaGraosVO();

		if (grao != null) {

			areaPlantada.setAno(grao.getAnoSafra());
			areaPlantada.setAreaArrendada(grao.getAreaArrendNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getAreaArrend()));
			areaPlantada.setAreaPropria(grao.getAreaProprNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getAreaPropr()));
			areaPlantada.setCustoProducaoRealizado(grao.getVcustoProdNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVcustoProd()));
			areaPlantada.setPorcentagemVolumeGraoFixado(grao.getPvolGraoFixNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.pvolGraoFix));
			areaPlantada.setPrecoMedioGrao(grao.getVmedGraoNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVmedGrao()));
			areaPlantada.setPrecoMedioGraoFixado(grao.getVmedGraoFixNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVmedGraoFix()));
			areaPlantada.setPrecoMedioSemente(grao.getVmedSemntNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVmedSemnt()));
			areaPlantada.setPesoSacaMediaSemente(grao.getVmedSemntKgNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVmedSemntKg()));
			areaPlantada.setProducaoGraos(grao.getProdGraoNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdGrao()));
			areaPlantada.setProducaoSementes(grao.getProdSemntNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdSemnt()));
			areaPlantada.setPesoSacaSementes(grao.getProdSemntKgNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdSemntKg()));
			areaPlantada.setProducaoTotal(grao.getProdGraoNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdGrao()));
			areaPlantada.setProdutividade(grao.getProdutivKgNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdutivKg()));
			areaPlantada.setPesoSacaSementes(grao.getProdSemntKgNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getProdSemntKg()));
			areaPlantada.setPesoSacaMediaSemente(grao.getVmedSemntKgNull().equals("S") ? "" : siteUtil.tratarParametroString(grao.getVmedSemntKg()));
		}

		return areaPlantada;
	}

	private Long parseStringToLong(String s) {
		if (s == null || "".equals(s)) {
			return 0l;
		} else {
			return Long.valueOf(s.replace(".",""));
		}
	}
}
