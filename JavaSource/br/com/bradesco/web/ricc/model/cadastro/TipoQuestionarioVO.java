package br.com.bradesco.web.ricc.model.cadastro;

import java.io.Serializable;

import br.com.bradesco.web.ricc.converter.BaseEntity;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class TipoQuestionarioVO implements BaseEntity, Serializable, Comparable<TipoQuestionarioVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7623271408909256245L;
	private String nomeBean = "";
	private Long codigo;
	private String descricao = "";
	
	public TipoQuestionarioVO(String nomeBean, Long codigo, String descricao) {
		super();
		this.nomeBean = nomeBean;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public TipoQuestionarioVO() {
		super();
	}

	public String getNomeBean() {
		return nomeBean;
	}

	public void setNomeBean(String nomeBean) {
		this.nomeBean = nomeBean;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((nomeBean == null) ? 0 : nomeBean.hashCode());
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
		TipoQuestionarioVO other = (TipoQuestionarioVO) obj;
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
		if (nomeBean == null) {
			if (other.nomeBean != null)
				return false;
		} else if (!nomeBean.equals(other.nomeBean))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		if(SiteUtil.getInstance().isEmptyOrNull(codigo)){
			return new Long(0);
		}
		return new Long(codigo);
	}

	@Override
	public int compareTo(TipoQuestionarioVO o) {
		if(this.hashCode() == o.hashCode()){
			return 0;			
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

}
