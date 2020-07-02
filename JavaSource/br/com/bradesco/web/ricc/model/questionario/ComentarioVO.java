package br.com.bradesco.web.ricc.model.questionario;

public class ComentarioVO {
	private String codTipo;
	private String codSequencial;
	private String comentario;

	public ComentarioVO() {
		super();
	}

	public ComentarioVO(String codTipo, String codSequencial, String comentario) {
		super();
		this.codTipo = codTipo;
		this.codSequencial = codSequencial;
		this.comentario = comentario;
	}

	public String getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(String codTipo) {
		this.codTipo = codTipo;
	}

	public String getCodSequencial() {
		return codSequencial;
	}

	public void setCodSequencial(String codSequencial) {
		this.codSequencial = codSequencial;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
