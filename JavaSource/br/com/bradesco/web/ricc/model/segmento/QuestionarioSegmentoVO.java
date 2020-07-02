package br.com.bradesco.web.ricc.model.segmento;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;

public abstract class QuestionarioSegmentoVO {

	private String nomeRelatorio = "";
	private String versaoOrigem = "";

	private String administracao = "";
	private String planoSucessao = "";

	private String codRelatorio = "";
	private String codSegmentoRelatorio = "";
	private String informarAtraso = "";

	private String codGrupo = "";
	private String nomeGrupo = "";

	private String flagSetorTransporte = "";
	private String flagSetorImobiliario = "";
	private String flagSetorAgricola = "";
	private String flagSetorProjeto = "";

	private String codSituacaoRelatorio = "";

	private String dataInclusao = "";
	private String horaInclusao = "";
	private String usuarioInclusao = "";

	private TipoQuestionarioVO setor;
	private List<TipoQuestionarioVO> setorSelecionado = new ArrayList<TipoQuestionarioVO>();
	private List<TipoQuestionarioVO> listaSetor = new ArrayList<TipoQuestionarioVO>();

	/**
	 * @description
	 * @name getGrupoFormatado
	 * @see QuestionarioAgronegocioVO
	 * @return
	 * @return String
	 */
	public String getGrupoFormatado() {
		return this.codGrupo + " - " + this.nomeGrupo;
	}
	
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public String getCodRelatorio() {
		return codRelatorio;
	}

	public void setCodRelatorio(String codRelatorio) {
		this.codRelatorio = codRelatorio;
	}

	public String getAdministracao() {
		return administracao;
	}

	public void setAdministracao(String administracao) {
		this.administracao = administracao;
	}

	public String getPlanoSucessao() {
		return planoSucessao;
	}

	public void setPlanoSucessao(String planoSucessao) {
		this.planoSucessao = planoSucessao;
	}

	public String getCodSegmentoRelatorio() {
		return codSegmentoRelatorio;
	}

	public void setCodSegmentoRelatorio(String codSegmentoRelatorio) {
		this.codSegmentoRelatorio = codSegmentoRelatorio;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getFlagSetorTransporte() {
		return flagSetorTransporte;
	}

	public void setFlagSetorTransporte(String flagSetorTransporte) {
		this.flagSetorTransporte = flagSetorTransporte;
	}

	public String getFlagSetorImobiliario() {
		return flagSetorImobiliario;
	}

	public void setFlagSetorImobiliario(String flagSetorImobiliario) {
		this.flagSetorImobiliario = flagSetorImobiliario;
	}

	public String getFlagSetorAgricola() {
		return flagSetorAgricola;
	}

	public void setFlagSetorAgricola(String flagSetorAgricola) {
		this.flagSetorAgricola = flagSetorAgricola;
	}

	public String getFlagSetorProjeto() {
		return flagSetorProjeto;
	}

	public void setFlagSetorProjeto(String flagSetorProjeto) {
		this.flagSetorProjeto = flagSetorProjeto;
	}

	public String getCodSituacaoRelatorio() {
		return codSituacaoRelatorio;
	}

	public void setCodSituacaoRelatorio(String codSituacaoRelatorio) {
		this.codSituacaoRelatorio = codSituacaoRelatorio;
	}

	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getHoraInclusao() {
		return horaInclusao;
	}

	public void setHoraInclusao(String horaInclusao) {
		this.horaInclusao = horaInclusao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public String getVersaoOrigem() {
		return versaoOrigem;
	}

	public void setVersaoOrigem(String versaoOrigem) {
		this.versaoOrigem = versaoOrigem;
	}

	public String getInformarAtraso() {
		return informarAtraso;
	}

	public void setInformarAtraso(String informarAtraso) {
		this.informarAtraso = informarAtraso;
	}

	public TipoQuestionarioVO getSetor() {
		return setor;
	}

	public void setSetor(TipoQuestionarioVO setor) {
		this.setor = setor;
	}

	public List<TipoQuestionarioVO> getSetorSelecionado() {
		return setorSelecionado;
	}

	public void setSetorSelecionado(List<TipoQuestionarioVO> setorSelecionado) {
		this.setorSelecionado = setorSelecionado;
	}

	public List<TipoQuestionarioVO> getListaSetor() {
		return listaSetor;
	}

	public void setListaSetor(List<TipoQuestionarioVO> listaSetor) {
		this.listaSetor = listaSetor;
	}
}
