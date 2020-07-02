package br.com.bradesco.web.ricc.model.cadastro;

public class CadastramentoVO implements Comparable<CadastramentoVO> {

	// Campos tabela
	private Integer codRelatorio = 0;
	private String nomeRelatorio = "";
	private String codSegmento = "";
	private String segmento = "";
	private String setor = "";
	private String data = "";
	private String hora = "";
	private String usuarioInclusao = "";
	private Integer flagSetorTransporte = 2;
	private Integer flagSetorImobiliario = 2;
	private Integer flagSetorAgricola = 2;
	private Integer flagSetorProjeto = 2;
	private Integer codSituacao = 2;
	private String descSituacao = "";

	public Integer getCodRelatorio() {
		return codRelatorio;
	}

	public void setCodRelatorio(Integer codRelatorio) {
		this.codRelatorio = codRelatorio;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public String getCodSegmento() {
		return codSegmento;
	}

	public void setCodSegmento(String codSegmento) {
		this.codSegmento = codSegmento;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public Integer getFlagSetorTransporte() {
		return flagSetorTransporte;
	}

	public void setFlagSetorTransporte(Integer flagSetorTransporte) {
		this.flagSetorTransporte = flagSetorTransporte;
	}

	public Integer getFlagSetorImobiliario() {
		return flagSetorImobiliario;
	}

	public void setFlagSetorImobiliario(Integer flagSetorImobiliario) {
		this.flagSetorImobiliario = flagSetorImobiliario;
	}

	public Integer getFlagSetorAgricola() {
		return flagSetorAgricola;
	}

	public void setFlagSetorAgricola(Integer flagSetorAgricola) {
		this.flagSetorAgricola = flagSetorAgricola;
	}

	public Integer getFlagSetorProjeto() {
		return flagSetorProjeto;
	}

	public void setFlagSetorProjeto(Integer flagSetorProjeto) {
		this.flagSetorProjeto = flagSetorProjeto;
	}

	public Integer getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(Integer codSituacao) {
		this.codSituacao = codSituacao;
	}

	public String getDescSituacao() {
		return descSituacao;
	}

	public void setDescSituacao(String descSituacao) {
		this.descSituacao = descSituacao;
	}

	@Override
	public int compareTo(CadastramentoVO o) {
		return 0;
	}

}
