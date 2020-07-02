package br.com.bradesco.web.ricc.model.parametrizacao;

import java.io.Serializable;

import br.com.bradesco.web.ricc.converter.BaseEntity;

public class ListaObrigatoriedadeParamVO implements BaseEntity, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4172377207023882334L;
	private Integer codigo;
	private String descricao;
	
	public ListaObrigatoriedadeParamVO() {
		super();
	}

	public ListaObrigatoriedadeParamVO(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaObrigatoriedadeParamVO other = (ListaObrigatoriedadeParamVO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		return new Long(codigo);
	}

}
