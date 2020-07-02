package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

//4. Detalhamento do Patrimônio (caso haja divergência do detalhado e do cadastro)
public class DetalhamentoPatrimonioVO implements
		Comparable<DetalhamentoPatrimonioVO> {

	private String patrimonio;
	private String valorPatrimonio;
	private String sequencialPatrimonio = "0";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public DetalhamentoPatrimonioVO() {

	}

	public DetalhamentoPatrimonioVO(String patrimonio,
			String valorPatrimonio) {
		super();
		this.patrimonio = patrimonio;
		this.valorPatrimonio = valorPatrimonio;
	}

	public String getValorPatrimonioFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorPatrimonio);
	}
	
	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getValorPatrimonio() {
		return valorPatrimonio;
	}
	
	public void setValorPatrimonio(String valorPatrimonio) {
		this.valorPatrimonio = valorPatrimonio;
	}

	public String getSequencialPatrimonio() {
		return sequencialPatrimonio;
	}

	public void setSequencialPatrimonio(String sequencialPatrimonio) {
		this.sequencialPatrimonio = sequencialPatrimonio;
	}

	@Override
	public int compareTo(DetalhamentoPatrimonioVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((patrimonio == null) ? 0 : patrimonio.hashCode());
		result = prime
				* result
				+ ((sequencialPatrimonio == null) ? 0 : sequencialPatrimonio
						.hashCode());
		result = prime * result
				+ ((valorPatrimonio == null) ? 0 : valorPatrimonio.hashCode());
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
		DetalhamentoPatrimonioVO other = (DetalhamentoPatrimonioVO) obj;
		if (patrimonio == null) {
			if (other.patrimonio != null)
				return false;
		} else if (!patrimonio.equals(other.patrimonio))
			return false;
		if (sequencialPatrimonio == null) {
			if (other.sequencialPatrimonio != null)
				return false;
		} else if (!sequencialPatrimonio.equals(other.sequencialPatrimonio))
			return false;
		if (valorPatrimonio == null) {
			if (other.valorPatrimonio != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorPatrimonio).equals(other.valorPatrimonio))
			return false;
		return true;
	}
	
	

}
