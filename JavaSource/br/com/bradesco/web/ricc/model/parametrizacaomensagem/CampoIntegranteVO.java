package br.com.bradesco.web.ricc.model.parametrizacaomensagem;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;

public class CampoIntegranteVO implements Comparable<InstructionCodeVO> {

	private String ordem = "";
	private String obrigatorio = "";
	private String campo = "";
	private String tag = "";
	private String bloco = "";

	public CampoIntegranteVO() {
	}

	public CampoIntegranteVO(String ordem, String obrigatorio, String campo,
			String tag, String bloco) {
		this.ordem = ordem;
		this.obrigatorio = obrigatorio;
		this.campo = campo;
		this.tag = tag;
		this.bloco = bloco;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public String getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	@Override
	public int compareTo(InstructionCodeVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
