package br.com.bradesco.web.ricc.model.manutencao;

import br.com.bradesco.web.ricc.model.manutencao.TimeIndicationVO;

public class TimeIndicationVO implements Comparable<TimeIndicationVO> {

	// Campos tabela
	private String occur = "";
	private String code = "";
	private String time = "";
	private String sign = "";
	private String offset = "";

	@Override
	public int compareTo(TimeIndicationVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getOccur() {
		return occur;
	}

	public void setOccur(String occur) {
		this.occur = occur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

}
