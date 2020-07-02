package br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.converter.BaseEntity;
import br.com.bradesco.web.ricc.model.segmento.QuestionarioSegmentoVO;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class QuestionarioProjetoVO extends QuestionarioSegmentoVO implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1742417813805275329L;

	// Dados do Projeto
	private String nomeProjeto = "";
	private String descProjeto = "";
	// ----------------

	// Estrutura Societária
	private EstruturaSocietariaVO acionista = new EstruturaSocietariaVO();
	private List<EstruturaSocietariaVO> listEstruturaSocietariaSelecionado = new ArrayList<EstruturaSocietariaVO>();
	private List<EstruturaSocietariaVO> listEstruturaSocietaria = new ArrayList<EstruturaSocietariaVO>();
	private List<EstruturaSocietariaVO> copiaListaEstruturaSocietaria = new ArrayList<EstruturaSocietariaVO>();
	// --------------------

	// Quadro de Usos e Fontes
	private UsosFontesVO usosFontes = new UsosFontesVO();
	private List<UsosFontesVO> listUsosFontesSelecionado = new ArrayList<UsosFontesVO>();
	private List<UsosFontesVO> listUsosFontes = new ArrayList<UsosFontesVO>();
	private List<UsosFontesVO> listaFontes = new ArrayList<UsosFontesVO>();
	private List<UsosFontesVO> copiaListalistUsosFontes = new ArrayList<UsosFontesVO>();
	private List<UsosFontesVO> copiaListalistFontes = new ArrayList<UsosFontesVO>();
	// -----------------------

	// Status de Equacionamento do founding
	private String descFonteFinanStatus = "";
	// ------------------------------------

	// Construtores/Fornecedores
	private ConstrutoresFornecedoresVO construtoresFornecedores = new ConstrutoresFornecedoresVO();
	private List<ConstrutoresFornecedoresVO> listConstrutoresFornecedoresSelecionado = new ArrayList<ConstrutoresFornecedoresVO>();
	private List<ConstrutoresFornecedoresVO> listConstrutoresFornecedores = new ArrayList<ConstrutoresFornecedoresVO>();
	private List<ConstrutoresFornecedoresVO> listFornecedores = new ArrayList<ConstrutoresFornecedoresVO>();
	private List<ConstrutoresFornecedoresVO> copiaListConstrutoresFornecedores = new ArrayList<ConstrutoresFornecedoresVO>();
	private List<ConstrutoresFornecedoresVO> copiaListFornecedores = new ArrayList<ConstrutoresFornecedoresVO>();
	// -------------------------

	// Status de licenciamento socioambiental
	private String descComentariosStatusLicenciamento = "";
	// --------------------------------------
	
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	private List<UsosFontesVO> carregaListaUsosFontes() {
		List<UsosFontesVO> lista = new ArrayList<UsosFontesVO>(10);
		for (int i = 0; i < 10; i++) {
			lista.add(new UsosFontesVO());
		}
		return lista;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getDescProjeto() {
		return descProjeto;
	}

	public void setDescProjeto(String descProjeto) {
		this.descProjeto = descProjeto;
	}

	public EstruturaSocietariaVO getAcionista() {
		return acionista;
	}

	public void setAcionista(EstruturaSocietariaVO acionista) {
		this.acionista = acionista;
	}

	public UsosFontesVO getUsosFontes() {
		return usosFontes;
	}

	public void setUsosFontes(UsosFontesVO usosFontes) {
		this.usosFontes = usosFontes;
	}

	public List<UsosFontesVO> getListUsosFontes() {
		return listUsosFontes;
	}

	public void setListUsosFontes(List<UsosFontesVO> listUsosFontes) {
		this.listUsosFontes = listUsosFontes;
	}

	public String getDescFonteFinanStatus() {
		return descFonteFinanStatus;
	}

	public void setDescFonteFinanStatus(String descFonteFinanStatus) {
		this.descFonteFinanStatus = descFonteFinanStatus;
	}

	public ConstrutoresFornecedoresVO getConstrutoresFornecedores() {
		return construtoresFornecedores;
	}

	public void setConstrutoresFornecedores(
			ConstrutoresFornecedoresVO construtoresFornecedores) {
		this.construtoresFornecedores = construtoresFornecedores;
	}

	public String getDescComentariosStatusLicenciamento() {
		return descComentariosStatusLicenciamento;
	}

	public void setDescComentariosStatusLicenciamento(
			String descComentariosStatusLicenciamento) {
		this.descComentariosStatusLicenciamento = descComentariosStatusLicenciamento;
	}

	public List<EstruturaSocietariaVO> getListEstruturaSocietariaSelecionado() {
		return listEstruturaSocietariaSelecionado;
	}

	public void setListEstruturaSocietariaSelecionado(
			List<EstruturaSocietariaVO> listEstruturaSocietariaSelecionado) {
		this.listEstruturaSocietariaSelecionado = listEstruturaSocietariaSelecionado;
	}

	public List<EstruturaSocietariaVO> getListEstruturaSocietaria() {
		return listEstruturaSocietaria;
	}

	public void setListEstruturaSocietaria(
			List<EstruturaSocietariaVO> listEstruturaSocietaria) {
		this.listEstruturaSocietaria = listEstruturaSocietaria;
	}
	
	public List<EstruturaSocietariaVO> getCopiaListaEstruturaSocietaria() {
		return copiaListaEstruturaSocietaria;
	}

	public void setCopiaListaEstruturaSocietaria(
			List<EstruturaSocietariaVO> copiaListaEstruturaSocietaria) {
		this.copiaListaEstruturaSocietaria = copiaListaEstruturaSocietaria;
	}

	public List<UsosFontesVO> getListUsosFontesSelecionado() {
		return listUsosFontesSelecionado;
	}

	public void setListUsosFontesSelecionado(
			List<UsosFontesVO> listUsosFontesSelecionado) {
		this.listUsosFontesSelecionado = listUsosFontesSelecionado;
	}

	public List<ConstrutoresFornecedoresVO> getListConstrutoresFornecedoresSelecionado() {
		return listConstrutoresFornecedoresSelecionado;
	}

	public void setListConstrutoresFornecedoresSelecionado(
			List<ConstrutoresFornecedoresVO> listConstrutoresFornecedoresSelecionado) {
		this.listConstrutoresFornecedoresSelecionado = listConstrutoresFornecedoresSelecionado;
	}

	public List<ConstrutoresFornecedoresVO> getListConstrutoresFornecedores() {
		return listConstrutoresFornecedores;
	}

	public void setListConstrutoresFornecedores(
			List<ConstrutoresFornecedoresVO> listConstrutoresFornecedores) {
		this.listConstrutoresFornecedores = listConstrutoresFornecedores;
	}

	@Override
	public Long getId() {
		return SiteUtil.getInstance().nullToLong(getCodGrupo());
	}
	
	public List<EstruturaSocietariaVO> carregarEstruturaSocietaria() {
		
		List<EstruturaSocietariaVO> lista = new ArrayList<EstruturaSocietariaVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new EstruturaSocietariaVO());
		}
		return lista;
	}
	
	public List<ConstrutoresFornecedoresVO> carregarConstrutoresFornecedores() {
		
		List<ConstrutoresFornecedoresVO> lista = new ArrayList<ConstrutoresFornecedoresVO>(5);
		for (int i = 0; i < 5; i++) {
			lista.add(new ConstrutoresFornecedoresVO());
		}
		return lista;
	}

	public List<UsosFontesVO> getCopiaListalistUsosFontes() {
		return copiaListalistUsosFontes;
	}

	public void setCopiaListalistUsosFontes(
			List<UsosFontesVO> copiaListalistUsosFontes) {
		this.copiaListalistUsosFontes = copiaListalistUsosFontes;
	}

	public List<UsosFontesVO> getListaFontes() {
		return listaFontes;
	}

	public void setListaFontes(List<UsosFontesVO> listaFontes) {
		this.listaFontes = listaFontes;
	}

	public List<UsosFontesVO> getCopiaListalistFontes() {
		return copiaListalistFontes;
	}

	public void setCopiaListalistFontes(List<UsosFontesVO> copiaListalistFontes) {
		this.copiaListalistFontes = copiaListalistFontes;
	}

	public List<ConstrutoresFornecedoresVO> getCopiaListConstrutoresFornecedores() {
		return copiaListConstrutoresFornecedores;
	}

	public void setCopiaListConstrutoresFornecedores(
			List<ConstrutoresFornecedoresVO> copiaListConstrutoresFornecedores) {
		this.copiaListConstrutoresFornecedores = copiaListConstrutoresFornecedores;
	}

	public List<ConstrutoresFornecedoresVO> getListFornecedores() {
		return listFornecedores;
	}

	public void setListFornecedores(
			List<ConstrutoresFornecedoresVO> listFornecedores) {
		this.listFornecedores = listFornecedores;
	}

	public List<ConstrutoresFornecedoresVO> getCopiaListFornecedores() {
		return copiaListFornecedores;
	}

	public void setCopiaListFornecedores(
			List<ConstrutoresFornecedoresVO> copiaListFornecedores) {
		this.copiaListFornecedores = copiaListFornecedores;
	}	
	
}